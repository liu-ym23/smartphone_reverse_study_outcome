package com.bytedance.android.ec.common.impl.sku.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    @SafeVarargs
    public static String a(String r10, Pair... r11) {
        Map r12 = MapsKt.mapOf(r11);
        Uri r1 = UriProtector.parse(r10);     // Catch: Exception -> L9
        String r13 = UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Exception -> L9
        if (r13 == null) goto L7;
        r10 = e(r1, com.bytedance.android.ec.core.event.a.KEY_URL, c(r13, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, r12)).toString();     // Catch: Exception -> L9
    L12:
    L11:
        return r10;
    L7:
        r10 = c(r10, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, r12);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static String b(String r10, String r11, String r12) {
        Uri r1 = UriProtector.parse(r10);     // Catch: Exception -> L9
        String r13 = UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Exception -> L9
        if (r13 == null) goto L8;
        return e(r1, com.bytedance.android.ec.core.event.a.KEY_URL, e(UriProtector.parse(r13), r11, r12).toString()).toString();
    L8:
        return e(r1, r11, r12).toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    public static String c(String r10, String r11, Map<String, String> r12) {
        Uri r0 = UriProtector.parse(r10);     // Catch: Exception -> L17
        String r1 = UriProtector.getQueryParameter(r0, r11);     // Catch: Exception -> L17
        if (r1 != null) goto L5;
    L6:
        r1 = "{}";
    L7:
        JSONObject r13 = new JSONObject(r1);     // Catch: Exception -> L17
        Iterator<Map.Entry<String, String>> r14 = r12.entrySet().iterator();     // Catch: Exception -> L17
    L9:
        if (r14.hasNext() == false) goto L15;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Exception -> L17
        if (r15.getKey() == null) goto L9;
        if (r15.getValue() == null) goto L9;
        r13.put(r15.getKey(), r15.getValue());     // Catch: Exception -> L17
        goto L9
    L15:
        return e(r0, r11, r13.toString()).toString();
    L5:
        if (r1.isEmpty() == false) goto L7;
    L17:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    public static String d(String r0, String r1, String r10) {
        Uri.Builder r11 = UriProtector.parse(r0).buildUpon();
        r11.appendQueryParameter(r1, r10);
        return r11.build().toString();
    }

    public static Uri e(Uri r10, String r11, String r12) {
        if (r12 == null) goto L25;
        Uri.Builder r0 = r10.buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r10, r11)) == false) goto L7;
        r0.appendQueryParameter(r11, r12);
    L18:
        return r0.build();
    L7:
        r0.clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r10).iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        String r13 = (String) r1.next();
        if (r13.equals(r11) == false) goto L12;
        r0.appendQueryParameter(r13, r12);
        goto L9
    L12:
        Iterator r14 = UriProtector.getQueryParameters(r10, r13).iterator();
    L14:
        if (r14.hasNext() == false) goto L9;
        r0.appendQueryParameter(r13, (String) r14.next());
        goto L14
    L25:
        return r10;
    }
}
