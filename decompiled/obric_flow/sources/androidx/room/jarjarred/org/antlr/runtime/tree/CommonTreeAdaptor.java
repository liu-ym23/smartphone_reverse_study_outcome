package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class CommonTreeAdaptor extends BaseTreeAdaptor {
    public CommonTreeAdaptor() {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(Token r5) {
        return new CommonTree(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor
    public Token createToken(int r5, String r10) {
        return new CommonToken(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object dupNode(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((Tree) r5).dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object getChild(Object r5, int r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((Tree) r5).getChild(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getChildCount(Object r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        return ((Tree) r5).getChildCount();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getChildIndex(Object r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        return ((Tree) r5).getChildIndex();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object getParent(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((Tree) r5).getParent();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public String getText(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((Tree) r5).getText();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Token getToken(Object r5) {
        if ((r5 instanceof CommonTree) == true) goto L5;
        return null;
    L5:
        return ((CommonTree) r5).getToken();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getTokenStartIndex(Object r5) {
        if (r5 != null) goto L6;
        return -1;
    L6:
        return ((Tree) r5).getTokenStartIndex();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getTokenStopIndex(Object r5) {
        if (r5 != null) goto L6;
        return -1;
    L6:
        return ((Tree) r5).getTokenStopIndex();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getType(Object r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        return ((Tree) r5).getType();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void replaceChildren(Object r5, int r10, int r11, Object r12) {
        if (r5 == null) goto L5;
        ((Tree) r5).replaceChildren(r10, r11, r12);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setChildIndex(Object r5, int r10) {
        if (r5 == null) goto L5;
        ((Tree) r5).setChildIndex(r10);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setParent(Object r5, Object r10) {
        if (r5 == null) goto L5;
        ((Tree) r5).setParent((Tree) r10);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setTokenBoundaries(Object r5, Token r10, Token r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r12 = 0;
        if (r10 == null) goto L7;
        int r13 = r10.getTokenIndex();
    L8:
        if (r11 == null) goto L10;
        r12 = r11.getTokenIndex();
    L10:
        Tree r14 = (Tree) r5;
        r14.setTokenStartIndex(r13);
        r14.setTokenStopIndex(r12);
        return;
    L7:
        r13 = 0;
        goto L8
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor
    public Token createToken(Token r5) {
        return new CommonToken(r5);
    }
}
