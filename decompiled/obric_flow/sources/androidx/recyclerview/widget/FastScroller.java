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

    public class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        final /* synthetic */ FastScroller this$0;

        public AnimatorListener(FastScroller r5) {
            this.this$0 = r5;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            if (this.mCanceled == false) goto L7;
            this.mCanceled = false;
            return;
        L7:
            if (((Float) this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue() != 0.0f) goto L9;
            FastScroller r10 = this.this$0;
            r10.mAnimationState = 0;
            r10.setState(0);
            return;
        L9:
            FastScroller r11 = this.this$0;
            r11.mAnimationState = 2;
            r11.requestRedraw();
        }
    }

    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FastScroller this$0;

        public AnimatorUpdater(FastScroller r5) {
            this.this$0 = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r5) {
            int r10 = (int) (((Float) r5.getAnimatedValue()).floatValue() * 255.0f);
            this.this$0.mVerticalThumbDrawable.setAlpha(r10);
            this.this$0.mVerticalTrackDrawable.setAlpha(r10);
            this.this$0.requestRedraw();
        }
    }

    static {
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        EMPTY_STATE_SET = new int[0];
    }

    public FastScroller(RecyclerView r5, StateListDrawable r10, Drawable r11, StateListDrawable r12, Drawable r13, int r14, int r15, int r16) {
        this.mRecyclerViewWidth = 0;
        this.mRecyclerViewHeight = 0;
        this.mNeedVerticalScrollbar = false;
        this.mNeedHorizontalScrollbar = false;
        this.mState = 0;
        this.mDragState = 0;
        this.mVerticalRange = new int[2];
        this.mHorizontalRange = new int[2];
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mShowHideAnimator = r17;
        this.mAnimationState = 0;
        this.mHideRunnable = new AnonymousClass1(this);
        this.mOnScrollListener = new AnonymousClass2(this);
        this.mVerticalThumbDrawable = r10;
        this.mVerticalTrackDrawable = r11;
        this.mHorizontalThumbDrawable = r12;
        this.mHorizontalTrackDrawable = r13;
        this.mVerticalThumbWidth = Math.max(r14, r10.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(r14, r11.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(r14, r12.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(r14, r13.getIntrinsicWidth());
        this.mScrollbarMinimumRange = r15;
        this.mMargin = r16;
        r10.setAlpha(255);
        r11.setAlpha(255);
        r17.addListener(new AnimatorListener(this));
        r17.addUpdateListener(new AnimatorUpdater(this));
        attachToRecyclerView(r5);
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
        int r5 = this.mRecyclerViewHeight;
        int r11 = this.mHorizontalThumbHeight;
        int r12 = r5 - r11;
        int r13 = this.mHorizontalThumbCenterX;
        int r14 = this.mHorizontalThumbWidth;
        int r15 = r13 - (r14 / 2);
        this.mHorizontalThumbDrawable.setBounds(0, 0, r14, r11);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        r10.translate(0.0f, r12);
        this.mHorizontalTrackDrawable.draw(r10);
        r10.translate(r15, 0.0f);
        this.mHorizontalThumbDrawable.draw(r10);
        r10.translate(-r15, -r12);
    }

    private void drawVerticalScrollbar(Canvas r10) {
        int r5 = this.mRecyclerViewWidth;
        int r11 = this.mVerticalThumbWidth;
        int r12 = r5 - r11;
        int r13 = this.mVerticalThumbCenterY;
        int r14 = this.mVerticalThumbHeight;
        int r15 = r13 - (r14 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, r11, r14);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (isLayoutRTL() == false) goto L5;
        this.mVerticalTrackDrawable.draw(r10);
        r10.translate(this.mVerticalThumbWidth, r15);
        r10.scale(-1.0f, 1.0f);
        this.mVerticalThumbDrawable.draw(r10);
        r10.scale(-1.0f, 1.0f);
        r10.translate(-this.mVerticalThumbWidth, -r15);
        return;
    L5:
        r10.translate(r12, 0.0f);
        this.mVerticalTrackDrawable.draw(r10);
        r10.translate(0.0f, r15);
        this.mVerticalThumbDrawable.draw(r10);
        r10.translate(-r12, -r15);
    }

    private int[] getHorizontalRange() {
        int[] r5 = this.mHorizontalRange;
        int r10 = this.mMargin;
        r5[0] = r10;
        r5[1] = this.mRecyclerViewWidth - r10;
        return r5;
    }

    private int[] getVerticalRange() {
        int[] r5 = this.mVerticalRange;
        int r10 = this.mMargin;
        r5[0] = r10;
        r5[1] = this.mRecyclerViewHeight - r10;
        return r5;
    }

    private void horizontalScrollTo(float r10) {
        int[] r5 = getHorizontalRange();
        float r11 = Math.max(r5[0], Math.min(r5[1], r10));
        if (Math.abs(this.mHorizontalThumbCenterX - r11) >= 2.0f) goto L5;
        return;
    L5:
        int r12 = scrollTo(this.mHorizontalDragX, r11, r5, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
        if (r12 == 0) goto L8;
        this.mRecyclerView.scrollBy(r12, 0);
    L8:
        this.mHorizontalDragX = r11;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this.mRecyclerView) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void resetHideDelay(int r5) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, r5);
    }

    private int scrollTo(float r5, float r10, int[] r11, int r12, int r13, int r14) {
        int r15 = r11[1] - r11[0];
        if (r15 != 0) goto L5;
        return 0;
    L5:
        int r16 = r12 - r14;
        int r17 = (int) (((r10 - r5) / r15) * r16);
        int r18 = r13 + r17;
        if (r18 >= r16) goto L9;
        if (r18 < 0) goto L9;
        return r17;
    L9:
        return 0;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void verticalScrollTo(float r10) {
        int[] r5 = getVerticalRange();
        float r11 = Math.max(r5[0], Math.min(r5[1], r10));
        if (Math.abs(this.mVerticalThumbCenterY - r11) >= 2.0f) goto L5;
        return;
    L5:
        int r12 = scrollTo(this.mVerticalDragY, r11, r5, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
        if (r12 == 0) goto L8;
        this.mRecyclerView.scrollBy(0, r12);
    L8:
        this.mVerticalDragY = r11;
    }

    public void attachToRecyclerView(@Nullable RecyclerView r5) {
        RecyclerView r10 = this.mRecyclerView;
        if (r10 != r5) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r5;
        if (r5 == null) goto L11;
        setupCallbacks();
        return;
    }

    @VisibleForTesting
    public Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    @VisibleForTesting
    public Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    @VisibleForTesting
    public Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    @VisibleForTesting
    public Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    @VisibleForTesting
    public void hide(int r10) {
        int r5 = this.mAnimationState;
        if (r5 == 1) goto L6;
        if (r5 != 2) goto L9;
    L7:
        this.mAnimationState = 3;
        ValueAnimator r11 = this.mShowHideAnimator;
        r11.setFloatValues(new float[]{((Float) r11.getAnimatedValue()).floatValue(), 0.0f});
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
    public boolean isPointInsideHorizontalThumb(float r5, float r10) {
        if (r10 < (this.mRecyclerViewHeight - this.mHorizontalThumbHeight)) goto L9;
        int r11 = this.mHorizontalThumbCenterX;
        int r12 = this.mHorizontalThumbWidth;
        if (r5 < (r11 - (r12 / 2))) goto L9;
        if (r5 > ((r12 / 2) + r11)) goto L9;
        return true;
    L9:
        return false;
    }

    @VisibleForTesting
    public boolean isPointInsideVerticalThumb(float r5, float r10) {
        if (isLayoutRTL() == false) goto L8;
        if (r5 <= this.mVerticalThumbWidth) goto L9;
    L14:
        return false;
    L9:
        int r11 = this.mVerticalThumbCenterY;
        int r12 = this.mVerticalThumbHeight;
        if (r10 < (r11 - (r12 / 2))) goto L14;
        if (r10 > ((r12 / 2) + r11)) goto L14;
        return true;
    L8:
        if (r5 < (this.mRecyclerViewWidth - this.mVerticalThumbWidth)) goto L14;
        goto L9
    }

    @VisibleForTesting
    public boolean isVisible() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r5, RecyclerView r10, RecyclerView.State r11) {
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
        drawVerticalScrollbar(r5);
    L13:
        if (this.mNeedHorizontalScrollbar == false) goto L19;
        drawHorizontalScrollbar(r5);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11) {
        int r12 = this.mState;
        if (r12 != 1) goto L13;
        boolean r13 = isPointInsideVerticalThumb(r11.getX(), r11.getY());
        boolean r5 = isPointInsideHorizontalThumb(r11.getX(), r11.getY());
        if (r11.getAction() != 0) goto L16;
        if (r13 == true) goto L8;
        if (r5 == true) goto L8;
        return false;
    L8:
        if (r5 == false) goto L10;
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
    public void onRequestDisallowInterceptTouchEvent(boolean r5) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@NonNull RecyclerView r5, @NonNull MotionEvent r10) {
        if (this.mState != 0) goto L6;
        return;
    L6:
        if (r10.getAction() != 0) goto L16;
        boolean r11 = isPointInsideVerticalThumb(r10.getX(), r10.getY());
        boolean r12 = isPointInsideHorizontalThumb(r10.getX(), r10.getY());
        if (r11 == true) goto L10;
        if (r12 == true) goto L10;
        return;
    L10:
        if (r12 == false) goto L12;
        this.mDragState = 1;
        this.mHorizontalDragX = (int) r10.getX();
    L14:
        setState(2);
        return;
    L12:
        if (r11 == false) goto L14;
        this.mDragState = 2;
        this.mVerticalDragY = (int) r10.getY();
        goto L14
    L16:
        if (r10.getAction() != 1) goto L21;
        if (this.mState != 2) goto L21;
        this.mVerticalDragY = 0.0f;
        this.mHorizontalDragX = 0.0f;
        setState(1);
        this.mDragState = 0;
        return;
    L21:
        if (r10.getAction() == 2) goto L23;
        return;
    L23:
        if (this.mState != 2) goto L35;
        show();
        if (this.mDragState != 1) goto L28;
        horizontalScrollTo(r10.getX());
    L28:
        if (this.mDragState != 2) goto L36;
        verticalScrollTo(r10.getY());
        return;
    L36:
        return;
    }

    public void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    public void setState(int r5) {
        if (r5 == 2) goto L5;
    L7:
        if (r5 != 0) goto L9;
        requestRedraw();
    L11:
        if (this.mState != 2) goto L15;
        if (r5 == 2) goto L15;
        this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
        resetHideDelay(HIDE_DELAY_AFTER_DRAGGING_MS);
    L17:
        this.mState = r5;
        return;
    L15:
        if (r5 != 1) goto L17;
        resetHideDelay(HIDE_DELAY_AFTER_VISIBLE_MS);
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
        int r5 = this.mAnimationState;
        if (r5 != 0) goto L5;
    L8:
        this.mAnimationState = 1;
        ValueAnimator r10 = this.mShowHideAnimator;
        r10.setFloatValues(new float[]{((Float) r10.getAnimatedValue()).floatValue(), 1.0f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
        return;
    L5:
        if (r5 != 3) goto L10;
        this.mShowHideAnimator.cancel();
        goto L8
    }

    public void updateScrollPosition(int r10, int r11) {
        int r5 = this.mRecyclerView.computeVerticalScrollRange();
        int r12 = this.mRecyclerViewHeight;
        if ((r5 - r12) > 0) goto L5;
    L7:
        boolean r13 = false;
    L8:
        this.mNeedVerticalScrollbar = r13;
        int r14 = this.mRecyclerView.computeHorizontalScrollRange();
        int r15 = this.mRecyclerViewWidth;
        if ((r14 - r15) > 0) goto L11;
    L13:
        boolean r16 = false;
    L14:
        this.mNeedHorizontalScrollbar = r16;
        boolean r17 = this.mNeedVerticalScrollbar;
        if (r17 == true) goto L22;
        if (r16 == true) goto L22;
        if (this.mState == 0) goto L32;
        setState(0);
        return;
    L32:
        return;
    L22:
        if (r17 == false) goto L25;
        float r18 = r12;
        this.mVerticalThumbCenterY = (int) ((((r18 / 2.0f) + r11) * r18) / r5);
        this.mVerticalThumbHeight = Math.min(r12, (r12 * r12) / r5);
    L25:
        if (this.mNeedHorizontalScrollbar == false) goto L27;
        float r19 = r15;
        this.mHorizontalThumbCenterX = (int) ((((r19 / 2.0f) + r10) * r19) / r14);
        this.mHorizontalThumbWidth = Math.min(r15, (r15 * r15) / r14);
    L27:
        int r20 = this.mState;
        if (r20 == 0) goto L30;
        if (r20 == 1) goto L30;
        return;
    L30:
        setState(1);
        return;
    L11:
        if (r15 < this.mScrollbarMinimumRange) goto L13;
        r16 = true;
        goto L14
    L5:
        if (r12 < this.mScrollbarMinimumRange) goto L7;
        r13 = true;
        goto L8
    }
}
