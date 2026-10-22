package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UnaryExp extends Expression {
    private static final long serialVersionUID = 1;
    public final Expression exp;

    public UnaryExp(Expression r2) {
        super(r2.hashCode());
        this.exp = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final int calcHashCode() {
        return this.exp.hashCode();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean equals(Object r4) {
        if (getClass().equals(r4.getClass()) == true) goto L6;
        return false;
    L6:
        if (((UnaryExp) ZeusTransformUtils.preCheckCast(r4, UnaryExp.class, "com.obric.memorydata.plugin")).exp != this.exp) goto L9;
        return true;
    L9:
        return false;
    }
}
