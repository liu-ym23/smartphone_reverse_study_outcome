package com.bytedance.android.live.revlink.impl.multianchor.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements d {
    public final int a;
    public final int b;
    public final int c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L12;
        e r4 = (e) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "FloatOffsetFromBaseLine(wholeHeight=" + this.a + ", redBlueBarHeight=" + this.b + ", floatDistanceFromBase=" + this.c + ")";
    }

    public e(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
