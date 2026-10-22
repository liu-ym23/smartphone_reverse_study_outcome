package com.ss.android.lark.message.card.interactive;

import android.text.TextUtils;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.card.action.InteractiveHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.net.URLDecoder;
import java.net.URLEncoder;
import jrb.c;
import jrb.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final void c(String r1, String r2) {
        throw null;
    }

    public static String b(String r5, String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L31;
        if (InteractiveHandler.d(r5) == false) goto L31;
        if (TextUtils.isEmpty(r6) == true) goto L43;
        String r2 = UriProtector.getQueryParameter(UriProtector.parse(r5), "bdp_launch_query");
        if (r2 != null) goto L37;
        JSONObject r3 = new JSONObject();
        r3.put("__trigger_id__", r6);     // Catch: Throwable -> L20 JSONException -> L22
        StringBuffer r7 = new StringBuffer("bdp_launch_query=");     // Catch: Throwable -> L20 JSONException -> L22
        r7.append(URLEncoder.encode(r3.toString(), "utf-8"));     // Catch: Throwable -> L20 JSONException -> L22
        int r1 = r5.length();     // Catch: Throwable -> L20 JSONException -> L22
        int r4 = r5.indexOf("?");     // Catch: Throwable -> L20 JSONException -> L22
        if (r4 > (-1)) goto L15;
        r5 = r5 + "?" + r7.toString();     // Catch: Throwable -> L20 JSONException -> L22
    L34:
        return r5;
    L15:
        if ((r1 - 1) != r4) goto L17;
        r5 = r5 + r7.toString();     // Catch: Throwable -> L20 JSONException -> L22
        goto L34
    L17:
        r5 = r5 + "&" + r7.toString();     // Catch: Throwable -> L20 JSONException -> L22
    L20:
        e = move-exception;
        e.printStackTrace();
        return r5;
    L37:
        JSONObject r8 = new JSONObject(URLDecoder.decode(r2, "utf-8").replace("\\", ""));     // Catch: Throwable -> L26 JSONException -> L28
        r8.put("__trigger_id__", r6);     // Catch: Throwable -> L26 JSONException -> L28
        return d(r5, URLEncoder.encode(r8.toString(), "utf-8"));
    L26:
        e = move-exception;
        Log.e("InteractiveHandler", "error:" + e.getMessage());
        e.printStackTrace();
        return r5;
    L43:
        return r5;
    L31:
        if (TextUtils.isEmpty(r6) == false) goto L42;
        d r9 = d.g;
        OPMonitor r0 = c.a(r9);
        r0.setErrorMessage(((OPMonitorCode) r9).message);
        r0.flush();
        return r5;
    L42:
        return r5;
    }

    public static String d(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (TextUtils.isEmpty("bdp_launch_query") == false) goto L7;
        return r2;
    L7:
        return r2.replaceAll("(bdp_launch_query=[^&]*)", "bdp_launch_query=" + r3);
    }

    public static void a(a r2, boolean r3, String r4, long r5) {
        r2.getClass();
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L12
        if (r3 == false) goto L6;
        String r1 = "success";
    L7:
        r6.put("state", r1);     // Catch: Exception -> L12
        if (r3 == true) goto L10;
        r6.put("errorMsg", r4);     // Catch: Exception -> L12
    L10:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L12
        r7.put("duration", System.currentTimeMillis() - r5);     // Catch: Exception -> L12
        MonitorUtils.monitorEvent("op_messagecard_trigger_code", r6, r7, null);     // Catch: Exception -> L12
        return;
    L6:
        r1 = "fail";
    L12:
        e = move-exception;
        Log.e("InteractiveHandler", e.getMessage(), e);
    }
}
