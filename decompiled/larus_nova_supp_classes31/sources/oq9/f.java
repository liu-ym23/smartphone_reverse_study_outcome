package oq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final int d;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.d;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CameraRecordFeatureConfig(enableTips=" + this.a + ", recordMaxDuration=" + this.b + ", enablePreviewRatio3to4=" + this.c + ", longPressDurationMs=" + this.d + ')';
    }

    public /* synthetic */ f(int r3) {
        this(false, 60, false, 300);
    }

    public f(boolean r1, int r2, boolean r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
