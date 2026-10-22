package lq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r {
    public final float a;
    public final float b;
    public final int c;

    public r() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + this.c;
    }

    public final String toString() {
        return "LoudnessConfig(targetLufs=" + this.a + ", doraLufs=" + this.b + ", loudNormAlgoType=" + this.c + ')';
    }

    public /* synthetic */ r(int r2) {
        this(0.0f, 0.0f, 0);
    }

    public r(float r1, float r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
