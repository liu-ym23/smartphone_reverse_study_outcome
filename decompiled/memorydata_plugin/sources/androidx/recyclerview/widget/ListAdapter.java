package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    public ListAdapter(AsyncDifferConfig<T> r4) {
        AsyncListDiffer.ListListener<T> r0 = new AnonymousClass1(this);
        this.mListener = r0;
        AsyncListDiffer<T> r1 = new AsyncListDiffer(new AdapterListUpdateCallback(this), r4);
        this.mDiffer = r1;
        r1.addListListener(r0);
    }

    public ListAdapter(DiffUtil.ItemCallback<T> r5) {
        AsyncListDiffer.ListListener<T> r0 = new AnonymousClass1(this);
        this.mListener = r0;
        AsyncListDiffer<T> r1 = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(r5).build());
        this.mDiffer = r1;
        r1.addListListener(r0);
    }

    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    public T getItem(int r1) {
        return this.mDiffer.getCurrentList().get(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(List<T> r2, List<T> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void submitList(List<T> r3) {
        List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.mDiffer.submitList(r4);
    }

    public void submitList(List<T> r3, Runnable r4) {
        List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.mDiffer.submitList(r5, r6);
    }
}
