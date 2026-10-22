package cg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public final boolean a;
    public final boolean b;

    public l() {
        this(false, false);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof l) == false) goto L10;
        l r11 = (l) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L16;
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
        ?? r10 = r0;
        if (r0 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = r10 * 31;
        boolean r12 = this.b;
        if (r12 == true) goto L10;
        r1 = r12;
    L10:
        return r11 + r1;
    }

    public final String toString() {
        return "SwitchModeOptimizeVO(showBigPic=" + this.a + ", showSmallPic=" + this.b + ")";
    }

    public l(boolean r1, boolean r10) {
        this.a = r1;
        this.b = r10;
    }
}
