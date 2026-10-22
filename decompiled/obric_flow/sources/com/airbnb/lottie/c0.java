package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public static final ExecutorService e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f1252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f1253c;
    public volatile a0 d;

    static {
        e = Executors.newCachedThreadPool();
    }

    public c0(Callable r5) {
        this.f1251a = new LinkedHashSet(1);
        this.f1252b = new LinkedHashSet(1);
        this.f1253c = new Handler(Looper.getMainLooper());
        this.d = null;
        e.execute(new b0(this, r5));
    }

    public final synchronized void a(y r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.d != null) goto L6;
    L10:
        this.f1252b.add(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L6:
        if (this.d.f1248b == null) goto L10;
        r5.onResult(this.d.f1248b);     // Catch: Throwable -> L8
        goto L10
    }

    public final synchronized void b(y r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.d != null) goto L6;
    L10:
        this.f1251a.add(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L6:
        if (this.d.f1247a == null) goto L10;
        r5.onResult(this.d.f1247a);     // Catch: Throwable -> L8
        goto L10
    }

    public final void c(a0 r5) {
        if (this.d != null) goto L7;
        this.d = r5;
        a6.a r10 = new a6.a(this, 3);
        this.f1253c.post(r10);
        return;
    L7:
        throw new IllegalStateException("A task may only be set once.");
    }
}
