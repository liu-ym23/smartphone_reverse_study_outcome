package com.larus.praise.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.google.gson.JsonObject;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Settings(storageKey = "nova_settings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/larus/praise/settings/IPraiseSdkSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getPraiseSdkConfig", "Lcom/google/gson/JsonObject;", "sdk-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IPraiseSdkSettings extends ISettings {
    JsonObject getPraiseSdkConfig();
}
