package com.bytedance.apm.data.a;

import android.text.TextUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.apm.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1288b;
    public boolean c;
    public JSONObject d;
    public JSONObject e;
    public JSONObject f;
    public JSONObject g;

    public e() {
    }

    public e(String r8, String r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        this(r8, r9, false, r10, r11, r12);
    }

    public e(String r1, String r2, boolean r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.f1287a = r1;
        this.f1288b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.g = r6;
    }

    public e(String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        this(r8, "", false, r9, r10, r11);
    }

    public e a(String r1) {
        this.f1287a = r1;
        return this;
    }

    @Override // com.bytedance.apm.data.b
    public JSONObject a() {
    L24:
        return null;
    L3:
        if (this.g != null) goto L5;
        this.g = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.g.put("log_type", LogTypeName.MONITOR_LOG_TYPE_PERFORMANCE);     // Catch: JSONException -> L24
        this.g.put("service", this.f1287a);     // Catch: JSONException -> L24
        if (JsonUtils.b(this.d) == true) goto L9;
        this.g.put("extra_values", this.d);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals(CommonConsts.APM_INNER_EVENT_COST_START, this.f1287a) == false) goto L17;
        if (TextUtils.equals("from", this.g.optString(CommonConsts.API_CALL_FROM_PLUGIN)) == false) goto L17;
        if (this.e != null) goto L15;
        this.e = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.e.put("start_mode", com.bytedance.apm.b.j());     // Catch: JSONException -> L24
    L17:
        if (JsonUtils.b(this.e) == true) goto L20;
        this.g.put("extra_status", this.e);     // Catch: JSONException -> L24
    L20:
        if (JsonUtils.b(this.f) == true) goto L22;
        this.g.put("filters", this.f);     // Catch: JSONException -> L24
    L22:
        return this.g;
    }

    @Override // com.bytedance.apm.data.b
    public boolean a(JSONObject r5) {
        if ("fps".equals(this.f1287a) == false) goto L5;
    L33:
        boolean r6 = com.bytedance.apm.j.c.a(this.f1287a, this.f1288b);
    L35:
        if (this.c == true) goto L38;
        if (r6 == true) goto L38;
        return false;
    L38:
        return true;
    L5:
        if ("fps_drop".equals(this.f1287a) == true) goto L33;
        if ("temperature".equals(this.f1287a) == false) goto L11;
        r6 = com.bytedance.apm.j.c.e(this.f1287a);
        goto L35
    L11:
        if (Scraps.BATTERY.equals(this.f1287a) == false) goto L14;
    L12:
        r6 = true;
        goto L35
    L14:
        if (CommonConsts.APM_INNER_EVENT_COST_START.equals(this.f1287a) == false) goto L22;
        if (com.bytedance.apm.j.c.d(this.f1287a) == true) goto L12;
        if (com.bytedance.apm.j.c.c(this.f1288b) == true) goto L12;
        r6 = false;
        goto L35
    L22:
        if ("start_trace".equals(this.f1287a) == false) goto L32;
        if (r5 == null) goto L32;
        if (com.bytedance.apm.j.c.e("enable_perf_data_collect") == true) goto L28;
        r5.remove("perf_data");
    L28:
        if (com.bytedance.apm.j.c.d(this.f1287a) == true) goto L32;
        JSONObject r7 = r5.optJSONObject("trace");
        if (r7 == null) goto L32;
        r7.remove("spans");
    L32:
        r6 = com.bytedance.apm.j.c.d(this.f1287a);
        goto L35
    }

    public e b(JSONObject r1) {
        this.d = r1;
        return this;
    }

    @Override // com.bytedance.apm.data.b
    public String b() {
        return LogTypeName.MONITOR_LOG_TYPE_PERFORMANCE;
    }

    public e c(JSONObject r1) {
        this.e = r1;
        return this;
    }

    @Override // com.bytedance.apm.data.b
    public String c() {
        return this.f1287a;
    }

    public e d(JSONObject r1) {
        this.f = r1;
        return this;
    }

    @Override // com.bytedance.apm.data.b
    public boolean d() {
        return true;
    }

    public e e(JSONObject r1) {
        this.g = r1;
        return this;
    }

    public boolean e() {
        return TextUtils.equals(this.f1287a, SlardarSettingsConstants.PERF_KEY_MEMORY);
    }
}
