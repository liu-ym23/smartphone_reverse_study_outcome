package f32;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements f {
    public final boolean a;
    public final boolean b;
    public final long c;
    public final boolean d;

    public d() {
        this(false, false, 0, false, 15);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L14;
        d r7 = (d) r6;
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
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        boolean r9 = this.d;
        if (r9 == true) goto L13;
        r1 = r9;
    L13:
        return r8 + r1;
    }

    public final String toString() {
        return "FlowLikeFeatureConfig(cancelFlow=" + this.a + ", disableShowAvatar=" + this.b + ", othersDiggFrq=" + this.c + ", disableOthersDiggFlow=" + this.d + ")";
    }

    public d(boolean r3, boolean r4, long r5, boolean r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = 200;
    L12:
        if ((r8 & 8) == 0) goto L14;
        r7 = false;
    L14:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r7;
    }
}
