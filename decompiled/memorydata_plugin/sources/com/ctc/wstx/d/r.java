package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends g {
    public r(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.d.g
    public g a(int r8) {
        return new r(this.f3492b, this.d, r8, this.e, this.f);
    }

    @Override // com.ctc.wstx.d.g
    public String a(y r6, char[] r7, int r8, int r9, boolean r10) {
        int r0 = r9 - r8;
    L3:
        if (r8 >= r9) goto L7;
        if (com.ctc.wstx.io.u.c(r7[r8]) == false) goto L7;
        r8 = r8 + 1;
    L7:
        if (r8 >= r9) goto L9;
    L10:
        r9 = r9 - 1;
        if (r9 <= r8) goto L15;
        if (com.ctc.wstx.io.u.c(r7[r9]) == true) goto L10;
    L15:
        int r1 = r8;
    L16:
        if (r1 > r9) goto L22;
        char r2 = r7[r1];
        if (com.ctc.wstx.io.u.b(r2, this.e, this.f) == false) goto L20;
        r1 = r1 + 1;
        goto L16
    L20:
        return a(r6, r2, "not valid NMTOKEN character");
    L22:
        if (r10 == false) goto L27;
        int r11 = (r9 - r8) + 1;
        if (r11 != r0) goto L26;
        return null;
    L26:
        return new String(r7, r8, r11);
    L27:
        return null;
    L9:
        return a(r6, "Empty NMTOKEN value");
    }

    @Override // com.ctc.wstx.d.g
    public void a(com.ctc.wstx.g.f r3, boolean r4) {
        String r5 = d((com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin"), r4);
        if (r4 == false) goto L6;
        this.d.a(r5);
        return;
    }

    @Override // com.ctc.wstx.d.g
    public int h() {
        return 8;
    }
}
