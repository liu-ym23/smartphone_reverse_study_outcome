package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.personalcontext.bridge.AppEntityIndexBridgeAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IAppEntityIndexBridgeAPI__ServiceProxy implements IServiceProxy<IAppEntityIndexBridgeAPI> {
    public IAppEntityIndexBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IAppEntityIndexBridgeAPI", "com.obric.memorydata.personalcontext.bridge.AppEntityIndexBridgeAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAppEntityIndexBridgeAPI newInstance() {
        return AppEntityIndexBridgeAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAppEntityIndexBridgeAPI newInstance() {
        return newInstance();
    }
}
