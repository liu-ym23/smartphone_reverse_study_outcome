package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import i84.o;
import i84.q;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import z74.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c extends BaseWorker {
    public boolean h;
    public final o0 i;
    public final u j;
    public final f k;
    public final SharedPreferences l;

    public final String c() {
        return "ac";
    }

    public final void e() {
    }

    public final void f() {
    }

    public final long g() {
        return 0;
    }

    public final boolean b() {
        String r3 = ((b) this.j).b.b;
        f r4 = this.k;
        if (r4 == null) goto L5;
        r3 = r4.a(((BaseWorker) this).a, new StringBuilder(r3), true, Level.L0);
    L5:
        StringBuilder r5 = new StringBuilder(r3);
        float r6 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Throwable -> L21
        if (r6 >= (-12.0f)) goto L10;
        r6 = -12.0f;
    L10:
        if (r6 <= 12.0f) goto L12;
        r6 = 12.0f;
    L12:
        d.b(r5, "req_id", (String) o.a.b(new Object[0]));     // Catch: Throwable -> L21
        this.i.getClass();     // Catch: Throwable -> L21
        d.b(r5, "timezone", r6 + "");     // Catch: Throwable -> L21
        String r7 = this.i.e;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r7) == true) goto L96;
        d.b(r5, "package", r7);     // Catch: Throwable -> L21
        d.b(r5, "real_package_name", ((BaseWorker) this).a.getPackageName());     // Catch: Throwable -> L21
    L96:
        o0 r8 = this.i;     // Catch: Exception -> L17 Throwable -> L21
        q.a r9 = q.a;     // Catch: Exception -> L17 Throwable -> L21
        d.b(r5, "carrier", r8.M.n());     // Catch: Exception -> L17 Throwable -> L21
        d.b(r5, "mcc_mnc", this.i.M.m());     // Catch: Exception -> L17 Throwable -> L21
        d.b(r5, "sim_region", this.i.M.q());     // Catch: Exception -> L17 Throwable -> L21
    L19:
        e.a(((BaseWorker) this).a, this.i, r5);     // Catch: Throwable -> L21
        d.b(r5, "app_version_minor", this.i.q.b);     // Catch: Throwable -> L21
        d.b(r5, "custom_bt", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));     // Catch: Throwable -> L21
        this.i.getClass();     // Catch: Throwable -> L21
        String r10 = r5.toString();     // Catch: Throwable -> L21
    L24:
        if (TextUtils.isEmpty(r10) == false) goto L91;
        return false;
    L91:
        k r11 = ((BaseWorker) this).e;     // Catch: Throwable -> L83
        if (r11 == null) goto L29;
        r11.d.a(true);     // Catch: Throwable -> L83
    L29:
        a r12 = i84.d.b().a(this.i.a);     // Catch: Throwable -> L83
        if (r12.a > 0) goto L33;
        r12.a = System.currentTimeMillis();     // Catch: Throwable -> L83
    L33:
        g0 r13 = this.i.b;     // Catch: Throwable -> L83
        i.b.g.getClass();     // Catch: Throwable -> L83
        o0 r14 = this.i;     // Catch: Throwable -> L83
        if (r14.r == false) goto L36;
        boolean r15 = r14.A;     // Catch: Throwable -> L83
    L37:
        d84.a r16 = d.a(r13, r10, r15, r14.s, this.h);     // Catch: Throwable -> L83
        if (r16 == null) goto L63;
        int r17 = r16.b;     // Catch: Throwable -> L83
        if (r17 != (-555)) goto L43;
    L58:
        t.b("doActive# hit net fallback and stop,code=" + r17);     // Catch: Throwable -> L83
        ((BaseWorker) this).f = true;     // Catch: Throwable -> L83
        k r0 = ((BaseWorker) this).e;
        if (r0 == null) goto L62;
        r0.d.a(false);
    L62:
        return true;
    L43:
        if (r17 == 429) goto L58;
        JSONObject r2 = new JSONObject(r16.d);     // Catch: JSONException -> L55 Throwable -> L83
        JSONObject r18 = r2.optJSONObject("data");     // Catch: JSONException -> L55 Throwable -> L83
        if (r18 == null) goto L50;
        if (r18.optInt("is_activated", -1) != 1) goto L50;
        boolean r19 = true;
    L94:
        t.a("active response body " + r2);     // Catch: JSONException -> L53 Throwable -> L83
    L65:
        if (r12.b > 0) goto L68;
        r12.b = System.currentTimeMillis();     // Catch: Throwable -> L83
    L68:
        if (r19 == false) goto L77;
        k r1 = ((BaseWorker) this).e;     // Catch: Throwable -> L83
        if (r1 != null) goto L92;
    L76:
        this.h = true;     // Catch: Throwable -> L83
        goto L77
    L92:
        String r20 = r1.j().b;     // Catch: Exception -> L88 Throwable -> L83
        if (this.l.contains(r20) == true) goto L76;
        if (TextUtils.isEmpty(r20) == true) goto L76;
        this.l.edit().putBoolean(r20, true).apply();     // Catch: Exception -> L88 Throwable -> L83
    L77:
        k r21 = ((BaseWorker) this).e;
        if (r21 == null) goto L80;
        r21.d.a(false);
    L80:
        if (r19 == false) goto L82;
        ((BaseWorker) this).f = true;
    L82:
        return r19;
    L53:
        e = e;
    L57:
        t.c("active parse json error " + r16 + ", ", e);     // Catch: Throwable -> L83
    L50:
        r19 = false;
    L55:
        e = e;
        r19 = false;
        goto L57
    L63:
        r19 = false;
        goto L65
    L36:
        r15 = true;
    L83:
        th = move-exception;
        k r22 = ((BaseWorker) this).e;
        if (r22 == null) goto L87;
        r22.d.a(false);
    L87:
        throw th;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        t.e(th);
        r10 = r5.toString();
        goto L24
    }

    public final void a() {
        a r0 = i84.d.b().a(this.i.a);
        SharedPreferences r1 = i84.a.a(this.i.getContext(), this.i);
        SharedPreferences.Editor r2 = r1.edit();
        if (r1.getBoolean("is_first_activate_for_app", false) == true) goto L6;
        if (r2 == null) goto L6;
        r2.putBoolean("is_first_activate_for_app", true);
        r2.apply();
        r0.d = true;
    L6:
        o0 r3 = this.i;
        i84.d.b().a(r3.a).b(r3, "dr_active_result");
    }

    public final long[] d() {
        return y0.n;
    }

    public final void h(boolean r3) {
        i84.d.b().a(this.i.a).setResult(r3);
    }

    public final void i(int r4) {
        i84.d.b().a(((BaseWorker) this).b.a).c = r4;
    }

    public c(o0 r4, u r5) {
        Context r0 = r4.getContext();
        super(r0, r4);
        this.h = false;
        this.i = r4;
        this.j = r5;
        k r6 = ((BaseWorker) this).e;
        if (r6 == null) goto L5;
        this.k = r6.i;
    L5:
        SharedPreferences r7 = i84.a.a(r0, r4);
        this.l = r7;
        String r1 = ((BaseWorker) this).e.j().b;     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return;
    L10:
        if (r7.contains(r1) == false) goto L17;
        this.h = r7.getBoolean(r1, false);     // Catch: Exception -> L13
        t.a("active# is_activated:" + this.h);     // Catch: Exception -> L13
        return;
    L17:
        return;
    }
}
