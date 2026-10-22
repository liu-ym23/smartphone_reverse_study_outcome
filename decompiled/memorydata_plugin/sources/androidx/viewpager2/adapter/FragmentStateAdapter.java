package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
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
import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        /* synthetic */ DataSetChangeObserver(AnonymousClass1 r1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r1, int r2, Object r3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r1, int r2, int r3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r1, int r2) {
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

        FragmentMaxLifecycleEnforcer(FragmentStateAdapter r3) {
            this.this$0 = r3;
            this.mPrimaryItemId = -1;
        }

        private ViewPager2 inferViewPager(RecyclerView r3) {
            ViewParent r2 = r3.getParent();
            if (ZeusTransformUtils.instanceOf(r2, ViewPager2.class) == false) goto L7;
            return (ViewPager2) ZeusTransformUtils.preCheckCast(r2, ViewPager2.class, "com.obric.memorydata.plugin");
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r2);
        }

        void register(RecyclerView r2) {
            this.mViewPager = inferViewPager(r2);
            ViewPager2.OnPageChangeCallback r3 = new AnonymousClass1(this);
            this.mPageChangeCallback = r3;
            this.mViewPager.registerOnPageChangeCallback(r3);
            DataSetChangeObserver r4 = new AnonymousClass2(this);
            this.mDataObserver = r4;
            this.this$0.registerAdapterDataObserver(r4);
            this.mLifecycleObserver = new AnonymousClass3(this);
            this.this$0.mLifecycle.addObserver(this.mLifecycleObserver);
        }

        void unregister(RecyclerView r2) {
            inferViewPager(r2).unregisterOnPageChangeCallback(this.mPageChangeCallback);
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
            int r0 = this.mViewPager.getCurrentItem();
            if (r0 < this.this$0.getItemCount()) goto L16;
            return;
        L16:
            long r1 = this.this$0.getItemId(r0);
            if (r1 != this.mPrimaryItemId) goto L20;
            if (r10 == true) goto L20;
            return;
        L20:
            Fragment r11 = (Fragment) ZeusTransformUtils.preCheckCast(this.this$0.mFragments.get(r1), Fragment.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L23;
            return;
        L23:
            if (r11.isAdded() == false) goto L54;
            this.mPrimaryItemId = r1;
            FragmentTransaction r12 = this.this$0.mFragmentManager.beginTransaction();
            Fragment r2 = null;
            int r3 = 0;
        L27:
            if (r3 >= this.this$0.mFragments.size()) goto L41;
            long r4 = this.this$0.mFragments.keyAt(r3);
            Fragment r6 = (Fragment) ZeusTransformUtils.preCheckCast(this.this$0.mFragments.valueAt(r3), Fragment.class, "com.obric.memorydata.plugin");
            if (r6.isAdded() == false) goto L40;
            if (r4 == this.mPrimaryItemId) goto L34;
            r12.setMaxLifecycle(r6, Lifecycle.State.STARTED);
        L36:
            if (r4 != this.mPrimaryItemId) goto L38;
            boolean r5 = true;
        L39:
            r6.setMenuVisibility(r5);
            goto L40
        L38:
            r5 = false;
            goto L39
        L34:
            r2 = r6;
        L40:
            r3 = r3 + 1;
            goto L27
        L41:
            if (r2 == null) goto L44;
            r12.setMaxLifecycle(r2, Lifecycle.State.RESUMED);
        L44:
            if (r12.isEmpty() == true) goto L52;
            r12.commitNow();
            return;
        L52:
            return;
        L54:
            return;
        }
    }

    public FragmentStateAdapter(Fragment r2) {
        this(r2.getChildFragmentManager(), r2.getLifecycle());
    }

    public FragmentStateAdapter(FragmentActivity r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        this(r4.getSupportFragmentManager(), r4.getLifecycle());
    }

    public FragmentStateAdapter(FragmentManager r2, Lifecycle r3) {
        this.mFragments = new LongSparseArray();
        this.mSavedStates = new LongSparseArray();
        this.mItemIdToViewHolder = new LongSparseArray();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = r2;
        this.mLifecycle = r3;
        super.setHasStableIds(true);
    }

    private static String createKey(String r1, long r2) {
        return r1 + r2;
    }

    private void ensureFragment(int r6) {
        long r0 = getItemId(r6);
        if (this.mFragments.containsKey(r0) == true) goto L6;
        Fragment r7 = createFragment(r6);
        r7.setInitialSavedState((Fragment.SavedState) ZeusTransformUtils.preCheckCast(this.mSavedStates.get(r0), Fragment.SavedState.class, "com.obric.memorydata.plugin"));
        this.mFragments.put(r0, r7);
        return;
    }

    private boolean isFragmentViewBound(long r3) {
        if (this.mItemIdToViewHolder.containsKey(r3) == false) goto L5;
        return true;
    L5:
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.mFragments.get(r3), Fragment.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        return false;
    L8:
        View r4 = r2.getView();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.getParent() == null) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean isValidKey(String r1, String r2) {
        if (r1.startsWith(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.length() <= r2.length()) goto L7;
        return true;
    }

    private Long itemForViewHolder(int r6) {
        Long r0 = null;
        int r1 = 0;
    L4:
        if (r1 >= this.mItemIdToViewHolder.size()) goto L12;
        if (((Integer) ZeusTransformUtils.preCheckCast(this.mItemIdToViewHolder.valueAt(r1), Integer.class, "com.obric.memorydata.plugin")).intValue() != r6) goto L11;
        if (r0 != null) goto L10;
        r0 = Long.valueOf(this.mItemIdToViewHolder.keyAt(r1));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0;
    }

    private static long parseIdFromKey(String r0, String r1) {
        return Long.parseLong(r0.substring(r1.length()));
    }

    private void removeFragment(long r5) {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.mFragments.get(r5), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getView() == null) goto L11;
        ViewParent r1 = r0.getView().getParent();
        if (r1 == null) goto L11;
        ((FrameLayout) ZeusTransformUtils.preCheckCast(r1, FrameLayout.class, "com.obric.memorydata.plugin")).removeAllViews();
    L11:
        if (containsItem(r5) == true) goto L14;
        this.mSavedStates.remove(r5);
    L14:
        if (r0.isAdded() == true) goto L18;
        this.mFragments.remove(r5);
        return;
    L18:
        if (shouldDelayFragmentTransactions() == false) goto L22;
        this.mHasStaleFragments = true;
        return;
    L22:
        if (r0.isAdded() == true) goto L24;
    L26:
        this.mFragmentManager.beginTransaction().remove(r0).commitNow();
        this.mFragments.remove(r5);
        return;
    L24:
        if (containsItem(r5) == false) goto L26;
        this.mSavedStates.put(r5, this.mFragmentManager.saveFragmentInstanceState(r0));
        goto L26
    }

    private void scheduleGracePeriodEnd() {
        final Handler r0 = new Handler(Looper.getMainLooper());
        final Runnable r1 = new AnonymousClass4(this);
        this.mLifecycle.addObserver(new AnonymousClass5(this, r0, r1));
        r0.postDelayed(r1, 10000);
    }

    private void scheduleViewAttach(final Fragment r3, final FrameLayout r4) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new AnonymousClass3(this, r3, r4), false);
    }

    void addViewToContainer(View r3, FrameLayout r4) {
        if (r4.getChildCount() > 1) goto L16;
        if (r3.getParent() != r4) goto L8;
        return;
    L8:
        if (r4.getChildCount() <= 0) goto L11;
        r4.removeAllViews();
    L11:
        if (r3.getParent() == null) goto L13;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r3.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r3);
    L13:
        r4.addView(r3);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r3 >= getItemCount()) goto L7;
        return true;
    }

    public abstract Fragment createFragment(int r1);

    void gcFragments() {
        if (this.mHasStaleFragments == true) goto L5;
        return;
    L5:
        if (shouldDelayFragmentTransactions() == true) goto L35;
        ArraySet r0 = new ArraySet();
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= this.mFragments.size()) goto L15;
        long r3 = this.mFragments.keyAt(r2);
        if (containsItem(r3) == true) goto L13;
        r0.add(Long.valueOf(r3));
        this.mItemIdToViewHolder.remove(r3);
    L13:
        r2 = r2 + 1;
        goto L9
    L15:
        if (this.mIsInGracePeriod == true) goto L23;
        this.mHasStaleFragments = false;
    L18:
        if (r1 >= this.mFragments.size()) goto L23;
        long r4 = this.mFragments.keyAt(r1);
        if (isFragmentViewBound(r4) == true) goto L22;
        r0.add(Long.valueOf(r4));
    L22:
        r1 = r1 + 1;
    L23:
        Iterator<E> r5 = r0.iterator();
    L25:
        if (r5.hasNext() == false) goto L36;
        removeFragment(((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L25
    L36:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r2) {
        if (this.mFragmentMaxLifecycleEnforcer != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        FragmentMaxLifecycleEnforcer r1 = new FragmentMaxLifecycleEnforcer(this);
        this.mFragmentMaxLifecycleEnforcer = r1;
        r1.register(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        onBindViewHolder((FragmentViewHolder) ZeusTransformUtils.preCheckCast(r3, FragmentViewHolder.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void onBindViewHolder(final FragmentViewHolder r8, int r9) {
        long r0 = r8.getItemId();
        int r2 = r8.getContainer().getId();
        Long r3 = itemForViewHolder(r2);
        if (r3 != null) goto L5;
    L7:
        this.mItemIdToViewHolder.put(r0, Integer.valueOf(r2));
        ensureFragment(r9);
        final FrameLayout r10 = r8.getContainer();
        if (ViewCompat.isAttachedToWindow(r10) == true) goto L10;
    L14:
        gcFragments();
        return;
    L10:
        if (r10.getParent() != null) goto L13;
        r10.addOnLayoutChangeListener(new AnonymousClass1(this, r10, r8));
        goto L14
    L13:
        throw new IllegalStateException("Design assumption violated.");
    L5:
        if (r3.longValue() == r0) goto L7;
        removeFragment(r3.longValue());
        this.mItemIdToViewHolder.remove(r3.longValue());
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final FragmentViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return FragmentViewHolder.create(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView r2) {
        this.mFragmentMaxLifecycleEnforcer.unregister(r2);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder r3) {
        return onFailedToRecycleView((FragmentViewHolder) ZeusTransformUtils.preCheckCast(r3, FragmentViewHolder.class, "com.obric.memorydata.plugin"));
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder r1) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        onViewAttachedToWindow((FragmentViewHolder) ZeusTransformUtils.preCheckCast(r3, FragmentViewHolder.class, "com.obric.memorydata.plugin"));
    }

    public final void onViewAttachedToWindow(FragmentViewHolder r1) {
        placeFragmentInViewHolder(r1);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r3) {
        onViewRecycled((FragmentViewHolder) ZeusTransformUtils.preCheckCast(r3, FragmentViewHolder.class, "com.obric.memorydata.plugin"));
    }

    public final void onViewRecycled(FragmentViewHolder r3) {
        Long r4 = itemForViewHolder(r3.getContainer().getId());
        if (r4 == null) goto L6;
        removeFragment(r4.longValue());
        this.mItemIdToViewHolder.remove(r4.longValue());
        return;
    }

    void placeFragmentInViewHolder(final FragmentViewHolder r6) {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.mFragments.get(r6.getItemId()), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L36;
        FrameLayout r2 = r6.getContainer();
        View r3 = r0.getView();
        if (r0.isAdded() == true) goto L11;
        if (r3 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r0.isAdded() == false) goto L16;
        if (r3 != null) goto L16;
        scheduleViewAttach(r0, r2);
        return;
    L16:
        if (r0.isAdded() == false) goto L24;
        if (r3.getParent() == null) goto L24;
        if (r3.getParent() == r2) goto L37;
        addViewToContainer(r3, r2);
        return;
    L37:
        return;
    L24:
        if (r0.isAdded() == false) goto L28;
        addViewToContainer(r3, r2);
        return;
    L28:
        if (shouldDelayFragmentTransactions() == true) goto L31;
        scheduleViewAttach(r0, r2);
        this.mFragmentManager.beginTransaction().add(r0, f.f1488a + r6.getItemId()).setMaxLifecycle(r0, Lifecycle.State.STARTED).commitNow();
        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
        return;
    L31:
        if (this.mFragmentManager.isDestroyed() == false) goto L33;
        return;
    L33:
        this.mLifecycle.addObserver(new AnonymousClass2(this, r6));
        return;
    L36:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(Parcelable r7) {
        Parcelable r8 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.memorydata.plugin");
        if (this.mSavedStates.isEmpty() == false) goto L28;
        if (this.mFragments.isEmpty() == false) goto L28;
        Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin");
        if (r9.getClassLoader() != null) goto L9;
        r9.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r0 = r9.keySet().iterator();
    L11:
        if (r0.hasNext() == false) goto L24;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (isValidKey(r2, KEY_PREFIX_FRAGMENT) == true) goto L14;
        if (isValidKey(r2, KEY_PREFIX_STATE) == false) goto L22;
        long r3 = parseIdFromKey(r2, KEY_PREFIX_STATE);
        Object r4 = (Fragment.SavedState) ZeusTransformUtils.preCheckCast(r9.getParcelable(r2), Fragment.SavedState.class, "com.obric.memorydata.plugin");
        if (containsItem(r3) == false) goto L11;
        LongSparseArray r5 = this.mSavedStates;
    L15:
        r5.put(r3, r4);
        goto L11
    L22:
        throw new IllegalArgumentException("Unexpected key in savedState: " + r2);
    L14:
        r3 = parseIdFromKey(r2, KEY_PREFIX_FRAGMENT);
        r4 = this.mFragmentManager.getFragment(r9, r2);
        r5 = this.mFragments;
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
    public final Parcelable saveState() {
        Bundle r0 = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.mFragments.size()) goto L12;
        long r5 = this.mFragments.keyAt(r2);
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(this.mFragments.get(r5), Fragment.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        if (r3.isAdded() == false) goto L10;
        this.mFragmentManager.putFragment(r0, createKey(KEY_PREFIX_FRAGMENT, r5), r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (r1 >= this.mSavedStates.size()) goto L17;
        long r4 = this.mSavedStates.keyAt(r1);
        if (containsItem(r4) == false) goto L16;
        r0.putParcelable(createKey(KEY_PREFIX_STATE, r4), (Parcelable) ZeusTransformUtils.preCheckCast(this.mSavedStates.get(r4), Parcelable.class, "com.obric.memorydata.plugin"));
    L16:
        r1 = r1 + 1;
        goto L12
    L17:
        return r0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r1) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }
}
