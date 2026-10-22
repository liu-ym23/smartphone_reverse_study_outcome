package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final int a;
    public final float b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "DanmakuWaitMessageState(commentSize=" + this.a + ", commentHotRate=" + this.b + ")";
    }

    public /* synthetic */ a(int r2) {
        this(0, 0.0f);
    }

    public a(int r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
