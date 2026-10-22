package androidx.viewpager2.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
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
import com.google.android.material.card.MaterialCardView;
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

    private abstract class AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        private AccessibilityProvider(ViewPager2 r10) {
            this.this$0 = r10;
        }

        /* synthetic */ AccessibilityProvider(ViewPager2 r10, AnonymousClass1 r11) {
            this(r10);
        }

        boolean handlesGetAccessibilityClassName() {
            return false;
        }

        boolean handlesLmPerformAccessibilityAction(int r10) {
            return false;
        }

        boolean handlesPerformAccessibilityAction(int r10, Bundle r11) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void onAttachAdapter(@Nullable RecyclerView.Adapter<?> r10) {
        }

        void onDetachAdapter(@Nullable RecyclerView.Adapter<?> r10) {
        }

        String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        void onInitialize(@NonNull CompositeOnPageChangeCallback r10, @NonNull RecyclerView r11) {
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        }

        void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat r10) {
        }

        boolean onLmPerformAccessibilityAction(int r10) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean onPerformAccessibilityAction(int r10, Bundle r11) {
            throw new IllegalStateException("Not implemented.");
        }

        void onRestorePendingState() {
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        }

        void onSetLayoutDirection() {
        }

        void onSetNewCurrentItem() {
        }

        void onSetOrientation() {
        }

        void onSetUserInputEnabled() {
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        BasicAccessibilityProvider(ViewPager2 r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int r10) {
            if (r10 == 8192) goto L7;
            if (r10 == 4096) goto L7;
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
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat r10) {
            if (this.this$0.isUserInputEnabled() == true) goto L6;
            r10.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r10.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r10.setScrollable(false);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int r10) {
            if (handlesLmPerformAccessibilityAction(r10) == false) goto L7;
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

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        /* synthetic */ DataSetChangeObserver(AnonymousClass1 r10) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r10, int r11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r10, int r11, @Nullable Object r12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r10, int r11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r10, int r11, int r12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r10, int r11) {
            onChanged();
        }
    }

    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        final /* synthetic */ ViewPager2 this$0;

        LinearLayoutManagerImpl(ViewPager2 r10, Context r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State r10, @NonNull int[] r11) {
            int r12 = this.this$0.getOffscreenPageLimit();
            if (r12 != (-1)) goto L6;
            super.calculateExtraLayoutSpace(r10, r11);
            return;
        L6:
            int r13 = this.this$0.getPageSize() * r12;
            r11[0] = r13;
            r11[1] = r13;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler r10, @NonNull RecyclerView.State r11, @NonNull AccessibilityNodeInfoCompat r12) {
            super.onInitializeAccessibilityNodeInfo(r10, r11, r12);
            this.this$0.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(r12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler r10, @NonNull RecyclerView.State r11, int r12, @Nullable Bundle r13) {
            if (this.this$0.mAccessibilityProvider.handlesLmPerformAccessibilityAction(r12) == false) goto L7;
            return this.this$0.mAccessibilityProvider.onLmPerformAccessibilityAction(r12);
        L7:
            return super.performAccessibilityAction(r10, r11, r12, r13);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r10, @NonNull View r11, @NonNull Rect r12, boolean r13, boolean r14) {
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

        public void onPageScrollStateChanged(int r10) {
        }

        public void onPageScrolled(int r10, float r11, @Px int r12) {
        }

        public void onPageSelected(int r10) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    class PageAwareAccessibilityProvider extends AccessibilityProvider {
        private final AccessibilityViewCommand mActionPageBackward;
        private final AccessibilityViewCommand mActionPageForward;
        private RecyclerView.AdapterDataObserver mAdapterDataObserver;
        final /* synthetic */ ViewPager2 this$0;

        PageAwareAccessibilityProvider(ViewPager2 r10) {
            this.this$0 = r10;
            super(r10, null);
            this.mActionPageForward = new AnonymousClass1(this);
            this.mActionPageBackward = new AnonymousClass2(this);
        }

        private void addCollectionInfo(AccessibilityNodeInfo r10) {
            if (this.this$0.getAdapter() == null) goto L8;
            int r11 = this.this$0.getOrientation();
            int r12 = this.this$0.getAdapter().getItemCount();
            if (r11 != 1) goto L7;
            int r13 = 0;
        L9:
            AccessibilityNodeInfoCompat.wrap(r10).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r12, r13, false, 0));
            return;
        L7:
            r13 = r12;
            r12 = 0;
            goto L9
        L8:
            r12 = 0;
            r13 = 0;
            goto L9
        }

        private void addScrollActions(AccessibilityNodeInfo r10) {
            RecyclerView.Adapter r11 = this.this$0.getAdapter();
            if (r11 != null) goto L5;
            return;
        L5:
            int r12 = r11.getItemCount();
            if (r12 != 0) goto L8;
            return;
        L8:
            if (this.this$0.isUserInputEnabled() == true) goto L11;
            return;
        L11:
            if (this.this$0.mCurrentItem <= 0) goto L14;
            r10.addAction(8192);
        L14:
            if (this.this$0.mCurrentItem >= (r12 - 1)) goto L16;
            r10.addAction(4096);
        L16:
            r10.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesPerformAccessibilityAction(int r10, Bundle r11) {
            if (r10 != 8192) goto L5;
        L8:
            return true;
        L5:
            if (r10 == 4096) goto L8;
            return false;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onAttachAdapter(@Nullable RecyclerView.Adapter<?> r10) {
            updatePageAccessibilityActions();
            if (r10 == null) goto L6;
            r10.registerAdapterDataObserver(this.mAdapterDataObserver);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onDetachAdapter(@Nullable RecyclerView.Adapter<?> r10) {
            if (r10 == null) goto L5;
            r10.unregisterAdapterDataObserver(this.mAdapterDataObserver);
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
        public void onInitialize(@NonNull CompositeOnPageChangeCallback r10, @NonNull RecyclerView r11) {
            ViewCompat.setImportantForAccessibility(r11, 2);
            this.mAdapterDataObserver = new AnonymousClass3(this);
            if (ViewCompat.getImportantForAccessibility(this.this$0) != 0) goto L6;
            ViewCompat.setImportantForAccessibility(this.this$0, 1);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
            addCollectionInfo(r10);
            if (Build.VERSION.SDK_INT < 16) goto L6;
            addScrollActions(r10);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onPerformAccessibilityAction(int r10, Bundle r11) {
            if (handlesPerformAccessibilityAction(r10, r11) == false) goto L11;
            if (r10 != 8192) goto L7;
            int r12 = this.this$0.getCurrentItem() - 1;
        L8:
            setCurrentItemFromAccessibilityCommand(r12);
            return true;
        L7:
            r12 = this.this$0.getCurrentItem() + 1;
            goto L8
        L11:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
            r10.setSource(this.this$0);
            r10.setClassName(onGetAccessibilityClassName());
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
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            this.this$0.sendAccessibilityEvent(2048);
            return;
        }

        void setCurrentItemFromAccessibilityCommand(int r10) {
            if (this.this$0.isUserInputEnabled() == false) goto L6;
            this.this$0.setCurrentItemInternal(r10, true);
            return;
        }

        void updatePageAccessibilityActions() {
            ViewPager2 r10 = this.this$0;
            int r11 = R.id.accessibilityActionPageLeft;
            ViewCompat.removeAccessibilityAction(r10, R.id.accessibilityActionPageLeft);
            ViewCompat.removeAccessibilityAction(r10, R.id.accessibilityActionPageRight);
            ViewCompat.removeAccessibilityAction(r10, R.id.accessibilityActionPageUp);
            ViewCompat.removeAccessibilityAction(r10, R.id.accessibilityActionPageDown);
            if (this.this$0.getAdapter() != null) goto L5;
            return;
        L5:
            int r12 = this.this$0.getAdapter().getItemCount();
            if (r12 != 0) goto L9;
            return;
        L9:
            if (this.this$0.isUserInputEnabled() == true) goto L12;
            return;
        L12:
            if (this.this$0.getOrientation() != 0) goto L26;
            boolean r13 = this.this$0.isRtl();
            if (r13 == false) goto L16;
            int r14 = 16908360;
        L17:
            if (r13 == false) goto L20;
            r11 = 16908361;
        L20:
            if (this.this$0.mCurrentItem >= (r12 - 1)) goto L23;
            ViewCompat.replaceAccessibilityAction(r10, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r14, null), null, this.mActionPageForward);
        L23:
            if (this.this$0.mCurrentItem <= 0) goto L32;
            ViewCompat.replaceAccessibilityAction(r10, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r11, null), null, this.mActionPageBackward);
            return;
        L32:
            return;
        L16:
            r14 = 16908361;
            goto L17
        L26:
            if (this.this$0.mCurrentItem >= (r12 - 1)) goto L29;
            ViewCompat.replaceAccessibilityAction(r10, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, null), null, this.mActionPageForward);
        L29:
            if (this.this$0.mCurrentItem <= 0) goto L34;
            ViewCompat.replaceAccessibilityAction(r10, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, null), null, this.mActionPageBackward);
            return;
        }
    }

    public interface PageTransformer {
        void transformPage(@NonNull View r10, float r11);
    }

    private class PagerSnapHelperImpl extends PagerSnapHelper {
        final /* synthetic */ ViewPager2 this$0;

        PagerSnapHelperImpl(ViewPager2 r10) {
            this.this$0 = r10;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager r10) {
            if (this.this$0.isFakeDragging() == false) goto L6;
            return null;
        L6:
            return super.findSnapView(r10);
        }
    }

    private class RecyclerViewImpl extends RecyclerView {
        final /* synthetic */ ViewPager2 this$0;

        RecyclerViewImpl(@NonNull ViewPager2 r10, Context r11) {
            this.this$0 = r10;
            super(r11);
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
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r10);
            r10.setFromIndex(this.this$0.mCurrentItem);
            r10.setToIndex(this.this$0.mCurrentItem);
            this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(r10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r10) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r10) == false) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent r10) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r10) == false) goto L7;
            return true;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r10) {
            super(r10);
            readValues(r10, null);
        }

        @RequiresApi(24)
        SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            readValues(r10, r11);
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        private void readValues(Parcel r10, ClassLoader r11) {
            this.mRecyclerViewId = r10.readInt();
            this.mCurrentItem = r10.readInt();
            this.mAdapterState = r10.readParcelable(r11);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.mRecyclerViewId);
            r10.writeInt(this.mCurrentItem);
            r10.writeParcelable(this.mAdapterState, r11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollState {
    }

    private static class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        SmoothScrollToPosition(int r10, RecyclerView r11) {
            this.mPosition = r10;
            this.mRecyclerView = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    static {
    }

    public ViewPager2(@NonNull Context r10) {
        super(r10);
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
        initialize(r10, null);
    }

    public ViewPager2(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
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
        initialize(r10, r11);
    }

    public ViewPager2(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
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
        initialize(r10, r11);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
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
        initialize(r10, r11);
    }

    private RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener() {
        return new AnonymousClass4(this);
    }

    private void initialize(Context r10, AttributeSet r11) {
        if (sFeatureEnhancedA11yEnabled == false) goto L5;
        AccessibilityProvider r12 = new PageAwareAccessibilityProvider(this);
    L6:
        this.mAccessibilityProvider = r12;
        RecyclerViewImpl r13 = new RecyclerViewImpl(this, r10);
        this.mRecyclerView = r13;
        r13.setId(ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl r14 = new LinearLayoutManagerImpl(this, r10);
        this.mLayoutManager = r14;
        this.mRecyclerView.setLayoutManager(r14);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(r10, r11);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        ScrollEventAdapter r15 = new ScrollEventAdapter(this);
        this.mScrollEventAdapter = r15;
        this.mFakeDragger = new FakeDrag(this, r15, this.mRecyclerView);
        PagerSnapHelperImpl r16 = new PagerSnapHelperImpl(this);
        this.mPagerSnapHelper = r16;
        r16.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback r17 = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = r17;
        this.mScrollEventAdapter.setOnPageChangeCallback(r17);
        OnPageChangeCallback r18 = new AnonymousClass2(this);
        OnPageChangeCallback r19 = new AnonymousClass3(this);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r18);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r19);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter r20 = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = r20;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r20);
        RecyclerView r21 = this.mRecyclerView;
        attachViewToParent(r21, 0, r21.getLayoutParams());
        return;
    L5:
        r12 = new BasicAccessibilityProvider(this);
        goto L6
    }

    private void registerCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> r10) {
        if (r10 == null) goto L5;
        r10.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restorePendingState() {
        if (this.mPendingCurrentItem != (-1)) goto L5;
        return;
    L5:
        RecyclerView.Adapter r10 = getAdapter();
        if (r10 != 0) goto L8;
        return;
    L8:
        Parcelable r11 = this.mPendingAdapterState;
        if (r11 != null) goto L11;
    L14:
        int r12 = Math.max(0, Math.min(this.mPendingCurrentItem, r10.getItemCount() - 1));
        this.mCurrentItem = r12;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(r12);
        this.mAccessibilityProvider.onRestorePendingState();
        return;
    L11:
        if ((r10 instanceof StatefulAdapter) == false) goto L13;
        ((StatefulAdapter) r10).restoreState(r11);
    L13:
        this.mPendingAdapterState = null;
        goto L14
    }

    private void setOrientation(Context r10, AttributeSet r11) {
        int[] r12 = androidx.viewpager2.R.styleable.ViewPager2;
        TypedArray r13 = r10.obtainStyledAttributes(r11, r12);
        if (Build.VERSION.SDK_INT < 29) goto L11;
        saveAttributeDataForStyleable(r10, r12, r11, r13, 0, 0);
    L11:
        setOrientation(r13.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));     // Catch: Throwable -> L8
        r13.recycle();
        return;
    L8:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    private void unregisterCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> r10) {
        if (r10 == null) goto L5;
        r10.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration r10) {
        this.mRecyclerView.addItemDecoration(r10);
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration r10, int r11) {
        this.mRecyclerView.addItemDecoration(r10, r11);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r10) {
        return this.mRecyclerView.canScrollHorizontally(r10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r10) {
        return this.mRecyclerView.canScrollVertically(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> r10) {
        Parcelable r11 = r10.get(getId());
        if ((r11 instanceof SavedState) == false) goto L5;
        int r12 = ((SavedState) r11).mRecyclerViewId;
        r10.put(this.mRecyclerView.getId(), r10.get(r12));
        r10.remove(r12);
    L5:
        super.dispatchRestoreInstanceState(r10);
        restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float r10) {
        return this.mFakeDragger.fakeDragBy(r10);
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
    public RecyclerView.ItemDecoration getItemDecorationAt(int r10) {
        return this.mRecyclerView.getItemDecorationAt(r10);
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

    int getPageSize() {
        RecyclerView r10 = this.mRecyclerView;
        if (getOrientation() != 0) goto L5;
        int r11 = r10.getWidth() - r10.getPaddingLeft();
        int r12 = r10.getPaddingRight();
    L7:
        return r11 - r12;
    L5:
        r11 = r10.getHeight() - r10.getPaddingTop();
        r12 = r10.getPaddingBottom();
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

    boolean isRtl() {
        if (this.mLayoutManager.getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = this.mRecyclerView.getMeasuredWidth();
        int r16 = this.mRecyclerView.getMeasuredHeight();
        Rect r17 = this.mTmpContainerRect;
        r17.left = getPaddingLeft();
        Rect r18 = this.mTmpContainerRect;
        r18.right = (r13 - r11) - getPaddingRight();
        Rect r19 = this.mTmpContainerRect;
        r19.top = getPaddingTop();
        Rect r20 = this.mTmpContainerRect;
        r20.bottom = (r14 - r12) - getPaddingBottom();
        Gravity.apply(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START, r15, r16, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView r21 = this.mRecyclerView;
        Rect r22 = this.mTmpChildRect;
        r21.layout(r22.left, r22.top, r22.right, r22.bottom);
        if (this.mCurrentItemDirty == false) goto L6;
        updateCurrentItem();
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        measureChild(this.mRecyclerView, r10, r11);
        int r12 = this.mRecyclerView.getMeasuredWidth();
        int r13 = this.mRecyclerView.getMeasuredHeight();
        int r14 = this.mRecyclerView.getMeasuredState();
        int r15 = r12 + (getPaddingLeft() + getPaddingRight());
        int r16 = r13 + (getPaddingTop() + getPaddingBottom());
        int r17 = Math.max(r15, getSuggestedMinimumWidth());
        int r18 = Math.max(r16, getSuggestedMinimumHeight());
        setMeasuredDimension(ViewGroup.resolveSizeAndState(r17, r10, r14), ViewGroup.resolveSizeAndState(r18, r11, r14 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.mPendingCurrentItem = r11.mCurrentItem;
        this.mPendingAdapterState = r11.mAdapterState;
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.mRecyclerViewId = this.mRecyclerView.getId();
        int r11 = this.mPendingCurrentItem;
        if (r11 != (-1)) goto L5;
        r11 = this.mCurrentItem;
    L5:
        r10.mCurrentItem = r11;
        Parcelable r12 = this.mPendingAdapterState;
        if (r12 == null) goto L8;
        r10.mAdapterState = r12;
    L11:
        return r10;
    L8:
        Object r13 = this.mRecyclerView.getAdapter();
        if ((r13 instanceof StatefulAdapter) == false) goto L11;
        r10.mAdapterState = ((StatefulAdapter) r13).saveState();
        goto L11
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r10) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int r10, Bundle r11) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(r10, r11) == false) goto L7;
        return this.mAccessibilityProvider.onPerformAccessibilityAction(r10, r11);
    L7:
        return super.performAccessibilityAction(r10, r11);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback r10) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(r10);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration r10) {
        this.mRecyclerView.removeItemDecoration(r10);
    }

    public void removeItemDecorationAt(int r10) {
        this.mRecyclerView.removeItemDecorationAt(r10);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() != null) goto L5;
        return;
    L5:
        double r10 = this.mScrollEventAdapter.getRelativeScrollPosition();
        int r11 = (int) r10;
        float r12 = (float) (r10 - ((double) r11));
        this.mPageTransformerAdapter.onPageScrolled(r11, r12, Math.round(getPageSize() * r12));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter r10) {
        RecyclerView.Adapter r11 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(r11);
        unregisterCurrentItemDataSetTracker(r11);
        this.mRecyclerView.setAdapter(r10);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(r10);
        registerCurrentItemDataSetTracker(r10);
    }

    public void setCurrentItem(int r10) {
        setCurrentItem(r10, true);
    }

    public void setCurrentItem(int r10, boolean r11) {
        if (isFakeDragging() == true) goto L7;
        setCurrentItemInternal(r10, r11);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    void setCurrentItemInternal(int r10, boolean r11) {
        RecyclerView.Adapter r12 = getAdapter();
        if (r12 != null) goto L9;
        if (this.mPendingCurrentItem == (-1)) goto L36;
        this.mPendingCurrentItem = Math.max(r10, 0);
        return;
    L36:
        return;
    L9:
        if (r12.getItemCount() > 0) goto L11;
        return;
    L11:
        int r13 = Math.min(Math.max(r10, 0), r12.getItemCount() - 1);
        if (r13 == this.mCurrentItem) goto L14;
    L16:
        int r14 = this.mCurrentItem;
        if (r13 != r14) goto L20;
        if (r11 == false) goto L20;
        return;
    L20:
        double r15 = r14;
        this.mCurrentItem = r13;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (this.mScrollEventAdapter.isIdle() == true) goto L23;
        r15 = this.mScrollEventAdapter.getRelativeScrollPosition();
    L23:
        this.mScrollEventAdapter.notifyProgrammaticScroll(r13, r11);
        if (r11 == true) goto L27;
        this.mRecyclerView.scrollToPosition(r13);
        return;
    L27:
        double r16 = r13;
        if (Math.abs(r16 - r15) <= 3.0d) goto L34;
        RecyclerView r17 = this.mRecyclerView;
        if (r16 <= r15) goto L32;
        int r18 = r13 - 3;
    L33:
        r17.scrollToPosition(r18);
        RecyclerView r19 = this.mRecyclerView;
        r19.post(new SmoothScrollToPosition(r13, r19));
        return;
    L32:
        r18 = r13 + 3;
        goto L33
    L34:
        this.mRecyclerView.smoothScrollToPosition(r13);
        return;
    L14:
        if (this.mScrollEventAdapter.isIdle() == false) goto L16;
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int r10) {
        super.setLayoutDirection(r10);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int r10) {
        if (r10 < 1) goto L5;
    L9:
        this.mOffscreenPageLimit = r10;
        this.mRecyclerView.requestLayout();
        return;
    L5:
        if (r10 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int r10) {
        this.mLayoutManager.setOrientation(r10);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public void setPageTransformer(@Nullable PageTransformer r10) {
        boolean r11 = this.mSavedItemAnimatorPresent;
        if (r10 == null) goto L7;
        if (r11 == true) goto L6;
        this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
        this.mSavedItemAnimatorPresent = true;
    L6:
        this.mRecyclerView.setItemAnimator(null);
    L10:
        if (r10 != this.mPageTransformerAdapter.getPageTransformer()) goto L12;
        return;
    L12:
        this.mPageTransformerAdapter.setPageTransformer(r10);
        requestTransform();
        return;
    L7:
        if (r11 == false) goto L10;
        this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        goto L10
    }

    public void setUserInputEnabled(boolean r10) {
        this.mUserInputEnabled = r10;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    void snapToPage() {
        View r10 = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (r10 != null) goto L5;
        return;
    L5:
        int[] r11 = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, r10);
        if (r11[0] == 0) goto L8;
    L9:
        this.mRecyclerView.smoothScrollBy(r11[0], r11[1]);
        return;
    L8:
        if (r11[1] != 0) goto L9;
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback r10) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(r10);
    }

    void updateCurrentItem() {
        PagerSnapHelper r10 = this.mPagerSnapHelper;
        if (r10 == null) goto L15;
        View r11 = r10.findSnapView(this.mLayoutManager);
        if (r11 != null) goto L7;
        return;
    L7:
        int r12 = this.mLayoutManager.getPosition(r11);
        if (r12 != this.mCurrentItem) goto L10;
    L12:
        this.mCurrentItemDirty = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.mPageChangeEventDispatcher.onPageSelected(r12);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }
}
