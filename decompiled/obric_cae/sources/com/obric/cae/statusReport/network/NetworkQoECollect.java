package com.obric.cae.statusReport.network;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.networkHandover.HandoverParameterManager;
import com.obric.cae.smartNetwork.networkHandover.NetworkQoeScore;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.smartNetwork.qoe.WiFiQoECallback;
import com.obric.cae.smartNetwork.qoe.WiFiQoEParam;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkQoECollect {
    private static final int L2_QOE_QUEUE_SIZE = 5;
    private static final int L4_QOE_QUEUE_SIZE = 5;
    private static final String TAG = "NetworkQoECollect";
    private final CellQoECollect mCellQoECollect;
    private final Context mContext;
    private final HandoverParameterManager mHandoverParameterManager;
    private final L4NetEvaluate.L4NetErrReportCb mL4NetErrReportCb;
    private final L4NetEvaluate mL4NetEvaluate;
    private final NetworkQoEInfoCollector mNetworkQoEInfoCollector;
    private final NetworkQoEMonitor mNetworkQoEMonitor;
    private final WiFiQoECallback mWiFiQoECallback;
    private final WifiQoECollect mWifiQoECollect;

    public static class CellQoECollect {
        private final Object lock;
        private final Queue<QoEInfo> mL2QoEInfoQueue;
        private final Queue<QoEInfo> mL4QoEInfoQueue;

        private CellQoECollect() {
            this.mL2QoEInfoQueue = new LinkedList();
            this.mL4QoEInfoQueue = new LinkedList();
            this.lock = new Object();
        }

        public void addL2QoEInfo() {
        }

        public void addL4QoEInfo(L4NetEvaluate.L4NetStats r8) {
            Object r10 = this.lock;
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mL4QoEInfoQueue.size() < 5) goto L7;
            this.mL4QoEInfoQueue.poll();     // Catch: Throwable -> L10
        L7:
            QoEInfo r11 = new QoEInfo();     // Catch: Throwable -> L10
            r11.setTcpRetryRate(r8.sendRetrans);     // Catch: Throwable -> L10
            r11.setTcpAverageRtt(r8.rttAve);     // Catch: Throwable -> L10
            this.mL4QoEInfoQueue.offer(r11);     // Catch: Throwable -> L10
            monitor-exit(r10);     // Catch: Throwable -> L10
        }

        public void clear() {
            Object r8 = this.lock;
            monitor-enter(r8);
            this.mL2QoEInfoQueue.clear();     // Catch: Throwable -> L7
            this.mL4QoEInfoQueue.clear();     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public QoEInfo getQoEInfo() {
            QoEInfo r8 = new QoEInfo();
            Object r10 = this.lock;
            monitor-enter(r10);
            Iterator<QoEInfo> r11 = this.mL2QoEInfoQueue.iterator();     // Catch: Throwable -> L21
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
        L6:
            if (r11.hasNext() == false) goto L9;
            QoEInfo r15 = r11.next();     // Catch: Throwable -> L21
            r13 = r13 + r15.getL2AverageTput();     // Catch: Throwable -> L21
            r14 = r14 + r15.getL2AverageJitter();     // Catch: Throwable -> L21
            goto L6
        L9:
            if (this.mL2QoEInfoQueue.isEmpty() == true) goto L11;
            r8.setL2AverageTput(r13 / this.mL2QoEInfoQueue.size());     // Catch: Throwable -> L21
            r8.setL2AverageJitter(r14 / this.mL2QoEInfoQueue.size());     // Catch: Throwable -> L21
        L11:
            Iterator<QoEInfo> r16 = this.mL4QoEInfoQueue.iterator();     // Catch: Throwable -> L21
            int r17 = 0;
        L13:
            if (r16.hasNext() == false) goto L16;
            QoEInfo r18 = r16.next();     // Catch: Throwable -> L21
            r12 = r12 + r18.getTcpAverageRtt();     // Catch: Throwable -> L21
            r17 = r17 + r18.getTcpRetryRate();     // Catch: Throwable -> L21
            goto L13
        L16:
            if (this.mL4QoEInfoQueue.isEmpty() == true) goto L18;
            r8.setTcpAverageRtt(r12 / this.mL4QoEInfoQueue.size());     // Catch: Throwable -> L21
            r8.setTcpRetryRate(r17 / this.mL4QoEInfoQueue.size());     // Catch: Throwable -> L21
        L18:
            monitor-exit(r10);     // Catch: Throwable -> L21
            CaeLog.d(NetworkQoECollect.TAG, "Cell QoE Info: Tput = " + QoEInfo.access$600(r8) + ", Jitter = " + QoEInfo.access$700(r8) + ", rtt = " + QoEInfo.access$800(r8) + ", retrans = " + QoEInfo.access$900(r8) + ", L2 size = " + this.mL2QoEInfoQueue.size() + ", L4 size = " + this.mL4QoEInfoQueue.size());
            return r8;
        L21:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ CellQoECollect(AnonymousClass1 r8) {
            this();
        }
    }

    public static class QoEInfo {
        private int l2AverageJitter;
        private int l2AverageTput;
        private int tcpAverageRtt;
        private int tcpRetryRate;

        public QoEInfo() {
        }

        public static /* synthetic */ int access$600(QoEInfo r8) {
            return r8.l2AverageTput;
        }

        public static /* synthetic */ int access$700(QoEInfo r8) {
            return r8.l2AverageJitter;
        }

        public static /* synthetic */ int access$800(QoEInfo r8) {
            return r8.tcpAverageRtt;
        }

        public static /* synthetic */ int access$900(QoEInfo r8) {
            return r8.tcpRetryRate;
        }

        public void clear() {
            this.tcpAverageRtt = 0;
            this.tcpRetryRate = 0;
            this.l2AverageTput = 0;
            this.l2AverageJitter = 0;
        }

        public int getL2AverageJitter() {
            return this.l2AverageJitter;
        }

        public int getL2AverageTput() {
            return this.l2AverageTput;
        }

        public int getTcpAverageRtt() {
            return this.tcpAverageRtt;
        }

        public int getTcpRetryRate() {
            return this.tcpRetryRate;
        }

        public void setL2AverageJitter(int r8) {
            this.l2AverageJitter = r8;
        }

        public void setL2AverageTput(int r8) {
            this.l2AverageTput = r8;
        }

        public void setTcpAverageRtt(int r8) {
            this.tcpAverageRtt = r8;
        }

        public void setTcpRetryRate(int r8) {
            this.tcpRetryRate = r8;
        }

        public String toString() {
            StringBuilder r8 = new StringBuilder("{tcpAverageRtt=");
            r8.append(this.tcpAverageRtt);
            r8.append(", tcpRetryRate=");
            r8.append(this.tcpRetryRate);
            r8.append(", l2AverageTput=");
            r8.append(this.l2AverageTput);
            r8.append(", l2AverageJitter=");
            return android.aimedia.a.h(r8, this.l2AverageJitter, "}");
        }
    }

    public static class WifiQoECollect {
        private final Object lock;
        private final Queue<QoEInfo> mL2QoEInfoQueue;
        private final Queue<QoEInfo> mL4QoEInfoQueue;

        private WifiQoECollect() {
            this.mL2QoEInfoQueue = new LinkedList();
            this.mL4QoEInfoQueue = new LinkedList();
            this.lock = new Object();
        }

        public void addL2QoEInfo(WiFiQoEParam r8) {
            Object r10 = this.lock;
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mL2QoEInfoQueue.size() < 5) goto L7;
            this.mL2QoEInfoQueue.poll();     // Catch: Throwable -> L10
        L7:
            QoEInfo r11 = new QoEInfo();     // Catch: Throwable -> L10
            r11.setL2AverageTput(r8.getRxThroughput());     // Catch: Throwable -> L10
            this.mL2QoEInfoQueue.offer(r11);     // Catch: Throwable -> L10
            monitor-exit(r10);     // Catch: Throwable -> L10
        }

        public void addL4QoEInfo(L4NetEvaluate.L4NetStats r8) {
            Object r10 = this.lock;
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mL4QoEInfoQueue.size() < 5) goto L7;
            this.mL4QoEInfoQueue.poll();     // Catch: Throwable -> L10
        L7:
            QoEInfo r11 = new QoEInfo();     // Catch: Throwable -> L10
            r11.setTcpRetryRate(r8.sendRetrans);     // Catch: Throwable -> L10
            r11.setTcpAverageRtt(r8.rttAve);     // Catch: Throwable -> L10
            this.mL4QoEInfoQueue.offer(r11);     // Catch: Throwable -> L10
            monitor-exit(r10);     // Catch: Throwable -> L10
        }

        public void clear() {
            Object r8 = this.lock;
            monitor-enter(r8);
            this.mL2QoEInfoQueue.clear();     // Catch: Throwable -> L7
            this.mL4QoEInfoQueue.clear();     // Catch: Throwable -> L7
            monitor-exit(r8);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public QoEInfo getQoEInfo() {
            QoEInfo r8 = new QoEInfo();
            Object r10 = this.lock;
            monitor-enter(r10);
            Iterator<QoEInfo> r11 = this.mL2QoEInfoQueue.iterator();     // Catch: Throwable -> L21
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
        L6:
            if (r11.hasNext() == false) goto L9;
            QoEInfo r15 = r11.next();     // Catch: Throwable -> L21
            r13 = r13 + r15.getL2AverageTput();     // Catch: Throwable -> L21
            r14 = r14 + r15.getL2AverageJitter();     // Catch: Throwable -> L21
            goto L6
        L9:
            if (this.mL2QoEInfoQueue.isEmpty() == true) goto L11;
            r8.setL2AverageTput(r13 / this.mL2QoEInfoQueue.size());     // Catch: Throwable -> L21
            r8.setL2AverageJitter(r14 / this.mL2QoEInfoQueue.size());     // Catch: Throwable -> L21
        L11:
            Iterator<QoEInfo> r16 = this.mL4QoEInfoQueue.iterator();     // Catch: Throwable -> L21
            int r17 = 0;
        L13:
            if (r16.hasNext() == false) goto L16;
            QoEInfo r18 = r16.next();     // Catch: Throwable -> L21
            r12 = r12 + r18.getTcpAverageRtt();     // Catch: Throwable -> L21
            r17 = r17 + r18.getTcpRetryRate();     // Catch: Throwable -> L21
            goto L13
        L16:
            if (this.mL4QoEInfoQueue.isEmpty() == true) goto L18;
            r8.setTcpAverageRtt(r12 / this.mL4QoEInfoQueue.size());     // Catch: Throwable -> L21
            r8.setTcpRetryRate(r17 / this.mL4QoEInfoQueue.size());     // Catch: Throwable -> L21
        L18:
            monitor-exit(r10);     // Catch: Throwable -> L21
            CaeLog.d(NetworkQoECollect.TAG, "Wifi QoE Info: Tput = " + QoEInfo.access$600(r8) + ", Jitter = " + QoEInfo.access$700(r8) + ", rtt = " + QoEInfo.access$800(r8) + ", retrans = " + QoEInfo.access$900(r8) + ", L2 size = " + this.mL2QoEInfoQueue.size() + ", L4 size = " + this.mL4QoEInfoQueue.size());
            return r8;
        L21:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ WifiQoECollect(AnonymousClass1 r8) {
            this();
        }
    }

    public NetworkQoECollect(Context r8, NetworkQoEMonitor r10) {
        this.mWiFiQoECallback = new AnonymousClass1(this);
        this.mL4NetErrReportCb = new AnonymousClass2(this);
        this.mContext = r8;
        this.mNetworkQoEMonitor = r10;
        this.mNetworkQoEInfoCollector = NetworkQoEInfoCollector.getInstance(r8);
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        AnonymousClass1 r11 = null;
        this.mWifiQoECollect = new WifiQoECollect(r11);
        this.mCellQoECollect = new CellQoECollect(r11);
    }

    public static /* synthetic */ WifiQoECollect access$200(NetworkQoECollect r8) {
        return r8.mWifiQoECollect;
    }

    public static /* synthetic */ Context access$300(NetworkQoECollect r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void access$400(NetworkQoECollect r8, int r10, L4NetEvaluate.L4NetStats r11) {
        r8.updateNetworkQoEInfo(r10, r11);
    }

    public static /* synthetic */ CellQoECollect access$500(NetworkQoECollect r8) {
        return r8.mCellQoECollect;
    }

    private void updateNetworkQoEInfo(int r8, L4NetEvaluate.L4NetStats r10) {
        int r11 = NetworkQoeScore.getNetworkScore(r10);
        NetworkQoEInfoCollector r12 = this.mNetworkQoEInfoCollector;
        if (r11 >= this.mHandoverParameterManager.getNetworkL4QoeBadThreshold()) goto L5;
        boolean r13 = true;
    L6:
        r12.updateL4QoEInfo(r8, r13, r10);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public void clearCellQoEInfo() {
        this.mCellQoECollect.clear();
    }

    public void clearWifiQoEInfo() {
        this.mWifiQoECollect.clear();
    }

    public QoEInfo getCellQoEInfo() {
        return this.mCellQoECollect.getQoEInfo();
    }

    public QoEInfo getWifiQoEInfo() {
        return this.mWifiQoECollect.getQoEInfo();
    }

    public void start() {
        this.mNetworkQoEMonitor.registerWiFiQoECallback(this.mWiFiQoECallback);
        this.mL4NetEvaluate.registerErrReportCb(this.mL4NetErrReportCb);
    }

    public void stop() {
        this.mNetworkQoEMonitor.unregisterWiFiQoECallback(this.mWiFiQoECallback);
        this.mL4NetEvaluate.unregisterErrReportCb(this.mL4NetErrReportCb);
    }
}
