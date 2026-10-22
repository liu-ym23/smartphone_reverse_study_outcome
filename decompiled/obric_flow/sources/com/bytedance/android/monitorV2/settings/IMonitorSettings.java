package com.bytedance.android.monitorV2.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/IMonitorSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "Lcom/bytedance/android/monitorV2/settings/h;", "getWebBlankConfig", "()Lcom/bytedance/android/monitorV2/settings/h;", "Lcom/bytedance/android/monitorV2/settings/d;", "getMonitorConfig", "()Lcom/bytedance/android/monitorV2/settings/d;", "Lcom/bytedance/android/monitorV2/settings/c;", "getLynxBlankConfig", "()Lcom/bytedance/android/monitorV2/settings/c;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@rg.a(settingsId = "hybrid_monitor", storageKey = "hybrid_monitor")
public interface IMonitorSettings extends ISettings {
    c getLynxBlankConfig();

    d getMonitorConfig();

    h getWebBlankConfig();
}
