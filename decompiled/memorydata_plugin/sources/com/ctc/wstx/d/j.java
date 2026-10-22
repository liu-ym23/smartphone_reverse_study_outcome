package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends g {
    public j(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.ctc.wstx.d.g
    public g a(int r8) {
        return new j(this.f3492b, this.d, r8, this.e, this.f);
    }

    @Override // com.ctc.wstx.d.g
    public String a(y r8, char[] r9, int r10, int r11, boolean r12) {
    L2:
        if (r10 >= r11) goto L6;
        if (com.ctc.wstx.io.u.c(r9[r10]) == false) goto L6;
        r10 = r10 + 1;
    L6:
        if (r10 >= r11) goto L8;
    L9:
        r11 = r11 - 1;
        if (r11 <= r10) goto L14;
        if (com.ctc.wstx.io.u.c(r9[r11]) == true) goto L9;
    L14:
        StringBuilder r1 = null;
        String r2 = null;
    L15:
        if (r10 > r11) goto L42;
        char r3 = r9[r10];
        if (com.ctc.wstx.io.u.a(r3, this.e, this.f) == false) goto L19;
        int r4 = r10 + 1;
    L21:
        if (r4 > r11) goto L30;
        char r5 = r9[r4];
        if (com.ctc.wstx.io.u.c(r5) == true) goto L30;
        if (com.ctc.wstx.io.u.b(r5, this.e, this.f) == false) goto L28;
        r4 = r4 + 1;
        goto L21
    L28:
        return a(r8, r5, "not valid as an ENTITIES character");
    L30:
        com.ctc.wstx.e.a r13 = b(r8, r9, r10, r4 - r10);
        int r6 = r4 + 1;
        if (r12 == false) goto L37;
        if (r2 != null) goto L34;
        r2 = r13.c();
        goto L37
    L34:
        if (r1 != null) goto L36;
        r1 = new StringBuilder(r2);
    L36:
        r2 = r13.c();
        r1.append(' ');
        r1.append(r2);
    L37:
        r10 = r6;
    L38:
        if (r10 > r11) goto L15;
        if (com.ctc.wstx.io.u.c(r9[r10]) == false) goto L15;
        r10 = r10 + 1;
        goto L38
    L19:
        return a(r8, r3, "not valid as the first ENTITIES character");
    L42:
        if (r12 == false) goto L46;
        if (r1 != null) goto L45;
        return r2;
    L45:
        return r1.toString();
    L46:
        return null;
    L8:
        return a(r8, "Empty ENTITIES value");
    }

    @Override // com.ctc.wstx.d.g
    public void a(com.ctc.wstx.g.f r4, boolean r5) {
        com.ctc.wstx.g.f r6 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        String r0 = c(r6, true);
        if (r5 == false) goto L5;
        this.d.a(r0);
    L5:
        StringTokenizer r7 = new StringTokenizer(r0);
        ae r1 = (ae) ZeusTransformUtils.preCheckCast(r6, ae.class, "com.obric.memorydata.plugin");
    L7:
        if (r7.hasMoreTokens() == false) goto L9;
        a(r6, r0, r1.a(r7.nextToken()));
        goto L7
    }

    @Override // com.ctc.wstx.d.g
    public int h() {
        return 6;
    }
}
