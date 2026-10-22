package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private RecyclerView.AdapterDataObserver mAdapterObserver;
    int mCachedItemCount;
    final Callback mCallback;

    @NonNull
    private final StableIdStorage.StableIdLookup mStableIdLookup;

    @NonNull
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    public interface Callback {
        void onChanged(@NonNull NestedAdapterWrapper r5);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper r5, int r10, int r11);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper r5, int r10, int r11, @Nullable Object r12);

        void onItemRangeInserted(@NonNull NestedAdapterWrapper r5, int r10, int r11);

        void onItemRangeMoved(@NonNull NestedAdapterWrapper r5, int r10, int r11);

        void onItemRangeRemoved(@NonNull NestedAdapterWrapper r5, int r10, int r11);

        void onStateRestorationPolicyChanged(NestedAdapterWrapper r5);
    }

    public NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> r5, Callback r10, ViewTypeStorage r11, StableIdStorage.StableIdLookup r12) {
        this.mAdapterObserver = new AnonymousClass1(this);
        this.adapter = r5;
        this.mCallback = r10;
        this.mViewTypeLookup = r11.createViewTypeWrapper(this);
        this.mStableIdLookup = r12;
        this.mCachedItemCount = r5.getItemCount();
        r5.registerAdapterDataObserver(this.mAdapterObserver);
    }

    public void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int r5) {
        long r10 = this.adapter.getItemId(r5);
        return this.mStableIdLookup.localToGlobal(r10);
    }

    public int getItemViewType(int r5) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(r5));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r5, int r10) {
        this.adapter.bindViewHolder(r5, r10);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
        int r11 = this.mViewTypeLookup.globalToLocal(r10);
        return this.adapter.onCreateViewHolder(r5, r11);
    }
}
