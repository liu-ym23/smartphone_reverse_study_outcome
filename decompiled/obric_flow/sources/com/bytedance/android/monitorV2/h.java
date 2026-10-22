package com.bytedance.android.monitorV2;

import android.app.Application;
import android.os.Handler;
import android.view.View;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile h f3580k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Application f3581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3583c;
    public f d;
    public e e;
    public z4.b f;
    public final k6.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CopyOnWriteArrayList f3584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f3585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f3586j;

    public h() {
        this.f3582b = false;
        this.f3583c = false;
        this.g = new k6.a(3);
        this.f3585i = u4.e.f22249a;
        this.f3586j = u4.e.f22250b;
    }

    public static void d(x4.c r5) {
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L7;
        xc.d r12 = (xc.d) r11.a(xc.d.class);
        if (r12 == null) goto L7;
        boolean r13 = Intrinsics.areEqual(r12.Z(), Boolean.TRUE);
    L8:
        if (r13 == false) goto L29;
        String r14 = r5.f22951i;
        if (r14 == null) goto L25;
        j5.b r15 = j5.b.f18235a;
        Intrinsics.checkNotNullParameter(r14, "monitorId");
        if (((j5.f) j5.b.e.get(r14)) == null) goto L25;
        j5.f r16 = j5.b.i(r5.f22951i);
        if (r16 == null) goto L27;
        String r17 = r16.f18244a;
        boolean r18 = r17.equals("web");
        WeakReference r19 = r16.f18245b;
        if (r18 == false) goto L22;
        com.bytedance.android.monitorV2.webview.k.d.c((View) r19.get(), r5);
        return;
    L22:
        if (r17.equals("lynx") == false) goto L28;
        com.bytedance.android.monitorV2.lynx.d.f3638a.c((View) r19.get(), r5);
        return;
    L28:
        return;
    L27:
        return;
    L25:
        com.bytedance.android.monitorV2.event.b r20 = new com.bytedance.android.monitorV2.event.b(r5);
        com.bytedance.android.monitorV2.dataprocessor.b r21 = c.f3517a;
        c.d(r20, Boolean.TRUE);
        return;
    L29:
        return;
    L7:
        r13 = false;
        goto L8
    }

    public static h e() {
        if (f3580k != null) goto L16;
        monitor-enter(h.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f3580k != null) goto L11;
        f3580k = new h();     // Catch: Throwable -> L9
    L11:
        monitor-exit(h.class);     // Catch: Throwable -> L9
    L16:
        return f3580k;
    }

    public final z4.d a() {
        z4.b r5 = this.f;
        if (r5 == null) goto L6;
        return r5;
    L6:
        if (z4.a.f != null) goto L19;
        monitor-enter(z4.a.class);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (z4.a.f != null) goto L14;
        z4.a.f = new z4.a();     // Catch: Throwable -> L12
    L14:
        monitor-exit(z4.a.class);     // Catch: Throwable -> L12
    L19:
        return z4.a.f;
    }

    public final void b(a5.c r10) {
        z4.b r5 = new z4.b(r10);
        this.f = r5;
    L15:
        th = move-exception;
        mn.h.g("startup_handle", th);
    L40:
        Handler r11 = com.bytedance.android.monitorV2.executor.b.f3573a;     // Catch: Throwable -> L19
        ab.b r12 = new ab.b(3, this, false, r10);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r12, "runnable");     // Catch: Throwable -> L19
        com.bytedance.android.monitorV2.executor.b.a().execute(new c1.a(r12, 2));     // Catch: Throwable -> L19
    L21:
        Application r13 = this.f3581a;
        if (r13 == null) goto L46;
        JSONObject r14 = new JSONObject();
        r14.put(WsConstants.KEY_DEVICE_ID, r10.e);     // Catch: JSONException -> L27
        r14.put("host_aid", r10.f98a);     // Catch: JSONException -> L27
        r14.put(WsConstants.KEY_SDK_VERSION, "9.0.0");     // Catch: JSONException -> L27
        r14.put(LynxMonitorService.KEY_CHANNEL, r10.f);     // Catch: JSONException -> L27
        r14.put("app_version", r10.g);     // Catch: JSONException -> L27
        r14.put("update_version_code", r10.f101h);     // Catch: JSONException -> L27
    L30:
        if (r10.a() == null) goto L33;
        com.bytedance.framwork.core.sdkmonitor.f.d("8560", r10.a());
    L33:
        if (r10.b() == null) goto L35;
        com.bytedance.framwork.core.sdkmonitor.f.e("8560", r10.b());
    L35:
        com.bytedance.framwork.core.sdkmonitor.f.c(r13.getApplicationContext(), "8560", r14, new com.bytedance.sdk.xbridge.cn.auth.g(4));
        return;
    L27:
        e = move-exception;
        mn.h.g("startup_handle", e);
        goto L30
    L46:
        return;
    L19:
        th = move-exception;
        mn.h.g("startup_handle", th);
        goto L21
    L4:
        if (this.f3581a != null) goto L7;
        d5.b.e("HybridSettingRequestService_init", "init error, no context");     // Catch: Throwable -> L15
    L37:
        goto L40
    L7:
        if (r5.f23393b == true) goto L37;
        r5.f23393b = true;     // Catch: Throwable -> L15
        r5.f23394c.submit(new jm.a(r5, 18));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        mn.h.g("default_handle", th);     // Catch: Throwable -> L15
        goto L37
    }

    public final void c(Application r10) {
        if (this.f3582b == true) goto L40;
        this.f3582b = true;
        this.f3581a = r10;
    L11:
        th = move-exception;
        mn.h.g("startup_handle", th);
        return;
    L7:
        if (this.f3581a != null) goto L9;
    L13:
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();     // Catch: Throwable -> L11
        d5.b.f("HybridMultiMonitor", "init sdkinfo: 9.0.0, " + ((Number) a.f3516a.getValue()).longValue() + ", false");     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder("init hostinfo: ");     // Catch: Throwable -> L11
        String r5 = qo.a.p("version_name", com.bytedance.apm.j.f3888b);     // Catch: Throwable -> L16
    L18:
        r11.append(r5);     // Catch: Throwable -> L11
        r11.append(", ");     // Catch: Throwable -> L11
        int r12 = 0;
        JSONObject r13 = com.bytedance.apm.j.f3888b;     // Catch: Throwable -> L25
        if (r13 == null) goto L27;
        r12 = r13.optInt("version_code", 0);     // Catch: Throwable -> L25
    L27:
        r11.append(r12);     // Catch: Throwable -> L11
        d5.b.f("HybridMultiMonitor", r11.toString());     // Catch: Throwable -> L11
        com.bytedance.android.monitorV2.executor.b.a().execute(new androidx.fragment.app.d(this, 13));     // Catch: Throwable -> L11
        d r14 = new d();     // Catch: Throwable -> L11
        if (this.f3584h != null) goto L30;
        this.f3584h = new CopyOnWriteArrayList();     // Catch: Throwable -> L11
    L30:
        this.f3584h.add(r14);     // Catch: Throwable -> L11
        a6.a r15 = new a6.a(this, 8);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r15, "runnable");     // Catch: Throwable -> L11
        com.bytedance.android.monitorV2.executor.b.a().execute(new c1.a(r15, 2));     // Catch: Throwable -> L11
        return;
    L25:
        th = move-exception;
        mn.h.g("default_handle", th);     // Catch: Throwable -> L11
        goto L27
    L16:
        th = move-exception;
        mn.h.g("default_handle", th);     // Catch: Throwable -> L11
        r5 = "";
        goto L18
    L9:
        if (this.f3583c == true) goto L13;
        this.d = new f();     // Catch: Throwable -> L11
        this.f3581a.registerActivityLifecycleCallbacks(this.d);     // Catch: Throwable -> L11
        this.f3581a.registerActivityLifecycleCallbacks(c5.c.f1122a);     // Catch: Throwable -> L11
        this.f3583c = true;     // Catch: Throwable -> L11
        goto L13
    }
}
