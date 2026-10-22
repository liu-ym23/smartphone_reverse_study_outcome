package com.obric.cae.smartNfc;

import android.aimedia.a;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.ServiceManager;
import com.obric.cae.libs.nfc.CaeNfcConstants;
import com.obric.cae.log.CaeLog;
import com.obric.cae.softap.c;

/* JADX INFO: loaded from: classes2.dex */
public class SmartNfcService extends Service {
    private static final long INITIAL_RETRY_DELAY_MS = 1000;
    private static final String INIT_WORKER_THREAD = "CaeSmartNfcInit";
    private static final int MAX_RETRY_COUNT = 5;
    private static final long MAX_RETRY_DELAY_MS = 30000;
    private static final String TAG = "SmartNfcService";
    private volatile boolean mDestroyed;
    private final Runnable mInitRunnable;
    private long mNextRetryDelayMs;
    private int mRetryCount;
    private volatile boolean mServiceRegistered;
    private SmartNfcManager mSmartNfcManager;
    private Handler mWorkerHandler;
    private HandlerThread mWorkerThread;

    public SmartNfcService() {
        this.mNextRetryDelayMs = 1000;
        this.mInitRunnable = new c(this, 1);
    }

    public static /* synthetic */ void a(SmartNfcService r8) {
        r8.initOnWorker();
    }

    private void initOnWorker() {
        if (this.mDestroyed == false) goto L26;
        return;
    L26:
    L15:
        e = move-exception;
        a.q("initOnWorker failed: ", e, TAG);
        boolean r8 = false;
    L17:
        if (r8 == false) goto L20;
        resetInitState();
        stopWorkerThread();
        return;
    L20:
        int r10 = this.mRetryCount;
        if (r10 < 5) goto L24;
        CaeLog.e(TAG, "initOnWorker: retry limit reached, wait for next onStartCommand");
        stopWorkerThread();
        return;
    L24:
        long r11 = this.mNextRetryDelayMs;
        this.mRetryCount = r10 + 1;
        this.mNextRetryDelayMs = Math.min(2 * r11, 30000);
        CaeLog.w(TAG, "initOnWorker: retry " + this.mRetryCount + "/5 in " + r11 + " ms");
        postInitTask(r11);
        return;
    L7:
        if (isAdapterServiceRegistered() == false) goto L9;
        this.mServiceRegistered = true;     // Catch: Exception -> L15
        r8 = true;
        goto L17
    L9:
        this.mSmartNfcManager.init();     // Catch: Exception -> L15
        if (this.mDestroyed == false) goto L13;
        this.mSmartNfcManager.cleanup();     // Catch: Exception -> L15
        return;
    L13:
        r8 = registerAdapterServiceIfNeeded();     // Catch: Exception -> L15
        goto L17
    }

    private boolean isAdapterServiceRegistered() {
        if (ServiceManager.getService(CaeNfcConstants.SERVICE_NAME_NFC) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        a.q("isAdapterServiceRegistered failed: ", e, TAG);
        return false;
    }

    private void postInitTask(long r8) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        if (this.mServiceRegistered == true) goto L18;
        startWorkerThread();
        Handler r10 = this.mWorkerHandler;
        if (r10 != null) goto L11;
        CaeLog.w(TAG, "postInitTask: worker handler is null");
        return;
    L11:
        r10.removeCallbacks(this.mInitRunnable);
        Runnable r11 = this.mInitRunnable;
        if (r8 > 0) goto L14;
        r10.post(r11);
        return;
    L14:
        r10.postDelayed(r11, r8);
        return;
    }

    private boolean registerAdapterServiceIfNeeded() {
        if (this.mDestroyed == false) goto L5;
    L25:
        return false;
    L5:
        if (this.mServiceRegistered == true) goto L25;
        if (this.mSmartNfcManager != null) goto L26;
        return false;
    L26:
    L22:
        e = e;
        String r8 = TAG;
        StringBuilder r10 = new StringBuilder("registerAdapterServiceIfNeeded: register denied: ");
    L24:
        r10.append(e);
        CaeLog.e(r8, r10.toString());
    L20:
        e = e;
        r8 = TAG;
        r10 = new StringBuilder("registerAdapterServiceIfNeeded: register failed: ");
        goto L24
    L11:
        if (isAdapterServiceRegistered() == false) goto L14;
        this.mServiceRegistered = true;     // Catch: Exception -> L20 SecurityException -> L22
        CaeLog.i(TAG, "registerAdapterServiceIfNeeded: service already registered");     // Catch: Exception -> L20 SecurityException -> L22
        return true;
    L14:
        CaeNfcAdapterService r11 = this.mSmartNfcManager.getAdapterService();     // Catch: Exception -> L20 SecurityException -> L22
        if (r11 != null) goto L18;
        CaeLog.e(TAG, "registerAdapterServiceIfNeeded: adapter service is null");     // Catch: Exception -> L20 SecurityException -> L22
        return false;
    L18:
        ServiceManager.addService(CaeNfcConstants.SERVICE_NAME_NFC, r11);     // Catch: Exception -> L20 SecurityException -> L22
        this.mServiceRegistered = true;     // Catch: Exception -> L20 SecurityException -> L22
        CaeLog.i(TAG, "registerAdapterServiceIfNeeded: service registered");     // Catch: Exception -> L20 SecurityException -> L22
        return true;
    }

    private void resetInitState() {
        this.mNextRetryDelayMs = 1000;
        this.mRetryCount = 0;
    }

    private void startWorkerThread() {
        if (this.mWorkerThread == null) goto L5;
        return;
    L5:
        HandlerThread r8 = new HandlerThread(INIT_WORKER_THREAD);
        this.mWorkerThread = r8;
        r8.start();
        this.mWorkerHandler = new Handler(this.mWorkerThread.getLooper());
    }

    private void stopWorkerThread() {
        this.mWorkerHandler = null;
        HandlerThread r8 = this.mWorkerThread;
        if (r8 == null) goto L6;
        r8.quitSafely();
        this.mWorkerThread = null;
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        CaeLog.d(TAG, "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CaeLog.d(TAG, "onCreate");
        this.mDestroyed = false;
        this.mServiceRegistered = false;
        this.mNextRetryDelayMs = 1000;
        this.mRetryCount = 0;
        this.mSmartNfcManager = SmartNfcManager.getInstance(this);
        postInitTask(0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CaeLog.i(TAG, "onDestroy");
        this.mDestroyed = true;
        Handler r8 = this.mWorkerHandler;
        if (r8 == null) goto L5;
        r8.removeCallbacks(this.mInitRunnable);
    L5:
        SmartNfcManager r10 = this.mSmartNfcManager;
        if (r10 != null) goto L13;
    L11:
        stopWorkerThread();
        return;
    L13:
        r10.cleanup();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        a.q("cleanup failed: ", e, TAG);
        goto L11
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        if (this.mDestroyed == false) goto L5;
        return 1;
    L5:
        if (this.mServiceRegistered == true) goto L10;
        postInitTask(0);
        return 1;
    L10:
        return 1;
    }
}
