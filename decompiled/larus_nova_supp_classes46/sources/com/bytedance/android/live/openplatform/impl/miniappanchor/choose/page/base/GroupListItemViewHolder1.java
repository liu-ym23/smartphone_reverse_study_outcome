package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/GroupListItemViewHolder1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupListItemViewHolder1 extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final TextView b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public final Function2<MiniAppEntranceCell, Integer, Unit> g;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupListItemViewHolder1(View r2, Function2<? super MiniAppEntranceCell, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "clickCallback");
        super(r2);
        this.g = r3;
        this.a = r2.findViewById(2131374718);
        this.b = (TextView) r2.findViewById(2131380593);
        this.c = r2.findViewById(2131369392);
        this.d = r2.findViewById(2131364174);
        this.e = r2.findViewById(2131384095);
        this.f = r2.findViewById(2131362039);
    }
}
