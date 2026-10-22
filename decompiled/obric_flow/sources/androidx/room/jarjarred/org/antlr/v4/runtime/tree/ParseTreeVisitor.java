package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public interface ParseTreeVisitor<T> {
    T visit(ParseTree r5);

    T visitChildren(RuleNode r5);

    T visitErrorNode(ErrorNode r5);

    T visitTerminal(TerminalNode r5);
}
