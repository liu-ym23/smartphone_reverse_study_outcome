package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 extends me.drakeet.multitype.b<k0, DrawerHistoryMoreItemViewHolder> {
    public final IDrawerFeedAction b;

    public m0(IDrawerFeedAction r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        DrawerHistoryMoreItemViewHolder r4 = (DrawerHistoryMoreItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter((k0) r3, "item");
        r4.getClass();
        DrawerHistoryMoreItemViewHolder.T3();
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new DrawerHistoryMoreItemViewHolder(r3.inflate(2131565977, r4, false), this.b);
    }
}
