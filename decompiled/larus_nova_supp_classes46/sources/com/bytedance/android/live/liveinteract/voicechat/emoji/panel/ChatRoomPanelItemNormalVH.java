package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemNormalVH;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemBaseVH;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomPanelItemNormalVH extends ChatRoomPanelItemBaseVH {
    public final HSImageView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void U3(ChatRoomPanelItemBaseVH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public ChatRoomPanelItemNormalVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381850);
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381852);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131377888);
        this.d = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384095);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void T3(final g r4) {
        Intrinsics.checkNotNullParameter(r4, "panelItem");
        this.b.setText(r4.j());
        if (r4.d() <= 0) goto L5;
        this.a.setActualImageResource(r4.d());
    L6:
        this.b.setTextColor(r4.d);
        this.a.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new ChatRoomPanelItemNormalVH$bind$1(r4)));
        if (r4.l() == false) goto L10;
        this.d.setVisibility(0);
    L10:
        if (r4.f().length() <= 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        this.c.setVisibility(0);
        this.c.setText(r4.f());
        this.c.setTextColor(r4.g());
        this.c.setBackground(s1.m(r4.h()));
    L16:
        this.a.setClickable(!r4.i());
        return;
    L15:
        this.c.setVisibility(8);
        goto L16
    L12:
        r0 = false;
        goto L13
    L5:
        r4.a(this.a);
        goto L6
    }
}
