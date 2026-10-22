package com.bytedance.crash.entity;

import androidx.annotation.NonNull;
import com.bytedance.crash.util.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomLong {
    public static final String TAG = "custom_long";

    public CustomLong() {
    }

    public static void add(@NonNull JSONObject r10, String r11, JSONArray r12) {
        if (r12.length() == 0) goto L6;
        JSONUtils.put(JSONUtils.get(r10, TAG), r11, r12);
        return;
    }
}
