package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s1 implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.model.k1 a;
    public final /* synthetic */ VideoTalkSettingFragment b;
    public final /* synthetic */ String c;

    public s1(com.bytedance.android.livesdk.chatroom.model.k1 r1, VideoTalkSettingFragment r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        Context r1 = this.b.getContext();
        DataCenter r2 = this.b.n;
        if (r1 == null) goto L12;
        if (r2 == null) goto L13;
        gd0.m r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r8 == null) goto L14;
        String r3 = this.c;
        com.bytedance.android.livesdk.chatroom.model.k1 r4 = this.a;
        if (r4 == null) goto L11;
        ((LinkPanelTransitService) r8).l(r1, r2, r3, r4, false);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractItem");
    L14:
        return;
    L13:
        return;
    }
}
