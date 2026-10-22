package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NestedHorizontalScrollView extends HorizontalScrollView implements NestedScrollingParent2, NestedScrollingChild2 {
    public boolean a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final int[] k;
    public final int[] l;
    public final UIScrollView m;
    public OverScroller n;
    public VelocityTracker o;
    public NestedScrollingParentHelper p;
    public NestedScrollingChildHelper q;
    public g7a.b r;

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void computeScroll() {
        if (this.a == false) goto L36;
        OverScroller r8 = getHScroller();
        if (r8 == null) goto L36;
        if (r8.computeScrollOffset() == false) goto L28;
        int r15 = r8.getCurrX();
        int r10 = r15 - this.j;
        if (dispatchNestedPreScroll(r10, 0, this.l, null, 1) == false) goto L12;
        r10 = r10 - this.l[0];
    L12:
        int r0 = r10;
        if (r0 == 0) goto L26;
        int r12 = this.m.u0();
        int r1 = getScrollX();
        int r2 = r1 + r0;
        if (r2 < 0) goto L19;
        if (r2 > r12) goto L19;
        boolean r3 = false;
    L20:
        int r4 = MathUtils.clamp(r2, 0, r12);
        if (r3 == true) goto L23;
    L25:
        super.scrollTo(r4, getScrollY());
        int r5 = getScrollX() - r1;
        dispatchNestedScroll(r5, 0, r0 - r5, 0, null, 1);
        goto L26
    L23:
        if (hasNestedScrollingParent(1) == true) goto L25;
        r8.springBack(r4, 0, 0, r12, 0, 0);
    L19:
        r3 = true;
    L26:
        this.j = r15;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L28:
        if (hasNestedScrollingParent(1) == false) goto L30;
        stopNestedScroll(1);
    L30:
        this.j = 0;
        g7a.b r6 = this.r;
        if (r6 != null) goto L33;
        return;
    L33:
        if (this.c == false) goto L40;
        r6.a();
        return;
    L40:
        return;
    L36:
        super.computeScroll();
    }

    public OverScroller getHScroller() {
        OverScroller r1 = this.n;
        if (r1 == null) goto L15;
        return r1;
    L15:
        Field r2 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if (r2 == null) goto L14;
        r2.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        Object r3 = r2.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if ((r3 instanceof OverScroller) == false) goto L14;
        this.n = (OverScroller) r3;     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
    L14:
        return this.n;
    L11:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mScroller of HorizontalScrollView!");
    L12:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mScroller field of HorizontalScrollView!");
        goto L14
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.p.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.q.isNestedScrollingEnabled();
    }

    public final void a(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.d) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.e = (int) r4.getX(r1);
        this.d = r4.getPointerId(r1);
        VelocityTracker r5 = this.o;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int r13) {
        if (this.a == false) goto L11;
        OverScroller r1 = getHScroller();
        if (r1 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        startNestedScroll(1, 1);
        r1.fling(getScrollX(), getScrollY(), r13, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.j = getScrollX();
        return;
    L13:
        return;
    L11:
        super.fling(r13);
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.q.hasNestedScrollingParent(r2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r13) {
        if (this.a == true) goto L7;
        return super.onInterceptTouchEvent(r13);
    L7:
        if (this.c == false) goto L13;
        g7a.b r0 = this.r;
        if (r0 == null) goto L13;
        return r0.b();
    L13:
        if (r13.getAction() == 2) goto L15;
    L17:
        int r1 = r13.getActionMasked();
        if (r1 != 0) goto L20;
        int r2 = (int) r13.getX();
        int r3 = (int) r13.getY();
        if (getChildCount() <= 0) goto L65;
        int r5 = getScrollX();
        View r6 = getChildAt(0);
        if (r3 < r6.getTop()) goto L65;
        if (r3 >= r6.getBottom()) goto L65;
        if (r2 < (r6.getLeft() - r5)) goto L65;
        if (r2 >= (r6.getRight() - r5)) goto L65;
        boolean r4 = true;
    L66:
        if (r4 == true) goto L70;
        this.b = false;
        VelocityTracker r14 = this.o;
        if (r14 == null) goto L79;
        r14.recycle();
        this.o = null;
    L79:
        return this.b;
    L70:
        VelocityTracker r7 = this.o;
        if (r7 != null) goto L73;
        this.o = VelocityTracker.obtain();
    L74:
        this.o.addMovement(r13);
        this.d = r13.getPointerId(0);
        this.e = r2;
        OverScroller r15 = getHScroller();
        if (r15 == null) goto L77;
        r15.computeScrollOffset();
        this.b = !getHScroller().isFinished();
    L77:
        startNestedScroll(1, 0);
        goto L79
    L73:
        r7.clear();
    L65:
        r4 = false;
        goto L66
    L20:
        if (r1 == 1) goto L45;
        if (r1 != 2) goto L23;
        int r8 = this.d;
        if (r8 == (-1)) goto L79;
        int r9 = r13.findPointerIndex(r8);
        if (r9 == (-1)) goto L79;
        int r10 = (int) r13.getX(r9);
        if (Math.abs(r10 - this.e) <= this.f) goto L79;
        if ((getNestedScrollAxes() & 1) != 0) goto L79;
        this.b = true;
        this.e = r10;
        if (this.o != null) goto L41;
        this.o = VelocityTracker.obtain();
    L41:
        this.o.addMovement(r13);
        ViewParent r16 = getParent();
        if (r16 == null) goto L44;
        r16.requestDisallowInterceptTouchEvent(true);
    L44:
        this.i = 0;
        goto L79
    L23:
        if (r1 == 3) goto L45;
        if (r1 != 6) goto L79;
        a(r13);
    L45:
        this.b = false;
        this.d = -1;
        VelocityTracker r17 = this.o;
        if (r17 == null) goto L48;
        r17.recycle();
        this.o = null;
    L48:
        int r11 = this.m.u0();
        if (getHScroller() != null) goto L51;
    L53:
        stopNestedScroll(0);
        goto L79
    L51:
        if (getHScroller().springBack(getScrollX(), getScrollY(), 0, r11, 0, 0) == false) goto L53;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L53
    L15:
        if (this.b == false) goto L17;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r2) {
        onStopNestedScroll(r2, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r15) {
        if (this.a == true) goto L7;
        return super.onTouchEvent(r15);
    L7:
        if (this.c == true) goto L9;
    L11:
        int r0 = r15.getActionMasked();
        if (this.o != null) goto L14;
        this.o = VelocityTracker.obtain();
    L14:
        MotionEvent r2 = MotionEvent.obtain(r15);
        if (r0 != 0) goto L17;
        this.i = 0;
    L17:
        r2.offsetLocation(this.i, 0.0f);
        if (r0 == 0) goto L110;
        if (r0 != 1) goto L22;
        VelocityTracker r16 = this.o;
        r16.computeCurrentVelocity(1000, this.h);
        int r17 = -((int) r16.getXVelocity(this.d));
        int r11 = this.m.u0();
        OverScroller r7 = getHScroller();
        if (getChildCount() > 0) goto L88;
    L105:
        this.b = false;
        this.d = -1;
        VelocityTracker r18 = this.o;
        if (r18 == null) goto L108;
        r18.recycle();
        this.o = null;
    L108:
        stopNestedScroll(0);
    L121:
        VelocityTracker r19 = this.o;
        if (r19 == null) goto L124;
        r19.addMovement(r2);
    L124:
        r2.recycle();
        return true;
    L88:
        if (Math.abs(r17) > this.g) goto L90;
        if (r7 == null) goto L105;
        if (r7.springBack(getScrollX(), getScrollY(), 0, r11, 0, 0) == false) goto L105;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L105
    L90:
        if (getScrollX() > 0) goto L93;
        if (r17 > 0) goto L93;
    L96:
        boolean r1 = false;
    L98:
        float r8 = r17;
        if (dispatchNestedPreFling(r8, 0.0f) == true) goto L105;
        dispatchNestedFling(r8, 0.0f, r1);
        fling(r17);
    L93:
        if (getScrollX() < r11) goto L97;
        if (r17 >= 0) goto L96;
    L97:
        r1 = true;
        goto L98
    L22:
        if (r0 != 2) goto L24;
        int r3 = r15.findPointerIndex(this.d);
        if (r3 == (-1)) goto L121;
        int r110 = (int) r15.getX(r3);
        int r4 = this.e - r110;
        if (dispatchNestedPreScroll(r4, 0, this.l, this.k, 0) == false) goto L54;
        r4 = r4 - this.l[0];
        r2.offsetLocation(this.k[0], 0.0f);
        this.i += this.k[0];
    L54:
        if (this.b == true) goto L64;
        if (Math.abs(r4) <= this.f) goto L64;
        this.b = true;
        ViewParent r5 = getParent();
        if (r5 == null) goto L60;
        r5.requestDisallowInterceptTouchEvent(true);
    L60:
        if (r4 <= 0) goto L62;
        r4 = r4 - this.f;
        goto L64
    L62:
        r4 = r4 + this.f;
    L64:
        if (this.b == false) goto L121;
        this.e = r110 - this.k[0];
        int r9 = this.m.u0();
        int r111 = getScrollX();
        int r6 = r111 + r4;
        if (r6 < 0) goto L70;
        if (r6 > r9) goto L70;
        boolean r12 = false;
    L71:
        int r13 = MathUtils.clamp(r6, 0, r9);
        OverScroller r10 = getHScroller();
        if (r12 == true) goto L74;
    L77:
        super.scrollTo(r13, getScrollY());
        if (r12 == true) goto L80;
    L82:
        int r14 = getScrollX() - r111;
        if (dispatchNestedScroll(r14, 0, r4 - r14, 0, this.k, 0) == false) goto L121;
        int r112 = this.e;
        int r20 = this.k[0];
        this.e = r112 - r20;
        this.i += r20;
        r2.offsetLocation(r20, 0.0f);
        goto L121
    L80:
        if (hasNestedScrollingParent(0) == true) goto L82;
        this.o.clear();
        goto L82
    L74:
        if (hasNestedScrollingParent(1) == true) goto L77;
        if (r10 == null) goto L77;
        r10.springBack(r13, 0, 0, r9, 0, 0);
    L70:
        r12 = true;
        goto L71
    L24:
        if (r0 != 3) goto L26;
        int r113 = this.m.u0();
        OverScroller r21 = getHScroller();
        if (this.b == true) goto L38;
    L43:
        this.b = false;
        this.d = -1;
        VelocityTracker r114 = this.o;
        if (r114 == null) goto L46;
        r114.recycle();
        this.o = null;
    L46:
        stopNestedScroll(0);
        goto L121
    L38:
        if (getChildCount() <= 0) goto L43;
        if (r21 == null) goto L43;
        if (r21.springBack(getScrollX(), getScrollY(), 0, r113, 0, 0) == false) goto L43;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L43
    L26:
        if (r0 != 5) goto L28;
        int r22 = r15.getActionIndex();
        this.e = (int) r15.getX(r22);
        this.d = r15.getPointerId(r22);
        goto L121
    L28:
        if (r0 != 6) goto L121;
        a(r15);
        int r23 = r15.findPointerIndex(this.d);
        if (r23 == (-1)) goto L121;
        this.e = (int) r15.getX(r23);
        goto L121
    L110:
        if (getChildCount() != 0) goto L112;
        return false;
    L112:
        OverScroller r24 = getHScroller();
        if (r24 == null) goto L120;
        boolean r25 = !r24.isFinished();
        this.b = r25;
        if (r25 == false) goto L119;
        ViewParent r26 = getParent();
        if (r26 == null) goto L119;
        r26.requestDisallowInterceptTouchEvent(true);
    L119:
        r24.abortAnimation();
    L120:
        this.e = (int) r15.getX();
        this.d = r15.getPointerId(0);
        startNestedScroll(1, 0);
        goto L121
    L9:
        if (this.r == null) goto L11;
        return false;
    }

    public void setEnableNewBounce(boolean r1) {
        this.c = r1;
    }

    public void setEnableNewNested(boolean r1) {
        this.a = r1;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.q.setNestedScrollingEnabled(r2);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    public final void stopNestedScroll(int r2) {
        this.q.stopNestedScroll(r2);
    }

    public NestedHorizontalScrollView(Context r3, UIScrollView r4) {
        super(r3);
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = -1;
        this.k = new int[2];
        this.l = new int[2];
        this.m = r4;
        this.p = new NestedScrollingParentHelper(this);
        this.q = new NestedScrollingChildHelper(this);
        this.r = new g7a.b(this, false, this.p);
        ViewConfiguration r5 = ViewConfiguration.get(getContext());
        this.f = r5.getScaledTouchSlop();
        this.g = r5.getScaledMinimumFlingVelocity();
        this.h = r5.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(false);
    }

    public final void b(int r2, int r3) {
        if (this.a == true) goto L5;
    L7:
        super.smoothScrollTo(r2, r3);
        return;
    L5:
        if (getHScroller() == null) goto L7;
        this.j = getScrollX();
        goto L7
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float r2, float r3) {
        return this.q.dispatchNestedPreFling(r2, r3);
    }

    public final void onStopNestedScroll(View r2, int r3) {
        if (this.c == false) goto L8;
        g7a.b r0 = this.r;
        if (r0 == null) goto L8;
        r0.e(r3);
        return;
    L8:
        this.p.onStopNestedScroll(r2, r3);
        stopNestedScroll(r3);
    }

    public final boolean startNestedScroll(int r2, int r3) {
        return this.q.startNestedScroll(r2, r3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.q.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        if (this.c == false) goto L9;
        g7a.b r4 = this.r;
        if (r4 == null) goto L9;
        r4.getClass();
        return false;
    L9:
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r2, View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r4, float r5, float r6, boolean r7) {
        boolean r8 = false;
        if (this.c == false) goto L8;
        g7a.b r9 = this.r;
        if (r9 == null) goto L8;
        r9.getClass();
        return false;
    L8:
        if (r7 == true) goto L21;
        int r10 = getScrollX();
        int r11 = this.m.u0();
        if (r10 <= 0) goto L12;
    L13:
        if (r10 >= r11) goto L15;
    L16:
        r8 = true;
    L18:
        if (dispatchNestedPreFling(r5, 0.0f) == true) goto L20;
        dispatchNestedFling(r5, 0.0f, r8);
        fling((int) r5);
    L20:
        return true;
    L15:
        if (r5 >= 0.0f) goto L18;
    L12:
        if (r5 <= 0.0f) goto L18;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        dispatchNestedPreScroll(r8, r9, r10, null, 0);
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        if (this.c == false) goto L8;
        g7a.b r0 = this.r;
        if (r0 == null) goto L8;
        r0.g.onNestedScrollAccepted(r2, r3, r4, r5);
        return;
    L8:
        this.p.onNestedScrollAccepted(r2, r3, r4, r5);
        startNestedScroll(1, r5);
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        if (this.c == false) goto L15;
        g7a.b r5 = this.r;
        if (r5 == null) goto L15;
        if (r5.a == false) goto L9;
        int r6 = 2;
    L11:
        if ((r6 & r3) == 0) goto L18;
        return true;
    L18:
        return false;
    L9:
        r6 = 1;
    L15:
        if ((r3 & 1) == 0) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.q.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12) {
        return dispatchNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public final void onNestedPreScroll(View r9, int r10, int r11, int[] r12, int r13) {
        if (this.c == false) goto L8;
        g7a.b r1 = this.r;
        if (r1 == null) goto L8;
        r1.c(r9, r10, r11, r12, r13);
        return;
    L8:
        dispatchNestedPreScroll(r10, r11, r12, null, r13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12) {
        onNestedScroll(r8, r9, r10, r11, r12, 0);
    }

    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.q.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12, int r13) {
        if (this.c == false) goto L8;
        g7a.b r0 = this.r;
        if (r0 == null) goto L8;
        r0.d(r9, r10, r11, r12, r13);
        return;
    L8:
        int r14 = getScrollX();
        scrollBy(r11, 0);
        int r1 = getScrollX() - r14;
        dispatchNestedScroll(r1, 0, r11 - r1, 0, null, r13);
    }
}
