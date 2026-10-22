package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ScrollerCompat {
    OverScroller mScroller;

    ScrollerCompat(Context r10, Interpolator r11) {
        if (r11 == null) goto L5;
        OverScroller r12 = new OverScroller(r10, r11);
    L6:
        this.mScroller = r12;
        return;
    L5:
        r12 = new OverScroller(r10);
        goto L6
    }

    @Deprecated
    public static ScrollerCompat create(Context r10) {
        return create(r10, null);
    }

    @Deprecated
    public static ScrollerCompat create(Context r10, Interpolator r11) {
        return new ScrollerCompat(r10, r11);
    }

    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated
    public void fling(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        this.mScroller.fling(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Deprecated
    public void fling(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21) {
        this.mScroller.fling(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int r10, int r11, int r12) {
        this.mScroller.notifyHorizontalEdgeReached(r10, r11, r12);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int r10, int r11, int r12) {
        this.mScroller.notifyVerticalEdgeReached(r10, r11, r12);
    }

    @Deprecated
    public boolean springBack(int r10, int r11, int r12, int r13, int r14, int r15) {
        return this.mScroller.springBack(r10, r11, r12, r13, r14, r15);
    }

    @Deprecated
    public void startScroll(int r10, int r11, int r12, int r13) {
        this.mScroller.startScroll(r10, r11, r12, r13);
    }

    @Deprecated
    public void startScroll(int r10, int r11, int r12, int r13, int r14) {
        this.mScroller.startScroll(r10, r11, r12, r13, r14);
    }
}
