package com.ctc.wstx.shaded.msv_core.grammar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ExpressionPool f3593a;

    public b(ExpressionPool r1) {
        this.f3593a = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a() {
        return Expression.epsilon;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ChoiceExp r4) {
        Expression r0 = r4.exp1.visit(this);
        Expression r1 = r4.exp2.visit(this);
        if (r4.exp1 != r0) goto L8;
        if (r4.exp2 != r1) goto L8;
        return r4;
    L8:
        return this.f3593a.createChoice(r0, r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ConcurExp r3) {
        return this.f3593a.createConcur(r3.exp1.visit(this), r3.exp2.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(DataExp r1) {
        return r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(InterleaveExp r3) {
        return this.f3593a.createInterleave(r3.exp1.visit(this), r3.exp2.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ListExp r3) {
        Expression r0 = r3.exp.visit(this);
        if (r3.exp != r0) goto L6;
        return r3;
    L6:
        return this.f3593a.createList(r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(MixedExp r3) {
        Expression r0 = r3.exp.visit(this);
        if (r3.exp != r0) goto L6;
        return r3;
    L6:
        return this.f3593a.createMixed(r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OneOrMoreExp r3) {
        Expression r0 = r3.exp.visit(this);
        if (r3.exp != r0) goto L6;
        return r3;
    L6:
        return this.f3593a.createOneOrMore(r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(SequenceExp r4) {
        Expression r0 = r4.exp1.visit(this);
        Expression r1 = r4.exp2.visit(this);
        if (r4.exp1 != r0) goto L8;
        if (r4.exp2 != r1) goto L8;
        return r4;
    L8:
        return this.f3593a.createSequence(r0, r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ValueExp r1) {
        return r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression b() {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression c() {
        return Expression.anyString;
    }
}
