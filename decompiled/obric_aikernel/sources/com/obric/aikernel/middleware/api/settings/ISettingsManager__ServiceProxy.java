package com.obric.aikernel.middleware.api.settings;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ISettingsManager__ServiceProxy implements IServiceProxy<ISettingsManager> {
    public ISettingsManager__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.settings.ISettingsManager", "com.obric.aikernel.middleware.impl.settings.AppSettingsManager");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ISettingsManager newInstance() {
        return com.obric.aikernel.middleware.impl.settings.AppSettingsManager.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ISettingsManager newInstance() {
        return newInstance();
    }
}
