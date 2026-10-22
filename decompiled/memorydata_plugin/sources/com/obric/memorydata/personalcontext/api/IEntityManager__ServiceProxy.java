package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IEntityManager__ServiceProxy implements IServiceProxy<IEntityManager> {
    public IEntityManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.personalcontext.api.IEntityManager", "com.obric.memorydata.personalcontext.EntityManager");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IEntityManager newInstance() {
        return com.obric.memorydata.personalcontext.EntityManager.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IEntityManager newInstance() {
        return newInstance();
    }
}
