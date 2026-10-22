package androidx.recyclerview.widget;

import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private final ConcatAdapter.Config.StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private List<NestedAdapterWrapper> mWrappers;

    static class WrapperAndLocalPosition {
        boolean mInUse;
        int mLocalPosition;
        NestedAdapterWrapper mWrapper;

        WrapperAndLocalPosition() {
        }
    }

    ConcatAdapterController(ConcatAdapter r2, ConcatAdapter.Config r3) {
        this.mAttachedRecyclerViews = new ArrayList();
        this.mBinderLookup = new IdentityHashMap();
        this.mWrappers = new ArrayList();
        this.mReusableHolder = new WrapperAndLocalPosition();
        this.mConcatAdapter = r2;
        if (r3.isolateViewTypes == false) goto L5;
        ViewTypeStorage r4 = new ViewTypeStorage.IsolatedViewTypeStorage();
    L6:
        this.mViewTypeStorage = r4;
        this.mStableIdMode = r3.stableIdMode;
        if (r3.stableIdMode != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L11;
        StableIdStorage r5 = new StableIdStorage.NoStableIdStorage();
    L9:
        this.mStableIdStorage = r5;
        return;
    L11:
        if (r3.stableIdMode != ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) goto L14;
        r5 = new StableIdStorage.IsolatedStableIdStorage();
        goto L9
    L14:
        if (r3.stableIdMode != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) goto L18;
        r5 = new StableIdStorage.SharedPoolStableIdStorage();
        goto L9
    L18:
        throw new IllegalArgumentException("unknown stable id mode");
    L5:
        r4 = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        goto L6
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        RecyclerView.Adapter.StateRestorationPolicy r0 = computeStateRestorationPolicy();
        if (r0 == this.mConcatAdapter.getStateRestorationPolicy()) goto L6;
        this.mConcatAdapter.internalSetStateRestorationPolicy(r0);
        return;
    }

    private RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy() {
        Iterator<NestedAdapterWrapper> r3 = this.mWrappers.iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        NestedAdapterWrapper r0 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r3.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        RecyclerView.Adapter.StateRestorationPolicy r1 = r0.adapter.getStateRestorationPolicy();
        if (r1 == RecyclerView.Adapter.StateRestorationPolicy.PREVENT) goto L8;
        if (r1 != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) goto L4;
        if (r0.getCachedItemCount() != 0) goto L4;
        return RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
    L8:
        return RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
    L16:
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int countItemsBefore(NestedAdapterWrapper r5) {
        Iterator<NestedAdapterWrapper> r4 = this.mWrappers.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L8;
        NestedAdapterWrapper r1 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r4.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        if (r1 == r5) goto L8;
        r0 = r0 + r1.getCachedItemCount();
    L8:
        return r0;
    }

    private WrapperAndLocalPosition findWrapperAndLocalPosition(int r6) {
        if (this.mReusableHolder.mInUse == false) goto L5;
        WrapperAndLocalPosition r0 = new WrapperAndLocalPosition();
    L6:
        Iterator<NestedAdapterWrapper> r5 = this.mWrappers.iterator();
        int r1 = r6;
    L8:
        if (r5.hasNext() == false) goto L14;
        NestedAdapterWrapper r2 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r5.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        if (r2.getCachedItemCount() > r1) goto L11;
        r1 = r1 - r2.getCachedItemCount();
        goto L8
    L11:
        r0.mWrapper = r2;
        r0.mLocalPosition = r1;
    L14:
        if (r0.mWrapper == null) goto L17;
        return r0;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r6);
    L5:
        this.mReusableHolder.mInUse = true;
        r0 = this.mReusableHolder;
        goto L6
    }

    private NestedAdapterWrapper findWrapperFor(RecyclerView.Adapter<RecyclerView.ViewHolder> r2) {
        int r3 = indexOfWrapper(r2);
        if (r3 != (-1)) goto L7;
        return null;
    L7:
        return (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mWrappers.get(r3), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
    }

    private NestedAdapterWrapper getWrapper(RecyclerView.ViewHolder r4) {
        NestedAdapterWrapper r0 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mBinderLookup.get(r4), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    private int indexOfWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> r6) {
        int r0 = this.mWrappers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (((NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mWrappers.get(r1), NestedAdapterWrapper.class, "com.obric.memorydata.plugin")).adapter == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private boolean isAttachedTo(RecyclerView r4) {
        Iterator<WeakReference<RecyclerView>> r3 = this.mAttachedRecyclerViews.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get() != r4) goto L4;
        return true;
    L9:
        return false;
    }

    private void releaseWrapperAndLocalPosition(WrapperAndLocalPosition r2) {
        r2.mInUse = false;
        r2.mWrapper = null;
        r2.mLocalPosition = -1;
        this.mReusableHolder = r2;
    }

    boolean addAdapter(int r5, RecyclerView.Adapter<RecyclerView.ViewHolder> r6) {
        if (r5 < 0) goto L27;
        if (r5 > this.mWrappers.size()) goto L27;
        if (hasStableIds() == false) goto L9;
        Preconditions.checkArgument(r6.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
    L12:
        if (findWrapperFor(r6) == null) goto L15;
        return false;
    L15:
        NestedAdapterWrapper r0 = new NestedAdapterWrapper(r6, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
        this.mWrappers.add(r5, r0);
        Iterator<WeakReference<RecyclerView>> r7 = this.mAttachedRecyclerViews.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r7.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        r6.onAttachedToRecyclerView(r1);
        goto L17
    L22:
        if (r0.getCachedItemCount() <= 0) goto L24;
        this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(r0), r0.getCachedItemCount());
    L24:
        calculateAndUpdateStateRestorationPolicy();
        return true;
    L9:
        if (r6.hasStableIds() == false) goto L12;
        Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
    L27:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + this.mWrappers.size() + ". Given:" + r5);
    }

    boolean addAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r2) {
        return addAdapter(this.mWrappers.size(), r2);
    }

    public boolean canRestoreState() {
        Iterator<NestedAdapterWrapper> r3 = this.mWrappers.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r3.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin")).adapter.canRestoreState() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getBoundAdapter(RecyclerView.ViewHolder r2) {
        NestedAdapterWrapper r1 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mBinderLookup.get(r2), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.adapter;
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList(this.mWrappers.size());
        Iterator<NestedAdapterWrapper> r4 = this.mWrappers.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(((NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r4.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin")).adapter);
        goto L8
    L10:
        return r0;
    L5:
        return Collections.emptyList();
    }

    public long getItemId(int r3) {
        WrapperAndLocalPosition r4 = findWrapperAndLocalPosition(r3);
        long r0 = r4.mWrapper.getItemId(r4.mLocalPosition);
        releaseWrapperAndLocalPosition(r4);
        return r0;
    }

    public int getItemViewType(int r3) {
        WrapperAndLocalPosition r4 = findWrapperAndLocalPosition(r3);
        int r0 = r4.mWrapper.getItemViewType(r4.mLocalPosition);
        releaseWrapperAndLocalPosition(r4);
        return r0;
    }

    public int getLocalAdapterPosition(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r4, RecyclerView.ViewHolder r5, int r6) {
        NestedAdapterWrapper r0 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mBinderLookup.get(r5), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r7 = r6 - countItemsBefore(r0);
        int r3 = r0.adapter.getItemCount();
        if (r7 < 0) goto L12;
        if (r7 >= r3) goto L12;
        return r0.adapter.findRelativeAdapterPositionIn(r4, r5, r7);
    L12:
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + r7 + " which is out of bounds for the adapter with size " + r3 + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + r5 + "adapter:" + r4);
    }

    public int getTotalCount() {
        Iterator<NestedAdapterWrapper> r4 = this.mWrappers.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r4.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin")).getCachedItemCount();
        goto L4
    L6:
        return r0;
    }

    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int r4) {
        WrapperAndLocalPosition r5 = findWrapperAndLocalPosition(r4);
        Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> r0 = new Pair(r5.mWrapper.adapter, Integer.valueOf(r5.mLocalPosition));
        releaseWrapperAndLocalPosition(r5);
        return r0;
    }

    public boolean hasStableIds() {
        if (this.mStableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L5;
        return true;
    L5:
        return false;
    }

    public void onAttachedToRecyclerView(RecyclerView r4) {
        if (isAttachedTo(r4) == false) goto L5;
        return;
    L5:
        this.mAttachedRecyclerViews.add(new WeakReference(r4));
        Iterator<NestedAdapterWrapper> r3 = this.mWrappers.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r3.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin")).adapter.onAttachedToRecyclerView(r4);
        goto L7
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        WrapperAndLocalPosition r5 = findWrapperAndLocalPosition(r4);
        this.mBinderLookup.put(r3, r5.mWrapper);
        r5.mWrapper.onBindViewHolder(r3, r5.mLocalPosition);
        releaseWrapperAndLocalPosition(r5);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onChanged(NestedAdapterWrapper r1) {
        this.mConcatAdapter.notifyDataSetChanged();
        calculateAndUpdateStateRestorationPolicy();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return this.mViewTypeStorage.getWrapperForGlobalType(r2).onCreateViewHolder(r1, r2);
    }

    public void onDetachedFromRecyclerView(RecyclerView r5) {
        int r0 = this.mAttachedRecyclerViews.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L12;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mAttachedRecyclerViews.get(r0), WeakReference.class, "com.obric.memorydata.plugin");
        if (r2.get() != null) goto L9;
        this.mAttachedRecyclerViews.remove(r0);
        goto L3
    L9:
        if (r2.get() != r5) goto L3;
        this.mAttachedRecyclerViews.remove(r0);
    L12:
        Iterator<NestedAdapterWrapper> r4 = this.mWrappers.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        ((NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(r4.next(), NestedAdapterWrapper.class, "com.obric.memorydata.plugin")).adapter.onDetachedFromRecyclerView(r5);
        goto L14
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r4) {
        NestedAdapterWrapper r0 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mBinderLookup.get(r4), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        boolean r1 = r0.adapter.onFailedToRecycleView(r4);
        this.mBinderLookup.remove(r4);
        return r1;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(NestedAdapterWrapper r1, int r2, int r3) {
        int r4 = countItemsBefore(r1);
        this.mConcatAdapter.notifyItemRangeChanged(r2 + r4, r3);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(NestedAdapterWrapper r1, int r2, int r3, Object r4) {
        int r5 = countItemsBefore(r1);
        this.mConcatAdapter.notifyItemRangeChanged(r2 + r5, r3, r4);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeInserted(NestedAdapterWrapper r1, int r2, int r3) {
        int r4 = countItemsBefore(r1);
        this.mConcatAdapter.notifyItemRangeInserted(r2 + r4, r3);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeMoved(NestedAdapterWrapper r1, int r2, int r3) {
        int r4 = countItemsBefore(r1);
        this.mConcatAdapter.notifyItemMoved(r2 + r4, r3 + r4);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeRemoved(NestedAdapterWrapper r1, int r2, int r3) {
        int r4 = countItemsBefore(r1);
        this.mConcatAdapter.notifyItemRangeRemoved(r2 + r4, r3);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onStateRestorationPolicyChanged(NestedAdapterWrapper r1) {
        calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        getWrapper(r1).adapter.onViewAttachedToWindow(r1);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        getWrapper(r1).adapter.onViewDetachedFromWindow(r1);
    }

    public void onViewRecycled(RecyclerView.ViewHolder r4) {
        NestedAdapterWrapper r0 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mBinderLookup.get(r4), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.adapter.onViewRecycled(r4);
        this.mBinderLookup.remove(r4);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    boolean removeAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r6) {
        int r0 = indexOfWrapper(r6);
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        NestedAdapterWrapper r1 = (NestedAdapterWrapper) ZeusTransformUtils.preCheckCast(this.mWrappers.get(r0), NestedAdapterWrapper.class, "com.obric.memorydata.plugin");
        int r2 = countItemsBefore(r1);
        this.mWrappers.remove(r0);
        this.mConcatAdapter.notifyItemRangeRemoved(r2, r1.getCachedItemCount());
        Iterator<WeakReference<RecyclerView>> r3 = this.mAttachedRecyclerViews.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        RecyclerView r4 = (RecyclerView) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        r6.onDetachedFromRecyclerView(r4);
        goto L8
    L12:
        r1.dispose();
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }
}
