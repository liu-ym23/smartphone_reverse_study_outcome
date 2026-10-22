package pfa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k {
    public final long a;
    public final long b;
    public final boolean c;
    public final long d;
    public final long e;
    public final long f;
    public final int g;

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
        if (this.c == false) goto L5;
        int r4 = 1231;
    L6:
        long r5 = this.d;
        int r6 = (((r2 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.e;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.f;
        return ((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + this.g;
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "NovaProcessControlerInitParams(stopDelayMs=" + this.a + ", startDelayMs=" + this.b + ", enableBootAutoStartExit=" + this.c + ", bootAutoStartWindowMs=" + this.d + ", bootAutoStartFirstCheckDelayMs=" + this.e + ", bootAutoStartRetryDelayMs=" + this.f + ", bootAutoStartMaxRetryCount=" + this.g + ')';
    }

    public k(long r1, long r3, boolean r5, long r6, long r8, long r10, int r12) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r10;
        this.g = r12;
    }
}
