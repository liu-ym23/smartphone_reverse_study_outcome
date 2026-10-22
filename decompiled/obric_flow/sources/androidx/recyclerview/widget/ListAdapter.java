package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    public ListAdapter(@NonNull DiffUtil.ItemCallback<T> r5) {
        AsyncListDiffer.ListListener<T> r10 = new AnonymousClass1(this);
        this.mListener = r10;
        AsyncListDiffer<T> r11 = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(r5).build());
        this.mDiffer = r11;
        r11.addListListener(r10);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    public T getItem(int r5) {
        return this.mDiffer.getCurrentList().get(r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> r5, @NonNull List<T> r10) {
    }

    public void submitList(@Nullable List<T> r5) {
        this.mDiffer.submitList(r5);
    }

    public void submitList(@Nullable List<T> r5, @Nullable Runnable r10) {
        this.mDiffer.submitList(r5, r10);
    }

    public ListAdapter(@NonNull AsyncDifferConfig<T> r5) {
        AsyncListDiffer.ListListener<T> r10 = new AnonymousClass1(this);
        this.mListener = r10;
        AsyncListDiffer<T> r11 = new AsyncListDiffer(new AdapterListUpdateCallback(this), r5);
        this.mDiffer = r11;
        r11.addListListener(r10);
    }
}
