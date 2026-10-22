package com.obric.aikernel.middleware.api.npth;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class INpthInit__ServiceProxy implements IServiceProxy<INpthInit> {
    public INpthInit__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.npth.INpthInit", "com.obric.aikernel.middleware.impl.npth.NpthInit");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public INpthInit newInstance() {
        return com.obric.aikernel.middleware.impl.npth.NpthInit.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ INpthInit newInstance() {
        return newInstance();
    }
}
