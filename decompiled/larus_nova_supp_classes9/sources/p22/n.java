package p22;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public final boolean a;
    public final int b;
    public final int c;
    public final float d;
    public final int e;
    public final int f;
    public final float g;
    public final float h;
    public final float i;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L24;
        n r4 = (n) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Float.compare(this.g, r4.g) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.h, r4.h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.i, r4.i) == 0) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((((((((((((((r1 * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i);
    }

    public final String toString() {
        return "SimpleDanmakuConfig(isDanmakuOpen=" + this.a + ", displayWidth=" + this.b + ", lineCount=" + this.c + ", lineHeight=" + this.d + ", lineSpacing=" + this.e + ", barrageMinSpacing=" + this.f + ", speed=" + this.g + ", alpha=" + this.h + ", fontSize=" + this.i + ")";
    }

    public n(boolean r1, int r2, int r3, float r4, int r5, int r6, float r7, float r8, float r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
