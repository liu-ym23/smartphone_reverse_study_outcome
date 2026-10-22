package d5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import x4.i0;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f6802r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x4.s f6806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f6808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.s f6809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f6810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f6811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j5.m f6812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f6814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public z4.c f6815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k5.b f6816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e5.a f6817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final l6.a f6818p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6819q;

    public static class a extends k5.l<i> {
        @Override // k5.l
        public final i a(Object[] r8) {
            Context r10 = (Context) r8[0];
            j0 r11 = (j0) r8[1];
            return new i(r10, (x4.s) r8[2], r11);
        }
    }

    static {
        new AtomicBoolean(true);
        f6802r = new a();
    }

    public l(Context r8, x4.s r10, j0 r11) {
        this.f6803a = new LinkedHashMap(32);
        this.f6804b = new Object();
        this.f6805c = false;
        this.f6810h = false;
        this.f6814l = new AtomicBoolean(false);
        this.f6816n = null;
        this.f6819q = 0;
        this.f6807e = r8;
        this.f6806d = r10;
        this.f6808f = r11;
        this.f6811i = new JSONObject();
        this.f6809g = new androidx.lifecycle.s(r11);
        this.f6812j = a(r8, r10);
        this.f6816n = x4.j.c(String.valueOf(r11.f13463a)).f13459i;
        String r12 = r11.a();
        x4.t.e(new m((q) this), r12);
        this.f6818p = new l6.a();
    }

    public final j5.m a(Context r8, x4.s r10) {
        j0 r11 = this.f6808f;
        i5.c r12 = (i5.c) i5.d.a(i5.c.class, String.valueOf(r11.f13463a));
        j5.n r13 = new j5.n(r8, r10.a(r11), r11);
        if (r12 != null) goto L5;
        return r13;
    L5:
        return (j5.m) r12.c();
    }

    public final boolean b(Context r13, x4.s r14) {
        j0 r8 = this.f6808f;
        e5.a r10 = new e5.a(r13, r8);
        this.f6817o = r10;
        int r11 = x4.r.f13543a;
        boolean r12 = r10.f7122c;
        if (r12 == false) goto L14;
        e5.a.a(r13, r8, c(), true);
        k5.a.a(r13, r8).edit().remove("google_aid").remove("gaid_limited").apply();
        x0.i(r8.b(), new String[]{"device_id", "bd_did", "install_id", "device_token"});
        if (r14 == null) goto L22;
        SharedPreferences r15 = r14.a(r8);
        if (r15 == null) goto L22;
        x0.i(r15, new String[]{"device_id", "bd_did", "install_id", "device_token"});
    L22:
        x0.i(r13.getSharedPreferences("snssdk_openudid", 0), new String[]{"clientudid", "openudid", "serial_number"});     // Catch: Exception -> L11
    L13:
        x0.i(k5.a.a(r13, r8), new String[]{"clientudid", "openudid", "serial_number"});
        x4.m.a(r13, r8);
        SharedPreferences r16 = g5.k.c(r13).f7656b.f7676a;
        x0.i(r16, new String[]{"oaid"});
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        e5.a r17 = this.f6817o;
        r17.getClass();
        int r18 = x4.r.f13543a;
        r17.f7120a.setComponentEnabledSetting(r17.f7121b, 2, 1);     // Catch: Exception -> L17
        r17.f7123d.edit().putInt("component_state", 2).apply();     // Catch: Exception -> L17
    L19:
        return r12;
    L17:
        e = move-exception;
        e.printStackTrace();
        int r19 = x4.r.f13543a;
        goto L19
    }

    public final String c() {
        i5.a r8 = (i5.a) i5.d.a(i5.a.class, this.f6808f.a());
        if (r8 == null) goto L7;
        return r8.getDeviceId();
    L7:
        return this.f6812j.a("", "");
    }

    public final i0 d() {
        Object r8 = this.f6804b;
        monitor-enter(r8);
    L21:
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f6810h == true) goto L9;
        this.f6804b.wait();     // Catch: InterruptedException -> L8 Throwable -> L18
    L8:
        int r10 = x4.r.f13543a;     // Catch: Throwable -> L18
        goto L21
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L18
        String r11 = c();
        String r12 = this.f6812j.c("install_id");
        String r13 = k5.a.a(this.f6807e, this.f6808f).getString("openudid", null);
        String r14 = k5.a.a(this.f6807e, this.f6808f).getString("clientudid", null);
        String r15 = this.f6812j.c("ssid");
        String r16 = k5.a.a(this.f6807e, this.f6808f).getString("klink_egdi", null);
        i0 r17 = new i0();
        if (TextUtils.isEmpty(r11) == false) goto L13;
        r11 = "";
    L13:
        r17.f13443a = r11;
        if (TextUtils.isEmpty(r12) == false) goto L16;
        r12 = "";
    L16:
        r17.f13444b = r12;
        r17.f13446n = r14;
        r17.f13445m = r13;
        r17.f13447o = r15;
        r17.f13448p = r16;
        return r17;
    }

    public final int e() {
        String r8 = this.f6811i.optString("device_id", "");
        String r10 = this.f6811i.optString("install_id", "");
        String r11 = this.f6811i.optString("bd_did", "");
        if (x0.b(r8) == true) goto L7;
        if (x0.b(r11) == true) goto L7;
        return 0;
    L7:
        if (x0.b(r10) == true) goto L9;
        return 0;
    L9:
        if (k5.a.a(this.f6807e, this.f6808f).getLong("dr_install_vc", 0) != this.f6811i.optLong("version_code", -1)) goto L11;
        return 1;
    L11:
        return 2;
    }

    public final boolean f() {
        LinkedHashMap r8 = this.f6803a;
        monitor-enter(r8);
    L65:
        th = move-exception;
        throw th;
    L5:
        if (this.f6805c == true) goto L7;
        this.f6805c = true;     // Catch: Throwable -> L65
        this.f6803a.put(g.class, new g(this.f6808f));     // Catch: Throwable -> L65
        this.f6803a.put(u.class, new u(this.f6807e, this.f6808f));     // Catch: Throwable -> L65
        this.f6803a.put(w.class, new w(this.f6808f, this.f6806d));     // Catch: Throwable -> L65
        this.f6803a.put(x.class, new x(this.f6807e));     // Catch: Throwable -> L65
        this.f6803a.put(f.class, new f(this.f6808f));     // Catch: Throwable -> L65
        this.f6803a.put(c.class, new c(this.f6807e, this.f6808f));     // Catch: Throwable -> L65
        this.f6803a.put(b.class, new b(this.f6807e));     // Catch: Throwable -> L65
        this.f6803a.put(h.class, new h(this.f6808f));     // Catch: Throwable -> L65
        this.f6803a.put(z.class, new z(this.f6807e, this.f6808f));     // Catch: Throwable -> L65
        this.f6803a.put(k.class, new k(this.f6808f));     // Catch: Throwable -> L65
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L65
        monitor-enter(l.class);
        JSONObject r10 = this.f6811i;     // Catch: Throwable -> L62
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L62
        x0.d(r11, r10);     // Catch: Throwable -> L62
        a r12 = f6802r;     // Catch: Throwable -> L62
        if (r12.b(new Object[]{this.f6807e, this.f6808f, this.f6806d}).a() == false) goto L13;
        x0.d(r11, r12.b(new Object[]{this.f6807e, this.f6808f, this.f6806d}).f6795c);     // Catch: Throwable -> L62
        boolean r13 = false;
    L14:
        Iterator r14 = this.f6803a.values().iterator();     // Catch: Throwable -> L62
        boolean r15 = true;
        int r16 = 0;
        int r17 = 0;
    L16:
        if (r14.hasNext() == false) goto L53;
        d r18 = (d) r14.next();     // Catch: Throwable -> L62
        if (r18.f6786a == true) goto L20;
    L72:
        r18.b(r11);     // Catch: SecurityException -> L31 JSONException -> L37 Throwable -> L62
        r18.f6786a = r18.a(r11);     // Catch: SecurityException -> L31 JSONException -> L37 Throwable -> L62
    L39:
        if (r18.f6786a == false) goto L41;
    L45:
        if (r18.f6786a == false) goto L47;
    L51:
        boolean r19 = true;
    L52:
        r15 = r15 & r19;     // Catch: Throwable -> L62
        goto L16
    L47:
        if (r18.f6787b == true) goto L51;
        if (r13 == false) goto L51;
        r19 = false;
        goto L52
    L41:
        if (r18.f6787b == true) goto L45;
        if (r13 == false) goto L45;
        r17 = r17 + 1;     // Catch: Throwable -> L62
    L37:
        int r110 = x4.r.f13543a;     // Catch: Throwable -> L62
    L32:
        if (r18.f6787b == true) goto L39;
        r16 = r16 + 1;     // Catch: Throwable -> L62
        int r111 = this.f6819q;     // Catch: Throwable -> L62
        int r112 = x4.r.f13543a;     // Catch: Throwable -> L62
        if (r18.f6786a == true) goto L39;
        if (r111 <= 10) goto L39;
        r18.f6786a = true;     // Catch: Throwable -> L62
        goto L39
    L20:
        if (r18.f6788c == true) goto L72;
        if (x0.f(this.f6808f.f13465c) == false) goto L24;
    L26:
        boolean r113 = false;
    L27:
        int r114 = x4.r.f13543a;     // Catch: Throwable -> L62
        if (r113 == false) goto L45;
    L24:
        if (r18.f6789d == false) goto L26;
        r113 = true;
        goto L27
    L53:
        this.f6811i = r11;     // Catch: Throwable -> L62
        this.f6813k = r15;     // Catch: Throwable -> L62
        int r20 = x4.r.f13543a;     // Catch: Throwable -> L62
        int r21 = this.f6819q;     // Catch: Throwable -> L62
        if (r16 <= 0) goto L59;
        if (r16 != r17) goto L59;
        this.f6819q = r21 + 1;     // Catch: Throwable -> L62
        if (e() == 0) goto L59;
        this.f6819q += 10;     // Catch: Throwable -> L62
    L59:
        monitor-exit(l.class);     // Catch: Throwable -> L62
        return this.f6813k;
    L13:
        r13 = true;
    L62:
        th = move-exception;
        throw th;
    }

    public void g() {
        Context r8 = this.f6807e;
    L17:
        th = move-exception;
        monitor-enter(this.f6804b);
        this.f6810h = true;     // Catch: Throwable -> L23
        this.f6804b.notifyAll();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f6808f.f13482t == true) goto L6;
        int r10 = x4.r.f13543a;     // Catch: Throwable -> L17
        boolean r11 = false;
    L7:
        if (r11 == true) goto L9;
        t.a(r8, this.f6806d, this.f6808f);     // Catch: Throwable -> L17
    L9:
        Object r12 = this.f6804b;
        monitor-enter(r12);
        this.f6810h = true;     // Catch: Throwable -> L14
        this.f6804b.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        r11 = b(r8, this.f6806d);     // Catch: Throwable -> L17
        goto L7
    }

    public final void h(i5.a r8, String r10, String r11) {
        String r12 = r8.b();
        JSONObject r13 = new JSONObject();
        r13.put("old_id", r11);
        r13.put("new_id", r10);
        if (this.f6806d.f13378a == true) goto L5;
        r13.put("openudid", r8.getOpenUdid());
    L5:
        r13.put("clientudid", r12);
        x4.z r14 = this.f6808f.B;
        if (r14 == null) goto L9;
        r14.a();
        return;
    }

    public final void i() {
        i0 r8 = d();
        if (TextUtils.isEmpty(r8.f13443a) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8.f13444b) == true) goto L13;
        z4.c r10 = this.f6815m;
        if (r10 == null) goto L12;
        r10.a(new a5.b(r8));
        return;
    L12:
        return;
    }

    public void j() {
        if (this.f6814l.getAndSet(true) == true) goto L6;
        x4.s r8 = this.f6806d;
        j0 r10 = this.f6808f;
        j5.j.a(this.f6807e, r8, r10);
        return;
    }

    public final boolean k(Object r8, String r10) {
        Object r11 = this.f6811i.opt(r10);
        if (r8 != null) goto L5;
    L6:
        if (r8 != null) goto L19;
        if (r11 == null) goto L19;
    L9:
        monitor-enter(l.class);
        JSONObject r12 = this.f6811i;     // Catch: Throwable -> L12 JSONException -> L14
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L12 JSONException -> L14
        x0.d(r13, r12);     // Catch: Throwable -> L12 JSONException -> L14
        r13.put(r10, r8);     // Catch: Throwable -> L12 JSONException -> L14
        this.f6811i = r13;     // Catch: Throwable -> L12 JSONException -> L14
    L15:
        monitor-exit(l.class);     // Catch: Throwable -> L12
        boolean r14 = true;
    L20:
        int r15 = x4.r.f13543a;
        return r14;
    L12:
        th = move-exception;
        throw th;
    L14:
        int r16 = x4.r.f13543a;     // Catch: Throwable -> L12
    L19:
        r14 = false;
        goto L20
    L5:
        if (r8.equals(r11) == false) goto L9;
        goto L6
    }
}
