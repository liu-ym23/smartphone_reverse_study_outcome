package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.obric.common.oui.R$styleable;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior;", "Lcom/obric/oui/titlebar/behavior/HeaderScrollingViewBehavior;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public ScrollingViewBehavior() {
    }

    public static OUnitedTitleBar a(List r5) {
        Intrinsics.checkNotNullParameter(r5, "views");
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        View r12 = (View) r5.get(r11);
        if ((r12 instanceof OUnitedTitleBar) == true) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) r12;
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final /* bridge */ /* synthetic */ View findFirstDependency(List r5) {
        return a(r5);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final float getOverlapRatioForOffset(View r5) {
        Intrinsics.checkNotNullParameter(r5, "header");
        if ((r5 instanceof OUnitedTitleBar) == false) goto L20;
        OUnitedTitleBar r10 = (OUnitedTitleBar) r5;
        int r11 = r10.getTotalScrollRange();
        int r12 = r10.getDownNestedPreScrollRange();
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L19;
        CoordinatorLayout.Behavior r14 = ((CoordinatorLayout.LayoutParams) r13).getBehavior();
        if ((r14 instanceof OUnitedTitleBar.Behavior) == false) goto L9;
        int r15 = ((OUnitedTitleBar.Behavior) r14).getTopAndBottomOffset();
    L10:
        if (r12 != 0) goto L12;
    L14:
        int r16 = r11 - r12;
        if (r16 == 0) goto L20;
        return (r15 / r16) + 1.0f;
    L12:
        if ((r11 + r15) > r12) goto L14;
        return 0.0f;
    L9:
        r15 = 0;
        goto L10
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L20:
        return 0.0f;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final int getScrollRange(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        if ((r5 instanceof OUnitedTitleBar) == false) goto L6;
        return ((OUnitedTitleBar) r5).getTotalScrollRange();
    L6:
        return r5.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout r5, View r10, View r11) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r10, "child");
        Intrinsics.checkNotNullParameter(r11, "dependency");
        return r11 instanceof OUnitedTitleBar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout r5, View r10, View r11) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r10, "child");
        Intrinsics.checkNotNullParameter(r11, "dependency");
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L14;
        CoordinatorLayout.Behavior r13 = ((CoordinatorLayout.LayoutParams) r12).getBehavior();
        if ((r13 instanceof BaseBehavior) == false) goto L11;
        int r14 = r11.getBottom() - r10.getTop();
        ((BaseBehavior) r13).getClass();
        int r15 = r14 + this.e;
        if (this.f != 0) goto L9;
        int r16 = 0;
    L10:
        ViewCompat.offsetTopAndBottom(r10, r15 - r16);
        goto L11
    L9:
        float r17 = getOverlapRatioForOffset(r11);
        int r18 = this.f;
        r16 = MathUtils.clamp((int) (r17 * r18), 0, r18);
    L11:
        boolean r19 = r11 instanceof OUnitedTitleBar;
        return false;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDependentViewRemoved(CoordinatorLayout r5, View r10, View r11) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r10, "child");
        Intrinsics.checkNotNullParameter(r11, "dependency");
        if ((r11 instanceof OUnitedTitleBar) == false) goto L6;
        ViewCompat.removeAccessibilityAction(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        ViewCompat.setAccessibilityDelegate(r5, null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onRequestChildRectangleOnScreen(CoordinatorLayout r5, View r10, Rect r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r10, "child");
        Intrinsics.checkNotNullParameter(r11, "rectangle");
        OUnitedTitleBar r13 = a(r5.getDependencies(r10));
        if (r13 == null) goto L8;
        Rect r14 = new Rect(r11);
        r14.offset(r10.getLeft(), r10.getTop());
        int r15 = r5.getWidth();
        int r16 = r5.getHeight();
        Rect r17 = this.f14854c;
        r17.set(0, 0, r15, r16);
        if (r17.contains(r14) == true) goto L8;
        r13.setExpanded(false);
        return true;
    L8:
        return false;
    }

    public ScrollingViewBehavior(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.ScrollingViewBehavior_Layout);
        this.f = r11.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
        r11.recycle();
    }
}
