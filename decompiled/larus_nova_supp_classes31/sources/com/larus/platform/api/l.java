package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public final Long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    public l() {
        this(null, 0, 0, 0, 0, 0, -1, -1);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
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
        Long r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.b;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.g;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        long r14 = this.h;
        return r13 + ((int) (r14 ^ (r14 >>> 32)));
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ColdLaunchTimeline(appRealInitTime=" + this.a + ", appAttachEndTime=" + this.b + ", appOnCreateStartTime=" + this.c + ", appOnCreateEndTime=" + this.d + ", mainActivityCreateTime=" + this.e + ", mainActivityResumeTime=" + this.f + ", mainFirstFrameDuration=" + this.g + ", chatFirstFrameDuration=" + this.h + ')';
    }

    public l(Long r1, long r2, long r4, long r6, long r8, long r10, long r12, long r14) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r10;
        this.g = r12;
        this.h = r14;
    }
}
