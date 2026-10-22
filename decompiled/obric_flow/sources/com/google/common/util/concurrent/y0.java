package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Executor f9447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f9448b;

    public y0(Executor r5, p r10) {
        this.f9447a = r5;
        this.f9448b = r10;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        this.f9447a.execute(r5);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        this.f9448b.k(e);
    }
}
