package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.awareness.audio.AuditoryBridgeAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IAuditoryBridgeAPI__ServiceProxy implements IServiceProxy<IAuditoryBridgeAPI> {
    public IAuditoryBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI", "com.obric.memorydata.awareness.audio.AuditoryBridgeAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAuditoryBridgeAPI newInstance() {
        return AuditoryBridgeAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAuditoryBridgeAPI newInstance() {
        return newInstance();
    }
}
