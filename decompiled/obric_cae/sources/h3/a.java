package h3;

import j3.d;
import k3.c;
import org.json.JSONArray;
import org.json.JSONObject;
import t2.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f7903a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p3.a<c> f7904b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7905c = false;

    /* JADX INFO: renamed from: h3.a$a, reason: collision with other inner class name */
    public static class C0083a implements p3.a.InterfaceC0133a<c> {
    }

    static {
        p3.a<c> r8 = new p3.a(1000);
        f7904b = r8;
        f7905c = true;
        r8.f9937c = new C0083a();
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f7903a == true) goto L12;
        i3.a r8 = (i3.a) m3.c.a(i3.a.class);     // Catch: Throwable -> L14
        if (r8 == null) goto L12;
        r8.a();     // Catch: Throwable -> L14
        monitor-enter(a.class);     // Catch: Throwable -> L14
        monitor-exit(a.class);     // Catch: Throwable -> L14
        f7903a = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(a.class);
    }

    public static void b(j3.a r8) {
        f7904b.a(r8);
        if (b.G() == false) goto L5;
        q3.a.a("APM-CommonEvent", "cached CommonEvent:" + r8);
    L5:
        a();
    }

    public static void c(j3.c r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        k3.b.a(r8);
    }

    public static void d(d r8) {
        if (b.G() == false) goto L9;
        StringBuilder r10 = new StringBuilder("trace_data:");
        JSONArray r11 = r8.f8581a;
        JSONObject r12 = new JSONObject().put("wrapper_array_data", r11);     // Catch: Exception -> L7
        r12.put("log_type", "tracing");     // Catch: Exception -> L7
        r12.put("wrapper_type_description", 1);     // Catch: Exception -> L7
    L8:
        r10.append(r12);
        q3.a.a("APM-CommonEvent", r10.toString());
    L7:
        r12 = null;
    L9:
        k3.b.a(r8);
    }
}
