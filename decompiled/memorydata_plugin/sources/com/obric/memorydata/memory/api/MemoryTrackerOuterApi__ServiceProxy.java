package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.MemoryTrackerOuterImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryTrackerOuterApi__ServiceProxy implements IServiceProxy<MemoryTrackerOuterApi> {
    public MemoryTrackerOuterApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.memory.api.MemoryTrackerOuterApi", "com.obric.memorydata.MemoryTrackerOuterImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public MemoryTrackerOuterApi newInstance() {
        return MemoryTrackerOuterImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ MemoryTrackerOuterApi newInstance() {
        return newInstance();
    }
}
