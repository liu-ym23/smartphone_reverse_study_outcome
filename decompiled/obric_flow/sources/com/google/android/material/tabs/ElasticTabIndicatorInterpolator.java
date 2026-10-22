package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes2.dex */
class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    public ElasticTabIndicatorInterpolator() {
    }

    private static float accInterp(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        return (float) (1.0d - Math.cos((((double) r5) * 3.141592653589793d) / 2.0d));
    }

    private static float decInterp(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        return (float) Math.sin((((double) r5) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public void updateIndicatorForOffset(TabLayout r5, View r10, View r11, float r12, @NonNull Drawable r13) {
        RectF r14 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(r5, r10);
        RectF r15 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(r5, r11);
        if (r14.left >= r15.left) goto L5;
        float r16 = accInterp(r12);
        float r17 = decInterp(r12);
    L6:
        r13.setBounds(AnimationUtils.lerp((int) r14.left, (int) r15.left, r16), r13.getBounds().top, AnimationUtils.lerp((int) r14.right, (int) r15.right, r17), r13.getBounds().bottom);
        return;
    L5:
        r16 = decInterp(r12);
        r17 = accInterp(r12);
        goto L6
    }
}
