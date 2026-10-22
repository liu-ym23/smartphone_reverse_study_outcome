package jub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final long d;

    public a() {
        this(0, 15);
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b) * 31;
        if (this.c == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        long r4 = this.d;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingNotificationConfig(canClose=" + this.a + ", priority=" + this.b + ", persistent=" + this.c + ", throttleInterval=" + this.d + ')';
    }

    public a(long r1, int r3) {
        if ((r3 & 8) == 0) goto L5;
        r1 = 0;
    L5:
        this.a = false;
        this.b = 0;
        this.c = false;
        this.d = r1;
    }
}
