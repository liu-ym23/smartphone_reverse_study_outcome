package com.bytedance.services.slardar.config;

import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;
import v8.a;
import v8.b;

/* JADX INFO: loaded from: classes.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String r8, int r10);

    JSONObject getConfigJSON(String r8);

    boolean getLogTypeSwitch(String r8);

    boolean getMetricTypeSwitch(String r8);

    boolean getServiceSwitch(String r8);

    boolean getSwitch(String r8);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(a r8);

    void registerResponseConfigListener(b r8);

    void unregisterConfigListener(a r8);

    void unregisterResponseConfigListener(b r8);
}
