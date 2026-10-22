package com.obric.memorydata.recommend;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IRecommendApi__ServiceProxy implements IServiceProxy<IRecommendApi> {
    public IRecommendApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.recommend.IRecommendApi", "com.obric.memorydata.recommend.RecommendApiImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IRecommendApi newInstance() {
        return RecommendApiImpl.getInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IRecommendApi newInstance() {
        return newInstance();
    }
}
