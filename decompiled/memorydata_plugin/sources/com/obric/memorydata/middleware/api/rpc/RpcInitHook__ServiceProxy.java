package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.network.rpc.RpcInitHookImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RpcInitHook__ServiceProxy implements IServiceProxy<RpcInitHook> {
    public RpcInitHook__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.rpc.RpcInitHook", "com.obric.memorydata.middleware.impl.network.rpc.RpcInitHookImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public RpcInitHook newInstance() {
        return new RpcInitHookImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ RpcInitHook newInstance() {
        return newInstance();
    }
}
