package com.bytedance.sdk.account.save.entity;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static a a(String r5) {
    L18:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (TextUtils.isEmpty(r5) == true) goto L24;
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L18
        Iterator<String> r6 = r0.keys();     // Catch: Exception -> L18
        a r1 = new a();     // Catch: Exception -> L18
        if (r6.hasNext() == false) goto L17;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r7) == true) goto L17;
        byte r2 = -1;
        if (r7.hashCode() == 1481071862) goto L12;
    L14:
        if (r2 != 0) goto L17;
        r1.a(Integer.valueOf(r0.optInt(r7)));     // Catch: Exception -> L18
        goto L17
    L12:
        if (r7.equals("country_code") == false) goto L14;
        r2 = 0;
    L17:
        return r1;
    L24:
        return null;
    }

    public static String a(a r2) {
        if (r2 == null) goto L14;
        Integer r3 = r2.a();     // Catch: Exception -> L8
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L8
        if (r3 == null) goto L6;
        r0.put("country_code", r3);     // Catch: Exception -> L8
    L6:
        return r0.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L14:
        return null;
    }
}
