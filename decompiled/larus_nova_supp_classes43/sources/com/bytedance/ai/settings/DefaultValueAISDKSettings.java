package com.bytedance.ai.settings;

import com.bytedance.news.common.settings.api.SettingsData;
import kotlin.Metadata;
import t5.e;
import t5.g;
import t5.i;
import t5.m;
import t5.p;
import t5.r;
import t5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/settings/DefaultValueAISDKSettings;", "Lcom/bytedance/ai/settings/IAISDKSettings;", "<init>", "()V", "updateSettings", "", "settingsData", "Lcom/bytedance/news/common/settings/api/SettingsData;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultValueAISDKSettings implements IAISDKSettings {
    public static final DefaultValueAISDKSettings INSTANCE = null;

    static {
        INSTANCE = new DefaultValueAISDKSettings();
    }

    private DefaultValueAISDKSettings() {
    }

    public void updateSettings(SettingsData r1) {
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t5.a aiBridgeConfig() {
        return new t5.a();
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t5.c appletSettings() {
        return new t5.c(null);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public r embedWebviewSettings() {
        return new r(0);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public e frontierConfig() {
        return new e();
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public g lynxTemplateVerifyConfig() {
        return new g(null);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public i lynxViewReusedConfig() {
        return new i(null);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public m optimizeSettings() {
        return new m(null);
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public p resourcesManagerConfig() {
        return new p();
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t widgetSettingsConfig() {
        return new t(null);
    }
}
