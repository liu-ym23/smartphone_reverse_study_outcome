package com.obric.memorydata.middleware.api.controller;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.personalcontext.impl.NetworkControllerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class INetworkController__ServiceProxy implements IServiceProxy<INetworkController> {
    public INetworkController__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.controller.INetworkController", "com.obric.memorydata.personalcontext.impl.NetworkControllerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public INetworkController newInstance() {
        return NetworkControllerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ INetworkController newInstance() {
        return newInstance();
    }
}
