package com.ss.android.common.applog;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.applog.monitor.Monitor;
import com.bytedance.crash.constants.Constants;
import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Monitor f15053a = null;

    static {
        f15053a = new Monitor(null, null, "applog_");
    }

    public static void a(MonitorKey r1, MonitorState r2) {
        Monitor r0 = f15053a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.record(r1.name(), r2.name());
    }

    public static void a(MonitorKey r1, MonitorState r2, int r3) {
        Monitor r0 = f15053a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.recordCount(r1.name(), r2.name(), r3);
    }

    public static void a(MonitorKey r1, MonitorState r2, long r3) {
        Monitor r0 = f15053a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.recordTime(r1.name(), r2.name(), (int) r3);
    }

    public static void a(String r2, MonitorState r3) {
        Monitor r0 = f15053a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equals(r2) == false) goto L8;
        MonitorKey r4 = MonitorKey.event_v3;
    L9:
        r0.record(r4.name(), r3.name());
        return;
    L8:
        r4 = MonitorKey.event;
        goto L9
    }

    private static void a(JSONObject r7, String r8, MonitorKey r9, MonitorState r10) {
        JSONArray r11 = r7.optJSONArray(r8);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() > 0) goto L7;
        return;
    L7:
        if (Constants.LAUNCH_TAG.equals(r8) == false) goto L19;
        int r12 = 0;
        int r4 = 0;
    L10:
        if (r12 >= r11.length()) goto L17;
        JSONObject r5 = r11.optJSONObject(r12);
        if (r5 == null) goto L16;
        if (r5.isNull("is_background") == false) goto L16;
        r4 = r4 + 1;
    L16:
        r12 = r12 + 1;
        goto L10
    L17:
        if (r4 <= 0) goto L27;
        Log.d("Monitor_AppLog", "[recordPackItem]key: " + r9 + ", state: " + r10 + ", count: " + r4);
        f15053a.recordCount(r9.name(), r10.name(), r4);
        return;
    L27:
        return;
    L19:
        Log.d("Monitor_AppLog", "[recordPackItem]key: " + r9 + ", state: " + r10 + ", count: " + r11.length());
        f15053a.recordCount(r9.name(), r10.name(), r11.length());
    }

    public static void b(String r2, MonitorState r3) {
        if (f15053a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        JSONObject r0 = new JSONObject(r2);     // Catch: Throwable -> L9
        a(r0, "event", MonitorKey.event, r3);     // Catch: Throwable -> L9
        a(r0, AppLogNewUtils.EVENT_V3_CATEGORY, MonitorKey.event_v3, r3);     // Catch: Throwable -> L9
        a(r0, Constants.LAUNCH_TAG, MonitorKey.launch, r3);     // Catch: Throwable -> L9
        a(r0, "terminate", MonitorKey.terminate, r3);     // Catch: Throwable -> L9
        a(r0, "log_data", MonitorKey.log_data, r3);     // Catch: Throwable -> L9
        a(r0, "item_impression", MonitorKey.item_impression, r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Log.e("Monitor_AppLog", "[recordPack]state: " + r3, th);
        return;
    }
}
