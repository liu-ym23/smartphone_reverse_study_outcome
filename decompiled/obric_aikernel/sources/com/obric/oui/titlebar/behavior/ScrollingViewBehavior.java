package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001$B\t\b\u0016¢\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0014J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0002H\u0014¨\u0006%"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior;", "Lcom/obric/oui/titlebar/behavior/HeaderScrollingViewBehavior;", "Landroid/view/View;", "child", "dependency", "", "offsetChildAsNeeded", "updateLiftedStateIfNeeded", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "", "layoutDependsOn", "onDependentViewChanged", "onDependentViewRemoved", "Landroid/graphics/Rect;", "rectangle", "immediate", "onRequestChildRectangleOnScreen", "header", "", "getOverlapRatioForOffset", "", "views", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "findFirstDependency", BaseSwitches.V, "", "getScrollRange", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public static final a Companion = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int a(a r10, OUnitedTitleBar r11) {
            return r10.b(r11);
        }

        private final int b(OUnitedTitleBar r10) {
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
            Objects.requireNonNull(r11, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.LayoutParams) r11).getBehavior();
            if ((r12 instanceof OUnitedTitleBar.Behavior) == true) goto L7;
            return 0;
        L7:
            return ((OUnitedTitleBar.Behavior) r12).getTopBottomOffsetForScrollingSibling();
        }
    }

    static {
        Companion = new a(null);
    }

    public ScrollingViewBehavior() {
    }

    public ScrollingViewBehavior(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.ScrollingViewBehavior_Layout);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        setOverlayTop(r12.getDimensionPixelSize(l.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
        r12.recycle();
    }

    private final void offsetChildAsNeeded(View r10, View r11) {
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r13 = ((CoordinatorLayout.LayoutParams) r12).getBehavior();
        if ((r13 instanceof BaseBehavior) == false) goto L6;
        ViewCompat.offsetTopAndBottom(r10, (((r11.getBottom() - r10.getTop()) + ((BaseBehavior) r13).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r11));
        return;
    }

    private final void updateLiftedStateIfNeeded(View r10, View r11) {
        boolean r12 = r11 instanceof OUnitedTitleBar;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public /* bridge */ /* synthetic */ View findFirstDependency(List r10) {
        return findFirstDependency(r10);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    protected OUnitedTitleBar findFirstDependency(List<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "views");
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        View r13 = r10.get(r12);
        if ((r13 instanceof OUnitedTitleBar) == true) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) r13;
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    protected float getOverlapRatioForOffset(View r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        if ((r10 instanceof OUnitedTitleBar) == false) goto L13;
        OUnitedTitleBar r11 = (OUnitedTitleBar) r10;
        int r12 = r11.getTotalScrollRange();
        int r13 = r11.getDownNestedPreScrollRange();
        int r14 = a.a(Companion, r11);
        if (r13 != 0) goto L7;
    L9:
        int r15 = r12 - r13;
        if (r15 == 0) goto L13;
        return (r14 / r15) + 1.0f;
    L7:
        if ((r12 + r14) > r13) goto L9;
        return 0.0f;
    L13:
        return 0.0f;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    protected int getScrollRange(View r10) {
        Intrinsics.checkNotNullParameter(r10, BaseSwitches.V);
        if ((r10 instanceof OUnitedTitleBar) == false) goto L6;
        return ((OUnitedTitleBar) r10).getTotalScrollRange();
    L6:
        return super.getScrollRange(r10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r10, View r11, View r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "dependency");
        return r12 instanceof OUnitedTitleBar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r10, View r11, View r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "dependency");
        offsetChildAsNeeded(r11, r12);
        updateLiftedStateIfNeeded(r11, r12);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(CoordinatorLayout r10, View r11, View r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "dependency");
        if ((r12 instanceof OUnitedTitleBar) == false) goto L6;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r13 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD;
        Intrinsics.checkNotNullExpressionValue(r13, "AccessibilityNodeInfoCom…pat.ACTION_SCROLL_FORWARD");
        ViewCompat.removeAccessibilityAction(r10, r13.getId());
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r14 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD;
        Intrinsics.checkNotNullExpressionValue(r14, "AccessibilityNodeInfoCom…at.ACTION_SCROLL_BACKWARD");
        ViewCompat.removeAccessibilityAction(r10, r14.getId());
        ViewCompat.setAccessibilityDelegate(r10, null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r10, View r11, Rect r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "rectangle");
        List<View> r14 = r10.getDependencies(r11);
        Intrinsics.checkNotNullExpressionValue(r14, "parent.getDependencies(child)");
        OUnitedTitleBar r15 = findFirstDependency(r14);
        if (r15 == null) goto L8;
        Rect r16 = new Rect(r12);
        r16.offset(r11.getLeft(), r11.getTop());
        Rect r17 = this.tempRect1;
        r17.set(0, 0, r10.getWidth(), r10.getHeight());
        if (r17.contains(r16) == true) goto L8;
        r15.setExpanded(false);
        return true;
    L8:
        return false;
    }
}
