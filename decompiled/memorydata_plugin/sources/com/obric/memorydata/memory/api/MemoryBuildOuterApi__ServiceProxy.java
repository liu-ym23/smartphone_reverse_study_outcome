package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryBuildOuterApi__ServiceProxy implements IServiceProxy<MemoryBuildOuterApi> {
    public MemoryBuildOuterApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.memory.api.MemoryBuildOuterApi", "com.obric.memorydata.MemoryBuildOuter");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public MemoryBuildOuterApi newInstance() {
        return com.obric.memorydata.MemoryBuildOuter.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ MemoryBuildOuterApi newInstance() {
        return newInstance();
    }
}
