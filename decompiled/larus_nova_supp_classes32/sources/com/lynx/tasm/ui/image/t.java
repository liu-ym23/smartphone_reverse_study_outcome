package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t implements ScalingUtils.ScaleType {
    public t() {
    }

    public final Matrix getTransform(Matrix r2, Rect r3, int r4, int r5, float r6, float r7) {
        float r8 = r3.width() / r4;
        float r9 = r3.height() / r5;
        float r10 = Math.max(r8, r9);
        float r11 = r3.left;
        float r12 = r3.top;
        if (r8 <= r9) goto L5;
        r2.postTranslate(r11, 0.0f);
    L6:
        r2.setScale(r10, r10);
        return r2;
    L5:
        r2.postTranslate(0.0f, r12);
        goto L6
    }
}
