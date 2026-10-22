package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.memory.api.impl.MemoryBuildApiImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryBuildApi__ServiceProxy implements IServiceProxy<MemoryBuildApi> {
    public MemoryBuildApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.memory.api.MemoryBuildApi", "com.obric.memorydata.memory.api.impl.MemoryBuildApiImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public MemoryBuildApi newInstance() {
        return MemoryBuildApiImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ MemoryBuildApi newInstance() {
        return newInstance();
    }
}
