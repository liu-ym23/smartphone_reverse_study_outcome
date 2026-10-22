package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ MultiLinkIntegrationPlayMethodFragment.VideoTalkPlayMethodItemViewHolder a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.model.k1 b;

    public f0(MultiLinkIntegrationPlayMethodFragment.VideoTalkPlayMethodItemViewHolder r1, com.bytedance.android.livesdk.chatroom.model.k1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        com.bytedance.android.livesdk.chatroom.model.k1 r12 = this.a.f;
        if (r12 == null) goto L34;
        r12.getType();
        MultiLinkIntegrationPlayMethodFragment r13 = this.a.g;
        int r0 = r13.m;
        String r3 = "link_interact_panel_tab";
        if (r0 != 1) goto L7;
        String r1 = r13.l;
        if (r1 != null) goto L24;
        String r7 = "link_interact_panel_tab";
    L25:
        Context r5 = r13.getContext();
        if (r5 == null) goto L38;
        gd0.m r14 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r14 == null) goto L39;
        DataCenter r6 = this.a.g.j;
        if (r6 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L32:
        LinkPanelTransitService r4 = (LinkPanelTransitService) r14;
        r4.l(r5, r6, r7, this.b, true);
        return;
    L39:
        return;
    L38:
        return;
    L24:
        r7 = r1;
        goto L25
    L7:
        if (r0 != 2) goto L40;
        String r2 = r13.l;
        if (r2 == null) goto L13;
        r3 = r2;
    L13:
        Context r15 = r13.getContext();
        if (r15 == null) goto L35;
        gd0.m r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r8 == null) goto L36;
        DataCenter r9 = this.a.g.j;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L20:
        LinkPanelTransitService r10 = (LinkPanelTransitService) r8;
        r10.c(r15, r9, r3, this.b);
        return;
    L36:
        return;
    L35:
        return;
    L40:
        return;
    }
}
