package com.obric.cae.smartBluetooth.dcf;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.log.CaeLog;
import com.qualcomm.qti.qesdk.Dcf.DcfEnums;
import com.qualcomm.qti.qesdk.Dcf.DcfManager;
import com.qualcomm.qti.qesdk.Dcf.IDcfCBs;
import com.qualcomm.qti.qesdk.QesdkStatusException;
import com.qualcomm.qti.qesdkIntf.IQesdk;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class QeSdkHelper {
    private static final int CONNECT_DCF_TRIES_COUNT = 5;
    private static final long CONNECT_DCF_TRIES_INTERVAL = 3000;
    private static final String TAG = "QeSdkHelper";
    public static final byte[] UUID = null;
    public static final int UUID_IN_16BITS = 64706;
    public static final int UUID_IN_16BITS_TRIGGER = 64705;
    public static final byte[] UUID_TRIGGER = null;
    private static volatile QeSdkHelper sInstance;
    private Context mContext;
    private long mDcfClientId;
    private DcfManager mDcfManager;
    private DcfHandler mHandler;
    private boolean mIsInitSuccess;
    private final CopyOnWriteArrayList<platformStatusChangeListener> mPlatformReadyListeners;
    private DcfEnums.PlatformStatus mPlatformStatus;
    private final IDcfCBs.IPlatformStatusCallback mPlatformStatusCallback;
    private IQesdk mQeSDK;
    private int mRegToken;
    private final IDcfCBs.IClientRegistrationCallback mRegistrationCallback;
    private int mRemainingTriesCount;
    HandlerThread mWorkerThread;

    public class DcfHandler extends Handler {
        static final int MSG_INIT_DCF_MANAGER = 100;
        static final int MSG_REG_CLIENT = 101;
        static final int MSG_SET_PLATFORM_STATUS_CB = 102;
        final /* synthetic */ QeSdkHelper this$0;

        public DcfHandler(QeSdkHelper r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            super.handleMessage(r8);
            switch(r8.what) {
                case 100: goto L7;
                case 101: goto L6;
                case 102: goto L5;
                default: goto L11;
            };
        L5:
            QeSdkHelper.access$1000(this.this$0);
            return;
        L6:
            QeSdkHelper.access$900(this.this$0);
            return;
        L7:
            QeSdkHelper.access$800(this.this$0, r8);
            return;
        }
    }

    public interface platformStatusChangeListener {
        void onPlatformStatusChanged();
    }

    static {
        UUID = QeSdkUuidUtils.toBytes(-830);
        UUID_TRIGGER = QeSdkUuidUtils.toBytes(-831);
    }

    public QeSdkHelper() {
        this.mDcfClientId = -1;
        this.mPlatformStatus = DcfEnums.PlatformStatus.PLATFORMSTATUS_UNAVAILABLE;
        this.mPlatformReadyListeners = new CopyOnWriteArrayList();
        this.mRemainingTriesCount = 5;
        this.mRegistrationCallback = new AnonymousClass1(this);
        this.mPlatformStatusCallback = new AnonymousClass2(this);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ int access$100(QeSdkHelper r8) {
        return r8.mRegToken;
    }

    public static /* synthetic */ void access$1000(QeSdkHelper r8) {
        r8.handleSetPlatformStatusCallback();
    }

    public static /* synthetic */ int access$200(QeSdkHelper r8) {
        return r8.mRemainingTriesCount;
    }

    public static /* synthetic */ int access$202(QeSdkHelper r8, int r10) {
        r8.mRemainingTriesCount = r10;
        return r10;
    }

    public static /* synthetic */ int access$210(QeSdkHelper r8) {
        int r10 = r8.mRemainingTriesCount;
        r8.mRemainingTriesCount = r10 - 1;
        return r10;
    }

    public static /* synthetic */ void access$300(QeSdkHelper r8, long r10) {
        r8.scheduleRegisterClientDelayed(r10);
    }

    public static /* synthetic */ long access$402(QeSdkHelper r8, long r10) {
        r8.mDcfClientId = r10;
        return r10;
    }

    public static /* synthetic */ void access$500(QeSdkHelper r8) {
        r8.scheduleSetPlatformStatusCallback();
    }

    public static /* synthetic */ DcfEnums.PlatformStatus access$602(QeSdkHelper r8, DcfEnums.PlatformStatus r10) {
        r8.mPlatformStatus = r10;
        return r10;
    }

    public static /* synthetic */ void access$700(QeSdkHelper r8) {
        r8.notifyPlatformChange();
    }

    public static /* synthetic */ void access$800(QeSdkHelper r8, Message r10) {
        r8.handleInitDcfManager(r10);
    }

    public static /* synthetic */ void access$900(QeSdkHelper r8) {
        r8.handleRegisterClient();
    }

    private void deRegisterClient() {
        int r8 = this.mDcfManager.deregisterClient(this.mDcfClientId);     // Catch: QesdkStatusException -> L5
        this.mDcfClientId = -1;     // Catch: QesdkStatusException -> L5
        CaeLog.d(TAG, "deRegister success ? " + r8);     // Catch: QesdkStatusException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.w(TAG, "deRegister Exception: " + e.getMessage());
    }

    private boolean ensureDcfManagerReadyForInit() {
        if (this.mQeSDK != null) goto L9;
        IQesdk r8 = IQesdk.createInstance(this.mContext);
        this.mQeSDK = r8;
        if (r8 != null) goto L9;
        CaeLog.e(TAG, "Null IQesdk");
        return false;
    L9:
        if (this.mDcfManager != null) goto L13;
        this.mDcfManager = new DcfManager(this.mQeSDK);
        return true;
    L13:
        return true;
    }

    public static QeSdkHelper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(QeSdkHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new QeSdkHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(QeSdkHelper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handleInitDcfManager(Message r8) {
        if (this.mIsInitSuccess == false) goto L6;
        return;
    L6:
        if (ensureDcfManagerReadyForInit() == true) goto L9;
        scheduleInitRetryOrGiveUp("QeSDK manager instance is not available");
        return;
    L9:
        int r10 = this.mDcfManager.init("8169836875838067444944494450545650", new AnonymousClass3(this));
        if (r10 <= 0) goto L12;
        this.mIsInitSuccess = true;
        this.mRemainingTriesCount = 5;
        scheduleRegisterClient();
        CaeLog.i(TAG, "Init QeSDK done.");
        return;
    L12:
        this.mIsInitSuccess = false;
        CaeLog.e(TAG, "Fail to init QeSDK. " + r10);
        scheduleInitRetryOrGiveUp("DcfManager init failed, status=" + r10);
    }

    private void handleRegisterClient() {
        this.mRegToken = this.mDcfManager.registerClient(DcfEnums.ReferenceClientId.REFERENCECLIENTID_DEFAULT.getValue(), this.mRegistrationCallback);     // Catch: QesdkStatusException -> L5
        CaeLog.i(TAG, "registration value " + this.mRegToken);     // Catch: QesdkStatusException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.w(TAG, "registration Exception: " + e.getMessage());
    }

    private void handleSetPlatformStatusCallback() {
        int r8 = this.mDcfManager.setPlatformStatusCallback(this.mDcfClientId, this.mPlatformStatusCallback);     // Catch: QesdkStatusException -> L10
        CaeLog.d(TAG, "setPlatformStatusCallback : " + r8);     // Catch: QesdkStatusException -> L10
        if (r8 != 0) goto L7;
        DcfEnums.PlatformStatus r10 = DcfEnums.PlatformStatus.PLATFORMSTATUS_AVAILABLE;     // Catch: QesdkStatusException -> L10
    L6:
        this.mPlatformStatus = r10;     // Catch: QesdkStatusException -> L10
        notifyPlatformChange();     // Catch: QesdkStatusException -> L10
        return;
    L7:
        r10 = DcfEnums.PlatformStatus.PLATFORMSTATUS_UNAVAILABLE;     // Catch: QesdkStatusException -> L10
    L10:
        e = move-exception;
        CaeLog.w(TAG, "setPlatformStatusCallback Exception " + e.getMessage());
    }

    private void notifyPlatformChange() {
        Iterator<platformStatusChangeListener> r8 = this.mPlatformReadyListeners.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onPlatformStatusChanged();
        goto L4
    }

    private void scheduleInitDcfManager() {
        scheduleInitDcfManagerDelayed(0);
    }

    private void scheduleInitDcfManagerDelayed(long r8) {
        DcfHandler r10 = this.mHandler;
        if (r10 != null) goto L6;
        CaeLog.w(TAG, "scheduleInitDcfManagerDelayed ignored before handler init");
        return;
    L6:
        r10.removeMessages(100);
        DcfHandler r11 = this.mHandler;
        r11.sendMessageDelayed(Message.obtain(r11, 100), r8);
    }

    private void scheduleInitRetryOrGiveUp(String r8) {
        int r10 = this.mRemainingTriesCount - 1;
        this.mRemainingTriesCount = r10;
        if (r10 <= 0) goto L5;
        String r11 = TAG;
        StringBuilder r12 = android.aimedia.a.k(r8, ", retry after 3000 ms, remaining=");
        r12.append(this.mRemainingTriesCount);
        CaeLog.w(r11, r12.toString());
        scheduleInitDcfManagerDelayed(3000);
        return;
    L5:
        CaeLog.e(TAG, "init QeSDK failed after all retries: " + r8);
    }

    private void scheduleRegisterClient() {
        scheduleRegisterClientDelayed(0);
    }

    private void scheduleRegisterClientDelayed(long r8) {
        this.mHandler.removeMessages(101);
        DcfHandler r10 = this.mHandler;
        r10.sendMessageDelayed(Message.obtain(r10, 101), r8);
    }

    private void scheduleSetPlatformStatusCallback() {
        this.mHandler.removeMessages(102);
        DcfHandler r8 = this.mHandler;
        r8.sendMessage(Message.obtain(r8, 102));
    }

    public synchronized void addPlatformStatusChangeListener(platformStatusChangeListener r8) {
        monitor-enter(this);
        if (r8 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.mPlatformReadyListeners.addIfAbsent(r8);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public long getDcfClientId() {
        return this.mDcfClientId;
    }

    public DcfManager getDcfManager() {
        return this.mDcfManager;
    }

    public Looper getWorkerLooper() {
        HandlerThread r8 = this.mWorkerThread;
        if (r8 != null) goto L7;
        CaeLog.e(TAG, "Worker thread is not initialized");
        return Looper.getMainLooper();
    L7:
        return r8.getLooper();
    }

    public synchronized void init(Context r8) {
        monitor-enter(this);
        this.mContext = r8.getApplicationContext();     // Catch: Throwable -> L17
        if (this.mHandler == null) goto L14;
        HandlerThread r10 = this.mWorkerThread;     // Catch: Throwable -> L17
        if (r10 == null) goto L14;
        if (r10.isAlive() == false) goto L14;
        CaeLog.i(TAG, "QeSDK helper already initialized");     // Catch: Throwable -> L17
        if (this.mIsInitSuccess == true) goto L12;
        scheduleInitDcfManagerDelayed(0);     // Catch: Throwable -> L17
    L12:
        monitor-exit(this);
        return;
    L14:
        HandlerThread r11 = new HandlerThread("QeSdkClientWorker");     // Catch: Throwable -> L17
        this.mWorkerThread = r11;     // Catch: Throwable -> L17
        r11.start();     // Catch: Throwable -> L17
        this.mHandler = new DcfHandler(this, this.mWorkerThread.getLooper());     // Catch: Throwable -> L17
        scheduleInitDcfManagerDelayed(0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public boolean isPlatformReady() {
        if (this.mIsInitSuccess == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mDcfClientId <= 0) goto L9;
        if (this.mPlatformStatus != DcfEnums.PlatformStatus.PLATFORMSTATUS_AVAILABLE) goto L9;
        return true;
    }

    public void qesdkSesionCleanup(int r8, int[] r10) {
        CaeLog.e(TAG, "Error: QESDK session closed while in ".concat(getClass().getSimpleName()));
        DcfManager r11 = this.mDcfManager;
        if (r11 == null) goto L5;
        r11.deinit();
    L5:
        this.mIsInitSuccess = false;
        this.mDcfClientId = -1;
        this.mPlatformStatus = DcfEnums.PlatformStatus.PLATFORMSTATUS_UNAVAILABLE;
        DcfHandler r12 = this.mHandler;
        if (r12 == null) goto L8;
        r12.removeCallbacksAndMessages(null);
    L8:
        this.mRemainingTriesCount = 5;
        notifyPlatformChange();
        scheduleInitDcfManagerDelayed(3000);
    }
}
