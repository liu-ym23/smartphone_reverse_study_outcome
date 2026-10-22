package x4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class c extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j0 f13387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s f13388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f13389k;

    public c(j0 r8, s r10) {
        super(r8.f13465c, r8);
        this.f13386h = false;
        this.f13387i = r8;
        this.f13388j = r10;
        j r11 = this.f13436e;
        if (r11 == null) goto L6;
        this.f13389k = r11.f13458h;
        return;
    }

    @Override // x4.i
    public final void a() {
        k5.c r8 = k5.c.b();
        j0 r10 = this.f13387i;
        b5.a r11 = r8.a(r10.f13463a);
        SharedPreferences r12 = k5.a.a(r10.f13465c, r10);
        SharedPreferences.Editor r13 = r12.edit();
        if (r12.getBoolean("is_first_activate_for_app", false) == true) goto L6;
        if (r13 == null) goto L6;
        r13.putBoolean("is_first_activate_for_app", true);
        r13.apply();
        r11.f3056f = true;
    L6:
        k5.c.b().a(r10.f13463a).n(r10, "dr_active_result");
    }

    @Override // x4.i
    public final boolean b() {
        j0 r8 = this.f13387i;
        String r10 = this.f13388j.f13379b.f13530b;
        Context r11 = this.f13432a;
        f r12 = this.f13389k;
        if (r12 == null) goto L5;
        r10 = r12.a(r11, new StringBuilder(r10), o0.f13535a);
    L5:
        StringBuilder r13 = new StringBuilder(r10);
        float r14 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Throwable -> L23
        if (r14 >= (-12.0f)) goto L10;
        r14 = -12.0f;
    L10:
        if (r14 <= 12.0f) goto L12;
        r14 = 12.0f;
    L12:
        e.b(r13, "req_id", k5.i.f8941a.b(new Object[0]));     // Catch: Throwable -> L23
        r8.getClass();     // Catch: Throwable -> L23
        h5.b r15 = r8.H;
        e.b(r13, "timezone", r14 + "");     // Catch: Throwable -> L23
        String r16 = r8.f13467e;     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r16) == true) goto L53;
        e.b(r13, "package", r16);     // Catch: Throwable -> L23
        e.b(r13, "real_package_name", r11.getPackageName());     // Catch: Throwable -> L23
    L53:
        k5.k.a r17 = k5.k.f8943a;     // Catch: Exception -> L19 Throwable -> L23
        e.b(r13, "carrier", r15.f7907c.I.getNetworkOperatorName());     // Catch: Exception -> L19 Throwable -> L23
        e.b(r13, "mcc_mnc", r15.f7907c.I.getNetworkOperator());     // Catch: Exception -> L19 Throwable -> L23
        e.b(r13, "sim_region", r15.f7907c.I.getSimCountryIso());     // Catch: Exception -> L19 Throwable -> L23
    L21:
        t2.b.g(r11, r8, r13);     // Catch: Throwable -> L23
        e.b(r13, "app_version_minor", r8.f13476n.f13420b);     // Catch: Throwable -> L23
        e.b(r13, "custom_bt", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));     // Catch: Throwable -> L23
        String r18 = r13.toString();     // Catch: Throwable -> L23
    L25:
        if (TextUtils.isEmpty(r18) == false) goto L27;
        return false;
    L27:
        j r19 = this.f13436e;
        if (r19 != null) goto L55;
    L30:
        b5.a r20 = k5.c.b().a(r8.f13463a);     // Catch: Throwable -> L49
        if (r20.f3053c > 0) goto L34;
        r20.f3053c = System.currentTimeMillis();     // Catch: Throwable -> L49
    L34:
        b0 r21 = r8.f13464b;     // Catch: Throwable -> L49
        h.f13430b.f13456f.getClass();     // Catch: Throwable -> L49
        if (r8.f13477o == false) goto L37;
        boolean r22 = r8.f13486x;     // Catch: Throwable -> L49
    L38:
        boolean r23 = e.a(r21, r18, r22, r8.f13478p, this.f13386h);     // Catch: Throwable -> L49
        if (r20.f3054d > 0) goto L42;
        r20.f3054d = System.currentTimeMillis();     // Catch: Throwable -> L49
    L42:
        if (r23 == false) goto L44;
        this.f13386h = true;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        if (r19 == null) goto L52;
        r19.f13453c.f13532a.remove();
    L52:
        throw th;
    L44:
        if (r19 == null) goto L46;
        r19.f13453c.f13532a.remove();
    L46:
        if (r23 == false) goto L48;
        this.f13437f = true;
    L48:
        return r23;
    L37:
        r22 = true;
        goto L38
    L55:
        r19.f13453c.f13532a.set(Boolean.TRUE);     // Catch: Throwable -> L49
        goto L30
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
    L23:
        int r24 = r.f13543a;
        r18 = r13.toString();
        goto L25
    }

    @Override // x4.i
    public final String c() {
        return "ac";
    }

    @Override // x4.i
    public final long[] d() {
        return t0.f13557n;
    }

    @Override // x4.i
    public final void e() {
    }

    @Override // x4.i
    public final void f() {
    }

    @Override // x4.i
    public final long g() {
        return 0;
    }

    @Override // x4.i
    public final void h(boolean r8) {
        k5.c.b().a(this.f13387i.f13463a).f3059i = r8;
    }

    @Override // x4.i
    public final void i(int r8) {
        k5.c.b().a(this.f13433b.f13463a).f3055e = r8;
    }
}
