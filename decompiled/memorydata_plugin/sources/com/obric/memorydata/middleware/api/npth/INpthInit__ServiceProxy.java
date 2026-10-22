package com.obric.memorydata.middleware.api.npth;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class INpthInit__ServiceProxy implements IServiceProxy<INpthInit> {
    public INpthInit__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.npth.INpthInit", "com.obric.memorydata.middleware.impl.npth.NpthInit");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public INpthInit newInstance() {
        return com.obric.memorydata.middleware.impl.npth.NpthInit.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ INpthInit newInstance() {
        return newInstance();
    }
}
