package com.larksuite.component.blockit.hashtag.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class RecyclerSwipeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements py7.a {
    public final b a;

    public final void y2() {
        this.a.b(true);
    }

    public RecyclerSwipeAdapter() {
        this.a = new b(this);
    }

    public final void z2() {
        super.notifyDataSetChanged();
    }
}
