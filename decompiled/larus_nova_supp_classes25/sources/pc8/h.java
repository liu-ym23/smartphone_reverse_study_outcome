package pc8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public final int a;
    public final int b;
    public final long c;
    public final boolean d;
    public final int e;
    public final int f;

    public static final class a {
    }

    static {
    }

    public h() {
        this(0, 0, 0, false, 0, 0);
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
        int r0 = ((this.a * 31) + this.b) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.d == false) goto L5;
        int r3 = 1231;
    L7:
        return ((((r2 + r3) * 31) + this.e) * 31) + this.f;
    L5:
        r3 = 1237;
        goto L7
    }

    public final String toString() {
        return "BubbleBannerStrategy(showTiming=" + this.a + ", dismissTiming=" + this.b + ", autoDismissSeconds=" + this.c + ", keepOnLeave=" + this.d + ", clickDismissBehavior=" + this.e + ", priority=" + this.f + ')';
    }

    public h(int r1, int r2, long r3, boolean r5, int r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
