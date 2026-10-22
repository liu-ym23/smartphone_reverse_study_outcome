package q72;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (this.b == r4.b) goto L8;
        return false;
    L8:
        if (this.c == r4.c) goto L10;
        return false;
    L10:
        if (this.d == r4.d) goto L12;
        return false;
    L12:
        if (this.e == r4.e) goto L14;
        return false;
    L14:
        if (this.f == r4.f) goto L16;
        return false;
    L16:
        if (this.g == r4.g) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r0 = ((((((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        boolean r1 = this.g;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public final String toString() {
        return "CarnivalDanmakuConfig(displayWidth=" + this.b + ", displayHeight=" + this.c + ", lineHeight=" + this.d + ", lineSpacing=" + this.e + ", duration=" + this.f + ", left2right=" + this.g + ")";
    }

    public a(int r1, int r2, int r3, int r4, int r5, boolean r6) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = r2 / (r3 + r4);
    }
}
