package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.awareness.impl.RecommenderImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class IRecommender__ServiceProxy implements IServiceProxy<IRecommender> {
    public IRecommender__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.awareness.api.IRecommender", "com.obric.memorydata.awareness.impl.RecommenderImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IRecommender newInstance() {
        return RecommenderImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IRecommender newInstance() {
        return newInstance();
    }
}
