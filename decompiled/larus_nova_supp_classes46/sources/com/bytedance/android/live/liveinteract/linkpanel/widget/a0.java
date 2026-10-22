package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LinkPanelTopBarWidget a;

    public a0(LinkPanelTopBarWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        DataCenter r5 = ((Widget) this.a).dataCenter;
        if (r5 == null) goto L6;
        r5.put("data_voice_chat_room_close_page", "link_panel");
    L6:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L13;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r6 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r6 == null) goto L10;
        r6.finishAudioTalk("link_setting_panel");
    L10:
        IKtvService r7 = jc1.k.f(IKtvService.class);
        if (r7 == null) goto L13;
        r7.finishAudioTalk();
    L13:
        r3.dismiss();
    }
}
