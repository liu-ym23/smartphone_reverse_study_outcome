package androidx.viewpager2.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    private RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private FakeDrag mFakeDragger;
    private LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private PageTransformerAdapter mPageTransformerAdapter;
    private PagerSnapHelper mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    RecyclerView mRecyclerView;
    private RecyclerView.ItemAnimator mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    public abstract class AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        private AccessibilityProvider(ViewPager2 r5) {
            this.this$0 = r5;
        }

        public boolean handlesGetAccessibilityClassName() {
            return false;
        }

        public boolean handlesLmPerformAccessibilityAction(int r5) {
            return false;
        }

        public boolean handlesPerformAccessibilityAction(int r5, Bundle r10) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onAttachAdapter(@Nullable RecyclerView.Adapter<?> r5) {
        }

        public void onDetachAdapter(@Nullable RecyclerView.Adapter<?> r5) {
        }

        public String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public void onInitialize(@NonNull CompositeOnPageChangeCallback r5, @NonNull RecyclerView r10) {
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        }

        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat r5) {
        }

        public boolean onLmPerformAccessibilityAction(int r5) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean onPerformAccessibilityAction(int r5, Bundle r10) {
            throw new IllegalStateException("Not implemented.");
        }

        public void onRestorePendingState() {
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent r5) {
        }

        public void onSetLayoutDirection() {
        }

        public void onSetNewCurrentItem() {
        }

        public void onSetOrientation() {
        }

        public void onSetUserInputEnabled() {
        }

        public /* synthetic */ AccessibilityProvider(ViewPager2 r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public class BasicAccessibilityProvider extends AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        public BasicAccessibilityProvider(ViewPager2 r5) {
            this.this$0 = r5;
            super(r5, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int r5) {
            if (r5 == 8192) goto L7;
            if (r5 == 4096) goto L7;
        L9:
            return false;
        L7:
            if (this.this$0.isUserInputEnabled() == true) goto L9;
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat r5) {
            if (this.this$0.isUserInputEnabled() == true) goto L6;
            r5.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r5.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r5.setScrollable(false);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int r5) {
            if (handlesLmPerformAccessibilityAction(r5) == false) goto L7;
            return false;
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r5, int r10) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r5, int r10) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r5, int r10, int r11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r5, int r10) {
            onChanged();
        }

        public /* synthetic */ DataSetChangeObserver(AnonymousClass1 r5) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r5, int r10, @Nullable Object r11) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        final /* synthetic */ ViewPager2 this$0;

        public LinearLayoutManagerImpl(ViewPager2 r5, Context r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State r5, @NonNull int[] r10) {
            int r11 = this.this$0.getOffscreenPageLimit();
            if (r11 != (-1)) goto L6;
            super.calculateExtraLayoutSpace(r5, r10);
            return;
        L6:
            int r12 = this.this$0.getPageSize() * r11;
            r10[0] = r12;
            r10[1] = r12;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler r5, @NonNull RecyclerView.State r10, @NonNull AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r5, r10, r11);
            this.this$0.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler r5, @NonNull RecyclerView.State r10, int r11, @Nullable Bundle r12) {
            if (this.this$0.mAccessibilityProvider.handlesLmPerformAccessibilityAction(r11) == false) goto L7;
            return this.this$0.mAccessibilityProvider.onLmPerformAccessibilityAction(r11);
        L7:
            return super.performAccessibilityAction(r5, r10, r11, r12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r5, @NonNull View r10, @NonNull Rect r11, boolean r12, boolean r13) {
            return false;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public OnPageChangeCallback() {
        }

        public void onPageScrollStateChanged(int r5) {
        }

        public void onPageScrolled(int r5, float r10, @Px int r11) {
        }

        public void onPageSelected(int r5) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public class PageAwareAccessibilityProvider extends AccessibilityProvider {
        private final AccessibilityViewCommand mActionPageBackward;
        private final AccessibilityViewCommand mActionPageForward;
        private RecyclerView.AdapterDataObserver mAdapterDataObserver;
        final /* synthetic */ ViewPager2 this$0;

        public PageAwareAccessibilityProvider(ViewPager2 r5) {
            this.this$0 = r5;
            super(r5, null);
            this.mActionPageForward = new AnonymousClass1(this);
            this.mActionPageBackward = new AnonymousClass2(this);
        }

        private void addCollectionInfo(AccessibilityNodeInfo r5) {
            if (this.this$0.getAdapter() != null) goto L5;
            int r10 = 0;
            int r11 = 0;
        L9:
            AccessibilityNodeInfoCompat.wrap(r5).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r10, r11, false, 0));
            return;
        L5:
            if (this.this$0.getOrientation() != 1) goto L7;
            r10 = this.this$0.getAdapter().getItemCount();
            r11 = 0;
            goto L9
        L7:
            r11 = this.this$0.getAdapter().getItemCount();
            r10 = 0;
            goto L9
        }

        private void addScrollActions(AccessibilityNodeInfo r5) {
            RecyclerView.Adapter r10 = this.this$0.getAdapter();
            if (r10 != null) goto L5;
            return;
        L5:
            int r11 = r10.getItemCount();
            if (r11 != 0) goto L8;
            return;
        L8:
            if (this.this$0.isUserInputEnabled() == true) goto L11;
            return;
        L11:
            if (this.this$0.mCurrentItem <= 0) goto L14;
            r5.addAction(8192);
        L14:
            if (this.this$0.mCurrentItem >= (r11 - 1)) goto L16;
            r5.addAction(4096);
        L16:
            r5.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesPerformAccessibilityAction(int r5, Bundle r10) {
            if (r5 != 8192) goto L5;
        L8:
            return true;
        L5:
            if (r5 == 4096) goto L8;
            return false;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onAttachAdapter(@Nullable RecyclerView.Adapter<?> r5) {
            updatePageAccessibilityActions();
            if (r5 == null) goto L6;
            r5.registerAdapterDataObserver(this.mAdapterDataObserver);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onDetachAdapter(@Nullable RecyclerView.Adapter<?> r5) {
            if (r5 == null) goto L5;
            r5.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public String onGetAccessibilityClassName() {
            if (handlesGetAccessibilityClassName() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitialize(@NonNull CompositeOnPageChangeCallback r5, @NonNull RecyclerView r10) {
            ViewCompat.setImportantForAccessibility(r10, 2);
            this.mAdapterDataObserver = new AnonymousClass3(this);
            if (ViewCompat.getImportantForAccessibility(this.this$0) != 0) goto L6;
            ViewCompat.setImportantForAccessibility(this.this$0, 1);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
            addCollectionInfo(r5);
            addScrollActions(r5);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onPerformAccessibilityAction(int r5, Bundle r10) {
            if (handlesPerformAccessibilityAction(r5, r10) == false) goto L11;
            if (r5 != 8192) goto L7;
            int r11 = this.this$0.getCurrentItem() - 1;
        L8:
            setCurrentItemFromAccessibilityCommand(r11);
            return true;
        L7:
            r11 = this.this$0.getCurrentItem() + 1;
            goto L8
        L11:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent r5) {
            r5.setSource(this.this$0);
            r5.setClassName(onGetAccessibilityClassName());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetLayoutDirection() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetNewCurrentItem() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetOrientation() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetUserInputEnabled() {
            updatePageAccessibilityActions();
        }

        public void setCurrentItemFromAccessibilityCommand(int r5) {
            if (this.this$0.isUserInputEnabled() == false) goto L6;
            this.this$0.setCurrentItemInternal(r5, true);
            return;
        }

        public void updatePageAccessibilityActions() {
            ViewPager2 r5 = this.this$0;
            int r10 = R.id.accessibilityActionPageLeft;
            ViewCompat.removeAccessibilityAction(r5, R.id.accessibilityActionPageLeft);
            ViewCompat.removeAccessibilityAction(r5, R.id.accessibilityActionPageRight);
            ViewCompat.removeAccessibilityAction(r5, R.id.accessibilityActionPageUp);
            ViewCompat.removeAccessibilityAction(r5, R.id.accessibilityActionPageDown);
            if (this.this$0.getAdapter() != null) goto L5;
            return;
        L5:
            int r11 = this.this$0.getAdapter().getItemCount();
            if (r11 != 0) goto L9;
            return;
        L9:
            if (this.this$0.isUserInputEnabled() == true) goto L12;
            return;
        L12:
            if (this.this$0.getOrientation() != 0) goto L26;
            boolean r12 = this.this$0.isRtl();
            if (r12 == false) goto L16;
            int r13 = 16908360;
        L17:
            if (r12 == false) goto L20;
            r10 = 16908361;
        L20:
            if (this.this$0.mCurrentItem >= (r11 - 1)) goto L23;
            ViewCompat.replaceAccessibilityAction(r5, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r13, null), null, this.mActionPageForward);
        L23:
            if (this.this$0.mCurrentItem <= 0) goto L32;
            ViewCompat.replaceAccessibilityAction(r5, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r10, null), null, this.mActionPageBackward);
            return;
        L32:
            return;
        L16:
            r13 = 16908361;
            goto L17
        L26:
            if (this.this$0.mCurrentItem >= (r11 - 1)) goto L29;
            ViewCompat.replaceAccessibilityAction(r5, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, null), null, this.mActionPageForward);
        L29:
            if (this.this$0.mCurrentItem <= 0) goto L34;
            ViewCompat.replaceAccessibilityAction(r5, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, null), null, this.mActionPageBackward);
            return;
        }
    }

    public interface PageTransformer {
        void transformPage(@NonNull View r5, float r10);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        final /* synthetic */ ViewPager2 this$0;

        public PagerSnapHelperImpl(ViewPager2 r5) {
            this.this$0 = r5;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager r5) {
            if (this.this$0.isFakeDragging() == false) goto L6;
            return null;
        L6:
            return super.findSnapView(r5);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        final /* synthetic */ ViewPager2 this$0;

        public RecyclerViewImpl(@NonNull ViewPager2 r5, Context r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            if (this.this$0.mAccessibilityProvider.handlesRvGetAccessibilityClassName() == false) goto L7;
            return this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName();
        L7:
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r5) {
            super.onInitializeAccessibilityEvent(r5);
            r5.setFromIndex(this.this$0.mCurrentItem);
            r5.setToIndex(this.this$0.mCurrentItem);
            this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(r5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r5) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r5) == false) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent r5) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r5) == false) goto L7;
            return true;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        static {
            CREATOR = new AnonymousClass1();
        }

        @RequiresApi(24)
        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            readValues(r5, r10);
        }

        private void readValues(Parcel r5, ClassLoader r10) {
            this.mRecyclerViewId = r5.readInt();
            this.mCurrentItem = r5.readInt();
            this.mAdapterState = r5.readParcelable(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.mRecyclerViewId);
            r5.writeInt(this.mCurrentItem);
            r5.writeParcelable(this.mAdapterState, r10);
        }

        public SavedState(Parcel r5) {
            super(r5);
            readValues(r5, null);
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int r5, RecyclerView r10) {
            this.mPosition = r5;
            this.mRecyclerView = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    public ViewPager2(@NonNull Context r5) {
        super(r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r5, null);
    }

    private RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener() {
        return new AnonymousClass4(this);
    }

    private void initialize(Context r5, AttributeSet r10) {
        if (sFeatureEnhancedA11yEnabled == false) goto L5;
        AccessibilityProvider r11 = new PageAwareAccessibilityProvider(this);
    L6:
        this.mAccessibilityProvider = r11;
        RecyclerViewImpl r12 = new RecyclerViewImpl(this, r5);
        this.mRecyclerView = r12;
        r12.setId(ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl r13 = new LinearLayoutManagerImpl(this, r5);
        this.mLayoutManager = r13;
        this.mRecyclerView.setLayoutManager(r13);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(r5, r10);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        ScrollEventAdapter r14 = new ScrollEventAdapter(this);
        this.mScrollEventAdapter = r14;
        this.mFakeDragger = new FakeDrag(this, r14, this.mRecyclerView);
        PagerSnapHelperImpl r15 = new PagerSnapHelperImpl(this);
        this.mPagerSnapHelper = r15;
        r15.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback r16 = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = r16;
        this.mScrollEventAdapter.setOnPageChangeCallback(r16);
        OnPageChangeCallback r17 = new AnonymousClass2(this);
        OnPageChangeCallback r18 = new AnonymousClass3(this);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r17);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r18);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter r19 = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = r19;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r19);
        RecyclerView r20 = this.mRecyclerView;
        attachViewToParent(r20, 0, r20.getLayoutParams());
        return;
    L5:
        r11 = new BasicAccessibilityProvider(this);
        goto L6
    }

    private void registerCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> r5) {
        if (r5 == null) goto L5;
        r5.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restorePendingState() {
        if (this.mPendingCurrentItem != (-1)) goto L5;
        return;
    L5:
        RecyclerView.Adapter r5 = getAdapter();
        if (r5 != 0) goto L8;
        return;
    L8:
        Parcelable r10 = this.mPendingAdapterState;
        if (r10 != null) goto L11;
    L14:
        int r11 = Math.max(0, Math.min(this.mPendingCurrentItem, r5.getItemCount() - 1));
        this.mCurrentItem = r11;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(r11);
        this.mAccessibilityProvider.onRestorePendingState();
        return;
    L11:
        if ((r5 instanceof StatefulAdapter) == false) goto L13;
        ((StatefulAdapter) r5).restoreState(r10);
    L13:
        this.mPendingAdapterState = null;
        goto L14
    }

    private void setOrientation(Context r10, AttributeSet r11) {
        TypedArray r5 = r10.obtainStyledAttributes(r11, androidx.viewpager2.R.styleable.ViewPager2);
        saveAttributeDataForStyleable(r10, androidx.viewpager2.R.styleable.ViewPager2, r11, r5, 0, 0);
        setOrientation(r5.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));     // Catch: Throwable -> L6
        r5.recycle();
        return;
    L6:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    private void unregisterCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> r5) {
        if (r5 == null) goto L5;
        r5.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration r5) {
        this.mRecyclerView.addItemDecoration(r5);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        return this.mRecyclerView.canScrollHorizontally(r5);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r5) {
        return this.mRecyclerView.canScrollVertically(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r5) {
        Parcelable r10 = r5.get(getId());
        if ((r10 instanceof SavedState) == false) goto L5;
        int r11 = ((SavedState) r10).mRecyclerViewId;
        r5.put(this.mRecyclerView.getId(), r5.get(r11));
        r5.remove(r11);
    L5:
        super.dispatchRestoreInstanceState(r5);
        restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float r5) {
        return this.mFakeDragger.fakeDragBy(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.handlesGetAccessibilityClassName() == false) goto L7;
        return this.mAccessibilityProvider.onGetAccessibilityClassName();
    L7:
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int r5) {
        return this.mRecyclerView.getItemDecorationAt(r5);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    public int getPageSize() {
        RecyclerView r5 = this.mRecyclerView;
        if (getOrientation() != 0) goto L6;
        int r10 = r5.getWidth() - r5.getPaddingLeft();
        int r11 = r5.getPaddingRight();
    L7:
        return r10 - r11;
    L6:
        r10 = r5.getHeight() - r5.getPaddingTop();
        r11 = r5.getPaddingBottom();
        goto L7
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    public boolean isRtl() {
        if (this.mLayoutManager.getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = this.mRecyclerView.getMeasuredWidth();
        int r15 = this.mRecyclerView.getMeasuredHeight();
        Rect r16 = this.mTmpContainerRect;
        r16.left = getPaddingLeft();
        Rect r17 = this.mTmpContainerRect;
        r17.right = (r12 - r10) - getPaddingRight();
        Rect r18 = this.mTmpContainerRect;
        r18.top = getPaddingTop();
        Rect r19 = this.mTmpContainerRect;
        r19.bottom = (r13 - r11) - getPaddingBottom();
        Gravity.apply(8388659, r14, r15, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView r20 = this.mRecyclerView;
        Rect r21 = this.mTmpChildRect;
        r20.layout(r21.left, r21.top, r21.right, r21.bottom);
        if (this.mCurrentItemDirty == false) goto L6;
        updateCurrentItem();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        measureChild(this.mRecyclerView, r10, r11);
        int r5 = this.mRecyclerView.getMeasuredWidth();
        int r12 = this.mRecyclerView.getMeasuredHeight();
        int r13 = this.mRecyclerView.getMeasuredState();
        int r14 = getPaddingLeft();
        int r15 = (getPaddingRight() + r14) + r5;
        int r16 = getPaddingTop();
        int r17 = (getPaddingBottom() + r16) + r12;
        int r18 = Math.max(r15, getSuggestedMinimumWidth());
        int r19 = Math.max(r17, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(r18, r10, r13), View.resolveSizeAndState(r19, r11, r13 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        this.mPendingCurrentItem = r10.mCurrentItem;
        this.mPendingAdapterState = r10.mAdapterState;
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.mRecyclerViewId = this.mRecyclerView.getId();
        int r10 = this.mPendingCurrentItem;
        if (r10 != (-1)) goto L5;
        r10 = this.mCurrentItem;
    L5:
        r5.mCurrentItem = r10;
        Parcelable r11 = this.mPendingAdapterState;
        if (r11 == null) goto L8;
        r5.mAdapterState = r11;
    L11:
        return r5;
    L8:
        Object r12 = this.mRecyclerView.getAdapter();
        if ((r12 instanceof StatefulAdapter) == false) goto L11;
        r5.mAdapterState = ((StatefulAdapter) r12).saveState();
        goto L11
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r5) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int r5, Bundle r10) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(r5, r10) == false) goto L7;
        return this.mAccessibilityProvider.onPerformAccessibilityAction(r5, r10);
    L7:
        return super.performAccessibilityAction(r5, r10);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback r5) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(r5);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration r5) {
        this.mRecyclerView.removeItemDecoration(r5);
    }

    public void removeItemDecorationAt(int r5) {
        this.mRecyclerView.removeItemDecorationAt(r5);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() != null) goto L5;
        return;
    L5:
        double r5 = this.mScrollEventAdapter.getRelativeScrollPosition();
        int r10 = (int) r5;
        float r11 = (float) (r5 - ((double) r10));
        this.mPageTransformerAdapter.onPageScrolled(r10, r11, Math.round(getPageSize() * r11));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter r5) {
        RecyclerView.Adapter r10 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(r10);
        unregisterCurrentItemDataSetTracker(r10);
        this.mRecyclerView.setAdapter(r5);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(r5);
        registerCurrentItemDataSetTracker(r5);
    }

    public void setCurrentItem(int r5) {
        setCurrentItem(r5, true);
    }

    public void setCurrentItemInternal(int r10, boolean r11) {
        RecyclerView.Adapter r5 = getAdapter();
        if (r5 != null) goto L9;
        if (this.mPendingCurrentItem == (-1)) goto L36;
        this.mPendingCurrentItem = Math.max(r10, 0);
        return;
    L36:
        return;
    L9:
        if (r5.getItemCount() > 0) goto L11;
        return;
    L11:
        int r12 = Math.min(Math.max(r10, 0), r5.getItemCount() - 1);
        if (r12 == this.mCurrentItem) goto L14;
    L16:
        int r13 = this.mCurrentItem;
        if (r12 != r13) goto L20;
        if (r11 == false) goto L20;
        return;
    L20:
        double r14 = r13;
        this.mCurrentItem = r12;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (this.mScrollEventAdapter.isIdle() == true) goto L23;
        r14 = this.mScrollEventAdapter.getRelativeScrollPosition();
    L23:
        this.mScrollEventAdapter.notifyProgrammaticScroll(r12, r11);
        if (r11 == true) goto L27;
        this.mRecyclerView.scrollToPosition(r12);
        return;
    L27:
        double r15 = r12;
        if (Math.abs(r15 - r14) <= 3.0d) goto L34;
        RecyclerView r16 = this.mRecyclerView;
        if (r15 <= r14) goto L32;
        int r17 = r12 - 3;
    L33:
        r16.scrollToPosition(r17);
        RecyclerView r18 = this.mRecyclerView;
        r18.post(new SmoothScrollToPosition(r12, r18));
        return;
    L32:
        r17 = r12 + 3;
        goto L33
    L34:
        this.mRecyclerView.smoothScrollToPosition(r12);
        return;
    L14:
        if (this.mScrollEventAdapter.isIdle() == false) goto L16;
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int r5) {
        super.setLayoutDirection(r5);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int r5) {
        if (r5 < 1) goto L5;
    L9:
        this.mOffscreenPageLimit = r5;
        this.mRecyclerView.requestLayout();
        return;
    L5:
        if (r5 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setPageTransformer(@Nullable PageTransformer r5) {
        if (r5 == null) goto L9;
        if (this.mSavedItemAnimatorPresent == true) goto L7;
        this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
        this.mSavedItemAnimatorPresent = true;
    L7:
        this.mRecyclerView.setItemAnimator(null);
    L12:
        if (r5 != this.mPageTransformerAdapter.getPageTransformer()) goto L14;
        return;
    L14:
        this.mPageTransformerAdapter.setPageTransformer(r5);
        requestTransform();
        return;
    L9:
        if (this.mSavedItemAnimatorPresent == false) goto L12;
        this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        goto L12
    }

    public void setUserInputEnabled(boolean r5) {
        this.mUserInputEnabled = r5;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void snapToPage() {
        View r5 = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (r5 != null) goto L5;
        return;
    L5:
        int[] r10 = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, r5);
        int r11 = r10[0];
        if (r11 == 0) goto L8;
    L9:
        this.mRecyclerView.smoothScrollBy(r11, r10[1]);
        return;
    L8:
        if (r10[1] != 0) goto L9;
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback r5) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(r5);
    }

    public void updateCurrentItem() {
        PagerSnapHelper r5 = this.mPagerSnapHelper;
        if (r5 == null) goto L15;
        View r10 = r5.findSnapView(this.mLayoutManager);
        if (r10 != null) goto L7;
        return;
    L7:
        int r11 = this.mLayoutManager.getPosition(r10);
        if (r11 != this.mCurrentItem) goto L10;
    L12:
        this.mCurrentItemDirty = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.mPageChangeEventDispatcher.onPageSelected(r11);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration r5, int r10) {
        this.mRecyclerView.addItemDecoration(r5, r10);
    }

    public void setCurrentItem(int r5, boolean r10) {
        if (isFakeDragging() == true) goto L7;
        setCurrentItemInternal(r5, r10);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setOrientation(int r5) {
        this.mLayoutManager.setOrientation(r5);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public ViewPager2(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r5, r10);
    }

    public ViewPager2(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r5, r10);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context r5, @Nullable AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11, r12);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r5, r10);
    }
}
