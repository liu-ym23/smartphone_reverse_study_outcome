package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.live.MonitorMessageType;
import com.bytedance.common.utility.Logger;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r3<T> implements Consumer {
    public final /* synthetic */ VerifyCodeWidget a;

    public r3(VerifyCodeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        TTLiveSDK.hostService().verify().dismissCaptcha();
        VerifyCodeWidget r5 = this.a;
        if (r5.b == false) goto L20;
        DataContext r0 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r0 instanceof RoomContext) == true) goto L8;
        r0 = null;
    L8:
        RoomContext r1 = (RoomContext) r0;
        if (r5.c == true) goto L15;
        ch1.b r6 = new ch1.b(MonitorMessageType.CLOSE_LIVE);
        if (r1 == null) goto L20;
        com.bytedance.live.datacontext.m r2 = r1.getReconnectMonitorMessage();
        if (r2 == null) goto L20;
        r2.setValue(r6);
        goto L20
    L15:
        ch1.b r7 = new ch1.b(MonitorMessageType.PASS_VERIFY);
        if (r1 == null) goto L20;
        com.bytedance.live.datacontext.m r8 = r1.getReconnectMonitorMessage();
        if (r8 == null) goto L20;
        r8.setValue(r7);
    L20:
        Logger.d("VerifyCodeWidget", "showCaptcha, dismissCaptcha");
    }
}
