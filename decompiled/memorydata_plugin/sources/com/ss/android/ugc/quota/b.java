package com.ss.android.ugc.quota;

import android.app.Application;
import com.ss.android.ugc.aweme.framework.services.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class b {
    static Application a() {
        IBDNetworkTagConfig r0 = (IBDNetworkTagConfig) ZeusTransformUtils.preCheckCast(f.a().a(IBDNetworkTagConfig.class), IBDNetworkTagConfig.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
    }

    static d b() {
        IBDNetworkTagConfig r0 = (IBDNetworkTagConfig) ZeusTransformUtils.preCheckCast(f.a().a(IBDNetworkTagConfig.class), IBDNetworkTagConfig.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTagDepend();
    }
}
