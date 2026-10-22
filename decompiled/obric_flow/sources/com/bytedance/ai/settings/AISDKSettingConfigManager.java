package com.bytedance.ai.settings;

import com.bytedance.ai.settings.provider.LynxTemplateVerifyConfig;
import com.bytedance.ai.settings.provider.LynxViewReusedConfig;
import com.bytedance.ai.settings.provider.OptimizeSettings;
import com.bytedance.ai.settings.provider.RelaxConfig;
import com.bytedance.ai.settings.provider.WidgetSettingsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\bR\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\bR\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\bR\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\b¨\u0006-"}, d2 = {"Lcom/bytedance/ai/settings/AISDKSettingConfigManager;", "", "<init>", "()V", "PACKAGE_DOWNLOAD_TYPE", "Lcom/bytedance/ai/settings/AISDKSetting;", "", "getPACKAGE_DOWNLOAD_TYPE", "()Lcom/bytedance/ai/settings/AISDKSetting;", "FRONTIER_SERVER_ID", "getFRONTIER_SERVER_ID", "WIDGET_SETTINGS_CONFIG", "Lcom/bytedance/ai/settings/provider/WidgetSettingsConfig;", "getWIDGET_SETTINGS_CONFIG", "LYNX_TEMPLATE_VERIFY_CONFIG", "Lcom/bytedance/ai/settings/provider/LynxTemplateVerifyConfig;", "getLYNX_TEMPLATE_VERIFY_CONFIG", "GECKO_HOST_VERSION", "getGECKO_HOST_VERSION", "REQUEST_WHITE_LIST", "", "", "getREQUEST_WHITE_LIST", "LYNX_VIEW_REUSED_CONFIG", "Lcom/bytedance/ai/settings/provider/LynxViewReusedConfig;", "getLYNX_VIEW_REUSED_CONFIG", "MUST_RUN_IN_MAIN_JSB_LIST", "getMUST_RUN_IN_MAIN_JSB_LIST", "RELAX_CONFIG", "Lcom/bytedance/ai/settings/provider/RelaxConfig;", "getRELAX_CONFIG", "OPTIMIZE_SETTINGS", "Lcom/bytedance/ai/settings/provider/OptimizeSettings;", "getOPTIMIZE_SETTINGS", "CUSTOM_DOWNLOAD_PACKAGE_LIST", "getCUSTOM_DOWNLOAD_PACKAGE_LIST", "CUSTOM_UPDATE_INTERVAL", "", "getCUSTOM_UPDATE_INTERVAL", "OFFLINE_FILE_VERSION", "getOFFLINE_FILE_VERSION", "FORCE_UPDATE_CHANNEL_LIST", "getFORCE_UPDATE_CHANNEL_LIST", "FIRST_APP_PACKAGE_LIST", "getFIRST_APP_PACKAGE_LIST", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AISDKSettingConfigManager {
    private static final AISDKSetting<List<String>> CUSTOM_DOWNLOAD_PACKAGE_LIST = null;
    private static final AISDKSetting<Long> CUSTOM_UPDATE_INTERVAL = null;
    private static final AISDKSetting<List<String>> FIRST_APP_PACKAGE_LIST = null;
    private static final AISDKSetting<List<String>> FORCE_UPDATE_CHANNEL_LIST = null;
    private static final AISDKSetting<Integer> FRONTIER_SERVER_ID = null;
    private static final AISDKSetting<Integer> GECKO_HOST_VERSION = null;
    public static final AISDKSettingConfigManager INSTANCE = null;
    private static final AISDKSetting<LynxTemplateVerifyConfig> LYNX_TEMPLATE_VERIFY_CONFIG = null;
    private static final AISDKSetting<LynxViewReusedConfig> LYNX_VIEW_REUSED_CONFIG = null;
    private static final AISDKSetting<List<String>> MUST_RUN_IN_MAIN_JSB_LIST = null;
    private static final AISDKSetting<Integer> OFFLINE_FILE_VERSION = null;
    private static final AISDKSetting<OptimizeSettings> OPTIMIZE_SETTINGS = null;
    private static final AISDKSetting<Integer> PACKAGE_DOWNLOAD_TYPE = null;
    private static final AISDKSetting<RelaxConfig> RELAX_CONFIG = null;
    private static final AISDKSetting<List<String>> REQUEST_WHITE_LIST = null;
    private static final AISDKSetting<WidgetSettingsConfig> WIDGET_SETTINGS_CONFIG = null;

    static {
        INSTANCE = new AISDKSettingConfigManager();
        PACKAGE_DOWNLOAD_TYPE = new AISDKSetting("downloadType", "switch to change the mode of resource loading", Integer.valueOf(AISDKSettingsCore.c().resourcesManagerConfig().f()));
        FRONTIER_SERVER_ID = new AISDKSetting("frontierServerId", "config frontier serverId from Settings", Integer.valueOf(AISDKSettingsCore.c().frontierConfig().a()));
        WIDGET_SETTINGS_CONFIG = new AISDKSetting("widgetSettingsConfig", "widget config from Settings", AISDKSettingsCore.c().widgetSettingsConfig());
        LYNX_TEMPLATE_VERIFY_CONFIG = new AISDKSetting("lynxTemplateVerifyConfig", "verify lynx template domain", AISDKSettingsCore.c().lynxTemplateVerifyConfig());
        GECKO_HOST_VERSION = new AISDKSetting("geckoHostVersion", "update gecko host once the value of version is changed ", Integer.valueOf(AISDKSettingsCore.c().resourcesManagerConfig().d()));
        List r5 = AISDKSettingsCore.c().resourcesManagerConfig().g();
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        REQUEST_WHITE_LIST = new AISDKSetting("requestWhiteList", "AISDK will not intercept the url included in this list when WebView load it", r5);
        LYNX_VIEW_REUSED_CONFIG = new AISDKSetting("lynxViewReusedConfig", "widget lynx widget reused config", AISDKSettingsCore.c().lynxViewReusedConfig());
        List r10 = AISDKSettingsCore.c().aiBridgeConfig().a();
        if (r10 != null) goto L8;
        r10 = CollectionsKt.emptyList();
    L8:
        MUST_RUN_IN_MAIN_JSB_LIST = new AISDKSetting("aiBridgeConfig", "the list of jsbs which must run in the main thread", r10);
        RELAX_CONFIG = new AISDKSetting("relaxConfig", "relax config", AISDKSettingsCore.c().relaxConfig());
        OPTIMIZE_SETTINGS = new AISDKSetting("optimizeSettings", "optimize settings", AISDKSettingsCore.c().optimizeSettings());
        List r11 = AISDKSettingsCore.c().resourcesManagerConfig().a();
        if (r11 != null) goto L11;
        r11 = CollectionsKt.emptyList();
    L11:
        CUSTOM_DOWNLOAD_PACKAGE_LIST = new AISDKSetting("customDownloadPackageList", "The list that includes the packages which are downloaded with custom mode even if downloadType is 0", r11);
        CUSTOM_UPDATE_INTERVAL = new AISDKSetting("customUpdateInterval", "The interval of checking update", Long.valueOf(AISDKSettingsCore.c().resourcesManagerConfig().h()));
        OFFLINE_FILE_VERSION = new AISDKSetting("offlineFileVersion", "update offline file once the value is changed", Integer.valueOf(AISDKSettingsCore.c().resourcesManagerConfig().e()));
        List r12 = AISDKSettingsCore.c().resourcesManagerConfig().c();
        if (r12 != null) goto L14;
        r12 = CollectionsKt.emptyList();
    L14:
        FORCE_UPDATE_CHANNEL_LIST = new AISDKSetting("forceUpdateChannelList", "The list that should be updated before it's loaded", r12);
        List r13 = AISDKSettingsCore.c().resourcesManagerConfig().b();
        if (r13 != null) goto L17;
        r13 = CollectionsKt.emptyList();
    L17:
        FIRST_APP_PACKAGE_LIST = new AISDKSetting("firstAppPackageList", "The list includes the packages which are developed by internal team and downloaded with custom mode even if downloadType is 0", r13);
    }

    private AISDKSettingConfigManager() {
    }

    public final AISDKSetting<List<String>> getCUSTOM_DOWNLOAD_PACKAGE_LIST() {
        return CUSTOM_DOWNLOAD_PACKAGE_LIST;
    }

    public final AISDKSetting<Long> getCUSTOM_UPDATE_INTERVAL() {
        return CUSTOM_UPDATE_INTERVAL;
    }

    public final AISDKSetting<List<String>> getFIRST_APP_PACKAGE_LIST() {
        return FIRST_APP_PACKAGE_LIST;
    }

    public final AISDKSetting<List<String>> getFORCE_UPDATE_CHANNEL_LIST() {
        return FORCE_UPDATE_CHANNEL_LIST;
    }

    public final AISDKSetting<Integer> getFRONTIER_SERVER_ID() {
        return FRONTIER_SERVER_ID;
    }

    public final AISDKSetting<Integer> getGECKO_HOST_VERSION() {
        return GECKO_HOST_VERSION;
    }

    public final AISDKSetting<LynxTemplateVerifyConfig> getLYNX_TEMPLATE_VERIFY_CONFIG() {
        return LYNX_TEMPLATE_VERIFY_CONFIG;
    }

    public final AISDKSetting<LynxViewReusedConfig> getLYNX_VIEW_REUSED_CONFIG() {
        return LYNX_VIEW_REUSED_CONFIG;
    }

    public final AISDKSetting<List<String>> getMUST_RUN_IN_MAIN_JSB_LIST() {
        return MUST_RUN_IN_MAIN_JSB_LIST;
    }

    public final AISDKSetting<Integer> getOFFLINE_FILE_VERSION() {
        return OFFLINE_FILE_VERSION;
    }

    public final AISDKSetting<OptimizeSettings> getOPTIMIZE_SETTINGS() {
        return OPTIMIZE_SETTINGS;
    }

    public final AISDKSetting<Integer> getPACKAGE_DOWNLOAD_TYPE() {
        return PACKAGE_DOWNLOAD_TYPE;
    }

    public final AISDKSetting<RelaxConfig> getRELAX_CONFIG() {
        return RELAX_CONFIG;
    }

    public final AISDKSetting<List<String>> getREQUEST_WHITE_LIST() {
        return REQUEST_WHITE_LIST;
    }

    public final AISDKSetting<WidgetSettingsConfig> getWIDGET_SETTINGS_CONFIG() {
        return WIDGET_SETTINGS_CONFIG;
    }
}
