package com.bytedance.apm.data.a;

import com.bytedance.apm6.perf.base.model.LogTypeName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.apm.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f1282b;
    public boolean c;

    public b(String r1, JSONObject r2, boolean r3) {
        this.f1281a = r1;
        this.f1282b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.apm.data.b
    public JSONObject a() {
        JSONObject r0 = this.f1282b;
        if (r0 != null) goto L10;
        return null;
    L10:
        r0.put("log_type", this.f1281a);     // Catch: JSONException -> L9
    L6:
        return this.f1282b;
    }

    @Override // com.bytedance.apm.data.b
    public boolean a(JSONObject r1) {
        return com.bytedance.apm.j.c.a(this.f1281a);
    }

    @Override // com.bytedance.apm.data.b
    public String b() {
        return LogTypeName.MONITOR_LOG_TYPE_COMMON_LOG;
    }

    @Override // com.bytedance.apm.data.b
    public String c() {
        return this.f1281a;
    }

    @Override // com.bytedance.apm.data.b
    public boolean d() {
        return true;
    }
}
