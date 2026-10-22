package com.airbnb.lottie;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends FutureTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f1249a;

    public b0(c0 r5, Callable r10) {
        this.f1249a = r5;
        super(r10);
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        c0 r5 = this.f1249a;
        if (isCancelled() == false) goto L10;
        return;
    L10:
        r5.c((a0) get());     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        r5.c(new a0(e));
    }
}
