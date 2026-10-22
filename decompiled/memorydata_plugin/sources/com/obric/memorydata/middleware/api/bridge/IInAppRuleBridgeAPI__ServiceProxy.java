package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.memory.inapprule.InAppRuleBridgeAPIImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IInAppRuleBridgeAPI__ServiceProxy implements IServiceProxy<IInAppRuleBridgeAPI> {
    public IInAppRuleBridgeAPI__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.bridge.IInAppRuleBridgeAPI", "com.obric.memorydata.memory.inapprule.InAppRuleBridgeAPIImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IInAppRuleBridgeAPI newInstance() {
        return InAppRuleBridgeAPIImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IInAppRuleBridgeAPI newInstance() {
        return newInstance();
    }
}
