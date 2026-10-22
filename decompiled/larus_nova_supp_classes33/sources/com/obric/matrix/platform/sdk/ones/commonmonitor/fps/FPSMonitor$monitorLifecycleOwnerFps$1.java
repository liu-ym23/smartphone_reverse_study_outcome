package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import gka.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"com/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitor$monitorLifecycleOwnerFps$1", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onDestroy", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class FPSMonitor$monitorLifecycleOwnerFps$1 implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        b.a(null, "onDestroy");
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        b.a(null, "onPause fps stop");
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        b.a(null, "start fps monitor");
        throw null;
    }
}
