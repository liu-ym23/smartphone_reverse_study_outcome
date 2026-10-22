package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;

/* JADX INFO: loaded from: classes.dex */
public class TerminalNodeImpl implements TerminalNode {
    public ParseTree parent;
    public Token symbol;

    public TerminalNodeImpl(Token r5) {
        this.symbol = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public <T> T accept(ParseTreeVisitor<? extends T> r5) {
        return r5.visitTerminal(this);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public ParseTree getChild(int r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public int getChildCount() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getParent() {
        return getParent();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Object getPayload() {
        return getPayload();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.SyntaxTree
    public Interval getSourceInterval() {
        Token r5 = this.symbol;
        if (r5 == null) goto L5;
        int r10 = r5.getTokenIndex();
        return new Interval(r10, r10);
    L5:
        return Interval.INVALID;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode
    public Token getSymbol() {
        return this.symbol;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public String getText() {
        return this.symbol.getText();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public void setParent(RuleContext r5) {
        this.parent = r5;
    }

    public String toString() {
        if (this.symbol.getType() != (-1)) goto L7;
        return "<EOF>";
    L7:
        return this.symbol.getText();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public String toStringTree(Parser r5) {
        return toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getChild(int r5) {
        return getChild(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public ParseTree getParent() {
        return this.parent;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public Token getPayload() {
        return this.symbol;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public String toStringTree() {
        return toString();
    }
}
