package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0 {
    public final String a;
    public final String b;
    public final int c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final int h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r9 = (b0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.c) * 31;
        long r4 = this.d;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.e;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.f;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.g;
        return ((r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.h;
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiskPathUsageSnapshot(path=" + this.a + ", parentPath=" + this.b + ", pathLevel=" + this.c + ", storageBytes=" + this.d + ", accessKnownBytes=" + this.e + ", accessed7dBytes=" + this.f + ", accessed30dBytes=" + this.g + ", accessTrackedFileCount=" + this.h + ')';
    }

    public b0(String r2, String r3, int r4, long r5, long r7, long r9, long r11, int r13) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r11;
        this.h = r13;
    }
}
