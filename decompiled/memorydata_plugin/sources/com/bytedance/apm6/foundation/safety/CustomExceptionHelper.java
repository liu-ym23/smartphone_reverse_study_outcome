package com.bytedance.apm6.foundation.safety;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.e.a;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomExceptionHelper {
    private static final int AID = 2085;
    private static final String EXCEPTION_TYPE = "exception";
    private static final String HOST_APP_ID = "host_aid";
    private static final String KEY_EVENT_TYPE = "event_type";
    private static final String KEY_EXCEPTION_TYPE = "exception_type";
    private static final String KEY_FILTERS = "filters";
    private static final String KEY_INTERNAL_ERROR_KEY = "apm_sdk";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_STACK = "stack";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final int MAX_REPORT_COUNT = 3;
    private static final String TAG = "APM-CustomException";
    private static final String TAG_INTERNAL_VALUE = "apm6_error";
    private static boolean enableReport;
    private static AtomicInteger innerExceptionReportCount;
    private static String url;

    static {
        innerExceptionReportCount = new AtomicInteger(0);
        enableReport = true;
    }

    public CustomExceptionHelper() {
    }

    static /* synthetic */ void access$000(String r0, String r1, Throwable r2) {
        reportException(r0, r1, r2);
    }

    private static byte[] compress(byte[] r3) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = null;
        GZIPOutputStream r2 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r2.write(r3);     // Catch: Throwable -> L7
        IOUtils.closeQuietly(r2);
        return r0.toByteArray();
    L7:
        th = th;
        r1 = r2;
    L10:
        IOUtils.closeQuietly(r1);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private static HttpRequest createRequest(String r4, byte[] r5) {
        HashMap r0 = new HashMap();
        if (r5.length <= 128) goto L7;
        byte[] r1 = compress(r5);     // Catch: IOException -> L8
        r0.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);     // Catch: IOException -> L8
        r5 = r1;
    L7:
        return new HttpRequest(UrlUtils.addParamsToURL(r4, ApmContext.getUrlParams()), r0, r5);
    }

    private static String getThrowableStack(Throwable r2) {
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

    private static void reportException(String r5, String r6, Throwable r7) {
        ApmInternalException r1 = new ApmInternalException("tag=" + r5 + " message=" + r6, r7);
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        r8.put("event_type", "exception");     // Catch: Throwable -> L11
        r8.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L11
        r8.put("stack", getThrowableStack(r1));     // Catch: Throwable -> L11
        r8.put("exception_type", 1);     // Catch: Throwable -> L11
        r8.put("message", r5 + "_" + r6);     // Catch: Throwable -> L11
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L11
        r2.put(KEY_INTERNAL_ERROR_KEY, TAG_INTERNAL_VALUE);     // Catch: Throwable -> L11
        r2.put(HOST_APP_ID, String.valueOf(ApmContext.getAid()));     // Catch: Throwable -> L11
        r8.put("filters", r2);     // Catch: Throwable -> L11
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L11
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L11
        r4.put(r8);     // Catch: Throwable -> L11
        r3.put("data", r4);     // Catch: Throwable -> L11
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L11
        JsonUtils.copyJson2(r9, ApmContext.getStableHeaderExtras());     // Catch: Throwable -> L11
        ApmContextAdapter r10 = ApmContext.getApmContextAdapter();     // Catch: Throwable -> L11
        if (r10 == null) goto L6;
        JsonUtils.copyJson2(r9, r10.getDynamicHeaderExtras());     // Catch: Throwable -> L11
    L6:
        r9.put("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L11
        r9.put("aid", AID);     // Catch: Throwable -> L11
        r9.put("device_id", ApmContext.getDeviceId());     // Catch: Throwable -> L11
        r9.put("channel", ApmContext.getChannel());     // Catch: Throwable -> L11
        r9.put("version_code", ApmContext.getVersionCode());     // Catch: Throwable -> L11
        r9.put("update_version_code", ApmContext.getUpdateVersionCode());     // Catch: Throwable -> L11
        r9.put("device_id", ApmContext.getDeviceId());     // Catch: Throwable -> L11
        r9.put("uid", ApmContext.getUserID());     // Catch: Throwable -> L11
        r9.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L11
        r3.put("header", r9);     // Catch: Throwable -> L11
        if (ApmContext.isDebugMode() == false) goto L9;
        Log.e(TAG, "tag:" + r5 + " message:" + r6, r1);     // Catch: Throwable -> L11
    L9:
        sendLog(url, r3.toString().getBytes());     // Catch: Throwable -> L11
        return;
    }

    static void reportSlardarIfNeed(final String r2, final String r3, final Throwable r4) {
        a.a(r2, r3);
        if (enableReport == true) goto L5;
        return;
    L5:
        if (innerExceptionReportCount.get() >= 3) goto L10;
        innerExceptionReportCount.incrementAndGet();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AnonymousClass1(r2, r3, r4));
        return;
    }

    private static void sendLog(String r3, byte[] r4) {
        if (NetworkUtils.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) == false) goto L5;
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.length == 0) goto L27;
        HttpRequest r5 = createRequest(r3, r4);     // Catch: Throwable -> L17
        if (ApmContext.isDebugMode() == false) goto L15;
        Logger.d(TAG, "http request:url:" + r5.url + " headers:" + r5.headerMap);     // Catch: Throwable -> L17
    L15:
        ApmContext.doPost(r5.url, r5.headerMap, r5.data);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L24;
        Logger.d(TAG, "network unreachable");
        return;
    }

    public static void setEnableReport(boolean r0) {
        enableReport = r0;
    }

    public static void setExceptionUrl(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        url = r1;
        return;
    }
}
