package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ AudioTalkSettingFragment a;
    public final /* synthetic */ int b;

    public k(AudioTalkSettingFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        HashMap r7 = new HashMap();
        AudioTalkSettingFragment r0 = this.a;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r0.getRoom()) == false) goto L5;
        String r1 = "party";
    L6:
        AudioTalkSettingFragment.ca0(r0, r7, r1, "radio");
        IInteractService r2 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r2 != null) goto L9;
    L13:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_layout_change", r7, new Object[]{am2.x.class, IRoom.class});
        if (((IInteractService) jc1.k.n(IInteractService.class)).hitStageAB() == false) goto L16;
        int r8 = 27;
    L18:
        if (this.b == r8) goto L21;
        AudioTalkSettingFragment.da0(this.a, r8);
        return;
    L21:
        return;
    L16:
        r8 = 21;
        goto L18
    L9:
        if (r2.hitEnlargeStageAb(this.a.getRoom()) != true) goto L13;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.B0.getValue()).booleanValue() == false) goto L13;
        r7.put("layout_type", "stage_enlarge");
        goto L13
    L5:
        r1 = "radio";
        goto L6
    }
}
