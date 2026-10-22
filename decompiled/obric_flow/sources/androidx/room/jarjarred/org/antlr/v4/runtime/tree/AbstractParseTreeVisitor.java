package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractParseTreeVisitor<T> implements ParseTreeVisitor<T> {
    public AbstractParseTreeVisitor() {
    }

    public T aggregateResult(T r5, T r10) {
        return r10;
    }

    public T defaultResult() {
        return null;
    }

    public boolean shouldVisitNextChild(RuleNode r5, T r10) {
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor
    public T visit(ParseTree r5) {
        return (T) r5.accept(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor
    public T visitChildren(RuleNode r5) {
        T r10 = (T) defaultResult();
        int r11 = r5.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (shouldVisitNextChild(r5, r10) == false) goto L8;
        T r13 = r10;
        r10 = (T) aggregateResult(r13, r5.getChild(r12).accept(this));
        r12 = r12 + 1;
    L8:
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor
    public T visitErrorNode(ErrorNode r5) {
        return defaultResult();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor
    public T visitTerminal(TerminalNode r5) {
        return defaultResult();
    }
}
