import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Calculator extends JFrame implements ActionListener {
	
	private JPanel grid1,grid2;
	private JTextField textresult;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bsub,badd,bdec,beq,bdel,bclr;
	private double num1,num2;
	private String str;
	private boolean end,add,sub,mul,div;
	

	public Calculator() { // constructor
		// Create contentpane con and set BorderLayout
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		// Create panel grid2 and set GridLayout
		grid2 = new JPanel(); 
		grid2.setLayout(new GridLayout(1,1));
		
		// Create JTextField
		textresult = new JTextField("0");
		textresult.setEditable(false);
		textresult.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		// Add textresult to panel grid2
		grid2.add(textresult);
		// Add panel grid2 to ContentPane
		con.add(grid2,BorderLayout.NORTH);
		
		// Create panel grid1 and set GridLayout
		grid1 = new JPanel();
		grid1.setLayout(new GridLayout(5,4,4,4));
		
		// Create JButtons
		b1 = new JButton("1");
	        b2 = new JButton("2");
	        b3 = new JButton("3");
	        b4 = new JButton("4");
	        b5 = new JButton("5");
	        b6 = new JButton("6");
	        b7 = new JButton("7");
	        b8 = new JButton("8");
	        b9 = new JButton("9");
	        b0 = new JButton("0");
	        bdiv = new JButton("/");
	        bmul = new JButton("*");
	        bsub = new JButton("-");
	        badd = new JButton("+");
	        bdec = new JButton(".");
	        beq = new JButton("=");
		bdel=new JButton("Del");
        	bclr=new JButton("C");
		
		// When the action event occurs, that object's actionPerformed method is invoked
		b1.addActionListener(this);
	        b2.addActionListener(this);
	        b3.addActionListener(this);
	        b4.addActionListener(this);
	        b5.addActionListener(this);
	        b6.addActionListener(this);
	        b7.addActionListener(this);
	        b8.addActionListener(this);
	        b9.addActionListener(this);
	        b0.addActionListener(this);
	        badd.addActionListener(this);
	        bdiv.addActionListener(this);
	        bmul.addActionListener(this);
	        bsub.addActionListener(this);
	        bdec.addActionListener(this);
	        beq.addActionListener(this);
		bdel.addActionListener(this);
	 	bclr.addActionListener(this);
		
		// Add buttons to the panel grid1
		grid1.add(b7);
		grid1.add(b8);
		grid1.add(b9);
		grid1.add(bdiv);
		
		grid1.add(b4);
		grid1.add(b5);
		grid1.add(b6);
		grid1.add(bmul);
		
		grid1.add(b1);
		grid1.add(b2);
		grid1.add(b3);
		grid1.add(bsub);
		
		grid1.add(b0);
		grid1.add(bdec);
		grid1.add(beq);
		grid1.add(badd);

		grid1.add(bdel);
		grid1.add(bclr);
		
		// Add panel grid1 to ContentPane
		con.add(grid1,BorderLayout.CENTER);
	
	}
		
	public void num(int i) { //calculate
		String s = null;
		s = String.valueOf(i);
		
		if(end) {
			textresult.setText("0");
			end = false;
		}
		if((textresult.getText()).equals("0")) {
			textresult.setText(s);
		}
		else {
			str = textresult.getText() + s;
			textresult.setText(str);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //get the button value 
		// event number
		if(e.getSource()==b1)
		num(1);
		else if(e.getSource()==b2)
		num(2);
		else if(e.getSource()==b3)
		num(3);
		else if(e.getSource()==b4)
		num(4);
		else if(e.getSource()==b5)
		num(5);
		else if(e.getSource()==b6)
		num(6);
		else if(e.getSource()==b7)
		num(7);
		else if(e.getSource()==b8)
		num(8);
		else if(e.getSource()==b9)
		num(9);
		else if(e.getSource()==b0)
		num(0);

		// event operator
		else if(e.getSource() == badd)
			sign(1);
		else if(e.getSource() == bsub)
			sign(2);
		else if(e.getSource() == bmul)
			sign(3);
		else if(e.getSource() == bdiv)
			sign(4);
		
		// event operator "="
		else if(e.getSource() == bdec) {
			str = textresult.getText();
			if(str.indexOf(".") <= 1) {
				str += ".";
				textresult.setText(str);
			}
		}
		else if(e.getSource() == beq) {
			num2 = Double.parseDouble(textresult.getText());
			
			if(add){
				num1 = num1 + num2;
			}
			else if(sub) {
				num1 = num1 - num2;
			}			
			else if(mul) {
				num1 = num1 * num2;
			}
			else if(div) {
				num1 = num1 / num2;
			}
			textresult.setText(String.valueOf(num1));
			end = true;
		}
		
		if(e.getSource()==bclr)
            textresult.setText("0");
		
		if(e.getSource()==bdel)
        {
            String s = textresult.getText();
            textresult.setText("");
            for(int i=0; i<s.length()-1; i++)
            textresult.setText(textresult.getText()+s.charAt(i));
        }    
	}
	
	public void sign(int s) {
		if(s == 1) {
			add=true;
			sub=false;
			mul=false;
			div=false;
		}

		else if(s == 2){
			add=false;
			sub=true;
			mul=false;
			div=false;
		}

		else if(s == 3){
			add=false;
			sub=false;
			mul=true;
			div=false;
		}

		else if(s == 4){
			add=false;
			sub=false;
			mul=false;
			div=true;
		}

		num1 = Double.parseDouble(textresult.getText());

		end = true;

		}
	
	
	/** Main method */
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setTitle("Calculator");
		cal.setSize(300,400);
		cal.setLocationRelativeTo(null); // Center the frame
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cal.setVisible(true);
	}
}
