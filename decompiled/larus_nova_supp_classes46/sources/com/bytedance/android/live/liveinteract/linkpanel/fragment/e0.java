package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.model.k1 a;
    public final /* synthetic */ AudioTalkSettingFragment b;
    public final /* synthetic */ String c;

    public e0(com.bytedance.android.livesdk.chatroom.model.k1 r1, AudioTalkSettingFragment r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Context r6 = this.b.getContext();
        DataCenter r0 = this.b.l;
        if (r6 == null) goto L8;
        if (r0 == null) goto L8;
        gd0.m r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r1 == null) goto L8;
        LinkPanelTransitService r2 = (LinkPanelTransitService) r1;
        r2.c(r6, r0, this.c, this.a);
    L8:
        AudioTalkSettingFragment r7 = this.b;
        com.bytedance.android.livesdk.chatroom.model.k1 r3 = this.a;
        r7.getClass();
        if (r3.getType() != 5) goto L12;
        com.bytedance.android.livesdk.sharedpref.e r8 = b6.f;
        Boolean r4 = Boolean.FALSE;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r4);
        return;
    }
}
