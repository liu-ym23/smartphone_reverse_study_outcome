package vl8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final float d;

    public g() {
        this(false, false, false, 0.0f, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return ((r4 + r1) * 31) + Float.floatToIntBits(this.d);
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LocalFilePlaybackState(isPlaying=" + this.a + ", isLoading=" + this.b + ", isPaused=" + this.c + ", progress=" + this.d + ')';
    }

    public g(boolean r1, boolean r2, boolean r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public /* synthetic */ g(boolean r3, boolean r4, boolean r5, float r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 0.0f;
    L14:
        this(r3, r4, r5, r6);
    }
}
