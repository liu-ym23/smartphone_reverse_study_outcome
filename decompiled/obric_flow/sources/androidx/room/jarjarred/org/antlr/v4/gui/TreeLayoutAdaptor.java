package androidx.room.jarjarred.org.antlr.v4.gui;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import java.util.Iterator;
import org.abego.treelayout.TreeForTreeLayout;

/* JADX INFO: loaded from: classes.dex */
public class TreeLayoutAdaptor implements TreeForTreeLayout<Tree> {
    private Tree root;

    public static class AntlrTreeChildrenIterable implements Iterable<Tree> {
        private final Tree tree;

        public AntlrTreeChildrenIterable(Tree r5) {
            this.tree = r5;
        }

        public static /* synthetic */ Tree access$000(AntlrTreeChildrenIterable r5) {
            return r5.tree;
        }

        @Override // java.lang.Iterable
        public Iterator<Tree> iterator() {
            return new AnonymousClass1(this);
        }
    }

    public static class AntlrTreeChildrenReverseIterable implements Iterable<Tree> {
        private final Tree tree;

        public AntlrTreeChildrenReverseIterable(Tree r5) {
            this.tree = r5;
        }

        public static /* synthetic */ Tree access$100(AntlrTreeChildrenReverseIterable r5) {
            return r5.tree;
        }

        @Override // java.lang.Iterable
        public Iterator<Tree> iterator() {
            return new AnonymousClass1(this);
        }
    }

    public TreeLayoutAdaptor(Tree r5) {
        this.root = r5;
    }

    public /* bridge */ /* synthetic */ Iterable getChildren(Object r5) {
        return getChildren((Tree) r5);
    }

    public /* bridge */ /* synthetic */ Iterable getChildrenReverse(Object r5) {
        return getChildrenReverse((Tree) r5);
    }

    public /* bridge */ /* synthetic */ Object getFirstChild(Object r5) {
        return getFirstChild((Tree) r5);
    }

    public /* bridge */ /* synthetic */ Object getLastChild(Object r5) {
        return getLastChild((Tree) r5);
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m79getRoot() {
        return getRoot();
    }

    public /* bridge */ /* synthetic */ boolean isChildOfParent(Object r5, Object r10) {
        return isChildOfParent((Tree) r5, (Tree) r10);
    }

    public /* bridge */ /* synthetic */ boolean isLeaf(Object r5) {
        return isLeaf((Tree) r5);
    }

    public Iterable<Tree> getChildren(Tree r5) {
        return new AntlrTreeChildrenIterable(r5);
    }

    public Iterable<Tree> getChildrenReverse(Tree r5) {
        return new AntlrTreeChildrenReverseIterable(r5);
    }

    public Tree getFirstChild(Tree r5) {
        return r5.getChild(0);
    }

    public Tree getLastChild(Tree r5) {
        return r5.getChild(r5.getChildCount() - 1);
    }

    public Tree getRoot() {
        return this.root;
    }

    public boolean isChildOfParent(Tree r5, Tree r10) {
        if (r5.getParent() != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLeaf(Tree r5) {
        if (r5.getChildCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
