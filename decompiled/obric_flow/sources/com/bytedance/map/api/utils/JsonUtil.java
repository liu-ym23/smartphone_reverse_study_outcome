package com.bytedance.map.api.utils;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonUtil {
    public static void a(JSONObject r5, String r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L12;
        r5.put(r10, r11);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
