package com.bytedance.b.a;

import com.bytedance.apm6.util.BatchLogWrapUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static JSONArray a(JSONObject r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        JSONArray r3 = r2.optJSONArray(BatchLogWrapUtils.KEY_WRAPPER_ARRAY_DATA);
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3;
    }
}
