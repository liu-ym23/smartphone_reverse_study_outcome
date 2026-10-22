package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int[] EMPTY_STATE_SET = null;
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    int mAnimationState;
    private int mDragState;
    private final Runnable mHideRunnable;

    @VisibleForTesting
    float mHorizontalDragX;
    private final int[] mHorizontalRange;

    @VisibleForTesting
    int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;

    @VisibleForTesting
    int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private boolean mNeedHorizontalScrollbar;
    private boolean mNeedVerticalScrollbar;
    private final RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private int mRecyclerViewHeight;
    private int mRecyclerViewWidth;
    private final int mScrollbarMinimumRange;
    final ValueAnimator mShowHideAnimator;
    private int mState;

    @VisibleForTesting
    float mVerticalDragY;
    private final int[] mVerticalRange;

    @VisibleForTesting
    int mVerticalThumbCenterY;
    final StateListDrawable mVerticalThumbDrawable;

    @VisibleForTesting
    int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;

    private class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        final /* synthetic */ FastScroller this$0;

        AnimatorListener(FastScroller r10) {
            this.this$0 = r10;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.mCanceled == false) goto L6;
            this.mCanceled = false;
            return;
        L6:
            float r11 = ((Float) this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue();
            FastScroller r12 = this.this$0;
            if (r11 != 0.0f) goto L9;
            r12.mAnimationState = 0;
            r12.setState(0);
            return;
        L9:
            r12.mAnimationState = 2;
            r12.requestRedraw();
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FastScroller this$0;

        AnimatorUpdater(FastScroller r10) {
            this.this$0 = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            int r11 = (int) (((Float) r10.getAnimatedValue()).floatValue() * 255.0f);
            this.this$0.mVerticalThumbDrawable.setAlpha(r11);
            this.this$0.mVerticalTrackDrawable.setAlpha(r11);
            this.this$0.requestRedraw();
        }
    }

    static {
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        EMPTY_STATE_SET = new int[0];
    }

    FastScroller(RecyclerView r10, StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14, int r15, int r16, int r17) {
        this.mRecyclerViewWidth = 0;
        this.mRecyclerViewHeight = 0;
        this.mNeedVerticalScrollbar = false;
        this.mNeedHorizontalScrollbar = false;
        this.mState = 0;
        this.mDragState = 0;
        this.mVerticalRange = new int[2];
        this.mHorizontalRange = new int[2];
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mShowHideAnimator = r18;
        this.mAnimationState = 0;
        this.mHideRunnable = new AnonymousClass1(this);
        this.mOnScrollListener = new AnonymousClass2(this);
        this.mVerticalThumbDrawable = r11;
        this.mVerticalTrackDrawable = r12;
        this.mHorizontalThumbDrawable = r13;
        this.mHorizontalTrackDrawable = r14;
        this.mVerticalThumbWidth = Math.max(r15, r11.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(r15, r12.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(r15, r13.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(r15, r14.getIntrinsicWidth());
        this.mScrollbarMinimumRange = r16;
        this.mMargin = r17;
        r11.setAlpha(255);
        r12.setAlpha(255);
        r18.addListener(new AnimatorListener(this));
        r18.addUpdateListener(new AnimatorUpdater(this));
        attachToRecyclerView(r10);
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        cancelHide();
    }

    private void drawHorizontalScrollbar(Canvas r10) {
        int r11 = this.mRecyclerViewHeight;
        int r12 = this.mHorizontalThumbHeight;
        int r13 = r11 - r12;
        int r14 = this.mHorizontalThumbCenterX;
        int r15 = this.mHorizontalThumbWidth;
        int r16 = r14 - (r15 / 2);
        this.mHorizontalThumbDrawable.setBounds(0, 0, r15, r12);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        r10.translate(0.0f, r13);
        this.mHorizontalTrackDrawable.draw(r10);
        r10.translate(r16, 0.0f);
        this.mHorizontalThumbDrawable.draw(r10);
        r10.translate(-r16, -r13);
    }

    private void drawVerticalScrollbar(Canvas r10) {
        int r11 = this.mRecyclerViewWidth;
        int r12 = this.mVerticalThumbWidth;
        int r13 = r11 - r12;
        int r14 = this.mVerticalThumbCenterY;
        int r15 = this.mVerticalThumbHeight;
        int r16 = r14 - (r15 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, r12, r15);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (isLayoutRTL() == false) goto L5;
        this.mVerticalTrackDrawable.draw(r10);
        r10.translate(this.mVerticalThumbWidth, r16);
        r10.scale(-1.0f, 1.0f);
        this.mVerticalThumbDrawable.draw(r10);
        r10.scale(1.0f, 1.0f);
        int r17 = -this.mVerticalThumbWidth;
    L6:
        r10.translate(r17, -r16);
        return;
    L5:
        r10.translate(r13, 0.0f);
        this.mVerticalTrackDrawable.draw(r10);
        r10.translate(0.0f, r16);
        this.mVerticalThumbDrawable.draw(r10);
        r17 = -r13;
        goto L6
    }

    private int[] getHorizontalRange() {
        int[] r10 = this.mHorizontalRange;
        int r11 = this.mMargin;
        r10[0] = r11;
        r10[1] = this.mRecyclerViewWidth - r11;
        return r10;
    }

    private int[] getVerticalRange() {
        int[] r10 = this.mVerticalRange;
        int r11 = this.mMargin;
        r10[0] = r11;
        r10[1] = this.mRecyclerViewHeight - r11;
        return r10;
    }

    private void horizontalScrollTo(float r10) {
        int[] r11 = getHorizontalRange();
        float r12 = Math.max(r11[0], Math.min(r11[1], r10));
        if (Math.abs(this.mHorizontalThumbCenterX - r12) >= 2.0f) goto L5;
        return;
    L5:
        int r13 = scrollTo(this.mHorizontalDragX, r12, r11, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
        if (r13 == 0) goto L8;
        this.mRecyclerView.scrollBy(r13, 0);
    L8:
        this.mHorizontalDragX = r12;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this.mRecyclerView) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void resetHideDelay(int r10) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, r10);
    }

    private int scrollTo(float r10, float r11, int[] r12, int r13, int r14, int r15) {
        int r16 = r12[1] - r12[0];
        if (r16 != 0) goto L5;
        return 0;
    L5:
        int r17 = r13 - r15;
        int r18 = (int) (((r11 - r10) / r16) * r17);
        int r19 = r14 + r18;
        if (r19 >= r17) goto L9;
        if (r19 < 0) goto L9;
        return r18;
    L9:
        return 0;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void verticalScrollTo(float r10) {
        int[] r11 = getVerticalRange();
        float r12 = Math.max(r11[0], Math.min(r11[1], r10));
        if (Math.abs(this.mVerticalThumbCenterY - r12) >= 2.0f) goto L5;
        return;
    L5:
        int r13 = scrollTo(this.mVerticalDragY, r12, r11, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
        if (r13 == 0) goto L8;
        this.mRecyclerView.scrollBy(0, r13);
    L8:
        this.mVerticalDragY = r12;
    }

    public void attachToRecyclerView(@Nullable RecyclerView r10) {
        RecyclerView r11 = this.mRecyclerView;
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r10;
        if (r10 == null) goto L11;
        setupCallbacks();
        return;
    }

    @VisibleForTesting
    Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    @VisibleForTesting
    Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    @VisibleForTesting
    Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    @VisibleForTesting
    Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    @VisibleForTesting
    void hide(int r10) {
        int r11 = this.mAnimationState;
        if (r11 == 1) goto L6;
        if (r11 != 2) goto L9;
    L7:
        this.mAnimationState = 3;
        ValueAnimator r12 = this.mShowHideAnimator;
        r12.setFloatValues(new float[]{((Float) r12.getAnimatedValue()).floatValue(), 0.0f});
        this.mShowHideAnimator.setDuration(r10);
        this.mShowHideAnimator.start();
        return;
    L9:
        return;
    L6:
        this.mShowHideAnimator.cancel();
        goto L7
    }

    public boolean isDragging() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    boolean isPointInsideHorizontalThumb(float r10, float r11) {
        if (r11 < (this.mRecyclerViewHeight - this.mHorizontalThumbHeight)) goto L9;
        int r12 = this.mHorizontalThumbCenterX;
        int r13 = this.mHorizontalThumbWidth;
        if (r10 < (r12 - (r13 / 2))) goto L9;
        if (r10 > (r12 + (r13 / 2))) goto L9;
        return true;
    L9:
        return false;
    }

    @VisibleForTesting
    boolean isPointInsideVerticalThumb(float r10, float r11) {
        if (isLayoutRTL() == false) goto L8;
        if (r10 <= (this.mVerticalThumbWidth / 2)) goto L9;
    L14:
        return false;
    L9:
        int r12 = this.mVerticalThumbCenterY;
        int r13 = this.mVerticalThumbHeight;
        if (r11 < (r12 - (r13 / 2))) goto L14;
        if (r11 > (r12 + (r13 / 2))) goto L14;
        return true;
    L8:
        if (r10 < (this.mRecyclerViewWidth - this.mVerticalThumbWidth)) goto L14;
        goto L9
    }

    @VisibleForTesting
    boolean isVisible() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        if (this.mRecyclerViewWidth == this.mRecyclerView.getWidth()) goto L5;
    L16:
        this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
        setState(0);
        return;
    L5:
        if (this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) goto L16;
        if (this.mAnimationState != 0) goto L10;
        return;
    L10:
        if (this.mNeedVerticalScrollbar == false) goto L13;
        drawVerticalScrollbar(r10);
    L13:
        if (this.mNeedHorizontalScrollbar == false) goto L19;
        drawHorizontalScrollbar(r10);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11) {
        int r12 = this.mState;
        if (r12 != 1) goto L13;
        boolean r13 = isPointInsideVerticalThumb(r11.getX(), r11.getY());
        boolean r14 = isPointInsideHorizontalThumb(r11.getX(), r11.getY());
        if (r11.getAction() != 0) goto L16;
        if (r13 == true) goto L8;
        if (r14 == true) goto L8;
        return false;
    L8:
        if (r14 == false) goto L10;
        this.mDragState = 1;
        this.mHorizontalDragX = (int) r11.getX();
    L12:
        setState(2);
    L15:
        return true;
    L10:
        if (r13 == false) goto L12;
        this.mDragState = 2;
        this.mVerticalDragY = (int) r11.getY();
        goto L12
    L16:
        return false;
    L13:
        if (r12 == 2) goto L15;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11) {
        if (this.mState != 0) goto L6;
        return;
    L6:
        if (r11.getAction() != 0) goto L16;
        boolean r12 = isPointInsideVerticalThumb(r11.getX(), r11.getY());
        boolean r13 = isPointInsideHorizontalThumb(r11.getX(), r11.getY());
        if (r12 == true) goto L10;
        if (r13 == true) goto L10;
        return;
    L10:
        if (r13 == false) goto L12;
        this.mDragState = 1;
        this.mHorizontalDragX = (int) r11.getX();
    L14:
        setState(2);
        return;
    L12:
        if (r12 == false) goto L14;
        this.mDragState = 2;
        this.mVerticalDragY = (int) r11.getY();
        goto L14
    L16:
        if (r11.getAction() != 1) goto L21;
        if (this.mState != 2) goto L21;
        this.mVerticalDragY = 0.0f;
        this.mHorizontalDragX = 0.0f;
        setState(1);
        this.mDragState = 0;
        return;
    L21:
        if (r11.getAction() == 2) goto L23;
        return;
    L23:
        if (this.mState != 2) goto L35;
        show();
        if (this.mDragState != 1) goto L28;
        horizontalScrollTo(r11.getX());
    L28:
        if (this.mDragState != 2) goto L36;
        verticalScrollTo(r11.getY());
        return;
    L36:
        return;
    }

    void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    void setState(int r10) {
        if (r10 == 2) goto L5;
    L7:
        if (r10 != 0) goto L9;
        requestRedraw();
    L11:
        if (this.mState != 2) goto L15;
        if (r10 == 2) goto L15;
        this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
        int r11 = HIDE_DELAY_AFTER_DRAGGING_MS;
    L17:
        resetHideDelay(r11);
    L18:
        this.mState = r10;
        return;
    L15:
        if (r10 != 1) goto L18;
        r11 = HIDE_DELAY_AFTER_VISIBLE_MS;
        goto L17
    L9:
        show();
        goto L11
    L5:
        if (this.mState == 2) goto L7;
        this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
        cancelHide();
        goto L7
    }

    public void show() {
        int r10 = this.mAnimationState;
        if (r10 != 0) goto L5;
    L8:
        this.mAnimationState = 1;
        ValueAnimator r11 = this.mShowHideAnimator;
        r11.setFloatValues(new float[]{((Float) r11.getAnimatedValue()).floatValue(), 1.0f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
        return;
    L5:
        if (r10 != 3) goto L10;
        this.mShowHideAnimator.cancel();
        goto L8
    }

    void updateScrollPosition(int r10, int r11) {
        int r12 = this.mRecyclerView.computeVerticalScrollRange();
        int r13 = this.mRecyclerViewHeight;
        if ((r12 - r13) > 0) goto L5;
    L7:
        boolean r14 = false;
    L8:
        this.mNeedVerticalScrollbar = r14;
        int r15 = this.mRecyclerView.computeHorizontalScrollRange();
        int r16 = this.mRecyclerViewWidth;
        if ((r15 - r16) > 0) goto L11;
    L13:
        boolean r17 = false;
    L14:
        this.mNeedHorizontalScrollbar = r17;
        boolean r18 = this.mNeedVerticalScrollbar;
        if (r18 == true) goto L22;
        if (r17 == true) goto L22;
        if (this.mState == 0) goto L32;
        setState(0);
        return;
    L32:
        return;
    L22:
        if (r18 == false) goto L25;
        float r19 = r13;
        this.mVerticalThumbCenterY = (int) ((r19 * (r11 + (r19 / 2.0f))) / r12);
        this.mVerticalThumbHeight = Math.min(r13, (r13 * r13) / r12);
    L25:
        if (this.mNeedHorizontalScrollbar == false) goto L27;
        float r110 = r16;
        this.mHorizontalThumbCenterX = (int) ((r110 * (r10 + (r110 / 2.0f))) / r15);
        this.mHorizontalThumbWidth = Math.min(r16, (r16 * r16) / r15);
    L27:
        int r20 = this.mState;
        if (r20 == 0) goto L30;
        if (r20 == 1) goto L30;
        return;
    L30:
        setState(1);
        return;
    L11:
        if (r16 < this.mScrollbarMinimumRange) goto L13;
        r17 = true;
        goto L14
    L5:
        if (r13 < this.mScrollbarMinimumRange) goto L7;
        r14 = true;
        goto L8
    }
}
