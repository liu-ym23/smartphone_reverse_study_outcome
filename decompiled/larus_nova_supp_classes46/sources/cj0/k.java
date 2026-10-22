package cj0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public final boolean a;
    public final long b;
    public final long c;
    public final boolean d;

    public k() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L14;
        k r7 = (k) r6;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        boolean r7 = this.d;
        if (r7 == true) goto L10;
        r1 = r7;
    L10:
        return r6 + r1;
    }

    public final String toString() {
        return "PaidLinkMicState(isPaidLinkMicOn=" + this.a + ", paidCount=" + this.b + ", linkTime=" + this.c + ", showProfileCard=" + this.d + ")";
    }

    public /* synthetic */ k(int r8) {
        this(false, 0, 0, false);
    }

    public static k a(k r10, int r11) {
        boolean r1 = false;
        if ((r11 & 1) == 0) goto L5;
        boolean r3 = r10.a;
    L6:
        long r4 = 0;
        if ((r11 & 2) == 0) goto L9;
        long r6 = r10.b;
    L11:
        if ((r11 & 4) == 0) goto L13;
        r4 = r10.c;
    L13:
        long r8 = r4;
        if ((r11 & 8) == 0) goto L17;
        r1 = r10.d;
    L17:
        return new k(r3, r6, r8, r1);
    L9:
        r6 = 0;
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    public k(boolean r1, long r2, long r4, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }
}
