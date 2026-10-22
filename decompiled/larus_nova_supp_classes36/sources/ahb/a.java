package ahb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    /* JADX INFO: renamed from: ahb.a$a, reason: collision with other inner class name */
    public static final class C0000a {
    }

    static {
    }

    public a() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r6.f) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f);
    }

    public final String toString() {
        return "FlowTagStyle(textSizeSp=" + this.a + ", horizontalPaddingDp=" + this.b + ", tagHeightDp=" + this.c + ", cornerRadiusDp=" + this.d + ", iconSizeDp=" + this.e + ", iconTextSpacingDp=" + this.f + ')';
    }

    public a(float r3, float r4, float r5, float r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 11.0f;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = 6.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 22.0f;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 6.0f;
    L14:
        float r1 = 0.0f;
        if ((r7 & 16) == 0) goto L17;
        float r0 = 12.0f;
    L19:
        if ((r7 & 32) == 0) goto L21;
        r1 = 2.0f;
    L21:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r0;
        this.f = r1;
        return;
    L17:
        r0 = 0.0f;
        goto L19
    }
}
