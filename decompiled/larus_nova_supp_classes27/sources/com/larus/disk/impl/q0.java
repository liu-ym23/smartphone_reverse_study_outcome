package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q0 {
    public final long a;
    public final long b;
    public final int c;
    public final long d;
    public final long e;

    public q0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r9 = (q0) r8;
        if (this.a == r9.a) goto L12;
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
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31;
        long r4 = this.d;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.e;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "NativeHookStats(successCount=" + this.a + ", failureCount=" + this.b + ", lastErrorCode=" + this.c + ", hookedSymbolMask=" + this.d + ", failedSymbolMask=" + this.e + ')';
    }

    public /* synthetic */ q0(int r11) {
        this(0, 0, 0, 0, 0);
    }

    public q0(long r1, long r3, int r5, long r6, long r8) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
    }
}
