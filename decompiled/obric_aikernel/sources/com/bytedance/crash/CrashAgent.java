package com.bytedance.crash;

import android.text.TextUtils;
import c4.d;
import com.bytedance.crash.anr.AnrInfoParser;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CrashAgent {
    private static final String SERVICE_NAME = "hmd_app_exit_reason";

    public CrashAgent() {
    }

    public static void monitorCrash(CrashType r10, long r11, JSONObject r12) {
        CrashType r13 = CrashType.ANR;
        if (r10 != r13) goto L5;
        boolean r14 = !TextUtils.isEmpty(r12.optString(AnrInfoParser.ANR_INFO));
    L6:
        String r15 = ActivityLifecycle.getLastResumedActivityFromBody(r12);
        ICrashMonitorService r16 = Global.getCrashMonitorService();     // Catch: Exception -> L24
        if (r16 != null) goto L12;
        IApmAgent r17 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L24
        if (r17 != null) goto L13;
        return;
    L13:
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L24
        r18.put("app_exit_metrics", r10.getName());     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r15) == true) goto L16;
        r18.put("scene", r15);     // Catch: Exception -> L24
    L16:
        if (r10 != r13) goto L18;
        r18.put("has_anr_info", r14);     // Catch: Exception -> L24
    L18:
        r18.put("crash_time", r11);     // Catch: Exception -> L24
        if (r16 == null) goto L22;
        r16.monitorEvent(SERVICE_NAME, r18, null, null);     // Catch: Exception -> L24
        return;
    L22:
        r17.monitorEvent(SERVICE_NAME, r18, null, null);     // Catch: Exception -> L24
        return;
    L12:
        r17 = null;
        goto L13
    L27:
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        ICrashMonitorService r14 = Global.getCrashMonitorService();     // Catch: Exception -> L11
        IApmAgent r15 = null;
        if (r14 != null) goto L7;
        r15 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L11
        if (r15 != null) goto L7;
        return;
    L7:
        if (r14 == null) goto L9;
        r14.monitorEvent(r10, r11, r12, r13);     // Catch: Exception -> L11
        return;
    L9:
        r15.monitorEvent(r10, r11, r12, r13);     // Catch: Exception -> L11
        return;
    }
}
