package androidx.room.jarjarred.org.antlr.v4.gui;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ErrorNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.prefs.Preferences;
import javax.imageio.ImageIO;
import javax.print.PrintException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import org.abego.treelayout.NodeExtentProvider;
import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class TreeViewer extends JComponent {
    private static final String DIALOG_DIVIDER_LOC_PREFS_KEY = "dialog_divider_location";
    private static final String DIALOG_HEIGHT_PREFS_KEY = "dialog_height";
    private static final String DIALOG_VIEWER_SCALE_PREFS_KEY = "dialog_viewer_scale";
    private static final String DIALOG_WIDTH_PREFS_KEY = "dialog_width";
    private static final String DIALOG_X_PREFS_KEY = "dialog_x";
    private static final String DIALOG_Y_PREFS_KEY = "dialog_y";
    public static final Color LIGHT_RED = null;
    protected int arcSize;
    protected Color borderColor;
    protected Color boxColor;
    protected Font font;
    protected String fontName;
    protected int fontSize;
    protected int fontStyle;
    protected double gapBetweenLevels;
    protected double gapBetweenNodes;
    protected Color highlightedBoxColor;
    protected List<Tree> highlightedNodes;
    protected int nodeHeightPadding;
    protected int nodeWidthPadding;
    protected double scale;
    protected Color textColor;
    protected TreeLayout<Tree> treeLayout;
    protected TreeTextProvider treeTextProvider;
    private boolean useCurvedEdges;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.gui.TreeViewer$8, reason: invalid class name */
    public class AnonymousClass8 implements Callable<JFrame> {
        JFrame result;
        final /* synthetic */ TreeViewer this$0;
        final /* synthetic */ TreeViewer val$viewer;

        public AnonymousClass8(TreeViewer r5, TreeViewer r10) {
            this.this$0 = r5;
            this.val$viewer = r10;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ JFrame call() throws Exception {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public JFrame call2() throws Exception {
            SwingUtilities.invokeAndWait(new AnonymousClass1(this));
            return this.result;
        }
    }

    public static class DefaultTreeTextProvider implements TreeTextProvider {
        private final List<String> ruleNames;

        public DefaultTreeTextProvider(List<String> r5) {
            this.ruleNames = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.gui.TreeTextProvider
        public String getText(Tree r5) {
            return String.valueOf(androidx.room.jarjarred.org.antlr.v4.runtime.tree.Trees.getNodeText(r5, this.ruleNames));
        }
    }

    public static class EmptyIcon implements Icon {
        private EmptyIcon() {
        }

        public int getIconHeight() {
            return 0;
        }

        public int getIconWidth() {
            return 0;
        }

        public void paintIcon(Component r5, Graphics r10, int r11, int r12) {
        }

        public /* synthetic */ EmptyIcon(AnonymousClass1 r5) {
            this();
        }
    }

    public static class TreeNodeWrapper extends DefaultMutableTreeNode {
        final TreeViewer viewer;

        public TreeNodeWrapper(Tree r5, TreeViewer r10) {
            super(r5);
            this.viewer = r10;
        }

        public String toString() {
            return this.viewer.getText((Tree) getUserObject());
        }
    }

    public static class VariableExtentProvide implements NodeExtentProvider<Tree> {
        TreeViewer viewer;

        public VariableExtentProvide(TreeViewer r5) {
            this.viewer = r5;
        }

        public /* bridge */ /* synthetic */ double getHeight(Object r5) {
            return getHeight((Tree) r5);
        }

        public /* bridge */ /* synthetic */ double getWidth(Object r5) {
            return getWidth((Tree) r5);
        }

        public double getHeight(Tree r5) {
            TreeViewer r10 = this.viewer;
            int r11 = r10.getFontMetrics(r10.font).getHeight();
            TreeViewer r12 = this.viewer;
            return ((r12.nodeHeightPadding * 2) + r11) * r12.getText(r5).split("\n").length;
        }

        public double getWidth(Tree r5) {
            TreeViewer r10 = this.viewer;
            return (this.viewer.nodeWidthPadding * 2) + r10.getFontMetrics(r10.font).stringWidth(this.viewer.getText(r5));
        }
    }

    static {
        LIGHT_RED = new Color(244, 213, 211);
    }

    public TreeViewer(List<String> r10, Tree r11) {
        this.fontName = "Helvetica";
        this.fontStyle = 0;
        this.fontSize = 11;
        this.font = new Font(this.fontName, this.fontStyle, this.fontSize);
        this.gapBetweenLevels = 17.0d;
        this.gapBetweenNodes = 7.0d;
        this.nodeWidthPadding = 2;
        this.nodeHeightPadding = 0;
        this.arcSize = 0;
        this.scale = 1.0d;
        this.boxColor = null;
        this.highlightedBoxColor = Color.lightGray;
        this.borderColor = null;
        this.textColor = Color.black;
        this.useCurvedEdges = false;
        setRuleNames(r10);
        if (r11 == null) goto L5;
        setTree(r11);
    L5:
        setFont(this.font);
    }

    public static /* synthetic */ void access$000(TreeViewer r5, JFrame r10) {
        generatePNGFile(r5, r10);
    }

    public static /* synthetic */ void access$100(TreeViewer r5, JFrame r10) {
        generateSVGFile(r5, r10);
    }

    private static void fillTree(TreeNodeWrapper r5, Tree r10, TreeViewer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = 0;
    L6:
        if (r12 >= r10.getChildCount()) goto L8;
        Tree r13 = r10.getChild(r12);
        TreeNodeWrapper r14 = new TreeNodeWrapper(r13, r11);
        r5.add(r14);
        fillTree(r14, r13, r11);
        r12 = r12 + 1;
        goto L6
    }

    private static File generateNonExistingFile(String r5) {
        File r10 = new File(".", j0.C("antlr4_parse_tree", r5));
        int r11 = 1;
    L4:
        if (r10.exists() == false) goto L6;
        r10 = new File(".", j0.h(r11, "antlr4_parse_tree_", r5));
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    private static void generatePNGFile(TreeViewer r5, JFrame r10) {
        BufferedImage r11 = new BufferedImage(r5.getSize().width, r5.getSize().height, 2);
        Graphics2D r12 = r11.createGraphics();
        r5.paint(r12);
        r12.dispose();
        JFileChooser r13 = getFileChooser(".png", "PNG files");     // Catch: Exception -> L11
        if (r13.showSaveDialog(r10) != 0) goto L14;
        File r14 = r13.getSelectedFile();     // Catch: Exception -> L11
        ImageIO.write(r11, "png", r14);     // Catch: Exception -> L11
        Desktop.getDesktop().open(r14.getParentFile());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        JOptionPane.showMessageDialog(r10, "Saved PNG to: " + r14.getAbsolutePath());     // Catch: Exception -> L11
        e.printStackTrace();     // Catch: Exception -> L11
    L14:
        return;
    L11:
        e = move-exception;
        JOptionPane.showMessageDialog(r10, a.o(e, new StringBuilder("Could not export to PNG: ")), "Error", 0);
        e.printStackTrace();
    }

    private static void generateSVGFile(TreeViewer r10, JFrame r11) {
        JFileChooser r5 = getFileChooser(".svg", "SVG files");     // Catch: Exception -> L11
        if (r5.showSaveDialog(r11) != 0) goto L18;
        File r12 = r5.getSelectedFile();     // Catch: Exception -> L11
        BufferedWriter r13 = new BufferedWriter(new FileWriter(r12));     // Catch: Exception -> L11
        r13.write("<svg width=\"" + (r10.getSize().getWidth() * 1.1d) + "\" height=\"" + (r10.getSize().getHeight() * 1.1d) + "\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");     // Catch: Exception -> L11
        r10.paintSVG(r13);     // Catch: Exception -> L11
        r13.write("</svg>");     // Catch: Exception -> L11
        r13.flush();     // Catch: Exception -> L11
        r13.close();     // Catch: Exception -> L11
        Desktop.getDesktop().open(r12.getParentFile());     // Catch: Exception -> L8
    L19:
        return;
    L8:
        e = move-exception;
        JOptionPane.showMessageDialog(r11, "Saved SVG to: " + r12.getAbsolutePath());     // Catch: Exception -> L11
        e.printStackTrace();     // Catch: Exception -> L11
        return;
    L18:
        return;
    L11:
        e = move-exception;
        JOptionPane.showMessageDialog(r11, a.o(e, new StringBuilder("Could not export to SVG: ")), "Error", 0);
        e.printStackTrace();
    }

    private static JFileChooser getFileChooser(final String r5, final String r10) {
        File r11 = generateNonExistingFile(r5);
        JFileChooserConfirmOverwrite r12 = new JFileChooserConfirmOverwrite();
        r12.setCurrentDirectory(r11.getParentFile());
        r12.setSelectedFile(r11);
        FileFilter r13 = new AnonymousClass7(r5, r10);
        r12.addChoosableFileFilter(r13);
        r12.setFileFilter(r13);
        return r12;
    }

    private Dimension getScaledTreeSize() {
        Dimension r5 = this.treeLayout.getBounds().getBounds().getSize();
        return new Dimension((int) (((double) r5.width) * this.scale), (int) (((double) r5.height) * this.scale));
    }

    private static String line(String r5, String r10, String r11, String r12, String r13) {
        StringBuilder r14 = androidx.constraintlayout.motion.widget.a.y("<line x1=\"", r5, "\" y1=\"", r10, "\" x2=\"");
        androidx.constraintlayout.motion.widget.a.C(r14, r11, "\" y2=\"", r12, "\" style=\"");
        return j0.q(r14, r13, "\" />\n");
    }

    private void paintSVG(Writer r5) throws IOException {
        generateEdges(r5, (Tree) getTree().getRoot());
        Iterator r10 = this.treeLayout.getNodeBounds().keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        generateBox(r5, (Tree) r10.next());
        goto L4
    }

    private static String rect(String r5, String r10, String r11, String r12, String r13, String r14) {
        StringBuilder r15 = androidx.constraintlayout.motion.widget.a.y("<rect x=\"", r5, "\" y=\"", r10, "\" width=\"");
        androidx.constraintlayout.motion.widget.a.C(r15, r11, "\" height=\"", r12, "\" style=\"");
        return androidx.constraintlayout.motion.widget.a.u(r15, r13, "\" ", r14, "/>\n");
    }

    public static JFrame showInDialog(final TreeViewer r13) {
        final JFrame r5 = new JFrame();
        r5.setTitle("Parse Tree Inspector");
        final Preferences r10 = Preferences.userNodeForPackage(TreeViewer.class);
        JPanel r11 = new JPanel(new BorderLayout(5, 5));
        JPanel r12 = new JPanel(new BorderLayout(0, 0));
        r12.setBackground(Color.white);
        r12.add(new JScrollPane(r13), "Center");
        JPanel r14 = new JPanel(new FlowLayout());
        JPanel r15 = new JPanel(new BorderLayout(0, 0));
        r12.add(r15, "South");
        JButton r16 = new JButton("OK");
        r16.addActionListener(new AnonymousClass1(r5));
        r14.add(r16);
        JButton r17 = new JButton("Export as PNG");
        r17.addActionListener(new AnonymousClass2(r13, r5));
        r14.add(r17);
        JButton r18 = new JButton("Export as SVG");
        r18.addActionListener(new AnonymousClass3(r13, r5));
        r14.add(r18);
        r15.add(r14, "South");
        double r19 = r10.getDouble(DIALOG_VIEWER_SCALE_PREFS_KEY, r13.getScale());
        r13.setScale(r19);
        final JSlider r20 = new JSlider(0, -999, 1000, (int) ((r19 - 1.0d) * 1000.0d));
        r20.addChangeListener(new AnonymousClass4(r20, r13));
        r15.add(r20, "Center");
        JPanel r21 = new JPanel(new BorderLayout(5, 5));
        EmptyIcon r22 = new EmptyIcon(null);
        UIManager.put("Tree.closedIcon", r22);
        UIManager.put("Tree.openIcon", r22);
        UIManager.put("Tree.leafIcon", r22);
        Tree r23 = (Tree) r13.getTree().getRoot();
        TreeNodeWrapper r24 = new TreeNodeWrapper(r23, r13);
        fillTree(r24, r23, r13);
        JTree r25 = new JTree(r24);
        r25.getSelectionModel().setSelectionMode(1);
        r25.addTreeSelectionListener(new AnonymousClass5(r13));
        r21.add(new JScrollPane(r25));
        final JSplitPane r26 = new JSplitPane(1, r21, r12);
        r11.add(r26, "Center");
        r5.setContentPane(r11);
        r5.addWindowListener(new AnonymousClass6(r10, r5, r26, r13));
        r5.setDefaultCloseOperation(0);
        r5.setPreferredSize(new Dimension(r10.getInt(DIALOG_WIDTH_PREFS_KEY, 600), r10.getInt(DIALOG_HEIGHT_PREFS_KEY, 500)));
        r5.pack();
        r26.setDividerLocation(r10.getInt(DIALOG_DIVIDER_LOC_PREFS_KEY, 200));
        if (r10.getDouble(DIALOG_X_PREFS_KEY, -1.0d) == (-1.0d)) goto L5;
        r5.setLocation((int) r10.getDouble(DIALOG_X_PREFS_KEY, 100.0d), (int) r10.getDouble(DIALOG_Y_PREFS_KEY, 100.0d));
    L6:
        r5.setVisible(true);
        return r5;
    L5:
        r5.setLocationRelativeTo(null);
        goto L6
    }

    private void updatePreferredSize() {
        setPreferredSize(getScaledTreeSize());
        invalidate();
        if (getParent() == null) goto L5;
        getParent().validate();
    L5:
        repaint();
    }

    public void addHighlightedNodes(Collection<Tree> r5) {
        ArrayList r10 = new ArrayList();
        this.highlightedNodes = r10;
        r10.addAll(r5);
    }

    public void generateBox(Writer r12, Tree r13) throws IOException {
        Rectangle2D.Double r5 = getBoundsOfNode(r13);
        r12.write(rect("" + r5.x, "" + r5.y, "" + r5.width, "" + r5.height, "fill:orange; stroke:rgb(0,0,0);", "rx=\"1\""));
        String r11 = getText(r13).replace("<", "&lt;").replace(">", "&gt;");
        int r14 = ((int) r5.x) + 2;
        int r10 = ((int) r5.y) + 9;
        r12.write(text(j0.g(r14, ""), j0.g(r10, ""), String.format("font-family:sans-serif;font-size:%dpx;", new Object[]{10}), r11));
    }

    public void generateEdges(Writer r14, Tree r15) throws IOException {
        if (getTree().isLeaf(r15) == true) goto L8;
        Rectangle2D.Double r5 = getBoundsOfNode(r15);
        double r10 = r5.getCenterX();
        double r11 = r5.getCenterY();
        Iterator r16 = getTree().getChildren(r15).iterator();
    L6:
        if (r16.hasNext() == false) goto L10;
        Tree r12 = (Tree) r16.next();
        Rectangle2D.Double r13 = getBoundsOfNode(r12);
        double r17 = r13.getCenterX();
        double r18 = r13.getMinY();
        r14.write(line("" + r10, "" + r11, "" + r17, "" + r18, "stroke:black; stroke-width:1px;"));
        generateEdges(r14, r12);
        goto L6
    L10:
        return;
    }

    public int getArcSize() {
        return this.arcSize;
    }

    public Color getBorderColor() {
        return this.borderColor;
    }

    public Rectangle2D.Double getBoundsOfNode(Tree r5) {
        return (Rectangle2D.Double) this.treeLayout.getNodeBounds().get(r5);
    }

    public Color getBoxColor() {
        return this.boxColor;
    }

    public Graphics getComponentGraphics(Graphics r5) {
        Graphics2D r10 = (Graphics2D) r5;
        double r11 = this.scale;
        r10.scale(r11, r11);
        return super.getComponentGraphics(r10);
    }

    public Font getFont() {
        return this.font;
    }

    public Color getHighlightedBoxColor() {
        return this.highlightedBoxColor;
    }

    public int getHighlightedNodeIndex(Tree r5) {
        if (this.highlightedNodes != null) goto L5;
        return -1;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.highlightedNodes.size()) goto L12;
        if (this.highlightedNodes.get(r10) == r5) goto L10;
        r10 = r10 + 1;
        goto L7
    L10:
        return r10;
    L12:
        return -1;
    }

    public double getScale() {
        return this.scale;
    }

    public String getText(Tree r5) {
        return Utils.escapeWhitespace(this.treeTextProvider.getText(r5), true);
    }

    public Color getTextColor() {
        return this.textColor;
    }

    public TreeForTreeLayout<Tree> getTree() {
        return this.treeLayout.getTree();
    }

    public TreeForTreeLayout<Tree> getTreeLayoutAdaptor(Tree r5) {
        return new TreeLayoutAdaptor(r5);
    }

    public TreeTextProvider getTreeTextProvider() {
        return this.treeTextProvider;
    }

    public boolean getUseCurvedEdges() {
        return this.useCurvedEdges;
    }

    public boolean isHighlighted(Tree r5) {
        if (getHighlightedNodeIndex(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Future<JFrame> open() {
        setScale(1.5d);
        AnonymousClass8 r5 = new AnonymousClass8(this, this);
        ExecutorService r10 = Executors.newSingleThreadExecutor();
        Future<JFrame> r11 = r10.submit(r5);     // Catch: Throwable -> L6
        r10.shutdown();
        return r11;
    L6:
        th = move-exception;
        r10.shutdown();
        throw th;
    }

    public void paint(Graphics r5) {
        super.paint(r5);
        if (this.treeLayout != null) goto L5;
        return;
    L5:
        Graphics2D r10 = (Graphics2D) r5;
        r10.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        r10.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        paintEdges(r5, (Tree) getTree().getRoot());
        Iterator r11 = this.treeLayout.getNodeBounds().keySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        paintBox(r5, (Tree) r11.next());
        goto L7
    }

    public void paintBox(Graphics r14, Tree r15) {
        Rectangle2D.Double r5 = getBoundsOfNode(r15);
        int r10 = 0;
        if ((r15 instanceof ParserRuleContext) == false) goto L11;
        ParserRuleContext r11 = (ParserRuleContext) r15;
        if (r11.exception == null) goto L11;
        Token r12 = r11.stop;
        if (r12 == null) goto L11;
        if (r12.getTokenIndex() >= r11.start.getTokenIndex()) goto L11;
        boolean r13 = true;
    L13:
        if (isHighlighted(r15) == true) goto L20;
        if (this.boxColor != null) goto L20;
        if ((r15 instanceof ErrorNode) == true) goto L20;
        if (r13 == true) goto L20;
    L29:
        Color r16 = this.borderColor;
        if (r16 == null) goto L32;
        r14.setColor(r16);
        int r17 = (int) r5.x;
        int r18 = (int) r5.y;
        int r19 = ((int) r5.width) - 1;
        int r110 = ((int) r5.height) - 1;
        int r111 = this.arcSize;
        r14.drawRoundRect(r17, r18, r19, r110, r111, r111);
    L32:
        r14.setColor(this.textColor);
        String[] r112 = getText(r15).split("\n");
        FontMetrics r20 = getFontMetrics(this.font);
        int r21 = ((this.arcSize / 2) + ((int) r5.x)) + this.nodeWidthPadding;
        int r22 = (((((int) r5.y) + r20.getAscent()) + r20.getLeading()) + 1) + this.nodeHeightPadding;
    L34:
        if (r10 >= r112.length) goto L36;
        text(r14, r112[r10], r21, r22);
        r22 = r22 + r20.getHeight();
        r10 = r10 + 1;
        goto L34
    L36:
        return;
    L20:
        if (isHighlighted(r15) == false) goto L23;
        r14.setColor(this.highlightedBoxColor);
    L28:
        int r23 = (int) r5.x;
        int r24 = (int) r5.y;
        int r25 = ((int) r5.width) - 1;
        int r113 = ((int) r5.height) - 1;
        int r114 = this.arcSize;
        r14.fillRoundRect(r23, r24, r25, r113, r114, r114);
        goto L29
    L23:
        if ((r15 instanceof ErrorNode) == true) goto L27;
        if (r13 == true) goto L27;
        r14.setColor(this.boxColor);
    L27:
        r14.setColor(LIGHT_RED);
    L11:
        r13 = false;
        goto L13
    }

    public void paintEdges(Graphics r26, Tree r27) {
        TreeViewer r5 = this;
        if (getTree().isLeaf(r27) == true) goto L12;
        Graphics2D r10 = (Graphics2D) r26;
        r10.setStroke(new BasicStroke(1.0f, 1, 1));
        Rectangle2D.Double r11 = r5.getBoundsOfNode(r27);
        double r14 = r11.getCenterX();
        double r12 = r11.getMaxY();
        Iterator r13 = getTree().getChildren(r27).iterator();
    L6:
        if (r13.hasNext() == false) goto L16;
        Tree r15 = (Tree) r13.next();
        Rectangle2D.Double r16 = r5.getBoundsOfNode(r15);
        double r17 = r16.getCenterX();
        double r18 = r16.getMinY();
        if (getUseCurvedEdges() == false) goto L10;
        CubicCurve2D.Double r19 = new CubicCurve2D.Double();
        double r110 = (r12 + r18) / 2.0d;
        double r22 = r12;
        r19.setCurve(r14, r12, r14, r110, r17, r22, r17, r18);
        r10.draw(r19);
        double r111 = r14;
        double r20 = r22;
        Graphics r21 = r26;
    L11:
        paintEdges(r21, r15);
        r13 = r13;
        r14 = r111;
        r12 = r20;
        r5 = this;
        goto L6
    L10:
        double r23 = r14;
        r20 = r12;
        r111 = r23;
        r21 = r26;
        r21.drawLine((int) r23, (int) r20, (int) r17, (int) r18);
        goto L11
    L16:
        return;
    }

    public void removeHighlightedNodes(Collection<Tree> r5) {
        if (this.highlightedNodes == null) goto L10;
        Iterator<Tree> r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        int r11 = getHighlightedNodeIndex(r10.next());
        if (r11 < 0) goto L6;
        this.highlightedNodes.remove(r11);
        goto L6
    L16:
        return;
    }

    public void save(String r5) throws IOException, PrintException {
        JFrame r10 = new JFrame();
        JComponent r11 = r10.getContentPane();
        r11.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        r11.add(this);
        r11.setBackground(Color.white);
        r10.pack();
        r10.setLocationRelativeTo(null);
        r10.dispose();
        GraphicsSupport.saveImage(this, r5);
    }

    public void setArcSize(int r5) {
        this.arcSize = r5;
    }

    public void setBorderColor(Color r5) {
        this.borderColor = r5;
    }

    public void setBoxColor(Color r5) {
        this.boxColor = r5;
    }

    public void setFont(Font r5) {
        this.font = r5;
    }

    public void setFontName(String r5) {
        this.fontName = r5;
        this.font = new Font(this.fontName, this.fontStyle, this.fontSize);
    }

    public void setFontSize(int r5) {
        this.fontSize = r5;
        this.font = new Font(this.fontName, this.fontStyle, this.fontSize);
    }

    public void setHighlightedBoxColor(Color r5) {
        this.highlightedBoxColor = r5;
    }

    public void setRuleNames(List<String> r5) {
        setTreeTextProvider(new DefaultTreeTextProvider(r5));
    }

    public void setScale(double r5) {
        if (r5 > 0.0d) goto L5;
        r5 = 1.0d;
    L5:
        this.scale = r5;
        updatePreferredSize();
    }

    public void setTextColor(Color r5) {
        this.textColor = r5;
    }

    public void setTree(Tree r10) {
        if (r10 == null) goto L4;
        this.treeLayout = new TreeLayout(getTreeLayoutAdaptor(r10), new VariableExtentProvide(this), new DefaultConfiguration(this.gapBetweenLevels, this.gapBetweenNodes), true);
        updatePreferredSize();
        return;
    L4:
        this.treeLayout = null;
        repaint();
    }

    public void setTreeTextProvider(TreeTextProvider r5) {
        this.treeTextProvider = r5;
    }

    public void setUseCurvedEdges(boolean r5) {
        this.useCurvedEdges = r5;
    }

    public void text(Graphics r5, String r10, int r11, int r12) {
        r5.drawString(Utils.escapeWhitespace(r10, true), r11, r12);
    }

    private static String text(String r5, String r10, String r11, String r12) {
        return androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("<text x=\"", r5, "\" y=\"", r10, "\" style=\""), r11, "\">\n", r12, "\n</text>\n");
    }
}
