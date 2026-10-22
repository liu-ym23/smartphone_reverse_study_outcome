package com.larus.avlink.gallery.database;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final String a;
    public final long b;
    public final Long c;
    public final String d;
    public final Long e;
    public final String f;
    public final int g;
    public final int h;
    public final long i;
    public final int j;
    public final int k;
    public final double l;
    public final long m;
    public final String n;
    public final String o;
    public int p;
    public Integer q;
    public String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final int x;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Double.compare(this.l, r9.l) == 0) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r9.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r9.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (this.x == r9.x) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Long r3 = this.c;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.d;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.e;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (((((r12 + r14) * 31) + this.g) * 31) + this.h) * 31;
        long r16 = this.i;
        int r17 = (((((r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31) + this.j) * 31) + this.k) * 31;
        long r18 = Double.doubleToLongBits(this.l);
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        long r20 = this.m;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        String r22 = this.n;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        String r25 = this.o;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (((r24 + r26) * 31) + this.p) * 31;
        Integer r28 = this.q;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        String r31 = this.r;
        if (r31 != null) goto L33;
        int r32 = 0;
    L34:
        int r33 = (r30 + r32) * 31;
        String r34 = this.s;
        if (r34 != null) goto L37;
        int r35 = 0;
    L38:
        int r36 = (r33 + r35) * 31;
        String r37 = this.t;
        if (r37 != null) goto L41;
        int r38 = 0;
    L42:
        int r39 = (r36 + r38) * 31;
        String r40 = this.u;
        if (r40 != null) goto L45;
        int r41 = 0;
    L46:
        int r42 = (r39 + r41) * 31;
        String r43 = this.v;
        if (r43 != null) goto L49;
        int r44 = 0;
    L50:
        int r45 = (r42 + r44) * 31;
        String r46 = this.w;
        if (r46 == null) goto L55;
        r4 = r46.hashCode();
    L55:
        return ((r45 + r4) * 31) + this.x;
    L49:
        r44 = r43.hashCode();
        goto L50
    L45:
        r41 = r40.hashCode();
        goto L46
    L41:
        r38 = r37.hashCode();
        goto L42
    L37:
        r35 = r34.hashCode();
        goto L38
    L33:
        r32 = r31.hashCode();
        goto L34
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r14 = r13.hashCode();
        goto L18
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaData(id=" + this.a + ", mediaId=" + this.b + ", systemGalleryId=" + this.c + ", fileName=" + this.d + ", fileSize=" + this.e + ", mediaType=" + this.f + ", width=" + this.g + ", height=" + this.h + ", duration=" + this.i + ", outVideoWidth=" + this.j + ", outVideoHeight=" + this.k + ", outputVideoCrop=" + this.l + ", createTime=" + this.m + ", geoLocationInfo=" + this.n + ", algorithmType=" + this.o + ", lifecycleState=" + this.p + ", failureStage=" + this.q + ", failureReason=" + this.r + ", downloadFilePath=" + this.s + ", tempFilePath=" + this.t + ", unpackDirPath=" + this.u + ", processedFilePath=" + this.v + ", finalFilePath=" + this.w + ", activeMask=" + this.x + ')';
    }

    public a(String r4, long r5, Long r7, String r8, Long r9, String r10, int r11, int r12, long r13, int r15, int r16, double r17, long r19, String r21, String r22, int r23, Integer r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31) {
        Intrinsics.checkNotNullParameter(r4, "id");
        this.a = r4;
        this.b = r5;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r19;
        this.n = r21;
        this.o = r22;
        this.p = r23;
        this.q = r24;
        this.r = r25;
        this.s = r26;
        this.t = r27;
        this.u = r28;
        this.v = r29;
        this.w = r30;
        this.x = r31;
    }
}
