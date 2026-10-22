package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/trade/AnchorShelfDisplayTradeItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayTradeItemViewHolder extends RecyclerView.ViewHolder {
    public final AnchorShelfDisplayTradeLayout a;
    public final AnchorShelfDisplayTradeLayout.a b;

    public AnchorShelfDisplayTradeItemViewHolder(AnchorShelfDisplayTradeLayout r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "tradeLayout");
        Intrinsics.checkNotNullParameter(r3, "config");
        super(r2);
        this.a = r2;
        this.b = r3;
    }
}
