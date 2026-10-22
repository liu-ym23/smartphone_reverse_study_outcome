package com.bytedance.android.live.core.paging.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class SimplePagingAdapter<T> extends PagingAdapter<T> {
    public final Map<Integer, b90.a> a;
    public Object[] b;

    public SimplePagingAdapter(DiffUtil.ItemCallback<T> r1, Map<Integer, b90.a> r2) {
        super(r1);
        this.a = r2;
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public int getNormalViewType(int r1, T r2) {
        return invalidateType();
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r2, int r3) {
        b90.a r4 = this.a.get(Integer.valueOf(r3));
        if (r4 != null) goto L7;
        return new InvalidItemViewHolder(r2);
    L7:
        return r4.a(r2, this.b);
    }
}
