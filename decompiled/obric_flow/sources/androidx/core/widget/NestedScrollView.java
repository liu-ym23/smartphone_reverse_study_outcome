package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = null;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final float DECELERATION_RATE = 0.0f;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = null;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;

    @VisibleForTesting
    DifferentialMotionFlingController mDifferentialMotionFlingController;

    @VisibleForTesting
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowBottom;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r5, r10);
            NestedScrollView r11 = (NestedScrollView) r5;
            r10.setClassName(ScrollView.class.getName());
            if (r11.getScrollRange() <= 0) goto L5;
            boolean r12 = true;
        L6:
            r10.setScrollable(r12);
            r10.setScrollX(r11.getScrollX());
            r10.setScrollY(r11.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(r10, r11.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(r10, r11.getScrollRange());
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
            super.onInitializeAccessibilityNodeInfo(r5, r10);
            NestedScrollView r11 = (NestedScrollView) r5;
            r10.setClassName(ScrollView.class.getName());
            if (r11.isEnabled() == false) goto L13;
            int r12 = r11.getScrollRange();
            if (r12 <= 0) goto L14;
            r10.setScrollable(true);
            if (r11.getScrollY() <= 0) goto L10;
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        L10:
            if (r11.getScrollY() >= r12) goto L15;
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r5, int r10, Bundle r11) {
            if (super.performAccessibilityAction(r5, r10, r11) == false) goto L5;
            return true;
        L5:
            NestedScrollView r12 = (NestedScrollView) r5;
            if (r12.isEnabled() == true) goto L8;
            return false;
        L8:
            int r13 = r12.getHeight();
            Rect r14 = new Rect();
            if (r12.getMatrix().isIdentity() == false) goto L14;
            if (r12.getGlobalVisibleRect(r14) == false) goto L14;
            r13 = r14.height();
        L14:
            if (r10 != 4096) goto L16;
        L27:
            int r15 = (r13 - r12.getPaddingBottom()) - r12.getPaddingTop();
            int r16 = Math.min(r12.getScrollY() + r15, r12.getScrollRange());
            if (r16 == r12.getScrollY()) goto L31;
            r12.smoothScrollTo(0, r16, true);
            return true;
        L31:
            return false;
        L16:
            if (r10 != 8192) goto L18;
        L22:
            int r17 = (r13 - r12.getPaddingBottom()) - r12.getPaddingTop();
            int r18 = Math.max(r12.getScrollY() - r17, 0);
            if (r18 == r12.getScrollY()) goto L26;
            r12.smoothScrollTo(0, r18, true);
            return true;
        L26:
            return false;
        L18:
            if (r10 == 16908344) goto L22;
            if (r10 == 16908346) goto L27;
            return false;
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static boolean getClipToPadding(ViewGroup r5) {
            return r5.getClipToPadding();
        }
    }

    public class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        final /* synthetic */ NestedScrollView this$0;

        public DifferentialMotionFlingTargetImpl(NestedScrollView r5) {
            this.this$0 = r5;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -this.this$0.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float r5) {
            if (r5 != 0.0f) goto L6;
            return false;
        L6:
            stopDifferentialMotionFling();
            this.this$0.fling((int) r5);
            return true;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.access$000(this.this$0).abortAnimation();
        }
    }

    public interface OnScrollChangeListener {
        void onScrollChange(@NonNull NestedScrollView r5, int r10, int r11, int r12, int r13);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int scrollPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        @NonNull
        public String toString() {
            StringBuilder r5 = new StringBuilder("HorizontalScrollView.SavedState{");
            r5.append(Integer.toHexString(System.identityHashCode(this)));
            r5.append(" scrollPosition=");
            return androidx.constraintlayout.motion.widget.a.s(r5, this.scrollPosition, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.scrollPosition);
        }

        public SavedState(Parcel r5) {
            super(r5);
            this.scrollPosition = r5.readInt();
        }
    }

    static {
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[]{R.attr.fillViewport};
    }

    public NestedScrollView(@NonNull Context r5) {
        this(r5, null);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    public static /* synthetic */ OverScroller access$000(NestedScrollView r5) {
        return r5.mScroller;
    }

    private boolean canOverScroll() {
        int r5 = getOverScrollMode();
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L6;
    L8:
        return false;
    L6:
        if (getScrollRange() <= 0) goto L8;
        return true;
    L10:
        return true;
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) goto L8;
        View r5 = getChildAt(0);
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        if (((r5.getHeight() + r10.topMargin) + r10.bottomMargin) <= ((getHeight() - getPaddingTop()) - getPaddingBottom())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    private static int clamp(int r5, int r10, int r11) {
        if (r10 >= r11) goto L10;
        if (r5 >= 0) goto L6;
        return 0;
    L6:
        if ((r10 + r5) > r11) goto L8;
        return r5;
    L8:
        return r11 - r10;
    L10:
        return 0;
    }

    private void doScrollY(int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        if (this.mSmoothScrollingEnabled == false) goto L6;
        smoothScrollBy(0, r5);
        return;
    L6:
        scrollBy(0, r5);
    }

    private boolean edgeEffectFling(int r5) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L9;
        if (shouldAbsorb(this.mEdgeGlowTop, r5) == false) goto L7;
        this.mEdgeGlowTop.onAbsorb(r5);
    L14:
        return true;
    L7:
        fling(-r5);
        goto L14
    L9:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L15;
        int r10 = -r5;
        if (shouldAbsorb(this.mEdgeGlowBottom, r10) == false) goto L13;
        this.mEdgeGlowBottom.onAbsorb(r10);
        goto L14
    L13:
        fling(r10);
        goto L14
    L15:
        return false;
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View findFocusableViewInBounds(boolean r12, int r13, int r14) {
        ArrayList<View> r11 = getFocusables(2);
        int r5 = r11.size();
        View r10 = null;
        int r15 = 0;
        boolean r16 = false;
    L3:
        if (r15 >= r5) goto L31;
        View r17 = r11.get(r15);
        int r18 = r17.getTop();
        int r19 = r17.getBottom();
        if (r13 >= r19) goto L30;
        if (r18 >= r14) goto L30;
        if (r13 >= r18) goto L11;
        if (r19 >= r14) goto L11;
        boolean r20 = true;
    L12:
        if (r10 != null) goto L14;
        r10 = r17;
        r16 = r20;
        goto L30
    L14:
        if (r12 == true) goto L16;
    L17:
        if (r12 == false) goto L19;
    L21:
        boolean r21 = false;
    L22:
        if (r16 == false) goto L26;
        if (r20 == false) goto L30;
        if (r21 == false) goto L30;
    L29:
        r10 = r17;
        goto L30
    L26:
        if (r20 == false) goto L28;
        r10 = r17;
        r16 = true;
        goto L30
    L28:
        if (r21 == false) goto L30;
    L19:
        if (r19 <= r10.getBottom()) goto L21;
    L20:
        r21 = true;
        goto L22
    L16:
        if (r18 < r10.getTop()) goto L20;
    L11:
        r20 = false;
    L30:
        r15 = r15 + 1;
        goto L3
    L31:
        return r10;
    }

    private float getSplineFlingDistance(int r10) {
        double r5 = Math.log((Math.abs(r10) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float r11 = DECELERATION_RATE;
        return (float) (Math.exp((r11 / (((double) r11) - 1.0d)) * r5) * (this.mPhysicalCoeff * SCROLL_FRICTION));
    }

    private boolean inChild(int r5, int r10) {
        if (getChildCount() <= 0) goto L14;
        int r11 = getScrollY();
        View r12 = getChildAt(0);
        if (r10 >= (r12.getTop() - r11)) goto L7;
        return false;
    L7:
        if (r10 < (r12.getBottom() - r11)) goto L9;
        return false;
    L9:
        if (r5 >= r12.getLeft()) goto L11;
        return false;
    L11:
        if (r5 >= r12.getRight()) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r5.clear();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r5 = ViewConfiguration.get(getContext());
        this.mTouchSlop = r5.getScaledTouchSlop();
        this.mMinimumVelocity = r5.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r5.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    private void initializeTouchDrag(int r5, int r10) {
        this.mLastMotionY = r5;
        this.mActivePointerId = r10;
        startNestedScroll(2, 0);
    }

    private boolean isOffScreen(View r5) {
        return !isWithinDeltaOfScreen(r5, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View r5, View r10) {
        if (r5 != r10) goto L5;
        return true;
    L5:
        Object r11 = r5.getParent();
        if ((r11 instanceof ViewGroup) == true) goto L8;
    L10:
        return false;
    L8:
        if (isViewDescendantOf((View) r11, r10) == false) goto L10;
        return true;
    }

    private boolean isWithinDeltaOfScreen(View r5, int r10, int r11) {
        r5.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r5, this.mTempRect);
        if ((this.mTempRect.bottom + r10) >= getScrollY()) goto L5;
    L7:
        return false;
    L5:
        if ((this.mTempRect.top - r10) > (getScrollY() + r11)) goto L7;
        return true;
    }

    private void onNestedScrollInternal(int r11, int r12, @Nullable int[] r13) {
        int r5 = getScrollY();
        scrollBy(0, r11);
        int r10 = getScrollY() - r5;
        if (r13 == null) goto L5;
        r13[1] = r13[1] + r10;
    L5:
        NestedScrollingChildHelper r14 = this.mChildHelper;
        r14.dispatchNestedScroll(0, r10, 0, r11 - r10, null, r12, r13);
    }

    private void onSecondaryPointerUp(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        if (r5.getPointerId(r10) != this.mActivePointerId) goto L11;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.mLastMotionY = (int) r5.getY(r11);
        this.mActivePointerId = r5.getPointerId(r11);
        VelocityTracker r12 = this.mVelocityTracker;
        if (r12 == null) goto L12;
        r12.clear();
        return;
    L12:
        return;
    L6:
        r11 = 0;
        goto L7
    }

    private void recycleVelocityTracker() {
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L6;
        r5.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private int releaseVerticalGlow(int r5, float r10) {
        float r11 = r10 / getWidth();
        float r12 = r5 / getHeight();
        float r13 = 0.0f;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L9;
        float r14 = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -r12, r11);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) goto L7;
        this.mEdgeGlowTop.onRelease();
    L7:
        r13 = r14;
    L13:
        int r15 = Math.round(r13 * getHeight());
        if (r15 == 0) goto L16;
        invalidate();
    L16:
        return r15;
    L9:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L13;
        r14 = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r12, 1.0f - r11);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) goto L7;
        this.mEdgeGlowBottom.onRelease();
        goto L7
    }

    private void runAnimatedScroll(boolean r5) {
        if (r5 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        postInvalidateOnAnimation();
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    private boolean scrollAndFocus(int r10, int r11, int r12) {
        int r5 = getHeight();
        int r13 = getScrollY();
        int r14 = r5 + r13;
        boolean r15 = false;
        if (r10 != 33) goto L5;
        boolean r16 = true;
    L6:
        View r17 = findFocusableViewInBounds(r16, r11, r12);
        if (r17 != null) goto L9;
        r17 = this;
    L9:
        if (r11 < r13) goto L12;
        if (r12 > r14) goto L12;
    L17:
        if (r17 == findFocus()) goto L19;
        r17.requestFocus(r10);
    L19:
        return r15;
    L12:
        if (r16 == false) goto L14;
        int r18 = r11 - r13;
    L15:
        scrollBy(r18, 0, 1, true);
        r15 = true;
        goto L17
    L14:
        r18 = r12 - r14;
        goto L15
    L5:
        r16 = false;
        goto L6
    }

    private int scrollBy(int r22, int r23, int r24, boolean r25) {
        if (r24 != 1) goto L5;
        startNestedScroll(2, r24);
    L5:
        boolean r14 = false;
        if (dispatchNestedPreScroll(0, r22, this.mScrollConsumed, this.mScrollOffset, r24) == false) goto L8;
        int r15 = r22 - this.mScrollConsumed[1];
        int r16 = this.mScrollOffset[1];
    L9:
        int r17 = getScrollY();
        int r10 = getScrollRange();
        if (canOverScroll() == false) goto L13;
        if (r25 == true) goto L13;
        boolean r18 = true;
    L15:
        if (overScrollByCompat(0, r15, 0, r17, 0, r10, 0, 0, true) == true) goto L17;
    L19:
        boolean r11 = false;
    L20:
        int r5 = getScrollY() - r17;
        int[] r12 = this.mScrollConsumed;
        r12[1] = 0;
        dispatchNestedScroll(0, r5, 0, r15 - r5, this.mScrollOffset, r24, r12);
        int r19 = r16 + this.mScrollOffset[1];
        int r110 = r15 - this.mScrollConsumed[1];
        int r13 = r17 + r110;
        if (r13 >= 0) goto L27;
        if (r18 == false) goto L33;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-r110) / getHeight(), r23 / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L33;
        this.mEdgeGlowBottom.onRelease();
    L33:
        if (this.mEdgeGlowTop.isFinished() == true) goto L35;
    L38:
        postInvalidateOnAnimation();
    L39:
        if (r14 == false) goto L44;
        if (r24 != 0) goto L44;
        VelocityTracker r20 = this.mVelocityTracker;
        if (r20 == null) goto L44;
        r20.clear();
    L44:
        if (r24 != 1) goto L46;
        stopNestedScroll(r24);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    L46:
        return r19;
    L35:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L38;
        r14 = r11;
        goto L39
    L27:
        if (r13 <= r10) goto L33;
        if (r18 == false) goto L33;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r110 / getHeight(), 1.0f - (r23 / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L33;
        this.mEdgeGlowTop.onRelease();
        goto L33
    L17:
        if (hasNestedScrollingParent(r24) == true) goto L19;
        r11 = true;
    L13:
        r18 = false;
        goto L15
    L8:
        r15 = r22;
        r16 = 0;
        goto L9
    }

    private void scrollToChild(View r5) {
        r5.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r5, this.mTempRect);
        int r10 = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (r10 == 0) goto L6;
        scrollBy(0, r10);
        return;
    }

    private boolean scrollToChildRect(Rect r5, boolean r10) {
        int r11 = computeScrollDeltaToGetChildRectOnScreen(r5);
        if (r11 == 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        if (r10 == false) goto L9;
        scrollBy(0, r11);
        goto L10
    L9:
        smoothScrollBy(0, r11);
    L10:
        return r12;
    L5:
        r12 = false;
        goto L6
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect r5, int r10) {
        if (r10 <= 0) goto L6;
        return true;
    L6:
        if (getSplineFlingDistance(-r10) < (EdgeEffectCompat.getDistance(r5) * getHeight())) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean stopGlowAnimations(MotionEvent r10) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L5;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0.0f, r10.getX() / getWidth());
        boolean r5 = true;
    L7:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L10;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0.0f, 1.0f - (r10.getX() / getWidth()));
        return true;
    L10:
        return r5;
    L5:
        r5 = false;
        goto L7
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r5) {
        if (getChildCount() > 0) goto L7;
        super.addView(r5);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int r10) {
        View r5 = findFocus();
        if (r5 != this) goto L5;
        r5 = null;
    L5:
        View r11 = FocusFinder.getInstance().findNextFocus(this, r5, r10);
        int r12 = getMaxScrollAmount();
        if (r11 == null) goto L11;
        if (isWithinDeltaOfScreen(r11, r12, getHeight()) == false) goto L11;
        r11.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r11, this.mTempRect);
        scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
        r11.requestFocus(r10);
    L25:
        if (r5 != null) goto L27;
    L31:
        return true;
    L27:
        if (r5.isFocused() == false) goto L31;
        if (isOffScreen(r5) == false) goto L31;
        int r13 = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(r13);
    L11:
        if (r10 == 33) goto L13;
    L15:
        if (r10 == 130) goto L17;
    L19:
        if (r12 != 0) goto L21;
        return false;
    L21:
        if (r10 == 130) goto L24;
        r12 = -r12;
    L24:
        scrollBy(r12, 0, 1, true);
        goto L25
    L17:
        if (getChildCount() <= 0) goto L19;
        View r14 = getChildAt(0);
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        int r16 = r14.getBottom() + r15.bottomMargin;
        int r17 = getScrollY();
        r12 = Math.min(r16 - ((getHeight() + r17) - getPaddingBottom()), r12);
        goto L19
    L13:
        if (getScrollY() >= r12) goto L15;
        r12 = getScrollY();
        goto L19
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
        return;
    L5:
        this.mScroller.computeScrollOffset();
        int r5 = this.mScroller.getCurrY();
        int r10 = consumeFlingInVerticalStretch(r5 - this.mLastScrollerY);
        this.mLastScrollerY = r5;
        int[] r11 = this.mScrollConsumed;
        r11[1] = 0;
        dispatchNestedPreScroll(0, r10, r11, null, 1);
        int r13 = r10 - this.mScrollConsumed[1];
        int r14 = getScrollRange();
        if (r13 == 0) goto L8;
        int r15 = getScrollY();
        overScrollByCompat(0, r13, getScrollX(), r15, 0, r14, 0, 0, false);
        int r12 = getScrollY() - r15;
        int r16 = r13 - r12;
        int[] r17 = this.mScrollConsumed;
        r17[1] = 0;
        dispatchNestedScroll(0, r12, 0, r16, this.mScrollOffset, 1, r17);
        r13 = r16 - this.mScrollConsumed[1];
    L8:
        if (r13 == 0) goto L22;
        int r18 = getOverScrollMode();
        if (r18 == 0) goto L13;
        if (r18 != 1) goto L20;
        if (r14 > 0) goto L13;
    L20:
        abortAnimatedScroll();
    L13:
        if (r13 >= 0) goto L18;
        if (this.mEdgeGlowTop.isFinished() == false) goto L20;
        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L20
    L18:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L20;
        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
    L22:
        if (this.mScroller.isFinished() == true) goto L24;
        postInvalidateOnAnimation();
        return;
    L24:
        stopNestedScroll(1);
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect r11) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r5 = getHeight();
        int r10 = getScrollY();
        int r12 = r10 + r5;
        int r13 = getVerticalFadingEdgeLength();
        if (r11.top <= 0) goto L8;
        r10 = r10 + r13;
    L8:
        View r14 = getChildAt(0);
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        if (r11.bottom >= ((r14.getHeight() + r15.topMargin) + r15.bottomMargin)) goto L11;
        int r16 = r12 - r13;
    L12:
        int r17 = r11.bottom;
        if (r17 <= r16) goto L22;
        if (r11.top <= r10) goto L22;
        if (r11.height() <= r5) goto L19;
        int r18 = r11.top - r10;
    L30:
        return Math.min(r18, (r14.getBottom() + r15.bottomMargin) - r12);
    L19:
        r18 = r11.bottom - r16;
    L22:
        if (r11.top >= r10) goto L31;
        if (r17 < r16) goto L25;
        return 0;
    L25:
        if (r11.height() <= r5) goto L27;
        int r19 = 0 - (r16 - r11.bottom);
    L29:
        return Math.max(r19, -getScrollY());
    L27:
        r19 = 0 - (r10 - r11.top);
        goto L29
    L31:
        return 0;
    L11:
        r16 = r12;
        goto L12
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int r5 = getChildCount();
        int r10 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (r5 != 0) goto L5;
        return r10;
    L5:
        View r11 = getChildAt(0);
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11.getLayoutParams();
        int r13 = r11.getBottom() + r12.bottomMargin;
        int r14 = getScrollY();
        int r15 = Math.max(0, r13 - r10);
        if (r14 < 0) goto L11;
        if (r14 > r15) goto L10;
        return r13;
    L10:
        return r13 + (r14 - r15);
    L11:
        return r13 - r14;
    }

    public int consumeFlingInVerticalStretch(int r10) {
        int r5 = getHeight();
        if (r10 > 0) goto L5;
    L11:
        if (r10 < 0) goto L13;
        return r10;
    L13:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L20;
        float r11 = r5;
        float r12 = (r10 * FLING_DESTRETCH_FACTOR) / r11;
        int r13 = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r12, 0.5f) * (r11 / FLING_DESTRETCH_FACTOR));
        if (r13 == r10) goto L18;
        this.mEdgeGlowBottom.finish();
    L18:
        return r10 - r13;
    L20:
        return r10;
    L5:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L11;
        float r14 = ((-r10) * FLING_DESTRETCH_FACTOR) / r5;
        int r15 = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, r14, 0.5f) * ((-r5) / FLING_DESTRETCH_FACTOR));
        if (r15 == r10) goto L10;
        this.mEdgeGlowTop.finish();
    L10:
        return r10 - r15;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r5) {
        if (super.dispatchKeyEvent(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r5) == true) goto L8;
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        return this.mChildHelper.dispatchNestedFling(r5, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r5, float r10) {
        return this.mChildHelper.dispatchNestedPreFling(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13, int r14) {
        return this.mChildHelper.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15, @NonNull int[] r16) {
        this.mChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        int r5 = getScrollY();
        int r11 = 0;
        if (this.mEdgeGlowTop.isFinished() == true) goto L16;
        int r12 = r10.save();
        int r13 = getWidth();
        int r14 = getHeight();
        int r15 = Math.min(0, r5);
        if (Api21Impl.getClipToPadding(this) == false) goto L7;
        r13 = r13 - (getPaddingRight() + getPaddingLeft());
        int r16 = getPaddingLeft();
    L9:
        if (Api21Impl.getClipToPadding(this) == false) goto L11;
        r14 = r14 - (getPaddingBottom() + getPaddingTop());
        r15 = r15 + getPaddingTop();
    L11:
        r10.translate(r16, r15);
        this.mEdgeGlowTop.setSize(r13, r14);
        if (this.mEdgeGlowTop.draw(r10) == false) goto L14;
        postInvalidateOnAnimation();
    L14:
        r10.restoreToCount(r12);
        goto L16
    L7:
        r16 = 0;
    L16:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L28;
        int r17 = r10.save();
        int r18 = getWidth();
        int r19 = getHeight();
        int r20 = Math.max(getScrollRange(), r5) + r19;
        if (Api21Impl.getClipToPadding(this) == false) goto L21;
        r18 = r18 - (getPaddingRight() + getPaddingLeft());
        r11 = getPaddingLeft();
    L21:
        if (Api21Impl.getClipToPadding(this) == false) goto L23;
        r19 = r19 - (getPaddingBottom() + getPaddingTop());
        r20 = r20 - getPaddingBottom();
    L23:
        r10.translate(r11 - r18, r20);
        r10.rotate(180.0f, r18, 0.0f);
        this.mEdgeGlowBottom.setSize(r18, r19);
        if (this.mEdgeGlowBottom.draw(r10) == false) goto L26;
        postInvalidateOnAnimation();
    L26:
        r10.restoreToCount(r17);
        return;
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r10) {
        this.mTempRect.setEmpty();
        int r5 = 130;
        if (canScroll() == true) goto L19;
        if (isFocused() == true) goto L7;
        return false;
    L7:
        if (r10.getKeyCode() == 4) goto L53;
        View r11 = findFocus();
        if (r11 != this) goto L11;
        r11 = null;
    L11:
        View r12 = FocusFinder.getInstance().findNextFocus(this, r11, 130);
        if (r12 == null) goto L54;
        if (r12 != this) goto L15;
        return false;
    L15:
        if (r12.requestFocus(130) == false) goto L56;
        return true;
    L56:
        return false;
    L54:
        return false;
    L53:
        return false;
    L19:
        if (r10.getAction() != 0) goto L57;
        int r13 = r10.getKeyCode();
        if (r13 == 19) goto L48;
        if (r13 == 20) goto L44;
        if (r13 == 62) goto L40;
        if (r13 == 92) goto L61;
        if (r13 == 93) goto L60;
        if (r13 != 122) goto L33;
        pageScroll(33);
        return false;
    L33:
        if (r13 != 123) goto L66;
        pageScroll(130);
        return false;
    L66:
        return false;
    L60:
        return fullScroll(130);
    L61:
        return fullScroll(33);
    L40:
        if (r10.isShiftPressed() == false) goto L42;
        r5 = 33;
    L42:
        pageScroll(r5);
        return false;
    L44:
        if (r10.isAltPressed() == false) goto L64;
        return fullScroll(130);
    L64:
        return arrowScroll(130);
    L48:
        if (r10.isAltPressed() == false) goto L51;
        return fullScroll(33);
    L51:
        return arrowScroll(33);
    L57:
        return false;
    }

    public void fling(int r13) {
        if (getChildCount() <= 0) goto L6;
        this.mScroller.fling(getScrollX(), getScrollY(), 0, r13, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        runAnimatedScroll(true);
        return;
    }

    public boolean fullScroll(int r10) {
        if (r10 != 130) goto L5;
        boolean r5 = true;
    L6:
        int r11 = getHeight();
        Rect r12 = this.mTempRect;
        r12.top = 0;
        r12.bottom = r11;
        if (r5 == false) goto L11;
        int r13 = getChildCount();
        if (r13 <= 0) goto L11;
        View r14 = getChildAt(r13 - 1);
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        this.mTempRect.bottom = getPaddingBottom() + (r14.getBottom() + r15.bottomMargin);
        Rect r16 = this.mTempRect;
        r16.top = r16.bottom - r11;
    L11:
        Rect r17 = this.mTempRect;
        return scrollAndFocus(r10, r17.top, r17.bottom);
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        View r5 = getChildAt(0);
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        int r11 = getVerticalFadingEdgeLength();
        int r12 = ((r5.getBottom() + r10.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (r12 < r11) goto L9;
        return 1.0f;
    L9:
        return r12 / r11;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) goto L6;
        View r5 = getChildAt(0);
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        return Math.max(0, ((r5.getHeight() + r10.topMargin) + r10.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    L6:
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        int r5 = getVerticalFadingEdgeLength();
        int r10 = getScrollY();
        if (r10 < r5) goto L9;
        return 1.0f;
    L9:
        return r10 / r5;
    }

    @VisibleForTesting
    public float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor != 0.0f) goto L10;
        TypedValue r5 = new TypedValue();
        Context r10 = getContext();
        if (r10.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r5, true) == false) goto L8;
        this.mVerticalScrollFactor = r5.getDimension(r10.getResources().getDisplayMetrics());
        goto L10
    L8:
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
    L10:
        return this.mVerticalScrollFactor;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r5) {
        return this.mChildHelper.hasNestedScrollingParent(r5);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup
    public void measureChild(@NonNull View r5, int r10, int r11) {
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        int r13 = getPaddingLeft();
        r5.measure(ViewGroup.getChildMeasureSpec(r10, getPaddingRight() + r13, r12.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View r5, int r10, int r11, int r12, int r13) {
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        int r15 = getPaddingLeft();
        r5.measure(ViewGroup.getChildMeasureSpec(r10, (((getPaddingRight() + r15) + r14.leftMargin) + r14.rightMargin) + r11, r14.width), View.MeasureSpec.makeMeasureSpec(r14.topMargin + r14.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent r10) {
        if (r10.getAction() == 8) goto L5;
    L19:
        return false;
    L5:
        if (this.mIsBeingDragged == true) goto L19;
        if (MotionEventCompat.isFromSource(r10, 2) == false) goto L10;
        int r5 = 9;
        float r11 = r10.getAxisValue(9);
        int r12 = (int) r10.getX();
    L14:
        if (r11 == 0.0f) goto L19;
        scrollBy(-((int) (getVerticalScrollFactorCompat() * r11)), r12, 1, MotionEventCompat.isFromSource(r10, 8194));
        if (r5 == 0) goto L18;
        this.mDifferentialMotionFlingController.onMotionEvent(r10, r5);
    L18:
        return true;
    L10:
        if (MotionEventCompat.isFromSource(r10, 4194304) == false) goto L12;
        float r13 = r10.getAxisValue(26);
        r12 = getWidth() / 2;
        r5 = 26;
        r11 = r13;
        goto L14
    L12:
        r5 = 0;
        r12 = 0;
        r11 = 0.0f;
        goto L14
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent r12) {
        int r5 = r12.getAction();
        boolean r10 = true;
        if (r5 == 2) goto L5;
    L7:
        int r11 = r5 & 255;
        if (r11 != 0) goto L10;
        int r13 = (int) r12.getY();
        if (inChild((int) r12.getX(), r13) == false) goto L38;
        this.mLastMotionY = r13;
        this.mActivePointerId = r12.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(r12);
        this.mScroller.computeScrollOffset();
        if (stopGlowAnimations(r12) == false) goto L47;
    L50:
        this.mIsBeingDragged = r10;
        startNestedScroll(2, 0);
    L52:
        return this.mIsBeingDragged;
    L47:
        if (this.mScroller.isFinished() == false) goto L50;
        r10 = false;
        goto L50
    L38:
        if (stopGlowAnimations(r12) == false) goto L40;
    L43:
        this.mIsBeingDragged = r10;
        recycleVelocityTracker();
        goto L52
    L40:
        if (this.mScroller.isFinished() == false) goto L43;
        r10 = false;
        goto L43
    L10:
        if (r11 == 1) goto L31;
        if (r11 != 2) goto L13;
        int r14 = this.mActivePointerId;
        if (r14 == (-1)) goto L52;
        int r15 = r12.findPointerIndex(r14);
        if (r15 != (-1)) goto L24;
        Log.e(TAG, "Invalid pointerId=" + r14 + " in onInterceptTouchEvent");
        goto L52
    L24:
        int r16 = (int) r12.getY(r15);
        if (Math.abs(r16 - this.mLastMotionY) <= this.mTouchSlop) goto L52;
        if ((2 & getNestedScrollAxes()) != 0) goto L52;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r16;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(r12);
        this.mNestedYOffset = 0;
        ViewParent r17 = getParent();
        if (r17 == null) goto L52;
        r17.requestDisallowInterceptTouchEvent(true);
        goto L52
    L13:
        if (r11 == 3) goto L31;
        if (r11 != 6) goto L52;
        onSecondaryPointerUp(r12);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        postInvalidateOnAnimation();
    L34:
        stopNestedScroll(0);
        goto L52
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = 0;
        this.mIsLayoutDirty = false;
        View r15 = this.mChildToScrollTo;
        if (r15 != null) goto L5;
    L7:
        this.mChildToScrollTo = null;
        if (this.mIsLaidOut == false) goto L10;
    L18:
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
        return;
    L10:
        if (this.mSavedState == null) goto L13;
        scrollTo(getScrollX(), this.mSavedState.scrollPosition);
        this.mSavedState = null;
    L13:
        if (getChildCount() <= 0) goto L15;
        View r16 = getChildAt(0);
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16.getLayoutParams();
        r14 = (r16.getMeasuredHeight() + r17.topMargin) + r17.bottomMargin;
    L15:
        int r18 = ((r13 - r11) - getPaddingTop()) - getPaddingBottom();
        int r19 = getScrollY();
        int r20 = clamp(r19, r18, r14);
        if (r20 == r19) goto L18;
        scrollTo(getScrollX(), r20);
        goto L18
    L5:
        if (isViewDescendantOf(r15, this) == false) goto L7;
        scrollToChild(this.mChildToScrollTo);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if (this.mFillViewport == true) goto L6;
        return;
    L6:
        if (View.MeasureSpec.getMode(r10) != 0) goto L9;
        return;
    L9:
        if (getChildCount() <= 0) goto L14;
        View r11 = getChildAt(0);
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11.getLayoutParams();
        int r13 = r11.getMeasuredHeight();
        int r14 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - r12.topMargin) - r12.bottomMargin;
        if (r13 >= r14) goto L15;
        int r15 = getPaddingLeft();
        r11.measure(ViewGroup.getChildMeasureSpec(r5, ((getPaddingRight() + r15) + r12.leftMargin) + r12.rightMargin, r12.width), View.MeasureSpec.makeMeasureSpec(r14, BasicMeasure.EXACTLY));
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View r5, float r10, float r11, boolean r12) {
        if (r12 == true) goto L5;
        dispatchNestedFling(0.0f, r11, true);
        fling((int) r11);
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View r5, float r10, float r11) {
        return dispatchNestedPreFling(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13, int r14) {
        dispatchNestedPreScroll(r11, r12, r13, null, r14);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r5, int r10, int r11, int r12, int r13, int r14, @NonNull int[] r15) {
        onNestedScrollInternal(r13, r14, r15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View r5, @NonNull View r10, int r11, int r12) {
        this.mParentHelper.onNestedScrollAccepted(r5, r10, r11, r12);
        startNestedScroll(2, r12);
    }

    @Override // android.view.View
    public void onOverScrolled(int r5, int r10, boolean r11, boolean r12) {
        super.scrollTo(r5, r10);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r5, Rect r10) {
        if (r5 != 2) goto L6;
        r5 = 130;
    L8:
        if (r10 != null) goto L10;
        View r11 = FocusFinder.getInstance().findNextFocus(this, null, r5);
    L12:
        if (r11 != null) goto L15;
        return false;
    L15:
        if (isOffScreen(r11) == false) goto L18;
        return false;
    L18:
        return r11.requestFocus(r5, r10);
    L10:
        r11 = FocusFinder.getInstance().findNextFocusFromRect(this, r10, r5);
        goto L12
    L6:
        if (r5 != 1) goto L8;
        r5 = 33;
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        this.mSavedState = r10;
        requestLayout();
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.scrollPosition = getScrollY();
        return r5;
    }

    @Override // android.view.View
    public void onScrollChanged(int r10, int r11, int r12, int r13) {
        super.onScrollChanged(r10, r11, r12, r13);
        OnScrollChangeListener r5 = this.mOnScrollChangeListener;
        if (r5 == null) goto L6;
        r5.onScrollChange(this, r10, r11, r12, r13);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        View r13 = findFocus();
        if (r13 == null) goto L10;
        if (this != r13) goto L7;
        return;
    L7:
        if (isWithinDeltaOfScreen(r13, 0, r12) == false) goto L11;
        r13.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        return;
    L11:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View r5, @NonNull View r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View r5, int r10) {
        this.mParentHelper.onStopNestedScroll(r5, r10);
        stopNestedScroll(r10);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r13) {
        initVelocityTrackerIfNotExists();
        int r5 = r13.getActionMasked();
        if (r5 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r10 = MotionEvent.obtain(r13);
        r10.offsetLocation(0.0f, this.mNestedYOffset);
        if (r5 == 0) goto L56;
        if (r5 != 1) goto L9;
        VelocityTracker r14 = this.mVelocityTracker;
        r14.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r15 = (int) r14.getYVelocity(this.mActivePointerId);
        if (Math.abs(r15) < this.mMinimumVelocity) goto L52;
        if (edgeEffectFling(r15) == true) goto L54;
        int r16 = -r15;
        float r11 = r16;
        if (dispatchNestedPreFling(0.0f, r11) == true) goto L54;
        dispatchNestedFling(0.0f, r11, true);
        fling(r16);
    L54:
        endTouchDrag();
    L67:
        VelocityTracker r12 = this.mVelocityTracker;
        if (r12 == null) goto L70;
        r12.addMovement(r10);
    L70:
        r10.recycle();
        return true;
    L52:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L54;
        postInvalidateOnAnimation();
        goto L54
    L9:
        if (r5 != 2) goto L11;
        int r17 = r13.findPointerIndex(this.mActivePointerId);
        if (r17 != (-1)) goto L30;
        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
        goto L67
    L30:
        int r18 = (int) r13.getY(r17);
        int r19 = this.mLastMotionY - r18;
        int r20 = r19 - releaseVerticalGlow(r19, r13.getX(r17));
        if (this.mIsBeingDragged == true) goto L42;
        if (Math.abs(r20) <= this.mTouchSlop) goto L42;
        ViewParent r21 = getParent();
        if (r21 == null) goto L37;
        r21.requestDisallowInterceptTouchEvent(true);
    L37:
        this.mIsBeingDragged = true;
        if (r20 <= 0) goto L40;
        r20 = r20 - this.mTouchSlop;
        goto L42
    L40:
        r20 = r20 + this.mTouchSlop;
    L42:
        if (this.mIsBeingDragged == false) goto L67;
        int r110 = scrollBy(r20, (int) r13.getX(r17), 0, false);
        this.mLastMotionY = r18 - r110;
        this.mNestedYOffset += r110;
        goto L67
    L11:
        if (r5 == 3) goto L20;
        if (r5 != 5) goto L15;
        int r22 = r13.getActionIndex();
        this.mLastMotionY = (int) r13.getY(r22);
        this.mActivePointerId = r13.getPointerId(r22);
        goto L67
    L15:
        if (r5 != 6) goto L67;
        onSecondaryPointerUp(r13);
        this.mLastMotionY = (int) r13.getY(r13.findPointerIndex(this.mActivePointerId));
        goto L67
    L20:
        if (this.mIsBeingDragged == true) goto L22;
    L26:
        endTouchDrag();
        goto L67
    L22:
        if (getChildCount() <= 0) goto L26;
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L26;
        postInvalidateOnAnimation();
        goto L26
    L56:
        if (getChildCount() != 0) goto L59;
        return false;
    L59:
        if (this.mIsBeingDragged == false) goto L64;
        ViewParent r23 = getParent();
        if (r23 == null) goto L64;
        r23.requestDisallowInterceptTouchEvent(true);
    L64:
        if (this.mScroller.isFinished() == true) goto L66;
        abortAnimatedScroll();
    L66:
        initializeTouchDrag((int) r13.getY(), r13.getPointerId(0));
        goto L67
    }

    public boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        int r5 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r10 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r11 = true;
    L10:
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        if (r10 == true) goto L15;
    L14:
        boolean r12 = false;
    L16:
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L20;
        if (r11 == true) goto L21;
    L20:
        boolean r22 = false;
    L22:
        int r23 = r15 + r13;
        if (r12 == true) goto L25;
        int r24 = 0;
    L26:
        int r25 = r16 + r14;
        if (r22 == true) goto L29;
        int r26 = 0;
    L30:
        int r27 = -r24;
        int r28 = r24 + r17;
        int r29 = -r26;
        int r30 = r26 + r18;
        if (r23 <= r28) goto L33;
        r23 = r28;
        boolean r31 = true;
    L36:
        if (r25 <= r30) goto L38;
        r25 = r30;
        boolean r32 = true;
    L41:
        if (r32 == true) goto L43;
    L45:
        onOverScrolled(r23, r25, r31, r32);
        if (r31 == true) goto L49;
        if (r32 == true) goto L49;
        return false;
    L49:
        return true;
    L43:
        if (hasNestedScrollingParent(1) == true) goto L45;
        this.mScroller.springBack(r23, r25, 0, 0, 0, getScrollRange());
        goto L45
    L38:
        if (r25 >= r29) goto L40;
        r32 = true;
        r25 = r29;
        goto L41
    L40:
        r32 = false;
        goto L41
    L33:
        if (r23 >= r27) goto L35;
        r31 = true;
        r23 = r27;
        goto L36
    L35:
        r31 = false;
        goto L36
    L29:
        r26 = r20;
        goto L30
    L25:
        r24 = r19;
    L21:
        r22 = true;
    L15:
        r12 = true;
        goto L16
    L9:
        r11 = false;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    public boolean pageScroll(int r5) {
        if (r5 != 130) goto L5;
        boolean r10 = true;
    L6:
        int r11 = getHeight();
        if (r10 == false) goto L13;
        this.mTempRect.top = getScrollY() + r11;
        int r12 = getChildCount();
        if (r12 <= 0) goto L16;
        View r13 = getChildAt(r12 - 1);
        int r14 = getPaddingBottom() + (r13.getBottom() + ((FrameLayout.LayoutParams) r13.getLayoutParams()).bottomMargin);
        Rect r15 = this.mTempRect;
        if ((r15.top + r11) <= r14) goto L16;
        r15.top = r14 - r11;
    L16:
        Rect r16 = this.mTempRect;
        int r17 = r16.top;
        int r18 = r11 + r17;
        r16.bottom = r18;
        return scrollAndFocus(r5, r17, r18);
    L13:
        this.mTempRect.top = getScrollY() - r11;
        Rect r19 = this.mTempRect;
        if (r19.top >= 0) goto L16;
        r19.top = 0;
        goto L16
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r5, View r10) {
        if (this.mIsLayoutDirty == true) goto L5;
        scrollToChild(r10);
    L6:
        super.requestChildFocus(r5, r10);
        return;
    L5:
        this.mChildToScrollTo = r10;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View r5, Rect r10, boolean r11) {
        r10.offset(r5.getLeft() - r5.getScrollX(), r5.getTop() - r5.getScrollY());
        return scrollToChildRect(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r5) {
        if (r5 == false) goto L4;
        recycleVelocityTracker();
    L4:
        super.requestDisallowInterceptTouchEvent(r5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        if (getChildCount() <= 0) goto L10;
        View r5 = getChildAt(0);
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        int r13 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r14 = (r5.getWidth() + r12.leftMargin) + r12.rightMargin;
        int r15 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r16 = (r5.getHeight() + r12.topMargin) + r12.bottomMargin;
        int r17 = clamp(r10, r13, r14);
        int r18 = clamp(r11, r15, r16);
        if (r17 == getScrollX()) goto L7;
    L8:
        super.scrollTo(r17, r18);
        return;
    L7:
        if (r18 != getScrollY()) goto L8;
        return;
    }

    public void setFillViewport(boolean r5) {
        if (r5 == this.mFillViewport) goto L6;
        this.mFillViewport = r5;
        requestLayout();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        this.mChildHelper.setNestedScrollingEnabled(r5);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener r5) {
        this.mOnScrollChangeListener = r5;
    }

    public void setSmoothScrollingEnabled(boolean r5) {
        this.mSmoothScrollingEnabled = r5;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int r5, int r10) {
        smoothScrollBy(r5, r10, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollTo(int r5, int r10) {
        smoothScrollTo(r5, r10, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r5, int r10) {
        return this.mChildHelper.startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r5) {
        this.mChildHelper.stopNestedScroll(r5);
    }

    public NestedScrollView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, androidx.core.R.attr.nestedScrollViewStyle);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13) {
        return dispatchNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15) {
        return this.mChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13) {
        onNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View r5, int r10, int r11, int r12, int r13, int r14) {
        onNestedScrollInternal(r13, r14, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View r5, @NonNull View r10, int r11) {
        return onStartNestedScroll(r5, r10, r11, 0);
    }

    public final void smoothScrollBy(int r5, int r10, int r11) {
        smoothScrollBy(r5, r10, r11, false);
    }

    public final void smoothScrollTo(int r5, int r10, int r11) {
        smoothScrollTo(r5, r10, r11, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r5) {
        return startNestedScroll(r5, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        DifferentialMotionFlingTargetImpl r5 = new DifferentialMotionFlingTargetImpl(this);
        this.mDifferentialMotionFlingTarget = r5;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), r5);
        this.mEdgeGlowTop = EdgeEffectCompat.create(r10, r11);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(r10, r11);
        this.mPhysicalCoeff = ((r10.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        initScrollView();
        TypedArray r13 = r10.obtainStyledAttributes(r11, SCROLLVIEW_STYLEABLE, r12, 0);
        setFillViewport(r13.getBoolean(0, false));
        r13.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void smoothScrollBy(int r10, int r11, int r12, boolean r13) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if ((AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll) <= 250) goto L9;
        View r5 = getChildAt(0);
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        int r15 = (r5.getHeight() + r14.topMargin) + r14.bottomMargin;
        int r16 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r17 = getScrollY();
        int r18 = r11 + r17;
        int r19 = Math.max(0, Math.min(r18, Math.max(0, r15 - r16))) - r17;
        this.mScroller.startScroll(getScrollX(), r17, 0, r19, r12);
        runAnimatedScroll(r13);
    L12:
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        return;
    L9:
        if (this.mScroller.isFinished() == true) goto L11;
        abortAnimatedScroll();
    L11:
        scrollBy(r10, r11);
        goto L12
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14) {
        return this.mChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View r5, int r10, int r11, int r12, int r13) {
        onNestedScrollInternal(r13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View r5, @NonNull View r10, int r11) {
        onNestedScrollAccepted(r5, r10, r11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View r5) {
        onStopNestedScroll(r5, 0);
    }

    public void smoothScrollTo(int r5, int r10, boolean r11) {
        smoothScrollTo(r5, r10, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, r11);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10) {
        if (getChildCount() > 0) goto L7;
        super.addView(r5, r10);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void smoothScrollTo(int r5, int r10, int r11, boolean r12) {
        smoothScrollBy(r5 - getScrollX(), r10 - getScrollY(), r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r5, ViewGroup.LayoutParams r10) {
        if (getChildCount() > 0) goto L7;
        super.addView(r5, r10);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if (getChildCount() > 0) goto L7;
        super.addView(r5, r10, r11);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
