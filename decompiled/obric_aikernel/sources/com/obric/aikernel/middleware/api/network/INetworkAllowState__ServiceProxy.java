package com.obric.aikernel.middleware.api.network;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.network.NetworkAllowStateImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class INetworkAllowState__ServiceProxy implements IServiceProxy<INetworkAllowState> {
    public INetworkAllowState__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.network.INetworkAllowState", "com.obric.aikernel.middleware.impl.network.NetworkAllowStateImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public INetworkAllowState newInstance() {
        return NetworkAllowStateImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ INetworkAllowState newInstance() {
        return newInstance();
    }
}
