package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IAutoMemoryProBridgeAPI__ServiceProxy implements IServiceProxy<IAutoMemoryProBridgeAPI> {
    public IAutoMemoryProBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI", "com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAutoMemoryProBridgeAPI newInstance() {
        return AutoMemoryProBridgeImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAutoMemoryProBridgeAPI newInstance() {
        return newInstance();
    }
}
