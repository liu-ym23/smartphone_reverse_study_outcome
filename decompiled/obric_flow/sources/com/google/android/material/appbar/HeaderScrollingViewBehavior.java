package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap;

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    private static int resolveGravity(int r5) {
        if (r5 != 0) goto L5;
        return 8388659;
    L5:
        return r5;
    }

    @Nullable
    public abstract View findFirstDependency(List<View> r5);

    public final int getOverlapPixelsForOffset(View r5) {
        if (this.overlayTop == 0) goto L7;
        float r10 = getOverlapRatioForOffset(r5);
        int r11 = this.overlayTop;
        return MathUtils.clamp((int) (r10 * r11), 0, r11);
    L7:
        return 0;
    }

    public float getOverlapRatioForOffset(View r5) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    public int getScrollRange(@NonNull View r5) {
        return r5.getMeasuredHeight();
    }

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void layoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
        View r5 = findFirstDependency(r10.getDependencies(r11));
        if (r5 == null) goto L12;
        CoordinatorLayout.LayoutParams r13 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
        Rect r14 = this.tempRect1;
        r14.set(r10.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r13).leftMargin, r5.getBottom() + ((ViewGroup.MarginLayoutParams) r13).topMargin, (r10.getWidth() - r10.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r13).rightMargin, ((r5.getBottom() + r10.getHeight()) - r10.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r13).bottomMargin);
        WindowInsetsCompat r15 = r10.getLastWindowInsets();
        if (r15 != null) goto L7;
    L11:
        Rect r16 = this.tempRect2;
        GravityCompat.apply(resolveGravity(r13.gravity), r11.getMeasuredWidth(), r11.getMeasuredHeight(), r14, r16, r12);
        int r17 = getOverlapPixelsForOffset(r5);
        r11.layout(r16.left, r16.top - r17, r16.right, r16.bottom - r17);
        this.verticalLayoutGap = r16.top - r5.getBottom();
        return;
    L7:
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L11;
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L11;
        r14.left = r15.getSystemWindowInsetLeft() + r14.left;
        r14.right -= r15.getSystemWindowInsetRight();
        goto L11
    L12:
        super.layoutChild(r10, r11, r12);
        this.verticalLayoutGap = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
        int r5 = r11.getLayoutParams().height;
        if (r5 != (-1)) goto L5;
    L6:
        View r16 = findFirstDependency(r10.getDependencies(r11));
        if (r16 == null) goto L27;
        int r17 = View.MeasureSpec.getSize(r14);
        if (r17 > 0) goto L11;
        r17 = r10.getHeight();
    L16:
        int r18 = r17 + getScrollRange(r16);
        int r19 = r16.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild() == false) goto L19;
        r11.setTranslationY(-r19);
    L20:
        if (r5 != (-1)) goto L22;
        int r20 = BasicMeasure.EXACTLY;
    L23:
        r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(r18, r20), r15);
        return true;
    L22:
        r20 = Integer.MIN_VALUE;
        goto L23
    L19:
        r11.setTranslationY(0.0f);
        r18 = r18 - r19;
        goto L20
    L11:
        if (ViewCompat.getFitsSystemWindows(r16) == false) goto L16;
        WindowInsetsCompat r21 = r10.getLastWindowInsets();
        if (r21 == null) goto L16;
        r17 = r17 + (r21.getSystemWindowInsetBottom() + r21.getSystemWindowInsetTop());
        goto L16
    L27:
        return false;
    L5:
        if (r5 == (-2)) goto L6;
        return false;
    }

    public final void setOverlayTop(int r5) {
        this.overlayTop = r5;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }
}
