package h5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public final int e;
    public final int f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r11.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e) * 31) + this.f;
    }

    public final String toString() {
        return "WidgetConfig(borderMargin=" + this.a + ", fgStrokeWidth=" + this.b + ", fgStrokeColor=" + this.c + ", cornerRadius=" + this.d + ", noOutlineBoxType=" + this.e + ", defaultHeight=" + this.f + ')';
    }

    public j(int r1, int r10, int r11, float r12, int r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = 3;
        this.f = r13;
    }
}
