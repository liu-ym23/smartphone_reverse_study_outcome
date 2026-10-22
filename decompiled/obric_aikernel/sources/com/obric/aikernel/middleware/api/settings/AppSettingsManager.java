package com.obric.aikernel.middleware.api.settings;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import s7.b;
import s7.c;
import s7.d;
import s7.f;
import s7.g;
import s7.h;
import s7.i;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSettingsManager implements ISettingsManager {
    public static final AppSettingsManager INSTANCE = null;
    private final /* synthetic */ ISettingsManager $$delegate_0;

    static {
        INSTANCE = new AppSettingsManager();
    }

    private AppSettingsManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(ISettingsManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (ISettingsManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public String getABValueWith(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.$$delegate_0.getABValueWith(r10);
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public String getAppValueWith(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.$$delegate_0.getAppValueWith(r10);
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public b getCloudSlmInterceptorSetting() {
        return this.$$delegate_0.getCloudSlmInterceptorSetting();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public c getMemoryCollectSetting() {
        return this.$$delegate_0.getMemoryCollectSetting();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public d getModelQuotaConfigs() {
        return this.$$delegate_0.getModelQuotaConfigs();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public g getSettingsSetting() {
        return this.$$delegate_0.getSettingsSetting();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public h getTTNetStandbySettings() {
        return this.$$delegate_0.getTTNetStandbySettings();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public i getVmSettings() {
        return this.$$delegate_0.getVmSettings();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void registerObserver(f r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        this.$$delegate_0.registerObserver(r10);
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void unregisterObserver(f r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        this.$$delegate_0.unregisterObserver(r10);
    }

    @Override // com.obric.aikernel.middleware.api.settings.ISettingsManager
    public void update() {
        this.$$delegate_0.update();
    }
}
