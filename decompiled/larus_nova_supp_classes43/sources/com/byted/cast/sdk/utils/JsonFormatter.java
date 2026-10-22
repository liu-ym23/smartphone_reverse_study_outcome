package com.byted.cast.sdk.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class JsonFormatter {
    public JsonFormatter() {
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public static JSONObject toJson(Object r10) {
        return new JSONObject(GsonProtectorUtils.toJson(new Gson(), r10));
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static <T> T fromJson(String r1, Class<T> r10) {
        return (T) new Gson().fromJson(String.valueOf(r1), r10);
    L4:
        return null;
    }
}
