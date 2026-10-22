package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
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
    private static final String LOG_TAG = null;
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
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout r10, @Nullable View r11);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    static {
        LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
        LAYOUT_ATTRS = new int[]{R.attr.enabled};
    }

    public SwipeRefreshLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public SwipeRefreshLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new AnonymousClass1(this);
        this.mAnimateToCorrectPosition = new AnonymousClass6(this);
        this.mAnimateToStartPosition = new AnonymousClass7(this);
        this.mTouchSlop = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        DisplayMetrics r12 = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (r12.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        int r13 = (int) (r12.density * 64.0f);
        this.mSpinnerOffsetEnd = r13;
        this.mTotalDragDistance = r13;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r14 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = r14;
        this.mOriginalOffsetTop = r14;
        moveToStart(1.0f);
        TypedArray r15 = r10.obtainStyledAttributes(r11, LAYOUT_ATTRS);
        setEnabled(r15.getBoolean(0, true));
        r15.recycle();
    }

    private void animateOffsetToCorrectPosition(int r10, Animation.AnimationListener r11) {
        this.mFrom = r10;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r11 == null) goto L5;
        this.mCircleView.setAnimationListener(r11);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int r10, Animation.AnimationListener r11) {
        if (this.mScale == false) goto L5;
        startScaleDownReturnToStartAnimation(r10, r11);
        return;
    L5:
        this.mFrom = r10;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r11 == null) goto L8;
        this.mCircleView.setAnimationListener(r11);
    L8:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT);
        CircularProgressDrawable r10 = new CircularProgressDrawable(getContext());
        this.mProgress = r10;
        r10.setStyle(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget != null) goto L11;
        int r10 = 0;
    L6:
        if (r10 >= getChildCount()) goto L15;
        View r11 = getChildAt(r10);
        if (r11.equals(this.mCircleView) == false) goto L9;
        r10 = r10 + 1;
        goto L6
    L9:
        this.mTarget = r11;
        return;
    L15:
        return;
    }

    private void finishSpinner(float r10) {
        if (r10 <= this.mTotalDragDistance) goto L5;
        setRefreshing(true, true);
        return;
    L5:
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        Animation.AnimationListener r11 = null;
        if (this.mScale == true) goto L8;
        r11 = new AnonymousClass5(this);
    L8:
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r11);
        this.mProgress.setArrowEnabled(false);
    }

    private boolean isAnimationRunning(Animation r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.hasStarted() == false) goto L8;
        if (r10.hasEnded() == true) goto L8;
        return true;
    }

    private void moveSpinner(float r12) {
        this.mProgress.setArrowEnabled(true);
        float r10 = Math.min(1.0f, Math.abs(r12 / this.mTotalDragDistance));
        float r11 = (((float) Math.max(((double) r10) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float r13 = Math.abs(r12) - this.mTotalDragDistance;
        int r14 = this.mCustomSlingshotDistance;
        if (r14 <= 0) goto L6;
    L4:
        float r15 = r14;
        double r16 = Math.max(0.0f, Math.min(r13, r15 * DECELERATE_INTERPOLATION_FACTOR) / r15) / 4.0f;
        float r17 = ((float) (r16 - Math.pow(r16, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int r18 = this.mOriginalOffsetTop + ((int) ((r15 * r10) + ((r15 * r17) * DECELERATE_INTERPOLATION_FACTOR)));
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
        this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, r11 * MAX_PROGRESS_ANGLE));
        this.mProgress.setArrowScale(Math.min(1.0f, r11));
        this.mProgress.setProgressRotation((((r11 * 0.4f) - 0.25f) + (r17 * DECELERATE_INTERPOLATION_FACTOR)) * 0.5f);
        setTargetOffsetTopAndBottom(r18 - this.mCurrentTargetOffsetTop);
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
        r14 = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
        goto L4
    L8:
        r14 = this.mSpinnerOffsetEnd;
        goto L4
    }

    private void onSecondaryPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.mActivePointerId) goto L9;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.mActivePointerId = r10.getPointerId(r12);
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private void setColorViewAlpha(int r10) {
        this.mCircleView.getBackground().setAlpha(r10);
        this.mProgress.setAlpha(r10);
    }

    private void setRefreshing(boolean r10, boolean r11) {
        if (this.mRefreshing == r10) goto L9;
        this.mNotify = r11;
        ensureTarget();
        this.mRefreshing = r10;
        if (r10 == false) goto L7;
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        return;
    L7:
        startScaleDownAnimation(this.mRefreshListener);
        return;
    }

    private Animation startAlphaAnimation(final int r10, final int r11) {
        Animation r12 = new AnonymousClass4(this, r10, r11);
        r12.setDuration(300);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(r12);
        return r12;
    }

    private void startDragging(float r10) {
        float r11 = this.mInitialDownY;
        float r12 = r10 - r11;
        int r13 = this.mTouchSlop;
        if (r12 > r13) goto L5;
        return;
    L5:
        if (this.mIsBeingDragged == true) goto L9;
        this.mInitialMotionY = r11 + r13;
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

    private void startScaleDownReturnToStartAnimation(int r10, Animation.AnimationListener r11) {
        this.mFrom = r10;
        this.mStartingScale = this.mCircleView.getScaleX();
        Animation r12 = new AnonymousClass8(this);
        this.mScaleDownToStartAnimation = r12;
        r12.setDuration(150);
        if (r11 == null) goto L5;
        this.mCircleView.setAnimationListener(r11);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener r10) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        Animation r11 = new AnonymousClass2(this);
        this.mScaleAnimation = r11;
        r11.setDuration(this.mMediumAnimationDuration);
        if (r10 == null) goto L5;
        this.mCircleView.setAnimationListener(r10);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback r10 = this.mChildScrollUpCallback;
        if (r10 != null) goto L5;
        View r11 = this.mTarget;
        if ((r11 instanceof ListView) == false) goto L11;
        return ListViewCompat.canScrollList((ListView) r11, -1);
    L11:
        return r11.canScrollVertically(-1);
    L5:
        return r10.canChildScrollUp(this, this.mTarget);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r10, float r11, boolean r12) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r10, float r11) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(r10, r11, r12, r13);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int r10, int r11) {
        int r12 = this.mCircleViewIndex;
        if (r12 >= 0) goto L6;
        return r11;
    L6:
        if (r11 != (r10 - 1)) goto L8;
        return r12;
    L8:
        if (r11 >= r12) goto L10;
        return r11;
    L10:
        return r11 + 1;
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

    void moveToStart(float r10) {
        int r11 = this.mFrom;
        setTargetOffsetTopAndBottom((r11 + ((int) ((this.mOriginalOffsetTop - r11) * r10))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        ensureTarget();
        int r11 = r10.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r11 != 0) goto L7;
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
        if (r11 != 0) goto L19;
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
        int r12 = r10.getPointerId(0);
        this.mActivePointerId = r12;
        this.mIsBeingDragged = false;
        int r13 = r10.findPointerIndex(r12);
        if (r13 >= 0) goto L40;
        return false;
    L40:
        this.mInitialDownY = r10.getY(r13);
    L42:
        return this.mIsBeingDragged;
    L19:
        if (r11 != 1) goto L21;
    L36:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        goto L42
    L21:
        if (r11 != 2) goto L23;
        int r14 = this.mActivePointerId;
        if (r14 != (-1)) goto L32;
        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
    L32:
        int r15 = r10.findPointerIndex(r14);
        if (r15 >= 0) goto L35;
        return false;
    L35:
        startDragging(r10.getY(r15));
        goto L42
    L23:
        if (r11 == 3) goto L36;
        if (r11 != 6) goto L42;
        onSecondaryPointerUp(r10);
        goto L42
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getMeasuredWidth();
        int r16 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.mTarget != null) goto L8;
        ensureTarget();
    L8:
        View r17 = this.mTarget;
        if (r17 != null) goto L11;
        return;
    L11:
        int r18 = getPaddingLeft();
        int r19 = getPaddingTop();
        int r20 = (r15 - getPaddingLeft()) - getPaddingRight();
        r17.layout(r18, r19, r20 + r18, ((r16 - getPaddingTop()) - getPaddingBottom()) + r19);
        int r21 = this.mCircleView.getMeasuredWidth();
        int r22 = this.mCircleView.getMeasuredHeight();
        int r23 = r15 / 2;
        int r24 = r21 / 2;
        int r25 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(r23 - r24, r25, r23 + r24, r22 + r25);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.mTarget != null) goto L5;
        ensureTarget();
    L5:
        View r12 = this.mTarget;
        if (r12 != null) goto L8;
        return;
    L8:
        r12.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
        this.mCircleViewIndex = -1;
        int r13 = 0;
    L10:
        if (r13 >= getChildCount()) goto L18;
        if (getChildAt(r13) == this.mCircleView) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        this.mCircleViewIndex = r13;
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r10, float r11, float r12, boolean r13) {
        return dispatchNestedFling(r11, r12, r13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r10, float r11, float r12) {
        return dispatchNestedPreFling(r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        if (r12 <= 0) goto L12;
        float r14 = this.mTotalUnconsumed;
        if (r14 <= 0.0f) goto L12;
        float r15 = r12;
        if (r15 <= r14) goto L9;
        r13[1] = r12 - ((int) r14);
        this.mTotalUnconsumed = 0.0f;
    L10:
        moveSpinner(this.mTotalUnconsumed);
        goto L12
    L9:
        this.mTotalUnconsumed = r14 - r15;
        r13[1] = r12;
    L12:
        if (this.mUsingCustomStart == false) goto L19;
        if (r12 <= 0) goto L19;
        if (this.mTotalUnconsumed != 0.0f) goto L19;
        if (Math.abs(r12 - r13[1]) <= 0) goto L19;
        this.mCircleView.setVisibility(8);
    L19:
        int[] r16 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(r11 - r13[0], r12 - r13[1], r16, null) == false) goto L23;
        r13[0] = r13[0] + r16[0];
        r13[1] = r13[1] + r16[1];
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
    public void onNestedScrollAccepted(View r10, View r11, int r12) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(r10, r11, r12);
        startNestedScroll(r12 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r10, View r11, int r12) {
        if (isEnabled() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mReturningToStart == true) goto L11;
        if (this.mRefreshing == true) goto L11;
        if ((r12 & 2) == 0) goto L11;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r10) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(r10);
        this.mNestedScrollInProgress = false;
        float r11 = this.mTotalUnconsumed;
        if (r11 <= 0.0f) goto L5;
        finishSpinner(r11);
        this.mTotalUnconsumed = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r11 != 0) goto L7;
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
        if (r11 != 0) goto L20;
        this.mActivePointerId = r10.getPointerId(0);
        this.mIsBeingDragged = false;
    L57:
        return true;
    L20:
        if (r11 != 1) goto L22;
        int r12 = r10.findPointerIndex(this.mActivePointerId);
        if (r12 >= 0) goto L52;
        Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
        return false;
    L52:
        if (this.mIsBeingDragged == false) goto L54;
        float r13 = (r10.getY(r12) - this.mInitialMotionY) * 0.5f;
        this.mIsBeingDragged = false;
        finishSpinner(r13);
    L54:
        this.mActivePointerId = -1;
        return false;
    L22:
        if (r11 != 2) goto L24;
        int r14 = r10.findPointerIndex(this.mActivePointerId);
        if (r14 >= 0) goto L41;
        Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
    L41:
        float r15 = r10.getY(r14);
        startDragging(r15);
        if (this.mIsBeingDragged == false) goto L57;
        float r16 = (r15 - this.mInitialMotionY) * 0.5f;
        if (r16 <= 0.0f) goto L46;
        moveSpinner(r16);
        goto L57
    L46:
        return false;
    L24:
        if (r11 != 3) goto L26;
        return false;
    L26:
        if (r11 != 5) goto L28;
        int r17 = r10.getActionIndex();
        if (r17 >= 0) goto L35;
        Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
        return false;
    L35:
        this.mActivePointerId = r10.getPointerId(r17);
        goto L57
    L28:
        if (r11 != 6) goto L57;
        onSecondaryPointerUp(r10);
        goto L57
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L6:
        View r11 = this.mTarget;
        if (r11 != null) goto L9;
    L11:
        super.requestDisallowInterceptTouchEvent(r10);
        return;
    L9:
        if (ViewCompat.isNestedScrollingEnabled(r11) == true) goto L11;
        return;
    L5:
        if ((this.mTarget instanceof AbsListView) == false) goto L6;
    }

    void reset() {
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

    void setAnimationProgress(float r10) {
        this.mCircleView.setScaleX(r10);
        this.mCircleView.setScaleY(r10);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... r10) {
        setColorSchemeResources(r10);
    }

    public void setColorSchemeColors(@ColorInt int... r10) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(r10);
    }

    public void setColorSchemeResources(@ColorRes int... r10) {
        Context r11 = getContext();
        int[] r12 = new int[r10.length];
        int r13 = 0;
    L4:
        if (r13 >= r10.length) goto L6;
        r12[r13] = ContextCompat.getColor(r11, r10[r13]);
        r13 = r13 + 1;
        goto L4
    L6:
        setColorSchemeColors(r12);
    }

    public void setDistanceToTriggerSync(int r10) {
        this.mTotalDragDistance = r10;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == true) goto L6;
        reset();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r10) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(r10);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback r10) {
        this.mChildScrollUpCallback = r10;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener r10) {
        this.mListener = r10;
    }

    @Deprecated
    public void setProgressBackgroundColor(int r10) {
        setProgressBackgroundColorSchemeResource(r10);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int r10) {
        this.mCircleView.setBackgroundColor(r10);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int r10) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r10));
    }

    public void setProgressViewEndTarget(boolean r10, int r11) {
        this.mSpinnerOffsetEnd = r11;
        this.mScale = r10;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean r10, int r11, int r12) {
        this.mScale = r10;
        this.mOriginalOffsetTop = r11;
        this.mSpinnerOffsetEnd = r12;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean r10) {
        if (r10 == true) goto L5;
    L11:
        setRefreshing(r10, false);
        return;
    L5:
        if (this.mRefreshing == r10) goto L11;
        this.mRefreshing = r10;
        if (this.mUsingCustomStart == true) goto L9;
        int r11 = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
    L10:
        setTargetOffsetTopAndBottom(r11 - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
        return;
    L9:
        r11 = this.mSpinnerOffsetEnd;
        goto L10
    }

    public void setSize(int r10) {
        if (r10 != 0) goto L4;
    L6:
        DisplayMetrics r11 = getResources().getDisplayMetrics();
        if (r10 != 0) goto L9;
        float r12 = 56.0f;
    L10:
        this.mCircleDiameter = (int) (r11.density * r12);
        this.mCircleView.setImageDrawable(null);
        this.mProgress.setStyle(r10);
        this.mCircleView.setImageDrawable(this.mProgress);
        return;
    L9:
        r12 = 40.0f;
        goto L10
    L4:
        if (r10 == 1) goto L6;
    }

    public void setSlingshotDistance(@Px int r10) {
        this.mCustomSlingshotDistance = r10;
    }

    void setTargetOffsetTopAndBottom(int r10) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, r10);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r10) {
        return this.mNestedScrollingChildHelper.startNestedScroll(r10);
    }

    void startScaleDownAnimation(Animation.AnimationListener r10) {
        Animation r11 = new AnonymousClass3(this);
        this.mScaleDownAnimation = r11;
        r11.setDuration(150);
        this.mCircleView.setAnimationListener(r10);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }
}
