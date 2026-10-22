package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes2.dex */
class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static final float FADE_THRESHOLD = 0.5f;

    public FadeTabIndicatorInterpolator() {
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    public void updateIndicatorForOffset(TabLayout r5, View r10, View r11, float r12, @NonNull Drawable r13) {
        if (r12 < 0.5f) goto L6;
        r10 = r11;
    L6:
        RectF r14 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(r5, r10);
        if (r12 >= 0.5f) goto L9;
        float r15 = AnimationUtils.lerp(1.0f, 0.0f, 0.0f, 0.5f, r12);
    L10:
        r13.setBounds((int) r14.left, r13.getBounds().top, (int) r14.right, r13.getBounds().bottom);
        r13.setAlpha((int) (r15 * 255.0f));
        return;
    L9:
        r15 = AnimationUtils.lerp(0.0f, 1.0f, 0.5f, 1.0f, r12);
        goto L10
    }
}
