package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import androidx.room.jarjarred.org.antlr.v4.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class ErrorNodeImpl extends TerminalNodeImpl implements ErrorNode {
    public ErrorNodeImpl(Token r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNodeImpl, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public <T> T accept(ParseTreeVisitor<? extends T> r5) {
        return r5.visitErrorNode(this);
    }
}
