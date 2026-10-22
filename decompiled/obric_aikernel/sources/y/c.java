package y;

import androidx.annotation.Nullable;
import com.bytedance.crash.entity.EventBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f13607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f13608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f13609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f13610f;

    public c(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        this.f13605a = r10;
        this.f13606b = r11;
        this.f13607c = r12;
        this.f13608d = r13;
        this.f13609e = r14;
        this.f13610f = r15;
    }

    public c(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15, boolean r16) {
        this.f13605a = r10;
        this.f13606b = r11;
        this.f13607c = r12;
        this.f13608d = r13;
        this.f13609e = r14;
        this.f13610f = r15;
    }

    @Override // w.b
    public String a() {
        return "service_monitor";
    }

    @Override // w.b
    public boolean b(JSONObject r10) {
        return o0.c.f(this.f13605a);
    }

    @Override // w.b
    @Nullable
    public JSONObject c() {
        if (this.f13610f != null) goto L18;
        this.f13610f = new JSONObject();
    L18:
        this.f13610f.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.f13610f.put("service", this.f13605a);     // Catch: JSONException -> L16
        this.f13610f.put("status", this.f13606b);     // Catch: JSONException -> L16
        JSONObject r10 = this.f13607c;     // Catch: JSONException -> L16
        if (r10 == null) goto L8;
        this.f13610f.put(EventBody.KEY_VALUE, r10);     // Catch: JSONException -> L16
    L8:
        JSONObject r11 = this.f13608d;     // Catch: JSONException -> L16
        if (r11 == null) goto L11;
        this.f13610f.put(EventBody.KEY_CATEGORY, r11);     // Catch: JSONException -> L16
    L11:
        JSONObject r12 = this.f13609e;     // Catch: JSONException -> L16
        if (r12 == null) goto L14;
        this.f13610f.put(EventBody.KEY_METRIC, r12);     // Catch: JSONException -> L16
    L14:
        return this.f13610f;
    L16:
        return null;
    }

    @Override // w.b
    public boolean d() {
        return true;
    }

    @Override // w.b
    public String e() {
        return "service_monitor";
    }
}
