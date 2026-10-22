package com.bytedance.applog.monitor.v3.impl;

import com.bytedance.applog.monitor.v3.StageEventType;
import com.ss.android.common.applog.EventVerify;
import ex3.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class LatencyMonitor$a {
    public int a;
    public int b;
    public StageEventType c;
    public LatencyMonitor$EventLatencyScope d;

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put(EventVerify.TYPE_EVENT_V1, "sdk_event_latency");     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.put("stage", 2);     // Catch: Throwable -> L5
        r1.put("event_priority", this.b);     // Catch: Throwable -> L5
        r1.put("event_type", this.c.getLabel());     // Catch: Throwable -> L5
        r1.put("interval_scope", this.d.toString());     // Catch: Throwable -> L5
        r1.put("event_count", this.a);     // Catch: Throwable -> L5
        r0.put("params", r1);     // Catch: Throwable -> L5
        r0.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L5
        r0.put("event_id", g.b.incrementAndGet());     // Catch: Throwable -> L5
        r0.put("datetime", g.a());     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public LatencyMonitor$a() {
        this.a = 0;
        this.b = -1;
        this.c = StageEventType.V3_EVENT;
        this.d = LatencyMonitor$EventLatencyScope.l_0_60;
    }
}
