package com.ss.android.lark.chameleon.container.webcontainer.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.ss.android.lark.chameleon.basewebview.BridgeWebViewV2;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.ttvideoengine.utils.ScreenUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NestBridgeWebView extends BridgeWebViewV2 implements NestedScrollingChild3 {
    private static final int INVALID_POINTER = -1;
    private static final String TAG = "NestBridgeWebView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        EdgeEffect r0 = this.mEdgeGlowTop;
        if (r0 == null) goto L6;
        r0.onRelease();
        this.mEdgeGlowBottom.onRelease();
        return;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r0.clear();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r0 = ViewConfiguration.get(getContext());
        this.mTouchSlop = r0.getScaledTouchSlop();
        this.mMinimumVelocity = r0.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r0.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    private void recycleVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mVelocityTracker = null;
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
        return;
    L5:
        this.mScroller.computeScrollOffset();
        int r0 = this.mScroller.getCurrY();
        int r6 = r0 - this.mLastScrollerY;
        this.mLastScrollerY = r0;
        int[] r3 = this.mScrollConsumed;
        boolean r12 = false;
        r3[1] = 0;
        dispatchNestedPreScroll(0, r6, r3, null, 1);
        int r13 = r6 - this.mScrollConsumed[1];
        int r14 = getScrollRange();
        if (r13 == 0) goto L8;
        int r15 = getScrollY();
        overScrollByCompat(0, r13, getScrollX(), r15, 0, r14, 0, 0, false);
        int r2 = getScrollY() - r15;
        int r16 = r13 - r2;
        int[] r7 = this.mScrollConsumed;
        r7[1] = 0;
        dispatchNestedScroll(0, r2, 0, r16, this.mScrollOffset, 1, r7);
        r13 = r16 - this.mScrollConsumed[1];
    L8:
        if (r13 == 0) goto L25;
        int r1 = getOverScrollMode();
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L14;
        if (r14 > 0) goto L13;
    L14:
        if (r12 == false) goto L23;
        ensureGlows();
        if (r13 >= 0) goto L21;
        if (this.mEdgeGlowTop.isFinished() == false) goto L23;
        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L23
    L21:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L23;
        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
    L23:
        abortAnimatedScroll();
    L13:
        r12 = true;
    L25:
        if (this.mScroller.isFinished() == true) goto L27;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L27:
        stopNestedScroll(1);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    private void ensureGlows() {
        if (getOverScrollMode() != 2) goto L5;
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
        return;
    L5:
        if (this.mEdgeGlowTop != null) goto L9;
        Context r0 = getContext();
        this.mEdgeGlowTop = new EdgeEffect(r0);
        this.mEdgeGlowBottom = new EdgeEffect(r0);
        return;
    }

    public int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public NestBridgeWebView(Context r2) {
        super(r2);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    private void onSecondaryPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mActivePointerId) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mLastMotionY = (int) r4.getY(r1);
        this.mActivePointerId = r4.getPointerId(r1);
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    private void runAnimatedScroll(boolean r2) {
        if (r2 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    public void fling(int r12) {
        this.mScroller.fling(getScrollX(), getScrollY(), 0, r12, 0, 0, PluginList.LEVEL_NOT_SET, Integer.MAX_VALUE, 0, 0);
        runAnimatedScroll(true);
    }

    public boolean hasNestedScrollingParent(int r2) {
        return this.mChildHelper.hasNestedScrollingParent(r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r12) {
        int r0 = r12.getAction();
        if (r0 == 2) goto L5;
    L7:
        int r1 = r0 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        if (r1 != 0) goto L10;
        this.mLastMotionY = (int) r12.getY();
        this.mActivePointerId = r12.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(r12);
        this.mScroller.computeScrollOffset();
        this.mIsBeingDragged = !this.mScroller.isFinished();
        startNestedScroll(2, 0);
    L37:
        return this.mIsBeingDragged;
    L10:
        if (r1 == 1) goto L31;
        if (r1 != 2) goto L13;
        int r2 = this.mActivePointerId;
        if (r2 == (-1)) goto L37;
        int r3 = r12.findPointerIndex(r2);
        if (r3 == (-1)) goto L37;
        int r4 = (int) r12.getY(r3);
        if (Math.abs(r4 - this.mLastMotionY) <= this.mTouchSlop) goto L37;
        if ((2 & getNestedScrollAxes()) != 0) goto L37;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r4;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(r12);
        this.mNestedYOffset = 0;
        ViewParent r13 = getParent();
        if (r13 == null) goto L37;
        r13.requestDisallowInterceptTouchEvent(true);
        goto L37
    L13:
        if (r1 == 3) goto L31;
        if (r1 != 6) goto L37;
        onSecondaryPointerUp(r12);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        ViewCompat.postInvalidateOnAnimation(this);
    L34:
        stopNestedScroll(0);
        goto L37
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r23) {
        initVelocityTrackerIfNotExists();
        int r0 = r23.getActionMasked();
        if (r0 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r13 = MotionEvent.obtain(r23);
        r13.offsetLocation(0.0f, this.mNestedYOffset);
        if (r0 != 0) goto L8;
        boolean r1 = !this.mScroller.isFinished();
        this.mIsBeingDragged = r1;
        if (r1 == false) goto L90;
        ViewParent r2 = getParent();
        if (r2 == null) goto L90;
        r2.requestDisallowInterceptTouchEvent(true);
    L90:
        if (this.mScroller.isFinished() == true) goto L92;
        abortAnimatedScroll();
    L92:
        this.mLastMotionY = (int) r23.getY();
        this.mActivePointerId = r23.getPointerId(0);
        startNestedScroll(2, 0);
    L93:
        VelocityTracker r3 = this.mVelocityTracker;
        if (r3 == null) goto L96;
        r3.addMovement(r13);
    L96:
        r13.recycle();
        return super.onTouchEvent(r23);
    L8:
        if (r0 == 1) goto L75;
        if (r0 != 2) goto L11;
        int r15 = r23.findPointerIndex(this.mActivePointerId);
        if (r15 == (-1)) goto L93;
        int r6 = (int) r23.getY(r15);
        int r4 = this.mLastMotionY - r6;
        if (this.mIsBeingDragged == false) goto L31;
    L39:
        int r7 = r4;
        if (this.mIsBeingDragged == false) goto L93;
        if (dispatchNestedPreScroll(0, r7, this.mScrollConsumed, this.mScrollOffset, 0) == false) goto L44;
        r7 = r7 - this.mScrollConsumed[1];
        this.mNestedYOffset += this.mScrollOffset[1];
    L44:
        int r16 = r7;
        this.mLastMotionY = r6 - this.mScrollOffset[1];
        int r17 = getScrollY();
        int r9 = getScrollRange();
        int r5 = getOverScrollMode();
        if (r5 == 0) goto L50;
        if (r5 != 1) goto L49;
        if (r9 > 0) goto L50;
    L49:
        boolean r18 = false;
    L52:
        if (overScrollByCompat(0, r16, 0, getScrollY(), 0, r9, 0, 0, true) == true) goto L54;
    L56:
        int r8 = getScrollY() - r17;
        int[] r10 = this.mScrollConsumed;
        r10[1] = 0;
        dispatchNestedScroll(0, r8, 0, r16 - r8, this.mScrollOffset, 0, r10);
        int r11 = this.mLastMotionY;
        int r12 = this.mScrollOffset[1];
        this.mLastMotionY = r11 - r12;
        this.mNestedYOffset += r12;
        if (r18 == false) goto L93;
        int r14 = r16 - this.mScrollConsumed[1];
        ensureGlows();
        int r19 = r17 + r14;
        if (r19 >= 0) goto L64;
        EdgeEffectCompat.onPull(this.mEdgeGlowTop, r14 / getHeight(), r23.getX(r15) / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L68;
        this.mEdgeGlowBottom.onRelease();
    L68:
        EdgeEffect r20 = this.mEdgeGlowTop;
        if (r20 == null) goto L93;
        if (r20.isFinished() == true) goto L73;
    L74:
        ViewCompat.postInvalidateOnAnimation(this);
        goto L93
    L73:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L93;
    L64:
        if (r19 <= r9) goto L68;
        EdgeEffectCompat.onPull(this.mEdgeGlowBottom, r14 / getHeight(), 1.0f - (r23.getX(r15) / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L68;
        this.mEdgeGlowTop.onRelease();
        goto L68
    L54:
        if (hasNestedScrollingParent(0) == true) goto L56;
        this.mVelocityTracker.clear();
    L50:
        r18 = true;
        goto L52
    L31:
        if (Math.abs(r4) <= this.mTouchSlop) goto L39;
        ViewParent r21 = getParent();
        if (r21 == null) goto L35;
        r21.requestDisallowInterceptTouchEvent(true);
    L35:
        this.mIsBeingDragged = true;
        if (r4 <= 0) goto L38;
        r4 = r4 - this.mTouchSlop;
        goto L39
    L38:
        r4 = r4 + this.mTouchSlop;
        goto L39
    L11:
        if (r0 == 3) goto L20;
        if (r0 != 5) goto L15;
        int r22 = r23.getActionIndex();
        this.mLastMotionY = (int) r23.getY(r22);
        this.mActivePointerId = r23.getPointerId(r22);
        goto L93
    L15:
        if (r0 != 6) goto L93;
        onSecondaryPointerUp(r23);
        this.mLastMotionY = (int) r23.getY(r23.findPointerIndex(this.mActivePointerId));
        goto L93
    L20:
        if (this.mIsBeingDragged == true) goto L22;
    L24:
        this.mActivePointerId = -1;
        endDrag();
        goto L93
    L22:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L24;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L24
    L75:
        VelocityTracker r24 = this.mVelocityTracker;
        r24.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r25 = (int) r24.getYVelocity(this.mActivePointerId);
        if (Math.abs(r25) < this.mMinimumVelocity) goto L81;
        int r26 = -r25;
        float r27 = r26;
        if (dispatchNestedPreFling(0.0f, r27) == true) goto L83;
        dispatchNestedFling(0.0f, r27, true);
        fling(r26);
    L83:
        this.mActivePointerId = -1;
        endDrag();
        goto L93
    L81:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L83;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L83
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        if (r1 == false) goto L4;
        recycleVelocityTracker();
    L4:
        super.requestDisallowInterceptTouchEvent(r1);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.mChildHelper.setNestedScrollingEnabled(r2);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    public void stopNestedScroll(int r2) {
        this.mChildHelper.stopNestedScroll(r2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float r2, float r3) {
        return this.mChildHelper.dispatchNestedPreFling(r2, r3);
    }

    public boolean startNestedScroll(int r2, int r3) {
        return this.mChildHelper.startNestedScroll(r2, r3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.mChildHelper.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.mChildHelper.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.mChildHelper.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.mChildHelper.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        this.mChildHelper.dispatchNestedScroll(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        int r1 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r2 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r3 = true;
    L10:
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L14;
        if (r2 == true) goto L15;
    L14:
        boolean r4 = false;
    L16:
        if (r1 == 0) goto L21;
        if (r1 != 1) goto L20;
        if (r3 == true) goto L21;
    L20:
        boolean r5 = false;
    L22:
        int r6 = r15 + r13;
        if (r4 == true) goto L25;
        int r7 = 0;
    L26:
        int r8 = r16 + r14;
        if (r5 == true) goto L29;
        int r9 = 0;
    L30:
        int r10 = -r7;
        int r11 = r7 + r17;
        int r12 = -r9;
        int r22 = r9 + r18;
        if (r6 <= r11) goto L34;
        r6 = r11;
    L33:
        boolean r23 = true;
    L37:
        if (r8 <= r22) goto L40;
        r8 = r22;
    L39:
        boolean r24 = true;
    L43:
        if (r24 == true) goto L45;
    L47:
        onOverScrolled(r6, r8, r23, r24);
        if (r23 == true) goto L50;
        if (r24 == true) goto L50;
        return false;
    L50:
        return true;
    L45:
        if (hasNestedScrollingParent(1) == true) goto L47;
        int r110 = r6;
        int r111 = r8;
        this.mScroller.springBack(r110, r111, 0, 0, 0, getScrollRange());
        goto L47
    L40:
        if (r8 >= r12) goto L42;
        r8 = r12;
        goto L39
    L42:
        r24 = false;
        goto L43
    L34:
        if (r6 >= r10) goto L36;
        r6 = r10;
        goto L33
    L36:
        r23 = false;
        goto L37
    L29:
        r9 = r20;
        goto L30
    L25:
        r7 = r19;
    L21:
        r5 = true;
    L15:
        r4 = true;
        goto L16
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }
}
