package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends g {
    public k(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.d.g
    public g a(int r8) {
        return new k(this.f3492b, this.d, r8, this.e, this.f);
    }

    @Override // com.ctc.wstx.d.g
    public String a(y r5, char[] r6, int r7, int r8, boolean r9) {
    L2:
        if (r7 >= r8) goto L6;
        if (com.ctc.wstx.io.u.c(r6[r7]) == false) goto L6;
        r7 = r7 + 1;
    L6:
        if (r7 >= r8) goto L8;
    L9:
        r8 = r8 - 1;
        if (r8 <= r7) goto L14;
        if (com.ctc.wstx.io.u.c(r6[r8]) == true) goto L9;
    L14:
        char r0 = r6[r7];
        if (com.ctc.wstx.io.u.a(r0, this.e, this.f) == false) goto L17;
    L20:
        int r1 = r7 + 1;
    L21:
        if (r1 > r8) goto L27;
        char r2 = r6[r1];
        if (com.ctc.wstx.io.u.b(r2, this.e, this.f) == false) goto L25;
        r1 = r1 + 1;
        goto L21
    L25:
        return a(r5, r2, "not valid as an ID character");
    L27:
        com.ctc.wstx.e.a r4 = b(r5, r6, r7, (r8 - r7) + 1);
        if (r9 == true) goto L39;
        return null;
    L39:
        return r4.c();
    L17:
        if (r0 == ':') goto L20;
        return a(r5, r0, "not valid as the first ID character");
    L8:
        return a(r5, "Empty ENTITY value");
    }

    @Override // com.ctc.wstx.d.g
    public void a(com.ctc.wstx.g.f r3, boolean r4) {
        com.ctc.wstx.g.f r5 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        String r0 = b(r5, r4);
        if (r4 == false) goto L5;
        this.d.a(r0);
    L5:
        a(r5, r0, ((ae) ZeusTransformUtils.preCheckCast(r5, ae.class, "com.obric.memorydata.plugin")).a(r0));
    }

    @Override // com.ctc.wstx.d.g
    public int h() {
        return 5;
    }
}
