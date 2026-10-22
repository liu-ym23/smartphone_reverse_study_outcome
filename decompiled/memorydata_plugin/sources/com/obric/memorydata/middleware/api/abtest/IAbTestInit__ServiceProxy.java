package com.obric.memorydata.middleware.api.abtest;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.abtest.AbTestInitImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IAbTestInit__ServiceProxy implements IServiceProxy<IAbTestInit> {
    public IAbTestInit__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.abtest.IAbTestInit", "com.obric.memorydata.middleware.impl.abtest.AbTestInitImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAbTestInit newInstance() {
        return AbTestInitImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAbTestInit newInstance() {
        return newInstance();
    }
}
