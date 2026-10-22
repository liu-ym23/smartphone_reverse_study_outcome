package com.obric.aikernel.memory_collect.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.memory_collect.impl.MemoryCollectImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryCollectApi__ServiceProxy implements IServiceProxy<MemoryCollectApi> {
    public MemoryCollectApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.memory_collect.api.MemoryCollectApi", "com.obric.aikernel.memory_collect.impl.MemoryCollectImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public MemoryCollectApi newInstance() {
        return MemoryCollectImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ MemoryCollectApi newInstance() {
        return newInstance();
    }
}
