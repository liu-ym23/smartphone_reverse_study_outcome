package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ConcurExp;
import com.ctc.wstx.shaded.msv_core.grammar.DataExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.InterleaveExp;
import com.ctc.wstx.shaded.msv_core.grammar.ListExp;
import com.ctc.wstx.shaded.msv_core.grammar.MixedExp;
import com.ctc.wstx.shaded.msv_core.grammar.OneOrMoreExp;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.SequenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.ctc.wstx.shaded.msv_core.grammar.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExpressionPool f3651a;

    public c(ExpressionPool r1) {
        this.f3651a = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a() {
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(AttributeExp r1) {
        return r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ChoiceExp r3) {
        Expression r0 = r3.exp1.visit(this);
        Expression r4 = r3.exp2.visit(this);
        if (r0.isEpsilonReducible() == true) goto L10;
        if (r4.isEpsilonReducible() == true) goto L10;
        return this.f3651a.createChoice(r0, r4);
    L10:
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ConcurExp r1) {
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(DataExp r1) {
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ElementExp r1) {
        return AttributeExp.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(InterleaveExp r2) {
        Expression r0 = r2.exp1.visit(this);
        Expression r1 = r2.exp2.visit(this);
        if (r0.isEpsilonReducible() == true) goto L5;
        return r0;
    L5:
        if (r1.isEpsilonReducible() == true) goto L7;
        return r1;
    L7:
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ListExp r1) {
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(MixedExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OneOrMoreExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OtherExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ReferenceExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(SequenceExp r2) {
        Expression r0 = r2.exp1.visit(this);
        Expression r1 = r2.exp2.visit(this);
        if (r0.isEpsilonReducible() == true) goto L5;
        return r0;
    L5:
        if (r1.isEpsilonReducible() == true) goto L7;
        return r1;
    L7:
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ValueExp r1) {
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression b() {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression c() {
        return Expression.epsilon;
    }
}
