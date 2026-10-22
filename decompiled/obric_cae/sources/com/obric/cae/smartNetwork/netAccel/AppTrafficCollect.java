package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTcpInfo;
import com.obric.cae.smartNetwork.SmartNetworkService;
import com.obric.cae.smartNetwork.throughtput.InternalThroughputListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppTrafficCollect {
    private static final long CHECK_INACTIVE_INTERVAL = 1000;
    private static final long INACTIVE_THRESHOLD = 5000;
    private static final int MSG_CHECK_INACTIVE = 1;
    private static final String TAG = "MultiNetwork-AppTrafficCollect";
    private AtomicBoolean isRunning;
    private AtomicBoolean isWifiThroughputListenerRegistered;
    private final AccelMetric mAccelMetric;
    private final Set<Integer> mAppWhitelist;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final L4NetEvaluate mL4NetEvaluate;
    private final SmartNetworkService mSmartNetworkService;
    private final L4NetEvaluate.L4NetTcpInfoListenerCallback mTrafficStatisticsCallback;
    private final Map<Integer, String> mUidToPackageMap;
    private final ConcurrentHashMap<Integer, UidTrafficInfo> mUidTrafficMap;
    private final ConcurrentHashMap<Integer, List<AppSocketStats.WifiStats>> mUidWifiStatsMap;
    private WiFiThroughputListener mWiFiThroughputListener;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.netAccel.AppTrafficCollect$2, reason: invalid class name */
    public class AnonymousClass2 implements L4NetEvaluate.L4NetTcpInfoListenerCallback {
        final /* synthetic */ AppTrafficCollect this$0;

        public AnonymousClass2(AppTrafficCollect r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ SocketInfo a(L4NetTcpInfo r8, Long r10) {
            return lambda$onL4NetTcpInfoReport$1(r8, r10);
        }

        public static /* synthetic */ UidTrafficInfo b(AnonymousClass2 r8, int r10, Integer r11) {
            return r8.lambda$onL4NetTcpInfoReport$0(r10, r11);
        }

        private /* synthetic */ UidTrafficInfo lambda$onL4NetTcpInfoReport$0(int r8, Integer r10) {
            StringBuilder r11 = defpackage.b.f("Start traffic collection for UID: ", r8, ", package: ");
            r11.append((String) AppTrafficCollect.access$900(this.this$0).get(Integer.valueOf(r8)));
            CaeLog.i(AppTrafficCollect.TAG, r11.toString());
            return new UidTrafficInfo();
        }

        private static /* synthetic */ SocketInfo lambda$onL4NetTcpInfoReport$1(L4NetTcpInfo r8, Long r10) {
            return new SocketInfo(r8);
        }

        @Override // com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate.L4NetTcpInfoListenerCallback
        public void onL4NetTcpInfoReport(ConcurrentHashMap<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> r12) {
            boolean r8 = false;
            if (r12 == null) goto L30;
            Iterator<Map.Entry<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>>> r13 = r12.entrySet().iterator();
            boolean r10 = false;
        L6:
            if (r13.hasNext() == false) goto L29;
            Map.Entry<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> r11 = r13.next();
            final int r14 = r11.getKey().intValue();
            if (AppTrafficCollect.access$700(this.this$0).contains(Integer.valueOf(r14)) == false) goto L6;
            ConcurrentHashMap<Long, L4NetTcpInfo> r15 = r11.getValue();
            if (r15 == null) goto L6;
            if (r15.isEmpty() == true) goto L6;
            Iterator<Map.Entry<Long, L4NetTcpInfo>> r16 = r15.entrySet().iterator();
            int r17 = 0;
        L17:
            if (r16.hasNext() == false) goto L21;
            if (r16.next().getValue().tcpRecvBytes <= 0) goto L17;
            r17 = r17 + 1;
            goto L17
        L21:
            if (r17 <= 0) goto L6;
            UidTrafficInfo r18 = (UidTrafficInfo) AppTrafficCollect.access$300(this.this$0).computeIfAbsent(Integer.valueOf(r14), new a(this, r14));
            r18.updateLastUpdateTime();
            Iterator<Map.Entry<Long, L4NetTcpInfo>> r19 = r15.entrySet().iterator();
        L24:
            if (r19.hasNext() == false) goto L28;
            Map.Entry<Long, L4NetTcpInfo> r20 = r19.next();
            long r21 = r20.getKey().longValue();
            final L4NetTcpInfo r22 = r20.getValue();
            if (r22.tcpRecvBytes <= 0) goto L24;
            r18.socketInfoMap.computeIfAbsent(Long.valueOf(r21), new b(r22)).updateLastUpdateTime(r22);
            goto L24
        L28:
            r10 = true;
            goto L6
        L29:
            r8 = r10;
        L30:
            if (r8 == false) goto L33;
            AppTrafficCollect.access$500(this.this$0);
            return;
        L33:
            if (AppTrafficCollect.access$300(this.this$0).isEmpty() == false) goto L58;
            AppTrafficCollect.access$800(this.this$0);
            return;
        }
    }

    public static class SocketInfo {
        long lastUpdateTime;
        final long startTime;
        final L4NetTcpInfo tcpInfo;
        long totalBytesRecv;

        public SocketInfo(L4NetTcpInfo r8) {
            this.tcpInfo = r8;
            this.totalBytesRecv = r8.tcpRecvBytes;
            long r10 = System.currentTimeMillis();
            this.startTime = r10;
            this.lastUpdateTime = r10;
        }

        public void updateLastUpdateTime(L4NetTcpInfo r8) {
            this.lastUpdateTime = System.currentTimeMillis();
            if (r8 == null) goto L6;
            this.totalBytesRecv += r8.tcpRecvBytes;
            return;
        }
    }

    public static class UidTrafficInfo {
        long lastUpdateTime;
        final ConcurrentHashMap<Long, SocketInfo> socketInfoMap;
        final long startTime;

        public UidTrafficInfo() {
            long r8 = System.currentTimeMillis();
            this.startTime = r8;
            this.lastUpdateTime = r8;
            this.socketInfoMap = new ConcurrentHashMap();
        }

        public boolean isInactive() {
            if ((System.currentTimeMillis() - this.lastUpdateTime) <= 5000) goto L5;
            return true;
        L5:
            return false;
        }

        public void updateLastUpdateTime() {
            this.lastUpdateTime = System.currentTimeMillis();
        }
    }

    public class WiFiThroughputListener implements InternalThroughputListener {
        final /* synthetic */ AppTrafficCollect this$0;

        private WiFiThroughputListener(AppTrafficCollect r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ List a(Integer r8) {
            return lambda$onSecondaryThroughputChanged$1(r8);
        }

        public static /* synthetic */ List b(Integer r8) {
            return lambda$onThroughputChanged$0(r8);
        }

        private static /* synthetic */ List lambda$onSecondaryThroughputChanged$1(Integer r8) {
            return new ArrayList();
        }

        private static /* synthetic */ List lambda$onThroughputChanged$0(Integer r8) {
            return new ArrayList();
        }

        @Override // com.obric.cae.smartNetwork.throughtput.InternalThroughputListener
        public void onSecondaryThroughputChanged(int r8, int r10) {
            long r11 = System.currentTimeMillis();
            Iterator r12 = AppTrafficCollect.access$300(this.this$0).keySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            List r13 = (List) AppTrafficCollect.access$600(this.this$0).computeIfAbsent(Integer.valueOf(((Integer) r12.next()).intValue()), new c(0));
            AppSocketStats.WifiStats.Builder r14 = AppSocketStats.WifiStats.newBuilder();
            r14.setWifiType(1);
            r14.setL2Throughput(r8);
            r14.setTimestamp(r11);
            r13.add(r14.build());
            goto L4
        }

        @Override // com.obric.cae.smartNetwork.throughtput.InternalThroughputListener
        public void onThroughputChanged(int r8, int r10) {
            if (AppTrafficCollect.access$300(this.this$0).isEmpty() == false) goto L5;
        L7:
            long r11 = System.currentTimeMillis();
            Iterator r12 = AppTrafficCollect.access$300(this.this$0).keySet().iterator();
        L9:
            if (r12.hasNext() == false) goto L11;
            List r13 = (List) AppTrafficCollect.access$600(this.this$0).computeIfAbsent(Integer.valueOf(((Integer) r12.next()).intValue()), new d(0));
            AppSocketStats.WifiStats.Builder r14 = AppSocketStats.WifiStats.newBuilder();
            r14.setWifiType(0);
            r14.setL2Throughput(r8);
            r14.setTimestamp(r11);
            r13.add(r14.build());
            goto L9
        L11:
            return;
        L5:
            if (AppTrafficCollect.access$400(this.this$0).get() == true) goto L7;
            AppTrafficCollect.access$500(this.this$0);
            goto L7
        }

        public /* synthetic */ WiFiThroughputListener(AppTrafficCollect r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public AppTrafficCollect(Context r8, SmartNetworkService r10) {
        this.isRunning = new AtomicBoolean(false);
        this.isWifiThroughputListenerRegistered = new AtomicBoolean(false);
        this.mTrafficStatisticsCallback = new AnonymousClass2(this);
        this.mContext = r8;
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        this.mAccelMetric = AccelMetric.getInstance(r8);
        this.mSmartNetworkService = r10;
        this.mAppWhitelist = new HashSet();
        this.mUidToPackageMap = new HashMap();
        this.mUidTrafficMap = new ConcurrentHashMap();
        this.mUidWifiStatsMap = new ConcurrentHashMap();
        this.mWiFiThroughputListener = new WiFiThroughputListener(this, null);
        HandlerThread r11 = new HandlerThread("AppTrafficCollect");
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new Handler(r11.getLooper(), new AnonymousClass1(this));
    }

    public static /* synthetic */ void access$100(AppTrafficCollect r8) {
        r8.checkInactiveUids();
    }

    public static /* synthetic */ Handler access$200(AppTrafficCollect r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ ConcurrentHashMap access$300(AppTrafficCollect r8) {
        return r8.mUidTrafficMap;
    }

    public static /* synthetic */ AtomicBoolean access$400(AppTrafficCollect r8) {
        return r8.isWifiThroughputListenerRegistered;
    }

    public static /* synthetic */ void access$500(AppTrafficCollect r8) {
        r8.registerWifiThroughputListener();
    }

    public static /* synthetic */ ConcurrentHashMap access$600(AppTrafficCollect r8) {
        return r8.mUidWifiStatsMap;
    }

    public static /* synthetic */ Set access$700(AppTrafficCollect r8) {
        return r8.mAppWhitelist;
    }

    public static /* synthetic */ void access$800(AppTrafficCollect r8) {
        r8.unregisterWifiThroughputListener();
    }

    public static /* synthetic */ Map access$900(AppTrafficCollect r8) {
        return r8.mUidToPackageMap;
    }

    private void checkInactiveUids() {
        ArrayList r8 = new ArrayList();
        Iterator<Map.Entry<Integer, UidTrafficInfo>> r10 = this.mUidTrafficMap.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<Integer, UidTrafficInfo> r11 = r10.next();
        if (r11.getValue().isInactive() == false) goto L4;
        r8.add(r11.getKey());
        goto L4
    L8:
        Iterator r12 = r8.iterator();
    L10:
        if (r12.hasNext() == false) goto L13;
        int r13 = ((Integer) r12.next()).intValue();
        android.aimedia.a.r(defpackage.b.f("Stop traffic collection for UID: ", r13, ", package: "), this.mUidToPackageMap.get(Integer.valueOf(r13)), TAG);
        reportUidTraffic(r13);
        this.mUidTrafficMap.remove(Integer.valueOf(r13));
        this.mUidWifiStatsMap.remove(Integer.valueOf(r13));
        goto L10
    L13:
        if (this.mUidTrafficMap.isEmpty() == false) goto L22;
        unregisterWifiThroughputListener();
        return;
    }

    private int getUidByPackageName(String r8) {
        return this.mContext.getPackageManager().getApplicationInfo(r8, 0).uid;
    L4:
        return -1;
    }

    private void registerWifiThroughputListener() {
        if (this.mSmartNetworkService != null) goto L5;
        return;
    L5:
        if (this.mWiFiThroughputListener != null) goto L7;
        return;
    L7:
        if (this.isWifiThroughputListenerRegistered.get() == true) goto L12;
        this.mSmartNetworkService.registerInternalThroughputListener(this.mWiFiThroughputListener);
        this.isWifiThroughputListenerRegistered.set(true);
        CaeLog.i(TAG, "Registered WiFi throughput listener");
        return;
    }

    private void reportAllUids() {
        Iterator<Integer> r8 = this.mUidTrafficMap.keySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        reportUidTraffic(r8.next().intValue());
        goto L4
    }

    private void reportUidTraffic(int r11) {
        UidTrafficInfo r8 = this.mUidTrafficMap.get(Integer.valueOf(r11));
        if (r8 != null) goto L29;
        android.aimedia.a.p("reportUidTraffic: uidTrafficInfo is null for uid: ", r11, TAG);
        return;
    L29:
        AppSocketStats.Builder r10 = AppSocketStats.newBuilder();     // Catch: Exception -> L26
        int r12 = 0;
        r10.setState(0);     // Catch: Exception -> L26
        r10.setStartTimestamp(r8.startTime);     // Catch: Exception -> L26
        r10.setEndTimestamp(r8.lastUpdateTime);     // Catch: Exception -> L26
        AppSocketStats.AppInfo.Builder r13 = AppSocketStats.AppInfo.newBuilder();     // Catch: Exception -> L26
        r13.setUid(r11);     // Catch: Exception -> L26
        String r14 = this.mUidToPackageMap.get(Integer.valueOf(r11));     // Catch: Exception -> L26
        if (r14 == null) goto L9;
        r13.setPackageName(r14);     // Catch: Exception -> L26
    L9:
        r10.setAppInfo(r13.build());     // Catch: Exception -> L26
        Iterator<Map.Entry<Long, SocketInfo>> r15 = r8.socketInfoMap.entrySet().iterator();     // Catch: Exception -> L26
    L11:
        if (r15.hasNext() == false) goto L13;
        SocketInfo r16 = r15.next().getValue();     // Catch: Exception -> L26
        L4NetTcpInfo r17 = r16.tcpInfo;     // Catch: Exception -> L26
        AppSocketStats.SocketStats.Builder r18 = AppSocketStats.SocketStats.newBuilder();     // Catch: Exception -> L26
        r18.setStartTimestamp(r16.startTime);     // Catch: Exception -> L26
        r18.setEndTimestamp(r16.lastUpdateTime);     // Catch: Exception -> L26
        r18.setInterface(r17.ifName);     // Catch: Exception -> L26
        r18.setSrcIp(r17.srcIP);     // Catch: Exception -> L26
        r18.setSrcPort(r17.srcPort);     // Catch: Exception -> L26
        r18.setDstIp(r17.dstIP);     // Catch: Exception -> L26
        r18.setDstPort(r17.dstPort);     // Catch: Exception -> L26
        r18.setTotalBytesRecv(r16.totalBytesRecv);     // Catch: Exception -> L26
        r10.addSocketStats(r18.build());     // Catch: Exception -> L26
        goto L11
    L13:
        List<AppSocketStats.WifiStats> r19 = this.mUidWifiStatsMap.get(Integer.valueOf(r11));     // Catch: Exception -> L26
        if (r19 != null) goto L16;
    L21:
        this.mAccelMetric.reportAppSocketStats(r10.build());     // Catch: Exception -> L26
        StringBuilder r20 = new StringBuilder();     // Catch: Exception -> L26
        r20.append("Report traffic for UID: ");     // Catch: Exception -> L26
        r20.append(r11);     // Catch: Exception -> L26
        r20.append(" successfully, socket count: ");     // Catch: Exception -> L26
        r20.append(r8.socketInfoMap.size());     // Catch: Exception -> L26
        r20.append(", wifi stats count: ");     // Catch: Exception -> L26
        if (this.mUidWifiStatsMap.get(Integer.valueOf(r11)) == null) goto L24;
        r12 = this.mUidWifiStatsMap.get(Integer.valueOf(r11)).size();     // Catch: Exception -> L26
    L24:
        r20.append(r12);     // Catch: Exception -> L26
        CaeLog.i(TAG, r20.toString());     // Catch: Exception -> L26
        return;
    L16:
        if (r19.isEmpty() == true) goto L21;
        Iterator<AppSocketStats.WifiStats> r21 = r19.iterator();     // Catch: Exception -> L26
    L19:
        if (r21.hasNext() == false) goto L21;
        r10.addWifiStats(r21.next());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        CaeLog.e(TAG, "reportUidTraffic failed: " + e.getMessage(), e);
    }

    private void unregisterWifiThroughputListener() {
        if (this.mSmartNetworkService != null) goto L5;
        return;
    L5:
        if (this.mWiFiThroughputListener != null) goto L7;
        return;
    L7:
        if (this.isWifiThroughputListenerRegistered.get() == false) goto L12;
        this.mSmartNetworkService.unregisterInternalThroughputListener(this.mWiFiThroughputListener);
        this.isWifiThroughputListenerRegistered.set(false);
        CaeLog.i(TAG, "Unregistered WiFi throughput listener");
        return;
    }

    public void setAppWhitelist(List<String> r8) {
        this.mAppWhitelist.clear();
        this.mUidToPackageMap.clear();
        Iterator<String> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        String r11 = r10.next();
        int r12 = getUidByPackageName(r11);
        if (r12 <= 0) goto L4;
        this.mAppWhitelist.add(Integer.valueOf(r12));
        this.mUidToPackageMap.put(Integer.valueOf(r12), r11);
        goto L4
    L8:
        CaeLog.i(TAG, "setAppWhitelist: whitelist updated with " + this.mAppWhitelist.size() + " UIDs");
        ArrayList r13 = new ArrayList();
        Iterator<Integer> r14 = this.mUidTrafficMap.keySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        int r15 = r14.next().intValue();
        if (this.mAppWhitelist.contains(Integer.valueOf(r15)) == true) goto L10;
        r13.add(Integer.valueOf(r15));
        goto L10
    L14:
        Iterator r16 = r13.iterator();
    L16:
        if (r16.hasNext() == false) goto L19;
        int r17 = ((Integer) r16.next()).intValue();
        this.mUidTrafficMap.remove(Integer.valueOf(r17));
        this.mUidWifiStatsMap.remove(Integer.valueOf(r17));
        goto L16
    L19:
        if (this.mUidTrafficMap.isEmpty() == true) goto L21;
        registerWifiThroughputListener();
        return;
    L21:
        unregisterWifiThroughputListener();
    }

    public void start() {
        if (this.isRunning.get() == false) goto L5;
        return;
    L5:
        this.isRunning.set(true);
        CaeLog.i(TAG, "start: isRegistered: " + this.mL4NetEvaluate.registerL4NetTcpInfoListener(this.mTrafficStatisticsCallback));
        this.mHandler.sendEmptyMessage(1);
    }

    public void stop() {
        if (this.isRunning.get() == true) goto L5;
        return;
    L5:
        this.isRunning.set(false);
        CaeLog.i(TAG, "stop: isUnregistered: " + this.mL4NetEvaluate.unregisterL4NetTcpInfoListener(this.mTrafficStatisticsCallback));
        unregisterWifiThroughputListener();
        this.mHandler.removeCallbacksAndMessages(null);
        reportAllUids();
        this.mUidTrafficMap.clear();
        this.mUidWifiStatsMap.clear();
    }
}
