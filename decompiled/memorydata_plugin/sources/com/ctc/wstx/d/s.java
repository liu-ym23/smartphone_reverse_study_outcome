package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends g {
    public s(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.d.g
    public g a(int r8) {
        return new s(this.f3492b, this.d, r8, this.e, this.f);
    }

    @Override // com.ctc.wstx.d.g
    public String a(y r6, char[] r7, int r8, int r9, boolean r10) {
    L2:
        if (r8 >= r9) goto L6;
        if (com.ctc.wstx.io.u.c(r7[r8]) == false) goto L6;
        r8 = r8 + 1;
    L6:
        if (r8 < r9) goto L10;
        return a(r6, "Empty NMTOKENS value");
    L10:
        if (r10 == true) goto L20;
    L11:
        if (r8 >= r9) goto L19;
        char r11 = r7[r8];
        if (com.ctc.wstx.io.u.c(r11) == true) goto L18;
        if (com.ctc.wstx.io.u.b(r11, this.e, this.f) == true) goto L18;
        return a(r6, r11, "not valid as NMTOKENS character");
    L18:
        r8 = r8 + 1;
        goto L11
    L19:
        return null;
    L20:
        r9 = r9 - 1;
        if (r9 <= r8) goto L25;
        if (com.ctc.wstx.io.u.c(r7[r9]) == true) goto L20;
    L25:
        StringBuilder r12 = null;
    L26:
        if (r8 > r9) goto L45;
        int r1 = r8;
    L28:
        if (r1 > r9) goto L37;
        char r2 = r7[r1];
        if (com.ctc.wstx.io.u.c(r2) == true) goto L37;
        if (com.ctc.wstx.io.u.b(r2, this.e, this.f) == false) goto L35;
        r1 = r1 + 1;
        goto L28
    L35:
        return a(r6, r2, "not valid as an NMTOKENS character");
    L37:
        if (r12 != null) goto L39;
        r12 = new StringBuilder((r9 - r8) + 1);
    L40:
        r12.append(r7, r8, r1 - r8);
        r8 = r1 + 1;
    L41:
        if (r8 > r9) goto L26;
        if (com.ctc.wstx.io.u.c(r7[r8]) == false) goto L26;
        r8 = r8 + 1;
        goto L41
    L39:
        r12.append(' ');
        goto L40
    L45:
        if (r12 != null) goto L48;
        return null;
    L48:
        return r12.toString();
    }

    @Override // com.ctc.wstx.d.g
    public void a(com.ctc.wstx.g.f r11, boolean r12) {
        com.ctc.wstx.g.f r13 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r11, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        String r0 = this.d.e();
        int r1 = r0.length();
        int r2 = 0;
        StringBuilder r4 = null;
        int r3 = 0;
    L4:
        if (r2 >= r1) goto L25;
    L6:
        if (com.ctc.wstx.io.u.c(r0.charAt(r2)) == false) goto L7;
        r2 = r2 + 1;
        if (r2 < r1) goto L6;
    L7:
        int r6 = r2 + 1;
    L8:
        r6 = r6 + 1;
        if (r6 >= r1) goto L13;
        if (com.ctc.wstx.io.u.c(r0.charAt(r6)) == false) goto L8;
    L13:
        r3 = r3 + 1;
        String r7 = r0.substring(r2, r6);
        int r8 = com.ctc.wstx.io.u.b(r7, this.e, this.f);
        if (r8 < 0) goto L16;
        a(r13, "Invalid default value '" + r0 + "'; character #" + r8 + " (" + com.ctc.wstx.io.u.d(r0.charAt(r8)) + ") not a valid NMTOKENS character");
    L16:
        if (r12 == false) goto L22;
        if (r4 != null) goto L20;
        r4 = new StringBuilder((r6 - r2) + 32);
    L21:
        r4.append(r7);
        goto L22
    L20:
        r4.append(' ');
    L22:
        r2 = r6 + 1;
    L25:
        if (r3 != 0) goto L28;
        a(r13, "Invalid default value '" + r0 + "'; empty String is not a valid NMTOKENS value");
        return;
    L28:
        if (r4 == null) goto L40;
        this.d.a(r4.toString());
        return;
    }

    @Override // com.ctc.wstx.d.g
    public int h() {
        return 9;
    }
}
