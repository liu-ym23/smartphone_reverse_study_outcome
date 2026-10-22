package com.bytedance.android.anniex.detect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public final boolean a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k) == true) goto L8;
        return false;
    L8:
        k r11 = (k) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r10 = this.b;
        if (r10 != null) goto L9;
        int r11 = 0;
    L11:
        return r1 + r11;
    L9:
        r11 = r10.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SnapShotResult(isSuccess=" + this.a + ", errorMsg=" + this.b + ')';
    }

    public k(boolean r1, String r10) {
        this.a = r1;
        this.b = r10;
    }
}
