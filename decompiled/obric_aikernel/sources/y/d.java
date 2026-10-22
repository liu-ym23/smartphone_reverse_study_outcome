package y;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f13612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13614d;

    public d(String r10, JSONObject r11) {
        this(r10, r11, System.currentTimeMillis());
    }

    public d(String r10, JSONObject r11, long r12) {
        this.f13611a = r10;
        this.f13612b = r11;
        this.f13614d = r12;
    }

    @Override // w.b
    public String a() {
        return this.f13611a;
    }

    @Override // w.b
    public boolean b(JSONObject r10) {
        if (this.f13613c == false) goto L5;
    L8:
        return true;
    L5:
        if (o0.c.e(this.f13611a) == true) goto L8;
        return false;
    }

    @Override // w.b
    @Nullable
    public JSONObject c() {
        JSONObject r10 = this.f13612b;
        if (r10 != null) goto L18;
        return null;
    L18:
        r10.put("timestamp", this.f13614d);     // Catch: JSONException -> L17
        this.f13612b.put("crash_time", this.f13614d);     // Catch: JSONException -> L17
        this.f13612b.put("is_main_process", com.bytedance.apm.d.I());     // Catch: JSONException -> L17
        this.f13612b.put("process_name", com.bytedance.apm.d.h());     // Catch: JSONException -> L17
        this.f13612b.put("log_type", this.f13611a);     // Catch: JSONException -> L17
        if (com.bytedance.apm.d.f() <= com.bytedance.apm.d.B()) goto L8;
    L11:
        JSONObject r11 = this.f13612b;     // Catch: JSONException -> L17
        long r12 = com.bytedance.apm.d.B();     // Catch: JSONException -> L17
    L10:
        r11.put("app_launch_start_time", r12);     // Catch: JSONException -> L17
        goto L14
    L8:
        if (com.bytedance.apm.d.f() == 0) goto L11;
        r11 = this.f13612b;     // Catch: JSONException -> L17
        r12 = com.bytedance.apm.d.f();     // Catch: JSONException -> L17
    L14:
        return this.f13612b;
    }

    @Override // w.b
    public boolean d() {
        return true;
    }

    @Override // w.b
    public String e() {
        return this.f13611a;
    }

    public long f() {
        return this.f13614d;
    }

    public void g() {
        this.f13613c = true;
    }

    public String toString() {
        return "ExceptionLogData{eventType='" + this.f13611a + "', logJson=" + this.f13612b + ", forceSampled=" + this.f13613c + ", time=" + this.f13614d + '}';
    }
}
