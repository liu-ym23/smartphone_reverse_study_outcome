package com.bytedance.apm.battery.d.a;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.capabilitykit.common.Ext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1156a;

    public c() {
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.d);     // Catch: Throwable -> L4
        r0.put("end_time", this.e);     // Catch: Throwable -> L4
        r0.put(LBSLightLocationTraceLogger.THREAD_NAME, this.f);     // Catch: Throwable -> L4
        r0.put("thread_stack", d());     // Catch: Throwable -> L4
        r0.put(Ext.KEY_REQUEST, this.f1156a);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public String toString() {
        return "LocInfo{request=" + this.f1156a + ", startTime=" + this.d + ", endTime=" + this.e + ", threadName=" + this.f + ", threadStack=" + d() + '}';
    }
}
