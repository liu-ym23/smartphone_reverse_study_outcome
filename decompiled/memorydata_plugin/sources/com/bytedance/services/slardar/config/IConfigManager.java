package com.bytedance.services.slardar.config;

import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String r1, int r2);

    JSONObject getConfigJSON(String r1);

    boolean getLogTypeSwitch(String r1);

    boolean getMetricTypeSwitch(String r1);

    boolean getServiceSwitch(String r1);

    boolean getSwitch(String r1);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(a r1);

    void registerResponseConfigListener(b r1);

    JSONObject retrieveSettingsParams();

    void unregisterConfigListener(a r1);

    void unregisterResponseConfigListener(b r1);

    boolean updateWithSpecificAidResult(JSONObject r1);
}
