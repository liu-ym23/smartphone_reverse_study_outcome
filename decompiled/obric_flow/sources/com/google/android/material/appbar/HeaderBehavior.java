package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;

    @Nullable
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;

    @Nullable
    private VelocityTracker velocityTracker;

    public class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;
        final /* synthetic */ HeaderBehavior this$0;

        public FlingRunnable(HeaderBehavior r5, CoordinatorLayout r10, V r11) {
            this.this$0 = r5;
            this.parent = r10;
            this.layout = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.layout == null) goto L11;
            OverScroller r5 = this.this$0.scroller;
            if (r5 != null) goto L7;
            return;
        L7:
            if (r5.computeScrollOffset() == false) goto L9;
            HeaderBehavior r10 = this.this$0;
            r10.setHeaderTopBottomOffset(this.parent, this.layout, r10.scroller.getCurrY());
            ViewCompat.postOnAnimation(this.layout, this);
            return;
        L9:
            this.this$0.onFlingFinished(this.parent, this.layout);
            return;
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) goto L6;
        this.velocityTracker = VelocityTracker.obtain();
        return;
    }

    public boolean canDragView(V r5) {
        return false;
    }

    public final boolean fling(CoordinatorLayout r14, @NonNull V r15, int r16, int r17, float r18) {
        Runnable r5 = this.flingRunnable;
        if (r5 == null) goto L6;
        r15.removeCallbacks(r5);
        this.flingRunnable = null;
    L6:
        if (this.scroller != null) goto L8;
        this.scroller = new OverScroller(r15.getContext());
    L8:
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.scroller.computeScrollOffset() == false) goto L12;
        FlingRunnable r10 = new FlingRunnable(this, r14, r15);
        this.flingRunnable = r10;
        ViewCompat.postOnAnimation(r15, r10);
        return true;
    L12:
        onFlingFinished(r14, r15);
        return false;
    }

    public int getMaxDragOffset(@NonNull V r5) {
        return -r5.getHeight();
    }

    public int getScrollRangeForDragFling(@NonNull V r5) {
        return r5.getHeight();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout r5, V r10) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (this.touchSlop >= 0) goto L6;
        this.touchSlop = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
    L6:
        if (r12.getActionMasked() != 2) goto L20;
        if (this.isBeingDragged == false) goto L20;
        int r5 = this.activePointerId;
        if (r5 != (-1)) goto L12;
        return false;
    L12:
        int r13 = r12.findPointerIndex(r5);
        if (r13 != (-1)) goto L15;
        return false;
    L15:
        int r14 = (int) r12.getY(r13);
        if (Math.abs(r14 - this.lastMotionY) <= this.touchSlop) goto L20;
        this.lastMotionY = r14;
        return true;
    L20:
        if (r12.getActionMasked() != 0) goto L35;
        this.activePointerId = -1;
        int r15 = (int) r12.getX();
        int r16 = (int) r12.getY();
        if (canDragView(r11) == true) goto L24;
    L26:
        boolean r17 = false;
    L27:
        this.isBeingDragged = r17;
        if (r17 == false) goto L35;
        this.lastMotionY = r16;
        this.activePointerId = r12.getPointerId(0);
        ensureVelocityTracker();
        OverScroller r18 = this.scroller;
        if (r18 == null) goto L35;
        if (r18.isFinished() == true) goto L35;
        this.scroller.abortAnimation();
        return true;
    L24:
        if (r10.isPointInChildBounds(r11, r15, r16) == false) goto L26;
        r17 = true;
    L35:
        VelocityTracker r19 = this.velocityTracker;
        if (r19 == null) goto L38;
        r19.addMovement(r12);
    L38:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r12, @NonNull V r13, @NonNull MotionEvent r14) {
        int r5 = r14.getActionMasked();
        if (r5 != 1) goto L5;
        VelocityTracker r10 = this.velocityTracker;
        if (r10 == null) goto L24;
        r10.addMovement(r14);
        this.velocityTracker.computeCurrentVelocity(1000);
        fling(r12, r13, -getScrollRangeForDragFling(r13), 0, this.velocityTracker.getYVelocity(this.activePointerId));
        boolean r15 = true;
    L25:
        this.isBeingDragged = false;
        this.activePointerId = -1;
        VelocityTracker r16 = this.velocityTracker;
        if (r16 == null) goto L28;
        r16.recycle();
        this.velocityTracker = null;
    L28:
        VelocityTracker r17 = this.velocityTracker;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.isBeingDragged == true) goto L37;
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
        int r11 = r14.findPointerIndex(this.activePointerId);
        if (r11 != (-1)) goto L19;
        return false;
    L19:
        int r18 = (int) r14.getY(r11);
        int r19 = this.lastMotionY - r18;
        this.lastMotionY = r18;
        scroll(r12, r13, r19, getMaxDragOffset(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r5 == 3) goto L24;
        if (r5 != 6) goto L20;
        if (r14.getActionIndex() != 0) goto L14;
        int r110 = 1;
    L15:
        this.activePointerId = r14.getPointerId(r110);
        this.lastMotionY = (int) (r14.getY(r110) + 0.5f);
        goto L20
    L14:
        r110 = 0;
        goto L15
    }

    public final int scroll(CoordinatorLayout r10, V r11, int r12, int r13, int r14) {
        return setHeaderTopBottomOffset(r10, r11, getTopBottomOffsetForScrollingSibling() - r12, r13, r14);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r10, V r11, int r12) {
        return setHeaderTopBottomOffset(r10, r11, r12, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r5, V r10, int r11, int r12, int r13) {
        int r14 = getTopAndBottomOffset();
        if (r12 == 0) goto L9;
        if (r14 < r12) goto L9;
        if (r14 > r13) goto L9;
        int r15 = MathUtils.clamp(r11, r12, r13);
        if (r14 == r15) goto L9;
        setTopAndBottomOffset(r15);
        return r14 - r15;
    L9:
        return 0;
    }

    public HeaderBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }
}
