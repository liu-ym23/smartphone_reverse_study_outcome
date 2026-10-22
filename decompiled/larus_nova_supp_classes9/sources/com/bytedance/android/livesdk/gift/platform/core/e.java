package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final float a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Float.compare(this.a, ((e) r2).a) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.a);
    }

    public final String toString() {
        return "DirSize(appassetsSize=" + this.a + ")";
    }

    public e(float r1) {
        this.a = r1;
    }
}
