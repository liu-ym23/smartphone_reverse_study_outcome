package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c.a f2089a;

    public b(c.a r3) {
        this.f2089a = (c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin");
    }

    public ConnectionState a(int r4, int r5, boolean r6) {
        ConnectionState r0 = ConnectionState.CONNECTION_UNKNOWN;
        if (r5 != 0) goto L6;
        r0 = ConnectionState.CONNECTION_UNKNOWN;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "state = " + r5 + " connectionState = " + r0);
    L20:
        this.f2089a.a(r4, r0, r6);
        return r0;
    L6:
        if (r5 != 1) goto L9;
        r0 = ConnectionState.CONNECTING;
        goto L18
    L9:
        if (r5 != 2) goto L12;
        r0 = ConnectionState.CONNECT_FAILED;
        goto L18
    L12:
        if (r5 != 3) goto L15;
        r0 = ConnectionState.CONNECT_CLOSED;
        goto L18
    L15:
        if (r5 != 4) goto L18;
        r0 = ConnectionState.CONNECTED;
        goto L18
    }
}
