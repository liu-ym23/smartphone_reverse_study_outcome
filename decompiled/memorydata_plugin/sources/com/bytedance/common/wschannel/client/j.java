package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SocketState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {
    public j(c.a r3) {
        super((c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r3, com.bytedance.common.wschannel.model.a r4) {
        Logger.d("AbsWsClientService", "sync socket state");
        r3.setExtrasClassLoader(SocketState.class.getClassLoader());
        ArrayList r5 = r3.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);
        if (r5 == null) goto L10;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        SocketState r7 = (SocketState) ZeusTransformUtils.preCheckCast(r6.next(), SocketState.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L6;
        a(r7.getChannelId(), r7.getConnectionState(), r7.isPrivateProtocolEnabled());
        goto L6
    L16:
        return;
    }
}
