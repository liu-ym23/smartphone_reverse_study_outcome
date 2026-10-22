package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 implements ScalingUtils.ScaleType {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y0 f11148j = null;

    static {
        f11148j = new y0();
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14) {
        float r15 = r10.width();
        float r16 = r10.height();
        float r17 = r11;
        float r18 = r12;
        float r19 = r10.left;
        float r20 = r10.top;
        float r21 = r15 / r17;
        float r22 = r16 / r18;
        if (r21 <= r22) goto L5;
        r5.setScale(r22, r22);
        r5.postTranslate(((r15 - (r17 * r22)) / 2.0f) + r19, r20);
    L6:
        return r5;
    L5:
        r5.setScale(r21, r21);
        r5.postTranslate(r19, ((r16 - (r18 * r21)) / 2.0f) + r20);
        goto L6
    }

    public final String toString() {
        return "fit_center";
    }
}
