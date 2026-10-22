package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    private int mActionState;
    int mActivePointerId;

    @NonNull
    Callback mCallback;
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener;
    View mOverdrawChild;
    int mOverdrawChildPosition;
    final List<View> mPendingCleanup;
    List<RecoverAnimation> mRecoverAnimations;
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable;
    RecyclerView.ViewHolder mSelected;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    private float mSwipeEscapeVelocity;
    private final float[] mTmpPosition;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = null;
        private static final Interpolator sDragViewScrollCapInterpolator = null;
        private int mCachedMaxScrollSpeed;

        static {
            sDragScrollInterpolator = new AnonymousClass1();
            sDragViewScrollCapInterpolator = new AnonymousClass2();
        }

        public Callback() {
            this.mCachedMaxScrollSpeed = -1;
        }

        public static int convertToRelativeDirection(int r10, int r11) {
            int r12 = r10 & ABS_HORIZONTAL_DIR_FLAGS;
            if (r12 != 0) goto L5;
            return r10;
        L5:
            int r13 = r10 & (~r12);
            if (r11 != 0) goto L10;
            int r14 = r12 << 2;
        L9:
            return r13 | r14;
        L10:
            int r15 = r12 << 1;
            r13 = r13 | ((-789517) & r15);
            r14 = (r15 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            goto L9
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView r10) {
            if (this.mCachedMaxScrollSpeed != (-1)) goto L6;
            this.mCachedMaxScrollSpeed = r10.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
        L6:
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int r10, int r11) {
            return r11 << (r10 * 8);
        }

        public static int makeMovementFlags(int r10, int r11) {
            int r12 = makeFlag(0, r11 | r10);
            int r13 = makeFlag(1, r11) | r12;
            return makeFlag(2, r10) | r13;
        }

        public boolean canDropOver(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11, @NonNull RecyclerView.ViewHolder r12) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder r12, @NonNull List<RecyclerView.ViewHolder> r13, int r14, int r15) {
            int r11 = r12.itemView.getWidth() + r14;
            int r10 = r12.itemView.getHeight() + r15;
            int r16 = r14 - r12.itemView.getLeft();
            int r17 = r15 - r12.itemView.getTop();
            int r18 = r13.size();
            RecyclerView.ViewHolder r19 = null;
            int r20 = -1;
            int r21 = 0;
        L3:
            if (r21 >= r18) goto L38;
            RecyclerView.ViewHolder r22 = r13.get(r21);
            if (r16 <= 0) goto L13;
            int r23 = r22.itemView.getRight() - r11;
            if (r23 >= 0) goto L13;
            if (r22.itemView.getRight() <= r12.itemView.getRight()) goto L13;
            int r24 = Math.abs(r23);
            if (r24 <= r20) goto L13;
            r19 = r22;
            r20 = r24;
        L13:
            if (r16 >= 0) goto L21;
            int r25 = r22.itemView.getLeft() - r14;
            if (r25 <= 0) goto L21;
            if (r22.itemView.getLeft() >= r12.itemView.getLeft()) goto L21;
            int r26 = Math.abs(r25);
            if (r26 <= r20) goto L21;
            r19 = r22;
            r20 = r26;
        L21:
            if (r17 >= 0) goto L29;
            int r27 = r22.itemView.getTop() - r15;
            if (r27 <= 0) goto L29;
            if (r22.itemView.getTop() >= r12.itemView.getTop()) goto L29;
            int r28 = Math.abs(r27);
            if (r28 <= r20) goto L29;
            r19 = r22;
            r20 = r28;
        L29:
            if (r17 <= 0) goto L37;
            int r29 = r22.itemView.getBottom() - r10;
            if (r29 >= 0) goto L37;
            if (r22.itemView.getBottom() <= r12.itemView.getBottom()) goto L37;
            int r30 = Math.abs(r29);
            if (r30 <= r20) goto L37;
            r19 = r22;
            r20 = r30;
        L37:
            r21 = r21 + 1;
            goto L3
        L38:
            return r19;
        }

        public void clearView(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(r11.itemView);
        }

        public int convertToAbsoluteDirection(int r10, int r11) {
            int r12 = r10 & RELATIVE_DIR_FLAGS;
            if (r12 != 0) goto L5;
            return r10;
        L5:
            int r13 = r10 & (~r12);
            if (r11 != 0) goto L10;
            int r14 = r12 >> 2;
        L9:
            return r14 | r13;
        L10:
            int r15 = r12 >> 1;
            r13 = r13 | ((-3158065) & r15);
            r14 = (RELATIVE_DIR_FLAGS & r15) >> 2;
            goto L9
        }

        final int getAbsoluteMovementFlags(RecyclerView r10, RecyclerView.ViewHolder r11) {
            return convertToAbsoluteDirection(getMovementFlags(r10, r11), ViewCompat.getLayoutDirection(r10));
        }

        public long getAnimationDuration(@NonNull RecyclerView r10, int r11, float r12, float r13) {
            RecyclerView.ItemAnimator r14 = r10.getItemAnimator();
            if (r14 != null) goto L8;
            if (r11 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r11 != 8) goto L11;
            return r14.getMoveDuration();
        L11:
            return r14.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder r10) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11);

        public float getSwipeEscapeVelocity(float r10) {
            return r10;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder r10) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float r10) {
            return r10;
        }

        boolean hasDragFlag(RecyclerView r10, RecyclerView.ViewHolder r11) {
            if ((getAbsoluteMovementFlags(r10, r11) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasSwipeFlag(RecyclerView r10, RecyclerView.ViewHolder r11) {
            if ((getAbsoluteMovementFlags(r10, r11) & 65280) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView r10, int r11, int r12, int r13, long r14) {
            int r15 = getMaxDragScroll(r10);
            int r16 = Math.abs(r12);
            float r17 = 1.0f;
            int r18 = (int) ((((int) Math.signum(r12)) * r15) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (r16 * 1.0f) / r11)));
            if (r14 > DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) goto L6;
            r17 = r14 / 2000.0f;
        L6:
            int r19 = (int) (r18 * sDragScrollInterpolator.getInterpolation(r17));
            if (r19 != 0) goto L12;
            if (r12 <= 0) goto L10;
            return 1;
        L10:
            return -1;
        L12:
            return r19;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull RecyclerView.ViewHolder r12, float r13, float r14, int r15, boolean r16) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(r10, r11, r12.itemView, r13, r14, r15, r16);
        }

        public void onChildDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11, RecyclerView.ViewHolder r12, float r13, float r14, int r15, boolean r16) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(r10, r11, r12.itemView, r13, r14, r15, r16);
        }

        void onDraw(Canvas r14, RecyclerView r15, RecyclerView.ViewHolder r16, List<RecoverAnimation> r17, int r18, float r19, float r20) {
            int r10 = r17.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            RecoverAnimation r12 = r17.get(r11);
            r12.update();
            int r13 = r14.save();
            onChildDraw(r14, r15, r12.mViewHolder, r12.mX, r12.mY, r12.mActionState, false);
            r14.restoreToCount(r13);
            r11 = r11 + 1;
            goto L3
        L5:
            if (r16 == null) goto L9;
            int r21 = r14.save();
            onChildDraw(r14, r15, r16, r19, r20, r18, true);
            r14.restoreToCount(r21);
            return;
        }

        void onDrawOver(Canvas r15, RecyclerView r16, RecyclerView.ViewHolder r17, List<RecoverAnimation> r18, int r19, float r20, float r21) {
            int r10 = r18.size();
            boolean r11 = false;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            RecoverAnimation r13 = r18.get(r12);
            int r14 = r15.save();
            onChildDrawOver(r15, r16, r13.mViewHolder, r13.mX, r13.mY, r13.mActionState, false);
            r15.restoreToCount(r14);
            r12 = r12 + 1;
            goto L3
        L5:
            if (r17 == null) goto L7;
            int r110 = r15.save();
            onChildDrawOver(r15, r16, r17, r20, r21, r19, true);
            r15.restoreToCount(r110);
        L7:
            int r111 = r10 - 1;
        L8:
            if (r111 < 0) goto L17;
            RecoverAnimation r22 = r18.get(r111);
            boolean r23 = r22.mEnded;
            if (r23 == true) goto L12;
        L14:
            if (r23 == true) goto L16;
            r11 = true;
        L16:
            r111 = r111 - 1;
            goto L8
        L12:
            if (r22.mIsPendingCleanup == true) goto L14;
            r18.remove(r111);
            goto L16
        L17:
            if (r11 == false) goto L25;
            r16.invalidate();
            return;
        }

        public abstract boolean onMove(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11, @NonNull RecyclerView.ViewHolder r12);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11, int r12, @NonNull RecyclerView.ViewHolder r13, int r14, int r15, int r16) {
            RecyclerView.LayoutManager r17 = r10.getLayoutManager();
            if ((r17 instanceof ViewDropHandler) == false) goto L7;
            ((ViewDropHandler) r17).prepareForDrop(r11.itemView, r13.itemView, r15, r16);
            return;
        L7:
            if (r17.canScrollHorizontally() == false) goto L15;
            if (r17.getDecoratedLeft(r13.itemView) > r10.getPaddingLeft()) goto L12;
            r10.scrollToPosition(r14);
        L12:
            if (r17.getDecoratedRight(r13.itemView) < (r10.getWidth() - r10.getPaddingRight())) goto L15;
            r10.scrollToPosition(r14);
        L15:
            if (r17.canScrollVertically() == true) goto L17;
            return;
        L17:
            if (r17.getDecoratedTop(r13.itemView) > r10.getPaddingTop()) goto L20;
            r10.scrollToPosition(r14);
        L20:
            if (r17.getDecoratedBottom(r13.itemView) < (r10.getHeight() - r10.getPaddingBottom())) goto L24;
            r10.scrollToPosition(r14);
            return;
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder r10, int r11) {
            if (r10 == null) goto L5;
            ItemTouchUIUtilImpl.INSTANCE.onSelected(r10.itemView);
            return;
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder r10, int r11);
    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress;
        final /* synthetic */ ItemTouchHelper this$0;

        ItemTouchHelperGestureListener(ItemTouchHelper r10) {
            this.this$0 = r10;
            this.mShouldReactToLongPress = true;
        }

        void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r10) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r10) {
            if (this.mShouldReactToLongPress == true) goto L5;
            return;
        L5:
            View r11 = this.this$0.findChildView(r10);
            if (r11 == null) goto L18;
            RecyclerView.ViewHolder r12 = this.this$0.mRecyclerView.getChildViewHolder(r11);
            if (r12 == null) goto L19;
            ItemTouchHelper r13 = this.this$0;
            if (r13.mCallback.hasDragFlag(r13.mRecyclerView, r12) == true) goto L12;
            return;
        L12:
            int r14 = r10.getPointerId(0);
            int r15 = this.this$0.mActivePointerId;
            if (r14 != r15) goto L20;
            int r16 = r10.findPointerIndex(r15);
            float r17 = r10.getX(r16);
            float r18 = r10.getY(r16);
            ItemTouchHelper r19 = this.this$0;
            r19.mInitialTouchX = r17;
            r19.mInitialTouchY = r18;
            r19.mDy = 0.0f;
            r19.mDx = 0.0f;
            if (r19.mCallback.isLongPressDragEnabled() == false) goto L21;
            this.this$0.select(r12, 2);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    private static class RecoverAnimation implements Animator.AnimatorListener {
        final int mActionState;
        final int mAnimationType;
        boolean mEnded;
        private float mFraction;
        boolean mIsPendingCleanup;
        boolean mOverridden;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;

        RecoverAnimation(RecyclerView.ViewHolder r10, int r11, int r12, float r13, float r14, float r15, float r16) {
            this.mOverridden = false;
            this.mEnded = false;
            this.mActionState = r12;
            this.mAnimationType = r11;
            this.mViewHolder = r10;
            this.mStartDx = r13;
            this.mStartDy = r14;
            this.mTargetX = r15;
            this.mTargetY = r16;
            ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mValueAnimator = r17;
            r17.addUpdateListener(new AnonymousClass1(this));
            r17.setTarget(r10.itemView);
            r17.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.mEnded == true) goto L5;
            this.mViewHolder.setIsRecyclable(true);
        L5:
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
        }

        public void setDuration(long r10) {
            this.mValueAnimator.setDuration(r10);
        }

        public void setFraction(float r10) {
            this.mFraction = r10;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float r10 = this.mStartDx;
            float r11 = this.mTargetX;
            if (r10 != r11) goto L5;
            float r12 = this.mViewHolder.itemView.getTranslationX();
        L6:
            this.mX = r12;
            float r13 = this.mStartDy;
            float r14 = this.mTargetY;
            if (r13 != r14) goto L9;
            float r15 = this.mViewHolder.itemView.getTranslationY();
        L10:
            this.mY = r15;
            return;
        L9:
            r15 = r13 + (this.mFraction * (r14 - r13));
            goto L10
        L5:
            r12 = r10 + (this.mFraction * (r11 - r10));
            goto L6
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int r10, int r11) {
            this.mDefaultSwipeDirs = r11;
            this.mDefaultDragDirs = r10;
        }

        public int getDragDirs(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11) {
            return this.mDefaultDragDirs;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11) {
            return Callback.makeMovementFlags(getDragDirs(r10, r11), getSwipeDirs(r10, r11));
        }

        public int getSwipeDirs(@NonNull RecyclerView r10, @NonNull RecyclerView.ViewHolder r11) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int r10) {
            this.mDefaultDragDirs = r10;
        }

        public void setDefaultSwipeDirs(int r10) {
            this.mDefaultSwipeDirs = r10;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View r10, @NonNull View r11, int r12, int r13);
    }

    public ItemTouchHelper(@NonNull Callback r10) {
        this.mPendingCleanup = new ArrayList();
        this.mTmpPosition = new float[2];
        this.mSelected = null;
        this.mActivePointerId = -1;
        this.mActionState = 0;
        this.mRecoverAnimations = new ArrayList();
        this.mScrollRunnable = new AnonymousClass1(this);
        this.mChildDrawingOrderCallback = null;
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        this.mOnItemTouchListener = new AnonymousClass2(this);
        this.mCallback = r10;
    }

    private void addChildDrawingOrderCallback() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        return;
    L6:
        if (this.mChildDrawingOrderCallback != null) goto L8;
        this.mChildDrawingOrderCallback = new AnonymousClass5(this);
    L8:
        this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder r10, int r11) {
        if ((r11 & 12) == 0) goto L29;
        int r12 = 8;
        if (this.mDx <= 0.0f) goto L7;
        int r13 = 8;
    L8:
        VelocityTracker r14 = this.mVelocityTracker;
        if (r14 != null) goto L11;
    L24:
        float r15 = this.mRecyclerView.getWidth() * this.mCallback.getSwipeThreshold(r10);
        if ((r11 & r13) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.mDx) <= r15) goto L32;
        return r13;
    L32:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L24;
        r14.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r16 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r17 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r16 > 0.0f) goto L16;
        r12 = 4;
    L16:
        float r18 = Math.abs(r16);
        if ((r12 & r11) == 0) goto L24;
        if (r13 != r12) goto L24;
        if (r18 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L24;
        if (r18 <= Math.abs(r17)) goto L24;
        return r12;
    L7:
        r13 = 4;
        goto L8
    L29:
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder r10, int r11) {
        if ((r11 & 3) == 0) goto L29;
        int r12 = 2;
        if (this.mDy <= 0.0f) goto L7;
        int r13 = 2;
    L8:
        VelocityTracker r14 = this.mVelocityTracker;
        if (r14 != null) goto L11;
    L24:
        float r15 = this.mRecyclerView.getHeight() * this.mCallback.getSwipeThreshold(r10);
        if ((r11 & r13) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.mDy) <= r15) goto L32;
        return r13;
    L32:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L24;
        r14.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r16 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r17 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r17 > 0.0f) goto L16;
        r12 = 1;
    L16:
        float r18 = Math.abs(r17);
        if ((r12 & r11) == 0) goto L24;
        if (r12 != r13) goto L24;
        if (r18 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L24;
        if (r18 <= Math.abs(r16)) goto L24;
        return r12;
    L7:
        r13 = 1;
        goto L8
    L29:
        return 0;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        int r10 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
        r10 = r10 - 1;
        goto L3
    L5:
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder r17) {
        RecyclerView.ViewHolder r10 = r17;
        List<RecyclerView.ViewHolder> r11 = this.mSwapTargets;
        if (r11 != null) goto L5;
        this.mSwapTargets = new ArrayList();
        this.mDistances = new ArrayList();
    L6:
        int r12 = this.mCallback.getBoundingBoxMargin();
        int r13 = Math.round(this.mSelectedStartX + this.mDx) - r12;
        int r14 = Math.round(this.mSelectedStartY + this.mDy) - r12;
        int r15 = r12 * 2;
        int r16 = (r10.itemView.getWidth() + r13) + r15;
        int r18 = (r10.itemView.getHeight() + r14) + r15;
        int r19 = (r13 + r16) / 2;
        int r20 = (r14 + r18) / 2;
        RecyclerView.LayoutManager r21 = this.mRecyclerView.getLayoutManager();
        int r22 = r21.getChildCount();
        int r110 = 0;
    L7:
        if (r110 >= r22) goto L30;
        View r111 = r21.getChildAt(r110);
        if (r111 == r10.itemView) goto L28;
        if (r111.getBottom() < r14) goto L28;
        if (r111.getTop() > r18) goto L28;
        if (r111.getRight() < r13) goto L28;
        if (r111.getLeft() > r16) goto L28;
        RecyclerView.ViewHolder r112 = this.mRecyclerView.getChildViewHolder(r111);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, r112) == false) goto L28;
        int r113 = Math.abs(r19 - ((r111.getLeft() + r111.getRight()) / 2));
        int r114 = Math.abs(r20 - ((r111.getTop() + r111.getBottom()) / 2));
        int r115 = (r113 * r113) + (r114 * r114);
        int r116 = this.mSwapTargets.size();
        int r117 = 0;
        int r118 = 0;
    L23:
        if (r117 >= r116) goto L27;
        if (r115 <= this.mDistances.get(r117).intValue()) goto L27;
        r118 = r118 + 1;
        r117 = r117 + 1;
    L27:
        this.mSwapTargets.add(r118, r112);
        this.mDistances.add(r118, Integer.valueOf(r115));
    L28:
        r110 = r110 + 1;
        r10 = r17;
        goto L7
    L30:
        return this.mSwapTargets;
    L5:
        r11.clear();
        this.mDistances.clear();
        goto L6
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent r10) {
        RecyclerView.LayoutManager r11 = this.mRecyclerView.getLayoutManager();
        int r12 = this.mActivePointerId;
        if (r12 != (-1)) goto L5;
        return null;
    L5:
        int r13 = r10.findPointerIndex(r12);
        float r14 = r10.getX(r13) - this.mInitialTouchX;
        float r15 = r10.getY(r13) - this.mInitialTouchY;
        float r16 = Math.abs(r14);
        float r17 = Math.abs(r15);
        int r18 = this.mSlop;
        if (r16 >= r18) goto L11;
        if (r17 >= r18) goto L11;
        return null;
    L11:
        if (r16 <= r17) goto L16;
        if (r11.canScrollHorizontally() == false) goto L16;
        return null;
    L16:
        if (r17 > r16) goto L18;
    L20:
        View r19 = findChildView(r10);
        if (r19 != null) goto L24;
        return null;
    L24:
        return this.mRecyclerView.getChildViewHolder(r19);
    L18:
        if (r11.canScrollVertically() == false) goto L20;
        return null;
    }

    private void getSelectedDxDy(float[] r10) {
        if ((this.mSelectedFlags & 12) == 0) goto L5;
        r10[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
    L7:
        if ((this.mSelectedFlags & 3) == 0) goto L9;
        r10[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        return;
    L9:
        r10[1] = this.mSelected.itemView.getTranslationY();
        return;
    L5:
        r10[0] = this.mSelected.itemView.getTranslationX();
        goto L7
    }

    private static boolean hitTest(View r10, float r11, float r12, float r13, float r14) {
        if (r11 >= r13) goto L5;
    L11:
        return false;
    L5:
        if (r11 > (r13 + r10.getWidth())) goto L11;
        if (r12 < r14) goto L11;
        if (r12 > (r14 + r10.getHeight())) goto L11;
        return true;
    }

    private void releaseVelocityTracker() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        startGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener(this);
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener r10 = this.mItemTouchHelperGestureListener;
        if (r10 == null) goto L6;
        r10.doNotReactToLongPress();
        this.mItemTouchHelperGestureListener = null;
    L6:
        if (this.mGestureDetector == null) goto L9;
        this.mGestureDetector = null;
        return;
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder r10) {
        if (this.mActionState != 2) goto L5;
        return 0;
    L5:
        int r11 = this.mCallback.getMovementFlags(this.mRecyclerView, r10);
        int r12 = (this.mCallback.convertToAbsoluteDirection(r11, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (r12 != 0) goto L8;
        return 0;
    L8:
        int r13 = (r11 & 65280) >> 8;
        if (Math.abs(this.mDx) <= Math.abs(this.mDy)) goto L20;
        int r14 = checkHorizontalSwipe(r10, r12);
        if (r14 > 0) goto L13;
        int r15 = checkVerticalSwipe(r10, r12);
        if (r15 <= 0) goto L30;
        return r15;
    L30:
        return 0;
    L13:
        if ((r13 & r14) == 0) goto L15;
        return r14;
    L15:
        return Callback.convertToRelativeDirection(r14, ViewCompat.getLayoutDirection(this.mRecyclerView));
    L20:
        int r16 = checkVerticalSwipe(r10, r12);
        if (r16 <= 0) goto L23;
        return r16;
    L23:
        int r17 = checkHorizontalSwipe(r10, r12);
        if (r17 <= 0) goto L30;
        if ((r13 & r17) == 0) goto L28;
        return r17;
    L28:
        return Callback.convertToRelativeDirection(r17, ViewCompat.getLayoutDirection(this.mRecyclerView));
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
        Resources r12 = r10.getResources();
        this.mSwipeEscapeVelocity = r12.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
        this.mMaxSwipeVelocity = r12.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
        setupCallbacks();
        return;
    }

    void checkSelectForSwipe(int r10, MotionEvent r11, int r12) {
        if (this.mSelected == null) goto L5;
        return;
    L5:
        if (r10 == 2) goto L7;
        return;
    L7:
        if (this.mActionState != 2) goto L9;
        return;
    L9:
        if (this.mCallback.isItemViewSwipeEnabled() == true) goto L12;
        return;
    L12:
        if (this.mRecyclerView.getScrollState() != 1) goto L14;
        return;
    L14:
        RecyclerView.ViewHolder r13 = findSwipedView(r11);
        if (r13 != null) goto L17;
        return;
    L17:
        int r14 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r13) & 65280) >> 8;
        if (r14 != 0) goto L20;
        return;
    L20:
        float r15 = r11.getX(r12);
        float r16 = r11.getY(r12);
        float r17 = r15 - this.mInitialTouchX;
        float r18 = r16 - this.mInitialTouchY;
        float r19 = Math.abs(r17);
        float r20 = Math.abs(r18);
        int r21 = this.mSlop;
        if (r19 >= r21) goto L26;
        if (r20 >= r21) goto L26;
        return;
    L26:
        if (r19 <= r20) goto L38;
        if (r17 >= 0.0f) goto L33;
        if ((r14 & 4) != 0) goto L33;
        return;
    L33:
        if (r17 > 0.0f) goto L35;
    L47:
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = r11.getPointerId(0);
        select(r13, 1);
        return;
    L35:
        if ((r14 & 8) != 0) goto L47;
        return;
    L38:
        if (r18 >= 0.0f) goto L43;
        if ((r14 & 1) != 0) goto L43;
        return;
    L43:
        if (r18 <= 0.0f) goto L47;
        if ((r14 & 2) != 0) goto L47;
    }

    void endRecoverAnimation(RecyclerView.ViewHolder r10, boolean r11) {
        int r12 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r12 < 0) goto L12;
        RecoverAnimation r13 = this.mRecoverAnimations.get(r12);
        if (r13.mViewHolder == r10) goto L6;
        r12 = r12 - 1;
        goto L3
    L6:
        r13.mOverridden |= r11;
        if (r13.mEnded == true) goto L9;
        r13.cancel();
    L9:
        this.mRecoverAnimations.remove(r12);
        return;
    }

    RecoverAnimation findAnimation(MotionEvent r10) {
        if (this.mRecoverAnimations.isEmpty() == false) goto L5;
        return null;
    L5:
        View r11 = findChildView(r10);
        int r12 = this.mRecoverAnimations.size() - 1;
    L6:
        if (r12 < 0) goto L11;
        RecoverAnimation r13 = this.mRecoverAnimations.get(r12);
        if (r13.mViewHolder.itemView == r11) goto L9;
        r12 = r12 - 1;
        goto L6
    L9:
        return r13;
    L11:
        return null;
    }

    View findChildView(MotionEvent r10) {
        float r11 = r10.getX();
        float r12 = r10.getY();
        RecyclerView.ViewHolder r13 = this.mSelected;
        if (r13 == null) goto L7;
        View r14 = r13.itemView;
        if (hitTest(r14, r11, r12, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy) == false) goto L7;
        return r14;
    L7:
        int r15 = this.mRecoverAnimations.size() - 1;
    L8:
        if (r15 < 0) goto L14;
        RecoverAnimation r16 = this.mRecoverAnimations.get(r15);
        View r17 = r16.mViewHolder.itemView;
        if (hitTest(r17, r11, r12, r16.mX, r16.mY) == true) goto L11;
        r15 = r15 - 1;
        goto L8
    L11:
        return r17;
    L14:
        return this.mRecyclerView.findChildViewUnder(r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        r10.setEmpty();
    }

    boolean hasRunningRecoverAnim() {
        int r10 = this.mRecoverAnimations.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (this.mRecoverAnimations.get(r11).mEnded == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    void moveIfNecessary(RecyclerView.ViewHolder r11) {
        if (this.mRecyclerView.isLayoutRequested() == false) goto L6;
        return;
    L6:
        if (this.mActionState == 2) goto L8;
        return;
    L8:
        float r10 = this.mCallback.getMoveThreshold(r11);
        int r12 = (int) (this.mSelectedStartX + this.mDx);
        int r13 = (int) (this.mSelectedStartY + this.mDy);
        if (Math.abs(r13 - r11.itemView.getTop()) < (r11.itemView.getHeight() * r10)) goto L11;
    L13:
        List<RecyclerView.ViewHolder> r14 = findSwapTargets(r11);
        if (r14.size() != 0) goto L16;
        return;
    L16:
        RecyclerView.ViewHolder r15 = this.mCallback.chooseDropTarget(r11, r14, r12, r13);
        if (r15 != null) goto L20;
        this.mSwapTargets.clear();
        this.mDistances.clear();
        return;
    L20:
        int r16 = r15.getAdapterPosition();
        int r17 = r11.getAdapterPosition();
        if (this.mCallback.onMove(this.mRecyclerView, r11, r15) == false) goto L24;
        this.mCallback.onMoved(this.mRecyclerView, r11, r17, r15, r16, r12, r13);
        return;
    L24:
        return;
    L11:
        if (Math.abs(r12 - r11.itemView.getLeft()) >= (r11.itemView.getWidth() * r10)) goto L13;
    }

    void obtainVelocityTracker() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L5;
        r10.recycle();
    L5:
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View r10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View r10) {
        removeChildDrawingOrderCallbackIfNecessary(r10);
        RecyclerView.ViewHolder r11 = this.mRecyclerView.getChildViewHolder(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r12 = this.mSelected;
        if (r12 == null) goto L9;
        if (r11 != r12) goto L9;
        select(null, 0);
        return;
    L9:
        endRecoverAnimation(r11, false);
        if (this.mPendingCleanup.remove(r11.itemView) == false) goto L14;
        this.mCallback.clearView(this.mRecyclerView, r11);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        this.mOverdrawChildPosition = -1;
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r13 = this.mTmpPosition;
        float r14 = r13[0];
        float r15 = r13[1];
        float r16 = r14;
    L6:
        this.mCallback.onDraw(r10, r11, this.mSelected, this.mRecoverAnimations, this.mActionState, r16, r15);
        return;
    L5:
        r16 = 0.0f;
        r15 = 0.0f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r13 = this.mTmpPosition;
        float r14 = r13[0];
        float r15 = r13[1];
        float r16 = r14;
    L6:
        this.mCallback.onDrawOver(r10, r11, this.mSelected, this.mRecoverAnimations, this.mActionState, r16, r15);
        return;
    L5:
        r16 = 0.0f;
        r15 = 0.0f;
        goto L6
    }

    void postDispatchSwipe(final RecoverAnimation r10, final int r11) {
        this.mRecyclerView.post(new AnonymousClass4(this, r10, r11));
    }

    void removeChildDrawingOrderCallbackIfNecessary(View r10) {
        if (r10 != this.mOverdrawChild) goto L8;
        this.mOverdrawChild = null;
        if (this.mChildDrawingOrderCallback == null) goto L9;
        this.mRecyclerView.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }

    boolean scrollIfNecessary() {
        if (this.mSelected != null) goto L6;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L6:
        long r10 = System.currentTimeMillis();
        long r11 = this.mDragScrollStartTimeInMs;
        if (r11 != Long.MIN_VALUE) goto L9;
        long r12 = 0;
    L10:
        RecyclerView.LayoutManager r13 = this.mRecyclerView.getLayoutManager();
        if (this.mTmpRect != null) goto L13;
        this.mTmpRect = new Rect();
    L13:
        r13.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if (r13.canScrollHorizontally() == false) goto L24;
        int r14 = (int) (this.mSelectedStartX + this.mDx);
        int r15 = (r14 - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
        float r16 = this.mDx;
        if (r16 >= 0.0f) goto L20;
        if (r15 >= 0) goto L20;
        int r17 = r15;
    L26:
        if (r13.canScrollVertically() == false) goto L36;
        int r18 = (int) (this.mSelectedStartY + this.mDy);
        int r19 = (r18 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
        float r110 = this.mDy;
        if (r110 >= 0.0f) goto L32;
        if (r19 >= 0) goto L32;
        int r20 = r19;
    L37:
        if (r17 == 0) goto L39;
        r17 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), r17, this.mRecyclerView.getWidth(), r12);
    L39:
        int r111 = r17;
        if (r20 == 0) goto L42;
        int r112 = r111;
        r20 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), r20, this.mRecyclerView.getHeight(), r12);
    L43:
        if (r112 != 0) goto L49;
        if (r20 != 0) goto L49;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L49:
        if (this.mDragScrollStartTimeInMs != Long.MIN_VALUE) goto L51;
        this.mDragScrollStartTimeInMs = r10;
    L51:
        this.mRecyclerView.scrollBy(r112, r20);
        return true;
    L42:
        r112 = r111;
    L32:
        if (r110 <= 0.0f) goto L36;
        r20 = ((r18 + this.mSelected.itemView.getHeight()) + this.mTmpRect.bottom) - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
        if (r20 > 0) goto L37;
    L36:
        r20 = 0;
    L20:
        if (r16 <= 0.0f) goto L24;
        int r21 = ((r14 + this.mSelected.itemView.getWidth()) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
        if (r21 <= 0) goto L24;
        r17 = r21;
    L24:
        r17 = 0;
        goto L26
    L9:
        r12 = r10 - r11;
        goto L10
    }

    void select(@Nullable RecyclerView.ViewHolder r24, int r25) {
        if (r24 == this.mSelected) goto L5;
    L7:
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        final int r10 = this.mActionState;
        endRecoverAnimation(r24, true);
        this.mActionState = r25;
        if (r25 != 2) goto L13;
        if (r24 == null) goto L12;
        this.mOverdrawChild = r24.itemView;
        addChildDrawingOrderCallback();
        goto L13
    L12:
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
    L13:
        int r16 = (1 << ((r25 * 8) + 8)) - 1;
        final RecyclerView.ViewHolder r11 = this.mSelected;
        if (r11 != null) goto L16;
        boolean r12 = false;
    L41:
        if (r24 == null) goto L45;
        this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r24) & r16) >> (this.mActionState * 8);
        this.mSelectedStartX = r24.itemView.getLeft();
        this.mSelectedStartY = r24.itemView.getTop();
        this.mSelected = r24;
        if (r25 != 2) goto L45;
        boolean r13 = false;
        r24.itemView.performHapticFeedback(0);
    L46:
        ViewParent r14 = this.mRecyclerView.getParent();
        if (r14 != null) goto L49;
    L53:
        if (r12 == true) goto L55;
        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    L55:
        this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
        this.mRecyclerView.invalidate();
        return;
    L49:
        if (this.mSelected == null) goto L51;
        boolean r15 = true;
    L52:
        r14.requestDisallowInterceptTouchEvent(r15);
        goto L53
    L51:
        r15 = r13;
    L45:
        r13 = false;
        goto L46
    L16:
        if (r11.itemView.getParent() == null) goto L38;
        if (r10 != 2) goto L19;
        int r17 = 0;
    L20:
        releaseVelocityTracker();
        if (r17 == 1) goto L31;
        if (r17 == 2) goto L31;
        if (r17 == 4) goto L30;
        if (r17 == 8) goto L30;
        if (r17 == 16) goto L30;
        if (r17 == 32) goto L30;
        float r18 = 0.0f;
        float r19 = 0.0f;
    L32:
        if (r10 != 2) goto L34;
        int r20 = 8;
    L37:
        getSelectedDxDy(this.mTmpPosition);
        float[] r21 = this.mTmpPosition;
        final float r110 = r21[0];
        final float r22 = r21[1];
        final int r23 = r20;
        final int r26 = r17;
        final float r27 = r18;
        final float r28 = r19;
        RecoverAnimation r29 = new AnonymousClass3(this, r11, r23, r10, r110, r22, r27, r28, r26, r11);
        r29.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, r20, r18 - r110, r19 - r22));
        this.mRecoverAnimations.add(r29);
        r29.start();
        r12 = true;
    L39:
        this.mSelected = null;
        goto L41
    L34:
        if (r17 <= 0) goto L36;
        r20 = 2;
        goto L37
    L36:
        r20 = 4;
    L30:
        r19 = 0.0f;
        r18 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
    L31:
        r18 = 0.0f;
        r19 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
        goto L32
    L19:
        r17 = swipeIfNecessary(r11);
        goto L20
    L38:
        removeChildDrawingOrderCallbackIfNecessary(r11.itemView);
        this.mCallback.clearView(this.mRecyclerView, r11);
        r12 = false;
        goto L39
    L5:
        if (r25 != this.mActionState) goto L7;
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder r10) {
        if (this.mCallback.hasDragFlag(this.mRecyclerView, r10) == true) goto L7;
        Log.e(TAG, "Start drag has been called but dragging is not enabled");
        return;
    L7:
        if (r10.itemView.getParent() == this.mRecyclerView) goto L10;
        Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        return;
    L10:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r10, 2);
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder r10) {
        if (this.mCallback.hasSwipeFlag(this.mRecyclerView, r10) == true) goto L7;
        Log.e(TAG, "Start swipe has been called but swiping is not enabled");
        return;
    L7:
        if (r10.itemView.getParent() == this.mRecyclerView) goto L10;
        Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        return;
    L10:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r10, 1);
    }

    void updateDxDy(MotionEvent r10, int r11, int r12) {
        float r13 = r10.getX(r12);
        float r14 = r10.getY(r12);
        float r15 = r13 - this.mInitialTouchX;
        this.mDx = r15;
        this.mDy = r14 - this.mInitialTouchY;
        if ((r11 & 4) != 0) goto L6;
        this.mDx = Math.max(0.0f, r15);
    L6:
        if ((r11 & 8) != 0) goto L9;
        this.mDx = Math.min(0.0f, this.mDx);
    L9:
        if ((r11 & 1) != 0) goto L12;
        this.mDy = Math.max(0.0f, this.mDy);
    L12:
        if ((r11 & 2) != 0) goto L15;
        this.mDy = Math.min(0.0f, this.mDy);
        return;
    }
}
