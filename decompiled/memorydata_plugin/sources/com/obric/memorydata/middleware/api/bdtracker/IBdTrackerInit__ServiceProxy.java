package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IBdTrackerInit__ServiceProxy implements IServiceProxy<IBdTrackerInit> {
    public IBdTrackerInit__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bdtracker.IBdTrackerInit", "com.obric.memorydata.middleware.impl.bdtracker.BdTrackerInit");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IBdTrackerInit newInstance() {
        return new com.obric.memorydata.middleware.impl.bdtracker.BdTrackerInit();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IBdTrackerInit newInstance() {
        return newInstance();
    }
}
