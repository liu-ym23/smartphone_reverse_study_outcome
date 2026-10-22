package com.bytedance.applog.sampling;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.log.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static c a(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        c r0 = new c();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        r8 = "sampling_list";
    L5:
        SharedPreferences r10 = r9.getSharedPreferences(r8, 0);
        r0.a(r10.getInt("version", 0));
        r0.b(r10.getInt("capability", 0));
        String r11 = r10.getString("config_ids", null);
        if (TextUtils.isEmpty(r11) == false) goto L18;
    L11:
        String r12 = r10.getString("samplings", null);
        if (TextUtils.isEmpty(r12) == false) goto L20;
    L17:
        return r0;
    L20:
        a(r0, new JSONArray(r12));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        q.a().a(12, "parseEventSamplingFromLocal sampling config", th, new Object[0]);
        goto L17
    L18:
        r0.a(new JSONArray(r11));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        q.a().a(12, "parseEventSamplingFromLocal config ids error", th, new Object[0]);
        goto L11
    }

    public static c a(Context r6, String r7, JSONObject r8, c r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L20;
        return r9;
    L20:
        c r4 = new c();     // Catch: Throwable -> L17
        r4.a(r8.optInt("event_sampling_version", 0));     // Catch: Throwable -> L17
        r4.b(r8.optInt("capability", 0));     // Catch: Throwable -> L17
        r4.a(r8.optJSONArray("config_ids"));     // Catch: Throwable -> L17
        JSONArray r11 = r8.optJSONArray("samplings");     // Catch: Throwable -> L17
        a(r4, r11);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r7) == false) goto L9;
        r7 = "sampling_list";
    L9:
        SharedPreferences.Editor r12 = r10.getSharedPreferences(r7, 0).edit();     // Catch: Throwable -> L17
        r12.putInt("capability", r4.b());     // Catch: Throwable -> L17
        r12.putInt("version", r4.a());     // Catch: Throwable -> L17
        if (r11 == null) goto L13;
        r12.putString("samplings", r11.toString());     // Catch: Throwable -> L17
    L13:
        if (r4.c() == null) goto L15;
        r12.putString("config_ids", r4.c().toString());     // Catch: Throwable -> L17
    L15:
        r12.apply();     // Catch: Throwable -> L17
        return r4;
    L17:
        th = move-exception;
        q.a().a(12, "parseEventSamplingFromServer", th, new Object[0]);
        return r9;
    }

    private static void a(c r19, JSONArray r20) {
        JSONArray r0 = r20;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r20.length() <= 0) goto L130;
        r19.b(r20);
        int r2 = 0;
    L95:
        if (r2 >= r20.length()) goto L131;
        JSONObject r3 = r0.optJSONObject(r2);     // Catch: Throwable -> L92
        if (r3 == null) goto L91;
        int r6 = r3.optInt("sampling_rate");     // Catch: Throwable -> L92
        if (r6 >= 10000) goto L91;
        int r7 = r3.optInt("sampling_method");     // Catch: Throwable -> L92
        HashSet r8 = new HashSet();     // Catch: Throwable -> L92
        JSONArray r4 = r3.optJSONArray("events");     // Catch: Throwable -> L92
        if (r4 != null) goto L17;
    L25:
        HashMap r9 = new HashMap();     // Catch: Throwable -> L92
        JSONObject r5 = r3.optJSONObject("param_keys");     // Catch: Throwable -> L92
        if (r5 == null) goto L58;
        Iterator<String> r10 = r5.keys();     // Catch: Throwable -> L92
    L30:
        if (r10.hasNext() == false) goto L58;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r11) == true) goto L30;
        JSONArray r12 = r5.optJSONArray(r11);     // Catch: Throwable -> L92
        if (r12 != null) goto L37;
    L56:
        JSONObject r17 = r5;
    L57:
        r5 = r17;
        goto L30
    L37:
        if (r12.length() <= 0) goto L56;
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L92
        int r14 = 0;
    L40:
        if (r14 >= r12.length()) goto L55;
        JSONArray r15 = r12.optJSONArray(r14);     // Catch: Throwable -> L92
        if (r15 == null) goto L54;
        if (r15.length() <= 0) goto L54;
        HashSet r1 = new HashSet();     // Catch: Throwable -> L92
        int r16 = 0;
    L47:
        if (r16 >= r15.length()) goto L52;
        String r18 = r15.optString(r16);     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r18) == true) goto L51;
        r1.add(r18);     // Catch: Throwable -> L92
    L51:
        r16 = r16 + 1;     // Catch: Throwable -> L92
        goto L47
    L52:
        r13.add(r1);     // Catch: Throwable -> L92
    L54:
        r14 = r14 + 1;     // Catch: Throwable -> L92
        r5 = r5;
        goto L40
    L55:
        r17 = r5;
        r9.put(r11, r13);     // Catch: Throwable -> L92
    L58:
        HashMap r110 = new HashMap();     // Catch: Throwable -> L92
        JSONObject r21 = r3.optJSONObject("param_key_values");     // Catch: Throwable -> L92
        if (r21 == null) goto L90;
        Iterator<String> r22 = r21.keys();     // Catch: Throwable -> L92
    L62:
        if (r22.hasNext() == false) goto L90;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r23) == true) goto L62;
        JSONArray r24 = r21.optJSONArray(r23);     // Catch: Throwable -> L92
        if (r24 != null) goto L69;
    L88:
        JSONObject r111 = r21;
        Iterator<String> r112 = r22;
    L89:
        r21 = r111;
        r22 = r112;
        goto L62
    L69:
        if (r24.length() <= 0) goto L88;
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L92
        int r114 = 0;
    L72:
        if (r114 >= r24.length()) goto L87;
        JSONObject r115 = r24.optJSONObject(r114);     // Catch: Throwable -> L92
        if (r115 == null) goto L85;
        HashMap r116 = new HashMap();     // Catch: Throwable -> L92
        Iterator<String> r117 = r115.keys();     // Catch: Throwable -> L92
    L77:
        if (r117.hasNext() == false) goto L84;
        JSONObject r118 = r21;
        Iterator<String> r119 = r22;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r117.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r25) == true) goto L83;
        Object r26 = r115.opt(r25);     // Catch: Throwable -> L92
        if (r26 == null) goto L83;
        r116.put(r25, r26);     // Catch: Throwable -> L92
    L83:
        r21 = r118;
        r22 = r119;
        goto L77
    L84:
        JSONObject r120 = r21;
        Iterator<String> r121 = r22;
        r113.add(r116);     // Catch: Throwable -> L92
    L86:
        r114 = r114 + 1;     // Catch: Throwable -> L92
        r21 = r120;
        r22 = r121;
        goto L72
    L85:
        r120 = r21;
        r121 = r22;
        goto L86
    L87:
        r111 = r21;
        r112 = r22;
        r110.put(r23, r113);     // Catch: Throwable -> L92
    L90:
        r19.a(r6, r7, r8, r9, r110);     // Catch: Throwable -> L92
        goto L91
    L17:
        if (r4.length() <= 0) goto L25;
        int r27 = 0;
    L20:
        if (r27 >= r4.length()) goto L25;
        String r28 = r4.optString(r27);     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r28) == true) goto L24;
        r8.add(r28);     // Catch: Throwable -> L92
    L24:
        r27 = r27 + 1;     // Catch: Throwable -> L92
    L91:
        r2 = r2 + 1;
        r0 = r20;
        goto L95
    L131:
        return;
    L92:
        th = move-exception;
        q.a().a(12, "loadSamplingMapFromJsonArray error", th, new Object[0]);
        return;
    }
}
