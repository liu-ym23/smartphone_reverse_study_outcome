package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f14854c;
    public final Rect d;
    public int e;
    public int f;

    public HeaderScrollingViewBehavior() {
        this.f14854c = new Rect();
        this.d = new Rect();
        this.e = 0;
    }

    public abstract View findFirstDependency(List r5);

    public float getOverlapRatioForOffset(View r5) {
        return 1.0f;
    }

    public int getScrollRange(View r5) {
        return r5.getMeasuredHeight();
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public final void layoutChild(CoordinatorLayout r16, View r17, int r18) {
        View r5 = findFirstDependency(r16.getDependencies(r17));
        int r10 = 0;
        if (r5 == null) goto L19;
        CoordinatorLayout.LayoutParams r11 = (CoordinatorLayout.LayoutParams) r17.getLayoutParams();
        int r12 = r16.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r11).leftMargin;
        int r13 = r5.getBottom() + ((ViewGroup.MarginLayoutParams) r11).topMargin;
        int r14 = (r16.getWidth() - r16.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        int r15 = ((r5.getBottom() + r16.getHeight()) - r16.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        Rect r19 = this.f14854c;
        r19.set(r12, r13, r14, r15);
        WindowInsetsCompat r20 = r16.getLastWindowInsets();
        if (r20 != null) goto L7;
    L11:
        int r21 = r11.gravity;
        if (r21 != 0) goto L14;
        r21 = 8388659;
    L14:
        int r22 = r21;
        int r110 = r17.getMeasuredWidth();
        int r111 = r17.getMeasuredHeight();
        Rect r23 = this.d;
        GravityCompat.apply(r22, r110, r111, r19, r23, r18);
        if (this.f == 0) goto L18;
        float r24 = getOverlapRatioForOffset(r5);
        int r25 = this.f;
        r10 = MathUtils.clamp((int) (r24 * r25), 0, r25);
    L18:
        r17.layout(r23.left, r23.top - r10, r23.right, r23.bottom - r10);
        this.e = r23.top - r5.getBottom();
        return;
    L7:
        if (ViewCompat.getFitsSystemWindows(r16) == false) goto L11;
        if (ViewCompat.getFitsSystemWindows(r17) == true) goto L11;
        r19.left = r20.getSystemWindowInsetLeft() + r19.left;
        r19.right -= r20.getSystemWindowInsetRight();
        goto L11
    L19:
        r16.onLayoutChild(r17, r18);
        this.e = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r10, View r11, int r12, int r13, int r14, int r15) {
        int r5 = r11.getLayoutParams().height;
        if (r5 != (-1)) goto L5;
    L6:
        View r16 = findFirstDependency(r10.getDependencies(r11));
        if (r16 == null) goto L24;
        int r17 = View.MeasureSpec.getSize(r14);
        if (r17 > 0) goto L11;
        r17 = r10.getHeight();
    L16:
        int r18 = getScrollRange(r16) + r17;
        int r19 = r16.getMeasuredHeight();
        r11.setTranslationY(0.0f);
        int r20 = r18 - r19;
        if (r5 != (-1)) goto L19;
        int r110 = BasicMeasure.EXACTLY;
    L20:
        r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(r20, r110), r15);
        return true;
    L19:
        r110 = Integer.MIN_VALUE;
        goto L20
    L11:
        if (ViewCompat.getFitsSystemWindows(r16) == false) goto L16;
        WindowInsetsCompat r21 = r10.getLastWindowInsets();
        if (r21 == null) goto L16;
        int r22 = r21.getSystemWindowInsetTop();
        r17 = r17 + (r21.getSystemWindowInsetBottom() + r22);
        goto L16
    L24:
        return false;
    L5:
        if (r5 == (-2)) goto L6;
        return false;
    }

    public HeaderScrollingViewBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f14854c = new Rect();
        this.d = new Rect();
        this.e = 0;
    }
}
