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
import com.lynx.base.log.LynxLog;
import gn.c;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NestedHorizontalScrollView extends HorizontalScrollView implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10618c;
    public int d;
    public int e;
    public int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f10622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f10623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UIScrollView f10624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OverScroller f10625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VelocityTracker f10626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final NestedScrollingParentHelper f10627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final NestedScrollingChildHelper f10628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f10629r;

    public NestedHorizontalScrollView(Context r5, UIScrollView r10) {
        super(r5);
        this.f10616a = false;
        this.f10617b = false;
        this.f10618c = false;
        this.d = -1;
        this.f10622k = new int[2];
        this.f10623l = new int[2];
        this.f10624m = r10;
        NestedScrollingParentHelper r11 = new NestedScrollingParentHelper(this);
        this.f10627p = r11;
        this.f10628q = new NestedScrollingChildHelper(this);
        this.f10629r = new c(this, false, r11);
        ViewConfiguration r12 = ViewConfiguration.get(getContext());
        this.f = r12.getScaledTouchSlop();
        this.g = r12.getScaledMinimumFlingVelocity();
        this.f10619h = r12.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(false);
    }

    public final void a(int r5, int r10) {
        if (this.f10616a == true) goto L5;
    L7:
        super.smoothScrollTo(r5, r10);
        return;
    L5:
        if (getHScroller() == null) goto L7;
        this.f10621j = getScrollX();
        goto L7
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void computeScroll() {
        if (this.f10616a == false) goto L37;
        OverScroller r10 = getHScroller();
        if (r10 == null) goto L37;
        boolean r5 = r10.computeScrollOffset();
        NestedScrollingChildHelper r11 = this.f10628q;
        if (r5 == false) goto L29;
        int r15 = r10.getCurrX();
        int r12 = r15 - this.f10621j;
        if (dispatchNestedPreScroll(r12, 0, this.f10623l, null, 1) == false) goto L12;
        r12 = r12 - this.f10623l[0];
    L12:
        int r13 = r12;
        if (r13 == 0) goto L26;
        int r14 = this.f10624m.E();
        int r16 = getScrollX();
        int r17 = r16 + r13;
        if (r17 < 0) goto L19;
        if (r17 > r14) goto L19;
        boolean r18 = false;
    L20:
        int r19 = MathUtils.clamp(r17, 0, r14);
        if (r18 == true) goto L23;
    L25:
        super.scrollTo(r19, getScrollY());
        int r20 = getScrollX() - r16;
        dispatchNestedScroll(r20, 0, r13 - r20, 0, null, 1);
        goto L26
    L23:
        if (r11.hasNestedScrollingParent(1) == true) goto L25;
        r10.springBack(r19, 0, 0, r14, 0, 0);
    L19:
        r18 = true;
    L26:
        this.f10621j = r15;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L29:
        if (r11.hasNestedScrollingParent(1) == false) goto L31;
        r11.stopNestedScroll(1);
    L31:
        this.f10621j = 0;
        c r21 = this.f10629r;
        if (r21 != null) goto L34;
        return;
    L34:
        if (this.f10618c == false) goto L40;
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

    @Override // android.widget.HorizontalScrollView
    public void fling(int r13) {
        if (this.f10616a == false) goto L11;
        OverScroller r5 = getHScroller();
        if (r5 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        this.f10628q.startNestedScroll(1, 1);
        r5.fling(getScrollX(), getScrollY(), r13, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.f10621j = getScrollX();
        return;
    L13:
        return;
    L11:
        super.fling(r13);
    }

    public OverScroller getHScroller() {
        OverScroller r5 = this.f10625n;
        if (r5 == null) goto L16;
        return r5;
    L16:
        Field r10 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
        if (r10 == null) goto L15;
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
        Object r11 = r10.get(this);     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
        if ((r11 instanceof OverScroller) == false) goto L15;
        this.f10625n = (OverScroller) r11;     // Catch: IllegalAccessException -> L12 NoSuchFieldException -> L13
    L15:
        return this.f10625n;
    L12:
        LynxLog.b(4, "LynxNestedHorizontalScrollView", "Failed to get mScroller of HorizontalScrollView!");
    L13:
        LynxLog.b(4, "LynxNestedHorizontalScrollView", "Failed to get mScroller field of HorizontalScrollView!");
        goto L15
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f10627p.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f10628q.hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f10628q.isNestedScrollingEnabled();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r14) {
        if (this.f10616a == true) goto L7;
        return super.onInterceptTouchEvent(r14);
    L7:
        if (this.f10618c == false) goto L12;
        c r5 = this.f10629r;
        if (r5 == null) goto L12;
        return r5.e();
    L12:
        int r10 = 1;
        if (r14.getAction() == 2) goto L15;
    L17:
        int r11 = r14.getActionMasked();
        NestedScrollingChildHelper r12 = this.f10628q;
        if (r11 != 0) goto L20;
        int r13 = (int) r14.getX();
        int r15 = (int) r14.getY();
        if (getChildCount() <= 0) goto L79;
        int r16 = getScrollX();
        View r17 = getChildAt(0);
        if (r15 < r17.getTop()) goto L79;
        if (r15 >= r17.getBottom()) goto L79;
        if (r13 < (r17.getLeft() - r16)) goto L79;
        if (r13 >= (r17.getRight() - r16)) goto L79;
        VelocityTracker r18 = this.f10626o;
        if (r18 != null) goto L74;
        this.f10626o = VelocityTracker.obtain();
    L75:
        this.f10626o.addMovement(r14);
        this.d = r14.getPointerId(0);
        this.e = r13;
        OverScroller r19 = getHScroller();
        if (r19 == null) goto L78;
        r19.computeScrollOffset();
        this.f10617b = !getHScroller().isFinished();
    L78:
        r12.startNestedScroll(1, 0);
    L83:
        return this.f10617b;
    L74:
        r18.clear();
    L79:
        this.f10617b = false;
        VelocityTracker r110 = this.f10626o;
        if (r110 == null) goto L83;
        r110.recycle();
        this.f10626o = null;
        goto L83
    L20:
        if (r11 == 1) goto L52;
        if (r11 != 2) goto L23;
        int r20 = this.d;
        if (r20 == (-1)) goto L83;
        int r21 = r14.findPointerIndex(r20);
        if (r21 == (-1)) goto L83;
        int r22 = (int) r14.getX(r21);
        if (Math.abs(r22 - this.e) <= this.f) goto L83;
        if ((getNestedScrollAxes() & 1) != 0) goto L83;
        this.f10617b = true;
        this.e = r22;
        if (this.f10626o != null) goto L48;
        this.f10626o = VelocityTracker.obtain();
    L48:
        this.f10626o.addMovement(r14);
        ViewParent r111 = getParent();
        if (r111 == null) goto L51;
        r111.requestDisallowInterceptTouchEvent(true);
    L51:
        this.f10620i = 0;
        goto L83
    L23:
        if (r11 == 3) goto L52;
        if (r11 != 6) goto L83;
        int r23 = r14.getActionIndex();
        if (r14.getPointerId(r23) != this.d) goto L83;
        if (r23 == 0) goto L32;
        r10 = 0;
    L32:
        this.e = (int) r14.getX(r10);
        this.d = r14.getPointerId(r10);
        VelocityTracker r112 = this.f10626o;
        if (r112 == null) goto L83;
        r112.clear();
    L52:
        this.f10617b = false;
        this.d = -1;
        VelocityTracker r113 = this.f10626o;
        if (r113 == null) goto L55;
        r113.recycle();
        this.f10626o = null;
    L55:
        int r114 = this.f10624m.E();
        if (getHScroller() != null) goto L58;
    L60:
        r12.stopNestedScroll(0);
        goto L83
    L58:
        if (getHScroller().springBack(getScrollX(), getScrollY(), 0, r114, 0, 0) == false) goto L60;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L60
    L15:
        if (this.f10617b == false) goto L17;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        boolean r13 = false;
        if (this.f10618c == true) goto L5;
    L7:
        if (r12 == true) goto L20;
        int r14 = getScrollX();
        int r15 = this.f10624m.E();
        if (r14 <= 0) goto L11;
    L12:
        if (r14 >= r15) goto L14;
    L15:
        r13 = true;
    L17:
        if (dispatchNestedPreFling(r10, 0.0f) == true) goto L19;
        dispatchNestedFling(r10, 0.0f, r13);
        fling((int) r10);
    L19:
        return true;
    L14:
        if (r10 >= 0.0f) goto L17;
    L11:
        if (r10 <= 0.0f) goto L17;
    L20:
        return false;
    L5:
        if (this.f10629r == null) goto L7;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r5, float r10, float r11) {
        if (this.f10618c == false) goto L9;
        if (this.f10629r == null) goto L9;
        return false;
    L9:
        return dispatchNestedPreFling(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        if (this.f10618c == false) goto L8;
        c r5 = this.f10629r;
        if (r5 == null) goto L8;
        r5.d(r10, r11, r12, r13, r14);
        return;
    L8:
        dispatchNestedPreScroll(r11, r12, r13, null, r14);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        if (this.f10618c == false) goto L8;
        c r5 = this.f10629r;
        if (r5 == null) goto L8;
        r5.c(r11, r12, r13, r14, r15);
        return;
    L8:
        int r16 = getScrollX();
        scrollBy(r13, 0);
        int r17 = getScrollX() - r16;
        dispatchNestedScroll(r17, 0, r13 - r17, 0, null, r15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        if (this.f10618c == false) goto L8;
        c r13 = this.f10629r;
        if (r13 == null) goto L8;
        r13.g.onNestedScrollAccepted(r5, r10, r11, r12);
        return;
    L8:
        this.f10627p.onNestedScrollAccepted(r5, r10, r11, r12);
        this.f10628q.startNestedScroll(1, r12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        if (this.f10618c == false) goto L15;
        c r13 = this.f10629r;
        if (r13 == null) goto L15;
        if (r13.f17110a == false) goto L9;
        int r14 = 2;
    L11:
        if ((r14 & r11) == 0) goto L13;
        return true;
    L13:
        return false;
    L9:
        r14 = 1;
    L15:
        if ((r11 & 1) == 0) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r5, int r10) {
        if (this.f10618c == false) goto L8;
        c r11 = this.f10629r;
        if (r11 == null) goto L8;
        r11.b(r10);
        return;
    L8:
        this.f10627p.onStopNestedScroll(r5, r10);
        this.f10628q.stopNestedScroll(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r24) {
        if (this.f10616a == false) goto L5;
        int r10 = 0;
        if (this.f10618c == true) goto L9;
    L11:
        int r5 = r24.getActionMasked();
        if (this.f10626o != null) goto L14;
        this.f10626o = VelocityTracker.obtain();
    L14:
        MotionEvent r11 = MotionEvent.obtain(r24);
        if (r5 != 0) goto L17;
        this.f10620i = 0;
    L17:
        r11.offsetLocation(this.f10620i, 0.0f);
        NestedScrollingChildHelper r12 = this.f10628q;
        if (r5 == 0) goto L117;
        UIScrollView r13 = this.f10624m;
        if (r5 != 1) goto L22;
        VelocityTracker r14 = this.f10626o;
        r14.computeCurrentVelocity(1000, this.f10619h);
        int r15 = -((int) r14.getXVelocity(this.d));
        int r16 = r13.E();
        OverScroller r17 = getHScroller();
        if (getChildCount() > 0) goto L95;
    L112:
        this.f10617b = false;
        this.d = -1;
        VelocityTracker r18 = this.f10626o;
        if (r18 == null) goto L115;
        r18.recycle();
        this.f10626o = null;
    L115:
        r12.stopNestedScroll(0);
    L128:
        VelocityTracker r19 = this.f10626o;
        if (r19 == null) goto L131;
        r19.addMovement(r11);
    L131:
        r11.recycle();
        return true;
    L95:
        if (Math.abs(r15) > this.g) goto L97;
        if (r17 == null) goto L112;
        if (r17.springBack(getScrollX(), getScrollY(), 0, r16, 0, 0) == false) goto L112;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L112
    L97:
        if (getScrollX() > 0) goto L100;
        if (r15 > 0) goto L100;
    L103:
        boolean r20 = false;
    L105:
        float r21 = r15;
        if (dispatchNestedPreFling(r21, 0.0f) == true) goto L112;
        dispatchNestedFling(r21, 0.0f, r20);
        fling(r15);
    L100:
        if (getScrollX() < r16) goto L104;
        if (r15 >= 0) goto L103;
    L104:
        r20 = true;
        goto L105
    L22:
        if (r5 != 2) goto L24;
        int r22 = r24.findPointerIndex(this.d);
        if (r22 == (-1)) goto L128;
        int r110 = (int) r24.getX(r22);
        int r111 = this.e - r110;
        boolean r23 = dispatchNestedPreScroll(r111, 0, this.f10623l, this.f10622k, 0);
        int[] r112 = this.f10622k;
        if (r23 == false) goto L61;
        r111 = r111 - this.f10623l[0];
        r11.offsetLocation(r112[0], 0.0f);
        this.f10620i += r112[0];
    L61:
        if (this.f10617b == true) goto L71;
        if (Math.abs(r111) <= this.f) goto L71;
        this.f10617b = true;
        ViewParent r25 = getParent();
        if (r25 == null) goto L67;
        r25.requestDisallowInterceptTouchEvent(true);
    L67:
        if (r111 <= 0) goto L69;
        r111 = r111 - this.f;
        goto L71
    L69:
        r111 = r111 + this.f;
    L71:
        if (this.f10617b == false) goto L128;
        this.e = r110 - r112[0];
        int r26 = r13.E();
        int r27 = getScrollX();
        int r28 = r27 + r111;
        if (r28 < 0) goto L77;
        if (r28 > r26) goto L77;
        boolean r29 = false;
    L78:
        int r30 = MathUtils.clamp(r28, 0, r26);
        OverScroller r113 = getHScroller();
        if (r29 == true) goto L81;
    L84:
        super.scrollTo(r30, getScrollY());
        if (r29 == true) goto L87;
    L89:
        int r31 = getScrollX() - r27;
        if (dispatchNestedScroll(r31, 0, r111 - r31, 0, this.f10622k, 0) == false) goto L128;
        int r32 = this.e;
        int r33 = r112[0];
        this.e = r32 - r33;
        this.f10620i += r33;
        r11.offsetLocation(r33, 0.0f);
        goto L128
    L87:
        if (r12.hasNestedScrollingParent(0) == true) goto L89;
        this.f10626o.clear();
        goto L89
    L81:
        if (r12.hasNestedScrollingParent(1) == true) goto L84;
        if (r113 == null) goto L84;
        r113.springBack(r30, 0, 0, r26, 0, 0);
    L77:
        r29 = true;
        goto L78
    L24:
        if (r5 != 3) goto L26;
        int r114 = r13.E();
        OverScroller r115 = getHScroller();
        if (this.f10617b == true) goto L45;
    L50:
        this.f10617b = false;
        this.d = -1;
        VelocityTracker r34 = this.f10626o;
        if (r34 == null) goto L53;
        r34.recycle();
        this.f10626o = null;
    L53:
        r12.stopNestedScroll(0);
        goto L128
    L45:
        if (getChildCount() <= 0) goto L50;
        if (r115 == null) goto L50;
        if (r115.springBack(getScrollX(), getScrollY(), 0, r114, 0, 0) == false) goto L50;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L50
    L26:
        if (r5 != 5) goto L28;
        int r35 = r24.getActionIndex();
        this.e = (int) r24.getX(r35);
        this.d = r24.getPointerId(r35);
        goto L128
    L28:
        if (r5 != 6) goto L128;
        int r36 = r24.getActionIndex();
        if (r24.getPointerId(r36) != this.d) goto L37;
        if (r36 != 0) goto L34;
        r10 = 1;
    L34:
        this.e = (int) r24.getX(r10);
        this.d = r24.getPointerId(r10);
        VelocityTracker r37 = this.f10626o;
        if (r37 == null) goto L37;
        r37.clear();
    L37:
        int r38 = r24.findPointerIndex(this.d);
        if (r38 == (-1)) goto L128;
        this.e = (int) r24.getX(r38);
        goto L128
    L117:
        if (getChildCount() != 0) goto L119;
        return false;
    L119:
        OverScroller r39 = getHScroller();
        if (r39 == null) goto L127;
        boolean r40 = r39.isFinished();
        this.f10617b = !r40;
        if (r40 == true) goto L126;
        ViewParent r41 = getParent();
        if (r41 == null) goto L126;
        r41.requestDisallowInterceptTouchEvent(true);
    L126:
        r39.abortAnimation();
    L127:
        this.e = (int) r24.getX();
        this.d = r24.getPointerId(0);
        r12.startNestedScroll(1, 0);
        goto L128
    L9:
        if (this.f10629r == null) goto L11;
        return false;
    L5:
        return super.onTouchEvent(r24);
    }

    public void setEnableNewBounce(boolean r5) {
        this.f10618c = r5;
    }

    public void setEnableNewNested(boolean r5) {
        this.f10616a = r5;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        this.f10628q.setNestedScrollingEnabled(r5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r5) {
        return this.f10628q.startNestedScroll(r5, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f10628q.stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r5) {
        return this.f10628q.hasNestedScrollingParent(r5);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r5, int r10) {
        return this.f10628q.startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r5) {
        this.f10628q.stopNestedScroll(r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r5, View r10, int r11) {
        return onStartNestedScroll(r5, r10, r11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        dispatchNestedPreScroll(r11, r12, r13, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r5) {
        onStopNestedScroll(r5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r5, View r10, int r11) {
        onNestedScrollAccepted(r5, r10, r11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r10, r11, r12, r13, r14, 0);
    }
}
