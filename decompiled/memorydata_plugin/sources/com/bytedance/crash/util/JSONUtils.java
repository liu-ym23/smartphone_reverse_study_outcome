package com.bytedance.crash.util;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class JSONUtils {
    public JSONUtils() {
    }

    public static void addKVs(JSONObject r3, Object... r4) {
        if (r3 == null) goto L14;
        if (r4 == null) goto L14;
        if ((r4.length % 2) != 0) goto L14;
        if (r4.length == 0) goto L14;
        int r0 = 0;
    L11:
        if (r0 >= r4.length) goto L13;
        put(r3, String.valueOf(r4[r0]), r4[r0 + 1]);
        r0 = r0 + 2;
        goto L11
    L13:
        return;
    L14:
        NpthLog.e("JSONUtils", "Err use of addKVs!!!!!");
    }

    public static void append(JSONObject r0, String r1, Object r2) {
        if (r2 == null) goto L8;
        r0.put(r1, String.valueOf(r2));     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static void append(JSONObject r0, String r1, String r2) {
        if (r2 == null) goto L8;
        r0.put(r1, r2);     // Catch: JSONException -> L5
        return;
    L9:
        return;
    }

    public static void appendInt(JSONObject r0, String r1, int r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    }

    public static void appendLong(JSONObject r0, String r1, long r2) {
        r0.put(r1, r2);     // Catch: JSONException -> L4
        return;
    }

    public static void assignIfNoExist(JSONObject r4, JSONObject r5) {
        Iterator<String> r0 = r5.keys();
    L11:
        if (r0.hasNext() == false) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r4.has(r1) == true) goto L11;
        r4.put(r1, r5.opt(r1));     // Catch: Throwable -> L10
    L18:
        return;
    }

    public static void combineJson(JSONObject r7, JSONObject r8) {
        if (r7 == null) goto L33;
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.length() <= 0) goto L54;
        Iterator<String> r1 = r8.keys();     // Catch: JSONException -> L34
    L9:
        if (r1.hasNext() == false) goto L56;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L34
        Object r3 = r7.opt(r2);     // Catch: JSONException -> L34
        if (r3 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == false) goto L13;
        JSONArray r4 = r8.optJSONArray(r2);     // Catch: JSONException -> L34
        if (r4 == null) goto L9;
        JSONArray r5 = (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L34
        int r6 = 0;
        if (r5.length() != 1) goto L30;
        if (ZeusTransformUtils.instanceOf(r5.opt(0), JSONObject.class) == false) goto L30;
        if (ZeusTransformUtils.instanceOf(r4.opt(0), JSONObject.class) == false) goto L30;
        JSONObject r9 = r5.getJSONObject(0);     // Catch: JSONException -> L34
        JSONObject r10 = r4.getJSONObject(0);     // Catch: JSONException -> L34
    L17:
        combineJson(r9, r10);     // Catch: JSONException -> L34
    L30:
        if (r6 >= r4.length()) goto L9;
        r5.put(r4.get(r6));     // Catch: JSONException -> L34
        r6 = r6 + 1;
        goto L30
    L16:
        r9 = r7.getJSONObject(r2);     // Catch: JSONException -> L34
        r10 = r8.getJSONObject(r2);     // Catch: JSONException -> L34
    L13:
        r7.put(r2, r8.opt(r2));     // Catch: JSONException -> L34
        goto L9
    L56:
        return;
    L55:
        return;
    L54:
        return;
    }

    public static JSONObject get(JSONObject r1, String r2) {
        if (r1 != null) goto L4;
    L11:
        return r1;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        JSONObject r0 = r1.optJSONObject(r2);
        if (r0 != null) goto L10;
        r0 = new JSONObject();
        r1.put(r2, r0);     // Catch: JSONException -> L12
    L10:
        return r0;
    }

    public static JSONArray getArrayFromParent(JSONObject r1, String... r2) {
        JSONObject r3 = getJsonFromParent(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.optJSONArray(r2[r2.length - 1]);
    }

    public static int getIntFromParent(JSONObject r1, int r2, String... r3) {
        JSONObject r4 = getJsonFromParent(r1, r3);
        if (r4 != null) goto L6;
        return r2;
    L6:
        return r4.optInt(r3[r3.length - 1], r2);
    }

    public static JSONObject getJsonFromParent(JSONObject r3, String... r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= (r4.length - 1)) goto L13;
        r3 = r3.optJSONObject(r4[r1]);
        if (r3 == null) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        NpthLog.i("JSONUtil", "err get json: not found node:" + r4[r1]);
        return null;
    L13:
        return r3;
    }

    public static String getStringFromParent(JSONObject r1, String... r2) {
        JSONObject r3 = getJsonFromParent(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.optString(r2[r2.length - 1]);
    }

    public static boolean isEmpty(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(JSONObject r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean jsonEquals(JSONObject r5, JSONObject r6) {
        if (r5.length() == r6.length()) goto L5;
        return false;
    L5:
        Iterator<String> r0 = r6.keys();
    L16:
        if (r0.hasNext() == false) goto L22;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r5.has(r1) == false) goto L12;
        if (objectEquals(r5.opt(r1), r6.opt(r1)) == true) goto L16;
    L12:
        return false;
    L22:
        return true;
    L13:
        return true;
    }

    public static void jsonPutAll(JSONObject r4, Map<String, ? extends Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        if (r6 == null) goto L17;
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        r4.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), r0.getValue());     // Catch: Throwable -> L12
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static boolean objectEquals(Object r1, Object r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 != null) goto L7;
    L9:
        return false;
    L7:
        if (r1.equals(r2) == false) goto L9;
        return true;
    }

    public static JSONObject optJSONObject(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }

    public static JSONObject put(JSONObject r1, String r2, Object r3) {
        if (r1 == null) goto L8;
        if (r3 == null) goto L8;
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r1.put(r2, r3);     // Catch: JSONException -> L9
    L8:
        return r1;
    }

    public static void put(JSONObject r4, Map<? extends String, ?> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        if (r6 == null) goto L17;
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        r4.put((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), r0.getValue());     // Catch: Throwable -> L12
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static JSONArray splitArray(int r4, int r5, JSONArray r6) {
        int r1 = r5 + r4;
        if (r6.length() > r1) goto L5;
        return r6;
    L5:
        JSONArray r0 = new JSONArray();
        int r2 = 0;
    L6:
        if (r2 >= r4) goto L8;
        r0.put(r6.opt(r2));
        r2 = r2 + 1;
        goto L6
    L8:
        r0.put("... skip " + ((r6.length() - r5) - r4) + " lines");
    L9:
        if (r4 >= r1) goto L11;
        r0.put(r6.opt(r6.length() - (r1 - r4)));
        r4 = r4 + 1;
        goto L9
    L11:
        return r0;
    }

    public static JSONArray toArray(String[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        JSONArray r0 = new JSONArray();
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.put(r4[r2]);
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    public static Map<String, Object> toJson(JSONObject r5) {
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r2, r5.opt(r2));
        goto L7
    L9:
        return r0;
    }

    public static HashMap<String, Object> toMap(JSONObject r5) {
        HashMap<String, Object> r0 = new HashMap();
        if (r5 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r2, r5.opt(r2));
        goto L7
    L9:
        return r0;
    }
}
