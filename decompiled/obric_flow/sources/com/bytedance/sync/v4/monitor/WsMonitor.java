package com.bytedance.sync.v4.monitor;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.agilelogger.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class WsMonitor implements LifecycleObserver {
    public WsMonitor() {
        new AtomicBoolean(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onAnyActivityPause() {
        ALog.i("SyncSDKLog", "WsMonitor ON_PAUSE");     // Catch: Throwable -> L5
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onAnyActivityResume() {
        ALog.i("SyncSDKLog", "WsMonitor ON_RESUME");     // Catch: Throwable -> L5
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAnyActivityStart() {
        ALog.i("SyncSDKLog", "WsMonitor ON_START");     // Catch: Throwable -> L5
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAnyActivityStop() {
        ALog.i("SyncSDKLog", "WsMonitor ON_STOP");     // Catch: Throwable -> L5
        return;
    }
}
