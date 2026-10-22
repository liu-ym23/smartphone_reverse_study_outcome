package com.obric.aikernel.middleware.api.commonmonitor;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ICommonMonitorInit__ServiceProxy implements IServiceProxy<ICommonMonitorInit> {
    public ICommonMonitorInit__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.commonmonitor.ICommonMonitorInit", "com.obric.aikernel.middleware.impl.commonmonitor.CommonMonitorInit");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ICommonMonitorInit newInstance() {
        return new com.obric.aikernel.middleware.impl.commonmonitor.CommonMonitorInit();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ICommonMonitorInit newInstance() {
        return newInstance();
    }
}
