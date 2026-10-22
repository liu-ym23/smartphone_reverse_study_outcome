package k5;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import x4.j0;
import x4.r;
import x4.z;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f8932b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f8933a;

    public c() {
        this.f8933a = new ConcurrentHashMap();
    }

    public static c b() {
        if (f8932b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8932b != null) goto L9;
        f8932b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f8932b;
    }

    public static void e(j0 r8, JSONObject r10, JSONObject r11) {
        JSONObject r12 = new JSONObject();
        if (TextUtils.isEmpty(r11.optString("device_id_str")) == true) goto L5;
        boolean r13 = true;
    L6:
        JSONObject r14 = r10.optJSONObject("oaid");
        String r15 = null;
        if (r14 == null) goto L9;
        g5.n r16 = g5.n.a(r14.toString());
    L10:
        boolean r17 = TextUtils.isEmpty(r10.optString("install_id"));
        boolean r18 = TextUtils.isEmpty(r10.optString("device_id"));
        r12.put("reqeust_did_success", r13);     // Catch: JSONException -> L21
        r12.put("empty_iid", r17);     // Catch: JSONException -> L21
        r12.put("empty_did", r18);     // Catch: JSONException -> L21
        if (r16 != null) goto L14;
        String r19 = null;
    L15:
        r12.put("dr_oaid", r19);     // Catch: JSONException -> L21
        r12.put("oaid_thread_switch_ts", defpackage.c.f3197b - defpackage.c.f3196a);     // Catch: JSONException -> L21
        r12.put("oaid_file_load_ts", defpackage.c.f3198c - defpackage.c.f3197b);     // Catch: JSONException -> L21
        r12.put("oaid_sys_call_ts", defpackage.c.f3199d - defpackage.c.f3198c);     // Catch: JSONException -> L21
        r12.put("oaid_save_ts", defpackage.c.f3200e - defpackage.c.f3199d);     // Catch: JSONException -> L21
        r12.put("dr_wait_oaid_realtime", defpackage.c.f3202g - defpackage.c.f3201f);     // Catch: JSONException -> L21
        r12.put("dr_wait_oaid_estimate_time", defpackage.c.f3202g - defpackage.c.f3201f);     // Catch: JSONException -> L21
        r12.put("support_oaid", r10.optBoolean("oaid_may_support"));     // Catch: JSONException -> L21
        g5.m r20 = g5.k.c(r8.f13465c).f7655a;     // Catch: JSONException -> L21
        if (r20 == null) goto L19;
        r15 = r20.getName();     // Catch: JSONException -> L21
    L19:
        r12.put("oaid_impl", r15);     // Catch: JSONException -> L21
    L23:
        if (r8 == null) goto L27;
        z r21 = r8.B;
        if (r21 == null) goto L27;
        r21.a();
    L27:
        r12.toString();
        int r22 = r.f13543a;
        return;
    L14:
        r19 = r16.f7669a;     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L9:
        r16 = null;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    public final b5.a a(int r8) {
        ConcurrentHashMap r10 = this.f8933a;
        Map r11 = (Map) r10.get(String.valueOf(r8));
        if (r11 != null) goto L5;
        r11 = new ConcurrentHashMap();
        r10.put(String.valueOf(r8), r11);
    L5:
        b5.a r12 = (b5.a) r11.get("activate");
        if (r12 != null) goto L9;
        b5.a r13 = new b5.a();
        r11.put("activate", r13);
        return r13;
    L9:
        return r12;
    }

    public final b5.b c(int r8) {
        ConcurrentHashMap r10 = this.f8933a;
        Map r11 = (Map) r10.get(String.valueOf(r8));
        if (r11 != null) goto L5;
        r11 = new ConcurrentHashMap();
        r10.put(String.valueOf(r8), r11);
    L5:
        b5.b r12 = (b5.b) r11.get("params");
        if (r12 != null) goto L9;
        b5.b r13 = new b5.b();
        r11.put("params", r13);
        return r13;
    L9:
        return r12;
    }

    public final b5.c d(int r8) {
        ConcurrentHashMap r10 = this.f8933a;
        Map r11 = (Map) r10.get(String.valueOf(r8));
        if (r11 != null) goto L5;
        r11 = new ConcurrentHashMap();
        r10.put(String.valueOf(r8), r11);
    L5:
        b5.c r12 = (b5.c) r11.get("register");
        if (r12 != null) goto L9;
        b5.c r13 = new b5.c();
        r11.put("register", r13);
        return r13;
    L9:
        return r12;
    }
}
