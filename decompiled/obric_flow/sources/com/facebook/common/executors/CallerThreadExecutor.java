package com.facebook.common.executors;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class CallerThreadExecutor extends AbstractExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CallerThreadExecutor f7644a = null;

    static {
        f7644a = new CallerThreadExecutor();
    }

    public CallerThreadExecutor() {
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r5, TimeUnit r10) {
        return true;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        r5.run();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return Collections.EMPTY_LIST;
    }
}
