package com.obric.cae.smartNetwork.L4NetEvaluate;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteCallbackList;
import com.obric.cae.libs.l4NetStatus.IQoeStatusListener;
import com.obric.cae.libs.l4NetStatus.QoeStatus;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventsConsumer;
import com.obric.cae.smartNetwork.NetworkAccelerate.TicketGrabbingManager;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.AppCategoryHelper;
import com.obric.cae.smartNetwork.networkRateLimit.RateControlManager;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.utils.CaeUtil;
import ha.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class L4NetEvaluate {
    private static final String TAG = "L4NetEvaluate";
    private static final int UID_RTT_CACHE_INACTIVE_THRESHOLD = 300;
    private static L4NetEvaluate mNetEvaluate;
    private ErrWindowPara mAppNoDownErrWin;
    private Context mContext;
    private final LinkedList<L4NetErrReportCb> mErrReportCbList;
    private final Object mErrReportCbListLock;
    L4NetForegroundApp mForegroundApp;
    private boolean mIsStarted;
    private final Set<L4NetTcpInfoListenerCallback> mL4NetTcpInfoListenerSet;
    private L4NetTracker mNetTracker;
    private final ConcurrentHashMap<String, L4NetStats> mNetifDiff;
    private final ConcurrentHashMap<String, NetifErrWindow> mNetifErrWinMap;
    private final ConcurrentHashMap<String, L4NetStats> mNetifRttCache;
    private final ConcurrentHashMap<String, L4NetStats> mNetifStats;
    private final L4NetEvaluateObserver mObserver;
    private final Handler mQoeCallbackHandler;
    private final HandlerThread mQoeCallbackThread;
    private final RemoteCallbackList<IQoeStatusListener> mQoeListeners;
    private final RateControlManager mRateControlManager;
    private int mRefCnt;
    private SpecificAppEvaluate mSpecificAppEvaluate;
    private final Object mStartStopLock;
    private final ConcurrentHashMap<Long, L4NetTcpInfo> mTcpInfoMap;
    TicketGrabbingManager mTicketGrabbingManager;
    private int mTrackerTimes;
    private final ConcurrentHashMap<Integer, L4NetStats> mUidDiff;
    private final ConcurrentHashMap<Integer, UidNetifRateStats> mUidNetifRateStats;
    private final ConcurrentHashMap<Integer, L4NetStats> mUidRttCache;
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> mUidSocketMap;
    private final ConcurrentHashMap<Integer, L4NetStats> mUidStats;

    public static class ErrWindowPara {
        private LinkedList<Integer> list;
        private final int period;
        private final int threshold;
        private ErrorType type;
        private int winSum;

        public ErrWindowPara(ErrorType r8, LinkedList<Integer> r10, int r11, int r12, int r13) {
            this.type = r8;
            this.list = r10;
            this.winSum = r11;
            this.period = r12;
            this.threshold = r13;
        }

        public static /* synthetic */ LinkedList access$1000(ErrWindowPara r8) {
            return r8.list;
        }

        public static /* synthetic */ int access$1100(ErrWindowPara r8) {
            return r8.winSum;
        }

        public static /* synthetic */ int access$1108(ErrWindowPara r8) {
            int r10 = r8.winSum;
            r8.winSum = r10 + 1;
            return r10;
        }

        public static /* synthetic */ int access$1120(ErrWindowPara r8, int r10) {
            int r11 = r8.winSum - r10;
            r8.winSum = r11;
            return r11;
        }

        public static /* synthetic */ int access$1200(ErrWindowPara r8) {
            return r8.period;
        }

        public static /* synthetic */ int access$1300(ErrWindowPara r8) {
            return r8.threshold;
        }

        public static /* synthetic */ ErrorType access$1400(ErrWindowPara r8) {
            return r8.type;
        }

        public void clean() {
            this.list.clear();
            this.winSum = 0;
        }
    }

    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType FOREGROUND_APP_NO_DOWNLOAD_ERR = null;
        public static final ErrorType HUGE_RTT_ERR = null;
        public static final ErrorType NONE_ERR = null;
        public static final ErrorType NO_DOWNLOAD_ERR = null;
        public static final ErrorType QOS_BAD_ERR = null;
        public static final ErrorType RETRANS_ERR = null;
        public static final ErrorType UP_RETRANS_ERR = null;
        private final int value;

        private static /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{NONE_ERR, UP_RETRANS_ERR, RETRANS_ERR, FOREGROUND_APP_NO_DOWNLOAD_ERR, HUGE_RTT_ERR, NO_DOWNLOAD_ERR, QOS_BAD_ERR};
        }

        static {
            NONE_ERR = new ErrorType("NONE_ERR", 0, 0);
            UP_RETRANS_ERR = new ErrorType("UP_RETRANS_ERR", 1, 1);
            RETRANS_ERR = new ErrorType("RETRANS_ERR", 2, 2);
            FOREGROUND_APP_NO_DOWNLOAD_ERR = new ErrorType("FOREGROUND_APP_NO_DOWNLOAD_ERR", 3, 4);
            HUGE_RTT_ERR = new ErrorType("HUGE_RTT_ERR", 4, 8);
            NO_DOWNLOAD_ERR = new ErrorType("NO_DOWNLOAD_ERR", 5, 16);
            QOS_BAD_ERR = new ErrorType("QOS_BAD_ERR", 6, 32);
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

    public static final enum ForegroundAppStrategy extends Enum<ForegroundAppStrategy> {
        private static final /* synthetic */ ForegroundAppStrategy[] $VALUES = null;
        public static final ForegroundAppStrategy NETWORK_HANDOVER = null;
        public static final ForegroundAppStrategy NONE = null;
        public static final ForegroundAppStrategy TICKET_GRABBING = null;

        private static /* synthetic */ ForegroundAppStrategy[] $values() {
            return new ForegroundAppStrategy[]{NONE, NETWORK_HANDOVER, TICKET_GRABBING};
        }

        static {
            NONE = new ForegroundAppStrategy(BdimCategoryConstants.VALUE_NONE, 0);
            NETWORK_HANDOVER = new ForegroundAppStrategy("NETWORK_HANDOVER", 1);
            TICKET_GRABBING = new ForegroundAppStrategy("TICKET_GRABBING", 2);
            $VALUES = $values();
        }

        private ForegroundAppStrategy(String r8, int r10) {
            super(r8, r10);
        }

        public static ForegroundAppStrategy valueOf(String r8) {
            return (ForegroundAppStrategy) Enum.valueOf(ForegroundAppStrategy.class, r8);
        }

        public static ForegroundAppStrategy[] values() {
            return (ForegroundAppStrategy[]) $VALUES.clone();
        }
    }

    public interface L4NetErrReportCb {
        void errReportCb(L4NetStats r8);
    }

    public static class L4NetForegroundApp {
        public String appName;
        public String appPackageName;
        public int pid;
        public ForegroundAppStrategy strategy;
        public int uid;

        public L4NetForegroundApp() {
        }
    }

    public static class L4NetStats {
        public String appPackageName;
        public int errBitMap;
        public String ifName;
        public int lastUpdateTime;
        public int recvOooPercent;
        public int recvPackets;
        public int recvRate;
        public int rttAve;
        public int sendPackets;
        public int sendRate;
        public int sendRetrans;
        public StatSrcType statSrcType;
        public int streamNum;
        public int tcpSndCwnd;
        public int tcpSndSsthresh;
        public long totalRecvBytes;
        public long totalRecvPackets;
        public long totalSegsIn;
        public long totalSegsOut;
        public long totalSendBytes;
        public long totalSendPackets;
        public int uid;
        public int unacked;

        public L4NetStats() {
            this.statSrcType = StatSrcType.UNKNOWN;
            this.appPackageName = "NULL";
            this.ifName = "NULL";
        }

        public String toString() {
            return " statSrcType:" + this.statSrcType + " uid:" + this.uid + " appPackageName:" + this.appPackageName + " ifName:" + this.ifName + " streamNum:" + this.streamNum + " rttAve:" + this.rttAve + " totalSendPackets:" + this.totalSendPackets + " totalRecvPackets:" + this.totalRecvPackets + " totalSegsOut:" + this.totalSegsOut + " totalSegsIn:" + this.totalSegsIn + " totalSendBytes:" + this.totalSendBytes + " totalRecvBytes:" + this.totalRecvBytes + " sendPackets:" + this.sendPackets + " recvPackets:" + this.recvPackets + " sendRate(Bps):" + this.sendRate + " recvRate(Bps):" + this.recvRate + " sendRetrans:" + this.sendRetrans + " recvOooPercent:" + this.recvOooPercent + " unacked:" + this.unacked + " errBitMap:" + this.errBitMap + " tcpSndSsthresh:" + this.tcpSndSsthresh + " tcpSndCwnd:" + this.tcpSndCwnd;
        }

        public L4NetStats(L4NetStats r8) {
            this.statSrcType = r8.statSrcType;
            this.uid = r8.uid;
            this.appPackageName = r8.appPackageName;
            this.ifName = r8.ifName;
            this.streamNum = r8.streamNum;
            this.rttAve = r8.rttAve;
            this.totalSendPackets = r8.totalSendPackets;
            this.totalRecvPackets = r8.totalRecvPackets;
            this.totalSegsOut = r8.totalSegsOut;
            this.totalSegsIn = r8.totalSegsIn;
            this.totalSendBytes = r8.totalSendBytes;
            this.totalRecvBytes = r8.totalRecvBytes;
            this.sendPackets = r8.sendPackets;
            this.recvPackets = r8.recvPackets;
            this.sendRate = r8.sendRate;
            this.recvRate = r8.recvRate;
            this.sendRetrans = r8.sendRetrans;
            this.recvOooPercent = r8.recvOooPercent;
            this.unacked = r8.unacked;
            this.tcpSndSsthresh = r8.tcpSndSsthresh;
            this.tcpSndCwnd = r8.tcpSndCwnd;
            this.errBitMap = r8.errBitMap;
        }
    }

    public interface L4NetTcpInfoListenerCallback {
        void onL4NetTcpInfoReport(ConcurrentHashMap<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> r8);
    }

    public class NetifErrWindow {
        private final ErrWindowPara noDownErrWin;
        private final ErrWindowPara qosBadErrWin;
        private final ErrWindowPara retransErrWin;
        final /* synthetic */ L4NetEvaluate this$0;
        private final ErrWindowPara upRetransErrWin;

        public NetifErrWindow(L4NetEvaluate r14) {
            this.this$0 = r14;
            this.upRetransErrWin = new ErrWindowPara(ErrorType.UP_RETRANS_ERR, new LinkedList(), 0, L4NetEvaluate.access$000(r14).getUpRetransErrTimePeriod(), L4NetEvaluate.access$000(r14).getUpRetransErrTimesThreshold());
            this.retransErrWin = new ErrWindowPara(ErrorType.RETRANS_ERR, new LinkedList(), 0, L4NetEvaluate.access$000(r14).getRetransErrTimePeriod(), L4NetEvaluate.access$000(r14).getRetransErrTimesThreshold());
            this.noDownErrWin = new ErrWindowPara(ErrorType.NO_DOWNLOAD_ERR, new LinkedList(), 0, L4NetEvaluate.access$000(r14).getNoDownloadErrTimePeriod(), L4NetEvaluate.access$000(r14).getNoDownloadErrTimesThreshold());
            this.qosBadErrWin = new ErrWindowPara(ErrorType.QOS_BAD_ERR, new LinkedList(), 0, L4NetEvaluate.access$000(r14).getQosBadErrTimePeriod(), L4NetEvaluate.access$000(r14).getQosBadErrTimesThreshold());
        }

        public static /* synthetic */ ErrWindowPara access$1500(NetifErrWindow r8) {
            return r8.upRetransErrWin;
        }

        public static /* synthetic */ ErrWindowPara access$1600(NetifErrWindow r8) {
            return r8.retransErrWin;
        }

        public static /* synthetic */ ErrWindowPara access$1700(NetifErrWindow r8) {
            return r8.noDownErrWin;
        }

        public static /* synthetic */ ErrWindowPara access$1800(NetifErrWindow r8) {
            return r8.qosBadErrWin;
        }
    }

    public static final enum StatSrcType extends Enum<StatSrcType> {
        private static final /* synthetic */ StatSrcType[] $VALUES = null;
        public static final StatSrcType RMNET0 = null;
        public static final StatSrcType RMNET1 = null;
        public static final StatSrcType TUN0 = null;
        public static final StatSrcType UID = null;
        public static final StatSrcType UNKNOWN = null;
        public static final StatSrcType WLAN0 = null;
        public static final StatSrcType WLAN1 = null;

        private static /* synthetic */ StatSrcType[] $values() {
            return new StatSrcType[]{UNKNOWN, UID, RMNET0, RMNET1, WLAN0, WLAN1, TUN0};
        }

        static {
            UNKNOWN = new StatSrcType(BdimCategoryConstants.VALUE_UNKNOWN, 0);
            UID = new StatSrcType("UID", 1);
            RMNET0 = new StatSrcType("RMNET0", 2);
            RMNET1 = new StatSrcType("RMNET1", 3);
            WLAN0 = new StatSrcType("WLAN0", 4);
            WLAN1 = new StatSrcType("WLAN1", 5);
            TUN0 = new StatSrcType("TUN0", 6);
            $VALUES = $values();
        }

        private StatSrcType(String r8, int r10) {
            super(r8, r10);
        }

        public static StatSrcType valueOf(String r8) {
            return (StatSrcType) Enum.valueOf(StatSrcType.class, r8);
        }

        public static StatSrcType[] values() {
            return (StatSrcType[]) $VALUES.clone();
        }
    }

    public static class UidNetifRateStats {
        public boolean isUpdate;
        public UidQosStats rmnet0QosStats;
        public UidQosStats rmnet1QosStats;
        public UidQosStats totalQosStats;
        public UidQosStats wlan0QosStats;
        public UidQosStats wlan1QosStats;

        public UidNetifRateStats() {
            this.totalQosStats = new UidQosStats();
            this.wlan0QosStats = new UidQosStats();
            this.wlan1QosStats = new UidQosStats();
            this.rmnet0QosStats = new UidQosStats();
            this.rmnet1QosStats = new UidQosStats();
        }

        public void clean() {
            this.totalQosStats.clean();
            this.wlan0QosStats.clean();
            this.wlan1QosStats.clean();
            this.rmnet0QosStats.clean();
            this.rmnet1QosStats.clean();
            this.isUpdate = false;
        }

        public String toString() {
            return " totalQosStats:" + this.totalQosStats + " wlan0QosStats:" + this.wlan0QosStats + " wlan1QosStats:" + this.wlan1QosStats + " rmnet0QosStats:" + this.rmnet0QosStats + " rmnet1QosStats:" + this.rmnet1QosStats;
        }
    }

    public static class UidQosStats {
        public int recvOooPackets;
        public int recvOooPercent;
        public int recvPackets;
        public int recvRate;
        public int retransPackets;
        public int rttAve;
        public int rttSum;
        public int sendPackets;
        public int sendRate;
        public int sendRetrans;
        public int streamNum;
        public int unacked;

        public UidQosStats() {
        }

        public void clean() {
            this.streamNum = 0;
            this.rttSum = 0;
            this.rttAve = 0;
            this.sendPackets = 0;
            this.recvPackets = 0;
            this.sendRate = 0;
            this.recvRate = 0;
            this.retransPackets = 0;
            this.recvOooPackets = 0;
            this.sendRetrans = 0;
            this.recvOooPercent = 0;
            this.unacked = 0;
        }

        public String toString() {
            StringBuilder r8 = new StringBuilder("{ streamNum:");
            r8.append(this.streamNum);
            r8.append(" rttAve:");
            r8.append(this.rttAve);
            r8.append(" sendPackets:");
            r8.append(this.sendPackets);
            r8.append(" recvPackets:");
            r8.append(this.recvPackets);
            r8.append(" sendRate:");
            r8.append(this.sendRate);
            r8.append(" recvRate:");
            r8.append(this.recvRate);
            r8.append(" retransPackets:");
            r8.append(this.retransPackets);
            r8.append(" recvOooPackets:");
            r8.append(this.recvOooPackets);
            r8.append(" sendRetrans:");
            r8.append(this.sendRetrans);
            r8.append(" recvOooPercent:");
            r8.append(this.recvOooPercent);
            r8.append(" unacked:");
            return android.aimedia.a.h(r8, this.unacked, "}");
        }
    }

    private L4NetEvaluate(Context r8) {
        this.mTrackerTimes = 0;
        this.mTcpInfoMap = new ConcurrentHashMap();
        this.mNetifDiff = new ConcurrentHashMap();
        this.mNetifStats = new ConcurrentHashMap();
        this.mNetifRttCache = new ConcurrentHashMap();
        this.mUidDiff = new ConcurrentHashMap();
        this.mUidStats = new ConcurrentHashMap();
        this.mUidRttCache = new ConcurrentHashMap();
        this.mUidSocketMap = new ConcurrentHashMap();
        this.mUidNetifRateStats = new ConcurrentHashMap();
        this.mNetifErrWinMap = new ConcurrentHashMap();
        this.mIsStarted = false;
        this.mStartStopLock = new Object();
        this.mErrReportCbListLock = new Object();
        this.mRefCnt = 0;
        this.mErrReportCbList = new LinkedList();
        this.mForegroundApp = new L4NetForegroundApp();
        this.mQoeListeners = new AnonymousClass2(this);
        this.mL4NetTcpInfoListenerSet = ConcurrentHashMap.newKeySet();
        this.mNetTracker = L4NetTracker.getInstance(r8);
        this.mContext = r8.getApplicationContext();
        L4NetEvaluateObserver r10 = L4NetEvaluateObserver.getInstance(r8);
        this.mObserver = r10;
        this.mRateControlManager = RateControlManager.getInstance(r8);
        HandlerThread r11 = new HandlerThread("L4NetQoeCallback");
        this.mQoeCallbackThread = r11;
        r11.start();
        this.mQoeCallbackHandler = new Handler(r11.getLooper());
        this.mTicketGrabbingManager = new TicketGrabbingManager(r8, this.mNetTracker);
        this.mSpecificAppEvaluate = new SpecificAppEvaluate(r10.getForegroundAppNoDownloadErrTimePeriod(), r10.getForegroundAppNoDownloadErrTimesThreshold(), r10.getQosBadErrTxRxPktNumThreshold());
    }

    public static void CleanStatsTempParam(L4NetStats r8) {
        r8.streamNum = 0;
        r8.rttAve = 0;
        r8.sendPackets = 0;
        r8.recvPackets = 0;
        r8.sendRate = 0;
        r8.recvRate = 0;
        r8.sendRetrans = 0;
        r8.recvOooPercent = 0;
        r8.unacked = 0;
        r8.tcpSndSsthresh = 0;
        r8.tcpSndCwnd = 0;
        r8.errBitMap = 0;
    }

    private void L4NetStatReport() {
        RateControlManager r8 = this.mRateControlManager;
        if (r8 == null) goto L5;
        r8.updateL4NetStats(this.mNetifStats, this.mUidStats, this.mUidSocketMap, this.mForegroundApp);
    L5:
        Iterator<Map.Entry<String, L4NetStats>> r10 = this.mNetifStats.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L25;
        L4NetStats r11 = r10.next().getValue();
        if (CaeUtil.isNetifUp(this.mContext, r11.ifName, r11.sendPackets + r11.recvPackets) == false) goto L21;
        Object r12 = this.mErrReportCbListLock;
        monitor-enter(r12);
        Iterator<L4NetErrReportCb> r13 = this.mErrReportCbList.iterator();     // Catch: Throwable -> L18
    L14:
        if (r13.hasNext() == false) goto L16;
        r13.next().errReportCb(new L4NetStats(r11));     // Catch: Throwable -> L18
        goto L14
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        CaeUtil.MLog(TAG, "netifStats: " + r11.toString() + L4NetUidStats.getTopThreeAppsString(this.mUidNetifRateStats, r11.statSrcType));
        notifyQoeStatusChanged(convertToQoeStatus(r11));
    L24:
        CleanStatsTempParam(r11);
    L18:
        th = move-exception;
        throw th;
    L21:
        CaeLog.i(TAG, "netif " + r11.ifName + " is down, remove it form map");
        this.mNetifStats.remove(r11.ifName);
        this.mNetifRttCache.remove(r11.ifName);
        this.mNetifErrWinMap.remove(r11.ifName);
        RateControlManager r14 = this.mRateControlManager;
        if (r14 == null) goto L24;
        r14.netifDownProcess(r11.ifName);
        goto L24
    L25:
        L4NetForegroundApp r15 = this.mForegroundApp;
        if (r15.strategy == ForegroundAppStrategy.NONE) goto L41;
        L4NetStats r16 = this.mUidStats.get(Integer.valueOf(r15.uid));
        if (r16 != null) goto L30;
        return;
    L30:
        Object r17 = this.mErrReportCbListLock;
        monitor-enter(r17);
        Iterator<L4NetErrReportCb> r18 = this.mErrReportCbList.iterator();     // Catch: Throwable -> L38
    L34:
        if (r18.hasNext() == false) goto L36;
        r18.next().errReportCb(new L4NetStats(r16));     // Catch: Throwable -> L38
        goto L34
    L36:
        monitor-exit(r17);     // Catch: Throwable -> L38
        CaeLog.i(TAG, "uidStats: " + r16.toString());
        notifyQoeStatusChanged(convertToQoeStatus(r16));
        CleanStatsTempParam(r16);
    L38:
        th = move-exception;
        throw th;
    L41:
        Iterator r19 = new ArrayList(this.mL4NetTcpInfoListenerSet).iterator();
    L43:
        if (r19.hasNext() == false) goto L45;
        ((L4NetTcpInfoListenerCallback) r19.next()).onL4NetTcpInfoReport(this.mUidSocketMap);
        goto L43
    L45:
        this.mSpecificAppEvaluate.specificAppReport(this.mUidStats);
        this.mUidSocketMap.clear();
    }

    public static /* synthetic */ boolean a(L4NetEvaluate r8, int r10, Map.Entry r11) {
        return r8.lambda$removeInactiveUidRttCache$3(r10, r11);
    }

    public static /* synthetic */ L4NetEvaluateObserver access$000(L4NetEvaluate r8) {
        return r8.mObserver;
    }

    public static /* synthetic */ void access$100(L4NetEvaluate r8, L4NetTcpInfo r10) {
        r8.tcpInfoUpdate(r10);
    }

    public static /* synthetic */ RemoteCallbackList access$1900(L4NetEvaluate r8) {
        return r8.mQoeListeners;
    }

    public static /* synthetic */ void access$200(L4NetEvaluate r8) {
        r8.netifStatsUpdate();
    }

    public static /* synthetic */ void access$300(L4NetEvaluate r8) {
        r8.uidStatsUpdate();
    }

    public static /* synthetic */ void access$400(L4NetEvaluate r8) {
        r8.removeClosedTcpInfo();
    }

    public static /* synthetic */ void access$500(L4NetEvaluate r8) {
        r8.removeNoTcpUidNetifRateStats();
    }

    public static /* synthetic */ void access$600(L4NetEvaluate r8) {
        r8.removeInactiveUidRttCache();
    }

    public static /* synthetic */ void access$700(L4NetEvaluate r8) {
        r8.checkL4NetError();
    }

    public static /* synthetic */ void access$800(L4NetEvaluate r8) {
        r8.L4NetStatReport();
    }

    public static /* synthetic */ int access$908(L4NetEvaluate r8) {
        int r10 = r8.mTrackerTimes;
        r8.mTrackerTimes = r10 + 1;
        return r10;
    }

    private void applyDiffToStats(L4NetStats r10, L4NetStats r11) {
        r11.streamNum = r10.streamNum;
        int r8 = r10.streamNum;
        int r12 = 0;
        if (r8 != 0) goto L5;
        int r13 = 0;
    L6:
        r11.rttAve = r13;
        r11.totalSendPackets += r10.totalSendPackets;
        r11.totalRecvPackets += r10.totalRecvPackets;
        r11.totalSegsOut += r10.totalSegsOut;
        r11.totalSegsIn += r10.totalSegsIn;
        r11.totalSendBytes += r10.totalSendBytes;
        r11.totalRecvBytes += r10.totalRecvBytes;
        r11.sendPackets = (int) r10.totalSegsOut;
        r11.recvPackets = (int) r10.totalSegsIn;
        r11.sendRate = (int) ((r10.totalSendBytes * 1000) / ((long) this.mNetTracker.getInterval()));
        r11.recvRate = (int) ((r10.totalRecvBytes * 1000) / ((long) this.mNetTracker.getInterval()));
        int r14 = r11.sendPackets;
        if (r14 != 0) goto L9;
        int r15 = 0;
    L10:
        r11.sendRetrans = r15;
        int r16 = r11.recvPackets;
        if (r16 == 0) goto L14;
        r12 = (r10.recvOooPercent * 100) / r16;
    L14:
        r11.recvOooPercent = r12;
        r11.unacked = r10.unacked;
        r11.tcpSndSsthresh = r10.tcpSndSsthresh;
        r11.tcpSndCwnd = r10.tcpSndCwnd;
        return;
    L9:
        r15 = (r10.sendRetrans * 100) / r14;
        goto L10
    L5:
        r13 = r10.rttAve / r8;
        goto L6
    }

    public static /* synthetic */ boolean b(Map.Entry r8) {
        return lambda$removeNoTcpUidNetifRateStats$0(r8);
    }

    public static /* synthetic */ void c(L4NetEvaluate r8, Long r10, L4NetTcpInfo r11) {
        r8.lambda$removeClosedTcpInfo$2(r10, r11);
    }

    private static long checkAndGetDiff(long r8, long r10) {
        if (r10 >= r8) goto L6;
        return r8;
    L6:
        return r10 - r8;
    }

    private void checkL4NetError() {
        checkUidErr();
        if (this.mForegroundApp.strategy != ForegroundAppStrategy.NONE) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, L4NetStats>> r8 = this.mNetifStats.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L72;
        Map.Entry<String, L4NetStats> r10 = r8.next();
        HashMap<ErrorType, Boolean> r11 = new HashMap();
        String r12 = r10.getKey();
        L4NetStats r13 = r10.getValue();
        if (r13.sendRate <= this.mObserver.getIgnoreErrThroughputThreshold()) goto L11;
    L70:
        r8 = r8;
        StringBuilder r14 = defpackage.b.h("ignore err for high throughput, netif:", r12, " sendRate:");
        r14.append(r13.sendRate);
        r14.append(" recvRate:");
        r14.append(r13.recvRate);
        r14.append(" (");
        r14.append(this.mObserver.getIgnoreErrThroughputThreshold());
        r14.append(")");
        CaeLog.i(TAG, r14.toString());
    L71:
        r8 = r8;
        goto L7
    L11:
        if (r13.recvRate > this.mObserver.getIgnoreErrThroughputThreshold()) goto L70;
        if (r13.sendRetrans <= this.mObserver.getUpRetransErrSendRetransThreshold()) goto L21;
        if (r13.sendPackets <= this.mObserver.getUpRetransErrTxRxPktNumThreshold()) goto L18;
    L19:
        ErrorType r15 = ErrorType.UP_RETRANS_ERR;
        r11.put(r15, Boolean.TRUE);
        CaeLog.i(TAG, "warning, netif:" + r12 + " ErrorType:" + r15 + " sendRetrans:" + r13.sendRetrans + "(" + this.mObserver.getUpRetransErrSendRetransThreshold() + ") sendPackets:" + r13.sendPackets + " recvPackets:" + r13.recvPackets + " (" + this.mObserver.getUpRetransErrTxRxPktNumThreshold() + ") unacked:" + r13.unacked + "(" + this.mObserver.getUpRetransErrUnackedThreshold() + ")");
        goto L21
    L18:
        if (r13.unacked > this.mObserver.getUpRetransErrUnackedThreshold()) goto L19;
    L21:
        if (r13.sendRetrans < this.mObserver.getRetransErrLowRetransThreshold()) goto L25;
        if (r13.sendPackets <= this.mObserver.getRetransErrHighPktNumThreshold()) goto L25;
    L44:
        ErrorType r16 = ErrorType.RETRANS_ERR;
        r11.put(r16, Boolean.TRUE);
        CaeLog.i(TAG, "warning, netif:" + r12 + " ErrorType:" + r16 + " sendRetrans:" + r13.sendRetrans + " recvOooPercent:" + r13.recvOooPercent + " (" + this.mObserver.getRetransErrRxLowRetransThreshold() + "," + this.mObserver.getRetransErrRxHighRetransThreshold() + ") sendPackets:" + r13.sendPackets + " recvPackets:" + r13.recvPackets + " (" + this.mObserver.getRetransErrLowPktNumThreshold() + "," + this.mObserver.getRetransErrHighPktNumThreshold() + ")");
    L46:
        if (r13.rttAve <= this.mObserver.getRttErrRttThreshold()) goto L52;
        if (r13.sendRate <= this.mObserver.getRttErrRateThreshold()) goto L52;
        int r17 = r13.errBitMap;
        ErrorType r18 = ErrorType.HUGE_RTT_ERR;
        r13.errBitMap = r17 | r18.getValue();
        CaeLog.e(TAG, "report err netif:" + r12 + " ErrorType:" + r18 + " rttAve:" + r13.rttAve + "(" + this.mObserver.getRttErrRttThreshold() + ") sendRate:" + r13.sendRate + "(" + this.mObserver.getRttErrRateThreshold() + ")");
    L52:
        if (r13.sendPackets <= this.mObserver.getQosBadErrTxRxPktNumThreshold()) goto L57;
        if (r13.recvPackets != 0) goto L57;
        ErrorType r19 = ErrorType.NO_DOWNLOAD_ERR;
        r11.put(r19, Boolean.TRUE);
        StringBuilder r20 = new StringBuilder("warning, netif:");
        r20.append(r12);
        r20.append(" ErrorType:");
        r20.append(r19);
        r20.append(" sendPackets:");
        r20.append(r13.sendPackets);
        r20.append("(!=0) recvPackets:");
        defpackage.b.p(r20, r13.recvPackets, TAG);
    L57:
        if (r13.rttAve <= this.mObserver.getQosBadErrRttThreshold()) goto L59;
    L68:
        ErrorType r21 = ErrorType.QOS_BAD_ERR;
        r11.put(r21, Boolean.TRUE);
        CaeLog.i(TAG, "warning, netif:" + r12 + " ErrorType:" + r21 + " rttAve:" + r13.rttAve + "(" + this.mObserver.getQosBadErrRttThreshold() + ") recvOooPercent:" + r13.recvOooPercent + "(" + this.mObserver.getQosBadErrRecvRetransThreshold() + ") sendRetrans:" + r13.sendRetrans + "(" + this.mObserver.getQosBadErrSendRetransThreshold() + ") sendPackets:" + r13.sendPackets + " recvPackets:" + r13.recvPackets + " (" + this.mObserver.getQosBadErrTxRxPktNumThreshold() + ")");
    L69:
        checkNetifErrWindow(r11, r13);
        goto L71
    L59:
        if (r13.recvOooPercent <= this.mObserver.getQosBadErrRecvRetransThreshold()) goto L65;
        if (r13.recvPackets <= this.mObserver.getQosBadErrTxRxPktNumThreshold()) goto L65;
        if (r13.recvRate < this.mObserver.getIgnoreDownloadErrThroughputThreshold()) goto L68;
    L65:
        if (r13.sendRetrans <= this.mObserver.getQosBadErrSendRetransThreshold()) goto L69;
        if (r13.sendPackets <= this.mObserver.getQosBadErrTxRxPktNumThreshold()) goto L69;
    L25:
        if (r13.recvOooPercent < this.mObserver.getRetransErrRxLowRetransThreshold()) goto L31;
        if (r13.recvPackets <= this.mObserver.getRetransErrHighPktNumThreshold()) goto L31;
        if (r13.recvRate < this.mObserver.getIgnoreDownloadErrThroughputThreshold()) goto L44;
    L31:
        if (r13.sendRetrans <= this.mObserver.getRetransErrHighRetransThreshold()) goto L37;
        if (r13.sendPackets <= this.mObserver.getRetransErrLowPktNumThreshold()) goto L37;
        if (r13.sendPackets < this.mObserver.getRetransErrHighPktNumThreshold()) goto L44;
    L37:
        if (r13.recvOooPercent <= this.mObserver.getRetransErrRxHighRetransThreshold()) goto L46;
        if (r13.recvPackets <= this.mObserver.getRetransErrLowPktNumThreshold()) goto L46;
        if (r13.recvPackets >= this.mObserver.getRetransErrHighPktNumThreshold()) goto L46;
        if (r13.recvRate >= this.mObserver.getIgnoreDownloadErrThroughputThreshold()) goto L46;
    }

    private void checkNetifErrWindow(HashMap<ErrorType, Boolean> r8, L4NetStats r10) {
        NetifErrWindow r11 = this.mNetifErrWinMap.get(r10.ifName);
        if (r11 != null) goto L6;
        CaeLog.e(TAG, "ifName " + r10.ifName + " is not in mNetifErrWinMap");
        return;
    L6:
        boolean r12 = true;
        if (r8.get(ErrorType.UP_RETRANS_ERR) == null) goto L9;
        boolean r13 = true;
    L10:
        windowUpdateAndCheck(r13, NetifErrWindow.access$1500(r11), r10);
        if (r8.get(ErrorType.RETRANS_ERR) == null) goto L13;
        boolean r14 = true;
    L14:
        windowUpdateAndCheck(r14, NetifErrWindow.access$1600(r11), r10);
        if (r8.get(ErrorType.NO_DOWNLOAD_ERR) == null) goto L17;
        boolean r15 = true;
    L18:
        windowUpdateAndCheck(r15, NetifErrWindow.access$1700(r11), r10);
        if (r8.get(ErrorType.QOS_BAD_ERR) != null) goto L22;
        r12 = false;
    L22:
        windowUpdateAndCheck(r12, NetifErrWindow.access$1800(r11), r10);
        return;
    L17:
        r15 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    }

    private void checkUidErr() {
        int r8 = getAndCheckForegroundApp();
        if (r8 != (-1)) goto L5;
    L11:
        pushUidErrWindowAndCheck(null, false);
        return;
    L5:
        if (this.mForegroundApp.strategy == ForegroundAppStrategy.NONE) goto L11;
        L4NetStats r10 = this.mUidStats.get(Integer.valueOf(r8));
        if (r10 == null) goto L13;
        pushUidErrWindowAndCheck(r10, true);
        return;
    }

    private QoeStatus convertToQoeStatus(L4NetStats r8) {
        QoeStatus r10 = new QoeStatus();
        r10.statSrcType = r8.statSrcType.ordinal();
        r10.uid = r8.uid;
        r10.appPackageName = r8.appPackageName;
        r10.ifName = r8.ifName;
        r10.streamNum = r8.streamNum;
        r10.rttAve = r8.rttAve;
        r10.totalSendPackets = r8.totalSendPackets;
        r10.totalRecvPackets = r8.totalRecvPackets;
        r10.totalSegsOut = r8.totalSegsOut;
        r10.totalSegsIn = r8.totalSegsIn;
        r10.totalSendBytes = r8.totalSendBytes;
        r10.totalRecvBytes = r8.totalRecvBytes;
        r10.sendPackets = r8.sendPackets;
        r10.recvPackets = r8.recvPackets;
        r10.sendRate = r8.sendRate;
        r10.recvRate = r8.recvRate;
        r10.sendRetrans = r8.sendRetrans;
        r10.recvOooPercent = r8.recvOooPercent;
        r10.unacked = r8.unacked;
        r10.tcpSndSsthresh = r8.tcpSndSsthresh;
        r10.tcpSndCwnd = r8.tcpSndCwnd;
        r10.errBitMap = r8.errBitMap;
        return r10;
    }

    public static /* synthetic */ void d(UidNetifRateStats r8) {
        lambda$removeNoTcpUidNetifRateStats$1(r8);
    }

    private void diffSum(L4NetStats r8, L4NetTcpInfo r10) {
        int r11 = r10.tcpRtt;
        if (r11 != 0) goto L5;
    L7:
        r8.totalSendPackets += (long) r10.tcpTotalDataSegsOut;
        r8.totalRecvPackets += (long) r10.tcpTotalDataSegsIn;
        r8.totalSegsOut += (long) r10.tcpTotalSegsOut;
        r8.totalSegsIn += (long) r10.tcpTotalSegsIn;
        r8.totalSendBytes += r10.tcpSendBytes;
        r8.totalRecvBytes += r10.tcpRecvBytes;
        r8.sendRetrans += r10.tcpTotalRetrans;
        r8.recvOooPercent += r10.tcpRecvOoopack;
        r8.unacked += r10.tcpiUnacked;
        r8.tcpSndSsthresh = r10.tcpSndSsthresh;
        r8.tcpSndCwnd = r10.tcpSndCwnd;
        return;
    L5:
        if (r10.tcpTotalDataSegsOut == 0) goto L7;
        r8.streamNum++;
        r8.rttAve = (r11 / 1000) + r8.rttAve;
        goto L7
    }

    private int getAndCheckForegroundApp() {
        CaeUtil.ForegroundProcessInfo r8 = CaeUtil.getForegroundProcessInfo(this.mContext);
        if (r8 == null) goto L5;
        int r10 = r8.uid;
    L7:
        if (r10 != (-1)) goto L10;
        CaeLog.e(TAG, "getForegroundUid failed");
        return -1;
    L10:
        L4NetForegroundApp r11 = this.mForegroundApp;
        if (r10 != r11.uid) goto L14;
        this.mTicketGrabbingManager.tryUpdateTicketGrabbingStrategy(r11);
        return r10;
    L14:
        ApplicationInfo r12 = CaeUtil.getAppInfoByUid(this.mContext, r10);
        if (r12 != null) goto L18;
        CaeLog.e(TAG, "getAppInfoByUid failed");
        return -1;
    L18:
        String r13 = CaeUtil.getAppNameByAppInfo(this.mContext, r12);
        StringBuilder r14 = new StringBuilder("foreground app change, LAST: ");
        r14.append(this.mForegroundApp.uid);
        r14.append(" ");
        r14.append(this.mForegroundApp.appName);
        r14.append(" ");
        r14.append(this.mForegroundApp.appPackageName);
        r14.append("; NOW: ");
        r14.append(r10);
        r14.append(" ");
        r14.append(r13);
        r14.append(" ");
        android.aimedia.a.r(r14, r12.packageName, TAG);
        L4NetForegroundApp r15 = this.mForegroundApp;
        r15.uid = r10;
        r15.pid = r8.pid;
        r15.appName = r13;
        String r16 = r12.packageName;
        r15.appPackageName = r16;
        if (isAppInWhiteList(r16) == false) goto L21;
        ForegroundAppStrategy r17 = ForegroundAppStrategy.NETWORK_HANDOVER;
    L22:
        r15.strategy = r17;
        this.mTicketGrabbingManager.tryUpdateTicketGrabbingStrategy(this.mForegroundApp);
        this.mAppNoDownErrWin.clean();
        if (this.mForegroundApp.strategy != ForegroundAppStrategy.NONE) goto L26;
        CaeLog.d(TAG, "app is not in white list, don't report err");
        return -1;
    L26:
        return r10;
    L21:
        r17 = ForegroundAppStrategy.NONE;
        goto L22
    L5:
        r10 = -1;
        goto L7
    }

    public static synchronized L4NetEvaluate getInstance(Context r8) {
        monitor-enter(L4NetEvaluate.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mNetEvaluate != null) goto L7;
        mNetEvaluate = new L4NetEvaluate(r8);     // Catch: Throwable -> L10
    L7:
        L4NetEvaluate r10 = mNetEvaluate;     // Catch: Throwable -> L10
        monitor-exit(L4NetEvaluate.class);
        return r10;
    }

    private StatSrcType getNetifType(String r8) {
        if (r8.startsWith("wlan") == false) goto L10;
        if (r8.contains("0") == false) goto L8;
        return StatSrcType.WLAN0;
    L8:
        return StatSrcType.WLAN1;
    L10:
        if (r8.startsWith("rmnet") == false) goto L17;
        if (r8.contains("0") == false) goto L15;
        return StatSrcType.RMNET0;
    L15:
        return StatSrcType.RMNET1;
    L17:
        if (r8.startsWith("tun") == false) goto L21;
        return StatSrcType.TUN0;
    L21:
        return StatSrcType.UNKNOWN;
    }

    private String getPackageNameByUid(int r8) {
        ApplicationInfo r10 = CaeUtil.getAppInfoByUid(this.mContext, r8);
        if (r10 != null) goto L7;
        return "NULL";
    L7:
        return r10.packageName;
    }

    private boolean isAppInWhiteList(String r8) {
        if (r8 != null) goto L5;
    L27:
        return false;
    L5:
        if (r8.isEmpty() == true) goto L27;
        if (AppCategoryHelper.getInstance(this.mContext).getAppCategory(r8) != 4) goto L10;
        return true;
    L10:
        String r10 = this.mObserver.getWhiteList();
        if (r10 != null) goto L13;
    L26:
        CaeLog.e(TAG, "whiteListStr is null or empty");
        goto L27
    L13:
        if (r10.isEmpty() == true) goto L26;
        if (r10.equals("[]") == true) goto L26;
        String[] r11 = (String[]) new j().c(String[].class, r10);
        if (r11 == null) goto L25;
        int r12 = r11.length;
        int r13 = 0;
    L20:
        if (r13 >= r12) goto L25;
        if (r8.equals(r11[r13]) == true) goto L23;
        r13 = r13 + 1;
        goto L20
    L23:
        return true;
    L25:
        return false;
    }

    private /* synthetic */ void lambda$removeClosedTcpInfo$2(Long r8, L4NetTcpInfo r10) {
        if (r10.lastUpdateTime >= this.mTrackerTimes) goto L6;
        this.mTcpInfoMap.remove(r8);
        return;
    }

    private /* synthetic */ boolean lambda$removeInactiveUidRttCache$3(int r8, Map.Entry r10) {
        if (((Integer) r10.getKey()).intValue() != r8) goto L5;
    L7:
        return false;
    L5:
        if ((this.mTrackerTimes - ((L4NetStats) r10.getValue()).lastUpdateTime) <= 300) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$removeNoTcpUidNetifRateStats$0(Map.Entry r8) {
        return !((UidNetifRateStats) r8.getValue()).isUpdate;
    }

    private static /* synthetic */ void lambda$removeNoTcpUidNetifRateStats$1(UidNetifRateStats r8) {
        r8.isUpdate = false;
    }

    private void netifDiffUpdate(L4NetTcpInfo r8) {
        L4NetStats r10 = this.mNetifDiff.getOrDefault(r8.ifName, new L4NetStats());
        if (r10 != null) goto L6;
        CaeLog.e(TAG, "diff is null");
        return;
    L6:
        StatSrcType r11 = r10.statSrcType;
        StatSrcType r12 = StatSrcType.UNKNOWN;
        if (r11 != r12) goto L13;
        StatSrcType r13 = getNetifType(r8.ifName);
        r10.statSrcType = r13;
        if (r13 != r12) goto L12;
        CaeLog.e(TAG, "ifName " + r8.ifName + " is unknown");
        return;
    L12:
        r10.ifName = r8.ifName;
    L13:
        diffSum(r10, r8);
        this.mNetifDiff.put(r8.ifName, r10);
    }

    private void netifStatsUpdate() {
        Iterator<Map.Entry<String, L4NetStats>> r8 = this.mNetifDiff.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Map.Entry<String, L4NetStats> r10 = r8.next();
        String r11 = r10.getKey();
        L4NetStats r12 = r10.getValue();
        updateNetifRttCache(r11, r12);
        if (this.mNetifStats.containsKey(r11) == false) goto L7;
        L4NetStats r13 = this.mNetifStats.get(r11);
        if (r13 == null) goto L10;
        applyDiffToStats(r12, r13);
        goto L4
    L10:
        CaeLog.e(TAG, "stats is null");
        goto L4
    L7:
        this.mNetifStats.put(r11, new L4NetStats(r12));
        this.mNetifErrWinMap.put(r11, new NetifErrWindow(this));
        goto L4
    L12:
        this.mNetifDiff.clear();
    }

    private void pushUidErrWindowAndCheck(L4NetStats r8, boolean r10) {
        boolean r11 = false;
        if (r10 == true) goto L9;
        ErrWindowPara.access$1000(this.mAppNoDownErrWin).add(0);
        if (ErrWindowPara.access$1000(this.mAppNoDownErrWin).size() <= ErrWindowPara.access$1200(this.mAppNoDownErrWin)) goto L20;
        ErrWindowPara r12 = this.mAppNoDownErrWin;
        ErrWindowPara.access$1120(r12, ((Integer) ErrWindowPara.access$1000(r12).removeFirst()).intValue());
        return;
    L20:
        return;
    L9:
        if (r8.sendPackets <= this.mObserver.getQosBadErrTxRxPktNumThreshold()) goto L14;
        if (r8.recvPackets != 0) goto L14;
        CaeLog.i(TAG, "warning, UID:" + r8.uid + " ErrorType:" + ErrorType.FOREGROUND_APP_NO_DOWNLOAD_ERR);
    L14:
        if (r8.sendPackets != 0) goto L16;
    L18:
        windowUpdateAndCheck(r11, this.mAppNoDownErrWin, r8);
        return;
    L16:
        if (r8.recvPackets != 0) goto L18;
        r11 = true;
        goto L18
    }

    private void removeClosedTcpInfo() {
        this.mTcpInfoMap.forEach(new d(this));
    }

    private void removeInactiveUidRttCache() {
        final int r8 = this.mForegroundApp.uid;
        this.mUidRttCache.entrySet().removeIf(new c(this, r8));
    }

    private void removeNoTcpUidNetifRateStats() {
        this.mUidNetifRateStats.entrySet().removeIf(new a());
        this.mUidNetifRateStats.values().forEach(new b());
    }

    private void tcpInfoUpdate(L4NetTcpInfo r8) {
        L4NetTcpInfo r10 = this.mTcpInfoMap.getOrDefault(Long.valueOf(r8.cookie), new L4NetTcpInfo());
        if (r10 != null) goto L6;
        CaeLog.e(TAG, "get preInfo failed");
        return;
    L6:
        L4NetTcpInfo r11 = new L4NetTcpInfo();
        r11.ifName = r8.ifName;
        r11.family = r8.family;
        r11.state = r8.state;
        r11.srcIP = r8.srcIP;
        r11.dstIP = r8.dstIP;
        r11.srcPort = r8.srcPort;
        r11.dstPort = r8.dstPort;
        r11.uid = r8.uid;
        r11.tcpSendBytes = checkAndGetDiff(r10.tcpSendBytes, r8.tcpSendBytes);
        r11.tcpRecvBytes = checkAndGetDiff(r10.tcpRecvBytes, r8.tcpRecvBytes);
        r11.tcpRtt = r8.tcpRtt;
        r11.tcpTotalRetrans = (int) checkAndGetDiff(r10.tcpTotalRetrans, r8.tcpTotalRetrans);
        r11.tcpTotalDataSegsOut = (int) checkAndGetDiff(r10.tcpTotalDataSegsOut, r8.tcpTotalDataSegsOut);
        r11.tcpTotalDataSegsIn = (int) checkAndGetDiff(r10.tcpTotalDataSegsIn, r8.tcpTotalDataSegsIn);
        r11.tcpiUnacked = r8.tcpiUnacked;
        r11.tcpRecvOoopack = (int) checkAndGetDiff(r10.tcpRecvOoopack, r8.tcpRecvOoopack);
        r11.tcpTotalSegsOut = (int) checkAndGetDiff(r10.tcpTotalSegsOut, r8.tcpTotalSegsOut);
        r11.tcpTotalSegsIn = (int) checkAndGetDiff(r10.tcpTotalSegsIn, r8.tcpTotalSegsIn);
        r11.tcpSndSsthresh = r8.tcpSndSsthresh;
        r11.tcpSndCwnd = r8.tcpSndCwnd;
        r8.lastUpdateTime = this.mTrackerTimes;
        this.mTcpInfoMap.put(Long.valueOf(r8.cookie), new L4NetTcpInfo(r8));
        netifDiffUpdate(r11);
        uidDiffUpdate(r11);
        ConcurrentHashMap<Long, L4NetTcpInfo> r12 = this.mUidSocketMap.getOrDefault(Integer.valueOf(r8.uid), new ConcurrentHashMap());
        if (r12 != null) goto L10;
        CaeLog.e(TAG, "get uidSocketMap failed");
        return;
    L10:
        r12.put(Long.valueOf(r8.cookie), r11);
        this.mUidSocketMap.put(Integer.valueOf(r8.uid), r12);
    }

    private void uidDiffUpdate(L4NetTcpInfo r8) {
        L4NetStats r10 = this.mUidDiff.getOrDefault(Integer.valueOf(r8.uid), new L4NetStats());
        if (r10 != null) goto L7;
        CaeLog.e(TAG, "uidDiff is null");
        return;
    L7:
        if (r10.statSrcType != StatSrcType.UNKNOWN) goto L9;
        r10.statSrcType = StatSrcType.UID;
        int r11 = r8.uid;
        r10.uid = r11;
        r10.appPackageName = getPackageNameByUid(r11);
    L9:
        diffSum(r10, r8);
        this.mUidDiff.put(Integer.valueOf(r10.uid), r10);
        uidNetifRateUpdate(r8);
    }

    private void uidNetifQosStats(UidQosStats r8, L4NetTcpInfo r10) {
        r8.sendRate += (int) ((r10.tcpSendBytes * 1000) / ((long) this.mNetTracker.getInterval()));
        r8.recvRate += (int) ((r10.tcpRecvBytes * 1000) / ((long) this.mNetTracker.getInterval()));
        int r11 = r10.tcpRtt;
        if (r11 != 0) goto L5;
    L7:
        int r12 = r8.streamNum;
        int r13 = 0;
        if (r12 != 0) goto L10;
        int r14 = 0;
    L11:
        r8.rttAve = r14;
        int r15 = r8.sendPackets + r10.tcpTotalSegsOut;
        r8.sendPackets = r15;
        int r16 = r8.recvPackets + r10.tcpTotalSegsIn;
        r8.recvPackets = r16;
        int r17 = r8.retransPackets + r10.tcpTotalRetrans;
        r8.retransPackets = r17;
        int r18 = r8.recvOooPackets + r10.tcpRecvOoopack;
        r8.recvOooPackets = r18;
        r8.unacked += r10.tcpiUnacked;
        if (r15 != 0) goto L14;
        int r19 = 0;
    L15:
        r8.sendRetrans = r19;
        if (r16 == 0) goto L19;
        r13 = (r18 * 100) / r16;
    L19:
        r8.recvOooPercent = r13;
        return;
    L14:
        r19 = (r17 * 100) / r15;
        goto L15
    L10:
        r14 = r8.rttSum / r12;
        goto L11
    L5:
        if (r10.tcpTotalDataSegsOut == 0) goto L7;
        r8.streamNum++;
        r8.rttSum = (r11 / 1000) + r8.rttSum;
        goto L7
    }

    private void uidNetifRateUpdate(L4NetTcpInfo r8) {
        UidNetifRateStats r10 = this.mUidNetifRateStats.getOrDefault(Integer.valueOf(r8.uid), new UidNetifRateStats());
        if (r10 != null) goto L7;
        CaeLog.e(TAG, "uidNetifRateStats is null");
        return;
    L7:
        if (r10.isUpdate == true) goto L9;
        r10.clean();
    L9:
        r10.isUpdate = true;
        uidNetifQosStats(r10.totalQosStats, r8);
        if (getNetifType(r8.ifName) != StatSrcType.WLAN0) goto L14;
        UidQosStats r11 = r10.wlan0QosStats;
    L12:
        uidNetifQosStats(r11, r8);
    L22:
        this.mUidNetifRateStats.put(Integer.valueOf(r8.uid), r10);
        return;
    L14:
        if (getNetifType(r8.ifName) != StatSrcType.WLAN1) goto L17;
        r11 = r10.wlan1QosStats;
        goto L12
    L17:
        if (getNetifType(r8.ifName) != StatSrcType.RMNET0) goto L20;
        r11 = r10.rmnet0QosStats;
        goto L12
    L20:
        if (getNetifType(r8.ifName) != StatSrcType.RMNET1) goto L22;
        r11 = r10.rmnet1QosStats;
        goto L12
    }

    private void uidStatsUpdate() {
        Iterator<Map.Entry<Integer, L4NetStats>> r8 = this.mUidDiff.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Map.Entry<Integer, L4NetStats> r10 = r8.next();
        Integer r11 = r10.getKey();
        L4NetStats r12 = r10.getValue();
        updateUidRttCache(r11.intValue(), r12);
        if (this.mUidStats.containsKey(r11) == false) goto L7;
        L4NetStats r13 = this.mUidStats.get(r11);
        if (r13 == null) goto L10;
        applyDiffToStats(r12, r13);
        goto L4
    L10:
        CaeLog.e(TAG, "stats is null");
        goto L4
    L7:
        this.mUidStats.put(r11, new L4NetStats(r12));
        goto L4
    L12:
        this.mUidDiff.clear();
    }

    private void updateNetifRttCache(String r8, L4NetStats r10) {
        int r11 = r10.streamNum;
        if (r11 != 0) goto L5;
        int r12 = 0;
    L6:
        if (r12 > 0) goto L8;
        return;
    L8:
        L4NetStats r13 = this.mNetifRttCache.get(r8);
        if (r13 != null) goto L11;
        r13 = new L4NetStats();
    L12:
        r13.rttAve = r12;
        r13.lastUpdateTime = this.mTrackerTimes;
        this.mNetifRttCache.put(r8, r13);
        return;
    L11:
        int r14 = r12 / 8;
        r12 = r14 + ((r13.rttAve * 7) / 8);
        goto L12
    L5:
        r12 = r10.rttAve / r11;
        goto L6
    }

    private void updateUidRttCache(int r8, L4NetStats r10) {
        int r11 = r10.streamNum;
        if (r11 != 0) goto L5;
        int r12 = 0;
    L6:
        if (r12 > 0) goto L8;
        return;
    L8:
        L4NetStats r13 = this.mUidRttCache.get(Integer.valueOf(r8));
        if (r13 != null) goto L11;
        r13 = new L4NetStats();
    L12:
        r13.rttAve = r12;
        r13.lastUpdateTime = this.mTrackerTimes;
        this.mUidRttCache.put(Integer.valueOf(r8), r13);
        return;
    L11:
        int r14 = r12 / 8;
        r12 = r14 + ((r13.rttAve * 7) / 8);
        goto L12
    L5:
        r12 = r10.rttAve / r11;
        goto L6
    }

    public static void windowUpdateAndCheck(boolean r8, ErrWindowPara r10, L4NetStats r11) {
        if (r8 == false) goto L4;
        ErrWindowPara.access$1000(r10).add(1);
        ErrWindowPara.access$1108(r10);
    L6:
        if (ErrWindowPara.access$1000(r10).size() <= ErrWindowPara.access$1200(r10)) goto L9;
        ErrWindowPara.access$1120(r10, ((Integer) ErrWindowPara.access$1000(r10).removeFirst()).intValue());
    L9:
        if (ErrWindowPara.access$1100(r10) < ErrWindowPara.access$1300(r10)) goto L12;
        r11.errBitMap |= ErrWindowPara.access$1400(r10).getValue();
        CaeLog.e(TAG, "report err netif:" + r11.ifName + " UID:" + r11.uid + " ErrorType:" + ErrWindowPara.access$1400(r10) + " winSum:" + ErrWindowPara.access$1100(r10));
        return;
    L12:
        return;
    L4:
        ErrWindowPara.access$1000(r10).add(0);
        goto L6
    }

    public ConcurrentHashMap<String, L4NetStats> getNetifRttCache() {
        return this.mNetifRttCache;
    }

    public UidNetifRateStats getUidNetifRateStats(int r8) {
        if (this.mUidNetifRateStats.containsKey(Integer.valueOf(r8)) == true) goto L7;
        return null;
    L7:
        return this.mUidNetifRateStats.get(Integer.valueOf(r8));
    }

    public L4NetStats getUidRttCache(int r8) {
        return this.mUidRttCache.get(Integer.valueOf(r8));
    }

    public void notifyQoeStatusChanged(final QoeStatus r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "notifyQoeStatusChanged: newStatus is null");
        return;
    L5:
        this.mQoeCallbackHandler.post(new AnonymousClass3(this, r8));
    }

    public synchronized boolean registerErrReportCb(L4NetErrReportCb r8) {
        monitor-enter(this);
        if (r8 != null) goto L8;
        CaeLog.e(TAG, "Invalid callback");     // Catch: Throwable -> L23
        monitor-exit(this);
        return false;
    L8:
        Object r10 = this.mErrReportCbListLock;     // Catch: Throwable -> L23
        monitor-enter(r10);     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L11:
        if (this.mErrReportCbList.contains(r8) == false) goto L16;
        CaeLog.e(TAG, "L4NetErrReportCb callback already exist");     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        monitor-exit(this);
        return false;
    L16:
        boolean r11 = this.mErrReportCbList.add(r8);     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r11;
    L23:
        th = move-exception;
        throw th;
    }

    public boolean registerL4NetTcpInfoListener(L4NetTcpInfoListenerCallback r8) {
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "registerL4NetTcpInfoListener: listener is null");
        return false;
    L6:
        boolean r10 = this.mL4NetTcpInfoListenerSet.add(r8);
        if (r10 == true) goto L9;
        CaeLog.w(TAG, "registerL4NetTcpInfoListener: listener already registered");
    L9:
        return r10;
    }

    public boolean registerQoeStatusListener(IQoeStatusListener r8) {
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "registerQoeStatusListener: listener is null");
        return false;
    L6:
        boolean r10 = this.mQoeListeners.register(r8);
        if (r10 == false) goto L9;
        CaeLog.d(TAG, "registerQoeStatusListener: listener registered successfully");
    L10:
        return r10;
    L9:
        CaeLog.w(TAG, "registerQoeStatusListener: listener already registered");
        goto L10
    }

    public boolean registerSpecificAppEvaluateCb(L4NetErrReportCb r8) {
        return this.mSpecificAppEvaluate.registerErrReportCb(r8);
    }

    public synchronized boolean setInterval(int r8) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsStarted == false) goto L9;
        CaeLog.e(TAG, "L4NetEvaluate is Running");     // Catch: Throwable -> L12
        monitor-exit(this);
        return false;
    L9:
        boolean r10 = this.mNetTracker.setInterval(r8);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r10;
    }

    public void setNetworkQoEMonitor(NetworkQoEMonitor r8) {
        RateControlManager r10 = this.mRateControlManager;
        if (r10 == null) goto L6;
        r10.setNetworkQoEMonitor(r8);
        return;
    }

    public void setSpecificApp(int r8) {
        this.mSpecificAppEvaluate.setSpecificApp(r8);
    }

    public synchronized boolean start() {
        monitor-enter(this);
        CaeLog.i(TAG, "call start tracker");     // Catch: Throwable -> L30
        if (CaeUtil.isL4NetworkEvaluateSupported(this.mContext) == true) goto L9;
        CaeLog.e(TAG, "ignore start, L4NetEvaluate is not supported");     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L9:
        CaeLog.i(TAG, "start, L4NetEvaluate is supported");     // Catch: Throwable -> L30
        AIMediaEventsConsumer.subscribe();     // Catch: Throwable -> L30
        Object r8 = this.mStartStopLock;     // Catch: Throwable -> L30
        monitor-enter(r8);     // Catch: Throwable -> L30
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L12:
        if (this.mIsStarted == false) goto L18;
        this.mRefCnt++;     // Catch: Throwable -> L27
        CaeLog.i(TAG, "L4NetEvaluate is Running, mRefCnt:" + this.mRefCnt);     // Catch: Throwable -> L27
        monitor-exit(r8);     // Catch: Throwable -> L27
        monitor-exit(this);
        return true;
    L18:
        if (this.mNetTracker.setNetInfoReportCallback(new AnonymousClass1(this)) == true) goto L23;
        CaeLog.e(TAG, "setNetInfoReportCallback failed");     // Catch: Throwable -> L27
        monitor-exit(r8);     // Catch: Throwable -> L27
        monitor-exit(this);
        return false;
    L23:
        this.mIsStarted = true;     // Catch: Throwable -> L27
        this.mRefCnt++;     // Catch: Throwable -> L27
        this.mAppNoDownErrWin = new ErrWindowPara(ErrorType.FOREGROUND_APP_NO_DOWNLOAD_ERR, new LinkedList(), 0, this.mObserver.getForegroundAppNoDownloadErrTimePeriod(), this.mObserver.getForegroundAppNoDownloadErrTimesThreshold());     // Catch: Throwable -> L27
        CaeLog.i(TAG, "L4NetEvaluate start");     // Catch: Throwable -> L27
        boolean r10 = this.mNetTracker.start();     // Catch: Throwable -> L27
        monitor-exit(r8);     // Catch: Throwable -> L27
        monitor-exit(this);
        return r10;
    L30:
        th = move-exception;
        throw th;
    }

    public void stop() {
        CaeLog.i(TAG, "call stop tracker");
        if (CaeUtil.isL4NetworkEvaluateSupported(this.mContext) == true) goto L6;
        CaeLog.e(TAG, "ignore stop, L4NetEvaluate is not supported");
        return;
    L6:
        CaeLog.i(TAG, "stop, L4NetEvaluate is supported");
        Object r8 = this.mStartStopLock;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L9:
        if (this.mIsStarted == true) goto L13;
        CaeLog.e(TAG, "L4NetEvaluate is not Running");     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L13:
        int r10 = this.mRefCnt - 1;     // Catch: Throwable -> L22
        this.mRefCnt = r10;     // Catch: Throwable -> L22
        if (r10 <= 0) goto L18;
        CaeLog.i(TAG, "L4NetEvuate mRefCnt is " + this.mRefCnt + ", not stop");     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L18:
        this.mNetTracker.stop();     // Catch: Throwable -> L22
        this.mTcpInfoMap.clear();     // Catch: Throwable -> L22
        this.mAppNoDownErrWin.clean();     // Catch: Throwable -> L22
        this.mIsStarted = false;     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        CaeLog.i(TAG, "L4NetEvaluate stopped");
    }

    public boolean unregisterErrReportCb(L4NetErrReportCb r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "L4NetErrReportCb callback is null");
        return false;
    L5:
        Object r10 = this.mErrReportCbListLock;
        monitor-enter(r10);
        boolean r11 = this.mErrReportCbList.remove(r8);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean unregisterL4NetTcpInfoListener(L4NetTcpInfoListenerCallback r8) {
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "unregisterL4NetTcpInfoListener: listener is null");
        return false;
    L6:
        boolean r10 = this.mL4NetTcpInfoListenerSet.remove(r8);
        if (r10 == true) goto L9;
        CaeLog.w(TAG, "unregisterL4NetTcpInfoListener: listener not found");
    L9:
        return r10;
    }

    public boolean unregisterQoeStatusListener(IQoeStatusListener r8) {
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "unregisterQoeStatusListener: listener is null");
        return false;
    L6:
        boolean r10 = this.mQoeListeners.unregister(r8);
        if (r10 == false) goto L9;
        CaeLog.d(TAG, "unregisterQoeStatusListener: listener unregistered successfully");
    L10:
        return r10;
    L9:
        CaeLog.w(TAG, "unregisterQoeStatusListener: listener not found");
        goto L10
    }

    public boolean unregisterSpecificAppEvaluateCb(L4NetErrReportCb r8) {
        return this.mSpecificAppEvaluate.unregisterErrReportCb(r8);
    }
}
