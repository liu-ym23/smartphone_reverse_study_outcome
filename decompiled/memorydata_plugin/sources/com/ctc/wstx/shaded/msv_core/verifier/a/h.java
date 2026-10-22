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
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h implements com.ctc.wstx.shaded.msv_core.grammar.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ExpressionPool f3654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ctc.wstx.shaded.msv_core.util.c f3655b;
    private ElementExp[] c;
    private int d;
    private boolean e;
    private Expression f;
    private Expression g;
    private boolean h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Expression f3656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Expression f3657b;

        public a(Expression r1, Expression r2) {
            this.f3656a = r1;
            this.f3657b = r2;
        }
    }

    public h(ExpressionPool r2) {
        this.c = new ElementExp[4];
        this.f3654a = r2;
    }

    public a a(Expression r8, com.ctc.wstx.shaded.msv_core.util.c r9) {
        if (r8.verifierTag == null) goto L8;
        o r0 = (o) ZeusTransformUtils.preCheckCast(r8.verifierTag, o.class, "com.obric.memorydata.plugin");
        StringPair r4 = new StringPair(r9.f3641a, r9.f3642b);
        o.a r1 = (o.a) ZeusTransformUtils.preCheckCast(r0.c.get(r4), o.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        this.d = 1;
        this.c[0] = r1.f3666a;
        return new a(r1.f3666a.contentModel.getExpandedExp(this.f3654a), r1.f3667b);
    L9:
        a r2 = a(r8, r9, true);
        if (this.d != 1) goto L17;
        o r3 = (o) ZeusTransformUtils.preCheckCast(r8.verifierTag, o.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
        r3 = new o();
        r8.verifierTag = r3;
    L14:
        if (r4 != null) goto L16;
        r4 = new StringPair(r9.f3641a, r9.f3642b);
    L16:
        r3.c.put(r4, new o.a(this.c[0], r2.f3657b));
    L17:
        return r2;
    L8:
        r4 = null;
        goto L9
    }

    public a a(Expression r5, com.ctc.wstx.shaded.msv_core.util.c r6, boolean r7) {
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L8;
        int r0 = 0;
    L5:
        ElementExp[] r2 = this.c;
        if (r0 >= r2.length) goto L8;
        r2[r0] = null;
        r0 = r0 + 1;
    L8:
        this.d = 0;
        return b(r5, r6, r7);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a() {
        Expression r0 = Expression.nullSet;
        this.g = r0;
        this.f = r0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(AttributeExp r1) {
        Expression r2 = Expression.nullSet;
        this.g = r2;
        this.f = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ChoiceExp r4) {
        r4.exp1.visit(this);
        Expression r0 = this.f;
        Expression r1 = this.g;
        r4.exp2.visit(this);
        this.f = this.f3654a.createChoice(this.f, r0);
        this.g = this.f3654a.createChoice(this.g, r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ConcurExp r4) {
        this.h = true;
        r4.exp1.visit(this);
        Expression r0 = this.f;
        Expression r1 = this.g;
        r4.exp2.visit(this);
        this.f = this.f3654a.createConcur(this.f, r0);
        this.g = this.f3654a.createConcur(this.g, r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(DataExp r1) {
        Expression r2 = Expression.nullSet;
        this.g = r2;
        this.f = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ElementExp r5) {
        if (this.e == true) goto L5;
    L8:
        int r1 = 0;
    L9:
        int r2 = this.d;
        if (r1 >= r2) goto L16;
        if (this.c[r1] == r5) goto L13;
        r1 = r1 + 1;
        goto L9
    L13:
        this.f = r5.contentModel.getExpandedExp(this.f3654a);
        this.g = Expression.epsilon;
        return;
    L16:
        ElementExp[] r3 = this.c;
        if (r2 != r3.length) goto L19;
        ElementExp[] r4 = new ElementExp[r3.length * 2];
        System.arraycopy(r3, 0, r4, 0, r3.length);
        this.c = r4;
    L19:
        ElementExp[] r0 = this.c;
        int r6 = this.d;
        this.d = r6 + 1;
        r0[r6] = r5;
        this.f = r5.contentModel.getExpandedExp(this.f3654a);
        this.g = Expression.epsilon;
        return;
    L5:
        if (r5.getNameClass().accepts(this.f3655b.f3641a, this.f3655b.f3642b) == true) goto L8;
        Expression r7 = Expression.nullSet;
        this.g = r7;
        this.f = r7;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(InterleaveExp r5) {
        r5.exp1.visit(this);
        if (this.f != Expression.nullSet) goto L7;
        r5.exp2.visit(this);
        ExpressionPool r0 = this.f3654a;
        Expression r1 = this.g;
        Expression r6 = r5.exp1;
    L5:
        this.g = r0.createInterleave(r1, r6);
        return;
    L7:
        Expression r2 = this.f;
        r1 = this.g;
        r5.exp2.visit(this);
        if (this.f != Expression.nullSet) goto L10;
    L9:
        this.f = r2;
        r0 = this.f3654a;
        r6 = r5.exp2;
        goto L5
    L10:
        r2 = this.f3654a.createChoice(this.f, r2);
        goto L9
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ListExp r1) {
        Expression r2 = Expression.nullSet;
        this.g = r2;
        this.f = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(MixedExp r2) {
        r2.exp.visit(this);
        this.g = this.f3654a.createMixed(this.g);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(OneOrMoreExp r3) {
        r3.exp.visit(this);
        ExpressionPool r0 = this.f3654a;
        this.g = r0.createSequence(this.g, r0.createZeroOrMore(r3.exp));
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(OtherExp r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ReferenceExp r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(SequenceExp r4) {
        r4.exp1.visit(this);
        this.g = this.f3654a.createSequence(this.g, r4.exp2);
        if (r4.exp1.isEpsilonReducible() == true) goto L5;
        return;
    L5:
        Expression r0 = this.f;
        Expression r1 = this.g;
        r4.exp2.visit(this);
        if (this.f != Expression.nullSet) goto L10;
        this.f = r0;
        this.g = r1;
        return;
    L10:
        if (r0 != Expression.nullSet) goto L12;
        return;
    L12:
        this.f = this.f3654a.createChoice(this.f, r0);
        this.g = this.f3654a.createChoice(r1, this.g);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ValueExp r1) {
        Expression r2 = Expression.nullSet;
        this.g = r2;
        this.f = r2;
    }

    public final a b(Expression r2, com.ctc.wstx.shaded.msv_core.util.c r3, boolean r4) {
        this.h = false;
        this.f3655b = r3;
        this.e = r4;
        r2.visit(this);
        if (this.d == 1) goto L6;
        this.g = null;
    L6:
        return new a(this.f, this.g);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void b() {
        Expression r0 = Expression.nullSet;
        this.g = r0;
        this.f = r0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void c() {
        Expression r0 = Expression.nullSet;
        this.g = r0;
        this.f = r0;
    }

    public final ElementExp[] d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final boolean f() {
        return this.h;
    }
}
