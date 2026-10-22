package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/LinkCastItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkCastItemViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final a b;

    public interface a {
        void onClick();
    }

    public LinkCastItemViewHolder(View r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.b = r3;
        this.a = (TextView) r2.findViewById(2131377978);
    }
}
