package com.obric.miniapp.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Settings(settingsId = "obric-mini-app", storageKey = "obric_mini_app_settings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"Lcom/obric/miniapp/settings/IMiniAppSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "miniAppConfig", "Lcom/obric/miniapp/settings/provider/MiniAppConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMiniAppSettings extends ISettings {
    ela.a miniAppConfig();
}
