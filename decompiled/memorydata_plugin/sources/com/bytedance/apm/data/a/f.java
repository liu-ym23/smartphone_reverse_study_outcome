package com.bytedance.apm.data.a;

import com.bytedance.apm6.perf.base.model.LogTypeName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.apm.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1290b;
    public JSONObject c;
    public JSONObject d;

    public f(String r1, String r2, JSONObject r3, JSONObject r4) {
        this.f1289a = r1;
        this.f1290b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // com.bytedance.apm.data.b
    public JSONObject a() {
    L7:
        return null;
    L3:
        if (this.d != null) goto L5;
        this.d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.d.put("log_type", LogTypeName.MONITOR_LOG_TYPE_UI_ACTION);     // Catch: JSONException -> L7
        this.d.put("action", this.f1289a);     // Catch: JSONException -> L7
        this.d.put("page", this.f1290b);     // Catch: JSONException -> L7
        this.d.put("context", this.c);     // Catch: JSONException -> L7
        return this.d;
    }

    @Override // com.bytedance.apm.data.b
    public boolean a(JSONObject r1) {
        return com.bytedance.apm.j.c.d("ui");
    }

    @Override // com.bytedance.apm.data.b
    public String b() {
        return LogTypeName.MONITOR_LOG_TYPE_UI_ACTION;
    }

    @Override // com.bytedance.apm.data.b
    public String c() {
        return LogTypeName.MONITOR_LOG_TYPE_UI_ACTION;
    }

    @Override // com.bytedance.apm.data.b
    public boolean d() {
        return true;
    }
}
