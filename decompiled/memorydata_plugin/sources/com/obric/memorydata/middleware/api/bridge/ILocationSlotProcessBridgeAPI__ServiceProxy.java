package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.personalcontext.bridge.LocationSlotProcessBridgeAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ILocationSlotProcessBridgeAPI__ServiceProxy implements IServiceProxy<ILocationSlotProcessBridgeAPI> {
    public ILocationSlotProcessBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.ILocationSlotProcessBridgeAPI", "com.obric.memorydata.personalcontext.bridge.LocationSlotProcessBridgeAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ILocationSlotProcessBridgeAPI newInstance() {
        return LocationSlotProcessBridgeAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ILocationSlotProcessBridgeAPI newInstance() {
        return newInstance();
    }
}
