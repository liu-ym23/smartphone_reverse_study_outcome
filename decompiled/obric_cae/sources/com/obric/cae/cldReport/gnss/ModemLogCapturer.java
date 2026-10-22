package com.obric.cae.cldReport.gnss;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.obric.cae.log.CaeLog;
import defpackage.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import vendor.bytedance.modemcap.IModemCapture;
import vendor.bytedance.modemcap.IModemCaptureResponse;

/* JADX INFO: loaded from: classes.dex */
public class ModemLogCapturer {
    private static final String GNSS_CFG_FILE = "vendor/etc/diag_gps.cfg";
    private static final String MODEM_CAPTURE_SERVICE = "vendor.bytedance.modemcap.IModemCapture/default";
    private static final String TAG = "StarLocation-ModemLogCapturer";
    private static final int WAIT_FOR_CALLBACK_TIMEOUT_MS = 30000;
    private static ModemLogCapturer sInstance;
    private final IBinder.DeathRecipient mDeathRecipient;
    private IModemCapture mModemCapture;
    private int mModemCaptureClientId;
    private final ModemLogCallback mModemLogCallback;

    public static class ModemLogCallback extends IModemCaptureResponse.Stub {
        private CountDownLatch startDiagMdlogCountDownLatch;
        private final AtomicBoolean startDiagMdlogResult;
        private CountDownLatch stopDiagMdlogCountDownLatch;
        private final AtomicBoolean stopDiagMdlogResult;

        private ModemLogCallback() {
            this.startDiagMdlogCountDownLatch = null;
            this.stopDiagMdlogCountDownLatch = null;
            this.startDiagMdlogResult = new AtomicBoolean(false);
            this.stopDiagMdlogResult = new AtomicBoolean(false);
        }

