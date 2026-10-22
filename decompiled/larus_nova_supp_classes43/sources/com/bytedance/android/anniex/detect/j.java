package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final WeakReference<View> a;
    public Bitmap b;
    public final l c;
    public final Map<String, Object> d;

    public j() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Bitmap r1 = this.b;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((((r0 + r10) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "SnapShotContext(view=" + this.a + ", bitmap=" + this.b + ", SnapShotStats=" + this.c + ", extras=" + this.d + ')';
    }

    public j(WeakReference r10) {
        l r0 = new l();
        LinkedHashMap r1 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r0, "SnapShotStats");
        Intrinsics.checkNotNullParameter(r1, "extras");
        this.a = r10;
        this.b = null;
        this.c = r0;
        this.d = r1;
    }
}
