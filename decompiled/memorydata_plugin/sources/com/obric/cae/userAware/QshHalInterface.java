package com.obric.cae.userAware;

import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import vendor.oak.qshhar.HarMonitorParam;
import vendor.oak.qshhar.QshHarRuntimeParamParcel;
import vendor.oak.qshhar.QshHarWifiStandardData;
import vendor.oak.qshhar.b;

/* JADX INFO: loaded from: classes3.dex */
public final class QshHalInterface {
    private static final int CONNECT_MAX_ATTEMPTS = 10;
    private static final int CONNECT_RETRY_DELAY_MS = 1000;
    private static final String LEGACY_SERVICE_NAME = "vendor.oak.qshhar.IQshHarService/default";
    private static final String SENSORS_SERVICE_NAME = "android.hardware.sensors.ISensors/default";
    private static final String TAG = "QshHaInterface";
    private static volatile QshHalInterface sInstance;
    private int mConnectAttempts;
    private final IBinder.DeathRecipient mDeathRecipient;
    private Handler mHandler;
    private final ReentrantReadWriteLock mLock;
    private b mService;
    private final HandlerThread mThread;

    private QshHalInterface() {
        this.mLock = new ReentrantReadWriteLock();
        this.mConnectAttempts = 0;
        this.mDeathRecipient = new $$Lambda$QshHalInterface$x2ISTzDi0H_qjJ34E_oGr4XiTic(this);
        HandlerThread r0 = new HandlerThread(TAG);
        this.mThread = r0;
        r0.start();
        Handler r1 = new Handler(r0.getLooper());
        this.mHandler = r1;
        r1.post(new $$Lambda$QshHalInterface$rlC76Pn9bQA8_EZRwxTYlK8MvaQ(this));
    }

