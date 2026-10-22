package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BinaryExp extends Expression {
    private static final long serialVersionUID = 1;
    public final Expression exp1;
    public final Expression exp2;

    public BinaryExp(Expression r3, Expression r4) {
        super(r3.hashCode() + r4.hashCode());
        this.exp1 = r3;
        this.exp2 = r4;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final int calcHashCode() {
        return this.exp1.hashCode() + this.exp2.hashCode();
    }

    public Iterator children() {
        final Expression[] r0 = getChildren();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean equals(Object r4) {
        if (getClass() == r4.getClass()) goto L5;
        return false;
    L5:
        BinaryExp r5 = (BinaryExp) ZeusTransformUtils.preCheckCast(r4, BinaryExp.class, "com.obric.memorydata.plugin");
        if (r5.exp1 == this.exp1) goto L8;
        return false;
    L8:
        if (r5.exp2 != this.exp2) goto L12;
        return true;
    L12:
        return false;
    }

    public Expression[] getChildren() {
        int r1 = 1;
        Expression r2 = this;
    L4:
        if (r2.getClass() != getClass()) goto L6;
        r1 = r1 + 1;
        r2 = ((BinaryExp) ZeusTransformUtils.preCheckCast(r2, BinaryExp.class, "com.obric.memorydata.plugin")).exp1;
        goto L4
    L6:
        Expression[] r3 = new Expression[r1];
        Expression r4 = this;
    L8:
        if (r4.getClass() != getClass()) goto L10;
        r1 = r1 - 1;
        r3[r1] = ((BinaryExp) ZeusTransformUtils.preCheckCast(r4, BinaryExp.class, "com.obric.memorydata.plugin")).exp2;
        r4 = ((BinaryExp) ZeusTransformUtils.preCheckCast(r4, BinaryExp.class, "com.obric.memorydata.plugin")).exp1;
        goto L8
    L10:
        r3[0] = r4;
        return r3;
    }
}
