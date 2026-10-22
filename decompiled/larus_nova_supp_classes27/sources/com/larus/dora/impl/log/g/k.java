package com.larus.dora.impl.log.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public final long a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
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
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        long r3 = this.c;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.d;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.e;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "LogInfo(startTime=" + this.a + ", logType=" + this.b + ", totalSize=" + this.c + ", batchCount=" + this.d + ", startOffset=" + this.e + ')';
    }

    public k(long r1, int r3, long r4, long r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = 16;
        this.e = r6;
    }
}
