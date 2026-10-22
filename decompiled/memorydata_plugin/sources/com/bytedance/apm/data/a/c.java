package com.bytedance.apm.data.a;

import com.bytedance.crash.entity.EventBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.apm.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1284b;
    public JSONObject c;
    public JSONObject d;
    public JSONObject e;
    public JSONObject f;
    public boolean g;

    public c(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f1283a = r1;
        this.f1284b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public c(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6, boolean r7) {
        this.f1283a = r1;
        this.f1284b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // com.bytedance.apm.data.b
    public JSONObject a() {
        if (this.f != null) goto L18;
        this.f = new JSONObject();
    L18:
        this.f.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.f.put("service", this.f1283a);     // Catch: JSONException -> L16
        this.f.put("status", this.f1284b);     // Catch: JSONException -> L16
        JSONObject r0 = this.c;     // Catch: JSONException -> L16
        if (r0 == null) goto L8;
        this.f.put(EventBody.KEY_VALUE, r0);     // Catch: JSONException -> L16
    L8:
        JSONObject r1 = this.d;     // Catch: JSONException -> L16
        if (r1 == null) goto L11;
        this.f.put(EventBody.KEY_CATEGORY, r1);     // Catch: JSONException -> L16
    L11:
        JSONObject r2 = this.e;     // Catch: JSONException -> L16
        if (r2 == null) goto L14;
        this.f.put(EventBody.KEY_METRIC, r2);     // Catch: JSONException -> L16
    L14:
        return this.f;
    L16:
        return null;
    }

    @Override // com.bytedance.apm.data.b
    public boolean a(JSONObject r1) {
        return com.bytedance.apm.j.c.b(this.f1283a);
    }

    @Override // com.bytedance.apm.data.b
    public String b() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.b
    public String c() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.b
    public boolean d() {
        return true;
    }
}
