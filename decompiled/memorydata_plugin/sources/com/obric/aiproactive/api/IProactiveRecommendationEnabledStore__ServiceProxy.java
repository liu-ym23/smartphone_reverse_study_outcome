package com.obric.aiproactive.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aiproactive.impl.runtime.ProactiveRecommendationEnabledStoreImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class IProactiveRecommendationEnabledStore__ServiceProxy implements IServiceProxy<IProactiveRecommendationEnabledStore> {
    public IProactiveRecommendationEnabledStore__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.aiproactive.api.IProactiveRecommendationEnabledStore", "com.obric.aiproactive.impl.runtime.ProactiveRecommendationEnabledStoreImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IProactiveRecommendationEnabledStore newInstance() {
        return ProactiveRecommendationEnabledStoreImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IProactiveRecommendationEnabledStore newInstance() {
        return newInstance();
    }
}
