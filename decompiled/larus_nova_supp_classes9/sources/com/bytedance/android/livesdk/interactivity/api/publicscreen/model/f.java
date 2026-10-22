package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public f() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L18;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r4.e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f, r4.f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f);
    }

    public final String toString() {
        return "PublicScreenWaitMessageState(size=" + this.a + ", commentSize=" + this.b + ", commentHotRate=" + this.c + ", commentFansRate=" + this.d + ", commentLongRate=" + this.e + ", commentMeanLength=" + this.f + ")";
    }

    public /* synthetic */ f(int r8) {
        this(0, 0, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public f(int r1, int r2, float r3, float r4, float r5, float r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
