package f32;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements f {
    public final boolean a;
    public final boolean b;

    public e() {
        this(false, 3);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L10;
        e r4 = (e) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
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
        int r3 = r2 * 31;
        boolean r4 = this.b;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return r3 + r1;
    }

    public final String toString() {
        return "HotCommentFeatureConfig(enable=" + this.a + ", numberNotScale=" + this.b + ")";
    }

    public e(boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = false;
    L9:
        this.a = r0;
        this.b = r3;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
