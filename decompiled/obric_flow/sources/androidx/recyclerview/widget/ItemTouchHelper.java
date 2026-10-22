package androidx.recyclerview.widget;

import ai.j0;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
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
import androidx.annotation.VisibleForTesting;
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

    @VisibleForTesting
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

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$5, reason: invalid class name */
    public class AnonymousClass5 implements RecyclerView.ChildDrawingOrderCallback {
        final /* synthetic */ ItemTouchHelper this$0;

        public AnonymousClass5(ItemTouchHelper r5) {
            this.this$0 = r5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public int onGetChildDrawingOrder(int r5, int r10) {
            ItemTouchHelper r11 = this.this$0;
            View r12 = r11.mOverdrawChild;
            if (r12 != null) goto L5;
            return r10;
        L5:
            int r13 = r11.mOverdrawChildPosition;
            if (r13 != (-1)) goto L9;
            r13 = r11.mRecyclerView.indexOfChild(r12);
            this.this$0.mOverdrawChildPosition = r13;
        L9:
            if (r10 != (r5 - 1)) goto L11;
            return r13;
        L11:
            if (r10 >= r13) goto L14;
            return r10;
        L14:
            return r10 + 1;
        }
    }

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

        public static int convertToRelativeDirection(int r5, int r10) {
            int r11 = r5 & ABS_HORIZONTAL_DIR_FLAGS;
            if (r11 != 0) goto L5;
            return r5;
        L5:
            int r12 = r5 & (~r11);
            if (r10 != 0) goto L10;
            int r13 = r11 << 2;
        L9:
            return r12 | r13;
        L10:
            int r14 = r11 << 1;
            r12 = r12 | ((-789517) & r14);
            r13 = (r14 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            goto L9
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView r5) {
            if (this.mCachedMaxScrollSpeed != (-1)) goto L6;
            this.mCachedMaxScrollSpeed = r5.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
        L6:
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int r5, int r10) {
            return r10 << (r5 * 8);
        }

        public static int makeMovementFlags(int r5, int r10) {
            int r11 = makeFlag(0, r10 | r5);
            int r12 = makeFlag(1, r10) | r11;
            return makeFlag(2, r5) | r12;
        }

        public boolean canDropOver(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ViewHolder r11) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder r12, @NonNull List<RecyclerView.ViewHolder> r13, int r14, int r15) {
            int r11 = r12.itemView.getWidth() + r14;
            int r5 = r12.itemView.getHeight() + r15;
            int r10 = r14 - r12.itemView.getLeft();
            int r16 = r15 - r12.itemView.getTop();
            int r17 = r13.size();
            RecyclerView.ViewHolder r18 = null;
            int r19 = -1;
            int r20 = 0;
        L3:
            if (r20 >= r17) goto L38;
            RecyclerView.ViewHolder r21 = r13.get(r20);
            if (r10 <= 0) goto L13;
            int r22 = r21.itemView.getRight() - r11;
            if (r22 >= 0) goto L13;
            if (r21.itemView.getRight() <= r12.itemView.getRight()) goto L13;
            int r23 = Math.abs(r22);
            if (r23 <= r19) goto L13;
            r18 = r21;
            r19 = r23;
        L13:
            if (r10 >= 0) goto L21;
            int r24 = r21.itemView.getLeft() - r14;
            if (r24 <= 0) goto L21;
            if (r21.itemView.getLeft() >= r12.itemView.getLeft()) goto L21;
            int r25 = Math.abs(r24);
            if (r25 <= r19) goto L21;
            r18 = r21;
            r19 = r25;
        L21:
            if (r16 >= 0) goto L29;
            int r26 = r21.itemView.getTop() - r15;
            if (r26 <= 0) goto L29;
            if (r21.itemView.getTop() >= r12.itemView.getTop()) goto L29;
            int r27 = Math.abs(r26);
            if (r27 <= r19) goto L29;
            r18 = r21;
            r19 = r27;
        L29:
            if (r16 <= 0) goto L37;
            int r28 = r21.itemView.getBottom() - r5;
            if (r28 >= 0) goto L37;
            if (r21.itemView.getBottom() <= r12.itemView.getBottom()) goto L37;
            int r29 = Math.abs(r28);
            if (r29 <= r19) goto L37;
            r18 = r21;
            r19 = r29;
        L37:
            r20 = r20 + 1;
            goto L3
        L38:
            return r18;
        }

        public void clearView(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(r10.itemView);
        }

        public int convertToAbsoluteDirection(int r5, int r10) {
            int r11 = r5 & RELATIVE_DIR_FLAGS;
            if (r11 != 0) goto L5;
            return r5;
        L5:
            int r12 = r5 & (~r11);
            if (r10 != 0) goto L10;
            int r13 = r11 >> 2;
        L9:
            return r13 | r12;
        L10:
            int r14 = r11 >> 1;
            r12 = r12 | ((-3158065) & r14);
            r13 = (RELATIVE_DIR_FLAGS & r14) >> 2;
            goto L9
        }

        public final int getAbsoluteMovementFlags(RecyclerView r5, RecyclerView.ViewHolder r10) {
            return convertToAbsoluteDirection(getMovementFlags(r5, r10), ViewCompat.getLayoutDirection(r5));
        }

        public long getAnimationDuration(@NonNull RecyclerView r5, int r10, float r11, float r12) {
            RecyclerView.ItemAnimator r13 = r5.getItemAnimator();
            if (r13 != null) goto L8;
            if (r10 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r10 != 8) goto L11;
            return r13.getMoveDuration();
        L11:
            return r13.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder r5) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10);

        public float getSwipeEscapeVelocity(float r5) {
            return r5;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder r5) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float r5) {
            return r5;
        }

        public boolean hasDragFlag(RecyclerView r5, RecyclerView.ViewHolder r10) {
            if ((getAbsoluteMovementFlags(r5, r10) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSwipeFlag(RecyclerView r5, RecyclerView.ViewHolder r10) {
            if ((getAbsoluteMovementFlags(r5, r10) & 65280) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView r5, int r10, int r11, int r12, long r13) {
            int r14 = getMaxDragScroll(r5);
            int r15 = Math.abs(r11);
            int r16 = (int) Math.signum(r11);
            float r17 = 1.0f;
            int r18 = (int) (sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (r15 * 1.0f) / r10)) * (r16 * r14));
            if (r13 > DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) goto L6;
            r17 = r13 / 2000.0f;
        L6:
            int r19 = (int) (sDragScrollInterpolator.getInterpolation(r17) * r18);
            if (r19 != 0) goto L12;
            if (r11 <= 0) goto L10;
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

        public void onChildDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11, @SuppressLint({"UnknownNullness"}) RecyclerView.ViewHolder r12, float r13, float r14, int r15, boolean r16) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(r10, r11, r12.itemView, r13, r14, r15, r16);
        }

        public void onDraw(Canvas r14, RecyclerView r15, RecyclerView.ViewHolder r16, List<RecoverAnimation> r17, int r18, float r19, float r20) {
            int r10 = r17.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            RecoverAnimation r5 = r17.get(r11);
            r5.update();
            int r12 = r14.save();
            onChildDraw(r14, r15, r5.mViewHolder, r5.mX, r5.mY, r5.mActionState, false);
            r14.restoreToCount(r12);
            r11 = r11 + 1;
            goto L3
        L5:
            if (r16 == null) goto L9;
            int r13 = r14.save();
            onChildDraw(r14, r15, r16, r19, r20, r18, true);
            r14.restoreToCount(r13);
            return;
        }

        public void onDrawOver(Canvas r15, RecyclerView r16, RecyclerView.ViewHolder r17, List<RecoverAnimation> r18, int r19, float r20, float r21) {
            int r10 = r18.size();
            boolean r11 = false;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            RecoverAnimation r5 = r18.get(r12);
            int r13 = r15.save();
            onChildDrawOver(r15, r16, r5.mViewHolder, r5.mX, r5.mY, r5.mActionState, false);
            r15.restoreToCount(r13);
            r12 = r12 + 1;
            goto L3
        L5:
            if (r17 == null) goto L7;
            int r14 = r15.save();
            onChildDrawOver(r15, r16, r17, r20, r21, r19, true);
            r15.restoreToCount(r14);
        L7:
            int r110 = r10 - 1;
        L8:
            if (r110 < 0) goto L17;
            RecoverAnimation r22 = r18.get(r110);
            boolean r23 = r22.mEnded;
            if (r23 == true) goto L12;
        L14:
            if (r23 == true) goto L16;
            r11 = true;
        L16:
            r110 = r110 - 1;
            goto L8
        L12:
            if (r22.mIsPendingCleanup == true) goto L14;
            r18.remove(r110);
            goto L16
        L17:
            if (r11 == false) goto L25;
            r16.invalidate();
            return;
        }

        public abstract boolean onMove(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10, @NonNull RecyclerView.ViewHolder r11);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10, int r11, @NonNull RecyclerView.ViewHolder r12, int r13, int r14, int r15) {
            RecyclerView.LayoutManager r16 = r5.getLayoutManager();
            if ((r16 instanceof ViewDropHandler) == false) goto L7;
            ((ViewDropHandler) r16).prepareForDrop(r10.itemView, r12.itemView, r14, r15);
            return;
        L7:
            if (r16.canScrollHorizontally() == false) goto L15;
            if (r16.getDecoratedLeft(r12.itemView) > r5.getPaddingLeft()) goto L12;
            r5.scrollToPosition(r13);
        L12:
            if (r16.getDecoratedRight(r12.itemView) < (r5.getWidth() - r5.getPaddingRight())) goto L15;
            r5.scrollToPosition(r13);
        L15:
            if (r16.canScrollVertically() == true) goto L17;
            return;
        L17:
            if (r16.getDecoratedTop(r12.itemView) > r5.getPaddingTop()) goto L20;
            r5.scrollToPosition(r13);
        L20:
            if (r16.getDecoratedBottom(r12.itemView) < (r5.getHeight() - r5.getPaddingBottom())) goto L24;
            r5.scrollToPosition(r13);
            return;
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder r5, int r10) {
            if (r5 == null) goto L5;
            ItemTouchUIUtilImpl.INSTANCE.onSelected(r5.itemView);
            return;
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder r5, int r10);
    }

    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress;
        final /* synthetic */ ItemTouchHelper this$0;

        public ItemTouchHelperGestureListener(ItemTouchHelper r5) {
            this.this$0 = r5;
            this.mShouldReactToLongPress = true;
        }

        public void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r5) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r5) {
            if (this.mShouldReactToLongPress == true) goto L5;
            return;
        L5:
            View r10 = this.this$0.findChildView(r5);
            if (r10 == null) goto L18;
            RecyclerView.ViewHolder r11 = this.this$0.mRecyclerView.getChildViewHolder(r10);
            if (r11 == null) goto L19;
            ItemTouchHelper r12 = this.this$0;
            if (r12.mCallback.hasDragFlag(r12.mRecyclerView, r11) == true) goto L12;
            return;
        L12:
            int r13 = r5.getPointerId(0);
            int r14 = this.this$0.mActivePointerId;
            if (r13 != r14) goto L20;
            int r15 = r5.findPointerIndex(r14);
            float r16 = r5.getX(r15);
            float r17 = r5.getY(r15);
            ItemTouchHelper r18 = this.this$0;
            r18.mInitialTouchX = r16;
            r18.mInitialTouchY = r17;
            r18.mDy = 0.0f;
            r18.mDx = 0.0f;
            if (r18.mCallback.isLongPressDragEnabled() == false) goto L21;
            this.this$0.select(r11, 2);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    @VisibleForTesting
    public static class RecoverAnimation implements Animator.AnimatorListener {
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

        @VisibleForTesting
        final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;

        public RecoverAnimation(RecyclerView.ViewHolder r5, int r10, int r11, float r12, float r13, float r14, float r15) {
            this.mOverridden = false;
            this.mEnded = false;
            this.mActionState = r11;
            this.mAnimationType = r10;
            this.mViewHolder = r5;
            this.mStartDx = r12;
            this.mStartDy = r13;
            this.mTargetX = r14;
            this.mTargetY = r15;
            ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mValueAnimator = r16;
            r16.addUpdateListener(new AnonymousClass1(this));
            r16.setTarget(r5.itemView);
            r16.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            if (this.mEnded == true) goto L5;
            this.mViewHolder.setIsRecyclable(true);
        L5:
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r5) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
        }

        public void setDuration(long r5) {
            this.mValueAnimator.setDuration(r5);
        }

        public void setFraction(float r5) {
            this.mFraction = r5;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float r5 = this.mStartDx;
            float r10 = this.mTargetX;
            if (r5 != r10) goto L5;
            this.mX = this.mViewHolder.itemView.getTranslationX();
        L6:
            float r11 = this.mStartDy;
            float r12 = this.mTargetY;
            if (r11 != r12) goto L9;
            this.mY = this.mViewHolder.itemView.getTranslationY();
            return;
        L9:
            this.mY = j0.b(r12, r11, this.mFraction, r11);
            return;
        L5:
            this.mX = j0.b(r10, r5, this.mFraction, r5);
            goto L6
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int r5, int r10) {
            this.mDefaultSwipeDirs = r10;
            this.mDefaultDragDirs = r5;
        }

        public int getDragDirs(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10) {
            return this.mDefaultDragDirs;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10) {
            return Callback.makeMovementFlags(getDragDirs(r5, r10), getSwipeDirs(r5, r10));
        }

        public int getSwipeDirs(@NonNull RecyclerView r5, @NonNull RecyclerView.ViewHolder r10) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int r5) {
            this.mDefaultDragDirs = r5;
        }

        public void setDefaultSwipeDirs(int r5) {
            this.mDefaultSwipeDirs = r5;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View r5, @NonNull View r10, int r11, int r12);
    }

    public ItemTouchHelper(@NonNull Callback r5) {
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
        this.mCallback = r5;
    }

    private void addChildDrawingOrderCallback() {
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder r10, int r11) {
        if ((r11 & 12) == 0) goto L28;
        int r5 = 4;
        if (this.mDx <= 0.0f) goto L7;
        int r12 = 8;
    L8:
        VelocityTracker r13 = this.mVelocityTracker;
        if (r13 != null) goto L11;
    L23:
        float r14 = this.mCallback.getSwipeThreshold(r10) * this.mRecyclerView.getWidth();
        if ((r11 & r12) != 0) goto L26;
        return 0;
    L26:
        if (Math.abs(this.mDx) <= r14) goto L31;
        return r12;
    L31:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L23;
        r13.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r15 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r16 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r15 <= 0.0f) goto L15;
        r5 = 8;
    L15:
        float r17 = Math.abs(r15);
        if ((r5 & r11) == 0) goto L23;
        if (r12 != r5) goto L23;
        if (r17 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L23;
        if (r17 <= Math.abs(r16)) goto L23;
        return r5;
    L7:
        r12 = 4;
        goto L8
    L28:
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder r10, int r11) {
        if ((r11 & 3) == 0) goto L28;
        int r5 = 1;
        if (this.mDy <= 0.0f) goto L7;
        int r12 = 2;
    L8:
        VelocityTracker r13 = this.mVelocityTracker;
        if (r13 != null) goto L11;
    L23:
        float r14 = this.mCallback.getSwipeThreshold(r10) * this.mRecyclerView.getHeight();
        if ((r11 & r12) != 0) goto L26;
        return 0;
    L26:
        if (Math.abs(this.mDy) <= r14) goto L31;
        return r12;
    L31:
        return 0;
    L11:
        if (this.mActivePointerId <= (-1)) goto L23;
        r13.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        float r15 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float r16 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (r16 <= 0.0f) goto L15;
        r5 = 2;
    L15:
        float r17 = Math.abs(r16);
        if ((r5 & r11) == 0) goto L23;
        if (r5 != r12) goto L23;
        if (r17 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) goto L23;
        if (r17 <= Math.abs(r15)) goto L23;
        return r5;
    L7:
        r12 = 1;
        goto L8
    L28:
        return 0;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        int r5 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r5 < 0) goto L5;
        RecoverAnimation r10 = this.mRecoverAnimations.get(0);
        r10.cancel();
        this.mCallback.clearView(this.mRecyclerView, r10.mViewHolder);
        r5 = r5 - 1;
        goto L3
    L5:
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder r17) {
        RecyclerView.ViewHolder r5 = r17;
        List<RecyclerView.ViewHolder> r10 = this.mSwapTargets;
        if (r10 != null) goto L5;
        this.mSwapTargets = new ArrayList();
        this.mDistances = new ArrayList();
    L6:
        int r11 = this.mCallback.getBoundingBoxMargin();
        int r12 = Math.round(this.mSelectedStartX + this.mDx) - r11;
        int r13 = Math.round(this.mSelectedStartY + this.mDy) - r11;
        int r14 = r11 * 2;
        int r15 = (r5.itemView.getWidth() + r12) + r14;
        int r16 = (r5.itemView.getHeight() + r13) + r14;
        int r18 = (r12 + r15) / 2;
        int r19 = (r13 + r16) / 2;
        RecyclerView.LayoutManager r20 = this.mRecyclerView.getLayoutManager();
        int r21 = r20.getChildCount();
        int r110 = 0;
    L7:
        if (r110 >= r21) goto L30;
        View r111 = r20.getChildAt(r110);
        if (r111 == r5.itemView) goto L28;
        if (r111.getBottom() < r13) goto L28;
        if (r111.getTop() > r16) goto L28;
        if (r111.getRight() < r12) goto L28;
        if (r111.getLeft() > r15) goto L28;
        RecyclerView.ViewHolder r112 = this.mRecyclerView.getChildViewHolder(r111);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, r112) == false) goto L28;
        int r113 = r111.getLeft();
        int r114 = Math.abs(r18 - ((r111.getRight() + r113) / 2));
        int r115 = r111.getTop();
        int r116 = Math.abs(r19 - ((r111.getBottom() + r115) / 2));
        int r117 = r116 * r116;
        int r118 = r117 + (r114 * r114);
        int r119 = this.mSwapTargets.size();
        int r120 = 0;
        int r121 = 0;
    L23:
        if (r120 >= r119) goto L27;
        if (r118 <= this.mDistances.get(r120).intValue()) goto L27;
        r121 = r121 + 1;
        r120 = r120 + 1;
    L27:
        this.mSwapTargets.add(r121, r112);
        this.mDistances.add(r121, Integer.valueOf(r118));
    L28:
        r110 = r110 + 1;
        r5 = r17;
        goto L7
    L30:
        return this.mSwapTargets;
    L5:
        r10.clear();
        this.mDistances.clear();
        goto L6
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent r10) {
        RecyclerView.LayoutManager r5 = this.mRecyclerView.getLayoutManager();
        int r11 = this.mActivePointerId;
        if (r11 != (-1)) goto L5;
        return null;
    L5:
        int r12 = r10.findPointerIndex(r11);
        float r13 = r10.getX(r12) - this.mInitialTouchX;
        float r14 = r10.getY(r12) - this.mInitialTouchY;
        float r15 = Math.abs(r13);
        float r16 = Math.abs(r14);
        int r17 = this.mSlop;
        if (r15 >= r17) goto L11;
        if (r16 >= r17) goto L11;
        return null;
    L11:
        if (r15 <= r16) goto L16;
        if (r5.canScrollHorizontally() == false) goto L16;
        return null;
    L16:
        if (r16 > r15) goto L18;
    L20:
        View r18 = findChildView(r10);
        if (r18 != null) goto L24;
        return null;
    L24:
        return this.mRecyclerView.getChildViewHolder(r18);
    L18:
        if (r5.canScrollVertically() == false) goto L20;
        return null;
    }

    private void getSelectedDxDy(float[] r5) {
        if ((this.mSelectedFlags & 12) == 0) goto L5;
        r5[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
    L7:
        if ((this.mSelectedFlags & 3) == 0) goto L9;
        r5[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        return;
    L9:
        r5[1] = this.mSelected.itemView.getTranslationY();
        return;
    L5:
        r5[0] = this.mSelected.itemView.getTranslationX();
        goto L7
    }

    private static boolean hitTest(View r5, float r10, float r11, float r12, float r13) {
        if (r10 >= r12) goto L5;
    L11:
        return false;
    L5:
        if (r10 > (r12 + r5.getWidth())) goto L11;
        if (r11 < r13) goto L11;
        if (r11 > (r13 + r5.getHeight())) goto L11;
        return true;
    }

    private void releaseVelocityTracker() {
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L6;
        r5.recycle();
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
        ItemTouchHelperGestureListener r5 = this.mItemTouchHelperGestureListener;
        if (r5 == null) goto L6;
        r5.doNotReactToLongPress();
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
        int r5 = this.mCallback.getMovementFlags(this.mRecyclerView, r10);
        int r11 = (this.mCallback.convertToAbsoluteDirection(r5, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (r11 != 0) goto L8;
        return 0;
    L8:
        int r12 = (r5 & 65280) >> 8;
        if (Math.abs(this.mDx) <= Math.abs(this.mDy)) goto L20;
        int r13 = checkHorizontalSwipe(r10, r11);
        if (r13 > 0) goto L13;
        int r14 = checkVerticalSwipe(r10, r11);
        if (r14 <= 0) goto L30;
        return r14;
    L30:
        return 0;
    L13:
        if ((r12 & r13) == 0) goto L15;
        return r13;
    L15:
        return Callback.convertToRelativeDirection(r13, ViewCompat.getLayoutDirection(this.mRecyclerView));
    L20:
        int r15 = checkVerticalSwipe(r10, r11);
        if (r15 <= 0) goto L23;
        return r15;
    L23:
        int r16 = checkHorizontalSwipe(r10, r11);
        if (r16 <= 0) goto L30;
        if ((r12 & r16) == 0) goto L28;
        return r16;
    L28:
        return Callback.convertToRelativeDirection(r16, ViewCompat.getLayoutDirection(this.mRecyclerView));
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
        Resources r11 = r5.getResources();
        this.mSwipeEscapeVelocity = r11.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
        this.mMaxSwipeVelocity = r11.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
        setupCallbacks();
        return;
    }

    public void checkSelectForSwipe(int r10, MotionEvent r11, int r12) {
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
        int r5 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r13) & 65280) >> 8;
        if (r5 != 0) goto L20;
        return;
    L20:
        float r14 = r11.getX(r12);
        float r15 = r11.getY(r12);
        float r16 = r14 - this.mInitialTouchX;
        float r17 = r15 - this.mInitialTouchY;
        float r18 = Math.abs(r16);
        float r19 = Math.abs(r17);
        int r20 = this.mSlop;
        if (r18 >= r20) goto L26;
        if (r19 >= r20) goto L26;
        return;
    L26:
        if (r18 <= r19) goto L38;
        if (r16 >= 0.0f) goto L33;
        if ((r5 & 4) != 0) goto L33;
        return;
    L33:
        if (r16 > 0.0f) goto L35;
    L47:
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = r11.getPointerId(0);
        select(r13, 1);
        return;
    L35:
        if ((r5 & 8) != 0) goto L47;
        return;
    L38:
        if (r17 >= 0.0f) goto L43;
        if ((r5 & 1) != 0) goto L43;
        return;
    L43:
        if (r17 <= 0.0f) goto L47;
        if ((r5 & 2) != 0) goto L47;
    }

    public void endRecoverAnimation(RecyclerView.ViewHolder r5, boolean r10) {
        int r11 = this.mRecoverAnimations.size() - 1;
    L3:
        if (r11 < 0) goto L12;
        RecoverAnimation r12 = this.mRecoverAnimations.get(r11);
        if (r12.mViewHolder == r5) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        r12.mOverridden |= r10;
        if (r12.mEnded == true) goto L9;
        r12.cancel();
    L9:
        this.mRecoverAnimations.remove(r11);
        return;
    }

    public RecoverAnimation findAnimation(MotionEvent r5) {
        if (this.mRecoverAnimations.isEmpty() == false) goto L5;
        return null;
    L5:
        View r10 = findChildView(r5);
        int r11 = this.mRecoverAnimations.size() - 1;
    L6:
        if (r11 < 0) goto L11;
        RecoverAnimation r12 = this.mRecoverAnimations.get(r11);
        if (r12.mViewHolder.itemView == r10) goto L9;
        r11 = r11 - 1;
        goto L6
    L9:
        return r12;
    L11:
        return null;
    }

    public View findChildView(MotionEvent r10) {
        float r5 = r10.getX();
        float r11 = r10.getY();
        RecyclerView.ViewHolder r12 = this.mSelected;
        if (r12 == null) goto L7;
        View r13 = r12.itemView;
        if (hitTest(r13, r5, r11, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy) == false) goto L7;
        return r13;
    L7:
        int r14 = this.mRecoverAnimations.size() - 1;
    L8:
        if (r14 < 0) goto L14;
        RecoverAnimation r15 = this.mRecoverAnimations.get(r14);
        View r16 = r15.mViewHolder.itemView;
        if (hitTest(r16, r5, r11, r15.mX, r15.mY) == true) goto L11;
        r14 = r14 - 1;
        goto L8
    L11:
        return r16;
    L14:
        return this.mRecyclerView.findChildViewUnder(r5, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect r5, View r10, RecyclerView r11, RecyclerView.State r12) {
        r5.setEmpty();
    }

    public boolean hasRunningRecoverAnim() {
        int r5 = this.mRecoverAnimations.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L9;
        if (this.mRecoverAnimations.get(r10).mEnded == false) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void moveIfNecessary(RecyclerView.ViewHolder r11) {
        if (this.mRecyclerView.isLayoutRequested() == false) goto L6;
        return;
    L6:
        if (this.mActionState == 2) goto L8;
        return;
    L8:
        float r5 = this.mCallback.getMoveThreshold(r11);
        int r10 = (int) (this.mSelectedStartX + this.mDx);
        int r12 = (int) (this.mSelectedStartY + this.mDy);
        if (Math.abs(r12 - r11.itemView.getTop()) < (r11.itemView.getHeight() * r5)) goto L11;
    L13:
        List<RecyclerView.ViewHolder> r13 = findSwapTargets(r11);
        if (r13.size() != 0) goto L16;
        return;
    L16:
        RecyclerView.ViewHolder r14 = this.mCallback.chooseDropTarget(r11, r13, r10, r12);
        if (r14 != null) goto L20;
        this.mSwapTargets.clear();
        this.mDistances.clear();
        return;
    L20:
        int r15 = r14.getAbsoluteAdapterPosition();
        int r16 = r11.getAbsoluteAdapterPosition();
        if (this.mCallback.onMove(this.mRecyclerView, r11, r14) == false) goto L24;
        this.mCallback.onMoved(this.mRecyclerView, r11, r16, r14, r15, r10, r12);
        return;
    L24:
        return;
    L11:
        if (Math.abs(r10 - r11.itemView.getLeft()) >= (r11.itemView.getWidth() * r5)) goto L13;
    }

    public void obtainVelocityTracker() {
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L5;
        r5.recycle();
    L5:
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View r5) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View r5) {
        removeChildDrawingOrderCallbackIfNecessary(r5);
        RecyclerView.ViewHolder r10 = this.mRecyclerView.getChildViewHolder(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r11 = this.mSelected;
        if (r11 == null) goto L9;
        if (r10 != r11) goto L9;
        select(null, 0);
        return;
    L9:
        endRecoverAnimation(r10, false);
        if (this.mPendingCleanup.remove(r10.itemView) == false) goto L14;
        this.mCallback.clearView(this.mRecyclerView, r10);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        this.mOverdrawChildPosition = -1;
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r13 = this.mTmpPosition;
        float r5 = r13[0];
        float r14 = r13[1];
        float r15 = r5;
    L6:
        this.mCallback.onDraw(r10, r11, this.mSelected, this.mRecoverAnimations, this.mActionState, r15, r14);
        return;
    L5:
        r15 = 0.0f;
        r14 = 0.0f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull RecyclerView.State r12) {
        if (this.mSelected == null) goto L5;
        getSelectedDxDy(this.mTmpPosition);
        float[] r13 = this.mTmpPosition;
        float r5 = r13[0];
        float r14 = r13[1];
        float r15 = r5;
    L6:
        this.mCallback.onDrawOver(r10, r11, this.mSelected, this.mRecoverAnimations, this.mActionState, r15, r14);
        return;
    L5:
        r15 = 0.0f;
        r14 = 0.0f;
        goto L6
    }

    public void postDispatchSwipe(final RecoverAnimation r5, final int r10) {
        this.mRecyclerView.post(new AnonymousClass4(this, r5, r10));
    }

    public void removeChildDrawingOrderCallbackIfNecessary(View r5) {
        if (r5 != this.mOverdrawChild) goto L8;
        this.mOverdrawChild = null;
        if (this.mChildDrawingOrderCallback == null) goto L9;
        this.mRecyclerView.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }

    public boolean scrollIfNecessary() {
        if (this.mSelected != null) goto L6;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L6:
        long r5 = System.currentTimeMillis();
        long r10 = this.mDragScrollStartTimeInMs;
        if (r10 != Long.MIN_VALUE) goto L9;
        long r11 = 0;
    L10:
        RecyclerView.LayoutManager r12 = this.mRecyclerView.getLayoutManager();
        if (this.mTmpRect != null) goto L13;
        this.mTmpRect = new Rect();
    L13:
        r12.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if (r12.canScrollHorizontally() == false) goto L24;
        int r13 = (int) (this.mSelectedStartX + this.mDx);
        int r14 = (r13 - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
        float r15 = this.mDx;
        if (r15 >= 0.0f) goto L20;
        if (r14 >= 0) goto L20;
    L18:
        int r16 = r14;
    L26:
        if (r12.canScrollVertically() == false) goto L36;
        int r17 = (int) (this.mSelectedStartY + this.mDy);
        int r18 = (r17 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
        float r19 = this.mDy;
        if (r19 >= 0.0f) goto L32;
        if (r18 >= 0) goto L32;
    L30:
        int r20 = r18;
    L37:
        if (r16 == 0) goto L39;
        r16 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), r16, this.mRecyclerView.getWidth(), r11);
    L39:
        int r110 = r16;
        if (r20 == 0) goto L42;
        int r111 = r110;
        r20 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), r20, this.mRecyclerView.getHeight(), r11);
    L43:
        if (r111 != 0) goto L49;
        if (r20 != 0) goto L49;
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    L49:
        if (this.mDragScrollStartTimeInMs != Long.MIN_VALUE) goto L51;
        this.mDragScrollStartTimeInMs = r5;
    L51:
        this.mRecyclerView.scrollBy(r111, r20);
        return true;
    L42:
        r111 = r110;
    L32:
        if (r19 <= 0.0f) goto L36;
        r18 = ((this.mSelected.itemView.getHeight() + r17) + this.mTmpRect.bottom) - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
        if (r18 > 0) goto L30;
    L36:
        r20 = 0;
    L20:
        if (r15 <= 0.0f) goto L24;
        r14 = ((this.mSelected.itemView.getWidth() + r13) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
        if (r14 > 0) goto L18;
    L24:
        r16 = 0;
        goto L26
    L9:
        r11 = r5 - r10;
        goto L10
    }

    public void select(@Nullable RecyclerView.ViewHolder r24, int r25) {
        if (r24 == this.mSelected) goto L5;
    L7:
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        final int r5 = this.mActionState;
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
        final RecyclerView.ViewHolder r10 = this.mSelected;
        if (r10 != null) goto L16;
        boolean r11 = false;
    L41:
        if (r24 == null) goto L45;
        this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, r24) & r16) >> (this.mActionState * 8);
        this.mSelectedStartX = r24.itemView.getLeft();
        this.mSelectedStartY = r24.itemView.getTop();
        this.mSelected = r24;
        if (r25 != 2) goto L45;
        boolean r12 = false;
        r24.itemView.performHapticFeedback(0);
    L46:
        ViewParent r13 = this.mRecyclerView.getParent();
        if (r13 != null) goto L49;
    L53:
        if (r11 == true) goto L55;
        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    L55:
        this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
        this.mRecyclerView.invalidate();
        return;
    L49:
        if (this.mSelected == null) goto L51;
        boolean r14 = true;
    L52:
        r13.requestDisallowInterceptTouchEvent(r14);
        goto L53
    L51:
        r14 = r12;
    L45:
        r12 = false;
        goto L46
    L16:
        if (r10.itemView.getParent() == null) goto L38;
        if (r5 != 2) goto L19;
        int r15 = 0;
    L20:
        releaseVelocityTracker();
        if (r15 == 1) goto L31;
        if (r15 == 2) goto L31;
        if (r15 == 4) goto L30;
        if (r15 == 8) goto L30;
        if (r15 == 16) goto L30;
        if (r15 == 32) goto L30;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L32:
        if (r5 != 2) goto L34;
        int r19 = 8;
    L37:
        getSelectedDxDy(this.mTmpPosition);
        float[] r20 = this.mTmpPosition;
        final float r110 = r20[0];
        final float r21 = r20[1];
        final int r22 = r19;
        final int r23 = r15;
        final float r26 = r17;
        final float r27 = r18;
        RecoverAnimation r28 = new AnonymousClass3(this, r10, r22, r5, r110, r21, r26, r27, r23, r10);
        r28.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, r19, r17 - r110, r18 - r21));
        this.mRecoverAnimations.add(r28);
        r28.start();
        r11 = true;
    L39:
        this.mSelected = null;
        goto L41
    L34:
        if (r15 <= 0) goto L36;
        r19 = 2;
        goto L37
    L36:
        r19 = 4;
    L30:
        r18 = 0.0f;
        r17 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
    L31:
        r17 = 0.0f;
        r18 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
        goto L32
    L19:
        r15 = swipeIfNecessary(r10);
        goto L20
    L38:
        removeChildDrawingOrderCallbackIfNecessary(r10.itemView);
        this.mCallback.clearView(this.mRecyclerView, r10);
        r11 = false;
        goto L39
    L5:
        if (r25 != this.mActionState) goto L7;
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder r5) {
        if (this.mCallback.hasDragFlag(this.mRecyclerView, r5) == true) goto L7;
        Log.e(TAG, "Start drag has been called but dragging is not enabled");
        return;
    L7:
        if (r5.itemView.getParent() == this.mRecyclerView) goto L10;
        Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        return;
    L10:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r5, 2);
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder r5) {
        if (this.mCallback.hasSwipeFlag(this.mRecyclerView, r5) == true) goto L7;
        Log.e(TAG, "Start swipe has been called but swiping is not enabled");
        return;
    L7:
        if (r5.itemView.getParent() == this.mRecyclerView) goto L10;
        Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        return;
    L10:
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(r5, 1);
    }

    public void updateDxDy(MotionEvent r5, int r10, int r11) {
        float r12 = r5.getX(r11);
        float r13 = r5.getY(r11);
        float r14 = r12 - this.mInitialTouchX;
        this.mDx = r14;
        this.mDy = r13 - this.mInitialTouchY;
        if ((r10 & 4) != 0) goto L6;
        this.mDx = Math.max(0.0f, r14);
    L6:
        if ((r10 & 8) != 0) goto L9;
        this.mDx = Math.min(0.0f, this.mDx);
    L9:
        if ((r10 & 1) != 0) goto L12;
        this.mDy = Math.max(0.0f, this.mDy);
    L12:
        if ((r10 & 2) != 0) goto L15;
        this.mDy = Math.min(0.0f, this.mDy);
        return;
    }
}
