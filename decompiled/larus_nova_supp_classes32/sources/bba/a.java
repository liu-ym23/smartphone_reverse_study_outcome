package bba;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final long[] e = null;
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    /* JADX INFO: renamed from: bba.a$a, reason: collision with other inner class name */
    public static final class C0007a {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
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
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "ObricAiKeyGestureConfig(pressStartTimeoutMillis=" + this.a + ", tapTimeoutMillis=" + this.b + ", longAfterPressStartMillis=" + this.c + ", gestureTimeoutMillis=" + this.d + ')';
    }

    static {
        e = new long[]{300, 600, 1000};
    }

    public a(long r1, long r3) {
        this.a = r1;
        this.b = 300;
        this.c = 700;
        this.d = r3;
    }
}
