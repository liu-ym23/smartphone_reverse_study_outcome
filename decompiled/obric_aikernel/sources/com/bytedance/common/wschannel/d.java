package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements z1.c.a {
    public d() {
    }

    @Override // z1.c.a
    public void a(WsChannelMsg r10, boolean r11) {
        h r12 = k.d(r10.getChannelId());
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    @Override // z1.c.a
    public void b(com.bytedance.common.wschannel.event.a r10, JSONObject r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        h r12 = k.d(r10.f1306d);
        if (r12 == null) goto L8;
        r12.c(r10, r11);
        return;
    }

    @Override // z1.c.a
    public void c(WsChannelMsg r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        h r11 = k.d(r10.getChannelId());
        if (r11 == null) goto L8;
        r11.b(r10);
        return;
    }

    @Override // z1.c.a
    public void d(ServiceConnectEvent r10) {
        h r11 = k.d(r10.getChannelId());
        if (r11 == null) goto L6;
        r11.f(r10);
        r11.d(r10);
        return;
    }

    @Override // z1.c.a
    public void e(int r10, ConnectionState r11, boolean r12) {
        h r13 = k.d(r10);
        if (r13 == null) goto L6;
        r13.g(r11, r12);
        return;
    }

    @Override // z1.c.a
    public void f(String r10, boolean r11) {
    }
}
