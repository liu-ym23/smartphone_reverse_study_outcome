package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

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

    class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId;
        private ViewPager2 mViewPager;
        final /* synthetic */ FragmentStateAdapter this$0;

        FragmentMaxLifecycleEnforcer(FragmentStateAdapter r10) {
            this.this$0 = r10;
            this.mPrimaryItemId = -1;
        }

        @NonNull
        private ViewPager2 inferViewPager(@NonNull RecyclerView r10) {
            ViewParent r11 = r10.getParent();
            if ((r11 instanceof ViewPager2) == false) goto L7;
            return (ViewPager2) r11;
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r11);
        }

        void register(@NonNull RecyclerView r10) {
            this.mViewPager = inferViewPager(r10);
            ViewPager2.OnPageChangeCallback r11 = new AnonymousClass1(this);
            this.mPageChangeCallback = r11;
            this.mViewPager.registerOnPageChangeCallback(r11);
            DataSetChangeObserver r12 = new AnonymousClass2(this);
            this.mDataObserver = r12;
            this.this$0.registerAdapterDataObserver(r12);
            LifecycleEventObserver r13 = new AnonymousClass3(this);
            this.mLifecycleObserver = r13;
            this.this$0.mLifecycle.addObserver(r13);
        }

        void unregister(@NonNull RecyclerView r10) {
            inferViewPager(r10).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
            this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        void updateFragmentMaxLifecycle(boolean r10) {
            if (this.this$0.shouldDelayFragmentTransactions() == false) goto L6;
            return;
        L6:
            if (this.mViewPager.getScrollState() == 0) goto L9;
            return;
        L9:
            if (this.this$0.mFragments.isEmpty() == false) goto L11;
            return;
        L11:
            if (this.this$0.getItemCount() == 0) goto L53;
            int r11 = this.mViewPager.getCurrentItem();
            if (r11 < this.this$0.getItemCount()) goto L16;
            return;
        L16:
            long r12 = this.this$0.getItemId(r11);
            if (r12 != this.mPrimaryItemId) goto L20;
            if (r10 == true) goto L20;
            return;
        L20:
            Fragment r13 = this.this$0.mFragments.get(r12);
            if (r13 != null) goto L23;
            return;
        L23:
            if (r13.isAdded() == false) goto L54;
            this.mPrimaryItemId = r12;
            FragmentTransaction r14 = this.this$0.mFragmentManager.beginTransaction();
            Fragment r15 = null;
            int r16 = 0;
        L27:
            if (r16 >= this.this$0.mFragments.size()) goto L41;
            long r17 = this.this$0.mFragments.keyAt(r16);
            Fragment r18 = this.this$0.mFragments.valueAt(r16);
            if (r18.isAdded() == false) goto L40;
            if (r17 == this.mPrimaryItemId) goto L34;
            r14.setMaxLifecycle(r18, Lifecycle.State.STARTED);
        L36:
            if (r17 != this.mPrimaryItemId) goto L38;
            boolean r19 = true;
        L39:
            r18.setMenuVisibility(r19);
            goto L40
        L38:
            r19 = false;
            goto L39
        L34:
            r15 = r18;
        L40:
            r16 = r16 + 1;
            goto L27
        L41:
            if (r15 == null) goto L44;
            r14.setMaxLifecycle(r15, Lifecycle.State.RESUMED);
        L44:
            if (r14.isEmpty() == true) goto L52;
            r14.commitNow();
            return;
        L52:
            return;
        L54:
            return;
        }
    }

    public FragmentStateAdapter(@NonNull Fragment r10) {
        this(r10.getChildFragmentManager(), r10.getLifecycle());
    }

    public FragmentStateAdapter(@NonNull FragmentActivity r10) {
        this(r10.getSupportFragmentManager(), r10.getLifecycle());
    }

    public FragmentStateAdapter(@NonNull FragmentManager r10, @NonNull Lifecycle r11) {
        this.mFragments = new LongSparseArray();
        this.mSavedStates = new LongSparseArray();
        this.mItemIdToViewHolder = new LongSparseArray();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = r10;
        this.mLifecycle = r11;
        super.setHasStableIds(true);
    }

    @NonNull
    private static String createKey(@NonNull String r10, long r11) {
        return r10 + r11;
    }

    private void ensureFragment(int r10) {
        long r11 = getItemId(r10);
        if (this.mFragments.containsKey(r11) == true) goto L6;
        Fragment r12 = createFragment(r10);
        r12.setInitialSavedState(this.mSavedStates.get(r11));
        this.mFragments.put(r11, r12);
        return;
    }

    private boolean isFragmentViewBound(long r10) {
        if (this.mItemIdToViewHolder.containsKey(r10) == false) goto L5;
        return true;
    L5:
        Fragment r11 = this.mFragments.get(r10);
        if (r11 != null) goto L8;
        return false;
    L8:
        View r12 = r11.getView();
        if (r12 != null) goto L12;
        return false;
    L12:
        if (r12.getParent() == null) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean isValidKey(@NonNull String r10, @NonNull String r11) {
        if (r10.startsWith(r11) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.length() <= r11.length()) goto L7;
        return true;
    }

    private Long itemForViewHolder(int r10) {
        Long r11 = null;
        int r12 = 0;
    L4:
        if (r12 >= this.mItemIdToViewHolder.size()) goto L12;
        if (this.mItemIdToViewHolder.valueAt(r12).intValue() != r10) goto L11;
        if (r11 != null) goto L10;
        r11 = Long.valueOf(this.mItemIdToViewHolder.keyAt(r12));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        return r11;
    }

    private static long parseIdFromKey(@NonNull String r10, @NonNull String r11) {
        return Long.parseLong(r10.substring(r11.length()));
    }

    private void removeFragment(long r10) {
        Fragment r11 = this.mFragments.get(r10);
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.getView() == null) goto L11;
        ViewParent r12 = r11.getView().getParent();
        if (r12 == null) goto L11;
        ((FrameLayout) r12).removeAllViews();
    L11:
        if (containsItem(r10) == true) goto L14;
        this.mSavedStates.remove(r10);
    L14:
        if (r11.isAdded() == true) goto L18;
        this.mFragments.remove(r10);
        return;
    L18:
        if (shouldDelayFragmentTransactions() == false) goto L22;
        this.mHasStaleFragments = true;
        return;
    L22:
        if (r11.isAdded() == true) goto L24;
    L26:
        this.mFragmentManager.beginTransaction().remove(r11).commitNow();
        this.mFragments.remove(r10);
        return;
    L24:
        if (containsItem(r10) == false) goto L26;
        this.mSavedStates.put(r10, this.mFragmentManager.saveFragmentInstanceState(r11));
        goto L26
    }

    private void scheduleGracePeriodEnd() {
        final Handler r10 = new Handler(Looper.getMainLooper());
        final Runnable r11 = new AnonymousClass4(this);
        this.mLifecycle.addObserver(new AnonymousClass5(this, r10, r11));
        r10.postDelayed(r11, 10000);
    }

    private void scheduleViewAttach(final Fragment r10, @NonNull final FrameLayout r11) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new AnonymousClass3(this, r10, r11), false);
    }

    void addViewToContainer(@NonNull View r10, @NonNull FrameLayout r11) {
        if (r11.getChildCount() > 1) goto L16;
        if (r10.getParent() != r11) goto L8;
        return;
    L8:
        if (r11.getChildCount() <= 0) goto L11;
        r11.removeAllViews();
    L11:
        if (r10.getParent() == null) goto L13;
        ((ViewGroup) r10.getParent()).removeView(r10);
    L13:
        r11.addView(r10);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long r10) {
        if (r10 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= getItemCount()) goto L7;
        return true;
    }

    @NonNull
    public abstract Fragment createFragment(int r10);

    void gcFragments() {
        if (this.mHasStaleFragments == true) goto L5;
        return;
    L5:
        if (shouldDelayFragmentTransactions() == true) goto L35;
        ArraySet r10 = new ArraySet();
        int r11 = 0;
        int r12 = 0;
    L9:
        if (r12 >= this.mFragments.size()) goto L15;
        long r13 = this.mFragments.keyAt(r12);
        if (containsItem(r13) == true) goto L13;
        r10.add(Long.valueOf(r13));
        this.mItemIdToViewHolder.remove(r13);
    L13:
        r12 = r12 + 1;
        goto L9
    L15:
        if (this.mIsInGracePeriod == true) goto L23;
        this.mHasStaleFragments = false;
    L18:
        if (r11 >= this.mFragments.size()) goto L23;
        long r14 = this.mFragments.keyAt(r11);
        if (isFragmentViewBound(r14) == true) goto L22;
        r10.add(Long.valueOf(r14));
    L22:
        r11 = r11 + 1;
    L23:
        Iterator<E> r15 = r10.iterator();
    L25:
        if (r15.hasNext() == false) goto L36;
        removeFragment(((Long) r15.next()).longValue());
        goto L25
    L36:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView r10) {
        if (this.mFragmentMaxLifecycleEnforcer != null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11);
        FragmentMaxLifecycleEnforcer r12 = new FragmentMaxLifecycleEnforcer(this);
        this.mFragmentMaxLifecycleEnforcer = r12;
        r12.register(r10);
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((FragmentViewHolder) r10, r11);
    }

    public final void onBindViewHolder(@NonNull final FragmentViewHolder r10, int r11) {
        long r12 = r10.getItemId();
        int r13 = r10.getContainer().getId();
        Long r14 = itemForViewHolder(r13);
        if (r14 != null) goto L5;
    L7:
        this.mItemIdToViewHolder.put(r12, Integer.valueOf(r13));
        ensureFragment(r11);
        final FrameLayout r15 = r10.getContainer();
        if (ViewCompat.isAttachedToWindow(r15) == true) goto L10;
    L14:
        gcFragments();
        return;
    L10:
        if (r15.getParent() != null) goto L13;
        r15.addOnLayoutChangeListener(new AnonymousClass1(this, r15, r10));
        goto L14
    L13:
        throw new IllegalStateException("Design assumption violated.");
    L5:
        if (r14.longValue() == r12) goto L7;
        removeFragment(r14.longValue());
        this.mItemIdToViewHolder.remove(r14.longValue());
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        return FragmentViewHolder.create(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView r10) {
        this.mFragmentMaxLifecycleEnforcer.unregister(r10);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder r10) {
        return onFailedToRecycleView((FragmentViewHolder) r10);
    }

    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder r10) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder r10) {
        onViewAttachedToWindow((FragmentViewHolder) r10);
    }

    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder r10) {
        placeFragmentInViewHolder(r10);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(@NonNull RecyclerView.ViewHolder r10) {
        onViewRecycled((FragmentViewHolder) r10);
    }

    public final void onViewRecycled(@NonNull FragmentViewHolder r10) {
        Long r11 = itemForViewHolder(r10.getContainer().getId());
        if (r11 == null) goto L6;
        removeFragment(r11.longValue());
        this.mItemIdToViewHolder.remove(r11.longValue());
        return;
    }

    void placeFragmentInViewHolder(@NonNull final FragmentViewHolder r10) {
        Fragment r11 = this.mFragments.get(r10.getItemId());
        if (r11 == null) goto L36;
        FrameLayout r12 = r10.getContainer();
        View r13 = r11.getView();
        if (r11.isAdded() == true) goto L11;
        if (r13 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r11.isAdded() == false) goto L16;
        if (r13 != null) goto L16;
        scheduleViewAttach(r11, r12);
        return;
    L16:
        if (r11.isAdded() == false) goto L24;
        if (r13.getParent() == null) goto L24;
        if (r13.getParent() == r12) goto L37;
        addViewToContainer(r13, r12);
        return;
    L37:
        return;
    L24:
        if (r11.isAdded() == false) goto L28;
        addViewToContainer(r13, r12);
        return;
    L28:
        if (shouldDelayFragmentTransactions() == true) goto L31;
        scheduleViewAttach(r11, r12);
        this.mFragmentManager.beginTransaction().add(r11, "f" + r10.getItemId()).setMaxLifecycle(r11, Lifecycle.State.STARTED).commitNow();
        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
        return;
    L31:
        if (this.mFragmentManager.isDestroyed() == false) goto L33;
        return;
    L33:
        this.mLifecycle.addObserver(new AnonymousClass2(this, r10));
        return;
    L36:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable r10) {
        if (this.mSavedStates.isEmpty() == false) goto L28;
        if (this.mFragments.isEmpty() == false) goto L28;
        Bundle r11 = (Bundle) r10;
        if (r11.getClassLoader() != null) goto L9;
        r11.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r12 = r11.keySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L24;
        String r13 = r12.next();
        if (isValidKey(r13, KEY_PREFIX_FRAGMENT) == true) goto L14;
        if (isValidKey(r13, KEY_PREFIX_STATE) == false) goto L22;
        long r14 = parseIdFromKey(r13, KEY_PREFIX_STATE);
        Object r15 = (Fragment.SavedState) r11.getParcelable(r13);
        if (containsItem(r14) == false) goto L11;
        LongSparseArray r16 = this.mSavedStates;
    L15:
        r16.put(r14, r15);
        goto L11
    L22:
        throw new IllegalArgumentException("Unexpected key in savedState: " + r13);
    L14:
        r14 = parseIdFromKey(r13, KEY_PREFIX_FRAGMENT);
        r15 = this.mFragmentManager.getFragment(r11, r13);
        r16 = this.mFragments;
        goto L15
    L24:
        if (this.mFragments.isEmpty() == true) goto L36;
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
        return;
    L36:
        return;
    L28:
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        Bundle r10 = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.mFragments.size()) goto L12;
        long r13 = this.mFragments.keyAt(r12);
        Fragment r14 = this.mFragments.get(r13);
        if (r14 == null) goto L10;
        if (r14.isAdded() == false) goto L10;
        this.mFragmentManager.putFragment(r10, createKey(KEY_PREFIX_FRAGMENT, r13), r14);
    L10:
        r12 = r12 + 1;
    L12:
        if (r11 >= this.mSavedStates.size()) goto L17;
        long r15 = this.mSavedStates.keyAt(r11);
        if (containsItem(r15) == false) goto L16;
        r10.putParcelable(createKey(KEY_PREFIX_STATE, r15), this.mSavedStates.get(r15));
    L16:
        r11 = r11 + 1;
        goto L12
    L17:
        return r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }
}
