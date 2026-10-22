package com.bytedance.forest.preload;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4565a = null;

    static {
        f4565a = new b();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        r5.run();
    }
}
