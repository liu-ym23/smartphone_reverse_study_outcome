package com.bytedance.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f1897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1898b;
    private final boolean c;
    private final String d;

    public d(JSONObject r1, String r2, boolean r3, String r4) {
        this.f1897a = r1;
        this.f1898b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // com.bytedance.apm.data.b
    public JSONObject a() {
        return this.f1897a;
    }

    @Override // com.bytedance.apm.data.b
    public boolean a(JSONObject r2) {
        if ("app_launch_trace".equals(this.f1898b) == false) goto L7;
        return com.bytedance.apm.j.c.d("start_trace");
    L7:
        if (c.a().a(this.c, this.f1898b) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.apm.data.b
    public String b() {
        return "tracing";
    }

    @Override // com.bytedance.apm.data.b
    public String c() {
        return this.d;
    }

    @Override // com.bytedance.apm.data.b
    public boolean d() {
        return false;
    }
}
