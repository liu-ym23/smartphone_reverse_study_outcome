package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.larus.settings.SettingsConfigProviderImpl;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SettingsConfigProvider__ServiceProxy implements IServiceProxy<SettingsConfigProvider> {
    public SettingsConfigProvider__ServiceProxy() {
    }

    public SettingsConfigProvider newInstance() {
        return new SettingsConfigProviderImpl();
    }

    /* JADX INFO: renamed from: newInstance, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8newInstance() {
        return newInstance();
    }

    public void collectService(Map<String, String> r3) {
        r3.put("com.bytedance.news.common.settings.SettingsConfigProvider", "com.larus.settings.SettingsConfigProviderImpl");
    }
}
