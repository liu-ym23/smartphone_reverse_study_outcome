package com.bytedance.android.live.saas.middleware.applog;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IAppLog {
    String addCommonParams(String r1, boolean r2);

    void addCustomHeader(String r1, String r2);

    String getAbSdkVersion();

    String getCurrentSessionId();

    String getDid();

    String getInstallId();

    boolean isTob();

    void log(String r1, Map<String, String> r2);

    void observeIdChanged(IdChangedCallback r1);

    void onEventV3(String r1, JSONObject r2);

    void putCommonParams(Map<String, String> r1, boolean r2);

    void tryWaitDeviceInit();
}
