package com.bytedance.common.wschannel.client;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    public f(c.a r3) {
        super((c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r5, com.bytedance.common.wschannel.model.a r6) {
        r5.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        WsChannelMsg r7 = (WsChannelMsg) ZeusTransformUtils.preCheckCast(r5.getParcelableExtra("payload"), WsChannelMsg.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(WsConstants.getOptLogic().a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L9;
        Message r1 = new Message();
        r1.getData().putParcelable("payload", r7);
        r1.getData().setClassLoader(WsChannelMsg.class.getClassLoader());
        Parcelable r8 = r1.getData().getParcelable("payload");
        if (ZeusTransformUtils.instanceOf(r8, WsChannelMsg.class) == false) goto L8;
        r7 = (WsChannelMsg) ZeusTransformUtils.preCheckCast(r8, WsChannelMsg.class, "com.obric.memorydata.plugin");
        goto L9
    L8:
        r7 = null;
    L9:
        if (r7 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("AbsWsClientService", "get wsChannelMsg = " + r7.toString());
    L13:
        if (r6 == null) goto L15;
        r7.receiveDataFromIpcTs = r6.f2148a;
    L15:
        this.f2089a.a(r7);
    }
}
