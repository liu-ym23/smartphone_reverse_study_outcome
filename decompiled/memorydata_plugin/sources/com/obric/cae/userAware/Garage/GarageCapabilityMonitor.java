package com.obric.cae.userAware.Garage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.obric.cae.log.a;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class GarageCapabilityMonitor {
    static final int CAPABILITY_ALL = 7;
    static final int CAPABILITY_BLE = 2;
    static final int CAPABILITY_GPS = 4;
    static final int CAPABILITY_WIFI = 1;
    private static final long ENABLE_DEBOUNCE_MS = 2000;
    private static final String TAG = "GarageCapability";
    private final Context mContext;
    private volatile ScheduledFuture<?> mEnableFuture;
    private final ScheduledExecutorService mExecutor;
    private final Listener mListener;
    private int mPublishedMask;
    private final PluginBroadcastReceiver mReceiver;
    private boolean mReceiverRegistered;
    private volatile boolean mStarted;

    public interface Listener {
        void onCapabilityChanged(Snapshot r1);
    }

    public static final class Snapshot {
        final int capabilityMask;
        final boolean enabled;

        public Snapshot(int r2) {
            this.capabilityMask = r2;
            if (r2 != 7) goto L5;
            boolean r3 = true;
        L6:
            this.enabled = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    public GarageCapabilityMonitor(Context r4, ScheduledExecutorService r5, Listener r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        ScheduledExecutorService r8 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        Listener r9 = (Listener) ZeusTransformUtils.wrapperContextForParams(r6, Listener.class, "com.obric.memorydata.plugin");
        this.mPublishedMask = -1;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r7 = r0;
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mExecutor = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r8), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        this.mListener = (Listener) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r9), Listener.class, "com.obric.memorydata.plugin");
        this.mReceiver = new AnonymousClass1(this);
    }

    private void cancelPendingEnable() {
        if (this.mEnableFuture == null) goto L6;
        this.mEnableFuture.cancel(false);
        this.mEnableFuture = null;
        return;
    }

    private void evaluate() {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        int r0 = readCapabilityMask();
        if (r0 == 7) goto L10;
        cancelPendingEnable();
        publishIfChanged(r0);
        return;
    L10:
        if (this.mPublishedMask != 7) goto L12;
        return;
    L12:
        if (this.mEnableFuture != null) goto L17;
        this.mEnableFuture = this.mExecutor.schedule(new $$Lambda$GarageCapabilityMonitor$YExJrP3hm2sQfp2UtCpgERrqRyg(this), 2000, TimeUnit.MILLISECONDS);
        return;
    }

    /* JADX INFO: renamed from: lambda$1pJzn1oX5Z8ZGcZcRq5RoEQq4-E, reason: not valid java name */
    public static /* synthetic */ void m399lambda$1pJzn1oX5Z8ZGcZcRq5RoEQq4E(GarageCapabilityMonitor r0) {
        r0.evaluate();
    }

    private void publishIfChanged(int r4) {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        if (r4 == this.mPublishedMask) goto L10;
        this.mPublishedMask = r4;
        Snapshot r0 = new Snapshot(r4);
        a.e(TAG, "capability mask=0x" + Integer.toHexString(r4) + " enabled=" + r0.enabled);
        this.mListener.onCapabilityChanged(r0);
        return;
    }

    private int readCapabilityMask() {
        boolean r2 = true;
        WifiManager r4 = (WifiManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(WifiManager.class), WifiManager.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L8
        if (r4 == null) goto L10;
        if (r4.isWifiEnabled() == false) goto L10;
        int r5 = 1;
    L50:
    L29:
        e = e;
        String r6 = "BLE capability permission denied";
    L31:
        a.a(TAG, r6, e);
    L52:
    L44:
        e = e;
        String r0 = "GPS capability permission denied";
    L46:
        a.a(TAG, r0, e);
        return r5;
    L42:
        e = e;
        r0 = "failed to query GPS capability";
        goto L46
    L33:
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L36;
        r2 = false;
    L36:
        LocationManager r8 = (LocationManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(LocationManager.class), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L42 SecurityException -> L44
        if (r2 == false) goto L54;
        if (r8 == null) goto L55;
        if (r8.isProviderEnabled("gps") == true) goto L57;
        return r5;
    L57:
        return r5 | 4;
    L55:
        return r5;
    L54:
        return r5;
    L27:
        e = e;
        r6 = "failed to query BLE capability";
        goto L31
    L12:
        if (this.mContext.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) goto L14;
    L16:
        boolean r7 = false;
    L17:
        BluetoothManager r9 = (BluetoothManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(BluetoothManager.class), BluetoothManager.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L27 SecurityException -> L29
        if (r9 != null) goto L20;
        BluetoothAdapter r10 = null;
    L21:
        if (r7 == false) goto L52;
        if (r10 == null) goto L52;
    L25:
        if (r10.getState() != 12) goto L52;
        r5 = r5 | 2;
        goto L52
    L20:
        r10 = r9.getAdapter();     // Catch: RuntimeException -> L27 SecurityException -> L29
        goto L21
    L14:
        if (this.mContext.checkSelfPermission("android.permission.BLUETOOTH_SCAN") != 0) goto L16;
        r7 = true;
    L10:
        r5 = 0;
    L8:
        e = move-exception;
        a.a(TAG, "failed to query WiFi capability", e);
        goto L10
    }

    public /* synthetic */ void lambda$evaluate$0$GarageCapabilityMonitor() {
        this.mEnableFuture = null;
        if (this.mStarted == true) goto L5;
        return;
    L5:
        publishIfChanged(readCapabilityMask());
    }

    public void requestEvaluation() {
        if (this.mStarted == true) goto L8;
        return;
    L8:
        this.mExecutor.execute(new $$Lambda$GarageCapabilityMonitor$1pJzn1oX5Z8ZGcZcRq5RoEQq4E(this));     // Catch: RejectedExecutionException -> L7
        return;
    }

    public synchronized void start() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mStarted = true;     // Catch: Throwable -> L20
        IntentFilter r1 = new IntentFilter();     // Catch: Throwable -> L20
        r1.addAction("android.net.wifi.WIFI_STATE_CHANGED");     // Catch: Throwable -> L20
        r1.addAction("android.bluetooth.adapter.action.STATE_CHANGED");     // Catch: Throwable -> L20
        r1.addAction("android.location.MODE_CHANGED");     // Catch: Throwable -> L20
        r1.addAction("android.location.PROVIDERS_CHANGED");     // Catch: Throwable -> L20
    L15:
        e = move-exception;
        a.a(TAG, "failed to register capability receiver", e);     // Catch: Throwable -> L20
    L17:
        requestEvaluation();     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 33) goto L12;
        ZeusTransformUtils.registerReceiver(this.mContext, this.mReceiver, r1, 2, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L15 Throwable -> L20
    L13:
        this.mReceiverRegistered = true;     // Catch: RuntimeException -> L15 Throwable -> L20
    L12:
        ZeusTransformUtils.registerReceiver(this.mContext, this.mReceiver, r1, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L15 Throwable -> L20
        goto L13
    }

    public synchronized void stop() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mStarted = false;     // Catch: Throwable -> L22
        if (this.mReceiverRegistered == true) goto L27;
    L19:
        cancelPendingEnable();     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L27:
        ZeusTransformUtils.unregisterReceiver(this.mContext, this.mReceiver, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12 RuntimeException -> L14
    L16:
        this.mReceiverRegistered = false;     // Catch: Throwable -> L22
    L14:
        e = move-exception;
        a.a(TAG, "failed to unregister capability receiver", e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mReceiverRegistered = false;     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    }
}
