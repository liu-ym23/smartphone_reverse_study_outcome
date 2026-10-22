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
import com.obric.memorydata.plugin.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0014J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J \u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0016J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002¨\u0006#"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior;", "Lcom/obric/oui/titlebar/behavior/HeaderScrollingViewBehavior;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "findFirstDependency", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "views", "", "Landroid/view/View;", "getOverlapRatioForOffset", "", "header", "getScrollRange", "", BaseSwitches.V, "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "dependency", "offsetChildAsNeeded", "", "onDependentViewChanged", "onDependentViewRemoved", "onRequestChildRectangleOnScreen", "rectangle", "Landroid/graphics/Rect;", "immediate", "updateLiftedStateIfNeeded", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior$Companion;", "", "()V", "getOUnitedTitleBarOffset", "", "abl", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final int a(OUnitedTitleBar r2) {
            ViewGroup.LayoutParams r1 = r2.getLayoutParams();
            Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.Behavior r3 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
            if (ZeusTransformUtils.instanceOf(r3, OUnitedTitleBar.Behavior.class) == true) goto L7;
            return 0;
        L7:
            return ((OUnitedTitleBar.Behavior) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.Behavior.class, "com.obric.memorydata.plugin")).getTopBottomOffsetForScrollingSibling();
        }

        public static final /* synthetic */ int a(a r0, OUnitedTitleBar r1) {
            return r0.a(r1);
        }
    }

    static {
        Companion = new a(null);
    }

    public ScrollingViewBehavior() {
    }

    public ScrollingViewBehavior(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.ScrollingViewBehavior_Layout);
        Intrinsics.checkNotNullExpressionValue(r7, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        setOverlayTop(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, "styleable", "ScrollingViewBehavior_Layout_behavior_overlapTop"), 0));
        r7.recycle();
    }

    private final void offsetChildAsNeeded(View r5, View r6) {
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getBehavior();
        if (ZeusTransformUtils.instanceOf(r1, BaseBehavior.class) == false) goto L6;
        ViewCompat.offsetTopAndBottom(r5, (((r6.getBottom() - r5.getTop()) + ((BaseBehavior) ZeusTransformUtils.preCheckCast(r1, BaseBehavior.class, "com.obric.memorydata.plugin")).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r6));
        return;
    }

    private final void updateLiftedStateIfNeeded(View r1, View r2) {
        ZeusTransformUtils.instanceOf(r2, OUnitedTitleBar.class);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public /* synthetic */ View findFirstDependency(List r3) {
        return (View) ZeusTransformUtils.preCheckCast(findFirstDependency((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")), View.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public OUnitedTitleBar findFirstDependency(List<? extends View> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "views");
        int r6 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L9;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r4.get(r1), View.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, OUnitedTitleBar.class) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r2, OUnitedTitleBar.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public float getOverlapRatioForOffset(View r6) {
        Intrinsics.checkNotNullParameter(r6, "header");
        if (ZeusTransformUtils.instanceOf(r6, OUnitedTitleBar.class) == false) goto L13;
        int r5 = ((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r6, OUnitedTitleBar.class, "com.obric.memorydata.plugin")).getTotalScrollRange();
        int r2 = ((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r6, OUnitedTitleBar.class, "com.obric.memorydata.plugin")).getDownNestedPreScrollRange();
        int r7 = a.a(Companion, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r6, OUnitedTitleBar.class, "com.obric.memorydata.plugin"));
        if (r2 != 0) goto L7;
    L9:
        int r8 = r5 - r2;
        if (r8 == 0) goto L13;
        return (r7 / r8) + 1.0f;
    L7:
        if ((r5 + r7) > r2) goto L9;
        return 0.0f;
    L13:
        return 0.0f;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public int getScrollRange(View r2) {
        Intrinsics.checkNotNullParameter(r2, BaseSwitches.V);
        if (ZeusTransformUtils.instanceOf(r2, OUnitedTitleBar.class) == false) goto L6;
        return ((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r2, OUnitedTitleBar.class, "com.obric.memorydata.plugin")).getTotalScrollRange();
    L6:
        return super.getScrollRange(r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        return ZeusTransformUtils.instanceOf(r3, OUnitedTitleBar.class);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        offsetChildAsNeeded(r3, r4);
        updateLiftedStateIfNeeded(r3, r4);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(CoordinatorLayout r1, View r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        if (ZeusTransformUtils.instanceOf(r3, OUnitedTitleBar.class) == false) goto L6;
        ViewCompat.removeAccessibilityAction((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        ViewCompat.setAccessibilityDelegate((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r3, View r4, Rect r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "rectangle");
        List<View> r7 = r3.getDependencies(r4);
        Intrinsics.checkNotNullExpressionValue(r7, "parent.getDependencies(child)");
        OUnitedTitleBar r8 = findFirstDependency(r7);
        if (r8 == null) goto L8;
        Rect r1 = new Rect(r5);
        r1.offset(r4.getLeft(), r4.getTop());
        Rect r2 = this.tempRect1;
        r2.set(0, 0, r3.getWidth(), r3.getHeight());
        if (r2.contains(r1) == true) goto L8;
        r8.setExpanded(false);
        return true;
    L8:
        return false;
    }
}
