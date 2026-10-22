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
public class b implements com.ctc.wstx.shaded.msv_core.grammar.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final p f3649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final ExpressionPool f3650b;
    private v c;

    public b(p r1) {
        this.f3649a = r1;
        this.f3650b = r1.f3669b;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a() {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(AttributeExp r1) {
        if (this.c.a(r1) == false) goto L7;
        return Expression.epsilon;
    L7:
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ChoiceExp r3) {
        return this.f3650b.createChoice(r3.exp1.visit(this), r3.exp2.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ConcurExp r3) {
        return this.f3650b.createConcur(r3.exp1.visit(this), r3.exp2.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(DataExp r1) {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ElementExp r1) {
        return Expression.nullSet;
    }

    public final Expression a(Expression r3, g r4, boolean r5) {
        this.c = r4;
        Expression r0 = r3.visit(this);
        if (r0 != Expression.nullSet) goto L11;
        if (r5 == false) goto L11;
        this.c = r4.b();
        if (r3.visit(this) != Expression.nullSet) goto L10;
        return r3;
    L10:
        return Expression.nullSet;
    L11:
        return r0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(InterleaveExp r5) {
        ExpressionPool r0 = this.f3650b;
        return r0.createChoice(r0.createInterleave(r5.exp1.visit(this), r5.exp2), this.f3650b.createInterleave(r5.exp1, r5.exp2.visit(this)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ListExp r1) {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(MixedExp r2) {
        return this.f3650b.createMixed(r2.exp.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OneOrMoreExp r3) {
        return this.f3650b.createSequence(r3.exp.visit(this), this.f3650b.createZeroOrMore(r3.exp));
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
    public Expression a(SequenceExp r5) {
        ExpressionPool r0 = this.f3650b;
        return r0.createChoice(r0.createSequence(r5.exp1.visit(this), r5.exp2), this.f3650b.createSequence(r5.exp1, r5.exp2.visit(this)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ValueExp r1) {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression b() {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression c() {
        return Expression.nullSet;
    }
}
