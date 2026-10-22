package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static UiThreadImmediateExecutorService f7648b;

    public UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadImmediateExecutorService b() {
        if (f7648b != null) goto L6;
        f7648b = new UiThreadImmediateExecutorService();
    L6:
        return f7648b;
    }

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        if (a() == false) goto L6;
        r5.run();
        return;
    L6:
        this.f7645a.post(r5);
    }
}
