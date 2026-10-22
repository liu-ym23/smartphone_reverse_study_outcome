package com.bytedance.android.livesdk.chatroom.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k1 {
    public static String a() {
        com.bytedance.android.livesdk.log.filter.t r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L8;
        com.bytedance.android.livesdk.log.filter.t r1 = r0;
        if (r1.getMap().containsKey("video_id") == true) goto L7;
        return "";
    L7:
        return (String) r1.getMap().get("video_id");
    L8:
        return "";
    }

    public static String b() {
        return com.bytedance.android.livesdk.log.l0.a("action_type", com.bytedance.android.livesdk.log.j0.l().c(am2.x.class));
    }

    public static String c() {
        com.bytedance.android.livesdk.log.filter.t r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L32;
        com.bytedance.android.livesdk.log.filter.t r1 = r0;
        if (r1.getMap().containsKey("enter_from") == true) goto L7;
    L9:
        String r2 = "";
    L11:
        if (r1.getMap().containsKey("source") == true) goto L13;
    L15:
        String r3 = "";
    L16:
        Map r4 = r1.getMap();
        com.bytedance.android.livesdk.chatroom.r r5 = z51.a.c(null, 0);
        if (r5 == null) goto L21;
        if (r2 == null) goto L21;
        r5.dataMapping(r2, r3, r4);
    L21:
        if (r4.containsKey("enter_from_ad_type") == false) goto L27;
        if (TextUtils.isEmpty((CharSequence) r4.get("enter_from_ad_type")) == true) goto L27;
        return (String) r4.get("enter_from_ad_type");
    L27:
        if (r4.containsKey("enter_from_merge") == false) goto L32;
        if (TextUtils.isEmpty((CharSequence) r4.get("enter_from_merge")) == true) goto L32;
        return (String) r4.get("enter_from_merge");
    L13:
        if (r1.getMap().get("source") == null) goto L15;
        r3 = (String) r1.getMap().get("source");
        goto L16
    L7:
        if (r1.getMap().get("enter_from") == null) goto L9;
        r2 = (String) r1.getMap().get("enter_from");
    L32:
        return "";
    }

    public static String d() {
        return com.bytedance.android.livesdk.log.l0.a("enter_method", com.bytedance.android.livesdk.log.j0.l().c(am2.x.class));
    }

    public static Map<String, String> e(long r5) {
        com.bytedance.android.livesdk.log.filter.t r0 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        com.bytedance.android.livesdk.log.filter.s r1 = com.bytedance.android.livesdk.log.j0.l().c(am2.t.class);
        HashMap r2 = new HashMap(2);
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L11;
        com.bytedance.android.livesdk.log.filter.t r3 = r0;
        if (r3.getMap().containsKey("search_id") == false) goto L8;
        r2.put("search_id", (String) r3.getMap().get("search_id"));
    L8:
        if (r3.getMap().containsKey("search_type") == false) goto L11;
        r2.put("search_type", (String) r3.getMap().get("search_type"));
    L11:
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.s) == false) goto L22;
        com.bytedance.android.livesdk.log.filter.s r4 = r1;
        if (r4.getData() == null) goto L18;
        if (r4.getData().f == null) goto L18;
        r2.put("search_params", r4.getData().f);
    L18:
        if (r4.getData() == null) goto L22;
        if (r4.getData().d.containsKey(Long.valueOf(r5)) == false) goto L22;
        r2.put("search_params", (String) r4.getData().d.get(Long.valueOf(r5)));
    L22:
        return r2;
    }

    public static void f(JSONObject r2) {
        r2.put("action_type", b());     // Catch: JSONException -> L4
        r2.put("enter_method", d());     // Catch: JSONException -> L4
        r2.put("enter_from_merge", c());     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
