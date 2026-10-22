package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i0 implements ScalingUtils.ScaleType {
    public static final i0 e = null;

    public i0() {
    }

    static {
        e = new i0();
    }

    public final String toString() {
        u7a.m.b.c.getClass();
        return "center";
    }

    public final Matrix getTransform(Matrix r1, Rect r2, int r3, int r4, float r5, float r6) {
        u7a.m.b.c.a(r1, r2, r3, r4);
        return r1;
    }
}
