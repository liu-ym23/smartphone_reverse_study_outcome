package y;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.util.i;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f13618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f13619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f13620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f13621g;

    public e() {
    }

    public e(String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        this(r10, r11, false, r12, r13, r14);
    }

    public e(String r10, String r11, boolean r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        this.f13615a = r10;
        this.f13616b = r11;
        this.f13617c = r12;
        this.f13618d = r13;
        this.f13619e = r14;
        this.f13621g = r15;
    }

    public e(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        this(r10, "", false, r11, r12, r13);
    }

    @Override // w.b
    public String a() {
        return this.f13615a;
    }

    @Override // w.b
    public boolean b(@Nullable JSONObject r10) {
        if ("fps".equals(this.f13615a) == false) goto L5;
    L33:
        boolean r11 = o0.c.d(this.f13615a, this.f13616b);
    L35:
        if (this.f13617c == true) goto L38;
        if (r11 == true) goto L38;
        return false;
    L38:
        return true;
    L5:
        if ("fps_drop".equals(this.f13615a) == true) goto L33;
        if ("temperature".equals(this.f13615a) == false) goto L11;
        r11 = o0.c.e(this.f13615a);
        goto L35
    L11:
        if (Scraps.BATTERY.equals(this.f13615a) == false) goto L14;
    L12:
        r11 = true;
        goto L35
    L14:
        if (CommonConsts.APM_INNER_EVENT_COST_START.equals(this.f13615a) == false) goto L22;
        if (o0.c.c(this.f13615a) == true) goto L12;
        if (o0.c.b(this.f13616b) == true) goto L12;
        r11 = false;
        goto L35
    L22:
        if ("start_trace".equals(this.f13615a) == false) goto L32;
        if (r10 == null) goto L32;
        if (o0.c.e("enable_perf_data_collect") == true) goto L28;
        r10.remove("perf_data");
    L28:
        if (o0.c.c(this.f13615a) == true) goto L32;
        JSONObject r12 = r10.optJSONObject("trace");
        if (r12 == null) goto L32;
        r12.remove("spans");
    L32:
        r11 = o0.c.c(this.f13615a);
        goto L35
    }

    @Override // w.b
    @Nullable
    public JSONObject c() {
    L24:
        return null;
    L3:
        if (this.f13621g != null) goto L5;
        this.f13621g = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.f13621g.put("log_type", LogTypeName.MONITOR_LOG_TYPE_PERFORMANCE);     // Catch: JSONException -> L24
        this.f13621g.put("service", this.f13615a);     // Catch: JSONException -> L24
        if (i.d(this.f13618d) == true) goto L9;
        this.f13621g.put("extra_values", this.f13618d);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals(CommonConsts.APM_INNER_EVENT_COST_START, this.f13615a) == false) goto L17;
        if (TextUtils.equals("from", this.f13621g.optString(CommonConsts.API_CALL_FROM_PLUGIN)) == false) goto L17;
        if (this.f13619e != null) goto L15;
        this.f13619e = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.f13619e.put("start_mode", com.bytedance.apm.d.u());     // Catch: JSONException -> L24
    L17:
        if (i.d(this.f13619e) == true) goto L20;
        this.f13621g.put("extra_status", this.f13619e);     // Catch: JSONException -> L24
    L20:
        if (i.d(this.f13620f) == true) goto L22;
        this.f13621g.put("filters", this.f13620f);     // Catch: JSONException -> L24
    L22:
        return this.f13621g;
    }

    @Override // w.b
    public boolean d() {
        return true;
    }

    @Override // w.b
    public String e() {
        return LogTypeName.MONITOR_LOG_TYPE_PERFORMANCE;
    }

    public e f(JSONObject r10) {
        this.f13620f = r10;
        return this;
    }

    public e g(JSONObject r10) {
        this.f13621g = r10;
        return this;
    }

    public e h(JSONObject r10) {
        this.f13619e = r10;
        return this;
    }

    public e i(JSONObject r10) {
        this.f13618d = r10;
        return this;
    }

    public boolean j() {
        return TextUtils.equals(this.f13615a, SlardarSettingsConstants.PERF_KEY_MEMORY);
    }

    public e k(String r10) {
        this.f13615a = r10;
        return this;
    }
}
