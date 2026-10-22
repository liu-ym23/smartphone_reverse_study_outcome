package com.bytedance.android.live.browser.jsbridge;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public static JSONObject a(int r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("status_code", r2);     // Catch: JSONException -> L5
        r0.put("message", r3);     // Catch: JSONException -> L5
    L4:
        return r0;
    }
}
