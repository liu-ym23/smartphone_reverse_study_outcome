package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.MemoryServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryServiceApi__ServiceProxy implements IServiceProxy<MemoryServiceApi> {
    public MemoryServiceApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.memory.api.MemoryServiceApi", "com.obric.memorydata.MemoryServiceImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public MemoryServiceApi newInstance() {
        return MemoryServiceImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ MemoryServiceApi newInstance() {
        return newInstance();
    }
}
