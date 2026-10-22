package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes2.dex */
class TabIndicatorInterpolator {

    @Dimension(unit = 0)
    private static final int MIN_INDICATOR_WIDTH = 24;

    public TabIndicatorInterpolator() {
    }

    public static RectF calculateIndicatorWidthForTab(TabLayout r5, @Nullable View r10) {
        if (r10 != null) goto L6;
        return new RectF();
    L6:
        if (r5.isTabIndicatorFullWidth() == true) goto L12;
        if ((r10 instanceof TabLayout.TabView) == false) goto L12;
        return calculateTabViewContentBounds((TabLayout.TabView) r10, 24);
    L12:
        return new RectF(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    }

    public static RectF calculateTabViewContentBounds(@NonNull TabLayout.TabView r5, @Dimension(unit = 0) int r10) {
        int r11 = r5.getContentWidth();
        int r12 = r5.getContentHeight();
        int r13 = (int) ViewUtils.dpToPx(r5.getContext(), r10);
        if (r11 >= r13) goto L5;
        r11 = r13;
    L5:
        int r14 = (r5.getRight() + r5.getLeft()) / 2;
        int r15 = (r5.getBottom() + r5.getTop()) / 2;
        int r16 = r11 / 2;
        return new RectF(r14 - r16, r15 - (r12 / 2), r16 + r14, (r14 / 2) + r15);
    }

    public void setIndicatorBoundsForTab(TabLayout r5, View r10, @NonNull Drawable r11) {
        RectF r12 = calculateIndicatorWidthForTab(r5, r10);
        r11.setBounds((int) r12.left, r11.getBounds().top, (int) r12.right, r11.getBounds().bottom);
    }

    public void updateIndicatorForOffset(TabLayout r5, View r10, View r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12, @NonNull Drawable r13) {
        RectF r14 = calculateIndicatorWidthForTab(r5, r10);
        RectF r15 = calculateIndicatorWidthForTab(r5, r11);
        r13.setBounds(AnimationUtils.lerp((int) r14.left, (int) r15.left, r12), r13.getBounds().top, AnimationUtils.lerp((int) r14.right, (int) r15.right, r12), r13.getBounds().bottom);
    }
}
