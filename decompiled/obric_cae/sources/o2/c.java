package o2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements m2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f9629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f9630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f9631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f9632f;

    public c(String r8, int r10, JSONObject r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        this.f9627a = r8;
        this.f9628b = r10;
        this.f9629c = r11;
        this.f9630d = r12;
        this.f9631e = r13;
        this.f9632f = r14;
    }

    @Override // m2.c
    public final String a() {
        return "service_monitor";
    }

    @Override // m2.c
    public final boolean b(JSONObject r8) {
        return false;
    }

    @Override // m2.c
    public final JSONObject c() {
        if (this.f9632f != null) goto L18;
        this.f9632f = new JSONObject();
    L18:
        this.f9632f.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.f9632f.put("service", this.f9627a);     // Catch: JSONException -> L16
        this.f9632f.put("status", this.f9628b);     // Catch: JSONException -> L16
        JSONObject r8 = this.f9629c;     // Catch: JSONException -> L16
        if (r8 == null) goto L8;
        this.f9632f.put("value", r8);     // Catch: JSONException -> L16
    L8:
        JSONObject r10 = this.f9630d;     // Catch: JSONException -> L16
        if (r10 == null) goto L11;
        this.f9632f.put("category", r10);     // Catch: JSONException -> L16
    L11:
        JSONObject r11 = this.f9631e;     // Catch: JSONException -> L16
        if (r11 == null) goto L14;
        this.f9632f.put("metric", r11);     // Catch: JSONException -> L16
    L14:
        return this.f9632f;
    L16:
        return null;
    }

    @Override // m2.c
    public final boolean d() {
        return true;
    }

    @Override // m2.c
    public final String e() {
        return "service_monitor";
    }
}
