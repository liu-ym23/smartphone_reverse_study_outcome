package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public b0(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r5) {
        HashMap r6 = new HashMap();
        AudioTalkSettingFragment r0 = this.a;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r0.getRoom()) == false) goto L5;
        String r1 = "party";
    L6:
        AudioTalkSettingFragment.ca0(r0, r6, r1, null);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_layout_change_popup_show", r6, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r1 = "radio";
        goto L6
    }
}
