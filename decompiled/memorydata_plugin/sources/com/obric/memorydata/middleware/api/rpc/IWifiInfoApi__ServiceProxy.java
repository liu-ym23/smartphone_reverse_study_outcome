package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.network.WifiInfoApiImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IWifiInfoApi__ServiceProxy implements IServiceProxy<IWifiInfoApi> {
    public IWifiInfoApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.rpc.IWifiInfoApi", "com.obric.memorydata.middleware.impl.network.WifiInfoApiImpl");
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
