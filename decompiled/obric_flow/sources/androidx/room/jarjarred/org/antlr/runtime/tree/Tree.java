package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface Tree {
    public static final Tree INVALID_NODE = null;

    static {
        INVALID_NODE = new CommonTree(Token.INVALID_TOKEN);
    }

    void addChild(Tree r5);

    Object deleteChild(int r5);

    Tree dupNode();

    void freshenParentAndChildIndexes();

    Tree getAncestor(int r5);

    List<?> getAncestors();

    int getCharPositionInLine();

    Tree getChild(int r5);

    int getChildCount();

    int getChildIndex();

    int getLine();

    Tree getParent();

    String getText();

    int getTokenStartIndex();

    int getTokenStopIndex();

    int getType();

    boolean hasAncestor(int r5);

    boolean isNil();

    void replaceChildren(int r5, int r10, Object r11);

    void setChild(int r5, Tree r10);

    void setChildIndex(int r5);

    void setParent(Tree r5);

    void setTokenStartIndex(int r5);

    void setTokenStopIndex(int r5);

    String toString();

    String toStringTree();
}