        public void countDownAll() {
            monitor-enter(this);
            CountDownLatch r8 = this.startDiagMdlogCountDownLatch;     // Catch: Throwable -> L11
            if (r8 == null) goto L6;
            r8.countDown();     // Catch: Throwable -> L11
        L6:
            CountDownLatch r10 = this.stopDiagMdlogCountDownLatch;     // Catch: Throwable -> L11
            if (r10 == null) goto L9;
            r10.countDown();     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public String getInterfaceHash() {
            return "9fb5b491d237e48f111a4d9703b93bc706fb6bdc";
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public int getInterfaceVersion() {
            return 1;
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public void onGetDiagBufferLog(int r8) {
            a.i("modemLogCallback - onGetDiagBufferLog: ", r8, ModemLogCapturer.TAG);
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public void onGetDiagMdlogStatus(int r8, int r10) {
            CaeLog.i(ModemLogCapturer.TAG, "modemLogCallback - onGetDiagMdlogStatus: " + r8 + ", " + r10);
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public void onRegisterCallback(int r8) {
            a.i("modemLogCallback - onRegisterCallback: ", r8, ModemLogCapturer.TAG);
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public void onStartDiagMdlog(int r8) {
            a.i("modemLogCallback - onStartDiagMdlog: ", r8, ModemLogCapturer.TAG);
            AtomicBoolean r10 = this.startDiagMdlogResult;
            boolean r11 = true;
            if (r8 == 1) goto L6;
            r11 = false;
        L6:
            r10.set(r11);
            monitor-enter(this);
            CountDownLatch r12 = this.startDiagMdlogCountDownLatch;     // Catch: Throwable -> L13
            if (r12 == null) goto L11;
            r12.countDown();     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public void onStopDiagMdlog(int r8) {
            a.i("modemLogCallback - onStopDiagMdlog: ", r8, ModemLogCapturer.TAG);
            AtomicBoolean r10 = this.stopDiagMdlogResult;
            boolean r11 = true;
            if (r8 == 1) goto L6;
            r11 = false;
        L6:
            r10.set(r11);
            monitor-enter(this);
            CountDownLatch r12 = this.stopDiagMdlogCountDownLatch;     // Catch: Throwable -> L13
            if (r12 == null) goto L11;
            r12.countDown();     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // vendor.bytedance.modemcap.IModemCaptureResponse
        public void onUnregisterCallback(int r8) {
            a.i("modemLogCallback - onUnregisterCallback: ", r8, ModemLogCapturer.TAG);
        }

        public void setAllResultToFalse() {
            this.startDiagMdlogResult.set(false);
            this.stopDiagMdlogResult.set(false);
        }

        public boolean waitForStartDiagMdlog() {
            CaeLog.i(ModemLogCapturer.TAG, "modemLogCallback - waitForStartDiagMdlog");
            CountDownLatch r8 = new CountDownLatch(1);
            monitor-enter(this);
            this.startDiagMdlogCountDownLatch = r8;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
        L13:
            CaeLog.e(ModemLogCapturer.TAG, "modemLogCallback - onStartDiagMdlog interrupted");
            return false;
        L8:
            if (r8.await(30000, TimeUnit.MILLISECONDS) == true) goto L12;
            CaeLog.e(ModemLogCapturer.TAG, "modemLogCallback - onStartDiagMdlog timeout");     // Catch: InterruptedException -> L13
            return false;
        L12:
            return this.startDiagMdlogResult.get();
        L15:
            th = move-exception;
            throw th;
        }

        public boolean waitForStopDiagMdlog() {
            CaeLog.i(ModemLogCapturer.TAG, "modemLogCallback - waitForStopDiagMdlog");
            CountDownLatch r8 = new CountDownLatch(1);
            monitor-enter(this);
            this.stopDiagMdlogCountDownLatch = r8;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
        L13:
            CaeLog.e(ModemLogCapturer.TAG, "modemLogCallback - onStopDiagMdlog interrupted");
            return false;
        L8:
            if (r8.await(30000, TimeUnit.MILLISECONDS) == true) goto L12;
            CaeLog.e(ModemLogCapturer.TAG, "modemLogCallback - onStopDiagMdlog timeout");     // Catch: InterruptedException -> L13
            return false;
        L12:
            return this.stopDiagMdlogResult.get();
        L15:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ ModemLogCallback(AnonymousClass1 r8) {
            this();
        }
    }

    public ModemLogCapturer() {
        this.mModemCaptureClientId = -1;
        this.mModemLogCallback = new ModemLogCallback(null);
        this.mDeathRecipient = new AnonymousClass1(this);
    }

    public static /* synthetic */ IModemCapture access$102(ModemLogCapturer r8, IModemCapture r10) {
        r8.mModemCapture = r10;
        return r10;
    }

    public static /* synthetic */ int access$202(ModemLogCapturer r8, int r10) {
        r8.mModemCaptureClientId = r10;
        return r10;
    }

    public static /* synthetic */ ModemLogCallback access$300(ModemLogCapturer r8) {
        return r8.mModemLogCallback;
    }

    private void destoryService() {
        CaeLog.i(TAG, "destoryService Start");
        IModemCapture r8 = this.mModemCapture;
        if (r8 != null) goto L15;
        CaeLog.i(TAG, "destoryService, mModemCapture Already destroyed");
        return;
    L15:
        r8.v(this.mModemLogCallback);     // Catch: RemoteException -> L8
    L9:
        IModemCapture r10 = this.mModemCapture;
        if (r10 != null) goto L13;
        CaeLog.i(TAG, "destoryService, mModemCapture Already destroyed");
        return;
    L13:
        r10.asBinder().unlinkToDeath(this.mDeathRecipient, 0);
        this.mModemCapture = null;
        this.mModemCaptureClientId = -1;
        CaeLog.i(TAG, "destoryService success");
        return;
    L8:
        CaeLog.e(TAG, "destoryService, Failed to unregister callback");
        goto L9
    }

    public static synchronized ModemLogCapturer getInstance() {
        monitor-enter(ModemLogCapturer.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new ModemLogCapturer();     // Catch: Throwable -> L10
    L7:
        ModemLogCapturer r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(ModemLogCapturer.class);
        return r8;
    }

    private boolean initService() {
        CaeLog.i(TAG, "initService Start");
        if (this.mModemCapture == null) goto L6;
        CaeLog.i(TAG, "initService, mModemCapture Already initialized");
        return true;
    L6:
        IBinder r8 = ServiceManager.getService(MODEM_CAPTURE_SERVICE);
        IModemCapture r10 = IModemCapture.Stub.H2(r8);
        this.mModemCapture = r10;
        if (r10 != null) goto L20;
        String r11 = "initService, Failed to find modem capture aidl service";
    L9:
        CaeLog.e(TAG, r11);
        return false;
    L20:
        r8.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L19
        int r12 = this.mModemCapture.t0("com.obric.cae", this.mModemLogCallback);     // Catch: RemoteException -> L18
        this.mModemCaptureClientId = r12;     // Catch: RemoteException -> L18
        if (r12 != (-1)) goto L15;
        CaeLog.e(TAG, "ModemCapture service registerCallback failed: mModemCaptureClientId is -1");     // Catch: RemoteException -> L18
    L16:
        CaeLog.i(TAG, "initService success");     // Catch: RemoteException -> L18
        return true;
    L15:
        CaeLog.d(TAG, "ModemCapture service registerCallback successed with id: " + this.mModemCaptureClientId);     // Catch: RemoteException -> L18
    L18:
        r11 = "initService, Failed to register callback";
    L19:
        r11 = "initService, Failed to link to death";
        goto L9
    }

    public synchronized boolean startModemLog(int r10, int r11, int r12) {
        monitor-enter(this);
        CaeLog.i(TAG, "startModemLog Start, n: " + r10 + ", s: " + r11 + ", min: " + r12);     // Catch: Throwable -> L27
        if (initService() == true) goto L9;
        CaeLog.e(TAG, "startModemLog, failed to init service");     // Catch: Throwable -> L27
        destoryService();     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L9:
        IModemCapture r8 = this.mModemCapture;     // Catch: Throwable -> L27
        if (r8 != null) goto L30;
        CaeLog.e(TAG, "startModemLog, mModemCapture is null");     // Catch: Throwable -> L27
        destoryService();     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L30:
        r8.J1(GNSS_CFG_FILE, r10, r11, r12, this.mModemCaptureClientId);     // Catch: RemoteException -> L24 Throwable -> L27
    L16:
        if (this.mModemLogCallback.waitForStartDiagMdlog() == true) goto L20;
        CaeLog.e(TAG, "startModemLog, Failed to wait for startDiagMdlog");     // Catch: Throwable -> L27
        destoryService();     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L20:
        CaeLog.i(TAG, "startModemLog success");     // Catch: Throwable -> L27
        monitor-exit(this);
        return true;
    L24:
        CaeLog.e(TAG, "startModemLog, Failed to call startDiagMdlog");     // Catch: Throwable -> L27
        destoryService();     // Catch: Throwable -> L27
        return false;
    L27:
        th = move-exception;
        throw th;
    }

    public synchronized boolean stopModemLog() {
        monitor-enter(this);
        CaeLog.i(TAG, "stopModemLog Start");     // Catch: Throwable -> L26
        if (initService() == true) goto L8;
        CaeLog.e(TAG, "stopModemLog, failed to init service");     // Catch: Throwable -> L26
        destoryService();     // Catch: Throwable -> L26
        monitor-exit(this);
        return false;
    L8:
        IModemCapture r8 = this.mModemCapture;     // Catch: Throwable -> L26
        if (r8 != null) goto L29;
        CaeLog.e(TAG, "stopModemLog, mModemCapture is null");     // Catch: Throwable -> L26
        destoryService();     // Catch: Throwable -> L26
        monitor-exit(this);
        return false;
    L29:
        r8.y2(this.mModemCaptureClientId);     // Catch: RemoteException -> L23 Throwable -> L26
    L15:
        if (this.mModemLogCallback.waitForStopDiagMdlog() == true) goto L19;
        CaeLog.e(TAG, "stopModemLog, Failed to wait for stopDiagMdlog");     // Catch: Throwable -> L26
        destoryService();     // Catch: Throwable -> L26
        monitor-exit(this);
        return false;
    L19:
        CaeLog.i(TAG, "stopModemLog success");     // Catch: Throwable -> L26
        monitor-exit(this);
        return true;
    L23:
        CaeLog.e(TAG, "stopModemLog, Failed to call stopDiagMdlog");     // Catch: Throwable -> L26
        destoryService();     // Catch: Throwable -> L26
        return false;
    L26:
        th = move-exception;
        throw th;
    }
}
