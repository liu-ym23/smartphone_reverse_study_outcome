package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IMemoryAppLogSettings__ServiceProxy implements IServiceProxy<IMemoryAppLogSettings> {
    public IMemoryAppLogSettings__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bdtracker.IMemoryAppLogSettings", "com.obric.memorydata.middleware.impl.bdtracker.MemoryAppLogSettings");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IMemoryAppLogSettings newInstance() {
        return com.obric.memorydata.middleware.impl.bdtracker.MemoryAppLogSettings.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IMemoryAppLogSettings newInstance() {
        return newInstance();
    }
}
