package com.bytedance.apm.data.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f1286b;
    private boolean c;
    private long d;

    public d(String r3, JSONObject r4) {
        this(r3, r4, System.currentTimeMillis());
    }

    public d(String r1, JSONObject r2, long r3) {
        this.f1285a = r1;
        this.f1286b = r2;
        this.d = r3;
    }

    @Override // com.bytedance.apm.data.b
    public JSONObject a() {
        JSONObject r0 = this.f1286b;
        if (r0 != null) goto L18;
        return null;
    L18:
        r0.put("timestamp", this.d);     // Catch: JSONException -> L17
        this.f1286b.put("crash_time", this.d);     // Catch: JSONException -> L17
        this.f1286b.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.b.f());     // Catch: JSONException -> L17
        this.f1286b.put("process_name", com.bytedance.apm.b.e());     // Catch: JSONException -> L17
        this.f1286b.put("log_type", this.f1285a);     // Catch: JSONException -> L17
        if (com.bytedance.apm.b.w() <= com.bytedance.apm.b.i()) goto L8;
    L11:
        JSONObject r1 = this.f1286b;     // Catch: JSONException -> L17
        long r2 = com.bytedance.apm.b.i();     // Catch: JSONException -> L17
    L10:
        r1.put("app_launch_start_time", r2);     // Catch: JSONException -> L17
        goto L14
    L8:
        if (com.bytedance.apm.b.w() == 0) goto L11;
        r1 = this.f1286b;     // Catch: JSONException -> L17
        r2 = com.bytedance.apm.b.w();     // Catch: JSONException -> L17
    L14:
        return this.f1286b;
    }

    @Override // com.bytedance.apm.data.b
    public boolean a(JSONObject r1) {
        if (this.c == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.apm.j.c.e(this.f1285a) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.apm.data.b
    public String b() {
        return this.f1285a;
    }

    @Override // com.bytedance.apm.data.b
    public String c() {
        return this.f1285a;
    }

    @Override // com.bytedance.apm.data.b
    public boolean d() {
        return true;
    }

    public void e() {
        this.c = true;
    }

    public long f() {
        return this.d;
    }

    public String toString() {
        return "ExceptionLogData{eventType='" + this.f1285a + "', logJson=" + this.f1286b + ", forceSampled=" + this.c + ", time=" + this.d + '}';
    }
}
