package hwb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r6.f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r6.g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.h, r6.h) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.i, r6.i) == 0) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i);
    }

    public final String toString() {
        return "MmRecordingFloatContainerSpec(layoutRes=" + this.a + ", contentContainerId=" + this.b + ", sideHideContainerId=" + this.c + ", leftArrowViewId=" + this.d + ", rightArrowViewId=" + this.e + ", contentWidthDp=" + this.f + ", contentHeightDp=" + this.g + ", shadowInsetDp=" + this.h + ", sideHideButtonWidthDp=" + this.i + ')';
    }

    public a(int r1) {
        this.a = r1;
        this.b = 2131380201;
        this.c = 2131380207;
        this.d = 2131380203;
        this.e = 2131380205;
        this.f = 78.0f;
        this.g = 96.0f;
        this.h = 16.0f;
        this.i = 24.0f;
    }
}
