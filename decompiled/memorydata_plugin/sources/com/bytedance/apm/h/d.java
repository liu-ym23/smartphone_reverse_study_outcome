package com.bytedance.apm.h;

import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f1357a;

    private d() {
    }

    public static d a() {
        if (f1357a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1357a != null) goto L9;
        f1357a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f1357a;
    }

    public JSONObject b() {
        JSONObject r4 = new JSONObject();
        ICpuDataService r0 = (ICpuDataService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ICpuDataService.class), ICpuDataService.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L5
        r4.put("process_usage", r0.getCpuRate());     // Catch: JSONException -> L5
        r4.put("stat_speed", r0.getCpuSpeed());     // Catch: JSONException -> L5
        return r4;
    L6:
        return new JSONObject();
    }
}
