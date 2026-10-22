package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
abstract class CarouselOrientationHelper {
    final int orientation;

    public /* synthetic */ CarouselOrientationHelper(int r5, AnonymousClass1 r10) {
        this(r5);
    }

    private static CarouselOrientationHelper createHorizontalHelper(final CarouselLayoutManager r5) {
        final int r10 = 0;
        return new AnonymousClass2(r10, r5);
    }

    public static CarouselOrientationHelper createOrientationHelper(CarouselLayoutManager r5, int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return createVerticalHelper(r5);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return createHorizontalHelper(r5);
    }

    private static CarouselOrientationHelper createVerticalHelper(final CarouselLayoutManager r5) {
        final int r10 = 1;
        return new AnonymousClass1(r10, r5);
    }

    public abstract void containMaskWithinBounds(RectF r5, RectF r10, RectF r11);

    public abstract int getDecoratedCrossAxisMeasurement(View r5);

    public abstract float getMaskMargins(RecyclerView.LayoutParams r5);

    public abstract RectF getMaskRect(float r5, float r10, float r11, float r12);

    public abstract int getParentBottom();

    public abstract int getParentEnd();

    public abstract int getParentLeft();

    public abstract int getParentRight();

    public abstract int getParentStart();

    public abstract int getParentTop();

    public abstract void layoutDecoratedWithMargins(View r5, int r10, int r11);

    public abstract void moveMaskOnEdgeOutsideBounds(RectF r5, RectF r10, RectF r11);

    public abstract void offsetChild(View r5, Rect r10, float r11, float r12);

    private CarouselOrientationHelper(int r5) {
        this.orientation = r5;
    }
}
