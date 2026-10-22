package com.bytedance.sync.v4.compensate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes2.dex */
final class CompensatorImplV4 implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppBackground() {
        ALog.i("SyncSDKLog", "[CompensatorV4] startCompensate ON_STOP");     // Catch: Throwable -> L6
    L5:
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppForeground() {
        ALog.i("SyncSDKLog", "[CompensatorV4] startCompensate ON_START");     // Catch: Throwable -> L6
    L5:
        throw null;
    }
}
