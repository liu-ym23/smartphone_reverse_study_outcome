package com.obric.cae.smartNetwork.qoe;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import androidx.activity.j;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.CaeUtil;
import com.qti.extphone.Client;
import com.qti.extphone.ExtPhoneCallbackListener;
import com.qti.extphone.ExtTelephonyManager;
import defpackage.a;
import defpackage.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public class CellularQoeEvaluate {
    private static final int DEFAULT_INTERVAL = 1000;
    private static final String TAG = "CellularQoeEvaluate";
    private static CellularQoeEvaluate mInstance;
    private boolean isCellularNetifUp;
    private boolean isUpdateStats;
    private ConnectivityManager.NetworkCallback mCellularCallback;
    private Client mClient;
    private Context mContext;
    private final LinkedList<CellularQoECallback> mErrReportCb;
    private final Object mErrReportCbListLock;
    private final ExtPhoneCallbackListener mExtPhoneCallbackListener;
    private ExtTelephonyManager mExtTelephonyManager;
    private boolean mIsRunning;
    private long mMobileRxBytes;
    private long mMobileTxBytes;
    private CellularQoeEvaluateObserver mObserver;
    private int mScreenState;
    Semaphore mSem;
    private boolean mServiceConnected;
    private final Object mStartStopLock;
    private final ConcurrentHashMap<Integer, CellularQoeEvaluateStats> mStats;
    private final Object mStatsLock;
    private Thread mThread;

    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType NONE_ERR = null;
        public static final ErrorType RLF_ERR = null;
        public static final ErrorType UP_RETRANS_ERR = null;
        private final int value;

        private static /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{NONE_ERR, UP_RETRANS_ERR, RLF_ERR};
        }

        static {
            NONE_ERR = new ErrorType("NONE_ERR", 0, 0);
            UP_RETRANS_ERR = new ErrorType("UP_RETRANS_ERR", 1, 1);
            RLF_ERR = new ErrorType("RLF_ERR", 2, 2);
            $VALUES = $values();
        }

        private ErrorType(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static ErrorType valueOf(String r8) {
            return (ErrorType) Enum.valueOf(ErrorType.class, r8);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    private CellularQoeEvaluate() {
        this.mIsRunning = false;
        this.mServiceConnected = false;
        this.mStartStopLock = new Object();
        this.mErrReportCbListLock = new Object();
        this.mStatsLock = new Object();
        this.mErrReportCb = new LinkedList();
        this.mMobileTxBytes = 0;
        this.mMobileRxBytes = 0;
        this.isCellularNetifUp = false;
        this.isUpdateStats = false;
        this.mStats = new ConcurrentHashMap();
        this.mExtPhoneCallbackListener = new AnonymousClass1(this);
    }

    public static /* synthetic */ void a(CellularQoeEvaluate r8) {
        r8.lambda$start$0();
    }

    public static /* synthetic */ boolean access$000(CellularQoeEvaluate r8) {
        return r8.isCellularNetifUp;
    }

    public static /* synthetic */ boolean access$002(CellularQoeEvaluate r8, boolean r10) {
        r8.isCellularNetifUp = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$100(CellularQoeEvaluate r8) {
        return r8.mIsRunning;
    }

    public static /* synthetic */ Context access$1000(CellularQoeEvaluate r8) {
        return r8.mContext;
    }

    public static /* synthetic */ ExtPhoneCallbackListener access$1100(CellularQoeEvaluate r8) {
        return r8.mExtPhoneCallbackListener;
    }

    public static /* synthetic */ ExtTelephonyManager access$1200(CellularQoeEvaluate r8) {
        return r8.mExtTelephonyManager;
    }

    public static /* synthetic */ boolean access$1300(CellularQoeEvaluate r8) {
        return r8.mServiceConnected;
    }

    public static /* synthetic */ boolean access$1302(CellularQoeEvaluate r8, boolean r10) {
        r8.mServiceConnected = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(CellularQoeEvaluate r8, int r10) {
        r8.mScreenState = r10;
        return r10;
    }

    public static /* synthetic */ Object access$200(CellularQoeEvaluate r8) {
        return r8.mStatsLock;
    }

    public static /* synthetic */ ConcurrentHashMap access$300(CellularQoeEvaluate r8) {
        return r8.mStats;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ long access$500(CellularQoeEvaluate r8) {
        return r8.mMobileTxBytes;
    }

    public static /* synthetic */ long access$502(CellularQoeEvaluate r8, long r10) {
        r8.mMobileTxBytes = r10;
        return r10;
    }

    public static /* synthetic */ long access$600(CellularQoeEvaluate r8) {
        return r8.mMobileRxBytes;
    }

    public static /* synthetic */ long access$602(CellularQoeEvaluate r8, long r10) {
        r8.mMobileRxBytes = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$702(CellularQoeEvaluate r8, boolean r10) {
        r8.isUpdateStats = r10;
        return r10;
    }

    public static /* synthetic */ void access$800(CellularQoeEvaluate r8) {
        r8.checkErr();
    }

    public static /* synthetic */ Client access$900(CellularQoeEvaluate r8) {
        return r8.mClient;
    }

    public static /* synthetic */ Client access$902(CellularQoeEvaluate r8, Client r10) {
        r8.mClient = r10;
        return r10;
    }

    private void checkErr() {
        Iterator<Map.Entry<Integer, CellularQoeEvaluateStats>> r8 = this.mStats.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        CellularQoeEvaluateStats r10 = r8.next().getValue();
        if (r10.lteRlfCauseType == 0) goto L8;
    L9:
        r10.errBitMap |= ErrorType.RLF_ERR.getValue();
        CaeLog.e(TAG, "report err, LTE RLF cause type: " + r10.lteRlfCauseType + ", NR RLF cause type: " + r10.nrRlfCauseType);
    L10:
        int r11 = r10.ltePdcpLossRate;
        if (r11 != 0) goto L15;
        r11 = r10.nrPdcpLossRate;
    L15:
        if (r10.sendRate < this.mObserver.getPdcpUpThroughputThreshold()) goto L17;
        if (r11 <= this.mObserver.getPdcpUpLossRateLowThreshold()) goto L4;
        r10.errBitMap |= ErrorType.UP_RETRANS_ERR.getValue();
        String r12 = TAG;
        StringBuilder r13 = b.f("report err, high throughput lossRate: ", r11, "(");
        int r14 = this.mObserver.getPdcpUpLossRateLowThreshold();
    L22:
        r13.append(r14);
        r13.append(") , sendRate: ");
        r13.append(r10.sendRate);
        r13.append("(");
        r13.append(this.mObserver.getPdcpUpThroughputThreshold());
        r13.append(")");
        CaeLog.e(r12, r13.toString());
        goto L4
    L17:
        if (r11 <= this.mObserver.getPdcpUpLossRateHighThreshold()) goto L4;
        r10.errBitMap |= ErrorType.UP_RETRANS_ERR.getValue();
        r12 = TAG;
        r13 = b.f("report err, low throughput lossRate: ", r11, "(");
        r14 = this.mObserver.getPdcpUpLossRateHighThreshold();
        goto L22
    L8:
        if (r10.nrRlfCauseType == 0) goto L10;
    }

    public static synchronized CellularQoeEvaluate getInstance(Context r8) {
        monitor-enter(CellularQoeEvaluate.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        CellularQoeEvaluate r10 = new CellularQoeEvaluate();     // Catch: Throwable -> L10
        mInstance = r10;     // Catch: Throwable -> L10
        r10.mExtTelephonyManager = ExtTelephonyManager.getInstance(r8);     // Catch: Throwable -> L10
        CellularQoeEvaluate r11 = mInstance;     // Catch: Throwable -> L10
        r11.mContext = r8;     // Catch: Throwable -> L10
        r11.mObserver = CellularQoeEvaluateObserver.getInstance(r8);     // Catch: Throwable -> L10
    L7:
        CellularQoeEvaluate r12 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(CellularQoeEvaluate.class);
        return r12;
    }

    private void initNetworkMonitoring() {
        ConnectivityManager r8 = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkRequest r10 = new NetworkRequest.Builder().addTransportType(0).build();
        ConnectivityManager.NetworkCallback r11 = new AnonymousClass3(this);
        this.mCellularCallback = r11;
        r8.registerNetworkCallback(r10, r11);
    }

    private void initScreenStateReceiver() {
        this.mScreenState = CaeUtil.getScreenState(this.mContext);
        CaeLog.d(TAG, "initScreenStateReceiver mScreenState = " + this.mScreenState);
        this.mSem = new Semaphore(0);
        IntentFilter r8 = a.c("android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(new AnonymousClass4(this), r8);
    }

    private /* synthetic */ void lambda$start$0() {
    L3:
        if (this.mIsRunning == false) goto L20;
    L5:
        if (this.mIsRunning == false) goto L13;
        if (this.mScreenState != 0) goto L13;
        this.mSem.acquire();     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        CaeLog.e(TAG, "mSem.acquire interrupted", e);
    L13:
        if (this.mIsRunning == false) goto L33;
        reportErr();
        Thread.sleep(1000);     // Catch: InterruptedException -> L18
    L18:
        e = move-exception;
        CaeLog.e(TAG, "thread interrupted", e);
        goto L3
    L33:
        return;
    }

    private void reportErr() {
        Object r8 = this.mStatsLock;
        monitor-enter(r8);
        Iterator<Map.Entry<Integer, CellularQoeEvaluateStats>> r10 = this.mStats.entrySet().iterator();     // Catch: Throwable -> L26
    L6:
        if (r10.hasNext() == false) goto L23;
        CellularQoeEvaluateStats r11 = r10.next().getValue();     // Catch: Throwable -> L26
        Object r12 = this.mErrReportCbListLock;     // Catch: Throwable -> L26
        monitor-enter(r12);     // Catch: Throwable -> L26
        Iterator<CellularQoECallback> r13 = this.mErrReportCb.iterator();     // Catch: Throwable -> L20
    L11:
        if (r13.hasNext() == false) goto L17;
        CellularQoECallback r14 = r13.next();     // Catch: Throwable -> L20
        if (this.isUpdateStats == false) goto L15;
        CellularQoeEvaluateStats r15 = new CellularQoeEvaluateStats(r11);     // Catch: Throwable -> L20
    L16:
        r14.onCellularL2EvaluateReport(r15);     // Catch: Throwable -> L20
        goto L11
    L15:
        r15 = new CellularQoeEvaluateStats();     // Catch: Throwable -> L20
        goto L16
    L17:
        monitor-exit(r12);     // Catch: Throwable -> L20
        r11.errBitMap = 0;     // Catch: Throwable -> L26
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L23:
        this.isUpdateStats = false;     // Catch: Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public boolean registerErrReportCb(CellularQoECallback r8) {
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "Invalid callback");
        return false;
    L6:
        Object r10 = this.mErrReportCbListLock;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.mErrReportCb.contains(r8) == false) goto L13;
        CaeLog.e(TAG, "CellularQoECallback already registered");     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
        return false;
    L13:
        this.mErrReportCb.add(r8);     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
        return true;
    }

    public void start() {
        String r8 = TAG;
        CaeLog.i(r8, "call start");
        Object r10 = this.mStartStopLock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsRunning == false) goto L9;
        CaeLog.e(r8, r8 + " already started");     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L9:
        this.mIsRunning = true;     // Catch: Throwable -> L13
        this.mExtTelephonyManager.connectService(new AnonymousClass2(this));     // Catch: Throwable -> L13
        initNetworkMonitoring();     // Catch: Throwable -> L13
        initScreenStateReceiver();     // Catch: Throwable -> L13
        Thread r11 = new Thread(new j(this, 27), "CellularQoeEvaluateThread");     // Catch: Throwable -> L13
        this.mThread = r11;     // Catch: Throwable -> L13
        r11.start();     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        CaeLog.e(r8, r8 + " start success");
    }

    public synchronized void stop() {
        monitor-enter(this);
        String r8 = TAG;     // Catch: Throwable -> L24
        CaeLog.i(r8, "call stop");     // Catch: Throwable -> L24
        if (this.mIsRunning == true) goto L8;
        CaeLog.e(r8, r8 + " already stopped");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L8:
        Object r10 = this.mStartStopLock;     // Catch: Throwable -> L24
        monitor-enter(r10);     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L11:
        if (this.mIsRunning == false) goto L18;
        this.mIsRunning = false;     // Catch: Throwable -> L21
        this.mThread.interrupt();     // Catch: Throwable -> L21
        this.mThread.join();     // Catch: InterruptedException -> L15 Throwable -> L21
    L17:
        this.mExtTelephonyManager.unregisterCallback(this.mExtPhoneCallbackListener);     // Catch: Throwable -> L21
        this.mExtTelephonyManager.disconnectService();     // Catch: Throwable -> L21
        this.mServiceConnected = false;     // Catch: Throwable -> L21
        this.mStats.clear();     // Catch: Throwable -> L21
        goto L18
    L15:
        e = move-exception;
        CaeLog.e(TAG, "thread join interrupted", e);     // Catch: Throwable -> L21
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public boolean unregisterErrReportCb(CellularQoECallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "Invalid callback");
        return false;
    L5:
        Object r10 = this.mErrReportCbListLock;
        monitor-enter(r10);
        boolean r11 = this.mErrReportCb.remove(r8);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }
}
