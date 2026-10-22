package com.obric.memorydata.middleware.api.alog;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IALogManager__ServiceProxy implements IServiceProxy<IALogManager> {
    public IALogManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put("com.obric.memorydata.middleware.api.alog.IALogManager", "com.obric.memorydata.middleware.impl.alog.ALogManager");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IALogManager newInstance() {
        return com.obric.memorydata.middleware.impl.alog.ALogManager.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IALogManager newInstance() {
        return newInstance();
    }
}
