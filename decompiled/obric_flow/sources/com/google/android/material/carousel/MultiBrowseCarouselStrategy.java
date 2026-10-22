package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = null;
    private static final int[] SMALL_COUNTS = null;
    private int keylineCount;

    static {
        SMALL_COUNTS = new int[]{1};
        MEDIUM_COUNTS = new int[]{1, 0};
    }

    public MultiBrowseCarouselStrategy() {
        this.keylineCount = 0;
    }

    public boolean ensureArrangementFitsItemCount(Arrangement r5, int r10) {
        int r11 = r5.getItemCount() - r10;
        if (r11 > 0) goto L5;
    L9:
        boolean r12 = false;
    L10:
        if (r11 <= 0) goto L18;
        int r13 = r5.smallCount;
        if (r13 <= 0) goto L14;
        r5.smallCount = r13 - 1;
    L17:
        r11 = r11 - 1;
        goto L10
    L14:
        int r14 = r5.mediumCount;
        if (r14 <= 1) goto L17;
        r5.mediumCount = r14 - 1;
        goto L17
    L18:
        return r12;
    L5:
        if (r5.smallCount <= 0) goto L7;
    L8:
        r12 = true;
        goto L10
    L7:
        if (r5.mediumCount <= 1) goto L9;
        goto L8
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel r18, @NonNull View r19) {
        float r5 = r18.getContainerHeight();
        if (r18.isHorizontal() == false) goto L5;
        r5 = r18.getContainerWidth();
    L5:
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r19.getLayoutParams();
        float r11 = ((ViewGroup.MarginLayoutParams) r10).topMargin + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
        float r12 = r19.getMeasuredHeight();
        if (r18.isHorizontal() == false) goto L8;
        r11 = ((ViewGroup.MarginLayoutParams) r10).leftMargin + ((ViewGroup.MarginLayoutParams) r10).rightMargin;
        r12 = r19.getMeasuredWidth();
    L8:
        float r13 = r11;
        float r14 = getSmallItemSizeMin() + r13;
        float r15 = Math.max(getSmallItemSizeMax() + r13, r14);
        float r16 = Math.min(r12 + r13, r5);
        float r17 = MathUtils.clamp((r12 / 3.0f) + r13, r14 + r13, r15 + r13);
        float r110 = (r16 + r17) / 2.0f;
        int[] r20 = SMALL_COUNTS;
        int r21 = 0;
        if (r5 >= (2.0f * r14)) goto L11;
        r20 = new int[]{0};
    L11:
        int[] r22 = MEDIUM_COUNTS;
        if (r18.getCarouselAlignment() != 1) goto L14;
        r20 = CarouselStrategy.doubleCounts(r20);
        r22 = CarouselStrategy.doubleCounts(r22);
    L14:
        int[] r23 = r20;
        int[] r24 = r22;
        int r25 = (int) Math.max(1.0d, Math.floor(((r5 - (CarouselStrategyHelper.maxValue(r24) * r110)) - (CarouselStrategyHelper.maxValue(r23) * r15)) / r16));
        int r26 = (int) Math.ceil(r5 / r16);
        int r27 = (r26 - r25) + 1;
        int[] r111 = new int[r27];
    L15:
        if (r21 >= r27) goto L17;
        r111[r21] = r26 - r21;
        r21 = r21 + 1;
        goto L15
    L17:
        Arrangement r28 = Arrangement.findLowestCostArrangement(r5, r17, r14, r15, r23, r110, r24, r16, r111);
        this.keylineCount = r28.getItemCount();
        if (ensureArrangementFitsItemCount(r28, r18.getItemCount()) == false) goto L21;
        r28 = Arrangement.findLowestCostArrangement(r5, r17, r14, r15, new int[]{r28.smallCount}, r110, new int[]{r28.mediumCount}, r16, new int[]{r28.largeCount});
    L21:
        return CarouselStrategyHelper.createKeylineState(r19.getContext(), r13, r5, r28, r18.getCarouselAlignment());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(Carousel r5, int r10) {
        if (r10 >= this.keylineCount) goto L7;
        if (r5.getItemCount() < this.keylineCount) goto L7;
    L10:
        return true;
    L7:
        if (r10 >= this.keylineCount) goto L9;
    L11:
        return false;
    L9:
        if (r5.getItemCount() >= this.keylineCount) goto L11;
        goto L10
    }
}
