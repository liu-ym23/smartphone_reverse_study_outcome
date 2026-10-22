package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class FullScreenCarouselStrategy extends CarouselStrategy {
    public FullScreenCarouselStrategy() {
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel r13, @NonNull View r14) {
        RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        if (r13.isHorizontal() == false) goto L6;
        float r15 = r13.getContainerWidth();
        int r5 = ((ViewGroup.MarginLayoutParams) r12).leftMargin;
        int r16 = ((ViewGroup.MarginLayoutParams) r12).rightMargin;
    L5:
        float r17 = r5 + r16;
        return CarouselStrategyHelper.createLeftAlignedKeylineState(r14.getContext(), r17, r15, new Arrangement(0, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, Math.min(r15 + r17, r15), 1, r15));
    L6:
        r15 = r13.getContainerHeight();
        r5 = ((ViewGroup.MarginLayoutParams) r12).topMargin;
        r16 = ((ViewGroup.MarginLayoutParams) r12).bottomMargin;
        goto L5
    }
}
