package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
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
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
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

    private class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CoordinatorLayout f7733c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final V f7734g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ HeaderBehavior f7735h;

        a(HeaderBehavior r10, CoordinatorLayout r11, V r12) {
            this.f7735h = r10;
            this.f7733c = r11;
            this.f7734g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7734g != null) goto L5;
            return;
        L5:
            if (this.f7735h.scroller == null) goto L12;
            Log.i("djd ", "FlingRunnable: " + this.f7734g.getClass().getName() + "  scroller.getCurrY：" + this.f7735h.scroller.getCurrY());
            if (this.f7735h.scroller.computeScrollOffset() == false) goto L9;
            HeaderBehavior r10 = this.f7735h;
            r10.setHeaderTopBottomOffset(this.f7733c, this.f7734g, r10.scroller.getCurrY());
            ViewCompat.postOnAnimation(this.f7734g, this);
            return;
        L9:
            this.f7735h.onFlingFinished(this.f7733c, this.f7734g);
            return;
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public HeaderBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) goto L6;
        this.velocityTracker = VelocityTracker.obtain();
        return;
    }

    public boolean canDragView(V r10) {
        return false;
    }

    public boolean fling(CoordinatorLayout r14, @NonNull V r15, int r16, int r17, float r18) {
        Runnable r10 = this.flingRunnable;
        if (r10 == null) goto L6;
        r15.removeCallbacks(r10);
        this.flingRunnable = null;
    L6:
        if (this.scroller != null) goto L8;
        this.scroller = new OverScroller(r15.getContext());
    L8:
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.scroller.computeScrollOffset() == false) goto L12;
        a r11 = new a(this, r14, r15);
        this.flingRunnable = r11;
        ViewCompat.postOnAnimation(r15, r11);
        return true;
    L12:
        onFlingFinished(r14, r15);
        return false;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }

    public int getMaxDragOffset(@NonNull V r10) {
        return -r10.getHeight();
    }

    public int getScrollRangeForDragFling(@NonNull V r10) {
        return r10.getHeight();
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
        return super.isHorizontalOffsetEnabled();
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
        return super.isVerticalOffsetEnabled();
    }

    public void onFlingFinished(CoordinatorLayout r10, V r11) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (this.touchSlop >= 0) goto L6;
        this.touchSlop = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
    L6:
        if (r12.getActionMasked() != 2) goto L20;
        if (this.isBeingDragged == false) goto L20;
        int r13 = this.activePointerId;
        if (r13 != (-1)) goto L12;
        return false;
    L12:
        int r14 = r12.findPointerIndex(r13);
        if (r14 != (-1)) goto L15;
        return false;
    L15:
        int r15 = (int) r12.getY(r14);
        if (Math.abs(r15 - this.lastMotionY) <= this.touchSlop) goto L20;
        this.lastMotionY = r15;
        return true;
    L20:
        if (r12.getActionMasked() != 0) goto L35;
        this.activePointerId = -1;
        int r16 = (int) r12.getX();
        int r17 = (int) r12.getY();
        if (canDragView(r11) == true) goto L24;
    L26:
        boolean r18 = false;
    L27:
        this.isBeingDragged = r18;
        if (r18 == false) goto L35;
        this.lastMotionY = r17;
        this.activePointerId = r12.getPointerId(0);
        ensureVelocityTracker();
        OverScroller r19 = this.scroller;
        if (r19 == null) goto L35;
        if (r19.isFinished() == true) goto L35;
        this.scroller.abortAnimation();
        return true;
    L24:
        if (r10.isPointInChildBounds(r11, r16, r17) == false) goto L26;
        r18 = true;
    L35:
        VelocityTracker r20 = this.velocityTracker;
        if (r20 == null) goto L38;
        r20.addMovement(r12);
    L38:
        return false;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull View r11, int r12) {
        return super.onLayoutChild(r10, r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r12, @NonNull V r13, @NonNull MotionEvent r14) {
        int r10 = r14.getActionMasked();
        if (r10 != 1) goto L5;
        VelocityTracker r11 = this.velocityTracker;
        if (r11 == null) goto L24;
        r11.addMovement(r14);
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
        if (r10 != 2) goto L7;
        int r18 = r14.findPointerIndex(this.activePointerId);
        if (r18 != (-1)) goto L19;
        return false;
    L19:
        int r19 = (int) r14.getY(r18);
        int r20 = this.lastMotionY - r19;
        this.lastMotionY = r19;
        scroll(r12, r13, r20, getMaxDragOffset(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r10 == 3) goto L24;
        if (r10 != 6) goto L20;
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

    public int scroll(CoordinatorLayout r10, V r11, int r12, int r13, int r14) {
        return setHeaderTopBottomOffset(r10, r11, getTopBottomOffsetForScrollingSibling() - r12, r13, r14);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r10, V r11, int r12) {
        return setHeaderTopBottomOffset(r10, r11, r12, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r10, V r11, int r12, int r13, int r14) {
        int r15 = getTopAndBottomOffset();
        if (r13 == 0) goto L9;
        if (r15 < r13) goto L9;
        if (r15 > r14) goto L9;
        int r16 = MathUtils.clamp(r12, r13, r14);
        if (r15 == r16) goto L9;
        setTopAndBottomOffset(r16);
        return r15 - r16;
    L9:
        return 0;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r10) {
        super.setHorizontalOffsetEnabled(r10);
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r10) {
        return super.setLeftAndRightOffset(r10);
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r10) {
        return super.setTopAndBottomOffset(r10);
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r10) {
        super.setVerticalOffsetEnabled(r10);
    }

    protected void stopFling() {
        OverScroller r10 = this.scroller;
        if (r10 == null) goto L6;
        r10.abortAnimation();
        return;
    }
}
