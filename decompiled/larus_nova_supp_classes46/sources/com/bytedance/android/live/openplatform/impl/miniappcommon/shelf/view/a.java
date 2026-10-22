package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends me.drakeet.multitype.b<wq0.a, LinkCastItemViewHolder> {
    public final LinkCastItemViewHolder.a b;

    public a(CommonShelfDisplayDialog.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        LinkCastItemViewHolder r4 = (LinkCastItemViewHolder) r2;
        wq0.a r5 = (wq0.a) r3;
        Intrinsics.checkNotNullParameter(r4, "vh");
        Intrinsics.checkNotNullParameter(r5, "linkCastItemInfo");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "linkCastItemInfo");
        r4.a.setText(r5.a);
        ((RecyclerView.ViewHolder) r4).itemView.setOnClickListener(new b(r4));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new LinkCastItemViewHolder(r4.inflate(2131566950, r5, false), this.b);
    }
}
