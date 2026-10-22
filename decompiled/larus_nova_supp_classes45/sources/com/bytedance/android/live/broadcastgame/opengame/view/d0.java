package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.network.m0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 extends me.drakeet.multitype.b<m0, TotalDiamondViewHolder> {
    public d0() {
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        TotalDiamondViewHolder r5 = (TotalDiamondViewHolder) r3;
        m0 r6 = (m0) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        r5.a.setText(b.a(r6.a()));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new TotalDiamondViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131565450, r5, false));
    }
}
