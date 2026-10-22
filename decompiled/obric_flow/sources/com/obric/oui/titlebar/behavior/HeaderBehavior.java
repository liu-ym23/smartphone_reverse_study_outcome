package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.scene.core.i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f14851c;
    public OverScroller d;
    public boolean e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VelocityTracker f14853i;

    public HeaderBehavior() {
        this.f = -1;
        this.f14852h = -1;
    }

    public boolean canDragView(View r5) {
        return false;
    }

    public boolean fling(CoordinatorLayout r18, View r19, int r20, int r21, float r22) {
        i r5 = this.f14851c;
        if (r5 == null) goto L6;
        r19.removeCallbacks(r5);
        this.f14851c = null;
    L6:
        if (this.d != null) goto L8;
        this.d = new OverScroller(r19.getContext());
    L8:
        this.d.fling(0, getTopAndBottomOffset(), 0, Math.round(r22), 0, 0, r20, r21);
        if (this.d.computeScrollOffset() == false) goto L12;
        i r10 = new i(this, r18, r19, 15, false);
        this.f14851c = r10;
        ViewCompat.postOnAnimation(r19, r10);
        return true;
    L12:
        onFlingFinished(r18, r19);
        return false;
    }

    public int getMaxDragOffset(View r5) {
        return -r5.getHeight();
    }

    public int getScrollRangeForDragFling(View r5) {
        return r5.getHeight();
    }

    public final int getTopAndBottomOffset() {
        com.airbnb.lottie.parser.moshi.c r5 = this.f14855a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.f1315c;
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout r5, View r10) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        if (this.f14852h >= 0) goto L6;
        this.f14852h = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
    L6:
        if (r12.getActionMasked() != 2) goto L20;
        if (this.e == false) goto L20;
        int r5 = this.f;
        if (r5 != (-1)) goto L12;
        return false;
    L12:
        int r13 = r12.findPointerIndex(r5);
        if (r13 != (-1)) goto L15;
        return false;
    L15:
        int r14 = (int) r12.getY(r13);
        if (Math.abs(r14 - this.g) <= this.f14852h) goto L20;
        this.g = r14;
        return true;
    L20:
        if (r12.getActionMasked() != 0) goto L38;
        this.f = -1;
        int r15 = (int) r12.getX();
        int r16 = (int) r12.getY();
        if (canDragView(r11) == true) goto L24;
    L26:
        boolean r17 = false;
    L27:
        this.e = r17;
        if (r17 == false) goto L38;
        this.g = r16;
        this.f = r12.getPointerId(0);
        if (this.f14853i != null) goto L32;
        this.f14853i = VelocityTracker.obtain();
    L32:
        OverScroller r18 = this.d;
        if (r18 == null) goto L38;
        if (r18.isFinished() == true) goto L38;
        this.d.abortAnimation();
        return true;
    L24:
        if (r10.isPointInChildBounds(r11, r15, r16) == false) goto L26;
        r17 = true;
    L38:
        VelocityTracker r19 = this.f14853i;
        if (r19 == null) goto L41;
        r19.addMovement(r12);
    L41:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r12, View r13, MotionEvent r14) {
        int r5 = r14.getActionMasked();
        if (r5 != 1) goto L5;
        VelocityTracker r10 = this.f14853i;
        if (r10 == null) goto L24;
        r10.addMovement(r14);
        this.f14853i.computeCurrentVelocity(1000);
        fling(r12, r13, -getScrollRangeForDragFling(r13), 0, this.f14853i.getYVelocity(this.f));
        boolean r15 = true;
    L25:
        this.e = false;
        this.f = -1;
        VelocityTracker r16 = this.f14853i;
        if (r16 == null) goto L28;
        r16.recycle();
        this.f14853i = null;
    L28:
        VelocityTracker r17 = this.f14853i;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.e == true) goto L37;
        if (r15 == false) goto L36;
        return true;
    L36:
        return false;
    L37:
        return true;
    L24:
        r15 = false;
        goto L25
    L5:
        if (r5 != 2) goto L7;
        int r11 = r14.findPointerIndex(this.f);
        if (r11 != (-1)) goto L19;
        return false;
    L19:
        int r18 = (int) r14.getY(r11);
        int r19 = this.g - r18;
        this.g = r18;
        setHeaderTopBottomOffset(r12, r13, getTopBottomOffsetForScrollingSibling() - r19, getMaxDragOffset(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r5 == 3) goto L24;
        if (r5 != 6) goto L20;
        if (r14.getActionIndex() != 0) goto L14;
        int r110 = 1;
    L15:
        this.f = r14.getPointerId(r110);
        this.g = (int) (r14.getY(r110) + 0.5f);
        goto L20
    L14:
        r110 = 0;
        goto L15
    }

    public final int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12) {
        return setHeaderTopBottomOffset(r10, r11, r12, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r5, View r10, int r11, int r12, int r13) {
        int r14 = getTopAndBottomOffset();
        if (r12 == 0) goto L15;
        if (r14 < r12) goto L15;
        if (r14 > r13) goto L15;
        int r15 = MathUtils.clamp(r11, r12, r13);
        if (r14 == r15) goto L15;
        com.airbnb.lottie.parser.moshi.c r16 = this.f14855a;
        if (r16 != null) goto L11;
        this.f14856b = r15;
    L17:
        return r14 - r15;
    L11:
        if (r16.f1315c == r15) goto L17;
        r16.f1315c = r15;
        r16.f();
    L15:
        return 0;
    }

    public HeaderBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f = -1;
        this.f14852h = -1;
    }
}
