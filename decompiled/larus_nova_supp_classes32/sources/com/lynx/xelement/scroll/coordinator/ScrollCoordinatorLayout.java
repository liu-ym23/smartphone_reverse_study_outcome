package com.lynx.xelement.scroll.coordinator;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lynx.tasm.base.LLog;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/lynx/xelement/scroll/coordinator/ScrollCoordinatorLayout;", "Lcom/lynx/xelement/scroll/coordinator/ScrollCoordinatorToolbarLayout;", "Lcom/lynx/xelement/scroll/coordinator/ScrollCoordinatorAppBarLayout;", "Landroidx/core/view/NestedScrollingChild2;", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getCollapsingToolbarLayout", NameKeys.UnloadStrategy_No_Strategy, "consume", NameKeys.UnloadStrategy_No_Strategy, "setConsumeGesture", "intercept", "setInterceptGesture", NameKeys.UnloadStrategy_No_Strategy, "getLayoutResId", "enabled", "setScrollEnabled", "setNestedScrollAsChild", "setNestedScrollingEnabled", "a", "ScrollCoordinator_release"}, k = 1, mv = {1, 6, 0})
public final class ScrollCoordinatorLayout extends ScrollCoordinatorToolbarLayout<ScrollCoordinatorAppBarLayout> implements NestedScrollingChild2 {
    public static final /* synthetic */ int y = 0;
    public final LynxUIScrollCoordinator g;
    public float h;
    public float i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public Boolean n;
    public Boolean o;
    public final NestedScrollingChildHelper p;
    public VelocityTracker q;
    public final OverScroller r;
    public int s;
    public int t;
    public final int[] u;
    public final int[] v;
    public final int[] w;
    public Method x;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.xelement.scroll.coordinator.ScrollCoordinatorToolbarLayout
    public int getLayoutResId() {
        return 2131564429;
    }

