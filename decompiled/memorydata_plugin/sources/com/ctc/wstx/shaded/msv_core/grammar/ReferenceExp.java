package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ReferenceExp extends Expression {
    private static final long serialVersionUID = 1;
    public Expression exp;
    public final String name;

    public ReferenceExp(String r2) {
        this.exp = null;
        this.name = r2;
    }

    public ReferenceExp(String r1, Expression r2) {
        this(r1);
        this.exp = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean calcEpsilonReducibility() {
        Expression r0 = this.exp;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEpsilonReducible();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final int calcHashCode() {
        return System.identityHashCode(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public boolean isDefined() {
        if (this.exp == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final Expression visit(e r3) {
        return ((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final Object visit(c r3) {
        return ((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final void visit(f r3) {
        ((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final boolean visit(d r3) {
        return ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).a(this);
    }
}
