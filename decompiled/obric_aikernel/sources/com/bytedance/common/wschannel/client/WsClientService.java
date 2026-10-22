package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;
import u1.c;
import u1.d;
import u1.e;
import z1.a;

/* JADX INFO: loaded from: classes.dex */
public class WsClientService extends a {
    public WsClientService() {
    }

    @Override // z1.c.a
    public void a(WsChannelMsg r10, boolean r11) {
    }

    @Override // z1.c.a
    public void b(com.bytedance.common.wschannel.event.a r10, JSONObject r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        d r12 = WsConstants.getListener(r10.f1306d);
        if (r12 == null) goto L8;
        r12.b(r10, r11);
        return;
    }

    @Override // z1.c.a
    public void c(WsChannelMsg r10) {
        if (r10 == null) goto L21;
        d r11 = WsConstants.getListener(r10.getChannelId());     // Catch: Throwable -> L14
        if (r11 != null) goto L6;
    L8:
        c r12 = WsConstants.getMessageAckListener();     // Catch: Throwable -> L14
        if (r12 != null) goto L11;
    L17:
        return;
    L11:
        if (r10.isAckMsg() == false) goto L17;
        MessageAckEvent r13 = new MessageAckEvent(r10.getUUID(), r10.getChannelId(), r10.getService(), r10.getMethod(), r10.getLogInfo());     // Catch: Throwable -> L14
        r13.a(r10.getState());     // Catch: Throwable -> L14
        r12.a(r13);     // Catch: Throwable -> L14
        goto L17
    L6:
        if (r10.isAckMsg() == true) goto L8;
        r11.c(r10);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Logger.e(th.toString());
        return;
    }

    @Override // z1.c.a
    public void d(ServiceConnectEvent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        WsConstants.setServiceState(r10);
        e r11 = WsConstants.getServiceConnectListener();
        if (r11 == null) goto L8;
        r11.b(r10);
        return;
    }

    @Override // z1.c.a
    public void e(int r10, ConnectionState r11, boolean r12) {
        WsConstants.setConnectionState(r10, r11, r12);
    }

    @Override // z1.a, z1.c.a
    public void f(String r10, boolean r11) {
        super.f(r10, r11);
    }
}
