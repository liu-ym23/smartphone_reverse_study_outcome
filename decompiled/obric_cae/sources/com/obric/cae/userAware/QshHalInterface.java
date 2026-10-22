package com.obric.cae.userAware;

import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.log.CommSenseLog;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import vendor.oak.qshhar.HarMonitorParam;
import vendor.oak.qshhar.IQshHarEventListener;
import vendor.oak.qshhar.IQshHarService;
import vendor.oak.qshhar.QshHarRuntimeParamParcel;
import vendor.oak.qshhar.QshHarWifiStandardData;

/* JADX INFO: loaded from: classes2.dex */
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
    private IQshHarService mService;
    private final HandlerThread mThread;

    private QshHalInterface() {
        this.mLock = new ReentrantReadWriteLock();
        this.mConnectAttempts = 0;
        this.mDeathRecipient = new j(this);
        HandlerThread r8 = new HandlerThread(TAG);
        this.mThread = r8;
        r8.start();
        Handler r10 = new Handler(r8.getLooper());
        this.mHandler = r10;
        r10.post(new i(this, 1));
    }

    public static /* synthetic */ void a(QshHalInterface r8) {
        r8.blockingConnect();
    }

    public static /* synthetic */ void b(QshHalInterface r8) {
        r8.lambda$new$0();
    }

    private void blockingConnect() {
        int r10 = 0;
        int r11 = 1;
        IBinder r12 = ServiceManager.getService(LEGACY_SERVICE_NAME);     // Catch: Throwable -> L36
        if (r12 == null) goto L7;
        String r8 = "connected via legacy service: vendor.oak.qshhar.IQshHarService/default";
    L6:
        CommSenseLog.i(TAG, r8);     // Catch: Throwable -> L36
        r12.linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L36
        r12 = (IBinder) Binder.class.getMethod("allowBlocking", new Class[]{IBinder.class}).invoke(null, new Object[]{r12});     // Catch: Exception -> L27 NoSuchMethodException -> L29 Throwable -> L36
    L30:
        IQshHarService r13 = IQshHarService.Stub.H2(r12);     // Catch: Throwable -> L36
        this.mLock.writeLock().lock();     // Catch: Throwable -> L36
        this.mService = r13;     // Catch: Throwable -> L33
        this.mLock.writeLock().unlock();     // Catch: Throwable -> L36
        this.mConnectAttempts = 0;     // Catch: Throwable -> L36
        CommSenseLog.i(TAG, "service connected");     // Catch: Throwable -> L36
        return;
    L33:
        th = move-exception;
        this.mLock.writeLock().unlock();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L29:
        CommSenseLog.d(TAG, "Binder.allowBlocking not available on this API level");     // Catch: Throwable -> L36
    L27:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to invoke allowBlocking", e);     // Catch: Throwable -> L36
        goto L30
    L7:
        CommSenseLog.i(TAG, "legacy service not found, waiting for: android.hardware.sensors.ISensors/default");     // Catch: Throwable -> L36
        IBinder r14 = ServiceManager.waitForService(SENSORS_SERVICE_NAME);     // Catch: Throwable -> L36
        if (r14 != null) goto L15;
        int r15 = this.mConnectAttempts;     // Catch: Throwable -> L36
        if (r15 < 10) goto L13;
        CommSenseLog.e(TAG, "waitForService returned null; giving up after " + this.mConnectAttempts + " attempts");     // Catch: Throwable -> L36
        return;
    L13:
        this.mConnectAttempts = r15 + 1;     // Catch: Throwable -> L36
        CommSenseLog.e(TAG, "waitForService returned null; retry " + this.mConnectAttempts + "/10");     // Catch: Throwable -> L36
        this.mHandler.postDelayed(new b(this, r11), 1000);     // Catch: Throwable -> L36
        return;
    L15:
        r12 = getBinderExtension(r14);     // Catch: Throwable -> L36
        if (r12 != null) goto L23;
        int r16 = this.mConnectAttempts;     // Catch: Throwable -> L36
        if (r16 < 10) goto L21;
        CommSenseLog.e(TAG, "sensors HAL extension is null; giving up after " + this.mConnectAttempts + " attempts");     // Catch: Throwable -> L36
        return;
    L21:
        this.mConnectAttempts = r16 + 1;     // Catch: Throwable -> L36
        CommSenseLog.e(TAG, "sensors HAL extension is null; retry " + this.mConnectAttempts + "/10");     // Catch: Throwable -> L36
        this.mHandler.postDelayed(new i(this, r10), 1000);     // Catch: Throwable -> L36
        return;
    L23:
        r8 = "connected via sensors HAL extension: android.hardware.sensors.ISensors/default";
    L36:
        th = move-exception;
        int r17 = this.mConnectAttempts;
        if (r17 < 10) goto L41;
        CommSenseLog.e(TAG, "blockingConnect failed; giving up after " + this.mConnectAttempts + " attempts", th);
        return;
    L41:
        this.mConnectAttempts = r17 + 1;
        CommSenseLog.e(TAG, "blockingConnect failed; retry " + this.mConnectAttempts + "/10", th);
        this.mHandler.postDelayed(new i(this, r10), 1000);
    }

    private static IBinder getBinderExtension(IBinder r8) {
        if (r8 != null) goto L21;
        return null;
    L21:
        Object r10 = IBinder.class.getMethod("getExtension", new Class[0]).invoke(r8, new Object[0]);     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        if ((r10 instanceof IBinder) == false) goto L10;
        return (IBinder) r10;
    L10:
        if (r10 != null) goto L12;
        String r11 = "null";
    L13:
        CommSenseLog.e(TAG, "IBinder.getExtension returned non-binder: ".concat(r11));     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        return null;
    L12:
        r11 = r10.getClass().getName();     // Catch: Throwable -> L15 NoSuchMethodException -> L19
    L19:
        e = e;
        String r12 = "IBinder.getExtension not available on this API level";
    L17:
        CommSenseLog.e(TAG, r12, e);
        return null;
    L15:
        e = th;
        r12 = "Failed to call IBinder.getExtension";
        goto L17
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

    private /* synthetic */ void lambda$new$0() {
        CommSenseLog.w(TAG, "Service died; reconnecting");
        this.mLock.writeLock().lock();
        this.mService = null;     // Catch: Throwable -> L6
        this.mLock.writeLock().unlock();
        this.mHandler.post(new i(this, 1));
        return;
    L6:
        th = move-exception;
        this.mLock.writeLock().unlock();
        throw th;
    }

    private IQshHarService snapshotService() {
        this.mLock.readLock().lock();
        IQshHarService r8 = this.mService;     // Catch: Throwable -> L6
        this.mLock.readLock().unlock();
        return r8;
    L6:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    }

    public void configQshHarWakeupEvent(@ApWakeEvent int[] r8) {
        IQshHarService r10 = snapshotService();
        if (r10 != null) goto L11;
        CommSenseLog.e(TAG, "configQshHarWakeupEvent: service not connected");
        return;
    L11:
        CommSenseLog.i(TAG, "configQshHarWakeupEvent: " + Arrays.toString(r8));     // Catch: RemoteException -> L8
        r10.g1(r8);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "configQshHarWakeupEvent failed", e);
    }

    public void configureHarMonitorParams(HarMonitorParams r8) {
        IQshHarService r10 = snapshotService();
        if (r10 != null) goto L6;
        CommSenseLog.e(TAG, "sendWifiStandardData: service not connected");
        return;
    L6:
        HarMonitorParam r11 = new HarMonitorParam();
        r11.f12908a = r8.stateVoteWindowSize;
        r11.f12909b = r8.walkingContinuousThreshold;
        r11.f12910m = r8.runningContinuousThreshold;
        r11.f12911n = r8.accelOccurrenceThreshold;
        r11.f12912o = r8.stationaryOccurrenceThreshold;
        r11.f12913p = r8.accStateDurationThreshold;
        r11.f12914q = r8.accStateMonitorWindow;
        r11.f12915r = r8.accStateDurationThreshold2;
        r11.f12916s = r8.runningStateDurationThreshold;
        r11.f12917t = r8.runningStateMonitorWindow;
        r11.f12918u = r8.runningStateDurationThreshold2;
        r11.f12919v = r8.walkingStateMonitorWindow;
        r11.f12920w = r8.walkingStateDurationThreshold;
        r11.f12921x = r8.walkingStateDurationThreshold2;
        CommSenseLog.i(TAG, "configureHarMonitorParams: " + r8);     // Catch: RemoteException -> L9
        r10.w(r11);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "ConfigureHarMonitorParams failed", e);
    }

    public void configureRuntime(QshHarRuntimeParamParcel r8) {
        if (r8 != null) goto L7;
        String r10 = "configureRuntime: params is null";
    L5:
        CommSenseLog.e(TAG, r10);
        return;
    L7:
        IQshHarService r11 = snapshotService();
        if (r11 != null) goto L15;
        r10 = "configureRuntime: service not connected";
        goto L5
    L15:
        CommSenseLog.d(TAG, "configureRuntime: " + r8);     // Catch: RemoteException -> L12
        r11.m1(r8);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "configureRuntime failed", e);
    }

    public boolean isConnected() {
        this.mLock.readLock().lock();
        if (this.mService == null) goto L6;
        boolean r8 = true;
    L7:
        this.mLock.readLock().unlock();
        return r8;
    L6:
        r8 = false;
    L9:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    }

    public void notifyHarEvent(HarEventData r8) {
        IQshHarService r10 = snapshotService();
        if (r10 != null) goto L6;
        CommSenseLog.e(TAG, "notifyHarEvent: service not connected");
        return;
    L6:
        vendor.oak.qshhar.HarEventData r11 = new vendor.oak.qshhar.HarEventData();
        r11.f12906a = r8.getEvent();
        r11.f12907b = r8.getTimestamp();
        CommSenseLog.i(TAG, "notifyHarEvent: " + r8);     // Catch: RemoteException -> L9
        r10.c1(r11);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "NotifyHarEvent failed", e);
    }

    public void sendWifiStandardData(QshHarWifiStandardData r8) {
        IQshHarService r10 = snapshotService();
        if (r10 != null) goto L11;
        CommSenseLog.e(TAG, "sendWifiStandardData: service not connected");
        return;
    L11:
        CommSenseLog.i(TAG, "sendWifiStandardData: " + r8);     // Catch: RemoteException -> L8
        r10.Q1(r8);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "sendWifiStandardData failed", e);
    }

    public void shutdown() {
        this.mLock.writeLock().lock();
        IQshHarService r8 = this.mService;     // Catch: Throwable -> L10
        if (r8 != null) goto L16;
    L8:
        this.mLock.writeLock().unlock();
        this.mThread.quitSafely();
        CommSenseLog.i(TAG, "shutdown complete");
        return;
    L16:
        r8.asBinder().unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L13
    L7:
        this.mService = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mLock.writeLock().unlock();
        throw th;
    }

    public void subscribe(IQshHarEventListener r8, int r10, int r11, int r12) {
        if (r8 != null) goto L7;
        String r13 = "subscribe: listener is null";
    L5:
        CommSenseLog.e(TAG, r13);
        return;
    L7:
        IQshHarService r14 = snapshotService();
        if (r14 != null) goto L15;
        r13 = "subscribe: service not connected";
        goto L5
    L15:
        CommSenseLog.d(TAG, "subscribe: eventType=" + r10 + " motionState=" + r11 + " conf=" + r12);     // Catch: RemoteException -> L12
        r14.L1(r8, r10, r11, r12);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "subscribe failed", e);
    }

    public void unsubscribe(IQshHarEventListener r8, int r10) {
        if (r8 != null) goto L7;
        String r11 = "unsubscribe: listener is null";
    L5:
        CommSenseLog.e(TAG, r11);
        return;
    L7:
        IQshHarService r12 = snapshotService();
        if (r12 != null) goto L15;
        r11 = "unsubscribe: service not connected";
        goto L5
    L15:
        CommSenseLog.i(TAG, "unsubscribe: motionState=" + r10);     // Catch: RemoteException -> L12
        r12.M1(r8, r10);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        CommSenseLog.e(TAG, "unsubscribe failed", e);
    }
}
