package y;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f13600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f13602h;

    public a(String r10, long r11, long r12, String r13, String r14, String r15, int r16, JSONObject r17) {
        this.f13595a = r10;
        this.f13596b = r11;
        this.f13597c = r12;
        this.f13598d = r13;
        this.f13599e = r14;
        this.f13600f = r15;
        this.f13601g = r16;
        if (r17 != null) goto L5;
        this.f13602h = new JSONObject();
        return;
    L5:
        this.f13602h = r17;
    }

    @Override // w.b
    public String a() {
        return null;
    }

    @Override // w.b
    public boolean b(JSONObject r10) {
        return false;
    }

    @Override // w.b
    @Nullable
    public JSONObject c() {
        if (TextUtils.isEmpty(this.f13595a) == false) goto L20;
        return null;
    L20:
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L19
        r10.put("log_type", this.f13595a);     // Catch: Exception -> L19
        r10.put("duration", this.f13596b);     // Catch: Exception -> L19
        r10.put("uri", Uri.parse(this.f13598d));     // Catch: Exception -> L19
        long r11 = this.f13597c;     // Catch: Exception -> L19
        if (r11 <= 0) goto L8;
        r10.put("timestamp", r11);     // Catch: Exception -> L19
    L8:
        r10.put("status", this.f13601g);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(this.f13599e) == true) goto L13;
        r10.put("ip", this.f13599e);     // Catch: Exception -> L19
    L13:
        if (TextUtils.isEmpty(this.f13600f) == true) goto L16;
        String r12 = this.f13600f;     // Catch: Exception -> L19
    L15:
        r10.put("trace_code", r12);     // Catch: Exception -> L19
        return r10;
    L16:
        r12 = "";
    L19:
        return null;
    }

    @Override // w.b
    public boolean d() {
        return true;
    }

    @Override // w.b
    public String e() {
        return null;
    }

    public void f(String r10) {
        if (this.f13602h.isNull("net_consume_type") == false) goto L6;
        this.f13602h.put("net_consume_type", r10);
        return;
    }

    public void g(boolean r10) {
        if (this.f13602h.isNull(CpuReportEvent.VALUE_FRONT) == false) goto L6;
        this.f13602h.put(CpuReportEvent.VALUE_FRONT, r10 ? 1 : 0);
        return;
    }

    public void h() {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put("trace_base", com.bytedance.apm.d.f());     // Catch: JSONException -> L4
        this.f13602h.put("relate_start_trace", r10);     // Catch: JSONException -> L4
        return;
    }
}
