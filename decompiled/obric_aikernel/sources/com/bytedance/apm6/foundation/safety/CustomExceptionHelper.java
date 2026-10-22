package com.bytedance.apm6.foundation.safety;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import e0.a;
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

    static /* synthetic */ void access$000(String r10, String r11, Throwable r12) {
        reportException(r10, r11, r12);
    }

    private static byte[] compress(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r12 = null;
        GZIPOutputStream r13 = new GZIPOutputStream(r11);     // Catch: Throwable -> L9
        r13.write(r10);     // Catch: Throwable -> L7
        IOUtils.closeQuietly(r13);
        return r11.toByteArray();
    L7:
        th = th;
        r12 = r13;
    L10:
        IOUtils.closeQuietly(r12);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private static HttpRequest createRequest(String r10, byte[] r11) {
        HashMap r12 = new HashMap();
        if (r11.length <= 128) goto L7;
        byte[] r13 = compress(r11);     // Catch: IOException -> L8
        r12.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);     // Catch: IOException -> L8
        r11 = r13;
    L7:
        return new HttpRequest(UrlUtils.addParamsToURL(r10, ApmContext.getUrlParams()), r12, r11);
    }

    private static String getThrowableStack(Throwable r10) {
        StringWriter r11 = new StringWriter();
        PrintWriter r12 = new PrintWriter(r11);
        r10.printStackTrace(r12);
        Throwable r13 = r10.getCause();
        if (r13 == null) goto L7;
        r13.printStackTrace(r12);
        Throwable r14 = r13.getCause();
        if (r14 == null) goto L7;
        r14.printStackTrace(r12);
    L7:
        String r15 = r11.toString();
        r12.close();
        return r15;
    }

    private static void reportException(String r10, String r11, Throwable r12) {
        ApmInternalException r13 = new ApmInternalException("tag=" + r10 + " message=" + r11, r12);
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L11
        r14.put("event_type", "exception");     // Catch: Throwable -> L11
        r14.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L11
        r14.put("stack", getThrowableStack(r13));     // Catch: Throwable -> L11
        r14.put("exception_type", 1);     // Catch: Throwable -> L11
        r14.put("message", r10 + "_" + r11);     // Catch: Throwable -> L11
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L11
        r15.put(KEY_INTERNAL_ERROR_KEY, TAG_INTERNAL_VALUE);     // Catch: Throwable -> L11
        r15.put(HOST_APP_ID, String.valueOf(ApmContext.getAid()));     // Catch: Throwable -> L11
        r14.put("filters", r15);     // Catch: Throwable -> L11
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L11
        JSONArray r17 = new JSONArray();     // Catch: Throwable -> L11
        r17.put(r14);     // Catch: Throwable -> L11
        r16.put("data", r17);     // Catch: Throwable -> L11
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L11
        JsonUtils.copyJson2(r18, ApmContext.getStableHeaderExtras());     // Catch: Throwable -> L11
        ApmContextAdapter r19 = ApmContext.getApmContextAdapter();     // Catch: Throwable -> L11
        if (r19 == null) goto L6;
        JsonUtils.copyJson2(r18, r19.getDynamicHeaderExtras());     // Catch: Throwable -> L11
    L6:
        r18.put("os", "Android");     // Catch: Throwable -> L11
        r18.put("aid", AID);     // Catch: Throwable -> L11
        r18.put("device_id", ApmContext.getDeviceId());     // Catch: Throwable -> L11
        r18.put("channel", ApmContext.getChannel());     // Catch: Throwable -> L11
        r18.put("version_code", ApmContext.getVersionCode());     // Catch: Throwable -> L11
        r18.put("update_version_code", ApmContext.getUpdateVersionCode());     // Catch: Throwable -> L11
        r18.put("device_id", ApmContext.getDeviceId());     // Catch: Throwable -> L11
        r18.put("uid", ApmContext.getUserID());     // Catch: Throwable -> L11
        r18.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L11
        r16.put("header", r18);     // Catch: Throwable -> L11
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Log.e(TAG, "tag:" + r10 + " message:" + r11, r13);     // Catch: Throwable -> L11
    L9:
        sendLog(url, r16.toString().getBytes());     // Catch: Throwable -> L11
        return;
    }

    static void reportSlardarIfNeed(final String r10, final String r11, final Throwable r12) {
        a.a(r10, r11);
        if (enableReport == true) goto L5;
        return;
    L5:
        if (innerExceptionReportCount.get() >= 3) goto L10;
        innerExceptionReportCount.incrementAndGet();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AnonymousClass1(r10, r11, r12));
        return;
    }

    private static void sendLog(String r10, byte[] r11) {
        if (NetworkUtils.g(ApmBaseContext.getContext()) == false) goto L5;
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.length == 0) goto L27;
        HttpRequest r12 = createRequest(r10, r11);     // Catch: Throwable -> L17
        if (ApmBaseContext.isDebugMode() == false) goto L15;
        Logger.d(TAG, "http request:url:" + r12.url + " headers:" + r12.headerMap);     // Catch: Throwable -> L17
    L15:
        ApmContext.doPost(r12.url, r12.headerMap, r12.data);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (ApmBaseContext.isDebugMode() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L24;
        Logger.d(TAG, "network unreachable");
        return;
    }

    public static void setEnableReport(boolean r10) {
        enableReport = r10;
    }

    public static void setExceptionUrl(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        url = r10;
        return;
    }
}
