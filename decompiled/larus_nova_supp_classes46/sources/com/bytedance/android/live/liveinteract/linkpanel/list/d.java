package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.widget.LinkInviteListWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends me.drakeet.multitype.b<w, BaseTalkGuestSearchViewHolder> {
    public final v b;

    public d(LinkInviteListWidget.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        BaseTalkGuestSearchViewHolder r8 = (BaseTalkGuestSearchViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter((w) r7, "item");
        ((RelativeLayout) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131383783)).setVisibility(8);
        ((RelativeLayout) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131370382)).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131366984)).setVisibility(8);
        HashMap r9 = new HashMap();
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.F(r9, r0);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r9, Integer.valueOf(r0), 4);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.J(r9);
        j0.l().sendLog("livesdk_invitation_search_show", r9, new Object[]{IRoom.class});
        ((RelativeLayout) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131370382)).setOnClickListener(new e(r8, r9));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new BaseTalkGuestSearchViewHolder(r3.inflate(2131565516, r4, false), this.b);
    }
}
