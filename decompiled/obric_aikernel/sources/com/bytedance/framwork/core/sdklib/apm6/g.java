package com.bytedance.framwork.core.sdklib.apm6;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<Long, Long> f1934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static i f1935c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1936a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f1937a = null;

        static {
            f1937a = new g();
        }

        static /* synthetic */ g a() {
            return f1937a;
        }
    }

    static {
        f1934b = new ConcurrentHashMap();
    }

    public g() {
        this.f1936a = false;
    }

    private synchronized void a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f1936a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f1936a = true;     // Catch: Throwable -> L14
        if (j.f() == false) goto L11;
        j3.c.a("APM-SDK", "Initializing SlardarHandler...");     // Catch: Throwable -> L14
    L11:
        f1935c = new i(com.bytedance.framwork.core.sdklib.apm6.a.f(), com.bytedance.framwork.core.sdklib.apm6.a.a());     // Catch: Throwable -> L14
        d.c().j(f1935c);     // Catch: Throwable -> L14
        d.c().d();     // Catch: Throwable -> L14
        e.d().e();     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public static g b() {
        return a.a();
    }

    public void c(long r10, JSONObject r11) {
    L22:
        th = move-exception;
        j3.c.c("APM-SDK", "record", th);
        return;
    L4:
        if (com.bytedance.framwork.core.sdklib.apm6.downgrade.a.a().d(r11, (int) r10) == true) goto L10;
        if (j.f() == false) goto L29;
        j3.c.a("APM-SDK", "push failed: event(aid=" + r10 + " is downgraded: " + r11.toString());     // Catch: Throwable -> L22
        return;
    L29:
        return;
    L10:
        if (f1934b.containsKey(Long.valueOf(r10)) == true) goto L12;
        f1934b.put(Long.valueOf(r10), Long.valueOf(h3.a.e().f(r10, j.e(r10))));     // Catch: Throwable -> L22
    L12:
        a();     // Catch: Throwable -> L22
        if (r11.getJSONObject("_debug_self") != null) goto L16;
        r11.put("_debug_self", new JSONObject());     // Catch: Exception -> L25 Throwable -> L22
    L16:
        new JSONObject().put("sdk_report_from", "apm6");     // Catch: Exception -> L25 Throwable -> L22
    L18:
        if (j.f() == false) goto L20;
        j3.c.a("APM-SDK", "record:" + r10 + " " + r11);     // Catch: Throwable -> L22
    L20:
        f1935c.j(r10, f1934b.get(Long.valueOf(r10)).longValue(), r11);     // Catch: Throwable -> L22
    }
}
