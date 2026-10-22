package j59;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final long a;
    public final int b;
    public final int c;
    public final int d;

    public a() {
        this(0);
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
        return (((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "DoraGuideState(lastShowTime=" + this.a + ", showTimes=" + this.b + ", closeTimes=" + this.c + ", clickTimes=" + this.d + ')';
    }

    public /* synthetic */ a(int r7) {
        this(0, 0, 0, 0);
    }

    public a(long r1, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static a a(a r6, long r7, int r9, int r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.b;
    L8:
        int r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.c;
    L11:
        int r4 = r10;
        if ((r12 & 8) == 0) goto L14;
        r11 = r6.d;
    L14:
        r6.getClass();
        return new a(r1, r3, r4, r11);
    }
}
