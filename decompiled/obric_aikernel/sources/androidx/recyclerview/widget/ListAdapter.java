package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    protected ListAdapter(@NonNull AsyncDifferConfig<T> r10) {
        AsyncListDiffer.ListListener<T> r11 = (AsyncListDiffer.ListListener<T>) new AnonymousClass1(this);
        this.mListener = r11;
        AsyncListDiffer<T> r12 = new AsyncListDiffer(new AdapterListUpdateCallback(this), r10);
        this.mDiffer = r12;
        r12.addListListener(r11);
    }

    protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> r10) {
        AsyncListDiffer.ListListener<T> r11 = (AsyncListDiffer.ListListener<T>) new AnonymousClass1(this);
        this.mListener = r11;
        AsyncListDiffer<T> r12 = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(r10).build());
        this.mDiffer = r12;
        r12.addListListener(r11);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    protected T getItem(int r10) {
        return this.mDiffer.getCurrentList().get(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> r10, @NonNull List<T> r11) {
    }

    public void submitList(@Nullable List<T> r10) {
        this.mDiffer.submitList(r10);
    }

    public void submitList(@Nullable List<T> r10, @Nullable Runnable r11) {
        this.mDiffer.submitList(r10, r11);
    }
}
