package hq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public final boolean a;
    public final long b;
    public final boolean c;
    public final long d;
    public final long e;
    public final long f;

    public h() {
        this(false, 0, false, 0, 0, 63);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r9 = (h) r8;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r3 = this.b;
        int r2 = ((r0 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.c == true) goto L10;
        r1 = 1237;
    L10:
        int r4 = (r2 + r1) * 31;
        long r5 = this.d;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.e;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.f;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppLaunchFeedOptConfig(enable=" + this.a + ", viewWaitTimeOutDuration=" + this.b + ", optimizeLandingChatActivity=" + this.c + ", boostDuration=" + this.d + ", boostDurationList=" + this.e + ", boostDurationPager=" + this.f + ')';
    }

    public h(boolean r4, long r5, boolean r7, long r8, long r10, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r5 = 5000;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r7 = false;
    L12:
        if ((r12 & 16) == 0) goto L15;
        r8 = 0;
    L15:
        if ((r12 & 32) == 0) goto L17;
        r10 = 0;
    L17:
        this.a = r4;
        this.b = r5;
        this.c = r7;
        this.d = 0;
        this.e = r8;
        this.f = r10;
    }
}
