package com.obric.cae.smartNetwork.multipath;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.qoe.CellularLteQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularNrQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoECallback;
import com.obric.cae.smartNetwork.qoe.CellularQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluateStats;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.smartNetwork.qoe.WiFiQoECallback;
import com.obric.cae.smartNetwork.qoe.WiFiQoEParam;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkPolicyCenter {
    private static final int CELL_QOE_GOOD = 8;
    private static final int CELL_QOE_POOR = 7;
    private static final int CELL_RTT_GOOD = 4;
    private static final int CELL_RTT_POOR = 3;
    private static final int NETWORK_INVALID = 9;
    private static final int NETWORK_TYPE_CELL = 1;
    private static final int NETWORK_TYPE_WIFI = 0;
    private static final int NETWORK_VALID = 10;
    private static final String TAG = "NetworkPolicyCenter";
    private static final int WIFI_QOE_GOOD = 6;
    private static final int WIFI_QOE_POOR = 5;
    private static final int WIFI_RTT_GOOD = 2;
    private static final int WIFI_RTT_POOR = 1;
    private final Context mContext;
    private final LinkLayerMonitor mLinkLayerMonitor;
    private final MPAConnQualityMonitor mMPAConnQualityMonitor;
    private final MPASettingsObserver mMPASettingsObserver;
    private MPAStateMachine mMPAStateMachine;
    private final NetworkPolicyHandover mNetworkPolicyHandover;
    private final NetworkQoEMonitor mNetworkQoEMonitor;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.multipath.NetworkPolicyCenter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ConnQualityQueue {
        private Deque<MPAConnQuality> mMPAConnQualityQueue;
        private int mRttGoodTimes;
        private int mRttMiddleTimes;
        final /* synthetic */ NetworkPolicyCenter this$0;

        private ConnQualityQueue(NetworkPolicyCenter r8) {
            this.this$0 = r8;
            this.mMPAConnQualityQueue = new LinkedList();
        }

        public void addMPAConnQuality(MPAConnQuality r8) {
            this.mRttMiddleTimes = 0;
            this.mRttGoodTimes = 0;
            if (this.mMPAConnQualityQueue.size() < NetworkPolicyCenter.access$400(this.this$0).getMaxRTTTimes()) goto L5;
            this.mMPAConnQualityQueue.poll();
        L5:
            this.mMPAConnQualityQueue.add(r8);
            Iterator<MPAConnQuality> r10 = this.mMPAConnQualityQueue.descendingIterator();
            boolean r11 = true;
        L7:
            if (r10.hasNext() == false) goto L16;
            MPAConnQuality r12 = r10.next();
            if (r12.maxRttTime() > NetworkPolicyCenter.access$400(this.this$0).getRTTGoodThreshold()) goto L15;
            if (r12.isRttTimedout() == true) goto L15;
            if (r11 == false) goto L7;
            this.mRttGoodTimes++;
        L15:
            this.mRttMiddleTimes++;
            r11 = false;
            goto L7
        }

        public void clear() {
            this.mRttMiddleTimes = 0;
            this.mRttGoodTimes = 0;
            this.mMPAConnQualityQueue.clear();
        }

        public int getRttGoodTimes() {
            return this.mRttGoodTimes;
        }

        public int getmRttMiddleTimes() {
            return this.mRttMiddleTimes;
        }

        public String toString() {
            return "ConnQualityQueue{mRttMiddleTimes=" + this.mRttMiddleTimes + ", mRttGoodTimes=" + this.mRttGoodTimes + ", mMPAConnQualityQueue=" + this.mMPAConnQualityQueue + '}';
        }

        public /* synthetic */ ConnQualityQueue(NetworkPolicyCenter r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class NetworkPolicyHandover implements LinkLayerMonitor.NetworkAvailableListener, MPAConnQualityMonitor.MPAConnectionQualityCallback, WiFiQoECallback, CellularQoECallback {
        private ConnQualityQueue mCellConnQualityQueue;
        private int mCellQoeLevel;
        private int mCellRttLevel;
        private int mCellValidStatus;
        private ConnQualityQueue mWifiConnQualityQueue;
        private int mWifiQoeLevel;
        private WifiQoeQueue mWifiQoeQueue;
        private int mWifiRttLevel;
        private int mWifiValidStatus;
        final /* synthetic */ NetworkPolicyCenter this$0;

        public NetworkPolicyHandover(NetworkPolicyCenter r8) {
            this.this$0 = r8;
            this.mWifiValidStatus = 9;
            this.mCellValidStatus = 9;
            this.mWifiRttLevel = 1;
            this.mCellRttLevel = 3;
            this.mWifiQoeLevel = 5;
            this.mCellQoeLevel = 7;
            AnonymousClass1 r10 = null;
            this.mWifiConnQualityQueue = new ConnQualityQueue(r8, r10);
            this.mCellConnQualityQueue = new ConnQualityQueue(r8, r10);
            this.mWifiQoeQueue = new WifiQoeQueue(r8, r10);
        }

        private void updateAvailableStatus(int r8, boolean r10, boolean r11) {
            if (r8 != 0) goto L4;
            int r12 = this.mWifiValidStatus;
        L5:
            int r13 = 9;
            if (r10 == false) goto L9;
            if (r11 == false) goto L9;
            int r14 = 10;
        L10:
            if (r12 != r14) goto L12;
            return;
        L12:
            if (r8 != 0) goto L23;
            this.mWifiValidStatus = r14;
            String r15 = NetworkPolicyCenter.access$200();
            StringBuilder r16 = new StringBuilder("send ");
            if (this.mWifiValidStatus != 10) goto L16;
            String r17 = "CMD_WLAN_ENABLED";
        L17:
            r16.append(r17);
            r16.append(" msg to MPAStateMachine");
            CaeLog.d(r15, r16.toString());
            MPAStateMachine r18 = NetworkPolicyCenter.access$300(this.this$0);
            if (this.mWifiValidStatus == 10) goto L21;
            r13 = 10;
        L21:
            r18.sendMessage(r13);
            return;
        L16:
            r17 = "CMD_WLAN_DISABLED";
            goto L17
        L23:
            if (r8 != 1) goto L36;
            this.mCellValidStatus = r14;
            String r19 = NetworkPolicyCenter.access$200();
            StringBuilder r20 = new StringBuilder("send ");
            if (this.mCellValidStatus != 10) goto L27;
            String r21 = "CMD_CELL_ENABLED";
        L28:
            r20.append(r21);
            r20.append(" msg to MPAStateMachine");
            CaeLog.d(r19, r20.toString());
            MPAStateMachine r22 = NetworkPolicyCenter.access$300(this.this$0);
            if (this.mCellValidStatus != 10) goto L31;
            int r23 = 11;
        L32:
            r22.sendMessage(r23);
            return;
        L31:
            r23 = 12;
            goto L32
        L27:
            r21 = "CMD_CELL_DISABLED";
            goto L28
        L36:
            return;
        L9:
            r14 = 9;
            goto L10
        L4:
            r12 = this.mCellValidStatus;
            goto L5
        }

        private void updateCellQoeLevel(CellularQoEParam r8) {
            if ((r8 instanceof CellularNrQoEParam) == false) goto L10;
            CellularNrQoEParam r10 = (CellularNrQoEParam) r8;
            if (r10.getSsRsrp() >= NetworkPolicyCenter.access$400(this.this$0).getCellNrRSRPThreshold()) goto L7;
        L16:
            char r11 = 7;
        L17:
            String r12 = NetworkPolicyCenter.access$200();
            StringBuilder r13 = new StringBuilder("send ");
            if (r11 != '\b') goto L20;
            String r14 = "CMD_CELL_QUALITY_GOOD";
        L21:
            r13.append(r14);
            r13.append(" msg to MPAStateMachine");
            CaeLog.d(r12, r13.toString());
            MPAStateMachine r15 = NetworkPolicyCenter.access$300(this.this$0);
            if (r11 != '\b') goto L24;
            int r16 = 6;
        L25:
            r15.sendMessage(r16);
            return;
        L24:
            r16 = 5;
            goto L25
        L20:
            r14 = "CMD_CELL_QUALITY_POOR";
            goto L21
        L7:
            if (r10.getSsRsrq() < NetworkPolicyCenter.access$400(this.this$0).getCellNrRSRQThreshold()) goto L16;
        L8:
            r11 = '\b';
            goto L17
        L10:
            if ((r8 instanceof CellularLteQoEParam) == false) goto L16;
            CellularLteQoEParam r17 = (CellularLteQoEParam) r8;
            if (r17.getRsrp() < NetworkPolicyCenter.access$400(this.this$0).getCellLteRSRPThreshold()) goto L16;
            if (r17.getRsrq() < NetworkPolicyCenter.access$400(this.this$0).getCellLteRSRQThreshold()) goto L16;
            goto L16
        }

        private void updateCellularConnectionQuality(MPAConnQuality r8) {
            this.mCellConnQualityQueue.addMPAConnQuality(r8);
            CaeLog.d(NetworkPolicyCenter.access$200(), "updateCellularConnectionQuality:" + r8.toString() + this.mCellConnQualityQueue.toString());
            if (this.mCellConnQualityQueue.getRttGoodTimes() < NetworkPolicyCenter.access$400(this.this$0).getRTTGoodContinueTimes()) goto L7;
            CaeLog.d(NetworkPolicyCenter.access$200(), "send CMD_CELL_RTT_GOOD msg to MPAStateMachine");
            MPAStateMachine r10 = NetworkPolicyCenter.access$300(this.this$0);
            int r11 = 8;
        L5:
            r10.sendMessage(r11);
            return;
        L7:
            if (r8.maxRttTime() <= NetworkPolicyCenter.access$400(this.this$0).getRTTPoorThreshold()) goto L9;
        L12:
            CaeLog.d(NetworkPolicyCenter.access$200(), "send CMD_CELL_RTT_POOR msg to MPAStateMachine");
            r10 = NetworkPolicyCenter.access$300(this.this$0);
            r11 = 7;
            goto L5
        L9:
            if (this.mCellConnQualityQueue.getmRttMiddleTimes() >= NetworkPolicyCenter.access$400(this.this$0).getRTTMiddleTotalTimes()) goto L12;
            if (r8.isRttTimedout() == true) goto L12;
        }

        private void updateWiFiConnectionQuality(MPAConnQuality r8) {
            this.mWifiConnQualityQueue.addMPAConnQuality(r8);
            CaeLog.d(NetworkPolicyCenter.access$200(), "updateWiFiConnectionQuality: " + r8.toString() + this.mWifiConnQualityQueue.toString());
            if (this.mWifiConnQualityQueue.getRttGoodTimes() < NetworkPolicyCenter.access$400(this.this$0).getRTTGoodContinueTimes()) goto L7;
            this.mWifiRttLevel = 2;
            CaeLog.d(NetworkPolicyCenter.access$200(), "send CMD_WLAN_RTT_GOOD msg to MPAStateMachine");
            MPAStateMachine r10 = NetworkPolicyCenter.access$300(this.this$0);
            int r11 = 4;
        L5:
            r10.sendMessage(r11);
            return;
        L7:
            if (r8.maxRttTime() <= NetworkPolicyCenter.access$400(this.this$0).getRTTPoorThreshold()) goto L9;
        L12:
            this.mWifiRttLevel = 1;
            CaeLog.d(NetworkPolicyCenter.access$200(), "send CMD_WLAN_RTT_POOR msg to MPAStateMachine");
            r10 = NetworkPolicyCenter.access$300(this.this$0);
            r11 = 3;
            goto L5
        L9:
            if (this.mWifiConnQualityQueue.getmRttMiddleTimes() >= NetworkPolicyCenter.access$400(this.this$0).getRTTMiddleTotalTimes()) goto L12;
            if (r8.isRttTimedout() == true) goto L12;
        }

        private void updateWifiQoeLevel(WiFiQoEParam r8) {
            this.mWifiQoeQueue.addWifiQoeInfo(r8);
            CaeLog.d(NetworkPolicyCenter.access$200(), "updateWifiQoeLevel: band=" + r8.getBand() + ", tput=" + r8.getRxThroughput() + ", tputGoodTimes=" + this.mWifiQoeQueue.getTputGoodTimes());
            if (r8.getBand() != 0) goto L5;
            int r10 = NetworkPolicyCenter.access$400(this.this$0).getWLAN24GTputPoorThreshold();
        L7:
            if (this.mWifiQoeQueue.getTputGoodTimes() < NetworkPolicyCenter.access$400(this.this$0).getWifiQOEGoodContinueTimes()) goto L11;
            CaeLog.d(NetworkPolicyCenter.access$200(), "send CMD_WLAN_QUALITY_GOOD msg to MPAStateMachine");
            MPAStateMachine r11 = NetworkPolicyCenter.access$300(this.this$0);
            int r12 = 2;
        L9:
            r11.sendMessage(r12);
            return;
        L11:
            if (r8.getRxThroughput() > r10) goto L14;
            CaeLog.d(NetworkPolicyCenter.access$200(), "send CMD_WLAN_QUALITY_POOR msg to MPAStateMachine");
            r11 = NetworkPolicyCenter.access$300(this.this$0);
            r12 = 1;
            goto L9
        L14:
            return;
        L5:
            r10 = NetworkPolicyCenter.access$400(this.this$0).getWLAN5GTputPoorThreshold();
            goto L7
        }

        public void clear() {
            this.mCellConnQualityQueue.clear();
            this.mWifiConnQualityQueue.clear();
            this.mWifiQoeQueue.clear();
        }

        @Override // com.obric.cae.smartNetwork.multipath.LinkLayerMonitor.NetworkAvailableListener
        public void onCellAvailableChanged(boolean r8, boolean r10) {
            updateAvailableStatus(1, r8, r10);
        }

        @Override // com.obric.cae.smartNetwork.qoe.CellularQoECallback
        public void onCellularL2EvaluateReport(CellularQoeEvaluateStats r8) {
        }

        @Override // com.obric.cae.smartNetwork.multipath.MPAConnQualityMonitor.MPAConnectionQualityCallback
        public void onCellularMPAConnQualityReport(MPAConnQuality r8) {
            updateCellularConnectionQuality(r8);
        }

        @Override // com.obric.cae.smartNetwork.qoe.CellularQoECallback
        public void onCellularQoEParamUpdate(CellularQoEParam r8) {
            CaeLog.d(NetworkPolicyCenter.access$200(), "onCellularQoEParamUpdate");
            updateCellQoeLevel(r8);
        }

        @Override // com.obric.cae.smartNetwork.multipath.MPAConnQualityMonitor.MPAConnectionQualityCallback
        public void onPathCtlModeChanged(String r8, int r10) {
            if (r10 != 1) goto L6;
            int r11 = 13;
        L11:
            CaeLog.d(NetworkPolicyCenter.access$200(), "onPathCtlModeChanged: acceleratedAddress=" + r8 + ", pathCtlMode=" + r10);
            NetworkPolicyCenter.access$300(this.this$0).sendMessage(r11);
            return;
        L6:
            if (r10 != 2) goto L9;
            r11 = 14;
            goto L11
        L9:
            if (r10 != 3) goto L13;
            r11 = 15;
            goto L11
        L13:
            android.aimedia.a.p("onPathCtlModeChanged: invalid pathCtlMode=", r10, NetworkPolicyCenter.access$200());
        }

        @Override // com.obric.cae.smartNetwork.multipath.MPAConnQualityMonitor.MPAConnectionQualityCallback
        public void onWiFiMPAConnQualityReport(MPAConnQuality r8) {
            updateWiFiConnectionQuality(r8);
        }

        @Override // com.obric.cae.smartNetwork.qoe.WiFiQoECallback
        public void onWiFiQoEParamUpdate(WiFiQoEParam r8) {
            CaeLog.d(NetworkPolicyCenter.access$200(), "onWiFiQoEParamUpdate: band=" + r8.getBand() + ", rxTput=" + r8.getRxThroughput() + ", txTput=" + r8.getTxThroughput());
            updateWifiQoeLevel(r8);
        }

        @Override // com.obric.cae.smartNetwork.multipath.LinkLayerMonitor.NetworkAvailableListener
        public void onWifiAvailableChanged(boolean r8, boolean r10) {
            updateAvailableStatus(0, r8, r10);
        }
    }

    public class WifiQoeQueue {
        private int mTputGoodTimes;
        private Deque<WiFiQoEParam> mWifiQoeInfoQueue;
        final /* synthetic */ NetworkPolicyCenter this$0;

        private WifiQoeQueue(NetworkPolicyCenter r8) {
            this.this$0 = r8;
            this.mWifiQoeInfoQueue = new LinkedList();
        }

        public void addWifiQoeInfo(WiFiQoEParam r8) {
            this.mTputGoodTimes = 0;
            if (this.mWifiQoeInfoQueue.size() < NetworkPolicyCenter.access$400(this.this$0).getMaxWifiQOETimes()) goto L5;
            this.mWifiQoeInfoQueue.poll();
        L5:
            this.mWifiQoeInfoQueue.add(r8);
            if (r8.getBand() != 0) goto L8;
            int r10 = NetworkPolicyCenter.access$400(this.this$0).getWLAN24GTputGoodThreshold();
        L9:
            Iterator<WiFiQoEParam> r11 = this.mWifiQoeInfoQueue.descendingIterator();
        L11:
            if (r11.hasNext() == false) goto L15;
            if (r11.next().getRxThroughput() < r10) goto L18;
            this.mTputGoodTimes++;
            goto L11
        L18:
            return;
        L15:
            return;
        L8:
            r10 = NetworkPolicyCenter.access$400(this.this$0).getWLAN5GTputGoodThreshold();
            goto L9
        }

        public void clear() {
            this.mTputGoodTimes = 0;
            this.mWifiQoeInfoQueue.clear();
        }

        public int getTputGoodTimes() {
            return this.mTputGoodTimes;
        }

        public /* synthetic */ WifiQoeQueue(NetworkPolicyCenter r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public NetworkPolicyCenter(Context r8, LinkLayerMonitor r10, MPAConnQualityMonitor r11, NetworkQoEMonitor r12) {
        this.mContext = r8;
        this.mMPASettingsObserver = MPASettingsObserver.getInstance(r8);
        this.mLinkLayerMonitor = r10;
        this.mMPAConnQualityMonitor = r11;
        this.mNetworkQoEMonitor = r12;
        this.mNetworkPolicyHandover = new NetworkPolicyHandover(this);
        this.mMPAStateMachine = null;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ MPAStateMachine access$300(NetworkPolicyCenter r8) {
        return r8.mMPAStateMachine;
    }

    public static /* synthetic */ MPASettingsObserver access$400(NetworkPolicyCenter r8) {
        return r8.mMPASettingsObserver;
    }

    public synchronized void start() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mMPAStateMachine != null) goto L6;
        this.mMPAStateMachine = MPAStateMachine.makeHsm();     // Catch: Throwable -> L8
        this.mLinkLayerMonitor.registerListener(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
        this.mMPAConnQualityMonitor.registerMPAConnectionQualityCallback(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
        this.mNetworkQoEMonitor.registerWiFiQoECallback(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
        this.mNetworkQoEMonitor.registerCellularQoECallback(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void stop() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mMPAStateMachine == null) goto L6;
        this.mLinkLayerMonitor.unregisterListener(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
        this.mMPAConnQualityMonitor.unregisterMPAConnectionQualityCallback(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
        this.mNetworkQoEMonitor.unregisterWiFiQoECallback(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
        this.mNetworkQoEMonitor.unregisterCellularQoECallback(this.mNetworkPolicyHandover);     // Catch: Throwable -> L8
        this.mMPAStateMachine.quit();     // Catch: Throwable -> L8
        this.mMPAStateMachine = null;     // Catch: Throwable -> L8
        this.mNetworkPolicyHandover.clear();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
