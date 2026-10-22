package com.bytedance.android.live.broadcastgame.opengame.performance;

import android.os.Build;
import com.bytedance.android.live.broadcastgame.e0;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdk.config.ad1;
import com.bytedance.android.livesdk.config.ge0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPlatformPerfDog implements e0 {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final int d = 0;
    public static int e;
    public static final Lazy f = null;
    public static volatile boolean g;
    public static volatile float h;
    public static volatile float i;
    public static volatile int j;
    public static volatile float k;
    public static volatile float l;
    public static volatile long m;
    public static final com.bytedance.android.livesdk.utils.c n = null;
    public static Disposable o;
    public static final OpenPlatformPerfDog p = null;

    public OpenPlatformPerfDog() {
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float c() {
        LocalTestManager.a(new Class[]{wy.a.class});
        if (Build.VERSION.SDK_INT < 26) goto L11;
        IHostPerformanceMonitor r0 = (IHostPerformanceMonitor) f.getValue();
        if (r0 == null) goto L19;
        Map r1 = r0.getCpuRate();
        if (r1 == null) goto L19;
        Double r2 = (Double) r1.get("cpu_speed");
        if (r2 == null) goto L19;
        double r3 = r2.doubleValue();
    L21:
        return (float) r3;
    L19:
        return -1.0f;
    L11:
        IHostPerformanceMonitor r4 = (IHostPerformanceMonitor) f.getValue();
        if (r4 == null) goto L19;
        Map r5 = r4.getCpuRate();
        if (r5 == null) goto L19;
        Double r6 = (Double) r5.get("cpu_rate");
        if (r6 == null) goto L19;
        r3 = r6.doubleValue();
        goto L21
    }

    static {
        p = new OpenPlatformPerfDog();
        a = LazyKt.lazy(OpenPlatformPerfDog$ENCODE_FPS_THRESHOLD$2.INSTANCE);
        b = LazyKt.lazy(OpenPlatformPerfDog$STUTTER_RATE_THRESHOLD$2.INSTANCE);
        c = LazyKt.lazy(OpenPlatformPerfDog$BATTERY_TEMPERATURE_THRESHOLD$2.INSTANCE);
        d = 2;
        f = LazyKt.lazy(OpenPlatformPerfDog$mPerformanceMonitor$2.INSTANCE);
        n = new com.bytedance.android.livesdk.utils.c(((ad1) ge0.a.getValue()).f(), 1);
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float a() {
        IHostPerformanceMonitor r0 = (IHostPerformanceMonitor) f.getValue();
        if (r0 == null) goto L9;
        Map r1 = r0.getMemory();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.get("mem_pss_total");
        if (r2 == null) goto L9;
        return r2.longValue() / 1048576;
    L9:
        return -1.0f;
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final int b() {
        return (int) jc1.k.n(IPerformanceManager.class).getStreamRenderFps();
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float d() {
        return jc1.k.n(IPerformanceManager.class).getTemperature();
    }

    @Override // com.bytedance.android.live.broadcastgame.e0
    public final float getUIStallRate() {
        float r0 = jc1.k.n(IPerformanceManager.class).getUIStallRate();
        if (r0 >= 0) goto L6;
        return 0.0f;
    L6:
        return r0;
    }
}
