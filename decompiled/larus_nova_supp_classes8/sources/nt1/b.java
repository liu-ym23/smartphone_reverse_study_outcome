package nt1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final int a;
    public final int b;
    public final boolean c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        boolean r1 = this.c;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public final String toString() {
        return "NotificationSetting(imageResId=" + this.a + ", textResId=" + this.b + ", isChecked=" + this.c + ")";
    }

    public b(int r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
