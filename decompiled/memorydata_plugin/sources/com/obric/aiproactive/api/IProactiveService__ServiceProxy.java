package com.obric.aiproactive.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aiproactive.impl.ProactiveService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class IProactiveService__ServiceProxy implements IServiceProxy<IProactiveService> {
    public IProactiveService__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.aiproactive.api.IProactiveService", "com.obric.aiproactive.impl.ProactiveService");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IProactiveService newInstance() {
        return ProactiveService.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IProactiveService newInstance() {
        return newInstance();
    }
}
