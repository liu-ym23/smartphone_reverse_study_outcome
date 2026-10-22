package f32;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements f {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public b() {
        this(false, false, false, false, false, 31);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L16;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
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
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = r10;
        if (r10 == false) goto L14;
        r11 = 1;
    L14:
        int r13 = (r9 + r11) * 31;
        boolean r14 = this.e;
        if (r14 == true) goto L19;
        r1 = r14;
    L19:
        return r13 + r1;
    }

    public final String toString() {
        return "EnterAnimFeatureConfig(disableEcomAnim=" + this.a + ", disableHighLevelEnterAnim=" + this.b + ", disableEffectMsgAnim=" + this.c + ", canSelfSee=" + this.d + ", disableGameAnim=" + this.e + ")";
    }

    public b(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = false;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = false;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
