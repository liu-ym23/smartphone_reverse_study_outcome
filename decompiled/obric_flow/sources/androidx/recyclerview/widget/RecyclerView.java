package androidx.recyclerview.widget;

import ai.j0;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
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
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.base.EdgeEffectAdapter;
import androidx.recyclerview.base.OverScrollerAdapter;
import androidx.recyclerview.base.VelocityTracker;
import androidx.recyclerview.base.VelocityTrackerFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    private static final float DECELERATION_RATE = 0.0f;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
    private static final float SCROLL_FRICTION = 0.015f;
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
    static boolean sDebugAssertionsEnabled = false;
    static final Interpolator sQuinticInterpolator = null;
    static boolean sVerboseLoggingEnabled = false;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private boolean mAvoidStateChangeInAnim;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    boolean mEnableFastScroller;
    private boolean mEnableOverFling;

    @VisibleForTesting
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    protected EdgeEffectAdapter mHorizontalEdgeEffect;
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
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;

    @VisibleForTesting
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private final int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;

    @VisibleForTesting
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    private final RecyclerViewExt mRecyclerViewExt;
    final int[] mReusableIntPair;
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
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    protected EdgeEffectAdapter mVerticalEdgeEffect;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = null;

        static {
            int[] r5 = new int[Adapter.StateRestorationPolicy.values().length];
            $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = r5;
            r5[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable;
        private StateRestorationPolicy mStateRestorationPolicy;

        public static final enum StateRestorationPolicy extends Enum<StateRestorationPolicy> {
            private static final /* synthetic */ StateRestorationPolicy[] $VALUES = null;
            public static final StateRestorationPolicy ALLOW = null;
            public static final StateRestorationPolicy PREVENT = null;
            public static final StateRestorationPolicy PREVENT_WHEN_EMPTY = null;

            static {
                StateRestorationPolicy r5 = new StateRestorationPolicy("ALLOW", 0);
                ALLOW = r5;
                StateRestorationPolicy r10 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r10;
                StateRestorationPolicy r11 = new StateRestorationPolicy("PREVENT", 2);
                PREVENT = r11;
                $VALUES = new StateRestorationPolicy[]{r5, r10, r11};
            }

            private StateRestorationPolicy(String r5, int r10) {
                super(r5, r10);
            }

            public static StateRestorationPolicy valueOf(String r5) {
                return (StateRestorationPolicy) Enum.valueOf(StateRestorationPolicy.class, r5);
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) $VALUES.clone();
            }
        }

        public Adapter() {
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
            this.mStateRestorationPolicy = StateRestorationPolicy.ALLOW;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(@NonNull VH r5, int r10) {
            if (r5.mBindingAdapter != null) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L11;
            r5.mPosition = r10;
            if (hasStableIds() == false) goto L10;
            r5.mItemId = getItemId(r10);
        L10:
            r5.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
        L11:
            r5.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L14;
        L27:
            onBindViewHolder(r5, r10, r5.getUnmodifiedPayloads());
            if (r11 == false) goto L34;
            r5.clearPayload();
            ViewGroup.LayoutParams r12 = r5.itemView.getLayoutParams();
            if ((r12 instanceof LayoutParams) == false) goto L32;
            ((LayoutParams) r12).mInsetsDirty = true;
        L32:
            TraceCompat.endSection();
            return;
        L34:
            return;
        L14:
            if (r5.itemView.getParent() != null) goto L21;
            if (ViewCompat.isAttachedToWindow(r5.itemView) == r5.isTmpDetached()) goto L21;
            throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + r5.isTmpDetached() + ", attached to window: " + ViewCompat.isAttachedToWindow(r5.itemView) + ", holder: " + r5);
        L21:
            if (r5.itemView.getParent() != null) goto L27;
            if (ViewCompat.isAttachedToWindow(r5.itemView) == false) goto L27;
            throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + r5);
        L5:
            r11 = false;
            goto L6
        }

        public boolean canRestoreState() {
            int r5 = AnonymousClass7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
            if (r5 != 1) goto L5;
            return false;
        L5:
            if (r5 == 2) goto L8;
            return true;
        L8:
            if (getItemCount() > 0) goto L10;
            return false;
        L10:
            return true;
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup r5, int r10) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L7
            VH r11 = (VH) onCreateViewHolder(r5, r10);
            if (r11.itemView.getParent() != null) goto L10;
            r11.mItemViewType = r10;     // Catch: Throwable -> L7
            TraceCompat.endSection();
            return r11;
        L10:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }

        public int findRelativeAdapterPositionIn(@NonNull Adapter<? extends ViewHolder> r5, @NonNull ViewHolder r10, int r11) {
            if (r5 != this) goto L4;
            return r11;
        L4:
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int r5) {
            return -1;
        }

        public int getItemViewType(int r5) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
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

        public final void notifyItemChanged(int r5) {
            this.mObservable.notifyItemRangeChanged(r5, 1);
        }

        public final void notifyItemInserted(int r5) {
            this.mObservable.notifyItemRangeInserted(r5, 1);
        }

        public final void notifyItemMoved(int r5, int r10) {
            this.mObservable.notifyItemMoved(r5, r10);
        }

        public final void notifyItemRangeChanged(int r5, int r10) {
            this.mObservable.notifyItemRangeChanged(r5, r10);
        }

        public final void notifyItemRangeInserted(int r5, int r10) {
            this.mObservable.notifyItemRangeInserted(r5, r10);
        }

        public final void notifyItemRangeRemoved(int r5, int r10) {
            this.mObservable.notifyItemRangeRemoved(r5, r10);
        }

        public final void notifyItemRemoved(int r5) {
            this.mObservable.notifyItemRangeRemoved(r5, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView r5) {
        }

        public abstract void onBindViewHolder(@NonNull VH r5, int r10);

        public void onBindViewHolder(@NonNull VH r5, int r10, @NonNull List<Object> r11) {
            onBindViewHolder(r5, r10);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup r5, int r10);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView r5) {
        }

        public boolean onFailedToRecycleView(@NonNull VH r5) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH r5) {
        }

        public void onViewDetachedFromWindow(@NonNull VH r5) {
        }

        public void onViewRecycled(@NonNull VH r5) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver r5) {
            this.mObservable.registerObserver(r5);
        }

        public void setHasStableIds(boolean r5) {
            if (hasObservers() == true) goto L7;
            this.mHasStableIds = r5;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(@NonNull StateRestorationPolicy r5) {
            this.mStateRestorationPolicy = r5;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver r5) {
            this.mObservable.unregisterObserver(r5);
        }

        public final void notifyItemChanged(int r5, @Nullable Object r10) {
            this.mObservable.notifyItemRangeChanged(r5, 1, r10);
        }

        public final void notifyItemRangeChanged(int r5, int r10, @Nullable Object r11) {
            this.mObservable.notifyItemRangeChanged(r5, r10, r11);
        }
    }

    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            int r5 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r5 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r5)).onChanged();
            r5 = r5 - 1;
            goto L3
        }

        public void notifyItemMoved(int r5, int r10) {
            int r11 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r11 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r11)).onItemRangeMoved(r5, r10, 1);
            r11 = r11 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r5, int r10) {
            notifyItemRangeChanged(r5, r10, null);
        }

        public void notifyItemRangeInserted(int r5, int r10) {
            int r11 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r11 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r11)).onItemRangeInserted(r5, r10);
            r11 = r11 - 1;
            goto L3
        }

        public void notifyItemRangeRemoved(int r5, int r10) {
            int r11 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r11 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r11)).onItemRangeRemoved(r5, r10);
            r11 = r11 - 1;
            goto L3
        }

        public void notifyStateRestorationPolicyChanged() {
            int r5 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r5 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r5)).onStateRestorationPolicyChanged();
            r5 = r5 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r5, int r10, @Nullable Object r11) {
            int r12 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r12 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r12)).onItemRangeChanged(r5, r10, r11);
            r12 = r12 - 1;
            goto L3
        }
    }

    public static abstract class AdapterDataObserver {
        public AdapterDataObserver() {
        }

        public void onChanged() {
        }

        public void onItemRangeChanged(int r5, int r10) {
        }

        public void onItemRangeInserted(int r5, int r10) {
        }

        public void onItemRangeMoved(int r5, int r10, int r11) {
        }

        public void onItemRangeRemoved(int r5, int r10) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int r5, int r10, @Nullable Object r11) {
            onItemRangeChanged(r5, r10);
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int r5, int r10);
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
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView r5, int r10) {
            return new EdgeEffect(r5.getContext());
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

        public interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder r5);
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
            public ItemHolderInfo setFrom(@NonNull ViewHolder r5) {
                return setFrom(r5, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder r5, int r10) {
                View r11 = r5.itemView;
                this.left = r11.getLeft();
                this.top = r11.getTop();
                this.right = r11.getRight();
                this.bottom = r11.getBottom();
                return this;
            }
        }

        public ItemAnimator() {
            this.mListener = null;
            this.mFinishedListeners = new ArrayList();
            this.mAddDuration = 100;
            this.mRemoveDuration = 100;
            this.mMoveDuration = 500;
            this.mChangeDuration = 250;
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder r5) {
            int r10 = r5.mFlags;
            int r11 = r10 & 14;
            if (r5.isInvalid() == false) goto L6;
            return 4;
        L6:
            if ((r10 & 4) != 0) goto L13;
            int r12 = r5.getOldPosition();
            int r13 = r5.getAbsoluteAdapterPosition();
            if (r12 == (-1)) goto L14;
            if (r13 == (-1)) goto L15;
            if (r12 != r13) goto L12;
            return r11;
        L12:
            return r11 | 2048;
        L15:
            return r11;
        L14:
            return r11;
        L13:
            return r11;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder r5, @Nullable ItemHolderInfo r10, @NonNull ItemHolderInfo r11);

        public abstract boolean animateChange(@NonNull ViewHolder r5, @NonNull ViewHolder r10, @NonNull ItemHolderInfo r11, @NonNull ItemHolderInfo r12);

        public abstract boolean animateDisappearance(@NonNull ViewHolder r5, @NonNull ItemHolderInfo r10, @Nullable ItemHolderInfo r11);

        public abstract boolean animatePersistence(@NonNull ViewHolder r5, @NonNull ItemHolderInfo r10, @NonNull ItemHolderInfo r11);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder r5) {
            return true;
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder r5) {
            onAnimationFinished(r5);
            ItemAnimatorListener r10 = this.mListener;
            if (r10 == null) goto L6;
            r10.onAnimationFinished(r5);
            return;
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder r5) {
            onAnimationStarted(r5);
        }

        public final void dispatchAnimationsFinished() {
            int r5 = this.mFinishedListeners.size();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L5;
            this.mFinishedListeners.get(r10).onAnimationsFinished();
            r10 = r10 + 1;
            goto L3
        L5:
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder r5);

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

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener r5) {
            boolean r10 = isRunning();
            if (r5 == null) goto L7;
            if (r10 == true) goto L6;
            r5.onAnimationsFinished();
            goto L7
        L6:
            this.mFinishedListeners.add(r5);
        L7:
            return r10;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder r5) {
        }

        public void onAnimationStarted(@NonNull ViewHolder r5) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State r5, @NonNull ViewHolder r10) {
            return obtainHolderInfo().setFrom(r10);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State r5, @NonNull ViewHolder r10, int r11, @NonNull List<Object> r12) {
            return obtainHolderInfo().setFrom(r10);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long r5) {
            this.mAddDuration = r5;
        }

        public void setChangeDuration(long r5) {
            this.mChangeDuration = r5;
        }

        public void setListener(ItemAnimatorListener r5) {
            this.mListener = r5;
        }

        public void setMoveDuration(long r5) {
            this.mMoveDuration = r5;
        }

        public void setRemoveDuration(long r5) {
            this.mRemoveDuration = r5;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder r5, @NonNull List<Object> r10) {
            return canReuseUpdatedViewHolder(r5);
        }
    }

    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        final /* synthetic */ RecyclerView this$0;

        public ItemAnimatorRestoreListener(RecyclerView r5) {
            this.this$0 = r5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder r5) {
            r5.setIsRecyclable(true);
            if (r5.mShadowedHolder != null) goto L5;
        L7:
            r5.mShadowingHolder = null;
            if (r5.shouldBeKeptAsChild() == false) goto L10;
            return;
        L10:
            if (this.this$0.removeAnimatingView(r5.itemView) == false) goto L12;
            return;
        L12:
            if (r5.isTmpDetached() == false) goto L17;
            this.this$0.removeDetachedView(r5.itemView, false);
            return;
        L17:
            return;
        L5:
            if (r5.mShadowingHolder != null) goto L7;
            r5.mShadowedHolder = null;
            goto L7
        }
    }

    public static abstract class ItemDecoration {
        public ItemDecoration() {
        }

        @Deprecated
        public void getItemOffsets(@NonNull Rect r5, int r10, @NonNull RecyclerView r11) {
            r5.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas r5, @NonNull RecyclerView r10) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas r5, @NonNull RecyclerView r10) {
        }

        public void getItemOffsets(@NonNull Rect r5, @NonNull View r10, @NonNull RecyclerView r11, @NonNull State r12) {
            getItemOffsets(r5, ((LayoutParams) r10.getLayoutParams()).getViewLayoutPosition(), r11);
        }

        public void onDraw(@NonNull Canvas r5, @NonNull RecyclerView r10, @NonNull State r11) {
            onDraw(r5, r10);
        }

        public void onDrawOver(@NonNull Canvas r5, @NonNull RecyclerView r10, @NonNull State r11) {
            onDrawOver(r5, r10);
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
            void addPosition(int r5, int r10);
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
            ViewBoundsCheck.Callback r5 = new AnonymousClass1(this);
            this.mHorizontalBoundCheckCallback = r5;
            ViewBoundsCheck.Callback r10 = new AnonymousClass2(this);
            this.mVerticalBoundCheckCallback = r10;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r5);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r10);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View r5, int r10, boolean r11) {
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r5);
            if (r11 == false) goto L5;
        L8:
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r12);
        L9:
            LayoutParams r13 = (LayoutParams) r5.getLayoutParams();
            if (r12.wasReturnedFromScrap() == true) goto L30;
            if (r12.isScrap() == true) goto L30;
            if (r5.getParent() != this.mRecyclerView) goto L24;
            int r14 = this.mChildHelper.indexOfChild(r5);
            if (r10 != (-1)) goto L19;
            r10 = this.mChildHelper.getChildCount();
        L19:
            if (r14 == (-1)) goto L22;
            if (r14 == r10) goto L35;
            this.mRecyclerView.mLayout.moveView(r14, r10);
        L35:
            if (r13.mPendingInvalidate == true) goto L37;
            return;
        L37:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L39;
            Log.d(RecyclerView.TAG, "consuming pending invalidate on child " + r13.mViewHolder);
        L39:
            r12.itemView.invalidate();
            r13.mPendingInvalidate = false;
            return;
        L22:
            StringBuilder r15 = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            r15.append(this.mRecyclerView.indexOfChild(r5));
            throw new IllegalStateException(a.k(this.mRecyclerView, r15));
        L24:
            this.mChildHelper.addView(r5, r10, false);
            r13.mInsetsDirty = true;
            SmoothScroller r16 = this.mSmoothScroller;
            if (r16 == null) goto L35;
            if (r16.isRunning() == false) goto L35;
            this.mSmoothScroller.onChildAttachedToWindow(r5);
        L30:
            if (r12.isScrap() == false) goto L32;
            r12.unScrap();
        L33:
            this.mChildHelper.attachViewToParent(r5, r10, r5.getLayoutParams(), false);
            goto L35
        L32:
            r12.clearReturnedFromScrapFlag();
            goto L33
        L5:
            if (r12.isRemoved() == true) goto L8;
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r12);
            goto L9
        }

        public static int chooseSize(int r5, int r10, int r11) {
            int r12 = View.MeasureSpec.getMode(r5);
            int r13 = View.MeasureSpec.getSize(r5);
            if (r12 == Integer.MIN_VALUE) goto L9;
            if (r12 != 1073741824) goto L7;
            return r13;
        L7:
            return Math.max(r10, r11);
        L9:
            return Math.min(r13, Math.max(r10, r11));
        }

        private void detachViewInternal(int r5, @NonNull View r10) {
            this.mChildHelper.detachViewFromParent(r5);
        }

        @Deprecated
        public static int getChildMeasureSpec(int r5, int r10, int r11, boolean r12) {
            int r13 = r5 - r10;
            int r14 = 0;
            int r15 = Math.max(0, r13);
            if (r12 == false) goto L7;
            if (r11 < 0) goto L6;
        L5:
            r14 = 1073741824;
        L16:
            return View.MeasureSpec.makeMeasureSpec(r11, r14);
        L6:
            r11 = 0;
            goto L16
        L7:
            if (r11 >= 0) goto L5;
            if (r11 != (-1)) goto L13;
            r11 = r15;
            goto L5
        L13:
            if (r11 != (-2)) goto L6;
            r14 = Integer.MIN_VALUE;
            r11 = r15;
            goto L16
        }

        private int[] getChildRectangleOnScreenScrollAmount(View r10, Rect r11) {
            int r5 = getPaddingLeft();
            int r12 = getPaddingTop();
            int r13 = getWidth() - getPaddingRight();
            int r14 = getHeight() - getPaddingBottom();
            int r15 = (r10.getLeft() + r11.left) - r10.getScrollX();
            int r16 = (r10.getTop() + r11.top) - r10.getScrollY();
            int r17 = r11.width() + r15;
            int r18 = r11.height() + r16;
            int r19 = r15 - r5;
            int r20 = Math.min(0, r19);
            int r21 = r16 - r12;
            int r22 = Math.min(0, r21);
            int r23 = r17 - r13;
            int r24 = Math.max(0, r23);
            int r25 = Math.max(0, r18 - r14);
            if (getLayoutDirection() != 1) goto L7;
            if (r24 != 0) goto L11;
            r24 = Math.max(r20, r23);
        L11:
            if (r22 != 0) goto L15;
            r22 = Math.min(r21, r25);
        L15:
            return new int[]{r24, r22};
        L7:
            if (r20 != 0) goto L10;
            r20 = Math.min(r19, r24);
        L10:
            r24 = r20;
            goto L11
        }

        public static Properties getProperties(@NonNull Context r5, @Nullable AttributeSet r10, int r11, int r12) {
            Properties r13 = new Properties();
            TypedArray r14 = r5.obtainStyledAttributes(r10, R.styleable.RecyclerView, r11, r12);
            r13.orientation = r14.getInt(R.styleable.RecyclerView_android_orientation, 1);
            r13.spanCount = r14.getInt(R.styleable.RecyclerView_spanCount, 1);
            r13.reverseLayout = r14.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            r13.stackFromEnd = r14.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            r14.recycle();
            return r13;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView r10, int r11, int r12) {
            View r13 = r10.getFocusedChild();
            if (r13 != null) goto L5;
            return false;
        L5:
            int r5 = getPaddingLeft();
            int r14 = getPaddingTop();
            int r15 = getWidth() - getPaddingRight();
            int r16 = getHeight() - getPaddingBottom();
            Rect r17 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r13, r17);
            if ((r17.left - r11) < r15) goto L8;
        L16:
            return false;
        L8:
            if ((r17.right - r11) <= r5) goto L16;
            if ((r17.top - r12) >= r16) goto L16;
            if ((r17.bottom - r12) <= r14) goto L16;
            return true;
        }

        private static boolean isMeasurementUpToDate(int r5, int r10, int r11) {
            int r12 = View.MeasureSpec.getMode(r10);
            int r13 = View.MeasureSpec.getSize(r10);
            if (r11 <= 0) goto L7;
            if (r5 == r11) goto L7;
            return false;
        L7:
            if (r12 == Integer.MIN_VALUE) goto L16;
            if (r12 != 0) goto L10;
            return true;
        L10:
            if (r12 == 1073741824) goto L12;
            return false;
        L12:
            if (r13 == r5) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r13 >= r5) goto L18;
            return false;
        L18:
            return true;
        }

        private void scrapOrRecycleView(Recycler r5, int r10, View r11) {
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r11);
            if (r12.shouldIgnore() == false) goto L9;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L17;
            Log.d(RecyclerView.TAG, "ignoring view " + r12);
            return;
        L17:
            return;
        L9:
            if (r12.isInvalid() == true) goto L11;
        L15:
            detachViewAt(r10);
            r5.scrapView(r11);
            this.mRecyclerView.mViewInfoStore.onViewDetached(r12);
            return;
        L11:
            if (r12.isRemoved() == true) goto L15;
            if (this.mRecyclerView.mAdapter.hasStableIds() == true) goto L15;
            removeViewAt(r10);
            r5.recycleViewHolderInternal(r12);
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View r5) {
            addDisappearingView(r5, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View r5) {
            addView(r5, -1);
        }

        public void assertInLayoutOrScroll(String r5) {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L6;
            r10.assertInLayoutOrScroll(r5);
            return;
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String r5) {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L6;
            r10.assertNotInLayoutOrScroll(r5);
            return;
        }

        public void attachView(@NonNull View r5, int r10, LayoutParams r11) {
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r5);
            if (r12.isRemoved() == false) goto L5;
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r12);
        L6:
            this.mChildHelper.attachViewToParent(r5, r10, r11, r12.isRemoved());
            return;
        L5:
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r12);
            goto L6
        }

        public void calculateItemDecorationsForChild(@NonNull View r5, @NonNull Rect r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 != null) goto L6;
            r10.set(0, 0, 0, 0);
            return;
        L6:
            r10.set(r11.getItemDecorInsetsForChild(r5));
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams r5) {
            if (r5 == null) goto L4;
            return true;
        L4:
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int r5, int r10, State r11, LayoutPrefetchRegistry r12) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int r5, LayoutPrefetchRegistry r10) {
        }

        public int computeHorizontalScrollExtent(@NonNull State r5) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State r5) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State r5) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State r5) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State r5) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State r5) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler r5) {
            int r10 = getChildCount() - 1;
        L3:
            if (r10 < 0) goto L5;
            scrapOrRecycleView(r5, r10, getChildAt(r10));
            r10 = r10 - 1;
            goto L3
        }

        public void detachAndScrapView(@NonNull View r5, @NonNull Recycler r10) {
            scrapOrRecycleView(r10, this.mChildHelper.indexOfChild(r5), r5);
        }

        public void detachAndScrapViewAt(int r5, @NonNull Recycler r10) {
            scrapOrRecycleView(r10, r5, getChildAt(r5));
        }

        public void detachView(@NonNull View r5) {
            int r10 = this.mChildHelper.indexOfChild(r5);
            if (r10 < 0) goto L6;
            detachViewInternal(r10, r5);
            return;
        }

        public void detachViewAt(int r5) {
            detachViewInternal(r5, getChildAt(r5));
        }

        public void dispatchAttachedToWindow(RecyclerView r5) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(r5);
        }

        public void dispatchDetachedFromWindow(RecyclerView r5, Recycler r10) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(r5, r10);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View r5) {
            ItemAnimator r10 = this.mRecyclerView.mItemAnimator;
            if (r10 == null) goto L6;
            r10.endAnimation(RecyclerView.getChildViewHolderInt(r5));
            return;
        }

        @Nullable
        public View findContainingItemView(@NonNull View r5) {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
            return null;
        L5:
            View r11 = r10.findContainingItemView(r5);
            if (r11 != null) goto L9;
            return null;
        L9:
            if (this.mChildHelper.isHidden(r11) == false) goto L11;
            return null;
        L11:
            return r11;
        }

        @Nullable
        public View findViewByPosition(int r10) {
            int r5 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L17;
            View r12 = getChildAt(r11);
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r12);
            if (r13 == null) goto L16;
            if (r13.getLayoutPosition() != r10) goto L16;
            if (r13.shouldIgnore() == true) goto L16;
            if (this.mRecyclerView.mState.isPreLayout() == true) goto L15;
            if (r13.isRemoved() == true) goto L16;
        L15:
            return r12;
        L16:
            r11 = r11 + 1;
            goto L3
        L17:
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
            if ((r5 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r5);
        L7:
            if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
        L11:
            return new LayoutParams(r5);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View r5) {
            return ((LayoutParams) r5.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int r5) {
            ChildHelper r10 = this.mChildHelper;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.getChildAt(r5);
        }

        public int getChildCount() {
            ChildHelper r5 = this.mChildHelper;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return r5.getChildCount();
        }

        public boolean getClipToPadding() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.mClipToPadding == false) goto L7;
            return true;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler r5, @NonNull State r10) {
            return -1;
        }

        public int getDecoratedBottom(@NonNull View r5) {
            int r10 = r5.getBottom();
            return getBottomDecorationHeight(r5) + r10;
        }

        public void getDecoratedBoundsWithMargins(@NonNull View r5, @NonNull Rect r10) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r5, r10);
        }

        public int getDecoratedLeft(@NonNull View r5) {
            return r5.getLeft() - getLeftDecorationWidth(r5);
        }

        public int getDecoratedMeasuredHeight(@NonNull View r5) {
            Rect r10 = ((LayoutParams) r5.getLayoutParams()).mDecorInsets;
            return (r5.getMeasuredHeight() + r10.top) + r10.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View r5) {
            Rect r10 = ((LayoutParams) r5.getLayoutParams()).mDecorInsets;
            return (r5.getMeasuredWidth() + r10.left) + r10.right;
        }

        public int getDecoratedRight(@NonNull View r5) {
            int r10 = r5.getRight();
            return getRightDecorationWidth(r5) + r10;
        }

        public int getDecoratedTop(@NonNull View r5) {
            return r5.getTop() - getTopDecorationHeight(r5);
        }

        @Nullable
        public View getFocusedChild() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L5;
            return null;
        L5:
            View r10 = r5.getFocusedChild();
            if (r10 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.mChildHelper.isHidden(r10) == true) goto L11;
            return r10;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 == null) goto L5;
            Adapter r10 = r5.getAdapter();
        L6:
            if (r10 != null) goto L10;
            return 0;
        L10:
            return r10.getItemCount();
        L5:
            r10 = null;
            goto L6
        }

        public int getItemViewType(@NonNull View r5) {
            return RecyclerView.getChildViewHolderInt(r5).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View r5) {
            return ((LayoutParams) r5.getLayoutParams()).mDecorInsets.left;
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
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return r5.getPaddingBottom();
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingEnd(r5);
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return r5.getPaddingLeft();
        }

        @Px
        public int getPaddingRight() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return r5.getPaddingRight();
        }

        @Px
        public int getPaddingStart() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingStart(r5);
        }

        @Px
        public int getPaddingTop() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L7;
            return 0;
        L7:
            return r5.getPaddingTop();
        }

        public int getPosition(@NonNull View r5) {
            return ((LayoutParams) r5.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View r5) {
            return ((LayoutParams) r5.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler r5, @NonNull State r10) {
            return -1;
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler r5, @NonNull State r10) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View r5) {
            return ((LayoutParams) r5.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View r5, boolean r10, @NonNull Rect r11) {
            if (r10 == false) goto L4;
            Rect r12 = ((LayoutParams) r5.getLayoutParams()).mDecorInsets;
            r11.set(-r12.left, -r12.top, r5.getWidth() + r12.right, r5.getHeight() + r12.bottom);
        L6:
            if (this.mRecyclerView == null) goto L12;
            Matrix r13 = r5.getMatrix();
            if (r13 == null) goto L12;
            if (r13.isIdentity() == true) goto L12;
            RectF r14 = this.mRecyclerView.mTempRectF;
            r14.set(r11);
            r13.mapRect(r14);
            r11.set((int) Math.floor(r14.left), (int) Math.floor(r14.top), (int) Math.ceil(r14.right), (int) Math.ceil(r14.bottom));
        L12:
            r11.offset(r5.getLeft(), r5.getTop());
            return;
        L4:
            r11.set(0, 0, r5.getWidth(), r5.getHeight());
            goto L6
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int r5 = getChildCount();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L11;
            ViewGroup.LayoutParams r11 = getChildAt(r10).getLayoutParams();
            if (r11.width >= 0) goto L10;
            if (r11.height >= 0) goto L10;
            return true;
        L10:
            r10 = r10 + 1;
            goto L3
        L11:
            return false;
        }

        public boolean hasFocus() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.hasFocus() == false) goto L7;
            return true;
        }

        public void ignoreView(@NonNull View r5) {
            ViewParent r10 = r5.getParent();
            RecyclerView r11 = this.mRecyclerView;
            if (r10 == r11) goto L5;
        L8:
            StringBuilder r12 = new StringBuilder("View should be fully attached to be ignored");
            throw new IllegalArgumentException(a.k(this.mRecyclerView, r12));
        L5:
            if (r11.indexOfChild(r5) == (-1)) goto L8;
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r5);
            r13.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(r13);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.isFocused() == false) goto L7;
            return true;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler r5, @NonNull State r10) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller r5 = this.mSmoothScroller;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.isRunning() == false) goto L7;
            return true;
        }

        public boolean isViewPartiallyVisible(@NonNull View r5, boolean r10, boolean r11) {
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(r5, 24579) == true) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r10 == false) goto L11;
            return r12;
        L11:
            return !r12;
        L5:
            if (this.mVerticalBoundCheck.isViewWithinBoundFlags(r5, 24579) == false) goto L7;
            r12 = true;
            goto L8
        }

        public void layoutDecorated(@NonNull View r5, int r10, int r11, int r12, int r13) {
            Rect r14 = ((LayoutParams) r5.getLayoutParams()).mDecorInsets;
            r5.layout(r10 + r14.left, r11 + r14.top, r12 - r14.right, r13 - r14.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View r5, int r10, int r11, int r12, int r13) {
            LayoutParams r14 = (LayoutParams) r5.getLayoutParams();
            Rect r15 = r14.mDecorInsets;
            r5.layout((r10 + r15.left) + ((ViewGroup.MarginLayoutParams) r14).leftMargin, (r11 + r15.top) + ((ViewGroup.MarginLayoutParams) r14).topMargin, (r12 - r15.right) - ((ViewGroup.MarginLayoutParams) r14).rightMargin, (r13 - r15.bottom) - ((ViewGroup.MarginLayoutParams) r14).bottomMargin);
        }

        public void measureChild(@NonNull View r10, int r11, int r12) {
            LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
            Rect r13 = this.mRecyclerView.getItemDecorInsetsForChild(r10);
            int r14 = (r13.left + r13.right) + r11;
            int r15 = (r13.top + r13.bottom) + r12;
            int r16 = getWidth();
            int r17 = getWidthMode();
            int r18 = getPaddingLeft();
            int r19 = getChildMeasureSpec(r16, r17, (getPaddingRight() + r18) + r14, ((ViewGroup.MarginLayoutParams) r5).width, canScrollHorizontally());
            int r20 = getHeight();
            int r21 = getHeightMode();
            int r22 = getPaddingTop();
            int r23 = getChildMeasureSpec(r20, r21, (getPaddingBottom() + r22) + r15, ((ViewGroup.MarginLayoutParams) r5).height, canScrollVertically());
            if (shouldMeasureChild(r10, r19, r23, r5) == false) goto L6;
            r10.measure(r19, r23);
            return;
        }

        public void measureChildWithMargins(@NonNull View r10, int r11, int r12) {
            LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
            Rect r13 = this.mRecyclerView.getItemDecorInsetsForChild(r10);
            int r14 = (r13.left + r13.right) + r11;
            int r15 = (r13.top + r13.bottom) + r12;
            int r16 = getWidth();
            int r17 = getWidthMode();
            int r18 = getPaddingLeft();
            int r19 = getChildMeasureSpec(r16, r17, (((getPaddingRight() + r18) + ((ViewGroup.MarginLayoutParams) r5).leftMargin) + ((ViewGroup.MarginLayoutParams) r5).rightMargin) + r14, ((ViewGroup.MarginLayoutParams) r5).width, canScrollHorizontally());
            int r20 = getHeight();
            int r21 = getHeightMode();
            int r22 = getPaddingTop();
            int r23 = getChildMeasureSpec(r20, r21, (((getPaddingBottom() + r22) + ((ViewGroup.MarginLayoutParams) r5).topMargin) + ((ViewGroup.MarginLayoutParams) r5).bottomMargin) + r15, ((ViewGroup.MarginLayoutParams) r5).height, canScrollVertically());
            if (shouldMeasureChild(r10, r19, r23, r5) == false) goto L6;
            r10.measure(r19, r23);
            return;
        }

        public void moveView(int r5, int r10) {
            View r11 = getChildAt(r5);
            if (r11 == null) goto L7;
            detachViewAt(r5);
            attachView(r11, r10);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r5 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(@Px int r5) {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L6;
            r10.offsetChildrenHorizontal(r5);
            return;
        }

        public void offsetChildrenVertical(@Px int r5) {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L6;
            r10.offsetChildrenVertical(r5);
            return;
        }

        public void onAdapterChanged(@Nullable Adapter r5, @Nullable Adapter r10) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView r5, @NonNull ArrayList<View> r10, int r11, int r12) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView r5) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView r5) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View r5, int r10, @NonNull Recycler r11, @NonNull State r12) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r5) {
            RecyclerView r10 = this.mRecyclerView;
            onInitializeAccessibilityEvent(r10.mRecycler, r10.mState, r5);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r5) {
            RecyclerView r10 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(r10.mRecycler, r10.mState, r5);
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler r5, @NonNull State r10, @NonNull View r11, @NonNull AccessibilityNodeInfoCompat r12) {
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View r5, int r10) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView r5, int r10, int r11) {
        }

        public void onItemsChanged(@NonNull RecyclerView r5) {
        }

        public void onItemsMoved(@NonNull RecyclerView r5, int r10, int r11, int r12) {
        }

        public void onItemsRemoved(@NonNull RecyclerView r5, int r10, int r11) {
        }

        public void onItemsUpdated(@NonNull RecyclerView r5, int r10, int r11) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(Recycler r5, State r10) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(State r5) {
        }

        public void onMeasure(@NonNull Recycler r5, @NonNull State r10, int r11, int r12) {
            this.mRecyclerView.defaultOnMeasure(r11, r12);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView r5, @NonNull View r10, @Nullable View r11) {
            if (isSmoothScrolling() == false) goto L5;
        L8:
            return true;
        L5:
            if (r5.isComputingLayout() == true) goto L8;
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable r5) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int r5) {
        }

        public void onSmoothScrollerStopped(SmoothScroller r5) {
            if (this.mSmoothScroller != r5) goto L6;
            this.mSmoothScroller = null;
            return;
        }

        public boolean performAccessibilityAction(int r5, @Nullable Bundle r10) {
            RecyclerView r11 = this.mRecyclerView;
            return performAccessibilityAction(r11.mRecycler, r11.mState, r5, r10);
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler r5, @NonNull State r10, @NonNull View r11, int r12, @Nullable Bundle r13) {
            return false;
        }

        public void postOnAnimation(Runnable r5) {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L6;
            ViewCompat.postOnAnimation(r10, r5);
            return;
        }

        public void removeAllViews() {
            int r5 = getChildCount() - 1;
        L3:
            if (r5 < 0) goto L5;
            this.mChildHelper.removeViewAt(r5);
            r5 = r5 - 1;
            goto L3
        }

        public void removeAndRecycleAllViews(@NonNull Recycler r5) {
            int r10 = getChildCount() - 1;
        L3:
            if (r10 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(getChildAt(r10)).shouldIgnore() == true) goto L7;
            removeAndRecycleViewAt(r10, r5);
        L7:
            r10 = r10 - 1;
            goto L3
        }

        public void removeAndRecycleScrapInt(Recycler r10) {
            int r5 = r10.getScrapCount();
            int r11 = r5 - 1;
        L3:
            if (r11 < 0) goto L15;
            View r12 = r10.getScrapViewAt(r11);
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r12);
            if (r13.shouldIgnore() == true) goto L14;
            r13.setIsRecyclable(false);
            if (r13.isTmpDetached() == false) goto L10;
            this.mRecyclerView.removeDetachedView(r12, false);
        L10:
            ItemAnimator r14 = this.mRecyclerView.mItemAnimator;
            if (r14 == null) goto L13;
            r14.endAnimation(r13);
        L13:
            r13.setIsRecyclable(true);
            r10.quickRecycleScrapView(r12);
        L14:
            r11 = r11 - 1;
            goto L3
        L15:
            r10.clearScrap();
            if (r5 <= 0) goto L22;
            this.mRecyclerView.invalidate();
            return;
        }

        public void removeAndRecycleView(@NonNull View r5, @NonNull Recycler r10) {
            removeView(r5);
            r10.recycleView(r5);
        }

        public void removeAndRecycleViewAt(int r5, @NonNull Recycler r10) {
            View r11 = getChildAt(r5);
            removeViewAt(r5);
            r10.recycleView(r11);
        }

        public boolean removeCallbacks(Runnable r5) {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
            return false;
        L5:
            return r10.removeCallbacks(r5);
        }

        public void removeDetachedView(@NonNull View r5) {
            this.mRecyclerView.removeDetachedView(r5, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View r5) {
            this.mChildHelper.removeView(r5);
        }

        public void removeViewAt(int r5) {
            if (getChildAt(r5) == null) goto L6;
            this.mChildHelper.removeViewAt(r5);
            return;
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r10, @NonNull View r11, @NonNull Rect r12, boolean r13) {
            return requestChildRectangleOnScreen(r10, r11, r12, r13, false);
        }

        public void requestLayout() {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 == null) goto L6;
            r5.requestLayout();
            return;
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int r5, Recycler r10, State r11) {
            return 0;
        }

        public void scrollToPosition(int r5) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L6;
            Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            return;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int r5, Recycler r10, State r11) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean r5) {
            this.mAutoMeasure = r5;
        }

        public void setExactMeasureSpecsFrom(RecyclerView r5) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(r5.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r5.getHeight(), BasicMeasure.EXACTLY));
        }

        public final void setItemPrefetchEnabled(boolean r5) {
            if (r5 == this.mItemPrefetchEnabled) goto L8;
            this.mItemPrefetchEnabled = r5;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L9;
            r10.mRecycler.updateViewCacheSize();
            return;
        L9:
            return;
        }

        public void setMeasureSpecs(int r5, int r10) {
            this.mWidth = View.MeasureSpec.getSize(r5);
            int r11 = View.MeasureSpec.getMode(r5);
            this.mWidthMode = r11;
            if (r11 == 0) goto L5;
        L7:
            this.mHeight = View.MeasureSpec.getSize(r10);
            int r12 = View.MeasureSpec.getMode(r10);
            this.mHeightMode = r12;
            if (r12 == 0) goto L10;
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

        public void setMeasuredDimension(Rect r5, int r10, int r11) {
            int r12 = r5.width();
            int r13 = getPaddingLeft() + r12;
            int r14 = getPaddingRight() + r13;
            int r15 = r5.height();
            int r16 = getPaddingTop() + r15;
            int r17 = getPaddingBottom() + r16;
            setMeasuredDimension(chooseSize(r10, r14, getMinimumWidth()), chooseSize(r11, r17, getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int r10, int r11) {
            int r5 = getChildCount();
            if (r5 != 0) goto L6;
            this.mRecyclerView.defaultOnMeasure(r10, r11);
            return;
        L6:
            int r12 = Integer.MIN_VALUE;
            int r13 = Integer.MAX_VALUE;
            int r14 = 0;
            int r15 = Integer.MIN_VALUE;
            int r16 = Integer.MAX_VALUE;
        L7:
            if (r14 >= r5) goto L21;
            View r17 = getChildAt(r14);
            Rect r18 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r17, r18);
            int r19 = r18.left;
            if (r19 >= r16) goto L11;
            r16 = r19;
        L11:
            int r20 = r18.right;
            if (r20 <= r12) goto L14;
            r12 = r20;
        L14:
            int r21 = r18.top;
            if (r21 >= r13) goto L17;
            r13 = r21;
        L17:
            int r22 = r18.bottom;
            if (r22 <= r15) goto L20;
            r15 = r22;
        L20:
            r14 = r14 + 1;
            goto L7
        L21:
            this.mRecyclerView.mTempRect.set(r16, r13, r12, r15);
            setMeasuredDimension(this.mRecyclerView.mTempRect, r10, r11);
        }

        public void setMeasurementCacheEnabled(boolean r5) {
            this.mMeasurementCacheEnabled = r5;
        }

        public void setRecyclerView(RecyclerView r5) {
            if (r5 != null) goto L4;
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        L5:
            this.mWidthMode = BasicMeasure.EXACTLY;
            this.mHeightMode = BasicMeasure.EXACTLY;
            return;
        L4:
            this.mRecyclerView = r5;
            this.mChildHelper = r5.mChildHelper;
            this.mWidth = r5.getWidth();
            this.mHeight = r5.getHeight();
            goto L5
        }

        public boolean shouldMeasureChild(View r5, int r10, int r11, LayoutParams r12) {
            if (r5.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.mMeasurementCacheEnabled == false) goto L12;
            if (isMeasurementUpToDate(r5.getWidth(), r10, ((ViewGroup.MarginLayoutParams) r12).width) == false) goto L12;
            if (isMeasurementUpToDate(r5.getHeight(), r11, ((ViewGroup.MarginLayoutParams) r12).height) == false) goto L12;
            return false;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View r5, int r10, int r11, LayoutParams r12) {
            if (this.mMeasurementCacheEnabled == true) goto L5;
        L10:
            return true;
        L5:
            if (isMeasurementUpToDate(r5.getMeasuredWidth(), r10, ((ViewGroup.MarginLayoutParams) r12).width) == false) goto L10;
            if (isMeasurementUpToDate(r5.getMeasuredHeight(), r11, ((ViewGroup.MarginLayoutParams) r12).height) == false) goto L10;
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView r5, State r10, int r11) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller r5) {
            SmoothScroller r10 = this.mSmoothScroller;
            if (r10 == null) goto L8;
            if (r5 == r10) goto L8;
            if (r10.isRunning() == false) goto L8;
            this.mSmoothScroller.stop();
        L8:
            this.mSmoothScroller = r5;
            r5.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View r5) {
            ViewHolder r10 = RecyclerView.getChildViewHolderInt(r5);
            r10.stopIgnoring();
            r10.resetInternal();
            r10.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller r5 = this.mSmoothScroller;
            if (r5 == null) goto L6;
            r5.stop();
            return;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View r5, int r10) {
            addViewInt(r5, r10, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View r5, int r10) {
            addViewInt(r5, r10, false);
        }

        @SuppressLint({"UnknownNullness"})
        @CallSuper
        public void onDetachedFromWindow(RecyclerView r5, Recycler r10) {
            onDetachedFromWindow(r5);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler r5, @NonNull State r10, @NonNull AccessibilityEvent r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (r12 == null) goto L20;
            if (r11 == null) goto L22;
            boolean r13 = true;
            if (r12.canScrollVertically(1) == false) goto L9;
        L16:
            r11.setScrollable(r13);
            Adapter r14 = this.mRecyclerView.mAdapter;
            if (r14 == null) goto L21;
            r11.setItemCount(r14.getItemCount());
            return;
        L21:
            return;
        L9:
            if (this.mRecyclerView.canScrollVertically(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(1) == true) goto L16;
            r13 = false;
            goto L16
        L22:
            return;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler r5, @NonNull State r10, @NonNull AccessibilityNodeInfoCompat r11) {
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L5;
        L6:
            r11.addAction(8192);
            r11.setScrollable(true);
        L8:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L10;
        L11:
            r11.addAction(4096);
            r11.setScrollable(true);
        L12:
            r11.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(r5, r10), getColumnCountForAccessibility(r5, r10), isLayoutHierarchical(r5, r10), getSelectionModeForAccessibility(r5, r10)));
            return;
        L10:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public void onInitializeAccessibilityNodeInfoForItem(View r5, AccessibilityNodeInfoCompat r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r5);
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.isRemoved() == false) goto L7;
            return;
        L7:
            if (this.mChildHelper.isHidden(r11.itemView) == true) goto L12;
            RecyclerView r12 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(r12.mRecycler, r12.mState, r5, r10);
            return;
        }

        public void onItemsUpdated(@NonNull RecyclerView r5, int r10, int r11, @Nullable Object r12) {
            onItemsUpdated(r5, r10, r11);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView r5, @NonNull State r10, @NonNull View r11, @Nullable View r12) {
            return onRequestChildFocus(r5, r11, r12);
        }

        public boolean performAccessibilityAction(@NonNull Recycler r10, @NonNull State r11, int r12, @Nullable Bundle r13) {
            if (this.mRecyclerView != null) goto L5;
            return false;
        L5:
            int r14 = getHeight();
            int r15 = getWidth();
            Rect r5 = new Rect();
            if (this.mRecyclerView.getMatrix().isIdentity() == false) goto L11;
            if (this.mRecyclerView.getGlobalVisibleRect(r5) == false) goto L11;
            r14 = r5.height();
            r15 = r5.width();
        L11:
            if (r12 == 4096) goto L25;
            if (r12 == 8192) goto L16;
            int r16 = 0;
            int r17 = 0;
        L31:
            if (r17 != 0) goto L34;
            if (r16 != 0) goto L34;
            return false;
        L34:
            this.mRecyclerView.smoothScrollBy(r16, r17, null, Integer.MIN_VALUE, true);
            return true;
        L16:
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L18;
            int r18 = -((r14 - getPaddingTop()) - getPaddingBottom());
        L20:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L23;
            int r19 = -((r15 - getPaddingLeft()) - getPaddingRight());
        L22:
            r17 = r18;
            r16 = r19;
        L23:
            r17 = r18;
            r16 = 0;
            goto L31
        L18:
            r18 = 0;
            goto L20
        L25:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L27;
            r18 = (r14 - getPaddingTop()) - getPaddingBottom();
        L29:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L23;
            r19 = (r15 - getPaddingLeft()) - getPaddingRight();
            goto L22
        L27:
            r18 = 0;
            goto L29
        }

        public boolean performAccessibilityActionForItem(@NonNull View r10, int r11, @Nullable Bundle r12) {
            RecyclerView r5 = this.mRecyclerView;
            return performAccessibilityActionForItem(r5.mRecycler, r5.mState, r10, r11, r12);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r5, @NonNull View r10, @NonNull Rect r11, boolean r12, boolean r13) {
            int[] r14 = getChildRectangleOnScreenScrollAmount(r10, r11);
            int r15 = r14[0];
            int r16 = r14[1];
            if (r13 == true) goto L5;
        L6:
            if (r15 != 0) goto L10;
            if (r16 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r12 == false) goto L12;
            r5.scrollBy(r15, r16);
        L13:
            return true;
        L12:
            r5.smoothScrollBy(r15, r16);
            goto L13
        L5:
            if (isFocusedChildVisibleAfterScrolling(r5, r15, r16) == false) goto L9;
            goto L6
        }

        public static int getChildMeasureSpec(int r5, int r10, int r11, int r12, boolean r13) {
            int r14 = Math.max(0, r5 - r11);
            if (r13 == false) goto L11;
            if (r12 < 0) goto L6;
        L5:
            r10 = 1073741824;
        L22:
            return View.MeasureSpec.makeMeasureSpec(r12, r10);
        L6:
            if (r12 != (-1)) goto L10;
            if (r10 == Integer.MIN_VALUE) goto L14;
            if (r10 == 0) goto L10;
            if (r10 != 1073741824) goto L10;
        L14:
            r12 = r14;
        L10:
            r10 = 0;
            r12 = 0;
            goto L22
        L11:
            if (r12 >= 0) goto L5;
            if (r12 == (-1)) goto L14;
            if (r12 != (-2)) goto L10;
            if (r10 == Integer.MIN_VALUE) goto L20;
            if (r10 == 1073741824) goto L20;
            r12 = r14;
            r10 = 0;
        L20:
            r12 = r14;
            r10 = Integer.MIN_VALUE;
            goto L22
        }

        public void attachView(@NonNull View r5, int r10) {
            attachView(r5, r10, (LayoutParams) r5.getLayoutParams());
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context r5, AttributeSet r10) {
            return new LayoutParams(r5, r10);
        }

        public void setMeasuredDimension(int r5, int r10) {
            RecyclerView.access$500(this.mRecyclerView, r5, r10);
        }

        public void attachView(@NonNull View r5) {
            attachView(r5, -1);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
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

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams r5) {
            super(r5);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View r5);

        void onChildViewDetachedFromWindow(@NonNull View r5);
    }

    public static abstract class OnFlingListener {
        public OnFlingListener() {
        }

        public abstract boolean onFling(int r5, int r10);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView r5, @NonNull MotionEvent r10);

        void onRequestDisallowInterceptTouchEvent(boolean r5);

        void onTouchEvent(@NonNull RecyclerView r5, @NonNull MotionEvent r10);
    }

    public static abstract class OnScrollListener {
        public OnScrollListener() {
        }

        public void onScrollStateChanged(@NonNull RecyclerView r5, int r10) {
        }

        public void onScrolled(@NonNull RecyclerView r5, int r10, int r11) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        int mAttachCountForClearing;
        Set<Adapter<?>> mAttachedAdaptersForPoolingContainer;
        SparseArray<ScrapData> mScrap;

        public static class ScrapData {
            long mBindRunningAverageNs;
            long mCreateRunningAverageNs;
            int mMaxScrap;
            final ArrayList<ViewHolder> mScrapHeap;

            public ScrapData() {
                this.mScrapHeap = new ArrayList();
                this.mMaxScrap = 5;
                this.mCreateRunningAverageNs = 0;
                this.mBindRunningAverageNs = 0;
            }
        }

        public RecycledViewPool() {
            this.mScrap = new SparseArray();
            this.mAttachCountForClearing = 0;
            this.mAttachedAdaptersForPoolingContainer = Collections.newSetFromMap(new IdentityHashMap());
        }

        private ScrapData getScrapDataForType(int r5) {
            ScrapData r10 = this.mScrap.get(r5);
            if (r10 != null) goto L6;
            ScrapData r11 = new ScrapData();
            this.mScrap.put(r5, r11);
            return r11;
        L6:
            return r10;
        }

        public void attach() {
            this.mAttachCountForClearing++;
        }

        public void attachForPoolingContainer(@NonNull Adapter<?> r5) {
            this.mAttachedAdaptersForPoolingContainer.add(r5);
        }

        public void clear() {
            int r5 = 0;
        L4:
            if (r5 >= this.mScrap.size()) goto L10;
            ScrapData r10 = this.mScrap.valueAt(r5);
            Iterator<ViewHolder> r11 = r10.mScrapHeap.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            PoolingContainer.callPoolingContainerOnRelease(r11.next().itemView);
            goto L7
        L9:
            r10.mScrapHeap.clear();
            r5 = r5 + 1;
            goto L4
        }

        public void detach() {
            this.mAttachCountForClearing--;
        }

        public void detachForPoolingContainer(@NonNull Adapter<?> r5, boolean r10) {
            this.mAttachedAdaptersForPoolingContainer.remove(r5);
            if (this.mAttachedAdaptersForPoolingContainer.size() != 0) goto L13;
            if (r10 == true) goto L16;
            int r11 = 0;
        L7:
            if (r11 >= this.mScrap.size()) goto L17;
            SparseArray<ScrapData> r12 = this.mScrap;
            ArrayList<ViewHolder> r13 = r12.get(r12.keyAt(r11)).mScrapHeap;
            int r14 = 0;
        L10:
            if (r14 >= r13.size()) goto L12;
            PoolingContainer.callPoolingContainerOnRelease(r13.get(r14).itemView);
            r14 = r14 + 1;
            goto L10
        L12:
            r11 = r11 + 1;
            goto L7
        L17:
            return;
        L16:
            return;
        }

        public void factorInBindTime(int r5, long r10) {
            ScrapData r11 = getScrapDataForType(r5);
            r11.mBindRunningAverageNs = runningAverage(r11.mBindRunningAverageNs, r10);
        }

        public void factorInCreateTime(int r5, long r10) {
            ScrapData r11 = getScrapDataForType(r5);
            r11.mCreateRunningAverageNs = runningAverage(r11.mCreateRunningAverageNs, r10);
        }

        @Nullable
        public ViewHolder getRecycledView(int r5) {
            ScrapData r10 = this.mScrap.get(r5);
            if (r10 != null) goto L5;
            return null;
        L5:
            if (r10.mScrapHeap.isEmpty() == true) goto L17;
            ArrayList<ViewHolder> r11 = r10.mScrapHeap;
            int r12 = r11.size() - 1;
        L7:
            if (r12 < 0) goto L18;
            if (r11.get(r12).isAttachedToTransitionOverlay() == false) goto L11;
            r12 = r12 - 1;
            goto L7
        L11:
            return r11.remove(r12);
        L18:
            return null;
        L17:
            return null;
        }

        public int getRecycledViewCount(int r5) {
            return getScrapDataForType(r5).mScrapHeap.size();
        }

        public void onAdapterChanged(Adapter<?> r5, Adapter<?> r10, boolean r11) {
            if (r5 == null) goto L4;
            detach();
        L4:
            if (r11 == false) goto L6;
        L8:
            if (r10 == null) goto L11;
            attach();
            return;
        L11:
            return;
        L6:
            if (this.mAttachCountForClearing != 0) goto L8;
            clear();
            goto L8
        }

        public void putRecycledView(ViewHolder r5) {
            int r10 = r5.getItemViewType();
            ArrayList<ViewHolder> r11 = getScrapDataForType(r10).mScrapHeap;
            if (this.mScrap.get(r10).mMaxScrap > r11.size()) goto L7;
            PoolingContainer.callPoolingContainerOnRelease(r5.itemView);
            return;
        L7:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L9;
        L13:
            r5.resetInternal();
            r11.add(r5);
            return;
        L9:
            if (r11.contains(r5) == false) goto L13;
            throw new IllegalArgumentException("this scrap item already exists");
        }

        public long runningAverage(long r5, long r10) {
            if (r5 != 0) goto L5;
            return r10;
        L5:
            long r11 = r10 / 4;
            return r11 + ((r5 / 4) * 3);
        }

        public void setMaxRecycledViews(int r5, int r10) {
            ScrapData r11 = getScrapDataForType(r5);
            r11.mMaxScrap = r10;
            ArrayList<ViewHolder> r12 = r11.mScrapHeap;
        L4:
            if (r12.size() <= r10) goto L6;
            r12.remove(r12.size() - 1);
            goto L4
        }

        public int size() {
            int r5 = 0;
            int r10 = 0;
        L4:
            if (r5 >= this.mScrap.size()) goto L9;
            ArrayList<ViewHolder> r11 = this.mScrap.valueAt(r5).mScrapHeap;
            if (r11 == null) goto L8;
            r10 = r11.size() + r10;
        L8:
            r5 = r5 + 1;
            goto L4
        L9:
            return r10;
        }

        public boolean willBindInTime(int r5, long r10, long r11) {
            long r12 = getScrapDataForType(r5).mBindRunningAverageNs;
            if (r12 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r10 + r12) < r11) goto L8;
            return false;
        }

        public boolean willCreateInTime(int r5, long r10, long r11) {
            long r12 = getScrapDataForType(r5).mCreateRunningAverageNs;
            if (r12 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r10 + r12) < r11) goto L8;
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

        public Recycler(RecyclerView r5) {
            this.this$0 = r5;
            ArrayList<ViewHolder> r10 = new ArrayList();
            this.mAttachedScrap = r10;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(r10);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder r5) {
            if (this.this$0.isAccessibilityEnabled() == false) goto L15;
            View r10 = r5.itemView;
            if (ViewCompat.getImportantForAccessibility(r10) != 0) goto L7;
            ViewCompat.setImportantForAccessibility(r10, 1);
        L7:
            RecyclerViewAccessibilityDelegate r11 = this.this$0.mAccessibilityDelegate;
            if (r11 != null) goto L10;
            return;
        L10:
            AccessibilityDelegateCompat r12 = r11.getItemDelegate();
            if ((r12 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L13;
            ((RecyclerViewAccessibilityDelegate.ItemDelegate) r12).saveOriginalDelegate(r10);
        L13:
            ViewCompat.setAccessibilityDelegate(r10, r12);
            return;
        }

        private void invalidateDisplayListInt(ViewHolder r5) {
            View r10 = r5.itemView;
            if ((r10 instanceof ViewGroup) == false) goto L6;
            invalidateDisplayListInt((ViewGroup) r10, false);
            return;
        }

        private void maybeSendPoolingContainerAttach() {
            if (this.mRecyclerPool == null) goto L10;
            RecyclerView r5 = this.this$0;
            if (r5.mAdapter != null) goto L7;
            return;
        L7:
            if (r5.isAttachedToWindow() == false) goto L12;
            this.mRecyclerPool.attachForPoolingContainer(this.this$0.mAdapter);
            return;
        L12:
            return;
        }

        private void poolingContainerDetach(Adapter<?> r5) {
            poolingContainerDetach(r5, false);
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder r11, int r12, int r13, long r14) {
            r11.mBindingAdapter = null;
            r11.mOwnerRecyclerView = this.this$0;
            int r5 = r11.getItemViewType();
            long r10 = this.this$0.getNanoTime();
            boolean r15 = false;
            if (r14 == Long.MAX_VALUE) goto L8;
            if (this.mRecyclerPool.willBindInTime(r5, r10, r14) == true) goto L8;
            return false;
        L8:
            if (r11.isTmpDetached() == false) goto L10;
            RecyclerView r16 = this.this$0;
            RecyclerView.access$300(r16, r11.itemView, r16.getChildCount(), r11.itemView.getLayoutParams());
            r15 = true;
        L10:
            this.this$0.mAdapter.bindViewHolder(r11, r12);
            if (r15 == false) goto L13;
            RecyclerView.access$400(this.this$0, r11.itemView);
        L13:
            this.mRecyclerPool.factorInBindTime(r11.getItemViewType(), this.this$0.getNanoTime() - r10);
            attachAccessibilityDelegateOnBind(r11);
            if (this.this$0.mState.isPreLayout() == false) goto L16;
            r11.mPreLayoutPosition = r13;
        L16:
            return true;
        }

        public void addViewHolderToRecycledViewPool(@NonNull ViewHolder r5, boolean r10) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r5);
            View r11 = r5.itemView;
            RecyclerViewAccessibilityDelegate r12 = this.this$0.mAccessibilityDelegate;
            if (r12 == null) goto L9;
            AccessibilityDelegateCompat r13 = r12.getItemDelegate();
            if ((r13 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L7;
            AccessibilityDelegateCompat r14 = ((RecyclerViewAccessibilityDelegate.ItemDelegate) r13).getAndRemoveOriginalDelegateForItem(r11);
        L8:
            ViewCompat.setAccessibilityDelegate(r11, r14);
            goto L9
        L7:
            r14 = null;
        L9:
            if (r10 == false) goto L11;
            dispatchViewRecycled(r5);
        L11:
            r5.mBindingAdapter = null;
            r5.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(r5);
        }

        public void bindViewToPosition(@NonNull View r10, int r11) {
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r10);
            if (r12 == null) goto L23;
            int r5 = this.this$0.mAdapterHelper.findPositionOffset(r11);
            if (r5 >= 0) goto L7;
        L21:
            StringBuilder r13 = j0.v("Inconsistency detected. Invalid item position ", r11, r5, "(offset:", ").state:");
            r13.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.k(this.this$0, r13));
        L7:
            if (r5 >= this.this$0.mAdapter.getItemCount()) goto L21;
            tryBindViewHolderByDeadline(r12, r5, r11, Long.MAX_VALUE);
            ViewGroup.LayoutParams r14 = r12.itemView.getLayoutParams();
            if (r14 != null) goto L12;
            LayoutParams r15 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r12.itemView.setLayoutParams(r15);
        L15:
            boolean r16 = true;
            r15.mInsetsDirty = true;
            r15.mViewHolder = r12;
            if (r12.itemView.getParent() == null) goto L19;
            r16 = false;
        L19:
            r15.mPendingInvalidate = r16;
            return;
        L12:
            if (this.this$0.checkLayoutParams(r14) == true) goto L14;
            r15 = (LayoutParams) this.this$0.generateLayoutParams(r14);
            r12.itemView.setLayoutParams(r15);
            goto L15
        L14:
            r15 = (LayoutParams) r14;
            goto L15
        L23:
            StringBuilder r17 = new StringBuilder("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            throw new IllegalArgumentException(a.k(this.this$0, r17));
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void clearOldPositions() {
            int r5 = this.mCachedViews.size();
            int r10 = 0;
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L5;
            this.mCachedViews.get(r11).clearOldPosition();
            r11 = r11 + 1;
            goto L3
        L5:
            int r12 = this.mAttachedScrap.size();
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L8;
            this.mAttachedScrap.get(r13).clearOldPosition();
            r13 = r13 + 1;
            goto L6
        L8:
            ArrayList<ViewHolder> r14 = this.mChangedScrap;
            if (r14 == null) goto L13;
            int r15 = r14.size();
        L11:
            if (r10 >= r15) goto L17;
            this.mChangedScrap.get(r10).clearOldPosition();
            r10 = r10 + 1;
            goto L11
        L17:
            return;
        }

        public void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> r5 = this.mChangedScrap;
            if (r5 == null) goto L6;
            r5.clear();
            return;
        }

        public int convertPreLayoutPositionToPostLayout(int r5) {
            if (r5 >= 0) goto L4;
        L10:
            StringBuilder r10 = j0.s(r5, "invalid position ", ". State item count is ");
            r10.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.k(this.this$0, r10));
        L4:
            if (r5 >= this.this$0.mState.getItemCount()) goto L10;
            if (this.this$0.mState.isPreLayout() == true) goto L9;
            return r5;
        L9:
            return this.this$0.mAdapterHelper.findPositionOffset(r5);
        }

        public void dispatchViewRecycled(@NonNull ViewHolder r5) {
            RecyclerListener r10 = this.this$0.mRecyclerListener;
            if (r10 == null) goto L5;
            r10.onViewRecycled(r5);
        L5:
            int r11 = this.this$0.mRecyclerListeners.size();
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L8;
            this.this$0.mRecyclerListeners.get(r12).onViewRecycled(r5);
            r12 = r12 + 1;
            goto L6
        L8:
            Adapter r13 = this.this$0.mAdapter;
            if (r13 == null) goto L11;
            r13.onViewRecycled(r5);
        L11:
            RecyclerView r14 = this.this$0;
            if (r14.mState == null) goto L15;
            r14.mViewInfoStore.removeViewHolder(r5);
        L15:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L19;
            Log.d(RecyclerView.TAG, "dispatchViewRecycled: " + r5);
            return;
        }

        public ViewHolder getChangedScrapViewForPosition(int r10) {
            ArrayList<ViewHolder> r5 = this.mChangedScrap;
            if (r5 == null) goto L32;
            int r11 = r5.size();
            if (r11 == 0) goto L32;
            int r12 = 0;
            int r13 = 0;
        L9:
            if (r13 >= r11) goto L18;
            ViewHolder r14 = this.mChangedScrap.get(r13);
            if (r14.wasReturnedFromScrap() == true) goto L16;
            if (r14.getLayoutPosition() != r10) goto L16;
            r14.addFlags(32);
            return r14;
        L16:
            r13 = r13 + 1;
            goto L9
        L18:
            if (this.this$0.mAdapter.hasStableIds() == false) goto L32;
            int r15 = this.this$0.mAdapterHelper.findPositionOffset(r10);
            if (r15 <= 0) goto L32;
            if (r15 >= this.this$0.mAdapter.getItemCount()) goto L32;
            long r16 = this.this$0.mAdapter.getItemId(r15);
        L24:
            if (r12 >= r11) goto L32;
            ViewHolder r17 = this.mChangedScrap.get(r12);
            if (r17.wasReturnedFromScrap() == true) goto L31;
            if (r17.getItemId() != r16) goto L31;
            r17.addFlags(32);
            return r17;
        L31:
            r12 = r12 + 1;
        L32:
            return null;
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool != null) goto L6;
            this.mRecyclerPool = new RecycledViewPool();
            maybeSendPoolingContainerAttach();
        L6:
            return this.mRecyclerPool;
        }

        public int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        public ViewHolder getScrapOrCachedViewForId(long r10, int r11, boolean r12) {
            int r5 = this.mAttachedScrap.size() - 1;
        L3:
            if (r5 < 0) goto L19;
            ViewHolder r13 = this.mAttachedScrap.get(r5);
            if (r13.getItemId() != r10) goto L18;
            if (r13.wasReturnedFromScrap() == true) goto L18;
            if (r11 == r13.getItemViewType()) goto L10;
            if (r12 == true) goto L18;
            this.mAttachedScrap.remove(r5);
            this.this$0.removeDetachedView(r13.itemView, false);
            quickRecycleScrapView(r13.itemView);
            goto L18
        L10:
            r13.addFlags(32);
            if (r13.isRemoved() == true) goto L13;
        L15:
            return r13;
        L13:
            if (this.this$0.mState.isPreLayout() == true) goto L15;
            r13.setFlags(2, 14);
        L18:
            r5 = r5 - 1;
            goto L3
        L19:
            int r14 = this.mCachedViews.size();
        L20:
            r14 = r14 - 1;
            if (r14 < 0) goto L35;
            ViewHolder r15 = this.mCachedViews.get(r14);
            if (r15.getItemId() != r10) goto L20;
            if (r15.isAttachedToTransitionOverlay() == true) goto L20;
            if (r11 == r15.getItemViewType()) goto L28;
            if (r12 == true) goto L20;
            recycleCachedViewAt(r14);
            return null;
        L28:
            if (r12 == true) goto L30;
            this.mCachedViews.remove(r14);
        L30:
            return r15;
        L35:
            return null;
        }

        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int r10, boolean r11) {
            int r5 = this.mAttachedScrap.size();
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r13 >= r5) goto L17;
            ViewHolder r14 = this.mAttachedScrap.get(r13);
            if (r14.wasReturnedFromScrap() == true) goto L16;
            if (r14.getLayoutPosition() != r10) goto L16;
            if (r14.isInvalid() == true) goto L16;
            if (this.this$0.mState.mInPreLayout == true) goto L14;
            if (r14.isRemoved() == true) goto L16;
        L14:
            r14.addFlags(32);
            return r14;
        L16:
            r13 = r13 + 1;
            goto L3
        L17:
            if (r11 == true) goto L26;
            View r15 = this.this$0.mChildHelper.findHiddenNonRemovedView(r10);
            if (r15 == null) goto L26;
            ViewHolder r16 = RecyclerView.getChildViewHolderInt(r15);
            this.this$0.mChildHelper.unhide(r15);
            int r17 = this.this$0.mChildHelper.indexOfChild(r15);
            if (r17 == (-1)) goto L24;
            this.this$0.mChildHelper.detachViewFromParent(r17);
            scrapView(r15);
            r16.addFlags(8224);
            return r16;
        L24:
            StringBuilder r18 = new StringBuilder("layout index should not be -1 after unhiding a view:");
            r18.append(r16);
            throw new IllegalStateException(a.k(this.this$0, r18));
        L26:
            int r19 = this.mCachedViews.size();
        L27:
            if (r12 >= r19) goto L41;
            ViewHolder r20 = this.mCachedViews.get(r12);
            if (r20.isInvalid() == true) goto L40;
            if (r20.getLayoutPosition() != r10) goto L40;
            if (r20.isAttachedToTransitionOverlay() == true) goto L40;
            if (r11 == true) goto L37;
            this.mCachedViews.remove(r12);
        L37:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L39;
            Log.d(RecyclerView.TAG, "getScrapOrHiddenOrCachedHolderForPosition(" + r10 + ") found match in cache: " + r20);
        L39:
            return r20;
        L40:
            r12 = r12 + 1;
            goto L27
        L41:
            return null;
        }

        public View getScrapViewAt(int r5) {
            return this.mAttachedScrap.get(r5).itemView;
        }

        @NonNull
        public View getViewForPosition(int r5) {
            return getViewForPosition(r5, false);
        }

        public void markItemDecorInsetsDirty() {
            int r5 = this.mCachedViews.size();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L8;
            LayoutParams r11 = (LayoutParams) this.mCachedViews.get(r10).itemView.getLayoutParams();
            if (r11 == null) goto L7;
            r11.mInsetsDirty = true;
        L7:
            r10 = r10 + 1;
            goto L3
        }

        public void markKnownViewsInvalid() {
            int r5 = this.mCachedViews.size();
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L8;
            ViewHolder r11 = this.mCachedViews.get(r10);
            if (r11 == null) goto L7;
            r11.addFlags(6);
            r11.addChangePayload(null);
        L7:
            r10 = r10 + 1;
            goto L3
        L8:
            Adapter r12 = this.this$0.mAdapter;
            if (r12 != null) goto L11;
        L12:
            recycleAndClearCachedViews();
            return;
        L11:
            if (r12.hasStableIds() == false) goto L12;
        }

        public void offsetPositionRecordsForInsert(int r10, int r11) {
            int r5 = this.mCachedViews.size();
            int r12 = 0;
        L3:
            if (r12 >= r5) goto L13;
            ViewHolder r13 = this.mCachedViews.get(r12);
            if (r13 == null) goto L12;
            if (r13.mPosition < r10) goto L12;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForInsert cached " + r12 + " holder " + r13 + " now at position " + (r13.mPosition + r11));
        L11:
            r13.offsetPosition(r11, false);
        L12:
            r12 = r12 + 1;
            goto L3
        }

        public void offsetPositionRecordsForMove(int r10, int r11) {
            if (r10 >= r11) goto L4;
            int r5 = -1;
            int r12 = r10;
            int r13 = r11;
        L5:
            int r14 = this.mCachedViews.size();
            int r15 = 0;
        L6:
            if (r15 >= r14) goto L20;
            ViewHolder r16 = this.mCachedViews.get(r15);
            if (r16 == null) goto L19;
            int r17 = r16.mPosition;
            if (r17 < r12) goto L19;
            if (r17 > r13) goto L19;
            if (r17 != r10) goto L15;
            r16.offsetPosition(r11 - r10, false);
        L17:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L19;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForMove cached child " + r15 + " holder " + r16);
            goto L19
        L15:
            r16.offsetPosition(r5, false);
        L19:
            r15 = r15 + 1;
            goto L6
        L20:
            return;
        L4:
            r5 = 1;
            r13 = r10;
            r12 = r11;
            goto L5
        }

        public void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
            int r5 = r10 + r11;
            int r13 = this.mCachedViews.size() - 1;
        L3:
            if (r13 < 0) goto L15;
            ViewHolder r14 = this.mCachedViews.get(r13);
            if (r14 == null) goto L14;
            int r15 = r14.mPosition;
            if (r15 >= r5) goto L9;
            if (r15 < r10) goto L14;
            r14.addFlags(8);
            recycleCachedViewAt(r13);
            goto L14
        L9:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForRemove cached " + r13 + " holder " + r14 + " now at position " + (r14.mPosition - r11));
        L11:
            r14.offsetPosition(-r11, r12);
        L14:
            r13 = r13 - 1;
            goto L3
        }

        public void onAdapterChanged(Adapter<?> r5, Adapter<?> r10, boolean r11) {
            clear();
            poolingContainerDetach(r5, true);
            getRecycledViewPool().onAdapterChanged(r5, r10, r11);
            maybeSendPoolingContainerAttach();
        }

        public void onAttachedToWindow() {
            maybeSendPoolingContainerAttach();
        }

        public void onDetachedFromWindow() {
            int r5 = 0;
        L4:
            if (r5 >= this.mCachedViews.size()) goto L6;
            PoolingContainer.callPoolingContainerOnRelease(this.mCachedViews.get(r5).itemView);
            r5 = r5 + 1;
            goto L4
        L6:
            poolingContainerDetach(this.this$0.mAdapter);
        }

        public void quickRecycleScrapView(View r5) {
            ViewHolder r10 = RecyclerView.getChildViewHolderInt(r5);
            r10.mScrapContainer = null;
            r10.mInChangeScrap = false;
            r10.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(r10);
        }

        public void recycleAndClearCachedViews() {
            int r5 = this.mCachedViews.size() - 1;
        L3:
            if (r5 < 0) goto L5;
            recycleCachedViewAt(r5);
            r5 = r5 - 1;
            goto L3
        L5:
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
            return;
        }

        public void recycleCachedViewAt(int r5) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L5;
            Log.d(RecyclerView.TAG, "Recycling cached view at index " + r5);
        L5:
            ViewHolder r10 = this.mCachedViews.get(r5);
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L8;
            Log.d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + r10);
        L8:
            addViewHolderToRecycledViewPool(r10, true);
            this.mCachedViews.remove(r5);
        }

        public void recycleView(@NonNull View r5) {
            ViewHolder r10 = RecyclerView.getChildViewHolderInt(r5);
            if (r10.isTmpDetached() == false) goto L6;
            this.this$0.removeDetachedView(r5, false);
        L6:
            if (r10.isScrap() == false) goto L9;
            r10.unScrap();
        L11:
            recycleViewHolderInternal(r10);
            if (this.this$0.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r10.isRecyclable() == true) goto L18;
            this.this$0.mItemAnimator.endAnimation(r10);
            return;
        L18:
            return;
        L9:
            if (r10.wasReturnedFromScrap() == false) goto L11;
            r10.clearReturnedFromScrapFlag();
            goto L11
        }

        public void recycleViewHolderInternal(ViewHolder r10) {
            boolean r5 = false;
            boolean r11 = true;
            if (r10.isScrap() == false) goto L5;
        L69:
            StringBuilder r12 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            r12.append(r10.isScrap());
            r12.append(" isAttached:");
            if (r10.itemView.getParent() == null) goto L72;
            r5 = true;
        L72:
            r12.append(r5);
            throw new IllegalArgumentException(a.k(this.this$0, r12));
        L5:
            if (r10.itemView.getParent() != null) goto L69;
            if (r10.isTmpDetached() == false) goto L10;
            StringBuilder r13 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            r13.append(r10);
            throw new IllegalArgumentException(a.k(this.this$0, r13));
        L10:
            if (r10.shouldIgnore() == true) goto L66;
            boolean r14 = r10.doesTransientStatePreventRecycling();
            Adapter r15 = this.this$0.mAdapter;
            if (r15 == null) goto L17;
            if (r14 == false) goto L17;
            if (r15.onFailedToRecycleView(r10) == false) goto L17;
            boolean r16 = true;
        L19:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L21;
        L25:
            if (r16 == true) goto L34;
            if (r10.isRecyclable() == true) goto L34;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L32;
            Log.d(RecyclerView.TAG, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + this.this$0.exceptionLabel());
        L32:
            r11 = false;
        L59:
            this.this$0.mViewInfoStore.removeViewHolder(r10);
            if (r5 == true) goto L76;
            if (r11 == true) goto L77;
            if (r14 == false) goto L78;
            PoolingContainer.callPoolingContainerOnRelease(r10.itemView);
            r10.mBindingAdapter = null;
            r10.mOwnerRecyclerView = null;
            return;
        L78:
            return;
        L77:
            return;
        L76:
            return;
        L34:
            if (this.mViewCacheMax > 0) goto L36;
        L54:
            boolean r17 = false;
        L55:
            if (r17 == true) goto L58;
            addViewHolderToRecycledViewPool(r10, true);
        L57:
            r5 = r17;
            goto L59
        L58:
            r11 = false;
            goto L57
        L36:
            if (r10.hasAnyOfTheFlags(526) == true) goto L54;
            int r18 = this.mCachedViews.size();
            if (r18 < this.mViewCacheMax) goto L42;
            if (r18 <= 0) goto L42;
            recycleCachedViewAt(0);
            r18 = r18 - 1;
        L42:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L53;
            if (r18 <= 0) goto L53;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(r10.mPosition) == true) goto L53;
            int r19 = r18 - 1;
        L47:
            if (r19 < 0) goto L52;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(r19).mPosition) == false) goto L52;
            r19 = r19 - 1;
        L52:
            r18 = r19 + 1;
        L53:
            this.mCachedViews.add(r18, r10);
            r17 = true;
            goto L55
        L21:
            if (this.mCachedViews.contains(r10) == false) goto L25;
            StringBuilder r20 = new StringBuilder("cached view received recycle internal? ");
            r20.append(r10);
            throw new IllegalArgumentException(a.k(this.this$0, r20));
        L17:
            r16 = false;
            goto L19
        L66:
            throw new IllegalArgumentException(a.k(this.this$0, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }

        public void scrapView(View r5) {
            ViewHolder r10 = RecyclerView.getChildViewHolderInt(r5);
            if (r10.hasAnyOfTheFlags(12) == true) goto L14;
            if (r10.isUpdated() == false) goto L14;
            if (this.this$0.canReuseUpdatedViewHolder(r10) == true) goto L14;
            if (this.mChangedScrap != null) goto L12;
            this.mChangedScrap = new ArrayList();
        L12:
            r10.setScrapContainer(this, true);
            this.mChangedScrap.add(r10);
            return;
        L14:
            if (r10.isInvalid() == true) goto L16;
        L22:
            r10.setScrapContainer(this, false);
            this.mAttachedScrap.add(r10);
            return;
        L16:
            if (r10.isRemoved() == true) goto L22;
            if (this.this$0.mAdapter.hasStableIds() == true) goto L22;
            StringBuilder r11 = new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            throw new IllegalArgumentException(a.k(this.this$0, r11));
        }

        public void setRecycledViewPool(RecycledViewPool r5) {
            poolingContainerDetach(this.this$0.mAdapter);
            RecycledViewPool r10 = this.mRecyclerPool;
            if (r10 == null) goto L5;
            r10.detach();
        L5:
            this.mRecyclerPool = r5;
            if (r5 != null) goto L8;
        L10:
            maybeSendPoolingContainerAttach();
            return;
        L8:
            if (this.this$0.getAdapter() == null) goto L10;
            this.mRecyclerPool.attach();
            goto L10
        }

        public void setViewCacheExtension(ViewCacheExtension r5) {
            this.mViewCacheExtension = r5;
        }

        public void setViewCacheSize(int r5) {
            this.mRequestedCacheMax = r5;
            updateViewCacheSize();
        }

        @Nullable
        public ViewHolder tryGetViewHolderForPositionByDeadline(int r19, boolean r20, long r21) {
            if (r19 >= 0) goto L5;
        L122:
            StringBuilder r5 = j0.v("Invalid item position ", r19, r19, "(", "). Item count:");
            r5.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.k(this.this$0, r5));
        L5:
            if (r19 >= this.this$0.mState.getItemCount()) goto L122;
            boolean r10 = true;
            if (this.this$0.mState.isPreLayout() == false) goto L11;
            ViewHolder r11 = getChangedScrapViewForPosition(r19);
            if (r11 == null) goto L12;
            boolean r12 = true;
        L13:
            if (r11 != null) goto L28;
            r11 = getScrapOrHiddenOrCachedHolderForPosition(r19, r20);
            if (r11 == null) goto L28;
            if (validateViewHolderForOffsetPosition(r11) == true) goto L27;
            if (r20 == true) goto L26;
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
            if (r11 != null) goto L76;
            int r13 = this.this$0.mAdapterHelper.findPositionOffset(r19);
            if (r13 >= 0) goto L32;
        L77:
            StringBuilder r14 = j0.v("Inconsistency detected. Invalid item position ", r19, r13, "(offset:", ").state:");
            r14.append(this.this$0.mState.getItemCount());
            throw new IndexOutOfBoundsException(a.k(this.this$0, r14));
        L32:
            if (r13 >= this.this$0.mAdapter.getItemCount()) goto L77;
            int r15 = this.this$0.mAdapter.getItemViewType(r13);
            if (this.this$0.mAdapter.hasStableIds() == false) goto L38;
            r11 = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(r13), r15, r20);
            if (r11 == null) goto L38;
            r11.mPosition = r13;
            r12 = true;
        L38:
            if (r11 != null) goto L53;
            ViewCacheExtension r16 = this.mViewCacheExtension;
            if (r16 == null) goto L53;
            View r17 = r16.getViewForPositionAndType(this, r19, r15);
            if (r17 == null) goto L53;
            r11 = this.this$0.getChildViewHolder(r17);
            if (r11 == null) goto L51;
            if (r11.shouldIgnore() == false) goto L53;
            throw new IllegalArgumentException(a.k(this.this$0, new StringBuilder("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.")));
        L51:
            throw new IllegalArgumentException(a.k(this.this$0, new StringBuilder("getViewForPositionAndType returned a view which does not have a ViewHolder")));
        L53:
            if (r11 == null) goto L55;
        L62:
            if (r11 != null) goto L76;
            long r18 = this.this$0.getNanoTime();
            if (r21 != Long.MAX_VALUE) goto L66;
        L68:
            RecyclerView r22 = this.this$0;
            r11 = r22.mAdapter.createViewHolder(r22, r15);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L73;
            RecyclerView r23 = RecyclerView.findNestedRecyclerView(r11.itemView);
            if (r23 == null) goto L73;
            r11.mNestedRecyclerView = new WeakReference(r23);
        L73:
            this.mRecyclerPool.factorInCreateTime(r15, this.this$0.getNanoTime() - r18);
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L76;
            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline created new ViewHolder");
            goto L76
        L66:
            if (this.mRecyclerPool.willCreateInTime(r15, r18, r21) == true) goto L68;
            return null;
        L55:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L57;
            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline(" + r19 + ") fetching from shared pool");
        L57:
            r11 = getRecycledViewPool().getRecycledView(r15);
            if (r11 == null) goto L62;
            r11.resetInternal();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L62;
            invalidateDisplayListInt(r11);
        L76:
            ViewHolder r24 = r11;
            boolean r110 = r12;
            if (r110 == false) goto L88;
            if (this.this$0.mState.isPreLayout() == true) goto L88;
            if (r24.hasAnyOfTheFlags(8192) == false) goto L88;
            r24.setFlags(0, 8192);
            if (this.this$0.mState.mRunSimpleAnimations == false) goto L88;
            int r25 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r24) | 4096;
            RecyclerView r26 = this.this$0;
            this.this$0.recordAnimationInfoIfBouncedHiddenView(r24, r26.mItemAnimator.recordPreLayoutInformation(r26.mState, r24, r25, r24.getUnmodifiedPayloads()));
        L88:
            if (this.this$0.mState.isPreLayout() == false) goto L93;
            if (r24.isBound() == false) goto L93;
            r24.mPreLayoutPosition = r19;
        L99:
            boolean r27 = false;
        L108:
            ViewGroup.LayoutParams r28 = r24.itemView.getLayoutParams();
            if (r28 != null) goto L112;
            LayoutParams r29 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r24.itemView.setLayoutParams(r29);
        L115:
            r29.mViewHolder = r24;
            if (r110 == false) goto L119;
            if (r27 == false) goto L119;
        L120:
            r29.mPendingInvalidate = r10;
            return r24;
        L119:
            r10 = false;
            goto L120
        L112:
            if (this.this$0.checkLayoutParams(r28) == true) goto L114;
            r29 = (LayoutParams) this.this$0.generateLayoutParams(r28);
            r24.itemView.setLayoutParams(r29);
            goto L115
        L114:
            r29 = (LayoutParams) r28;
        L93:
            if (r24.isBound() == false) goto L101;
            if (r24.needsUpdate() == true) goto L101;
            if (r24.isInvalid() == false) goto L99;
        L101:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L103;
        L107:
            r27 = tryBindViewHolderByDeadline(r24, this.this$0.mAdapterHelper.findPositionOffset(r19), r19, r21);
            goto L108
        L103:
            if (r24.isRemoved() == false) goto L107;
            StringBuilder r30 = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
            r30.append(r24);
            throw new IllegalStateException(a.k(this.this$0, r30));
        L12:
            r12 = false;
            goto L13
        L11:
            r11 = null;
            goto L12
        }

        public void unscrapView(ViewHolder r5) {
            if (r5.mInChangeScrap == false) goto L5;
            this.mChangedScrap.remove(r5);
        L6:
            r5.mScrapContainer = null;
            r5.mInChangeScrap = false;
            r5.clearReturnedFromScrapFlag();
            return;
        L5:
            this.mAttachedScrap.remove(r5);
            goto L6
        }

        public void updateViewCacheSize() {
            LayoutManager r5 = this.this$0.mLayout;
            if (r5 == null) goto L5;
            int r10 = r5.mPrefetchMaxCountObserved;
        L6:
            this.mViewCacheMax = this.mRequestedCacheMax + r10;
            int r11 = this.mCachedViews.size() - 1;
        L7:
            if (r11 < 0) goto L11;
            if (this.mCachedViews.size() <= this.mViewCacheMax) goto L14;
            recycleCachedViewAt(r11);
            r11 = r11 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r10 = 0;
            goto L6
        }

        public boolean validateViewHolderForOffsetPosition(ViewHolder r10) {
            if (r10.isRemoved() == true) goto L5;
            int r5 = r10.mPosition;
            if (r5 >= 0) goto L16;
        L29:
            StringBuilder r11 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
            r11.append(r10);
            throw new IndexOutOfBoundsException(a.k(this.this$0, r11));
        L16:
            if (r5 >= this.this$0.mAdapter.getItemCount()) goto L29;
            if (this.this$0.mState.isPreLayout() == true) goto L23;
            if (this.this$0.mAdapter.getItemViewType(r10.mPosition) == r10.getItemViewType()) goto L23;
            return false;
        L23:
            if (this.this$0.mAdapter.hasStableIds() == true) goto L25;
            return true;
        L25:
            if (r10.getItemId() == this.this$0.mAdapter.getItemId(r10.mPosition)) goto L27;
            return false;
        L27:
            return true;
        L5:
            if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
            if (this.this$0.mState.isPreLayout() == true) goto L12;
            StringBuilder r12 = new StringBuilder("should not receive a removed view unless it is pre layout");
            throw new IllegalStateException(a.k(this.this$0, r12));
        L12:
            return this.this$0.mState.isPreLayout();
        }

        public void viewRangeUpdate(int r5, int r10) {
            int r11 = r10 + r5;
            int r12 = this.mCachedViews.size() - 1;
        L3:
            if (r12 < 0) goto L12;
            ViewHolder r13 = this.mCachedViews.get(r12);
            if (r13 == null) goto L11;
            int r14 = r13.mPosition;
            if (r14 < r5) goto L11;
            if (r14 >= r11) goto L11;
            r13.addFlags(2);
            recycleCachedViewAt(r12);
        L11:
            r12 = r12 - 1;
            goto L3
        }

        private void poolingContainerDetach(Adapter<?> r5, boolean r10) {
            RecycledViewPool r11 = this.mRecyclerPool;
            if (r11 == null) goto L6;
            r11.detachForPoolingContainer(r5, r10);
            return;
        }

        public View getViewForPosition(int r5, boolean r10) {
            return tryGetViewHolderForPositionByDeadline(r5, r10, Long.MAX_VALUE).itemView;
        }

        private void invalidateDisplayListInt(ViewGroup r5, boolean r10) {
            int r11 = r5.getChildCount() - 1;
        L3:
            if (r11 < 0) goto L8;
            View r12 = r5.getChildAt(r11);
            if ((r12 instanceof ViewGroup) == false) goto L7;
            invalidateDisplayListInt((ViewGroup) r12, true);
        L7:
            r11 = r11 - 1;
            goto L3
        L8:
            if (r10 == true) goto L11;
            return;
        L11:
            if (r5.getVisibility() != 4) goto L13;
            r5.setVisibility(0);
            r5.setVisibility(4);
            return;
        L13:
            int r13 = r5.getVisibility();
            r5.setVisibility(4);
            r5.setVisibility(r13);
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder r5);
    }

    public class RecyclerViewDataObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerView this$0;

        public RecyclerViewDataObserver(RecyclerView r5) {
            this.this$0 = r5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.assertNotInLayoutOrScroll(null);
            RecyclerView r5 = this.this$0;
            r5.mState.mStructureChanged = true;
            r5.processDataSetCompletelyChanged(true);
            if (this.this$0.mAdapterHelper.hasPendingUpdates() == true) goto L6;
            this.this$0.requestLayout();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r5, int r10, Object r11) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeChanged(r5, r10, r11) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r5, int r10) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeInserted(r5, r10) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r5, int r10, int r11) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeMoved(r5, r10, r11) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r5, int r10) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeRemoved(r5, r10) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            RecyclerView r5 = this.this$0;
            if (r5.mPendingSavedState != null) goto L5;
            return;
        L5:
            Adapter r10 = r5.mAdapter;
            if (r10 != null) goto L8;
            return;
        L8:
            if (r10.canRestoreState() == false) goto L12;
            this.this$0.requestLayout();
            return;
        }

        public void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == false) goto L9;
            RecyclerView r5 = this.this$0;
            if (r5.mHasFixedSize == false) goto L9;
            if (r5.mIsAttached == false) goto L9;
            ViewCompat.postOnAnimation(r5, r5.mUpdateChildViewsRunnable);
            return;
        L9:
            RecyclerView r10 = this.this$0;
            r10.mAdapterUpdateDuringMeasure = true;
            r10.requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            if (r10 != null) goto L6;
            r10 = LayoutManager.class.getClassLoader();
        L6:
            this.mLayoutState = r5.readParcelable(r10);
        }

        public void copyFrom(SavedState r5) {
            this.mLayoutState = r5.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public SimpleOnItemTouchListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView r5, @NonNull MotionEvent r10) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r5) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView r5, @NonNull MotionEvent r10) {
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

            public Action(@Px int r5, @Px int r10) {
                this(r5, r10, Integer.MIN_VALUE, null);
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

            public boolean hasJumpTarget() {
                if (this.mJumpToPosition < 0) goto L5;
                return true;
            L5:
                return false;
            }

            public void jumpTo(int r5) {
                this.mJumpToPosition = r5;
            }

            public void runIfNecessary(RecyclerView r10) {
                int r5 = this.mJumpToPosition;
                if (r5 < 0) goto L7;
                this.mJumpToPosition = -1;
                r10.jumpToPositionForSmoothScroller(r5);
                this.mChanged = false;
                return;
            L7:
                if (this.mChanged == false) goto L12;
                validate();
                r10.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                int r11 = this.mConsecutiveUpdates + 1;
                this.mConsecutiveUpdates = r11;
                if (r11 <= 10) goto L11;
                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L11:
                this.mChanged = false;
                return;
            L12:
                this.mConsecutiveUpdates = 0;
            }

            public void setDuration(int r5) {
                this.mChanged = true;
                this.mDuration = r5;
            }

            public void setDx(@Px int r5) {
                this.mChanged = true;
                this.mDx = r5;
            }

            public void setDy(@Px int r5) {
                this.mChanged = true;
                this.mDy = r5;
            }

            public void setInterpolator(@Nullable Interpolator r5) {
                this.mChanged = true;
                this.mInterpolator = r5;
            }

            public void update(@Px int r5, @Px int r10, int r11, @Nullable Interpolator r12) {
                this.mDx = r5;
                this.mDy = r10;
                this.mDuration = r11;
                this.mInterpolator = r12;
                this.mChanged = true;
            }

            public Action(@Px int r5, @Px int r10, int r11) {
                this(r5, r10, r11, null);
            }

            public Action(@Px int r5, @Px int r10, int r11, @Nullable Interpolator r12) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = r5;
                this.mDy = r10;
                this.mDuration = r11;
                this.mInterpolator = r12;
            }
        }

        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int r5);
        }

        public SmoothScroller() {
            this.mTargetPosition = -1;
            this.mRecyclingAction = new Action(0, 0);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int r5) {
            Object r10 = getLayoutManager();
            if ((r10 instanceof ScrollVectorProvider) == true) goto L5;
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        L5:
            return ((ScrollVectorProvider) r10).computeScrollVectorForPosition(r5);
        }

        public View findViewByPosition(int r5) {
            return this.mRecyclerView.mLayout.findViewByPosition(r5);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View r5) {
            return this.mRecyclerView.getChildLayoutPosition(r5);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int r5) {
            this.mRecyclerView.scrollToPosition(r5);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(@NonNull PointF r5) {
            float r10 = r5.x;
            float r11 = r5.y;
            float r12 = (float) Math.sqrt((r11 * r11) + (r10 * r10));
            r5.x /= r12;
            r5.y /= r12;
        }

        public void onAnimation(int r10, int r11) {
            RecyclerView r5 = this.mRecyclerView;
            if (this.mTargetPosition == (-1)) goto L5;
            if (r5 == null) goto L5;
        L7:
            if (this.mPendingInitialRun == true) goto L9;
        L19:
            this.mPendingInitialRun = false;
            View r12 = this.mTargetView;
            if (r12 == null) goto L26;
            if (getChildPosition(r12) != this.mTargetPosition) goto L24;
            onTargetFound(this.mTargetView, r5.mState, this.mRecyclingAction);
            this.mRecyclingAction.runIfNecessary(r5);
            stop();
            goto L26
        L24:
            Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.mTargetView = null;
        L26:
            if (this.mRunning == false) goto L33;
            onSeekTargetStep(r10, r11, r5.mState, this.mRecyclingAction);
            boolean r13 = this.mRecyclingAction.hasJumpTarget();
            this.mRecyclingAction.runIfNecessary(r5);
            if (r13 == true) goto L30;
            return;
        L30:
            if (this.mRunning == false) goto L35;
            this.mPendingInitialRun = true;
            r5.mViewFlinger.postOnAnimation();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.mTargetView != null) goto L19;
            if (this.mLayoutManager == null) goto L19;
            PointF r14 = computeScrollVectorForPosition(this.mTargetPosition);
            if (r14 == null) goto L19;
            float r15 = r14.x;
            if (r15 == 0.0f) goto L17;
        L18:
            r5.scrollStep((int) Math.signum(r15), (int) Math.signum(r14.y), null);
            goto L19
        L17:
            if (r14.y == 0.0f) goto L19;
        L5:
            stop();
            goto L7
        }

        public void onChildAttachedToWindow(View r5) {
            if (getChildPosition(r5) != getTargetPosition()) goto L8;
            this.mTargetView = r5;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L9;
            Log.d(RecyclerView.TAG, "smooth scroll target view has been attached");
            return;
        L9:
            return;
        }

        public abstract void onSeekTargetStep(@Px int r5, @Px int r10, @NonNull State r11, @NonNull Action r12);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(@NonNull View r5, @NonNull State r10, @NonNull Action r11);

        public void setTargetPosition(int r5) {
            this.mTargetPosition = r5;
        }

        public void start(RecyclerView r5, LayoutManager r10) {
            r5.mViewFlinger.stop();
            if (this.mStarted == false) goto L5;
            Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L5:
            this.mRecyclerView = r5;
            this.mLayoutManager = r10;
            int r11 = this.mTargetPosition;
            if (r11 == (-1)) goto L10;
            r5.mState.mTargetPosition = r11;
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

        public final void stop() {
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

        public void assertLayoutStep(int r5) {
            if ((this.mLayoutStep & r5) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r5) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public <T> T get(int r5) {
            SparseArray<Object> r10 = this.mData;
            if (r10 != null) goto L7;
            return null;
        L7:
            return (T) r10.get(r5);
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

        public void prepareForNestedPrefetch(Adapter r5) {
            this.mLayoutStep = 1;
            this.mItemCount = r5.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void put(int r5, Object r10) {
            if (this.mData != null) goto L5;
            this.mData = new SparseArray();
        L5:
            this.mData.put(r5, r10);
        }

        public void remove(int r5) {
            SparseArray<Object> r10 = this.mData;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.remove(r5);
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("State{mTargetPosition=");
            r5.append(this.mTargetPosition);
            r5.append(", mData=");
            r5.append(this.mData);
            r5.append(", mItemCount=");
            r5.append(this.mItemCount);
            r5.append(", mIsMeasuring=");
            r5.append(this.mIsMeasuring);
            r5.append(", mPreviousLayoutItemCount=");
            r5.append(this.mPreviousLayoutItemCount);
            r5.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            r5.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
            r5.append(", mStructureChanged=");
            r5.append(this.mStructureChanged);
            r5.append(", mInPreLayout=");
            r5.append(this.mInPreLayout);
            r5.append(", mRunSimpleAnimations=");
            r5.append(this.mRunSimpleAnimations);
            r5.append(", mRunPredictiveAnimations=");
            return a.w(r5, this.mRunPredictiveAnimations, '}');
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
        public abstract View getViewForPositionAndType(@NonNull Recycler r5, int r10, int r11);
    }

    public class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScrollerAdapter mOverScroller;
        private boolean mReSchedulePostAnimationCallback;
        final /* synthetic */ RecyclerView this$0;

        public ViewFlinger(RecyclerView r5) {
            this.this$0 = r5;
            Interpolator r10 = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = r10;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScrollerAdapter(r5.getContext(), r10);
        }

        private int computeScrollDuration(int r5, int r10) {
            int r11 = Math.abs(r5);
            int r12 = Math.abs(r10);
            if (r11 <= r12) goto L5;
            boolean r13 = true;
        L6:
            RecyclerView r14 = this.this$0;
            if (r13 == false) goto L9;
            int r15 = r14.getWidth();
        L10:
            if (r13 == true) goto L14;
            r11 = r12;
        L14:
            return Math.min((int) (((r11 / r15) + 1.0f) * 300.0f), RecyclerView.MAX_SCROLL_DURATION);
        L9:
            r15 = r14.getHeight();
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        private void internalPostOnAnimation() {
            this.this$0.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.this$0, this);
        }

        public void fling(int r13, int r14) {
            this.this$0.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator r5 = this.mInterpolator;
            Interpolator r10 = RecyclerView.sQuinticInterpolator;
            if (r5 == r10) goto L5;
            this.mInterpolator = r10;
            this.mOverScroller = new OverScrollerAdapter(this.this$0.getContext(), r10);
        L5:
            this.mOverScroller.fling(0, 0, r13, r14, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest == false) goto L5;
            this.mReSchedulePostAnimationCallback = true;
            return;
        L5:
            internalPostOnAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r5 = this.this$0;
            if (r5.mLayout != null) goto L6;
            stop();
            return;
        L6:
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            r5.consumePendingUpdateOperations();
            OverScrollerAdapter r10 = this.mOverScroller;
            if (r10.computeScrollOffset() == false) goto L80;
            int r11 = r10.getCurrX();
            int r12 = r10.getCurrY();
            int r13 = r11 - this.mLastFlingX;
            int r14 = r12 - this.mLastFlingY;
            this.mLastFlingX = r11;
            this.mLastFlingY = r12;
            int r15 = this.this$0.consumeFlingInHorizontalStretch(r13);
            int r16 = this.this$0.consumeFlingInVerticalStretch(r14);
            RecyclerView r17 = this.this$0;
            int[] r18 = r17.mReusableIntPair;
            r18[0] = 0;
            r18[1] = 0;
            if (r17.dispatchNestedPreScroll(r15, r16, r18, null, 1) == false) goto L11;
            int[] r19 = this.this$0.mReusableIntPair;
            r15 = r15 - r19[0];
            r16 = r16 - r19[1];
        L11:
            RecyclerView r20 = this.this$0;
            if (r20.mAdapter == null) goto L26;
            int[] r21 = r20.mReusableIntPair;
            r21[0] = 0;
            r21[1] = 0;
            r20.scrollStep(r15, r16, r21);
            RecyclerView r22 = this.this$0;
            int[] r23 = r22.mReusableIntPair;
            int r24 = r23[0];
            int r25 = r23[1];
            r15 = r15 - r24;
            r16 = r16 - r25;
            SmoothScroller r26 = r22.mLayout.mSmoothScroller;
            if (r26 == null) goto L28;
            if (r26.isPendingInitialRun() == true) goto L28;
            if (r26.isRunning() == false) goto L28;
            int r27 = this.this$0.mState.getItemCount();
            if (r27 != 0) goto L23;
            r26.stop();
            goto L28
        L23:
            if (r26.getTargetPosition() < r27) goto L25;
            r26.setTargetPosition(r27 - 1);
            r26.onAnimation(r24, r25);
            goto L28
        L25:
            r26.onAnimation(r24, r25);
        L28:
            if (this.this$0.mItemDecorations.isEmpty() == true) goto L30;
            this.this$0.invalidate();
        L30:
            RecyclerView r110 = this.this$0;
            int[] r28 = r110.mReusableIntPair;
            r28[0] = 0;
            r28[1] = 0;
            r110.dispatchNestedScroll(r24, r25, r15, r16, null, 1, r28);
            RecyclerView r29 = this.this$0;
            int[] r30 = r29.mReusableIntPair;
            int r31 = r15 - r30[0];
            int r32 = r16 - r30[1];
            if (r24 != 0) goto L33;
            if (r25 != 0) goto L33;
        L35:
            if (RecyclerView.access$200(this.this$0) == true) goto L38;
            this.this$0.invalidate();
        L38:
            if (r10.getCurrX() != r10.getFinalX()) goto L40;
            boolean r33 = true;
        L42:
            if (r10.getCurrY() != r10.getFinalY()) goto L44;
            boolean r34 = true;
        L46:
            if (r10.isFinished() == true) goto L53;
            if (r33 == true) goto L49;
            if (r31 != 0) goto L49;
        L52:
            boolean r35 = false;
        L54:
            SmoothScroller r36 = this.this$0.mLayout.mSmoothScroller;
            if (r36 != null) goto L57;
        L59:
            if (r35 == true) goto L61;
        L77:
            postOnAnimation();
            RecyclerView r37 = this.this$0;
            GapWorker r38 = r37.mGapWorker;
            if (r38 == null) goto L80;
            r38.postFromTraversal(r37, r24, r25);
            goto L80
        L61:
            if (this.this$0.getOverScrollMode() == 2) goto L75;
            int r39 = (int) r10.getCurrVelocity();
            if (r31 >= 0) goto L65;
            int r40 = r39;
        L68:
            if (r32 < 0) goto L73;
            if (r32 <= 0) goto L72;
            r39 = -r39;
            goto L73
        L72:
            r39 = 0;
        L73:
            this.this$0.absorbGlows(r40, r39);
            goto L75
        L65:
            if (r31 <= 0) goto L67;
            r40 = -r39;
            goto L68
        L67:
            r40 = 0;
        L75:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L80;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
            goto L80
        L57:
            if (r36.isPendingInitialRun() == false) goto L59;
        L49:
            if (r34 == true) goto L53;
            if (r32 == 0) goto L52;
        L53:
            r35 = true;
            goto L54
        L44:
            r34 = false;
            goto L46
        L40:
            r33 = false;
        L33:
            r29.dispatchOnScrolled(r24, r25);
            goto L35
        L26:
            r25 = 0;
            r24 = 0;
        L80:
            SmoothScroller r41 = this.this$0.mLayout.mSmoothScroller;
            if (r41 != null) goto L83;
        L85:
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback == false) goto L88;
            internalPostOnAnimation();
            return;
        L88:
            this.this$0.setScrollState(0);
            this.this$0.stopNestedScroll(1);
            return;
        L83:
            if (r41.isPendingInitialRun() == false) goto L85;
            r41.onAnimation(0, 0);
            goto L85
        }

        public void smoothScrollBy(int r10, int r11, int r12, @Nullable Interpolator r13) {
            if (r12 != Integer.MIN_VALUE) goto L5;
            r12 = computeScrollDuration(r10, r11);
        L5:
            int r5 = r12;
            if (r13 != null) goto L9;
            r13 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.mInterpolator == r13) goto L11;
            this.mInterpolator = r13;
            this.mOverScroller = new OverScrollerAdapter(this.this$0.getContext(), r13);
        L11:
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.this$0.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, r10, r11, r5);
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
        Adapter<? extends ViewHolder> mBindingAdapter;
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

        public ViewHolder(@NonNull View r5) {
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
            if (r5 == null) goto L7;
            this.itemView = r5;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads != null) goto L6;
            ArrayList r5 = new ArrayList();
            this.mPayloads = r5;
            this.mUnmodifiedPayloads = Collections.unmodifiableList(r5);
            return;
        }

        public void addChangePayload(Object r5) {
            if (r5 != null) goto L6;
            addFlags(1024);
            return;
        L6:
            if ((1024 & this.mFlags) != 0) goto L10;
            createPayloadsIfNeeded();
            this.mPayloads.add(r5);
            return;
        }

        public void addFlags(int r5) {
            this.mFlags = r5 | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> r5 = this.mPayloads;
            if (r5 == null) goto L5;
            r5.clear();
        L5:
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.itemView) == false) goto L7;
            return true;
        }

        public void flagRemovedAndOffsetPosition(int r5, int r10, boolean r11) {
            addFlags(8);
            offsetPosition(r10, r11);
            this.mPosition = r5;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView r5 = this.mOwnerRecyclerView;
            if (r5 != null) goto L7;
            return -1;
        L7:
            return r5.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            if (this.mBindingAdapter != null) goto L5;
            return -1;
        L5:
            RecyclerView r5 = this.mOwnerRecyclerView;
            if (r5 != null) goto L8;
            return -1;
        L8:
            Adapter r10 = r5.getAdapter();
            if (r10 != null) goto L11;
            return -1;
        L11:
            int r11 = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
            if (r11 != (-1)) goto L15;
            return -1;
        L15:
            return r10.findRelativeAdapterPositionIn(this.mBindingAdapter, this, r11);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int r5 = this.mPreLayoutPosition;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            return this.mPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int r5 = this.mPreLayoutPosition;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            return this.mPosition;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) goto L14;
            List<Object> r5 = this.mPayloads;
            if (r5 == null) goto L12;
            if (r5.size() == 0) goto L12;
            return this.mUnmodifiedPayloads;
        L12:
            return FULLUPDATE_PAYLOADS;
        L14:
            return FULLUPDATE_PAYLOADS;
        }

        public boolean hasAnyOfTheFlags(int r5) {
            if ((this.mFlags & r5) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (isInvalid() == true) goto L8;
            return false;
        }

        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.itemView.getParent() == this.mOwnerRecyclerView) goto L7;
            return true;
        }

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isInvalid() {
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

        public boolean isRemoved() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isScrap() {
            if (this.mScrapContainer == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isTmpDetached() {
            if ((this.mFlags & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isUpdated() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void offsetPosition(int r5, boolean r10) {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
        L6:
            if (this.mPreLayoutPosition != (-1)) goto L8;
            this.mPreLayoutPosition = this.mPosition;
        L8:
            if (r10 == false) goto L10;
            this.mPreLayoutPosition += r5;
        L10:
            this.mPosition += r5;
            if (this.itemView.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            return;
        }

        public void onEnteredHiddenState(RecyclerView r5) {
            int r10 = this.mPendingAccessibilityState;
            if (r10 == (-1)) goto L5;
            this.mWasImportantForAccessibilityBeforeHidden = r10;
        L6:
            r5.setChildImportantForAccessibilityInternal(this, 4);
            return;
        L5:
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            goto L6
        }

        public void onLeftHiddenState(RecyclerView r5) {
            r5.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L5;
        L9:
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
            return;
        L5:
            if (isTmpDetached() == false) goto L9;
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public void saveOldPosition() {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
            return;
        }

        public void setFlags(int r5, int r10) {
            int r11 = r5 & r10;
            this.mFlags = r11 | (this.mFlags & (~r10));
        }

        public final void setIsRecyclable(boolean r5) {
            int r10 = this.mIsRecyclableCount;
            if (r5 == false) goto L5;
            int r11 = r10 - 1;
        L6:
            this.mIsRecyclableCount = r11;
            if (r11 >= 0) goto L13;
            this.mIsRecyclableCount = 0;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L12;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L20:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L23;
            Log.d(RecyclerView.TAG, "setIsRecyclable val:" + r5 + ":" + this);
            return;
        L23:
            return;
        L12:
            throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L13:
            if (r5 == true) goto L16;
            if (r11 != 1) goto L16;
            this.mFlags |= 16;
        L16:
            if (r5 == false) goto L20;
            if (r11 != 0) goto L20;
            this.mFlags &= -17;
            goto L20
        L5:
            r11 = r10 + 1;
            goto L6
        }

        public void setScrapContainer(Recycler r5, boolean r10) {
            this.mScrapContainer = r5;
            this.mInChangeScrap = r10;
        }

        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean shouldIgnore() {
            if ((this.mFlags & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r5 = "ViewHolder";
        L6:
            StringBuilder r10 = j0.w(r5, "{");
            r10.append(Integer.toHexString(hashCode()));
            r10.append(" position=");
            r10.append(this.mPosition);
            r10.append(" id=");
            r10.append(this.mItemId);
            r10.append(", oldPos=");
            r10.append(this.mOldPosition);
            r10.append(", pLpos:");
            r10.append(this.mPreLayoutPosition);
            StringBuilder r11 = new StringBuilder(r10.toString());
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
            r5 = getClass().getSimpleName();
            goto L6
        }

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{android.R.attr.nestedScrollingEnabled};
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class r5 = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, r5, r5};
        sQuinticInterpolator = new AnonymousClass3();
    }

    public RecyclerView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void access$000(RecyclerView r5, View r10, int r11, ViewGroup.LayoutParams r12) {
        r5.attachViewToParent(r10, r11, r12);
    }

    public static /* synthetic */ void access$100(RecyclerView r5, int r10) {
        r5.detachViewFromParent(r10);
    }

    public static /* synthetic */ boolean access$200(RecyclerView r5) {
        return r5.awakenScrollBars();
    }

    public static /* synthetic */ void access$300(RecyclerView r5, View r10, int r11, ViewGroup.LayoutParams r12) {
        r5.attachViewToParent(r10, r11, r12);
    }

    public static /* synthetic */ void access$400(RecyclerView r5, View r10) {
        r5.detachViewFromParent(r10);
    }

    public static /* synthetic */ void access$500(RecyclerView r5, int r10, int r11) {
        r5.setMeasuredDimension(r10, r11);
    }

    private void addAnimatingView(ViewHolder r10) {
        View r5 = r10.itemView;
        if (r5.getParent() != this) goto L5;
        boolean r11 = true;
    L6:
        this.mRecycler.unscrapView(getChildViewHolder(r5));
        if (r10.isTmpDetached() == false) goto L9;
        this.mChildHelper.attachViewToParent(r5, -1, r5.getLayoutParams(), true);
        return;
    L9:
        if (r11 == true) goto L11;
        this.mChildHelper.addView(r5, true);
        return;
    L11:
        this.mChildHelper.hide(r5);
        return;
    L5:
        r11 = false;
        goto L6
    }

    private void animateChange(@NonNull ViewHolder r5, @NonNull ViewHolder r10, @NonNull ItemAnimator.ItemHolderInfo r11, @NonNull ItemAnimator.ItemHolderInfo r12, boolean r13, boolean r14) {
        r5.setIsRecyclable(false);
        if (r13 == false) goto L5;
        addAnimatingView(r5);
    L5:
        if (r5 == r10) goto L10;
        if (r14 == false) goto L8;
        addAnimatingView(r10);
    L8:
        r5.mShadowedHolder = r10;
        addAnimatingView(r5);
        this.mRecycler.unscrapView(r5);
        r10.setIsRecyclable(false);
        r10.mShadowingHolder = r5;
    L10:
        if (this.mItemAnimator.animateChange(r5, r10, r11, r12) == false) goto L13;
        postAnimationRunner();
        return;
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder r5) {
        WeakReference<RecyclerView> r10 = r5.mNestedRecyclerView;
        if (r10 == null) goto L23;
        RecyclerView r11 = r10.get();
    L6:
        if (r11 == null) goto L14;
        if (r11 == r5.itemView) goto L9;
        Object r12 = r11.getParent();
        if ((r12 instanceof View) == true) goto L12;
        r11 = null;
        goto L6
    L12:
        r11 = (View) r12;
        goto L6
    L9:
        return;
    L14:
        r5.mNestedRecyclerView = null;
        return;
    }

    private int consumeFlingInStretch(int r5, EdgeEffectAdapter r10) {
        if (r5 == 0) goto L11;
        if (r10 != null) goto L5;
        return r5;
    L5:
        if (r10.getDistance() == 0.0f) goto L13;
        int r11 = (int) r10.onPullDistance(r5, true, this.mAvoidStateChangeInAnim);
        if (r5 <= 0) goto L10;
        return r5 - r11;
    L10:
        return r5 + r11;
    L13:
        return r5;
    L11:
        return r5;
    }

    private void createLayoutManager(Context r10, String r11, AttributeSet r12, int r13, int r14) {
        if (r11 == null) goto L42;
        String r15 = r11.trim();
        if (r15.isEmpty() == true) goto L48;
        String r16 = getFullClassName(r10, r15);
    L10:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Class is not a LayoutManager " + r16, e);
    L18:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Unable to find LayoutManager " + r16, e);
    L12:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Cannot access non-public constructor " + r16, e);
    L14:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L16:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L8:
        if (isInEditMode() == false) goto L20;
        ClassLoader r5 = getClass().getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L21:
        Class<? extends U> r17 = Class.forName(r16, false, r5).asSubclass(LayoutManager.class);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        Constructor r18 = r17.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
        Object[] r19 = {r10, r12, Integer.valueOf(r13), Integer.valueOf(r14)};     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
    L28:
        r18.setAccessible(true);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        setLayoutManager((LayoutManager) r18.newInstance(r19));     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        return;
    L25:
        e = move-exception;
        r19 = null;
        r18 = r17.getConstructor(null);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L29
    L29:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        throw new IllegalStateException(r12.getPositionDescription() + ": Error creating LayoutManager " + r16, e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L20:
        r5 = r10.getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        goto L21
    L48:
        return;
    }

    private boolean didChildRangeChange(int r5, int r10) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r11 = this.mMinMaxLayoutPositions;
        if (r11[0] != r5) goto L7;
        if (r11[1] != r10) goto L7;
        return false;
    L7:
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int r5 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r5 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r10 = AccessibilityEvent.obtain();
        r10.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(r10, r5);
        sendAccessibilityEventUnchecked(r10);
        return;
    }

    private void dispatchLayoutStep1() {
        boolean r5 = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State r10 = this.mState;
        if (r10.mRunSimpleAnimations == true) goto L5;
    L7:
        r5 = false;
    L8:
        r10.mTrackOldChangeHolders = r5;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        r10.mInPreLayout = r10.mRunPredictiveAnimations;
        r10.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations == false) goto L32;
        int r11 = this.mChildHelper.getChildCount();
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L32;
        ViewHolder r13 = getChildViewHolderInt(this.mChildHelper.getChildAt(r12));
        if (r13.shouldIgnore() == true) goto L30;
        if (r13.isInvalid() == true) goto L17;
    L19:
        this.mViewInfoStore.addToPreLayout(r13, this.mItemAnimator.recordPreLayoutInformation(this.mState, r13, ItemAnimator.buildAdapterChangeFlagsForAnimations(r13), r13.getUnmodifiedPayloads()));
        if (this.mState.mTrackOldChangeHolders == false) goto L30;
        if (r13.isUpdated() == false) goto L30;
        if (r13.isRemoved() == true) goto L30;
        if (r13.shouldIgnore() == true) goto L30;
        if (r13.isInvalid() == true) goto L30;
        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(r13), r13);
        goto L30
    L17:
        if (this.mAdapter.hasStableIds() == true) goto L19;
    L30:
        r12 = r12 + 1;
    L32:
        if (this.mState.mRunPredictiveAnimations == false) goto L50;
        saveOldPositions();
        State r14 = this.mState;
        boolean r15 = r14.mStructureChanged;
        r14.mStructureChanged = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r14);
        this.mState.mStructureChanged = r15;
        int r16 = 0;
    L35:
        if (r16 >= this.mChildHelper.getChildCount()) goto L49;
        ViewHolder r17 = getChildViewHolderInt(this.mChildHelper.getChildAt(r16));
        if (r17.shouldIgnore() == true) goto L48;
        if (this.mViewInfoStore.isInPreLayout(r17) == true) goto L48;
        int r18 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r17);
        boolean r19 = r17.hasAnyOfTheFlags(8192);
        if (r19 == true) goto L44;
        r18 = r18 | 4096;
    L44:
        ItemAnimator.ItemHolderInfo r20 = this.mItemAnimator.recordPreLayoutInformation(this.mState, r17, r18, r17.getUnmodifiedPayloads());
        if (r19 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r17, r20);
        goto L48
    L47:
        this.mViewInfoStore.addToAppearedInPreLayoutHolders(r17, r20);
    L48:
        r16 = r16 + 1;
        goto L35
    L49:
        clearOldPositions();
    L51:
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
        return;
    L50:
        clearOldPositions();
        goto L51
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
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null) goto L5;
    L10:
        State r5 = this.mState;
        r5.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r5);
        State r10 = this.mState;
        r10.mStructureChanged = false;
        if (r10.mRunSimpleAnimations == true) goto L13;
    L15:
        boolean r11 = false;
    L16:
        r10.mRunSimpleAnimations = r11;
        r10.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L13:
        if (this.mItemAnimator == null) goto L15;
        r11 = true;
        goto L16
    L5:
        if (this.mAdapter.canRestoreState() == false) goto L10;
        Parcelable r12 = this.mPendingSavedState.mLayoutState;
        if (r12 == null) goto L9;
        this.mLayout.onRestoreInstanceState(r12);
    L9:
        this.mPendingSavedState = null;
        goto L10
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State r5 = this.mState;
        r5.mLayoutStep = 1;
        if (r5.mRunSimpleAnimations == false) goto L24;
        int r10 = this.mChildHelper.getChildCount() - 1;
    L5:
        if (r10 < 0) goto L23;
        ViewHolder r11 = getChildViewHolderInt(this.mChildHelper.getChildAt(r10));
        if (r11.shouldIgnore() == true) goto L22;
        long r12 = getChangedHolderKey(r11);
        ItemAnimator.ItemHolderInfo r13 = this.mItemAnimator.recordPostLayoutInformation(this.mState, r11);
        ViewHolder r14 = this.mViewInfoStore.getFromOldChangeHolders(r12);
        if (r14 != null) goto L12;
    L21:
        this.mViewInfoStore.addToPostLayout(r11, r13);
        goto L22
    L12:
        if (r14.shouldIgnore() == true) goto L21;
        boolean r15 = this.mViewInfoStore.isDisappearing(r14);
        boolean r16 = this.mViewInfoStore.isDisappearing(r11);
        if (r15 == false) goto L17;
        if (r14 != r11) goto L17;
        this.mViewInfoStore.addToPostLayout(r11, r13);
    L17:
        ItemAnimator.ItemHolderInfo r17 = this.mViewInfoStore.popFromPreLayout(r14);
        this.mViewInfoStore.addToPostLayout(r11, r13);
        ItemAnimator.ItemHolderInfo r18 = this.mViewInfoStore.popFromPostLayout(r11);
        if (r17 != null) goto L20;
        handleMissingPreInfoForChangeError(r12, r11, r14);
        goto L22
    L20:
        animateChange(r14, r11, r17, r18, r15, r16);
    L22:
        r10 = r10 - 1;
        goto L5
    L23:
        this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State r19 = this.mState;
        r19.mPreviousLayoutItemCount = r19.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        r19.mRunSimpleAnimations = false;
        r19.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> r20 = this.mRecycler.mChangedScrap;
        if (r20 == null) goto L27;
        r20.clear();
    L27:
        LayoutManager r21 = this.mLayout;
        if (r21.mPrefetchMaxObservedInInitialPrefetch == false) goto L30;
        r21.mPrefetchMaxCountObserved = 0;
        r21.mPrefetchMaxObservedInInitialPrefetch = false;
        this.mRecycler.updateViewCacheSize();
    L30:
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] r22 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r22[0], r22[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r5) {
        OnItemTouchListener r10 = this.mInterceptingOnItemTouchListener;
        if (r10 == null) goto L5;
        r10.onTouchEvent(this, r5);
        int r11 = r5.getAction();
        if (r11 == 3) goto L13;
        if (r11 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r5.getAction() != 0) goto L9;
        return false;
    L9:
        return findInterceptingOnItemTouchListener(r5);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent r10) {
        int r5 = r10.getAction();
        int r11 = this.mOnItemTouchListeners.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        OnItemTouchListener r13 = this.mOnItemTouchListeners.get(r12);
        if (r13.onInterceptTouchEvent(this, r10) == false) goto L10;
        if (r5 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r13;
        return true;
    L10:
        r12 = r12 + 1;
        goto L3
    L11:
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] r10) {
        int r5 = this.mChildHelper.getChildCount();
        if (r5 != 0) goto L6;
        r10[0] = -1;
        r10[1] = -1;
        return;
    L6:
        int r11 = Integer.MAX_VALUE;
        int r12 = Integer.MIN_VALUE;
        int r13 = 0;
    L7:
        if (r13 >= r5) goto L17;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getChildAt(r13));
        if (r14.shouldIgnore() == true) goto L16;
        int r15 = r14.getLayoutPosition();
        if (r15 >= r11) goto L14;
        r11 = r15;
    L14:
        if (r15 <= r12) goto L16;
        r12 = r15;
    L16:
        r13 = r13 + 1;
        goto L7
    L17:
        r10[0] = r11;
        r10[1] = r12;
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View r5) {
        if ((r5 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r5 instanceof RecyclerView) == true) goto L8;
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = r10.getChildCount();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L15;
        RecyclerView r13 = findNestedRecyclerView(r10.getChildAt(r12));
        if (r13 != null) goto L13;
        r12 = r12 + 1;
        goto L10
    L13:
        return r13;
    L15:
        return null;
    L8:
        return (RecyclerView) r5;
    }

    @Nullable
    private View findNextViewToFocus() {
        State r5 = this.mState;
        int r10 = r5.mFocusedItemPosition;
        if (r10 != (-1)) goto L6;
        r10 = 0;
    L6:
        int r11 = r5.getItemCount();
        int r12 = r10;
    L7:
        if (r12 >= r11) goto L16;
        ViewHolder r13 = findViewHolderForAdapterPosition(r12);
        if (r13 == null) goto L16;
        if (r13.itemView.hasFocusable() == true) goto L14;
        r12 = r12 + 1;
        goto L7
    L14:
        return r13.itemView;
    L16:
        int r14 = Math.min(r11, r10);
    L17:
        r14 = r14 - 1;
        if (r14 < 0) goto L27;
        ViewHolder r15 = findViewHolderForAdapterPosition(r14);
        if (r15 == null) goto L21;
        if (r15.itemView.hasFocusable() == false) goto L17;
        return r15.itemView;
    L21:
        return null;
    L27:
        return null;
    }

    public static ViewHolder getChildViewHolderInt(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r5.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View r10, Rect r11) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        Rect r12 = r5.mDecorInsets;
        r11.set((r10.getLeft() - r12.left) - ((ViewGroup.MarginLayoutParams) r5).leftMargin, (r10.getTop() - r12.top) - ((ViewGroup.MarginLayoutParams) r5).topMargin, (r10.getRight() + r12.right) + ((ViewGroup.MarginLayoutParams) r5).rightMargin, (r10.getBottom() + r12.bottom) + ((ViewGroup.MarginLayoutParams) r5).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View r5) {
        int r10 = r5.getId();
    L4:
        if (r5.isFocused() == true) goto L12;
        if ((r5 instanceof ViewGroup) == false) goto L12;
        if (r5.hasFocus() == false) goto L12;
        r5 = ((ViewGroup) r5).getFocusedChild();
        if (r5.getId() == (-1)) goto L4;
        r10 = r5.getId();
    L12:
        return r10;
    }

    private String getFullClassName(Context r5, String r10) {
        if (r10.charAt(0) != '.') goto L7;
        return r5.getPackageName() + r10;
    L7:
        if (r10.contains(".") == false) goto L10;
        return r10;
    L10:
        return RecyclerView.class.getPackage().getName() + '.' + r10;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    L6:
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int r10) {
        double r5 = Math.log((Math.abs(r10) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        float r11 = DECELERATION_RATE;
        return (float) (Math.exp((r11 / (((double) r11) - 1.0d)) * r5) * (this.mPhysicalCoef * SCROLL_FRICTION));
    }

    private void handleMissingPreInfoForChangeError(long r10, ViewHolder r11, ViewHolder r12) {
        int r5 = this.mChildHelper.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L18;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getChildAt(r13));
        if (r14 == r11) goto L17;
        if (getChangedHolderKey(r14) != r10) goto L17;
        Adapter r15 = this.mAdapter;
        if (r15 != null) goto L12;
    L15:
        StringBuilder r16 = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        r16.append(r14);
        r16.append(" \n View Holder 2:");
        r16.append(r11);
        throw new IllegalStateException(a.k(this, r16));
    L12:
        if (r15.hasStableIds() == false) goto L15;
        StringBuilder r17 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
        r17.append(r14);
        r17.append(" \n View Holder 2:");
        r17.append(r11);
        throw new IllegalStateException(a.k(this, r17));
    L17:
        r13 = r13 + 1;
        goto L3
    L18:
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r12 + " cannot be found but it is necessary for " + r11 + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int r5 = this.mChildHelper.getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L14;
        ViewHolder r11 = getChildViewHolderInt(this.mChildHelper.getChildAt(r10));
        if (r11 == null) goto L13;
        if (r11.shouldIgnore() == true) goto L13;
        if (r11.isUpdated() == false) goto L13;
        return true;
    L13:
        r10 = r10 + 1;
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
        if (r11 == null) goto L89;
        if (r11 == this) goto L90;
        if (r11 != r10) goto L8;
        return false;
    L8:
        if (findContainingItemView(r11) != null) goto L11;
        return false;
    L11:
        if (r10 != null) goto L14;
        return true;
    L14:
        if (findContainingItemView(r10) != null) goto L16;
        return true;
    L16:
        this.mTempRect.set(0, 0, r10.getWidth(), r10.getHeight());
        this.mTempRect2.set(0, 0, r11.getWidth(), r11.getHeight());
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        offsetDescendantRectToMyCoords(r11, this.mTempRect2);
        byte r13 = -1;
        if (this.mLayout.getLayoutDirection() != 1) goto L19;
        int r14 = -1;
    L20:
        Rect r5 = this.mTempRect;
        int r15 = r5.left;
        Rect r16 = this.mTempRect2;
        int r17 = r16.left;
        if (r15 < r17) goto L25;
        if (r5.right <= r17) goto L25;
    L27:
        int r18 = r5.right;
        int r19 = r16.right;
        if (r18 > r19) goto L30;
        if (r15 >= r19) goto L30;
    L32:
        int r20 = 0;
    L33:
        int r21 = r5.top;
        int r22 = r16.top;
        if (r21 < r22) goto L38;
        if (r5.bottom <= r22) goto L38;
    L40:
        int r23 = r5.bottom;
        int r24 = r16.bottom;
        if (r23 > r24) goto L43;
        if (r21 >= r24) goto L43;
    L45:
        r13 = 0;
    L46:
        if (r12 != 1) goto L48;
        if (r13 < 0) goto L82;
        if (r13 == 0) goto L80;
        return false;
    L80:
        if ((r20 * r14) < 0) goto L82;
        return false;
    L82:
        return true;
    L48:
        if (r12 != 2) goto L50;
        if (r13 > 0) goto L76;
        if (r13 == 0) goto L74;
        return false;
    L74:
        if ((r20 * r14) > 0) goto L76;
        return false;
    L76:
        return true;
    L50:
        if (r12 != 17) goto L52;
        if (r20 < 0) goto L70;
        return false;
    L70:
        return true;
    L52:
        if (r12 != 33) goto L54;
        if (r13 < 0) goto L67;
        return false;
    L67:
        return true;
    L54:
        if (r12 != 66) goto L56;
        if (r20 > 0) goto L64;
        return false;
    L64:
        return true;
    L56:
        if (r12 != 130) goto L60;
        if (r13 > 0) goto L59;
        return false;
    L59:
        return true;
    L60:
        StringBuilder r110 = new StringBuilder("Invalid direction: ");
        r110.append(r12);
        throw new IllegalArgumentException(a.k(this, r110));
    L43:
        if (r21 <= r22) goto L45;
    L38:
        if (r5.bottom >= r16.bottom) goto L40;
        r13 = 1;
    L30:
        if (r15 <= r17) goto L32;
        r20 = -1;
    L25:
        if (r5.right >= r16.right) goto L27;
        r20 = 1;
        goto L33
    L19:
        r14 = 1;
        goto L20
    L90:
        return false;
    L89:
        return false;
    }

    private void nestedScrollByInternal(int r12, int r13, @Nullable MotionEvent r14, int r15) {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int[] r10 = this.mReusableIntPair;
        int r11 = 0;
        r10[0] = 0;
        r10[1] = 0;
        boolean r16 = r5.canScrollHorizontally();
        boolean r17 = this.mLayout.canScrollVertically();
        if (r17 == false) goto L12;
        int r18 = (r16 ? 1 : 0) | 2;
    L14:
        if (r14 != null) goto L16;
        float r19 = getHeight() / 2.0f;
    L17:
        if (r14 != null) goto L19;
        float r20 = getWidth() / 2.0f;
    L20:
        int r110 = r12 - releaseHorizontalGlow(r12, r19);
        int r111 = r13 - releaseVerticalGlow(r13, r20);
        startNestedScroll(r18, r15);
        if (r16 == false) goto L23;
        int r21 = r110;
    L24:
        if (r17 == false) goto L26;
        int r22 = r111;
    L28:
        if (dispatchNestedPreScroll(r21, r22, this.mReusableIntPair, this.mScrollOffset, r15) == false) goto L30;
        int[] r23 = this.mReusableIntPair;
        r110 = r110 - r23[0];
        r111 = r111 - r23[1];
    L30:
        if (r16 == false) goto L32;
        int r24 = r110;
    L33:
        if (r17 == false) goto L35;
        r11 = r111;
    L35:
        scrollByInternal(r24, r11, r14, r15);
        GapWorker r112 = this.mGapWorker;
        if (r112 == null) goto L40;
        if (r110 != 0) goto L39;
        if (r111 == 0) goto L40;
    L39:
        r112.postFromTraversal(this, r110, r111);
    L40:
        stopNestedScroll(r15);
        return;
    L32:
        r24 = 0;
        goto L33
    L26:
        r22 = 0;
        goto L28
    L23:
        r21 = 0;
        goto L24
    L19:
        r20 = r14.getX();
        goto L20
    L16:
        r19 = r14.getY();
        goto L17
    L12:
        r18 = r16 ? 1 : 0;
        goto L14
    }

    private void onPointerUp(MotionEvent r5) {
        int r10 = r5.getActionIndex();
        if (r5.getPointerId(r10) != this.mScrollPointerId) goto L9;
        if (r10 != 0) goto L6;
        int r11 = 1;
    L7:
        this.mScrollPointerId = r5.getPointerId(r11);
        int r12 = (int) (r5.getX(r11) + 0.5f);
        this.mLastTouchX = r12;
        this.mInitialTouchX = r12;
        int r13 = (int) (r5.getY(r11) + 0.5f);
        this.mLastTouchY = r13;
        this.mInitialTouchY = r13;
        return;
    L6:
        r11 = 0;
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
        boolean r5 = true;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r10 = true;
    L18:
        State r11 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L31:
        boolean r12 = false;
    L32:
        r11.mRunSimpleAnimations = r12;
        State r13 = this.mState;
        if (r13.mRunSimpleAnimations == false) goto L40;
        if (r10 == false) goto L40;
        if (this.mDataSetHasChangedAfterLayout == true) goto L40;
        if (predictiveItemAnimationsEnabled() == false) goto L40;
    L41:
        r13.mRunPredictiveAnimations = r5;
        return;
    L40:
        r5 = false;
        goto L41
    L21:
        if (this.mItemAnimator == null) goto L31;
        boolean r14 = this.mDataSetHasChangedAfterLayout;
        if (r14 == true) goto L27;
        if (r10 == true) goto L27;
        if (this.mLayout.mRequestedSimpleAnimations == false) goto L31;
    L27:
        if (r14 == true) goto L29;
    L30:
        r12 = true;
        goto L32
    L29:
        if (this.mAdapter.hasStableIds() == false) goto L31;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r10 = false;
        goto L18
    L10:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        goto L11
    }

    private void pullGlows(float r5, float r10, float r11, float r12) {
        boolean r13 = true;
        if (r10 == 0.0f) goto L5;
        ensureHorizontalGlow();
        this.mHorizontalEdgeEffect.onPullDistance(r10, false, false);
        boolean r14 = true;
    L7:
        if (r12 == 0.0f) goto L9;
        ensureVerticalGlow();
        this.mVerticalEdgeEffect.onPullDistance(r12, false, false);
    L10:
        if (r13 == true) goto L13;
        if (r10 != 0.0f) goto L13;
        if (r12 != 0.0f) goto L13;
        return;
    L13:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        r13 = r14;
        goto L10
    L5:
        r14 = false;
        goto L7
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
        View r5 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r5.getParent() == null) goto L24;
        if (r5.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.getChildCount() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.isHidden(r5) == true) goto L30;
        return;
    L30:
        View r10 = null;
        if (this.mState.mFocusedItemId != (-1)) goto L33;
    L35:
        ViewHolder r11 = null;
    L36:
        if (r11 == null) goto L44;
        if (this.mChildHelper.isHidden(r11.itemView) == true) goto L44;
        if (r11.itemView.hasFocusable() == false) goto L44;
        r10 = r11.itemView;
    L46:
        if (r10 == null) goto L60;
        int r12 = this.mState.mFocusedSubChildId;
        if (r12 == (-1)) goto L54;
        View r13 = r10.findViewById(r12);
        if (r13 == null) goto L54;
        if (r13.isFocusable() == false) goto L54;
        r10 = r13;
    L54:
        r10.requestFocus();
        return;
    L60:
        return;
    L44:
        if (this.mChildHelper.getChildCount() <= 0) goto L46;
        r10 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.hasStableIds() == false) goto L35;
        r11 = findViewHolderForItemId(this.mState.mFocusedItemId);
        goto L36
    }

    private void releaseGlows() {
        EdgeEffectAdapter r5 = this.mHorizontalEdgeEffect;
        if (r5 == null) goto L5;
        r5.onRelease();
        boolean r10 = this.mHorizontalEdgeEffect.isFinished();
    L6:
        EdgeEffectAdapter r11 = this.mVerticalEdgeEffect;
        if (r11 == null) goto L9;
        r11.onRelease();
        r10 = r10 | this.mVerticalEdgeEffect.isFinished();
    L9:
        if (r10 == false) goto L12;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        return;
    L5:
        r10 = false;
        goto L6
    }

    private int releaseHorizontalGlow(int r5, float r10) {
        EdgeEffectAdapter r11 = this.mHorizontalEdgeEffect;
        if (r11 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r11.getDistance() == 0.0f) goto L8;
        int r12 = (int) this.mHorizontalEdgeEffect.onPullDistance(r5, true, false);
        invalidate();
        return r12;
    }

    private int releaseVerticalGlow(int r5, float r10) {
        EdgeEffectAdapter r11 = this.mVerticalEdgeEffect;
        if (r11 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r11.getDistance() == 0.0f) goto L8;
        int r12 = (int) this.mVerticalEdgeEffect.onPullDistance(r5, true, false);
        invalidate();
        return r12;
    }

    private void requestChildOnScreen(@NonNull View r12, @Nullable View r13) {
        if (r13 == null) goto L4;
        View r5 = r13;
    L5:
        this.mTempRect.set(0, 0, r5.getWidth(), r5.getHeight());
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof LayoutParams) == false) goto L10;
        LayoutParams r11 = (LayoutParams) r10;
        if (r11.mInsetsDirty == true) goto L10;
        Rect r14 = r11.mDecorInsets;
        Rect r15 = this.mTempRect;
        r15.left -= r14.left;
        r15.right += r14.right;
        r15.top -= r14.top;
        r15.bottom += r14.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        offsetRectIntoDescendantCoords(r12, this.mTempRect);
    L12:
        LayoutManager r16 = this.mLayout;
        Rect r17 = this.mTempRect;
        boolean r18 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r19 = true;
    L16:
        r16.requestChildRectangleOnScreen(this, r12, r17, r18, r19);
        return;
    L15:
        r19 = false;
        goto L16
    L4:
        r5 = r12;
        goto L5
    }

    private void resetFocusInfo() {
        State r5 = this.mState;
        r5.mFocusedItemId = -1;
        r5.mFocusedItemPosition = -1;
        r5.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L5;
        r5.clear();
    L5:
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        ViewHolder r5 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r10 = null;
    L10:
        if (r10 == null) goto L13;
        r5 = findContainingViewHolder(r10);
    L13:
        if (r5 != null) goto L15;
        resetFocusInfo();
        return;
    L15:
        State r11 = this.mState;
        if (this.mAdapter.hasStableIds() == false) goto L18;
        long r12 = r5.getItemId();
    L19:
        r11.mFocusedItemId = r12;
        State r13 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r14 = -1;
    L26:
        r13.mFocusedItemPosition = r14;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(r5.itemView);
        return;
    L23:
        if (r5.isRemoved() == false) goto L25;
        r14 = r5.mOldPosition;
        goto L26
    L25:
        r14 = r5.getAbsoluteAdapterPosition();
        goto L26
    L18:
        r12 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r10 = getFocusedChild();
        goto L10
    }

    private void setAdapterInternal(@Nullable Adapter<?> r5, boolean r10, boolean r11) {
        Adapter r12 = this.mAdapter;
        if (r12 == null) goto L5;
        r12.unregisterAdapterDataObserver(this.mObserver);
        this.mAdapter.onDetachedFromRecyclerView(this);
    L5:
        if (r10 == false) goto L7;
        if (r11 == true) goto L7;
    L8:
        this.mAdapterHelper.reset();
        Adapter<?> r13 = this.mAdapter;
        this.mAdapter = r5;
        if (r5 == null) goto L11;
        r5.registerAdapterDataObserver(this.mObserver);
        r5.onAttachedToRecyclerView(this);
    L11:
        LayoutManager r14 = this.mLayout;
        if (r14 == null) goto L14;
        r14.onAdapterChanged(r13, this.mAdapter);
    L14:
        this.mRecycler.onAdapterChanged(r13, this.mAdapter, r10);
        this.mState.mStructureChanged = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    public static void setDebugAssertionsEnabled(boolean r5) {
        sDebugAssertionsEnabled = r5;
    }

    public static void setVerboseLoggingEnabled(boolean r5) {
        sVerboseLoggingEnabled = r5;
    }

    private boolean shouldAbsorb(@NonNull EdgeEffectAdapter r5, int r10) {
        return true;
    }

    private boolean stopGlowAnimations(MotionEvent r5) {
        EdgeEffectAdapter r10 = this.mHorizontalEdgeEffect;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        EdgeEffectAdapter r12 = this.mVerticalEdgeEffect;
        if (r12 == null) goto L14;
        if (r12.getDistance() == 0.0f) goto L14;
        this.mVerticalEdgeEffect.onPullDistance(0.0f, false, false);
        return true;
    L14:
        return r11;
    L5:
        if (r10.getDistance() == 0.0f) goto L7;
        r11 = true;
        goto L8
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager r5 = this.mLayout;
        if (r5 == null) goto L6;
        r5.stopSmoothScroller();
        return;
    }

    public void absorbGlows(int r5, int r10) {
        if (r5 == 0) goto L8;
        ensureHorizontalGlow();
        if (this.mHorizontalEdgeEffect.isFinished() == false) goto L6;
    L7:
        this.mHorizontalEdgeEffect.onAbsorb(r5);
        goto L8
    L6:
        if (this.mEnableOverFling == true) goto L7;
    L8:
        if (r10 == 0) goto L14;
        ensureVerticalGlow();
        if (this.mVerticalEdgeEffect.isFinished() == false) goto L12;
    L13:
        this.mVerticalEdgeEffect.onAbsorb(r10);
        goto L14
    L12:
        if (this.mEnableOverFling == true) goto L13;
    L14:
        if (r5 != 0) goto L16;
        if (r10 != 0) goto L16;
        return;
    L16:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r5, int r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 != null) goto L5;
    L6:
        super.addFocusables(r5, r10, r11);
        return;
    L5:
        if (r12.onAddFocusables(this, r5, r10, r11) == false) goto L6;
    }

    public void addItemDecoration(@NonNull ItemDecoration r5, int r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L6;
        r11.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r10 >= 0) goto L10;
        this.mItemDecorations.add(r5);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        this.mItemDecorations.add(r10, r5);
        goto L11
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r5) {
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r5);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener r5) {
        this.mOnItemTouchListeners.add(r5);
    }

    public void addOnScrollListener(@NonNull OnScrollListener r5) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r5);
    }

    public void addRecyclerListener(@NonNull RecyclerListener r5) {
        if (r5 == null) goto L4;
        boolean r10 = true;
    L5:
        Preconditions.checkArgument(r10, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(r5);
        return;
    L4:
        r10 = false;
        goto L5
    }

    public void allowClickDuringOverScroll(boolean r5) {
        this.mRecyclerViewExt.allowClickDuringOverScroll(r5);
    }

    public void animateAppearance(@NonNull ViewHolder r5, @Nullable ItemAnimator.ItemHolderInfo r10, @NonNull ItemAnimator.ItemHolderInfo r11) {
        r5.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(r5, r10, r11) == false) goto L6;
        postAnimationRunner();
        return;
    }

    public void animateDisappearance(@NonNull ViewHolder r5, @NonNull ItemAnimator.ItemHolderInfo r10, @Nullable ItemAnimator.ItemHolderInfo r11) {
        addAnimatingView(r5);
        r5.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(r5, r10, r11) == false) goto L6;
        postAnimationRunner();
        return;
    }

    public void assertInLayoutOrScroll(String r5) {
        if (isComputingLayout() == true) goto L9;
        if (r5 != null) goto L8;
        throw new IllegalStateException(a.k(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    L8:
        throw new IllegalStateException(a.k(this, j0.u(r5)));
    }

    public void assertNotInLayoutOrScroll(String r5) {
        if (isComputingLayout() == false) goto L10;
        if (r5 != null) goto L8;
        throw new IllegalStateException(a.k(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
    L8:
        throw new IllegalStateException(r5);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(a.k(this, new StringBuilder(""))));
        return;
    }

    public void avoidStateChangeInAnim() {
        this.mAvoidStateChangeInAnim = true;
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder r5) {
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.canReuseUpdatedViewHolder(r5, r5.getUnmodifiedPayloads()) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.checkLayoutParams((LayoutParams) r5) == false) goto L7;
        return true;
    }

    public void clearOldPositions() {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        ViewHolder r11 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r10));
        if (r11.shouldIgnore() == true) goto L7;
        r11.clearOldPosition();
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> r5 = this.mOnChildAttachStateListeners;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> r5 = this.mScrollListeners;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (r5.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    public int consumeFlingInHorizontalStretch(int r5) {
        return consumeFlingInStretch(r5, this.mHorizontalEdgeEffect);
    }

    public int consumeFlingInVerticalStretch(int r5) {
        return consumeFlingInStretch(r5, this.mVerticalEdgeEffect);
    }

    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L25:
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L25;
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
        TraceCompat.endSection();
        return;
    }

    public void defaultOnMeasure(int r5, int r10) {
        int r11 = getPaddingLeft();
        int r12 = LayoutManager.chooseSize(r5, getPaddingRight() + r11, ViewCompat.getMinimumWidth(this));
        int r13 = getPaddingTop();
        setMeasuredDimension(r12, LayoutManager.chooseSize(r10, getPaddingBottom() + r13, ViewCompat.getMinimumHeight(this)));
    }

    public void dispatchChildAttached(View r5) {
        ViewHolder r10 = getChildViewHolderInt(r5);
        onChildAttachedToWindow(r5);
        Adapter r11 = this.mAdapter;
        if (r11 == null) goto L6;
        if (r10 == null) goto L6;
        r11.onViewAttachedToWindow(r10);
    L6:
        List<OnChildAttachStateChangeListener> r12 = this.mOnChildAttachStateListeners;
        if (r12 == null) goto L11;
        int r13 = r12.size() - 1;
    L9:
        if (r13 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r13).onChildViewAttachedToWindow(r5);
        r13 = r13 - 1;
        goto L9
    L13:
        return;
    }

    public void dispatchChildDetached(View r5) {
        ViewHolder r10 = getChildViewHolderInt(r5);
        onChildDetachedFromWindow(r5);
        Adapter r11 = this.mAdapter;
        if (r11 == null) goto L6;
        if (r10 == null) goto L6;
        r11.onViewDetachedFromWindow(r10);
    L6:
        List<OnChildAttachStateChangeListener> r12 = this.mOnChildAttachStateListeners;
        if (r12 == null) goto L11;
        int r13 = r12.size() - 1;
    L9:
        if (r13 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r13).onChildViewDetachedFromWindow(r5);
        r13 = r13 - 1;
        goto L9
    L13:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        r5.save();
        EdgeEffectAdapter r10 = this.mHorizontalEdgeEffect;
        boolean r11 = true;
        if (r10 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        EdgeEffectAdapter r13 = this.mVerticalEdgeEffect;
        if (r13 != null) goto L11;
    L13:
        r11 = r12;
    L14:
        super.dispatchDraw(r5);
        r5.restore();
        if (r11 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L11:
        if (r13.isFinished() == true) goto L13;
        this.mVerticalEdgeEffect.computeScrollOffset();
        r5.translate(0.0f, this.mVerticalEdgeEffect.getDistance());
        goto L14
    L5:
        if (r10.isFinished() == true) goto L7;
        this.mHorizontalEdgeEffect.computeScrollOffset();
        r5.translate(this.mHorizontalEdgeEffect.getDistance(), 0.0f);
        r12 = true;
        goto L8
    }

    public void dispatchLayout() {
        if (this.mAdapter != null) goto L7;
        Log.w(TAG, "No adapter attached; skipping layout");
        return;
    L7:
        if (this.mLayout != null) goto L10;
        Log.e(TAG, "No layout manager attached; skipping layout");
        return;
    L10:
        this.mState.mIsMeasuring = false;
        if (this.mLastAutoMeasureSkippedDueToExact == true) goto L13;
    L17:
        boolean r5 = false;
    L18:
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.mLayoutStep != 1) goto L22;
        dispatchLayoutStep1();
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
    L31:
        dispatchLayoutStep3();
        return;
    L22:
        if (this.mAdapterHelper.hasUpdates() == true) goto L30;
        if (r5 == true) goto L30;
        if (this.mLayout.getWidth() != getWidth()) goto L30;
        if (this.mLayout.getHeight() != getHeight()) goto L30;
        this.mLayout.setExactMeasureSpecsFrom(this);
    L30:
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
        goto L31
    L13:
        if (this.mLastAutoMeasureNonExactMeasuredWidth == getWidth()) goto L15;
    L16:
        r5 = true;
        goto L18
    L15:
        if (this.mLastAutoMeasureNonExactMeasuredHeight == getHeight()) goto L17;
        goto L16
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        return getScrollingChildHelper().dispatchNestedFling(r5, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r5, float r10) {
        return getScrollingChildHelper().dispatchNestedPreFling(r5, r10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r5, int r10, int[] r11, int[] r12) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r5, r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14);
    }

    public void dispatchOnScrollStateChanged(int r5) {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L5;
        r10.onScrollStateChanged(r5);
    L5:
        onScrollStateChanged(r5);
        OnScrollListener r11 = this.mScrollListener;
        if (r11 == null) goto L8;
        r11.onScrollStateChanged(this, r5);
    L8:
        List<OnScrollListener> r12 = this.mScrollListeners;
        if (r12 == null) goto L13;
        int r13 = r12.size() - 1;
    L11:
        if (r13 < 0) goto L15;
        this.mScrollListeners.get(r13).onScrollStateChanged(this, r5);
        r13 = r13 - 1;
        goto L11
    L15:
        return;
    }

    public void dispatchOnScrolled(int r5, int r10) {
        this.mDispatchScrollCounter++;
        int r11 = getScrollX();
        int r12 = getScrollY();
        onScrollChanged(r11, r12, r11 - r5, r12 - r10);
        onScrolled(r5, r10);
        OnScrollListener r13 = this.mScrollListener;
        if (r13 == null) goto L5;
        r13.onScrolled(this, r5, r10);
    L5:
        List<OnScrollListener> r14 = this.mScrollListeners;
        if (r14 == null) goto L10;
        int r15 = r14.size() - 1;
    L8:
        if (r15 < 0) goto L10;
        this.mScrollListeners.get(r15).onScrolled(this, r5, r10);
        r15 = r15 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int r5 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r5 < 0) goto L13;
        ViewHolder r10 = this.mPendingAccessibilityImportanceChange.get(r5);
        if (r10.itemView.getParent() != this) goto L12;
        if (r10.shouldIgnore() == true) goto L12;
        int r11 = r10.mPendingAccessibilityState;
        if (r11 == (-1)) goto L12;
        ViewCompat.setImportantForAccessibility(r10.itemView, r11);
        r10.mPendingAccessibilityState = -1;
    L12:
        r5 = r5 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r5) {
        onPopulateAccessibilityEvent(r5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r5) {
        dispatchThawSelfOnly(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r5) {
        dispatchFreezeSelfOnly(r5);
    }

    @Override // android.view.View
    public void draw(Canvas r5) {
        super.draw(r5);
        int r10 = this.mItemDecorations.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        this.mItemDecorations.get(r11).onDrawOver(r5, this, this.mState);
        r11 = r11 + 1;
        goto L3
    L6:
        if (this.mItemAnimator != null) goto L8;
        return;
    L8:
        if (this.mItemDecorations.size() > 0) goto L10;
        return;
    L10:
        if (this.mItemAnimator.isRunning() == false) goto L16;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r5, View r10, long r11) {
        return super.drawChild(r5, r10, r11);
    }

    public void ensureHorizontalGlow() {
        if (this.mHorizontalEdgeEffect == null) goto L5;
        return;
    L5:
        EdgeEffectAdapter r5 = new EdgeEffectAdapter(getContext());
        this.mHorizontalEdgeEffect = r5;
        r5.updateViewportRange(getWidth());
    }

    public void ensureVerticalGlow() {
        if (this.mVerticalEdgeEffect == null) goto L5;
        return;
    L5:
        EdgeEffectAdapter r5 = new EdgeEffectAdapter(getContext());
        this.mVerticalEdgeEffect = r5;
        r5.updateViewportRange(getHeight());
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(State r5) {
        if (getScrollState() != 2) goto L5;
        OverScrollerAdapter r10 = this.mViewFlinger.mOverScroller;
        r5.mRemainingScrollHorizontal = r10.getFinalX() - r10.getCurrX();
        r5.mRemainingScrollVertical = r10.getFinalY() - r10.getCurrY();
        return;
    L5:
        r5.mRemainingScrollHorizontal = 0;
        r5.mRemainingScrollVertical = 0;
    }

    @Nullable
    public View findChildViewUnder(float r10, float r11) {
        int r5 = this.mChildHelper.getChildCount() - 1;
    L3:
        if (r5 < 0) goto L14;
        View r12 = this.mChildHelper.getChildAt(r5);
        float r13 = r12.getTranslationX();
        float r14 = r12.getTranslationY();
        if (r10 < (r12.getLeft() + r13)) goto L13;
        if (r10 > (r12.getRight() + r13)) goto L13;
        if (r11 < (r12.getTop() + r14)) goto L13;
        if (r11 > (r12.getBottom() + r14)) goto L13;
        return r12;
    L13:
        r5 = r5 - 1;
        goto L3
    L14:
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View r5) {
        ViewParent r10 = r5.getParent();
    L3:
        if (r10 == null) goto L8;
        if (r10 == this) goto L8;
        if ((r10 instanceof View) == false) goto L8;
        r5 = r10;
        r10 = r5.getParent();
    L8:
        if (r10 == this) goto L15;
        return null;
    L15:
        return r5;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View r5) {
        View r10 = findContainingItemView(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r10);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int r10) {
        ViewHolder r5 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r11 = this.mChildHelper.getUnfilteredChildCount();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L18;
        ViewHolder r13 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r12));
        if (r13 == null) goto L17;
        if (r13.isRemoved() == true) goto L17;
        if (getAdapterPositionInRecyclerView(r13) != r10) goto L17;
        if (this.mChildHelper.isHidden(r13.itemView) == false) goto L16;
        r5 = r13;
        goto L17
    L16:
        return r13;
    L17:
        r12 = r12 + 1;
        goto L6
    L18:
        return r5;
    }

    public ViewHolder findViewHolderForItemId(long r10) {
        Adapter r5 = this.mAdapter;
        ViewHolder r11 = null;
        if (r5 != null) goto L5;
    L20:
        return r11;
    L5:
        if (r5.hasStableIds() == false) goto L20;
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L20;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r13));
        if (r14 == null) goto L19;
        if (r14.isRemoved() == true) goto L19;
        if (r14.getItemId() != r10) goto L19;
        if (this.mChildHelper.isHidden(r14.itemView) == false) goto L18;
        r11 = r14;
        goto L19
    L18:
        return r14;
    L19:
        r13 = r13 + 1;
        goto L8
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int r5) {
        return findViewHolderForPosition(r5, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int r5) {
        return findViewHolderForPosition(r5, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int r10, int r11) {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L7;
        Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        int r12 = r5.canScrollHorizontally();
        boolean r13 = this.mLayout.canScrollVertically();
        if (r12 != 0) goto L12;
    L13:
        r10 = 0;
    L14:
        if (r13 == true) goto L16;
    L17:
        r11 = 0;
    L18:
        if (r10 != 0) goto L22;
        if (r11 != 0) goto L22;
        return false;
    L22:
        if (r10 == 0) goto L38;
        EdgeEffectAdapter r14 = this.mHorizontalEdgeEffect;
        if (r14 == null) goto L38;
        if (r14.getDistance() == 0.0f) goto L38;
        if (shouldAbsorb(this.mHorizontalEdgeEffect, r10) == false) goto L30;
        this.mHorizontalEdgeEffect.onAbsorb(r10);
        int r15 = 0;
    L32:
        if (this.mEnableOverFling == false) goto L37;
        EdgeEffectAdapter r16 = this.mHorizontalEdgeEffect;
        if (r16 != null) goto L36;
    L39:
        if (r11 == 0) goto L55;
        EdgeEffectAdapter r17 = this.mVerticalEdgeEffect;
        if (r17 == null) goto L55;
        if (r17.getDistance() == 0.0f) goto L55;
        if (shouldAbsorb(this.mVerticalEdgeEffect, r11) == false) goto L47;
        this.mVerticalEdgeEffect.onAbsorb(-r11);
        int r18 = 0;
    L49:
        if (this.mEnableOverFling == false) goto L54;
        EdgeEffectAdapter r19 = this.mVerticalEdgeEffect;
        if (r19 != null) goto L53;
    L56:
        if (r15 != 0) goto L58;
        if (r18 != 0) goto L58;
    L60:
        if (r10 != 0) goto L66;
        if (r11 != 0) goto L66;
        if (r15 != 0) goto L65;
        if (r18 != 0) goto L65;
        return false;
    L65:
        return true;
    L66:
        float r20 = r10;
        float r21 = r11;
        if (dispatchNestedPreFling(r20, r21) == true) goto L83;
        if (r12 != 0) goto L72;
        if (r13 == true) goto L72;
        boolean r22 = false;
    L73:
        dispatchNestedFling(r20, r21, r22);
        OnFlingListener r23 = this.mOnFlingListener;
        if (r23 != null) goto L76;
    L78:
        if (r22 == false) goto L83;
        if (r13 == false) goto L81;
        r12 = (r12 == true ? 1 : 0) | 2;
    L81:
        startNestedScroll(r12, 1);
        int r24 = this.mMaxFlingVelocity;
        int r25 = Math.max(-r24, Math.min(r10, r24));
        int r26 = this.mMaxFlingVelocity;
        this.mViewFlinger.fling(r25, Math.max(-r26, Math.min(r11, r26)));
        return true;
    L76:
        if (r23.onFling(r10, r11) == false) goto L78;
        return true;
    L72:
        r22 = true;
    L83:
        return false;
    L58:
        int r27 = this.mMaxFlingVelocity;
        r15 = Math.max(-r27, Math.min(r15, r27));
        int r28 = this.mMaxFlingVelocity;
        r18 = Math.max(-r28, Math.min(r18, r28));
        this.mViewFlinger.fling(r15, r18);
        goto L60
    L53:
        if ((r19.getDistance() * r11) >= 0.0f) goto L56;
    L54:
        r11 = 0;
        goto L56
    L47:
        r18 = r11;
    L55:
        r18 = 0;
        goto L56
    L36:
        if ((r16.getDistance() * r10) >= 0.0f) goto L39;
    L37:
        r10 = 0;
        goto L39
    L30:
        r15 = r10;
    L38:
        r15 = 0;
        goto L39
    L16:
        if (Math.abs(r11) >= this.mMinFlingVelocity) goto L18;
    L12:
        if (Math.abs(r10) >= this.mMinFlingVelocity) goto L14;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r10, int r11) {
        View r5 = this.mLayout.onInterceptFocusSearch(r10, r11);
        if (r5 == null) goto L5;
        return r5;
    L5:
        boolean r12 = true;
        if (this.mAdapter != null) goto L8;
    L14:
        boolean r13 = false;
    L15:
        FocusFinder r14 = FocusFinder.getInstance();
        if (r13 == true) goto L18;
    L61:
        View r15 = r14.findNextFocus(this, r10, r11);
        if (r15 != null) goto L68;
        if (r13 == false) goto L68;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L67;
        return null;
    L67:
        startInterceptRequestLayout();
        View r16 = this.mLayout.onFocusSearchFailed(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L69:
        if (r16 == null) goto L79;
        if (r16.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        requestChildOnScreen(r16, null);
        return r10;
    L75:
        return super.focusSearch(r10, r11);
    L79:
        if (isPreferredNextFocus(r10, r16, r11) == false) goto L82;
        return r16;
    L82:
        return super.focusSearch(r10, r11);
    L68:
        r16 = r15;
        goto L69
    L18:
        if (r11 == 2) goto L21;
        if (r11 != 1) goto L61;
    L21:
        if (this.mLayout.canScrollVertically() == false) goto L32;
        if (r11 != 2) goto L24;
        int r17 = 130;
    L26:
        if (r14.findNextFocus(this, r10, r17) != null) goto L28;
        boolean r18 = true;
    L30:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L33;
        r11 = r17;
    L33:
        if (r18 == false) goto L35;
    L55:
        if (r18 == false) goto L60;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L59;
        return null;
    L59:
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r16 = r14.findNextFocus(this, r10, r11);
        goto L69
    L35:
        if (this.mLayout.canScrollHorizontally() == false) goto L55;
        if (this.mLayout.getLayoutDirection() != 1) goto L39;
        boolean r19 = true;
    L40:
        if (r11 != 2) goto L42;
        boolean r20 = true;
    L44:
        if ((r19 ^ r20) == false) goto L46;
        int r21 = 66;
    L48:
        if (r14.findNextFocus(this, r10, r21) == null) goto L52;
        r12 = false;
    L52:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L54;
        r11 = r21;
    L54:
        r18 = r12;
        goto L55
    L46:
        r21 = 17;
        goto L48
    L42:
        r20 = false;
        goto L44
    L39:
        r19 = false;
        goto L40
    L28:
        r18 = false;
        goto L30
    L24:
        r17 = 33;
        goto L26
    L32:
        r18 = false;
        goto L33
    L8:
        if (this.mLayout == null) goto L14;
        if (isComputingLayout() == true) goto L14;
        if (this.mLayoutSuppressed == true) goto L14;
        r13 = true;
        goto L15
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager r5 = this.mLayout;
        if (r5 == null) goto L7;
        return r5.generateDefaultLayoutParams();
    L7:
        throw new IllegalStateException(a.k(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.generateLayoutParams(getContext(), r5);
    L7:
        throw new IllegalStateException(a.k(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.fluidrecyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ViewHolder r5) {
        if (r5.hasAnyOfTheFlags(524) == false) goto L5;
        return -1;
    L5:
        if (r5.isBound() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.applyPendingUpdatesToPosition(r5.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager r5 = this.mLayout;
        if (r5 == null) goto L7;
        return r5.getBaseline();
    L7:
        return super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder r5) {
        if (this.mAdapter.hasStableIds() == false) goto L6;
        return r5.getItemId();
    L6:
        return r5.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View r5) {
        ViewHolder r10 = getChildViewHolderInt(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getAbsoluteAdapterPosition();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r5, int r10) {
        ChildDrawingOrderCallback r11 = this.mChildDrawingOrderCallback;
        if (r11 != null) goto L7;
        return super.getChildDrawingOrder(r5, r10);
    L7:
        return r11.onGetChildDrawingOrder(r5, r10);
    }

    public long getChildItemId(@NonNull View r5) {
        Adapter r10 = this.mAdapter;
        if (r10 != null) goto L5;
        return -1;
    L5:
        if (r10.hasStableIds() == false) goto L13;
        ViewHolder r11 = getChildViewHolderInt(r5);
        if (r11 != null) goto L10;
        return -1;
    L10:
        return r11.getItemId();
    L13:
        return -1;
    }

    public int getChildLayoutPosition(@NonNull View r5) {
        ViewHolder r10 = getChildViewHolderInt(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getLayoutPosition();
    }

    @Deprecated
    public int getChildPosition(@NonNull View r5) {
        return getChildAdapterPosition(r5);
    }

    public ViewHolder getChildViewHolder(@NonNull View r5) {
        ViewParent r10 = r5.getParent();
        if (r10 == null) goto L9;
        if (r10 == this) goto L9;
        throw new IllegalArgumentException("View " + r5 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r5);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View r5, @NonNull Rect r10) {
        getDecoratedBoundsWithMarginsInt(r5, r10);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return null;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View r10) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        if (r5.mInsetsDirty == true) goto L7;
        return r5.mDecorInsets;
    L7:
        if (this.mState.isPreLayout() == true) goto L9;
    L14:
        Rect r11 = r5.mDecorInsets;
        r11.set(0, 0, 0, 0);
        int r12 = this.mItemDecorations.size();
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        this.mItemDecorations.get(r13).getItemOffsets(this.mTempRect, r10, this, this.mState);
        int r14 = r11.left;
        Rect r15 = this.mTempRect;
        r11.left = r14 + r15.left;
        r11.top += r15.top;
        r11.right += r15.right;
        r11.bottom += r15.bottom;
        r13 = r13 + 1;
        goto L15
    L17:
        r5.mInsetsDirty = false;
        return r11;
    L9:
        if (r5.isItemChanged() == true) goto L13;
        if (r5.isViewInvalid() == false) goto L14;
    L13:
        return r5.mDecorInsets;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int r5) {
        int r10 = getItemDecorationCount();
        if (r5 < 0) goto L8;
        if (r5 >= r10) goto L8;
        return this.mItemDecorations.get(r5);
    L8:
        throw new IndexOutOfBoundsException(r5 + " is an invalid index for size " + r10);
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

    public long getNanoTime() {
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

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L10;
        return false;
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AnonymousClass6(this));
    }

    @VisibleForTesting
    public void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r5 = getContext().getResources();
        new FastScroller(this, r11, r12, r13, r14, r5.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), r5.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), r5.getDimensionPixelOffset(R.dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException(a.k(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
    }

    public void invalidateGlows() {
        this.mVerticalEdgeEffect = null;
        this.mHorizontalEdgeEffect = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        LayoutManager r5 = this.mLayout;
        if (r5 == null) goto L8;
        r5.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager r5 = this.mAccessibilityManager;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isEnabled() == false) goto L7;
        return true;
    }

    public boolean isAnimating() {
        ItemAnimator r5 = this.mItemAnimator;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isRunning() == false) goto L7;
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

    public boolean isOverScrolling() {
        EdgeEffectAdapter r5 = this.mVerticalEdgeEffect;
        if (r5 != null) goto L5;
    L9:
        boolean r10 = false;
    L10:
        EdgeEffectAdapter r11 = this.mHorizontalEdgeEffect;
        if (r11 != null) goto L13;
    L17:
        boolean r12 = false;
    L18:
        if (r10 == true) goto L21;
        if (r12 == true) goto L21;
        return false;
    L21:
        return true;
    L13:
        if (r11.getDistance() == 0.0f) goto L15;
    L16:
        r12 = true;
        goto L18
    L15:
        if (this.mHorizontalEdgeEffect.isFinished() == true) goto L17;
    L5:
        if (r5.getDistance() == 0.0f) goto L7;
    L8:
        r10 = true;
        goto L10
    L7:
        if (this.mVerticalEdgeEffect.isFinished() == true) goto L9;
        goto L8
    }

    public void jumpToPositionForSmoothScroller(int r5) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.scrollToPosition(r5);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(r10).getLayoutParams()).mInsetsDirty = true;
        r10 = r10 + 1;
        goto L3
    L5:
        this.mRecycler.markItemDecorInsetsDirty();
    }

    public void markKnownViewsInvalid() {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L10;
        ViewHolder r11 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r10));
        if (r11 == null) goto L9;
        if (r11.shouldIgnore() == true) goto L9;
        r11.addFlags(6);
    L9:
        r10 = r10 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void nestedScrollBy(int r5, int r10) {
        nestedScrollByInternal(r5, r10, null, 1);
    }

    public void offsetChildrenHorizontal(@Px int r5) {
        int r10 = this.mChildHelper.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mChildHelper.getChildAt(r11).offsetLeftAndRight(r5);
        r11 = r11 + 1;
        goto L3
    }

    public void offsetChildrenVertical(@Px int r5) {
        int r10 = this.mChildHelper.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mChildHelper.getChildAt(r11).offsetTopAndBottom(r5);
        r11 = r11 + 1;
        goto L3
    }

    public void offsetPositionRecordsForInsert(int r10, int r11) {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L15;
        ViewHolder r13 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r12));
        if (r13 == null) goto L14;
        if (r13.shouldIgnore() == true) goto L14;
        if (r13.mPosition < r10) goto L14;
        if (sVerboseLoggingEnabled == false) goto L13;
        Log.d(TAG, "offsetPositionRecordsForInsert attached child " + r12 + " holder " + r13 + " now at position " + (r13.mPosition + r11));
    L13:
        r13.offsetPosition(r11, false);
        this.mState.mStructureChanged = true;
    L14:
        r12 = r12 + 1;
        goto L3
    L15:
        this.mRecycler.offsetPositionRecordsForInsert(r10, r11);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int r11, int r12) {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        if (r11 >= r12) goto L5;
        int r10 = -1;
        int r13 = r11;
        int r14 = r12;
    L6:
        int r15 = 0;
    L7:
        if (r15 >= r5) goto L23;
        ViewHolder r16 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r15));
        if (r16 == null) goto L22;
        int r17 = r16.mPosition;
        if (r17 < r13) goto L22;
        if (r17 > r14) goto L22;
        if (sVerboseLoggingEnabled == false) goto L18;
        Log.d(TAG, "offsetPositionRecordsForMove attached child " + r15 + " holder " + r16);
    L18:
        if (r16.mPosition != r11) goto L20;
        r16.offsetPosition(r12 - r11, false);
    L21:
        this.mState.mStructureChanged = true;
        goto L22
    L20:
        r16.offsetPosition(r10, false);
    L22:
        r15 = r15 + 1;
        goto L7
    L23:
        this.mRecycler.offsetPositionRecordsForMove(r11, r12);
        requestLayout();
        return;
    L5:
        r14 = r11;
        r13 = r12;
        r10 = 1;
        goto L6
    }

    public void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
        int r5 = r10 + r11;
        int r13 = this.mChildHelper.getUnfilteredChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L20;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r14));
        if (r15 == null) goto L19;
        if (r15.shouldIgnore() == true) goto L19;
        int r16 = r15.mPosition;
        if (r16 >= r5) goto L11;
        if (r16 < r10) goto L19;
        if (sVerboseLoggingEnabled == false) goto L18;
        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + r14 + " holder " + r15 + " now REMOVED");
    L18:
        r15.flagRemovedAndOffsetPosition(r10 - 1, -r11, r12);
        this.mState.mStructureChanged = true;
        goto L19
    L11:
        if (sVerboseLoggingEnabled == false) goto L13;
        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + r14 + " holder " + r15 + " now at position " + (r15.mPosition - r11));
    L13:
        r15.offsetPosition(-r11, r12);
        this.mState.mStructureChanged = true;
    L19:
        r14 = r14 + 1;
        goto L3
    L20:
        this.mRecycler.offsetPositionRecordsForRemove(r10, r11, r12);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r5 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r5 = false;
    L8:
        this.mFirstLayoutComplete = r5;
        this.mRecycler.onAttachedToWindow();
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L11;
        r10.dispatchAttachedToWindow(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L25;
        ThreadLocal<GapWorker> r11 = GapWorker.sGapWorker;
        GapWorker r12 = r11.get();
        this.mGapWorker = r12;
        if (r12 != null) goto L23;
        this.mGapWorker = new GapWorker();
        Display r13 = ViewCompat.getDisplay(this);
        if (isInEditMode() == true) goto L21;
        if (r13 == null) goto L21;
        float r14 = r13.getRefreshRate();
        if (r14 < 30.0f) goto L21;
    L22:
        GapWorker r15 = this.mGapWorker;
        r15.mFrameIntervalNs = (long) (1.0E9f / r14);
        r11.set(r15);
    L21:
        r14 = 60.0f;
    L23:
        this.mGapWorker.add(this);
        return;
    L25:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    public void onChildAttachedToWindow(@NonNull View r5) {
    }

    public void onChildDetachedFromWindow(@NonNull View r5) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r5 = this.mItemAnimator;
        if (r5 == null) goto L5;
        r5.endAnimations();
    L5:
        stopScroll();
        this.mIsAttached = false;
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L8;
        r10.dispatchDetachedFromWindow(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        this.mRecycler.onDetachedFromWindow();
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        GapWorker r11 = this.mGapWorker;
        if (r11 == null) goto L15;
        r11.remove(this);
        this.mGapWorker = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        int r10 = this.mItemDecorations.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mItemDecorations.get(r11).onDraw(r5, this, this.mState);
        r11 = r11 + 1;
        goto L3
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
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
        float r5 = -r10.getAxisValue(9);
    L17:
        if (this.mLayout.canScrollHorizontally() == false) goto L19;
        float r11 = r10.getAxisValue(10);
    L30:
        if (r5 == 0.0f) goto L32;
    L33:
        nestedScrollByInternal((int) (r11 * this.mScaledHorizontalScrollFactor), (int) (r5 * this.mScaledVerticalScrollFactor), r10, 1);
        goto L34
    L32:
        if (r11 == 0.0f) goto L34;
    L19:
        r11 = 0.0f;
        goto L30
    L15:
        r5 = 0.0f;
        goto L17
    L21:
        if ((r10.getSource() & 4194304) == 0) goto L28;
        float r12 = r10.getAxisValue(26);
        if (this.mLayout.canScrollVertically() == false) goto L26;
        r5 = -r12;
        goto L19
    L26:
        if (this.mLayout.canScrollHorizontally() == false) goto L28;
        r11 = r12;
        r5 = 0.0f;
    L28:
        r5 = 0.0f;
        r11 = 0.0f;
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
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L12;
        return false;
    L12:
        boolean r11 = r5.canScrollHorizontally();
        boolean r12 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = VelocityTrackerFactory.create(getContext());
    L15:
        this.mVelocityTracker.addMovement(r10);
        int r13 = r10.getActionMasked();
        int r14 = r10.getActionIndex();
        if (r13 == 0) goto L50;
        if (r13 == 1) goto L47;
        if (r13 != 2) goto L20;
        int r15 = r10.findPointerIndex(this.mScrollPointerId);
        if (r15 >= 0) goto L33;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r16 = (int) (r10.getX(r15) + 0.5f);
        int r17 = (int) (r10.getY(r15) + 0.5f);
        if (this.mScrollState == 1) goto L48;
        int r18 = r16 - this.mInitialTouchX;
        int r19 = r17 - this.mInitialTouchY;
        if (r11 == true) goto L38;
    L40:
        boolean r20 = false;
    L41:
        if (r12 == true) goto L43;
    L45:
        if (r20 == false) goto L48;
        setScrollState(1);
        goto L48
    L43:
        if (Math.abs(r19) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r17;
        r20 = true;
        goto L45
    L38:
        if (Math.abs(r18) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r16;
        r20 = true;
    L48:
        boolean r21 = false;
    L63:
        if (r21 == false) goto L65;
        return false;
    L65:
        if (this.mScrollState == 1) goto L67;
        return false;
    L67:
        return true;
    L20:
        if (r13 != 3) goto L22;
        cancelScroll();
        goto L48
    L22:
        if (r13 != 5) goto L24;
        this.mScrollPointerId = r10.getPointerId(r14);
        int r22 = (int) (r10.getX(r14) + 0.5f);
        this.mLastTouchX = r22;
        this.mInitialTouchX = r22;
        int r23 = (int) (r10.getY(r14) + 0.5f);
        this.mLastTouchY = r23;
        this.mInitialTouchY = r23;
        goto L48
    L24:
        if (r13 != 6) goto L48;
        onPointerUp(r10);
        goto L48
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L48
    L50:
        if (this.mIgnoreMotionEventTillDown == false) goto L52;
        this.mIgnoreMotionEventTillDown = false;
    L52:
        this.mScrollPointerId = r10.getPointerId(0);
        int r24 = (int) (r10.getX() + 0.5f);
        this.mLastTouchX = r24;
        this.mInitialTouchX = r24;
        int r25 = (int) (r10.getY() + 0.5f);
        this.mLastTouchY = r25;
        this.mInitialTouchY = r25;
        r21 = this.mRecyclerViewExt.isDisallowInterceptTouchEvent(r10, false);
        if (r21 == false) goto L55;
    L59:
        int[] r26 = this.mNestedOffsets;
        r26[1] = 0;
        r26[0] = 0;
        int r27 = r11;
        if (r12 == false) goto L62;
        r27 = (r11 ? 1 : 0) | 2;
    L62:
        startNestedScroll(r27, 0);
        goto L63
    L55:
        if (stopGlowAnimations(r10) == false) goto L57;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
        goto L59
    L57:
        if (this.mScrollState != 2) goto L59;
        goto L58
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L6;
        defaultOnMeasure(r10, r11);
        return;
    L6:
        boolean r12 = false;
        if (r5.isAutoMeasureEnabled() == false) goto L26;
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        if (r13 != 1073741824) goto L12;
        if (r14 != 1073741824) goto L12;
        r12 = true;
    L12:
        this.mLastAutoMeasureSkippedDueToExact = r12;
        if (r12 == false) goto L15;
        return;
    L15:
        if (this.mAdapter != null) goto L18;
        return;
    L18:
        if (this.mState.mLayoutStep != 1) goto L20;
        dispatchLayoutStep1();
    L20:
        this.mLayout.setMeasureSpecs(r10, r11);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r10, r11);
        if (this.mLayout.shouldMeasureTwice() == false) goto L23;
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY));
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r10, r11);
    L23:
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
        return;
    L26:
        if (this.mHasFixedSize == false) goto L30;
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        return;
    L30:
        if (this.mAdapterUpdateDuringMeasure == false) goto L37;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        State r15 = this.mState;
        if (r15.mRunPredictiveAnimations == false) goto L34;
        r15.mInPreLayout = true;
    L35:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L40:
        Adapter r16 = this.mAdapter;
        if (r16 == null) goto L43;
        this.mState.mItemCount = r16.getItemCount();
    L44:
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
        return;
    L43:
        this.mState.mItemCount = 0;
        goto L44
    L34:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mInPreLayout = false;
        goto L35
    L37:
        if (this.mState.mRunPredictiveAnimations == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r5, Rect r10) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r5, r10);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        this.mPendingSavedState = r10;
        super.onRestoreInstanceState(r10.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        SavedState r10 = this.mPendingSavedState;
        if (r10 == null) goto L5;
        r5.copyFrom(r10);
    L9:
        return r5;
    L5:
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L8;
        r5.mLayoutState = r11.onSaveInstanceState();
        goto L9
    L8:
        r5.mLayoutState = null;
        goto L9
    }

    public void onScrollStateChanged(int r5) {
    }

    public void onScrolled(@Px int r5, @Px int r10) {
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (r5 != r11) goto L5;
        if (r10 != r12) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        if (this.mLayoutSuppressed == false) goto L5;
    L106:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L106;
        if (dispatchToOnItemTouchListeners(r18) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        LayoutManager r5 = this.mLayout;
        if (r5 != null) goto L14;
        return false;
    L14:
        boolean r10 = r5.canScrollHorizontally();
        boolean r11 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = VelocityTrackerFactory.create(getContext());
    L17:
        int r12 = r18.getActionMasked();
        int r13 = r18.getActionIndex();
        if (r12 != 0) goto L20;
        int[] r14 = this.mNestedOffsets;
        r14[1] = 0;
        r14[0] = 0;
    L20:
        MotionEvent r15 = MotionEvent.obtain(r18);
        int[] r16 = this.mNestedOffsets;
        r15.offsetLocation(r16[0], r16[1]);
        if (r12 != 0) goto L23;
        this.mScrollPointerId = r18.getPointerId(0);
        int r17 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r17;
        this.mInitialTouchX = r17;
        int r19 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r19;
        this.mInitialTouchY = r19;
        int r110 = r10;
        if (r11 == false) goto L102;
        r110 = (r10 ? 1 : 0) | 2;
    L102:
        startNestedScroll(r110, 0);
    L103:
        this.mVelocityTracker.addMovement(r15);
    L104:
        r15.recycle();
        return true;
    L23:
        if (r12 != 1) goto L25;
        this.mVelocityTracker.addMovement(r15);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r10 == false) goto L87;
        float r20 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L88:
        if (r11 == false) goto L90;
        float r21 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L91:
        Log.d(TAG, "TouchUp, Velocity: x: " + r20 + ", y: " + r21);
        if (r20 != 0.0f) goto L96;
        if (r21 != 0.0f) goto L96;
    L97:
        Log.d(TAG, "No fling, setting scroll state to idle");
        setScrollState(0);
    L98:
        resetScroll();
    L96:
        if (fling((int) r20, (int) r21) == true) goto L98;
    L90:
        r21 = 0.0f;
        goto L91
    L87:
        r20 = 0.0f;
        goto L88
    L25:
        if (r12 != 2) goto L27;
        int r22 = r18.findPointerIndex(this.mScrollPointerId);
        if (r22 >= 0) goto L40;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L40:
        int r111 = (int) (r18.getX(r22) + 0.5f);
        int r112 = (int) (r18.getY(r22) + 0.5f);
        int r23 = this.mLastTouchX - r111;
        int r24 = this.mLastTouchY - r112;
        if (this.mScrollState == 1) goto L58;
        if (r10 == false) goto L48;
        if (r23 <= 0) goto L45;
        r23 = Math.max(0, r23 - this.mTouchSlop);
    L46:
        if (r23 == 0) goto L48;
        boolean r25 = true;
    L49:
        if (r11 == false) goto L55;
        if (r24 <= 0) goto L52;
        r24 = Math.max(0, r24 - this.mTouchSlop);
    L53:
        if (r24 == 0) goto L55;
        r25 = true;
        goto L55
    L52:
        r24 = Math.min(0, r24 + this.mTouchSlop);
    L55:
        if (r25 == false) goto L58;
        setScrollState(1);
        goto L58
    L45:
        r23 = Math.min(0, r23 + this.mTouchSlop);
    L48:
        r25 = false;
    L58:
        if (this.mScrollState != 1) goto L103;
        int[] r26 = this.mReusableIntPair;
        r26[0] = 0;
        r26[1] = 0;
        int r113 = r23 - releaseHorizontalGlow(r23, r18.getY());
        int r114 = r24 - releaseVerticalGlow(r24, r18.getX());
        if (r10 == false) goto L62;
        int r27 = r113;
    L63:
        if (r11 == false) goto L65;
        int r28 = r114;
    L67:
        if (dispatchNestedPreScroll(r27, r28, this.mReusableIntPair, this.mScrollOffset, 0) == false) goto L69;
        int[] r29 = this.mReusableIntPair;
        r113 = r113 - r29[0];
        r114 = r114 - r29[1];
        int[] r30 = this.mNestedOffsets;
        int r31 = r30[0];
        int[] r32 = this.mScrollOffset;
        r30[0] = r31 + r32[0];
        r30[1] = r30[1] + r32[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L69:
        int r33 = r114;
        int[] r34 = this.mScrollOffset;
        this.mLastTouchX = r111 - r34[0];
        this.mLastTouchY = r112 - r34[1];
        if (r10 == false) goto L72;
        int r35 = r113;
    L73:
        if (r11 == false) goto L75;
        int r36 = r33;
    L77:
        if (scrollByInternal(r35, r36, r18, 0) == false) goto L79;
        getParent().requestDisallowInterceptTouchEvent(true);
    L79:
        GapWorker r37 = this.mGapWorker;
        if (r37 == null) goto L103;
        if (r113 != 0) goto L83;
        if (r33 == 0) goto L103;
    L83:
        r37.postFromTraversal(this, r113, r33);
        goto L103
    L75:
        r36 = 0;
        goto L77
    L72:
        r35 = 0;
        goto L73
    L65:
        r28 = 0;
        goto L67
    L62:
        r27 = 0;
        goto L63
    L27:
        if (r12 != 3) goto L29;
        cancelScroll();
        goto L103
    L29:
        if (r12 != 5) goto L31;
        this.mScrollPointerId = r18.getPointerId(r13);
        int r38 = (int) (r18.getX(r13) + 0.5f);
        this.mLastTouchX = r38;
        this.mInitialTouchX = r38;
        int r39 = (int) (r18.getY(r13) + 0.5f);
        this.mLastTouchY = r39;
        this.mInitialTouchY = r39;
        goto L103
    L31:
        if (r12 != 6) goto L103;
        onPointerUp(r18);
        goto L103
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
        return;
    }

    public void processDataSetCompletelyChanged(boolean r5) {
        this.mDispatchItemsChangedEvent = r5 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder r5, ItemAnimator.ItemHolderInfo r10) {
        r5.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders == true) goto L5;
    L11:
        this.mViewInfoStore.addToPreLayout(r5, r10);
        return;
    L5:
        if (r5.isUpdated() == false) goto L11;
        if (r5.isRemoved() == true) goto L11;
        if (r5.shouldIgnore() == true) goto L11;
        long r11 = getChangedHolderKey(r5);
        this.mViewInfoStore.addToOldChangeHolders(r11, r5);
        goto L11
    }

    public void removeAndRecycleViews() {
        ItemAnimator r5 = this.mItemAnimator;
        if (r5 == null) goto L5;
        r5.endAnimations();
    L5:
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L8;
        r10.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    L8:
        this.mRecycler.clear();
    }

    public boolean removeAnimatingView(View r5) {
        startInterceptRequestLayout();
        boolean r10 = this.mChildHelper.removeViewIfHidden(r5);
        if (r10 == false) goto L7;
        ViewHolder r11 = getChildViewHolderInt(r5);
        this.mRecycler.unscrapView(r11);
        this.mRecycler.recycleViewHolderInternal(r11);
        if (sVerboseLoggingEnabled == false) goto L7;
        Log.d(TAG, "after removing animated view: " + r5 + ", " + this);
    L7:
        stopInterceptRequestLayout(!r10);
        return r10;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r5, boolean r10) {
        ViewHolder r11 = getChildViewHolderInt(r5);
        if (r11 == null) goto L13;
        if (r11.isTmpDetached() == false) goto L8;
        r11.clearTmpDetachFlag();
    L14:
        r5.clearAnimation();
        dispatchChildDetached(r5);
        super.removeDetachedView(r5, r10);
        return;
    L8:
        if (r11.shouldIgnore() == true) goto L14;
        StringBuilder r12 = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
        r12.append(r11);
        throw new IllegalArgumentException(a.k(this, r12));
    L13:
        if (sDebugAssertionsEnabled == false) goto L14;
        StringBuilder r13 = new StringBuilder("No ViewHolder found for child: ");
        r13.append(r5);
        throw new IllegalArgumentException(a.k(this, r13));
    }

    public void removeItemDecoration(@NonNull ItemDecoration r5) {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L5;
        r10.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r5);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r11 = true;
    L11:
        setWillNotDraw(r11);
        goto L12
    L10:
        r11 = false;
        goto L11
    }

    public void removeItemDecorationAt(int r5) {
        int r10 = getItemDecorationCount();
        if (r5 < 0) goto L8;
        if (r5 >= r10) goto L8;
        removeItemDecoration(getItemDecorationAt(r5));
        return;
    L8:
        throw new IndexOutOfBoundsException(r5 + " is an invalid index for size " + r10);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r5) {
        List<OnChildAttachStateChangeListener> r10 = this.mOnChildAttachStateListeners;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.remove(r5);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener r5) {
        this.mOnItemTouchListeners.remove(r5);
        if (this.mInterceptingOnItemTouchListener != r5) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    public void removeOnScrollListener(@NonNull OnScrollListener r5) {
        List<OnScrollListener> r10 = this.mScrollListeners;
        if (r10 == null) goto L6;
        r10.remove(r5);
        return;
    }

    public void removeRecyclerListener(@NonNull RecyclerListener r5) {
        this.mRecyclerListeners.remove(r5);
    }

    public void repositionShadowingViews() {
        int r5 = this.mChildHelper.getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L14;
        View r11 = this.mChildHelper.getChildAt(r10);
        ViewHolder r12 = getChildViewHolder(r11);
        if (r12 == null) goto L13;
        ViewHolder r13 = r12.mShadowingHolder;
        if (r13 == null) goto L13;
        View r14 = r13.itemView;
        int r15 = r11.getLeft();
        int r16 = r11.getTop();
        if (r15 == r14.getLeft()) goto L11;
    L12:
        r14.layout(r15, r16, r14.getWidth() + r15, r14.getHeight() + r16);
        goto L13
    L11:
        if (r16 != r14.getTop()) goto L12;
    L13:
        r10 = r10 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r5, View r10) {
        if (this.mLayout.onRequestChildFocus(this, this.mState, r5, r10) == true) goto L6;
        if (r10 == null) goto L6;
        requestChildOnScreen(r5, r10);
    L6:
        super.requestChildFocus(r5, r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r5, Rect r10, boolean r11) {
        return this.mLayout.requestChildRectangleOnScreen(this, r5, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r5) {
        int r10 = this.mOnItemTouchListeners.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mOnItemTouchListeners.get(r11).onRequestDisallowInterceptTouchEvent(r5);
        r11 = r11 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r5);
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

    public void saveOldPositions() {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L17;
        ViewHolder r11 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r10));
        if (sDebugAssertionsEnabled == false) goto L14;
        if (r11.mPosition != (-1)) goto L14;
        if (r11.isRemoved() == true) goto L14;
        throw new IllegalStateException(a.k(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
    L14:
        if (r11.shouldIgnore() == true) goto L16;
        r11.saveOldPosition();
    L16:
        r10 = r10 + 1;
        goto L3
    }

    @Override // android.view.View
    public void scrollBy(int r5, int r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r12 = r11.canScrollHorizontally();
        boolean r13 = this.mLayout.canScrollVertically();
        if (r12 == true) goto L13;
        if (r13 == true) goto L13;
        return;
    L13:
        if (r12 == true) goto L16;
        r5 = 0;
    L16:
        if (r13 == true) goto L19;
        r10 = 0;
    L19:
        scrollByInternal(r5, r10, null, 0);
    }

    public boolean scrollByInternal(int r17, int r18, MotionEvent r19, int r20) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r5 = this.mReusableIntPair;
        r5[0] = 0;
        r5[1] = 0;
        scrollStep(r17, r18, r5);
        int[] r10 = this.mReusableIntPair;
        int r11 = r10[0];
        int r12 = r10[1];
        int r13 = r17 - r11;
        int r14 = r18 - r12;
        int r15 = r12;
        int r16 = r11;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r21 = this.mReusableIntPair;
        r21[0] = 0;
        r21[1] = 0;
        dispatchNestedScroll(r16, r15, r13, r14, this.mScrollOffset, r20, r21);
        int[] r22 = this.mReusableIntPair;
        int r23 = r22[0];
        int r110 = r13 - r23;
        int r24 = r22[1];
        int r111 = r14 - r24;
        if (r23 != 0) goto L14;
        if (r24 != 0) goto L14;
        boolean r25 = false;
    L15:
        int r26 = this.mLastTouchX;
        int[] r27 = this.mScrollOffset;
        int r28 = r27[0];
        this.mLastTouchX = r26 - r28;
        int r29 = this.mLastTouchY;
        int r30 = r27[1];
        this.mLastTouchY = r29 - r30;
        int[] r31 = this.mNestedOffsets;
        r31[0] = r31[0] + r28;
        r31[1] = r31[1] + r30;
        if (getOverScrollMode() == 2) goto L21;
        if (r19 == null) goto L21;
        if (MotionEventCompat.isFromSource(r19, 8194) == true) goto L21;
        pullGlows(r19.getX(), r110, r19.getY(), r111);
    L21:
        if (r16 != 0) goto L23;
        if (r15 != 0) goto L23;
    L25:
        if (awakenScrollBars() == true) goto L27;
        invalidate();
    L27:
        if (r25 == true) goto L33;
        if (r16 != 0) goto L34;
        if (r15 == 0) goto L32;
        return true;
    L32:
        return false;
    L34:
        return true;
    L33:
        return true;
    L23:
        dispatchOnScrolled(r16, r15);
    L14:
        r25 = true;
        goto L15
    L5:
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r16 = 0;
        goto L7
    }

    public void scrollStep(int r5, int r10, @Nullable int[] r11) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r5 == 0) goto L5;
        int r12 = this.mLayout.scrollHorizontallyBy(r5, this.mRecycler, this.mState);
    L6:
        if (r10 == 0) goto L8;
        int r13 = this.mLayout.scrollVerticallyBy(r10, this.mRecycler, this.mState);
    L9:
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r11 == null) goto L13;
        r11[0] = r12;
        r11[1] = r13;
        return;
    L13:
        return;
    L8:
        r13 = 0;
        goto L9
    L5:
        r12 = 0;
        goto L6
    }

    @Override // android.view.View
    public void scrollTo(int r5, int r10) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int r5) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L9;
        Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r10.scrollToPosition(r5);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r5) {
        if (shouldDeferAccessibilityEvent(r5) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r5);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate r5) {
        this.mAccessibilityDelegate = r5;
        ViewCompat.setAccessibilityDelegate(this, r5);
    }

    public void setAdapter(@Nullable Adapter r5) {
        setLayoutFrozen(false);
        setAdapterInternal(r5, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback r5) {
        if (r5 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r5;
        if (r5 == null) goto L8;
        boolean r10 = true;
    L9:
        setChildrenDrawingOrderEnabled(r10);
        return;
    L8:
        r10 = false;
        goto L9
    }

    @VisibleForTesting
    public boolean setChildImportantForAccessibilityInternal(ViewHolder r5, int r10) {
        if (isComputingLayout() == false) goto L6;
        r5.mPendingAccessibilityState = r10;
        this.mPendingAccessibilityImportanceChange.add(r5);
        return false;
    L6:
        ViewCompat.setImportantForAccessibility(r5.itemView, r10);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r5) {
        if (r5 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r5;
        super.setClipToPadding(r5);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory r5) {
    }

    public void setEnableOverFling(boolean r5) {
        this.mEnableOverFling = r5;
    }

    public void setHasFixedSize(boolean r5) {
        this.mHasFixedSize = r5;
    }

    public void setItemAnimator(@Nullable ItemAnimator r5) {
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 == null) goto L5;
        r10.endAnimations();
        this.mItemAnimator.setListener(null);
    L5:
        this.mItemAnimator = r5;
        if (r5 == null) goto L9;
        r5.setListener(this.mItemAnimatorListener);
        return;
    }

    public void setItemViewCacheSize(int r5) {
        this.mRecycler.setViewCacheSize(r5);
    }

    @Deprecated
    public void setLayoutFrozen(boolean r5) {
        suppressLayout(r5);
    }

    public void setLayoutManager(@Nullable LayoutManager r5) {
        if (r5 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 == null) goto L10;
        r10.endAnimations();
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
        this.mLayout = r5;
        if (r5 != null) goto L18;
    L24:
        this.mRecycler.updateViewCacheSize();
        requestLayout();
        return;
    L18:
        if (r5.mRecyclerView != null) goto L22;
        r5.setRecyclerView(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.dispatchAttachedToWindow(this);
        goto L24
    L22:
        StringBuilder r11 = new StringBuilder("LayoutManager ");
        r11.append(r5);
        r11.append(" is already attached to a RecyclerView:");
        throw new IllegalArgumentException(a.k(r5.mRecyclerView, r11));
    L14:
        this.mRecycler.clear();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r5) {
        if (r5 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setMinFlingVelocity(int r5) {
        this.mMinFlingVelocity = r5;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r5) {
        getScrollingChildHelper().setNestedScrollingEnabled(r5);
    }

    public void setOnFlingListener(@Nullable OnFlingListener r5) {
        this.mOnFlingListener = r5;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener r5) {
        this.mScrollListener = r5;
    }

    public void setPreserveFocusAfterLayout(boolean r5) {
        this.mPreserveFocusAfterLayout = r5;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool r5) {
        this.mRecycler.setRecycledViewPool(r5);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener r5) {
        this.mRecyclerListener = r5;
    }

    public void setScrollState(int r5) {
        if (r5 != this.mScrollState) goto L6;
        return;
    L6:
        if (sVerboseLoggingEnabled == false) goto L8;
        StringBuilder r10 = j0.s(r5, "setting scroll state to ", " from ");
        r10.append(this.mScrollState);
        Log.d(TAG, r10.toString(), new Exception());
    L8:
        this.mScrollState = r5;
        if (r5 == 2) goto L11;
        stopScrollersInternal();
    L11:
        dispatchOnScrollStateChanged(r5);
    }

    public void setScrollingTouchSlop(int r5) {
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        if (r5 != 0) goto L5;
    L8:
        this.mTouchSlop = r10.getScaledTouchSlop();
        return;
    L5:
        if (r5 == 1) goto L7;
        Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + r5 + "; using default value");
        goto L8
    L7:
        this.mTouchSlop = r10.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension r5) {
        this.mRecycler.setViewCacheExtension(r5);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent r5) {
        int r10 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r5 == null) goto L6;
        int r11 = AccessibilityEventCompat.getContentChangeTypes(r5);
    L7:
        if (r11 == 0) goto L10;
        r10 = r11;
    L10:
        this.mEatenAccessibilityChangeFlags |= r10;
        return true;
    L6:
        r11 = 0;
        goto L7
    L12:
        return false;
    }

    public void smoothScrollBy(@Px int r5, @Px int r10) {
        smoothScrollBy(r5, r10, null);
    }

    public void smoothScrollToPosition(int r5) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L9;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r10.smoothScrollToPosition(this, this.mState, r5);
    }

    public void startInterceptRequestLayout() {
        int r5 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r5;
        if (r5 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r5) {
        return getScrollingChildHelper().startNestedScroll(r5);
    }

    public void stopInterceptRequestLayout(boolean r5) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L10;
        if (sDebugAssertionsEnabled == true) goto L8;
        this.mInterceptRequestLayoutDepth = 1;
        goto L10
    L8:
        throw new IllegalStateException(a.k(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
    L10:
        if (r5 == true) goto L15;
        if (this.mLayoutSuppressed == true) goto L15;
        this.mLayoutWasDefered = false;
    L15:
        if (this.mInterceptRequestLayoutDepth != 1) goto L29;
        if (r5 == false) goto L27;
        if (this.mLayoutWasDefered == false) goto L27;
        if (this.mLayoutSuppressed == true) goto L27;
        if (this.mLayout == null) goto L27;
        if (this.mAdapter == null) goto L27;
        dispatchLayout();
    L27:
        if (this.mLayoutSuppressed == true) goto L29;
        this.mLayoutWasDefered = false;
    L29:
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
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
        long r5 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r5, r5, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    public void swapAdapter(@Nullable Adapter r5, boolean r10) {
        setLayoutFrozen(false);
        setAdapterInternal(r5, true, r10);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int r10, int r11, Object r12) {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        int r13 = r10 + r11;
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L14;
        View r15 = this.mChildHelper.getUnfilteredChildAt(r14);
        ViewHolder r16 = getChildViewHolderInt(r15);
        if (r16 == null) goto L13;
        if (r16.shouldIgnore() == true) goto L13;
        int r17 = r16.mPosition;
        if (r17 < r10) goto L13;
        if (r17 >= r13) goto L13;
        r16.addFlags(2);
        r16.addChangePayload(r12);
        ((LayoutParams) r15.getLayoutParams()).mInsetsDirty = true;
    L13:
        r14 = r14 + 1;
        goto L3
    L14:
        this.mRecycler.viewRangeUpdate(r10, r11);
    }

    public RecyclerView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Nullable
    public ViewHolder findViewHolderForPosition(int r10, boolean r11) {
        int r5 = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L20;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r13));
        if (r14 == null) goto L19;
        if (r14.isRemoved() == true) goto L19;
        if (r11 == false) goto L13;
        if (r14.mPosition != r10) goto L19;
    L16:
        if (this.mChildHelper.isHidden(r14.itemView) == false) goto L18;
        r12 = r14;
        goto L19
    L18:
        return r14;
    L13:
        if (r14.getLayoutPosition() == r10) goto L16;
    L19:
        r13 = r13 + 1;
        goto L3
    L20:
        return r12;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r5) {
        return getScrollingChildHelper().hasNestedScrollingParent(r5);
    }

    public void onExitLayoutOrScroll(boolean r5) {
        int r10 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r10;
        if (r10 < 1) goto L5;
        return;
    L5:
        if (sDebugAssertionsEnabled == false) goto L10;
        if (r10 >= 0) goto L10;
        throw new IllegalStateException(a.k(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
    L10:
        this.mLayoutOrScrollCounter = 0;
        if (r5 == false) goto L15;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    }

    public void smoothScrollBy(@Px int r5, @Px int r10, @Nullable Interpolator r11) {
        smoothScrollBy(r5, r10, r11, Integer.MIN_VALUE);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r5, int r10) {
        return getScrollingChildHelper().startNestedScroll(r5, r10);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r5) {
        getScrollingChildHelper().stopNestedScroll(r5);
    }

    public RecyclerView(@NonNull Context r16, @Nullable AttributeSet r17, int r18) {
        super(r16, r17, r18);
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new AnonymousClass1(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        GapWorker.LayoutPrefetchRegistryImpl r5 = new GapWorker.LayoutPrefetchRegistryImpl();
    L6:
        this.mPrefetchRegistry = r5;
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
        this.mEnableOverFling = true;
        this.mAvoidStateChangeInAnim = true;
        this.mItemAnimatorRunner = new AnonymousClass2(this);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new AnonymousClass4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r10 = ViewConfiguration.get(r16);
        this.mTouchSlop = r10.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r10, r16);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(r10, r16);
        this.mMinFlingVelocity = r10.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r10.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = ((r16.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        if (getOverScrollMode() != 2) goto L9;
        boolean r11 = true;
    L10:
        setWillNotDraw(r11);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray r14 = r16.obtainStyledAttributes(r17, R.styleable.RecyclerView, r18, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r16, R.styleable.RecyclerView, r17, r14, r18, 0);
        String r12 = r14.getString(R.styleable.RecyclerView_layoutManager);
        if (r14.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) != (-1)) goto L16;
        setDescendantFocusability(262144);
    L16:
        this.mClipToPadding = r14.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean r13 = r14.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = r13;
        if (r13 == false) goto L19;
        initFastScroller((StateListDrawable) r14.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), r14.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) r14.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), r14.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    L19:
        r14.recycle();
        createLayoutManager(r16, r12, r17, r18, 0);
        int[] r15 = NESTED_SCROLLING_ATTRS;
        TypedArray r19 = r16.obtainStyledAttributes(r17, r15, r18, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r16, r15, r17, r19, r18, 0);
        boolean r20 = r19.getBoolean(0, true);
        r19.recycle();
        setNestedScrollingEnabled(r20);
        PoolingContainer.setPoolingContainer(this, true);
        this.mRecyclerViewExt = new RecyclerViewExt(this);
        return;
    L9:
        r11 = false;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15, @NonNull int[] r16) {
        getScrollingChildHelper().dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }

    public void smoothScrollBy(@Px int r10, @Px int r11, @Nullable Interpolator r12, int r13) {
        smoothScrollBy(r10, r11, r12, r13, false);
    }

    public void smoothScrollBy(@Px int r5, @Px int r10, @Nullable Interpolator r11, int r12, boolean r13) {
        LayoutManager r14 = this.mLayout;
        if (r14 != null) goto L7;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r15 = 0;
        if (r14.canScrollHorizontally() == true) goto L13;
        r5 = 0;
    L13:
        if (this.mLayout.canScrollVertically() == true) goto L15;
        r10 = 0;
    L15:
        if (r5 != 0) goto L18;
        if (r10 != 0) goto L18;
        return;
    L18:
        if (r12 == Integer.MIN_VALUE) goto L22;
        if (r12 > 0) goto L22;
        scrollBy(r5, r10);
        return;
    L22:
        if (r13 == true) goto L24;
    L29:
        this.mViewFlinger.smoothScrollBy(r5, r10, r12, r11);
        return;
    L24:
        if (r5 == 0) goto L26;
        r15 = 1;
    L26:
        if (r10 == 0) goto L28;
        r15 = r15 | 2;
    L28:
        startNestedScroll(r15, 1);
        goto L29
    }

    public void addItemDecoration(@NonNull ItemDecoration r5) {
        addItemDecoration(r5, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.generateLayoutParams(r5);
    L7:
        throw new IllegalStateException(a.k(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
