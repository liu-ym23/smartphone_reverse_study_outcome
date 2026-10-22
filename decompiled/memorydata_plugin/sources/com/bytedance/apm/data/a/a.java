package com.bytedance.apm.data.a;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.apm.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1280b;
    public long c;
    public String d;
    public String e;
    public String f;
    public int g;
    public JSONObject h;

    public a(String r1, long r2, long r4, String r6, String r7, String r8, int r9, JSONObject r10) {
        this.f1279a = r1;
        this.f1280b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        if (r10 != null) goto L5;
        this.h = new JSONObject();
        return;
    L5:
        this.h = r10;
    }

    @Override // com.bytedance.apm.data.b
    public JSONObject a() {
        if (TextUtils.isEmpty(this.f1279a) == false) goto L20;
        return null;
    L20:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L19
        r0.put("log_type", this.f1279a);     // Catch: Exception -> L19
        r0.put("duration", this.f1280b);     // Catch: Exception -> L19
        r0.put("uri", Uri.parse(this.d));     // Catch: Exception -> L19
        long r2 = this.c;     // Catch: Exception -> L19
        if (r2 <= 0) goto L8;
        r0.put("timestamp", r2);     // Catch: Exception -> L19
    L8:
        r0.put("status", this.g);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(this.e) == true) goto L13;
        r0.put("ip", this.e);     // Catch: Exception -> L19
    L13:
        if (TextUtils.isEmpty(this.f) == true) goto L16;
        String r6 = this.f;     // Catch: Exception -> L19
    L15:
        r0.put("trace_code", r6);     // Catch: Exception -> L19
        return r0;
    L16:
        r6 = "";
    L19:
        return null;
    }

    public void a(String r3) {
        if (this.h.isNull("net_consume_type") == false) goto L6;
        this.h.put("net_consume_type", r3);
        return;
    }

    public void a(boolean r3) {
        if (this.h.isNull(CpuReportEvent.VALUE_FRONT) == false) goto L6;
        this.h.put(CpuReportEvent.VALUE_FRONT, r3 ? 1 : 0);
        return;
    }

    @Override // com.bytedance.apm.data.b
    public boolean a(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.apm.data.b
    public String b() {
        return null;
    }

    @Override // com.bytedance.apm.data.b
    public String c() {
        return null;
    }

    @Override // com.bytedance.apm.data.b
    public boolean d() {
        return true;
    }

    public void e() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("trace_base", com.bytedance.apm.b.w());     // Catch: JSONException -> L4
        this.h.put("relate_start_trace", r0);     // Catch: JSONException -> L4
        return;
    }
}
