package com.bytedance.android.live.core.utils;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class JsonUtil {
    private static JsonParser jsonParser;

    static {
        jsonParser = new JsonParser();
    }

    private JsonUtil() {
    }

    public static JSONObject copyJson2(JSONObject r4) throws JSONException {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L8;
        return null;
    L8:
        JSONObject r0 = new JSONObject();
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        r0.put(r2, r4.opt(r2));
        goto L10
    L12:
        return r0;
    }

    public static Map<String, String> jsonObjectToLinkedMap(JSONObject r5) {
        if (r5 == null) goto L4;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1.hasNext() == false) goto L11;
        String r2 = r1.next();
        String r3 = r5.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r0.put(r2, r3);
        goto L7
    L11:
        return r0;
    L4:
        return new LinkedHashMap();
    }

    public static Map<String, String> jsonObjectToMap(JSONObject r5) {
        if (r5 == null) goto L4;
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1.hasNext() == false) goto L11;
        String r2 = r1.next();
        String r3 = r5.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r0.put(r2, r3);
        goto L7
    L11:
        return r0;
    L4:
        return new HashMap();
    }

    public static JsonObject parseObject(String r1) throws JsonParseException {
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return null;
    L11:
        return jsonParser.parse(r1).getAsJsonObject();
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static String toJSONString(Object r1) throws JsonParseException {
        if (r1 != null) goto L10;
        return "";
    L10:
        return GsonHelper.get().toJson(r1);
    L7:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static <T> T parse(String r2, Type r3) {
        if (r2 != null) goto L10;
        return null;
    L10:
        return (T) GsonHelper.get().fromJson(r2, r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static <T> T parseObject(byte[] r3, Class<T> r4) throws JsonParseException {
        if (r3.length != 0) goto L11;
        return null;
    L11:
        return (T) GsonHelper.get().fromJson(new InputStreamReader(new ByteArrayInputStream(r3)), r4);
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static <T> T parseObject(String r1, Class<T> r2) throws JsonParseException {
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return null;
    L11:
        return (T) GsonHelper.get().fromJson(r1, r2);
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }
}
