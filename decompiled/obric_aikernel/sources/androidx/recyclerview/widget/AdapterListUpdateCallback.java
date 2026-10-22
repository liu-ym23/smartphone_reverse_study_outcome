package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter r10) {
        this.mAdapter = r10;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r10, int r11, Object r12) {
        this.mAdapter.notifyItemRangeChanged(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r10, int r11) {
        this.mAdapter.notifyItemRangeInserted(r10, r11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r10, int r11) {
        this.mAdapter.notifyItemMoved(r10, r11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r10, int r11) {
        this.mAdapter.notifyItemRangeRemoved(r10, r11);
    }
}
