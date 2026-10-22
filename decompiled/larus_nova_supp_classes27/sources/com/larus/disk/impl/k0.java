package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k0 {
    public final long a;
    public final long b;
    public final long c;
    public final int d;

    public k0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r9 = (k0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        return ((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.d;
    }

    public final String toString() {
        return "FileAccessUsage(knownBytes=" + this.a + ", used7dBytes=" + this.b + ", used30dBytes=" + this.c + ", knownFileCount=" + this.d + ')';
    }

    public /* synthetic */ k0(int r9) {
        this(0, 0, 0, 0);
    }

    public final k0 a(k0 r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        long r2 = l0.a(this.a, r11.a);
        long r4 = l0.a(this.b, r11.b);
        long r6 = l0.a(this.c, r11.c);
        int r1 = this.d;
        int r12 = r11.d;
        int r8 = Integer.MAX_VALUE;
        if ((Integer.MAX_VALUE - r1) < r12) goto L7;
        r8 = r1 + r12;
    L7:
        return new k0(r2, r4, r6, r8);
    }

    public k0(long r1, long r3, long r5, int r7) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r7;
    }
}
