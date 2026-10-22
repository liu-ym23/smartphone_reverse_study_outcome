package com.larus.bmhome.resource.access;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 {
    public final w a;
    public final c0 b;
    public volatile j0 c;
    public volatile mr9.c d;
    public volatile Long e;
    public volatile mr9.h f;
    public volatile String g;
    public volatile f0 h;
    public final ConcurrentHashMap<String, String> i;

    public final Map<String, String> b() {
        return MapsKt.toMap(this.i);
    }

    public final synchronized void a(i0 r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "update");     // Catch: Throwable -> L24
        j0 r0 = r3.a;     // Catch: Throwable -> L24
        if (r0 == null) goto L6;
        this.c = r0;     // Catch: Throwable -> L24
    L6:
        mr9.c r1 = r3.b;     // Catch: Throwable -> L24
        if (r1 == null) goto L9;
        this.d = r1;     // Catch: Throwable -> L24
    L9:
        Long r2 = r3.c;     // Catch: Throwable -> L24
        if (r2 == null) goto L12;
        this.e = Long.valueOf(r2.longValue());     // Catch: Throwable -> L24
    L12:
        mr9.h r4 = r3.d;     // Catch: Throwable -> L24
        if (r4 == null) goto L15;
        this.f = r4;     // Catch: Throwable -> L24
    L15:
        String r5 = r3.e;     // Catch: Throwable -> L24
        if (r5 == null) goto L18;
        this.g = r5;     // Catch: Throwable -> L24
    L18:
        f0 r6 = r3.f;     // Catch: Throwable -> L24
        if (r6 == null) goto L21;
        this.h = r6;     // Catch: Throwable -> L24
    L21:
        this.i.putAll(r3.g);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public h0(w r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "task");
        this.a = r2;
        this.b = r3;
        this.c = r2.b;
        this.d = r2.d.i;
        this.e = r2.d.j;
        this.f = r2.d.h;
        this.g = r2.d.e;
        this.i = new ConcurrentHashMap(r2.d.m);
    }
}
