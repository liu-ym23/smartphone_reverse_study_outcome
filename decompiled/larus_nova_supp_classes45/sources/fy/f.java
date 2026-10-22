package fy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public final long a;
    public final int b;
    public final int c;
    public final int d;
    public final long e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L16;
        f r7 = (f) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        long r3 = this.e;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "JoinChannelParams(channelId=" + this.a + ", scene=" + this.b + ", fromAudience=" + this.c + ", matchType=" + this.d + ", startTs=" + this.e + ")";
    }

    public f(long r5, int r7, int r8, int r9) {
        if ((r9 & 8) == 0) goto L6;
        r8 = 0;
    L6:
        if ((r9 & 16) == 0) goto L8;
        i97.a r11 = i97.a.a;
        long r2 = System.currentTimeMillis();
    L9:
        this.a = r5;
        this.b = r7;
        this.c = 0;
        this.d = r8;
        this.e = r2;
        return;
    L8:
        r2 = 0;
        goto L9
    }
}
