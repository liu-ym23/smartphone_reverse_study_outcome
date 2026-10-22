package com.bytedance.android.live.core.performance;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseSampler<T> implements LifecycleObserver, Runnable {
    public final int a;
    public Handler b;
    public final ArrayList<T> c;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Handler r0 = this.b;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this);
        this.b = null;
        return;
    }

    public BaseSampler() {
        this.c = new ArrayList();
        this.a = 300;
    }

    static {
    }
}
