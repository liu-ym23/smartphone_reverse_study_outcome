package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 implements ScalingUtils.ScaleType {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final z0 f11150j = null;

    static {
        f11150j = new z0();
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14) {
        float r15 = r10.width();
        float r16 = r10.left;
        float r17 = r10.top;
        r5.setScale(r15 / r11, r10.height() / r12);
        r5.postTranslate(r16, r17);
        return r5;
    }

    public final String toString() {
        return "fit_xy";
    }
}
