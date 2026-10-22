package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficStatsMonitor {
    private static final int MSG_BACKGROUND_LONG_TIME_TRAFFIC_STATS = 2;
    private static final int MSG_BACKGROUND_SHORT_TIME_TRAFFIC_STATS = 1;
    private static final String TAG = "TrafficStatsMonitor";
    public static final int TRAFFIC_MONITOR_STATE_NORMAL = 2;
    public static final int TRAFFIC_MONITOR_STATE_WARNING = 1;
    public static final int TRAFFIC_WARNING_TYPE_BACKGROUND = 1;
    public static final int TRAFFIC_WARNING_TYPE_NONE = 0;
    public static final int TRAFFIC_WARNING_TYPE_TOTAL = 2;
    private final ActivityMonitor mActivityMonitor;
    private final Context mContext;
    private final MonitorHandler mHandler;
    private final HandlerThread mHandlerThread;
    private final HandoverParameterManager mHandoverParameterManager;
    private boolean mHasForegroundApp;
    private boolean mIsLongTimeTrafficStatsRunning;
    private boolean mIsShortTimeTrafficStatsRunning;
    private TrafficInfo mLongTimeCurrentTrafficInfo;
    private TrafficInfo mLongTimeLastTrafficInfo;
    private int mLongTrafficMonitorState;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private final Map<Integer, Integer> mNetworksState;
    private String mPackageName;
    private TrafficInfo mShortTimeCurrentTrafficInfo;
    private TrafficInfo mShortTimeLastTrafficInfo;
    private int mShortTrafficMonitorState;
    private final Object mTrafficStatsLock;

    public class MonitorHandler extends Handler {
        final /* synthetic */ TrafficStatsMonitor this$0;

        public MonitorHandler(TrafficStatsMonitor r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            int r11 = 1;
            if (r10 == 1) goto L15;
            r11 = 2;
            if (r10 != 2) goto L29;
            Object r12 = TrafficStatsMonitor.access$200(this.this$0);
            monitor-enter(r12);
            TrafficStatsMonitor.access$900(this.this$0);     // Catch: Throwable -> L12
            monitor-exit(r12);     // Catch: Throwable -> L12
            MonitorHandler r13 = TrafficStatsMonitor.access$800(this.this$0);
            int r14 = TrafficStatsMonitor.access$700(this.this$0).getTrafficStatsLongInterval();
        L20:
            r13.sendEmptyMessageDelayed(r11, r14);
            return;
        L12:
            th = move-exception;
            throw th;
        L29:
            return;
        L15:
            Object r15 = TrafficStatsMonitor.access$200(this.this$0);
            monitor-enter(r15);
            TrafficStatsMonitor.access$600(this.this$0);     // Catch: Throwable -> L22
            monitor-exit(r15);     // Catch: Throwable -> L22
            r13 = TrafficStatsMonitor.access$800(this.this$0);
            r14 = TrafficStatsMonitor.access$700(this.this$0).getTrafficStatsShortInterval();
        L22:
            th = move-exception;
            throw th;
        }
    }

    public static class TrafficInfo {
        private long appRxBytes;
        private long appTxBytes;
        private String packageName;
        private long totalRxBytes;
        private long totalTxBytes;
        private int uid;

        private TrafficInfo() {
        }

        public /* synthetic */ TrafficInfo(AnonymousClass1 r8) {
            this();
        }

        public static /* synthetic */ String access$1100(TrafficInfo r8) {
            return r8.packageName;
        }

        public static /* synthetic */ String access$1102(TrafficInfo r8, String r10) {
            r8.packageName = r10;
            return r10;
        }

        public static /* synthetic */ int access$1200(TrafficInfo r8) {
            return r8.uid;
        }

        public static /* synthetic */ int access$1202(TrafficInfo r8, int r10) {
            r8.uid = r10;
            return r10;
        }

        public static /* synthetic */ long access$1300(TrafficInfo r8) {
            return r8.appRxBytes;
        }

        public static /* synthetic */ long access$1302(TrafficInfo r8, long r10) {
            r8.appRxBytes = r10;
            return r10;
        }

        public static /* synthetic */ long access$1400(TrafficInfo r8) {
            return r8.appTxBytes;
        }

        public static /* synthetic */ long access$1402(TrafficInfo r8, long r10) {
            r8.appTxBytes = r10;
            return r10;
        }

        public static /* synthetic */ long access$1500(TrafficInfo r8) {
            return r8.totalTxBytes;
        }

        public static /* synthetic */ long access$1502(TrafficInfo r8, long r10) {
            r8.totalTxBytes = r10;
            return r10;
        }

        public static /* synthetic */ long access$1600(TrafficInfo r8) {
            return r8.totalRxBytes;
        }

        public static /* synthetic */ long access$1602(TrafficInfo r8, long r10) {
            r8.totalRxBytes = r10;
            return r10;
        }
    }

    public TrafficStatsMonitor(Context r8, NetworkPolicyCenter r10) {
        this.mShortTimeLastTrafficInfo = null;
        this.mShortTimeCurrentTrafficInfo = null;
        this.mLongTimeLastTrafficInfo = null;
        this.mLongTimeCurrentTrafficInfo = null;
        this.mShortTrafficMonitorState = 2;
        this.mLongTrafficMonitorState = 2;
        this.mIsShortTimeTrafficStatsRunning = false;
        this.mIsLongTimeTrafficStatsRunning = false;
        this.mPackageName = null;
        this.mHasForegroundApp = false;
        this.mNetworksState = new HashMap();
        this.mTrafficStatsLock = new Object();
        this.mContext = r8;
        this.mNetworkPolicyCenter = r10;
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        HandlerThread r11 = new HandlerThread("TrafficStatsMonitorThread");
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new MonitorHandler(this, r11.getLooper());
        ActivityMonitor r12 = ActivityMonitor.getInstance(r8);
        this.mActivityMonitor = r12;
        r12.registerActivityListener(new AnonymousClass1(this));
    }

    public static /* synthetic */ String access$000(TrafficStatsMonitor r8) {
        return r8.mPackageName;
    }

    public static /* synthetic */ String access$002(TrafficStatsMonitor r8, String r10) {
        r8.mPackageName = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$100(TrafficStatsMonitor r8) {
        return r8.mHasForegroundApp;
    }

    public static /* synthetic */ boolean access$102(TrafficStatsMonitor r8, boolean r10) {
        r8.mHasForegroundApp = r10;
        return r10;
    }

    public static /* synthetic */ Object access$200(TrafficStatsMonitor r8) {
        return r8.mTrafficStatsLock;
    }

    public static /* synthetic */ Map access$300(TrafficStatsMonitor r8) {
        return r8.mNetworksState;
    }

    public static /* synthetic */ void access$400(TrafficStatsMonitor r8) {
        r8.stopShortTrafficStatsMonitor();
    }

    public static /* synthetic */ void access$500(TrafficStatsMonitor r8) {
        r8.startShortTimeTrafficStatsMonitor();
    }

    public static /* synthetic */ void access$600(TrafficStatsMonitor r8) {
        r8.backgroundTrafficStats();
    }

    public static /* synthetic */ HandoverParameterManager access$700(TrafficStatsMonitor r8) {
        return r8.mHandoverParameterManager;
    }

    public static /* synthetic */ MonitorHandler access$800(TrafficStatsMonitor r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$900(TrafficStatsMonitor r8) {
        r8.totalTrafficStats();
    }

    private void backgroundTrafficStats() {
        this.mShortTimeLastTrafficInfo = this.mShortTimeCurrentTrafficInfo;
        TrafficInfo r8 = new TrafficInfo(null);
        this.mShortTimeCurrentTrafficInfo = r8;
        TrafficInfo.access$1102(r8, this.mPackageName);
        TrafficInfo.access$1202(this.mShortTimeCurrentTrafficInfo, NetworkUtil.getUidFromPackageName(this.mContext, this.mPackageName));
        TrafficInfo r10 = this.mShortTimeCurrentTrafficInfo;
        TrafficInfo.access$1302(r10, TrafficStats.getUidRxBytes(TrafficInfo.access$1200(r10)));
        TrafficInfo r11 = this.mShortTimeCurrentTrafficInfo;
        TrafficInfo.access$1402(r11, TrafficStats.getUidTxBytes(TrafficInfo.access$1200(r11)));
        TrafficInfo.access$1502(this.mShortTimeCurrentTrafficInfo, TrafficStats.getTotalTxBytes());
        TrafficInfo.access$1602(this.mShortTimeCurrentTrafficInfo, TrafficStats.getTotalRxBytes());
        if (this.mShortTimeLastTrafficInfo != null) goto L6;
        return;
    L6:
        if (this.mHasForegroundApp == true) goto L9;
        return;
    L9:
        if (TrafficInfo.access$1200(this.mShortTimeCurrentTrafficInfo) == TrafficInfo.access$1200(this.mShortTimeLastTrafficInfo)) goto L11;
        return;
    L11:
        long r12 = ((((TrafficInfo.access$1300(this.mShortTimeCurrentTrafficInfo) - TrafficInfo.access$1300(this.mShortTimeLastTrafficInfo)) + TrafficInfo.access$1400(this.mShortTimeCurrentTrafficInfo)) - TrafficInfo.access$1400(this.mShortTimeLastTrafficInfo)) / 1024) / 1024;
        long r13 = ((((TrafficInfo.access$1600(this.mShortTimeCurrentTrafficInfo) - TrafficInfo.access$1600(this.mShortTimeLastTrafficInfo)) + TrafficInfo.access$1500(this.mShortTimeCurrentTrafficInfo)) - TrafficInfo.access$1500(this.mShortTimeLastTrafficInfo)) / 1024) / 1024;
        long r14 = r13 - r12;
        CaeLog.i(TAG, "packageName = " + TrafficInfo.access$1100(this.mShortTimeCurrentTrafficInfo) + ", uid = " + TrafficInfo.access$1200(this.mShortTimeCurrentTrafficInfo) + ", interval = " + this.mHandoverParameterManager.getTrafficStatsShortInterval() + "ms, totalDataUsage = " + r13 + "MB, appDataUsage = " + r12 + "MB, backgroundDataUsage = " + r14 + "MB");
        if (r14 <= this.mHandoverParameterManager.getTrafficStatsShortWarningThreshold()) goto L16;
        int r15 = 1;
    L14:
        this.mShortTrafficMonitorState = r15;
        sendTrafficStatsStateEvent();
        return;
    L16:
        if (r14 >= this.mHandoverParameterManager.getTrafficStatsShortNormalThreshold()) goto L19;
        r15 = 2;
        goto L14
    }

    private void sendTrafficStatsStateEvent() {
        int r8 = this.mShortTrafficMonitorState;
        int r10 = 2;
        if (r8 == 1) goto L10;
        int r11 = this.mLongTrafficMonitorState;
        if (r11 == 1) goto L10;
        if (r8 != 2) goto L15;
        if (r11 != 2) goto L16;
        Message r12 = this.mNetworkPolicyCenter.obtainMessage(15, 2, 0);
    L13:
        this.mNetworkPolicyCenter.sendMessage(r12);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        if (r8 != 1) goto L12;
        r10 = 1;
    L12:
        r12 = this.mNetworkPolicyCenter.obtainMessage(15, 1, r10);
        goto L13
    }

    private void startLongTimeTrafficStatsMonitor() {
        if (this.mHandler.hasMessages(2) == false) goto L5;
        return;
    L5:
        CaeLog.d(TAG, "startLongTimeTrafficStatsMonitor. interval = " + this.mHandoverParameterManager.getTrafficStatsLongInterval() + "ms");
        this.mHandler.sendEmptyMessage(2);
        this.mIsLongTimeTrafficStatsRunning = true;
    }

    private void startShortTimeTrafficStatsMonitor() {
        if (this.mHandler.hasMessages(1) == false) goto L5;
        return;
    L5:
        CaeLog.d(TAG, "startShortTimeTrafficStatsMonitor. interval = " + this.mHandoverParameterManager.getTrafficStatsShortInterval() + "ms");
        this.mHandler.sendEmptyMessage(1);
        this.mIsShortTimeTrafficStatsRunning = true;
    }

    private void stopLongTrafficStatsMonitor() {
        if (this.mHandler.hasMessages(2) == false) goto L5;
        CaeLog.d(TAG, "stopLongTrafficStatsMonitor");
        this.mHandler.removeMessages(2);
    L5:
        this.mLongTimeLastTrafficInfo = null;
        this.mLongTimeCurrentTrafficInfo = null;
        this.mIsLongTimeTrafficStatsRunning = false;
    }

    private void stopShortTrafficStatsMonitor() {
        if (this.mHandler.hasMessages(1) == false) goto L5;
        CaeLog.d(TAG, "stopShortTrafficStatsMonitor");
        this.mHandler.removeMessages(1);
    L5:
        this.mShortTimeLastTrafficInfo = null;
        this.mShortTimeCurrentTrafficInfo = null;
        this.mIsShortTimeTrafficStatsRunning = false;
        this.mShortTrafficMonitorState = 2;
        sendTrafficStatsStateEvent();
    }

    private void totalTrafficStats() {
        this.mLongTimeLastTrafficInfo = this.mLongTimeCurrentTrafficInfo;
        TrafficInfo r8 = new TrafficInfo(null);
        this.mLongTimeCurrentTrafficInfo = r8;
        TrafficInfo.access$1502(r8, TrafficStats.getTotalTxBytes());
        TrafficInfo.access$1602(this.mLongTimeCurrentTrafficInfo, TrafficStats.getTotalRxBytes());
        if (this.mLongTimeLastTrafficInfo != null) goto L5;
        return;
    L5:
        long r10 = ((((TrafficInfo.access$1600(this.mLongTimeCurrentTrafficInfo) - TrafficInfo.access$1600(this.mLongTimeLastTrafficInfo)) + TrafficInfo.access$1500(this.mLongTimeCurrentTrafficInfo)) - TrafficInfo.access$1500(this.mLongTimeLastTrafficInfo)) / 1024) / 1024;
        StringBuilder r11 = new StringBuilder("interval = ");
        r11.append(this.mHandoverParameterManager.getTrafficStatsLongInterval());
        r11.append("ms, totalDataUsage = ");
        r11.append(r10);
        android.aimedia.a.r(r11, "MB", TAG);
        if (r10 <= this.mHandoverParameterManager.getTrafficStatsLongWarningThreshold()) goto L9;
        int r12 = 1;
    L11:
        this.mLongTrafficMonitorState = r12;
        sendTrafficStatsStateEvent();
        return;
    L9:
        if (r10 >= this.mHandoverParameterManager.getTrafficStatsLongNormalThreshold()) goto L13;
        r12 = 2;
        goto L11
    }

    public void addNetworkState(int r8, int r10) {
        Object r11 = this.mTrafficStatsLock;
        monitor-enter(r11);
        this.mNetworksState.put(Integer.valueOf(r8), Integer.valueOf(r10));     // Catch: Throwable -> L12
        if (this.mIsShortTimeTrafficStatsRunning == true) goto L8;
        startShortTimeTrafficStatsMonitor();     // Catch: Throwable -> L12
    L8:
        if (this.mIsLongTimeTrafficStatsRunning == true) goto L10;
        startLongTimeTrafficStatsMonitor();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeNetworkState(int r8) {
        Object r10 = this.mTrafficStatsLock;
        monitor-enter(r10);
        this.mNetworksState.remove(Integer.valueOf(r8));     // Catch: Throwable -> L14
        if (this.mNetworksState.isEmpty() == true) goto L7;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mIsShortTimeTrafficStatsRunning == false) goto L10;
        stopShortTrafficStatsMonitor();     // Catch: Throwable -> L14
    L10:
        if (this.mIsLongTimeTrafficStatsRunning == false) goto L12;
        stopLongTrafficStatsMonitor();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
