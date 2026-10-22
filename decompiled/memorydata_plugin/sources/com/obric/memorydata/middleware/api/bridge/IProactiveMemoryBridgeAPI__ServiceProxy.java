package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.recommend.bridge.ProactiveMemoryBridgeImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IProactiveMemoryBridgeAPI__ServiceProxy implements IServiceProxy<IProactiveMemoryBridgeAPI> {
    public IProactiveMemoryBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI", "com.obric.memorydata.recommend.bridge.ProactiveMemoryBridgeImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IProactiveMemoryBridgeAPI newInstance() {
        return ProactiveMemoryBridgeImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IProactiveMemoryBridgeAPI newInstance() {
        return newInstance();
    }
}
