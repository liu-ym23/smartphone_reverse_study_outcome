package com.bytedance.crash.tracker;

import com.bytedance.crash.runtime.DefaultWorkThread;

/* JADX INFO: loaded from: classes2.dex */
public class TrackerManager {
    public TrackerManager() {
    }

    public static void start() {
        DefaultWorkThread.post(new AnonymousClass1());
    }

    public static void startActivityTrack() {
        ActivityLifecycle.start();
    }
}
