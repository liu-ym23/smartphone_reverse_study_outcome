package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements DialogInterface.OnClickListener {
    public final /* synthetic */ AudioTalkSettingFragment a;
    public final /* synthetic */ int b;

    public z(AudioTalkSettingFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        HashMap r7 = new HashMap();
        r7.put("live_type", "voice_live");
        AudioTalkSettingFragment r0 = this.a;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r0.getRoom()) == false) goto L5;
        String r1 = "party";
    L6:
        AudioTalkSettingFragment.ca0(r0, r7, r1, "confirm");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_layout_change_popup_click", r7, new Object[]{am2.x.class, IRoom.class});
        this.a.ta0(5, 5, this.b);
        r5.dismiss();
        return;
    L5:
        r1 = "radio";
        goto L6
    }
}
