package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final Bitmap a;
    public final g b;
    public final Map<String, Object> c;

    public f() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DetectionContext(bitmap=" + this.a + ", detectionStatus=" + this.b + ", extras=" + this.c + ')';
    }

    public f(Bitmap r10, g r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "detectionStatus");
        Intrinsics.checkNotNullParameter(r0, "extras");
        this.a = r10;
        this.b = r11;
        this.c = r0;
    }
}
