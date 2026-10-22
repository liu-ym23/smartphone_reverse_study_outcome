package com.bytedance.android.live.core.widget.simple;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class SimpleViewHolderType<F extends T, T> extends ViewHolderType<T> {
    public abstract void bind(SimpleViewHolder r1, F r2, int r3);

    public abstract int getLayoutResId();

    public void unBind(SimpleViewHolder r1, F r2) {
    }

    public SimpleViewHolderType() {
    }

    @Override // com.bytedance.android.live.core.widget.simple.ViewHolderType
    public RecyclerView.ViewHolder create(ViewGroup r5) {
        return new SimpleViewHolder(LayoutInflater.from(r5.getContext()).inflate(getLayoutResId(), r5, false));
    }
}
