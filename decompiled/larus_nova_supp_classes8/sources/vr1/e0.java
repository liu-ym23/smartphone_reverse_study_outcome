package vr1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0 {
    public final boolean a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e0) == false) goto L10;
        e0 r4 = (e0) r3;
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
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (r1 * 31) + this.b;
    }

    public final String toString() {
        return "ReplayKeyBoardResult(keyboardVisible=" + this.a + ", keyboardHeight=" + this.b + ")";
    }

    public e0(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
