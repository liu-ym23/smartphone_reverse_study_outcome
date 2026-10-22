package f32;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements f {
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public i() {
        this(0, false, false, false, false, 63);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof i) == false) goto L18;
        i r7 = (i) r6;
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
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        boolean r2 = this.b;
        ?? r3 = 1;
        ?? r4 = r2;
        if (r2 == false) goto L5;
        r4 = 1;
    L5:
        int r5 = (r1 + r4) * 31;
        boolean r6 = this.c;
        ?? r7 = r6;
        if (r6 == false) goto L8;
        r7 = 1;
    L8:
        int r8 = (r5 + r7) * 31;
        boolean r9 = this.d;
        ?? r10 = r9;
        if (r9 == false) goto L11;
        r10 = 1;
    L11:
        int r11 = (r8 + r10) * 31;
        boolean r13 = this.e;
        ?? r14 = r13;
        if (r13 == false) goto L14;
        r14 = 1;
    L14:
        int r15 = (r11 + r14) * 31;
        boolean r16 = this.f;
        if (r16 == true) goto L19;
        r3 = r16;
    L19:
        return r15 + r3;
    }

    public final String toString() {
        return "TapLikeFeatureConfig(tapAnimInterval=" + this.a + ", cancelDiggCountAnim=" + this.b + ", disableVibrationEffect=" + this.c + ", disableIconScale=" + this.d + ", disableIconRotate=" + this.e + ", disableIconAlpha=" + this.f + ")";
    }

    public /* synthetic */ i(long r9, boolean r11, boolean r13, boolean r14, boolean r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        r9 = 0;
    L5:
        long r1 = r9;
        if ((r16 & 2) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r16 & 4) == 0) goto L12;
        boolean r4 = false;
    L14:
        if ((r16 & 16) == 0) goto L16;
        boolean r6 = false;
    L18:
        if ((r16 & 32) == 0) goto L20;
        boolean r7 = false;
    L21:
        this(r1, r3, r4, false, r6, r7);
        return;
    L20:
        r7 = r15;
        goto L21
    L16:
        r6 = r14;
        goto L18
    L12:
        r4 = r13;
        goto L14
    L8:
        r3 = r11;
        goto L10
    }

    public i(long r1, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
