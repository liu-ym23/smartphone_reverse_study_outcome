package com.ss.bduploader.smartserver;

import com.ss.ugc.clientai.core.api.SmartInputData;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public interface SmartServiceInterface {
    void configServer();

    int getIntelligentInput(JSONObject r1, SmartInputData r2);

    void preloadEnv();

    void runAsync(Map r1, SmartServiceListener r2);

    float runAsyncJsonObject(JSONObject r1, SmartServiceListener r2);

    float runSync(Map r1);

    float runSyncJsonObject(JSONObject r1);

    boolean serviceEnabled();

    void setIntValue(int r1, int r2);

    void setStringValue(int r1, String r2);
}
