package j6;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements h6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f18260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f18261c;
    public JSONObject d;
    public JSONObject e;

    public e(String r5, String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        this.f18259a = r5;
        this.f18260b = r11;
        this.f18261c = r12;
        this.e = r13;
    }

    @Override // h6.b
    public final String a() {
        return this.f18259a;
    }

    @Override // h6.b
    public final boolean b(JSONObject r5) {
        if ("fps".equals(this.f18259a) == false) goto L5;
        return false;
    L5:
        if ("fps_drop".equals(this.f18259a) == false) goto L8;
        return false;
    L8:
        if ("temperature".equals(this.f18259a) == false) goto L11;
        return false;
    L11:
        if ("battery".equals(this.f18259a) == false) goto L14;
        return true;
    L14:
        if ("start".equals(this.f18259a) == false) goto L17;
        return false;
    L17:
        if ("start_trace".equals(this.f18259a) == false) goto L25;
        if (r5 == null) goto L26;
        r5.remove("perf_data");
        JSONObject r10 = r5.optJSONObject("trace");
        if (r10 == null) goto L27;
        r10.remove("spans");
        return false;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    @Override // h6.b
    public final JSONObject c() {
    L41:
        return null;
    L3:
        if (this.e != null) goto L5;
        this.e = new JSONObject();     // Catch: JSONException -> L41
    L5:
        this.e.put("log_type", "performance_monitor");     // Catch: JSONException -> L41
        this.e.put(NotificationCompat.CATEGORY_SERVICE, this.f18259a);     // Catch: JSONException -> L41
        JSONObject r5 = this.f18260b;     // Catch: JSONException -> L41
        boolean r10 = true;
        if (r5 != null) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == true) goto L15;
        this.e.put("extra_values", this.f18260b);     // Catch: JSONException -> L41
    L15:
        if (TextUtils.equals("start", this.f18259a) == true) goto L17;
    L22:
        JSONObject r12 = this.f18261c;     // Catch: JSONException -> L41
        if (r12 != null) goto L25;
    L28:
        boolean r13 = true;
    L29:
        if (r13 == true) goto L31;
        this.e.put("extra_status", this.f18261c);     // Catch: JSONException -> L41
    L31:
        JSONObject r14 = this.d;     // Catch: JSONException -> L41
        if (r14 != null) goto L34;
    L37:
        if (r10 == true) goto L39;
        this.e.put("filters", this.d);     // Catch: JSONException -> L41
    L39:
        return this.e;
    L34:
        if (r14.length() == 0) goto L37;
        r10 = false;
        goto L37
    L25:
        if (r12.length() == 0) goto L28;
        r13 = false;
        goto L29
    L17:
        if (TextUtils.equals("from", this.e.optString("monitor-plugin")) == false) goto L22;
        if (this.f18261c != null) goto L21;
        this.f18261c = new JSONObject();     // Catch: JSONException -> L41
    L21:
        this.f18261c.put("start_mode", j.f);     // Catch: JSONException -> L41
        goto L22
    L8:
        if (r5.length() == 0) goto L11;
        r11 = false;
        goto L12
    }

    @Override // h6.b
    public final boolean d() {
        return true;
    }

    @Override // h6.b
    public final String e() {
        return "performance_monitor";
    }

    public e(JSONObject r10) {
        this("thread", "", null, null, r10);
    }
}
