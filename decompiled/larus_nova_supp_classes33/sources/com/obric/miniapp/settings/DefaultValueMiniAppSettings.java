package com.obric.miniapp.settings;

import com.bytedance.news.common.settings.api.SettingsData;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/miniapp/settings/DefaultValueMiniAppSettings;", "Lcom/obric/miniapp/settings/IMiniAppSettings;", "<init>", "()V", "updateSettings", "", "settingsData", "Lcom/bytedance/news/common/settings/api/SettingsData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultValueMiniAppSettings implements IMiniAppSettings {
    public static final DefaultValueMiniAppSettings INSTANCE = null;

    static {
        INSTANCE = new DefaultValueMiniAppSettings();
    }

    private DefaultValueMiniAppSettings() {
    }

    public void updateSettings(SettingsData r1) {
    }

    @Override // com.obric.miniapp.settings.IMiniAppSettings
    public ela.a miniAppConfig() {
        return new ela.a(null);
    }
}
