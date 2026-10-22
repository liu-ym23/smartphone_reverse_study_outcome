package com.bytedance.apm.battery.d.a;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1158b;

    public d() {
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("flags", this.f1157a);     // Catch: Throwable -> L4
        r0.put(LocationMonitorConst.TAG, this.f1158b);     // Catch: Throwable -> L4
        r0.put("start_time", this.d);     // Catch: Throwable -> L4
        r0.put("end_time", this.e);     // Catch: Throwable -> L4
        r0.put(LBSLightLocationTraceLogger.THREAD_NAME, this.f);     // Catch: Throwable -> L4
        r0.put("thread_stack", d());     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public String toString() {
        return "WakeLockInfo{flags=" + this.f1157a + ", tag=" + this.f1158b + ", startTime=" + this.d + ", endTime=" + this.e + ", threadName=" + this.f + ", threadStack=" + d() + '}';
    }
}
