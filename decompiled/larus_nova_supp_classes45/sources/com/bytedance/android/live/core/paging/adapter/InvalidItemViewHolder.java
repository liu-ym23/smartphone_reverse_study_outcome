package com.bytedance.android.live.core.paging.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class InvalidItemViewHolder extends BaseViewHolder<Object> {
    public final ViewGroup a;

    public InvalidItemViewHolder(ViewGroup r3) {
        super(new View(r3.getContext()));
        this.a = r3;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(Object r3, int r4) {
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(new RecyclerView.LayoutParams(this.a.getMeasuredWidth(), 1));
    }
}
