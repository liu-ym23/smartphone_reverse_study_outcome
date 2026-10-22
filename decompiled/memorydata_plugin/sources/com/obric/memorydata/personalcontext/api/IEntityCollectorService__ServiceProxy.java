package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.personalcontext.collector.EntityCollectorServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IEntityCollectorService__ServiceProxy implements IServiceProxy<IEntityCollectorService> {
    public IEntityCollectorService__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.personalcontext.api.IEntityCollectorService", "com.obric.memorydata.personalcontext.collector.EntityCollectorServiceImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IEntityCollectorService newInstance() {
        return EntityCollectorServiceImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IEntityCollectorService newInstance() {
        return newInstance();
    }
}
