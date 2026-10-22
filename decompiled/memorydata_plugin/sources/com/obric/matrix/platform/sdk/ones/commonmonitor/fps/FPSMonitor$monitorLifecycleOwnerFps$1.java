package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\nH\u0007R\u0016\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"com/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitor$monitorLifecycleOwnerFps$1", "Landroidx/lifecycle/LifecycleObserver;", "TAG", "", "kotlin.jvm.PlatformType", "fpsTracer", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "getFpsTracer", "()Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "onDestroy", "", "onPause", "onResume", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FPSMonitor$monitorLifecycleOwnerFps$1 implements LifecycleObserver {
    final /* synthetic */ LifecycleOwner $owner;
    private final String TAG;
    private final c fpsTracer;

    FPSMonitor$monitorLifecycleOwnerFps$1(LifecycleOwner r4) {
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        this.$owner = r5;
        String r6 = r5.getClass().getSimpleName();
        this.TAG = r6;
        Intrinsics.checkNotNullExpressionValue(r6, "TAG");
        this.fpsTracer = new c(r6, false, null);
    }

    public final c getFpsTracer() {
        return this.fpsTracer;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        String r0 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r0, "TAG");
        com.obric.matrix.platform.sdk.ones.internal.b.b.a(r0, "onDestroy", null, 4, null);
        this.$owner.getLifecycle().removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        String r0 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r0, "TAG");
        com.obric.matrix.platform.sdk.ones.internal.b.b.a(r0, "onPause fps stop", null, 4, null);
        this.fpsTracer.b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        String r0 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r0, "TAG");
        com.obric.matrix.platform.sdk.ones.internal.b.b.a(r0, "start fps monitor", null, 4, null);
        b.a(b.f8087a);
        this.fpsTracer.a();
    }
}
