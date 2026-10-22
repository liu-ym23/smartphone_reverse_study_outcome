package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends me.drakeet.multitype.b<d, AnchorShelfDisplayTradeItemViewHolder> {
    public b() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        AnchorShelfDisplayTradeItemViewHolder r4 = (AnchorShelfDisplayTradeItemViewHolder) r2;
        d r5 = (d) r3;
        Intrinsics.checkNotNullParameter(r4, "vh");
        Intrinsics.checkNotNullParameter(r5, "unitList");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "unitList");
        r4.a.a(r5, r4.b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = r3.inflate(2131566951, r4, false);
        if (r5 == null) goto L7;
        return new AnchorShelfDisplayTradeItemViewHolder((AnchorShelfDisplayTradeLayout) r5, new a());
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.AnchorShelfDisplayTradeLayout");
    }
}
