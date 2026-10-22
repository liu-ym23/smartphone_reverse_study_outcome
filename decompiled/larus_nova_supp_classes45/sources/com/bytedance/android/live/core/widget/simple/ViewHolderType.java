package com.bytedance.android.live.core.widget.simple;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class ViewHolderType<T> {
    public ViewHolderType() {
    }

    public abstract RecyclerView.ViewHolder create(ViewGroup r1);

    public abstract boolean match(T r1);
}
