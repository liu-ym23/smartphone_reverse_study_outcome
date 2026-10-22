package com.obric.memorydata.middleware.impl.settings;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.IAppEntityIndexSetting;
import com.obric.memorydata.middleware.api.settings.ICommonFeatureSettings;
import com.obric.memorydata.middleware.api.settings.IDataUploadSettings;
import com.obric.memorydata.middleware.api.settings.IFeatureCollectSetting;
import com.obric.memorydata.middleware.api.settings.IOcrSetting;
import com.obric.memorydata.middleware.api.settings.IProactiveSettings;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.middleware.api.settings.IReportPackageNameBlackListSetting;
import com.obric.memorydata.middleware.api.settings.ISettingsManager;
import com.obric.memorydata.middleware.impl.bdtracker.MemoryAppLogSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/AppSettingsManager;", "Lcom/obric/memorydata/middleware/api/settings/ISettingsManager;", "<init>", "()V", "hasUpdatedSettings", "", "getInst", "appSettingsConfig", "Lcom/obric/memorydata/middleware/impl/settings/AppSettingsConfig;", "getAppSettingsConfig", "()Lcom/obric/memorydata/middleware/impl/settings/AppSettingsConfig;", "appSettingsConfig$delegate", "Lkotlin/Lazy;", "inited", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "updateSettingsIfNeeded", InfoRequestQPSOptTraceLogger.REASON, "", "hasInited", "requestUpdate", "getAppValueWith", "key", "getABValueWith", "getReportPackageNameBlackListSetting", "Lcom/obric/memorydata/middleware/api/settings/IReportPackageNameBlackListSetting;", "getFeatureProducerSetting", "Lcom/obric/memorydata/middleware/api/settings/IFeatureCollectSetting;", "getAppEntityIndexSetting", "Lcom/obric/memorydata/middleware/api/settings/IAppEntityIndexSetting;", "getOcrSetting", "Lcom/obric/memorydata/middleware/api/settings/IOcrSetting;", "getDataUploadSettings", "Lcom/obric/memorydata/middleware/api/settings/IDataUploadSettings;", "getRecommendSettings", "Lcom/obric/memorydata/middleware/api/settings/IRecommendSettings;", "getProactiveSettings", "Lcom/obric/memorydata/middleware/api/settings/IProactiveSettings;", "getCommonFeatureSettings", "Lcom/obric/memorydata/middleware/api/settings/ICommonFeatureSettings;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppSettingsManager implements ISettingsManager {
    public static final AppSettingsManager INSTANCE = null;
    private static final Lazy appSettingsConfig$delegate = null;
    private static volatile boolean hasUpdatedSettings;
    private static boolean inited;

    static {
        INSTANCE = new AppSettingsManager();
        appSettingsConfig$delegate = LazyKt.lazy($$Lambda$AppSettingsManager$wuLexz0fMqZXlBACE8wa_lSsPAY.INSTANCE);
    }

    private AppSettingsManager() {
    }

    private static final b appSettingsConfig_delegate$lambda$0() {
        return new b();
    }

    private final b getAppSettingsConfig() {
        return (b) ZeusTransformUtils.preCheckCast(appSettingsConfig$delegate.getValue(), b.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final AppSettingsManager getInst() {
        return INSTANCE;
    }

    private static final Unit init$lambda$1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        RunLog.INSTANCE.debug("AppSettingsManager", "did changed, should update settings is " + (!hasUpdatedSettings));
        INSTANCE.updateSettingsIfNeeded("did changed");
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$2(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        INSTANCE.updateSettingsIfNeeded("did loaded");
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        RunLog.INSTANCE.debug("AppSettingsManager", "did is not empty");
        INSTANCE.updateSettingsIfNeeded("did is not empty");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$2Dg3YOWxSo8PazXtEBDCWrTBMDQ(String r0) {
        return init$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$YAogtkb_i5b-cB0sfFiuoN-lnUA, reason: not valid java name */
    public static /* synthetic */ Unit m1035lambda$YAogtkb_i5bcB0sfFiuoNlnUA(String r0) {
        return init$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$ldmlEZ9mONxPpdlpVtR5deve-n8, reason: not valid java name */
    public static /* synthetic */ Unit m1036lambda$ldmlEZ9mONxPpdlpVtR5deven8(String r0) {
        return init$lambda$1(r0);
    }

    public static /* synthetic */ b lambda$wuLexz0fMqZXlBACE8wa_lSsPAY() {
        return appSettingsConfig_delegate$lambda$0();
    }

    private final void updateSettingsIfNeeded(String r2) {
        if (hasUpdatedSettings == false) goto L5;
        return;
    L5:
        hasUpdatedSettings = true;
        com.bytedance.news.common.settings.e.a(true);
        RunLog.INSTANCE.debug("InitSettingsTask", r2 + " and update now");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public String getABValueWith(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IAppEntityIndexSetting getAppEntityIndexSetting() {
        return (IAppEntityIndexSetting) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).appEntityIndexSettings(), IAppEntityIndexSetting.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public String getAppValueWith(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return getAppSettingsConfig().a(r2);
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public ICommonFeatureSettings getCommonFeatureSettings() {
        return (ICommonFeatureSettings) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).commonFeatureSettings(), ICommonFeatureSettings.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IDataUploadSettings getDataUploadSettings() {
        return (IDataUploadSettings) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).dataUploadSettings(), IDataUploadSettings.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IFeatureCollectSetting getFeatureProducerSetting() {
        return (IFeatureCollectSetting) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).featureCollectSetting(), IFeatureCollectSetting.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IOcrSetting getOcrSetting() {
        return (IOcrSetting) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).ocrSettings(), IOcrSetting.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IProactiveSettings getProactiveSettings() {
        return (IProactiveSettings) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).proactiveSettings(), IProactiveSettings.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IRecommendSettings getRecommendSettings() {
        return (IRecommendSettings) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).recommedSettings(), IRecommendSettings.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public IReportPackageNameBlackListSetting getReportPackageNameBlackListSetting() {
        return (IReportPackageNameBlackListSetting) ZeusTransformUtils.preCheckCast(((AppInfoSettings) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.settings.e.a(AppInfoSettings.class), AppInfoSettings.class, "com.obric.memorydata.plugin")).reportPackageNameBlackListSetting(), IReportPackageNameBlackListSetting.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public boolean hasInited() {
        return inited;
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public void init() {
        getAppSettingsConfig().a();
        inited = true;
        MemoryAppLogSettings.INSTANCE.registerDidListener($$Lambda$AppSettingsManager$ldmlEZ9mONxPpdlpVtR5deven8.INSTANCE, $$Lambda$AppSettingsManager$YAogtkb_i5bcB0sfFiuoNlnUA.INSTANCE, $$Lambda$AppSettingsManager$2Dg3YOWxSo8PazXtEBDCWrTBMDQ.INSTANCE);
    }

    @Override // com.obric.memorydata.middleware.api.settings.ISettingsManager
    public boolean requestUpdate() {
        if (inited == true) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppSettingsManager", "skip settings update, manager not initialized", null, 4, null);
        return false;
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        AppSettingsManager r8 = (AppSettingsManager) ZeusTransformUtils.preCheckCast(this, AppSettingsManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        com.bytedance.news.common.settings.e.a(true);     // Catch: Throwable -> L8
        Object r9 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L8
    L10:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r9);
        if (r1 == null) goto L14;
        RunLog.INSTANCE.warn("AppSettingsManager", "request settings update failed", r1);
    L14:
        if (Result.m1427isFailureimpl(r9) == false) goto L17;
        r9 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
