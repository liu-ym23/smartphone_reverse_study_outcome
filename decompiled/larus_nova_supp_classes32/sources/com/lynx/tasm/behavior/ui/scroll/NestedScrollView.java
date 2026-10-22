package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NestedScrollView extends ScrollView implements NestedScrollingParent2, NestedScrollingChild2 {
    public final NestedScrollingParentHelper a;
    public final NestedScrollingChildHelper b;
    public final UIScrollView c;
    public boolean d;
    public boolean e;
    public int f;
    public final int[] g;
    public OverScroller h;
    public final g7a.b i;
    public boolean j;
    public boolean k;

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public void setPanInterceptAncestors(boolean r1) {
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        if (this.d == false) goto L36;
        OverScroller r8 = getVScroller();
        if (r8 == null) goto L36;
        if (r8.computeScrollOffset() == false) goto L28;
        int r15 = r8.getCurrY();
        int r10 = r15 - this.f;
        if (dispatchNestedPreScroll(0, r10, this.g, null, 1) == false) goto L12;
        r10 = r10 - this.g[1];
    L12:
        int r0 = r10;
        if (r0 == 0) goto L26;
        int r14 = this.c.u0();
        int r1 = getScrollY();
        int r2 = r1 + r0;
        if (r2 < 0) goto L19;
        if (r2 > r14) goto L19;
        boolean r3 = false;
    L20:
        int r4 = MathUtils.clamp(r2, 0, r14);
        if (r3 == true) goto L23;
    L25:
        super.scrollTo(getScrollX(), r4);
        int r5 = getScrollY() - r1;
        dispatchNestedScroll(0, r5, 0, r0 - r5, null, 1);
        goto L26
    L23:
        if (hasNestedScrollingParent(1) == true) goto L25;
        r8.springBack(0, r4, 0, 0, 0, r14);
    L19:
        r3 = true;
    L26:
        this.f = r15;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L28:
        if (hasNestedScrollingParent(1) == false) goto L30;
        stopNestedScroll(1);
    L30:
        this.f = 0;
        g7a.b r6 = this.i;
        if (r6 != null) goto L33;
        return;
    L33:
        if (this.e == false) goto L40;
        r6.a();
        return;
    L40:
        return;
    L36:
        super.computeScroll();
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.a.getNestedScrollAxes();
    }

    public OverScroller getVScroller() {
        OverScroller r1 = this.h;
        if (r1 == null) goto L15;
        return r1;
    L15:
        Field r2 = ScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if (r2 == null) goto L14;
        r2.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        Object r3 = r2.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if ((r3 instanceof OverScroller) == false) goto L14;
        this.h = (OverScroller) r3;     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
    L14:
        return this.h;
    L11:
        LLog.e("LynxNestedScrollView", "Failed to get mScroller of ScrollView!");
    L12:
        LLog.e("LynxNestedScrollView", "Failed to get mScroller field of ScrollView!");
        goto L14
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.b.isNestedScrollingEnabled();
    }

    @Override // android.widget.ScrollView
    public void fling(int r13) {
        LLog.i("LynxNestedScrollView", "fling with vel = " + r13);
        if (this.d == false) goto L11;
        OverScroller r1 = getVScroller();
        if (r1 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        startNestedScroll(2, 1);
        r1.fling(getScrollX(), getScrollY(), 0, r13, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.f = getScrollY();
        return;
    L13:
        return;
    L11:
        super.fling(r13);
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.b.hasNestedScrollingParent(r2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.e == false) goto L9;
        g7a.b r0 = this.i;
        if (r0 == null) goto L9;
        return r0.b();
    L9:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r2) {
        onStopNestedScroll(r2, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.e == false) goto L9;
        g7a.b r0 = this.i;
        if (r0 == null) goto L9;
        r0.getClass();
        return false;
    L9:
        return super.onTouchEvent(r2);
    }

    public void setEnableNewBounce(boolean r1) {
        this.e = r1;
    }

    public void setEnableNewNested(boolean r1) {
        this.d = r1;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.b.setNestedScrollingEnabled(r2);
    }

    public void setPanInterceptDescendants(boolean r1) {
        this.k = r1;
    }

    public void setPanInterceptSelf(boolean r1) {
        this.j = r1;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    public final void stopNestedScroll(int r2) {
        this.b.stopNestedScroll(r2);
    }

    public NestedScrollView(Context r2, UIScrollView r3) {
        super(r2);
        this.d = false;
        this.e = false;
        this.g = new int[2];
        this.j = false;
        this.k = false;
        this.c = r3;
        NestedScrollingParentHelper r4 = new NestedScrollingParentHelper(this);
        this.a = r4;
        this.b = new NestedScrollingChildHelper(this);
        this.i = new g7a.b(this, true, r4);
        setNestedScrollingEnabled(true);
    }

    public final void a(int r2, int r3) {
        if (this.d == true) goto L5;
    L7:
        super.smoothScrollTo(r2, r3);
        return;
    L5:
        if (getVScroller() == null) goto L7;
        this.f = getScrollY();
        goto L7
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float r2, float r3) {
        return this.b.dispatchNestedPreFling(r2, r3);
    }

    public final void onStopNestedScroll(View r2, int r3) {
        if (this.e == false) goto L8;
        g7a.b r0 = this.i;
        if (r0 == null) goto L8;
        r0.e(r3);
        return;
    L8:
        this.a.onStopNestedScroll(r2, r3);
        stopNestedScroll(r3);
    }

    public final boolean startNestedScroll(int r2, int r3) {
        return this.b.startNestedScroll(r2, r3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.b.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        if (this.e == false) goto L9;
        g7a.b r4 = this.i;
        if (r4 == null) goto L9;
        r4.getClass();
        return false;
    L9:
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r2, View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r4, float r5, float r6, boolean r7) {
        boolean r8 = false;
        if (this.e == false) goto L8;
        g7a.b r9 = this.i;
        if (r9 == null) goto L8;
        r9.getClass();
        return false;
    L8:
        if (r7 == true) goto L21;
        int r10 = getScrollY();
        int r11 = this.c.u0();
        if (r10 <= 0) goto L12;
    L13:
        if (r10 >= r11) goto L15;
    L16:
        r8 = true;
    L18:
        if (dispatchNestedPreFling(0.0f, r6) == true) goto L20;
        dispatchNestedFling(0.0f, r6, r8);
        fling((int) r6);
    L20:
        return true;
    L15:
        if (r6 >= 0.0f) goto L18;
    L12:
        if (r6 <= 0.0f) goto L18;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        dispatchNestedPreScroll(r8, r9, r10, null, 0);
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        if (this.e == false) goto L8;
        g7a.b r0 = this.i;
        if (r0 == null) goto L8;
        r0.g.onNestedScrollAccepted(r2, r3, r4, r5);
        return;
    L8:
        this.a.onNestedScrollAccepted(r2, r3, r4, r5);
        startNestedScroll(2, r5);
    }

    public final boolean onStartNestedScroll(View r2, View r3, int r4, int r5) {
        int r6 = 2;
        if (this.e == false) goto L15;
        g7a.b r7 = this.i;
        if (r7 == null) goto L15;
        if (r7.a == true) goto L11;
        r6 = 1;
    L11:
        if ((r4 & r6) == 0) goto L18;
        return true;
    L18:
        return false;
    L15:
        if ((r4 & 2) == 0) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.b.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12) {
        return dispatchNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public final void onNestedPreScroll(View r9, int r10, int r11, int[] r12, int r13) {
        if (this.e == false) goto L8;
        g7a.b r1 = this.i;
        if (r1 == null) goto L8;
        r1.c(r9, r10, r11, r12, r13);
        return;
    L8:
        dispatchNestedPreScroll(r10, r11, r12, null, r13);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12) {
        onNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.b.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12, int r13) {
        if (this.e == false) goto L8;
        g7a.b r0 = this.i;
        if (r0 == null) goto L8;
        r0.d(r9, r10, r11, r12, r13);
        return;
    L8:
        int r14 = getScrollY();
        scrollBy(0, r12);
        int r2 = getScrollY() - r14;
        dispatchNestedScroll(0, r2, 0, r12 - r2, null, r13);
    }
}
