package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UncontainedCarouselStrategy() {
    }

    private float calculateMediumChildSize(float r5, float r10, float r11) {
        float r12 = Math.max(1.5f * r11, r5);
        float r13 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * r10;
        if (r12 <= r13) goto L6;
        r12 = Math.max(r13, r11 * 1.2f);
    L6:
        return Math.min(r10, r12);
    }

    private KeylineState createCenterAlignedKeylineState(float r16, float r17, float r18, int r19, float r20, float r21, float r22) {
        float r10 = Math.min(r21, r18);
        float r11 = CarouselStrategy.getChildMaskPercentage(r10, r18, r17);
        float r12 = CarouselStrategy.getChildMaskPercentage(r20, r18, r17);
        float r13 = r20 / 2.0f;
        float r5 = (r22 + 0.0f) - r13;
        float r14 = r5 + r13;
        float r15 = r10 / 2.0f;
        float r110 = (r19 * r18) + r14;
        KeylineState.Builder r23 = new KeylineState.Builder(r18, r16).addAnchorKeyline((r5 - r13) - r15, r11, r10).addKeyline(r5, r12, r20, false).addKeylineRange((r18 / 2.0f) + r14, 0.0f, r18, r19, true);
        r23.addKeyline(r13 + r110, r12, r20, false);
        r23.addAnchorKeyline((r110 + r20) + r15, r11, r10);
        return r23.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context r15, float r16, float r17, float r18, int r19, float r20, int r21, float r22) {
        float r10 = Math.min(r22, r18);
        float r5 = Math.max(r10, 0.5f * r20);
        float r11 = CarouselStrategy.getChildMaskPercentage(r5, r18, r16);
        float r12 = CarouselStrategy.getChildMaskPercentage(r10, r18, r16);
        float r13 = CarouselStrategy.getChildMaskPercentage(r20, r18, r16);
        float r14 = (r19 * r18) + 0.0f;
        KeylineState.Builder r23 = new KeylineState.Builder(r18, r17).addAnchorKeyline(0.0f - (r5 / 2.0f), r11, r5).addKeylineRange(r18 / 2.0f, 0.0f, r18, r19, true);
        if (r21 <= 0) goto L5;
        float r24 = (r20 / 2.0f) + r14;
        r14 = r14 + r20;
        r23.addKeyline(r24, r13, r20, false);
    L5:
        r23.addAnchorKeyline((CarouselStrategyHelper.getExtraSmallSize(r15) / 2.0f) + r14, r12, r10);
        return r23.build();
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean isContained() {
        return false;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel r11, @NonNull View r12) {
        if (r11.isHorizontal() == false) goto L6;
        int r5 = r11.getContainerWidth();
    L5:
        float r10 = r5;
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r12.getLayoutParams();
        float r14 = ((ViewGroup.MarginLayoutParams) r13).topMargin + ((ViewGroup.MarginLayoutParams) r13).bottomMargin;
        float r15 = r12.getMeasuredHeight();
        if (r11.isHorizontal() == false) goto L10;
        float r16 = ((ViewGroup.MarginLayoutParams) r13).leftMargin + ((ViewGroup.MarginLayoutParams) r13).rightMargin;
        r15 = r12.getMeasuredWidth();
        float r17 = r16;
    L11:
        float r18 = r15 + r17;
        float r19 = CarouselStrategyHelper.getExtraSmallSize(r12.getContext()) + r17;
        float r20 = CarouselStrategyHelper.getExtraSmallSize(r12.getContext()) + r17;
        int r21 = Math.max(1, (int) Math.floor(r10 / r18));
        float r22 = r10 - (r21 * r18);
        if (r11.getCarouselAlignment() != 1) goto L16;
        float r23 = r22 / 2.0f;
        return createCenterAlignedKeylineState(r10, r17, r18, r21, Math.max(Math.min(3.0f * r23, r18), getSmallItemSizeMin() + r17), r20, r23);
    L16:
        if (r22 <= 0.0f) goto L18;
        int r24 = 1;
    L20:
        return createLeftAlignedKeylineState(r12.getContext(), r17, r10, r18, r21, calculateMediumChildSize(r19, r18, r22), r24, r20);
    L18:
        r24 = 0;
        goto L20
    L10:
        r17 = r14;
        goto L11
    L6:
        r5 = r11.getContainerHeight();
        goto L5
    }
}
