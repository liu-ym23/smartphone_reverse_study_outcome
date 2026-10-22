package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter r5) {
        this.mAdapter = r5;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int r5, int r10, Object r11) {
        this.mAdapter.notifyItemRangeChanged(r5, r10, r11);
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
}
