package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

    public HeaderScrollingViewBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    private static int resolveGravity(int r10) {
        if (r10 != 0) goto L5;
        return MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
    L5:
        return r10;
    }

    @Nullable
    abstract View findFirstDependency(List<View> r10);

    final int getOverlapPixelsForOffset(View r10) {
        if (this.overlayTop == 0) goto L7;
        float r11 = getOverlapRatioForOffset(r10);
        int r12 = this.overlayTop;
        return MathUtils.clamp((int) (r11 * r12), 0, r12);
    L7:
        return 0;
    }

    float getOverlapRatioForOffset(View r10) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    int getScrollRange(@NonNull View r10) {
        return r10.getMeasuredHeight();
    }

    final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void layoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
        View r13 = findFirstDependency(r10.getDependencies(r11));
        if (r13 == null) goto L12;
        CoordinatorLayout.LayoutParams r14 = (CoordinatorLayout.LayoutParams) r11.getLayoutParams();
        Rect r15 = this.tempRect1;
        r15.set(r10.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r14).leftMargin, r13.getBottom() + ((ViewGroup.MarginLayoutParams) r14).topMargin, (r10.getWidth() - r10.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r14).rightMargin, ((r10.getHeight() + r13.getBottom()) - r10.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r14).bottomMargin);
        WindowInsetsCompat r16 = r10.getLastWindowInsets();
        if (r16 != null) goto L7;
    L11:
        Rect r17 = this.tempRect2;
        GravityCompat.apply(resolveGravity(r14.gravity), r11.getMeasuredWidth(), r11.getMeasuredHeight(), r15, r17, r12);
        int r18 = getOverlapPixelsForOffset(r13);
        r11.layout(r17.left, r17.top - r18, r17.right, r17.bottom - r18);
        int r19 = r17.top - r13.getBottom();
    L13:
        this.verticalLayoutGap = r19;
        return;
    L7:
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L11;
        if (ViewCompat.getFitsSystemWindows(r11) == true) goto L11;
        r15.left += r16.getSystemWindowInsetLeft();
        r15.right -= r16.getSystemWindowInsetRight();
        goto L11
    L12:
        super.layoutChild(r10, r11, r12);
        r19 = 0;
        goto L13
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12, int r13, int r14, int r15) {
        int r16 = r11.getLayoutParams().height;
        if (r16 != (-1)) goto L5;
    L6:
        View r17 = findFirstDependency(r10.getDependencies(r11));
        if (r17 == null) goto L27;
        int r18 = View.MeasureSpec.getSize(r14);
        if (r18 > 0) goto L11;
        r18 = r10.getHeight();
    L16:
        int r19 = r18 + getScrollRange(r17);
        int r20 = r17.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild() == false) goto L19;
        r11.setTranslationY(-r20);
    L20:
        if (r16 != (-1)) goto L22;
        int r21 = 1073741824;
    L23:
        r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(r19, r21), r15);
        return true;
    L22:
        r21 = Integer.MIN_VALUE;
        goto L23
    L19:
        r19 = r19 - r20;
        goto L20
    L11:
        if (ViewCompat.getFitsSystemWindows(r17) == false) goto L16;
        WindowInsetsCompat r22 = r10.getLastWindowInsets();
        if (r22 == null) goto L16;
        r18 = r18 + (r22.getSystemWindowInsetTop() + r22.getSystemWindowInsetBottom());
        goto L16
    L27:
        return false;
    L5:
        if (r16 == (-2)) goto L6;
        return false;
    }

    public final void setOverlayTop(int r10) {
        this.overlayTop = r10;
    }

    protected boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }
}
