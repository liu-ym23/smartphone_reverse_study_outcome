package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.ctc.wstx.shaded.msv_core.grammar.b {
    public d(ExpressionPool r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(AttributeExp r1) {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ElementExp r1) {
        return r1;
    }

    public final Expression a(Expression r4) {
        o r0 = (o) ZeusTransformUtils.preCheckCast(r4.verifierTag, o.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = new o();
        r4.verifierTag = r0;
    L9:
        Expression r3 = r4.visit(this);
        r0.d = r3;
        return r3;
    L6:
        if (r0.d == null) goto L9;
        return r0.d;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OtherExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ReferenceExp r1) {
        return r1.exp.visit(this);
    }
}
