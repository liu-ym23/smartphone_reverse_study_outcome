package com.bytedance.ai.settings;

import com.bytedance.ai.settings.provider.AIBridgeSettingsConfig;
import com.bytedance.ai.settings.provider.FrontierConfig;
import com.bytedance.ai.settings.provider.LynxTemplateVerifyConfig;
import com.bytedance.ai.settings.provider.LynxViewReusedConfig;
import com.bytedance.ai.settings.provider.OptimizeSettings;
import com.bytedance.ai.settings.provider.RelaxConfig;
import com.bytedance.ai.settings.provider.ResourcesManagerConfig;
import com.bytedance.ai.settings.provider.WidgetSettingsConfig;
import kotlin.Metadata;
import qg.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/settings/DefaultValueAISDKSettings;", "Lcom/bytedance/ai/settings/IAISDKSettings;", "<init>", "()V", "Lqg/c;", "settingsData", "", "updateSettings", "(Lqg/c;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultValueAISDKSettings implements IAISDKSettings {
    public static final DefaultValueAISDKSettings INSTANCE = null;

    static {
        INSTANCE = new DefaultValueAISDKSettings();
    }

    private DefaultValueAISDKSettings() {
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public AIBridgeSettingsConfig aiBridgeConfig() {
        return new AIBridgeSettingsConfig();
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public FrontierConfig frontierConfig() {
        return new FrontierConfig();
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public LynxTemplateVerifyConfig lynxTemplateVerifyConfig() {
        return new LynxTemplateVerifyConfig(0);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public LynxViewReusedConfig lynxViewReusedConfig() {
        return new LynxViewReusedConfig(0);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public OptimizeSettings optimizeSettings() {
        return new OptimizeSettings(0);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public RelaxConfig relaxConfig() {
        return new RelaxConfig(0);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public ResourcesManagerConfig resourcesManagerConfig() {
        return new ResourcesManagerConfig();
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ISettings
    public void updateSettings(c r5) {
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public WidgetSettingsConfig widgetSettingsConfig() {
        return new WidgetSettingsConfig(0);
    }
}
