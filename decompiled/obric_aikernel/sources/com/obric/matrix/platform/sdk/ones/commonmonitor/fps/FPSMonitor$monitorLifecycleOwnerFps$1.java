package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class FPSMonitor$monitorLifecycleOwnerFps$1 implements LifecycleObserver {
    final /* synthetic */ LifecycleOwner $owner;
    private final String TAG;
    private final c fpsTracer;

    FPSMonitor$monitorLifecycleOwnerFps$1(LifecycleOwner r10) {
        this.$owner = r10;
        String r11 = r10.getClass().getSimpleName();
        this.TAG = r11;
        Intrinsics.checkNotNullExpressionValue(r11, "TAG");
        this.fpsTracer = new c(r11, false, null);
    }

    public final c getFpsTracer() {
        return this.fpsTracer;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        String r10 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r10, "TAG");
        e9.b.b(r10, "onDestroy", null, 4, null);
        this.$owner.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        String r10 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r10, "TAG");
        e9.b.b(r10, "onPause fps stop", null, 4, null);
        this.fpsTracer.g();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        String r10 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r10, "TAG");
        e9.b.b(r10, "start fps monitor", null, 4, null);
        b.a(b.f5856a);
        this.fpsTracer.f();
    }
}
