package com.bytedance.android.live.browser.service;

import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnniePerformanceServiceImpl implements m9.c {
    public final Lazy a;

    public static final class a implements IStallCallback {
        public final /* synthetic */ Function2 a;

        public final void onBlockReady(long r1, int r3, long r4) {
        }

        public a(Function2 r1) {
            this.a = r1;
        }

        public final void onFpsReady(double r2, JSONObject r4) {
            Function2 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(Double.valueOf(r2), r4);
            return;
        }
    }

    public final IPerformanceManager H1() {
        return (IPerformanceManager) this.a.getValue();
    }

    public AnniePerformanceServiceImpl() {
        this.a = InfraKotlinExtsKt.mainThreadLazy(AnniePerformanceServiceImpl$hostPerformanceManager$2.INSTANCE);
    }

    public final double getCpuRate() {
        IPerformanceManager r0 = H1();
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.getCpuRate();
    }

    public final double getCpuSpeed() {
        IPerformanceManager r0 = H1();
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.getCpuSpeed();
    }

    public final float getTemperature() {
        IPerformanceManager r0 = H1();
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getTemperature();
    }

    public final void c1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        IPerformanceManager r0 = H1();
        if (r0 == null) goto L6;
        r0.startMonitorFps(r2);
        return;
    }

    public final void h0(String r3, Function2<? super Double, ? super JSONObject, Unit> r4) {
        IPerformanceManager r0 = H1();
        if (r0 == null) goto L5;
        r0.stopMonitorFps(r3, new a(r4));
    L5:
        IPerformanceManager r5 = H1();
        if (r5 == null) goto L9;
        r5.releaseFpsMonitor(r3);
        return;
    }
}
