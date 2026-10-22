package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.abtest.ExperimentBridgeAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IExperimentBridgeAPI__ServiceProxy implements IServiceProxy<IExperimentBridgeAPI> {
    public IExperimentBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI", "com.obric.memorydata.middleware.impl.abtest.ExperimentBridgeAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IExperimentBridgeAPI newInstance() {
        return ExperimentBridgeAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IExperimentBridgeAPI newInstance() {
        return newInstance();
    }
}
