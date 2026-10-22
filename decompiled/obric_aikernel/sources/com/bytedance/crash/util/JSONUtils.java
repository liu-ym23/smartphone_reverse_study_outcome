package com.bytedance.crash.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class JSONUtils {
    public JSONUtils() {
    }

    public static void addKVs(JSONObject r10, Object... r11) {
        if (r10 == null) goto L14;
        if (r11 == null) goto L14;
        if ((r11.length % 2) != 0) goto L14;
        if (r11.length == 0) goto L14;
        int r12 = 0;
    L11:
        if (r12 >= r11.length) goto L13;
        put(r10, String.valueOf(r11[r12]), r11[r12 + 1]);
        r12 = r12 + 2;
        goto L11
    L13:
        return;
    L14:
        NpthLog.e("JSONUtils", "Err use of addKVs!!!!!");
    }

    public static void append(JSONObject r10, String r11, Object r12) {
        if (r12 == null) goto L8;
        r10.put(r11, String.valueOf(r12));     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static void append(JSONObject r10, String r11, String r12) {
        if (r12 == null) goto L8;
        r10.put(r11, r12);     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static void appendInt(JSONObject r10, String r11, int r12) {
        r10.put(r11, r12);     // Catch: JSONException -> L4
        return;
    }

    public static void appendLong(JSONObject r10, String r11, long r12) {
        r10.put(r11, r12);     // Catch: JSONException -> L4
        return;
    }

    public static void assignIfNoExist(JSONObject r10, JSONObject r11) {
        Iterator<String> r12 = r11.keys();
    L11:
        if (r12.hasNext() == false) goto L18;
        String r13 = r12.next();     // Catch: Throwable -> L10
        if (r10.has(r13) == true) goto L11;
        r10.put(r13, r11.opt(r13));     // Catch: Throwable -> L10
    L18:
        return;
    }

    public static void combineJson(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L32;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() <= 0) goto L53;
        Iterator<String> r12 = r11.keys();     // Catch: JSONException -> L33
    L8:
        if (r12.hasNext() == false) goto L55;
        String r13 = r12.next();     // Catch: JSONException -> L33
        Object r14 = r10.opt(r13);     // Catch: JSONException -> L33
        if (r14 == null) goto L12;
        if ((r14 instanceof JSONObject) == true) goto L15;
        if ((r14 instanceof JSONArray) == false) goto L12;
        JSONArray r15 = r11.optJSONArray(r13);     // Catch: JSONException -> L33
        if (r15 == null) goto L8;
        JSONArray r16 = (JSONArray) r14;     // Catch: JSONException -> L33
        int r17 = 0;
        if (r16.length() != 1) goto L29;
        if ((r16.opt(0) instanceof JSONObject) == false) goto L29;
        if ((r15.opt(0) instanceof JSONObject) == false) goto L29;
        JSONObject r18 = r16.getJSONObject(0);     // Catch: JSONException -> L33
        JSONObject r19 = r15.getJSONObject(0);     // Catch: JSONException -> L33
    L16:
        combineJson(r18, r19);     // Catch: JSONException -> L33
    L29:
        if (r17 >= r15.length()) goto L8;
        r16.put(r15.get(r17));     // Catch: JSONException -> L33
        r17 = r17 + 1;
        goto L29
    L15:
        r18 = r10.getJSONObject(r13);     // Catch: JSONException -> L33
        r19 = r11.getJSONObject(r13);     // Catch: JSONException -> L33
    L12:
        r10.put(r13, r11.opt(r13));     // Catch: JSONException -> L33
        goto L8
    L55:
        return;
    L54:
        return;
    L53:
        return;
    }

    public static JSONObject get(JSONObject r10, String r11) {
        if (r10 != null) goto L4;
    L11:
        return r10;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L11;
        JSONObject r12 = r10.optJSONObject(r11);
        if (r12 != null) goto L10;
        r12 = new JSONObject();
        r10.put(r11, r12);     // Catch: JSONException -> L12
    L10:
        return r12;
    }

    @Nullable
    public static JSONArray getArrayFromParent(@Nullable JSONObject r10, String... r11) {
        JSONObject r12 = getJsonFromParent(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.optJSONArray(r11[r11.length - 1]);
    }

    public static int getIntFromParent(@Nullable JSONObject r10, int r11, String... r12) {
        JSONObject r13 = getJsonFromParent(r10, r12);
        if (r13 != null) goto L6;
        return r11;
    L6:
        return r13.optInt(r12[r12.length - 1], r11);
    }

    @Nullable
    public static JSONObject getJsonFromParent(@Nullable JSONObject r10, String... r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= (r11.length - 1)) goto L13;
        r10 = r10.optJSONObject(r11[r12]);
        if (r10 == null) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        NpthLog.i("JSONUtil", "err get json: not found node:" + r11[r12]);
        return null;
    L13:
        return r10;
    }

    @Nullable
    public static String getStringFromParent(@Nullable JSONObject r10, String... r11) {
        JSONObject r12 = getJsonFromParent(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.optString(r11[r11.length - 1]);
    }

    public static boolean isEmpty(JSONArray r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(JSONObject r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static boolean jsonEquals(JSONObject r10, JSONObject r11) {
        if (r10.length() == r11.length()) goto L5;
        return false;
    L5:
        Iterator<String> r12 = r11.keys();
    L16:
        if (r12.hasNext() == false) goto L22;
        String r13 = r12.next();     // Catch: Throwable -> L15
        if (r10.has(r13) == false) goto L12;
        if (objectEquals(r10.opt(r13), r11.opt(r13)) == true) goto L16;
    L12:
        return false;
    L22:
        return true;
    L13:
        return true;
    }

    public static void jsonPutAll(JSONObject r10, Map<String, ? extends Object> r11) {
        if (r10 == null) goto L10;
        if (r11 == null) goto L16;
        Iterator<Map.Entry<String, ? extends Object>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, ? extends Object> r13 = r12.next();     // Catch: Throwable -> L11
        r10.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L11
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static boolean objectEquals(Object r10, Object r11) {
        if (r10 != r11) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
    L9:
        return false;
    L7:
        if (r10.equals(r11) == false) goto L9;
        return true;
    }

    @Nullable
    public static JSONObject optJSONObject(JSONObject r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONObject r13 = r10.optJSONObject(r11);
        if (r13 != null) goto L9;
        return null;
    L9:
        return r13.optJSONObject(r12);
    }

    public static JSONObject put(JSONObject r10, String r11, Object r12) {
        if (r10 == null) goto L8;
        if (r12 == null) goto L8;
        if (TextUtils.isEmpty(r11) == true) goto L8;
        r10.put(r11, r12);     // Catch: JSONException -> L9
    L8:
        return r10;
    }

    public static void put(JSONObject r10, Map<? extends String, ?> r11) {
        if (r10 == null) goto L10;
        if (r11 == null) goto L16;
        Iterator<Map.Entry<? extends String, ?>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<? extends String, ?> r13 = r12.next();     // Catch: Throwable -> L11
        r10.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L11
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static JSONArray splitArray(int r10, int r11, @Nullable JSONArray r12) {
        int r13 = r11 + r10;
        if (r12.length() > r13) goto L5;
        return r12;
    L5:
        JSONArray r14 = new JSONArray();
        int r15 = 0;
    L6:
        if (r15 >= r10) goto L8;
        r14.put(r12.opt(r15));
        r15 = r15 + 1;
        goto L6
    L8:
        r14.put("... skip " + ((r12.length() - r11) - r10) + " lines");
    L9:
        if (r10 >= r13) goto L11;
        r14.put(r12.opt(r12.length() - (r13 - r10)));
        r10 = r10 + 1;
        goto L9
    L11:
        return r14;
    }

    @Nullable
    public static JSONArray toArray(@Nullable String[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONArray r11 = new JSONArray();
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r11.put(r10[r13]);
        r13 = r13 + 1;
        goto L6
    L8:
        return r11;
    }

    @NonNull
    public static Map<String, Object> toJson(JSONObject r10) {
        HashMap r11 = new HashMap();
        if (r10 != null) goto L5;
        return r11;
    L5:
        Iterator<String> r12 = r10.keys();
    L7:
        if (r12.hasNext() == false) goto L9;
        String r13 = r12.next();
        r11.put(r13, r10.opt(r13));
        goto L7
    L9:
        return r11;
    }

    @NonNull
    public static HashMap<String, Object> toMap(JSONObject r10) {
        HashMap<String, Object> r11 = new HashMap();
        if (r10 != null) goto L5;
        return r11;
    L5:
        Iterator<String> r12 = r10.keys();
    L7:
        if (r12.hasNext() == false) goto L9;
        String r13 = r12.next();
        r11.put(r13, r10.opt(r13));
        goto L7
    L9:
        return r11;
    }
}
