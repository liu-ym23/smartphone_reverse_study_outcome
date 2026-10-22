package com.bytedance.ies.abmock.datacenter.plugin;

import com.bytedance.ies.abmock.datacenter.storage.j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2691b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<BaseConfigPlugin, Boolean> f2692a;

    private a() {
        this.f2692a = new ConcurrentHashMap();
    }

    public static a a() {
        if (f2691b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2691b != null) goto L9;
        f2691b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2691b;
    }

    public void a(BaseConfigPlugin r2) {
        this.f2692a.put(r2, false);
        if (j.b() == false) goto L6;
        j.a();
        return;
    }

    public Map<BaseConfigPlugin, Boolean> b() {
        return this.f2692a;
    }
}
