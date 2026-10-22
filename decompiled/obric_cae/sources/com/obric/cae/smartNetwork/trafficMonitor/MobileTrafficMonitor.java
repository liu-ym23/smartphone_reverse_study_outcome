package com.obric.cae.smartNetwork.trafficMonitor;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import com.obric.cae.log.CaeLog;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class MobileTrafficMonitor {
    private static final String TAG = "MobileTrafficMonitor";
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private boolean mDataEnabled;
    private final TrafficMonitorHandler mHandler;
    private final HandlerThread mHandlerThread;
    private final Object mMonitorLock;
    private final NetworkStatsManager mNetworkStatsManager;
    private boolean mSimReady;
    private int mSubId;
    private final TelephonyCallbackWrapper mTelephonyCallbackWrapper;
    private final TelephonyManager mTelephonyManager;
    private final ConcurrentHashMap<Integer, TrafficInfo> mTrafficInfoMap;
    private final TrafficThreshold mTrafficThreshold;

    public class TelephonyCallbackWrapper extends TelephonyCallback implements TelephonyCallback.ActiveDataSubscriptionIdListener {
        final /* synthetic */ MobileTrafficMonitor this$0;

        private TelephonyCallbackWrapper(MobileTrafficMonitor r8) {
            this.this$0 = r8;
        }

        @Override // android.telephony.TelephonyCallback.ActiveDataSubscriptionIdListener
        public void onActiveDataSubscriptionIdChanged(int r8) {
            Object r10 = MobileTrafficMonitor.access$100(this.this$0);
            monitor-enter(r10);
            CaeLog.i(MobileTrafficMonitor.TAG, "onActiveDataSubscriptionIdChanged. subId: " + r8);     // Catch: Throwable -> L9
            if (r8 == MobileTrafficMonitor.access$500(this.this$0)) goto L7;
            MobileTrafficMonitor.access$502(this.this$0, r8);     // Catch: Throwable -> L9
            MobileTrafficMonitor.access$600(this.this$0).clear();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ TelephonyCallbackWrapper(MobileTrafficMonitor r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static class TrafficInfo {
        int checkType;
        int dataUsage;
        long timeStamp;

        public TrafficInfo() {
        }
    }

    public class TrafficMonitorHandler extends Handler {
        final /* synthetic */ MobileTrafficMonitor this$0;

        public TrafficMonitorHandler(MobileTrafficMonitor r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 3) goto L5;
            Object r11 = MobileTrafficMonitor.access$100(this.this$0);
            monitor-enter(r11);
            MobileTrafficMonitor.access$700(this.this$0, 3);     // Catch: Throwable -> L30
            monitor-exit(r11);     // Catch: Throwable -> L30
            return;
        L30:
            th = move-exception;
            throw th;
        L5:
            if (r10 != 4) goto L7;
            Object r12 = MobileTrafficMonitor.access$100(this.this$0);
            monitor-enter(r12);
            MobileTrafficMonitor.access$700(this.this$0, 4);     // Catch: Throwable -> L22
            monitor-exit(r12);     // Catch: Throwable -> L22
            return;
        L22:
            th = move-exception;
            throw th;
        L7:
            if (r10 != 5) goto L41;
            Object r13 = MobileTrafficMonitor.access$100(this.this$0);
            monitor-enter(r13);
            MobileTrafficMonitor.access$700(this.this$0, 5);     // Catch: Throwable -> L14
            monitor-exit(r13);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public MobileTrafficMonitor(Context r8) {
        this.mTrafficInfoMap = new ConcurrentHashMap();
        this.mMonitorLock = new Object();
        this.mContext = r8;
        this.mNetworkStatsManager = (NetworkStatsManager) r8.getSystemService("netstats");
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        this.mTrafficThreshold = TrafficThreshold.getInstance(r8);
        HandlerThread r10 = new HandlerThread(TAG);
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new TrafficMonitorHandler(this, r10.getLooper());
        this.mTelephonyCallbackWrapper = new TelephonyCallbackWrapper(this, null);
        registerDataCallback();
        registerSimReceiver();
        registerSubIdChangedListener();
        initStateAndStartMonitor();
    }

    public static /* synthetic */ Object access$100(MobileTrafficMonitor r8) {
        return r8.mMonitorLock;
    }

    public static /* synthetic */ TelephonyManager access$200(MobileTrafficMonitor r8) {
        return r8.mTelephonyManager;
    }

    public static /* synthetic */ void access$300(MobileTrafficMonitor r8, boolean r10) {
        r8.handleSimStateChanged(r10);
    }

    public static /* synthetic */ void access$400(MobileTrafficMonitor r8, boolean r10) {
        r8.handleDataStateChanged(r10);
    }

    public static /* synthetic */ int access$500(MobileTrafficMonitor r8) {
        return r8.mSubId;
    }

    public static /* synthetic */ int access$502(MobileTrafficMonitor r8, int r10) {
        r8.mSubId = r10;
        return r10;
    }

    public static /* synthetic */ ConcurrentHashMap access$600(MobileTrafficMonitor r8) {
        return r8.mTrafficInfoMap;
    }

    public static /* synthetic */ void access$700(MobileTrafficMonitor r8, int r10) {
        r8.startTrafficMonitor(r10);
    }

    private String getDefaultSubscriberId() {
        int r8 = SubscriptionManager.getDefaultDataSubscriptionId();
        return this.mTelephonyManager.getSubscriberId(r8);
    }

    private int getTotalDataUsage(int r10, long r11, long r13) {
        long r8 = 0;
        if (r10 != 0) goto L5;
        NetworkStats.Bucket r12 = this.mNetworkStatsManager.querySummaryForDevice(r10, getDefaultSubscriberId(), r11, r13);     // Catch: RemoteException -> L12
    L9:
        if (r12 == null) goto L15;
        r8 = 0 + r12.getRxBytes();     // Catch: RemoteException -> L12
        r8 = r8 + r12.getTxBytes();
    L15:
        return (int) ((r8 / 1024) / 1024);
    L5:
        if (r10 == 1) goto L7;
        r12 = null;
        goto L9
    L7:
        r12 = this.mNetworkStatsManager.querySummaryForDevice(r10, null, r11, r13);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        CaeLog.e(TAG, "querySummaryForDevice failed: " + e.getMessage());
        goto L15
    }

    private void handleDataStateChanged(boolean r8) {
        this.mDataEnabled = r8;
        if (r8 == false) goto L5;
        startTrafficMonitor(3);
        return;
    L5:
        stopTrafficMonitor(3);
    }

    private void handleSimStateChanged(boolean r8) {
        this.mSimReady = r8;
        if (r8 == false) goto L5;
        startTrafficMonitor(4);
        startTrafficMonitor(5);
        return;
    L5:
        stopTrafficMonitor(4);
        stopTrafficMonitor(5);
    }

    private void initStateAndStartMonitor() {
        if (5 != this.mTelephonyManager.getSimState()) goto L5;
        boolean r8 = true;
    L6:
        this.mSimReady = r8;
        this.mDataEnabled = false;
        this.mSubId = SubscriptionManager.getDefaultDataSubscriptionId();
        StringBuilder r10 = new StringBuilder("initStateAndStartMonitor. , mSimReady:");
        r10.append(this.mSimReady);
        r10.append(", mDataEnabled:");
        r10.append(this.mDataEnabled);
        r10.append(", mSubId:");
        defpackage.a.j(r10, this.mSubId, TAG);
        Object r11 = this.mMonitorLock;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.mDataEnabled == false) goto L12;
        startTrafficMonitor(3);     // Catch: Throwable -> L16
    L12:
        if (this.mSimReady == false) goto L14;
        startTrafficMonitor(4);     // Catch: Throwable -> L16
        startTrafficMonitor(5);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L5:
        r8 = false;
        goto L6
    }

    private void registerDataCallback() {
        NetworkRequest r8 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
        this.mConnectivityManager.registerNetworkCallback(r8, new AnonymousClass2(this));
    }

    private void registerSimReceiver() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.SIM_STATE_CHANGED");
        this.mContext.registerReceiver(new AnonymousClass1(this), r8);
    }

    private void registerSubIdChangedListener() {
        TelephonyManager r8 = this.mTelephonyManager;
        final TrafficMonitorHandler r10 = this.mHandler;
        Objects.requireNonNull(r10);
        r8.registerTelephonyCallback(new a(r10), this.mTelephonyCallbackWrapper);
    }

    private void sendTrafficWarningBroadcast() {
        this.mSubId = SubscriptionManager.getDefaultDataSubscriptionId();
        Intent r8 = new Intent(TrafficMonitorUtil.ACTION_TRAFFIC_WARNING);
        r8.putExtra(TrafficMonitorUtil.EXTRA_SUB_ID, this.mSubId);
        this.mContext.sendBroadcast(r8, TrafficMonitorUtil.ACTION_TRAFFIC_WARNING_SECURITY);
    }

    private void startTrafficMonitor(int r8) {
        if (this.mHandler.hasMessages(r8) == true) goto L6;
        trafficWarningCheck(r8);
        this.mHandler.sendEmptyMessageDelayed(r8, TrafficMonitorUtil.getTrafficMonitorInterval(r8));
        return;
    }

    private void stopTrafficMonitor(int r8) {
        if (this.mHandler.hasMessages(r8) == false) goto L6;
        this.mHandler.removeMessages(r8);
        this.mTrafficInfoMap.remove(Integer.valueOf(r8));
        CaeLog.d(TAG, "stopTrafficMonitor. type:" + r8);
        return;
    }

    private void trafficWarningCheck(int r10) {
        TrafficInfo r8 = this.mTrafficInfoMap.get(Integer.valueOf(r10));
        int r11 = getTotalDataUsage(0, 0, System.currentTimeMillis());
        if (r11 != 0) goto L6;
        return;
    L6:
        if (r8 != null) goto L9;
        CaeLog.i(TAG, "start trafficWarningCheck, type: " + r10 + ", totalDataUsage: " + r11 + "M");
        TrafficInfo r12 = new TrafficInfo();
        r12.dataUsage = r11;
        r12.timeStamp = System.currentTimeMillis();
        r12.checkType = r10;
        this.mTrafficInfoMap.put(Integer.valueOf(r10), r12);
        return;
    L9:
        long r13 = r11 - r8.dataUsage;
        r8.dataUsage = r11;
        r8.timeStamp = System.currentTimeMillis();
        int r14 = this.mTrafficThreshold.getTrafficThreshold(r10);
        StringBuilder r15 = defpackage.a.g("internal trafficWarningCheck, type: ", r10, ", interval: ", (((int) TrafficMonitorUtil.getTrafficMonitorInterval(r10)) / 1000) / 60, " min, internalDataUsage: ");
        r15.append(r13);
        r15.append("M, warning threshold: ");
        r15.append(r14);
        android.aimedia.a.r(r15, "M", TAG);
        if (r13 <= r14) goto L13;
        StringBuilder r16 = new StringBuilder("send traffic warning broadcast, type: ");
        r16.append(r10);
        r16.append(", dataUsage: ");
        r16.append(r13);
        android.aimedia.a.r(r16, "M", TAG);
        sendTrafficWarningBroadcast();
        return;
    }
}
