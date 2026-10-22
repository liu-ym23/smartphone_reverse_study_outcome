package com.bytedance.android.livesdk.gamecp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.AppLifeCycleMonitor;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.ttnet.TTNetInit;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements bw.b {

    public static final class a implements IHostAppMonitorListener {
        public final /* synthetic */ dw.d a;

        public a(dw.d r1) {
            this.a = r1;
        }

        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.onActivityDestroyed(r2);
            return;
        }

        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.onActivityPaused(r2);
            return;
        }

        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.onActivityResumed(r2);
            return;
        }

        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.onActivityStarted(r2);
            return;
        }

        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.onActivityStopped(r2);
            return;
        }

        public final void appEnterBackground(boolean r2, boolean r3) {
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.appEnterBackground(r2, r3);
            return;
        }

        public final void onActivityCreated(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.onActivityCreated(r2, r3);
            return;
        }

        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
            dw.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.onActivitySaveInstanceState(r2, r3);
            return;
        }
    }

    public j() {
    }

    public final void M0(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final String P() {
        return null;
    }

    public final void X1(com.bytedance.android.gamecp.host_api.model.i r2) {
        Intrinsics.checkNotNullParameter(r2, "pushInfo");
    }

    public final void f1() {
    }

    public final float getDeviceScore() {
        return z0.b(false);
    }

    public final void getFontScale() {
    }

    public final void m2(Function1 r3) {
        Intrinsics.checkNotNullParameter("DouyinSansBold.otf", "fontName");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    public final Activity A1() {
        return jc1.k.n(IHostApp.class).getTopActivity();
    }

    public final Activity[] getActivityStack() {
        WeakReference r0 = com.bytedance.android.live.core.utils.a.a;
        LinkedList r1 = com.bytedance.android.live.core.utils.a.b;
        if (r1 == null) goto L9;
        Object[] r2 = r1.toArray(new Activity[0]);
        if (r2 == null) goto L8;
        return (Activity[]) r2;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        return null;
    }

    public final Activity getCurrentActivity() {
        return jc1.k.n(IHostApp.class).getCurrentActivity();
    }

    public final Map<String, String> getNQEParams() {
        HashMap r0 = new HashMap();
        PacketLossMetrics r1 = TTNetInit.getPacketLossRateMetrics(1);     // Catch: Exception -> L35
        r0.put("quic_send_loss_rate", String.valueOf(r1.upstreamLossRate));     // Catch: Exception -> L35
        r0.put("quic_receive_loss_rate", String.valueOf(r1.downstreamLossRate));     // Catch: Exception -> L35
        r0.put("net_effective_connection_type", String.valueOf(TTNetInit.getEffectiveConnectionType()));     // Catch: Exception -> L35
        if (fhc.b.b == null) goto L6;
    L15:
        fhc.c r2 = fhc.b.b.a;     // Catch: Exception -> L35
        double r3 = r2.a;     // Catch: Exception -> L35
        if (r3 != (-1.0d)) goto L30;
        ReentrantLock r4 = (ReentrantLock) fhc.c.f;     // Catch: Exception -> L35
        r4.lock();     // Catch: Exception -> L35
        double r6 = r2.a;     // Catch: Throwable -> L26
        if (r6 != (-1.0d)) goto L25;
        r2.d.a(r2.b, r2.c);     // Catch: Throwable -> L26
        fhc.a r5 = r2.e;     // Catch: Throwable -> L26
        if (r5 == r2.d) goto L23;
        r5.a(r2.b, r2.c);     // Catch: Throwable -> L26
    L23:
        r2.a = -1.0d;     // Catch: Throwable -> L26
        r6 = -1.0d;
        goto L25
    L25:
        r4.unlock();     // Catch: Exception -> L35
        r3 = r6;
    L26:
        th = move-exception;
        ((ReentrantLock) fhc.c.f).unlock();     // Catch: Exception -> L35
        throw th;     // Catch: Exception -> L35
    L30:
        if (r3 != (-1.0d)) goto L32;
        int r7 = -1;
    L33:
        r0.put("video_download_speed", String.valueOf(r7));     // Catch: Exception -> L35
        goto L34
    L32:
        r7 = (int) ((r3 / 8.0d) / 1000.0d);     // Catch: Exception -> L35
        goto L33
    L6:
        monitor-enter(fhc.b.class);     // Catch: Exception -> L35
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L35
    L8:
        if (fhc.b.b != null) goto L10;
        fhc.b.b = new fhc.b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(fhc.b.class);     // Catch: Throwable -> L12
    L34:
        return r0;
    }

    public final String getSessionId() {
        return jc1.k.n(IHostApp.class).getSessionId();
    }

    public final Activity getTopActivity() {
        return jc1.k.n(IHostApp.class).getTopActivity();
    }

    public final boolean isAppBackground() {
        return AppLifeCycleMonitor.INSTANCE.isAppBackground();
    }

    public final Activity c0() {
        return com.bytedance.android.live.core.utils.a.d();
    }

    public final Activity getMainActivity() {
        return TTLiveSDK.hostService().hostApp().getMainActivity();
    }

    public final void y0(dw.d r3) {
        IMiddlewareHostApp r0 = jc1.k.f(IMiddlewareHostApp.class);
        if (r0 == null) goto L6;
        r0.registerLiveLifeCycleListener(new a(r3));
        return;
    }

    public final void h0(Context r4, dw.l r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        jc1.k.n(IHostApp.class).checkUploadPlugin(r4, Boolean.TRUE, new h(r5));
    }

    public final void V1(Context r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        if (r4 != 0) goto L6;
    L8:
        jc1.k.n(IHostApp.class).centerToast(r2, r3, r4);     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L6:
        if (r4 == 1) goto L8;
        r4 = 0;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void centerToast(Context r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        jc1.k.n(IHostApp.class).centerToast(r2, r3, r4);
    }

    public final void G1(Context r11, String r12, String r13, Map r14, Map r15, Map r16, com.bytedance.android.gamecp.business.props.k r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "aid");
        Intrinsics.checkNotNullParameter(r13, "did");
        com.bytedance.android.live.wallet.c r0 = jc1.k.n(IRechargeServiceExternal.class).getCJExternalService();
        Map r4 = MapsKt.toMap(r14);
        Map r6 = MapsKt.toMap(r15);
        Map r7 = MapsKt.toMap(r16);
        i r8 = new i(r17);
        r0.getClass();
        com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).J(r11, r12, r13, r4, "", r6, r7, r8);
    }
}
