package androidx.viewpager2.adapter;

import ai.j0;
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

    public class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId;
        private ViewPager2 mViewPager;
        final /* synthetic */ FragmentStateAdapter this$0;

        public FragmentMaxLifecycleEnforcer(FragmentStateAdapter r5) {
            this.this$0 = r5;
            this.mPrimaryItemId = -1;
        }

        @NonNull
        private ViewPager2 inferViewPager(@NonNull RecyclerView r5) {
            ViewParent r10 = r5.getParent();
            if ((r10 instanceof ViewPager2) == false) goto L7;
            return (ViewPager2) r10;
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r10);
        }

        public void register(@NonNull RecyclerView r5) {
            this.mViewPager = inferViewPager(r5);
            ViewPager2.OnPageChangeCallback r10 = new AnonymousClass1(this);
            this.mPageChangeCallback = r10;
            this.mViewPager.registerOnPageChangeCallback(r10);
            DataSetChangeObserver r11 = new AnonymousClass2(this);
            this.mDataObserver = r11;
            this.this$0.registerAdapterDataObserver(r11);
            LifecycleEventObserver r12 = new AnonymousClass3(this);
            this.mLifecycleObserver = r12;
            this.this$0.mLifecycle.addObserver(r12);
        }

        public void unregister(@NonNull RecyclerView r5) {
            inferViewPager(r5).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
            this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void updateFragmentMaxLifecycle(boolean r10) {
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
            int r5 = this.mViewPager.getCurrentItem();
            if (r5 < this.this$0.getItemCount()) goto L16;
            return;
        L16:
            long r11 = this.this$0.getItemId(r5);
            if (r11 != this.mPrimaryItemId) goto L20;
            if (r10 == true) goto L20;
            return;
        L20:
            Fragment r12 = this.this$0.mFragments.get(r11);
            if (r12 != null) goto L23;
            return;
        L23:
            if (r12.isAdded() == false) goto L54;
            this.mPrimaryItemId = r11;
            FragmentTransaction r13 = this.this$0.mFragmentManager.beginTransaction();
            Fragment r14 = null;
            int r15 = 0;
        L27:
            if (r15 >= this.this$0.mFragments.size()) goto L41;
            long r16 = this.this$0.mFragments.keyAt(r15);
            Fragment r17 = this.this$0.mFragments.valueAt(r15);
            if (r17.isAdded() == false) goto L40;
            if (r16 == this.mPrimaryItemId) goto L34;
            r13.setMaxLifecycle(r17, Lifecycle.State.STARTED);
        L36:
            if (r16 != this.mPrimaryItemId) goto L38;
            boolean r18 = true;
        L39:
            r17.setMenuVisibility(r18);
            goto L40
        L38:
            r18 = false;
            goto L39
        L34:
            r14 = r17;
        L40:
            r15 = r15 + 1;
            goto L27
        L41:
            if (r14 == null) goto L44;
            r13.setMaxLifecycle(r14, Lifecycle.State.RESUMED);
        L44:
            if (r13.isEmpty() == true) goto L52;
            r13.commitNow();
            return;
        L52:
            return;
        L54:
            return;
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity r5) {
        this(r5.getSupportFragmentManager(), r5.getLifecycle());
    }

    @NonNull
    private static String createKey(@NonNull String r5, long r10) {
        return r5 + r10;
    }

    private void ensureFragment(int r5) {
        long r10 = getItemId(r5);
        if (this.mFragments.containsKey(r10) == true) goto L6;
        Fragment r11 = createFragment(r5);
        r11.setInitialSavedState(this.mSavedStates.get(r10));
        this.mFragments.put(r10, r11);
        return;
    }

    private boolean isFragmentViewBound(long r5) {
        if (this.mItemIdToViewHolder.containsKey(r5) == false) goto L5;
        return true;
    L5:
        Fragment r10 = this.mFragments.get(r5);
        if (r10 != null) goto L8;
        return false;
    L8:
        View r11 = r10.getView();
        if (r11 != null) goto L12;
        return false;
    L12:
        if (r11.getParent() == null) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean isValidKey(@NonNull String r5, @NonNull String r10) {
        if (r5.startsWith(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.length() <= r10.length()) goto L7;
        return true;
    }

    private Long itemForViewHolder(int r5) {
        Long r10 = null;
        int r11 = 0;
    L4:
        if (r11 >= this.mItemIdToViewHolder.size()) goto L12;
        if (this.mItemIdToViewHolder.valueAt(r11).intValue() != r5) goto L11;
        if (r10 != null) goto L10;
        r10 = Long.valueOf(this.mItemIdToViewHolder.keyAt(r11));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r11 = r11 + 1;
        goto L4
    L12:
        return r10;
    }

    private static long parseIdFromKey(@NonNull String r5, @NonNull String r10) {
        return Long.parseLong(r5.substring(r10.length()));
    }

    private void removeFragment(long r5) {
        Fragment r10 = this.mFragments.get(r5);
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getView() == null) goto L11;
        ViewParent r11 = r10.getView().getParent();
        if (r11 == null) goto L11;
        ((FrameLayout) r11).removeAllViews();
    L11:
        if (containsItem(r5) == true) goto L14;
        this.mSavedStates.remove(r5);
    L14:
        if (r10.isAdded() == true) goto L18;
        this.mFragments.remove(r5);
        return;
    L18:
        if (shouldDelayFragmentTransactions() == false) goto L22;
        this.mHasStaleFragments = true;
        return;
    L22:
        if (r10.isAdded() == true) goto L24;
    L26:
        this.mFragmentManager.beginTransaction().remove(r10).commitNow();
        this.mFragments.remove(r5);
        return;
    L24:
        if (containsItem(r5) == false) goto L26;
        this.mSavedStates.put(r5, this.mFragmentManager.saveFragmentInstanceState(r10));
        goto L26
    }

    private void scheduleGracePeriodEnd() {
        final Handler r5 = new Handler(Looper.getMainLooper());
        final Runnable r10 = new AnonymousClass4(this);
        this.mLifecycle.addObserver(new AnonymousClass5(this, r5, r10));
        r5.postDelayed(r10, GRACE_WINDOW_TIME_MS);
    }

    private void scheduleViewAttach(final Fragment r5, @NonNull final FrameLayout r10) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new AnonymousClass3(this, r5, r10), false);
    }

    public void addViewToContainer(@NonNull View r5, @NonNull FrameLayout r10) {
        if (r10.getChildCount() > 1) goto L16;
        if (r5.getParent() != r10) goto L8;
        return;
    L8:
        if (r10.getChildCount() <= 0) goto L11;
        r10.removeAllViews();
    L11:
        if (r5.getParent() == null) goto L13;
        ((ViewGroup) r5.getParent()).removeView(r5);
    L13:
        r10.addView(r5);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long r5) {
        if (r5 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r5 >= getItemCount()) goto L7;
        return true;
    }

    @NonNull
    public abstract Fragment createFragment(int r5);

    public void gcFragments() {
        if (this.mHasStaleFragments == true) goto L5;
        return;
    L5:
        if (shouldDelayFragmentTransactions() == true) goto L35;
        ArraySet r5 = new ArraySet();
        int r10 = 0;
        int r11 = 0;
    L9:
        if (r11 >= this.mFragments.size()) goto L15;
        long r12 = this.mFragments.keyAt(r11);
        if (containsItem(r12) == true) goto L13;
        r5.add(Long.valueOf(r12));
        this.mItemIdToViewHolder.remove(r12);
    L13:
        r11 = r11 + 1;
        goto L9
    L15:
        if (this.mIsInGracePeriod == true) goto L23;
        this.mHasStaleFragments = false;
    L18:
        if (r10 >= this.mFragments.size()) goto L23;
        long r13 = this.mFragments.keyAt(r10);
        if (isFragmentViewBound(r13) == true) goto L22;
        r5.add(Long.valueOf(r13));
    L22:
        r10 = r10 + 1;
    L23:
        Iterator<E> r14 = r5.iterator();
    L25:
        if (r14.hasNext() == false) goto L36;
        removeFragment(((Long) r14.next()).longValue());
        goto L25
    L36:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r5) {
        return r5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView r5) {
        if (this.mFragmentMaxLifecycleEnforcer != null) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkArgument(r10);
        FragmentMaxLifecycleEnforcer r11 = new FragmentMaxLifecycleEnforcer(this);
        this.mFragmentMaxLifecycleEnforcer = r11;
        r11.register(r5);
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r5, int r10) {
        onBindViewHolder((FragmentViewHolder) r5, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
        return onCreateViewHolder(r5, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView r5) {
        this.mFragmentMaxLifecycleEnforcer.unregister(r5);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder r5) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder r5) {
        onViewAttachedToWindow((FragmentViewHolder) r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(@NonNull RecyclerView.ViewHolder r5) {
        onViewRecycled((FragmentViewHolder) r5);
    }

    public void placeFragmentInViewHolder(@NonNull final FragmentViewHolder r10) {
        Fragment r5 = this.mFragments.get(r10.getItemId());
        if (r5 == null) goto L36;
        FrameLayout r11 = r10.getContainer();
        View r12 = r5.getView();
        if (r5.isAdded() == true) goto L11;
        if (r12 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r5.isAdded() == false) goto L16;
        if (r12 != null) goto L16;
        scheduleViewAttach(r5, r11);
        return;
    L16:
        if (r5.isAdded() == false) goto L24;
        if (r12.getParent() == null) goto L24;
        if (r12.getParent() == r11) goto L37;
        addViewToContainer(r12, r11);
        return;
    L37:
        return;
    L24:
        if (r5.isAdded() == false) goto L28;
        addViewToContainer(r12, r11);
        return;
    L28:
        if (shouldDelayFragmentTransactions() == true) goto L31;
        scheduleViewAttach(r5, r11);
        this.mFragmentManager.beginTransaction().add(r5, "f" + r10.getItemId()).setMaxLifecycle(r5, Lifecycle.State.STARTED).commitNow();
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
        if (this.mSavedStates.isEmpty() == false) goto L27;
        if (this.mFragments.isEmpty() == false) goto L27;
        Bundle r11 = (Bundle) r10;
        if (r11.getClassLoader() != null) goto L9;
        r11.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r5 = r11.keySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L23;
        String r12 = r5.next();
        if (isValidKey(r12, KEY_PREFIX_FRAGMENT) == true) goto L14;
        if (isValidKey(r12, KEY_PREFIX_STATE) == false) goto L21;
        long r13 = parseIdFromKey(r12, KEY_PREFIX_STATE);
        Fragment.SavedState r14 = (Fragment.SavedState) r11.getParcelable(r12);
        if (containsItem(r13) == false) goto L11;
        this.mSavedStates.put(r13, r14);
        goto L11
    L21:
        throw new IllegalArgumentException(j0.C("Unexpected key in savedState: ", r12));
    L14:
        long r15 = parseIdFromKey(r12, KEY_PREFIX_FRAGMENT);
        Fragment r16 = this.mFragmentManager.getFragment(r11, r12);
        this.mFragments.put(r15, r16);
        goto L11
    L23:
        if (this.mFragments.isEmpty() == true) goto L37;
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
        return;
    L37:
        return;
    L27:
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        Bundle r5 = new Bundle(this.mSavedStates.size() + this.mFragments.size());
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.mFragments.size()) goto L12;
        long r12 = this.mFragments.keyAt(r11);
        Fragment r13 = this.mFragments.get(r12);
        if (r13 == null) goto L10;
        if (r13.isAdded() == false) goto L10;
        this.mFragmentManager.putFragment(r5, createKey(KEY_PREFIX_FRAGMENT, r12), r13);
    L10:
        r11 = r11 + 1;
    L12:
        if (r10 >= this.mSavedStates.size()) goto L17;
        long r14 = this.mSavedStates.keyAt(r10);
        if (containsItem(r14) == false) goto L16;
        r5.putParcelable(createKey(KEY_PREFIX_STATE, r14), this.mSavedStates.get(r14));
    L16:
        r10 = r10 + 1;
        goto L12
    L17:
        return r5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r5) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public FragmentStateAdapter(@NonNull Fragment r5) {
        this(r5.getChildFragmentManager(), r5.getLifecycle());
    }

    public final void onBindViewHolder(@NonNull final FragmentViewHolder r10, int r11) {
        long r5 = r10.getItemId();
        int r12 = r10.getContainer().getId();
        Long r13 = itemForViewHolder(r12);
        if (r13 != null) goto L5;
    L7:
        this.mItemIdToViewHolder.put(r5, Integer.valueOf(r12));
        ensureFragment(r11);
        final FrameLayout r14 = r10.getContainer();
        if (ViewCompat.isAttachedToWindow(r14) == true) goto L10;
    L14:
        gcFragments();
        return;
    L10:
        if (r14.getParent() != null) goto L13;
        r14.addOnLayoutChangeListener(new AnonymousClass1(this, r14, r10));
        goto L14
    L13:
        throw new IllegalStateException("Design assumption violated.");
    L5:
        if (r13.longValue() == r5) goto L7;
        removeFragment(r13.longValue());
        this.mItemIdToViewHolder.remove(r13.longValue());
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup r5, int r10) {
        return FragmentViewHolder.create(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder r5) {
        return onFailedToRecycleView((FragmentViewHolder) r5);
    }

    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder r5) {
        placeFragmentInViewHolder(r5);
        gcFragments();
    }

    public final void onViewRecycled(@NonNull FragmentViewHolder r5) {
        Long r10 = itemForViewHolder(r5.getContainer().getId());
        if (r10 == null) goto L6;
        removeFragment(r10.longValue());
        this.mItemIdToViewHolder.remove(r10.longValue());
        return;
    }

    public FragmentStateAdapter(@NonNull FragmentManager r5, @NonNull Lifecycle r10) {
        this.mFragments = new LongSparseArray();
        this.mSavedStates = new LongSparseArray();
        this.mItemIdToViewHolder = new LongSparseArray();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = r5;
        this.mLifecycle = r10;
        super.setHasStableIds(true);
    }
}
