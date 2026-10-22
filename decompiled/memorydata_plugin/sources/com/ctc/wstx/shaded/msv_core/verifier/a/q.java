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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class q implements com.ctc.wstx.shaded.msv_core.grammar.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected v f3670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final ExpressionPool f3671b;

    public q(ExpressionPool r1) {
        this.f3671b = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a() {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(AttributeExp r1) {
        if (this.f3670a.a(r1) == false) goto L7;
        return Expression.epsilon;
    L7:
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ChoiceExp r3) {
        return this.f3671b.createChoice(r3.exp1.visit(this), r3.exp2.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ConcurExp r3) {
        return this.f3671b.createConcur(r3.exp1.visit(this), r3.exp2.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(DataExp r1) {
        if (this.f3670a.a(r1) == false) goto L7;
        return Expression.epsilon;
    L7:
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ElementExp r1) {
        if (this.f3670a.a(r1) == false) goto L7;
        return Expression.epsilon;
    L7:
        return Expression.nullSet;
    }

    final Expression a(Expression r6, l r7) {
        if (r7.f3660b != null) goto L5;
    L14:
        this.f3670a = r7;
        return r6.visit(this);
    L5:
        if (r7.f3660b.length != 1) goto L14;
        if (r6.verifierTag != null) goto L9;
        o r0 = new o();
        r6.verifierTag = r0;
    L12:
        this.f3670a = r7;
        Expression r5 = r6.visit(this);
        r0.f3665b.put(r7.f3660b[0], r5);
        return r5;
    L9:
        r0 = (o) ZeusTransformUtils.preCheckCast(r6.verifierTag, o.class, "com.obric.memorydata.plugin");
        Expression r2 = (Expression) ZeusTransformUtils.preCheckCast(r0.f3665b.get(r7.f3660b[0]), Expression.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        return r2;
    }

    public final Expression a(Expression r3, v r4) {
        if (ZeusTransformUtils.instanceOf(r4, l.class) == true) goto L5;
        this.f3670a = r4;
        Expression r0 = r3.visit(this);
        if (r4.e_() == true) goto L9;
        return r0;
    L9:
        return this.f3671b.createChoice(r0, r3);
    L5:
        return a(r3, (l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(InterleaveExp r5) {
        ExpressionPool r0 = this.f3671b;
        return r0.createChoice(r0.createInterleave(r5.exp1.visit(this), r5.exp2), this.f3671b.createInterleave(r5.exp1, r5.exp2.visit(this)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ListExp r1) {
        if (this.f3670a.a(r1) == false) goto L7;
        return Expression.epsilon;
    L7:
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(MixedExp r2) {
        if (this.f3670a.d_() == false) goto L6;
        return r2;
    L6:
        return this.f3671b.createMixed(r2.exp.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OneOrMoreExp r3) {
        return this.f3671b.createSequence(r3.exp.visit(this), this.f3671b.createZeroOrMore(r3.exp));
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
    public Expression a(SequenceExp r4) {
        Expression r0 = this.f3671b.createSequence(r4.exp1.visit(this), r4.exp2);
        if (r4.exp1.isEpsilonReducible() == true) goto L5;
        return r0;
    L5:
        return this.f3671b.createChoice(r0, r4.exp2.visit(this));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ValueExp r1) {
        if (this.f3670a.a(r1) == false) goto L7;
        return Expression.epsilon;
    L7:
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression b() {
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression c() {
        if (this.f3670a.d_() == false) goto L7;
        return Expression.anyString;
    L7:
        return Expression.nullSet;
    }
}
