package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class h extends b {
    public h(c.a r3) {
        super((c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r2, com.bytedance.common.wschannel.model.a r3) {
        r2.setExtrasClassLoader(ServiceConnectEvent.class.getClassLoader());
        ServiceConnectEvent r4 = (ServiceConnectEvent) ZeusTransformUtils.preCheckCast(r2.getParcelableExtra("service"), ServiceConnectEvent.class, "com.obric.memorydata.plugin");
        this.f2089a.a(r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
