package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.personalcontext.search.bridge.impl.EntitySearchBridgeApiImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IEntitySearchBridgeApi__ServiceProxy implements IServiceProxy<IEntitySearchBridgeApi> {
    public IEntitySearchBridgeApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IEntitySearchBridgeApi", "com.obric.memorydata.personalcontext.search.bridge.impl.EntitySearchBridgeApiImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IEntitySearchBridgeApi newInstance() {
        return EntitySearchBridgeApiImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IEntitySearchBridgeApi newInstance() {
        return newInstance();
    }
}
