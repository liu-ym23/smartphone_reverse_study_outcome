package com.bytedance.crash.anr;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.runtime.DefaultWorkThread;

/* JADX INFO: loaded from: classes.dex */
public class AnrSignalMonitor {
    public AnrSignalMonitor() {
    }

    private void initOnMainThread() {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this));
    }

    private void initOnSubThread() {
        DefaultWorkThread.post(new AnonymousClass2(this));
    }

    void start() {
        initOnMainThread();
        initOnSubThread();
    }

    void stop() {
    }
}
