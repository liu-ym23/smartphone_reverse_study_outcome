package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = null;
    private static final int[] SMALL_COUNTS = null;
    private int keylineCount;

    static {
        SMALL_COUNTS = new int[]{1};
        MEDIUM_COUNTS = new int[]{0, 1};
    }

    public HeroCarouselStrategy() {
        this.keylineCount = 0;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel r21, @NonNull View r22) {
        int r5 = r21.getContainerHeight();
        if (r21.isHorizontal() == false) goto L5;
        r5 = r21.getContainerWidth();
    L5:
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r22.getLayoutParams();
        float r11 = ((ViewGroup.MarginLayoutParams) r10).topMargin + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
        float r12 = r22.getMeasuredWidth() * 2;
        if (r21.isHorizontal() == false) goto L8;
        r11 = ((ViewGroup.MarginLayoutParams) r10).leftMargin + ((ViewGroup.MarginLayoutParams) r10).rightMargin;
        r12 = r22.getMeasuredHeight() * 2;
    L8:
        float r13 = getSmallItemSizeMin() + r11;
        float r14 = Math.max(getSmallItemSizeMax() + r11, r13);
        float r15 = r5;
        float r16 = Math.min(r12 + r11, r15);
        float r17 = MathUtils.clamp((r12 / 3.0f) + r11, r13 + r11, r14 + r11);
        float r18 = (r16 + r17) / 2.0f;
        int[] r19 = SMALL_COUNTS;
        if (r15 >= (2.0f * r13)) goto L11;
        int[] r110 = {0};
    L12:
        int r20 = (int) Math.max(1.0d, Math.floor((r15 - (CarouselStrategyHelper.maxValue(r19) * r14)) / r16));
        int r23 = (((int) Math.ceil(r15 / r16)) - r20) + 1;
        int[] r111 = new int[r23];
        int r24 = 0;
    L13:
        if (r24 >= r23) goto L16;
        r111[r24] = r20 + r24;
        r24 = r24 + 1;
        goto L13
    L16:
        if (r21.getCarouselAlignment() != 1) goto L18;
        int r112 = 1;
    L19:
        if (r112 == 0) goto L21;
        int[] r25 = CarouselStrategy.doubleCounts(r110);
    L22:
        if (r112 == 0) goto L25;
        int[] r26 = CarouselStrategy.doubleCounts(MEDIUM_COUNTS);
    L26:
        Arrangement r27 = Arrangement.findLowestCostArrangement(r15, r17, r13, r14, r25, r18, r26, r16, r111);
        this.keylineCount = r27.getItemCount();
        if (r27.getItemCount() <= r21.getItemCount()) goto L29;
        r27 = Arrangement.findLowestCostArrangement(r15, r17, r13, r14, r110, r18, MEDIUM_COUNTS, r16, r111);
        int r28 = 0;
    L31:
        return CarouselStrategyHelper.createKeylineState(r22.getContext(), r11, r15, r27, r28);
    L29:
        r28 = r112;
        goto L31
    L25:
        r26 = MEDIUM_COUNTS;
        goto L26
    L21:
        r25 = r110;
        goto L22
    L18:
        r112 = 0;
        goto L19
    L11:
        r110 = r19;
        goto L12
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel r5, int r10) {
        if (r5.getCarouselAlignment() == 1) goto L5;
    L13:
        return false;
    L5:
        if (r10 >= this.keylineCount) goto L9;
        if (r5.getItemCount() < this.keylineCount) goto L9;
        return true;
    L9:
        if (r10 < this.keylineCount) goto L13;
        if (r5.getItemCount() >= this.keylineCount) goto L13;
        return true;
    }
}
