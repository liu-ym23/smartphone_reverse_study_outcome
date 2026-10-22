package com.bytedance.ttnet.retrofit;

import com.bytedance.frameworks.baselib.network.http.d;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Client {
    public c() {
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r3) {
        if (ZeusTransformUtils.instanceOf(r3.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L5;
        boolean r2 = ((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r3.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin")).l;
    L6:
        d r4 = com.bytedance.ttnet.c.a(r3.getUrl(), r2);
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.newSsCall(r3);
    L5:
        r2 = false;
        goto L6
    }
}
