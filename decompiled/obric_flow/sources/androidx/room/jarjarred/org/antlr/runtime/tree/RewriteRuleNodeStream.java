package androidx.room.jarjarred.org.antlr.runtime.tree;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RewriteRuleNodeStream extends RewriteRuleElementStream {
    public RewriteRuleNodeStream(TreeAdaptor r5, String r10) {
        super(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleElementStream
    public Object dup(Object r5) {
        throw new UnsupportedOperationException("dup can't be called for a node stream.");
    }

    public Object nextNode() {
        return _next();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleElementStream
    public Object toTree(Object r5) {
        return this.adaptor.dupNode(r5);
    }

    public RewriteRuleNodeStream(TreeAdaptor r5, String r10, Object r11) {
        super(r5, r10, r11);
    }

    public RewriteRuleNodeStream(TreeAdaptor r5, String r10, List<Object> r11) {
        super(r5, r10, r11);
    }
}
