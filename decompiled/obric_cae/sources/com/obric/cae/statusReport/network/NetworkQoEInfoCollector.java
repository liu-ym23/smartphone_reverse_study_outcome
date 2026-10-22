package com.obric.cae.statusReport.network;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.os.SystemProperties;
import com.cae.caed.DeltaInfoParcel;
import com.cae.caed.INefiListener;
import com.cae.caed.NefiInfoParcel;
import com.cae.caed.WifiStatsParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.network.CaeNetworkHandoverData;
import com.obric.cae.network.CaeNetworkHandoverProto;
import com.obric.cae.network.NetworkBadQoEData;
import com.obric.cae.network.NetworkQoE;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.utils.CaeUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkQoEInfoCollector {
    private static final int COLLECT_QOE_DELAY = 1000;
    private static final int MAX_COLLECT_HISTORY_SIZE = 20;
    private static final int MAX_COLLECT_RING_BUFFER_SIZE = 20;
    private static final int NETWORK_QOE_BAD = 0;
    private static final int NETWORK_QOE_GOOD = 1;
    private static final String NETWORK_QOE_PROPERTY_KEY = "sys.perf.netq";
    private static final String NETWORK_QOE_TIME_PREFIX = ";t";
    private static final String NETWORK_QOE_VALUE_PREFIX = "v1;q";
    private static final String TAG = "NetworkQoEInfoCollector";
    private static volatile NetworkQoEInfoCollector mInstance;
    private final Context mContext;
    private final NetworkQoEInfo mCurrentCellInfo;
    private final NetworkQoEInfo mCurrentWifiInfo;
    private String mForegroundPackageName;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final ConcurrentLinkedQueue<NetworkQoE> mHistoryCellInfo;
    private final ConcurrentLinkedQueue<NetworkQoE> mHistoryWifiInfo;
    private boolean mIsCellConnected;
    private boolean mIsWifiConnected;
    private NefidInterface mNefidInterface;
    private NefidListener mNefidListener;
    private final ConcurrentLinkedQueue<NetworkQoE> mRingBufferCellInfo;
    private final ConcurrentLinkedQueue<NetworkQoE> mRingBufferWifiInfo;

    public final class NefidListener extends INefiListener.Stub {
        final /* synthetic */ NetworkQoEInfoCollector this$0;

        public NefidListener(NetworkQoEInfoCollector r8) {
            this.this$0 = r8;
        }

        @Override // com.cae.caed.INefiListener
        public void OnInfoChanged(int r8, List<NefiInfoParcel> r10) {
            Iterator<NefiInfoParcel> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            Iterator r12 = r11.next().f4160p.iterator();
            if (r12.hasNext() == false) goto L4;
            DeltaInfoParcel r13 = (DeltaInfoParcel) r12.next();
            NetworkQoEInfoCollector.access$400(this.this$0, r13);
            return;
        }

        @Override // com.cae.caed.INefiListener
        public void OnWifiStatsChanged(List<WifiStatsParcel> r8) {
        }
    }

    public static class NetworkQoEInfo {
        int cca_busy_rate;
        int channel_busy_rate;
        boolean isDefault;
        boolean isL2QoEGood;
        boolean isL4QoEGood;
        boolean isValid;
        int on_time_rate;
        int per;
        int recvOooPercent;
        int recvPackets;
        int recvRate;
        int retranRate;
        int rtt;
        int rx_link_speed;
        int rx_mpdu;
        int rx_speed_kbps;
        int rx_throughput;
        int sendPackets;
        int sendRate;
        int streamNum;
        int tx_link_speed;
        int tx_mpdu;
        int tx_retries;
        int tx_speed_kbps;
        int tx_throughput;
        int unacked;

        public NetworkQoEInfo() {
        }
    }

    private NetworkQoEInfoCollector(Context r8) {
        this.mForegroundPackageName = "";
        this.mCurrentWifiInfo = new NetworkQoEInfo();
        this.mCurrentCellInfo = new NetworkQoEInfo();
        this.mHistoryWifiInfo = new ConcurrentLinkedQueue();
        this.mHistoryCellInfo = new ConcurrentLinkedQueue();
        this.mRingBufferWifiInfo = new ConcurrentLinkedQueue();
        this.mRingBufferCellInfo = new ConcurrentLinkedQueue();
        HandlerThread r10 = new HandlerThread(TAG);
        this.mHandlerThread = r10;
        this.mContext = r8;
        r10.start();
        this.mHandler = new Handler(r10.getLooper());
        IntentFilter r11 = defpackage.a.c("android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF");
        r8.registerReceiver(new AnonymousClass1(this), r11);
        this.mNefidInterface = NefidInterface.getInstance(r8);
        NefidListener r12 = new NefidListener(this);
        this.mNefidListener = r12;
        this.mNefidInterface.registerNefidInfoListener(r12, 1, "all", 1, 0, 2);
        clearNetworkQoEInfo(1);
        clearNetworkQoEInfo(0);
    }

    public static /* synthetic */ void access$000(NetworkQoEInfoCollector r8) {
        r8.startCollect();
    }

    public static /* synthetic */ void access$100(NetworkQoEInfoCollector r8) {
        r8.stopAllCollect();
    }

    public static /* synthetic */ void access$200(NetworkQoEInfoCollector r8) {
        r8.collectNetworkQoEInfo();
    }

    public static /* synthetic */ Handler access$300(NetworkQoEInfoCollector r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$400(NetworkQoEInfoCollector r8, DeltaInfoParcel r10) {
        r8.updateWifiStats(r10);
    }

    private void buildNetworkQoEInfoProtoBufData() {
        NetworkBadQoEData.Builder r8 = NetworkBadQoEData.newBuilder();
        r8.addAllNetworkQoe(this.mHistoryWifiInfo);
        r8.addAllNetworkQoe(this.mHistoryCellInfo);
        CaeNetworkHandoverData.Builder r10 = CaeNetworkHandoverData.newBuilder().setNetworkBadQoeEvent(r8);
        CaeNetworkHandoverProto r11 = CaeNetworkHandoverProto.newBuilder().addNetworkHandoverEvent(r10).build();
        CaeLog.i(TAG, "report network bad qoe list data.");
        CaeUtil.writePbEventSafely(System.currentTimeMillis(), 95, r11.toByteArray());
    }

    private void checkDefaultNetworkAndWriteQoE() {
        boolean r8 = this.mIsWifiConnected;
        int r10 = 1;
        if (r8 == false) goto L13;
        NetworkQoEInfo r11 = this.mCurrentWifiInfo;
        if (r11.isDefault == false) goto L13;
        if (r11.isValid == true) goto L9;
    L42:
        r10 = 0;
    L43:
        SystemProperties.set(NETWORK_QOE_PROPERTY_KEY, NETWORK_QOE_VALUE_PREFIX + r10 + NETWORK_QOE_TIME_PREFIX + SystemClock.elapsedRealtime());
        return;
    L9:
        if (r11.isL2QoEGood == false) goto L42;
        if (r11.isL4QoEGood == false) goto L42;
    L13:
        boolean r12 = this.mIsCellConnected;
        if (r12 == false) goto L24;
        NetworkQoEInfo r13 = this.mCurrentCellInfo;
        if (r13.isDefault == false) goto L24;
        if (r13.isValid == false) goto L42;
        if (r13.isL2QoEGood == false) goto L42;
        if (r13.isL4QoEGood == false) goto L42;
    L24:
        if (r8 == false) goto L33;
        if (r12 == true) goto L33;
        NetworkQoEInfo r14 = this.mCurrentWifiInfo;
        if (r14.isValid == false) goto L42;
        if (r14.isL2QoEGood == false) goto L42;
        if (r14.isL4QoEGood == false) goto L42;
    L33:
        if (r12 == false) goto L42;
        if (r8 == true) goto L42;
        NetworkQoEInfo r15 = this.mCurrentCellInfo;
        if (r15.isValid == false) goto L42;
        if (r15.isL2QoEGood == false) goto L42;
        if (r15.isL4QoEGood == false) goto L42;
        goto L42
    }

    private void clearNetworkQoEInfo(int r8) {
        if (r8 == 0) goto L7;
        if (r8 != 1) goto L10;
        this.mRingBufferWifiInfo.clear();
        NetworkQoEInfo r10 = this.mCurrentWifiInfo;
    L8:
        r10.isDefault = false;
        r10.isValid = true;
        r10.isL2QoEGood = true;
        r10.tx_throughput = 0;
        r10.rx_throughput = 0;
        r10.cca_busy_rate = 0;
        r10.channel_busy_rate = 0;
        r10.on_time_rate = 0;
        r10.tx_mpdu = 0;
        r10.rx_mpdu = 0;
        r10.tx_retries = 0;
        r10.per = 0;
        r10.tx_speed_kbps = 0;
        r10.rx_speed_kbps = 0;
        r10.tx_link_speed = 0;
        r10.rx_link_speed = 0;
        r10.isL4QoEGood = true;
        r10.rtt = 0;
        r10.retranRate = 0;
        r10.sendRate = 0;
        r10.recvRate = 0;
        r10.sendPackets = 0;
        r10.recvPackets = 0;
        r10.recvOooPercent = 0;
        r10.unacked = 0;
        r10.streamNum = 0;
        return;
    L10:
        return;
    L7:
        this.mRingBufferCellInfo.clear();
        r10 = this.mCurrentCellInfo;
        goto L8
    }

    private void collectNetworkQoEInfo() {
        if (this.mIsWifiConnected == false) goto L16;
        NetworkQoE r8 = getNetworkQoEInfo(1);
        if (r8.getL2QoeStateGood() == true) goto L7;
    L10:
        this.mHistoryWifiInfo.add(r8);
    L12:
        if (this.mRingBufferWifiInfo.size() < 20) goto L14;
        this.mRingBufferWifiInfo.poll();
    L14:
        this.mRingBufferWifiInfo.add(r8);
        goto L16
    L7:
        if (r8.getL4QoeStateGood() == false) goto L10;
        if (r8.getValid() == true) goto L12;
    L16:
        if (this.mIsCellConnected == false) goto L29;
        NetworkQoE r10 = getNetworkQoEInfo(0);
        if (r10.getL2QoeStateGood() == true) goto L20;
    L23:
        this.mHistoryCellInfo.add(r10);
    L25:
        if (this.mRingBufferCellInfo.size() < 20) goto L27;
        this.mRingBufferCellInfo.poll();
    L27:
        this.mRingBufferCellInfo.add(r10);
        goto L29
    L20:
        if (r10.getL4QoeStateGood() == false) goto L23;
        if (r10.getValid() == true) goto L25;
    L29:
        if (this.mHistoryWifiInfo.size() < 20) goto L31;
    L32:
        buildNetworkQoEInfoProtoBufData();
        this.mHistoryWifiInfo.clear();
        this.mHistoryCellInfo.clear();
    L33:
        checkDefaultNetworkAndWriteQoE();
        return;
    L31:
        if (this.mHistoryCellInfo.size() < 20) goto L33;
        goto L32
    }

    public static NetworkQoEInfoCollector getInstance(Context r8) {
        if (mInstance != null) goto L15;
        monitor-enter(NetworkQoEInfoCollector.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new NetworkQoEInfoCollector(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkQoEInfoCollector.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private NetworkQoE getNetworkQoEInfo(int r8) {
        long r10 = System.currentTimeMillis();
        NetworkQoE.Builder r11 = NetworkQoE.newBuilder();
        if (r8 != 0) goto L5;
        NetworkQoE.Builder r12 = r11.setTimestamp(r10).setNetworkType(0).setDefaultNetwork(this.mCurrentCellInfo.isDefault).setValid(this.mCurrentCellInfo.isValid).setL2QoeStateGood(this.mCurrentCellInfo.isL2QoEGood).setL4QoeStateGood(this.mCurrentCellInfo.isL4QoEGood).setRtt(this.mCurrentCellInfo.rtt).setSendRate(this.mCurrentCellInfo.sendRate).setRecvRate(this.mCurrentCellInfo.recvRate).setSendPackets(this.mCurrentCellInfo.sendPackets).setRecvPackets(this.mCurrentCellInfo.recvPackets).setRetranRate(this.mCurrentCellInfo.retranRate).setRecvOooPercent(this.mCurrentCellInfo.recvOooPercent).setStreamNum(this.mCurrentCellInfo.streamNum);
        NetworkQoEInfo r13 = this.mCurrentCellInfo;
    L10:
        return r12.setUnacked(r13.unacked).setForegroundApp(this.mForegroundPackageName).build();
    L5:
        if (r8 != 1) goto L7;
        r12 = r11.setTimestamp(r10).setNetworkType(1).setDefaultNetwork(this.mCurrentWifiInfo.isDefault).setValid(this.mCurrentWifiInfo.isValid).setL2QoeStateGood(this.mCurrentWifiInfo.isL2QoEGood).setTxTput(this.mCurrentWifiInfo.tx_throughput).setRxTput(this.mCurrentWifiInfo.rx_throughput).setCcaBusyRate(this.mCurrentWifiInfo.cca_busy_rate).setChannelBusyRate(this.mCurrentWifiInfo.channel_busy_rate).setOnTimeRate(this.mCurrentWifiInfo.on_time_rate).setPer(this.mCurrentWifiInfo.per).setTxMpdu(this.mCurrentWifiInfo.tx_mpdu).setRxMpdu(this.mCurrentWifiInfo.rx_mpdu).setTxRetries(this.mCurrentWifiInfo.tx_retries).setTxLinkSpeed(this.mCurrentWifiInfo.tx_link_speed).setRxLinkSpeed(this.mCurrentWifiInfo.rx_link_speed).setTxSpeedKbps(this.mCurrentWifiInfo.tx_speed_kbps).setRxSpeedKbps(this.mCurrentWifiInfo.rx_speed_kbps).setL4QoeStateGood(this.mCurrentWifiInfo.isL4QoEGood).setRtt(this.mCurrentWifiInfo.rtt).setSendRate(this.mCurrentWifiInfo.sendRate).setRecvRate(this.mCurrentWifiInfo.recvRate).setSendPackets(this.mCurrentWifiInfo.sendPackets).setRecvPackets(this.mCurrentWifiInfo.recvPackets).setRetranRate(this.mCurrentWifiInfo.retranRate).setRecvOooPercent(this.mCurrentWifiInfo.recvOooPercent).setStreamNum(this.mCurrentWifiInfo.streamNum);
        r13 = this.mCurrentWifiInfo;
        goto L10
    L7:
        return r11.build();
    }

    private void startCollect() {
        this.mHandler.postDelayed(new AnonymousClass2(this), 1000);
    }

    private void stopAllCollect() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void updateWifiStats(DeltaInfoParcel r8) {
        NetworkQoEInfo r10 = this.mCurrentWifiInfo;
        r10.cca_busy_rate = r8.f4111o;
        r10.channel_busy_rate = r8.f4112p;
        r10.on_time_rate = r8.f4110n;
        r10.tx_mpdu = r8.f4116t;
        r10.rx_mpdu = r8.f4117u;
        r10.tx_retries = r8.f4118v;
        r10.per = r8.f4119w;
        r10.tx_speed_kbps = r8.f4121y;
        r10.rx_speed_kbps = r8.f4122z;
        r10.tx_link_speed = r8.A;
        r10.rx_link_speed = r8.B;
    }

    public ConcurrentLinkedQueue<NetworkQoE> getRingBufferQoEInfo(int r8) {
        if (r8 == 0) goto L10;
        if (r8 == 1) goto L8;
        return new ConcurrentLinkedQueue();
    L8:
        return this.mRingBufferWifiInfo;
    L10:
        return this.mRingBufferCellInfo;
    }

    public void updateDefaultNetwork(int r8) {
        if (r8 == 0) goto L7;
        if (r8 == 1) goto L6;
        this.mCurrentCellInfo.isDefault = false;
    L8:
        NetworkQoEInfo r10 = this.mCurrentWifiInfo;
    L9:
        r10.isDefault = false;
        return;
    L6:
        this.mCurrentWifiInfo.isDefault = true;
        r10 = this.mCurrentCellInfo;
        goto L9
    L7:
        this.mCurrentCellInfo.isDefault = true;
        goto L8
    }

    public void updateForegroundPackageName(String r8) {
        this.mForegroundPackageName = r8;
    }

    public void updateL2QoEInfo(int r8, boolean r10, int r11, int r12) {
        if (r8 != 0) goto L4;
        NetworkQoEInfo r13 = this.mCurrentCellInfo;
    L8:
        r13.isL2QoEGood = r10;
        r13.tx_throughput = r11;
        r13.rx_throughput = r12;
        return;
    L4:
        if (r8 != 1) goto L10;
        r13 = this.mCurrentWifiInfo;
        goto L8
    }

    public void updateL4QoEInfo(int r8, boolean r10, L4NetEvaluate.L4NetStats r11) {
        if (r8 != 0) goto L4;
        NetworkQoEInfo r12 = this.mCurrentCellInfo;
    L8:
        r12.isL4QoEGood = r10;
        r12.rtt = r11.rttAve;
        r12.retranRate = r11.sendRetrans;
        r12.sendPackets = r11.sendPackets;
        r12.recvPackets = r11.recvPackets;
        r12.recvOooPercent = r11.recvOooPercent;
        r12.unacked = r11.unacked;
        r12.sendRate = r11.sendRate;
        r12.recvRate = r11.recvRate;
        r12.streamNum = r11.streamNum;
        return;
    L4:
        if (r8 != 1) goto L10;
        r12 = this.mCurrentWifiInfo;
        goto L8
    }

    public void updateNetworkStatus(int r8, boolean r10) {
        if (r8 != 0) goto L4;
        this.mIsCellConnected = r10;
    L8:
        if (r10 == true) goto L11;
        clearNetworkQoEInfo(r8);
        return;
    L11:
        return;
    L4:
        if (r8 != 1) goto L8;
        this.mIsWifiConnected = r10;
        goto L8
    }

    public void updateNetworkValidity(int r8, boolean r10) {
        if (r8 != 0) goto L4;
        NetworkQoEInfo r11 = this.mCurrentCellInfo;
    L8:
        r11.isValid = r10;
        return;
    L4:
        if (r8 != 1) goto L10;
        r11 = this.mCurrentWifiInfo;
        goto L8
    }
}
