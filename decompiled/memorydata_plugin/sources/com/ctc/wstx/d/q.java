package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends g {
    public q(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.d.g
    public g a(int r8) {
        return new q(this.f3492b, this.d, r8, this.e, this.f);
    }

    @Override // com.ctc.wstx.d.g
    public String a(y r19, char[] r20, int r21, int r22, boolean r23) {
        int r3 = r21;
    L3:
        if (r3 >= r22) goto L7;
        if (com.ctc.wstx.io.u.c(r20[r3]) == false) goto L7;
        r3 = r3 + 1;
    L7:
        if (r3 >= r22) goto L9;
        int r10 = r22 - 1;
    L11:
        if (r10 <= r3) goto L15;
        if (com.ctc.wstx.io.u.c(r20[r10]) == false) goto L15;
        r10 = r10 - 1;
    L15:
        com.ctc.wstx.util.f r11 = r19.c();
        javax.xml.stream.a r12 = r19.f();
        int r4 = r3;
        StringBuilder r14 = null;
        String r15 = null;
    L16:
        if (r4 > r10) goto L43;
        char r2 = r20[r4];
        if (com.ctc.wstx.io.u.a(r2, this.e, this.f) == false) goto L20;
        int r6 = r2;
        int r9 = r4 + 1;
    L22:
        if (r9 > r10) goto L31;
        char r5 = r20[r9];
        if (com.ctc.wstx.io.u.c(r5) == true) goto L31;
        if (com.ctc.wstx.io.u.b(r5, this.e, this.f) == false) goto L29;
        r6 = (r6 * 31) + r5;
        r9 = r9 + 1;
        goto L22
    L29:
        return a(r19, r5, "not valid as an IDREFS character");
    L31:
        com.ctc.wstx.util.e r7 = r11.a(r20, r4, r9 - r4, r6, r12, r19.e(), this.f3492b);
        int r13 = r9 + 1;
        if (r23 == false) goto L38;
        if (r15 != null) goto L35;
        r15 = r7.a();
        goto L38
    L35:
        if (r14 != null) goto L37;
        r14 = new StringBuilder(r15);
    L37:
        r15 = r7.a();
        r14.append(' ');
        r14.append(r15);
    L38:
        r4 = r13;
    L39:
        if (r4 > r10) goto L16;
        if (com.ctc.wstx.io.u.c(r20[r4]) == false) goto L16;
        r4 = r4 + 1;
        goto L39
    L20:
        return a(r19, r2, "not valid as the first IDREFS character");
    L43:
        if (r23 == false) goto L47;
        if (r14 != null) goto L46;
        return r15;
    L46:
        return r14.toString();
    L47:
        return null;
    L9:
        return a(r19, "Empty IDREFS value");
    }

    @Override // com.ctc.wstx.d.g
    public void a(com.ctc.wstx.g.f r3, boolean r4) {
        String r5 = c((com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin"), r4);
        if (r4 == false) goto L6;
        this.d.a(r5);
        return;
    }

    @Override // com.ctc.wstx.d.g
    public int h() {
        return 4;
    }
}
