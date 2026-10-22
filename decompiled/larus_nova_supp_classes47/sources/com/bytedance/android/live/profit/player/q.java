package com.bytedance.android.live.profit.player;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public long a;
    public long b;
    public long c;
    public int d;

    public q() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof q) == false) goto L14;
        q r7 = (q) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
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
        return "PlayMetrics(playStartTs=" + this.a + ", lynxInitEndTs=" + this.b + ", lynxLoadedTs=" + this.c + ", playTimes=" + this.d + ")";
    }

    public q(int r3) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 1;
    }
}
