package com.obric.memorydata.middleware.impl.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@com.bytedance.news.common.settings.api.annotation.a(a = "memory_data_settings")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\b\u001a\u00020\tH'J\b\u0010\n\u001a\u00020\u000bH'J\b\u0010\f\u001a\u00020\rH'J\b\u0010\u000e\u001a\u00020\u000fH'J\b\u0010\u0010\u001a\u00020\u0011H'¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/AppInfoSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "reportPackageNameBlackListSetting", "Lcom/obric/memorydata/middleware/impl/settings/ReportPackageNameBlackListSetting;", "featureCollectSetting", "Lcom/obric/memorydata/middleware/impl/settings/FeatureCollectSetting;", "appEntityIndexSettings", "Lcom/obric/memorydata/middleware/impl/settings/AppEntityIndexSetting;", "ocrSettings", "Lcom/obric/memorydata/middleware/impl/settings/OcrSettings;", "recommedSettings", "Lcom/obric/memorydata/middleware/impl/settings/RecommendSettings;", "dataUploadSettings", "Lcom/obric/memorydata/middleware/impl/settings/DataUploadSettings;", "proactiveSettings", "Lcom/obric/memorydata/middleware/impl/settings/ProactiveSettings;", "commonFeatureSettings", "Lcom/obric/memorydata/middleware/impl/settings/CommonFeatureSettings;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AppInfoSettings extends ISettings {
    a appEntityIndexSettings();

    c commonFeatureSettings();

    d dataUploadSettings();

    e featureCollectSetting();

    f ocrSettings();

    h proactiveSettings();

    i recommedSettings();

    j reportPackageNameBlackListSetting();
}
