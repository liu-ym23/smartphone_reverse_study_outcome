package androidx.recyclerview.widget;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter<?> mAdapter;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter<?> r5) {
        this.mAdapter = r5;
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback
    public void onChanged(int r5, int r10) {
        this.mAdapter.notifyItemRangeChanged(r5, r10);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r5, int r10) {
        this.mAdapter.notifyItemRangeInserted(r5, r10);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r5, int r10) {
        this.mAdapter.notifyItemMoved(r5, r10);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r5, int r10) {
        this.mAdapter.notifyItemRangeRemoved(r5, r10);
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int r5, int r10, Object r11) {
        this.mAdapter.notifyItemRangeChanged(r5, r10, r11);
    }
}
