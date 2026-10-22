package com.bytedance.ai.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;
import t5.e;
import t5.g;
import t5.i;
import t5.m;
import t5.p;
import t5.r;
import t5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Settings(settingsId = "flow_ai_sdk", storageKey = "ai_sdk_settings")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\tH\u0017J\b\u0010\n\u001a\u00020\u000bH\u0017J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0017¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/settings/IAISDKSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "resourcesManagerConfig", "Lcom/bytedance/ai/settings/provider/ResourcesManagerConfig;", "frontierConfig", "Lcom/bytedance/ai/settings/provider/FrontierConfig;", "widgetSettingsConfig", "Lcom/bytedance/ai/settings/provider/WidgetSettingsConfig;", "lynxTemplateVerifyConfig", "Lcom/bytedance/ai/settings/provider/LynxTemplateVerifyConfig;", "lynxViewReusedConfig", "Lcom/bytedance/ai/settings/provider/LynxViewReusedConfig;", "aiBridgeConfig", "Lcom/bytedance/ai/settings/provider/AIBridgeSettingsConfig;", "optimizeSettings", "Lcom/bytedance/ai/settings/provider/OptimizeSettings;", "appletSettings", "Lcom/bytedance/ai/settings/provider/AppletSettings;", "embedWebviewSettings", "Lcom/bytedance/ai/settings/provider/WebviewSettingsConfig;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAISDKSettings extends ISettings {
    t5.a aiBridgeConfig();

    t5.c appletSettings();

    r embedWebviewSettings();

    e frontierConfig();

    g lynxTemplateVerifyConfig();

    i lynxViewReusedConfig();

    m optimizeSettings();

    p resourcesManagerConfig();

    t widgetSettingsConfig();
}
