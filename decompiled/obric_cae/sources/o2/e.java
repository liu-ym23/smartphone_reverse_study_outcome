package o2;

import android.text.TextUtils;
import c2.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements m2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f9639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f9640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f9641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f9642f;

    public e(String r8, String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        this(r8, r10, r11, r12, r13, 0);
    }

    @Override // m2.c
    public final String a() {
        return this.f9637a;
    }

    @Override // m2.c
    public final boolean b(JSONObject r8) {
        if ("fps".equals(this.f9637a) == false) goto L5;
    L22:
        boolean r10 = false;
    L24:
        if (this.f9638b == true) goto L29;
        if (r10 == false) goto L28;
        return true;
    L28:
        return false;
    L29:
        return true;
    L5:
        if ("fps_drop".equals(this.f9637a) == true) goto L22;
        if ("temperature".equals(this.f9637a) == true) goto L22;
        if ("battery".equals(this.f9637a) == false) goto L14;
        r10 = true;
        goto L24
    L14:
        if ("start".equals(this.f9637a) == true) goto L22;
        if ("start_trace".equals(this.f9637a) == false) goto L22;
        if (r8 == null) goto L22;
        r8.remove("perf_data");
        JSONObject r11 = r8.optJSONObject("trace");
        if (r11 == null) goto L22;
        r11.remove("spans");
        goto L22
    }

    @Override // m2.c
    public final JSONObject c() {
    L24:
        return null;
    L3:
        if (this.f9642f != null) goto L5;
        this.f9642f = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.f9642f.put("log_type", "performance_monitor");     // Catch: JSONException -> L24
        this.f9642f.put("service", this.f9637a);     // Catch: JSONException -> L24
        if (l6.a.f0(this.f9639c) == true) goto L9;
        this.f9642f.put("extra_values", this.f9639c);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals("start", this.f9637a) == false) goto L17;
        if (TextUtils.equals("from", this.f9642f.optString("monitor-plugin")) == false) goto L17;
        if (this.f9640d != null) goto L15;
        this.f9640d = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.f9640d.put("start_mode", k.f3303g);     // Catch: JSONException -> L24
    L17:
        if (l6.a.f0(this.f9640d) == true) goto L20;
        this.f9642f.put("extra_status", this.f9640d);     // Catch: JSONException -> L24
    L20:
        if (l6.a.f0(this.f9641e) == true) goto L22;
        this.f9642f.put("filters", this.f9641e);     // Catch: JSONException -> L24
    L22:
        return this.f9642f;
    }

    @Override // m2.c
    public final boolean d() {
        return true;
    }

    @Override // m2.c
    public final String e() {
        return "performance_monitor";
    }

    public e(String r8, String r10, JSONObject r11, JSONObject r12, JSONObject r13, int r14) {
        this.f9637a = r8;
        this.f9638b = false;
        this.f9639c = r11;
        this.f9640d = r12;
        this.f9642f = r13;
    }
}
