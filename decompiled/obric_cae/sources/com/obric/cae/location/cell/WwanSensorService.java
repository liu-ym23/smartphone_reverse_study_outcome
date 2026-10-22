package com.obric.cae.location.cell;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import com.obric.cae.log.CommSenseLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import vendor.bytedance.wwansensor.ISensorNotify;
import vendor.bytedance.wwansensor.ISensorNotifyCallback;

/* JADX INFO: loaded from: classes.dex */
final class WwanSensorService {
    private static final long CONNECT_RETRY_INTERVAL_MS = 5000;
    private static final int CONNECT_RETRY_MAX_ATTEMPTS = 3;
    private static final int DB_TYPE_STORE = 2;
    private static final String SERVICE_NAME = "vendor.bytedance.wwansensor.ISensorNotify/default";
    private static final String TAG = "StarLocation-wwansensor";
    private IBinder mBinder;
    private final ISensorNotifyCallback mCallback;
    private final CellPoiCallback mCellPoiCallback;
    private int mClientId;
    private final AtomicBoolean mConnectScheduled;
    private final IBinder.DeathRecipient mDeathRecipient;
    private boolean mEnabled;
    private ExecutorService mExecutor;
    private final Object mLock;
    private ISensorNotify mService;

    public interface CellPoiCallback {
        void onCellPoiStatusChange(int r8, int r10, int r11, int r12, long r13, int r14);
    }

    public WwanSensorService(CellPoiCallback r8) {
        this.mLock = new Object();
        this.mConnectScheduled = new AtomicBoolean(false);
        this.mDeathRecipient = new e(this);
        this.mCallback = new AnonymousClass1(this);
        this.mCellPoiCallback = r8;
    }

    public static /* synthetic */ void a(WwanSensorService r8) {
        r8.lambda$new$0();
    }

    public static /* synthetic */ CellPoiCallback access$000(WwanSensorService r8) {
        return r8.mCellPoiCallback;
    }

    public static /* synthetic */ void b(WwanSensorService r8) {
        r8.lambda$ensureService$1();
    }

    private void clearLocked() {
        this.mBinder = null;
        this.mService = null;
        this.mClientId = 0;
    }

    private void connectServiceWithRetry() {
        int r8 = 1;
    L4:
        if (r8 > 3) goto L66;
        Object r10 = this.mLock;
        monitor-enter(r10);
    L63:
        th = move-exception;
        throw th;
    L8:
        if (this.mEnabled == false) goto L9;
        if (isConnectedLocked() == true) goto L13;
        if (this.mBinder != null) goto L18;
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L63
        IBinder r11 = ServiceManager.getService(SERVICE_NAME);
        if (r11 != null) goto L25;
        if (r8 >= 3) goto L78;
    L24:
        SystemClock.sleep(5000);
    L78:
        r8 = r8 + 1;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    L25:
        Object r12 = this.mLock;
        monitor-enter(r12);
        if (this.mEnabled == false) goto L29;
        if (isConnectedLocked() == true) goto L33;
        this.mBinder = r11;     // Catch: Throwable -> L60
        r11.linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L39
    L41:
        ISensorNotify r13 = ISensorNotify.Stub.H2(this.mBinder);     // Catch: Throwable -> L60
        this.mService = r13;     // Catch: Throwable -> L60
        if (r13 != null) goto L76;
        CommSenseLog.w(TAG, "ISensorNotify service is null");     // Catch: Throwable -> L60
    L44:
        clearLocked();     // Catch: Throwable -> L60
        monitor-exit(r12);     // Catch: Throwable -> L60
        if (r8 >= 3) goto L78;
    L76:
        this.mClientId = r13.z0(this.mCallback);     // Catch: RemoteException -> L54 Throwable -> L60
        CommSenseLog.i(TAG, "ISensorNotify connected, clientId=" + this.mClientId);     // Catch: RemoteException -> L54 Throwable -> L60
        int r14 = this.mClientId;     // Catch: RemoteException -> L54 Throwable -> L60
        if (r14 <= 0) goto L44;
        this.mService.X0(r14, true, 0, 2);     // Catch: RemoteException -> L50 Throwable -> L60
        CommSenseLog.i(TAG, "ISensorNotify startOemSensor enable store, clientId=" + this.mClientId + ", dbType=2");     // Catch: RemoteException -> L50 Throwable -> L60
    L52:
        monitor-exit(r12);     // Catch: Throwable -> L60
        return;
    L50:
        e = move-exception;
        CommSenseLog.e(TAG, "ISensorNotify startOemSensor failed", e);     // Catch: RemoteException -> L54 Throwable -> L60
    L54:
        e = move-exception;
        CommSenseLog.e(TAG, "ISensorNotify registerCallback failed", e);     // Catch: Throwable -> L60
        goto L44
    L39:
        th = move-exception;
        CommSenseLog.e(TAG, "ISensorNotify linkToDeath failed", th);     // Catch: Throwable -> L60
        goto L41
    L33:
        monitor-exit(r12);     // Catch: Throwable -> L60
        return;
    L29:
        monitor-exit(r12);     // Catch: Throwable -> L60
        return;
    L18:
        if (isServiceAliveLocked() == true) goto L20;
        clearLocked();     // Catch: Throwable -> L63
        goto L20
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L63
        return;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L63
        return;
    L66:
        Object r15 = this.mLock;
        monitor-enter(r15);
    L73:
        th = move-exception;
        throw th;
    L69:
        if (this.mEnabled == false) goto L71;
        CommSenseLog.w(TAG, "ISensorNotify still not available: vendor.bytedance.wwansensor.ISensorNotify/default");     // Catch: Throwable -> L73
    L71:
        monitor-exit(r15);     // Catch: Throwable -> L73
    }

