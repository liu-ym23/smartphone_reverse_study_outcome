package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.awareness.impl.FeatureManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class IFeatureManager__ServiceProxy implements IServiceProxy<IFeatureManager> {
    public IFeatureManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.awareness.api.IFeatureManager", "com.obric.memorydata.awareness.impl.FeatureManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IFeatureManager newInstance() {
        return FeatureManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IFeatureManager newInstance() {
        return newInstance();
    }
}
