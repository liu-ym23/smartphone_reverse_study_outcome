package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemNormalVH;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemBaseVH;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractPanelItemNormalVH extends LinkPKAudienceInteractPanelItemBaseVH {
    public final HSImageView a;
    public final TextView b;

    public LinkPKAudienceInteractPanelItemNormalVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381850);
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381852);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemBaseVH
    public final void T3(final g r3) {
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        this.b.setText(r3.d());
        if (r3.c() <= 0) goto L5;
        this.a.setActualImageResource(r3.c());
    L6:
        this.a.setOnClickListener(x0.a(new LinkPKAudienceInteractPanelItemNormalVH$bind$1(r3)));
        return;
    L5:
        Intrinsics.checkNotNullParameter(this.a, "icon");
        goto L6
    }
}
