package com.bytedance.apm.block;

import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f1229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1230b;

    private g() {
        this.f1230b = 0;
    }

    public static int a(int r1) {
        if (r1 != 11) goto L5;
        return 2;
    L5:
        if (r1 != 101) goto L7;
        return 3;
    L7:
        if (r1 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static int a(JSONObject r3) {
        int r4 = JsonUtils.a(r3, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "smooth", "block_monitor_mode");
        if (r4 != 11) goto L5;
        return 2;
    L5:
        if (r4 != 101) goto L7;
        return 3;
    L7:
        if (r4 == 1001) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static g a() {
        if (f1229a != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1229a != null) goto L9;
        f1229a = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f1229a;
    }

    public void a(int r1, boolean r2) {
        this.f1230b = a(r1);
        com.bytedance.monitor.collector.k.a().a(this.f1230b);
    }

    public void b() {
        com.bytedance.apm.f.a.a(new AnonymousClass1(this));
    }

    public void c() {
        com.bytedance.monitor.collector.k.a().d();
    }
}
