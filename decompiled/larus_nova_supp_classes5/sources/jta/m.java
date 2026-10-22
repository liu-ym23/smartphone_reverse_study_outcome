package jta;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.n;
import com.bytedance.bdinstall.o0;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.ss.android.common.applog.c0;
import com.ss.android.deviceregister.AActivity;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import ita.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kta.s;
import kta.u;
import lta.c;
import lta.d;
import lta.e;
import lta.f;
import lta.h;
import org.json.JSONObject;
import pta.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m implements l {
    public static final Object c = null;
    public static String d;
    public static volatile boolean e;
    public e a;
    public boolean b;

    @Override // jta.l
    public final void isLocalTest() {
    }

    @Override // jta.l
    public final void n(boolean r1) {
    }

    static {
        c = new Object();
        e = false;
    }

    @Override // jta.l
    public final void A() {
        u.g = "2.14.0";
    }

    @Override // jta.l
    public final void g() {
        e r0 = this.a;
        if (r0 == null) goto L12;
        h.a r1 = ((h) r0).l;
        if (r1 == null) goto L9;
        r1.n();
    L9:
        if (Logger.debug() == false) goto L13;
        j.b("OldImpl updateDeviceInfo call  device_register", null);
        return;
    L13:
        return;
    }

    @Override // jta.l
    public final int getAppId() {
        if (u.e > 0) goto L8;
        eta.b r0 = u.b;
        if (r0 == null) goto L8;
        r0.getAid();
    L8:
        return u.e;
    }

    @Override // jta.l
    public final String getDeviceId() {
        e r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L7:
        if (Logger.debug() == false) goto L9;
        j.b("OldImpl getDeviceId() called,return value : " + r1, null);
    L9:
        return r1;
    L5:
        r1 = "";
        goto L7
    }

    @Override // jta.l
    public final String getInstallId() {
        e r0 = this.a;
        if (r0 == null) goto L7;
        String r1 = ((h) r0).k;
        if (Logger.debug() == false) goto L9;
        j.b("OldImpl getInstallId() called,return value : " + r1, null);
        return r1;
    L9:
        return r1;
    L7:
        return "";
    }

    @Override // jta.l
    public final String getRequestId() {
        if (TextUtils.isEmpty(d) == false) goto L15;
        Object r0 = c;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(d) == false) goto L9;
        d = UUID.randomUUID().toString();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    @Override // jta.l
    public final String getVersionName() {
        if (TextUtils.isEmpty(u.c) == false) goto L8;
        eta.b r0 = u.b;
        if (r0 == null) goto L8;
        u.c = r0.getVersion();
    L8:
        return u.c;
    }

    @Override // jta.l
    public final void onPause() {
        Object r0 = h.r;
        h.x = System.currentTimeMillis();
    }

    @Override // jta.l
    public final void onResume() {
        Object r0 = h.r;
        h.x = System.currentTimeMillis();
    }

    public m() {
    }

    @Override // jta.l
    public final void e() {
        Object r0 = h.r;
    }

    @Override // jta.l
    public final void i() {
        String r0 = u.a;
    }

    @Override // jta.l
    public final boolean t() {
        return e;
    }

    @Override // jta.l
    public final void z() {
        String r0 = u.a;
    }

    @Override // jta.l
    public final void a(Context r8) {
        e r0 = this.a;
        r0.getClass();
        ((h) r0).h = new JSONObject();
        long r1 = System.currentTimeMillis();
        SharedPreferences r3 = ((h) r0).f.getSharedPreferences(kta.b.a, 0);
        ((h) r0).c = r3.getInt("last_config_version", 0);
        ((h) r0).k = r3.getString("install_id", "");
        boolean r4 = TextUtils.equals(u.c(((h) r0).f), r3.getString("dr_channel", null));
        if (((h) r0).c != u.e()) goto L14;
        if (r4 == false) goto L14;
        long r5 = r3.getLong("last_config_time", 0);
        if (r5 > r1) goto L9;
        r1 = r5;
    L9:
        boolean r6 = c0.f(r0.c());
        boolean r7 = c0.f(((h) r0).k);
        if (r6 == true) goto L14;
        if (r7 == true) goto L14;
        ((h) r0).i = r1;
    L14:
        if (u.d(((h) r0).f, ((h) r0).h, ((h) r0).b) == false) goto L16;
    L20:
        h.a r2 = new h.a(r0);
        ((h) r0).l = r2;
        ThreadMethodProxy.start(r2);
        c.a = true;
        ThreadPlus.submitRunnable(new d(r8));
        return;
    L16:
        if (Logger.debug() == false) goto L20;
        throw new RuntimeException("init header error.");
    }

    @Override // jta.l
    public final void b(eta.b r1) {
        u.b = r1;
    }

    @Override // jta.l
    public final void c(boolean r1) {
        e = r1;
    }

    @Override // jta.l
    public final String getChannel(Context r1) {
        return u.c(r1);
    }

    @Override // jta.l
    public final void h(com.ss.android.common.applog.b r1) {
        h.s = r1;
        u.o = r1;
    }

    @Override // jta.l
    public final boolean k(boolean r7) {
        e = r7;
        e r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        d = null;
        ((h) r0).k = null;
        ((h) r0).b = r7;
        ((h) r0).e.a(EffectConfiguration.KEY_DEVICE_ID);
        ((h) r0).e.a("install_id");
        ((h) r0).e.a("clientudid");
        ((h) r0).f.getSharedPreferences(kta.b.a, 0).edit().remove("install_id").apply();
        Context r3 = ((h) r0).f;
        a.a r4 = a.a;
        o0 r5 = i.b.a;
        if (r5 == null) goto L8;
        n.a(r3, r5);
    L9:
        JSONObject r1 = new JSONObject();
        u.i = null;
        u.d(((h) r0).f, r1, r7);
        ((h) r0).h = r1;
        return true;
    L8:
        r3.getSharedPreferences(i84.h.c(), 0).edit().putString("cdid", null).apply();
        a.a = new a.a();
        goto L9
    }

    @Override // jta.l
    public final void l(Context r8) {
        if (this.a == null) goto L5;
        mta.a r0 = h.a(r8);
    L7:
        if ((r0 instanceof e) == false) goto L26;
        e r1 = (e) r0;
        r1.getClass();
        if (TextUtils.isEmpty("clearMigrationInfo") == true) goto L26;
        a.g = null;
        SharedPreferences r3 = r8.getSharedPreferences(kta.b.a, 0);
        if (r3.getBoolean("clear_key_prefixclearMigrationInfo", false) == true) goto L23;
        SharedPreferences.Editor r5 = r3.edit();
        r5.putBoolean("clear_key_prefixclearMigrationInfo", true);
        if (r3.contains(EffectConfiguration.KEY_DEVICE_ID) == false) goto L17;
        r5.remove(EffectConfiguration.KEY_DEVICE_ID);
    L17:
        if (r3.contains("install_id") == false) goto L19;
        r5.remove("install_id");
    L19:
        r5.commit();
        ((a) r1).b.b(EffectConfiguration.KEY_DEVICE_ID);
        if (Logger.debug() == false) goto L25;
        j.g("DeviceParamsProvider clearKey : clearMigrationInfo :clear installId and deviceId finish", null);
    L25:
        ((a) r1).b.d("", "");
        goto L26
    L23:
        if (Logger.debug() == false) goto L25;
        j.g("DeviceParamsProvider clearKey : clearMigrationInfo : is already cleared", null);
    L26:
        r8.getSharedPreferences(kta.b.a, 0).edit().remove("device_token").commit();
        return;
    L5:
        g.j.isLocalTest();
        r0 = new e(r8, false);
        goto L7
    }

    @Override // jta.l
    public final void o(boolean r2) {
        u.p = r2;
        if (u.i == null) goto L12;
        Object r3 = u.m;
        monitor-enter(r3);
        u.b(u.i);     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // jta.l
    public final void p(g.a r3) {
        if (r3 != null) goto L4;
        Object r4 = h.r;
        return;
    L4:
        h.z.add(new WeakReference(r3));
    }

    @Override // jta.l
    public final void q(boolean r1) {
        this.b = r1;
    }

    @Override // jta.l
    public final boolean r(Context r1) {
        return h.b(r1);
    }

    @Override // jta.l
    public final void s(Bundle r2) {
        if (r2.size() > 0) goto L5;
        return;
    L5:
        Object r0 = h.r;
        if (r2.size() <= 0) goto L18;
        Bundle r1 = h.t;
        monitor-enter(r1);
        r1.putAll(r2);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // jta.l
    public final void setAnonymous(boolean r1) {
        kta.b.c = r1;
    }

    @Override // jta.l
    public final void setChannel(String r1) {
        u.a = r1;
    }

    @Override // jta.l
    public final void u(int r1) {
        u.e = r1;
    }

    @Override // jta.l
    public final void v(Context r3) {
        h.g(r3, -1);
    }

    @Override // jta.l
    public final void w(String r1) {
        u.f = r1;
    }

    @Override // jta.l
    public final void d(Context r10, boolean r11) {
        if (u.s == false) goto L13;
        Context r0 = r10.getApplicationContext();
        SharedPreferences r1 = r0.getSharedPreferences("device_register_migrate_detector", 0);
        PackageManager r2 = r0.getPackageManager();
        ComponentName r3 = new ComponentName(r10, AActivity.class);
        int r4 = r2.getComponentEnabledSetting(r3);
        int r6 = r1.getInt("component_state", 0);
        if (r4 != 0) goto L8;
        if (r6 != 2) goto L8;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        r10.getSharedPreferences(kta.b.a, 0).edit().remove("google_aid").remove("gaid_limited").apply();
        a r7 = h.a(r10);
        u.q = r7.c();
        r7.a("openudid");
        r7.a("clientudid");
        r7.a("serial_number");
        r7.a("sim_serial_number");
        r7.a("udid");
        r7.a("udid_list");
        r7.a(EffectConfiguration.KEY_DEVICE_ID);
        g.j.l(r10);
    L12:
        r2.setComponentEnabledSetting(r3, 2, 1);
        r1.edit().putInt("component_state", 2).apply();
    L8:
        r5 = false;
    L13:
        s.b(r10).a();
        e r8 = new e(r10, r11);
        this.a = r8;
        lta.a.b = this.b;
        u.n = r8;
    }

    @Override // jta.l
    public final void j(Context r3, String r4) {
        String r0 = u.a;
        if (StringUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (r4.equals(u.k) == true) goto L9;
        u.k = r4;
        SharedPreferences.Editor r5 = r3.getSharedPreferences(kta.b.a, 0).edit();
        r5.putString("user_agent", r4);
        r5.commit();
        return;
    }

    @Override // jta.l
    public final void x(Map<String, String> r11, Context r12) {
        e r0 = this.a;
        if (r0 != null) goto L23;
        if (r0 != null) goto L51;
        if (r12 == null) goto L52;
        SharedPreferences r1 = r12.getSharedPreferences(kta.b.a, 0);
        String r8 = r1.getString(EffectConfiguration.KEY_DEVICE_ID, "");
        if (TextUtils.isEmpty(r8) == true) goto L9;
        ((HashMap) r11).put(EffectConfiguration.KEY_DEVICE_ID, r8);
    L9:
        String r2 = r1.getString("install_id", "");
        if (TextUtils.isEmpty(r2) == true) goto L12;
        ((HashMap) r11).put("install_id", r2);
    L12:
        String r3 = r12.getSharedPreferences(kta.b.a(), 0).getString("openudid", null);
        if (TextUtils.isEmpty(r3) == true) goto L15;
        ((HashMap) r11).put("openudid", r3);
    L15:
        e r4 = this.a;
        if (r4 != null) goto L18;
        String r13 = r12.getSharedPreferences(kta.b.a, 0).getString("klink_egdi", "");
    L20:
        if (TextUtils.isEmpty(r13) == true) goto L53;
        ((HashMap) r11).put("klink_egdi", r13);
        return;
    L53:
        return;
    L18:
        r13 = r4.d();
        goto L20
    L52:
        return;
    L51:
        return;
    L23:
        String r5 = r0.e();
        if (Logger.debug() == false) goto L26;
        j.b("OldImpl getOpenUdId() called,return value : " + r5, null);
    L26:
        if (r5 == null) goto L28;
        ((HashMap) r11).put("openudid", r5);
    L28:
        e r6 = this.a;
        if (r6 == null) goto L31;
        String r7 = ((h) r6).e.b();
    L33:
        if (Logger.debug() == false) goto L35;
        j.b("OldImpl getClientUDID() called,return value : " + r7, null);
    L35:
        if (r7 == null) goto L37;
        ((HashMap) r11).put("clientudid", r7);
    L37:
        String r9 = getInstallId();
        if (r9 == null) goto L40;
        ((HashMap) r11).put("install_id", r9);
    L40:
        String r10 = getDeviceId();
        if (r10 == null) goto L43;
        ((HashMap) r11).put(EffectConfiguration.KEY_DEVICE_ID, r10);
    L43:
        e r14 = this.a;
        if (r14 != null) goto L46;
        String r15 = r12.getSharedPreferences(kta.b.a, 0).getString("klink_egdi", "");
    L48:
        if (TextUtils.isEmpty(r15) == true) goto L54;
        ((HashMap) r11).put("klink_egdi", r15);
        return;
    L54:
        return;
    L46:
        r15 = r14.d();
        goto L48
    L31:
        r7 = "";
        goto L33
    }

    @Override // jta.l
    public final void y(String[] r3, String[] r4) {
        if (r3 != null) goto L5;
    L9:
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.length <= 0) goto L15;
        StringUtils.isEmpty(r4[0]);
        return;
    L15:
        return;
    L5:
        if (r3.length <= 0) goto L9;
        if (StringUtils.isEmpty(r3[0]) == true) goto L9;
        lta.a.a = r3;
        goto L9
    }

    @Override // jta.l
    public final boolean f(Context r1, JSONObject r2, boolean r3) {
        return u.d(r1, r2, r3);
    }

    @Override // jta.l
    public final void m(boolean r4, long r5, n r7) {
        e = r4;
        e r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        monitor-enter(r0);
        ((h) r0).b = r4;     // Catch: Throwable -> L13
        ((h) r0).i = 0;     // Catch: Throwable -> L13
        h.a r6 = ((h) r0).l;     // Catch: Throwable -> L13
        if (r6 == null) goto L9;
        r6.v = 0;     // Catch: Throwable -> L13
    L9:
        u.i = null;     // Catch: Throwable -> L13
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L13
        u.d(((h) r0).f, r8, ((h) r0).b);     // Catch: Throwable -> L13
        ((h) r0).h = r8;     // Catch: Throwable -> L13
        ((h) r0).m = r7;     // Catch: Throwable -> L13
        r0.f();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        new Handler(Looper.getMainLooper()).postDelayed(new f(r0), r5);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
