package com.bytedance.android.live.saas.middleware.monitor;

import android.app.Application;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class IMonitorReport {
    public IMonitorReport() {
    }

    public abstract void ensureNotReachHere(Throwable r1, String r2);

    public void init(Application r1) {
    }

    public abstract void monitorApiError(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9);

    public abstract void monitorCommonLog(String r1, String r2, JSONObject r3);

    public abstract void monitorCommonLog(String r1, JSONObject r2);

    public abstract void monitorDebugReal(String r1);

    public abstract void monitorDebugReal(String r1, String r2);

    public abstract void monitorDirectOnCount(String r1, String r2, float r3);

    public abstract void monitorDirectOnTimer(String r1, String r2, float r3);

    public abstract void monitorDuration(String r1, JSONObject r2, JSONObject r3);

    public abstract void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    public abstract void monitorOnCount(String r1, String r2);

    public abstract void monitorOnCount(String r1, String r2, float r3);

    public abstract void monitorOnStore(String r1, String r2, float r3);

    public abstract void monitorOnTimer(String r1, String r2, float r3);

    public abstract void monitorSLA(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9);

    public abstract void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4);

    public abstract void monitorStatusRate(String r1, int r2, JSONObject r3);

    public void callInit(Application r1) {
        init(r1);
    }
}
