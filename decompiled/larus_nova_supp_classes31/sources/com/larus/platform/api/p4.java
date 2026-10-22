package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;

    public p4() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p4) == true) goto L8;
        return false;
    L8:
        p4 r6 = (p4) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.q;
        if (r49 == null) goto L71;
        r1 = r49.hashCode();
    L71:
        return r48 + r1;
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MusicAuthTraceInfo(scene=" + this.a + ", secEnterMethod=" + this.b + ", enterMethod=" + this.c + ", action=" + this.d + ", scope=" + this.e + ", botId=" + this.f + ", messageId=" + this.g + ", contentType=" + this.h + ", appName=" + this.i + ", appType=" + this.j + ", uniqueKey=" + this.k + ", widgetId=" + this.l + ", appKey=" + this.m + ", currentPage=" + this.n + ", bindScene=" + this.o + ", bindSource=" + this.p + ", bindType=" + this.q + ')';
    }

    public static p4 a(p4 r19, String r20) {
        return new p4(r19.a, r19.b, r19.c, r19.d, r19.e, r19.f, r19.g, r20, r19.i, r19.j, r19.k, r19.l, r19.m, r19.n, r19.o, r19.p, r19.q);
    }

    public /* synthetic */ p4(String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, int r38) {
        if ((r38 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r38 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r38 & 64) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r38 & 128) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r38 & 256) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r38 & 512) == 0) goto L37;
        String r13 = null;
    L39:
        if ((r38 & 1024) == 0) goto L41;
        String r14 = null;
    L43:
        if ((r38 & 2048) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r38 & 4096) == 0) goto L49;
        String r16 = null;
    L51:
        if ((r38 & 8192) == 0) goto L53;
        String r17 = null;
    L55:
        if ((r38 & 16384) == 0) goto L57;
        String r18 = null;
    L59:
        if ((32768 & r38) == 0) goto L61;
        String r19 = null;
    L63:
        if ((r38 & 65536) == 0) goto L65;
        String r20 = null;
    L66:
        this(r4, r5, r6, r7, null, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    L65:
        r20 = r37;
        goto L66
    L61:
        r19 = r36;
        goto L63
    L57:
        r18 = r35;
        goto L59
    L53:
        r17 = r34;
        goto L55
    L49:
        r16 = r33;
        goto L51
    L45:
        r15 = r32;
        goto L47
    L41:
        r14 = r31;
        goto L43
    L37:
        r13 = r30;
        goto L39
    L33:
        r12 = r29;
        goto L35
    L29:
        r11 = r28;
        goto L31
    L25:
        r10 = r27;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L17:
        r7 = r25;
        goto L19
    L13:
        r6 = r24;
        goto L15
    L9:
        r5 = r23;
        goto L11
    L5:
        r4 = r22;
        goto L7
    }

    public p4(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
    }
}
