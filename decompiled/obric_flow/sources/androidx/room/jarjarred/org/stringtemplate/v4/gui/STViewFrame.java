package androidx.room.jarjarred.org.stringtemplate.v4.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JTree;

/* JADX INFO: loaded from: classes.dex */
public class STViewFrame extends JFrame {
    public JTree ast;
    protected JScrollPane attributeScrollPane;
    protected JTree attributes;
    protected JTextPane bytecode;
    protected JList errorList;
    public JScrollPane errorScrollPane;
    public JTextPane output;
    public JSplitPane outputTemplateSplitPane;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    protected JScrollPane scrollPane15;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane3;
    protected JScrollPane scrollPane7;
    public JTextPane template;
    public JTabbedPane templateBytecodeTraceTabPanel;
    private JToolBar toolBar1;
    public JTextPane trace;
    protected JTree tree;
    public JSplitPane treeAttributesSplitPane;
    public JSplitPane treeContentSplitPane;
    public JScrollPane treeScrollPane;

    public STViewFrame() {
        initComponents();
    }

    private void initComponents() {
        this.toolBar1 = new JToolBar();
        this.treeContentSplitPane = new JSplitPane();
        this.treeAttributesSplitPane = new JSplitPane();
        this.treeScrollPane = new JScrollPane();
        this.tree = new JTree();
        this.attributeScrollPane = new JScrollPane();
        this.attributes = new JTree();
        this.outputTemplateSplitPane = new JSplitPane();
        this.scrollPane7 = new JScrollPane();
        this.output = new JTextPane();
        this.templateBytecodeTraceTabPanel = new JTabbedPane();
        this.panel1 = new JPanel();
        this.scrollPane3 = new JScrollPane();
        this.template = new JTextPane();
        this.scrollPane2 = new JScrollPane();
        this.ast = new JTree();
        this.scrollPane15 = new JScrollPane();
        this.bytecode = new JTextPane();
        this.scrollPane1 = new JScrollPane();
        this.trace = new JTextPane();
        this.errorScrollPane = new JScrollPane();
        this.errorList = new JList();
        Container r5 = getContentPane();
        r5.setLayout(new GridBagLayout());
        int[] r10 = {0, 0};
        r5.getLayout().columnWidths = r10;
        int[] r11 = {0, 0, 0, 0};
        r5.getLayout().rowHeights = r11;
        double[] r12 = {1.0d, 1.0E-4d};
        r5.getLayout().columnWeights = r12;
        double[] r13 = {0.0d, 1.0d, 0.0d, 1.0E-4d};
        r5.getLayout().rowWeights = r13;
        r5.add(this.toolBar1, new GridBagConstraints(0, 0, 1, 1, 0.0d, 0.0d, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
        this.treeContentSplitPane.setResizeWeight(0.25d);
        this.treeAttributesSplitPane.setOrientation(0);
        this.treeAttributesSplitPane.setResizeWeight(0.7d);
        this.treeScrollPane.setViewportView(this.tree);
        this.treeAttributesSplitPane.setTopComponent(this.treeScrollPane);
        this.attributeScrollPane.setViewportView(this.attributes);
        this.treeAttributesSplitPane.setBottomComponent(this.attributeScrollPane);
        this.treeContentSplitPane.setLeftComponent(this.treeAttributesSplitPane);
        this.outputTemplateSplitPane.setOrientation(0);
        this.outputTemplateSplitPane.setResizeWeight(0.7d);
        this.scrollPane7.setViewportView(this.output);
        this.outputTemplateSplitPane.setTopComponent(this.scrollPane7);
        this.panel1.setLayout(new BoxLayout(this.panel1, 0));
        this.scrollPane3.setViewportView(this.template);
        this.panel1.add(this.scrollPane3);
        this.scrollPane2.setViewportView(this.ast);
        this.panel1.add(this.scrollPane2);
        this.templateBytecodeTraceTabPanel.addTab("template", this.panel1);
        this.scrollPane15.setViewportView(this.bytecode);
        this.templateBytecodeTraceTabPanel.addTab("bytecode", this.scrollPane15);
        this.scrollPane1.setViewportView(this.trace);
        this.templateBytecodeTraceTabPanel.addTab("trace", this.scrollPane1);
        this.outputTemplateSplitPane.setBottomComponent(this.templateBytecodeTraceTabPanel);
        this.treeContentSplitPane.setRightComponent(this.outputTemplateSplitPane);
        r5.add(this.treeContentSplitPane, new GridBagConstraints(0, 1, 1, 1, 0.0d, 0.0d, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
        this.errorScrollPane.setViewportView(this.errorList);
        r5.add(this.errorScrollPane, new GridBagConstraints(0, 2, 1, 1, 0.0d, 0.0d, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
    }
}