    private void blockingConnect() {
        IBinder r11 = ServiceManager.getService(LEGACY_SERVICE_NAME);     // Catch: Throwable -> L36
        if (r11 == null) goto L7;
        String r3 = "connected via legacy service: vendor.oak.qshhar.IQshHarService/default";
    L6:
        a.e(TAG, r3);     // Catch: Throwable -> L36
        r11.linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L36
        r11 = (IBinder) ZeusTransformUtils.preCheckCast(Binder.class.getMethod("allowBlocking", new Class[]{IBinder.class}).invoke(null, new Object[]{r11}), IBinder.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 NoSuchMethodException -> L29 Throwable -> L36
    L30:
        b r4 = b.a.a(r11);     // Catch: Throwable -> L36
        this.mLock.writeLock().lock();     // Catch: Throwable -> L36
        this.mService = r4;     // Catch: Throwable -> L33
        this.mLock.writeLock().unlock();     // Catch: Throwable -> L36
        this.mConnectAttempts = 0;     // Catch: Throwable -> L36
        a.e(TAG, "service connected");     // Catch: Throwable -> L36
        return;
    L33:
        th = move-exception;
        this.mLock.writeLock().unlock();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L29:
        a.c(TAG, "Binder.allowBlocking not available on this API level");     // Catch: Throwable -> L36
    L27:
        e = move-exception;
        a.a(TAG, "Failed to invoke allowBlocking", e);     // Catch: Throwable -> L36
        goto L30
    L7:
        a.e(TAG, "legacy service not found, waiting for: android.hardware.sensors.ISensors/default");     // Catch: Throwable -> L36
        IBinder r12 = ServiceManager.waitForService(SENSORS_SERVICE_NAME);     // Catch: Throwable -> L36
        if (r12 != null) goto L15;
        int r5 = this.mConnectAttempts;     // Catch: Throwable -> L36
        if (r5 < 10) goto L13;
        a.i(TAG, "waitForService returned null; giving up after " + this.mConnectAttempts + " attempts");     // Catch: Throwable -> L36
        return;
    L13:
        this.mConnectAttempts = r5 + 1;     // Catch: Throwable -> L36
        a.i(TAG, "waitForService returned null; retry " + this.mConnectAttempts + "/10");     // Catch: Throwable -> L36
        this.mHandler.postDelayed(new $$Lambda$QshHalInterface$rlC76Pn9bQA8_EZRwxTYlK8MvaQ(this), 1000);     // Catch: Throwable -> L36
        return;
    L15:
        r11 = getBinderExtension(r12);     // Catch: Throwable -> L36
        if (r11 != null) goto L23;
        int r6 = this.mConnectAttempts;     // Catch: Throwable -> L36
        if (r6 < 10) goto L21;
        a.i(TAG, "sensors HAL extension is null; giving up after " + this.mConnectAttempts + " attempts");     // Catch: Throwable -> L36
        return;
    L21:
        this.mConnectAttempts = r6 + 1;     // Catch: Throwable -> L36
        a.i(TAG, "sensors HAL extension is null; retry " + this.mConnectAttempts + "/10");     // Catch: Throwable -> L36
        this.mHandler.postDelayed(new $$Lambda$QshHalInterface$rlC76Pn9bQA8_EZRwxTYlK8MvaQ(this), 1000);     // Catch: Throwable -> L36
        return;
    L23:
        r3 = "connected via sensors HAL extension: android.hardware.sensors.ISensors/default";
    L36:
        th = move-exception;
        int r7 = this.mConnectAttempts;
        if (r7 < 10) goto L41;
        a.a(TAG, "blockingConnect failed; giving up after " + this.mConnectAttempts + " attempts", th);
        return;
    L41:
        this.mConnectAttempts = r7 + 1;
        a.a(TAG, "blockingConnect failed; retry " + this.mConnectAttempts + "/10", th);
        this.mHandler.postDelayed(new $$Lambda$QshHalInterface$rlC76Pn9bQA8_EZRwxTYlK8MvaQ(this), 1000);
    }

    private static IBinder getBinderExtension(IBinder r8) {
        IBinder r9 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r8, IBinder.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L20;
        return null;
    L20:
        Object r10 = IBinder.class.getMethod("getExtension", new Class[0]).invoke(r9, new Object[0]);     // Catch: Throwable -> L14 NoSuchMethodException -> L18
        if (ZeusTransformUtils.instanceOf(r10, IBinder.class) == true) goto L8;
        if (r10 != null) goto L11;
        String r11 = "null";
    L12:
        a.i(TAG, "IBinder.getExtension returned non-binder: ".concat(r11));     // Catch: Throwable -> L14 NoSuchMethodException -> L18
        return null;
    L11:
        r11 = r10.getClass().getName();     // Catch: Throwable -> L14 NoSuchMethodException -> L18
        goto L12
    L8:
        return (IBinder) ZeusTransformUtils.preCheckCast(r10, IBinder.class, "com.obric.memorydata.plugin");
    L18:
        e = e;
        String r1 = "IBinder.getExtension not available on this API level";
    L16:
        a.a(TAG, r1, e);
        return null;
    L14:
        e = th;
        r1 = "Failed to call IBinder.getExtension";
        goto L16
    }

    public static QshHalInterface getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(QshHalInterface.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new QshHalInterface();     // Catch: Throwable -> L11
    L9:
        monitor-exit(QshHalInterface.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static /* synthetic */ void lambda$rlC76Pn9bQA8_EZRwxTYlK8MvaQ(QshHalInterface r0) {
        r0.blockingConnect();
    }

    private b snapshotService() {
        this.mLock.readLock().lock();
        b r0 = this.mService;     // Catch: Throwable -> L6
        this.mLock.readLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    }

    public void configQshHarWakeupEvent(int[] r4) {
        b r3 = snapshotService();
        if (r3 != null) goto L11;
        a.i(TAG, "configQshHarWakeupEvent: service not connected");
        return;
    L11:
        a.e(TAG, "configQshHarWakeupEvent: " + Arrays.toString(r4));     // Catch: RemoteException -> L8
        r3.a(r4);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        a.a(TAG, "configQshHarWakeupEvent failed", e);
    }

    public void configureHarMonitorParams(HarMonitorParams r5) {
        b r4 = snapshotService();
        if (r4 != null) goto L6;
        a.i(TAG, "sendWifiStandardData: service not connected");
        return;
    L6:
        HarMonitorParam r2 = new HarMonitorParam();
        r2.stateVoteWindowSize = r5.stateVoteWindowSize;
        r2.walkingContinuousThreshold = r5.walkingContinuousThreshold;
        r2.runningContinuousThreshold = r5.runningContinuousThreshold;
        r2.accelOccurrenceThreshold = r5.accelOccurrenceThreshold;
        r2.stationaryOccurrenceThreshold = r5.stationaryOccurrenceThreshold;
        r2.accStateDurationThreshold = r5.accStateDurationThreshold;
        r2.accStateMonitorWindow = r5.accStateMonitorWindow;
        r2.accStateDurationThreshold2 = r5.accStateDurationThreshold2;
        r2.runningStateDurationThreshold = r5.runningStateDurationThreshold;
        r2.runningStateMonitorWindow = r5.runningStateMonitorWindow;
        r2.runningStateDurationThreshold2 = r5.runningStateDurationThreshold2;
        r2.walkingStateMonitorWindow = r5.walkingStateMonitorWindow;
        r2.walkingStateDurationThreshold = r5.walkingStateDurationThreshold;
        r2.walkingStateDurationThreshold2 = r5.walkingStateDurationThreshold2;
        a.e(TAG, "configureHarMonitorParams: " + r5);     // Catch: RemoteException -> L9
        r4.a(r2);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        a.a(TAG, "ConfigureHarMonitorParams failed", e);
    }

    public void configureRuntime(QshHarRuntimeParamParcel r4) {
        if (r4 != null) goto L7;
        String r3 = "configureRuntime: params is null";
    L5:
        a.i(TAG, r3);
        return;
    L7:
        b r5 = snapshotService();
        if (r5 != null) goto L15;
        r3 = "configureRuntime: service not connected";
        goto L5
    L15:
        a.c(TAG, "configureRuntime: " + r4);     // Catch: RemoteException -> L12
        r5.a(r4);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        a.a(TAG, "configureRuntime failed", e);
    }

    public boolean isConnected() {
        this.mLock.readLock().lock();
        if (this.mService == null) goto L6;
        boolean r0 = true;
    L7:
        this.mLock.readLock().unlock();
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    }

    public /* synthetic */ void lambda$new$0$QshHalInterface() {
        a.g(TAG, "Service died; reconnecting");
        this.mLock.writeLock().lock();
        this.mService = null;     // Catch: Throwable -> L6
        this.mLock.writeLock().unlock();
        this.mHandler.post(new $$Lambda$QshHalInterface$rlC76Pn9bQA8_EZRwxTYlK8MvaQ(this));
        return;
    L6:
        th = move-exception;
        this.mLock.writeLock().unlock();
        throw th;
    }

    public void notifyHarEvent(HarEventData r6) {
        b r5 = snapshotService();
        if (r5 != null) goto L6;
        a.i(TAG, "notifyHarEvent: service not connected");
        return;
    L6:
        vendor.oak.qshhar.HarEventData r2 = new vendor.oak.qshhar.HarEventData();
        r2.event = r6.getEvent();
        r2.timestamp = r6.getTimestamp();
        a.e(TAG, "notifyHarEvent: " + r6);     // Catch: RemoteException -> L9
        r5.a(r2);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        a.a(TAG, "NotifyHarEvent failed", e);
    }

    public void sendWifiStandardData(QshHarWifiStandardData r4) {
        b r3 = snapshotService();
        if (r3 != null) goto L11;
        a.i(TAG, "sendWifiStandardData: service not connected");
        return;
    L11:
        a.e(TAG, "sendWifiStandardData: " + r4);     // Catch: RemoteException -> L8
        r3.a(r4);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        a.a(TAG, "sendWifiStandardData failed", e);
    }

    public void shutdown() {
        this.mLock.writeLock().lock();
        b r0 = this.mService;     // Catch: Throwable -> L10
        if (r0 != null) goto L16;
    L8:
        this.mLock.writeLock().unlock();
        this.mThread.quitSafely();
        a.e(TAG, "shutdown complete");
        return;
    L16:
        r0.asBinder().unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L13
    L7:
        this.mService = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mLock.writeLock().unlock();
        throw th;
    }

    public void subscribe(vendor.oak.qshhar.a r4, int r5, int r6, int r7) {
        vendor.oak.qshhar.a r8 = (vendor.oak.qshhar.a) ZeusTransformUtils.wrapperContextForParams(r4, vendor.oak.qshhar.a.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L7;
        String r3 = "subscribe: listener is null";
    L5:
        a.i(TAG, r3);
        return;
    L7:
        b r9 = snapshotService();
        if (r9 != null) goto L15;
        r3 = "subscribe: service not connected";
        goto L5
    L15:
        a.c(TAG, "subscribe: eventType=" + r5 + " motionState=" + r6 + " conf=" + r7);     // Catch: RemoteException -> L12
        r9.a(r8, r5, r6, r7);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        a.a(TAG, "subscribe failed", e);
    }

    public void unsubscribe(vendor.oak.qshhar.a r4, int r5) {
        vendor.oak.qshhar.a r6 = (vendor.oak.qshhar.a) ZeusTransformUtils.wrapperContextForParams(r4, vendor.oak.qshhar.a.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        String r3 = "unsubscribe: listener is null";
    L5:
        a.i(TAG, r3);
        return;
    L7:
        b r7 = snapshotService();
        if (r7 != null) goto L15;
        r3 = "unsubscribe: service not connected";
        goto L5
    L15:
        a.e(TAG, "unsubscribe: motionState=" + r5);     // Catch: RemoteException -> L12
        r7.a(r6, r5);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        a.a(TAG, "unsubscribe failed", e);
    }
}
