package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Expression[] f3659b;

    public j(p r1, Expression r2, Expression[] r3, boolean r4) {
        super(r1, r2, r4);
        this.f3659b = r3;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.n
    public boolean a(g r5, com.ctc.wstx.shaded.msv_core.util.d r6) {
        int r0 = 0;
        if (super.a(r5, r6) == true) goto L5;
        return false;
    L5:
        Expression[] r7 = this.f3659b;
        if (r0 >= r7.length) goto L8;
        r7[r0] = this.c.e.a(this.f3659b[r0], r5, this.d);
        r0 = r0 + 1;
        goto L5
    L8:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.k, com.ctc.wstx.shaded.msv_core.verifier.b
    public final boolean a(com.ctc.wstx.shaded.msv_core.verifier.b r6, com.ctc.wstx.shaded.msv_core.util.d r7) {
        com.ctc.wstx.shaded.msv_core.verifier.b r8 = (com.ctc.wstx.shaded.msv_core.verifier.b) ZeusTransformUtils.wrapperContextForParams(r6, com.ctc.wstx.shaded.msv_core.verifier.b.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (super.a(r8, r7) == true) goto L5;
        return false;
    L5:
        q r0 = this.c.c;
        if (ZeusTransformUtils.instanceOf(r8, r.class) == false) goto L12;
        ElementExp r9 = ((r) ZeusTransformUtils.preCheckCast(r8, r.class, "com.obric.memorydata.plugin")).f3673b;
        if (r9 != null) goto L10;
        v r10 = a.f3648a;
    L15:
        Expression[] r11 = this.f3659b;
        if (r2 >= r11.length) goto L18;
        r11[r2] = r0.a(r11[r2], r10);
        r2 = r2 + 1;
        goto L15
    L18:
        return true;
    L10:
        l r12 = new l(new ElementExp[]{r9});
    L11:
        r10 = r12;
        goto L15
    L12:
        if (r7 == null) goto L14;
        r12 = new l(((i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.memorydata.plugin")).f3658a);
        goto L11
    L14:
        r12 = new l(((i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.memorydata.plugin")).b());
        goto L11
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.n, com.ctc.wstx.shaded.msv_core.verifier.b
    public final boolean a(String r3, com.ctc.wstx.shaded.msv_core.grammar.g r4, com.ctc.wstx.shaded.msv_core.util.d r5, com.ctc.wstx.shaded.msv_core.util.a r6) {
        com.ctc.wstx.shaded.msv_core.grammar.g r7 = (com.ctc.wstx.shaded.msv_core.grammar.g) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.grammar.g.class, "com.obric.memorydata.plugin");
        boolean r8 = super.a(r3, r7, r5, r6);
        int r9 = 0;
        if (r8 == true) goto L5;
        return false;
    L5:
        u r10 = new u(this.c, r3, r7);
        q r11 = this.c.c;
    L6:
        Expression[] r12 = this.f3659b;
        if (r9 >= r12.length) goto L9;
        r12[r9] = r11.a(r12[r9], r10);
        r9 = r9 + 1;
        goto L6
    L9:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.n, com.ctc.wstx.shaded.msv_core.verifier.b
    public boolean b(com.ctc.wstx.shaded.msv_core.util.c r3, com.ctc.wstx.shaded.msv_core.util.d r4) {
        boolean r5 = super.b(r3, r4);
        int r6 = 0;
        if (r5 == true) goto L5;
        return false;
    L5:
        Expression[] r7 = this.f3659b;
        if (r6 >= r7.length) goto L8;
        r7[r6] = this.c.f.a(this.f3659b[r6]);
        r6 = r6 + 1;
        goto L5
    L8:
        return true;
    }
}
