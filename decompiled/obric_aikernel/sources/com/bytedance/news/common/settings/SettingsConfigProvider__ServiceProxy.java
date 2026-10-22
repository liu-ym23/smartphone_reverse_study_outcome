package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.settings.SettingsConfigProviderImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SettingsConfigProvider__ServiceProxy implements IServiceProxy<SettingsConfigProvider> {
    public SettingsConfigProvider__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.bytedance.news.common.settings.SettingsConfigProvider", "com.obric.aikernel.middleware.impl.settings.SettingsConfigProviderImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public SettingsConfigProvider newInstance() {
        return new SettingsConfigProviderImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ SettingsConfigProvider newInstance() {
        return newInstance();
    }
}
