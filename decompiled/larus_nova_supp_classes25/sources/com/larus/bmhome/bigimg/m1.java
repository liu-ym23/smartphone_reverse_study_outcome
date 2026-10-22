package com.larus.bmhome.bigimg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m1 {
    public final String a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final String f;

    public m1(String r1, String r2, String r3, Integer r4, Integer r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ m1(String r7, String r8, String r9, Integer r10, Integer r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        Integer r4 = null;
    L19:
        if ((r13 & 16) == 0) goto L21;
        Integer r5 = null;
    L23:
        if ((r13 & 32) == 0) goto L25;
        String r14 = null;
    L26:
        this(r0, r2, r3, r4, r5, r14);
        return;
    L25:
        r14 = r12;
        goto L26
    L21:
        r5 = r11;
        goto L23
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r0 = r7;
        goto L7
    }
}
