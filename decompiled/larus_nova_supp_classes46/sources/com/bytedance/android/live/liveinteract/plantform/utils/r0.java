package com.bytedance.android.live.liveinteract.plantform.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r0 {
    public final int a;
    public final int b;

    public r0() {
        this(0, 0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r0) == false) goto L10;
        r0 r4 = (r0) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "SwitchSceneSourceMapKey(scene=" + this.a + ", layout=" + this.b + ")";
    }

    public r0(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
