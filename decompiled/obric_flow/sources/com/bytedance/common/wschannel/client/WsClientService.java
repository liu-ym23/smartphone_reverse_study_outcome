package com.bytedance.common.wschannel.client;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.salamander.anniex.b0;

/* JADX INFO: loaded from: classes2.dex */
public class WsClientService extends AbsWsClientService {
    public WsClientService() {
    }

    @Override // m8.a
    public final void a(int r5, ConnectionState r10) {
        WsConstants.setConnectionState(r5, r10);
    }

    @Override // m8.a
    public final void b(WsChannelMsg r5) {
        if (r5 == null) goto L10;
        WsConstants.getListener(r5.f4011j);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // m8.a
    public final void e(b0 r5) {
        WsConstants.getListener(r5.f7246b);
    }
}
