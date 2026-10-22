package j6;

import androidx.core.app.NotificationCompat;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements h6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f18252c;
    public final JSONObject d;
    public final JSONObject e;
    public JSONObject f;

    public b(String r5, int r10, JSONObject r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        this.f18250a = r5;
        this.f18251b = r10;
        this.f18252c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // h6.b
    public final String a() {
        return "service_monitor";
    }

    @Override // h6.b
    public final boolean b(JSONObject r5) {
        return false;
    }

    @Override // h6.b
    public final JSONObject c() {
        if (this.f != null) goto L18;
        this.f = new JSONObject();
    L18:
        this.f.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.f.put(NotificationCompat.CATEGORY_SERVICE, this.f18250a);     // Catch: JSONException -> L16
        this.f.put(NotificationCompat.CATEGORY_STATUS, this.f18251b);     // Catch: JSONException -> L16
        JSONObject r5 = this.f18252c;     // Catch: JSONException -> L16
        if (r5 == null) goto L8;
        this.f.put("value", r5);     // Catch: JSONException -> L16
    L8:
        JSONObject r10 = this.d;     // Catch: JSONException -> L16
        if (r10 == null) goto L11;
        this.f.put("category", r10);     // Catch: JSONException -> L16
    L11:
        JSONObject r11 = this.e;     // Catch: JSONException -> L16
        if (r11 == null) goto L14;
        this.f.put(LynxMonitorService.KEY_METRIC, r11);     // Catch: JSONException -> L16
    L14:
        return this.f;
    L16:
        return null;
    }

    @Override // h6.b
    public final boolean d() {
        return true;
    }

    @Override // h6.b
    public final String e() {
        return "service_monitor";
    }
}
