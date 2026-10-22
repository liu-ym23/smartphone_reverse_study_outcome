package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public interface Tree {
    Tree getChild(int r5);

    int getChildCount();

    Tree getParent();

    Object getPayload();

    String toStringTree();
}
