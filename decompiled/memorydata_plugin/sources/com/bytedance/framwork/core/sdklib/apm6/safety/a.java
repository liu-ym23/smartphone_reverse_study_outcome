package com.bytedance.framwork.core.sdklib.apm6.safety;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.constants.Constants;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.bytedance.framwork.core.sdkmonitor.f;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f2612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2613b;
    private static String c;

    static {
        f2612a = new AtomicInteger(0);
        f2613b = true;
    }

    private static String a(Throwable r2) {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        r2.printStackTrace(r1);
        Throwable r3 = r2.getCause();
        if (r3 == null) goto L7;
        r3.printStackTrace(r1);
        Throwable r4 = r3.getCause();
        if (r4 == null) goto L7;
        r4.printStackTrace(r1);
    L7:
        String r5 = r0.toString();
        r1.close();
        return r5;
    }

    public static void a(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        c = r1 + "/monitor/collect/c/exception";
        return;
    }

    static void a(final String r2, final String r3, final Throwable r4) {
        if (TextUtils.isEmpty(c) == false) goto L6;
        return;
    L6:
        if (f2613b == true) goto L8;
        return;
    L8:
        if (f2612a.get() >= 3) goto L13;
        f2612a.incrementAndGet();
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass1(r2, r3, r4));
        return;
    }

    private static void a(String r5, byte[] r6) {
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.length == 0) goto L27;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L17
        byte[] r7 = f.a(r6, r0);     // Catch: Throwable -> L17
        HashMap r2 = new HashMap(j.b());     // Catch: Throwable -> L17
        r2.put("aid", "44444");     // Catch: Throwable -> L17
        String r8 = UrlUtils.addParamsToURL(r5, r2);     // Catch: Throwable -> L17
        if (j.d() == false) goto L15;
        Logger.d("APM-SDK", "http request:url:" + r8);     // Catch: Throwable -> L17
    L15:
        j.a(r8, r0, r7);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (j.d() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (j.d() == false) goto L24;
        Logger.d("APM-SDK", "network unreachable");
        return;
    }

    static /* synthetic */ void b(String r0, String r1, Throwable r2) {
        c(r0, r1, r2);
    }

    private static void c(String r7, String r8, Throwable r9) {
        ApmSDKInternalException r3 = new ApmSDKInternalException("tag=" + r7 + " message=" + r8, r9);
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L8
        r10.put(Constants.EVENT_TYPE, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Throwable -> L8
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L8
        r10.put("stack", a(r3));     // Catch: Throwable -> L8
        r10.put(ApiPerfDetails.exceptionType, 1);     // Catch: Throwable -> L8
        r10.put("message", r7 + "_" + r8);     // Catch: Throwable -> L8
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L8
        r4.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L8
        r10.put("filters", r4);     // Catch: Throwable -> L8
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L8
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L8
        r6.put(r10);     // Catch: Throwable -> L8
        r5.put("data", r6);     // Catch: Throwable -> L8
        JSONObject r11 = com.bytedance.framwork.core.sdklib.b.b.a(j.a());     // Catch: Throwable -> L8
        r11.put("aid", "44444");     // Catch: Throwable -> L8
        r5.put("header", r11);     // Catch: Throwable -> L8
        if (j.d() == false) goto L6;
        Log.e("APM-SDK", "tag:" + r7 + " message:" + r8, r3);     // Catch: Throwable -> L8
    L6:
        a(c, r5.toString().getBytes());     // Catch: Throwable -> L8
        return;
    L9:
        if (j.d() == false) goto L14;
        Log.e("APM-SDK", "tag:" + r7 + " message:" + r8, r3);
        return;
    }
}
