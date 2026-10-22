package com.obric.aikernel.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IBdTrackerInit__ServiceProxy implements IServiceProxy<IBdTrackerInit> {
    public IBdTrackerInit__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.bdtracker.IBdTrackerInit", "com.obric.aikernel.middleware.impl.bdtracker.BdTrackerInit");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IBdTrackerInit newInstance() {
        return new com.obric.aikernel.middleware.impl.bdtracker.BdTrackerInit();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IBdTrackerInit newInstance() {
        return newInstance();
    }
}
