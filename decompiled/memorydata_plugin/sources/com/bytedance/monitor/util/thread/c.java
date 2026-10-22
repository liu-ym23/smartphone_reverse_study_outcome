package com.bytedance.monitor.util.thread;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends com.bytedance.monitor.util.thread.a.c {

    public interface a {
        void a(Throwable r1, String r2);
    }

    long a(AsyncTaskType r1);

    void a(Throwable r1, String r2);

    ExecutorService b();

    e c();
}
