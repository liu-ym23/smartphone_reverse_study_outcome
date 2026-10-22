package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MixedExp extends UnaryExp {
    private static final long serialVersionUID = 1;

    MixedExp(Expression r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean calcEpsilonReducibility() {
        return this.exp.isEpsilonReducible();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public Expression visit(e r3) {
        return ((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public Object visit(c r3) {
        return ((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public void visit(f r3) {
        ((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean visit(d r3) {
        return ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).a(this);
    }
}
