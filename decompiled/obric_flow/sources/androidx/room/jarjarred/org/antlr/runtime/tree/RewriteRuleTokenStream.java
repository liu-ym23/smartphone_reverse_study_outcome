package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RewriteRuleTokenStream extends RewriteRuleElementStream {
    public RewriteRuleTokenStream(TreeAdaptor r5, String r10) {
        super(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleElementStream
    public Object dup(Object r5) {
        throw new UnsupportedOperationException("dup can't be called for a token stream.");
    }

    public Object nextNode() {
        Token r5 = (Token) _next();
        return this.adaptor.create(r5);
    }

    public Token nextToken() {
        return (Token) _next();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleElementStream
    public Object toTree(Object r5) {
        return r5;
    }

    public RewriteRuleTokenStream(TreeAdaptor r5, String r10, Object r11) {
        super(r5, r10, r11);
    }

    public RewriteRuleTokenStream(TreeAdaptor r5, String r10, List<Object> r11) {
        super(r5, r10, r11);
    }
}
