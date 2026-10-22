package com.ss.android.lark.monitor.traffic;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustSdkTrafficHandler extends a<TrafficMetrics> {
    public e3c.a b;
    public e3c.a c;
    public final RustSDKTrafficCallback d;
    public ScheduledFuture<?> e;
    public boolean f;
    public boolean g;

    public class RustSDKTrafficCallback implements IGetDataCallback<e3c.a> {
        private boolean mIsFirstCollect;
        final /* synthetic */ RustSdkTrafficHandler this$0;

        public RustSDKTrafficCallback(RustSdkTrafficHandler r1) {
            this.this$0 = r1;
            this.mIsFirstCollect = true;
        }

        public void onError(ErrorResult r3) {
            Log.w("RustSdkTrafficHandler", "rustSDK traffic data error: " + r3.getMessage());
        }

        public void onSuccess(e3c.a r5) {
            if (r5 != null) goto L5;
            Log.i("RustSdkTrafficHandler", "rustSDK traffic data is null");
            return;
        L5:
            Log.i("RustSdkTrafficHandler", "rustSDK traffic data, wfRx: " + r5.a + ",wfTx: " + r5.b + ",mbRx: " + r5.c + ",mbTx: " + r5.d);
            RustSDKTrafficCallback r0 = this.this$0.d;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L8:
            if (this.mIsFirstCollect == false) goto L10;
            this.mIsFirstCollect = false;     // Catch: Throwable -> L13
            this.this$0.b = r5;     // Catch: Throwable -> L13
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L10:
            this.this$0.c = r5;     // Catch: Throwable -> L13
            goto L11
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((e3c.a) r1);
        }
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r0 = new TrafficMetrics();
        r0.from = TrafficMetrics.FROM_RUST;
        RustSDKTrafficCallback r1 = this.d;
        monitor-enter(r1);
        e3c.a r2 = this.c;     // Catch: Throwable -> L18
        boolean r3 = true;
        if (r2 == null) goto L7;
        boolean r5 = true;
    L8:
        e3c.a r6 = this.b;     // Catch: Throwable -> L18
        if (r6 != null) goto L13;
        r3 = false;
    L13:
        if ((r3 & r5) == false) goto L15;
        r0.mobileBytesRx = r2.c - r6.c;     // Catch: Throwable -> L18
        r0.mobileBytesTx = r2.d - r6.d;     // Catch: Throwable -> L18
        r0.wifiBytesRx = r2.a - r6.a;     // Catch: Throwable -> L18
        r0.wifiBytesTx = r2.b - r6.b;     // Catch: Throwable -> L18
        this.a = r0;     // Catch: Throwable -> L18
    L15:
        this.b = r2;     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r0;
    L7:
        r5 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public RustSdkTrafficHandler() {
        this.f = false;
        this.g = true;
        this.d = new RustSDKTrafficCallback(this);
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (true != this.f) goto L9;
        Log.i("RustSdkTrafficHandler", "rustSDK traffic data has started, isAppFront:true");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L9:
        this.f = true;     // Catch: Throwable -> L19
        ScheduledFuture<?> r2 = this.e;     // Catch: Throwable -> L19
        if (r2 == null) goto L13;
        r2.cancel(true);     // Catch: Throwable -> L19
        this.e = null;     // Catch: Throwable -> L19
    L13:
        if (this.g == false) goto L15;
        this.g = false;     // Catch: Throwable -> L19
        long r0 = 5;
    L16:
        long r3 = r0;
        this.e = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new e(this), r3, 30, TimeUnit.SECONDS);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L15:
        r0 = 30;
        goto L16
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r2) {
        TrafficMetrics r0 = this.a;
        if (r0 == null) goto L6;
        r2.f = r0.totalKBytes();
        r2.i = this.a.totalMobileKBytes();
        r2.j = this.a.totalWifiKBytes();
        r2.g = this.a.totalRxKBytes();
        r2.h = this.a.totalTxKBytes();
        return;
    }
}
