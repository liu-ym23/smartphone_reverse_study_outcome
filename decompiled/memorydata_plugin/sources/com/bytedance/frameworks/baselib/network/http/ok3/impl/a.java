package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f2450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f2451b;

    private a() {
        this.f2451b = new CopyOnWriteArrayList();
    }

    public static a a() {
        if (f2450a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2450a != null) goto L9;
        f2450a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2450a;
    }

    public void a(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        TTConfigManager.parseJsonArray(r2, "log_header_rm_list", this.f2451b);
    }

    public List<String> b() {
        return this.f2451b;
    }
}
