package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    public static float addEnd(float r5, float r10, int r11) {
        return (Math.max(0, r11 - 1) * r10) + r5;
    }

    public static float addStart(float r5, float r10, int r11) {
        if (r11 > 0) goto L4;
        return r5;
    L4:
        return (r10 / 2.0f) + r5;
    }

    public static KeylineState createCenterAlignedKeylineState(@NonNull Context r19, float r20, float r21, @NonNull Arrangement r22) {
        float r5 = Math.min(getExtraSmallSize(r19) + r20, r22.largeSize);
        float r10 = r5 / 2.0f;
        float r11 = 0.0f - r10;
        float r12 = addStart(0.0f, r22.smallSize, r22.smallCount);
        float r13 = updateCurPosition(0.0f, addEnd(r12, r22.smallSize, (int) Math.floor(r22.smallCount / 2.0f)), r22.smallSize, r22.smallCount);
        float r14 = addStart(r13, r22.mediumSize, r22.mediumCount);
        float r15 = updateCurPosition(r13, addEnd(r14, r22.mediumSize, (int) Math.floor(r22.mediumCount / 2.0f)), r22.mediumSize, r22.mediumCount);
        float r16 = addStart(r15, r22.largeSize, r22.largeCount);
        float r17 = updateCurPosition(r15, addEnd(r16, r22.largeSize, r22.largeCount), r22.largeSize, r22.largeCount);
        float r18 = addStart(r17, r22.mediumSize, r22.mediumCount);
        float r23 = addStart(updateCurPosition(r17, addEnd(r18, r22.mediumSize, (int) Math.ceil(r22.mediumCount / 2.0f)), r22.mediumSize, r22.mediumCount), r22.smallSize, r22.smallCount);
        float r24 = r10 + r21;
        float r110 = CarouselStrategy.getChildMaskPercentage(r5, r22.largeSize, r20);
        float r111 = CarouselStrategy.getChildMaskPercentage(r22.smallSize, r22.largeSize, r20);
        float r25 = CarouselStrategy.getChildMaskPercentage(r22.mediumSize, r22.largeSize, r20);
        KeylineState.Builder r26 = new KeylineState.Builder(r22.largeSize, r21).addAnchorKeyline(r11, r110, r5);
        int r27 = r22.smallCount;
        if (r27 <= 0) goto L6;
        r26.addKeylineRange(r12, r111, r22.smallSize, (int) Math.floor(r27 / 2.0f));
    L6:
        int r28 = r22.mediumCount;
        if (r28 <= 0) goto L9;
        r26.addKeylineRange(r14, r25, r22.mediumSize, (int) Math.floor(r28 / 2.0f));
    L9:
        r26.addKeylineRange(r16, 0.0f, r22.largeSize, r22.largeCount, true);
        int r29 = r22.mediumCount;
        if (r29 <= 0) goto L12;
        float r30 = 2.0f;
        r26.addKeylineRange(r18, r25, r22.mediumSize, (int) Math.ceil(r29 / 2.0f));
    L13:
        int r31 = r22.smallCount;
        if (r31 <= 0) goto L16;
        r26.addKeylineRange(r23, r111, r22.smallSize, (int) Math.ceil(r31 / r30));
    L16:
        r26.addAnchorKeyline(r24, r110, r5);
        return r26.build();
    L12:
        r30 = 2.0f;
        goto L13
    }

    public static KeylineState createKeylineState(@NonNull Context r5, float r10, float r11, @NonNull Arrangement r12, int r13) {
        if (r13 != 1) goto L7;
        return createCenterAlignedKeylineState(r5, r10, r11, r12);
    L7:
        return createLeftAlignedKeylineState(r5, r10, r11, r12);
    }

    public static KeylineState createLeftAlignedKeylineState(@NonNull Context r12, float r13, float r14, @NonNull Arrangement r15) {
        float r16 = Math.min(getExtraSmallSize(r12) + r13, r15.largeSize);
        float r5 = r16 / 2.0f;
        float r10 = 0.0f - r5;
        float r11 = addStart(0.0f, r15.largeSize, r15.largeCount);
        float r17 = updateCurPosition(0.0f, addEnd(r11, r15.largeSize, r15.largeCount), r15.largeSize, r15.largeCount);
        float r18 = addStart(r17, r15.mediumSize, r15.mediumCount);
        float r19 = addStart(updateCurPosition(r17, r18, r15.mediumSize, r15.mediumCount), r15.smallSize, r15.smallCount);
        float r20 = r5 + r14;
        float r21 = CarouselStrategy.getChildMaskPercentage(r16, r15.largeSize, r13);
        float r110 = CarouselStrategy.getChildMaskPercentage(r15.smallSize, r15.largeSize, r13);
        float r111 = CarouselStrategy.getChildMaskPercentage(r15.mediumSize, r15.largeSize, r13);
        KeylineState.Builder r112 = new KeylineState.Builder(r15.largeSize, r14).addAnchorKeyline(r10, r21, r16).addKeylineRange(r11, 0.0f, r15.largeSize, r15.largeCount, true);
        if (r15.mediumCount <= 0) goto L5;
        r112.addKeyline(r18, r111, r15.mediumSize);
    L5:
        int r113 = r15.smallCount;
        if (r113 <= 0) goto L8;
        r112.addKeylineRange(r19, r110, r15.smallSize, r113);
    L8:
        r112.addAnchorKeyline(r20, r21, r16);
        return r112.build();
    }

    public static float getExtraSmallSize(@NonNull Context r5) {
        return r5.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    public static float getSmallSizeMax(@NonNull Context r5) {
        return r5.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    public static float getSmallSizeMin(@NonNull Context r5) {
        return r5.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    public static int maxValue(int[] r5) {
        int r10 = r5.length;
        int r11 = Integer.MIN_VALUE;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L8;
        int r13 = r5[r12];
        if (r13 <= r11) goto L7;
        r11 = r13;
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r11;
    }

    public static float updateCurPosition(float r5, float r10, float r11, int r12) {
        if (r12 > 0) goto L4;
        return r5;
    L4:
        return (r11 / 2.0f) + r10;
    }
}
