package com.bytedance.android.live.core.paging.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class DelegatePagingAdapter<T> extends PagingAdapter<T> {
    public final Delegate a;

    public interface Delegate<V> {
        boolean areContentsTheSame(V r1, V r2);

        boolean areItemsTheSame(V r1, V r2);

        int getEmptyResId();

        int getViewType(int r1, V r2);

        void onBindViewHolder(RecyclerView.ViewHolder r1, int r2, V r3);

        RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2);

        void setPayload(Object... r1);
    }

    public static class a<T> extends DiffUtil.ItemCallback<T> {
        public final Delegate<T> a;

        public a(Delegate<T> r1) {
            this.a = r1;
        }

        public final boolean areContentsTheSame(T r2, T r3) {
            return this.a.areContentsTheSame(r2, r3);
        }

        public final boolean areItemsTheSame(T r2, T r3) {
            return this.a.areItemsTheSame(r2, r3);
        }
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final int getEmptyResId() {
        if (this.a.getEmptyResId() != 0) goto L7;
        return super.getEmptyResId();
    L7:
        return this.a.getEmptyResId();
    }

    public DelegatePagingAdapter(Delegate<T> r2) {
        super(new a(r2));
        this.a = r2;
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final int getNormalViewType(int r2, T r3) {
        return this.a.getViewType(r2, r3);
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final void onBindNormalViewHolder(RecyclerView.ViewHolder r3, int r4) {
        this.a.onBindViewHolder(r3, r4, getItem(r4));
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r2, int r3) {
        return this.a.onCreateViewHolder(r2, r3);
    }
}
