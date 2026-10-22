package j2;

import a8.e;
import android.text.TextUtils;
import c2.k;
import g3.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b3.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f8561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f8562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f8563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile JSONObject f8564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile JSONObject f8565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f8566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f8567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f8568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f8569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f8570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f8571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f8572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f8575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CopyOnWriteArrayList f8576p;

    public class a implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f8577a;

        public a(d r8) {
            this.f8577a = r8;
        }
    }

    public d() {
        this.f8562b = false;
        this.f8566f = k2.a.f8925a;
        this.f8567g = 1200;
        this.f8569i = -1;
        this.f8570j = 60000;
        this.f8571k = -1;
        this.f8572l = false;
    }

    @Override // b3.b.c
    public final void a(long r8) {
        d(false);
    }

    public final void b() {
        if (this.f8561a == true) goto L16;
        this.f8561a = true;
        CopyOnWriteArrayList r8 = this.f8576p;
        if (r8 == null) goto L25;
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L26;
        ((v8.a) r10.next()).b();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (k.d() == false) goto L8;
        th.printStackTrace();
        goto L8
    L26:
        return;
    L25:
        return;
    }

    public final void c(JSONObject r8, boolean r10) {
        CopyOnWriteArrayList r11 = this.f8576p;
        if (r11 == null) goto L14;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L23;
        ((v8.a) r12.next()).a(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (k.d() == false) goto L6;
        th.printStackTrace();
        goto L6
    L23:
        return;
    }

    public final void d(boolean r10) {
        boolean r8 = false;
        if (this.f8574n == false) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L22;
        if (r10 == true) goto L21;
        long r12 = System.currentTimeMillis();
        long r13 = this.f8570j;
        if (r13 <= 60000) goto L17;
        if ((r12 - this.f8571k) > r13) goto L18;
    L19:
        boolean r14 = false;
    L20:
        if (r14 == false) goto L22;
    L18:
        r14 = true;
        goto L20
    L17:
        if ((r12 - this.f8569i) <= (this.f8567g * 1000)) goto L19;
    L21:
        r8 = true;
    L22:
        if (r8 == true) goto L24;
        return;
    L24:
        boolean r15 = k.f3297a;
        int r16 = f.f7630a;
        throw null;     // Catch: Exception -> L26
    L26:
        return;
    L5:
        if (this.f8573m == true) goto L8;
        r11 = false;
        goto L9
    }

    public final void e(JSONObject r8) {
        if (l6.a.f0(r8) == false) goto L5;
        return;
    L5:
        JSONObject r10 = l6.a.u0(r8, "general", "slardar_api_settings");
        if (r10 == null) goto L13;
        JSONObject r11 = r10.optJSONObject("fetch_setting");
        if (r11 == null) goto L11;
        this.f8567g = r11.optLong("fetch_setting_interval", 1200);
    L11:
        if (this.f8567g >= 600) goto L13;
        this.f8567g = 600;
    L13:
        JSONObject r12 = r8.optJSONObject("custom_event_settings");
        if (r12 == null) goto L16;
        this.f8563c = r12.optJSONObject("allow_log_type");
        this.f8564d = r12.optJSONObject("allow_metric_type");
        this.f8565e = r12.optJSONObject("allow_service_name");
    L16:
        this.f8568h = r8;
        if (TextUtils.isEmpty("exception_modules") == true) goto L22;
        JSONObject r13 = this.f8568h;
        if (r13 == null) goto L22;
        JSONObject r14 = r13.optJSONObject("exception_modules");
    L23:
        boolean r15 = false;
        if (r14 == null) goto L33;
        JSONObject r16 = r14.optJSONObject("exception");
        if (r16 == null) goto L33;
        if (r16.optInt("enable_upload") != 1) goto L30;
        boolean r17 = true;
    L31:
        this.f8562b = r17;
        goto L33
    L30:
        r17 = false;
    L33:
        if (this.f8565e != null) goto L35;
    L40:
        if (r15 == false) goto L43;
        e.f125e = new a(this);
        e.f126f = true;
        return;
    L43:
        return;
    L35:
        if (TextUtils.isEmpty("apm_cost") == true) goto L40;
        if (this.f8565e.optInt("apm_cost") != 1) goto L40;
        r15 = true;
    L22:
        r14 = new JSONObject();
        goto L23
    }

    public final boolean f() {
        monitor-enter(this);
        boolean r8 = k.f3297a;     // Catch: Throwable -> L7
        l2.c.a();     // Catch: Throwable -> L7
        throw null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