    public final void c() {
        this.s++;
        if (this.r.isFinished() == true) goto L6;
        this.r.forceFinished(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        if (this.k == true) goto L5;
    L7:
        super/*android.view.ViewGroup*/.computeScroll();
        return;
    L5:
        if (this.r.computeScrollOffset() == false) goto L7;
        final int r0 = this.s;
        final int r1 = this.r.getCurrY() - ((ScrollCoordinatorAppBarLayout) getAppBarLayoutView()).getTopAndBottomOffset();
        ViewCompat.postOnAnimation(this, new e(r0, this, r1));
        ViewCompat.postInvalidateOnAnimation(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean hasNestedScrollingParent() {
        if (this.k == false) goto L6;
        return hasNestedScrollingParent(0);
    L6:
        return super/*android.view.ViewGroup*/.hasNestedScrollingParent();
    }

    public final boolean isNestedScrollingEnabled() {
        return this.p.isNestedScrollingEnabled();
    }

    public final void stopNestedScroll() {
        if (this.k == false) goto L6;
        stopNestedScroll(0);
        return;
    }

    public CollapsingToolbarLayout getCollapsingToolbarLayout() {
        return getCollapsingToolbar();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        return super/*android.view.ViewGroup*/.performClick();
    }

    public final int a(int r9) {
        ViewGroup.LayoutParams r0 = ((ScrollCoordinatorAppBarLayout) getAppBarLayoutView()).getLayoutParams();
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == false) goto L5;
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0;
    L7:
        if (r1 != null) goto L9;
        return 0;
    L9:
        AppBarLayout.Behavior r2 = r1.getBehavior();
        if ((r2 instanceof AppBarLayout.Behavior) == false) goto L12;
        AppBarLayout.Behavior r3 = r2;
    L13:
        if (r3 != null) goto L15;
        return 0;
    L15:
        int r4 = r3.getTopAndBottomOffset();
        int r10 = RangesKt.coerceIn(r4 - r9, -getAppBarLayoutView().getTotalScrollRange(), 0);
        if (r10 != r4) goto L18;
        return 0;
    L18:
        r3.setTopAndBottomOffset(r10);
    L29:
        LLog.e("ScrollCoordinatorLayout", "dispatchOffsetUpdate fail, offset is" + getAppBarLayoutView().getTopAndBottomOffset());
        this.x = null;
    L31:
        return r4 - r10;
    L20:
        if (this.x != null) goto L25;
        Method r5 = getAppBarLayoutView().getClass().getSuperclass().getSuperclass().getDeclaredMethod("dispatchOffsetUpdates", new Class[]{Integer.TYPE});     // Catch: Exception -> L29
        this.x = r5;     // Catch: Exception -> L29
        if (r5 == null) goto L25;
        r5.setAccessible(true);     // Catch: Exception -> L29
    L25:
        Method r6 = this.x;     // Catch: Exception -> L29
        if (r6 == null) goto L31;
        r6.invoke(getAppBarLayoutView(), new Object[]{Integer.valueOf(getAppBarLayoutView().getTopAndBottomOffset())});     // Catch: Exception -> L29
        goto L31
    L12:
        r3 = null;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final boolean b(MotionEvent r3) {
        if (this.g.isEnableNewGesture() == false) goto L17;
        Boolean r0 = this.n;
        if (r0 == null) goto L18;
        Intrinsics.checkNotNull(r0);
        if (r0.booleanValue() == false) goto L9;
        return false;
    L9:
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L20;
        return true;
    L20:
        return false;
    L11:
        if (r3.getActionMasked() != 0) goto L13;
        r4 = true;
        goto L14
    L18:
        return false;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (this.g.isEnableNewGesture() == false) goto L18;
        Boolean r0 = this.n;
        if (r0 == null) goto L10;
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == false) goto L10;
        return true;
    L10:
        if (this.n == null) goto L18;
        if (this.m == true) goto L18;
        if (r4 == null) goto L16;
        r4.setAction(0);
    L16:
        this.m = true;
    L18:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.p.hasNestedScrollingParent(r2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        if (this.g.isEnableNewGesture() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return false;
    L11:
        if (b(r7) == false) goto L14;
        return false;
    L14:
        if (this.g.isEnableNewGesture() == true) goto L16;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == true) goto L21;
    L23:
        boolean r2 = false;
    L24:
        if (r2 == true) goto L26;
        this.j = false;
        if (r7 == null) goto L30;
        Integer r3 = Integer.valueOf(r7.getAction());
    L32:
        if (r3 != null) goto L35;
    L39:
        if (r3 != null) goto L42;
    L44:
        if (r3 != null) goto L47;
    L55:
        if (getScrollEnabledFlag() == true) goto L58;
        return this.j;
    L58:
        return super.onInterceptTouchEvent(r7);
    L47:
        if (r3.intValue() != 2) goto L55;
        if (getScrollEnabledFlag() == true) goto L55;
        float r4 = r7.getX();
        float r5 = r7.getY();
        if (Math.abs(r4 - this.h) < Math.abs(r5 - this.i)) goto L53;
        this.h = r4;
        this.i = r5;
        this.j = false;
        goto L55
    L53:
        this.j = true;
        goto L55
    L42:
        if (r3.intValue() != 1) goto L44;
        this.h = r7.getX();
        this.i = r7.getY();
        goto L55
    L35:
        if (r3.intValue() != 0) goto L39;
        this.h = r7.getX();
        this.i = r7.getY();
        c();
        if (this.k == false) goto L55;
        this.t = (int) (r7.getY() + 0.5f);
        startNestedScroll(2, 0);
        goto L55
    L30:
        r3 = null;
        goto L32
    L26:
        return Intrinsics.areEqual(this.o, Boolean.TRUE);
    L21:
        if (Intrinsics.areEqual(this.o, Boolean.TRUE) == false) goto L23;
        r2 = true;
        goto L24
    L16:
        if (this.o == null) goto L18;
        r1 = true;
        goto L19
    L5:
        if (this.g.getIncludeNativeGesture() == true) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r15) {
        if (b(r15) == false) goto L6;
        return false;
    L6:
        if (this.g.isEnableNewGesture() == true) goto L8;
    L10:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L43;
        if (r15 == null) goto L15;
        Integer r1 = Integer.valueOf(r15.getActionMasked());
    L16:
        if (r1 != null) goto L19;
    L21:
        if (r1 != null) goto L24;
    L29:
        if (r1 != null) goto L32;
    L34:
        if (r1 != null) goto L37;
    L39:
        boolean r2 = false;
    L40:
        if (r2 == false) goto L43;
        this.o = null;
        goto L43
    L37:
        if (r1.intValue() != 3) goto L39;
    L38:
        r2 = true;
        goto L40
    L32:
        if (r1.intValue() != 1) goto L34;
    L24:
        if (r1.intValue() != 2) goto L29;
        getParent().requestDisallowInterceptTouchEvent(this.j);
        Boolean r3 = this.o;
        Boolean r4 = Boolean.TRUE;
        boolean r5 = Intrinsics.areEqual(r3, r4);
        if (Intrinsics.areEqual(this.o, r4) == false) goto L28;
        return r5;
    L28:
        return super.onTouchEvent(r15);
    L19:
        if (r1.intValue() != 0) goto L21;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L43
    L15:
        r1 = null;
    L43:
        if (getScrollEnabledFlag() == true) goto L46;
        return false;
    L46:
        if (this.k == true) goto L48;
        boolean r6 = super.onTouchEvent(r15);
    L49:
        if (r15 != null) goto L52;
        return true;
    L52:
        if (this.k == true) goto L54;
    L59:
        int r7 = (int) (r15.getY() + 0.5f);
        int r16 = r15.getActionMasked();
        if (r16 == 0) goto L111;
        if (r16 == 1) goto L89;
        if (r16 == 2) goto L71;
        if (r16 == 3) goto L66;
    L118:
        return r6;
    L66:
        if (this.k == false) goto L118;
        stopNestedScroll(0);
        VelocityTracker r17 = this.q;
        if (r17 == null) goto L70;
        r17.recycle();
    L70:
        this.q = null;
        goto L118
    L71:
        int r18 = this.t - r7;
        if (this.l == true) goto L79;
        if (Math.abs(r18) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L79;
        this.l = true;
        if (this.k == false) goto L79;
        getParent().requestDisallowInterceptTouchEvent(true);
    L79:
        if (this.k == false) goto L118;
        if (this.l == false) goto L118;
        if (dispatchNestedPreScroll(0, r18, this.v, this.u, 0) == false) goto L85;
        r18 = r18 - this.v[1];
        int[] r8 = this.w;
        int r9 = r8[0];
        int[] r10 = this.u;
        r8[0] = r9 + r10[0];
        r8[1] = r8[1] + r10[1];
    L85:
        this.t = r7 - this.u[1];
        int r11 = a(r18);
        if (dispatchNestedScroll(0, r11, 0, r18 - r11, this.u, 0) == false) goto L118;
        int r19 = this.t;
        int[] r12 = this.u;
        int r13 = r12[1];
        this.t = r19 - r13;
        int[] r110 = this.w;
        r110[0] = r110[0] + r12[0];
        r110[1] = r110[1] + r13;
        goto L118
    L89:
        if (this.k == false) goto L103;
        if (this.l == false) goto L103;
        VelocityTracker r111 = this.q;
        if (r111 == null) goto L95;
        r111.computeCurrentVelocity(1000);
    L95:
        VelocityTracker r112 = this.q;
        if (r112 == null) goto L98;
        float r113 = r112.getYVelocity();
    L100:
        if (Math.abs(r113) <= ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity()) goto L103;
        int r14 = ((ScrollCoordinatorAppBarLayout) getAppBarLayoutView()).getTopAndBottomOffset();
        int r20 = ((ScrollCoordinatorAppBarLayout) getAppBarLayoutView()).getTotalScrollRange();
        this.s++;
        this.r.fling(0, r14, 0, (int) r113, 0, 0, -r20, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L103
    L98:
        r113 = 0.0f;
    L103:
        if (this.l == true) goto L106;
        super/*android.view.ViewGroup*/.performClick();
    L106:
        if (this.k == false) goto L118;
        stopNestedScroll(0);
        VelocityTracker r114 = this.q;
        if (r114 == null) goto L110;
        r114.recycle();
    L110:
        this.q = null;
        goto L118
    L111:
        c();
        this.t = r7;
        this.l = false;
        int[] r115 = this.w;
        r115[0] = 0;
        r115[1] = 0;
        if (this.k == false) goto L118;
        VelocityTracker r116 = this.q;
        if (r116 != null) goto L116;
        this.q = VelocityTracker.obtain();
    L117:
        startNestedScroll(2, 0);
        goto L118
    L116:
        r116.clear();
        goto L117
    L54:
        if (this.q != null) goto L56;
        this.q = VelocityTracker.obtain();
    L56:
        VelocityTracker r21 = this.q;
        if (r21 == null) goto L59;
        r21.addMovement(r15);
        goto L59
    L48:
        r6 = true;
        goto L49
    L8:
        if (this.o == null) goto L10;
        r0 = true;
        goto L12
    }

    public final void setConsumeGesture(boolean r2) {
        this.n = Boolean.valueOf(r2);
        if (r2 == false) goto L6;
        this.m = false;
        return;
    }

    public final void setInterceptGesture(boolean r1) {
        this.o = Boolean.valueOf(r1);
    }

    public final void setNestedScrollAsChild(boolean r1) {
        this.k = r1;
        setNestedScrollingEnabled(r1);
    }

    public void setNestedScrollingEnabled(boolean r2) {
        this.p.setNestedScrollingEnabled(r2);
    }

    @Override // com.lynx.xelement.scroll.coordinator.ScrollCoordinatorToolbarLayout
    public void setScrollEnabled(boolean r1) {
        setScrollEnabledFlag(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean startNestedScroll(int r2) {
        if (this.k == false) goto L6;
        return startNestedScroll(r2, 0);
    L6:
        return super/*android.view.ViewGroup*/.startNestedScroll(r2);
    }

    public final void stopNestedScroll(int r2) {
        this.p.stopNestedScroll(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollCoordinatorLayout(Context r2, LynxUIScrollCoordinator r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "coordinatorHost");
        new LinkedHashMap();
        super(r2);
        this.g = r3;
        this.m = true;
        this.p = new NestedScrollingChildHelper(this);
        this.r = new OverScroller(r2);
        this.u = new int[2];
        this.v = new int[2];
        this.w = new int[2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        if (this.k == false) goto L6;
        return this.p.dispatchNestedPreFling(r2, r3);
    L6:
        return super/*android.view.ViewGroup*/.dispatchNestedPreFling(r2, r3);
    }

    public final boolean startNestedScroll(int r2, int r3) {
        return this.p.startNestedScroll(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        if (this.k == false) goto L6;
        return this.p.dispatchNestedFling(r2, r3, r4);
    L6:
        return super/*android.view.ViewGroup*/.dispatchNestedFling(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchNestedPreScroll(int r8, int r9, int[] r10, int[] r11) {
        if (this.k == false) goto L6;
        return dispatchNestedPreScroll(r8, r9, r10, r11, 0);
    L6:
        return super/*android.view.ViewGroup*/.dispatchNestedPreScroll(r8, r9, r10, r11);
    }

    public final void onNestedPreScroll(View r3, int r4, int r5, int[] r6) {
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r6, "consumed");
        if (this.k == false) goto L5;
        int[] r1 = {0, 0};
        super.onNestedPreScroll(r3, r4, r5, r1);
        int[] r7 = {0, 0};
        dispatchNestedPreScroll(r4, r5, r7, null);
        r6[0] = r1[0] + r7[0];
        r6[1] = r1[1] + r7[1];
        return;
    L5:
        super.onNestedPreScroll(r3, r4, r5, r6);
    }

    public final boolean onStartNestedScroll(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        boolean r6 = super.onStartNestedScroll(r2, r3, r4, r5);
        if (this.k == true) goto L6;
        return r6;
    L6:
        if ((r4 & 2) == 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
    L12:
        if (r6 == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        if (startNestedScroll(r4) == false) goto L12;
        return true;
    L8:
        r7 = false;
        goto L9
    }

    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.p.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13) {
        if (this.k == false) goto L6;
        return dispatchNestedScroll(r9, r10, r11, r12, r13, 0);
    L6:
        return super/*android.view.ViewGroup*/.dispatchNestedScroll(r9, r10, r11, r12, r13);
    }

    public final void onNestedPreScroll(View r9, int r10, int r11, int[] r12, int r13) {
        Intrinsics.checkNotNullParameter(r9, "target");
        Intrinsics.checkNotNullParameter(r12, "consumed");
        if (this.k == false) goto L5;
        int[] r7 = {0, 0};
        super.onNestedPreScroll(r9, r10, r11, r7, r13);
        int[] r14 = {0, 0};
        dispatchNestedPreScroll(r10, r11, r14, null);
        r12[0] = r7[0] + r14[0];
        r12[1] = r7[1] + r14[1];
        return;
    L5:
        super.onNestedPreScroll(r9, r10, r11, r12, r13);
    }

    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r7, "target");
        super.onNestedScroll(r7, r8, r9, r10, r11);
        if (this.k == true) goto L5;
        return;
    L5:
        if (getAppBarLayoutView().getTopAndBottomOffset() != 0) goto L9;
        dispatchNestedScroll(r8, r9, r10, r11, null);
        return;
    }

    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.p.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r8, "target");
        super.onNestedScroll(r8, r9, r10, r11, r12, r13);
        if (this.k == true) goto L5;
        return;
    L5:
        if (getAppBarLayoutView().getTopAndBottomOffset() != 0) goto L9;
        dispatchNestedScroll(r9, r10, r11, r12, null, r13);
        return;
    }
}
