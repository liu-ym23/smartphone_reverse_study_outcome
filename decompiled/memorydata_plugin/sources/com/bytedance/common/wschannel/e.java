package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.bytedance.common.wschannel.client.c.a {
    public e() {
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(int r1, ConnectionState r2, boolean r3) {
        i r0 = k.a(r1);
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(com.bytedance.common.wschannel.event.a r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        i r0 = k.a(r1.d);
        if (r0 == null) goto L8;
        r0.a(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(ServiceConnectEvent r1) {
        i r0 = k.a(r1.getChannelId());
        if (r0 == null) goto L6;
        r0.b(r1);
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(WsChannelMsg r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        i r0 = k.a(r1.getChannelId());
        if (r0 == null) goto L8;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(WsChannelMsg r1, boolean r2) {
        i r0 = k.a(r1.getChannelId());
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.c.a
    public void a(String r1, boolean r2) {
    }
}
