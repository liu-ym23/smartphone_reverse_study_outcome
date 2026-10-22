package com.larus.project;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final b a(er9.b r6, er9.b r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
        r7 = new er9.b(0);
    L5:
        Integer r2 = null;
        if (r6 == null) goto L16;
        Integer r3 = Integer.valueOf(r6.a);
        if (r3.intValue() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L16;
        int r5 = r3.intValue();
    L17:
        if (r6 == null) goto L27;
        Integer r8 = Integer.valueOf(r6.b);
        if (r8.intValue() <= 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L25;
        r8 = null;
    L25:
        if (r8 == null) goto L27;
        int r10 = r8.intValue();
    L28:
        if (r6 == null) goto L36;
        Integer r11 = Integer.valueOf(r6.c);
        if (r11.intValue() <= 0) goto L32;
        r0 = true;
    L32:
        if (r0 == false) goto L34;
        r2 = r11;
    L34:
        if (r2 == null) goto L36;
        int r12 = r2.intValue();
    L38:
        return new b(r5, r10, r12);
    L36:
        r12 = r7.c;
        goto L38
    L21:
        r9 = false;
    L27:
        r10 = r7.b;
        goto L28
    L10:
        r4 = false;
    L16:
        r5 = r7.a;
        goto L17
    }
}
