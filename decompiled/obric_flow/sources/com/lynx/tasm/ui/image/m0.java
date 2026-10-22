package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements ScalingUtils.ScaleType {
    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14) {
        float r15 = r10.width() / r11;
        float r16 = r10.height() / r12;
        float r17 = Math.max(r15, r16);
        float r18 = r10.left;
        float r19 = r10.top;
        if (r15 <= r16) goto L5;
        r5.postTranslate(r18, 0.0f);
    L6:
        r5.setScale(r17, r17);
        return r5;
    L5:
        r5.postTranslate(0.0f, r19);
        goto L6
    }
}
