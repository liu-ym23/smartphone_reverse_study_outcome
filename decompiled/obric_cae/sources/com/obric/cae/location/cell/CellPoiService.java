package com.obric.cae.location.cell;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import com.bytedance.radioservice.cellpoi.ICellPoiCallback;
import com.bytedance.radioservice.cellpoi.ICellPoiService;
import com.bytedance.radioservice.cellpoi.IHighConfidenceCellPoiCallback;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class CellPoiService {
    private static final long CONNECT_RETRY_INTERVAL_MS = 5000;
    private static final int CONNECT_RETRY_MAX_ATTEMPTS = 3;
    private static final String SERVICE_NAME = "cellpoi_service";
    private static final String TAG = "StarLocation-cellpoiService";
    private static volatile CellPoiService sInstance;
    private IBinder mBinder;
    private final ICellPoiCallback mCellPoiCallback;
    private int mCellPoiClientId;
    private final List<CellPoiListener> mCellPoiListeners;
    private final AtomicBoolean mConnectScheduled;
    private final IBinder.DeathRecipient mDeathRecipient;
    private final ExecutorService mExecutor;
    private final IHighConfidenceCellPoiCallback mHighConfidenceCallback;
    private int mHighConfidenceClientId;
    private final List<HighConfidenceCellPoiListener> mHighConfidenceListeners;
    private final Object mLock;
    private ICellPoiService mService;

    public interface CellPoiListener {
        void onCellPoiStatusChange(int r8, int r10, int r11, long r12, int r13, String r14);
    }

    public interface HighConfidenceCellPoiListener {
        void onHighConfidenceCellPoiStatusChange(int r8, String r10);
    }

    private CellPoiService() {
        this.mLock = new Object();
        this.mConnectScheduled = new AtomicBoolean(false);
        this.mExecutor = Executors.newSingleThreadExecutor();
        this.mCellPoiListeners = new ArrayList();
        this.mHighConfidenceListeners = new ArrayList();
        this.mDeathRecipient = new b(this);
        this.mCellPoiCallback = new AnonymousClass1(this);
        this.mHighConfidenceCallback = new AnonymousClass2(this);
    }

    public static /* synthetic */ void a(CellPoiService r8) {
        r8.lambda$new$0();
    }

    public static /* synthetic */ Object access$000(CellPoiService r8) {
        return r8.mLock;
    }

    public static /* synthetic */ int access$100(CellPoiService r8) {
        return r8.mCellPoiClientId;
    }

    public static /* synthetic */ List access$200(CellPoiService r8) {
        return r8.mCellPoiListeners;
    }

    public static /* synthetic */ int access$300(CellPoiService r8) {
        return r8.mHighConfidenceClientId;
    }

    public static /* synthetic */ List access$400(CellPoiService r8) {
        return r8.mHighConfidenceListeners;
    }

    private boolean attachServiceIfNeeded(IBinder r8, ICellPoiService r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (hasListenersLocked() == true) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L20
        return false;
    L8:
        if (r8 != null) goto L10;
    L16:
        this.mService = r10;     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        return true;
    L10:
        if (this.mBinder == r8) goto L16;
        this.mBinder = r8;     // Catch: Throwable -> L20
        r8.linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CommSenseLog.e(TAG, "ICellPoiService linkToDeath failed", th);     // Catch: Throwable -> L20
        goto L16
    }

    public static /* synthetic */ void b(CellPoiService r8) {
        r8.lambda$ensureService$1();
    }

    private void clearLocked() {
        this.mBinder = null;
        this.mService = null;
        this.mCellPoiClientId = 0;
        this.mHighConfidenceClientId = 0;
    }

    private void connectWithRetry() {
        int r8 = 1;
    L4:
        if (r8 > 3) goto L54;
        Object r10 = this.mLock;
        monitor-enter(r10);
    L51:
        th = move-exception;
        throw th;
    L8:
        if (hasListenersLocked() == false) goto L9;
        if (isServiceReadyLocked() == true) goto L13;
        if (this.mBinder != null) goto L18;
    L20:
        IBinder r11 = this.mBinder;     // Catch: Throwable -> L51
        ICellPoiService r12 = this.mService;     // Catch: Throwable -> L51
        monitor-exit(r10);     // Catch: Throwable -> L51
        if (r12 != null) goto L27;
        r11 = ServiceManager.getService(SERVICE_NAME);
        if (r11 == null) goto L27;
        r12 = ICellPoiService.Stub.H2(r11);
    L27:
        if (r12 != null) goto L31;
        if (r8 >= 3) goto L66;
    L29:
        SystemClock.sleep(5000);
    L66:
        r8 = r8 + 1;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L31:
        if (attachServiceIfNeeded(r11, r12) == false) goto L32;
        registerCallbacksIfNeeded(r12);
        Object r13 = this.mLock;
        monitor-enter(r13);
        if (hasListenersLocked() == false) goto L37;
        if (isServiceReadyLocked() == true) goto L42;
        monitor-exit(r13);     // Catch: Throwable -> L48
        if (r8 >= 3) goto L66;
    L42:
        monitor-exit(r13);     // Catch: Throwable -> L48
        return;
    L37:
        clearLocked();     // Catch: Throwable -> L48
        monitor-exit(r13);     // Catch: Throwable -> L48
        return;
    L32:
        return;
    L18:
        if (isBinderAliveLocked() == true) goto L20;
        clearLocked();     // Catch: Throwable -> L51
        goto L20
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L51
        return;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L51
        return;
    L54:
        Object r14 = this.mLock;
        monitor-enter(r14);
    L61:
        th = move-exception;
        throw th;
    L57:
        if (hasListenersLocked() == false) goto L59;
        CommSenseLog.w(TAG, "ICellPoiService still not available: cellpoi_service");     // Catch: Throwable -> L61
    L59:
        monitor-exit(r14);     // Catch: Throwable -> L61
    }

    private void ensureService() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (hasListenersLocked() == true) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L9:
        if (isServiceReadyLocked() == false) goto L12;
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L12:
        int r10 = 1;
        if (this.mConnectScheduled.compareAndSet(false, true) == true) goto L16;
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L22
        this.mExecutor.execute(new f(this, r10));     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        this.mConnectScheduled.set(false);
        throw th;
    }

    public static CellPoiService getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(CellPoiService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CellPoiService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CellPoiService.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean hasListenersLocked() {
        if (this.mCellPoiListeners.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.mHighConfidenceListeners.isEmpty() == false) goto L8;
        return false;
    }

    private boolean isBinderAliveLocked() {
        IBinder r8 = this.mBinder;
        if (r8 != null) goto L5;
    L9:
        return false;
    L5:
        if (r8.isBinderAlive() == false) goto L9;
        if (this.mBinder.pingBinder() == false) goto L9;
        return true;
    }

    private boolean isServiceReadyLocked() {
        boolean r8 = !this.mCellPoiListeners.isEmpty();
        boolean r10 = !this.mHighConfidenceListeners.isEmpty();
        if (this.mService != null) goto L5;
    L16:
        return false;
    L5:
        if (isBinderAliveLocked() == false) goto L16;
        if (r8 == true) goto L9;
    L11:
        if (r10 == true) goto L13;
    L15:
        return true;
    L13:
        if (this.mHighConfidenceClientId > 0) goto L15;
        return false;
    L9:
        if (this.mCellPoiClientId > 0) goto L11;
        return false;
    }

    private /* synthetic */ void lambda$ensureService$1() {
        connectWithRetry();     // Catch: Throwable -> L6
        this.mConnectScheduled.set(false);
        return;
    L6:
        th = move-exception;
        this.mConnectScheduled.set(false);
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        CommSenseLog.w(TAG, "ICellPoiService binderDied");
        Object r8 = this.mLock;
        monitor-enter(r8);
        clearLocked();     // Catch: Throwable -> L9
        boolean r10 = hasListenersLocked();     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        if (r10 == false) goto L14;
        ensureService();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void registerCallbacksIfNeeded(ICellPoiService r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (hasListenersLocked() == true) goto L7;
    L45:
        monitor-exit(r10);     // Catch: Throwable -> L47
        return;
    L7:
        if (this.mService != r8) goto L45;
        monitor-exit(r10);     // Catch: Throwable -> L47
        if (this.mCellPoiListeners.isEmpty() == true) goto L28;
        if (this.mCellPoiClientId > 0) goto L28;
        int r11 = r8.T(this.mCellPoiCallback);     // Catch: RemoteException -> L25
        Object r12 = this.mLock;     // Catch: RemoteException -> L25
        monitor-enter(r12);     // Catch: RemoteException -> L25
    L22:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L25
    L17:
        if (this.mService != r8) goto L19;
        this.mCellPoiClientId = r11;     // Catch: Throwable -> L22
    L19:
        monitor-exit(r12);     // Catch: Throwable -> L22
        CommSenseLog.i(TAG, "ICellPoiService registerCallback ok, clientId=" + r11);     // Catch: RemoteException -> L25
        goto L28
    L25:
        e = move-exception;
        CommSenseLog.e(TAG, "ICellPoiService registerCallback failed", e);
    L28:
        if (this.mHighConfidenceListeners.isEmpty() == false) goto L30;
        return;
    L30:
        if (this.mHighConfidenceClientId > 0) goto L58;
        int r13 = r8.i1(this.mHighConfidenceCallback);     // Catch: RemoteException -> L42
        Object r14 = this.mLock;     // Catch: RemoteException -> L42
        monitor-enter(r14);     // Catch: RemoteException -> L42
    L39:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L42
    L34:
        if (this.mService != r8) goto L36;
        this.mHighConfidenceClientId = r13;     // Catch: Throwable -> L39
    L36:
        monitor-exit(r14);     // Catch: Throwable -> L39
        CommSenseLog.i(TAG, "ICellPoiService registerHighConfidenceCallback ok, clientId=" + r13);     // Catch: RemoteException -> L42
        return;
    L42:
        e = move-exception;
        CommSenseLog.e(TAG, "ICellPoiService registerHighConfidenceCallback failed", e);
        return;
    }

    private void releaseIfIdle() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (hasListenersLocked() == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L8:
        IBinder r10 = this.mBinder;     // Catch: Throwable -> L13
        clearLocked();     // Catch: Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        if (r10 == null) goto L20;
        r10.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    }

    public void addCellPoiListener(CellPoiListener r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCellPoiListeners.contains(r8) == true) goto L7;
        this.mCellPoiListeners.add(r8);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L10
        ensureService();
    }

    public void addHighConfidenceCellPoiListener(HighConfidenceCellPoiListener r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mHighConfidenceListeners.contains(r8) == true) goto L7;
        this.mHighConfidenceListeners.add(r8);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L10
        ensureService();
    }

    public void removeCellPoiListener(CellPoiListener r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mCellPoiListeners.remove(r8);     // Catch: Throwable -> L18
        if (this.mCellPoiListeners.isEmpty() == true) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L8:
        ICellPoiService r11 = this.mService;     // Catch: Throwable -> L18
        int r12 = this.mCellPoiClientId;     // Catch: Throwable -> L18
        this.mCellPoiClientId = 0;     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        if (r11 == null) goto L16;
        if (r12 <= 0) goto L16;
        r11.c(r12);     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        CommSenseLog.e(TAG, "ICellPoiService unregisterCallback failed", e);
    L16:
        releaseIfIdle();
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void removeHighConfidenceCellPoiListener(HighConfidenceCellPoiListener r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mHighConfidenceListeners.remove(r8);     // Catch: Throwable -> L18
        if (this.mHighConfidenceListeners.isEmpty() == true) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L8:
        ICellPoiService r11 = this.mService;     // Catch: Throwable -> L18
        int r12 = this.mHighConfidenceClientId;     // Catch: Throwable -> L18
        this.mHighConfidenceClientId = 0;     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        if (r11 == null) goto L16;
        if (r12 <= 0) goto L16;
        r11.I(r12);     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        CommSenseLog.e(TAG, "ICellPoiService unregisterHighConfidenceCallback failed", e);
    L16:
        releaseIfIdle();
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
