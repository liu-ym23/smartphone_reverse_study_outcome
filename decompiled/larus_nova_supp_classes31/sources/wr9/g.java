package wr9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public final long a;
    public final long b;
    public final long c;

    public g() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "PowerStateMonitorConfig(cpuSampleIntervalMs=" + this.a + ", deviceSampleIntervalMs=" + this.b + ", staleAfterMs=" + this.c + ')';
    }

    public g(int r3) {
        this.a = 1000;
        this.b = 1000;
        this.c = 5000;
    }
}
