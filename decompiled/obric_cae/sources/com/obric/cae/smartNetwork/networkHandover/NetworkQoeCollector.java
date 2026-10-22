package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.os.Message;
import android.os.SystemProperties;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;
import com.obric.cae.smartNetwork.qoe.CellularLteQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularNrQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoECallback;
import com.obric.cae.smartNetwork.qoe.CellularQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluate;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluateStats;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.smartNetwork.qoe.WiFiQoECallback;
import com.obric.cae.smartNetwork.qoe.WiFiQoEParam;
import com.obric.cae.statusReport.network.NetworkQoEInfoCollector;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkQoeCollector implements WiFiQoECallback, CellularQoECallback, ActivityMonitor.ActivityMonitorListener {
    private static final boolean DEBUG = true;
    private static final int QOE_LEVEL_BAD = 2;
    private static final int QOE_LEVEL_GOOD = 1;
    private static final String TAG = "NetworkQoeCollector";
    private static final String WIFI_QOS_RX_PROPERTY_KEY = "sys.wifi.qos.rx";
    private static final String WIFI_QOS_TX_PROPERTY_KEY = "sys.wifi.qos.tx";
    private final ActivityMonitor mActivityMonitor;
    private int mCellDataLevel;
    private CellQoeQueue mCellQoeQueue;
    private int mCellSignalLevel;
    private final Context mContext;
    private final HandoverParameterManager mHandoverParameterManager;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private final NetworkQoEInfoCollector mNetworkQoEInfoCollector;
    private final NetworkQoEMonitor mNetworkQoEMonitor;
    private int mWifiQoeLevel;
    private WifiQoeQueue mWifiQoeQueue;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkHandover.NetworkQoeCollector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CellQoeQueue {
        private final Queue<CellularQoeEvaluateStats> cellQoeQueue;
        private int continueBadTimes;
        private int continueGoodTimes;
        private boolean isRlfError;
        private int occurBadTimes;
        final /* synthetic */ NetworkQoeCollector this$0;

        private CellQoeQueue(NetworkQoeCollector r8) {
            this.this$0 = r8;
            this.cellQoeQueue = new LinkedList();
        }

        public static /* synthetic */ int access$1000(CellQoeQueue r8) {
            return r8.occurBadTimes;
        }

        public static /* synthetic */ int access$1100(CellQoeQueue r8) {
            return r8.continueGoodTimes;
        }

        public static /* synthetic */ void access$200(CellQoeQueue r8) {
            r8.clear();
        }

        public static /* synthetic */ void access$700(CellQoeQueue r8, CellularQoeEvaluateStats r10) {
            r8.add(r10);
        }

        public static /* synthetic */ boolean access$800(CellQoeQueue r8) {
            return r8.isRlfError;
        }

        public static /* synthetic */ int access$900(CellQoeQueue r8) {
            return r8.continueBadTimes;
        }

        private void add(CellularQoeEvaluateStats r8) {
            if (this.cellQoeQueue.size() < NetworkQoeCollector.access$1200(this.this$0).getCellQosCheckTimes()) goto L5;
            poll();
        L5:
            this.cellQoeQueue.add(r8);
            this.isRlfError = NetworkQoeCollector.access$1300(this.this$0, r8);
            if (NetworkQoeCollector.access$1400(this.this$0, r8) == false) goto L9;
            this.continueBadTimes++;
            this.occurBadTimes++;
            this.continueGoodTimes = 0;
            return;
        L9:
            if (this.continueGoodTimes >= NetworkQoeCollector.access$1200(this.this$0).getCellQosCheckTimes()) goto L11;
            this.continueGoodTimes++;
        L11:
            this.continueBadTimes = 0;
        }

        private void clear() {
            this.occurBadTimes = 0;
            this.continueBadTimes = 0;
            this.continueGoodTimes = 0;
            this.isRlfError = false;
            this.cellQoeQueue.clear();
        }

        private void poll() {
            if (NetworkQoeCollector.access$1400(this.this$0, this.cellQoeQueue.poll()) == true) goto L5;
            return;
        L5:
            if (this.continueBadTimes < NetworkQoeCollector.access$1200(this.this$0).getCellQosCheckTimes()) goto L7;
            this.continueBadTimes--;
        L7:
            this.occurBadTimes--;
        }

        public /* synthetic */ CellQoeQueue(NetworkQoeCollector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class WifiQoeQueue {
        private int continueRxBadTputTimes;
        private int continueRxGoodTputTimes;
        private int continueTxBadTputTimes;
        private int continueTxGoodTputTimes;
        final /* synthetic */ NetworkQoeCollector this$0;
        private final Queue<WiFiQoEParam> wifiQoEParamQueue;

        private WifiQoeQueue(NetworkQoeCollector r8) {
            this.this$0 = r8;
            this.wifiQoEParamQueue = new LinkedList();
        }

        public static /* synthetic */ int access$300(WifiQoeQueue r8) {
            return r8.continueRxBadTputTimes;
        }

        public static /* synthetic */ int access$400(WifiQoeQueue r8) {
            return r8.continueTxBadTputTimes;
        }

        public static /* synthetic */ int access$500(WifiQoeQueue r8) {
            return r8.continueRxGoodTputTimes;
        }

        public static /* synthetic */ int access$600(WifiQoeQueue r8) {
            return r8.continueTxGoodTputTimes;
        }

        public void add(WiFiQoEParam r8) {
            if (r8.getBand() != 0) goto L5;
            int r10 = NetworkQoeCollector.access$1200(this.this$0).getWifi24GGoodTputThreshold();
        L7:
            if (r8.getBand() != 0) goto L9;
            int r11 = NetworkQoeCollector.access$1200(this.this$0).getWifi24GBadTputThreshold();
        L11:
            if (this.wifiQoEParamQueue.size() < NetworkQoeCollector.access$1200(this.this$0).getWifiQosCheckTimes()) goto L13;
            poll();
        L13:
            this.wifiQoEParamQueue.add(r8);
            if (r8.getRxThroughput() >= r11) goto L18;
            this.continueRxBadTputTimes++;
        L16:
            this.continueRxGoodTputTimes = 0;
        L25:
            if (r8.getTxThroughput() >= r11) goto L29;
            this.continueTxBadTputTimes++;
        L27:
            this.continueTxGoodTputTimes = 0;
            return;
        L29:
            if (r8.getTxThroughput() >= r10) goto L32;
            this.continueTxBadTputTimes = 0;
            goto L27
        L32:
            if (this.continueTxGoodTputTimes >= NetworkQoeCollector.access$1200(this.this$0).getWifiQosCheckTimes()) goto L34;
            this.continueTxGoodTputTimes++;
        L34:
            this.continueTxBadTputTimes = 0;
            return;
        L18:
            if (r8.getRxThroughput() >= r10) goto L21;
            this.continueRxBadTputTimes = 0;
            goto L16
        L21:
            if (this.continueRxGoodTputTimes >= NetworkQoeCollector.access$1200(this.this$0).getWifiQosCheckTimes()) goto L23;
            this.continueRxGoodTputTimes++;
        L23:
            this.continueRxBadTputTimes = 0;
            goto L25
        L9:
            r11 = NetworkQoeCollector.access$1200(this.this$0).getWifi5GBadTputThreshold();
            goto L11
        L5:
            r10 = NetworkQoeCollector.access$1200(this.this$0).getWifi5GGoodTputThreshold();
            goto L7
        }

        public void clear() {
            this.continueRxBadTputTimes = 0;
            this.continueRxGoodTputTimes = 0;
            this.continueTxBadTputTimes = 0;
            this.continueTxGoodTputTimes = 0;
            this.wifiQoEParamQueue.clear();
        }

        public void poll() {
            WiFiQoEParam r8 = this.wifiQoEParamQueue.poll();
            if (r8.getBand() != 0) goto L5;
            int r10 = NetworkQoeCollector.access$1200(this.this$0).getWifi24GBadTputThreshold();
        L7:
            if (r8.getRxThroughput() >= r10) goto L12;
            if (this.continueRxBadTputTimes < NetworkQoeCollector.access$1200(this.this$0).getWifiQosCheckBadTimes()) goto L12;
            this.continueRxBadTputTimes--;
        L12:
            if (r8.getTxThroughput() < r10) goto L14;
            return;
        L14:
            if (this.continueTxBadTputTimes < NetworkQoeCollector.access$1200(this.this$0).getWifiQosCheckBadTimes()) goto L18;
            this.continueTxBadTputTimes--;
            return;
        L18:
            return;
        L5:
            r10 = NetworkQoeCollector.access$1200(this.this$0).getWifi5GBadTputThreshold();
            goto L7
        }

        public /* synthetic */ WifiQoeQueue(NetworkQoeCollector r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public NetworkQoeCollector(Context r8, NetworkPolicyCenter r10, NetworkQoEMonitor r11, ActivityMonitor r12) {
        this.mWifiQoeLevel = 1;
        this.mCellSignalLevel = 1;
        this.mCellDataLevel = 1;
        AnonymousClass1 r13 = null;
        this.mWifiQoeQueue = new WifiQoeQueue(this, r13);
        this.mCellQoeQueue = new CellQoeQueue(this, r13);
        this.mContext = r8;
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        this.mNetworkPolicyCenter = r10;
        this.mNetworkQoEMonitor = r11;
        this.mActivityMonitor = r12;
        this.mNetworkQoEInfoCollector = NetworkQoEInfoCollector.getInstance(r8);
    }

    public static /* synthetic */ HandoverParameterManager access$1200(NetworkQoeCollector r8) {
        return r8.mHandoverParameterManager;
    }

    public static /* synthetic */ boolean access$1300(NetworkQoeCollector r8, CellularQoeEvaluateStats r10) {
        return r8.hasRlfError(r10);
    }

    public static /* synthetic */ boolean access$1400(NetworkQoeCollector r8, CellularQoeEvaluateStats r10) {
        return r8.hasRetransError(r10);
    }

    private boolean hasRetransError(CellularQoeEvaluateStats r8) {
        if ((r8.errBitMap & CellularQoeEvaluate.ErrorType.UP_RETRANS_ERR.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasRlfError(CellularQoeEvaluateStats r8) {
        if ((r8.errBitMap & CellularQoeEvaluate.ErrorType.RLF_ERR.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isBadCellQoE(CellularQoeEvaluateStats r8) {
        if (this.mCellSignalLevel != 2) goto L6;
        return true;
    L6:
        if (hasRetransError(r8) == false) goto L8;
    L12:
        return true;
    L8:
        if (hasRlfError(r8) == true) goto L12;
        return false;
    }

    private boolean isBadWifiQoE(WiFiQoEParam r8) {
        int r10 = r8.getBand();
        HandoverParameterManager r11 = this.mHandoverParameterManager;
        if (r10 != 0) goto L5;
        int r12 = r11.getWifi24GBadTputThreshold();
    L6:
        int r13 = r8.getTxThroughput();
        if (r8.getRxThroughput() < r12) goto L11;
        if (r13 < r12) goto L11;
        return false;
    L11:
        return true;
    L5:
        r12 = r11.getWifi5GBadTputThreshold();
        goto L6
    }

    private void sendCellQoeLevelMsg() {
        int r8 = this.mCellSignalLevel;
        if (r8 == 2) goto L11;
        int r10 = this.mCellDataLevel;
        if (r10 == 2) goto L11;
        if (r8 != 1) goto L14;
        if (r10 != 1) goto L15;
        NetworkPolicyCenter r11 = this.mNetworkPolicyCenter;
        int r12 = 5;
    L12:
        Message r13 = r11.obtainMessage(r12, 0, 0);
        this.mNetworkPolicyCenter.sendMessage(r13);
        return;
    L15:
        return;
    L14:
        return;
    L11:
        r11 = this.mNetworkPolicyCenter;
        r12 = 6;
        goto L12
    }

    private void updateCellQoeLevel(CellularQoEParam r8) {
        this.mCellSignalLevel = 2;
        boolean r10 = true;
        if ((r8 instanceof CellularNrQoEParam) == false) goto L10;
        StringBuilder r11 = new StringBuilder("NR Cell Report: Rsrp = ");
        CellularNrQoEParam r12 = (CellularNrQoEParam) r8;
        r11.append(r12.getSsRsrp());
        r11.append(" Rsrq = ");
        r11.append(r12.getSsRsrq());
        CaeLog.i(TAG, r11.toString());
        if (r12.getSsRsrp() >= this.mHandoverParameterManager.getCellNrRsrpThreshold()) goto L7;
    L16:
        NetworkQoEInfoCollector r13 = this.mNetworkQoEInfoCollector;
        if (this.mCellSignalLevel == 1) goto L20;
        r10 = false;
    L20:
        r13.updateL2QoEInfo(0, r10, 0, 0);
        sendCellQoeLevelMsg();
        return;
    L7:
        if (r12.getSsRsrq() < this.mHandoverParameterManager.getCellNrRsrqThreshold()) goto L16;
    L8:
        this.mCellSignalLevel = 1;
        goto L16
    L10:
        if ((r8 instanceof CellularLteQoEParam) == false) goto L16;
        StringBuilder r14 = new StringBuilder("LTE Cell Report: Rsrp = ");
        CellularLteQoEParam r15 = (CellularLteQoEParam) r8;
        r14.append(r15.getRsrp());
        r14.append(" Rsrq = ");
        r14.append(r15.getRsrq());
        CaeLog.i(TAG, r14.toString());
        if (r15.getRsrp() < this.mHandoverParameterManager.getCellLteRsrpThreshold()) goto L16;
        if (r15.getRsrq() < this.mHandoverParameterManager.getCellLteRsrqThreshold()) goto L16;
        goto L16
    }

    private void updateCellQoeStats(CellularQoeEvaluateStats r8) {
        this.mNetworkQoEInfoCollector.updateL2QoEInfo(0, !isBadCellQoE(r8), 0, 0);
        CellQoeQueue.access$700(this.mCellQoeQueue, r8);
        if (CellQoeQueue.access$800(this.mCellQoeQueue) == false) goto L5;
    L12:
        this.mCellDataLevel = 2;
    L14:
        if (this.mCellSignalLevel != 2) goto L16;
    L17:
        StringBuilder r10 = new StringBuilder("Cell L2 Qoe Info:  RlfError = ");
        r10.append(CellQoeQueue.access$800(this.mCellQoeQueue));
        r10.append(" ContinueGoodTimes = ");
        r10.append(CellQoeQueue.access$1100(this.mCellQoeQueue));
        r10.append(" ContinueBadTimes = ");
        r10.append(CellQoeQueue.access$900(this.mCellQoeQueue));
        r10.append(" OccurErrorTimes = ");
        r10.append(CellQoeQueue.access$1000(this.mCellQoeQueue));
        r10.append(" L2CellSignalLevel = ");
        String r11 = "GOOD";
        if (this.mCellSignalLevel != 1) goto L20;
        String r12 = "GOOD";
    L21:
        r10.append(r12);
        r10.append(" L2CellDataLevel = ");
        if (this.mCellDataLevel == 1) goto L25;
        r11 = "BAD";
    L25:
        android.aimedia.a.r(r10, r11, TAG);
    L26:
        sendCellQoeLevelMsg();
        return;
    L20:
        r12 = "BAD";
        goto L21
    L16:
        if (this.mCellDataLevel != 2) goto L26;
    L5:
        if (CellQoeQueue.access$900(this.mCellQoeQueue) >= this.mHandoverParameterManager.getCellQosCheckBadTimes()) goto L12;
        if (CellQoeQueue.access$1000(this.mCellQoeQueue) >= this.mHandoverParameterManager.getCellQosCheckMiddleTimes()) goto L12;
        if (CellQoeQueue.access$1100(this.mCellQoeQueue) < this.mHandoverParameterManager.getCellQosCheckGoodTimes()) goto L14;
        this.mCellDataLevel = 1;
        goto L14
    }

    private void updateWifiQoeInfo(WiFiQoEParam r8) {
        this.mNetworkQoEInfoCollector.updateL2QoEInfo(1, !isBadWifiQoE(r8), r8.getTxThroughput(), r8.getRxThroughput());
        SystemProperties.set(WIFI_QOS_TX_PROPERTY_KEY, String.valueOf(r8.getTxThroughput()));     // Catch: Exception -> L5
        SystemProperties.set(WIFI_QOS_RX_PROPERTY_KEY, String.valueOf(r8.getRxThroughput()));     // Catch: Exception -> L5
    L7:
        this.mWifiQoeQueue.add(r8);
        if (WifiQoeQueue.access$300(this.mWifiQoeQueue) < this.mHandoverParameterManager.getWifiQosCheckBadTimes()) goto L10;
    L18:
        this.mWifiQoeLevel = 2;
    L20:
        if (this.mWifiQoeLevel != 2) goto L34;
        int r10 = r8.getBand();
        HandoverParameterManager r11 = this.mHandoverParameterManager;
        if (r10 != 0) goto L24;
        int r12 = r11.getWifi24GGoodTputThreshold();
    L25:
        HandoverParameterManager r13 = this.mHandoverParameterManager;
        if (r10 != 0) goto L28;
        int r14 = r13.getWifi24GBadTputThreshold();
    L29:
        StringBuilder r15 = new StringBuilder("Wi-Fi L2 QoE Info: RxTput = ");
        r15.append(r8.getRxThroughput());
        r15.append(" TxTput = ");
        r15.append(r8.getTxThroughput());
        r15.append(" Band = ");
        r15.append(NetworkUtil.getWifiBandString(r10));
        r15.append(" ContinueRxGoodTputTimes = ");
        r15.append(WifiQoeQueue.access$500(this.mWifiQoeQueue));
        r15.append(" ContinueTxGoodTputTimes = ");
        r15.append(WifiQoeQueue.access$600(this.mWifiQoeQueue));
        r15.append(" ContinueRxBadTputTimes = ");
        r15.append(WifiQoeQueue.access$300(this.mWifiQoeQueue));
        r15.append(" ContinueTxBadTputTimes = ");
        defpackage.b.q(r15, WifiQoeQueue.access$400(this.mWifiQoeQueue), " GoodTputThreshold = ", r12, " BadTputThreshold = ");
        r15.append(r14);
        r15.append(" L2QoeLevel = ");
        if (this.mWifiQoeLevel != 1) goto L32;
        String r16 = "GOOD";
    L33:
        android.aimedia.a.r(r15, r16, TAG);
        goto L34
    L32:
        r16 = "BAD";
        goto L33
    L28:
        r14 = r13.getWifi5GBadTputThreshold();
        goto L29
    L24:
        r12 = r11.getWifi5GGoodTputThreshold();
    L34:
        NetworkPolicyCenter r17 = this.mNetworkPolicyCenter;
        if (this.mWifiQoeLevel != 1) goto L37;
        int r18 = 5;
    L38:
        this.mNetworkPolicyCenter.sendMessage(r17.obtainMessage(r18, 1, 0));
        return;
    L37:
        r18 = 6;
        goto L38
    L10:
        if (WifiQoeQueue.access$400(this.mWifiQoeQueue) >= this.mHandoverParameterManager.getWifiQosCheckBadTimes()) goto L18;
        if (WifiQoeQueue.access$500(this.mWifiQoeQueue) >= this.mHandoverParameterManager.getWifiQosCheckGoodTimes()) goto L15;
        return;
    L15:
        if (WifiQoeQueue.access$600(this.mWifiQoeQueue) < this.mHandoverParameterManager.getWifiQosCheckGoodTimes()) goto L42;
        this.mWifiQoeLevel = 1;
        goto L20
    L42:
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "set wifi qos property failed: " + e.getMessage(), e);
        goto L7
    }

    @Override // com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor.ActivityMonitorListener
    public void onActivityChanged(String r8, boolean r10) {
        NetworkPolicyCenter r11 = this.mNetworkPolicyCenter;
        if (r10 == false) goto L5;
        int r12 = 10;
    L6:
        Message r13 = r11.obtainMessage(r12, r8);
        this.mNetworkPolicyCenter.sendMessage(r13);
        return;
    L5:
        r12 = 9;
        goto L6
    }

    @Override // com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor.ActivityMonitorListener
    public void onActivityPinned(String r8) {
        Message r10 = this.mNetworkPolicyCenter.obtainMessage(16, r8);
        this.mNetworkPolicyCenter.sendMessage(r10);
    }

    @Override // com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor.ActivityMonitorListener
    public void onActivityUnpinned() {
        Message r8 = this.mNetworkPolicyCenter.obtainMessage(17);
        this.mNetworkPolicyCenter.sendMessage(r8);
    }

    @Override // com.obric.cae.smartNetwork.qoe.CellularQoECallback
    public void onCellularL2EvaluateReport(CellularQoeEvaluateStats r8) {
        if (NetworkUtil.isValidCellularQoeEvaluateStats(r8) == false) goto L6;
        updateCellQoeStats(r8);
        return;
    }

    @Override // com.obric.cae.smartNetwork.qoe.CellularQoECallback
    public void onCellularQoEParamUpdate(CellularQoEParam r8) {
        if (NetworkUtil.isValidCellQoEParam(r8) == false) goto L6;
        updateCellQoeLevel(r8);
        return;
    }

    @Override // com.obric.cae.smartNetwork.qoe.WiFiQoECallback
    public void onWiFiQoEParamUpdate(WiFiQoEParam r8) {
        if (NetworkUtil.isValidWifiQoEParam(r8) == false) goto L6;
        updateWifiQoeInfo(r8);
        return;
    }

    public void start() {
    }

    public void stop() {
        this.mWifiQoeLevel = 1;
        this.mCellSignalLevel = 1;
        this.mCellDataLevel = 1;
        this.mWifiQoeQueue.clear();
        CellQoeQueue.access$200(this.mCellQoeQueue);
    }
}
