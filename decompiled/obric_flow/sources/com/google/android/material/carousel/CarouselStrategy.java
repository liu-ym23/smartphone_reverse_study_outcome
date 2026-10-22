package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CarouselStrategy {
    private float smallSizeMax;
    private float smallSizeMin;

    public CarouselStrategy() {
    }

    public static int[] doubleCounts(int[] r5) {
        int r10 = r5.length;
        int[] r11 = new int[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = r5[r12] * 2;
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public static float getChildMaskPercentage(float r5, float r10, float r11) {
        return 1.0f - ((r5 - r11) / (r10 - r11));
    }

    public float getSmallItemSizeMax() {
        return this.smallSizeMax;
    }

    public float getSmallItemSizeMin() {
        return this.smallSizeMin;
    }

    public void initialize(Context r5) {
        float r10 = this.smallSizeMin;
        if (r10 > 0.0f) goto L6;
        r10 = CarouselStrategyHelper.getSmallSizeMin(r5);
    L6:
        this.smallSizeMin = r10;
        float r11 = this.smallSizeMax;
        if (r11 > 0.0f) goto L10;
        r11 = CarouselStrategyHelper.getSmallSizeMax(r5);
    L10:
        this.smallSizeMax = r11;
    }

    public boolean isContained() {
        return true;
    }

    public abstract KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel r5, @NonNull View r10);

    public void setSmallItemSizeMax(float r5) {
        this.smallSizeMax = r5;
    }

    public void setSmallItemSizeMin(float r5) {
        this.smallSizeMin = r5;
    }

    public boolean shouldRefreshKeylineState(Carousel r5, int r10) {
        return false;
    }
}
