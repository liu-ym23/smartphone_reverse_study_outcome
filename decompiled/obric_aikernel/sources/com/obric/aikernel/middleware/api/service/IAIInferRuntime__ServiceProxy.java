package com.obric.aikernel.middleware.api.service;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.service.AIInferRuntimeImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IAIInferRuntime__ServiceProxy implements IServiceProxy<IAIInferRuntime> {
    public IAIInferRuntime__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.service.IAIInferRuntime", "com.obric.aikernel.service.AIInferRuntimeImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAIInferRuntime newInstance() {
        return AIInferRuntimeImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAIInferRuntime newInstance() {
        return newInstance();
    }
}
