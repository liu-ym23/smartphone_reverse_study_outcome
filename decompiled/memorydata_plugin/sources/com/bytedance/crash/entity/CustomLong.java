package com.bytedance.crash.entity;

import com.bytedance.crash.util.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CustomLong {
    public static final String TAG = "custom_long";

    public CustomLong() {
    }

    public static void add(JSONObject r1, String r2, JSONArray r3) {
        if (r3.length() == 0) goto L6;
        JSONUtils.put(JSONUtils.get(r1, TAG), r2, r3);
        return;
    }
}
