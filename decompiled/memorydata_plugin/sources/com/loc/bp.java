package com.loc;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class bp extends br {
    private static Thread.UncaughtExceptionHandler c;
    private static bp d;

    static {
        c = new AnonymousClass1();
        d = new bp(new bn.a().a(c).a("amap-global-threadPool").a());
    }

    private bp(bn r10) {
        this.f5375a = new ThreadPoolExecutor(r10.a(), r10.b(), r10.d(), TimeUnit.SECONDS, r10.c(), r10);     // Catch: Throwable -> L5
        this.f5375a.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        q.b(th, "TPool", "ThreadPool");
        th.printStackTrace();
    }

    public static bp a() {
        return d;
    }
}
