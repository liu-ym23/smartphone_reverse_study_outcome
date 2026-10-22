package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0 {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final Long g;
    public final Long h;
    public final boolean i;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r9 = (s0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31;
        int r3 = 1231;
        if (this.e == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.f == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r5 + r6) * 31;
        Long r8 = this.g;
        int r9 = 0;
        if (r8 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r7 + r10) * 31;
        Long r12 = this.h;
        if (r12 == null) goto L18;
        r9 = r12.hashCode();
    L18:
        int r13 = (r11 + r9) * 31;
        if (this.i == true) goto L23;
        r3 = 1237;
    L23:
        return r13 + r3;
    L13:
        r10 = r8.hashCode();
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "RegisteredCacheUsageInfo(business=" + this.a + ", biz=" + this.b + ", sizeBytes=" + this.c + ", storageScope=" + this.d + ", autoCleanable=" + this.e + ", manualCleanable=" + this.f + ", autoCleanableBytes=" + this.g + ", manualCleanableBytes=" + this.h + ", collectionComplete=" + this.i + ')';
    }

    public s0(String r2, String r3, long r4, String r6, boolean r7, boolean r8, Long r9, Long r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "business");
        Intrinsics.checkNotNullParameter(r3, "biz");
        Intrinsics.checkNotNullParameter(r6, "storageScope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
