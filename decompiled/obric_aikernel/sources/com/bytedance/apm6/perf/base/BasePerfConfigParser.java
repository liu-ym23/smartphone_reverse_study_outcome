package com.bytedance.apm6.perf.base;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BasePerfConfigParser {
    private static final String PERF_KEY = "performance_modules";

    public BasePerfConfigParser() {
    }

    public static JSONObject parseData(JSONObject r10, String r11) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.optJSONObject("performance_modules").optJSONObject(r11);
    L7:
        return null;
    }
}
