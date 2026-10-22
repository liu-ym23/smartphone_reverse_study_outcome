package com.larus.account.saas.jsb.core;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final List<Object> a(JSONArray r5) {
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
        r0.add(b(JSONArrayProtectorUtils.getJSONObject(r5, r2)));
        goto L26
    L20:
        if ((r3 instanceof JSONArray) == false) goto L23;
        r0.add(a(JSONArrayProtectorUtils.getJSONArray(r5, r2)));
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

    public static final Map<String, Object> b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L27;
        String r2 = r1.next();
        Object r3 = r5.opt(r2);
        if ((r3 instanceof Long) == true) goto L7;
        if ((r3 instanceof Double) == true) goto L10;
        if ((r3 instanceof Integer) == true) goto L13;
        if ((r3 instanceof String) == true) goto L16;
        if ((r3 instanceof JSONObject) == true) goto L19;
        if ((r3 instanceof JSONArray) == true) goto L22;
        if ((r3 instanceof Boolean) == true) goto L25;
        r0.put(r2, null);
        goto L4
    L25:
        r0.put(r2, Boolean.valueOf(r5.optBoolean(r2)));
        goto L4
    L22:
        r0.put(r2, a(JSONObjectProtectorUtils.getJSONArray(r5, r2)));
        goto L4
    L19:
        r0.put(r2, b(JSONObjectProtectorUtils.getJSONObject(r5, r2)));
        goto L4
    L16:
        r0.put(r2, r5.optString(r2));
        goto L4
    L13:
        r0.put(r2, Integer.valueOf(r5.optInt(r2)));
        goto L4
    L10:
        r0.put(r2, Double.valueOf(r5.optDouble(r2)));
        goto L4
    L7:
        r0.put(r2, Long.valueOf(r5.optLong(r2)));
        goto L4
    L27:
        return r0;
    }
}
