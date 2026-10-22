package com.obric.cae.smartNetwork.nefid;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import androidx.activity.k;
import com.cae.caed.DbamParamParcel;
import com.cae.caed.IEventListener;
import com.cae.caed.INefiListener;
import com.cae.caed.INefiService;
import com.cae.caed.VendorAttr;
import com.cae.caed.VendorAttrParcel;
import com.cae.caed.net.IL4NetInfoUpdateCb;
import com.obric.cae.log.CaeLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class NefidInterface {
    private static final int ATTR_TYPE_INT32 = 3;
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final int CAE_NL80211_VENDOR_ID = 4982;
    private static final int CAE_NL80211_VENDOR_SUBCMD_ROAM_BOOST_RSSI_SET = 32;
    private static final int CAE_NL80211_VENDOR_SUBCMD_ROAM_PENALIZE_RSSI_SET = 33;
    private static final int CAE_WLAN_VENDOR_ATTR_ROAM_BOOST_RSSI_THRESHOLD = 2;
    private static final int CAE_WLAN_VENDOR_ATTR_ROAM_PENALIZE_RSSI_THRESHOLD = 3;
    private static final int IFACEINDEX = 0;
    public static final int METHOD_EQUAL_TO = 1;
    public static final int METHOD_GREATER_THAN = 4;
    public static final int METHOD_LESS_THAN = 2;
    private static final String NEFID_LATENCY_MODE_TAG = "nefid_low_latency";
    private static final String NEFID_SERVER_NAME = "caed";
    public static final int NEFI_CCA_CHANGE_EVENT = 4;
    public static final int NEFI_PERIODIC_REPORT_EVENT = 1;
    public static final int NEFI_PER_CHANGE_EVENT = 8;
    public static int NEFI_SCENARIO_GENERAL = 0;
    public static int NEFI_SCENARIO_HIGH_TX_THPUT = 3;
    public static int NEFI_SCENARIO_MAX = 5;
    public static int NEFI_SCENARIO_OAUTO = 4;
    public static int NEFI_SCENARIO_ONLINE_GAME = 1;
    public static int NEFI_SCENARIO_STREAMING = 2;
    public static final int NEFI_SIGNAL_CHANGE_EVENT = 2;
    public static final int NEFI_STATUS_REPORT_EVENT = 16;
    public static final int REPORT_FREQ_ALWAYS = 2;
    public static final int REPORT_FREQ_ONCE = 1;
    private static final String TAG = "NefidInterface";
    private static ServiceDeathRecipient mDeathRecipient;
    private static volatile NefidInterface mNefidInterface;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final Set<IEventListener> mIEventListenerSet;
    private final Object mListenerLock;
    private final ReentrantReadWriteLock mLock;
    private INefiListener mNefiListener;
    private final ArrayMap<INefiListener, NefidListenerEventCfg> mNefiListenerMap;
    private int mNefidLowLatencyMode;
    private INefiService mNefidService;
    private final Runnable mRetryBindRunnable;
    private WifiManager.WifiLock mWifiLock;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.nefid.NefidInterface$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class NefidListenerEventCfg {
        int mEventId;
        String mIfName;
        int mMethod;
        int mReport;
        int mThreshold;
        final /* synthetic */ NefidInterface this$0;

        public NefidListenerEventCfg(NefidInterface r8, int r10, String r11, int r12, int r13, int r14) {
            this.this$0 = r8;
            this.mEventId = r10;
            this.mIfName = r11;
            this.mThreshold = r12;
            this.mMethod = r13;
            this.mReport = r14;
        }

        public int getEventId() {
            return this.mEventId;
        }

        public String getIfName() {
            return this.mIfName;
        }

        public int getMethod() {
            return this.mMethod;
        }

        public int getReport() {
            return this.mReport;
        }

        public int getThreshold() {
            return this.mThreshold;
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ NefidInterface this$0;

        private ServiceDeathRecipient(NefidInterface r8) {
            this.this$0 = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CaeLog.e(NefidInterface.TAG, "Caed service is dead !!!");
            NefidInterface.access$000(this.this$0).writeLock().lock();
            NefidInterface.access$102(this.this$0, null);
            NefidInterface.access$000(this.this$0).writeLock().unlock();
            NefidInterface.access$200(this.this$0);
        }

        public /* synthetic */ ServiceDeathRecipient(NefidInterface r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public NefidInterface(Context r8) {
        this.mNefidLowLatencyMode = NEFI_SCENARIO_GENERAL;
        this.mLock = new ReentrantReadWriteLock();
        this.mRetryBindRunnable = new k(this, 20);
        this.mListenerLock = new Object();
        this.mNefiListenerMap = new ArrayMap();
        this.mIEventListenerSet = new HashSet();
        this.mContext = r8;
        HandlerThread r10 = new HandlerThread(TAG);
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        mDeathRecipient = new ServiceDeathRecipient(this, null);
        setupNefidInterface();
    }

    public static /* synthetic */ void a(NefidInterface r8) {
        r8.setupNefidInterface();
    }

    public static /* synthetic */ ReentrantReadWriteLock access$000(NefidInterface r8) {
        return r8.mLock;
    }

    public static /* synthetic */ INefiService access$102(NefidInterface r8, INefiService r10) {
        r8.mNefidService = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(NefidInterface r8) {
        r8.scheduleSetupNefidInterfaceRetry();
    }

    public static NefidInterface getInstance(Context r8) {
        if (mNefidInterface != null) goto L15;
        monitor-enter(NefidInterface.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mNefidInterface != null) goto L9;
        mNefidInterface = new NefidInterface(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NefidInterface.class);     // Catch: Throwable -> L11
    L15:
        return mNefidInterface;
    }

    private INefiService getNefidService() {
        this.mLock.readLock().lock();
        INefiService r8 = this.mNefidService;     // Catch: Throwable -> L6
        this.mLock.readLock().unlock();
        return r8;
    L6:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    }

    private void handleCaedBound() {
        INefiService r8 = getNefidService();
        if (r8 != null) goto L5;
        return;
    L5:
        Object r10 = this.mListenerLock;
        monitor-enter(r10);
        ArrayMap r11 = new ArrayMap(this.mNefiListenerMap);     // Catch: Throwable -> L18
        HashSet r12 = new HashSet(this.mIEventListenerSet);     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        int r13 = 0;
    L11:
        if (r13 >= r11.size()) goto L13;
        subscribeNefidInfoListener(r8, (INefiListener) r11.keyAt(r13), (NefidListenerEventCfg) r11.valueAt(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        Iterator r14 = r12.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        subscribeNefidEventListener(r8, (IEventListener) r14.next());
        goto L15
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private static byte[] intToBytesLE(int r8) {
        return new byte[]{(byte) (r8 & 255), (byte) ((r8 >> 8) & 255), (byte) ((r8 >> 16) & 255), (byte) ((r8 >> 24) & 255)};
    }

    private void scheduleSetupNefidInterfaceRetry() {
        Handler r8 = this.mHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        r8.removeCallbacks(this.mRetryBindRunnable);
        this.mHandler.postDelayed(this.mRetryBindRunnable, 2000);
    }

    private void setupNefidInterface() {
        this.mLock.writeLock().lock();
        if (this.mNefidService == null) goto L6;
        this.mLock.writeLock().unlock();
        return;
    L6:
        INefiService r8 = INefiService.Stub.H2(ServiceManager.getService(NEFID_SERVER_NAME));
        CaeLog.d(TAG, "get mNefiService = " + r8);
        this.mNefidService = r8;
        this.mLock.writeLock().unlock();
        if (r8 != null) goto L16;
        CaeLog.e(TAG, "Failed to get service, retry later");
        scheduleSetupNefidInterfaceRetry();
        return;
    L16:
        r8.asBinder().linkToDeath(mDeathRecipient, 0);     // Catch: RemoteException -> L13
        handleCaedBound();
        return;
    L13:
        e = move-exception;
        CaeLog.e(TAG, "Failed to register DeathRecipient", e);
        this.mLock.writeLock().lock();
        this.mNefidService = null;
        this.mLock.writeLock().unlock();
        scheduleSetupNefidInterfaceRetry();
    }

    private void subscribeNefidEventListener(INefiService r8, IEventListener r10) {
        CaeLog.d(TAG, "registerNefidEventListener");     // Catch: RemoteException -> L5
        r8.D1(r10);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "registerNefidEventListener failed", e);
        this.mLock.writeLock().lock();
    L12:
        th = move-exception;
        this.mLock.writeLock().unlock();
        throw th;
    L8:
        if (this.mNefidService != r8) goto L10;
        this.mNefidService = null;     // Catch: Throwable -> L12
    L10:
        this.mLock.writeLock().unlock();
        scheduleSetupNefidInterfaceRetry();
    }

    private void subscribeNefidInfoListener(INefiService r10, INefiListener r11, NefidListenerEventCfg r12) {
        CaeLog.d(TAG, "registerNefidInfoListener");     // Catch: RemoteException -> L4
        r10.b2(r11, r12.getEventId(), r12.getIfName(), r12.getThreshold(), r12.getMethod(), r12.getReport());     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public boolean getDbamParams(int r8, DbamParamParcel r10) {
        boolean r11 = false;
        this.mLock.readLock().lock();     // Catch: Throwable -> L9 RemoteException -> L11
        if (this.mNefidService == null) goto L7;
        CaeLog.d(TAG, "getDbamParams");     // Catch: Throwable -> L9 RemoteException -> L11
        r11 = this.mNefidService.r2(r8, r10);     // Catch: Throwable -> L9 RemoteException -> L11
    L19:
    L13:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return r11;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L9 RemoteException -> L11
    L9:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        goto L13
    }

    public boolean getL4NetInfo(IL4NetInfoUpdateCb r8) {
        ReentrantReadWriteLock r10 = this.mLock;
        monitor-enter(r10);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        INefiService r11 = this.mNefidService;     // Catch: Throwable -> L14 RemoteException -> L16
        if (r11 == null) goto L10;
        boolean r12 = r11.E0(r8);     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        return r12;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r13 = this.mLock.readLock();     // Catch: Throwable -> L22
    L12:
        r13.unlock();     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        return false;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        r13 = this.mLock.readLock();     // Catch: Throwable -> L22
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public String getNefidConfig() {
        ReentrantReadWriteLock r8 = this.mLock;
        monitor-enter(r8);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        if (this.mNefidService == null) goto L10;
        CaeLog.d(TAG, "getNefidLowLatencyMode");     // Catch: Throwable -> L14 RemoteException -> L16
        String r10 = this.mNefidService.e2();     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        return r10;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r11 = this.mLock.readLock();     // Catch: Throwable -> L24
    L12:
        r11.unlock();     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        return null;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        r11 = this.mLock.readLock();     // Catch: Throwable -> L24
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public int getNefidMode() {
        ReentrantReadWriteLock r8 = this.mLock;
        monitor-enter(r8);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        if (this.mNefidService == null) goto L10;
        CaeLog.d(TAG, "getNefidLowLatencyMode");     // Catch: Throwable -> L14 RemoteException -> L16
        int r10 = this.mNefidService.f1();     // Catch: Throwable -> L14 RemoteException -> L16
        this.mNefidLowLatencyMode = r10;     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        return r10;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r11 = this.mLock.readLock();     // Catch: Throwable -> L24
    L12:
        r11.unlock();     // Catch: Throwable -> L24
        int r12 = NEFI_SCENARIO_GENERAL;     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        return r12;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        r11 = this.mLock.readLock();     // Catch: Throwable -> L24
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public int getRoamRssiThreshold(int r8) {
        int r10 = 0;
        this.mLock.readLock().lock();     // Catch: Throwable -> L9 RemoteException -> L11
        if (this.mNefidService == null) goto L7;
        CaeLog.d(TAG, "getRoamRssiThreshold");     // Catch: Throwable -> L9 RemoteException -> L11
        r10 = this.mNefidService.s(r8);     // Catch: Throwable -> L9 RemoteException -> L11
    L19:
    L13:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return r10;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L9 RemoteException -> L11
    L9:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        goto L13
    }

    public void netTCCleanFilter() {
        ReentrantReadWriteLock r8 = this.mLock;
        monitor-enter(r8);
        this.mLock.readLock().lock();     // Catch: Throwable -> L11 RemoteException -> L13
        INefiService r10 = this.mNefidService;     // Catch: Throwable -> L11 RemoteException -> L13
        if (r10 == null) goto L7;
        r10.s0();     // Catch: Throwable -> L11 RemoteException -> L13
    L8:
        ReentrantReadWriteLock.ReadLock r11 = this.mLock.readLock();     // Catch: Throwable -> L20
    L9:
        r11.unlock();     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        return;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L11 RemoteException -> L13
    L13:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L11
        r11 = this.mLock.readLock();     // Catch: Throwable -> L20
    L11:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public int netTCCreateClass(int r8, int r10, int r11) {
        ReentrantReadWriteLock r12 = this.mLock;
        monitor-enter(r12);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        INefiService r13 = this.mNefidService;     // Catch: Throwable -> L14 RemoteException -> L16
        if (r13 == null) goto L10;
        int r14 = r13.p(r8, r10, r11);     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return r14;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r15 = this.mLock.readLock();     // Catch: Throwable -> L24
    L12:
        r15.unlock();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return -1;
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L16:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L14
        r15 = this.mLock.readLock();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public int netTCCreateOutputFilter(String r8, int r10, int r11) {
        ReentrantReadWriteLock r12 = this.mLock;
        monitor-enter(r12);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        INefiService r13 = this.mNefidService;     // Catch: Throwable -> L14 RemoteException -> L16
        if (r13 == null) goto L10;
        int r14 = r13.w1(r10, r11, r8);     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return r14;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r15 = this.mLock.readLock();     // Catch: Throwable -> L24
    L12:
        r15.unlock();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return -1;
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L16:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L14
        r15 = this.mLock.readLock();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public void netTCDeInit() {
        ReentrantReadWriteLock r8 = this.mLock;
        monitor-enter(r8);
        this.mLock.readLock().lock();     // Catch: Throwable -> L11 Throwable -> L13
        INefiService r10 = this.mNefidService;     // Catch: Throwable -> L11 Throwable -> L13
        if (r10 == null) goto L7;
        r10.T1();     // Catch: Throwable -> L11 Throwable -> L13
    L8:
        ReentrantReadWriteLock.ReadLock r11 = this.mLock.readLock();     // Catch: Throwable -> L20
    L9:
        r11.unlock();     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        return;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L11 Throwable -> L13
    L13:
        e = move-exception;
        CaeLog.e(TAG, "netTCDeInit failed", e);     // Catch: Throwable -> L11
        r11 = this.mLock.readLock();     // Catch: Throwable -> L20
    L11:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public void netTCDeleteClass(int r8) {
        ReentrantReadWriteLock r10 = this.mLock;
        monitor-enter(r10);
        this.mLock.readLock().lock();     // Catch: Throwable -> L11 RemoteException -> L13
        INefiService r11 = this.mNefidService;     // Catch: Throwable -> L11 RemoteException -> L13
        if (r11 == null) goto L7;
        r11.n(r8);     // Catch: Throwable -> L11 RemoteException -> L13
    L8:
        ReentrantReadWriteLock.ReadLock r12 = this.mLock.readLock();     // Catch: Throwable -> L20
    L9:
        r12.unlock();     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L11 RemoteException -> L13
    L13:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L11
        r12 = this.mLock.readLock();     // Catch: Throwable -> L20
    L11:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public void netTCDeleteOutputFilter(int r8, int r10, int r11, int r12) {
        ReentrantReadWriteLock r13 = this.mLock;
        monitor-enter(r13);
        this.mLock.readLock().lock();     // Catch: Throwable -> L11 RemoteException -> L13
        INefiService r14 = this.mNefidService;     // Catch: Throwable -> L11 RemoteException -> L13
        if (r14 == null) goto L7;
        r14.Z(r8, r10, r11, r12);     // Catch: Throwable -> L11 RemoteException -> L13
    L8:
        ReentrantReadWriteLock.ReadLock r15 = this.mLock.readLock();     // Catch: Throwable -> L20
    L9:
        r15.unlock();     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L11 RemoteException -> L13
    L13:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L11
        r15 = this.mLock.readLock();     // Catch: Throwable -> L20
    L11:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public int netTCInit(String r8) {
        ReentrantReadWriteLock r10 = this.mLock;
        monitor-enter(r10);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        INefiService r11 = this.mNefidService;     // Catch: Throwable -> L14 RemoteException -> L16
        if (r11 == null) goto L10;
        int r12 = r11.u1(r8);     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        monitor-exit(r10);     // Catch: Throwable -> L24
        return r12;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r13 = this.mLock.readLock();     // Catch: Throwable -> L24
    L12:
        r13.unlock();     // Catch: Throwable -> L24
        monitor-exit(r10);     // Catch: Throwable -> L24
        return -1;
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L16:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L14
        r13 = this.mLock.readLock();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public int netTCUpdateClassRate(int r8, int r10, int r11) {
        ReentrantReadWriteLock r12 = this.mLock;
        monitor-enter(r12);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        INefiService r13 = this.mNefidService;     // Catch: Throwable -> L14 RemoteException -> L16
        if (r13 == null) goto L10;
        int r14 = r13.F2(r8, r10, r11);     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return r14;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r15 = this.mLock.readLock();     // Catch: Throwable -> L24
    L12:
        r15.unlock();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return -1;
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L16:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L14
        r15 = this.mLock.readLock();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public boolean registerNefidEventListener(IEventListener r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "registerNefidEventListener listener is null");
        return false;
    L5:
        Object r10 = this.mListenerLock;
        monitor-enter(r10);
        this.mIEventListenerSet.add(r8);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        INefiService r11 = getNefidService();
        if (r11 == null) goto L12;
        subscribeNefidEventListener(r11, r8);
        return true;
    L12:
        CaeLog.e(TAG, "mNefidService is null, cache listener and retry after caed bound");
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public void registerNefidInfoListener(INefiListener r10, int r11, String r12, int r13, int r14, int r15) {
        CaeLog.d(TAG, "registerNefidInfoListener - listener: " + r10 + ", eventId: " + r11 + ", ifname: " + r12 + ", threshold: " + r13 + ", method: " + r14 + ", report: " + r15);
        NefidListenerEventCfg r8 = new NefidListenerEventCfg(this, r11, r12, r13, r14, r15);
        Object r16 = this.mListenerLock;
        monitor-enter(r16);
        this.mNefiListenerMap.put(r10, r8);     // Catch: Throwable -> L11
        monitor-exit(r16);     // Catch: Throwable -> L11
        INefiService r17 = getNefidService();
        if (r17 == null) goto L9;
        subscribeNefidInfoListener(r17, r10, r8);
        return;
    L9:
        CaeLog.e(TAG, "mNefidService is null!!!!");
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean sendVendorCommand(int r12, int r13) {
        VendorAttrParcel r8 = null;
        this.mLock.readLock().lock();     // Catch: Throwable -> L13 RemoteException -> L15
        if (this.mNefidService == null) goto L10;
        VendorAttrParcel r10 = new VendorAttrParcel();     // Catch: Throwable -> L13 RemoteException -> L15
        VendorAttr r11 = new VendorAttr();     // Catch: Throwable -> L13 RemoteException -> L15
        r11.f4199a = 2;     // Catch: Throwable -> L13 RemoteException -> L15
        r11.f4200b = 3;     // Catch: Throwable -> L13 RemoteException -> L15
        r11.f4201m = intToBytesLE(r12);     // Catch: Throwable -> L13 RemoteException -> L15
        r10.f4202a = new VendorAttr[]{r11};     // Catch: Throwable -> L13 RemoteException -> L15
        VendorAttrParcel r14 = this.mNefidService.Y0(CAE_NL80211_VENDOR_ID, 32, 0, r10, new int[0]);     // Catch: Throwable -> L13 RemoteException -> L15
        VendorAttrParcel r15 = new VendorAttrParcel();     // Catch: RemoteException -> L8 Throwable -> L13
        VendorAttr r16 = new VendorAttr();     // Catch: RemoteException -> L8 Throwable -> L13
        r16.f4199a = 3;     // Catch: RemoteException -> L8 Throwable -> L13
        r16.f4200b = 3;     // Catch: RemoteException -> L8 Throwable -> L13
        r16.f4201m = intToBytesLE(r13);     // Catch: RemoteException -> L8 Throwable -> L13
        r15.f4202a = new VendorAttr[]{r16};     // Catch: RemoteException -> L8 Throwable -> L13
        VendorAttrParcel r17 = this.mNefidService.Y0(CAE_NL80211_VENDOR_ID, 33, 0, r15, new int[0]);     // Catch: RemoteException -> L8 Throwable -> L13
        r8 = r14;
    L12:
        this.mLock.readLock().unlock();
    L19:
        if (r8 == null) goto L28;
        if (r17 == null) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    L8:
        e = e;
    L17:
        CaeLog.e(TAG, "sendVendorCommand(boost5g, penalize5g) RemoteException", e);     // Catch: Throwable -> L13
        this.mLock.readLock().unlock();
        r17 = null;
        r8 = r14;
        goto L19
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L13 RemoteException -> L15
        r17 = null;
    L13:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L15:
        e = e;
        r14 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public boolean setDbamParams(int r8, DbamParamParcel r10) {
        boolean r11 = false;
        this.mLock.readLock().lock();     // Catch: Throwable -> L9 RemoteException -> L11
        if (this.mNefidService == null) goto L7;
        CaeLog.d(TAG, "setDbamParams");     // Catch: Throwable -> L9 RemoteException -> L11
        r11 = this.mNefidService.t2(r8, r10);     // Catch: Throwable -> L9 RemoteException -> L11
    L19:
    L13:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return r11;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L9 RemoteException -> L11
    L9:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public boolean setLatencyLevel(int r8, int r10) {
        boolean r11 = false;
        this.mLock.readLock().lock();     // Catch: Throwable -> L9 RemoteException -> L11
        if (this.mNefidService == null) goto L7;
        CaeLog.d(TAG, "setLatencyLevel");     // Catch: Throwable -> L9 RemoteException -> L11
        r11 = this.mNefidService.n0(r8, r10);     // Catch: Throwable -> L9 RemoteException -> L11
    L19:
    L13:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return r11;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L9 RemoteException -> L11
    L9:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public void setNefidConfig(String r8, String r10) {
        this.mLock.readLock().lock();     // Catch: Throwable -> L8 RemoteException -> L10
        if (this.mNefidService == null) goto L6;
        CaeLog.d(TAG, "setNefidConfig");     // Catch: Throwable -> L8 RemoteException -> L10
        this.mNefidService.w0(r8, r10);     // Catch: Throwable -> L8 RemoteException -> L10
    L18:
    L12:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return;
    L6:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L8 RemoteException -> L10
    L8:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public void setNefidLowLatencyMode(int r8, int r10) {
        this.mLock.readLock().lock();     // Catch: Throwable -> L8 RemoteException -> L10
        if (this.mNefidService == null) goto L6;
        CaeLog.d(TAG, "setNefidLowLatencyMode");     // Catch: Throwable -> L8 RemoteException -> L10
        this.mNefidService.R1(r8, r10);     // Catch: Throwable -> L8 RemoteException -> L10
        this.mNefidLowLatencyMode = r8;     // Catch: Throwable -> L8 RemoteException -> L10
    L18:
    L12:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return;
    L6:
        CaeLog.e(TAG, "mNefidService is null !!!!");     // Catch: Throwable -> L8 RemoteException -> L10
    L8:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public boolean setRoamRssiThreshold(int r8, int r10) {
        boolean r11 = false;
        this.mLock.readLock().lock();     // Catch: Throwable -> L9 RemoteException -> L11
        if (this.mNefidService == null) goto L7;
        CaeLog.d(TAG, "setRoamRssiThreshold");     // Catch: Throwable -> L9 RemoteException -> L11
        r11 = this.mNefidService.u(r8, r10);     // Catch: Throwable -> L9 RemoteException -> L11
    L19:
    L13:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return r11;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L9 RemoteException -> L11
    L9:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    public boolean setSoftApTxPower(String r8, int r10, int r11) {
        boolean r12 = false;
        this.mLock.readLock().lock();     // Catch: Throwable -> L11 RemoteException -> L13
        if (this.mNefidService == null) goto L9;
        CaeLog.i(TAG, "setSoftApTxPower ifName=" + r8 + " mode=" + r10 + " dbm=" + r11);     // Catch: Throwable -> L11 RemoteException -> L13
        INefiService r13 = this.mNefidService;     // Catch: Throwable -> L11 RemoteException -> L13
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        r12 = r13.l1(r10, r11, r8);     // Catch: Throwable -> L11 RemoteException -> L13
    L21:
    L15:
        NefidInterface this = this.mLock.readLock();
        this.unlock();
        return r12;
    L9:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L11 RemoteException -> L13
    L11:
        th = move-exception;
        this.mLock.readLock().unlock();
        throw th;
    L13:
        e = move-exception;
        CaeLog.e(TAG, "setSoftApTxPower RemoteException", e);     // Catch: Throwable -> L11
        goto L15
    }

    public boolean startCaptureTask() {
        ReentrantReadWriteLock r8 = this.mLock;
        monitor-enter(r8);
        this.mLock.readLock().lock();     // Catch: Throwable -> L14 RemoteException -> L16
        INefiService r10 = this.mNefidService;     // Catch: Throwable -> L14 RemoteException -> L16
        if (r10 == null) goto L10;
        boolean r11 = r10.W0();     // Catch: Throwable -> L14 RemoteException -> L16
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        return r11;
    L10:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L14 RemoteException -> L16
        ReentrantReadWriteLock.ReadLock r12 = this.mLock.readLock();     // Catch: Throwable -> L24
    L12:
        r12.unlock();     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        return false;
    L14:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L16:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L14
        r12 = this.mLock.readLock();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public void stopCaptureTask() {
        ReentrantReadWriteLock r8 = this.mLock;
        monitor-enter(r8);
        this.mLock.readLock().lock();     // Catch: Throwable -> L11 RemoteException -> L13
        INefiService r10 = this.mNefidService;     // Catch: Throwable -> L11 RemoteException -> L13
        if (r10 == null) goto L7;
        r10.p2();     // Catch: Throwable -> L11 RemoteException -> L13
    L8:
        ReentrantReadWriteLock.ReadLock r11 = this.mLock.readLock();     // Catch: Throwable -> L20
    L9:
        r11.unlock();     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        return;
    L7:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: Throwable -> L11 RemoteException -> L13
    L13:
        e = move-exception;
        CaeLog.e(TAG, "message", e);     // Catch: Throwable -> L11
        r11 = this.mLock.readLock();     // Catch: Throwable -> L20
    L11:
        th = move-exception;
        this.mLock.readLock().unlock();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public void unregisterNefidEventListener(IEventListener r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Object r10 = this.mListenerLock;
        monitor-enter(r10);
        this.mIEventListenerSet.remove(r8);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        INefiService r11 = getNefidService();
        if (r11 == null) goto L11;
        CaeLog.d(TAG, "unregisterNefidEventListener");     // Catch: RemoteException -> L13
        r11.A2(r8);     // Catch: RemoteException -> L13
    L19:
        return;
    L11:
        CaeLog.e(TAG, "mNefidService is null, remove cached listener only");     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        CaeLog.e(TAG, "unregisterNefidEventListener failed", e);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void unregisterNefidInfoListener(INefiListener r8) {
        Object r10 = this.mListenerLock;
        monitor-enter(r10);
        this.mNefiListenerMap.remove(r8);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        INefiService r11 = getNefidService();
        if (r11 == null) goto L9;
        CaeLog.d(TAG, "unregisterNefidInfoListener");     // Catch: RemoteException -> L11
        r11.D(r8);     // Catch: RemoteException -> L11
    L17:
        return;
    L9:
        CaeLog.e(TAG, "mNefidService is null!!!!");     // Catch: RemoteException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
