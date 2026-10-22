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
import com.lynx.base.log.LynxLog;
import gn.c;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NestedScrollView extends ScrollView implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingParentHelper f10630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollingChildHelper f10631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UIScrollView f10632c;
    public boolean d;
    public boolean e;
    public int f;
    public final int[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OverScroller f10633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f10634i;

    public NestedScrollView(Context r5, UIScrollView r10) {
        super(r5);
        this.d = false;
        this.e = false;
        this.g = new int[2];
        this.f10632c = r10;
        NestedScrollingParentHelper r11 = new NestedScrollingParentHelper(this);
        this.f10630a = r11;
        this.f10631b = new NestedScrollingChildHelper(this);
        this.f10634i = new c(this, true, r11);
        setNestedScrollingEnabled(true);
    }

    public final void a(int r5, int r10) {
        if (this.d == true) goto L5;
    L7:
        super.smoothScrollTo(r5, r10);
        return;
    L5:
        if (getVScroller() == null) goto L7;
        this.f = getScrollY();
        goto L7
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        if (this.d == false) goto L37;
        OverScroller r10 = getVScroller();
        if (r10 == null) goto L37;
        boolean r5 = r10.computeScrollOffset();
        NestedScrollingChildHelper r11 = this.f10631b;
        if (r5 == false) goto L29;
        int r15 = r10.getCurrY();
        int r12 = r15 - this.f;
        if (dispatchNestedPreScroll(0, r12, this.g, null, 1) == false) goto L12;
        r12 = r12 - this.g[1];
    L12:
        int r13 = r12;
        if (r13 == 0) goto L26;
        int r14 = this.f10632c.E();
        int r16 = getScrollY();
        int r17 = r16 + r13;
        if (r17 < 0) goto L19;
        if (r17 > r14) goto L19;
        boolean r18 = false;
    L20:
        int r19 = MathUtils.clamp(r17, 0, r14);
        if (r18 == true) goto L23;
    L25:
        super.scrollTo(getScrollX(), r19);
        int r20 = getScrollY() - r16;
        dispatchNestedScroll(0, r20, 0, r13 - r20, null, 1);
        goto L26
    L23:
        if (r11.hasNestedScrollingParent(1) == true) goto L25;
        r10.springBack(0, r19, 0, 0, 0, r14);
    L19:
        r18 = true;
    L26:
        this.f = r15;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L29:
        if (r11.hasNestedScrollingParent(1) == false) goto L31;
        r11.stopNestedScroll(1);
    L31:
        this.f = 0;
        c r21 = this.f10634i;
        if (r21 != null) goto L34;
        return;
    L34:
        if (this.e == false) goto L40;
        r21.a();
        return;
    L40:
        return;
    L37:
        super.computeScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public abstract boolean dispatchNestedFling(float r5, float r10, boolean r11);

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public abstract boolean dispatchNestedPreFling(float r5, float r10);

    public abstract boolean dispatchNestedPreScroll(int r5, int r10, int[] r11, int[] r12, int r13);

    public abstract boolean dispatchNestedScroll(int r5, int r10, int r11, int r12, int[] r13, int r14);

    @Override // android.widget.ScrollView
    public void fling(int r14) {
        LynxLog.b(2, "LynxNestedScrollView", "fling with vel = " + r14);
        if (this.d == false) goto L11;
        OverScroller r5 = getVScroller();
        if (r5 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        this.f10631b.startNestedScroll(2, 1);
        r5.fling(getScrollX(), getScrollY(), 0, r14, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.f = getScrollY();
        return;
    L13:
        return;
    L11:
        super.fling(r14);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f10630a.getNestedScrollAxes();
    }

    public OverScroller getVScroller() {
        OverScroller r5 = this.f10633h;
        if (r5 == null) goto L16;
        return r5;
    L16:
        Field r10 = ScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
        if (r10 == null) goto L15;
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
        Object r11 = r10.get(this);     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
        if ((r11 instanceof OverScroller) == false) goto L15;
        this.f10633h = (OverScroller) r11;     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
    L15:
        return this.f10633h;
    L12:
        LynxLog.b(4, "LynxNestedScrollView", "Failed to get mScroller of ScrollView!");
    L13:
        LynxLog.b(4, "LynxNestedScrollView", "Failed to get mScroller field of ScrollView!");
        goto L15
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f10631b.hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f10631b.isNestedScrollingEnabled();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.e == false) goto L9;
        c r10 = this.f10634i;
        if (r10 == null) goto L9;
        return r10.e();
    L9:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        boolean r13 = false;
        if (this.e == true) goto L5;
    L7:
        if (r12 == true) goto L20;
        int r14 = getScrollY();
        int r15 = this.f10632c.E();
        if (r14 <= 0) goto L11;
    L12:
        if (r14 >= r15) goto L14;
    L15:
        r13 = true;
    L17:
        if (dispatchNestedPreFling(0.0f, r11) == true) goto L19;
        dispatchNestedFling(0.0f, r11, r13);
        fling((int) r11);
    L19:
        return true;
    L14:
        if (r11 >= 0.0f) goto L17;
    L11:
        if (r11 <= 0.0f) goto L17;
    L20:
        return false;
    L5:
        if (this.f10634i == null) goto L7;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r5, float r10, float r11) {
        if (this.e == false) goto L9;
        if (this.f10634i == null) goto L9;
        return false;
    L9:
        return dispatchNestedPreFling(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        if (this.e == false) goto L8;
        c r5 = this.f10634i;
        if (r5 == null) goto L8;
        r5.d(r10, r11, r12, r13, r14);
        return;
    L8:
        dispatchNestedPreScroll(r11, r12, r13, null, r14);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        if (this.e == false) goto L8;
        c r5 = this.f10634i;
        if (r5 == null) goto L8;
        r5.c(r11, r12, r13, r14, r15);
        return;
    L8:
        int r16 = getScrollY();
        scrollBy(0, r14);
        int r17 = getScrollY() - r16;
        dispatchNestedScroll(0, r17, 0, r14 - r17, null, r15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        if (this.e == false) goto L8;
        c r13 = this.f10634i;
        if (r13 == null) goto L8;
        r13.g.onNestedScrollAccepted(r5, r10, r11, r12);
        return;
    L8:
        this.f10630a.onNestedScrollAccepted(r5, r10, r11, r12);
        this.f10631b.startNestedScroll(2, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        int r13 = 2;
        if (this.e == false) goto L15;
        c r14 = this.f10634i;
        if (r14 == null) goto L15;
        if (r14.f17110a == true) goto L11;
        r13 = 1;
    L11:
        if ((r11 & r13) == 0) goto L13;
        return true;
    L13:
        return false;
    L15:
        if ((r11 & 2) == 0) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r5, int r10) {
        if (this.e == false) goto L8;
        c r11 = this.f10634i;
        if (r11 == null) goto L8;
        r11.b(r10);
        return;
    L8:
        this.f10630a.onStopNestedScroll(r5, r10);
        this.f10631b.stopNestedScroll(r10);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (this.e == false) goto L9;
        if (this.f10634i == null) goto L9;
        return false;
    L9:
        return super.onTouchEvent(r5);
    }

    public void setEnableNewBounce(boolean r5) {
        this.e = r5;
    }

    public void setEnableNewNested(boolean r5) {
        this.d = r5;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        this.f10631b.setNestedScrollingEnabled(r5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r5) {
        return this.f10631b.startNestedScroll(r5, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f10631b.stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r5) {
        return this.f10631b.hasNestedScrollingParent(r5);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r5, int r10) {
        return this.f10631b.startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r5) {
        this.f10631b.stopNestedScroll(r5);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r5, View r10, int r11) {
        return onStartNestedScroll(r5, r10, r11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        dispatchNestedPreScroll(r11, r12, r13, null, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r5) {
        onStopNestedScroll(r5, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r5, View r10, int r11) {
        onNestedScrollAccepted(r5, r10, r11, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r10, r11, r12, r13, r14, 0);
    }
}
