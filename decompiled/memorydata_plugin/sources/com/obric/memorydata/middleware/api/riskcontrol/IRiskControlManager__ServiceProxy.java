package com.obric.memorydata.middleware.api.riskcontrol;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.memorydata.middleware.impl.riskcontrol.RiskControlManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IRiskControlManager__ServiceProxy implements IServiceProxy<IRiskControlManager> {
    public IRiskControlManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.riskcontrol.IRiskControlManager", "com.obric.memorydata.middleware.impl.riskcontrol.RiskControlManagerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IRiskControlManager newInstance() {
        return RiskControlManagerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IRiskControlManager newInstance() {
        return newInstance();
    }
}
