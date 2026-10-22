package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = null;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;

    @NonNull
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;

    @VisibleForTesting
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;

    @VisibleForTesting
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;

    @VisibleForTesting
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable;

        public Adapter() {
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
        }

        public final void bindViewHolder(@NonNull VH r10, int r11) {
            r10.mPosition = r11;
            if (hasStableIds() == false) goto L5;
            r10.mItemId = getItemId(r11);
        L5:
            r10.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(r10, r11, r10.getUnmodifiedPayloads());
            r10.clearPayload();
            ViewGroup.LayoutParams r12 = r10.itemView.getLayoutParams();
            if ((r12 instanceof LayoutParams) == false) goto L8;
            ((LayoutParams) r12).mInsetsDirty = true;
        L8:
            TraceCompat.endSection();
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup r10, int r11) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L9
            VH r12 = (VH) onCreateViewHolder(r10, r11);
            if (r12.itemView.getParent() != null) goto L8;
            r12.mItemViewType = r11;     // Catch: Throwable -> L9
            TraceCompat.endSection();
            return r12;
        L8:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }

        public abstract int getItemCount();

        public long getItemId(int r10) {
            return -1;
        }

        public int getItemViewType(int r10) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int r10) {
            this.mObservable.notifyItemRangeChanged(r10, 1);
        }

        public final void notifyItemChanged(int r10, @Nullable Object r11) {
            this.mObservable.notifyItemRangeChanged(r10, 1, r11);
        }

        public final void notifyItemInserted(int r10) {
            this.mObservable.notifyItemRangeInserted(r10, 1);
        }

        public final void notifyItemMoved(int r10, int r11) {
            this.mObservable.notifyItemMoved(r10, r11);
        }

        public final void notifyItemRangeChanged(int r10, int r11) {
            this.mObservable.notifyItemRangeChanged(r10, r11);
        }

        public final void notifyItemRangeChanged(int r10, int r11, @Nullable Object r12) {
            this.mObservable.notifyItemRangeChanged(r10, r11, r12);
        }

        public final void notifyItemRangeInserted(int r10, int r11) {
            this.mObservable.notifyItemRangeInserted(r10, r11);
        }

        public final void notifyItemRangeRemoved(int r10, int r11) {
            this.mObservable.notifyItemRangeRemoved(r10, r11);
        }

        public final void notifyItemRemoved(int r10) {
            this.mObservable.notifyItemRangeRemoved(r10, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView r10) {
        }

        public abstract void onBindViewHolder(@NonNull VH r10, int r11);

        public void onBindViewHolder(@NonNull VH r10, int r11, @NonNull List<Object> r12) {
            onBindViewHolder(r10, r11);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup r10, int r11);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView r10) {
        }

        public boolean onFailedToRecycleView(@NonNull VH r10) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH r10) {
        }

        public void onViewDetachedFromWindow(@NonNull VH r10) {
        }

        public void onViewRecycled(@NonNull VH r10) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver r10) {
            this.mObservable.registerObserver(r10);
        }

        public void setHasStableIds(boolean r10) {
            if (hasObservers() == true) goto L7;
            this.mHasStableIds = r10;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver r10) {
            this.mObservable.unregisterObserver(r10);
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            int r10 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r10)).onChanged();
            r10 = r10 - 1;
            goto L3
        }

        public void notifyItemMoved(int r10, int r11) {
            int r12 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r12 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r12)).onItemRangeMoved(r10, r11, 1);
            r12 = r12 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r10, int r11) {
            notifyItemRangeChanged(r10, r11, null);
        }

        public void notifyItemRangeChanged(int r10, int r11, @Nullable Object r12) {
            int r13 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r13 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r13)).onItemRangeChanged(r10, r11, r12);
            r13 = r13 - 1;
            goto L3
        }

        public void notifyItemRangeInserted(int r10, int r11) {
            int r12 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r12 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r12)).onItemRangeInserted(r10, r11);
            r12 = r12 - 1;
            goto L3
        }

        public void notifyItemRangeRemoved(int r10, int r11) {
            int r12 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r12 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r12)).onItemRangeRemoved(r10, r11);
            r12 = r12 - 1;
            goto L3
        }
    }

    public static abstract class AdapterDataObserver {
        public AdapterDataObserver() {
        }

        public void onChanged() {
        }

        public void onItemRangeChanged(int r10, int r11) {
        }

        public void onItemRangeChanged(int r10, int r11, @Nullable Object r12) {
            onItemRangeChanged(r10, r11);
        }

        public void onItemRangeInserted(int r10, int r11) {
        }

        public void onItemRangeMoved(int r10, int r11, int r12) {
        }

        public void onItemRangeRemoved(int r10, int r11) {
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int r10, int r11);
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        public EdgeEffectFactory() {
        }

        @NonNull
        protected EdgeEffect createEdgeEffect(@NonNull RecyclerView r10, int r11) {
            return new EdgeEffect(r10.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder r10);
        }

        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo() {
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder r10) {
                return setFrom(r10, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder r10, int r11) {
                View r12 = r10.itemView;
                this.left = r12.getLeft();
                this.top = r12.getTop();
                this.right = r12.getRight();
                this.bottom = r12.getBottom();
                return this;
            }
        }

        public ItemAnimator() {
            this.mListener = null;
            this.mFinishedListeners = new ArrayList();
            this.mAddDuration = 120;
            this.mRemoveDuration = 120;
            this.mMoveDuration = 250;
            this.mChangeDuration = 250;
        }

        static int buildAdapterChangeFlagsForAnimations(ViewHolder r10) {
            int r11 = r10.mFlags & 14;
            if (r10.isInvalid() == false) goto L7;
            return 4;
        L7:
            if ((r11 & 4) != 0) goto L14;
            int r12 = r10.getOldPosition();
            int r13 = r10.getAdapterPosition();
            if (r12 == (-1)) goto L15;
            if (r13 == (-1)) goto L16;
            if (r12 != r13) goto L13;
            return r11;
        L13:
            return r11 | 2048;
        L16:
            return r11;
        L15:
            return r11;
        L14:
            return r11;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder r10, @Nullable ItemHolderInfo r11, @NonNull ItemHolderInfo r12);

        public abstract boolean animateChange(@NonNull ViewHolder r10, @NonNull ViewHolder r11, @NonNull ItemHolderInfo r12, @NonNull ItemHolderInfo r13);

        public abstract boolean animateDisappearance(@NonNull ViewHolder r10, @NonNull ItemHolderInfo r11, @Nullable ItemHolderInfo r12);

        public abstract boolean animatePersistence(@NonNull ViewHolder r10, @NonNull ItemHolderInfo r11, @NonNull ItemHolderInfo r12);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder r10) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder r10, @NonNull List<Object> r11) {
            return canReuseUpdatedViewHolder(r10);
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder r10) {
            onAnimationFinished(r10);
            ItemAnimatorListener r11 = this.mListener;
            if (r11 == null) goto L6;
            r11.onAnimationFinished(r10);
            return;
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder r10) {
            onAnimationStarted(r10);
        }

        public final void dispatchAnimationsFinished() {
            int r10 = this.mFinishedListeners.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            this.mFinishedListeners.get(r11).onAnimationsFinished();
            r11 = r11 + 1;
            goto L3
        L5:
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder r10);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener r10) {
            boolean r11 = isRunning();
            if (r10 == null) goto L7;
            if (r11 == true) goto L6;
            r10.onAnimationsFinished();
            goto L7
        L6:
            this.mFinishedListeners.add(r10);
        L7:
            return r11;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder r10) {
        }

        public void onAnimationStarted(@NonNull ViewHolder r10) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State r10, @NonNull ViewHolder r11) {
            return obtainHolderInfo().setFrom(r11);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State r10, @NonNull ViewHolder r11, int r12, @NonNull List<Object> r13) {
            return obtainHolderInfo().setFrom(r11);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long r10) {
            this.mAddDuration = r10;
        }

        public void setChangeDuration(long r10) {
            this.mChangeDuration = r10;
        }

        void setListener(ItemAnimatorListener r10) {
            this.mListener = r10;
        }

        public void setMoveDuration(long r10) {
            this.mMoveDuration = r10;
        }

        public void setRemoveDuration(long r10) {
            this.mRemoveDuration = r10;
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        final /* synthetic */ RecyclerView this$0;

        ItemAnimatorRestoreListener(RecyclerView r10) {
            this.this$0 = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder r10) {
            r10.setIsRecyclable(true);
            if (r10.mShadowedHolder != null) goto L5;
        L7:
            r10.mShadowingHolder = null;
            if (r10.shouldBeKeptAsChild() == false) goto L10;
            return;
        L10:
            if (this.this$0.removeAnimatingView(r10.itemView) == false) goto L12;
            return;
        L12:
            if (r10.isTmpDetached() == false) goto L17;
            this.this$0.removeDetachedView(r10.itemView, false);
            return;
        L17:
            return;
        L5:
            if (r10.mShadowingHolder != null) goto L7;
            r10.mShadowedHolder = null;
            goto L7
        }
    }

    public static abstract class ItemDecoration {
        public ItemDecoration() {
        }

        @Deprecated
        public void getItemOffsets(@NonNull Rect r10, int r11, @NonNull RecyclerView r12) {
            r10.set(0, 0, 0, 0);
        }

        public void getItemOffsets(@NonNull Rect r10, @NonNull View r11, @NonNull RecyclerView r12, @NonNull State r13) {
            getItemOffsets(r10, ((LayoutParams) r11.getLayoutParams()).getViewLayoutPosition(), r12);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        }

        public void onDraw(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull State r12) {
            onDraw(r10, r11);
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        }

        public void onDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull State r12) {
            onDrawOver(r10, r11);
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;

        @Nullable
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public interface LayoutPrefetchRegistry {
            void addPosition(int r10, int r11);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;

            public Properties() {
            }
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback r10 = new AnonymousClass1(this);
            this.mHorizontalBoundCheckCallback = r10;
            ViewBoundsCheck.Callback r11 = new AnonymousClass2(this);
            this.mVerticalBoundCheckCallback = r11;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r10);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r11);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View r10, int r11, boolean r12) {
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r10);
            if (r12 == false) goto L5;
        L8:
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r13);
        L9:
            LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
            if (r13.wasReturnedFromScrap() == true) goto L30;
            if (r13.isScrap() == true) goto L30;
            if (r10.getParent() != this.mRecyclerView) goto L24;
            int r15 = this.mChildHelper.indexOfChild(r10);
            if (r11 != (-1)) goto L19;
            r11 = this.mChildHelper.getChildCount();
        L19:
            if (r15 == (-1)) goto L23;
            if (r15 == r11) goto L35;
            this.mRecyclerView.mLayout.moveView(r15, r11);
        L35:
            if (r14.mPendingInvalidate == false) goto L38;
            r13.itemView.invalidate();
            r14.mPendingInvalidate = false;
            return;
        L38:
            return;
        L23:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(r10) + this.mRecyclerView.exceptionLabel());
        L24:
            this.mChildHelper.addView(r10, r11, false);
            r14.mInsetsDirty = true;
            SmoothScroller r16 = this.mSmoothScroller;
            if (r16 == null) goto L35;
            if (r16.isRunning() == false) goto L35;
            this.mSmoothScroller.onChildAttachedToWindow(r10);
        L30:
            if (r13.isScrap() == false) goto L32;
            r13.unScrap();
        L33:
            this.mChildHelper.attachViewToParent(r10, r11, r10.getLayoutParams(), false);
            goto L35
        L32:
            r13.clearReturnedFromScrapFlag();
            goto L33
        L5:
            if (r13.isRemoved() == true) goto L8;
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r13);
            goto L9
        }

        public static int chooseSize(int r10, int r11, int r12) {
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = View.MeasureSpec.getSize(r10);
            if (r13 == Integer.MIN_VALUE) goto L9;
            if (r13 != 1073741824) goto L7;
            return r14;
        L7:
            return Math.max(r11, r12);
        L9:
            return Math.min(r14, Math.max(r11, r12));
        }

        private void detachViewInternal(int r10, @NonNull View r11) {
            this.mChildHelper.detachViewFromParent(r10);
        }

        public static int getChildMeasureSpec(int r10, int r11, int r12, int r13, boolean r14) {
            int r15 = Math.max(0, r10 - r12);
            if (r14 == false) goto L11;
            if (r13 >= 0) goto L12;
            if (r13 != (-1)) goto L21;
            if (r11 == Integer.MIN_VALUE) goto L14;
            if (r11 == 0) goto L21;
            if (r11 != 1073741824) goto L21;
        L14:
            r13 = r15;
        L23:
            return View.MeasureSpec.makeMeasureSpec(r13, r11);
        L21:
            r11 = 0;
            r13 = 0;
        L12:
            r11 = 1073741824;
            goto L23
        L11:
            if (r13 >= 0) goto L12;
            if (r13 == (-1)) goto L14;
            if (r13 != (-2)) goto L21;
            if (r11 == Integer.MIN_VALUE) goto L20;
            if (r11 == 1073741824) goto L20;
            r13 = r15;
            r11 = 0;
        L20:
            r13 = r15;
            r11 = Integer.MIN_VALUE;
            goto L23
        }

        @Deprecated
        public static int getChildMeasureSpec(int r10, int r11, int r12, boolean r13) {
            int r14 = r10 - r11;
            int r15 = 0;
            int r16 = Math.max(0, r14);
            if (r13 == false) goto L7;
            if (r12 >= 0) goto L8;
        L6:
            r12 = 0;
        L16:
            return View.MeasureSpec.makeMeasureSpec(r12, r15);
        L8:
            r15 = 1073741824;
            goto L16
        L7:
            if (r12 >= 0) goto L8;
            if (r12 != (-1)) goto L13;
            r12 = r16;
            goto L8
        L13:
            if (r12 != (-2)) goto L6;
            r15 = Integer.MIN_VALUE;
            r12 = r16;
            goto L16
        }

        private int[] getChildRectangleOnScreenScrollAmount(View r10, Rect r11) {
            int[] r12 = new int[2];
            int r13 = getPaddingLeft();
            int r14 = getPaddingTop();
            int r15 = getWidth() - getPaddingRight();
            int r16 = getHeight() - getPaddingBottom();
            int r17 = (r10.getLeft() + r11.left) - r10.getScrollX();
            int r18 = (r10.getTop() + r11.top) - r10.getScrollY();
            int r19 = r11.width() + r17;
            int r110 = r11.height() + r18;
            int r20 = r17 - r13;
            int r21 = Math.min(0, r20);
            int r22 = r18 - r14;
            int r23 = Math.min(0, r22);
            int r24 = r19 - r15;
            int r25 = Math.max(0, r24);
            int r111 = Math.max(0, r110 - r16);
            if (getLayoutDirection() != 1) goto L7;
            if (r25 != 0) goto L11;
            r25 = Math.max(r21, r24);
        L11:
            if (r23 != 0) goto L14;
            r23 = Math.min(r22, r111);
        L14:
            r12[0] = r25;
            r12[1] = r23;
            return r12;
        L7:
            if (r21 != 0) goto L10;
            r21 = Math.min(r20, r25);
        L10:
            r25 = r21;
            goto L11
        }

        public static Properties getProperties(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
            Properties r14 = new Properties();
            TypedArray r15 = r10.obtainStyledAttributes(r11, R.styleable.RecyclerView, r12, r13);
            r14.orientation = r15.getInt(R.styleable.RecyclerView_android_orientation, 1);
            r14.spanCount = r15.getInt(R.styleable.RecyclerView_spanCount, 1);
            r14.reverseLayout = r15.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            r14.stackFromEnd = r15.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            r15.recycle();
            return r14;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView r10, int r11, int r12) {
            View r13 = r10.getFocusedChild();
            if (r13 != null) goto L5;
            return false;
        L5:
            int r14 = getPaddingLeft();
            int r15 = getPaddingTop();
            int r16 = getWidth() - getPaddingRight();
            int r17 = getHeight() - getPaddingBottom();
            Rect r18 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r13, r18);
            if ((r18.left - r11) < r16) goto L8;
        L16:
            return false;
        L8:
            if ((r18.right - r11) <= r14) goto L16;
            if ((r18.top - r12) >= r17) goto L16;
            if ((r18.bottom - r12) <= r15) goto L16;
            return true;
        }

        private static boolean isMeasurementUpToDate(int r10, int r11, int r12) {
            int r13 = View.MeasureSpec.getMode(r11);
            int r14 = View.MeasureSpec.getSize(r11);
            if (r12 <= 0) goto L7;
            if (r10 == r12) goto L7;
            return false;
        L7:
            if (r13 == Integer.MIN_VALUE) goto L16;
            if (r13 != 0) goto L10;
            return true;
        L10:
            if (r13 == 1073741824) goto L12;
            return false;
        L12:
            if (r14 == r10) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r14 >= r10) goto L18;
            return false;
        L18:
            return true;
        }

        private void scrapOrRecycleView(Recycler r10, int r11, View r12) {
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r12);
            if (r13.shouldIgnore() == false) goto L6;
            return;
        L6:
            if (r13.isInvalid() == true) goto L8;
        L12:
            detachViewAt(r11);
            r10.scrapView(r12);
            this.mRecyclerView.mViewInfoStore.onViewDetached(r13);
            return;
        L8:
            if (r13.isRemoved() == true) goto L12;
            if (this.mRecyclerView.mAdapter.hasStableIds() == true) goto L12;
            removeViewAt(r11);
            r10.recycleViewHolderInternal(r13);
        }

        public void addDisappearingView(View r10) {
            addDisappearingView(r10, -1);
        }

        public void addDisappearingView(View r10, int r11) {
            addViewInt(r10, r11, true);
        }

        public void addView(View r10) {
            addView(r10, -1);
        }

        public void addView(View r10, int r11) {
            addViewInt(r10, r11, false);
        }

        public void assertInLayoutOrScroll(String r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.assertInLayoutOrScroll(r10);
            return;
        }

        public void assertNotInLayoutOrScroll(String r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.assertNotInLayoutOrScroll(r10);
            return;
        }

        public void attachView(@NonNull View r10) {
            attachView(r10, -1);
        }

        public void attachView(@NonNull View r10, int r11) {
            attachView(r10, r11, (LayoutParams) r10.getLayoutParams());
        }

        public void attachView(@NonNull View r10, int r11, LayoutParams r12) {
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r10);
            if (r13.isRemoved() == false) goto L5;
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r13);
        L6:
            this.mChildHelper.attachViewToParent(r10, r11, r12, r13.isRemoved());
            return;
        L5:
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r13);
            goto L6
        }

        public void calculateItemDecorationsForChild(@NonNull View r10, @NonNull Rect r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (r12 != null) goto L6;
            r11.set(0, 0, 0, 0);
            return;
        L6:
            r11.set(r12.getItemDecorInsetsForChild(r10));
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams r10) {
            if (r10 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public void collectAdjacentPrefetchPositions(int r10, int r11, State r12, LayoutPrefetchRegistry r13) {
        }

        public void collectInitialPrefetchPositions(int r10, LayoutPrefetchRegistry r11) {
        }

        public int computeHorizontalScrollExtent(@NonNull State r10) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State r10) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State r10) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State r10) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State r10) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State r10) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler r10) {
            int r11 = getChildCount() - 1;
        L3:
            if (r11 < 0) goto L5;
            scrapOrRecycleView(r10, r11, getChildAt(r11));
            r11 = r11 - 1;
            goto L3
        }

        public void detachAndScrapView(@NonNull View r10, @NonNull Recycler r11) {
            scrapOrRecycleView(r11, this.mChildHelper.indexOfChild(r10), r10);
        }

        public void detachAndScrapViewAt(int r10, @NonNull Recycler r11) {
            scrapOrRecycleView(r11, r10, getChildAt(r10));
        }

        public void detachView(@NonNull View r10) {
            int r11 = this.mChildHelper.indexOfChild(r10);
            if (r11 < 0) goto L6;
            detachViewInternal(r11, r10);
            return;
        }

        public void detachViewAt(int r10) {
            detachViewInternal(r10, getChildAt(r10));
        }

        void dispatchAttachedToWindow(RecyclerView r10) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(r10);
        }

        void dispatchDetachedFromWindow(RecyclerView r10, Recycler r11) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(r10, r11);
        }

        public void endAnimation(View r10) {
            ItemAnimator r11 = this.mRecyclerView.mItemAnimator;
            if (r11 == null) goto L6;
            r11.endAnimation(RecyclerView.getChildViewHolderInt(r10));
            return;
        }

        @Nullable
        public View findContainingItemView(@NonNull View r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 != null) goto L5;
            return null;
        L5:
            View r12 = r11.findContainingItemView(r10);
            if (r12 != null) goto L9;
            return null;
        L9:
            if (this.mChildHelper.isHidden(r12) == false) goto L11;
            return null;
        L11:
            return r12;
        }

        @Nullable
        public View findViewByPosition(int r10) {
            int r11 = getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L17;
            View r13 = getChildAt(r12);
            ViewHolder r14 = RecyclerView.getChildViewHolderInt(r13);
            if (r14 == null) goto L16;
            if (r14.getLayoutPosition() != r10) goto L16;
            if (r14.shouldIgnore() == true) goto L16;
            if (this.mRecyclerView.mState.isPreLayout() == true) goto L15;
            if (r14.isRemoved() == true) goto L16;
        L15:
            return r13;
        L16:
            r12 = r12 + 1;
            goto L3
        L17:
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context r10, AttributeSet r11) {
            return new LayoutParams(r10, r11);
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
            if ((r10 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r10);
        L7:
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
        L11:
            return new LayoutParams(r10);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int r10) {
            ChildHelper r11 = this.mChildHelper;
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.getChildAt(r10);
        }

        public int getChildCount() {
            ChildHelper r10 = this.mChildHelper;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getChildCount();
        }

        public boolean getClipToPadding() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.mClipToPadding == false) goto L7;
            return true;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler r10, @NonNull State r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (r12 != null) goto L5;
            return 1;
        L5:
            if (r12.mAdapter != null) goto L8;
            return 1;
        L8:
            if (canScrollHorizontally() == true) goto L10;
            return 1;
        L10:
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(@NonNull View r10) {
            return r10.getBottom() + getBottomDecorationHeight(r10);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View r10, @NonNull Rect r11) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r10, r11);
        }

        public int getDecoratedLeft(@NonNull View r10) {
            return r10.getLeft() - getLeftDecorationWidth(r10);
        }

        public int getDecoratedMeasuredHeight(@NonNull View r10) {
            Rect r11 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            return (r10.getMeasuredHeight() + r11.top) + r11.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View r10) {
            Rect r11 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            return (r10.getMeasuredWidth() + r11.left) + r11.right;
        }

        public int getDecoratedRight(@NonNull View r10) {
            return r10.getRight() + getRightDecorationWidth(r10);
        }

        public int getDecoratedTop(@NonNull View r10) {
            return r10.getTop() - getTopDecorationHeight(r10);
        }

        @Nullable
        public View getFocusedChild() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
            return null;
        L5:
            View r11 = r10.getFocusedChild();
            if (r11 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.mChildHelper.isHidden(r11) == true) goto L11;
            return r11;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L5;
            Adapter r11 = r10.getAdapter();
        L6:
            if (r11 != null) goto L10;
            return 0;
        L10:
            return r11.getItemCount();
        L5:
            r11 = null;
            goto L6
        }

        public int getItemViewType(@NonNull View r10) {
            return RecyclerView.getChildViewHolderInt(r10).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingBottom();
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingEnd(r10);
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingLeft();
        }

        @Px
        public int getPaddingRight() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingRight();
        }

        @Px
        public int getPaddingStart() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingStart(r10);
        }

        @Px
        public int getPaddingTop() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingTop();
        }

        public int getPosition(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler r10, @NonNull State r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (r12 != null) goto L5;
            return 1;
        L5:
            if (r12.mAdapter != null) goto L8;
            return 1;
        L8:
            if (canScrollVertically() == true) goto L10;
            return 1;
        L10:
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler r10, @NonNull State r11) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View r10, boolean r11, @NonNull Rect r12) {
            if (r11 == false) goto L4;
            Rect r13 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            r12.set(-r13.left, -r13.top, r10.getWidth() + r13.right, r10.getHeight() + r13.bottom);
        L6:
            if (this.mRecyclerView == null) goto L12;
            Matrix r14 = r10.getMatrix();
            if (r14 == null) goto L12;
            if (r14.isIdentity() == true) goto L12;
            RectF r15 = this.mRecyclerView.mTempRectF;
            r15.set(r12);
            r14.mapRect(r15);
            r12.set((int) Math.floor(r15.left), (int) Math.floor(r15.top), (int) Math.ceil(r15.right), (int) Math.ceil(r15.bottom));
        L12:
            r12.offset(r10.getLeft(), r10.getTop());
            return;
        L4:
            r12.set(0, 0, r10.getWidth(), r10.getHeight());
            goto L6
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        boolean hasFlexibleChildInBothOrientations() {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            ViewGroup.LayoutParams r12 = getChildAt(r11).getLayoutParams();
            if (r12.width >= 0) goto L10;
            if (r12.height >= 0) goto L10;
            return true;
        L10:
            r11 = r11 + 1;
            goto L3
        L11:
            return false;
        }

        public boolean hasFocus() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.hasFocus() == false) goto L7;
            return true;
        }

        public void ignoreView(@NonNull View r10) {
            ViewParent r11 = r10.getParent();
            RecyclerView r12 = this.mRecyclerView;
            if (r11 != r12) goto L9;
            if (r12.indexOfChild(r10) == (-1)) goto L9;
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r10);
            r13.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(r13);
            return;
        L9:
            throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.isFocused() == false) goto L7;
            return true;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler r10, @NonNull State r11) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller r10 = this.mSmoothScroller;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.isRunning() == false) goto L7;
            return true;
        }

        public boolean isViewPartiallyVisible(@NonNull View r10, boolean r11, boolean r12) {
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(r10, 24579) == true) goto L5;
        L7:
            boolean r13 = false;
        L8:
            if (r11 == false) goto L11;
            return r13;
        L11:
            return !r13;
        L5:
            if (this.mVerticalBoundCheck.isViewWithinBoundFlags(r10, 24579) == false) goto L7;
            r13 = true;
            goto L8
        }

        public void layoutDecorated(@NonNull View r10, int r11, int r12, int r13, int r14) {
            Rect r15 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            r10.layout(r11 + r15.left, r12 + r15.top, r13 - r15.right, r14 - r15.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View r10, int r11, int r12, int r13, int r14) {
            LayoutParams r15 = (LayoutParams) r10.getLayoutParams();
            Rect r16 = r15.mDecorInsets;
            r10.layout((r11 + r16.left) + ((ViewGroup.MarginLayoutParams) r15).leftMargin, (r12 + r16.top) + ((ViewGroup.MarginLayoutParams) r15).topMargin, (r13 - r16.right) - ((ViewGroup.MarginLayoutParams) r15).rightMargin, (r14 - r16.bottom) - ((ViewGroup.MarginLayoutParams) r15).bottomMargin);
        }

        public void measureChild(@NonNull View r10, int r11, int r12) {
            LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
            Rect r14 = this.mRecyclerView.getItemDecorInsetsForChild(r10);
            int r15 = r11 + (r14.left + r14.right);
            int r16 = r12 + (r14.top + r14.bottom);
            int r17 = getChildMeasureSpec(getWidth(), getWidthMode(), (getPaddingLeft() + getPaddingRight()) + r15, ((ViewGroup.MarginLayoutParams) r13).width, canScrollHorizontally());
            int r18 = getChildMeasureSpec(getHeight(), getHeightMode(), (getPaddingTop() + getPaddingBottom()) + r16, ((ViewGroup.MarginLayoutParams) r13).height, canScrollVertically());
            if (shouldMeasureChild(r10, r17, r18, r13) == false) goto L6;
            r10.measure(r17, r18);
            return;
        }

        public void measureChildWithMargins(@NonNull View r10, int r11, int r12) {
            LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
            Rect r14 = this.mRecyclerView.getItemDecorInsetsForChild(r10);
            int r15 = r11 + (r14.left + r14.right);
            int r16 = r12 + (r14.top + r14.bottom);
            int r17 = getChildMeasureSpec(getWidth(), getWidthMode(), (((getPaddingLeft() + getPaddingRight()) + ((ViewGroup.MarginLayoutParams) r13).leftMargin) + ((ViewGroup.MarginLayoutParams) r13).rightMargin) + r15, ((ViewGroup.MarginLayoutParams) r13).width, canScrollHorizontally());
            int r18 = getChildMeasureSpec(getHeight(), getHeightMode(), (((getPaddingTop() + getPaddingBottom()) + ((ViewGroup.MarginLayoutParams) r13).topMargin) + ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + r16, ((ViewGroup.MarginLayoutParams) r13).height, canScrollVertically());
            if (shouldMeasureChild(r10, r17, r18, r13) == false) goto L6;
            r10.measure(r17, r18);
            return;
        }

        public void moveView(int r10, int r11) {
            View r12 = getChildAt(r10);
            if (r12 == null) goto L7;
            detachViewAt(r10);
            attachView(r12, r11);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r10 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(@Px int r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.offsetChildrenHorizontal(r10);
            return;
        }

        public void offsetChildrenVertical(@Px int r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.offsetChildrenVertical(r10);
            return;
        }

        public void onAdapterChanged(@Nullable Adapter r10, @Nullable Adapter r11) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView r10, @NonNull ArrayList<View> r11, int r12, int r13) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView r10) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView r10) {
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView r10, Recycler r11) {
            onDetachedFromWindow(r10);
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View r10, int r11, @NonNull Recycler r12, @NonNull State r13) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
            RecyclerView r11 = this.mRecyclerView;
            onInitializeAccessibilityEvent(r11.mRecycler, r11.mState, r10);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler r10, @NonNull State r11, @NonNull AccessibilityEvent r12) {
            RecyclerView r13 = this.mRecyclerView;
            if (r13 == null) goto L20;
            if (r12 == null) goto L22;
            boolean r14 = true;
            if (r13.canScrollVertically(1) == false) goto L9;
        L16:
            r12.setScrollable(r14);
            Adapter r15 = this.mRecyclerView.mAdapter;
            if (r15 == null) goto L21;
            r12.setItemCount(r15.getItemCount());
            return;
        L21:
            return;
        L9:
            if (this.mRecyclerView.canScrollVertically(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(1) == true) goto L16;
            r14 = false;
            goto L16
        L22:
            return;
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r10) {
            RecyclerView r11 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(r11.mRecycler, r11.mState, r10);
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler r10, @NonNull State r11, @NonNull AccessibilityNodeInfoCompat r12) {
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L5;
        L6:
            r12.addAction(8192);
            r12.setScrollable(true);
        L8:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L10;
        L11:
            r12.addAction(4096);
            r12.setScrollable(true);
        L12:
            r12.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(r10, r11), getColumnCountForAccessibility(r10, r11), isLayoutHierarchical(r10, r11), getSelectionModeForAccessibility(r10, r11)));
            return;
        L10:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        void onInitializeAccessibilityNodeInfoForItem(View r10, AccessibilityNodeInfoCompat r11) {
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r10);
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.isRemoved() == false) goto L7;
            return;
        L7:
            if (this.mChildHelper.isHidden(r12.itemView) == true) goto L12;
            RecyclerView r13 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(r13.mRecycler, r13.mState, r10, r11);
            return;
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler r10, @NonNull State r11, @NonNull View r12, @NonNull AccessibilityNodeInfoCompat r13) {
            int r14 = 0;
            if (canScrollVertically() == false) goto L5;
            int r15 = getPosition(r12);
        L7:
            if (canScrollHorizontally() == false) goto L9;
            r14 = getPosition(r12);
        L9:
            r13.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r15, 1, r14, 1, false, false));
            return;
        L5:
            r15 = 0;
            goto L7
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View r10, int r11) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView r10, int r11, int r12) {
        }

        public void onItemsChanged(@NonNull RecyclerView r10) {
        }

        public void onItemsMoved(@NonNull RecyclerView r10, int r11, int r12, int r13) {
        }

        public void onItemsRemoved(@NonNull RecyclerView r10, int r11, int r12) {
        }

        public void onItemsUpdated(@NonNull RecyclerView r10, int r11, int r12) {
        }

        public void onItemsUpdated(@NonNull RecyclerView r10, int r11, int r12, @Nullable Object r13) {
            onItemsUpdated(r10, r11, r12);
        }

        public void onLayoutChildren(Recycler r10, State r11) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(State r10) {
        }

        public void onMeasure(@NonNull Recycler r10, @NonNull State r11, int r12, int r13) {
            this.mRecyclerView.defaultOnMeasure(r12, r13);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView r10, @NonNull View r11, @Nullable View r12) {
            if (isSmoothScrolling() == false) goto L5;
        L8:
            return true;
        L5:
            if (r10.isComputingLayout() == true) goto L8;
            return false;
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView r10, @NonNull State r11, @NonNull View r12, @Nullable View r13) {
            return onRequestChildFocus(r10, r12, r13);
        }

        public void onRestoreInstanceState(Parcelable r10) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int r10) {
        }

        void onSmoothScrollerStopped(SmoothScroller r10) {
            if (this.mSmoothScroller != r10) goto L6;
            this.mSmoothScroller = null;
            return;
        }

        boolean performAccessibilityAction(int r10, @Nullable Bundle r11) {
            RecyclerView r12 = this.mRecyclerView;
            return performAccessibilityAction(r12.mRecycler, r12.mState, r10, r11);
        }

        public boolean performAccessibilityAction(@NonNull Recycler r10, @NonNull State r11, int r12, @Nullable Bundle r13) {
            RecyclerView r14 = this.mRecyclerView;
            if (r14 != null) goto L6;
            return false;
        L6:
            if (r12 == 4096) goto L18;
            if (r12 == 8192) goto L11;
            int r15 = 0;
            int r16 = 0;
        L26:
            if (r16 != 0) goto L29;
            if (r15 != 0) goto L29;
            return false;
        L29:
            this.mRecyclerView.smoothScrollBy(r15, r16, null, Integer.MIN_VALUE, true);
            return true;
        L11:
            if (r14.canScrollVertically(-1) == false) goto L13;
            int r17 = -((getHeight() - getPaddingTop()) - getPaddingBottom());
        L15:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L25;
            int r18 = -((getWidth() - getPaddingLeft()) - getPaddingRight());
        L24:
            r16 = r17;
            r15 = r18;
        L25:
            r16 = r17;
            r15 = 0;
            goto L26
        L13:
            r17 = 0;
            goto L15
        L18:
            if (r14.canScrollVertically(1) == false) goto L20;
            r17 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        L22:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L25;
            r18 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            goto L24
        L20:
            r17 = 0;
            goto L22
        }

        boolean performAccessibilityActionForItem(@NonNull View r10, int r11, @Nullable Bundle r12) {
            RecyclerView r13 = this.mRecyclerView;
            return performAccessibilityActionForItem(r13.mRecycler, r13.mState, r10, r11, r12);
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler r10, @NonNull State r11, @NonNull View r12, int r13, @Nullable Bundle r14) {
            return false;
        }

        public void postOnAnimation(Runnable r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            ViewCompat.postOnAnimation(r11, r10);
            return;
        }

        public void removeAllViews() {
            int r10 = getChildCount() - 1;
        L3:
            if (r10 < 0) goto L5;
            this.mChildHelper.removeViewAt(r10);
            r10 = r10 - 1;
            goto L3
        }

        public void removeAndRecycleAllViews(@NonNull Recycler r10) {
            int r11 = getChildCount() - 1;
        L3:
            if (r11 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(getChildAt(r11)).shouldIgnore() == true) goto L7;
            removeAndRecycleViewAt(r11, r10);
        L7:
            r11 = r11 - 1;
            goto L3
        }

        void removeAndRecycleScrapInt(Recycler r10) {
            int r11 = r10.getScrapCount();
            int r12 = r11 - 1;
        L3:
            if (r12 < 0) goto L15;
            View r13 = r10.getScrapViewAt(r12);
            ViewHolder r14 = RecyclerView.getChildViewHolderInt(r13);
            if (r14.shouldIgnore() == true) goto L14;
            r14.setIsRecyclable(false);
            if (r14.isTmpDetached() == false) goto L10;
            this.mRecyclerView.removeDetachedView(r13, false);
        L10:
            ItemAnimator r15 = this.mRecyclerView.mItemAnimator;
            if (r15 == null) goto L13;
            r15.endAnimation(r14);
        L13:
            r14.setIsRecyclable(true);
            r10.quickRecycleScrapView(r13);
        L14:
            r12 = r12 - 1;
            goto L3
        L15:
            r10.clearScrap();
            if (r11 <= 0) goto L22;
            this.mRecyclerView.invalidate();
            return;
        }

        public void removeAndRecycleView(@NonNull View r10, @NonNull Recycler r11) {
            removeView(r10);
            r11.recycleView(r10);
        }

        public void removeAndRecycleViewAt(int r10, @NonNull Recycler r11) {
            View r12 = getChildAt(r10);
            removeViewAt(r10);
            r11.recycleView(r12);
        }

        public boolean removeCallbacks(Runnable r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 != null) goto L5;
            return false;
        L5:
            return r11.removeCallbacks(r10);
        }

        public void removeDetachedView(@NonNull View r10) {
            this.mRecyclerView.removeDetachedView(r10, false);
        }

        public void removeView(View r10) {
            this.mChildHelper.removeView(r10);
        }

        public void removeViewAt(int r10) {
            if (getChildAt(r10) == null) goto L6;
            this.mChildHelper.removeViewAt(r10);
            return;
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r10, @NonNull View r11, @NonNull Rect r12, boolean r13) {
            return requestChildRectangleOnScreen(r10, r11, r12, r13, false);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r10, @NonNull View r11, @NonNull Rect r12, boolean r13, boolean r14) {
            int[] r15 = getChildRectangleOnScreenScrollAmount(r11, r12);
            int r16 = r15[0];
            int r17 = r15[1];
            if (r14 == true) goto L5;
        L6:
            if (r16 != 0) goto L10;
            if (r17 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r13 == false) goto L12;
            r10.scrollBy(r16, r17);
        L13:
            return true;
        L12:
            r10.smoothScrollBy(r16, r17);
            goto L13
        L5:
            if (isFocusedChildVisibleAfterScrolling(r10, r16, r17) == false) goto L9;
            goto L6
        }

        public void requestLayout() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L6;
            r10.requestLayout();
            return;
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int r10, Recycler r11, State r12) {
            return 0;
        }

        public void scrollToPosition(int r10) {
        }

        public int scrollVerticallyBy(int r10, Recycler r11, State r12) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean r10) {
            this.mAutoMeasure = r10;
        }

        void setExactMeasureSpecsFrom(RecyclerView r10) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(r10.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r10.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean r10) {
            if (r10 == this.mItemPrefetchEnabled) goto L8;
            this.mItemPrefetchEnabled = r10;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L9;
            r11.mRecycler.updateViewCacheSize();
            return;
        L9:
            return;
        }

        void setMeasureSpecs(int r10, int r11) {
            this.mWidth = View.MeasureSpec.getSize(r10);
            int r12 = View.MeasureSpec.getMode(r10);
            this.mWidthMode = r12;
            if (r12 == 0) goto L5;
        L7:
            this.mHeight = View.MeasureSpec.getSize(r11);
            int r13 = View.MeasureSpec.getMode(r11);
            this.mHeightMode = r13;
            if (r13 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L14;
            this.mHeight = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L7;
            this.mWidth = 0;
            goto L7
        }

        public void setMeasuredDimension(int r10, int r11) {
            RecyclerView.access$300(this.mRecyclerView, r10, r11);
        }

        public void setMeasuredDimension(Rect r10, int r11, int r12) {
            int r13 = (r10.width() + getPaddingLeft()) + getPaddingRight();
            int r14 = (r10.height() + getPaddingTop()) + getPaddingBottom();
            setMeasuredDimension(chooseSize(r11, r13, getMinimumWidth()), chooseSize(r12, r14, getMinimumHeight()));
        }

        void setMeasuredDimensionFromChildren(int r10, int r11) {
            int r12 = getChildCount();
            if (r12 != 0) goto L6;
            this.mRecyclerView.defaultOnMeasure(r10, r11);
            return;
        L6:
            int r13 = 0;
            int r14 = Integer.MIN_VALUE;
            int r15 = Integer.MAX_VALUE;
            int r16 = Integer.MAX_VALUE;
            int r17 = Integer.MIN_VALUE;
        L7:
            if (r13 >= r12) goto L21;
            View r18 = getChildAt(r13);
            Rect r19 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r18, r19);
            int r20 = r19.left;
            if (r20 >= r15) goto L11;
            r15 = r20;
        L11:
            int r21 = r19.right;
            if (r21 <= r14) goto L14;
            r14 = r21;
        L14:
            int r22 = r19.top;
            if (r22 >= r16) goto L17;
            r16 = r22;
        L17:
            int r23 = r19.bottom;
            if (r23 <= r17) goto L20;
            r17 = r23;
        L20:
            r13 = r13 + 1;
            goto L7
        L21:
            this.mRecyclerView.mTempRect.set(r15, r16, r14, r17);
            setMeasuredDimension(this.mRecyclerView.mTempRect, r10, r11);
        }

        public void setMeasurementCacheEnabled(boolean r10) {
            this.mMeasurementCacheEnabled = r10;
        }

        void setRecyclerView(RecyclerView r10) {
            if (r10 != null) goto L4;
            this.mRecyclerView = null;
            this.mChildHelper = null;
            int r11 = 0;
            this.mWidth = 0;
        L5:
            this.mHeight = r11;
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
            return;
        L4:
            this.mRecyclerView = r10;
            this.mChildHelper = r10.mChildHelper;
            this.mWidth = r10.getWidth();
            r11 = r10.getHeight();
            goto L5
        }

        boolean shouldMeasureChild(View r10, int r11, int r12, LayoutParams r13) {
            if (r10.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.mMeasurementCacheEnabled == false) goto L12;
            if (isMeasurementUpToDate(r10.getWidth(), r11, ((ViewGroup.MarginLayoutParams) r13).width) == false) goto L12;
            if (isMeasurementUpToDate(r10.getHeight(), r12, ((ViewGroup.MarginLayoutParams) r13).height) == false) goto L12;
            return false;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        boolean shouldReMeasureChild(View r10, int r11, int r12, LayoutParams r13) {
            if (this.mMeasurementCacheEnabled == true) goto L5;
        L10:
            return true;
        L5:
            if (isMeasurementUpToDate(r10.getMeasuredWidth(), r11, ((ViewGroup.MarginLayoutParams) r13).width) == false) goto L10;
            if (isMeasurementUpToDate(r10.getMeasuredHeight(), r12, ((ViewGroup.MarginLayoutParams) r13).height) == false) goto L10;
            return false;
        }

        public void smoothScrollToPosition(RecyclerView r10, State r11, int r12) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller r10) {
            SmoothScroller r11 = this.mSmoothScroller;
            if (r11 == null) goto L8;
            if (r10 == r11) goto L8;
            if (r11.isRunning() == false) goto L8;
            this.mSmoothScroller.stop();
        L8:
            this.mSmoothScroller = r10;
            r10.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            r11.stopIgnoring();
            r11.resetInternal();
            r11.addFlags(4);
        }

        void stopSmoothScroller() {
            SmoothScroller r10 = this.mSmoothScroller;
            if (r10 == null) goto L6;
            r10.stop();
            return;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View r10);

        void onChildViewDetachedFromWindow(@NonNull View r10);
    }

    public static abstract class OnFlingListener {
        public OnFlingListener() {
        }

        public abstract boolean onFling(int r10, int r11);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11);

        void onRequestDisallowInterceptTouchEvent(boolean r10);

        void onTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11);
    }

    public static abstract class OnScrollListener {
        public OnScrollListener() {
        }

        public void onScrollStateChanged(@NonNull RecyclerView r10, int r11) {
        }

        public void onScrolled(@NonNull RecyclerView r10, int r11, int r12) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount;
        SparseArray<ScrapData> mScrap;

        static class ScrapData {
            long mBindRunningAverageNs;
            long mCreateRunningAverageNs;
            int mMaxScrap;
            final ArrayList<ViewHolder> mScrapHeap;

            ScrapData() {
                this.mScrapHeap = new ArrayList();
                this.mMaxScrap = 5;
                this.mCreateRunningAverageNs = 0;
                this.mBindRunningAverageNs = 0;
            }
        }

        public RecycledViewPool() {
            this.mScrap = new SparseArray();
            this.mAttachCount = 0;
        }

        private ScrapData getScrapDataForType(int r10) {
            ScrapData r11 = this.mScrap.get(r10);
            if (r11 != null) goto L6;
            ScrapData r12 = new ScrapData();
            this.mScrap.put(r10, r12);
            return r12;
        L6:
            return r11;
        }

        void attach() {
            this.mAttachCount++;
        }

        public void clear() {
            int r10 = 0;
        L4:
            if (r10 >= this.mScrap.size()) goto L6;
            this.mScrap.valueAt(r10).mScrapHeap.clear();
            r10 = r10 + 1;
            goto L4
        }

        void detach() {
            this.mAttachCount--;
        }

        void factorInBindTime(int r10, long r11) {
            ScrapData r12 = getScrapDataForType(r10);
            r12.mBindRunningAverageNs = runningAverage(r12.mBindRunningAverageNs, r11);
        }

        void factorInCreateTime(int r10, long r11) {
            ScrapData r12 = getScrapDataForType(r10);
            r12.mCreateRunningAverageNs = runningAverage(r12.mCreateRunningAverageNs, r11);
        }

        @Nullable
        public ViewHolder getRecycledView(int r10) {
            ScrapData r11 = this.mScrap.get(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if (r11.mScrapHeap.isEmpty() == true) goto L17;
            ArrayList<ViewHolder> r12 = r11.mScrapHeap;
            int r13 = r12.size() - 1;
        L7:
            if (r13 < 0) goto L18;
            if (r12.get(r13).isAttachedToTransitionOverlay() == false) goto L11;
            r13 = r13 - 1;
            goto L7
        L11:
            return r12.remove(r13);
        L18:
            return null;
        L17:
            return null;
        }

        public int getRecycledViewCount(int r10) {
            return getScrapDataForType(r10).mScrapHeap.size();
        }

        void onAdapterChanged(Adapter r10, Adapter r11, boolean r12) {
            if (r10 == null) goto L4;
            detach();
        L4:
            if (r12 == false) goto L6;
        L8:
            if (r11 == null) goto L11;
            attach();
            return;
        L11:
            return;
        L6:
            if (this.mAttachCount != 0) goto L8;
            clear();
            goto L8
        }

        public void putRecycledView(ViewHolder r10) {
            int r11 = r10.getItemViewType();
            ArrayList<ViewHolder> r12 = getScrapDataForType(r11).mScrapHeap;
            if (this.mScrap.get(r11).mMaxScrap > r12.size()) goto L5;
            return;
        L5:
            r10.resetInternal();
            r12.add(r10);
        }

        long runningAverage(long r10, long r11) {
            if (r10 != 0) goto L6;
            return r11;
        L6:
            return ((r10 / 4) * 3) + (r11 / 4);
        }

        public void setMaxRecycledViews(int r10, int r11) {
            ScrapData r12 = getScrapDataForType(r10);
            r12.mMaxScrap = r11;
            ArrayList<ViewHolder> r13 = r12.mScrapHeap;
        L4:
            if (r13.size() <= r11) goto L6;
            r13.remove(r13.size() - 1);
            goto L4
        }

        int size() {
            int r10 = 0;
            int r11 = 0;
        L4:
            if (r10 >= this.mScrap.size()) goto L9;
            ArrayList<ViewHolder> r12 = this.mScrap.valueAt(r10).mScrapHeap;
            if (r12 == null) goto L8;
            r11 = r11 + r12.size();
        L8:
            r10 = r10 + 1;
            goto L4
        L9:
            return r11;
        }

        boolean willBindInTime(int r10, long r11, long r12) {
            long r13 = getScrapDataForType(r10).mBindRunningAverageNs;
            if (r13 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r11 + r13) < r12) goto L8;
            return false;
        }

        boolean willCreateInTime(int r10, long r11, long r12) {
            long r13 = getScrapDataForType(r10).mCreateRunningAverageNs;
            if (r13 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r11 + r13) < r12) goto L8;
            return false;
        }
    }

    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews;
        ArrayList<ViewHolder> mChangedScrap;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax;
        final /* synthetic */ RecyclerView this$0;

        public Recycler(RecyclerView r10) {
            this.this$0 = r10;
            ArrayList<ViewHolder> r11 = new ArrayList();
            this.mAttachedScrap = r11;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(r11);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder r10) {
            if (this.this$0.isAccessibilityEnabled() == false) goto L15;
            View r11 = r10.itemView;
            if (ViewCompat.getImportantForAccessibility(r11) != 0) goto L7;
            ViewCompat.setImportantForAccessibility(r11, 1);
        L7:
            RecyclerViewAccessibilityDelegate r12 = this.this$0.mAccessibilityDelegate;
            if (r12 != null) goto L10;
            return;
        L10:
            AccessibilityDelegateCompat r13 = r12.getItemDelegate();
            if ((r13 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L13;
            ((RecyclerViewAccessibilityDelegate.ItemDelegate) r13).saveOriginalDelegate(r11);
        L13:
            ViewCompat.setAccessibilityDelegate(r11, r13);
            return;
        }

        private void invalidateDisplayListInt(ViewGroup r10, boolean r11) {
            int r12 = r10.getChildCount() - 1;
        L3:
            if (r12 < 0) goto L8;
            View r13 = r10.getChildAt(r12);
            if ((r13 instanceof ViewGroup) == false) goto L7;
            invalidateDisplayListInt((ViewGroup) r13, true);
        L7:
            r12 = r12 - 1;
            goto L3
        L8:
            if (r11 == true) goto L11;
            return;
        L11:
            if (r10.getVisibility() != 4) goto L13;
            r10.setVisibility(0);
            r10.setVisibility(4);
            return;
        L13:
            int r14 = r10.getVisibility();
            r10.setVisibility(4);
            r10.setVisibility(r14);
        }

        private void invalidateDisplayListInt(ViewHolder r10) {
            View r11 = r10.itemView;
            if ((r11 instanceof ViewGroup) == false) goto L6;
            invalidateDisplayListInt((ViewGroup) r11, false);
            return;
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder r10, int r11, int r12, long r13) {
            r10.mOwnerRecyclerView = this.this$0;
            int r14 = r10.getItemViewType();
            long r15 = this.this$0.getNanoTime();
            if (r13 != Long.MAX_VALUE) goto L5;
        L8:
            this.this$0.mAdapter.bindViewHolder(r10, r11);
            long r16 = this.this$0.getNanoTime();
            this.mRecyclerPool.factorInBindTime(r10.getItemViewType(), r16 - r15);
            attachAccessibilityDelegateOnBind(r10);
            if (this.this$0.mState.isPreLayout() == false) goto L13;
            r10.mPreLayoutPosition = r12;
            return true;
        L13:
            return true;
        L5:
            if (this.mRecyclerPool.willBindInTime(r14, r15, r13) == true) goto L8;
            return false;
        }

        void addViewHolderToRecycledViewPool(@NonNull ViewHolder r10, boolean r11) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r10);
            View r12 = r10.itemView;
            RecyclerViewAccessibilityDelegate r13 = this.this$0.mAccessibilityDelegate;
            if (r13 == null) goto L9;
            AccessibilityDelegateCompat r14 = r13.getItemDelegate();
            if ((r14 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L7;
            AccessibilityDelegateCompat r15 = ((RecyclerViewAccessibilityDelegate.ItemDelegate) r14).getAndRemoveOriginalDelegateForItem(r12);
        L8:
            ViewCompat.setAccessibilityDelegate(r12, r15);
            goto L9
        L7:
            r15 = null;
        L9:
            if (r11 == false) goto L11;
            dispatchViewRecycled(r10);
        L11:
            r10.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(r10);
        }

        public void bindViewToPosition(@NonNull View r10, int r11) {
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r10);
            if (r12 == null) goto L25;
            int r13 = this.this$0.mAdapterHelper.findPositionOffset(r11);
            if (r13 < 0) goto L23;
            if (r13 >= this.this$0.mAdapter.getItemCount()) goto L23;
            tryBindViewHolderByDeadline(r12, r13, r11, Long.MAX_VALUE);
            ViewGroup.LayoutParams r14 = r12.itemView.getLayoutParams();
            if (r14 != null) goto L13;
            ViewGroup.LayoutParams r15 = this.this$0.generateDefaultLayoutParams();
        L11:
            LayoutParams r16 = (LayoutParams) r15;
            r12.itemView.setLayoutParams(r16);
        L16:
            boolean r17 = true;
            r16.mInsetsDirty = true;
            r16.mViewHolder = r12;
            if (r12.itemView.getParent() == null) goto L20;
            r17 = false;
        L20:
            r16.mPendingInvalidate = r17;
            return;
        L13:
            if (this.this$0.checkLayoutParams(r14) == true) goto L15;
            r15 = this.this$0.generateLayoutParams(r14);
            goto L11
        L15:
            r16 = (LayoutParams) r14;
        L23:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r11 + "(offset:" + r13 + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        L25:
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + this.this$0.exceptionLabel());
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        void clearOldPositions() {
            int r10 = this.mCachedViews.size();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            this.mCachedViews.get(r12).clearOldPosition();
            r12 = r12 + 1;
            goto L3
        L5:
            int r13 = this.mAttachedScrap.size();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L8;
            this.mAttachedScrap.get(r14).clearOldPosition();
            r14 = r14 + 1;
            goto L6
        L8:
            ArrayList<ViewHolder> r15 = this.mChangedScrap;
            if (r15 == null) goto L13;
            int r16 = r15.size();
        L11:
            if (r11 >= r16) goto L17;
            this.mChangedScrap.get(r11).clearOldPosition();
            r11 = r11 + 1;
            goto L11
        L17:
            return;
        }

        void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> r10 = this.mChangedScrap;
            if (r10 == null) goto L6;
            r10.clear();
            return;
        }

        public int convertPreLayoutPositionToPostLayout(int r10) {
            if (r10 < 0) goto L11;
            if (r10 >= this.this$0.mState.getItemCount()) goto L11;
            if (this.this$0.mState.isPreLayout() == true) goto L9;
            return r10;
        L9:
            return this.this$0.mAdapterHelper.findPositionOffset(r10);
        L11:
            throw new IndexOutOfBoundsException("invalid position " + r10 + ". State item count is " + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        }

        void dispatchViewRecycled(@NonNull ViewHolder r10) {
            RecyclerListener r11 = this.this$0.mRecyclerListener;
            if (r11 == null) goto L5;
            r11.onViewRecycled(r10);
        L5:
            Adapter r12 = this.this$0.mAdapter;
            if (r12 == null) goto L8;
            r12.onViewRecycled(r10);
        L8:
            RecyclerView r13 = this.this$0;
            if (r13.mState == null) goto L12;
            r13.mViewInfoStore.removeViewHolder(r10);
            return;
        }

        ViewHolder getChangedScrapViewForPosition(int r10) {
            ArrayList<ViewHolder> r11 = this.mChangedScrap;
            if (r11 == null) goto L32;
            int r12 = r11.size();
            if (r12 == 0) goto L32;
            int r13 = 0;
            int r14 = 0;
        L9:
            if (r14 >= r12) goto L18;
            ViewHolder r15 = this.mChangedScrap.get(r14);
            if (r15.wasReturnedFromScrap() == true) goto L16;
            if (r15.getLayoutPosition() != r10) goto L16;
            r15.addFlags(32);
            return r15;
        L16:
            r14 = r14 + 1;
            goto L9
        L18:
            if (this.this$0.mAdapter.hasStableIds() == false) goto L32;
            int r16 = this.this$0.mAdapterHelper.findPositionOffset(r10);
            if (r16 <= 0) goto L32;
            if (r16 >= this.this$0.mAdapter.getItemCount()) goto L32;
            long r17 = this.this$0.mAdapter.getItemId(r16);
        L24:
            if (r13 >= r12) goto L32;
            ViewHolder r18 = this.mChangedScrap.get(r13);
            if (r18.wasReturnedFromScrap() == true) goto L31;
            if (r18.getItemId() != r17) goto L31;
            r18.addFlags(32);
            return r18;
        L31:
            r13 = r13 + 1;
        L32:
            return null;
        }

        RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool != null) goto L6;
            this.mRecyclerPool = new RecycledViewPool();
        L6:
            return this.mRecyclerPool;
        }

        int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        ViewHolder getScrapOrCachedViewForId(long r10, int r11, boolean r12) {
            int r13 = this.mAttachedScrap.size() - 1;
        L3:
            if (r13 < 0) goto L19;
            ViewHolder r14 = this.mAttachedScrap.get(r13);
            if (r14.getItemId() != r10) goto L18;
            if (r14.wasReturnedFromScrap() == true) goto L18;
            if (r11 == r14.getItemViewType()) goto L10;
            if (r12 == true) goto L18;
            this.mAttachedScrap.remove(r13);
            this.this$0.removeDetachedView(r14.itemView, false);
            quickRecycleScrapView(r14.itemView);
            goto L18
        L10:
            r14.addFlags(32);
            if (r14.isRemoved() == true) goto L13;
        L15:
            return r14;
        L13:
            if (this.this$0.mState.isPreLayout() == true) goto L15;
            r14.setFlags(2, 14);
        L18:
            r13 = r13 - 1;
            goto L3
        L19:
            int r15 = this.mCachedViews.size();
        L20:
            r15 = r15 - 1;
            if (r15 < 0) goto L35;
            ViewHolder r16 = this.mCachedViews.get(r15);
            if (r16.getItemId() != r10) goto L20;
            if (r16.isAttachedToTransitionOverlay() == true) goto L20;
            if (r11 == r16.getItemViewType()) goto L28;
            if (r12 == true) goto L20;
            recycleCachedViewAt(r15);
            return null;
        L28:
            if (r12 == true) goto L30;
            this.mCachedViews.remove(r15);
        L30:
            return r16;
        L35:
            return null;
        }

        ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int r10, boolean r11) {
            int r12 = this.mAttachedScrap.size();
            int r13 = 0;
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L17;
            ViewHolder r15 = this.mAttachedScrap.get(r14);
            if (r15.wasReturnedFromScrap() == true) goto L16;
            if (r15.getLayoutPosition() != r10) goto L16;
            if (r15.isInvalid() == true) goto L16;
            if (this.this$0.mState.mInPreLayout == true) goto L14;
            if (r15.isRemoved() == true) goto L16;
        L14:
            r15.addFlags(32);
            return r15;
        L16:
            r14 = r14 + 1;
            goto L3
        L17:
            if (r11 == true) goto L26;
            View r16 = this.this$0.mChildHelper.findHiddenNonRemovedView(r10);
            if (r16 == null) goto L26;
            ViewHolder r17 = RecyclerView.getChildViewHolderInt(r16);
            this.this$0.mChildHelper.unhide(r16);
            int r18 = this.this$0.mChildHelper.indexOfChild(r16);
            if (r18 == (-1)) goto L25;
            this.this$0.mChildHelper.detachViewFromParent(r18);
            scrapView(r16);
            r17.addFlags(8224);
            return r17;
        L25:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r17 + this.this$0.exceptionLabel());
        L26:
            int r19 = this.mCachedViews.size();
        L27:
            if (r13 >= r19) goto L38;
            ViewHolder r20 = this.mCachedViews.get(r13);
            if (r20.isInvalid() == true) goto L37;
            if (r20.getLayoutPosition() != r10) goto L37;
            if (r20.isAttachedToTransitionOverlay() == true) goto L37;
            if (r11 == true) goto L36;
            this.mCachedViews.remove(r13);
        L36:
            return r20;
        L37:
            r13 = r13 + 1;
            goto L27
        L38:
            return null;
        }

        View getScrapViewAt(int r10) {
            return this.mAttachedScrap.get(r10).itemView;
        }

        @NonNull
        public View getViewForPosition(int r10) {
            return getViewForPosition(r10, false);
        }

        View getViewForPosition(int r10, boolean r11) {
            return tryGetViewHolderForPositionByDeadline(r10, r11, Long.MAX_VALUE).itemView;
        }

        void markItemDecorInsetsDirty() {
            int r10 = this.mCachedViews.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            LayoutParams r12 = (LayoutParams) this.mCachedViews.get(r11).itemView.getLayoutParams();
            if (r12 == null) goto L7;
            r12.mInsetsDirty = true;
        L7:
            r11 = r11 + 1;
            goto L3
        }

        void markKnownViewsInvalid() {
            int r10 = this.mCachedViews.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            ViewHolder r12 = this.mCachedViews.get(r11);
            if (r12 == null) goto L7;
            r12.addFlags(6);
            r12.addChangePayload(null);
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            Adapter r13 = this.this$0.mAdapter;
            if (r13 != null) goto L11;
        L12:
            recycleAndClearCachedViews();
            return;
        L11:
            if (r13.hasStableIds() == false) goto L12;
        }

        void offsetPositionRecordsForInsert(int r10, int r11) {
            int r12 = this.mCachedViews.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            ViewHolder r14 = this.mCachedViews.get(r13);
            if (r14 == null) goto L9;
            if (r14.mPosition < r10) goto L9;
            r14.offsetPosition(r11, true);
        L9:
            r13 = r13 + 1;
            goto L3
        }

        void offsetPositionRecordsForMove(int r10, int r11) {
            if (r10 >= r11) goto L4;
            int r12 = -1;
            int r13 = r10;
            int r14 = r11;
        L5:
            int r15 = this.mCachedViews.size();
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L17;
            ViewHolder r17 = this.mCachedViews.get(r16);
            if (r17 == null) goto L16;
            int r18 = r17.mPosition;
            if (r18 < r13) goto L16;
            if (r18 > r14) goto L16;
            if (r18 != r10) goto L15;
            r17.offsetPosition(r11 - r10, false);
            goto L16
        L15:
            r17.offsetPosition(r12, false);
        L16:
            r16 = r16 + 1;
            goto L6
        L17:
            return;
        L4:
            r12 = 1;
            r14 = r10;
            r13 = r11;
            goto L5
        }

        void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
            int r13 = r10 + r11;
            int r14 = this.mCachedViews.size() - 1;
        L3:
            if (r14 < 0) goto L12;
            ViewHolder r15 = this.mCachedViews.get(r14);
            if (r15 == null) goto L11;
            int r16 = r15.mPosition;
            if (r16 < r13) goto L9;
            r15.offsetPosition(-r11, r12);
            goto L11
        L9:
            if (r16 < r10) goto L11;
            r15.addFlags(8);
            recycleCachedViewAt(r14);
        L11:
            r14 = r14 - 1;
            goto L3
        }

        void onAdapterChanged(Adapter r10, Adapter r11, boolean r12) {
            clear();
            getRecycledViewPool().onAdapterChanged(r10, r11, r12);
        }

        void quickRecycleScrapView(View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            r11.mScrapContainer = null;
            r11.mInChangeScrap = false;
            r11.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(r11);
        }

        void recycleAndClearCachedViews() {
            int r10 = this.mCachedViews.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            recycleCachedViewAt(r10);
            r10 = r10 - 1;
            goto L3
        L5:
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
            return;
        }

        void recycleCachedViewAt(int r10) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(r10), true);
            this.mCachedViews.remove(r10);
        }

        public void recycleView(@NonNull View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            if (r11.isTmpDetached() == false) goto L6;
            this.this$0.removeDetachedView(r10, false);
        L6:
            if (r11.isScrap() == false) goto L9;
            r11.unScrap();
        L11:
            recycleViewHolderInternal(r11);
            if (this.this$0.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r11.isRecyclable() == true) goto L18;
            this.this$0.mItemAnimator.endAnimation(r11);
            return;
        L18:
            return;
        L9:
            if (r11.wasReturnedFromScrap() == false) goto L11;
            r11.clearReturnedFromScrapFlag();
            goto L11
        }

        void recycleViewHolderInternal(ViewHolder r10) {
            boolean r11 = false;
            boolean r12 = true;
            if (r10.isScrap() == false) goto L5;
        L59:
            StringBuilder r13 = new StringBuilder();
            r13.append("Scrapped or attached views may not be recycled. isScrap:");
            r13.append(r10.isScrap());
            r13.append(" isAttached:");
            if (r10.itemView.getParent() == null) goto L62;
            r11 = true;
        L62:
            r13.append(r11);
            r13.append(this.this$0.exceptionLabel());
            throw new IllegalArgumentException(r13.toString());
        L5:
            if (r10.itemView.getParent() != null) goto L59;
            if (r10.isTmpDetached() == true) goto L58;
            if (r10.shouldIgnore() == true) goto L56;
            boolean r14 = r10.doesTransientStatePreventRecycling();
            Adapter r15 = this.this$0.mAdapter;
            if (r15 == null) goto L17;
            if (r14 == false) goto L17;
            if (r15.onFailedToRecycleView(r10) == false) goto L17;
            boolean r16 = true;
        L18:
            if (r16 == true) goto L24;
            if (r10.isRecyclable() == true) goto L24;
            r12 = false;
        L49:
            this.this$0.mViewInfoStore.removeViewHolder(r10);
            if (r11 == true) goto L66;
            if (r12 == true) goto L67;
            if (r14 == false) goto L68;
            r10.mOwnerRecyclerView = null;
            return;
        L68:
            return;
        L67:
            return;
        L66:
            return;
        L24:
            if (this.mViewCacheMax > 0) goto L26;
        L44:
            boolean r17 = false;
        L45:
            if (r17 == true) goto L47;
            addViewHolderToRecycledViewPool(r10, true);
        L48:
            r11 = r17;
            goto L49
        L47:
            r12 = false;
            goto L48
        L26:
            if (r10.hasAnyOfTheFlags(526) == true) goto L44;
            int r18 = this.mCachedViews.size();
            if (r18 < this.mViewCacheMax) goto L32;
            if (r18 <= 0) goto L32;
            recycleCachedViewAt(0);
            r18 = r18 - 1;
        L32:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L43;
            if (r18 <= 0) goto L43;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(r10.mPosition) == true) goto L43;
            int r19 = r18 - 1;
        L37:
            if (r19 < 0) goto L42;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(r19).mPosition) == false) goto L42;
            r19 = r19 - 1;
        L42:
            r18 = r19 + 1;
        L43:
            this.mCachedViews.add(r18, r10);
            r17 = true;
        L17:
            r16 = false;
            goto L18
        L56:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.this$0.exceptionLabel());
        L58:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r10 + this.this$0.exceptionLabel());
        }

        void scrapView(View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            if (r11.hasAnyOfTheFlags(12) == true) goto L14;
            if (r11.isUpdated() == false) goto L14;
            if (this.this$0.canReuseUpdatedViewHolder(r11) == true) goto L14;
            if (this.mChangedScrap != null) goto L12;
            this.mChangedScrap = new ArrayList();
        L12:
            r11.setScrapContainer(this, true);
            ArrayList<ViewHolder> r12 = this.mChangedScrap;
        L23:
            r12.add(r11);
            return;
        L14:
            if (r11.isInvalid() == true) goto L16;
        L22:
            r11.setScrapContainer(this, false);
            r12 = this.mAttachedScrap;
            goto L23
        L16:
            if (r11.isRemoved() == true) goto L22;
            if (this.this$0.mAdapter.hasStableIds() == true) goto L22;
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.this$0.exceptionLabel());
        }

        void setRecycledViewPool(RecycledViewPool r10) {
            RecycledViewPool r11 = this.mRecyclerPool;
            if (r11 == null) goto L5;
            r11.detach();
        L5:
            this.mRecyclerPool = r10;
            if (r10 != null) goto L8;
            return;
        L8:
            if (this.this$0.getAdapter() == null) goto L12;
            this.mRecyclerPool.attach();
            return;
        }

        void setViewCacheExtension(ViewCacheExtension r10) {
            this.mViewCacheExtension = r10;
        }

        public void setViewCacheSize(int r10) {
            this.mRequestedCacheMax = r10;
            updateViewCacheSize();
        }

        @Nullable
        ViewHolder tryGetViewHolderForPositionByDeadline(int r17, boolean r18, long r19) {
            if (r17 < 0) goto L113;
            if (r17 >= this.this$0.mState.getItemCount()) goto L113;
            boolean r10 = true;
            if (this.this$0.mState.isPreLayout() == false) goto L11;
            ViewHolder r11 = getChangedScrapViewForPosition(r17);
            if (r11 == null) goto L12;
            boolean r12 = true;
        L13:
            if (r11 != null) goto L28;
            r11 = getScrapOrHiddenOrCachedHolderForPosition(r17, r18);
            if (r11 == null) goto L28;
            if (validateViewHolderForOffsetPosition(r11) == true) goto L27;
            if (r18 == true) goto L26;
            r11.addFlags(4);
            if (r11.isScrap() == false) goto L23;
            this.this$0.removeDetachedView(r11.itemView, false);
            r11.unScrap();
        L25:
            recycleViewHolderInternal(r11);
            goto L26
        L23:
            if (r11.wasReturnedFromScrap() == false) goto L25;
            r11.clearReturnedFromScrapFlag();
        L26:
            r11 = null;
            goto L28
        L27:
            r12 = true;
        L28:
            if (r11 != null) goto L73;
            int r13 = this.this$0.mAdapterHelper.findPositionOffset(r17);
            if (r13 < 0) goto L72;
            if (r13 >= this.this$0.mAdapter.getItemCount()) goto L72;
            int r14 = this.this$0.mAdapter.getItemViewType(r13);
            if (this.this$0.mAdapter.hasStableIds() == false) goto L38;
            r11 = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(r13), r14, r18);
            if (r11 == null) goto L38;
            r11.mPosition = r13;
            r12 = true;
        L38:
            if (r11 != null) goto L52;
            ViewCacheExtension r15 = this.mViewCacheExtension;
            if (r15 == null) goto L52;
            View r16 = r15.getViewForPositionAndType(this, r17, r14);
            if (r16 == null) goto L52;
            r11 = this.this$0.getChildViewHolder(r16);
            if (r11 == null) goto L51;
            if (r11.shouldIgnore() == false) goto L52;
            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.this$0.exceptionLabel());
        L51:
            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.this$0.exceptionLabel());
        L52:
            if (r11 != null) goto L59;
            ViewHolder r20 = getRecycledViewPool().getRecycledView(r14);
            if (r20 == null) goto L58;
            r20.resetInternal();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L58;
            invalidateDisplayListInt(r20);
        L58:
            r11 = r20;
        L59:
            if (r11 != null) goto L73;
            long r21 = this.this$0.getNanoTime();
            if (r19 != Long.MAX_VALUE) goto L63;
        L65:
            RecyclerView r22 = this.this$0;
            ViewHolder r23 = r22.mAdapter.createViewHolder(r22, r14);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L70;
            RecyclerView r24 = RecyclerView.findNestedRecyclerView(r23.itemView);
            if (r24 == null) goto L70;
            r23.mNestedRecyclerView = new WeakReference(r24);
        L70:
            this.mRecyclerPool.factorInCreateTime(r14, this.this$0.getNanoTime() - r21);
            ViewHolder r25 = r23;
        L74:
            boolean r110 = r12;
            if (r110 == false) goto L84;
            if (this.this$0.mState.isPreLayout() == true) goto L84;
            if (r25.hasAnyOfTheFlags(8192) == false) goto L84;
            r25.setFlags(0, 8192);
            if (this.this$0.mState.mRunSimpleAnimations == false) goto L84;
            int r26 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r25) | 4096;
            RecyclerView r27 = this.this$0;
            this.this$0.recordAnimationInfoIfBouncedHiddenView(r25, r27.mItemAnimator.recordPreLayoutInformation(r27.mState, r25, r26, r25.getUnmodifiedPayloads()));
        L84:
            if (this.this$0.mState.isPreLayout() == false) goto L89;
            if (r25.isBound() == false) goto L89;
            r25.mPreLayoutPosition = r17;
        L95:
            boolean r28 = false;
        L97:
            ViewGroup.LayoutParams r29 = r25.itemView.getLayoutParams();
            if (r29 != null) goto L102;
            ViewGroup.LayoutParams r30 = this.this$0.generateDefaultLayoutParams();
        L100:
            LayoutParams r31 = (LayoutParams) r30;
            r25.itemView.setLayoutParams(r31);
        L105:
            r31.mViewHolder = r25;
            if (r110 == false) goto L109;
            if (r28 == false) goto L109;
        L110:
            r31.mPendingInvalidate = r10;
            return r25;
        L109:
            r10 = false;
            goto L110
        L102:
            if (this.this$0.checkLayoutParams(r29) == true) goto L104;
            r30 = this.this$0.generateLayoutParams(r29);
            goto L100
        L104:
            r31 = (LayoutParams) r29;
        L89:
            if (r25.isBound() == true) goto L91;
        L96:
            r28 = tryBindViewHolderByDeadline(r25, this.this$0.mAdapterHelper.findPositionOffset(r17), r17, r19);
            goto L97
        L91:
            if (r25.needsUpdate() == true) goto L96;
            if (r25.isInvalid() == false) goto L95;
        L63:
            if (this.mRecyclerPool.willCreateInTime(r14, r21, r19) == true) goto L65;
            return null;
        L72:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r17 + "(offset:" + r13 + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        L73:
            r25 = r11;
        L12:
            r12 = false;
            goto L13
        L11:
            r11 = null;
        L113:
            throw new IndexOutOfBoundsException("Invalid item position " + r17 + "(" + r17 + "). Item count:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        }

        void unscrapView(ViewHolder r10) {
            if (r10.mInChangeScrap == false) goto L5;
            ArrayList<ViewHolder> r11 = this.mChangedScrap;
        L6:
            r11.remove(r10);
            r10.mScrapContainer = null;
            r10.mInChangeScrap = false;
            r10.clearReturnedFromScrapFlag();
            return;
        L5:
            r11 = this.mAttachedScrap;
            goto L6
        }

        void updateViewCacheSize() {
            LayoutManager r10 = this.this$0.mLayout;
            if (r10 == null) goto L5;
            int r11 = r10.mPrefetchMaxCountObserved;
        L6:
            this.mViewCacheMax = this.mRequestedCacheMax + r11;
            int r12 = this.mCachedViews.size() - 1;
        L7:
            if (r12 < 0) goto L11;
            if (this.mCachedViews.size() <= this.mViewCacheMax) goto L14;
            recycleCachedViewAt(r12);
            r12 = r12 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r11 = 0;
            goto L6
        }

        boolean validateViewHolderForOffsetPosition(ViewHolder r10) {
            if (r10.isRemoved() == true) goto L5;
            int r11 = r10.mPosition;
            if (r11 < 0) goto L23;
            if (r11 >= this.this$0.mAdapter.getItemCount()) goto L23;
            if (this.this$0.mState.isPreLayout() == true) goto L16;
            if (this.this$0.mAdapter.getItemViewType(r10.mPosition) == r10.getItemViewType()) goto L16;
            return false;
        L16:
            if (this.this$0.mAdapter.hasStableIds() == true) goto L18;
            return true;
        L18:
            if (r10.getItemId() == this.this$0.mAdapter.getItemId(r10.mPosition)) goto L20;
            return false;
        L20:
            return true;
        L23:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r10 + this.this$0.exceptionLabel());
        L5:
            return this.this$0.mState.isPreLayout();
        }

        void viewRangeUpdate(int r10, int r11) {
            int r12 = r11 + r10;
            int r13 = this.mCachedViews.size() - 1;
        L3:
            if (r13 < 0) goto L12;
            ViewHolder r14 = this.mCachedViews.get(r13);
            if (r14 == null) goto L11;
            int r15 = r14.mPosition;
            if (r15 < r10) goto L11;
            if (r15 >= r12) goto L11;
            r14.addFlags(2);
            recycleCachedViewAt(r13);
        L11:
            r13 = r13 - 1;
            goto L3
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder r10);
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerView this$0;

        RecyclerViewDataObserver(RecyclerView r10) {
            this.this$0 = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.assertNotInLayoutOrScroll(null);
            RecyclerView r10 = this.this$0;
            r10.mState.mStructureChanged = true;
            r10.processDataSetCompletelyChanged(true);
            if (this.this$0.mAdapterHelper.hasPendingUpdates() == true) goto L6;
            this.this$0.requestLayout();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r10, int r11, Object r12) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeChanged(r10, r11, r12) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r10, int r11) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeInserted(r10, r11) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r10, int r11, int r12) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeMoved(r10, r11, r12) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r10, int r11) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeRemoved(r10, r11) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == false) goto L9;
            RecyclerView r10 = this.this$0;
            if (r10.mHasFixedSize == false) goto L9;
            if (r10.mIsAttached == false) goto L9;
            ViewCompat.postOnAnimation(r10, r10.mUpdateChildViewsRunnable);
            return;
        L9:
            RecyclerView r11 = this.this$0;
            r11.mAdapterUpdateDuringMeasure = true;
            r11.requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L6;
            r11 = LayoutManager.class.getClassLoader();
        L6:
            this.mLayoutState = r10.readParcelable(r11);
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        void copyFrom(SavedState r10) {
            this.mLayoutState = r10.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeParcelable(this.mLayoutState, 0);
        }
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public SimpleOnItemTouchListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r10) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11) {
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition;
        private View mTargetView;

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(@Px int r10, @Px int r11) {
                this(r10, r11, Integer.MIN_VALUE, null);
            }

            public Action(@Px int r10, @Px int r11, int r12) {
                this(r10, r11, r12, null);
            }

            public Action(@Px int r10, @Px int r11, int r12, @Nullable Interpolator r13) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = r10;
                this.mDy = r11;
                this.mDuration = r12;
                this.mInterpolator = r13;
            }

            private void validate() {
                if (this.mInterpolator == null) goto L10;
                if (this.mDuration >= 1) goto L10;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            L10:
                if (this.mDuration < 1) goto L13;
                return;
            L13:
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public int getDuration() {
                return this.mDuration;
            }

            @Px
            public int getDx() {
                return this.mDx;
            }

            @Px
            public int getDy() {
                return this.mDy;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            boolean hasJumpTarget() {
                if (this.mJumpToPosition < 0) goto L5;
                return true;
            L5:
                return false;
            }

            public void jumpTo(int r10) {
                this.mJumpToPosition = r10;
            }

            void runIfNecessary(RecyclerView r10) {
                int r11 = this.mJumpToPosition;
                if (r11 < 0) goto L7;
                this.mJumpToPosition = -1;
                r10.jumpToPositionForSmoothScroller(r11);
                this.mChanged = false;
                return;
            L7:
                if (this.mChanged == false) goto L12;
                validate();
                r10.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                int r12 = this.mConsecutiveUpdates + 1;
                this.mConsecutiveUpdates = r12;
                if (r12 <= 10) goto L11;
                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L11:
                this.mChanged = false;
                return;
            L12:
                this.mConsecutiveUpdates = 0;
            }

            public void setDuration(int r10) {
                this.mChanged = true;
                this.mDuration = r10;
            }

            public void setDx(@Px int r10) {
                this.mChanged = true;
                this.mDx = r10;
            }

            public void setDy(@Px int r10) {
                this.mChanged = true;
                this.mDy = r10;
            }

            public void setInterpolator(@Nullable Interpolator r10) {
                this.mChanged = true;
                this.mInterpolator = r10;
            }

            public void update(@Px int r10, @Px int r11, int r12, @Nullable Interpolator r13) {
                this.mDx = r10;
                this.mDy = r11;
                this.mDuration = r12;
                this.mInterpolator = r13;
                this.mChanged = true;
            }
        }

        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int r10);
        }

        public SmoothScroller() {
            this.mTargetPosition = -1;
            this.mRecyclingAction = new Action(0, 0);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int r10) {
            Object r11 = getLayoutManager();
            if ((r11 instanceof ScrollVectorProvider) == true) goto L5;
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        L5:
            return ((ScrollVectorProvider) r11).computeScrollVectorForPosition(r10);
        }

        public View findViewByPosition(int r10) {
            return this.mRecyclerView.mLayout.findViewByPosition(r10);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View r10) {
            return this.mRecyclerView.getChildLayoutPosition(r10);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int r10) {
            this.mRecyclerView.scrollToPosition(r10);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        protected void normalize(@NonNull PointF r10) {
            float r11 = r10.x;
            float r12 = r10.y;
            float r13 = (float) Math.sqrt((r11 * r11) + (r12 * r12));
            r10.x /= r13;
            r10.y /= r13;
        }

        void onAnimation(int r10, int r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (this.mTargetPosition == (-1)) goto L5;
            if (r12 == null) goto L5;
        L7:
            if (this.mPendingInitialRun == true) goto L9;
        L19:
            this.mPendingInitialRun = false;
            View r13 = this.mTargetView;
            if (r13 == null) goto L26;
            if (getChildPosition(r13) != this.mTargetPosition) goto L24;
            onTargetFound(this.mTargetView, r12.mState, this.mRecyclingAction);
            this.mRecyclingAction.runIfNecessary(r12);
            stop();
            goto L26
        L24:
            Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.mTargetView = null;
        L26:
            if (this.mRunning == false) goto L33;
            onSeekTargetStep(r10, r11, r12.mState, this.mRecyclingAction);
            boolean r14 = this.mRecyclingAction.hasJumpTarget();
            this.mRecyclingAction.runIfNecessary(r12);
            if (r14 == true) goto L30;
            return;
        L30:
            if (this.mRunning == false) goto L35;
            this.mPendingInitialRun = true;
            r12.mViewFlinger.postOnAnimation();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.mTargetView != null) goto L19;
            if (this.mLayoutManager == null) goto L19;
            PointF r15 = computeScrollVectorForPosition(this.mTargetPosition);
            if (r15 == null) goto L19;
            float r16 = r15.x;
            if (r16 == 0.0f) goto L17;
        L18:
            r12.scrollStep((int) Math.signum(r16), (int) Math.signum(r15.y), null);
            goto L19
        L17:
            if (r15.y == 0.0f) goto L19;
        L5:
            stop();
            goto L7
        }

        protected void onChildAttachedToWindow(View r10) {
            if (getChildPosition(r10) != getTargetPosition()) goto L6;
            this.mTargetView = r10;
            return;
        }

        protected abstract void onSeekTargetStep(@Px int r10, @Px int r11, @NonNull State r12, @NonNull Action r13);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(@NonNull View r10, @NonNull State r11, @NonNull Action r12);

        public void setTargetPosition(int r10) {
            this.mTargetPosition = r10;
        }

        void start(RecyclerView r10, LayoutManager r11) {
            r10.mViewFlinger.stop();
            if (this.mStarted == false) goto L5;
            Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L5:
            this.mRecyclerView = r10;
            this.mLayoutManager = r11;
            int r12 = this.mTargetPosition;
            if (r12 == (-1)) goto L10;
            r10.mState.mTargetPosition = r12;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.postOnAnimation();
            this.mStarted = true;
            return;
        L10:
            throw new IllegalArgumentException("Invalid target position");
        }

        protected final void stop() {
            if (this.mRunning == true) goto L5;
            return;
        L5:
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        int mDeletedInvisibleItemCountSincePreviousLayout;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        boolean mInPreLayout;
        boolean mIsMeasuring;
        int mItemCount;
        int mLayoutStep;
        int mPreviousLayoutItemCount;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        boolean mRunPredictiveAnimations;
        boolean mRunSimpleAnimations;
        boolean mStructureChanged;
        int mTargetPosition;
        boolean mTrackOldChangeHolders;

        public State() {
            this.mTargetPosition = -1;
            this.mPreviousLayoutItemCount = 0;
            this.mDeletedInvisibleItemCountSincePreviousLayout = 0;
            this.mLayoutStep = 1;
            this.mItemCount = 0;
            this.mStructureChanged = false;
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
            this.mRunSimpleAnimations = false;
            this.mRunPredictiveAnimations = false;
        }

        void assertLayoutStep(int r10) {
            if ((this.mLayoutStep & r10) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r10) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public <T> T get(int r10) {
            SparseArray<Object> r11 = this.mData;
            if (r11 != null) goto L7;
            return null;
        L7:
            return (T) r11.get(r10);
        }

        public int getItemCount() {
            if (this.mInPreLayout == false) goto L6;
            return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
        L6:
            return this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            if (this.mTargetPosition == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        void prepareForNestedPrefetch(Adapter r10) {
            this.mLayoutStep = 1;
            this.mItemCount = r10.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void put(int r10, Object r11) {
            if (this.mData != null) goto L5;
            this.mData = new SparseArray();
        L5:
            this.mData.put(r10, r11);
        }

        public void remove(int r10) {
            SparseArray<Object> r11 = this.mData;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.remove(r10);
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }
    }

    public static abstract class ViewCacheExtension {
        public ViewCacheExtension() {
        }

        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler r10, int r11, int r12);
    }

    class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;
        final /* synthetic */ RecyclerView this$0;

        ViewFlinger(RecyclerView r10) {
            this.this$0 = r10;
            Interpolator r11 = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = r11;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(r10.getContext(), r11);
        }

        private int computeScrollDuration(int r10, int r11, int r12, int r13) {
            int r14 = Math.abs(r10);
            int r15 = Math.abs(r11);
            if (r14 <= r15) goto L5;
            boolean r16 = true;
        L6:
            int r17 = (int) Math.sqrt((r12 * r12) + (r13 * r13));
            int r18 = (int) Math.sqrt((r10 * r10) + (r11 * r11));
            RecyclerView r19 = this.this$0;
            if (r16 == false) goto L9;
            int r20 = r19.getWidth();
        L10:
            int r21 = r20 / 2;
            float r22 = r20;
            float r23 = r21;
            float r24 = r23 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (r18 * 1.0f) / r22)) * r23);
            if (r17 <= 0) goto L13;
            int r25 = Math.round(Math.abs(r24 / r17) * 1000.0f) * 4;
        L18:
            return Math.min(r25, RecyclerView.MAX_SCROLL_DURATION);
        L13:
            if (r16 == true) goto L16;
            r14 = r15;
        L16:
            r25 = (int) (((r14 / r22) + 1.0f) * 300.0f);
            goto L18
        L9:
            r20 = r19.getHeight();
            goto L10
        L5:
            r16 = false;
            goto L6
        }

        private float distanceInfluenceForSnapDuration(float r10) {
            return (float) Math.sin((r10 - 0.5f) * 0.47123894f);
        }

        private void internalPostOnAnimation() {
            this.this$0.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.this$0, this);
        }

        public void fling(int r13, int r14) {
            this.this$0.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator r10 = this.mInterpolator;
            Interpolator r11 = RecyclerView.sQuinticInterpolator;
            if (r10 == r11) goto L5;
            this.mInterpolator = r11;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), r11);
        L5:
            this.mOverScroller.fling(0, 0, r13, r14, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest == false) goto L5;
            this.mReSchedulePostAnimationCallback = true;
            return;
        L5:
            internalPostOnAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r10 = this.this$0;
            if (r10.mLayout != null) goto L6;
            stop();
            return;
        L6:
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            r10.consumePendingUpdateOperations();
            OverScroller r11 = this.mOverScroller;
            if (r11.computeScrollOffset() == false) goto L85;
            int r12 = r11.getCurrX();
            int r13 = r11.getCurrY();
            int r14 = r12 - this.mLastFlingX;
            int r15 = r13 - this.mLastFlingY;
            this.mLastFlingX = r12;
            this.mLastFlingY = r13;
            RecyclerView r16 = this.this$0;
            int[] r17 = r16.mReusableIntPair;
            r17[0] = 0;
            r17[1] = 0;
            if (r16.dispatchNestedPreScroll(r14, r15, r17, null, 1) == false) goto L12;
            int[] r18 = this.this$0.mReusableIntPair;
            r14 = r14 - r18[0];
            r15 = r15 - r18[1];
        L12:
            if (this.this$0.getOverScrollMode() == 2) goto L14;
            this.this$0.considerReleasingGlowsOnScroll(r14, r15);
        L14:
            RecyclerView r19 = this.this$0;
            if (r19.mAdapter == null) goto L29;
            int[] r20 = r19.mReusableIntPair;
            r20[0] = 0;
            r20[1] = 0;
            r19.scrollStep(r14, r15, r20);
            RecyclerView r21 = this.this$0;
            int[] r22 = r21.mReusableIntPair;
            int r23 = r22[0];
            int r24 = r22[1];
            r14 = r14 - r23;
            r15 = r15 - r24;
            SmoothScroller r25 = r21.mLayout.mSmoothScroller;
            if (r25 == null) goto L31;
            if (r25.isPendingInitialRun() == true) goto L31;
            if (r25.isRunning() == false) goto L31;
            int r26 = this.this$0.mState.getItemCount();
            if (r26 != 0) goto L26;
            r25.stop();
            goto L31
        L26:
            if (r25.getTargetPosition() < r26) goto L28;
            r25.setTargetPosition(r26 - 1);
        L28:
            r25.onAnimation(r23, r24);
        L31:
            if (this.this$0.mItemDecorations.isEmpty() == true) goto L33;
            this.this$0.invalidate();
        L33:
            RecyclerView r110 = this.this$0;
            int[] r27 = r110.mReusableIntPair;
            r27[0] = 0;
            r27[1] = 0;
            r110.dispatchNestedScroll(r23, r24, r14, r15, null, 1, r27);
            RecyclerView r28 = this.this$0;
            int[] r29 = r28.mReusableIntPair;
            int r30 = r14 - r29[0];
            int r111 = r15 - r29[1];
            if (r23 != 0) goto L36;
            if (r24 != 0) goto L36;
        L38:
            if (RecyclerView.access$200(this.this$0) == true) goto L41;
            this.this$0.invalidate();
        L41:
            if (r11.getCurrX() != r11.getFinalX()) goto L43;
            boolean r31 = true;
        L45:
            if (r11.getCurrY() != r11.getFinalY()) goto L47;
            boolean r32 = true;
        L49:
            if (r11.isFinished() == true) goto L56;
            if (r31 == true) goto L52;
            if (r30 != 0) goto L52;
        L55:
            boolean r33 = false;
        L57:
            SmoothScroller r34 = this.this$0.mLayout.mSmoothScroller;
            if (r34 != null) goto L60;
        L62:
            boolean r35 = false;
        L63:
            if (r35 == true) goto L82;
            if (r33 == false) goto L82;
            if (this.this$0.getOverScrollMode() == 2) goto L80;
            int r36 = (int) r11.getCurrVelocity();
            if (r30 >= 0) goto L70;
            int r37 = -r36;
        L73:
            if (r111 >= 0) goto L75;
            r36 = -r36;
        L78:
            this.this$0.absorbGlows(r37, r36);
            goto L80
        L75:
            if (r111 > 0) goto L78;
            r36 = 0;
            goto L78
        L70:
            if (r30 <= 0) goto L72;
            r37 = r36;
            goto L73
        L72:
            r37 = 0;
        L80:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L85;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
        L82:
            postOnAnimation();
            RecyclerView r38 = this.this$0;
            GapWorker r39 = r38.mGapWorker;
            if (r39 == null) goto L85;
            r39.postFromTraversal(r38, r23, r24);
            goto L85
        L60:
            if (r34.isPendingInitialRun() == false) goto L62;
            r35 = true;
        L52:
            if (r32 == true) goto L56;
            if (r111 == 0) goto L55;
        L56:
            r33 = true;
            goto L57
        L47:
            r32 = false;
            goto L49
        L43:
            r31 = false;
        L36:
            r28.dispatchOnScrolled(r23, r24);
            goto L38
        L29:
            r24 = 0;
            r23 = 0;
        L85:
            SmoothScroller r40 = this.this$0.mLayout.mSmoothScroller;
            if (r40 != null) goto L88;
        L90:
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback == false) goto L93;
            internalPostOnAnimation();
            return;
        L93:
            this.this$0.setScrollState(0);
            this.this$0.stopNestedScroll(1);
            return;
        L88:
            if (r40.isPendingInitialRun() == false) goto L90;
            r40.onAnimation(0, 0);
            goto L90
        }

        public void smoothScrollBy(int r10, int r11, int r12, @Nullable Interpolator r13) {
            if (r12 != Integer.MIN_VALUE) goto L5;
            r12 = computeScrollDuration(r10, r11, 0, 0);
        L5:
            int r14 = r12;
            if (r13 != null) goto L9;
            r13 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.mInterpolator == r13) goto L11;
            this.mInterpolator = r13;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), r13);
        L11:
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.this$0.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, r10, r11, r14);
            if (Build.VERSION.SDK_INT >= 23) goto L14;
            this.mOverScroller.computeScrollOffset();
        L14:
            postOnAnimation();
        }

        public void stop() {
            this.this$0.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = null;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @NonNull
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;

        @VisibleForTesting
        int mPendingAccessibilityState;
        int mPosition;
        int mPreLayoutPosition;
        Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        static {
            FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public ViewHolder(@NonNull View r10) {
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mItemViewType = -1;
            this.mPreLayoutPosition = -1;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = 0;
            this.mScrapContainer = null;
            this.mInChangeScrap = false;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            if (r10 == null) goto L7;
            this.itemView = r10;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads != null) goto L6;
            ArrayList r10 = new ArrayList();
            this.mPayloads = r10;
            this.mUnmodifiedPayloads = Collections.unmodifiableList(r10);
            return;
        }

        void addChangePayload(Object r10) {
            if (r10 != null) goto L6;
            addFlags(1024);
            return;
        L6:
            if ((1024 & this.mFlags) != 0) goto L10;
            createPayloadsIfNeeded();
            this.mPayloads.add(r10);
            return;
        }

        void addFlags(int r10) {
            this.mFlags = r10 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> r10 = this.mPayloads;
            if (r10 == null) goto L5;
            r10.clear();
        L5:
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.itemView) == false) goto L7;
            return true;
        }

        void flagRemovedAndOffsetPosition(int r10, int r11, boolean r12) {
            addFlags(8);
            offsetPosition(r11, r12);
            this.mPosition = r10;
        }

        public final int getAdapterPosition() {
            RecyclerView r10 = this.mOwnerRecyclerView;
            if (r10 != null) goto L7;
            return -1;
        L7:
            return r10.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int r10 = this.mPreLayoutPosition;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            return this.mPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int r10 = this.mPreLayoutPosition;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            return this.mPosition;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) goto L14;
            List<Object> r10 = this.mPayloads;
            if (r10 == null) goto L12;
            if (r10.size() == 0) goto L12;
            return this.mUnmodifiedPayloads;
        L12:
            return FULLUPDATE_PAYLOADS;
        L14:
            return FULLUPDATE_PAYLOADS;
        }

        boolean hasAnyOfTheFlags(int r10) {
            if ((this.mFlags & r10) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (isInvalid() == true) goto L8;
            return false;
        }

        boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.itemView.getParent() == this.mOwnerRecyclerView) goto L7;
            return true;
        }

        boolean isBound() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean isInvalid() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.itemView) == true) goto L7;
            return true;
        }

        boolean isRemoved() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isScrap() {
            if (this.mScrapContainer == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isTmpDetached() {
            if ((this.mFlags & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isUpdated() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean needsUpdate() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void offsetPosition(int r10, boolean r11) {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
        L6:
            if (this.mPreLayoutPosition != (-1)) goto L8;
            this.mPreLayoutPosition = this.mPosition;
        L8:
            if (r11 == false) goto L10;
            this.mPreLayoutPosition += r10;
        L10:
            this.mPosition += r10;
            if (this.itemView.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            return;
        }

        void onEnteredHiddenState(RecyclerView r10) {
            int r11 = this.mPendingAccessibilityState;
            if (r11 != (-1)) goto L6;
            r11 = ViewCompat.getImportantForAccessibility(this.itemView);
        L6:
            this.mWasImportantForAccessibilityBeforeHidden = r11;
            r10.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView r10) {
            r10.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
            return;
        }

        void setFlags(int r10, int r11) {
            int r12 = r10 & r11;
            this.mFlags = r12 | (this.mFlags & (~r11));
        }

        public final void setIsRecyclable(boolean r10) {
            int r11 = this.mIsRecyclableCount;
            if (r10 == false) goto L5;
            int r12 = r11 - 1;
        L6:
            this.mIsRecyclableCount = r12;
            if (r12 >= 0) goto L9;
            this.mIsRecyclableCount = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        L9:
            if (r10 == true) goto L13;
            if (r12 != 1) goto L13;
            int r13 = this.mFlags | 16;
        L12:
            this.mFlags = r13;
            return;
        L13:
            if (r10 == false) goto L18;
            if (r12 != 0) goto L19;
            r13 = this.mFlags & (-17);
            goto L12
        L19:
            return;
        L18:
            return;
        L5:
            r12 = r11 + 1;
            goto L6
        }

        void setScrapContainer(Recycler r10, boolean r11) {
            this.mScrapContainer = r10;
            this.mInChangeScrap = r11;
        }

        boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean shouldIgnore() {
            if ((this.mFlags & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r10 = "ViewHolder";
        L6:
            StringBuilder r11 = new StringBuilder(r10 + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap() == false) goto L14;
            r11.append(" scrap ");
            if (this.mInChangeScrap == false) goto L11;
            String r12 = "[changeScrap]";
        L12:
            r11.append(r12);
            goto L14
        L11:
            r12 = "[attachedScrap]";
        L14:
            if (isInvalid() == false) goto L17;
            r11.append(" invalid");
        L17:
            if (isBound() == true) goto L20;
            r11.append(" unbound");
        L20:
            if (needsUpdate() == false) goto L23;
            r11.append(" update");
        L23:
            if (isRemoved() == false) goto L26;
            r11.append(" removed");
        L26:
            if (shouldIgnore() == false) goto L29;
            r11.append(" ignored");
        L29:
            if (isTmpDetached() == false) goto L32;
            r11.append(" tmpDetached");
        L32:
            if (isRecyclable() == true) goto L35;
            r11.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        L35:
            if (isAdapterPositionUnknown() == false) goto L38;
            r11.append(" undefined adapter position");
        L38:
            if (this.itemView.getParent() != null) goto L40;
            r11.append(" no parent");
        L40:
            r11.append("}");
            return r11.toString();
        L5:
            r10 = getClass().getSimpleName();
            goto L6
        }

        void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{android.R.attr.nestedScrollingEnabled};
        int r10 = Build.VERSION.SDK_INT;
        if (r10 != 18) goto L5;
    L10:
        boolean r11 = true;
    L11:
        FORCE_INVALIDATE_DISPLAY_LIST = r11;
        if (r10 < 23) goto L14;
        boolean r12 = true;
    L15:
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r12;
        if (r10 < 16) goto L18;
        boolean r13 = true;
    L19:
        POST_UPDATES_ON_ANIMATION = r13;
        if (r10 < 21) goto L22;
        boolean r14 = true;
    L23:
        ALLOW_THREAD_GAP_WORK = r14;
        if (r10 > 15) goto L26;
        boolean r15 = true;
    L27:
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = r15;
        if (r10 > 15) goto L30;
        boolean r16 = true;
    L31:
        IGNORE_DETACHED_FOCUSED_CHILD = r16;
        Class<?> r17 = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, r17, r17};
        sQuinticInterpolator = new AnonymousClass3();
        return;
    L30:
        r16 = false;
        goto L31
    L26:
        r15 = false;
        goto L27
    L22:
        r14 = false;
        goto L23
    L18:
        r13 = false;
        goto L19
    L14:
        r12 = false;
        goto L15
    L5:
        if (r10 == 19) goto L10;
        if (r10 == 20) goto L10;
        r11 = false;
        goto L11
    }

    public RecyclerView(@NonNull Context r10) {
        this(r10, null);
    }

    public RecyclerView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.recyclerViewStyle);
    }

    public RecyclerView(@NonNull Context r18, @Nullable AttributeSet r19, int r20) {
        super(r18, r19, r20);
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new AnonymousClass1(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean r13 = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        GapWorker.LayoutPrefetchRegistryImpl r10 = new GapWorker.LayoutPrefetchRegistryImpl();
    L6:
        this.mPrefetchRegistry = r10;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new AnonymousClass2(this);
        this.mViewInfoProcessCallback = new AnonymousClass4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r11 = ViewConfiguration.get(r18);
        this.mTouchSlop = r11.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r11, r18);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(r11, r18);
        this.mMinFlingVelocity = r11.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r11.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() != 2) goto L9;
        boolean r12 = true;
    L10:
        setWillNotDraw(r12);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] r14 = R.styleable.RecyclerView;
        TypedArray r15 = r18.obtainStyledAttributes(r19, r14, r20, 0);
        int r16 = Build.VERSION.SDK_INT;
        if (r16 < 29) goto L16;
        saveAttributeDataForStyleable(r18, r14, r19, r15, r20, 0);
    L16:
        String r17 = r15.getString(R.styleable.RecyclerView_layoutManager);
        if (r15.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) != (-1)) goto L19;
        setDescendantFocusability(262144);
    L19:
        this.mClipToPadding = r15.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean r21 = r15.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = r21;
        if (r21 == false) goto L22;
        initFastScroller((StateListDrawable) r15.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), r15.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) r15.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), r15.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    L22:
        r15.recycle();
        createLayoutManager(r18, r17, r19, r20, 0);
        if (r16 < 21) goto L28;
        int[] r22 = NESTED_SCROLLING_ATTRS;
        TypedArray r110 = r18.obtainStyledAttributes(r19, r22, r20, 0);
        if (r16 < 29) goto L27;
        saveAttributeDataForStyleable(r18, r22, r19, r110, r20, 0);
    L27:
        r13 = r110.getBoolean(0, true);
        r110.recycle();
    L28:
        setNestedScrollingEnabled(r13);
        return;
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    static /* synthetic */ void access$000(RecyclerView r10, View r11, int r12, ViewGroup.LayoutParams r13) {
        r10.attachViewToParent(r11, r12, r13);
    }

    static /* synthetic */ void access$100(RecyclerView r10, int r11) {
        r10.detachViewFromParent(r11);
    }

    static /* synthetic */ boolean access$200(RecyclerView r10) {
        return r10.awakenScrollBars();
    }

    static /* synthetic */ void access$300(RecyclerView r10, int r11, int r12) {
        r10.setMeasuredDimension(r11, r12);
    }

    private void addAnimatingView(ViewHolder r10) {
        View r11 = r10.itemView;
        if (r11.getParent() != this) goto L5;
        boolean r12 = true;
    L6:
        this.mRecycler.unscrapView(getChildViewHolder(r11));
        boolean r13 = r10.isTmpDetached();
        ChildHelper r14 = this.mChildHelper;
        if (r13 == false) goto L9;
        r14.attachViewToParent(r11, -1, r11.getLayoutParams(), true);
        return;
    L9:
        if (r12 == true) goto L11;
        r14.addView(r11, true);
        return;
    L11:
        r14.hide(r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void animateChange(@NonNull ViewHolder r10, @NonNull ViewHolder r11, @NonNull ItemAnimator.ItemHolderInfo r12, @NonNull ItemAnimator.ItemHolderInfo r13, boolean r14, boolean r15) {
        r10.setIsRecyclable(false);
        if (r14 == false) goto L5;
        addAnimatingView(r10);
    L5:
        if (r10 == r11) goto L10;
        if (r15 == false) goto L8;
        addAnimatingView(r11);
    L8:
        r10.mShadowedHolder = r11;
        addAnimatingView(r10);
        this.mRecycler.unscrapView(r10);
        r11.setIsRecyclable(false);
        r11.mShadowingHolder = r10;
    L10:
        if (this.mItemAnimator.animateChange(r10, r11, r12, r13) == false) goto L13;
        postAnimationRunner();
        return;
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder r10) {
        WeakReference<RecyclerView> r11 = r10.mNestedRecyclerView;
        if (r11 == null) goto L20;
        Object r12 = r11.get();
    L5:
        View r13 = (View) r12;
    L7:
        if (r13 == null) goto L15;
        if (r13 == r10.itemView) goto L10;
        r12 = r13.getParent();
        if ((r12 instanceof View) == true) goto L5;
        r13 = null;
        goto L7
    L10:
        return;
    L15:
        r10.mNestedRecyclerView = null;
        return;
    }

    private void createLayoutManager(Context r10, String r11, AttributeSet r12, int r13, int r14) {
        if (r11 == null) goto L36;
        String r15 = r11.trim();
        if (r15.isEmpty() == true) goto L42;
        String r16 = getFullClassName(r10, r15);
    L21:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Class is not a LayoutManager " + r16, e);
    L33:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Unable to find LayoutManager " + r16, e);
    L24:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Cannot access non-public constructor " + r16, e);
    L27:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L30:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L8:
        if (isInEditMode() == false) goto L10;
        ClassLoader r17 = getClass().getClassLoader();     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L11:
        Class<? extends U> r18 = Class.forName(r16, false, r17).asSubclass(LayoutManager.class);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        Object[] r19 = null;
        Constructor r20 = r18.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: NoSuchMethodException -> L15 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        r19 = new Object[]{r10, r12, Integer.valueOf(r13), Integer.valueOf(r14)};     // Catch: NoSuchMethodException -> L15 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L17:
        r20.setAccessible(true);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        setLayoutManager((LayoutManager) r20.newInstance(r19));     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        return;
    L15:
        e = move-exception;
        r20 = r18.getConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L18 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L18:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        throw new IllegalStateException(r12.getPositionDescription() + ": Error creating LayoutManager " + r16, e);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L10:
        r17 = r10.getClassLoader();     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        goto L11
    L42:
        return;
    }

    private boolean didChildRangeChange(int r10, int r11) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r12 = this.mMinMaxLayoutPositions;
        if (r12[0] != r10) goto L7;
        if (r12[1] != r11) goto L7;
        return false;
    L7:
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int r10 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r11 = AccessibilityEvent.obtain();
        r11.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(r11, r10);
        sendAccessibilityEventUnchecked(r11);
        return;
    }

    private void dispatchLayoutStep1() {
        boolean r10 = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State r11 = this.mState;
        if (r11.mRunSimpleAnimations == true) goto L5;
    L7:
        r10 = false;
    L8:
        r11.mTrackOldChangeHolders = r10;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        r11.mInPreLayout = r11.mRunPredictiveAnimations;
        r11.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations == false) goto L32;
        int r12 = this.mChildHelper.getChildCount();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L32;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getChildAt(r13));
        if (r14.shouldIgnore() == true) goto L30;
        if (r14.isInvalid() == true) goto L17;
    L19:
        this.mViewInfoStore.addToPreLayout(r14, this.mItemAnimator.recordPreLayoutInformation(this.mState, r14, ItemAnimator.buildAdapterChangeFlagsForAnimations(r14), r14.getUnmodifiedPayloads()));
        if (this.mState.mTrackOldChangeHolders == false) goto L30;
        if (r14.isUpdated() == false) goto L30;
        if (r14.isRemoved() == true) goto L30;
        if (r14.shouldIgnore() == true) goto L30;
        if (r14.isInvalid() == true) goto L30;
        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(r14), r14);
        goto L30
    L17:
        if (this.mAdapter.hasStableIds() == true) goto L19;
    L30:
        r13 = r13 + 1;
    L32:
        if (this.mState.mRunPredictiveAnimations == false) goto L49;
        saveOldPositions();
        State r15 = this.mState;
        boolean r16 = r15.mStructureChanged;
        r15.mStructureChanged = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r15);
        this.mState.mStructureChanged = r16;
        int r17 = 0;
    L35:
        if (r17 >= this.mChildHelper.getChildCount()) goto L49;
        ViewHolder r18 = getChildViewHolderInt(this.mChildHelper.getChildAt(r17));
        if (r18.shouldIgnore() == true) goto L48;
        if (this.mViewInfoStore.isInPreLayout(r18) == true) goto L48;
        int r19 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r18);
        boolean r20 = r18.hasAnyOfTheFlags(8192);
        if (r20 == true) goto L44;
        r19 = r19 | 4096;
    L44:
        ItemAnimator.ItemHolderInfo r21 = this.mItemAnimator.recordPreLayoutInformation(this.mState, r18, r19, r18.getUnmodifiedPayloads());
        if (r20 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r18, r21);
        goto L48
    L47:
        this.mViewInfoStore.addToAppearedInPreLayoutHolders(r18, r21);
    L48:
        r17 = r17 + 1;
    L49:
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
        return;
    L5:
        if (this.mItemsChanged == false) goto L7;
        goto L7
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        State r10 = this.mState;
        r10.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        r10.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r10);
        State r11 = this.mState;
        r11.mStructureChanged = false;
        this.mPendingSavedState = null;
        if (r11.mRunSimpleAnimations == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        r11.mRunSimpleAnimations = r12;
        r11.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L5:
        if (this.mItemAnimator == null) goto L7;
        r12 = true;
        goto L8
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State r10 = this.mState;
        r10.mLayoutStep = 1;
        if (r10.mRunSimpleAnimations == false) goto L24;
        int r11 = this.mChildHelper.getChildCount() - 1;
    L5:
        if (r11 < 0) goto L23;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getChildAt(r11));
        if (r12.shouldIgnore() == true) goto L22;
        long r13 = getChangedHolderKey(r12);
        ItemAnimator.ItemHolderInfo r14 = this.mItemAnimator.recordPostLayoutInformation(this.mState, r12);
        ViewHolder r15 = this.mViewInfoStore.getFromOldChangeHolders(r13);
        if (r15 != null) goto L12;
    L21:
        this.mViewInfoStore.addToPostLayout(r12, r14);
        goto L22
    L12:
        if (r15.shouldIgnore() == true) goto L21;
        boolean r16 = this.mViewInfoStore.isDisappearing(r15);
        boolean r17 = this.mViewInfoStore.isDisappearing(r12);
        if (r16 == false) goto L17;
        if (r15 == r12) goto L21;
    L17:
        ItemAnimator.ItemHolderInfo r18 = this.mViewInfoStore.popFromPreLayout(r15);
        this.mViewInfoStore.addToPostLayout(r12, r14);
        ItemAnimator.ItemHolderInfo r19 = this.mViewInfoStore.popFromPostLayout(r12);
        if (r18 != null) goto L20;
        handleMissingPreInfoForChangeError(r13, r12, r15);
        goto L22
    L20:
        animateChange(r15, r12, r18, r19, r16, r17);
    L22:
        r11 = r11 - 1;
        goto L5
    L23:
        this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State r20 = this.mState;
        r20.mPreviousLayoutItemCount = r20.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        r20.mRunSimpleAnimations = false;
        r20.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> r21 = this.mRecycler.mChangedScrap;
        if (r21 == null) goto L27;
        r21.clear();
    L27:
        LayoutManager r22 = this.mLayout;
        if (r22.mPrefetchMaxObservedInInitialPrefetch == false) goto L30;
        r22.mPrefetchMaxCountObserved = 0;
        r22.mPrefetchMaxObservedInInitialPrefetch = false;
        this.mRecycler.updateViewCacheSize();
    L30:
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] r23 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r23[0], r23[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r10) {
        OnItemTouchListener r11 = this.mInterceptingOnItemTouchListener;
        if (r11 == null) goto L5;
        r11.onTouchEvent(this, r10);
        int r12 = r10.getAction();
        if (r12 == 3) goto L13;
        if (r12 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r10.getAction() != 0) goto L9;
        return false;
    L9:
        return findInterceptingOnItemTouchListener(r10);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent r10) {
        int r11 = r10.getAction();
        int r12 = this.mOnItemTouchListeners.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        OnItemTouchListener r14 = this.mOnItemTouchListeners.get(r13);
        if (r14.onInterceptTouchEvent(this, r10) == false) goto L10;
        if (r11 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r14;
        return true;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] r10) {
        int r11 = this.mChildHelper.getChildCount();
        if (r11 != 0) goto L6;
        r10[0] = -1;
        r10[1] = -1;
        return;
    L6:
        int r12 = Integer.MAX_VALUE;
        int r13 = Integer.MIN_VALUE;
        int r14 = 0;
    L7:
        if (r14 >= r11) goto L17;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getChildAt(r14));
        if (r15.shouldIgnore() == true) goto L16;
        int r16 = r15.getLayoutPosition();
        if (r16 >= r12) goto L14;
        r12 = r16;
    L14:
        if (r16 <= r13) goto L16;
        r13 = r16;
    L16:
        r14 = r14 + 1;
        goto L7
    L17:
        r10[0] = r12;
        r10[1] = r13;
    }

    @Nullable
    static RecyclerView findNestedRecyclerView(@NonNull View r10) {
        if ((r10 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r10 instanceof RecyclerView) == true) goto L8;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L15;
        RecyclerView r14 = findNestedRecyclerView(r11.getChildAt(r13));
        if (r14 != null) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        return r14;
    L15:
        return null;
    L8:
        return (RecyclerView) r10;
    }

    @Nullable
    private View findNextViewToFocus() {
        State r10 = this.mState;
        int r11 = r10.mFocusedItemPosition;
        if (r11 != (-1)) goto L6;
        r11 = 0;
    L6:
        int r12 = r10.getItemCount();
        int r13 = r11;
    L7:
        if (r13 >= r12) goto L16;
        ViewHolder r14 = findViewHolderForAdapterPosition(r13);
        if (r14 == null) goto L16;
        if (r14.itemView.hasFocusable() == true) goto L14;
        r13 = r13 + 1;
        goto L7
    L14:
        return r14.itemView;
    L16:
        int r15 = Math.min(r12, r11);
    L17:
        r15 = r15 - 1;
        if (r15 < 0) goto L27;
        ViewHolder r16 = findViewHolderForAdapterPosition(r15);
        if (r16 == null) goto L21;
        if (r16.itemView.hasFocusable() == false) goto L17;
        return r16.itemView;
    L21:
        return null;
    L27:
        return null;
    }

    static ViewHolder getChildViewHolderInt(View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r10.getLayoutParams()).mViewHolder;
    }

    static void getDecoratedBoundsWithMarginsInt(View r10, Rect r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        Rect r13 = r12.mDecorInsets;
        r11.set((r10.getLeft() - r13.left) - ((ViewGroup.MarginLayoutParams) r12).leftMargin, (r10.getTop() - r13.top) - ((ViewGroup.MarginLayoutParams) r12).topMargin, (r10.getRight() + r13.right) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, (r10.getBottom() + r13.bottom) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View r10) {
    L2:
        int r11 = r10.getId();
    L4:
        if (r10.isFocused() == true) goto L12;
        if ((r10 instanceof ViewGroup) == false) goto L12;
        if (r10.hasFocus() == false) goto L12;
        r10 = ((ViewGroup) r10).getFocusedChild();
        if (r10.getId() == (-1)) goto L4;
    L12:
        return r11;
    }

    private String getFullClassName(Context r10, String r11) {
        if (r11.charAt(0) != '.') goto L8;
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.getPackageName());
    L5:
        r12.append(r11);
        return r12.toString();
    L8:
        if (r11.contains(".") == false) goto L10;
        return r11;
    L10:
        r12 = new StringBuilder();
        r12.append(RecyclerView.class.getPackage().getName());
        r12.append('.');
        goto L5
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    L6:
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long r10, ViewHolder r11, ViewHolder r12) {
        int r13 = this.mChildHelper.getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L18;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getChildAt(r14));
        if (r15 == r11) goto L17;
        if (getChangedHolderKey(r15) != r10) goto L17;
        Adapter r16 = this.mAdapter;
        if (r16 == null) goto L16;
        if (r16.hasStableIds() == false) goto L16;
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + r15 + " \n View Holder 2:" + r11 + exceptionLabel());
    L16:
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r15 + " \n View Holder 2:" + r11 + exceptionLabel());
    L17:
        r14 = r14 + 1;
        goto L3
    L18:
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r12 + " cannot be found but it is necessary for " + r11 + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int r10 = this.mChildHelper.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getChildAt(r11));
        if (r12 == null) goto L13;
        if (r12.shouldIgnore() == true) goto L13;
        if (r12.isUpdated() == false) goto L13;
        return true;
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) != 0) goto L6;
        ViewCompat.setImportantForAutofill(this, 8);
        return;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new AnonymousClass5(this));
    }

    private boolean isPreferredNextFocus(View r10, View r11, int r12) {
        if (r11 == null) goto L88;
        if (r11 != this) goto L7;
        return false;
    L7:
        if (findContainingItemView(r11) != null) goto L10;
        return false;
    L10:
        if (r10 != null) goto L13;
        return true;
    L13:
        if (findContainingItemView(r10) != null) goto L15;
        return true;
    L15:
        this.mTempRect.set(0, 0, r10.getWidth(), r10.getHeight());
        this.mTempRect2.set(0, 0, r11.getWidth(), r11.getHeight());
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        offsetDescendantRectToMyCoords(r11, this.mTempRect2);
        byte r13 = -1;
        if (this.mLayout.getLayoutDirection() != 1) goto L18;
        int r14 = -1;
    L19:
        Rect r15 = this.mTempRect;
        int r16 = r15.left;
        Rect r17 = this.mTempRect2;
        int r18 = r17.left;
        if (r16 < r18) goto L24;
        if (r15.right <= r18) goto L24;
    L26:
        int r19 = r15.right;
        int r20 = r17.right;
        if (r19 > r20) goto L29;
        if (r16 >= r20) goto L29;
    L31:
        int r21 = 0;
    L32:
        int r22 = r15.top;
        int r23 = r17.top;
        if (r22 < r23) goto L37;
        if (r15.bottom <= r23) goto L37;
    L39:
        int r24 = r15.bottom;
        int r25 = r17.bottom;
        if (r24 > r25) goto L42;
        if (r22 >= r25) goto L42;
    L44:
        r13 = 0;
    L45:
        if (r12 != 1) goto L47;
        if (r13 < 0) goto L81;
        if (r13 == 0) goto L79;
        return false;
    L79:
        if ((r21 * r14) <= 0) goto L81;
        return false;
    L81:
        return true;
    L47:
        if (r12 != 2) goto L49;
        if (r13 > 0) goto L75;
        if (r13 == 0) goto L73;
        return false;
    L73:
        if ((r21 * r14) >= 0) goto L75;
        return false;
    L75:
        return true;
    L49:
        if (r12 != 17) goto L51;
        if (r21 < 0) goto L69;
        return false;
    L69:
        return true;
    L51:
        if (r12 != 33) goto L53;
        if (r13 < 0) goto L66;
        return false;
    L66:
        return true;
    L53:
        if (r12 != 66) goto L55;
        if (r21 > 0) goto L63;
        return false;
    L63:
        return true;
    L55:
        if (r12 != 130) goto L60;
        if (r13 > 0) goto L58;
        return false;
    L58:
        return true;
    L60:
        throw new IllegalArgumentException("Invalid direction: " + r12 + exceptionLabel());
    L42:
        if (r22 <= r23) goto L44;
    L37:
        if (r15.bottom >= r17.bottom) goto L39;
        r13 = 1;
    L29:
        if (r16 <= r18) goto L31;
        r21 = -1;
    L24:
        if (r15.right >= r17.right) goto L26;
        r21 = 1;
        goto L32
    L18:
        r14 = 1;
        goto L19
    L88:
        return false;
    }

    private void onPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.mScrollPointerId) goto L9;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.mScrollPointerId = r10.getPointerId(r12);
        int r13 = (int) (r10.getX(r12) + 0.5f);
        this.mLastTouchX = r13;
        this.mInitialTouchX = r13;
        int r14 = (int) (r10.getY(r12) + 0.5f);
        this.mLastTouchY = r14;
        this.mInitialTouchY = r14;
        return;
    L6:
        r12 = 0;
        goto L7
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.supportsPredictiveItemAnimations() == false) goto L7;
        return true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout == false) goto L8;
        this.mAdapterHelper.reset();
        if (this.mDispatchItemsChangedEvent == false) goto L8;
        this.mLayout.onItemsChanged(this);
    L8:
        if (predictiveItemAnimationsEnabled() == false) goto L10;
        this.mAdapterHelper.preProcess();
    L11:
        boolean r10 = false;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r11 = true;
    L18:
        State r12 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L31:
        boolean r13 = false;
    L32:
        r12.mRunSimpleAnimations = r13;
        State r14 = this.mState;
        if (r14.mRunSimpleAnimations == false) goto L40;
        if (r11 == false) goto L40;
        if (this.mDataSetHasChangedAfterLayout == true) goto L40;
        if (predictiveItemAnimationsEnabled() == false) goto L40;
        r10 = true;
    L40:
        r14.mRunPredictiveAnimations = r10;
        return;
    L21:
        if (this.mItemAnimator == null) goto L31;
        boolean r15 = this.mDataSetHasChangedAfterLayout;
        if (r15 == true) goto L27;
        if (r11 == true) goto L27;
        if (this.mLayout.mRequestedSimpleAnimations == false) goto L31;
    L27:
        if (r15 == true) goto L29;
    L30:
        r13 = true;
        goto L32
    L29:
        if (this.mAdapter.hasStableIds() == false) goto L31;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r11 = false;
        goto L18
    L10:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        goto L11
    }

    private void pullGlows(float r10, float r11, float r12, float r13) {
        boolean r14 = true;
        if (r11 >= 0.0f) goto L7;
        ensureLeftGlow();
        EdgeEffect r15 = this.mLeftGlow;
        float r16 = (-r11) / getWidth();
        float r17 = 1.0f - (r12 / getHeight());
    L5:
        EdgeEffectCompat.onPull(r15, r16, r17);
        boolean r18 = true;
    L11:
        if (r13 >= 0.0f) goto L14;
        ensureTopGlow();
        EdgeEffectCompat.onPull(this.mTopGlow, (-r13) / getHeight(), r10 / getWidth());
    L17:
        if (r14 == false) goto L19;
    L22:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L19:
        if (r11 != 0.0f) goto L22;
        if (r13 != 0.0f) goto L22;
        return;
    L14:
        if (r13 <= 0.0f) goto L16;
        ensureBottomGlow();
        EdgeEffectCompat.onPull(this.mBottomGlow, r13 / getHeight(), 1.0f - (r10 / getWidth()));
        goto L17
    L16:
        r14 = r18;
        goto L17
    L7:
        if (r11 <= 0.0f) goto L9;
        ensureRightGlow();
        r15 = this.mRightGlow;
        r16 = r11 / getWidth();
        r17 = r12 / getHeight();
        goto L5
    L9:
        r18 = false;
        goto L11
    }

    private void recoverFocusFromState() {
        if (this.mPreserveFocusAfterLayout == true) goto L5;
        return;
    L5:
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        if (hasFocus() == true) goto L9;
        return;
    L9:
        if (getDescendantFocusability() != 393216) goto L11;
        return;
    L11:
        if (getDescendantFocusability() != 131072) goto L16;
        if (isFocused() == false) goto L16;
        return;
    L16:
        if (isFocused() == true) goto L30;
        View r10 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r10.getParent() == null) goto L24;
        if (r10.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.getChildCount() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.isHidden(r10) == true) goto L30;
        return;
    L30:
        View r11 = null;
        if (this.mState.mFocusedItemId != (-1)) goto L33;
    L35:
        ViewHolder r12 = null;
    L36:
        if (r12 == null) goto L44;
        if (this.mChildHelper.isHidden(r12.itemView) == true) goto L44;
        if (r12.itemView.hasFocusable() == false) goto L44;
        r11 = r12.itemView;
    L46:
        if (r11 == null) goto L60;
        int r13 = this.mState.mFocusedSubChildId;
        if (r13 == (-1)) goto L54;
        View r14 = r11.findViewById(r13);
        if (r14 == null) goto L54;
        if (r14.isFocusable() == false) goto L54;
        r11 = r14;
    L54:
        r11.requestFocus();
        return;
    L60:
        return;
    L44:
        if (this.mChildHelper.getChildCount() <= 0) goto L46;
        r11 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.hasStableIds() == false) goto L35;
        r12 = findViewHolderForItemId(this.mState.mFocusedItemId);
        goto L36
    }

    private void releaseGlows() {
        EdgeEffect r10 = this.mLeftGlow;
        if (r10 == null) goto L5;
        r10.onRelease();
        boolean r11 = this.mLeftGlow.isFinished();
    L6:
        EdgeEffect r12 = this.mTopGlow;
        if (r12 == null) goto L9;
        r12.onRelease();
        r11 = r11 | this.mTopGlow.isFinished();
    L9:
        EdgeEffect r13 = this.mRightGlow;
        if (r13 == null) goto L12;
        r13.onRelease();
        r11 = r11 | this.mRightGlow.isFinished();
    L12:
        EdgeEffect r14 = this.mBottomGlow;
        if (r14 == null) goto L15;
        r14.onRelease();
        r11 = r11 | this.mBottomGlow.isFinished();
    L15:
        if (r11 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L5:
        r11 = false;
        goto L6
    }

    private void requestChildOnScreen(@NonNull View r12, @Nullable View r13) {
        if (r13 == null) goto L4;
        View r10 = r13;
    L5:
        this.mTempRect.set(0, 0, r10.getWidth(), r10.getHeight());
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof LayoutParams) == false) goto L10;
        LayoutParams r14 = (LayoutParams) r11;
        if (r14.mInsetsDirty == true) goto L10;
        Rect r15 = r14.mDecorInsets;
        Rect r16 = this.mTempRect;
        r16.left -= r15.left;
        r16.right += r15.right;
        r16.top -= r15.top;
        r16.bottom += r15.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        offsetRectIntoDescendantCoords(r12, this.mTempRect);
    L12:
        LayoutManager r17 = this.mLayout;
        Rect r18 = this.mTempRect;
        boolean r19 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r110 = true;
    L16:
        r17.requestChildRectangleOnScreen(this, r12, r18, r19, r110);
        return;
    L15:
        r110 = false;
        goto L16
    L4:
        r10 = r12;
        goto L5
    }

    private void resetFocusInfo() {
        State r10 = this.mState;
        r10.mFocusedItemId = -1;
        r10.mFocusedItemPosition = -1;
        r10.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        ViewHolder r10 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r11 = null;
    L10:
        if (r11 == null) goto L13;
        r10 = findContainingViewHolder(r11);
    L13:
        if (r10 != null) goto L15;
        resetFocusInfo();
        return;
    L15:
        State r12 = this.mState;
        if (this.mAdapter.hasStableIds() == false) goto L18;
        long r13 = r10.getItemId();
    L19:
        r12.mFocusedItemId = r13;
        State r14 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r15 = -1;
    L26:
        r14.mFocusedItemPosition = r15;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(r10.itemView);
        return;
    L23:
        if (r10.isRemoved() == false) goto L25;
        r15 = r10.mOldPosition;
        goto L26
    L25:
        r15 = r10.getAdapterPosition();
        goto L26
    L18:
        r13 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r11 = getFocusedChild();
        goto L10
    }

    private void setAdapterInternal(@Nullable Adapter r10, boolean r11, boolean r12) {
        Adapter r13 = this.mAdapter;
        if (r13 == null) goto L5;
        r13.unregisterAdapterDataObserver(this.mObserver);
        this.mAdapter.onDetachedFromRecyclerView(this);
    L5:
        if (r11 == false) goto L7;
        if (r12 == true) goto L7;
    L8:
        this.mAdapterHelper.reset();
        Adapter r14 = this.mAdapter;
        this.mAdapter = r10;
        if (r10 == null) goto L11;
        r10.registerAdapterDataObserver(this.mObserver);
        r10.onAttachedToRecyclerView(this);
    L11:
        LayoutManager r15 = this.mLayout;
        if (r15 == null) goto L14;
        r15.onAdapterChanged(r14, this.mAdapter);
    L14:
        this.mRecycler.onAdapterChanged(r14, this.mAdapter, r11);
        this.mState.mStructureChanged = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L6;
        r10.stopSmoothScroller();
        return;
    }

    void absorbGlows(int r10, int r11) {
        if (r10 >= 0) goto L6;
        ensureLeftGlow();
        if (this.mLeftGlow.isFinished() == false) goto L10;
        this.mLeftGlow.onAbsorb(-r10);
    L10:
        if (r11 >= 0) goto L14;
        ensureTopGlow();
        if (this.mTopGlow.isFinished() == false) goto L18;
        this.mTopGlow.onAbsorb(-r11);
    L18:
        if (r10 != 0) goto L20;
        if (r11 != 0) goto L20;
        return;
    L20:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L14:
        if (r11 <= 0) goto L18;
        ensureBottomGlow();
        if (this.mBottomGlow.isFinished() == false) goto L18;
        this.mBottomGlow.onAbsorb(r11);
        goto L18
    L6:
        if (r10 <= 0) goto L10;
        ensureRightGlow();
        if (this.mRightGlow.isFinished() == false) goto L10;
        this.mRightGlow.onAbsorb(r10);
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r10, int r11, int r12) {
        LayoutManager r13 = this.mLayout;
        if (r13 != null) goto L5;
    L6:
        super.addFocusables(r10, r11, r12);
        return;
    L5:
        if (r13.onAddFocusables(this, r10, r11, r12) == false) goto L6;
    }

    public void addItemDecoration(@NonNull ItemDecoration r10) {
        addItemDecoration(r10, -1);
    }

    public void addItemDecoration(@NonNull ItemDecoration r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 == null) goto L6;
        r12.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r11 >= 0) goto L10;
        this.mItemDecorations.add(r10);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        this.mItemDecorations.add(r11, r10);
        goto L11
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r10) {
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r10);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener r10) {
        this.mOnItemTouchListeners.add(r10);
    }

    public void addOnScrollListener(@NonNull OnScrollListener r10) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r10);
    }

    void animateAppearance(@NonNull ViewHolder r10, @Nullable ItemAnimator.ItemHolderInfo r11, @NonNull ItemAnimator.ItemHolderInfo r12) {
        r10.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(r10, r11, r12) == false) goto L6;
        postAnimationRunner();
        return;
    }

    void animateDisappearance(@NonNull ViewHolder r10, @NonNull ItemAnimator.ItemHolderInfo r11, @Nullable ItemAnimator.ItemHolderInfo r12) {
        addAnimatingView(r10);
        r10.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(r10, r11, r12) == false) goto L6;
        postAnimationRunner();
        return;
    }

    void assertInLayoutOrScroll(String r10) {
        if (isComputingLayout() == true) goto L9;
        if (r10 != null) goto L8;
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r10 + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String r10) {
        if (isComputingLayout() == false) goto L10;
        if (r10 != null) goto L8;
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r10);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        return;
    }

    boolean canReuseUpdatedViewHolder(ViewHolder r10) {
        ItemAnimator r11 = this.mItemAnimator;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.canReuseUpdatedViewHolder(r10, r10.getUnmodifiedPayloads()) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.checkLayoutParams((LayoutParams) r10) == false) goto L7;
        return true;
    }

    void clearOldPositions() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r11));
        if (r12.shouldIgnore() == true) goto L7;
        r12.clearOldPosition();
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> r10 = this.mOnChildAttachStateListeners;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> r10 = this.mScrollListeners;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    void considerReleasingGlowsOnScroll(int r10, int r11) {
        EdgeEffect r12 = this.mLeftGlow;
        if (r12 != null) goto L5;
    L8:
        boolean r13 = false;
    L9:
        EdgeEffect r14 = this.mRightGlow;
        if (r14 != null) goto L12;
    L15:
        EdgeEffect r15 = this.mTopGlow;
        if (r15 != null) goto L18;
    L21:
        EdgeEffect r16 = this.mBottomGlow;
        if (r16 != null) goto L24;
    L27:
        if (r13 == false) goto L30;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L30:
        return;
    L24:
        if (r16.isFinished() == true) goto L27;
        if (r11 >= 0) goto L27;
        this.mBottomGlow.onRelease();
        r13 = r13 | this.mBottomGlow.isFinished();
        goto L27
    L18:
        if (r15.isFinished() == true) goto L21;
        if (r11 <= 0) goto L21;
        this.mTopGlow.onRelease();
        r13 = r13 | this.mTopGlow.isFinished();
        goto L21
    L12:
        if (r14.isFinished() == true) goto L15;
        if (r10 >= 0) goto L15;
        this.mRightGlow.onRelease();
        r13 = r13 | this.mRightGlow.isFinished();
        goto L15
    L5:
        if (r12.isFinished() == true) goto L8;
        if (r10 <= 0) goto L8;
        this.mLeftGlow.onRelease();
        r13 = this.mLeftGlow.isFinished();
        goto L9
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L26:
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L26;
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L11;
        return;
    L11:
        if (this.mAdapterHelper.hasAnyUpdateTypes(4) == false) goto L22;
        if (this.mAdapterHelper.hasAnyUpdateTypes(11) == true) goto L22;
        TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (this.mLayoutWasDefered == false) goto L17;
    L20:
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
    L24:
        TraceCompat.endSection();
        return;
    L17:
        if (hasUpdatedView() == false) goto L19;
        dispatchLayout();
        goto L20
    L19:
        this.mAdapterHelper.consumePostponedUpdates();
    L22:
        if (this.mAdapterHelper.hasPendingUpdates() == false) goto L28;
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        goto L24
    }

    void defaultOnMeasure(int r10, int r11) {
        setMeasuredDimension(LayoutManager.chooseSize(r10, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(r11, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    void dispatchChildAttached(View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        onChildAttachedToWindow(r10);
        Adapter r12 = this.mAdapter;
        if (r12 == null) goto L6;
        if (r11 == null) goto L6;
        r12.onViewAttachedToWindow(r11);
    L6:
        List<OnChildAttachStateChangeListener> r13 = this.mOnChildAttachStateListeners;
        if (r13 == null) goto L11;
        int r14 = r13.size() - 1;
    L9:
        if (r14 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r14).onChildViewAttachedToWindow(r10);
        r14 = r14 - 1;
        goto L9
    L13:
        return;
    }

    void dispatchChildDetached(View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        onChildDetachedFromWindow(r10);
        Adapter r12 = this.mAdapter;
        if (r12 == null) goto L6;
        if (r11 == null) goto L6;
        r12.onViewDetachedFromWindow(r11);
    L6:
        List<OnChildAttachStateChangeListener> r13 = this.mOnChildAttachStateListeners;
        if (r13 == null) goto L11;
        int r14 = r13.size() - 1;
    L9:
        if (r14 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r14).onChildViewDetachedFromWindow(r10);
        r14 = r14 - 1;
        goto L9
    L13:
        return;
    }

    void dispatchLayout() {
        if (this.mAdapter != null) goto L8;
        String r10 = "No adapter attached; skipping layout";
    L5:
        Log.e(TAG, r10);
        return;
    L8:
        if (this.mLayout != null) goto L10;
        r10 = "No layout manager attached; skipping layout";
        goto L5
    L10:
        State r11 = this.mState;
        r11.mIsMeasuring = false;
        if (r11.mLayoutStep != 1) goto L15;
        dispatchLayoutStep1();
    L13:
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
    L22:
        dispatchLayoutStep3();
        return;
    L15:
        if (this.mAdapterHelper.hasUpdates() == true) goto L13;
        if (this.mLayout.getWidth() != getWidth()) goto L13;
        if (this.mLayout.getHeight() != getHeight()) goto L13;
        this.mLayout.setExactMeasureSpecsFrom(this);
        goto L22
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r10, float r11, boolean r12) {
        return getScrollingChildHelper().dispatchNestedFling(r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r10, float r11) {
        return getScrollingChildHelper().dispatchNestedPreFling(r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r10, r11, r12, r13);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15, @NonNull int[] r16) {
        getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    void dispatchOnScrollStateChanged(int r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L5;
        r11.onScrollStateChanged(r10);
    L5:
        onScrollStateChanged(r10);
        OnScrollListener r12 = this.mScrollListener;
        if (r12 == null) goto L8;
        r12.onScrollStateChanged(this, r10);
    L8:
        List<OnScrollListener> r13 = this.mScrollListeners;
        if (r13 == null) goto L13;
        int r14 = r13.size() - 1;
    L11:
        if (r14 < 0) goto L15;
        this.mScrollListeners.get(r14).onScrollStateChanged(this, r10);
        r14 = r14 - 1;
        goto L11
    L15:
        return;
    }

    void dispatchOnScrolled(int r10, int r11) {
        this.mDispatchScrollCounter++;
        int r12 = getScrollX();
        int r13 = getScrollY();
        onScrollChanged(r12, r13, r12 - r10, r13 - r11);
        onScrolled(r10, r11);
        OnScrollListener r14 = this.mScrollListener;
        if (r14 == null) goto L5;
        r14.onScrolled(this, r10, r11);
    L5:
        List<OnScrollListener> r15 = this.mScrollListeners;
        if (r15 == null) goto L10;
        int r16 = r15.size() - 1;
    L8:
        if (r16 < 0) goto L10;
        this.mScrollListeners.get(r16).onScrolled(this, r10, r11);
        r16 = r16 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int r10 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r10 < 0) goto L13;
        ViewHolder r11 = this.mPendingAccessibilityImportanceChange.get(r10);
        if (r11.itemView.getParent() != this) goto L12;
        if (r11.shouldIgnore() == true) goto L12;
        int r12 = r11.mPendingAccessibilityState;
        if (r12 == (-1)) goto L12;
        ViewCompat.setImportantForAccessibility(r11.itemView, r12);
        r11.mPendingAccessibilityState = -1;
    L12:
        r10 = r10 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        onPopulateAccessibilityEvent(r10);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> r10) {
        dispatchThawSelfOnly(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> r10) {
        dispatchFreezeSelfOnly(r10);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        int r11 = this.mItemDecorations.size();
        boolean r12 = false;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        this.mItemDecorations.get(r13).onDrawOver(r10, this, this.mState);
        r13 = r13 + 1;
        goto L3
    L5:
        EdgeEffect r14 = this.mLeftGlow;
        boolean r15 = true;
        if (r14 != null) goto L8;
    L20:
        boolean r16 = false;
    L21:
        EdgeEffect r17 = this.mTopGlow;
        if (r17 != null) goto L24;
    L35:
        EdgeEffect r18 = this.mRightGlow;
        if (r18 != null) goto L38;
    L50:
        EdgeEffect r19 = this.mBottomGlow;
        if (r19 != null) goto L53;
    L64:
        if (r16 == false) goto L66;
    L72:
        r15 = r16;
    L73:
        if (r15 == false) goto L77;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L77:
        return;
    L66:
        if (this.mItemAnimator == null) goto L72;
        if (this.mItemDecorations.size() <= 0) goto L72;
        if (this.mItemAnimator.isRunning() == false) goto L72;
    L53:
        if (r19.isFinished() == true) goto L64;
        int r20 = r10.save();
        r10.rotate(180.0f);
        if (this.mClipToPadding == false) goto L57;
        float r21 = (-getWidth()) + getPaddingRight();
        int r22 = (-getHeight()) + getPaddingBottom();
    L58:
        r10.translate(r21, r22);
        EdgeEffect r23 = this.mBottomGlow;
        if (r23 != null) goto L61;
    L63:
        r16 = r16 | r12;
        r10.restoreToCount(r20);
        goto L64
    L61:
        if (r23.draw(r10) == false) goto L63;
        r12 = true;
        goto L63
    L57:
        r21 = -getWidth();
        r22 = -getHeight();
        goto L58
    L38:
        if (r18.isFinished() == true) goto L50;
        int r24 = r10.save();
        int r25 = getWidth();
        if (this.mClipToPadding == false) goto L42;
        int r26 = getPaddingTop();
    L43:
        r10.rotate(90.0f);
        r10.translate(-r26, -r25);
        EdgeEffect r27 = this.mRightGlow;
        if (r27 != null) goto L46;
    L48:
        boolean r28 = false;
    L49:
        r16 = r16 | r28;
        r10.restoreToCount(r24);
        goto L50
    L46:
        if (r27.draw(r10) == false) goto L48;
        r28 = true;
        goto L49
    L42:
        r26 = 0;
        goto L43
    L24:
        if (r17.isFinished() == true) goto L35;
        int r29 = r10.save();
        if (this.mClipToPadding == false) goto L28;
        r10.translate(getPaddingLeft(), getPaddingTop());
    L28:
        EdgeEffect r30 = this.mTopGlow;
        if (r30 != null) goto L31;
    L33:
        boolean r31 = false;
    L34:
        r16 = r16 | r31;
        r10.restoreToCount(r29);
        goto L35
    L31:
        if (r30.draw(r10) == false) goto L33;
        r31 = true;
        goto L34
    L8:
        if (r14.isFinished() == true) goto L20;
        int r32 = r10.save();
        if (this.mClipToPadding == false) goto L12;
        int r33 = getPaddingBottom();
    L13:
        r10.rotate(270.0f);
        r10.translate((-getHeight()) + r33, 0.0f);
        EdgeEffect r34 = this.mLeftGlow;
        if (r34 != null) goto L16;
    L18:
        r16 = false;
    L19:
        r10.restoreToCount(r32);
        goto L21
    L16:
        if (r34.draw(r10) == false) goto L18;
        r16 = true;
        goto L19
    L12:
        r33 = 0;
        goto L13
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        return super.drawChild(r10, r11, r12);
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r10 = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        this.mBottomGlow = r10;
        if (this.mClipToPadding == false) goto L8;
        r10.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r10.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r10 = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        this.mLeftGlow = r10;
        if (this.mClipToPadding == false) goto L8;
        r10.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r10.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r10 = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        this.mRightGlow = r10;
        if (this.mClipToPadding == false) goto L8;
        r10.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r10.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r10 = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        this.mTopGlow = r10;
        if (this.mClipToPadding == false) goto L8;
        r10.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r10.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    final void fillRemainingScrollValues(State r10) {
        if (getScrollState() != 2) goto L5;
        OverScroller r11 = this.mViewFlinger.mOverScroller;
        r10.mRemainingScrollHorizontal = r11.getFinalX() - r11.getCurrX();
        r10.mRemainingScrollVertical = r11.getFinalY() - r11.getCurrY();
        return;
    L5:
        r10.mRemainingScrollHorizontal = 0;
        r10.mRemainingScrollVertical = 0;
    }

    @Nullable
    public View findChildViewUnder(float r10, float r11) {
        int r12 = this.mChildHelper.getChildCount() - 1;
    L3:
        if (r12 < 0) goto L14;
        View r13 = this.mChildHelper.getChildAt(r12);
        float r14 = r13.getTranslationX();
        float r15 = r13.getTranslationY();
        if (r10 < (r13.getLeft() + r14)) goto L13;
        if (r10 > (r13.getRight() + r14)) goto L13;
        if (r11 < (r13.getTop() + r15)) goto L13;
        if (r11 > (r13.getBottom() + r15)) goto L13;
        return r13;
    L13:
        r12 = r12 - 1;
        goto L3
    L14:
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View r10) {
    L2:
        Object r11 = r10.getParent();
        if (r11 == null) goto L8;
        if (r11 == this) goto L8;
        if ((r11 instanceof View) == false) goto L8;
        r10 = (View) r11;
    L8:
        if (r11 == this) goto L15;
        return null;
    L15:
        return r10;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View r10) {
        View r11 = findContainingItemView(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r11);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int r10) {
        ViewHolder r11 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L18;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r13));
        if (r14 == null) goto L17;
        if (r14.isRemoved() == true) goto L17;
        if (getAdapterPositionFor(r14) != r10) goto L17;
        if (this.mChildHelper.isHidden(r14.itemView) == false) goto L16;
        r11 = r14;
        goto L17
    L16:
        return r14;
    L17:
        r13 = r13 + 1;
        goto L6
    L18:
        return r11;
    }

    public ViewHolder findViewHolderForItemId(long r10) {
        Adapter r11 = this.mAdapter;
        ViewHolder r12 = null;
        if (r11 != null) goto L5;
    L20:
        return r12;
    L5:
        if (r11.hasStableIds() == false) goto L20;
        int r13 = this.mChildHelper.getUnfilteredChildCount();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L20;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r14));
        if (r15 == null) goto L19;
        if (r15.isRemoved() == true) goto L19;
        if (r15.getItemId() != r10) goto L19;
        if (this.mChildHelper.isHidden(r15.itemView) == false) goto L18;
        r12 = r15;
        goto L19
    L18:
        return r15;
    L19:
        r14 = r14 + 1;
        goto L8
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int r10) {
        return findViewHolderForPosition(r10, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int r10) {
        return findViewHolderForPosition(r10, false);
    }

    @Nullable
    ViewHolder findViewHolderForPosition(int r10, boolean r11) {
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L20;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r14));
        if (r15 == null) goto L19;
        if (r15.isRemoved() == true) goto L19;
        if (r11 == false) goto L13;
        if (r15.mPosition != r10) goto L19;
    L16:
        if (this.mChildHelper.isHidden(r15.itemView) == false) goto L18;
        r13 = r15;
        goto L19
    L18:
        return r15;
    L13:
        if (r15.getLayoutPosition() == r10) goto L16;
    L19:
        r14 = r14 + 1;
        goto L3
    L20:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 != null) goto L7;
        Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        int r13 = r12.canScrollHorizontally();
        boolean r14 = this.mLayout.canScrollVertically();
        if (r13 != 0) goto L12;
    L13:
        r10 = 0;
    L14:
        if (r14 == true) goto L16;
    L17:
        r11 = 0;
    L18:
        if (r10 != 0) goto L21;
        if (r11 != 0) goto L21;
        return false;
    L21:
        float r15 = r10;
        float r16 = r11;
        if (dispatchNestedPreFling(r15, r16) == false) goto L24;
    L39:
        return false;
    L24:
        if (r13 != 0) goto L28;
        if (r14 == true) goto L28;
        boolean r17 = false;
    L29:
        dispatchNestedFling(r15, r16, r17);
        OnFlingListener r18 = this.mOnFlingListener;
        if (r18 != null) goto L32;
    L34:
        if (r17 == false) goto L39;
        if (r14 == false) goto L37;
        r13 = (r13 == true ? 1 : 0) | 2;
    L37:
        startNestedScroll(r13, 1);
        int r19 = this.mMaxFlingVelocity;
        int r20 = Math.max(-r19, Math.min(r10, r19));
        int r21 = this.mMaxFlingVelocity;
        this.mViewFlinger.fling(r20, Math.max(-r21, Math.min(r11, r21)));
        return true;
    L32:
        if (r18.onFling(r10, r11) == false) goto L34;
        return true;
    L28:
        r17 = true;
        goto L29
    L16:
        if (Math.abs(r11) >= this.mMinFlingVelocity) goto L18;
    L12:
        if (Math.abs(r10) >= this.mMinFlingVelocity) goto L14;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r10, int r11) {
        View r12 = this.mLayout.onInterceptFocusSearch(r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        boolean r13 = true;
        if (this.mAdapter != null) goto L8;
    L14:
        boolean r14 = false;
    L15:
        FocusFinder r15 = FocusFinder.getInstance();
        if (r14 == true) goto L18;
    L61:
        View r16 = r15.findNextFocus(this, r10, r11);
        if (r16 != null) goto L68;
        if (r14 == false) goto L68;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L67;
        return null;
    L67:
        startInterceptRequestLayout();
        View r17 = this.mLayout.onFocusSearchFailed(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L69:
        if (r17 == null) goto L79;
        if (r17.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        requestChildOnScreen(r17, null);
        return r10;
    L75:
        return super.focusSearch(r10, r11);
    L79:
        if (isPreferredNextFocus(r10, r17, r11) == false) goto L82;
        return r17;
    L82:
        return super.focusSearch(r10, r11);
    L68:
        r17 = r16;
        goto L69
    L18:
        if (r11 == 2) goto L21;
        if (r11 != 1) goto L61;
    L21:
        if (this.mLayout.canScrollVertically() == false) goto L32;
        if (r11 != 2) goto L24;
        int r18 = 130;
    L26:
        if (r15.findNextFocus(this, r10, r18) != null) goto L28;
        boolean r19 = true;
    L30:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L33;
        r11 = r18;
    L33:
        if (r19 == false) goto L35;
    L55:
        if (r19 == false) goto L60;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L59;
        return null;
    L59:
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r17 = r15.findNextFocus(this, r10, r11);
        goto L69
    L35:
        if (this.mLayout.canScrollHorizontally() == false) goto L55;
        if (this.mLayout.getLayoutDirection() != 1) goto L39;
        boolean r20 = true;
    L40:
        if (r11 != 2) goto L42;
        boolean r21 = true;
    L44:
        if ((r20 ^ r21) == false) goto L46;
        int r22 = 66;
    L48:
        if (r15.findNextFocus(this, r10, r22) == null) goto L52;
        r13 = false;
    L52:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L54;
        r11 = r22;
    L54:
        r19 = r13;
        goto L55
    L46:
        r22 = 17;
        goto L48
    L42:
        r21 = false;
        goto L44
    L39:
        r20 = false;
        goto L40
    L28:
        r19 = false;
        goto L30
    L24:
        r18 = 33;
        goto L26
    L32:
        r19 = false;
        goto L33
    L8:
        if (this.mLayout == null) goto L14;
        if (isComputingLayout() == true) goto L14;
        if (this.mLayoutSuppressed == true) goto L14;
        r14 = true;
        goto L15
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.generateDefaultLayoutParams();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L7;
        return r11.generateLayoutParams(getContext(), r10);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L7;
        return r11.generateLayoutParams(r10);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionFor(ViewHolder r10) {
        if (r10.hasAnyOfTheFlags(524) == false) goto L5;
        return -1;
    L5:
        if (r10.isBound() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.applyPendingUpdatesToPosition(r10.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.getBaseline();
    L7:
        return super.getBaseline();
    }

    long getChangedHolderKey(ViewHolder r10) {
        if (this.mAdapter.hasStableIds() == false) goto L6;
        return r10.getItemId();
    L6:
        return r10.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        if (r11 != null) goto L7;
        return -1;
    L7:
        return r11.getAdapterPosition();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int r10, int r11) {
        ChildDrawingOrderCallback r12 = this.mChildDrawingOrderCallback;
        if (r12 != null) goto L7;
        return super.getChildDrawingOrder(r10, r11);
    L7:
        return r12.onGetChildDrawingOrder(r10, r11);
    }

    public long getChildItemId(@NonNull View r10) {
        Adapter r11 = this.mAdapter;
        if (r11 != null) goto L5;
        return -1;
    L5:
        if (r11.hasStableIds() == false) goto L13;
        ViewHolder r12 = getChildViewHolderInt(r10);
        if (r12 != null) goto L10;
        return -1;
    L10:
        return r12.getItemId();
    L13:
        return -1;
    }

    public int getChildLayoutPosition(@NonNull View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        if (r11 != null) goto L7;
        return -1;
    L7:
        return r11.getLayoutPosition();
    }

    @Deprecated
    public int getChildPosition(@NonNull View r10) {
        return getChildAdapterPosition(r10);
    }

    public ViewHolder getChildViewHolder(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L9;
        if (r11 == this) goto L9;
        throw new IllegalArgumentException("View " + r10 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View r10, @NonNull Rect r11) {
        getDecoratedBoundsWithMarginsInt(r10, r11);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if (r11.mInsetsDirty == true) goto L7;
        return r11.mDecorInsets;
    L7:
        if (this.mState.isPreLayout() == true) goto L9;
    L14:
        Rect r12 = r11.mDecorInsets;
        r12.set(0, 0, 0, 0);
        int r13 = this.mItemDecorations.size();
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        this.mItemDecorations.get(r14).getItemOffsets(this.mTempRect, r10, this, this.mState);
        int r15 = r12.left;
        Rect r16 = this.mTempRect;
        r12.left = r15 + r16.left;
        r12.top += r16.top;
        r12.right += r16.right;
        r12.bottom += r16.bottom;
        r14 = r14 + 1;
        goto L15
    L17:
        r11.mInsetsDirty = false;
        return r12;
    L9:
        if (r11.isItemChanged() == true) goto L13;
        if (r11.isViewInvalid() == false) goto L14;
    L13:
        return r11.mDecorInsets;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int r10) {
        int r11 = getItemDecorationCount();
        if (r10 < 0) goto L8;
        if (r10 >= r11) goto L8;
        return this.mItemDecorations.get(r10);
    L8:
        throw new IndexOutOfBoundsException(r10 + " is an invalid index for size " + r11);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r10) {
        return getScrollingChildHelper().hasNestedScrollingParent(r10);
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L10;
        return false;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AnonymousClass6(this));
    }

    @VisibleForTesting
    void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r10 = getContext().getResources();
        new FastScroller(this, r11, r12, r13, r14, r10.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), r10.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), r10.getDimensionPixelOffset(R.dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L8;
        r10.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager r10 = this.mAccessibilityManager;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isEnabled() == false) goto L7;
        return true;
    }

    public boolean isAnimating() {
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isRunning() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    void jumpToPositionForSmoothScroller(int r10) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.scrollToPosition(r10);
        awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(r11).getLayoutParams()).mInsetsDirty = true;
        r11 = r11 + 1;
        goto L3
    L5:
        this.mRecycler.markItemDecorInsetsDirty();
    }

    void markKnownViewsInvalid() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r11));
        if (r12 == null) goto L9;
        if (r12.shouldIgnore() == true) goto L9;
        r12.addFlags(6);
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void offsetChildrenHorizontal(@Px int r10) {
        int r11 = this.mChildHelper.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mChildHelper.getChildAt(r12).offsetLeftAndRight(r10);
        r12 = r12 + 1;
        goto L3
    }

    public void offsetChildrenVertical(@Px int r10) {
        int r11 = this.mChildHelper.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mChildHelper.getChildAt(r12).offsetTopAndBottom(r10);
        r12 = r12 + 1;
        goto L3
    }

    void offsetPositionRecordsForInsert(int r10, int r11) {
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r13));
        if (r14 == null) goto L11;
        if (r14.shouldIgnore() == true) goto L11;
        if (r14.mPosition < r10) goto L11;
        r14.offsetPosition(r11, false);
        this.mState.mStructureChanged = true;
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        this.mRecycler.offsetPositionRecordsForInsert(r10, r11);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int r10, int r11) {
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        if (r10 >= r11) goto L5;
        int r13 = -1;
        int r14 = r10;
        int r15 = r11;
    L6:
        int r16 = 0;
    L7:
        if (r16 >= r12) goto L19;
        ViewHolder r17 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r16));
        if (r17 == null) goto L18;
        int r18 = r17.mPosition;
        if (r18 < r14) goto L18;
        if (r18 > r15) goto L18;
        if (r18 != r10) goto L16;
        r17.offsetPosition(r11 - r10, false);
    L17:
        this.mState.mStructureChanged = true;
        goto L18
    L16:
        r17.offsetPosition(r13, false);
    L18:
        r16 = r16 + 1;
        goto L7
    L19:
        this.mRecycler.offsetPositionRecordsForMove(r10, r11);
        requestLayout();
        return;
    L5:
        r15 = r10;
        r14 = r11;
        r13 = 1;
        goto L6
    }

    void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
        int r13 = r10 + r11;
        int r14 = this.mChildHelper.getUnfilteredChildCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L15;
        ViewHolder r16 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r15));
        if (r16 == null) goto L14;
        if (r16.shouldIgnore() == true) goto L14;
        int r17 = r16.mPosition;
        if (r17 < r13) goto L12;
        r16.offsetPosition(-r11, r12);
    L11:
        this.mState.mStructureChanged = true;
        goto L14
    L12:
        if (r17 < r10) goto L14;
        r16.flagRemovedAndOffsetPosition(r10 - 1, -r11, r12);
    L14:
        r15 = r15 + 1;
        goto L3
    L15:
        this.mRecycler.offsetPositionRecordsForRemove(r10, r11, r12);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r10 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r10 = false;
    L8:
        this.mFirstLayoutComplete = r10;
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L11;
        r11.dispatchAttachedToWindow(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L24;
        ThreadLocal<GapWorker> r12 = GapWorker.sGapWorker;
        GapWorker r13 = r12.get();
        this.mGapWorker = r13;
        if (r13 != null) goto L22;
        this.mGapWorker = new GapWorker();
        Display r14 = ViewCompat.getDisplay(this);
        float r15 = 60.0f;
        if (isInEditMode() == true) goto L21;
        if (r14 == null) goto L21;
        float r16 = r14.getRefreshRate();
        if (r16 < 30.0f) goto L21;
        r15 = r16;
    L21:
        GapWorker r17 = this.mGapWorker;
        r17.mFrameIntervalNs = (long) (1.0E9f / r15);
        r12.set(r17);
    L22:
        this.mGapWorker.add(this);
        return;
    L24:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    public void onChildAttachedToWindow(@NonNull View r10) {
    }

    public void onChildDetachedFromWindow(@NonNull View r10) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 == null) goto L5;
        r10.endAnimations();
    L5:
        stopScroll();
        this.mIsAttached = false;
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L8;
        r11.dispatchDetachedFromWindow(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        GapWorker r12 = this.mGapWorker;
        if (r12 == null) goto L15;
        r12.remove(this);
        this.mGapWorker = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        int r11 = this.mItemDecorations.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mItemDecorations.get(r12).onDraw(r10, this, this.mState);
        r12 = r12 + 1;
        goto L3
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean r10) {
        int r11 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r11;
        if (r11 >= 1) goto L8;
        this.mLayoutOrScrollCounter = 0;
        if (r10 == false) goto L9;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r10) {
        if (this.mLayout != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        if (r10.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r10.getSource() & 2) == 0) goto L21;
        if (this.mLayout.canScrollVertically() == false) goto L15;
        float r11 = -r10.getAxisValue(9);
    L17:
        if (this.mLayout.canScrollHorizontally() == false) goto L19;
        float r12 = r10.getAxisValue(10);
    L30:
        if (r11 == 0.0f) goto L32;
    L33:
        scrollByInternal((int) (r12 * this.mScaledHorizontalScrollFactor), (int) (r11 * this.mScaledVerticalScrollFactor), r10);
        goto L34
    L32:
        if (r12 == 0.0f) goto L34;
    L19:
        r12 = 0.0f;
        goto L30
    L15:
        r11 = 0.0f;
        goto L17
    L21:
        if ((r10.getSource() & 4194304) == 0) goto L28;
        float r13 = r10.getAxisValue(26);
        if (this.mLayout.canScrollVertically() == false) goto L26;
        r11 = -r13;
        goto L19
    L26:
        if (this.mLayout.canScrollHorizontally() == false) goto L28;
        r12 = r13;
        r11 = 0.0f;
    L28:
        r11 = 0.0f;
        r12 = 0.0f;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.mLayoutSuppressed == false) goto L5;
        return false;
    L5:
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(r10) == false) goto L9;
        cancelScroll();
        return true;
    L9:
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L12;
        return false;
    L12:
        boolean r12 = r11.canScrollHorizontally();
        boolean r13 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = VelocityTracker.obtain();
    L15:
        this.mVelocityTracker.addMovement(r10);
        int r14 = r10.getActionMasked();
        int r15 = r10.getActionIndex();
        if (r14 == 0) goto L49;
        if (r14 == 1) goto L47;
        if (r14 != 2) goto L20;
        int r16 = r10.findPointerIndex(this.mScrollPointerId);
        if (r16 >= 0) goto L33;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r17 = (int) (r10.getX(r16) + 0.5f);
        int r18 = (int) (r10.getY(r16) + 0.5f);
        if (this.mScrollState == 1) goto L59;
        int r19 = r17 - this.mInitialTouchX;
        int r20 = r18 - this.mInitialTouchY;
        if (r12 == true) goto L38;
    L40:
        boolean r21 = false;
    L41:
        if (r13 == true) goto L43;
    L45:
        if (r21 == false) goto L59;
        setScrollState(1);
        goto L59
    L43:
        if (Math.abs(r20) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r18;
        r21 = true;
        goto L45
    L38:
        if (Math.abs(r19) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r17;
        r21 = true;
    L59:
        if (this.mScrollState == 1) goto L61;
        return false;
    L61:
        return true;
    L20:
        if (r14 != 3) goto L22;
        cancelScroll();
        goto L59
    L22:
        if (r14 != 5) goto L24;
        this.mScrollPointerId = r10.getPointerId(r15);
        int r22 = (int) (r10.getX(r15) + 0.5f);
        this.mLastTouchX = r22;
        this.mInitialTouchX = r22;
        int r23 = (int) (r10.getY(r15) + 0.5f);
        this.mLastTouchY = r23;
        this.mInitialTouchY = r23;
        goto L59
    L24:
        if (r14 != 6) goto L59;
        onPointerUp(r10);
        goto L59
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L59
    L49:
        if (this.mIgnoreMotionEventTillDown == false) goto L51;
        this.mIgnoreMotionEventTillDown = false;
    L51:
        this.mScrollPointerId = r10.getPointerId(0);
        int r24 = (int) (r10.getX() + 0.5f);
        this.mLastTouchX = r24;
        this.mInitialTouchX = r24;
        int r25 = (int) (r10.getY() + 0.5f);
        this.mLastTouchY = r25;
        this.mInitialTouchY = r25;
        if (this.mScrollState != 2) goto L54;
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
    L54:
        int[] r26 = this.mNestedOffsets;
        r26[1] = 0;
        r26[0] = 0;
        int r27 = r12;
        if (r13 == false) goto L57;
        r27 = (r12 ? 1 : 0) | 2;
    L57:
        startNestedScroll(r27, 0);
        goto L59
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 != null) goto L6;
        defaultOnMeasure(r10, r11);
        return;
    L6:
        boolean r13 = false;
        if (r12.isAutoMeasureEnabled() == false) goto L24;
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getMode(r11);
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        if (r14 != 1073741824) goto L12;
        if (r15 != 1073741824) goto L12;
        r13 = true;
    L12:
        if (r13 == false) goto L14;
        return;
    L14:
        if (this.mAdapter != null) goto L17;
        return;
    L17:
        if (this.mState.mLayoutStep != 1) goto L19;
        dispatchLayoutStep1();
    L19:
        this.mLayout.setMeasureSpecs(r10, r11);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r10, r11);
        if (this.mLayout.shouldMeasureTwice() == false) goto L45;
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r10, r11);
        return;
    L45:
        return;
    L24:
        if (this.mHasFixedSize == false) goto L28;
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        return;
    L28:
        if (this.mAdapterUpdateDuringMeasure == false) goto L35;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        State r16 = this.mState;
        if (r16.mRunPredictiveAnimations == false) goto L32;
        r16.mInPreLayout = true;
    L33:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L38:
        Adapter r17 = this.mAdapter;
        if (r17 == null) goto L41;
        this.mState.mItemCount = r17.getItemCount();
    L42:
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
        return;
    L41:
        this.mState.mItemCount = 0;
        goto L42
    L32:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mInPreLayout = false;
        goto L33
    L35:
        if (this.mState.mRunPredictiveAnimations == false) goto L38;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int r10, Rect r11) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r10, r11);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        this.mPendingSavedState = r11;
        super.onRestoreInstanceState(r11.getSuperState());
        LayoutManager r12 = this.mLayout;
        if (r12 == null) goto L12;
        Parcelable r13 = this.mPendingSavedState.mLayoutState;
        if (r13 == null) goto L13;
        r12.onRestoreInstanceState(r13);
        return;
    L13:
        return;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        SavedState r11 = this.mPendingSavedState;
        if (r11 == null) goto L5;
        r10.copyFrom(r11);
    L10:
        return r10;
    L5:
        LayoutManager r12 = this.mLayout;
        if (r12 == null) goto L8;
        Parcelable r13 = r12.onSaveInstanceState();
    L9:
        r10.mLayoutState = r13;
        goto L10
    L8:
        r13 = null;
        goto L9
    }

    public void onScrollStateChanged(int r10) {
    }

    public void onScrolled(@Px int r10, @Px int r11) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 != r12) goto L5;
        if (r11 != r13) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        boolean r10 = false;
        if (this.mLayoutSuppressed == false) goto L5;
    L108:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L108;
        if (dispatchToOnItemTouchListeners(r18) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L14;
        return false;
    L14:
        boolean r12 = r11.canScrollHorizontally();
        boolean r13 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = VelocityTracker.obtain();
    L17:
        int r14 = r18.getActionMasked();
        int r15 = r18.getActionIndex();
        if (r14 != 0) goto L20;
        int[] r16 = this.mNestedOffsets;
        r16[1] = 0;
        r16[0] = 0;
    L20:
        MotionEvent r17 = MotionEvent.obtain(r18);
        int[] r19 = this.mNestedOffsets;
        r17.offsetLocation(r19[0], r19[1]);
        if (r14 == 0) goto L100;
        if (r14 != 1) goto L24;
        this.mVelocityTracker.addMovement(r17);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r12 == false) goto L88;
        float r20 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L89:
        if (r13 == false) goto L91;
        float r21 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L93:
        if (r20 != 0.0f) goto L97;
        if (r21 != 0.0f) goto L97;
    L98:
        setScrollState(0);
    L99:
        resetScroll();
        r10 = true;
    L104:
        if (r10 == true) goto L106;
        this.mVelocityTracker.addMovement(r17);
    L106:
        r17.recycle();
        return true;
    L97:
        if (fling((int) r20, (int) r21) == true) goto L99;
    L91:
        r21 = 0.0f;
        goto L93
    L88:
        r20 = 0.0f;
        goto L89
    L24:
        if (r14 != 2) goto L26;
        int r22 = r18.findPointerIndex(this.mScrollPointerId);
        if (r22 >= 0) goto L39;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L39:
        int r110 = (int) (r18.getX(r22) + 0.5f);
        int r111 = (int) (r18.getY(r22) + 0.5f);
        int r23 = this.mLastTouchX - r110;
        int r24 = this.mLastTouchY - r111;
        if (this.mScrollState == 1) goto L58;
        if (r12 == false) goto L48;
        int r25 = this.mTouchSlop;
        if (r23 <= 0) goto L45;
        r23 = Math.max(0, r23 - r25);
    L46:
        if (r23 == 0) goto L48;
        boolean r26 = true;
    L49:
        if (r13 == false) goto L56;
        int r27 = this.mTouchSlop;
        if (r24 <= 0) goto L53;
        r24 = Math.max(0, r24 - r27);
    L54:
        if (r24 == 0) goto L56;
        r26 = true;
        goto L56
    L53:
        r24 = Math.min(0, r24 + r27);
    L56:
        if (r26 == false) goto L58;
        setScrollState(1);
        goto L58
    L45:
        r23 = Math.min(0, r23 + r25);
    L48:
        r26 = false;
    L58:
        int r112 = r23;
        int r113 = r24;
        if (this.mScrollState != 1) goto L104;
        int[] r28 = this.mReusableIntPair;
        r28[0] = 0;
        r28[1] = 0;
        if (r12 == false) goto L63;
        int r29 = r112;
    L64:
        if (r13 == false) goto L66;
        int r30 = r113;
    L68:
        if (dispatchNestedPreScroll(r29, r30, r28, this.mScrollOffset, 0) == false) goto L70;
        int[] r31 = this.mReusableIntPair;
        r112 = r112 - r31[0];
        r113 = r113 - r31[1];
        int[] r32 = this.mNestedOffsets;
        int r33 = r32[0];
        int[] r34 = this.mScrollOffset;
        r32[0] = r33 + r34[0];
        r32[1] = r32[1] + r34[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L70:
        int r35 = r113;
        int[] r36 = this.mScrollOffset;
        this.mLastTouchX = r110 - r36[0];
        this.mLastTouchY = r111 - r36[1];
        if (r12 == false) goto L73;
        int r37 = r112;
    L74:
        if (r13 == false) goto L76;
        int r38 = r35;
    L78:
        if (scrollByInternal(r37, r38, r18) == false) goto L80;
        getParent().requestDisallowInterceptTouchEvent(true);
    L80:
        GapWorker r39 = this.mGapWorker;
        if (r39 == null) goto L104;
        if (r112 != 0) goto L84;
        if (r35 == 0) goto L104;
    L84:
        r39.postFromTraversal(this, r112, r35);
        goto L104
    L76:
        r38 = 0;
        goto L78
    L73:
        r37 = 0;
        goto L74
    L66:
        r30 = 0;
        goto L68
    L63:
        r29 = 0;
        goto L64
    L26:
        if (r14 != 3) goto L28;
        cancelScroll();
        goto L104
    L28:
        if (r14 != 5) goto L30;
        this.mScrollPointerId = r18.getPointerId(r15);
        int r40 = (int) (r18.getX(r15) + 0.5f);
        this.mLastTouchX = r40;
        this.mInitialTouchX = r40;
        int r41 = (int) (r18.getY(r15) + 0.5f);
        this.mLastTouchY = r41;
        this.mInitialTouchY = r41;
        goto L104
    L30:
        if (r14 != 6) goto L104;
        onPointerUp(r18);
        goto L104
    L100:
        this.mScrollPointerId = r18.getPointerId(0);
        int r42 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r42;
        this.mInitialTouchX = r42;
        int r43 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r43;
        this.mInitialTouchY = r43;
        int r114 = r12;
        if (r13 == false) goto L103;
        r114 = (r12 ? 1 : 0) | 2;
    L103:
        startNestedScroll(r114, 0);
        goto L104
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
        return;
    }

    void processDataSetCompletelyChanged(boolean r10) {
        this.mDispatchItemsChangedEvent = r10 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder r10, ItemAnimator.ItemHolderInfo r11) {
        r10.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders == true) goto L5;
    L11:
        this.mViewInfoStore.addToPreLayout(r10, r11);
        return;
    L5:
        if (r10.isUpdated() == false) goto L11;
        if (r10.isRemoved() == true) goto L11;
        if (r10.shouldIgnore() == true) goto L11;
        long r12 = getChangedHolderKey(r10);
        this.mViewInfoStore.addToOldChangeHolders(r12, r10);
        goto L11
    }

    void removeAndRecycleViews() {
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 == null) goto L5;
        r10.endAnimations();
    L5:
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L8;
        r11.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    L8:
        this.mRecycler.clear();
    }

    boolean removeAnimatingView(View r10) {
        startInterceptRequestLayout();
        boolean r11 = this.mChildHelper.removeViewIfHidden(r10);
        if (r11 == false) goto L5;
        ViewHolder r12 = getChildViewHolderInt(r10);
        this.mRecycler.unscrapView(r12);
        this.mRecycler.recycleViewHolderInternal(r12);
    L5:
        stopInterceptRequestLayout(!r11);
        return r11;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View r10, boolean r11) {
        ViewHolder r12 = getChildViewHolderInt(r10);
        if (r12 != null) goto L5;
    L12:
        r10.clearAnimation();
        dispatchChildDetached(r10);
        super.removeDetachedView(r10, r11);
        return;
    L5:
        if (r12.isTmpDetached() == false) goto L8;
        r12.clearTmpDetachFlag();
        goto L12
    L8:
        if (r12.shouldIgnore() == true) goto L12;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r12 + exceptionLabel());
    }

    public void removeItemDecoration(@NonNull ItemDecoration r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L5;
        r11.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r10);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r12 = true;
    L11:
        setWillNotDraw(r12);
        goto L12
    L10:
        r12 = false;
        goto L11
    }

    public void removeItemDecorationAt(int r10) {
        int r11 = getItemDecorationCount();
        if (r10 < 0) goto L8;
        if (r10 >= r11) goto L8;
        removeItemDecoration(getItemDecorationAt(r10));
        return;
    L8:
        throw new IndexOutOfBoundsException(r10 + " is an invalid index for size " + r11);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r10) {
        List<OnChildAttachStateChangeListener> r11 = this.mOnChildAttachStateListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener r10) {
        this.mOnItemTouchListeners.remove(r10);
        if (this.mInterceptingOnItemTouchListener != r10) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    public void removeOnScrollListener(@NonNull OnScrollListener r10) {
        List<OnScrollListener> r11 = this.mScrollListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    void repositionShadowingViews() {
        int r10 = this.mChildHelper.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        View r12 = this.mChildHelper.getChildAt(r11);
        ViewHolder r13 = getChildViewHolder(r12);
        if (r13 == null) goto L13;
        ViewHolder r14 = r13.mShadowingHolder;
        if (r14 == null) goto L13;
        View r15 = r14.itemView;
        int r16 = r12.getLeft();
        int r17 = r12.getTop();
        if (r16 == r15.getLeft()) goto L11;
    L12:
        r15.layout(r16, r17, r15.getWidth() + r16, r15.getHeight() + r17);
        goto L13
    L11:
        if (r17 != r15.getTop()) goto L12;
    L13:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r10, View r11) {
        if (this.mLayout.onRequestChildFocus(this, this.mState, r10, r11) == true) goto L6;
        if (r11 == null) goto L6;
        requestChildOnScreen(r10, r11);
    L6:
        super.requestChildFocus(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r10, Rect r11, boolean r12) {
        return this.mLayout.requestChildRectangleOnScreen(this, r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        int r11 = this.mOnItemTouchListeners.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mOnItemTouchListeners.get(r12).onRequestDisallowInterceptTouchEvent(r10);
        r12 = r12 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0) goto L5;
    L7:
        this.mLayoutWasDefered = true;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L7;
        super.requestLayout();
    }

    void saveOldPositions() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r11));
        if (r12.shouldIgnore() == true) goto L7;
        r12.saveOldPosition();
    L7:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.view.View
    public void scrollBy(int r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r13 = r12.canScrollHorizontally();
        boolean r14 = this.mLayout.canScrollVertically();
        if (r13 == true) goto L13;
        if (r14 == true) goto L13;
        return;
    L13:
        if (r13 == true) goto L16;
        r10 = 0;
    L16:
        if (r14 == true) goto L19;
        r11 = 0;
    L19:
        scrollByInternal(r10, r11, null);
    }

    boolean scrollByInternal(int r19, int r20, MotionEvent r21) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r10 = this.mReusableIntPair;
        r10[0] = 0;
        r10[1] = 0;
        scrollStep(r19, r20, r10);
        int[] r11 = this.mReusableIntPair;
        int r12 = r11[0];
        int r13 = r11[1];
        int r14 = r13;
        int r15 = r12;
        int r16 = r19 - r12;
        int r17 = r20 - r13;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r18 = this.mReusableIntPair;
        r18[0] = 0;
        r18[1] = 0;
        dispatchNestedScroll(r15, r14, r16, r17, this.mScrollOffset, 0, r18);
        int[] r22 = this.mReusableIntPair;
        int r23 = r16 - r22[0];
        int r24 = r17 - r22[1];
        if (r22[0] == 0) goto L12;
    L15:
        boolean r25 = true;
    L16:
        int r26 = this.mLastTouchX;
        int[] r27 = this.mScrollOffset;
        this.mLastTouchX = r26 - r27[0];
        this.mLastTouchY -= r27[1];
        int[] r28 = this.mNestedOffsets;
        r28[0] = r28[0] + r27[0];
        r28[1] = r28[1] + r27[1];
        if (getOverScrollMode() == 2) goto L23;
        if (r21 != null) goto L20;
    L22:
        considerReleasingGlowsOnScroll(r19, r20);
        goto L23
    L20:
        if (MotionEventCompat.isFromSource(r21, 8194) == true) goto L22;
        pullGlows(r21.getX(), r23, r21.getY(), r24);
    L23:
        if (r15 != 0) goto L25;
        if (r14 != 0) goto L25;
    L27:
        if (awakenScrollBars() == true) goto L29;
        invalidate();
    L29:
        if (r25 == true) goto L35;
        if (r15 != 0) goto L36;
        if (r14 == 0) goto L34;
        return true;
    L34:
        return false;
    L36:
        return true;
    L35:
        return true;
    L25:
        dispatchOnScrolled(r15, r14);
        goto L27
    L12:
        if (r22[1] != 0) goto L15;
        r25 = false;
        goto L16
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        goto L7
    }

    void scrollStep(int r10, int r11, @Nullable int[] r12) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r10 == 0) goto L5;
        int r13 = this.mLayout.scrollHorizontallyBy(r10, this.mRecycler, this.mState);
    L6:
        if (r11 == 0) goto L8;
        int r14 = this.mLayout.scrollVerticallyBy(r11, this.mRecycler, this.mState);
    L9:
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r12 == null) goto L13;
        r12[0] = r13;
        r12[1] = r14;
        return;
    L13:
        return;
    L8:
        r14 = 0;
        goto L9
    L5:
        r13 = 0;
        goto L6
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int r10) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L9;
        Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r11.scrollToPosition(r10);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r10) {
        if (shouldDeferAccessibilityEvent(r10) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r10);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate r10) {
        this.mAccessibilityDelegate = r10;
        ViewCompat.setAccessibilityDelegate(this, r10);
    }

    public void setAdapter(@Nullable Adapter r10) {
        setLayoutFrozen(false);
        setAdapterInternal(r10, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback r10) {
        if (r10 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r10;
        if (r10 == null) goto L8;
        boolean r11 = true;
    L9:
        setChildrenDrawingOrderEnabled(r11);
        return;
    L8:
        r11 = false;
        goto L9
    }

    @VisibleForTesting
    boolean setChildImportantForAccessibilityInternal(ViewHolder r10, int r11) {
        if (isComputingLayout() == false) goto L6;
        r10.mPendingAccessibilityState = r11;
        this.mPendingAccessibilityImportanceChange.add(r10);
        return false;
    L6:
        ViewCompat.setImportantForAccessibility(r10.itemView, r11);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r10) {
        if (r10 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r10;
        super.setClipToPadding(r10);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory r10) {
        Preconditions.checkNotNull(r10);
        this.mEdgeEffectFactory = r10;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean r10) {
        this.mHasFixedSize = r10;
    }

    public void setItemAnimator(@Nullable ItemAnimator r10) {
        ItemAnimator r11 = this.mItemAnimator;
        if (r11 == null) goto L5;
        r11.endAnimations();
        this.mItemAnimator.setListener(null);
    L5:
        this.mItemAnimator = r10;
        if (r10 == null) goto L9;
        r10.setListener(this.mItemAnimatorListener);
        return;
    }

    public void setItemViewCacheSize(int r10) {
        this.mRecycler.setViewCacheSize(r10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean r10) {
        suppressLayout(r10);
    }

    public void setLayoutManager(@Nullable LayoutManager r10) {
        if (r10 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        ItemAnimator r11 = this.mItemAnimator;
        if (r11 == null) goto L10;
        r11.endAnimations();
    L10:
        this.mLayout.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mRecycler.clear();
        if (this.mIsAttached == false) goto L13;
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
    L13:
        this.mLayout.setRecyclerView(null);
        this.mLayout = null;
    L15:
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = r10;
        if (r10 != null) goto L18;
    L24:
        this.mRecycler.updateViewCacheSize();
        requestLayout();
        return;
    L18:
        if (r10.mRecyclerView != null) goto L23;
        r10.setRecyclerView(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.dispatchAttachedToWindow(this);
        goto L24
    L23:
        throw new IllegalArgumentException("LayoutManager " + r10 + " is already attached to a RecyclerView:" + r10.mRecyclerView.exceptionLabel());
    L14:
        this.mRecycler.clear();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r10) {
        if (Build.VERSION.SDK_INT < 18) goto L5;
    L20:
        if (r10 != null) goto L24;
        super.setLayoutTransition(null);
        return;
    L24:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    L5:
        if (r10 != null) goto L9;
        suppressLayout(false);
        return;
    L9:
        if (r10.getAnimator(0) != null) goto L20;
        if (r10.getAnimator(1) != null) goto L20;
        if (r10.getAnimator(2) != null) goto L20;
        if (r10.getAnimator(3) != null) goto L20;
        if (r10.getAnimator(4) != null) goto L20;
        suppressLayout(true);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r10) {
        getScrollingChildHelper().setNestedScrollingEnabled(r10);
    }

    public void setOnFlingListener(@Nullable OnFlingListener r10) {
        this.mOnFlingListener = r10;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener r10) {
        this.mScrollListener = r10;
    }

    public void setPreserveFocusAfterLayout(boolean r10) {
        this.mPreserveFocusAfterLayout = r10;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool r10) {
        this.mRecycler.setRecycledViewPool(r10);
    }

    public void setRecyclerListener(@Nullable RecyclerListener r10) {
        this.mRecyclerListener = r10;
    }

    void setScrollState(int r10) {
        if (r10 != this.mScrollState) goto L5;
        return;
    L5:
        this.mScrollState = r10;
        if (r10 == 2) goto L8;
        stopScrollersInternal();
    L8:
        dispatchOnScrollStateChanged(r10);
    }

    public void setScrollingTouchSlop(int r10) {
        ViewConfiguration r11 = ViewConfiguration.get(getContext());
        if (r10 != 0) goto L5;
    L8:
        int r12 = r11.getScaledTouchSlop();
    L9:
        this.mTouchSlop = r12;
        return;
    L5:
        if (r10 == 1) goto L7;
        Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + r10 + "; using default value");
        goto L8
    L7:
        r12 = r11.getScaledPagingTouchSlop();
        goto L9
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension r10) {
        this.mRecycler.setViewCacheExtension(r10);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent r10) {
        int r11 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r10 == null) goto L6;
        int r12 = AccessibilityEventCompat.getContentChangeTypes(r10);
    L7:
        if (r12 == 0) goto L10;
        r11 = r12;
    L10:
        this.mEatenAccessibilityChangeFlags |= r11;
        return true;
    L6:
        r12 = 0;
        goto L7
    L12:
        return false;
    }

    public void smoothScrollBy(@Px int r10, @Px int r11) {
        smoothScrollBy(r10, r11, null);
    }

    public void smoothScrollBy(@Px int r10, @Px int r11, @Nullable Interpolator r12) {
        smoothScrollBy(r10, r11, r12, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(@Px int r10, @Px int r11, @Nullable Interpolator r12, int r13) {
        smoothScrollBy(r10, r11, r12, r13, false);
    }

    void smoothScrollBy(@Px int r10, @Px int r11, @Nullable Interpolator r12, int r13, boolean r14) {
        LayoutManager r15 = this.mLayout;
        if (r15 != null) goto L7;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r16 = 0;
        if (r15.canScrollHorizontally() == true) goto L13;
        r10 = 0;
    L13:
        if (this.mLayout.canScrollVertically() == true) goto L15;
        r11 = 0;
    L15:
        if (r10 != 0) goto L18;
        if (r11 != 0) goto L18;
        return;
    L18:
        if (r13 == Integer.MIN_VALUE) goto L22;
        if (r13 > 0) goto L22;
        boolean r17 = false;
    L23:
        if (r17 == false) goto L31;
        if (r14 == false) goto L30;
        if (r10 == 0) goto L27;
        r16 = 1;
    L27:
        if (r11 == 0) goto L29;
        r16 = r16 | 2;
    L29:
        startNestedScroll(r16, 1);
    L30:
        this.mViewFlinger.smoothScrollBy(r10, r11, r13, r12);
        return;
    L31:
        scrollBy(r10, r11);
        return;
    L22:
        r17 = true;
        goto L23
    }

    public void smoothScrollToPosition(int r10) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L9;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r11.smoothScrollToPosition(this, this.mState, r10);
    }

    void startInterceptRequestLayout() {
        int r10 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r10;
        if (r10 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r10) {
        return getScrollingChildHelper().startNestedScroll(r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r10, int r11) {
        return getScrollingChildHelper().startNestedScroll(r10, r11);
    }

    void stopInterceptRequestLayout(boolean r10) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L6;
        this.mInterceptRequestLayoutDepth = 1;
    L6:
        if (r10 == true) goto L11;
        if (this.mLayoutSuppressed == true) goto L11;
        this.mLayoutWasDefered = false;
    L11:
        if (this.mInterceptRequestLayoutDepth != 1) goto L25;
        if (r10 == false) goto L23;
        if (this.mLayoutWasDefered == false) goto L23;
        if (this.mLayoutSuppressed == true) goto L23;
        if (this.mLayout == null) goto L23;
        if (this.mAdapter == null) goto L23;
        dispatchLayout();
    L23:
        if (this.mLayoutSuppressed == true) goto L25;
        this.mLayoutWasDefered = false;
    L25:
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r10) {
        getScrollingChildHelper().stopNestedScroll(r10);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r10) {
        if (r10 == this.mLayoutSuppressed) goto L16;
        assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
        if (r10 == true) goto L14;
        this.mLayoutSuppressed = false;
        if (this.mLayoutWasDefered == true) goto L9;
    L13:
        this.mLayoutWasDefered = false;
        return;
    L9:
        if (this.mLayout == null) goto L13;
        if (this.mAdapter == null) goto L13;
        requestLayout();
        goto L13
    L14:
        long r11 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    public void swapAdapter(@Nullable Adapter r10, boolean r11) {
        setLayoutFrozen(false);
        setAdapterInternal(r10, true, r11);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    void viewRangeUpdate(int r10, int r11, Object r12) {
        int r13 = this.mChildHelper.getUnfilteredChildCount();
        int r14 = r10 + r11;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L14;
        View r16 = this.mChildHelper.getUnfilteredChildAt(r15);
        ViewHolder r17 = getChildViewHolderInt(r16);
        if (r17 == null) goto L13;
        if (r17.shouldIgnore() == true) goto L13;
        int r18 = r17.mPosition;
        if (r18 < r10) goto L13;
        if (r18 >= r14) goto L13;
        r17.addFlags(2);
        r17.addChangePayload(r12);
        ((LayoutParams) r16.getLayoutParams()).mInsetsDirty = true;
    L13:
        r15 = r15 + 1;
        goto L3
    L14:
        this.mRecycler.viewRangeUpdate(r10, r11);
    }
}
