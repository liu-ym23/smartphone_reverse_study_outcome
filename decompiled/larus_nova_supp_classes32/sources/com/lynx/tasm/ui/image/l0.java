package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l0 implements ScalingUtils.ScaleType {
    public static final l0 e = null;

    public l0() {
    }

    static {
        e = new l0();
    }

    public final String toString() {
        u7a.m.b.a.getClass();
        return "fit_xy";
    }

    public final Matrix getTransform(Matrix r1, Rect r2, int r3, int r4, float r5, float r6) {
        u7a.m.b.a.a(r1, r2, r3, r4);
        return r1;
    }
}
