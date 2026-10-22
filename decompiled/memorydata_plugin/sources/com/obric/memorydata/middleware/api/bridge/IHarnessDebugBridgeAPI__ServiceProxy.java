package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.aikernelcore.debug.HarnessDebugBridgeAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IHarnessDebugBridgeAPI__ServiceProxy implements IServiceProxy<IHarnessDebugBridgeAPI> {
    public IHarnessDebugBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI", "com.obric.memorydata.aikernelcore.debug.HarnessDebugBridgeAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IHarnessDebugBridgeAPI newInstance() {
        return HarnessDebugBridgeAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IHarnessDebugBridgeAPI newInstance() {
        return newInstance();
    }
}
