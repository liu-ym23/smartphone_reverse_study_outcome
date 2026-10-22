package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    public static String a(Exception r5) {
        JSONObject r10 = new JSONObject();
        if ((r5 instanceof JsBridgeException) == false) goto L6;
        int r11 = ((JsBridgeException) r5).f6260a;     // Catch: JSONException -> L12
    L7:
        r10.put("code", r11);     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r5.getMessage()) == true) goto L11;
        r10.put("msg", r5.getMessage());     // Catch: JSONException -> L12
        goto L11
    L6:
        r11 = 0;
    L11:
        return r10.toString();
    }
}
