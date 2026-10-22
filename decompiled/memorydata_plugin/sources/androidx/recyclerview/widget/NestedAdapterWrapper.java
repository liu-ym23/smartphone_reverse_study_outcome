package androidx.recyclerview.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private RecyclerView.AdapterDataObserver mAdapterObserver;
    int mCachedItemCount;
    final Callback mCallback;
    private final StableIdStorage.StableIdLookup mStableIdLookup;
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    interface Callback {
        void onChanged(NestedAdapterWrapper r1);

        void onItemRangeChanged(NestedAdapterWrapper r1, int r2, int r3);

        void onItemRangeChanged(NestedAdapterWrapper r1, int r2, int r3, Object r4);

        void onItemRangeInserted(NestedAdapterWrapper r1, int r2, int r3);

        void onItemRangeMoved(NestedAdapterWrapper r1, int r2, int r3);

        void onItemRangeRemoved(NestedAdapterWrapper r1, int r2, int r3);

        void onStateRestorationPolicyChanged(NestedAdapterWrapper r1);
    }

    NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> r3, Callback r4, ViewTypeStorage r5, StableIdStorage.StableIdLookup r6) {
        Callback r7 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        ViewTypeStorage r8 = (ViewTypeStorage) ZeusTransformUtils.wrapperContextForParams(r5, ViewTypeStorage.class, "com.obric.memorydata.plugin");
        StableIdStorage.StableIdLookup r9 = (StableIdStorage.StableIdLookup) ZeusTransformUtils.wrapperContextForParams(r6, StableIdStorage.StableIdLookup.class, "com.obric.memorydata.plugin");
        this.mAdapterObserver = new AnonymousClass1(this);
        this.adapter = r3;
        this.mCallback = r7;
        this.mViewTypeLookup = r8.createViewTypeWrapper(this);
        this.mStableIdLookup = r9;
        this.mCachedItemCount = r3.getItemCount();
        r3.registerAdapterDataObserver(this.mAdapterObserver);
    }

    void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int r3) {
        long r0 = this.adapter.getItemId(r3);
        return this.mStableIdLookup.localToGlobal(r0);
    }

    int getItemViewType(int r2) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(r2));
    }

    void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        this.adapter.bindViewHolder(r1, r2);
    }

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        int r4 = this.mViewTypeLookup.globalToLocal(r3);
        return this.adapter.onCreateViewHolder(r2, r4);
    }
}
