package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 implements ScalingUtils.ScaleType {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final w0 f11143j = null;

    static {
        f11143j = new w0();
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix a(Matrix r5, Rect r10, int r11, int r12, float r13, float r14) {
        float r15 = r10.width();
        float r16 = r10.height();
        float r17 = com.lynx.tasm.utils.g.a(1.0f, 0.0f);
        float r18 = Math.round((r15 - (r11 * r17)) * 0.5f);
        float r19 = Math.round((r16 - (r12 * r17)) * 0.5f);
        r5.setScale(r17, r17);
        r5.postTranslate(r18, r19);
        return r5;
    }

    public final String toString() {
        return "center";
    }
}
