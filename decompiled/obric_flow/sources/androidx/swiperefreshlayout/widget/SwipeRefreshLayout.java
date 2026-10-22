package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;

    @VisibleForTesting
    static final int CIRCLE_DIAMETER = 40;

    @VisibleForTesting
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = null;
    private static final String LOG_TAG = "SwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    CircleImageView mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    CircularProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout r5, @Nullable View r10);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.enabled};
    }

    public SwipeRefreshLayout(@NonNull Context r5) {
        this(r5, null);
    }

    private void animateOffsetToCorrectPosition(int r5, Animation.AnimationListener r10) {
        this.mFrom = r5;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r10 == null) goto L5;
        this.mCircleView.setAnimationListener(r10);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int r5, Animation.AnimationListener r10) {
        if (this.mScale == false) goto L5;
        startScaleDownReturnToStartAnimation(r5, r10);
        return;
    L5:
        this.mFrom = r5;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r10 == null) goto L8;
        this.mCircleView.setAnimationListener(r10);
    L8:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT);
        CircularProgressDrawable r5 = new CircularProgressDrawable(getContext());
        this.mProgress = r5;
        r5.setStyle(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget != null) goto L11;
        int r5 = 0;
    L6:
        if (r5 >= getChildCount()) goto L15;
        View r10 = getChildAt(r5);
        if (r10.equals(this.mCircleView) == false) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        this.mTarget = r10;
        return;
    L15:
        return;
    }

    private void finishSpinner(float r5) {
        if (r5 <= this.mTotalDragDistance) goto L5;
        setRefreshing(true, true);
        return;
    L5:
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        if (this.mScale == true) goto L8;
        Animation.AnimationListener r10 = new AnonymousClass5(this);
    L9:
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r10);
        this.mProgress.setArrowEnabled(false);
        return;
    L8:
        r10 = null;
        goto L9
    }

    private boolean isAnimationRunning(Animation r5) {
        if (r5 != null) goto L4;
    L8:
        return false;
    L4:
        if (r5.hasStarted() == false) goto L8;
        if (r5.hasEnded() == true) goto L8;
        return true;
    }

    private void moveSpinner(float r12) {
        this.mProgress.setArrowEnabled(true);
        float r5 = Math.min(1.0f, Math.abs(r12 / this.mTotalDragDistance));
        float r10 = (((float) Math.max(((double) r5) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float r11 = Math.abs(r12) - this.mTotalDragDistance;
        int r13 = this.mCustomSlingshotDistance;
        if (r13 <= 0) goto L6;
    L4:
        float r14 = r13;
        double r15 = Math.max(0.0f, Math.min(r11, r14 * DECELERATE_INTERPOLATION_FACTOR) / r14) / 4.0f;
        float r16 = ((float) (r15 - Math.pow(r15, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int r17 = this.mOriginalOffsetTop + ((int) ((r14 * r5) + ((r14 * r16) * DECELERATE_INTERPOLATION_FACTOR)));
        if (this.mCircleView.getVisibility() == 0) goto L13;
        this.mCircleView.setVisibility(0);
    L13:
        if (this.mScale == true) goto L16;
        this.mCircleView.setScaleX(1.0f);
        this.mCircleView.setScaleY(1.0f);
    L16:
        if (this.mScale == false) goto L19;
        setAnimationProgress(Math.min(1.0f, r12 / this.mTotalDragDistance));
    L19:
        if (r12 >= this.mTotalDragDistance) goto L26;
        if (this.mProgress.getAlpha() > 76) goto L23;
    L30:
        this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, r10 * MAX_PROGRESS_ANGLE));
        this.mProgress.setArrowScale(Math.min(1.0f, r10));
        float r18 = r16 * DECELERATE_INTERPOLATION_FACTOR;
        this.mProgress.setProgressRotation((r18 + ((r10 * 0.4f) - 0.25f)) * 0.5f);
        setTargetOffsetTopAndBottom(r17 - this.mCurrentTargetOffsetTop);
        return;
    L23:
        if (isAnimationRunning(this.mAlphaStartAnimation) == true) goto L30;
        startProgressAlphaStartAnimation();
        goto L30
    L26:
        if (this.mProgress.getAlpha() >= 255) goto L30;
        if (isAnimationRunning(this.mAlphaMaxAnimation) == true) goto L30;
        startProgressAlphaMaxAnimation();
        goto L30
    L6:
        if (this.mUsingCustomStart == false) goto L8;
        r13 = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
        goto L4
    L8:
        r13 = this.mSpinnerOffsetEnd;
        goto L4
    }

    private void onSecondaryPointerUp(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        if (r5.getPointerId(r10) != this.mActivePointerId) goto L9;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.mActivePointerId = r5.getPointerId(r11);
        return;
    L6:
        r11 = 0;
        goto L7
    }

    private void setColorViewAlpha(int r5) {
        this.mCircleView.getBackground().setAlpha(r5);
        this.mProgress.setAlpha(r5);
    }

    private Animation startAlphaAnimation(final int r5, final int r10) {
        Animation r11 = new AnonymousClass4(this, r5, r10);
        r11.setDuration(300);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(r11);
        return r11;
    }

    private void startDragging(float r5) {
        float r10 = this.mInitialDownY;
        float r11 = r5 - r10;
        int r12 = this.mTouchSlop;
        if (r11 > r12) goto L5;
        return;
    L5:
        if (this.mIsBeingDragged == true) goto L9;
        this.mInitialMotionY = r10 + r12;
        this.mIsBeingDragged = true;
        this.mProgress.setAlpha(76);
        return;
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startScaleDownReturnToStartAnimation(int r5, Animation.AnimationListener r10) {
        this.mFrom = r5;
        this.mStartingScale = this.mCircleView.getScaleX();
        Animation r11 = new AnonymousClass8(this);
        this.mScaleDownToStartAnimation = r11;
        r11.setDuration(150);
        if (r10 == null) goto L5;
        this.mCircleView.setAnimationListener(r10);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener r5) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        Animation r10 = new AnonymousClass2(this);
        this.mScaleAnimation = r10;
        r10.setDuration(this.mMediumAnimationDuration);
        if (r5 == null) goto L5;
        this.mCircleView.setAnimationListener(r5);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback r5 = this.mChildScrollUpCallback;
        if (r5 != null) goto L5;
        View r10 = this.mTarget;
        if ((r10 instanceof ListView) == false) goto L11;
        return ListViewCompat.canScrollList((ListView) r10, -1);
    L11:
        return r10.canScrollVertically(-1);
    L5:
        return r5.canChildScrollUp(this, this.mTarget);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(r5, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r5, float r10) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(r5, r10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r5, int r10, int[] r11, int[] r12) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(r5, r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r5, int r10) {
        int r11 = this.mCircleViewIndex;
        if (r11 >= 0) goto L6;
        return r10;
    L6:
        if (r10 != (r5 - 1)) goto L8;
        return r11;
    L8:
        if (r10 >= r11) goto L10;
        return r10;
    L10:
        return r10 + 1;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void moveToStart(float r5) {
        int r10 = this.mFrom;
        setTargetOffsetTopAndBottom((r10 + ((int) ((this.mOriginalOffsetTop - r10) * r5))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        ensureTarget();
        int r10 = r5.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r10 != 0) goto L7;
        this.mReturningToStart = false;
    L7:
        if (isEnabled() == true) goto L9;
    L43:
        return false;
    L9:
        if (this.mReturningToStart == true) goto L43;
        if (canChildScrollUp() == true) goto L43;
        if (this.mRefreshing == true) goto L43;
        if (this.mNestedScrollInProgress == true) goto L43;
        if (r10 != 0) goto L19;
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
        int r11 = r5.getPointerId(0);
        this.mActivePointerId = r11;
        this.mIsBeingDragged = false;
        int r12 = r5.findPointerIndex(r11);
        if (r12 >= 0) goto L40;
        return false;
    L40:
        this.mInitialDownY = r5.getY(r12);
    L42:
        return this.mIsBeingDragged;
    L19:
        if (r10 != 1) goto L21;
    L36:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        goto L42
    L21:
        if (r10 != 2) goto L23;
        int r13 = this.mActivePointerId;
        if (r13 != (-1)) goto L32;
        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
    L32:
        int r14 = r5.findPointerIndex(r13);
        if (r14 >= 0) goto L35;
        return false;
    L35:
        startDragging(r5.getY(r14));
        goto L42
    L23:
        if (r10 == 3) goto L36;
        if (r10 != 6) goto L42;
        onSecondaryPointerUp(r5);
        goto L42
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = getMeasuredWidth();
        int r15 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.mTarget != null) goto L8;
        ensureTarget();
    L8:
        View r16 = this.mTarget;
        if (r16 != null) goto L11;
        return;
    L11:
        int r17 = getPaddingLeft();
        int r18 = getPaddingTop();
        int r19 = (r14 - getPaddingLeft()) - getPaddingRight();
        r16.layout(r17, r18, r19 + r17, ((r15 - getPaddingTop()) - getPaddingBottom()) + r18);
        int r20 = this.mCircleView.getMeasuredWidth();
        int r21 = this.mCircleView.getMeasuredHeight();
        int r22 = r14 / 2;
        int r23 = r20 / 2;
        int r24 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(r22 - r23, r24, r22 + r23, r21 + r24);
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if (this.mTarget != null) goto L5;
        ensureTarget();
    L5:
        View r11 = this.mTarget;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), BasicMeasure.EXACTLY));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, BasicMeasure.EXACTLY));
        this.mCircleViewIndex = -1;
        int r12 = 0;
    L10:
        if (r12 >= getChildCount()) goto L18;
        if (getChildAt(r12) == this.mCircleView) goto L13;
        r12 = r12 + 1;
        goto L10
    L13:
        this.mCircleViewIndex = r12;
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        return dispatchNestedFling(r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r5, float r10, float r11) {
        return dispatchNestedPreFling(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r5, int r10, int r11, int[] r12) {
        if (r11 <= 0) goto L12;
        float r13 = this.mTotalUnconsumed;
        if (r13 <= 0.0f) goto L12;
        float r14 = r11;
        if (r14 <= r13) goto L9;
        r12[1] = r11 - ((int) r13);
        this.mTotalUnconsumed = 0.0f;
    L10:
        moveSpinner(this.mTotalUnconsumed);
        goto L12
    L9:
        this.mTotalUnconsumed = r13 - r14;
        r12[1] = r11;
    L12:
        if (this.mUsingCustomStart == false) goto L19;
        if (r11 <= 0) goto L19;
        if (this.mTotalUnconsumed != 0.0f) goto L19;
        if (Math.abs(r11 - r12[1]) <= 0) goto L19;
        this.mCircleView.setVisibility(8);
    L19:
        int[] r15 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(r10 - r12[0], r11 - r12[1], r15, null) == false) goto L23;
        r12[0] = r12[0] + r15[0];
        r12[1] = r12[1] + r15[1];
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        dispatchNestedScroll(r11, r12, r13, r14, this.mParentOffsetInWindow);
        int r15 = r14 + this.mParentOffsetInWindow[1];
        if (r15 < 0) goto L5;
        return;
    L5:
        if (canChildScrollUp() == true) goto L9;
        float r16 = this.mTotalUnconsumed + Math.abs(r15);
        this.mTotalUnconsumed = r16;
        moveSpinner(r16);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r5, View r10, int r11) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(r5, r10, r11);
        startNestedScroll(r11 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r5, View r10, int r11) {
        if (isEnabled() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mReturningToStart == true) goto L11;
        if (this.mRefreshing == true) goto L11;
        if ((r11 & 2) == 0) goto L11;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r5) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(r5);
        this.mNestedScrollInProgress = false;
        float r10 = this.mTotalUnconsumed;
        if (r10 <= 0.0f) goto L5;
        finishSpinner(r10);
        this.mTotalUnconsumed = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r5 = r10.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r5 != 0) goto L7;
        this.mReturningToStart = false;
    L7:
        if (isEnabled() == true) goto L9;
    L58:
        return false;
    L9:
        if (this.mReturningToStart == true) goto L58;
        if (canChildScrollUp() == true) goto L58;
        if (this.mRefreshing == true) goto L58;
        if (this.mNestedScrollInProgress == true) goto L58;
        if (r5 != 0) goto L20;
        this.mActivePointerId = r10.getPointerId(0);
        this.mIsBeingDragged = false;
    L57:
        return true;
    L20:
        if (r5 != 1) goto L22;
        int r11 = r10.findPointerIndex(this.mActivePointerId);
        if (r11 >= 0) goto L52;
        Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
        return false;
    L52:
        if (this.mIsBeingDragged == false) goto L54;
        float r12 = (r10.getY(r11) - this.mInitialMotionY) * 0.5f;
        this.mIsBeingDragged = false;
        finishSpinner(r12);
    L54:
        this.mActivePointerId = -1;
        return false;
    L22:
        if (r5 != 2) goto L24;
        int r13 = r10.findPointerIndex(this.mActivePointerId);
        if (r13 >= 0) goto L41;
        Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
    L41:
        float r14 = r10.getY(r13);
        startDragging(r14);
        if (this.mIsBeingDragged == false) goto L57;
        float r15 = (r14 - this.mInitialMotionY) * 0.5f;
        if (r15 <= 0.0f) goto L46;
        moveSpinner(r15);
        goto L57
    L46:
        return false;
    L24:
        if (r5 != 3) goto L26;
        return false;
    L26:
        if (r5 != 5) goto L28;
        int r16 = r10.getActionIndex();
        if (r16 >= 0) goto L35;
        Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
        return false;
    L35:
        this.mActivePointerId = r10.getPointerId(r16);
        goto L57
    L28:
        if (r5 != 6) goto L57;
        onSecondaryPointerUp(r10);
        goto L57
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r5) {
        View r10 = this.mTarget;
        if (r10 != null) goto L5;
    L7:
        super.requestDisallowInterceptTouchEvent(r5);
        return;
    L5:
        if (ViewCompat.isNestedScrollingEnabled(r10) == true) goto L7;
    }

    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale == false) goto L5;
        setAnimationProgress(0.0f);
    L6:
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        return;
    L5:
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        goto L6
    }

    public void setAnimationProgress(float r5) {
        this.mCircleView.setScaleX(r5);
        this.mCircleView.setScaleY(r5);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... r5) {
        setColorSchemeResources(r5);
    }

    public void setColorSchemeColors(@ColorInt int... r5) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(r5);
    }

    public void setColorSchemeResources(@ColorRes int... r5) {
        Context r10 = getContext();
        int[] r11 = new int[r5.length];
        int r12 = 0;
    L4:
        if (r12 >= r5.length) goto L6;
        r11[r12] = ContextCompat.getColor(r10, r5[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        setColorSchemeColors(r11);
    }

    public void setDistanceToTriggerSync(int r5) {
        this.mTotalDragDistance = r5;
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        if (r5 == true) goto L6;
        reset();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(r5);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback r5) {
        this.mChildScrollUpCallback = r5;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener r5) {
        this.mListener = r5;
    }

    @Deprecated
    public void setProgressBackgroundColor(int r5) {
        setProgressBackgroundColorSchemeResource(r5);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int r5) {
        this.mCircleView.setBackgroundColor(r5);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int r5) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r5));
    }

    public void setProgressViewEndTarget(boolean r5, int r10) {
        this.mSpinnerOffsetEnd = r10;
        this.mScale = r5;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean r5, int r10, int r11) {
        this.mScale = r5;
        this.mOriginalOffsetTop = r10;
        this.mSpinnerOffsetEnd = r11;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean r5) {
        if (r5 == true) goto L5;
    L11:
        setRefreshing(r5, false);
        return;
    L5:
        if (this.mRefreshing == r5) goto L11;
        this.mRefreshing = r5;
        if (this.mUsingCustomStart == true) goto L9;
        int r10 = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
    L10:
        setTargetOffsetTopAndBottom(r10 - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
        return;
    L9:
        r10 = this.mSpinnerOffsetEnd;
        goto L10
    }

    public void setSize(int r5) {
        if (r5 != 0) goto L4;
    L6:
        DisplayMetrics r10 = getResources().getDisplayMetrics();
        if (r5 != 0) goto L9;
        this.mCircleDiameter = (int) (r10.density * 56.0f);
    L10:
        this.mCircleView.setImageDrawable(null);
        this.mProgress.setStyle(r5);
        this.mCircleView.setImageDrawable(this.mProgress);
        return;
    L9:
        this.mCircleDiameter = (int) (r10.density * 40.0f);
        goto L10
    L4:
        if (r5 == 1) goto L6;
    }

    public void setSlingshotDistance(@Px int r5) {
        this.mCustomSlingshotDistance = r5;
    }

    public void setTargetOffsetTopAndBottom(int r5) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, r5);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r5) {
        return this.mNestedScrollingChildHelper.startNestedScroll(r5);
    }

    public void startScaleDownAnimation(Animation.AnimationListener r5) {
        Animation r10 = new AnonymousClass3(this);
        this.mScaleDownAnimation = r10;
        r10.setDuration(150);
        this.mCircleView.setAnimationListener(r5);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    public SwipeRefreshLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new AnonymousClass1(this);
        this.mAnimateToCorrectPosition = new AnonymousClass6(this);
        this.mAnimateToStartPosition = new AnonymousClass7(this);
        this.mTouchSlop = ViewConfiguration.get(r5).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        DisplayMetrics r11 = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (r11.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        int r12 = (int) (r11.density * 64.0f);
        this.mSpinnerOffsetEnd = r12;
        this.mTotalDragDistance = r12;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r13 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = r13;
        this.mOriginalOffsetTop = r13;
        moveToStart(1.0f);
        TypedArray r14 = r5.obtainStyledAttributes(r10, LAYOUT_ATTRS);
        setEnabled(r14.getBoolean(0, true));
        r14.recycle();
    }

    private void setRefreshing(boolean r5, boolean r10) {
        if (this.mRefreshing == r5) goto L9;
        this.mNotify = r10;
        ensureTarget();
        this.mRefreshing = r5;
        if (r5 == false) goto L7;
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        return;
    L7:
        startScaleDownAnimation(this.mRefreshListener);
        return;
    }
}
