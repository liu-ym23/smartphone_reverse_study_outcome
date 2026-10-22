package com.ss.android.lark.contact.base.entity.mobile.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b9b.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseItemAdapter<Item extends a<Item>> extends RecyclerView.Adapter<ItemViewHolder> {
    public List<Item> a;

    public final int getItemCount() {
        return this.a.size();
    }

    public BaseItemAdapter() {
        this.a = new ArrayList();
        setHasStableIds(false);
    }

    public final long getItemId(int r3) {
        ((a) ListProtector.get(this.a, r3)).getClass();
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getItemViewType(int r2) {
        a r3 = (a) ListProtector.get(this.a, r2);
        r3.c = this;
        return r3.b;
    }

    public final void onAttachedToRecyclerView(RecyclerView r1) {
        super.onAttachedToRecyclerView(r1);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        ItemViewHolder r4 = (ItemViewHolder) r3;
        super.onViewRecycled(r4);
        int r0 = r4.getAdapterPosition();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.a.size()) goto L10;
        ((a) ListProtector.get(this.a, r0)).b(r4);
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ItemViewHolder r6 = (ItemViewHolder) r4;
        a r0 = (a) ListProtector.get(this.a, r5);
        r0.getClass();
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(null);
        ((RecyclerView.ViewHolder) r6).itemView.setOnLongClickListener(null);
        r0.a = true;
        r0.a(r6, r5);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        int r6 = a.d.get(r5, -1);
        if (r6 == (-1)) goto L7;
        return new ItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(r6, r4, false));
    L7:
        throw new RuntimeException("onCreateViewHolder: get holder from view type failed.");
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        ItemViewHolder r5 = (ItemViewHolder) r2;
        if (r4.isEmpty() == false) goto L5;
        super.onBindViewHolder(r5, r3, r4);
        return;
    L5:
        ((a) ListProtector.get(this.a, r3)).getClass();
    }
}
