package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends n {
    public k(p r1, Expression r2, boolean r3) {
        super(r1, r2, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.n
    public com.ctc.wstx.shaded.msv_core.verifier.b a(Expression r3, Expression r4, ElementExp[] r5, int r6) {
        if (r5 != null) goto L5;
    L12:
        p r2 = this.c;
        if (r5 != null) goto L15;
        ElementExp r7 = null;
    L17:
        return new r(r2, r3, r7, r4);
    L15:
        r7 = r5[0];
        goto L17
    L5:
        if (r6 <= 1) goto L12;
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L10;
        System.out.println("ComplexAcceptor is used");
    L10:
        ElementExp[] r8 = new ElementExp[r6];
        System.arraycopy(r5, 0, r8, 0, r6);
        return new i(this.c, r3, r8);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.b
    public boolean a(com.ctc.wstx.shaded.msv_core.verifier.b r4, com.ctc.wstx.shaded.msv_core.util.d r5) {
        com.ctc.wstx.shaded.msv_core.verifier.b r6 = (com.ctc.wstx.shaded.msv_core.verifier.b) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.verifier.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, r.class) == false) goto L11;
        r r7 = (r) ZeusTransformUtils.preCheckCast(r6, r.class, "com.obric.memorydata.plugin");
        if (r7.f3672a == null) goto L9;
        return a(r7.f3672a, r5);
    L9:
        return a(new l(new ElementExp[]{r7.f3673b}), r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r6, i.class) == false) goto L19;
        i r8 = (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        ElementExp[] r9 = r8.f3658a;
    L17:
        return a(new l(r9), r5);
    L15:
        r9 = r8.b();
        goto L17
    L19:
        throw new Error();
    }
}
