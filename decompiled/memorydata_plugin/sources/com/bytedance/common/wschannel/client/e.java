package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.SocketState;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class e extends b {
    public e(c.a r3) {
        super((c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r5, com.bytedance.common.wschannel.model.a r6) {
        r5.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState r7 = (SocketState) ZeusTransformUtils.preCheckCast(r5.getParcelableExtra(WsConstants.KEY_CONNECTION), SocketState.class, "com.obric.memorydata.plugin");
        ConnectionState r8 = a(r7.getChannelId(), r7.getConnectionState(), r7.isPrivateProtocolEnabled());     // Catch: Throwable -> L5
        this.f2089a.a(new com.bytedance.common.wschannel.event.a(r8, r7.getChannelType(), r7.getChannelId(), r7.getErrorCode()), r7.toJson());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
