package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class i extends b {
    public i(c.a r3) {
        super((c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r3, com.bytedance.common.wschannel.model.a r4) {
        r3.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        String r5 = r3.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);
        boolean r6 = r3.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);
        if (Logger.debug() == false) goto L5;
        Logger.d("AbsWsClientService", "get payloadMd5 = " + r5 + " sendResult = " + r6);
    L5:
        this.f2089a.a(r5, r6);
    }
}
