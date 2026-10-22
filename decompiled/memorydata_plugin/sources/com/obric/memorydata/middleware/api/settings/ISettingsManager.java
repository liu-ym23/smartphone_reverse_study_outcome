package com.obric.memorydata.middleware.api.settings;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/ISettingsManager;", "Lcom/bytedance/news/common/service/manager/IService;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "hasInited", "", "requestUpdate", "getAppValueWith", "", "key", "getABValueWith", "getReportPackageNameBlackListSetting", "Lcom/obric/memorydata/middleware/api/settings/IReportPackageNameBlackListSetting;", "getFeatureProducerSetting", "Lcom/obric/memorydata/middleware/api/settings/IFeatureCollectSetting;", "getAppEntityIndexSetting", "Lcom/obric/memorydata/middleware/api/settings/IAppEntityIndexSetting;", "getOcrSetting", "Lcom/obric/memorydata/middleware/api/settings/IOcrSetting;", "getDataUploadSettings", "Lcom/obric/memorydata/middleware/api/settings/IDataUploadSettings;", "getRecommendSettings", "Lcom/obric/memorydata/middleware/api/settings/IRecommendSettings;", "getProactiveSettings", "Lcom/obric/memorydata/middleware/api/settings/IProactiveSettings;", "getCommonFeatureSettings", "Lcom/obric/memorydata/middleware/api/settings/ICommonFeatureSettings;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ISettingsManager extends IService {
    String getABValueWith(String r1);

    IAppEntityIndexSetting getAppEntityIndexSetting();

    String getAppValueWith(String r1);

    ICommonFeatureSettings getCommonFeatureSettings();

    IDataUploadSettings getDataUploadSettings();

    IFeatureCollectSetting getFeatureProducerSetting();

    IOcrSetting getOcrSetting();

    IProactiveSettings getProactiveSettings();

    IRecommendSettings getRecommendSettings();

    IReportPackageNameBlackListSetting getReportPackageNameBlackListSetting();

    boolean hasInited();

    void init();

    boolean requestUpdate();
}
