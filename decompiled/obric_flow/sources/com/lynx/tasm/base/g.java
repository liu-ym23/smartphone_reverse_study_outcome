package com.lynx.tasm.base;

import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f10128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FutureTask f10129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Consumer f10130c;

    public g(Callable r5, Consumer r10) {
        this.f10128a = new AtomicBoolean(false);
        this.f10130c = null;
        this.f10129b = new FutureTask(r5);
        this.f10130c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f10128a.compareAndSet(false, true) == false) goto L6;
        this.f10129b.run();
        return;
    }
}
