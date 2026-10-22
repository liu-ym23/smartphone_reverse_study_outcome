package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.ctc.wstx.shaded.msv_core.grammar.b {
    public f(ExpressionPool r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(AttributeExp r1) {
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ElementExp r1) {
        return r1;
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
