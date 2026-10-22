package androidx.room.jarjarred.org.antlr.v4.gui;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ErrorNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import org.abego.treelayout.Configuration;
import org.abego.treelayout.NodeExtentProvider;
import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class TreePostScriptGenerator {
    protected PostScriptDocument doc;
    protected double gapBetweenLevels;
    protected double gapBetweenNodes;
    protected int nodeHeightPaddingAbove;
    protected int nodeHeightPaddingBelow;
    protected int nodeWidthPadding;
    protected Tree root;
    protected TreeLayout<Tree> treeLayout;
    protected TreeTextProvider treeTextProvider;

    public class VariableExtentProvide implements NodeExtentProvider<Tree> {
        final /* synthetic */ TreePostScriptGenerator this$0;

        public VariableExtentProvide(TreePostScriptGenerator r5) {
            this.this$0 = r5;
        }

        public /* bridge */ /* synthetic */ double getHeight(Object r5) {
            return getHeight((Tree) r5);
        }

        public /* bridge */ /* synthetic */ double getWidth(Object r5) {
            return getWidth((Tree) r5);
        }

        public double getHeight(Tree r5) {
            String r10 = this.this$0.getText(r5);
            double r11 = this.this$0.doc.getLineHeight();
            TreePostScriptGenerator r12 = this.this$0;
            return ((r11 + ((double) r12.nodeHeightPaddingAbove)) + ((double) r12.nodeHeightPaddingBelow)) * ((double) r10.split("\n").length);
        }

        public double getWidth(Tree r5) {
            String r10 = this.this$0.getText(r5);
            return this.this$0.doc.getWidth(r10) + ((double) (this.this$0.nodeWidthPadding * 2));
        }
    }

    public TreePostScriptGenerator(List<String> r5, Tree r10) {
        this(r5, r10, PostScriptDocument.DEFAULT_FONT, 11);
    }

    public void generateEdges(Tree r15) {
        if (getTree().isLeaf(r15) == true) goto L8;
        Rectangle2D.Double r5 = getBoundsOfNode(r15);
        double r10 = r5.getCenterX();
        double r12 = r5.y;
        Iterator<Tree> r16 = getChildren(r15).iterator();
    L6:
        if (r16.hasNext() == false) goto L10;
        Tree r11 = r16.next();
        Rectangle2D.Double r13 = getBoundsOfNode(r11);
        double r14 = r13.getCenterX();
        double r17 = r13.getMaxY();
        this.doc.line(r10, r12, r14, r17);
        generateEdges(r11);
        goto L6
    L10:
        return;
    }

    public void generateNode(Tree r13) {
        String[] r5 = getText(r13).split("\n");
        Rectangle2D.Double r10 = getBoundsOfNode(r13);
        if ((r13 instanceof ErrorNode) == false) goto L5;
        this.doc.highlight(r10.x, r10.y, r10.width, r10.height);
    L5:
        double r11 = r10.x + ((double) this.nodeWidthPadding);
        double r12 = r10.y + ((double) this.nodeHeightPaddingBelow);
        int r14 = 0;
    L7:
        if (r14 >= r5.length) goto L9;
        this.doc.text(r5[r14], r11, r12);
        r12 = r12 + this.doc.getLineHeight();
        r14 = r14 + 1;
        goto L7
    }

    public Rectangle2D.Double getBoundsOfNode(Tree r5) {
        return (Rectangle2D.Double) this.treeLayout.getNodeBounds().get(r5);
    }

    public Iterable<Tree> getChildren(Tree r5) {
        return getTree().getChildren(r5);
    }

    public String getPS() {
        generateEdges((Tree) getTree().getRoot());
        Iterator r5 = this.treeLayout.getNodeBounds().keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        generateNode((Tree) r5.next());
        goto L4
    L6:
        Dimension r10 = this.treeLayout.getBounds().getBounds().getSize();
        this.doc.boundingBox(r10.width, r10.height);
        this.doc.close();
        return this.doc.getPS();
    }

    public String getText(Tree r5) {
        return Utils.escapeWhitespace(this.treeTextProvider.getText(r5), false);
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

    public void setTreeTextProvider(TreeTextProvider r5) {
        this.treeTextProvider = r5;
    }

    public TreePostScriptGenerator(List<String> r10, Tree r11, String r12, int r13) {
        this.gapBetweenLevels = 17.0d;
        this.gapBetweenNodes = 7.0d;
        this.nodeWidthPadding = 1;
        this.nodeHeightPaddingAbove = 0;
        this.nodeHeightPaddingBelow = 5;
        this.root = r11;
        setTreeTextProvider(new TreeViewer.DefaultTreeTextProvider(r10));
        this.doc = new PostScriptDocument(r12, r13);
        this.treeLayout = new TreeLayout(getTreeLayoutAdaptor(r11), new VariableExtentProvide(this), new DefaultConfiguration(this.gapBetweenLevels, this.gapBetweenNodes, Configuration.Location.Bottom), true);
    }
}
