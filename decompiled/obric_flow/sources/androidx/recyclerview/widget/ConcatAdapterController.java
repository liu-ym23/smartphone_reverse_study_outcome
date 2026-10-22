package androidx.recyclerview.widget;

import ai.j0;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ConcatAdapterController implements NestedAdapterWrapper.Callback {
    private List<WeakReference<RecyclerView>> mAttachedRecyclerViews;
    private final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> mBinderLookup;
    private final ConcatAdapter mConcatAdapter;
    private WrapperAndLocalPosition mReusableHolder;

    @NonNull
    private final ConcatAdapter.Config.StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private List<NestedAdapterWrapper> mWrappers;

    public static class WrapperAndLocalPosition {
        boolean mInUse;
        int mLocalPosition;
        NestedAdapterWrapper mWrapper;

        public WrapperAndLocalPosition() {
        }
    }

    public ConcatAdapterController(ConcatAdapter r5, ConcatAdapter.Config r10) {
        this.mAttachedRecyclerViews = new ArrayList();
        this.mBinderLookup = new IdentityHashMap();
        this.mWrappers = new ArrayList();
        this.mReusableHolder = new WrapperAndLocalPosition();
        this.mConcatAdapter = r5;
        if (r10.isolateViewTypes == false) goto L5;
        this.mViewTypeStorage = new ViewTypeStorage.IsolatedViewTypeStorage();
    L6:
        ConcatAdapter.Config.StableIdMode r11 = r10.stableIdMode;
        this.mStableIdMode = r11;
        if (r11 != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L10;
        this.mStableIdStorage = new StableIdStorage.NoStableIdStorage();
        return;
    L10:
        if (r11 != ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) goto L13;
        this.mStableIdStorage = new StableIdStorage.IsolatedStableIdStorage();
        return;
    L13:
        if (r11 != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) goto L17;
        this.mStableIdStorage = new StableIdStorage.SharedPoolStableIdStorage();
        return;
    L17:
        throw new IllegalArgumentException("unknown stable id mode");
    L5:
        this.mViewTypeStorage = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        goto L6
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        RecyclerView.Adapter.StateRestorationPolicy r5 = computeStateRestorationPolicy();
        if (r5 == this.mConcatAdapter.getStateRestorationPolicy()) goto L6;
        this.mConcatAdapter.internalSetStateRestorationPolicy(r5);
        return;
    }

    private RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy() {
        Iterator<NestedAdapterWrapper> r5 = this.mWrappers.iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        NestedAdapterWrapper r10 = r5.next();
        RecyclerView.Adapter.StateRestorationPolicy r11 = r10.adapter.getStateRestorationPolicy();
        RecyclerView.Adapter.StateRestorationPolicy r12 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
        if (r11 == r12) goto L7;
        if (r11 != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) goto L4;
        if (r10.getCachedItemCount() != 0) goto L4;
        return r12;
    L7:
        return r12;
    L14:
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int countItemsBefore(NestedAdapterWrapper r5) {
        Iterator<NestedAdapterWrapper> r10 = this.mWrappers.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L8;
        NestedAdapterWrapper r12 = r10.next();
        if (r12 == r5) goto L8;
        r11 = r11 + r12.getCachedItemCount();
    L8:
        return r11;
    }

    @NonNull
    private WrapperAndLocalPosition findWrapperAndLocalPosition(int r5) {
        WrapperAndLocalPosition r10 = this.mReusableHolder;
        if (r10.mInUse == false) goto L5;
        r10 = new WrapperAndLocalPosition();
    L6:
        Iterator<NestedAdapterWrapper> r11 = this.mWrappers.iterator();
        int r12 = r5;
    L8:
        if (r11.hasNext() == false) goto L14;
        NestedAdapterWrapper r13 = r11.next();
        if (r13.getCachedItemCount() > r12) goto L11;
        r12 = r12 - r13.getCachedItemCount();
        goto L8
    L11:
        r10.mWrapper = r13;
        r10.mLocalPosition = r12;
    L14:
        if (r10.mWrapper == null) goto L17;
        return r10;
    L17:
        throw new IllegalArgumentException(j0.g(r5, "Cannot find wrapper for "));
    L5:
        r10.mInUse = true;
        goto L6
    }

    @Nullable
    private NestedAdapterWrapper findWrapperFor(RecyclerView.Adapter<RecyclerView.ViewHolder> r5) {
        int r10 = indexOfWrapper(r5);
        if (r10 != (-1)) goto L7;
        return null;
    L7:
        return this.mWrappers.get(r10);
    }

    @NonNull
    private NestedAdapterWrapper getWrapper(RecyclerView.ViewHolder r5) {
        NestedAdapterWrapper r10 = this.mBinderLookup.get(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r5 + ", seems like it is not bound by this adapter: " + this);
    }

    private int indexOfWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> r5) {
        int r10 = this.mWrappers.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (this.mWrappers.get(r11).adapter == r5) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    private boolean isAttachedTo(RecyclerView r5) {
        Iterator<WeakReference<RecyclerView>> r10 = this.mAttachedRecyclerViews.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r10.next().get() != r5) goto L4;
        return true;
    L9:
        return false;
    }

    private void releaseWrapperAndLocalPosition(WrapperAndLocalPosition r5) {
        r5.mInUse = false;
        r5.mWrapper = null;
        r5.mLocalPosition = -1;
        this.mReusableHolder = r5;
    }

    public boolean addAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r5) {
        return addAdapter(this.mWrappers.size(), r5);
    }

    public boolean canRestoreState() {
        Iterator<NestedAdapterWrapper> r5 = this.mWrappers.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (r5.next().adapter.canRestoreState() == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Nullable
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getBoundAdapter(RecyclerView.ViewHolder r5) {
        NestedAdapterWrapper r10 = this.mBinderLookup.get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.adapter;
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty() == true) goto L5;
        ArrayList r5 = new ArrayList(this.mWrappers.size());
        Iterator<NestedAdapterWrapper> r10 = this.mWrappers.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r5.add(r10.next().adapter);
        goto L8
    L10:
        return r5;
    L5:
        return Collections.emptyList();
    }

    public long getItemId(int r5) {
        WrapperAndLocalPosition r10 = findWrapperAndLocalPosition(r5);
        long r11 = r10.mWrapper.getItemId(r10.mLocalPosition);
        releaseWrapperAndLocalPosition(r10);
        return r11;
    }

    public int getItemViewType(int r5) {
        WrapperAndLocalPosition r10 = findWrapperAndLocalPosition(r5);
        int r11 = r10.mWrapper.getItemViewType(r10.mLocalPosition);
        releaseWrapperAndLocalPosition(r10);
        return r11;
    }

    public int getLocalAdapterPosition(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r5, RecyclerView.ViewHolder r10, int r11) {
        NestedAdapterWrapper r12 = this.mBinderLookup.get(r10);
        if (r12 != null) goto L6;
        return -1;
    L6:
        int r13 = r11 - countItemsBefore(r12);
        int r14 = r12.adapter.getItemCount();
        if (r13 < 0) goto L11;
        if (r13 >= r14) goto L11;
        return r12.adapter.findRelativeAdapterPositionIn(r5, r10, r13);
    L11:
        StringBuilder r15 = j0.v("Detected inconsistent adapter updates. The local position of the view holder maps to ", r13, r14, " which is out of bounds for the adapter with size ", ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        r15.append(r10);
        r15.append("adapter:");
        r15.append(r5);
        throw new IllegalStateException(r15.toString());
    }

    public int getTotalCount() {
        Iterator<NestedAdapterWrapper> r5 = this.mWrappers.iterator();
        int r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r10 = r10 + r5.next().getCachedItemCount();
        goto L4
    L6:
        return r10;
    }

    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int r5) {
        WrapperAndLocalPosition r10 = findWrapperAndLocalPosition(r5);
        Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> r11 = new Pair(r10.mWrapper.adapter, Integer.valueOf(r10.mLocalPosition));
        releaseWrapperAndLocalPosition(r10);
        return r11;
    }

    public boolean hasStableIds() {
        if (this.mStableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L5;
        return true;
    L5:
        return false;
    }

    public void onAttachedToRecyclerView(RecyclerView r5) {
        if (isAttachedTo(r5) == false) goto L5;
        return;
    L5:
        this.mAttachedRecyclerViews.add(new WeakReference(r5));
        Iterator<NestedAdapterWrapper> r10 = this.mWrappers.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().adapter.onAttachedToRecyclerView(r5);
        goto L7
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r5, int r10) {
        WrapperAndLocalPosition r11 = findWrapperAndLocalPosition(r10);
        this.mBinderLookup.put(r5, r11.mWrapper);
        r11.mWrapper.onBindViewHolder(r5, r11.mLocalPosition);
        releaseWrapperAndLocalPosition(r11);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onChanged(@NonNull NestedAdapterWrapper r5) {
        this.mConcatAdapter.notifyDataSetChanged();
        calculateAndUpdateStateRestorationPolicy();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
        return this.mViewTypeStorage.getWrapperForGlobalType(r10).onCreateViewHolder(r5, r10);
    }

    public void onDetachedFromRecyclerView(RecyclerView r5) {
        int r10 = this.mAttachedRecyclerViews.size() - 1;
    L3:
        if (r10 < 0) goto L11;
        WeakReference<RecyclerView> r11 = this.mAttachedRecyclerViews.get(r10);
        if (r11.get() != null) goto L8;
        this.mAttachedRecyclerViews.remove(r10);
    L10:
        r10 = r10 - 1;
        goto L3
    L8:
        if (r11.get() != r5) goto L10;
        this.mAttachedRecyclerViews.remove(r10);
    L11:
        Iterator<NestedAdapterWrapper> r12 = this.mWrappers.iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        r12.next().adapter.onDetachedFromRecyclerView(r5);
        goto L13
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r5) {
        NestedAdapterWrapper r10 = this.mBinderLookup.get(r5);
        if (r10 == null) goto L7;
        boolean r11 = r10.adapter.onFailedToRecycleView(r5);
        this.mBinderLookup.remove(r5);
        return r11;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r5 + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(@NonNull NestedAdapterWrapper r5, int r10, int r11) {
        int r12 = countItemsBefore(r5);
        this.mConcatAdapter.notifyItemRangeChanged(r10 + r12, r11);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeInserted(@NonNull NestedAdapterWrapper r5, int r10, int r11) {
        int r12 = countItemsBefore(r5);
        this.mConcatAdapter.notifyItemRangeInserted(r10 + r12, r11);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeMoved(@NonNull NestedAdapterWrapper r5, int r10, int r11) {
        int r12 = countItemsBefore(r5);
        this.mConcatAdapter.notifyItemMoved(r10 + r12, r11 + r12);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeRemoved(@NonNull NestedAdapterWrapper r5, int r10, int r11) {
        int r12 = countItemsBefore(r5);
        this.mConcatAdapter.notifyItemRangeRemoved(r10 + r12, r11);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onStateRestorationPolicyChanged(NestedAdapterWrapper r5) {
        calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        getWrapper(r5).adapter.onViewAttachedToWindow(r5);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r5) {
        getWrapper(r5).adapter.onViewDetachedFromWindow(r5);
    }

    public void onViewRecycled(RecyclerView.ViewHolder r5) {
        NestedAdapterWrapper r10 = this.mBinderLookup.get(r5);
        if (r10 == null) goto L7;
        r10.adapter.onViewRecycled(r5);
        this.mBinderLookup.remove(r5);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r5 + ", seems like it is not bound by this adapter: " + this);
    }

    public boolean removeAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r5) {
        int r10 = indexOfWrapper(r5);
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        NestedAdapterWrapper r11 = this.mWrappers.get(r10);
        int r12 = countItemsBefore(r11);
        this.mWrappers.remove(r10);
        this.mConcatAdapter.notifyItemRangeRemoved(r12, r11.getCachedItemCount());
        Iterator<WeakReference<RecyclerView>> r13 = this.mAttachedRecyclerViews.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        RecyclerView r14 = r13.next().get();
        if (r14 == null) goto L8;
        r5.onDetachedFromRecyclerView(r14);
        goto L8
    L12:
        r11.dispose();
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }

    public boolean addAdapter(int r5, RecyclerView.Adapter<RecyclerView.ViewHolder> r10) {
        if (r5 < 0) goto L27;
        if (r5 > this.mWrappers.size()) goto L27;
        if (hasStableIds() == false) goto L9;
        Preconditions.checkArgument(r10.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
    L12:
        if (findWrapperFor(r10) == null) goto L15;
        return false;
    L15:
        NestedAdapterWrapper r11 = new NestedAdapterWrapper(r10, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
        this.mWrappers.add(r5, r11);
        Iterator<WeakReference<RecyclerView>> r12 = this.mAttachedRecyclerViews.iterator();
    L17:
        if (r12.hasNext() == false) goto L22;
        RecyclerView r13 = r12.next().get();
        if (r13 == null) goto L17;
        r10.onAttachedToRecyclerView(r13);
        goto L17
    L22:
        if (r11.getCachedItemCount() <= 0) goto L24;
        this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(r11), r11.getCachedItemCount());
    L24:
        calculateAndUpdateStateRestorationPolicy();
        return true;
    L9:
        if (r10.hasStableIds() == false) goto L12;
        Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
    L27:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + this.mWrappers.size() + ". Given:" + r5);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(@NonNull NestedAdapterWrapper r5, int r10, int r11, @Nullable Object r12) {
        int r13 = countItemsBefore(r5);
        this.mConcatAdapter.notifyItemRangeChanged(r10 + r13, r11, r12);
    }
}
