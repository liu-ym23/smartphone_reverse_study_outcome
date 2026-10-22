package com.ss.android.token;

import android.content.Context;
import android.util.Log;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static void a(String r2, String r3, JSONObject r4) {
        if (r4 == null) goto L18;
    L5:
        r4.put("error_name", r2);     // Catch: Exception -> L15
        r4.put(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE, r3);     // Catch: Exception -> L15
        int r0 = 1;
        if (NetworkUtils.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.account.d.a().b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L8;
        int r5 = 1;
    L9:
        r4.put("network_available", r5);     // Catch: Exception -> L15
        if (com.ss.android.a.a() == true) goto L13;
        r0 = 0;
    L13:
        r4.put("app_in_foreground", r0);     // Catch: Exception -> L15
        com.bytedance.sdk.account.f.a.a("tt_token_config_error", r4);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        r5 = 0;
        goto L9
    L18:
        r4 = new JSONObject();     // Catch: Exception -> L15
        goto L5
    }

    public static void a(String r4, List<b> r5, int r6, String r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L17
        r0.put("error_code", r6);     // Catch: Exception -> L17
        r0.put("error_code_msg", r7);     // Catch: Exception -> L17
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L17
        if (r8 != null) goto L6;
    L15:
        r0.put(WsConstants.KEY_EXTRA, r9.toString());     // Catch: Exception -> L17
        com.bytedance.sdk.account.f.a.a(r4, r0);     // Catch: Exception -> L17
        return;
    L6:
        if (r8.isEmpty() == true) goto L15;
        Iterator r10 = r8.iterator();     // Catch: Exception -> L17
    L9:
        if (r10.hasNext() == false) goto L15;
        Object r11 = r10.next();     // Catch: Exception -> L17
        if (ZeusTransformUtils.instanceOf(r11, b.class) == true) goto L12;
        if (r11 == null) goto L9;
        r9.append(r11.toString());     // Catch: Exception -> L17
        r9.append(";");     // Catch: Exception -> L17
        goto L9
    L12:
        r0.put(((b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.memorydata.plugin")).a(), ((b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.memorydata.plugin")).b());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(String r6, List r7, boolean r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        String r0 = "";
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L19
        if (r9 != null) goto L6;
    L17:
        com.bytedance.sdk.account.f.a.a("tt_token_logout", r6, r0, r2.toString(), r8);     // Catch: Exception -> L19
        return;
    L6:
        if (r9.isEmpty() == true) goto L17;
        Iterator r10 = r9.iterator();     // Catch: Exception -> L19
    L9:
        if (r10.hasNext() == false) goto L17;
        Object r3 = r10.next();     // Catch: Exception -> L19
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L13;
        if (r3 == null) goto L9;
        r2.append(r3.toString());     // Catch: Exception -> L19
        r2.append(";");     // Catch: Exception -> L19
        goto L9
    L13:
        if ("X-TT-LOGID".equalsIgnoreCase(((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).a()) == false) goto L9;
        r0 = ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).b();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        a(e);
    }

    public static void a(Throwable r3) {
        r3.printStackTrace();     // Catch: Exception -> L8
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L8
        r0.put("exception_msg", r3.getMessage());     // Catch: Exception -> L8
        r0.put("exception_stack_trace", Log.getStackTraceString(r3));     // Catch: Exception -> L8
        com.bytedance.sdk.account.f.a.a("tt_token_exception", r0);     // Catch: Exception -> L8
        if (com.ss.android.account.d.b() != null) goto L5;
        return;
    L5:
        if (com.ss.android.account.d.b().b() == null) goto L14;
        com.ss.android.account.d.b().b().a(r3);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
