package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends g {
    public o(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.d.g
    public g a(int r8) {
        return new o(this.f3492b, this.d, r8, this.e, this.f);
    }

    @Override // com.ctc.wstx.d.g
    public String a(y r9, char[] r10, int r11, int r12, boolean r13) {
        int r2 = r11;
    L3:
        if (r2 >= r12) goto L7;
        if (com.ctc.wstx.io.u.c(r10[r2]) == false) goto L7;
        r2 = r2 + 1;
    L7:
        if (r2 >= r12) goto L9;
    L10:
        r12 = r12 - 1;
        if (r12 <= r2) goto L15;
        if (com.ctc.wstx.io.u.c(r10[r12]) == true) goto L10;
    L15:
        char r14 = r10[r2];
        if (com.ctc.wstx.io.u.a(r14, this.e, this.f) == false) goto L18;
        int r0 = r2 + 1;
        int r4 = r14;
    L20:
        if (r0 > r12) goto L26;
        char r15 = r10[r0];
        if (com.ctc.wstx.io.u.b(r15, this.e, this.f) == false) goto L24;
        r4 = (r4 * 31) + r15;
        r0 = r0 + 1;
        goto L20
    L24:
        return a(r9, r15, "not valid as an ID character");
    L26:
        com.ctc.wstx.util.f r1 = r9.c();
        com.ctc.wstx.util.h r6 = r9.e();
        javax.xml.stream.a r16 = r9.f();
        com.ctc.wstx.util.e r17 = r1.b(r10, r2, (r12 - r2) + 1, r4, r16, r6, this.f3492b);
        if (r17.b() != r16) goto L29;
        if (r13 == true) goto L32;
        return null;
    L32:
        return r17.a();
    L29:
        return a(r9, "Duplicate id '" + r17.a() + "', first declared at " + r17.b());
    L18:
        return a(r9, r14, "not valid as the first ID character");
    L9:
        return a(r9, "Empty ID value");
    }

    @Override // com.ctc.wstx.d.g
    public void a(com.ctc.wstx.g.f r1, boolean r2) {
        com.ctc.wstx.g.f r0 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r1, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        throw new IllegalStateException(com.ctc.wstx.b.a.m);
    }

    @Override // com.ctc.wstx.d.g
    public int h() {
        return 2;
    }
}
