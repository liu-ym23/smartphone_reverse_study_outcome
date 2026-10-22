package com.obric.aikernel.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.network.WifiInfoApiImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IWifiInfoApi__ServiceProxy implements IServiceProxy<IWifiInfoApi> {
    public IWifiInfoApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.rpc.IWifiInfoApi", "com.obric.aikernel.middleware.impl.network.WifiInfoApiImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IWifiInfoApi newInstance() {
        return WifiInfoApiImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IWifiInfoApi newInstance() {
        return newInstance();
    }
}
