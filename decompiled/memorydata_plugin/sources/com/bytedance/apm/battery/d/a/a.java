package com.bytedance.apm.battery.d.a;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1155b;
    public String c;

    public a() {
    }

    public long a() {
        int r0 = this.f1154a;
        if (r0 == 1) goto L9;
        if (r0 == 0) goto L9;
        return (this.d + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    L9:
        return this.d;
    }

    public boolean b() {
        int r1 = this.f1154a;
        if (r1 == 2) goto L7;
        if (r1 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.d);     // Catch: Throwable -> L4
        r0.put("end_time", this.e);     // Catch: Throwable -> L4
        r0.put(LBSLightLocationTraceLogger.THREAD_NAME, this.f);     // Catch: Throwable -> L4
        r0.put("thread_stack", d());     // Catch: Throwable -> L4
        r0.put("interval", this.f1155b);     // Catch: Throwable -> L4
        r0.put("type", this.f1154a);     // Catch: Throwable -> L4
        r0.put("intent_info", this.c);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public String toString() {
        return "AlarmInfo{type=" + this.f1154a + ", interval=" + this.f1155b + ", intentInfo=" + this.c + ", startTime=" + this.d + ", endTime=" + this.e + ", threadName=" + this.f + ", threadStack=" + d() + '}';
    }
}