    private void ensureService() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L26
        return;
    L9:
        if (isConnectedLocked() == false) goto L12;
        monitor-exit(r8);     // Catch: Throwable -> L26
        return;
    L12:
        int r10 = 0;
        if (this.mConnectScheduled.compareAndSet(false, true) == true) goto L17;
        monitor-exit(r8);     // Catch: Throwable -> L26
        return;
    L17:
        if (this.mExecutor != null) goto L19;
        this.mExecutor = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L26
    L19:
        ExecutorService r11 = this.mExecutor;     // Catch: Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
        r11.execute(new f(this, r10));     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        this.mConnectScheduled.set(false);
        throw th;
    }

    private boolean isConnectedLocked() {
        if (this.mService != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mClientId <= 0) goto L9;
        if (isServiceAliveLocked() == false) goto L9;
        return true;
    }

    private boolean isServiceAliveLocked() {
        IBinder r8 = this.mBinder;
        if (r8 != null) goto L5;
    L9:
        return false;
    L5:
        if (r8.isBinderAlive() == false) goto L9;
        if (this.mBinder.pingBinder() == false) goto L9;
        return true;
    }

    private /* synthetic */ void lambda$ensureService$1() {
        connectServiceWithRetry();     // Catch: Throwable -> L6
        this.mConnectScheduled.set(false);
        return;
    L6:
        th = move-exception;
        this.mConnectScheduled.set(false);
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        CommSenseLog.w(TAG, "ISensorNotify binder died");
        Object r8 = this.mLock;
        monitor-enter(r8);
        clearLocked();     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        ensureService();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void releaseLocked() {
        ISensorNotify r8 = this.mService;
        if (r8 == null) goto L10;
        int r10 = this.mClientId;
        if (r10 <= 0) goto L10;
        r8.c(r10);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "ISensorNotify unregisterCallback failed", e);
    L10:
        IBinder r11 = this.mBinder;
        if (r11 != null) goto L18;
    L13:
        clearLocked();
        return;
    L18:
        r11.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L15
        goto L13
    }

    public void destroy() {
        stop();
        Object r8 = this.mLock;
        monitor-enter(r8);
        ExecutorService r10 = this.mExecutor;     // Catch: Throwable -> L9
        this.mExecutor = null;     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        if (r10 == null) goto L14;
        r10.shutdownNow();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void notifyDbUpdate(int r8, int r10, int r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        ISensorNotify r13 = this.mService;     // Catch: Throwable -> L14
        int r14 = this.mClientId;     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        if (r13 == null) goto L21;
        if (r14 <= 0) goto L22;
        r13.I0(r14, r8, r10, r11);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        CommSenseLog.e(TAG, "notifyDbUpdate failed", e);
        return;
    L22:
        return;
    L21:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void start() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mEnabled = true;     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        ensureService();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void startOemSensor(int r8, int r10, boolean r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        ISensorNotify r13 = this.mService;     // Catch: Throwable -> L14
        int r14 = this.mClientId;     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        if (r13 == null) goto L21;
        if (r14 <= 0) goto L22;
        r13.X0(r14, r11, r8, r10);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        CommSenseLog.e(TAG, "startOemSensor failed", e);
        return;
    L22:
        return;
    L21:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void stop() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mEnabled = false;     // Catch: Throwable -> L8
        releaseLocked();     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
