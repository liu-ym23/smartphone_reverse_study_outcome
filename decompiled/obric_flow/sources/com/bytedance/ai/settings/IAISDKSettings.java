package com.bytedance.ai.settings;

import com.bytedance.ai.settings.provider.AIBridgeSettingsConfig;
import com.bytedance.ai.settings.provider.FrontierConfig;
import com.bytedance.ai.settings.provider.LynxTemplateVerifyConfig;
import com.bytedance.ai.settings.provider.LynxViewReusedConfig;
import com.bytedance.ai.settings.provider.OptimizeSettings;
import com.bytedance.ai.settings.provider.RelaxConfig;
import com.bytedance.ai.settings.provider.ResourcesManagerConfig;
import com.bytedance.ai.settings.provider.WidgetSettingsConfig;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import kotlin.Metadata;
import rg.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\tH\u0017J\b\u0010\n\u001a\u00020\u000bH\u0017J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\u0011H\u0017¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/settings/IAISDKSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "resourcesManagerConfig", "Lcom/bytedance/ai/settings/provider/ResourcesManagerConfig;", "frontierConfig", "Lcom/bytedance/ai/settings/provider/FrontierConfig;", "widgetSettingsConfig", "Lcom/bytedance/ai/settings/provider/WidgetSettingsConfig;", "lynxTemplateVerifyConfig", "Lcom/bytedance/ai/settings/provider/LynxTemplateVerifyConfig;", "lynxViewReusedConfig", "Lcom/bytedance/ai/settings/provider/LynxViewReusedConfig;", "aiBridgeConfig", "Lcom/bytedance/ai/settings/provider/AIBridgeSettingsConfig;", "relaxConfig", "Lcom/bytedance/ai/settings/provider/RelaxConfig;", "optimizeSettings", "Lcom/bytedance/ai/settings/provider/OptimizeSettings;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@a(settingsId = "flow_ai_sdk", storageKey = "ai_sdk_settings")
public interface IAISDKSettings extends ISettings {
    AIBridgeSettingsConfig aiBridgeConfig();

    FrontierConfig frontierConfig();

    LynxTemplateVerifyConfig lynxTemplateVerifyConfig();

    LynxViewReusedConfig lynxViewReusedConfig();

    OptimizeSettings optimizeSettings();

    RelaxConfig relaxConfig();

    ResourcesManagerConfig resourcesManagerConfig();

    WidgetSettingsConfig widgetSettingsConfig();
}
