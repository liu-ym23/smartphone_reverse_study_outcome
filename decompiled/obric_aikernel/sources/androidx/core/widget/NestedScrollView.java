package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
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
import androidx.core.view.AccessibilityDelegateCompat;
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

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onInitializeAccessibilityEvent(r10, r11);
            NestedScrollView r12 = (NestedScrollView) r10;
            r11.setClassName(ScrollView.class.getName());
            if (r12.getScrollRange() <= 0) goto L5;
            boolean r13 = true;
        L6:
            r11.setScrollable(r13);
            r11.setScrollX(r12.getScrollX());
            r11.setScrollY(r12.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(r11, r12.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(r11, r12.getScrollRange());
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            NestedScrollView r12 = (NestedScrollView) r10;
            r11.setClassName(ScrollView.class.getName());
            if (r12.isEnabled() == false) goto L13;
            int r13 = r12.getScrollRange();
            if (r13 <= 0) goto L14;
            r11.setScrollable(true);
            if (r12.getScrollY() <= 0) goto L10;
            r11.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r11.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        L10:
            if (r12.getScrollY() >= r13) goto L15;
            r11.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r11.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (super.performAccessibilityAction(r10, r11, r12) == false) goto L5;
            return true;
        L5:
            NestedScrollView r13 = (NestedScrollView) r10;
            if (r13.isEnabled() == true) goto L8;
            return false;
        L8:
            int r14 = r13.getHeight();
            Rect r15 = new Rect();
            if (r13.getMatrix().isIdentity() == false) goto L14;
            if (r13.getGlobalVisibleRect(r15) == false) goto L14;
            r14 = r15.height();
        L14:
            if (r11 != 4096) goto L16;
        L27:
            int r16 = (r14 - r13.getPaddingBottom()) - r13.getPaddingTop();
            int r17 = Math.min(r13.getScrollY() + r16, r13.getScrollRange());
            if (r17 == r13.getScrollY()) goto L31;
            r13.smoothScrollTo(0, r17, true);
            return true;
        L31:
            return false;
        L16:
            if (r11 != 8192) goto L18;
        L22:
            int r18 = (r14 - r13.getPaddingBottom()) - r13.getPaddingTop();
            int r19 = Math.max(r13.getScrollY() - r18, 0);
            if (r19 == r13.getScrollY()) goto L26;
            r13.smoothScrollTo(0, r19, true);
            return true;
        L26:
            return false;
        L18:
            if (r11 == 16908344) goto L22;
            if (r11 == 16908346) goto L27;
            return false;
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean getClipToPadding(ViewGroup r10) {
            return r10.getClipToPadding();
        }
    }

    public interface OnScrollChangeListener {
        void onScrollChange(@NonNull NestedScrollView r10, int r11, int r12, int r13, int r14);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int scrollPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r10) {
            super(r10);
            this.scrollPosition = r10.readInt();
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.scrollPosition);
        }
    }

    static {
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[]{R.attr.fillViewport};
    }

    public NestedScrollView(@NonNull Context r10) {
        this(r10, null);
    }

    public NestedScrollView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, androidx.core.R.attr.nestedScrollViewStyle);
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

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean canOverScroll() {
        int r10 = getOverScrollMode();
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L6;
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
        View r10 = getChildAt(0);
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        if (((r10.getHeight() + r11.topMargin) + r11.bottomMargin) <= ((getHeight() - getPaddingTop()) - getPaddingBottom())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    private static int clamp(int r10, int r11, int r12) {
        if (r11 >= r12) goto L10;
        if (r10 >= 0) goto L6;
        return 0;
    L6:
        if ((r11 + r10) > r12) goto L8;
        return r10;
    L8:
        return r12 - r11;
    L10:
        return 0;
    }

    private void doScrollY(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        if (this.mSmoothScrollingEnabled == false) goto L6;
        smoothScrollBy(0, r10);
        return;
    L6:
        scrollBy(0, r10);
    }

    private boolean edgeEffectFling(int r10) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L11;
        if (shouldAbsorb(this.mEdgeGlowTop, r10) == false) goto L8;
        EdgeEffect r11 = this.mEdgeGlowTop;
    L7:
        r11.onAbsorb(r10);
    L15:
        return true;
    L8:
        r10 = -r10;
    L9:
        fling(r10);
        goto L15
    L11:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L16;
        r10 = -r10;
        if (shouldAbsorb(this.mEdgeGlowBottom, r10) == false) goto L9;
        r11 = this.mEdgeGlowBottom;
        goto L7
    L16:
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
        ArrayList r11 = getFocusables(2);
        int r10 = r11.size();
        View r15 = null;
        int r16 = 0;
        boolean r17 = false;
    L3:
        if (r16 >= r10) goto L30;
        View r18 = (View) r11.get(r16);
        int r19 = r18.getTop();
        int r20 = r18.getBottom();
        if (r13 >= r20) goto L29;
        if (r19 >= r14) goto L29;
        if (r13 >= r19) goto L10;
        if (r20 >= r14) goto L10;
        boolean r21 = true;
    L11:
        if (r15 != null) goto L13;
        r15 = r18;
        r17 = r21;
        goto L29
    L13:
        if (r12 == true) goto L15;
    L16:
        if (r12 == false) goto L18;
    L20:
        boolean r22 = false;
    L21:
        if (r17 == false) goto L25;
        if (r21 == false) goto L29;
        if (r22 == false) goto L29;
    L28:
        r15 = r18;
        goto L29
    L25:
        if (r21 == false) goto L27;
        r15 = r18;
        r17 = true;
        goto L29
    L27:
        if (r22 == false) goto L29;
    L18:
        if (r20 <= r15.getBottom()) goto L20;
    L19:
        r22 = true;
        goto L21
    L15:
        if (r19 < r15.getTop()) goto L19;
    L10:
        r21 = false;
    L29:
        r16 = r16 + 1;
        goto L3
    L30:
        return r15;
    }

    private float getSplineFlingDistance(int r10) {
        double r11 = Math.log((Math.abs(r10) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float r12 = DECELERATION_RATE;
        return (float) ((this.mPhysicalCoeff * SCROLL_FRICTION) * Math.exp((r12 / (((double) r12) - 1.0d)) * r11));
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor != 0.0f) goto L10;
        TypedValue r10 = new TypedValue();
        Context r11 = getContext();
        if (r11.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r10, true) == false) goto L8;
        this.mVerticalScrollFactor = r10.getDimension(r11.getResources().getDisplayMetrics());
        goto L10
    L8:
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
    L10:
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int r10, int r11) {
        if (getChildCount() <= 0) goto L14;
        int r12 = getScrollY();
        View r13 = getChildAt(0);
        if (r11 >= (r13.getTop() - r12)) goto L7;
        return false;
    L7:
        if (r11 < (r13.getBottom() - r12)) goto L9;
        return false;
    L9:
        if (r10 >= r13.getLeft()) goto L11;
        return false;
    L11:
        if (r10 >= r13.getRight()) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r10.clear();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        this.mTouchSlop = r10.getScaledTouchSlop();
        this.mMinimumVelocity = r10.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r10.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    private void initializeTouchDrag(int r10, int r11) {
        this.mLastMotionY = r10;
        this.mActivePointerId = r11;
        startNestedScroll(2, 0);
    }

    private boolean isOffScreen(View r10) {
        return !isWithinDeltaOfScreen(r10, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View r10, View r11) {
        if (r10 != r11) goto L5;
        return true;
    L5:
        Object r12 = r10.getParent();
        if ((r12 instanceof ViewGroup) == true) goto L8;
    L10:
        return false;
    L8:
        if (isViewDescendantOf((View) r12, r11) == false) goto L10;
        return true;
    }

    private boolean isWithinDeltaOfScreen(View r10, int r11, int r12) {
        r10.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        if ((this.mTempRect.bottom + r11) >= getScrollY()) goto L5;
    L7:
        return false;
    L5:
        if ((this.mTempRect.top - r11) > (getScrollY() + r12)) goto L7;
        return true;
    }

    private void onNestedScrollInternal(int r11, int r12, @Nullable int[] r13) {
        int r10 = getScrollY();
        scrollBy(0, r11);
        int r14 = getScrollY() - r10;
        if (r13 == null) goto L5;
        r13[1] = r13[1] + r14;
    L5:
        NestedScrollingChildHelper r15 = this.mChildHelper;
        r15.dispatchNestedScroll(0, r14, 0, r11 - r14, null, r12, r13);
    }

    private void onSecondaryPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.mActivePointerId) goto L11;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.mLastMotionY = (int) r10.getY(r12);
        this.mActivePointerId = r10.getPointerId(r12);
        VelocityTracker r13 = this.mVelocityTracker;
        if (r13 == null) goto L12;
        r13.clear();
        return;
    L12:
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private void recycleVelocityTracker() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private int releaseVerticalGlow(int r10, float r11) {
        float r12 = r11 / getWidth();
        float r13 = r10 / getHeight();
        float r14 = 0.0f;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L10;
        float r15 = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -r13, r12);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) goto L8;
        EdgeEffect r16 = this.mEdgeGlowTop;
    L7:
        r16.onRelease();
    L8:
        r14 = r15;
    L14:
        int r17 = Math.round(r14 * getHeight());
        if (r17 == 0) goto L17;
        invalidate();
    L17:
        return r17;
    L10:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L14;
        r15 = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r13, 1.0f - r12);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) goto L8;
        r16 = this.mEdgeGlowBottom;
        goto L7
    }

    private void runAnimatedScroll(boolean r10) {
        if (r10 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    private boolean scrollAndFocus(int r10, int r11, int r12) {
        int r13 = getHeight();
        int r14 = getScrollY();
        int r15 = r13 + r14;
        boolean r16 = false;
        if (r10 != 33) goto L5;
        boolean r17 = true;
    L6:
        View r18 = findFocusableViewInBounds(r17, r11, r12);
        if (r18 != null) goto L9;
        r18 = this;
    L9:
        if (r11 < r14) goto L12;
        if (r12 > r15) goto L12;
    L17:
        if (r18 == findFocus()) goto L19;
        r18.requestFocus(r10);
    L19:
        return r16;
    L12:
        if (r17 == false) goto L14;
        int r19 = r11 - r14;
    L15:
        scrollBy(r19, 0, 1, true);
        r16 = true;
        goto L17
    L14:
        r19 = r12 - r15;
        goto L15
    L5:
        r17 = false;
        goto L6
    }

    private int scrollBy(int r22, int r23, int r24, boolean r25) {
        if (r24 != 1) goto L5;
        startNestedScroll(2, r24);
    L5:
        boolean r14 = false;
        if (dispatchNestedPreScroll(0, r22, this.mScrollConsumed, this.mScrollOffset, r24) == false) goto L8;
        int r15 = r22 - this.mScrollConsumed[1];
        int r16 = this.mScrollOffset[1] + 0;
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
        int r12 = getScrollY() - r17;
        int[] r13 = this.mScrollConsumed;
        r13[1] = 0;
        dispatchNestedScroll(0, r12, 0, r15 - r12, this.mScrollOffset, r24, r13);
        int r19 = r16 + this.mScrollOffset[1];
        int r110 = r15 - this.mScrollConsumed[1];
        int r20 = r17 + r110;
        if (r20 >= 0) goto L28;
        if (r18 == false) goto L34;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-r110) / getHeight(), r23 / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L34;
        EdgeEffect r21 = this.mEdgeGlowBottom;
    L26:
        r21.onRelease();
    L34:
        if (this.mEdgeGlowTop.isFinished() == true) goto L36;
    L39:
        ViewCompat.postInvalidateOnAnimation(this);
    L40:
        if (r14 == false) goto L43;
        if (r24 != 0) goto L43;
        this.mVelocityTracker.clear();
    L43:
        if (r24 != 1) goto L45;
        stopNestedScroll(r24);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    L45:
        return r19;
    L36:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L39;
        r14 = r11;
        goto L40
    L28:
        if (r20 <= r10) goto L34;
        if (r18 == false) goto L34;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, r110 / getHeight(), 1.0f - (r23 / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L34;
        r21 = this.mEdgeGlowTop;
        goto L26
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

    private void scrollToChild(View r10) {
        r10.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        int r11 = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (r11 == 0) goto L6;
        scrollBy(0, r11);
        return;
    }

    private boolean scrollToChildRect(Rect r10, boolean r11) {
        int r12 = computeScrollDeltaToGetChildRectOnScreen(r10);
        if (r12 == 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        if (r11 == false) goto L9;
        scrollBy(0, r12);
        goto L10
    L9:
        smoothScrollBy(0, r12);
    L10:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect r10, int r11) {
        if (r11 <= 0) goto L6;
        return true;
    L6:
        if (getSplineFlingDistance(-r11) < (EdgeEffectCompat.getDistance(r10) * getHeight())) goto L10;
        return false;
    L10:
        return true;
    }

    private void smoothScrollBy(int r10, int r11, int r12, boolean r13) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if ((AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll) <= 250) goto L9;
        View r14 = getChildAt(0);
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        int r16 = (r14.getHeight() + r15.topMargin) + r15.bottomMargin;
        int r17 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r18 = getScrollY();
        int r19 = r11 + r18;
        int r20 = Math.max(0, Math.min(r19, Math.max(0, r16 - r17))) - r18;
        this.mScroller.startScroll(getScrollX(), r18, 0, r20, r12);
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

    private boolean stopGlowAnimations(MotionEvent r10) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L5;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0.0f, r10.getX() / getWidth());
        boolean r11 = true;
    L7:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L10;
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0.0f, 1.0f - (r10.getX() / getWidth()));
        return true;
    L10:
        return r11;
    L5:
        r11 = false;
        goto L7
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View r10) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10, r11);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10, r11, r12);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r10, ViewGroup.LayoutParams r11) {
        if (getChildCount() > 0) goto L7;
        super.addView(r10, r11);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int r10) {
        View r11 = findFocus();
        if (r11 != this) goto L5;
        r11 = null;
    L5:
        View r12 = FocusFinder.getInstance().findNextFocus(this, r11, r10);
        int r13 = getMaxScrollAmount();
        if (r12 == null) goto L11;
        if (isWithinDeltaOfScreen(r12, r13, getHeight()) == false) goto L11;
        r12.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r12, this.mTempRect);
        scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
        r12.requestFocus(r10);
    L25:
        if (r11 != null) goto L27;
    L31:
        return true;
    L27:
        if (r11.isFocused() == false) goto L31;
        if (isOffScreen(r11) == false) goto L31;
        int r14 = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(r14);
    L11:
        if (r10 == 33) goto L13;
    L15:
        if (r10 == 130) goto L17;
    L19:
        if (r13 != 0) goto L21;
        return false;
    L21:
        if (r10 == 130) goto L24;
        r13 = -r13;
    L24:
        scrollBy(r13, 0, 1, true);
        goto L25
    L17:
        if (getChildCount() <= 0) goto L19;
        View r15 = getChildAt(0);
        FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        r13 = Math.min((r15.getBottom() + r16.bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), r13);
        goto L19
    L13:
        if (getScrollY() >= r13) goto L15;
        r13 = getScrollY();
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
        int r10 = this.mScroller.getCurrY();
        int r11 = consumeFlingInVerticalStretch(r10 - this.mLastScrollerY);
        this.mLastScrollerY = r10;
        int[] r12 = this.mScrollConsumed;
        boolean r13 = false;
        r12[1] = 0;
        dispatchNestedPreScroll(0, r11, r12, null, 1);
        int r14 = r11 - this.mScrollConsumed[1];
        int r15 = getScrollRange();
        if (r14 == 0) goto L8;
        int r16 = getScrollY();
        overScrollByCompat(0, r14, getScrollX(), r16, 0, r15, 0, 0, false);
        int r17 = getScrollY() - r16;
        int r18 = r14 - r17;
        int[] r19 = this.mScrollConsumed;
        r19[1] = 0;
        dispatchNestedScroll(0, r17, 0, r18, this.mScrollOffset, 1, r19);
        r14 = r18 - this.mScrollConsumed[1];
    L8:
        if (r14 == 0) goto L25;
        int r20 = getOverScrollMode();
        if (r20 == 0) goto L13;
        if (r20 != 1) goto L14;
        if (r15 > 0) goto L13;
    L14:
        if (r13 == false) goto L23;
        if (r14 >= 0) goto L20;
        if (this.mEdgeGlowTop.isFinished() == false) goto L23;
        EdgeEffect r21 = this.mEdgeGlowTop;
    L22:
        r21.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L23
    L20:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L23;
        r21 = this.mEdgeGlowBottom;
    L23:
        abortAnimatedScroll();
    L13:
        r13 = true;
    L25:
        if (this.mScroller.isFinished() == true) goto L27;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L27:
        stopNestedScroll(1);
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect r11) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r10 = getHeight();
        int r12 = getScrollY();
        int r13 = r12 + r10;
        int r14 = getVerticalFadingEdgeLength();
        if (r11.top <= 0) goto L8;
        r12 = r12 + r14;
    L8:
        View r15 = getChildAt(0);
        FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        if (r11.bottom >= ((r15.getHeight() + r16.topMargin) + r16.bottomMargin)) goto L11;
        int r17 = r13 - r14;
    L12:
        int r18 = r11.bottom;
        if (r18 <= r17) goto L22;
        if (r11.top <= r12) goto L22;
        if (r11.height() <= r10) goto L19;
        int r19 = r11.top - r12;
    L30:
        return Math.min(r19 + 0, (r15.getBottom() + r16.bottomMargin) - r13);
    L19:
        r19 = r11.bottom - r17;
    L22:
        if (r11.top >= r12) goto L31;
        if (r18 < r17) goto L25;
        return 0;
    L25:
        if (r11.height() <= r10) goto L27;
        int r20 = 0 - (r17 - r11.bottom);
    L29:
        return Math.max(r20, -getScrollY());
    L27:
        r20 = 0 - (r12 - r11.top);
        goto L29
    L31:
        return 0;
    L11:
        r17 = r13;
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
        int r10 = getChildCount();
        int r11 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (r10 != 0) goto L5;
        return r11;
    L5:
        View r12 = getChildAt(0);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        int r14 = r12.getBottom() + r13.bottomMargin;
        int r15 = getScrollY();
        int r16 = Math.max(0, r14 - r11);
        if (r15 < 0) goto L11;
        if (r15 > r16) goto L10;
        return r14;
    L10:
        return r14 + (r15 - r16);
    L11:
        return r14 - r15;
    }

    int consumeFlingInVerticalStretch(int r10) {
        int r11 = getHeight();
        if (r10 > 0) goto L5;
    L11:
        if (r10 < 0) goto L13;
        return r10;
    L13:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) goto L20;
        float r12 = r11;
        int r13 = Math.round((r12 / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (r10 * FLING_DESTRETCH_FACTOR) / r12, 0.5f));
        if (r13 == r10) goto L18;
        this.mEdgeGlowBottom.finish();
    L18:
        return r10 - r13;
    L20:
        return r10;
    L5:
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) goto L11;
        int r14 = Math.round(((-r11) / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((-r10) * FLING_DESTRETCH_FACTOR) / r11, 0.5f));
        if (r14 == r10) goto L10;
        this.mEdgeGlowTop.finish();
    L10:
        return r10 - r14;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r10) {
        if (super.dispatchKeyEvent(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r10, float r11, boolean r12) {
        return this.mChildHelper.dispatchNestedFling(r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r10, float r11) {
        return this.mChildHelper.dispatchNestedPreFling(r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13) {
        return dispatchNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13, int r14) {
        return this.mChildHelper.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15, @NonNull int[] r16) {
        this.mChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14) {
        return this.mChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15) {
        return this.mChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r11) {
        super.draw(r11);
        int r10 = getScrollY();
        int r12 = 0;
        if (this.mEdgeGlowTop.isFinished() == true) goto L20;
        int r13 = r11.save();
        int r14 = getWidth();
        int r15 = getHeight();
        int r16 = Math.min(0, r10);
        int r17 = Build.VERSION.SDK_INT;
        if (r17 >= 21) goto L7;
    L10:
        r14 = r14 - (getPaddingLeft() + getPaddingRight());
        int r18 = getPaddingLeft() + 0;
    L11:
        if (r17 >= 21) goto L13;
    L15:
        r11.translate(r18, r16);
        this.mEdgeGlowTop.setSize(r14, r15);
        if (this.mEdgeGlowTop.draw(r11) == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
    L18:
        r11.restoreToCount(r13);
        goto L20
    L13:
        if (Api21Impl.getClipToPadding(this) == false) goto L15;
        r15 = r15 - (getPaddingTop() + getPaddingBottom());
        r16 = r16 + getPaddingTop();
        goto L15
    L7:
        if (Api21Impl.getClipToPadding(this) == true) goto L10;
        r18 = 0;
    L20:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L35;
        int r19 = r11.save();
        int r20 = getWidth();
        int r21 = getHeight();
        int r22 = Math.max(getScrollRange(), r10) + r21;
        int r23 = Build.VERSION.SDK_INT;
        if (r23 >= 21) goto L24;
    L25:
        r20 = r20 - (getPaddingLeft() + getPaddingRight());
        r12 = 0 + getPaddingLeft();
    L26:
        if (r23 >= 21) goto L28;
    L30:
        r11.translate(r12 - r20, r22);
        r11.rotate(180.0f, r20, 0.0f);
        this.mEdgeGlowBottom.setSize(r20, r21);
        if (this.mEdgeGlowBottom.draw(r11) == false) goto L33;
        ViewCompat.postInvalidateOnAnimation(this);
    L33:
        r11.restoreToCount(r19);
        return;
    L28:
        if (Api21Impl.getClipToPadding(this) == false) goto L30;
        r21 = r21 - (getPaddingTop() + getPaddingBottom());
        r22 = r22 - getPaddingBottom();
        goto L30
    L24:
        if (Api21Impl.getClipToPadding(this) == false) goto L26;
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r10) {
        this.mTempRect.setEmpty();
        int r11 = 130;
        if (canScroll() == true) goto L19;
        if (isFocused() == true) goto L7;
        return false;
    L7:
        if (r10.getKeyCode() == 4) goto L41;
        View r12 = findFocus();
        if (r12 != this) goto L11;
        r12 = null;
    L11:
        View r13 = FocusFinder.getInstance().findNextFocus(this, r12, 130);
        if (r13 == null) goto L42;
        if (r13 != this) goto L15;
        return false;
    L15:
        if (r13.requestFocus(130) == false) goto L44;
        return true;
    L44:
        return false;
    L42:
        return false;
    L41:
        return false;
    L19:
        if (r10.getAction() != 0) goto L45;
        int r14 = r10.getKeyCode();
        if (r14 == 19) goto L36;
        if (r14 == 20) goto L32;
        if (r14 == 62) goto L28;
        return false;
    L28:
        if (r10.isShiftPressed() == false) goto L30;
        r11 = 33;
    L30:
        pageScroll(r11);
        return false;
    L32:
        if (r10.isAltPressed() == true) goto L48;
        return arrowScroll(130);
    L48:
        return fullScroll(130);
    L36:
        if (r10.isAltPressed() == true) goto L39;
        return arrowScroll(33);
    L39:
        return fullScroll(33);
    L45:
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
        boolean r11 = true;
    L6:
        int r12 = getHeight();
        Rect r13 = this.mTempRect;
        r13.top = 0;
        r13.bottom = r12;
        if (r11 == false) goto L11;
        int r14 = getChildCount();
        if (r14 <= 0) goto L11;
        View r15 = getChildAt(r14 - 1);
        FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        this.mTempRect.bottom = (r15.getBottom() + r16.bottomMargin) + getPaddingBottom();
        Rect r17 = this.mTempRect;
        r17.top = r17.bottom - r12;
    L11:
        Rect r18 = this.mTempRect;
        return scrollAndFocus(r10, r18.top, r18.bottom);
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        View r10 = getChildAt(0);
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        int r12 = getVerticalFadingEdgeLength();
        int r13 = ((r10.getBottom() + r11.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (r13 < r12) goto L9;
        return 1.0f;
    L9:
        return r13 / r12;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) goto L6;
        View r10 = getChildAt(0);
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        return Math.max(0, ((r10.getHeight() + r11.topMargin) + r11.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    L6:
        return 0;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        int r10 = getVerticalFadingEdgeLength();
        int r11 = getScrollY();
        if (r11 < r10) goto L9;
        return 1.0f;
    L9:
        return r11 / r10;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r10) {
        return this.mChildHelper.hasNestedScrollingParent(r10);
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
    protected void measureChild(@NonNull View r10, int r11, int r12) {
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        r10.measure(FrameLayout.getChildMeasureSpec(r11, getPaddingLeft() + getPaddingRight(), r13.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View r10, int r11, int r12, int r13, int r14) {
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        r10.measure(FrameLayout.getChildMeasureSpec(r11, (((getPaddingLeft() + getPaddingRight()) + r15.leftMargin) + r15.rightMargin) + r12, r15.width), View.MeasureSpec.makeMeasureSpec(r15.topMargin + r15.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent r10) {
        if (r10.getAction() == 8) goto L5;
        return false;
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return false;
    L7:
        if (MotionEventCompat.isFromSource(r10, 2) == false) goto L10;
        float r11 = r10.getAxisValue(9);
        int r12 = (int) r10.getX();
    L14:
        if (r11 == 0.0f) goto L19;
        scrollBy(-((int) (r11 * getVerticalScrollFactorCompat())), r12, 1, MotionEventCompat.isFromSource(r10, 8194));
        return true;
    L19:
        return false;
    L10:
        if (MotionEventCompat.isFromSource(r10, 4194304) == false) goto L12;
        float r13 = r10.getAxisValue(26);
        r12 = getWidth() / 2;
        r11 = r13;
        goto L14
    L12:
        r12 = 0;
        r11 = 0.0f;
        goto L14
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent r12) {
        int r10 = r12.getAction();
        boolean r11 = true;
        if (r10 == 2) goto L5;
    L7:
        int r13 = r10 & 255;
        if (r13 != 0) goto L10;
        int r14 = (int) r12.getY();
        if (inChild((int) r12.getX(), r14) == false) goto L38;
        this.mLastMotionY = r14;
        this.mActivePointerId = r12.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(r12);
        this.mScroller.computeScrollOffset();
        if (stopGlowAnimations(r12) == false) goto L47;
    L50:
        this.mIsBeingDragged = r11;
        startNestedScroll(2, 0);
    L52:
        return this.mIsBeingDragged;
    L47:
        if (this.mScroller.isFinished() == false) goto L50;
        r11 = false;
        goto L50
    L38:
        if (stopGlowAnimations(r12) == false) goto L40;
    L43:
        this.mIsBeingDragged = r11;
        recycleVelocityTracker();
        goto L52
    L40:
        if (this.mScroller.isFinished() == false) goto L43;
        r11 = false;
        goto L43
    L10:
        if (r13 == 1) goto L31;
        if (r13 != 2) goto L13;
        int r15 = this.mActivePointerId;
        if (r15 == (-1)) goto L52;
        int r16 = r12.findPointerIndex(r15);
        if (r16 != (-1)) goto L24;
        Log.e(TAG, "Invalid pointerId=" + r15 + " in onInterceptTouchEvent");
        goto L52
    L24:
        int r17 = (int) r12.getY(r16);
        if (Math.abs(r17 - this.mLastMotionY) <= this.mTouchSlop) goto L52;
        if ((2 & getNestedScrollAxes()) != 0) goto L52;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r17;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(r12);
        this.mNestedYOffset = 0;
        ViewParent r18 = getParent();
        if (r18 == null) goto L52;
        r18.requestDisallowInterceptTouchEvent(true);
        goto L52
    L13:
        if (r13 == 3) goto L31;
        if (r13 != 6) goto L52;
        onSecondaryPointerUp(r12);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        ViewCompat.postInvalidateOnAnimation(this);
    L34:
        stopNestedScroll(0);
        goto L52
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = 0;
        this.mIsLayoutDirty = false;
        View r16 = this.mChildToScrollTo;
        if (r16 != null) goto L5;
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
        View r17 = getChildAt(0);
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) r17.getLayoutParams();
        r15 = (r17.getMeasuredHeight() + r18.topMargin) + r18.bottomMargin;
    L15:
        int r19 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        int r20 = getScrollY();
        int r21 = clamp(r20, r19, r15);
        if (r21 == r20) goto L18;
        scrollTo(getScrollX(), r21);
        goto L18
    L5:
        if (isViewDescendantOf(r16, this) == false) goto L7;
        scrollToChild(this.mChildToScrollTo);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.mFillViewport == true) goto L6;
        return;
    L6:
        if (View.MeasureSpec.getMode(r11) != 0) goto L9;
        return;
    L9:
        if (getChildCount() <= 0) goto L14;
        View r12 = getChildAt(0);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        int r14 = r12.getMeasuredHeight();
        int r15 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - r13.topMargin) - r13.bottomMargin;
        if (r14 >= r15) goto L15;
        r12.measure(FrameLayout.getChildMeasureSpec(r10, ((getPaddingLeft() + getPaddingRight()) + r13.leftMargin) + r13.rightMargin, r13.width), View.MeasureSpec.makeMeasureSpec(r15, 1073741824));
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View r10, float r11, float r12, boolean r13) {
        if (r13 == true) goto L5;
        dispatchNestedFling(0.0f, r12, true);
        fling((int) r12);
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View r10, float r11, float r12) {
        return dispatchNestedPreFling(r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13) {
        onNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13, int r14) {
        dispatchNestedPreScroll(r11, r12, r13, null, r14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14) {
        onNestedScrollInternal(r14, 0, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, int r15) {
        onNestedScrollInternal(r14, r15, null);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, int r15, @NonNull int[] r16) {
        onNestedScrollInternal(r14, r15, r16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12) {
        onNestedScrollAccepted(r10, r11, r12, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        this.mParentHelper.onNestedScrollAccepted(r10, r11, r12, r13);
        startNestedScroll(2, r13);
    }

    @Override // android.view.View
    protected void onOverScrolled(int r10, int r11, boolean r12, boolean r13) {
        super.scrollTo(r10, r11);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int r10, Rect r11) {
        if (r10 != 2) goto L6;
        r10 = 130;
    L8:
        FocusFinder r12 = FocusFinder.getInstance();
        if (r11 != null) goto L11;
        View r13 = r12.findNextFocus(this, null, r10);
    L13:
        if (r13 != null) goto L16;
        return false;
    L16:
        if (isOffScreen(r13) == false) goto L19;
        return false;
    L19:
        return r13.requestFocus(r10, r11);
    L11:
        r13 = r12.findNextFocusFromRect(this, r11, r10);
        goto L13
    L6:
        if (r10 != 1) goto L8;
        r10 = 33;
        goto L8
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.mSavedState = r11;
        requestLayout();
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.scrollPosition = getScrollY();
        return r10;
    }

    @Override // android.view.View
    protected void onScrollChanged(int r10, int r11, int r12, int r13) {
        super.onScrollChanged(r10, r11, r12, r13);
        OnScrollChangeListener r14 = this.mOnScrollChangeListener;
        if (r14 == null) goto L6;
        r14.onScrollChange(this, r10, r11, r12, r13);
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        View r14 = findFocus();
        if (r14 == null) goto L10;
        if (this != r14) goto L7;
        return;
    L7:
        if (isWithinDeltaOfScreen(r14, 0, r13) == false) goto L11;
        r14.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r14, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        return;
    L11:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View r10, @NonNull View r11, int r12) {
        return onStartNestedScroll(r10, r11, r12, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        if ((r12 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View r10) {
        onStopNestedScroll(r10, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View r10, int r11) {
        this.mParentHelper.onStopNestedScroll(r10, r11);
        stopNestedScroll(r11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r13) {
        initVelocityTrackerIfNotExists();
        int r10 = r13.getActionMasked();
        if (r10 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r11 = MotionEvent.obtain(r13);
        r11.offsetLocation(0.0f, this.mNestedYOffset);
        if (r10 == 0) goto L55;
        if (r10 != 1) goto L9;
        VelocityTracker r14 = this.mVelocityTracker;
        r14.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r15 = (int) r14.getYVelocity(this.mActivePointerId);
        if (Math.abs(r15) < this.mMinimumVelocity) goto L52;
        if (edgeEffectFling(r15) == false) goto L48;
    L26:
        endTouchDrag();
    L66:
        VelocityTracker r12 = this.mVelocityTracker;
        if (r12 == null) goto L69;
        r12.addMovement(r11);
    L69:
        r11.recycle();
        return true;
    L48:
        int r16 = -r15;
        float r17 = r16;
        if (dispatchNestedPreFling(0.0f, r17) == true) goto L26;
        dispatchNestedFling(0.0f, r17, true);
        fling(r16);
        goto L26
    L52:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L26;
    L25:
        ViewCompat.postInvalidateOnAnimation(this);
        goto L26
    L9:
        if (r10 != 2) goto L11;
        int r18 = r13.findPointerIndex(this.mActivePointerId);
        if (r18 != (-1)) goto L30;
        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
        goto L66
    L30:
        int r19 = (int) r13.getY(r18);
        int r20 = this.mLastMotionY - r19;
        int r21 = r20 - releaseVerticalGlow(r20, r13.getX(r18));
        if (this.mIsBeingDragged == true) goto L42;
        if (Math.abs(r21) <= this.mTouchSlop) goto L42;
        ViewParent r22 = getParent();
        if (r22 == null) goto L37;
        r22.requestDisallowInterceptTouchEvent(true);
    L37:
        this.mIsBeingDragged = true;
        int r23 = this.mTouchSlop;
        if (r21 <= 0) goto L40;
        r21 = r21 - r23;
        goto L42
    L40:
        r21 = r21 + r23;
    L42:
        if (this.mIsBeingDragged == false) goto L66;
        int r110 = scrollBy(r21, (int) r13.getX(r18), 0, false);
        this.mLastMotionY = r19 - r110;
        this.mNestedYOffset += r110;
        goto L66
    L11:
        if (r10 == 3) goto L20;
        if (r10 != 5) goto L15;
        int r24 = r13.getActionIndex();
        this.mLastMotionY = (int) r13.getY(r24);
        this.mActivePointerId = r13.getPointerId(r24);
        goto L66
    L15:
        if (r10 != 6) goto L66;
        onSecondaryPointerUp(r13);
        this.mLastMotionY = (int) r13.getY(r13.findPointerIndex(this.mActivePointerId));
        goto L66
    L20:
        if (this.mIsBeingDragged == false) goto L26;
        if (getChildCount() <= 0) goto L26;
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L26;
    L55:
        if (getChildCount() != 0) goto L58;
        return false;
    L58:
        if (this.mIsBeingDragged == false) goto L63;
        ViewParent r25 = getParent();
        if (r25 == null) goto L63;
        r25.requestDisallowInterceptTouchEvent(true);
    L63:
        if (this.mScroller.isFinished() == true) goto L65;
        abortAnimatedScroll();
    L65:
        initializeTouchDrag((int) r13.getY(), r13.getPointerId(0));
        goto L66
    }

    boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        int r10 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r11 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r12 = true;
    L10:
        if (r10 == 0) goto L15;
        if (r10 != 1) goto L14;
        if (r11 == true) goto L15;
    L14:
        boolean r22 = false;
    L16:
        if (r10 == 0) goto L21;
        if (r10 != 1) goto L20;
        if (r12 == true) goto L21;
    L20:
        boolean r23 = false;
    L22:
        int r24 = r15 + r13;
        if (r22 == true) goto L25;
        int r25 = 0;
    L26:
        int r26 = r16 + r14;
        if (r23 == true) goto L29;
        int r27 = 0;
    L30:
        int r28 = -r25;
        int r29 = r25 + r17;
        int r30 = -r27;
        int r31 = r27 + r18;
        if (r24 <= r29) goto L33;
        r24 = r29;
        boolean r32 = true;
    L36:
        if (r26 <= r31) goto L38;
        r26 = r31;
        boolean r33 = true;
    L41:
        if (r33 == true) goto L43;
    L45:
        onOverScrolled(r24, r26, r32, r33);
        if (r32 == true) goto L49;
        if (r33 == true) goto L49;
        return false;
    L49:
        return true;
    L43:
        if (hasNestedScrollingParent(1) == true) goto L45;
        this.mScroller.springBack(r24, r26, 0, 0, 0, getScrollRange());
        goto L45
    L38:
        if (r26 >= r30) goto L40;
        r33 = true;
        r26 = r30;
        goto L41
    L40:
        r33 = false;
        goto L41
    L33:
        if (r24 >= r28) goto L35;
        r32 = true;
        r24 = r28;
        goto L36
    L35:
        r32 = false;
        goto L36
    L29:
        r27 = r20;
        goto L30
    L25:
        r25 = r19;
    L21:
        r23 = true;
    L15:
        r22 = true;
        goto L16
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    public boolean pageScroll(int r10) {
        if (r10 != 130) goto L5;
        boolean r11 = true;
    L6:
        int r12 = getHeight();
        if (r11 == false) goto L13;
        this.mTempRect.top = getScrollY() + r12;
        int r13 = getChildCount();
        if (r13 <= 0) goto L16;
        View r14 = getChildAt(r13 - 1);
        int r15 = (r14.getBottom() + ((FrameLayout.LayoutParams) r14.getLayoutParams()).bottomMargin) + getPaddingBottom();
        Rect r16 = this.mTempRect;
        if ((r16.top + r12) <= r15) goto L16;
        r16.top = r15 - r12;
    L16:
        Rect r17 = this.mTempRect;
        int r18 = r17.top;
        int r19 = r12 + r18;
        r17.bottom = r19;
        return scrollAndFocus(r10, r18, r19);
    L13:
        this.mTempRect.top = getScrollY() - r12;
        Rect r20 = this.mTempRect;
        if (r20.top >= 0) goto L16;
        r20.top = 0;
        goto L16
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r10, View r11) {
        if (this.mIsLayoutDirty == true) goto L5;
        scrollToChild(r11);
    L6:
        super.requestChildFocus(r10, r11);
        return;
    L5:
        this.mChildToScrollTo = r11;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View r10, Rect r11, boolean r12) {
        r11.offset(r10.getLeft() - r10.getScrollX(), r10.getTop() - r10.getScrollY());
        return scrollToChildRect(r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        if (r10 == false) goto L4;
        recycleVelocityTracker();
    L4:
        super.requestDisallowInterceptTouchEvent(r10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        if (getChildCount() <= 0) goto L10;
        View r12 = getChildAt(0);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        int r14 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r15 = (r12.getWidth() + r13.leftMargin) + r13.rightMargin;
        int r16 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r17 = (r12.getHeight() + r13.topMargin) + r13.bottomMargin;
        int r18 = clamp(r10, r14, r15);
        int r19 = clamp(r11, r16, r17);
        if (r18 == getScrollX()) goto L7;
    L8:
        super.scrollTo(r18, r19);
        return;
    L7:
        if (r19 != getScrollY()) goto L8;
        return;
    }

    public void setFillViewport(boolean r10) {
        if (r10 == this.mFillViewport) goto L6;
        this.mFillViewport = r10;
        requestLayout();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r10) {
        this.mChildHelper.setNestedScrollingEnabled(r10);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener r10) {
        this.mOnScrollChangeListener = r10;
    }

    public void setSmoothScrollingEnabled(boolean r10) {
        this.mSmoothScrollingEnabled = r10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int r10, int r11) {
        smoothScrollBy(r10, r11, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollBy(int r10, int r11, int r12) {
        smoothScrollBy(r10, r11, r12, false);
    }

    public final void smoothScrollTo(int r10, int r11) {
        smoothScrollTo(r10, r11, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollTo(int r10, int r11, int r12) {
        smoothScrollTo(r10, r11, r12, false);
    }

    void smoothScrollTo(int r10, int r11, int r12, boolean r13) {
        smoothScrollBy(r10 - getScrollX(), r11 - getScrollY(), r12, r13);
    }

    void smoothScrollTo(int r10, int r11, boolean r12) {
        smoothScrollTo(r10, r11, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r10) {
        return startNestedScroll(r10, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r10, int r11) {
        return this.mChildHelper.startNestedScroll(r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r10) {
        this.mChildHelper.stopNestedScroll(r10);
    }
}
