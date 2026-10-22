package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class m implements k {
    public m() {
    }

    private void a(Context r2, int r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        if (r3 > 0) goto L6;
        return;
    L6:
        if (r3 <= 3) goto L9;
        return;
    L9:
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r3);
    L12:
        if (com.bytedance.common.wschannel.l.a(r1).c() == true) goto L14;
        return;
    L14:
        Message r4 = new Message();
        r4.what = 2;
        r4.arg1 = r3;
        com.bytedance.common.wschannel.server.h.a(r1).handleMsg(r4);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void a(Context r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 1);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void a(Context r1, boolean r2, boolean r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void b(Context r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 2);
    }
}
