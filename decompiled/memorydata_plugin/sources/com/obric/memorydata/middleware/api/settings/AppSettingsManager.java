package com.obric.memorydata.middleware.api.settings;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0019H\u0096\u0001¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/AppSettingsManager;", "Lcom/obric/memorydata/middleware/api/settings/ISettingsManager;", "<init>", "()V", "getABValueWith", "", "key", "getAppEntityIndexSetting", "Lcom/obric/memorydata/middleware/api/settings/IAppEntityIndexSetting;", "getAppValueWith", "getCommonFeatureSettings", "Lcom/obric/memorydata/middleware/api/settings/ICommonFeatureSettings;", "getDataUploadSettings", "Lcom/obric/memorydata/middleware/api/settings/IDataUploadSettings;", "getFeatureProducerSetting", "Lcom/obric/memorydata/middleware/api/settings/IFeatureCollectSetting;", "getOcrSetting", "Lcom/obric/memorydata/middleware/api/settings/IOcrSetting;", "getProactiveSettings", "Lcom/obric/memorydata/middleware/api/settings/IProactiveSettings;", "getRecommendSettings", "Lcom/obric/memorydata/middleware/api/settings/IRecommendSettings;", "getReportPackageNameBlackListSetting", "Lcom/obric/memorydata/middleware/api/settings/IReportPackageNameBlackListSetting;", "hasInited", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "requestUpdate", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppSettingsManager implements ISettingsManager {
    public static final AppSettingsManager INSTANCE = null;
    private final /* synthetic */ ISettingsManager $$delegate_0;

    static {
        INSTANCE = new AppSettingsManager();
    }

    private AppSettingsManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ISettingsManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ISettingsManager) ZeusTransformUtils.preCheckCast(r0, ISettingsManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public String getABValueWith(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.$$delegate_0.getABValueWith(r2);
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IAppEntityIndexSetting getAppEntityIndexSetting() {
        return this.$$delegate_0.getAppEntityIndexSetting();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public String getAppValueWith(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.$$delegate_0.getAppValueWith(r2);
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public ICommonFeatureSettings getCommonFeatureSettings() {
        return this.$$delegate_0.getCommonFeatureSettings();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IDataUploadSettings getDataUploadSettings() {
        return this.$$delegate_0.getDataUploadSettings();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IFeatureCollectSetting getFeatureProducerSetting() {
        return this.$$delegate_0.getFeatureProducerSetting();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IOcrSetting getOcrSetting() {
        return this.$$delegate_0.getOcrSetting();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IProactiveSettings getProactiveSettings() {
        return this.$$delegate_0.getProactiveSettings();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IRecommendSettings getRecommendSettings() {
        return this.$$delegate_0.getRecommendSettings();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IReportPackageNameBlackListSetting getReportPackageNameBlackListSetting() {
        return this.$$delegate_0.getReportPackageNameBlackListSetting();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public boolean hasInited() {
        return this.$$delegate_0.hasInited();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public boolean requestUpdate() {
        return this.$$delegate_0.requestUpdate();
    }
}
