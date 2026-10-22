package com.ss.android.cert.manager.ablity;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ICertMonitorConfig {
    int getAppId();

    void onEvent(String r1, JSONObject r2);
}
