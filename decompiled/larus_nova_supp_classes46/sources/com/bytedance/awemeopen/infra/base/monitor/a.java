package com.bytedance.awemeopen.infra.base.monitor;

import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.monitor.AoMonitorService;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Function0<Unit> {
    public a() {
    }

    public final Object invoke() {
        monitor-enter(AoMonitor.class);
    L41:
        th = move-exception;
        throw th;
    L5:
        if (AoMonitor.b() == false) goto L8;
        monitor-exit(AoMonitor.class);
        return null;
    L8:
        AoHostService r1 = j64.a.a(AoHostService.class);     // Catch: Throwable -> L41
        if (r1 != null) goto L13;
        AoLogger.i(new Object[]{"BdpInfoService is null "});     // Catch: Throwable -> L41
        monitor-exit(AoMonitor.class);
        return null;
    L13:
        String r4 = "";
        String r5 = "";
        r4 = r1.getDeviceId();     // Catch: Throwable -> L16
        r5 = (String) AoEnv.b.invoke();     // Catch: Throwable -> L16
    L18:
        if (TextUtils.equals(r4, "null") == true) goto L24;
        if (TextUtils.isEmpty(r4) == true) goto L24;
        if (TextUtils.equals(r4, "0") == true) goto L24;
    L30:
        String r6 = String.valueOf(313526);     // Catch: Throwable -> L41
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L41
        r7.put("device_id", r4);     // Catch: JSONException -> L33 Throwable -> L41
        r7.put("bd_device_id", r5);     // Catch: JSONException -> L33 Throwable -> L41
        r7.put("channel", r1.getHostChannel());     // Catch: JSONException -> L33 Throwable -> L41
        r7.put("host_aid", r1.getHostAid());     // Catch: JSONException -> L33 Throwable -> L41
        r7.put("app_version", r1.getHostVersionName());     // Catch: JSONException -> L33 Throwable -> L41
        r7.put("update_version_code", r1.getHostVersionCode());     // Catch: JSONException -> L33 Throwable -> L41
        r7.put("sdk_version", "3.7.3");     // Catch: JSONException -> L33 Throwable -> L41
    L35:
        AoMonitor.a = j64.a.a(AoMonitorService.class).Z(r1.getHostApplication(), r6, r7, Arrays.asList(d.a));     // Catch: Throwable -> L41
        AoPool.f(new b());     // Catch: Throwable -> L41
        monitor-exit(AoMonitor.class);
        return null;
    L33:
        e = move-exception;
        AoLogger.c("AoAppMonitor", new Object[]{e.getMessage()});     // Catch: Throwable -> L41
    L24:
        if (TextUtils.equals(r5, "null") == false) goto L26;
    L38:
        monitor-exit(AoMonitor.class);
        return null;
    L26:
        if (TextUtils.isEmpty(r5) == true) goto L38;
        if (TextUtils.equals(r5, "0") == false) goto L30;
    L16:
        AoLogger.c("AoAppMonitor", new Object[]{"Get error deviceId."});     // Catch: Throwable -> L41
        goto L18
    }
}
