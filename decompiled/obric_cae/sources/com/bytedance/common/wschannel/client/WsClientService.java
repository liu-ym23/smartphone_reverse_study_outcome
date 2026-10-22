package com.bytedance.common.wschannel.client;

import c6.a;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public class WsClientService extends a {
    public WsClientService() {
    }

    @Override // c6.a
    public final void c(WsChannelMsg r8) {
        if (r8 == null) goto L10;
        WsConstants.getListener(r8.f3913t);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // c6.a
    public final void d() {
    }
}
