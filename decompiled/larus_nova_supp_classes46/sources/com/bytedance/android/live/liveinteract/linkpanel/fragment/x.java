package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ AudioTalkSettingFragment a;
    public final /* synthetic */ Map b;

    public x(AudioTalkSettingFragment r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_profit_info_click", this.b, new Object[]{IRoom.class});
        jc1.k.n(IMiddlewareRoomService.class).actionHandler().handle(this.a.getContext(), vm2.d.H());
    }
}
