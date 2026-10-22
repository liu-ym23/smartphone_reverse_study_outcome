package com.larus.suggest.impl.repo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final long a;
    public final long b;
    public final long c;
    public final String d;
    public final long e;
    public final long f;
    public final long g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
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
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        String r6 = this.d;
        if (r6 != null) goto L5;
        int r7 = 0;
    L6:
        long r8 = this.e;
        int r9 = (((r5 + r7) * 31) + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.g;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
    L5:
        r7 = r6.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbPolicyState(expireTimeSec=" + this.a + ", responseVersion=" + this.b + ", lastRequestTimeMs=" + this.c + ", throughToken=" + this.d + ", freqReqIntervalSec=" + this.e + ", freqControlIntervalSec=" + this.f + ", updateTimeMs=" + this.g + ')';
    }

    public /* synthetic */ d(int r15) {
        this(0, 0, 0, null, 0, 0, 0);
    }

    public d(long r1, long r3, long r5, String r7, long r8, long r10, long r12) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r10;
        this.g = r12;
    }

    public static d a(d r14, long r15, long r17, long r19, String r21, long r22, long r24, long r26, int r28) {
        if ((r28 & 1) == 0) goto L5;
        long r1 = r14.a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        long r3 = r14.b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        long r5 = r14.c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r7 = r14.d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        long r8 = r14.e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r10 = r14.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        long r12 = r14.g;
    L31:
        return new d(r1, r3, r5, r7, r8, r10, r12);
    L29:
        r12 = r26;
        goto L31
    L25:
        r10 = r24;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
