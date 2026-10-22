package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Locale;
import okhttp3.w;

/* JADX INFO: loaded from: classes.dex */
public class n extends o2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile n f1785c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f1786d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile int f1787e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile String f1788f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile Proxy f1789g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f1790h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f1791i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile String f1792j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f1793k = "tt-ok/3.10.0.2";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile u2.a f1794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Context f1795m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static d f1796n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static b f1797o;

    class a implements v2.b {
        a(n r10) {
        }

        @Override // v2.b
        public String a() {
            if (n.g() != null) goto L5;
            return null;
        L5:
            return n.g().a();
        }

        @Override // v2.b
        public String[] b() {
            if (n.g() != null) goto L5;
            return null;
        L5:
            return n.g().b();
        }

        @Override // v2.b
        public String[] c() {
            if (n.g() != null) goto L5;
            return null;
        L5:
            return n.g().c();
        }

        @Override // v2.b
        public String getAppId() {
            if (n.g() != null) goto L5;
            return null;
        L5:
            return String.valueOf(n.g().getAid());
        }

        @Override // v2.b
        public Context getContext() {
            return n.f();
        }
    }

    static {
        f1790h = new Object();
    }

    private n(Context r10) {
        String r11 = null;
        r11 = hc.f.a();     // Catch: Throwable -> L5
    L10:
        if (TextUtils.isEmpty(r11) == false) goto L12;
    L16:
        f1795m = r10.getApplicationContext();
        f1796n = new d();
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().n(f1795m);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().B(new a(this));
        return;
    L12:
        if (r11.startsWith("okhttp/") == false) goto L14;
        String r12 = r11.replaceFirst("okhttp/", "tt-ok/");
    L15:
        f1793k = r12;
        goto L16
    L14:
        r12 = "tt-ok/" + r11;
    L5:
        byte[] r13 = hc.e.f9277a;     // Catch: Throwable -> L7
        Field r14 = hc.e.class.getDeclaredField("userAgent");     // Catch: Throwable -> L7
        r14.setAccessible(true);     // Catch: Throwable -> L7
        r11 = (String) r14.get(null);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    static /* synthetic */ Context f() {
        return f1795m;
    }

    static /* synthetic */ u2.a g() {
        return f1794l;
    }

    public static w h() {
        return f1796n.a(false);
    }

    public static Context i() {
        return f1795m;
    }

    public static String j() {
        if (TextUtils.isEmpty(f1792j) == false) goto L12;
        StringBuilder r10 = new StringBuilder();
        r10.append(f1795m.getPackageName());
        r10.append('/');
        r10.append(y(f1795m));
        r10.append(" (Linux; U; Android ");
        r10.append(Build.VERSION.RELEASE);
        r10.append("; ");
        r10.append(Locale.getDefault().toString());
        String r11 = Build.MODEL;
        if (r11.length() <= 0) goto L7;
        r10.append("; ");
        r10.append(r11);
    L7:
        String r12 = Build.ID;
        if (r12.length() <= 0) goto L10;
        r10.append("; Build/");
        r10.append(r12);
    L10:
        r10.append(";");
        r10.append(f1793k);
        r10.append(')');
        f1792j = r10.toString();
    L12:
        return f1792j;
    }

    public static String k() {
        return f1788f;
    }

    public static int l() {
        return f1787e;
    }

    public static String m(n4.c r10) {
        if (r10 != null) goto L4;
        return "null-metrics";
    L4:
        if (r10.z() != null) goto L7;
        return "null-metrics";
    L7:
        return "fallback_reason=" + f1787e + ",fallback-message=" + Base64.encodeToString(f1788f.getBytes(), 2) + ",request-fallback-reason=" + r10.z().f2439h + ",request-fallback-message=" + Base64.encodeToString(r10.z().f2441i.getBytes(), 2);
    }

    public static boolean n() {
        return f1786d;
    }

    public static b o() {
        return f1797o;
    }

    public static u2.a p() {
        return f1794l;
    }

    public static String q() {
        return f1793k;
    }

    public static Proxy r() {
        return f1789g;
    }

    public static void s(u2.a r10) {
        f1794l = r10;
    }

    public static n t(Context r10) {
        if (f1785c != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1785c != null) goto L9;
        f1785c = new n(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f1785c;
    }

    public static void u(String r10) {
        f1788f = r10;
    }

    public static void v(int r10) {
        f1787e = r10;
    }

    public static void x(String r10) {
        if (r10 != null) goto L5;
        f1789g = null;
        return;
    L5:
        String[] r11 = r10.split(";");
        if (r11.length <= 0) goto L31;
        String[] r12 = r11[0].trim().split("=");
        if (r12.length != 2) goto L29;
        String r13 = r12[0].trim().toLowerCase();
        String[] r14 = r12[1].trim().split(":");
        if (r14.length != 2) goto L27;
        InetSocketAddress r15 = new InetSocketAddress(r14[0], Integer.parseInt(r14[1]));
        if (r13.equals("http") == false) goto L14;
    L23:
        Proxy r16 = new Proxy(Proxy.Type.HTTP, r15);
    L24:
        f1789g = r16;
        return;
    L14:
        if (r13.equals("https") == true) goto L23;
        if (r13.equals("socks") == false) goto L19;
    L22:
        r16 = new Proxy(Proxy.Type.SOCKS, r15);
        goto L24
    L19:
        if (r13.equals("socks4") == true) goto L22;
        if (r13.equals("socks5") == true) goto L22;
        return;
    L27:
        throw new IllegalArgumentException("Invalid proxy rule:" + r10);
    L29:
        throw new IllegalArgumentException("Invalid proxy rule:" + r10);
    L31:
        throw new IllegalArgumentException("Invalid proxy rule:" + r10);
    }

    private static int y(Context r10) {
        Object r11 = f1790h;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f1791i == 0) goto L16;
    L9:
        int r12 = f1791i;     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L16:
        f1791i = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }

    @Override // n4.a
    public n4.e a(n4.c r10) {
        n4.c r11 = c3.b.m().c(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L5;
        r10 = r11;
    L5:
        long r12 = SystemClock.uptimeMillis();
        n4.c r13 = d3.d.f().e(r10);
        if (r10.z() == null) goto L8;
        RetrofitMetrics r14 = r10.z();
        r14.f2438g0 = SystemClock.uptimeMillis() - r12;
    L8:
        if (r13 == null) goto L11;
        r10 = r13;
    L11:
        return new com.bytedance.frameworks.baselib.network.http.ok3.impl.a(r10);
    }

    public void w(b r10) {
        f1797o = r10;
    }
}
