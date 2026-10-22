package com.obric.aikernel.middleware.api.alog;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IALogManager__ServiceProxy implements IServiceProxy<IALogManager> {
    public IALogManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.alog.IALogManager", "com.obric.aikernel.middleware.impl.alog.ALogManager");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IALogManager newInstance() {
        return com.obric.aikernel.middleware.impl.alog.ALogManager.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IALogManager newInstance() {
        return newInstance();
    }
}
