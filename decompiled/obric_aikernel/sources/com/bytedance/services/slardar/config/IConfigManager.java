package com.bytedance.services.slardar.config;

import androidx.annotation.Nullable;
import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;
import u4.a;
import u4.b;

/* JADX INFO: loaded from: classes.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String r10, int r11);

    @Nullable
    JSONObject getConfigJSON(String r10);

    boolean getLogTypeSwitch(String r10);

    boolean getMetricTypeSwitch(String r10);

    boolean getServiceSwitch(String r10);

    boolean getSwitch(String r10);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(a r10);

    void registerResponseConfigListener(b r10);

    JSONObject retrieveSettingsParams();

    void unregisterConfigListener(a r10);

    void unregisterResponseConfigListener(b r10);

    boolean updateWithSpecificAidResult(JSONObject r10);
}
