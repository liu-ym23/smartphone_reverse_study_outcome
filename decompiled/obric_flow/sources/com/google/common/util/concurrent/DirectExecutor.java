package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    public static final DirectExecutor INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DirectExecutor[] f9388a = null;

    static {
        DirectExecutor r5 = new DirectExecutor("INSTANCE", 0);
        INSTANCE = r5;
        f9388a = new DirectExecutor[]{r5};
    }

    public static DirectExecutor valueOf(String r5) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, r5);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) f9388a.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r5) {
        r5.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
