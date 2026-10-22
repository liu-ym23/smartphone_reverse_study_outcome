package com.bytedance.ies.bullet.prefetchv2;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f5866a;

    public m(i r5, h r10, r r11, f r12) {
        Intrinsics.checkNotNullParameter(r11, "schemaModel");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r12, "prefetchConfig");
        this.f5866a = r10;
    }

    public final synchronized void a() {
        monitor-enter(this);
        ConcurrentHashMap r5 = s.f5876a;     // Catch: Throwable -> L12
        h r10 = this.f5866a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r10, "request");     // Catch: Throwable -> L12
        Object r11 = s.f5877b;     // Catch: Throwable -> L12
        monitor-enter(r11);     // Catch: Throwable -> L12
        m r12 = (m) s.f5876a.remove(r10.f5854h);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
