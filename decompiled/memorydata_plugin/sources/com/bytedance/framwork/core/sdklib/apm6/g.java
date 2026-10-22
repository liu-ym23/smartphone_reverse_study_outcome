package com.bytedance.framwork.core.sdklib.apm6;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Long, Long> f2600a;
    private static i c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f2601b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f2602a = null;

        static {
            f2602a = new g();
        }

        static /* synthetic */ g a() {
            return f2602a;
        }
    }

    static {
        f2600a = new ConcurrentHashMap();
    }

    public g() {
        this.f2601b = false;
    }

    public static g a() {
        return a.a();
    }

    private synchronized void b() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f2601b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f2601b = true;     // Catch: Throwable -> L14
        if (j.d() == false) goto L11;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "Initializing SlardarHandler...");     // Catch: Throwable -> L14
    L11:
        c = new i(com.bytedance.framwork.core.sdklib.apm6.a.c(), com.bytedance.framwork.core.sdklib.apm6.a.d());     // Catch: Throwable -> L14
        d.a().a(c);     // Catch: Throwable -> L14
        d.a().b();     // Catch: Throwable -> L14
        e.a().b();     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public void a(long r9, JSONObject r11) {
    L16:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "record", th);
        return;
    L4:
        if (f2600a.containsKey(Long.valueOf(r9)) == true) goto L6;
        f2600a.put(Long.valueOf(r9), Long.valueOf(com.bytedance.framwork.core.sdklib.apm6.a.a.a().a(r9, j.a(r9))));     // Catch: Throwable -> L16
    L6:
        b();     // Catch: Throwable -> L16
        if (r11.getJSONObject("_debug_self") != null) goto L10;
        r11.put("_debug_self", new JSONObject());     // Catch: Exception -> L19 Throwable -> L16
    L10:
        new JSONObject().put("sdk_report_from", "apm6");     // Catch: Exception -> L19 Throwable -> L16
    L12:
        if (j.d() == false) goto L14;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "record:" + r9 + " " + r11);     // Catch: Throwable -> L16
    L14:
        c.a(r9, ((Long) ZeusTransformUtils.preCheckCast(f2600a.get(Long.valueOf(r9)), Long.class, "com.obric.memorydata.plugin")).longValue(), r11);     // Catch: Throwable -> L16
    }
}
