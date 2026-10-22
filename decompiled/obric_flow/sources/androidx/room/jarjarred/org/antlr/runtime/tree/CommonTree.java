package androidx.room.jarjarred.org.antlr.runtime.tree;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class CommonTree extends BaseTree {
    public int childIndex;
    public CommonTree parent;
    protected int startIndex;
    protected int stopIndex;
    public Token token;

    public CommonTree() {
        this.startIndex = -1;
        this.stopIndex = -1;
        this.childIndex = -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public Tree dupNode() {
        return new CommonTree(this);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getCharPositionInLine() {
        Token r5 = this.token;
        if (r5 == null) goto L10;
        if (r5.getCharPositionInLine() == (-1)) goto L10;
        return this.token.getCharPositionInLine();
    L10:
        if (getChildCount() > 0) goto L12;
        return 0;
    L12:
        return getChild(0).getCharPositionInLine();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getChildIndex() {
        return this.childIndex;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getLine() {
        Token r5 = this.token;
        if (r5 == null) goto L10;
        if (r5.getLine() == 0) goto L10;
        return this.token.getLine();
    L10:
        if (getChildCount() > 0) goto L12;
        return 0;
    L12:
        return getChild(0).getLine();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public Tree getParent() {
        return this.parent;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String getText() {
        Token r5 = this.token;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getText();
    }

    public Token getToken() {
        return this.token;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getTokenStartIndex() {
        int r5 = this.startIndex;
        if (r5 != (-1)) goto L8;
        Token r10 = this.token;
        if (r10 == null) goto L8;
        return r10.getTokenIndex();
    L8:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getTokenStopIndex() {
        int r5 = this.stopIndex;
        if (r5 != (-1)) goto L8;
        Token r10 = this.token;
        if (r10 == null) goto L8;
        return r10.getTokenIndex();
    L8:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getType() {
        Token r5 = this.token;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getType();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public boolean isNil() {
        if (this.token != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setChildIndex(int r5) {
        this.childIndex = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setParent(Tree r5) {
        this.parent = (CommonTree) r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setTokenStartIndex(int r5) {
        this.startIndex = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setTokenStopIndex(int r5) {
        this.stopIndex = r5;
    }

    public void setUnknownTokenBoundaries() {
        if (this.children == null) goto L5;
        int r5 = 0;
    L12:
        if (r5 >= this.children.size()) goto L15;
        ((CommonTree) this.children.get(r5)).setUnknownTokenBoundaries();
        r5 = r5 + 1;
        goto L12
    L15:
        if (this.startIndex < 0) goto L20;
        if (this.stopIndex < 0) goto L20;
        return;
    L20:
        if (this.children.size() <= 0) goto L25;
        CommonTree r10 = (CommonTree) this.children.get(0);
        CommonTree r11 = (CommonTree) j0.e(this.children, 1);
        this.startIndex = r10.getTokenStartIndex();
        this.stopIndex = r11.getTokenStopIndex();
        return;
    L25:
        return;
    L5:
        if (this.startIndex >= 0) goto L7;
    L8:
        int r12 = this.token.getTokenIndex();
        this.stopIndex = r12;
        this.startIndex = r12;
        return;
    L7:
        if (this.stopIndex < 0) goto L8;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String toString() {
        if (isNil() == false) goto L7;
        return "nil";
    L7:
        if (getType() != 0) goto L10;
        return "<errornode>";
    L10:
        Token r5 = this.token;
        if (r5 != null) goto L15;
        return null;
    L15:
        return r5.getText();
    }

    public CommonTree(CommonTree r5) {
        super(r5);
        this.startIndex = -1;
        this.stopIndex = -1;
        this.childIndex = -1;
        this.token = r5.token;
        this.startIndex = r5.startIndex;
        this.stopIndex = r5.stopIndex;
    }

    public CommonTree(Token r5) {
        this.startIndex = -1;
        this.stopIndex = -1;
        this.childIndex = -1;
        this.token = r5;
    }
}
