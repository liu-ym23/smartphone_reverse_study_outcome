package cbb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;

    public c() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
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
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        return r9 + ((int) (r10 ^ (r10 >>> 32)));
    }

    public final String toString() {
        return "GlobalConfig(cleanInterval=" + this.a + ", idleDelay=" + this.b + ", sdkTaskCostLimit=" + this.c + ", taskCostLimit=" + this.d + ", cacheTimeLimit=" + this.e + ", autoCleanMaxTimes=" + this.f + ')';
    }

    public c(int r3) {
        this.a = 86400;
        this.b = 30;
        this.c = 30;
        this.d = 60;
        this.e = 604800;
        this.f = 5;
    }
}
