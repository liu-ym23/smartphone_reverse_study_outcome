package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ElementExp extends Expression {
    private static final long serialVersionUID = 1;
    public Expression contentModel;
    public boolean ignoreUndeclaredAttributes;

    public ElementExp(Expression r2, boolean r3) {
        super(r2.hashCode());
        this.contentModel = r2;
        this.ignoreUndeclaredAttributes = r3;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final boolean calcEpsilonReducibility() {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final int calcHashCode() {
        return this.contentModel.hashCode();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public final Expression getContentModel() {
        return this.contentModel;
    }

    public abstract NameClass getNameClass();

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
