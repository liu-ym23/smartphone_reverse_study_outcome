package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ AudioTalkSettingFragment a;
    public final /* synthetic */ int b;

    public l(AudioTalkSettingFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        HashMap r6 = new HashMap();
        AudioTalkSettingFragment r0 = this.a;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r0.getRoom()) == false) goto L5;
        String r1 = "party";
    L6:
        AudioTalkSettingFragment.ca0(r0, r6, r1, "party");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_layout_change", r6, new Object[]{am2.x.class, IRoom.class});
        if (this.b == 22) goto L10;
        AudioTalkSettingFragment.da0(this.a, 22);
        return;
    L10:
        return;
    L5:
        r1 = "radio";
        goto L6
    }
}
