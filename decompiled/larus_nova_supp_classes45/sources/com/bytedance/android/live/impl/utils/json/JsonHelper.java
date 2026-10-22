package com.bytedance.android.live.impl.utils.json;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsonHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L27;
        Object r3 = r5.opt(r2);
        if ((r3 instanceof Long) == false) goto L8;
        r0.add(Long.valueOf(r5.optLong(r2)));
    L26:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof Double) == false) goto L11;
        r0.add(Double.valueOf(r5.optDouble(r2)));
        goto L26
    L11:
        if ((r3 instanceof Integer) == false) goto L14;
        r0.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r5, r2)));
        goto L26
    L14:
        if ((r3 instanceof String) == false) goto L17;
        r0.add(r5.optString(r2));
        goto L26
    L17:
        if ((r3 instanceof JSONObject) == false) goto L20;
        r0.add(b(r5.optJSONObject(r2)));
        goto L26
    L20:
        if ((r3 instanceof JSONArray) == false) goto L23;
        r0.add(a(r5.optJSONArray(r2)));
        goto L26
    L23:
        if ((r3 instanceof Boolean) == false) goto L25;
        r0.add(Boolean.valueOf(r5.optBoolean(r2)));
        goto L26
    L25:
        r0.add(null);
        goto L26
    L27:
        return r0;
    }

    public static Map b(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "json");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r6.keys();
    L4:
        if (r1.hasNext() == false) goto L33;
        String r2 = r1.next();
        Object r3 = r6.opt(r2);
        if ((r3 instanceof Long) == true) goto L7;
        if ((r3 instanceof Double) == true) goto L10;
        if ((r3 instanceof Integer) == true) goto L13;
        if ((r3 instanceof String) == true) goto L16;
        Object r5 = null;
        if ((r3 instanceof JSONObject) == true) goto L19;
        if ((r3 instanceof JSONArray) == true) goto L25;
        if ((r3 instanceof Boolean) == true) goto L31;
        r0.put(r2, null);
        goto L4
    L31:
        r0.put(r2, Boolean.valueOf(r6.optBoolean(r2)));
        goto L4
    L25:
        JSONArray r4 = r6.optJSONArray(r2);
        if (r4 == null) goto L28;
        r5 = a(r4);
    L28:
        r0.put(r2, r5);
        goto L4
    L19:
        JSONObject r7 = r6.optJSONObject(r2);
        if (r7 == null) goto L22;
        r5 = b(r7);
    L22:
        r0.put(r2, r5);
        goto L4
    L16:
        r0.put(r2, r6.optString(r2));
        goto L4
    L13:
        r0.put(r2, Integer.valueOf(r6.optInt(r2)));
        goto L4
    L10:
        r0.put(r2, Double.valueOf(r6.optDouble(r2)));
        goto L4
    L7:
        r0.put(r2, Long.valueOf(r6.optLong(r2)));
        goto L4
    L33:
        return r0;
    }

    public static JSONArray c(List r4) {
        JSONArray r0 = new JSONArray();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L43;
        Object r1 = r5.next();
        if ((r1 instanceof Float) == true) goto L7;
        if ((r1 instanceof Long) == true) goto L10;
        if ((r1 instanceof Integer) == true) goto L13;
        if ((r1 instanceof Double) == true) goto L16;
        if ((r1 instanceof String) == true) goto L19;
        if ((r1 instanceof Boolean) == true) goto L22;
        if ((r1 instanceof Map) == true) goto L25;
        if ((r1 instanceof List) == false) goto L4;
        if (r1 == null) goto L38;
        r0.put(c((List) r1));     // Catch: ClassCastException -> L39 JSONException -> L41
    L39:
        e = move-exception;
        boolean r2 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$listToJSON$1$5.INSTANCE, e);
    L41:
        e = move-exception;
        boolean r3 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$listToJSON$1$4.INSTANCE, e);
        goto L4
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");     // Catch: ClassCastException -> L39 JSONException -> L41
    L25:
        if (r1 == null) goto L28;
        r0.put(d((Map) r1));     // Catch: ClassCastException -> L29 JSONException -> L31
    L29:
        e = move-exception;
        boolean r6 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$listToJSON$1$2.INSTANCE, e);
    L31:
        e = move-exception;
        boolean r7 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$listToJSON$1$1.INSTANCE, e);
        goto L4
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");     // Catch: ClassCastException -> L29 JSONException -> L31
    L22:
        r0.put(((Boolean) r1).booleanValue());
        goto L4
    L19:
        r0.put(r1);
        goto L4
    L16:
        r0.put(((Number) r1).doubleValue());
        goto L4
    L13:
        r0.put(((Number) r1).intValue());
        goto L4
    L10:
        r0.put(((Number) r1).longValue());
        goto L4
    L7:
        r0.put(((Number) r1).floatValue());
        goto L4
    L43:
        return r0;
    }

    public static JSONObject d(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        JSONObject r0 = new JSONObject();
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L39;
        Map.Entry r1 = (Map.Entry) r6.next();
        String r2 = (String) r1.getKey();
        Object r3 = r1.getValue();
        if ((r3 instanceof Long) == true) goto L7;
        if ((r3 instanceof Float) == true) goto L10;
        if ((r3 instanceof Integer) == true) goto L13;
        if ((r3 instanceof Double) == true) goto L16;
        if ((r3 instanceof String) == true) goto L19;
        if ((r3 instanceof Boolean) == true) goto L22;
        if ((r3 instanceof Map) == false) goto L32;
        r0.put(r2, d((Map) r3));     // Catch: ClassCastException -> L27 JSONException -> L29
    L27:
        e = move-exception;
        boolean r4 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$mapToJSON$1$2.INSTANCE, e);
    L29:
        e = move-exception;
        boolean r7 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$mapToJSON$1$1.INSTANCE, e);
        goto L4
    L32:
        if ((r3 instanceof List) == false) goto L4;
        r0.put(r2, c((List) r3));     // Catch: ClassCastException -> L35 JSONException -> L37
    L35:
        e = move-exception;
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$mapToJSON$1$5.INSTANCE, e);
    L37:
        e = move-exception;
        boolean r9 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$mapToJSON$1$4.INSTANCE, e);
        goto L4
    L22:
        r0.put(r2, ((Boolean) r3).booleanValue());
        goto L4
    L19:
        r0.put(r2, r3);
        goto L4
    L16:
        r0.put(r2, ((Number) r3).doubleValue());
        goto L4
    L13:
        r0.put(r2, ((Number) r3).intValue());
        goto L4
    L10:
        r0.put(r2, ((Number) r3).floatValue());
        goto L4
    L7:
        r0.put(r2, ((Number) r3).longValue());
        goto L4
    L39:
        return r0;
    }

    public static String f(JsonItemHelper.IJsonItem r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
        return GsonProtectorUtils.toJson(GsonHelper.getDefault(), r1).toString();
    }

    public static List e(String r4, JsonItemType r5) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "jsonItemType");
        JsonArray r6 = new JsonParser().parse(r4).getAsJsonArray();     // Catch: Exception -> L11
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L11
        if (r6 == null) goto L10;
        Iterator r7 = r6.iterator();     // Catch: Exception -> L11
    L7:
        if (r7.hasNext() == false) goto L10;
        JsonElement r1 = (JsonElement) r7.next();     // Catch: Exception -> L11
        r0.add(GsonHelper.getDefault().fromJson(r1, a.a.get(r5)));     // Catch: Exception -> L11
    L10:
        return r0;
    L11:
        e = move-exception;
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", JsonHelper$parseData$2.INSTANCE, e);
        return null;
    }
}
