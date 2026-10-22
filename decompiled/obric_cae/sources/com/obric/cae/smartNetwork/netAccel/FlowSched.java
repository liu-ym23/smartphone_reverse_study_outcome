package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.os.SystemClock;
import android.system.OsConstants;
import com.cae.caed.SocketTupleParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTcpInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class FlowSched {
    private static final int MIN_LOAD_VALID_QUOTA = 1;
    private static final int MIN_VALID_DOWNLOAD_THROUGHPUT_THRESHOLD = 0;
    private static final int MIN_VALID_IFACE_FLOW_DIFF = 2;
    private static final int REMAIN_LOAD_VALID_FLOW = 2;
    private static final String TAG = "MultiNetwork-FlowSched";
    private static final long ZERO_IFACE_FLOW_DIFF = 0;
    private AtomicBoolean isRunning;
    private AccelConfigManager mAccelConfigManager;
    private final AccelControl mAccelControl;
    private final Context mContext;
    private final L4NetEvaluate mL4NetEvaluate;
    private MultiNetInfo mMultiNetInfo;
    private final ConcurrentHashMap<Integer, Long> mSchedStats;
    private final L4NetEvaluate.L4NetTcpInfoListenerCallback mTrafficStatistics;

    public static class IfaceInfo {
        byte dstNetType;
        private String srcIfname;

        private IfaceInfo() {
            this.dstNetType = 0;
        }

        public static /* synthetic */ String access$300(IfaceInfo r8) {
            return r8.srcIfname;
        }

        public IfaceInfo setDstNetType(byte r8) {
            this.dstNetType = r8;
            return this;
        }

        public IfaceInfo setSrcIfname(String r8) {
            this.srcIfname = r8;
            return this;
        }

        public String toString() {
            StringBuilder r8 = new StringBuilder("{ srcIfname: ");
            r8.append(this.srcIfname);
            r8.append(", dstNetType: ");
            return android.aimedia.a.h(r8, this.dstNetType, "}");
        }

        public /* synthetic */ IfaceInfo(AnonymousClass1 r8) {
            this();
        }
    }

    public static class NetworkLoad {
        int flowRateDiff;
        int flowRateLevel;
        byte netType;
        int quota;
        int realFlow;

        public NetworkLoad(byte r8, int r10, int r11) {
            this.netType = r8;
            this.quota = r10;
            this.realFlow = r11;
            this.flowRateLevel = r11 / r10;
            this.flowRateDiff = r11 % r10;
        }
    }

    public static class UidSocketStats {
        private final ConcurrentHashMap<String, ConcurrentHashMap<Long, L4NetTcpInfo>> ifStats;
        private int totalFlowCount;

        public UidSocketStats() {
            this.totalFlowCount = 0;
            this.ifStats = new ConcurrentHashMap();
        }

        public static /* synthetic */ ConcurrentHashMap a(String r8) {
            return lambda$calcStats$0(r8);
        }

        private static /* synthetic */ ConcurrentHashMap lambda$calcStats$0(String r8) {
            return new ConcurrentHashMap();
        }

        public void calcStats(ConcurrentHashMap<Long, L4NetTcpInfo> r8) {
            Iterator<Map.Entry<Long, L4NetTcpInfo>> r10 = r8.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L8;
            Map.Entry<Long, L4NetTcpInfo> r11 = r10.next();
            L4NetTcpInfo r12 = r11.getValue();
            CaeLog.d(FlowSched.TAG, "sIP:sPort - " + r12.srcIP + BdimCategoryConstants.SEPARATOR_COLON + r12.srcPort + ", dIP:dPort - " + r12.dstIP + BdimCategoryConstants.SEPARATOR_COLON + r12.dstPort + ", tcpRecvBytes: " + r12.tcpRecvBytes + ", ifName: " + r12.ifName);
            if (r12.tcpRecvBytes <= 0) goto L4;
            this.ifStats.computeIfAbsent(r12.ifName, new c(1)).put(r11.getKey(), new L4NetTcpInfo(r12));
            this.totalFlowCount++;
            goto L4
        }

        public L4NetTcpInfo getMinRateSocket(String r10) {
            Long r8 = 0L;
            Long r11 = Long.MAX_VALUE;
            ConcurrentHashMap<Long, L4NetTcpInfo> r12 = this.ifStats.get(r10);
            if (r12 != null) goto L5;
            return null;
        L5:
            if (r12.size() == 0) goto L22;
            Iterator<Map.Entry<Long, L4NetTcpInfo>> r13 = r12.entrySet().iterator();
        L9:
            if (r13.hasNext() == false) goto L14;
            Map.Entry<Long, L4NetTcpInfo> r14 = r13.next();
            L4NetTcpInfo r15 = r14.getValue();
            long r16 = r11.longValue();
            long r17 = r15.tcpRecvBytes;
            if (r16 < r17) goto L9;
            Long r18 = Long.valueOf(r17);
            Long r19 = r14.getKey();
            r11 = r18;
            r8 = r19;
            goto L9
        L14:
            return r12.get(r8);
        L22:
            return null;
        }

        public int getRealFlowCount(String r8) {
            if (this.ifStats.get(r8) != null) goto L6;
            CaeLog.d(FlowSched.TAG, "ifaceName: " + r8 + " not found");
            return 0;
        L6:
            CaeLog.d(FlowSched.TAG, "ifaceName: " + r8 + " found");
            return this.ifStats.get(r8).size();
        }

        public int getTotalFlowCount() {
            return this.totalFlowCount;
        }
    }

    public FlowSched(Context r8, AccelControl r10) {
        this.mSchedStats = new ConcurrentHashMap();
        this.isRunning = new AtomicBoolean(false);
        this.mTrafficStatistics = new AnonymousClass1(this);
        this.mAccelControl = r10;
        this.mContext = r8;
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        this.mAccelConfigManager = AccelConfigManager.getInstance(r8);
    }

    public static /* synthetic */ int a(NetworkLoad r8, NetworkLoad r10) {
        return lambda$calcSchedIfaceInfo$0(r8, r10);
    }

    public static /* synthetic */ MultiNetInfo access$000(FlowSched r8) {
        return r8.mMultiNetInfo;
    }

    public static /* synthetic */ void access$100(FlowSched r8, int r10, UidSocketStats r11) {
        r8.schedulFlowAdjustment(r10, r11);
    }

    private IfaceInfo calcSchedIfaceInfo(UidSocketStats r12) {
        ArrayList r8 = new ArrayList(this.mMultiNetInfo.getAvailableNetMap().entrySet());
        AnonymousClass1 r10 = null;
        if (r8.size() >= 2) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator r13 = r8.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        byte r15 = ((Integer) r14.getKey()).byteValue();
        int r16 = ((MultiNetInfo.AccelNet) r14.getValue()).getQuota();
        String r17 = this.mMultiNetInfo.getIfaceName(r15);
        int r18 = r12.getRealFlowCount(r17);
        CaeLog.d(TAG, "netType: " + r15 + ", ifaceName: " + r17 + ", quota: " + r16 + ", realFlow: " + r18);
        r11.add(new NetworkLoad(r15, r16, r18));
        goto L7
    L9:
        Collections.sort(r11, new e());
        NetworkLoad r19 = (NetworkLoad) r11.get(0);
        NetworkLoad r20 = (NetworkLoad) r11.get(r11.size() - 1);
        int r21 = r19.flowRateLevel;
        int r22 = r20.flowRateLevel;
        StringBuilder r23 = defpackage.b.f("minLevel: ", r21, ", minLoad.flowRateDiff: ");
        defpackage.b.q(r23, r19.flowRateDiff, ", maxLevel: ", r22, ", maxLoad.flowRateDiff: ");
        defpackage.a.j(r23, r20.flowRateDiff, TAG);
        if (r22 == r21) goto L12;
        int r24 = r21 + 1;
        if (r22 <= r24) goto L20;
        IfaceInfo r25 = new IfaceInfo(r10);
    L29:
        return r25.setSrcIfname(this.mMultiNetInfo.getIfaceName(r20.netType)).setDstNetType(r19.netType);
    L20:
        if (r22 == r24) goto L22;
    L30:
        return null;
    L22:
        if ((r20.quota + r20.flowRateDiff) < 2) goto L30;
        int r26 = r19.quota;
        if (r26 != 1) goto L26;
    L27:
        r25 = new IfaceInfo(r10);
        goto L29
    L26:
        if ((r26 - r19.flowRateDiff) < 2) goto L30;
    L12:
        if (r20.flowRateDiff >= 2) goto L14;
    L16:
        return null;
    L14:
        if (r19.flowRateDiff != 0) goto L16;
        r25 = new IfaceInfo(r10);
        goto L29
    }

    private static /* synthetic */ int lambda$calcSchedIfaceInfo$0(NetworkLoad r8, NetworkLoad r10) {
        int r11 = r8.flowRateLevel;
        int r12 = r10.flowRateLevel;
        if (r11 == r12) goto L7;
        return Integer.compare(r11, r12);
    L7:
        return Integer.compare(r8.flowRateDiff, r10.flowRateDiff);
    }

    private String makeTcpInfoString(L4NetTcpInfo r8) {
        if (r8 == null) goto L4;
        StringBuilder r10 = android.aimedia.a.k("{ ifname: " + r8.ifName, ", family: ");
        r10.append(r8.family);
        StringBuilder r11 = android.aimedia.a.k(r10.toString(), ", srcIP: ");
        r11.append(r8.srcIP);
        StringBuilder r12 = android.aimedia.a.k(r11.toString(), ", srcPort: ");
        r12.append(r8.srcPort);
        StringBuilder r13 = android.aimedia.a.k(r12.toString(), ", dstIP: ");
        r13.append(r8.dstIP);
        StringBuilder r14 = android.aimedia.a.k(r13.toString(), ", dstPort: ");
        r14.append(r8.dstPort);
        return defpackage.a.e(r14.toString(), "}");
    L4:
        return "";
    }

    private void schedulFlowAdjustment(int r8, UidSocketStats r10) {
        long r11 = SystemClock.uptimeMillis();
        Long r12 = this.mSchedStats.get(Integer.valueOf(r8));
        CaeLog.d(TAG, "uptimeMillis: " + r11 + ", mSchedStats.get(uid): " + r12);
        if (r12 != null) goto L5;
    L7:
        IfaceInfo r13 = calcSchedIfaceInfo(r10);
        if (r13 == null) goto L23;
        L4NetTcpInfo r14 = r10.getMinRateSocket(IfaceInfo.access$300(r13));
        if (r14 != null) goto L12;
        return;
    L12:
        if (r14.family == OsConstants.AF_INET6) goto L14;
    L17:
        SocketTupleParcel r15 = new SocketTupleParcel();
        r15.f4187q = r14.ifName;
        if (r14.family != OsConstants.AF_INET) goto L20;
        byte r16 = 2;
    L21:
        r15.f4181a = r16;
        r15.f4182b = 6;
        r15.f4183m = r14.srcIP;
        r15.f4185o = r14.dstIP;
        r15.f4184n = r14.srcPort;
        r15.f4186p = r14.dstPort;
        this.mAccelControl.schedSocketToNextNet(r15, r13.dstNetType, r8);
        CaeLog.d(TAG, "schedule uid: " + r8 + ", tcpInfo " + makeTcpInfoString(r14) + ", ifaceInfo " + r13.toString());
        this.mSchedStats.put(Integer.valueOf(r8), Long.valueOf(r11 + ((long) this.mAccelConfigManager.getFlowSchedIntervalMs())));
        return;
    L20:
        r16 = 10;
        goto L21
    L14:
        if (this.mMultiNetInfo.hasValidIpv6(r13.dstNetType) == true) goto L17;
        CaeLog.d(TAG, "dstNetType: " + r13.dstNetType + " has no Ipv6");
        return;
    L23:
        return;
    L5:
        if (r12.longValue() <= r11) goto L7;
    }

    public void start(MultiNetInfo r8) {
        if (this.isRunning.get() == false) goto L5;
        return;
    L5:
        this.isRunning.set(true);
        this.mMultiNetInfo = r8;
        boolean r10 = this.mL4NetEvaluate.registerL4NetTcpInfoListener(this.mTrafficStatistics);
        this.mL4NetEvaluate.start();
        CaeLog.i(TAG, "isRegistered: " + r10);
    }

    public void stop() {
        if (this.isRunning.get() == true) goto L5;
        return;
    L5:
        this.isRunning.set(false);
        boolean r8 = this.mL4NetEvaluate.unregisterL4NetTcpInfoListener(this.mTrafficStatistics);
        this.mL4NetEvaluate.stop();
        this.mSchedStats.clear();
        CaeLog.i(TAG, "isUnregistered: " + r8);
    }
}
