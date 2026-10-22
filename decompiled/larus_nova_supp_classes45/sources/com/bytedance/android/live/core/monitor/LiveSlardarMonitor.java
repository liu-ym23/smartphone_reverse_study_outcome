package com.bytedance.android.live.core.monitor;

import android.text.TextUtils;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import wm0.b;
import wy.a;
import y50.h;
import y50.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveSlardarMonitor {
    public static final boolean DEBUG = false;
    private static final String DEFALUT_MONITOR_ALOG_TAG = "ttlive_monitor";
    public static final int DELAY_3000 = 3000;
    private static final String MONITOR_TAG_PRE = "ttlive";
    public static final String SERVICE_ANCHOR_LIVE_EDN = "ttlive_anchor_close_room";
    public static final String SERVICE_APP_DEBUG_LOG = "ttlive_sdk_debug_log";
    public static final String SERVICE_GIF_DOWNLOAD_TIME = "download_time";
    public static final String SERVICE_LIVE_IMAGE_LOAD = "hotsoon_live_image_load";
    public static final String SERVICE_LOG_IMAGE_ERROR = "image_error";
    public static final String SERVICE_PUSH_IMAGE_LOAD_ERROR_RATE = "hotsoon_push_image_load_error_rate";
    public static final String SERVICE_VIDEO_DOWNLOAD_TIME = "download_time";
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final String TAG = "LiveSlardarMonitor";
    public static final String TYPE_GIF_DOWNLOAD = "hotsoon_gif_download_time";
    public static final String TYPE_GIF_TRANSFORM_FAILED_LOG_FILE_MD5 = "type_gif_transform_failed_log_file_md5";
    public static final String TYPE_IMAGE_API = "hotsoon_image_api";
    public static final String TYPE_LIVE_IAP = "hotsoon_live_iap";
    public static final String TYPE_LOCAL_VIDEO_CONVERT_GIF = "hotsoon_video_convert_gif";
    public static final String TYPE_LOG_IMAGE_LOAD = "hotsoon_image_load_log";
    public static final String TYPE_LOG_IMAGE_LOAD_DURATION = "hotsoon_image_load_duration";
    public static final String TYPE_VIDEO_DOWNLOAD = "hotsoon_video_download_time";
    public static final String TYPE_VIDEO_SERVER_GET_GIF = "hotsoon_server_gif_download";

    static {
        LocalTestManager.a(new Class[]{a.class});
        DEBUG = false;
    }

    public LiveSlardarMonitor() {
    }

    private static IHostMonitor monitor() {
        return (IHostMonitor) BaseServices.as(IHostMonitor.class);
    }

    private static JSONObject durationJson(long r2) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r2);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private static JSONObject generateFinalExtra(JSONObject r3) {
        JSONObject r0 = new JSONObject();
        r0.put("tag", "ttlive_sdk");     // Catch: JSONException -> L7
        r0.put("ttlive_sdk_version", String.valueOf(c.b()));     // Catch: JSONException -> L7
        if (r3 == null) goto L9;
        r0.put("extra", r3);     // Catch: JSONException -> L7
    L9:
        return r0;
    L7:
        e = move-exception;
        e.printStackTrace();
        Logger.e(TAG, e.getMessage());
        goto L9
    }

    private static JSONObject mapToJson(Map<String, ?> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, ?>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        Map.Entry<String, ?> r1 = r4.next();
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    L13:
        return r0;
    }

    public static void exceptionMonitor(Throwable r1, String r2) {
        int r0 = j.a;
        b r3 = om0.c.j();
        if (r3 == null) goto L6;
        r3.ensureNotReachHere(r1, r2);
        return;
    }

    public static void monitorStatus(String r1, int r2) {
        monitorStatus(r1, r2, Collections.emptyMap());
    }

    public static void monitorCommonLog(String r1, String r2, JSONObject r3) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r2) == false) goto L8;
        return;
    L8:
        if (r3 != null) goto L20;
        r3 = new JSONObject();
    L20:
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        int r4 = j.a;
        b r5 = om0.c.j();
        if (r5 == null) goto L22;
        r5.monitorCommonLog(r1, r3);
        return;
    L22:
        return;
    L11:
        if (TextUtils.isEmpty(r2) == true) goto L16;
        r3.put("service", r2);     // Catch: JSONException -> L14
        goto L16
    }

    public static void monitorDuration(String r1, long r2, JSONObject r4) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        JSONObject r3 = durationJson(r2);
        JSONObject r5 = generateFinalExtra(r4);
        beforeMonitor("monitorDuration", r1, 0, r3, r5);
        monitorDuration(r1, r3, r5);
    }

    public static void monitorStatus(String r1, int r2, JSONObject r3) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r1) == false) goto L8;
        return;
    L8:
        JSONObject r4 = generateFinalExtra(r3);
        beforeMonitor("monitorStatus", r1, r2, r4);
        int r0 = j.a;
        b r5 = om0.c.j();
        if (r5 == null) goto L12;
        r5.monitorStatusRate(r1, r2, r4);
        return;
    }

    public static void monitorStatusAndDuration(String r1, int r2, long r3) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        monitorStatusAndDuration(r1, r2, durationJson(r3), null);
    }

    public static void monitorStatusRate(String r1, int r2, JSONObject r3) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r1) == false) goto L8;
        return;
    L8:
        int r0 = j.a;
        b r4 = om0.c.j();
        if (r4 == null) goto L12;
        r4.monitorStatusRate(r1, r2, r3);
        return;
    }

    private static void monitorDuration(String r1, JSONObject r2, JSONObject r3) {
        IHostMonitor r0 = monitor();
        if (r0 == null) goto L6;
        r0.monitorDuration(r1, r2, r3);
        return;
    }

    public static void monitorStatus(String r1, int r2, Map<String, ?> r3) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r1) == false) goto L8;
        return;
    L8:
        monitorStatus(r1, r2, mapToJson(r3));
    }

    public static void monitorStatusAndDuration(String r1, int r2, JSONObject r3) {
        monitorStatusAndDuration(r1, r2, null, r3);
    }

    private static void beforeMonitor(String r1, String r2, int r3, JSONObject r4) {
        beforeMonitor(r1, r2, r3, null, r4);
    }

    public static void monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        if (DEBUG == false) goto L6;
        Logger.d(TAG, "serviceName = " + r2 + ", category = " + r3 + ", metric = " + r4 + ", extraLog = " + r5);
    L6:
        if (h.a(r2) == false) goto L8;
        return;
    L8:
        int r0 = j.a;
        b r1 = om0.c.j();
        if (r1 == null) goto L12;
        r1.monitorEvent(r2, r3, r4, r5);
        return;
    }

    public static void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r1) == false) goto L8;
        return;
    L8:
        JSONObject r5 = generateFinalExtra(r4);
        beforeMonitor("monitorStatusAndDuration", r1, r2, r3, r5);
        int r0 = j.a;
        b r6 = om0.c.j();
        if (r6 == null) goto L12;
        r6.monitorStatusAndDuration(r1, r2, r3, r5);
        return;
    }

    public static void monitorStatusAndDurationDirect(String r1, int r2, JSONObject r3, JSONObject r4) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        beforeMonitor("monitorStatusAndDuration", r1, r2, r3, r4);
        int r0 = j.a;
        b r5 = om0.c.j();
        if (r5 == null) goto L9;
        r5.monitorStatusAndDuration(r1, r2, r3, r4);
        return;
    }

    public static void monitorStatusAndDuration(String r1, int r2, long r3, Map<String, Object> r5) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        monitorStatusAndDuration(r1, r2, durationJson(r3), mapToJson(r5));
    }

    public static void monitorStatusAndDuration(String r1, int r2, long r3, JSONObject r5) {
        if (h.a(r1) == false) goto L5;
        return;
    L5:
        monitorStatusAndDuration(r1, r2, durationJson(r3), r5);
    }

    private static void beforeMonitor(String r2, String r3, int r4, JSONObject r5, JSONObject r6) {
        if (DEBUG == false) goto L6;
        Logger.e(TAG, "method = " + r2 + ",key = " + r3 + ",status = " + r4 + ",duration = " + r5 + ",logJson = " + r6);
        return;
    }
}
