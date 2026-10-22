package com.ss.android.lark.contact.base.entity.mobile.item;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    public final SparseArray<View> a;

    public ItemViewHolder(View r1) {
        super(r1);
        this.a = new SparseArray();
    }

    public final <T extends View> T T3(int r3) {
        T r0 = (T) this.a.get(r3);
        if (r0 != null) goto L6;
        T r1 = (T) ((RecyclerView.ViewHolder) this).itemView.findViewById(r3);
        this.a.put(r3, r1);
        return r1;
    L6:
        return r0;
    }
}
