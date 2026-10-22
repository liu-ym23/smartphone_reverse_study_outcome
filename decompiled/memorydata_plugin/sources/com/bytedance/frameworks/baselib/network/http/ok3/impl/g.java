package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: classes2.dex */
public class g implements TTNetDns {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f2467b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2468a;

    public g() {
        this.f2468a = g.class.getSimpleName();
    }

    public static g a() {
        if (f2467b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2467b != null) goto L9;
        f2467b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f2467b;
    }
}
