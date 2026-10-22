package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class IMemoryEntityManagerApi__ServiceProxy implements IServiceProxy<IMemoryEntityManagerApi> {
    public IMemoryEntityManagerApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.memory.api.IMemoryEntityManagerApi", "com.obric.memorydata.memory.memoryentity.MemoryEntityManager");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IMemoryEntityManagerApi newInstance() {
        return MemoryEntityManager.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IMemoryEntityManagerApi newInstance() {
        return newInstance();
    }
}
