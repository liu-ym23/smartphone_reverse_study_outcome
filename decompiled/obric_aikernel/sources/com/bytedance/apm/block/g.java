package com.bytedance.apm.block;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f774b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f775a;

    class a implements g0.a.InterfaceC0170a {
        a(g r10) {
        }
    }

    private g() {
        this.f775a = 0;
    }

    public static g a() {
        if (f774b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f774b != null) goto L9;
        f774b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f774b;
    }

    public static int b(int r10) {
        if (r10 != 11) goto L5;
        return 2;
    L5:
        if (r10 != 101) goto L7;
        return 3;
    L7:
        if (r10 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static int c(JSONObject r10) {
        int r11 = com.bytedance.apm.util.i.f(r10, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "smooth", "block_monitor_mode");
        if (r11 != 11) goto L5;
        return 2;
    L5:
        if (r11 != 101) goto L7;
        return 3;
    L7:
        if (r11 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public void d() {
        g0.a.a(new a(this));
    }

    public void e() {
        com.bytedance.monitor.collector.k.n().v();
    }

    public void f(int r10, boolean r11) {
        this.f775a = b(r10);
        com.bytedance.monitor.collector.k.n().x(this.f775a);
    }
}
