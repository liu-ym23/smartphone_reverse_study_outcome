package ctc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public final int a;
    public final int b;
    public final float c;
    public final int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L25:
        return true;
    L5:
        if ((r5 instanceof e) == false) goto L24;
        e r6 = (e) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L24;
        if (this.b != r6.b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L24;
        if (Float.compare(this.c, r6.c) != 0) goto L24;
        if (this.d != r6.d) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
    L21:
        r7 = false;
        goto L22
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L24:
        return false;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d;
    }

    public final String toString() {
        return "ScrollBarTheme(scrollBarWidth=" + this.a + ", scrollBarHeight=" + this.b + ", scrollBarPadding=" + this.c + ", scrollBarColor=" + this.d + ")";
    }

    public e(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = 0.0f;
        this.d = r3;
    }
}
