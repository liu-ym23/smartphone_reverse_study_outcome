package com.bytedance.services.slardar.config;

import androidx.annotation.Nullable;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;
import pj.a;
import pj.b;

/* JADX INFO: loaded from: classes2.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String r5, int r10);

    @Nullable
    JSONObject getConfigJSON(String r5);

    boolean getLogTypeSwitch(String r5);

    boolean getMetricTypeSwitch(String r5);

    boolean getServiceSwitch(String r5);

    boolean getSwitch(String r5);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(a r5);

    void registerResponseConfigListener(b r5);

    JSONObject retrieveSettingsParams();

    void unregisterConfigListener(a r5);

    void unregisterResponseConfigListener(b r5);

    boolean updateWithSpecificAidResult(JSONObject r5);
}
