package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m1 {
    public final int a;
    public final Bitmap b;
    public final String c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof m1) == false) goto L12;
        m1 r11 = (m1) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Bitmap r1 = this.b;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.c;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "SequenceBitmap(index=" + this.a + ", bitmap=" + this.b + ", url=" + this.c + ")";
    }

    public m1(int r10, Bitmap r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "bitmap");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
