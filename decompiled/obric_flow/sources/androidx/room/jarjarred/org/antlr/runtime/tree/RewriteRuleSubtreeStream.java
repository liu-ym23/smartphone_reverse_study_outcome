package androidx.room.jarjarred.org.antlr.runtime.tree;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RewriteRuleSubtreeStream extends RewriteRuleElementStream {
    public RewriteRuleSubtreeStream(TreeAdaptor r5, String r10) {
        super(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleElementStream
    public Object dup(Object r5) {
        return this.adaptor.dupTree(r5);
    }

    public Object nextNode() {
        int r5 = size();
        if (this.dirty == false) goto L5;
    L16:
        Object r10 = _next();
        return this.adaptor.dupNode(r10);
    L5:
        if (this.cursor < r5) goto L8;
        if (r5 == 1) goto L16;
    L8:
        Object r11 = _next();
    L10:
        if (this.adaptor.isNil(r11) == false) goto L15;
        if (this.adaptor.getChildCount(r11) != 1) goto L15;
        r11 = this.adaptor.getChild(r11, 0);
    L15:
        return this.adaptor.dupNode(r11);
    }

    public RewriteRuleSubtreeStream(TreeAdaptor r5, String r10, Object r11) {
        super(r5, r10, r11);
    }

    public RewriteRuleSubtreeStream(TreeAdaptor r5, String r10, List<Object> r11) {
        super(r5, r10, r11);
    }
}
