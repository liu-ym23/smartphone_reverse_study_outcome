package com.lynx.xelement.scroll.coordinator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.q1;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.lynx.xelement.scroll.coordinator.childitem.LynxUIScrollCoordinatorHeader;
import com.lynx.xelement.scroll.coordinator.childitem.LynxUIScrollCoordinatorSlot;
import com.lynx.xelement.scroll.coordinator.childitem.LynxUIScrollCoordinatorToolbar;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"scroll-coordinator"})
@LynxGeneratorName(packageName = "com.lynx.xelement.scroll.coordinator")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007J\u001c\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¨\u0006\u001a"}, d2 = {"Lcom/lynx/xelement/scroll/coordinator/LynxUIScrollCoordinator;", "Lcom/lynx/xelement/scroll/coordinator/BaseScrollCoordinator;", "Lcom/lynx/xelement/scroll/coordinator/ScrollCoordinatorAppBarLayout;", "Lcom/lynx/xelement/scroll/coordinator/ScrollCoordinatorLayout;", NameKeys.UnloadStrategy_No_Strategy, "enable", NameKeys.UnloadStrategy_No_Strategy, "setTabMovableEnable", "setToolbarInteractionEnable", "setHeaderScrollViewEnable", "setHeaderSlotOverflowHitTest", "setEnableTouchStopFling", "setAndroidHeaderOverSlot", "setHeaderOverSlot", "setNestedScrollAsChild", NameKeys.UnloadStrategy_No_Strategy, "tapSlop", "setAndroidHeaderTapSlop", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "scrollBy", "setFoldExpanded", "getScrollInfo", "a", "ScrollCoordinator_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIScrollCoordinator extends BaseScrollCoordinator<ScrollCoordinatorAppBarLayout, ScrollCoordinatorLayout> {
    public static final /* synthetic */ int q = 0;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public LynxUI<?> n;
    public LynxUI<?> o;
    public int p;

    public static final class a {
    }

    public static final class b implements ScrollCoordinatorAppBarLayout.a {
        public final /* synthetic */ LynxUIScrollCoordinator a;

        /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
        @Override // com.lynx.xelement.scroll.coordinator.ScrollCoordinatorAppBarLayout.a
        public final void a() {
            this.a.getLynxContext().getLynxViewClient().onScrollStart(new q1.b(this.a.getView(), this.a.getTagName(), this.a.getScrollMonitorTag()));
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
        @Override // com.lynx.xelement.scroll.coordinator.ScrollCoordinatorAppBarLayout.a
        public final void b() {
            this.a.getLynxContext().getLynxViewClient().onScrollStop(new q1.b(this.a.getView(), this.a.getTagName(), this.a.getScrollMonitorTag()));
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
        @Override // com.lynx.xelement.scroll.coordinator.ScrollCoordinatorAppBarLayout.a
        public final void onFling() {
            this.a.getLynxContext().getLynxViewClient().onFling(new q1.b(this.a.getView(), this.a.getTagName(), this.a.getScrollMonitorTag()));
        }

        public b(LynxUIScrollCoordinator r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollX() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getScrollContainerDirection() {
        return 1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    public final void U() {
        if (this.a == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        return;
    L9:
        if (this.k == true) goto L11;
        return;
    L11:
        if (this.m == false) goto L15;
        NestedScrollingChild2 r1 = (ScrollCoordinatorLayout) N();
        r1.bringChildToFront(r1.getAppBarLayoutView());
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollY() {
        return ((ScrollCoordinatorLayout) this.mView).getAppBarLayout().getTopAndBottomOffset();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onInvalidate() {
        if (this.mView != 0) goto L5;
        return;
    L5:
        if (isEnableNewGesture() == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        N().getAppBarLayout().setScrollListener(null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.xelement.scroll.coordinator.BaseScrollCoordinator
    public final int O() {
        return this.p;
    }

    public static boolean T(EventTarget r1) {
        if ((r1 instanceof LynxUIScrollCoordinatorToolbar) == true) goto L5;
    L8:
        if (r1 != null) goto L10;
        return false;
    L10:
        if ((r1 instanceof LynxUIScrollCoordinator) == false) goto L13;
        return false;
    L13:
        return T(r1.parent());
    L5:
        if (((LynxUIScrollCoordinatorToolbar) r1).isUserInteractionEnabled() == true) goto L8;
        return true;
    }

    public final boolean S(EventTarget r2) {
        if ((r2 instanceof UIScrollView) == false) goto L6;
        return true;
    L6:
        if (r2 != null) goto L8;
        return false;
    L8:
        if ((r2 instanceof LynxUIScrollCoordinator) == false) goto L11;
        return false;
    L11:
        return S(r2.parent());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(x0 r2) {
        super.afterPropsUpdated(r2);
        if (isEnableScrollMonitor() == false) goto L6;
        N().getAppBarLayout().setScrollListener(new b(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r2) {
        ((ScrollCoordinatorLayout) this.mView).setConsumeGesture(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r4) {
        LLog.i("ScrollCoordinator", "createView start: " + this + ' ' + r4 + " realActivity is: " + com.lynx.tasm.utils.a.getActivity(getLynxContext()));
        if (r4 != null) goto L5;
        return null;
    L5:
        ScrollCoordinatorLayout r0 = new ScrollCoordinatorLayout(r4, this);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.a = r0;
        Intrinsics.checkNotNullParameter(r4, "context");
        N().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        N().getAppBarLayout().addOnOffsetChangedListener(new com.lynx.xelement.scroll.coordinator.a(this));
        LLog.i("ScrollCoordinator", "createView end: " + this + ", " + N());
        return (ScrollCoordinatorLayout) N();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public final void getScrollInfo(Callback r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putInt("scrollX", 0);
        r0.putInt("scrollY", h.h(this.mContext, Math.abs(((ScrollCoordinatorLayout) this.mView).getAppBarLayout().getTopAndBottomOffset())));
        r0.putInt("scrollRange", h.h(this.mContext, N().getCollapsingToolbar().getHeight() - N().getPinnedToolbar().getHeight()));
        r6.invoke(new Object[]{0, r0});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r2) {
        ((ScrollCoordinatorLayout) this.mView).setInterceptGesture(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean isAtBorder(boolean r2) {
        if (((ScrollCoordinatorLayout) this.mView).getAppBarLayout().getTopAndBottomOffset() != 0) goto L5;
    L8:
        return true;
    L5:
        if (((ScrollCoordinatorLayout) this.mView).getAppBarLayout().getTopAndBottomOffset() == ((ScrollCoordinatorLayout) this.mView).getAppBarLayout().getTotalScrollRange()) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, java.lang.Object] */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r4) {
        Intrinsics.checkNotNullParameter(r4, "child");
        if ((r4 instanceof LynxUI) == false) goto L14;
        this.mChildren.remove(r4);
        ((LynxUI) r4).setParent(null);
        if ((r4 instanceof LynxUIScrollCoordinatorToolbar) == false) goto L8;
        ScrollCoordinatorLayout r0 = N();
        View r5 = ((LynxUIScrollCoordinatorToolbar) r4).getView();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "view");
        r0.getToolbarView().setVisibility(8);
        r0.getToolbarView().removeView(r5);
        return;
    L8:
        if ((r4 instanceof LynxUIScrollCoordinatorHeader) == false) goto L11;
        ScrollCoordinatorLayout r1 = N();
        View r6 = ((LynxUIScrollCoordinatorHeader) r4).getView();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "view");
        r1.getCollapsingToolbarView().removeView(r6);
        return;
    L11:
        if ((r4 instanceof LynxUIScrollCoordinatorSlot) == false) goto L17;
        ScrollCoordinatorLayout r2 = N();
        ?? r7 = ((LynxUIScrollCoordinatorSlot) r4).getView();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "view");
        r2.removeView(r7);
        return;
    L17:
        return;
    }

    @LynxProp(name = "android-header-over-slot")
    public final void setAndroidHeaderOverSlot(boolean r1) {
        this.m = r1;
        U();
    }

    @LynxProp(defaultInt = 0, name = "android-header-tap-slop")
    public final void setAndroidHeaderTapSlop(int r1) {
        this.p = r1;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-touch-stop-fling")
    public final void setEnableTouchStopFling(boolean r3) {
        ((ScrollCoordinatorAppBarLayout) ((ScrollCoordinatorLayout) N()).findViewById(2131363087)).setTouchStopFlingEnabled(r3);
        if (r3 == true) goto L6;
        LynxFeatureCounter.a(81, this.mContext.getInstanceId());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setGestureDetectors(Map<Integer, s7a.a> r1) {
        super.setGestureDetectors(r1);
    }

    @LynxProp(name = "header-over-slot")
    public final void setHeaderOverSlot(boolean r1) {
        this.m = r1;
        U();
    }

    @LynxProp(defaultBoolean = false, name = "header-scrollview-enable")
    public final void setHeaderScrollViewEnable(boolean r1) {
        this.j = r1;
    }

    @LynxProp(defaultBoolean = true, name = "experimental-header-slot-overflow-hit-test")
    public final void setHeaderSlotOverflowHitTest(boolean r1) {
        this.l = r1;
    }

    @LynxProp(defaultBoolean = false, name = "android-nested-scroll-as-child")
    public final void setNestedScrollAsChild(boolean r2) {
        N().setNestedScrollAsChild(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(Integer r3) {
        super.setOverflow(r3);
        if (r3 != null) goto L6;
    L7:
        boolean r4 = true;
    L9:
        this.k = r4;
        boolean r5 = !r4;
        ((ScrollCoordinatorLayout) this.mView).setClipChildren(r5);
        N().d.setClipChildren(r5);
        U();
        return;
    L6:
        if (r3.intValue() != 1) goto L7;
        r4 = false;
        goto L9
    }

    @LynxProp(defaultBoolean = true, name = "tab-movable-enable")
    public final void setTabMovableEnable(boolean r2) {
        N().getAppBarLayout().setToolbarDragEnabled(r2);
    }

    @LynxProp(defaultBoolean = true, name = "toolbar-interaction-enable")
    public final void setToolbarInteractionEnable(boolean r1) {
        this.i = r1;
    }

    public LynxUIScrollCoordinator(LynxContext r1, Object r2) {
        super(r1, r2);
        this.i = true;
        this.l = true;
    }

    public static void R(LynxUIScrollCoordinator r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        CoordinatorLayout r3 = r1.mView;
        if (r3 == null) goto L7;
        ((ScrollCoordinatorLayout) r3).scrollBy(0, (int) r2);
        return;
    }

    @Override // com.lynx.xelement.scroll.coordinator.BaseScrollCoordinator
    public final void P(AppBarLayout r1, int r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (Math.abs(r2) < r1.getTotalScrollRange()) goto L7;
        boolean r3 = true;
    L8:
        this.h = r3;
        return;
    L7:
        r3 = false;
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean canConsumeGesture(float r4, float r5) {
        if (isEnableNewGesture() == true) goto L5;
        return false;
    L5:
        if (this.mView != 0) goto L8;
        return false;
    L8:
        if (isAtBorder(true) == false) goto L12;
        if (r5 >= 0.0f) goto L12;
        return false;
    L12:
        if (isAtBorder(false) == true) goto L14;
    L15:
        return true;
    L14:
        if (r5 <= 0.0f) goto L15;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, java.lang.Object] */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "child");
        if ((r4 instanceof LynxUI) == false) goto L14;
        ListProtector.add(this.mChildren, r5, r4);
        LynxUI<?> r6 = (LynxUI) r4;
        r6.setParent(this);
        if ((r4 instanceof LynxUIScrollCoordinatorToolbar) == false) goto L8;
        this.o = r6;
        ScrollCoordinatorLayout r7 = N();
        LynxUIScrollCoordinatorToolbar r8 = (LynxUIScrollCoordinatorToolbar) r4;
        ?? r0 = r8.getView();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "view");
        r7.f.setVisibility(0);
        ViewCompat.setPaddingRelative(r7.f, 0, 0, 0, 0);
        r7.f.addView(r0);
        N().f.setClipChildren(!r8.a);
        return;
    L8:
        if ((r4 instanceof LynxUIScrollCoordinatorHeader) == false) goto L11;
        this.n = r6;
        ScrollCoordinatorLayout r9 = N();
        LynxUIScrollCoordinatorHeader r10 = (LynxUIScrollCoordinatorHeader) r4;
        ?? r1 = r10.getView();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "headerView");
        r9.e.addView(r1, 0);
        N().e.setClipChildren(!r10.a);
        return;
    L11:
        if ((r4 instanceof LynxUIScrollCoordinatorSlot) == false) goto L17;
        ScrollCoordinatorLayout r11 = N();
        ?? r12 = ((LynxUIScrollCoordinatorSlot) r4).getView();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "slotView");
        CoordinatorLayout.LayoutParams r2 = new CoordinatorLayout.LayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r2.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        r12.setLayoutParams(r2);
        r11.addView(r12);
        U();
        return;
    L17:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onGestureScrollBy(float r1, final float r2) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.xelement.scroll.coordinator.b(this, r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r4, float r5) {
        float[] r0 = new float[4];
        BaseScrollCoordinator.Q(this, (int) r5);
        if (Math.abs(r4) <= Float.MIN_VALUE) goto L5;
    L6:
        recognizeGesturere();
    L7:
        r0[0] = 0.0f;
        float r1 = Math.abs(((ScrollCoordinatorLayout) this.mView).getAppBarLayout().getTopAndBottomOffset());
        r0[1] = r1;
        r0[2] = r4;
        r0[3] = r5 - r1;
        return r0;
    L5:
        if (Math.abs(r5) <= Float.MIN_VALUE) goto L7;
        goto L6
    }

    @LynxUIMethod
    public final void setFoldExpanded(ReadableMap r18, Callback r19) {
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r3 = new JavaOnlyMap();
        r3.put("success", Boolean.FALSE);
        if (r18.hasKey("offset") == false) goto L34;
        String r4 = r18.getString("offset", NameKeys.UnloadStrategy_No_Strategy);
        if (StringsKt.endsWith$default(r4, "px", false, 2, null) == false) goto L7;
    L10:
        int r5 = (int) n.d(r4, 0.0f, -1.0f, this.mContext.getScreenMetrics());
    L12:
        if (r18.hasKey("smooth") == false) goto L14;
        boolean r0 = r18.getBoolean("smooth");
    L15:
        ScrollCoordinatorLayout r6 = N();
        r6.c();
        ScrollCoordinatorAppBarLayout r7 = r6.getAppBarLayoutView();
        ScrollCoordinatorAppBarLayout.b r11 = r7.getBehavior();
        r11.a(r7);
        r11.a = false;
        r11.b = false;
        if (r0 == false) goto L32;
        CoordinatorLayout.AttachedBehavior r1 = (BaseScrollCoordinatorAppBarLayout) N().getAppBarLayout();
        ViewGroup.LayoutParams r8 = r1.getLayoutParams();
        if (r8 == null) goto L31;
        CoordinatorLayout.Behavior r9 = ((CoordinatorLayout.LayoutParams) r8).getBehavior();
        if ((r9 instanceof AppBarLayout.Behavior) == false) goto L33;
        if (r5 >= 0) goto L24;
        r5 = (int) (((double) r1.getTotalScrollRange()) * (((double) 1) - (-1.0d)));     // Catch: Exception -> L28
    L28:
        e = move-exception;
        LLog.e("ScrollCoordinator", "invoke animateOffsetMethod error " + e.getMessage());
    L24:
        int r10 = RangesKt.coerceAtLeast(-r5, -r1.getTotalScrollRange());     // Catch: Exception -> L28
        Method r12 = (Method) this.g.getValue();     // Catch: Exception -> L28
        if (r12 == null) goto L33;
        r12.invoke(r9, new Object[]{N(), r1, Integer.valueOf(r10), 0});     // Catch: Exception -> L28
    L33:
        r3.put("success", Boolean.TRUE);
    L35:
        if (r19 == null) goto L40;
        r19.invoke(new Object[]{0, r3});
        return;
    L40:
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L32:
        BaseScrollCoordinator.Q(this, r5);
        goto L33
    L14:
        r0 = true;
        goto L15
    L7:
        if (StringsKt.endsWith$default(r4, "rpx", false, 2, null) == true) goto L10;
        r5 = -1;
        goto L12
    L34:
        r3.put("msg", "no index key");
        goto L35
    }

    @LynxUIMethod
    public final void scrollBy(ReadableMap r4, final Callback r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
    L10:
        r5.invoke(new Object[]{4, "Invoke scrollBy failed due to param is null"});
        return;
    L6:
        if (r4.hasKey("offset") == false) goto L10;
        final double r0 = i.a(r4.getDouble("offset", 0.0d));
        UIThreadUtils.runOnUiThreadImmediately(new c(this, r0, r5));
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final EventTarget findUIWithCustomLayout(float r6, float r7, UIGroup<?> r8) {
        EventTarget r9 = super.findUIWithCustomLayout(r6, r7, r8);
        if (this.i == true) goto L27;
        if (T(r9) == false) goto L27;
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L8:
        if (r0.hasNext() == false) goto L37;
        if ((r0.next() instanceof LynxUIScrollCoordinatorHeader) == false) goto L8;
        if (this.h == true) goto L8;
        HashMap r10 = new HashMap();
        int r1 = getChildCount() - 1;
    L14:
        if ((-1) >= r1) goto L25;
        LynxBaseUI r3 = getChildAt(r1);
        if ((r3 instanceof LynxUIScrollCoordinatorToolbar) == true) goto L24;
        if ((r3 instanceof UIShadowProxy) == false) goto L22;
        r3 = ((UIShadowProxy) r3).a;
    L22:
        if ((r3 instanceof LynxUI) == false) goto L24;
        r10.put(((LynxUI) r3).getView(), r3);
    L24:
        r1 = r1 - 1;
        goto L14
    L25:
        r9 = findUIWithCustomLayoutByChildren(r6, r7, this, r10);
    L37:
        return r9;
    L27:
        if (this.j == false) goto L37;
        boolean r11 = !S(r9);
        ViewGroup.LayoutParams r12 = ((ScrollCoordinatorLayout) N()).getCollapsingToolbar().getLayoutParams();
        if (r12 == null) goto L36;
        ViewGroup.LayoutParams r13 = (AppBarLayout.LayoutParams) r12;
        if (r11 == false) goto L33;
        r13.setScrollFlags(r13.getScrollFlags() | 1);
    L34:
        ((ScrollCoordinatorLayout) N()).getCollapsingToolbar().setLayoutParams(r13);
        goto L37
    L33:
        r13.setScrollFlags((r13.getScrollFlags() >> 1) << 1);
        goto L34
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final boolean isTransformedTouchPointInView(float[] r10, View r11, View r12, float[] r13, Map<View, LynxUI<?>> r14) {
        Intrinsics.checkNotNullParameter(r10, "inPoint");
        Intrinsics.checkNotNullParameter(r13, "outLocalPoint");
        if (this.l == true) goto L7;
        return super.isTransformedTouchPointInView(r10, r11, r12, r13, r14);
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r12 != null) goto L11;
        return false;
    L11:
        float[] r15 = getTargetPoint(r10[0], r10[1], r11.getScrollX(), r11.getScrollY(), r12, r12.getMatrix());
        r13[0] = r15[0];
        r13[1] = r15[1];
        if (r14 == null) goto L14;
        LynxUI<?> r16 = r14.get(r12);
    L15:
        if (r16 == null) goto L17;
    L25:
        if (r16 != null) goto L37;
        float r17 = r13[0];
        if (r17 >= 0.0f) goto L30;
        return false;
    L30:
        if (r17 >= (r12.getRight() - r12.getLeft())) goto L39;
        float r18 = r13[1];
        if (r18 >= 0.0f) goto L34;
        return false;
    L34:
        if (r18 >= (r12.getBottom() - r12.getTop())) goto L41;
        return true;
    L41:
        return false;
    L39:
        return false;
    L37:
        return r16.containsPoint(r13[0], r13[1]);
    L17:
        if (Intrinsics.areEqual(r12.getClass(), ScrollCoordinatorAppBarLayout.class) == false) goto L19;
    L20:
        r16 = this.n;
        if (r16 == null) goto L25;
        if (r16.containsPoint(r13[0], r13[1]) == true) goto L25;
        r16 = this.o;
        goto L25
    L19:
        if (Intrinsics.areEqual(r12.getClass(), CollapsingToolbarLayout.class) == false) goto L25;
    L14:
        r16 = null;
        goto L15
    }
}
