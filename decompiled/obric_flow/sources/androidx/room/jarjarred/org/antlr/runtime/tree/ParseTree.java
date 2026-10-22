package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParseTree extends BaseTree {
    public List<Token> hiddenTokens;
    public Object payload;

    public ParseTree(Object r5) {
        this.payload = r5;
    }

    public void _toStringLeaves(StringBuffer r5) {
        if ((this.payload instanceof Token) == false) goto L6;
        r5.append(toStringWithHiddenTokens());
        return;
    L6:
        int r10 = 0;
    L7:
        List<Object> r11 = this.children;
        if (r11 == null) goto L12;
        if (r10 >= r11.size()) goto L15;
        ((ParseTree) this.children.get(r10))._toStringLeaves(r5);
        r10 = r10 + 1;
        goto L7
    L15:
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public Tree dupNode() {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String getText() {
        return toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getTokenStartIndex() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getTokenStopIndex() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getType() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setTokenStartIndex(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setTokenStopIndex(int r5) {
    }

    public String toInputString() {
        StringBuffer r5 = new StringBuffer();
        _toStringLeaves(r5);
        return r5.toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String toString() {
        Object r5 = this.payload;
        if ((r5 instanceof Token) == false) goto L11;
        Token r10 = (Token) r5;
        if (r10.getType() != (-1)) goto L9;
        return "<EOF>";
    L9:
        return r10.getText();
    L11:
        return r5.toString();
    }

    public String toStringWithHiddenTokens() {
        StringBuilder r5 = new StringBuilder();
        if (this.hiddenTokens == null) goto L8;
        int r10 = 0;
    L6:
        if (r10 >= this.hiddenTokens.size()) goto L8;
        r5.append(this.hiddenTokens.get(r10).getText());
        r10 = r10 + 1;
    L8:
        String r11 = toString();
        if (r11.equals("<EOF>") == true) goto L12;
        r5.append(r11);
    L12:
        return r5.toString();
    }
}
