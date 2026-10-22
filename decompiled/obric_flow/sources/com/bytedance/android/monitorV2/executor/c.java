package com.bytedance.android.monitorV2.executor;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3575a = null;

    static {
        f3575a = new c();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Thread r10 = new Thread(r5);
        r10.setName("hybrid-monitor-data-report-thread");
        r10.setPriority(2);
        return r10;
    }
}
