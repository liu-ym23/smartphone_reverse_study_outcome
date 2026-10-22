package com.larus.avlink.gallery.database;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public String a;
    public final String b;
    public final String c;
    public final long d;
    public final String e;
    public final long f;
    public final String g;
    public final int h;
    public final int i;
    public final long j;
    public final long k;
    public final long l;
    public final long m;
    public final String n;
    public final String o;
    public final int p;
    public final boolean q;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
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
        if (this.l == r9.l) goto L45;
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
        if (this.q == r9.q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode()) * 31;
        long r3 = this.f;
        int r4 = (((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.g.hashCode()) * 31) + this.h) * 31) + this.i) * 31;
        long r5 = this.j;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.k;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.l;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r11 = this.m;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        String r13 = this.n;
        if (r13 != null) goto L5;
        int r14 = 0;
    L6:
        int r15 = (((((r12 + r14) * 31) + this.o.hashCode()) * 31) + this.p) * 31;
        if (this.q == false) goto L9;
        int r16 = 1231;
    L11:
        return r15 + r16;
    L9:
        r16 = 1237;
        goto L11
    L5:
        r14 = r13.hashCode();
        goto L6
    }

    public final String toString() {
        return "ThumbnailData(id=" + this.a + ", filePath=" + this.b + ", fileName=" + this.c + ", fileSize=" + this.d + ", sn=" + this.e + ", imageUuid=" + this.f + ", mediaType=" + this.g + ", width=" + this.h + ", height=" + this.i + ", duration=" + this.j + ", createTime=" + this.k + ", modifyTime=" + this.l + ", downloadTime=" + this.m + ", geoLocationInfo=" + this.n + ", sourceType=" + this.o + ", processingStatus=" + this.p + ", isSynced=" + this.q + ')';
    }

    public i(String r9, String r10, String r11, long r12, String r14, long r15, String r17, int r18, int r19, long r20, long r22, long r24, long r26, String r28, String r29, int r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r10, "filePath");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r14, "sn");
        Intrinsics.checkNotNullParameter(r17, "mediaType");
        Intrinsics.checkNotNullParameter(r29, "sourceType");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r14;
        this.f = r15;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r22;
        this.l = r24;
        this.m = r26;
        this.n = r28;
        this.o = r29;
        this.p = r30;
        this.q = r31;
    }
}
