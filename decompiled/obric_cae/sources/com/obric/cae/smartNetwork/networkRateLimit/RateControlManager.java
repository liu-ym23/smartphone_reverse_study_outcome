package com.obric.cae.smartNetwork.networkRateLimit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTcpInfo;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTracker;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipAppManager;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipStrategyReport;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.utils.CaeUtil;
import defpackage.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes2.dex */
public class RateControlManager {
    private static final int APP_RATE_LIMIT_INFO_LOG_PRINT_PERIOD = 10;
    private static final int BACKGROUND_ORDER_APP_NUM = 3;
    private static final int BACKGROUND_RATE_THRESHOLD_FOR_RATE_MANAGE = 262144;
    public static final int BACKGROUND_RATE_THRESHOLD_FOR_VIP_APP = 262144;
    private static final String CELL_IFNAME_MARK = "rmnet_data";
    private static final int DEFAULT_BANDWIDTH_ESTIMATED_VAL = 2048000;
    private static final int DEINIT_NET_TC_THRESHOLD = 60;
    private static final int FOREGROUND_RTT_THRESHOLD = 150;
    private static final int MAX_BANDWIDTH_ESTIMATED_VAL_PROPORTION = 3;
    private static final int MAX_SOCKET_COUNT_PER_UID = 10;
    private static final int MIN_BANDWIDTH_ESTIMATED_VAL = 10240;
    private static final int MIN_RATE_TO_MANAGE_THRESHOLD_IN_BYTE = 25600;
    private static final int RATE_LIMIT_TRIGGER_CNT_THRESHOLD = 3;
    public static final int RATE_UPDATE_THRESHOLD = 5000;
    private static final String TAG = "RateControlManager";
    private static final float TEMPERATURE_LEVEL_1 = 43.0f;
    private static final float TEMPERATURE_LEVEL_2 = 46.0f;
    private static final int THROUGHPUT_WEIGHTED_AVERAGE_PROPORTION = 8;
    private static final int VIP_APP_CNT_THRESHOLD = 3;
    private static final String WIFI0_IF_NAME = "wlan0";
    private static final String WIFI1_IF_NAME = "wlan1";
    private static final String WLAN_IFNAME_MARK = "wlan";
    private static volatile RateControlManager mRateControlManager;
    private boolean isMaxBandWidthReady;
    private boolean isTragetNetifWlan;
    private final AppRateLimitManager mAppRateLimitManager;
    private int mBackgroundOthersRateLimit;
    private int mBackgroundOthersRateNow;
    private int mBackgroundRateOverCnt;
    private int mCleanNetTCCnt;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private int mForegroundRttOverCnt;
    private final GetSkinTemperature mGetSkinTemperature;
    private boolean mIsForegroundRttOverThreshold;
    private StrategyType mLastStrategyType;
    private int mLogPeriodCnt;
    private int mMaxBandWidthEstimatedVal;
    private final TrafficControlConfig mNetTCConfig;
    private final NetworkRateLimitReport mNetworkRateLimitReport;
    private final ConcurrentHashMap<Integer, UidRateControlInfo> mRateCtrlMap;
    private final RateStrategyManager mRateStrategyManager;
    private final NetworkRateLimitReport.ReportCommonData mReportCommonData;
    private final SpecificAppManager mSpecificAppManager;
    private TCState mTCState;
    private String mTargetNetif;
    private int mTemperatureLevel1Cnt;
    private int mTemperatureLevel2Cnt;
    private int mThroughputTempVal;
    private int mThroughputUpdateCnt;
    private int mVipAppCnt;
    private final VipAppManager mVipAppManager;
    private final VipStrategyReport mVipStrategyReport;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkRateLimit.RateControlManager$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType = null;

        static {
            int[] r8 = new int[AppCtrlType.values().length];
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType = r8;
            r8[AppCtrlType.FOREGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[AppCtrlType.BACKGROUND_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[AppCtrlType.BACKGROUND_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[AppCtrlType.BACKGROUND_3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum AppCtrlType extends Enum<AppCtrlType> {
        private static final /* synthetic */ AppCtrlType[] $VALUES = null;
        public static final AppCtrlType BACKGROUND_1 = null;
        public static final AppCtrlType BACKGROUND_2 = null;
        public static final AppCtrlType BACKGROUND_3 = null;
        public static final AppCtrlType BACKGROUND_OTHERS = null;
        public static final AppCtrlType FOREGROUND = null;

        private static /* synthetic */ AppCtrlType[] $values() {
            return new AppCtrlType[]{FOREGROUND, BACKGROUND_1, BACKGROUND_2, BACKGROUND_3, BACKGROUND_OTHERS};
        }

        static {
            FOREGROUND = new AppCtrlType("FOREGROUND", 0);
            BACKGROUND_1 = new AppCtrlType("BACKGROUND_1", 1);
            BACKGROUND_2 = new AppCtrlType("BACKGROUND_2", 2);
            BACKGROUND_3 = new AppCtrlType("BACKGROUND_3", 3);
            BACKGROUND_OTHERS = new AppCtrlType("BACKGROUND_OTHERS", 4);
            $VALUES = $values();
        }

        private AppCtrlType(String r8, int r10) {
            super(r8, r10);
        }

        public static AppCtrlType valueOf(String r8) {
            return (AppCtrlType) Enum.valueOf(AppCtrlType.class, r8);
        }

        public static AppCtrlType[] values() {
            return (AppCtrlType[]) $VALUES.clone();
        }
    }

    public static final enum StrategyType extends Enum<StrategyType> {
        private static final /* synthetic */ StrategyType[] $VALUES = null;
        public static final StrategyType NONE_STRATEGY = null;
        public static final StrategyType NORMAL_TEMPERATURE_STRATEGY = null;
        public static final StrategyType SPECIFIC_APP_STRATEGY = null;
        public static final StrategyType TEMPERATURE_LEVEL1_STRATEGY = null;
        public static final StrategyType TEMPERATURE_LEVEL2_STRATEGY = null;
        public static final StrategyType VIP_APP_STRATEGY = null;

        private static /* synthetic */ StrategyType[] $values() {
            return new StrategyType[]{NORMAL_TEMPERATURE_STRATEGY, TEMPERATURE_LEVEL1_STRATEGY, TEMPERATURE_LEVEL2_STRATEGY, SPECIFIC_APP_STRATEGY, VIP_APP_STRATEGY, NONE_STRATEGY};
        }

        static {
            NORMAL_TEMPERATURE_STRATEGY = new StrategyType("NORMAL_TEMPERATURE_STRATEGY", 0);
            TEMPERATURE_LEVEL1_STRATEGY = new StrategyType("TEMPERATURE_LEVEL1_STRATEGY", 1);
            TEMPERATURE_LEVEL2_STRATEGY = new StrategyType("TEMPERATURE_LEVEL2_STRATEGY", 2);
            SPECIFIC_APP_STRATEGY = new StrategyType("SPECIFIC_APP_STRATEGY", 3);
            VIP_APP_STRATEGY = new StrategyType("VIP_APP_STRATEGY", 4);
            NONE_STRATEGY = new StrategyType("NONE_STRATEGY", 5);
            $VALUES = $values();
        }

        private StrategyType(String r8, int r10) {
            super(r8, r10);
        }

        public static StrategyType valueOf(String r8) {
            return (StrategyType) Enum.valueOf(StrategyType.class, r8);
        }

        public static StrategyType[] values() {
            return (StrategyType[]) $VALUES.clone();
        }
    }

    public static final enum TCState extends Enum<TCState> {
        private static final /* synthetic */ TCState[] $VALUES = null;
        public static final TCState DEINIT = null;
        public static final TCState IN_NORMAL_TEMPERATURE_STRATEGY = null;
        public static final TCState IN_TEMPERATURE_LEVEL1_STRATEGY = null;
        public static final TCState IN_TEMPERATURE_LEVEL2_STRATEGY = null;
        public static final TCState IN_VIP_APP_STRATEGY = null;
        public static final TCState NONE = null;

        private static /* synthetic */ TCState[] $values() {
            return new TCState[]{DEINIT, NONE, IN_VIP_APP_STRATEGY, IN_NORMAL_TEMPERATURE_STRATEGY, IN_TEMPERATURE_LEVEL1_STRATEGY, IN_TEMPERATURE_LEVEL2_STRATEGY};
        }

        static {
            DEINIT = new TCState("DEINIT", 0);
            NONE = new TCState(BdimCategoryConstants.VALUE_NONE, 1);
            IN_VIP_APP_STRATEGY = new TCState("IN_VIP_APP_STRATEGY", 2);
            IN_NORMAL_TEMPERATURE_STRATEGY = new TCState("IN_NORMAL_TEMPERATURE_STRATEGY", 3);
            IN_TEMPERATURE_LEVEL1_STRATEGY = new TCState("IN_TEMPERATURE_LEVEL1_STRATEGY", 4);
            IN_TEMPERATURE_LEVEL2_STRATEGY = new TCState("IN_TEMPERATURE_LEVEL2_STRATEGY", 5);
            $VALUES = $values();
        }

        private TCState(String r8, int r10) {
            super(r8, r10);
        }

        public static TCState valueOf(String r8) {
            return (TCState) Enum.valueOf(TCState.class, r8);
        }

        public static TCState[] values() {
            return (TCState[]) $VALUES.clone();
        }
    }

    public static class UidRateControlInfo {
        int RecvBytesInOneLogPeriod;
        int SendBytesInOneLogPeriod;
        public AppCtrlType appCtrlType;
        public String appPackageName;
        String ifName;
        boolean isSpecificApp;
        boolean isUpdate;
        public boolean isVipApp;
        public int rate;
        int rateLimit;
        List<TrafficControlConfig.UidSocketInfo> socketList;
        public int uid;

        public UidRateControlInfo() {
            this.appCtrlType = AppCtrlType.BACKGROUND_OTHERS;
            this.isVipApp = false;
            this.isSpecificApp = false;
            this.rateLimit = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            this.isUpdate = false;
        }

        public int getRate() {
            return this.rate;
        }
    }

    private RateControlManager(Context r8) {
        this.mTargetNetif = null;
        this.isTragetNetifWlan = true;
        this.mVipAppCnt = 0;
        this.mBackgroundRateOverCnt = 0;
        this.mTemperatureLevel1Cnt = 0;
        this.mTemperatureLevel2Cnt = 0;
        this.mCleanNetTCCnt = 0;
        this.mForegroundRttOverCnt = 0;
        this.mMaxBandWidthEstimatedVal = DEFAULT_BANDWIDTH_ESTIMATED_VAL;
        this.mBackgroundOthersRateLimit = 0;
        this.mIsForegroundRttOverThreshold = false;
        this.mBackgroundOthersRateNow = 0;
        this.mLastStrategyType = StrategyType.NONE_STRATEGY;
        this.mLogPeriodCnt = 0;
        this.mRateCtrlMap = new ConcurrentHashMap();
        this.mTCState = TCState.DEINIT;
        this.mThroughputUpdateCnt = 0;
        this.mThroughputTempVal = 0;
        this.isMaxBandWidthReady = false;
        this.mContext = r8.getApplicationContext();
        GetSkinTemperature r10 = new GetSkinTemperature();
        this.mGetSkinTemperature = r10;
        r10.init();
        TrafficControlConfig r11 = TrafficControlConfig.getInstance(r8);
        this.mNetTCConfig = r11;
        AppRateLimitManager r12 = new AppRateLimitManager(r11);
        this.mAppRateLimitManager = r12;
        this.mSpecificAppManager = new SpecificAppManager(r8, this, r12);
        this.mRateStrategyManager = new RateStrategyManager(r8, r11, r12);
        this.mNetworkRateLimitReport = new NetworkRateLimitReport();
        this.mReportCommonData = new NetworkRateLimitReport.ReportCommonData();
        this.mVipAppManager = VipAppManager.getInstance(r8);
        this.mVipStrategyReport = VipStrategyReport.getInstance();
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        setScreenOffPeriodicCb(r8);
    }

    private int BackgroundOtherAndNotVipAppsRate(int r8, int r10) {
        Iterator<UidRateControlInfo> r11 = this.mRateCtrlMap.values().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        UidRateControlInfo r13 = r11.next();
        if (this.mVipAppManager.isVipUid(r13.uid) == false) goto L4;
        r12 = r12 + r13.rate;
        goto L4
    L9:
        return Math.max((r8 - r10) - r12, 0);
    }

    private void RateManager(L4NetEvaluate.ForegroundAppStrategy r8, int r10, int r11) {
        float r12 = this.mGetSkinTemperature.getSkinTemperature();
        this.mReportCommonData.temperature = r12;
        if (this.isTragetNetifWlan == true) goto L5;
    L8:
        StrategyType r13 = this.mSpecificAppManager.specificAppStrategy(this.mRateCtrlMap);
        if (r12 >= TEMPERATURE_LEVEL_1) goto L28;
        this.mTemperatureLevel1Cnt = 0;
        this.mTemperatureLevel2Cnt = 0;
        if (this.mVipAppManager.isOAutoRunningAndVipFeatureEnable() == false) goto L17;
        if (r11 <= 262144) goto L17;
        r13 = vipAppStrategy();
        if (r13 != StrategyType.VIP_APP_STRATEGY) goto L36;
        this.mVipStrategyReport.setVipChannelEnabled(true);
    L36:
        if (r13 == StrategyType.NONE_STRATEGY) goto L41;
        this.mRateStrategyManager.updateStrategyLimit(r13, this.mRateCtrlMap, new RateStrategyManager.StrategyContext(this.mMaxBandWidthEstimatedVal, this.mBackgroundOthersRateNow, this.mIsForegroundRttOverThreshold, this.isTragetNetifWlan));
        this.mBackgroundOthersRateLimit = this.mRateStrategyManager.getBackgroundOthersRateLimit();
        this.mAppRateLimitManager.config(this.mRateCtrlMap);
        if (r13 == this.mLastStrategyType) goto L40;
        this.mNetworkRateLimitReport.reportRateLimitEvent(r13.ordinal(), this.mReportCommonData);
        CaeLog.i(TAG, "strategyType from " + this.mLastStrategyType + " to " + r13);
        this.mLastStrategyType = r13;
    L40:
        feedWatchDog();
    L41:
        this.mVipStrategyReport.reportRateLimitDataToVipStrategy(r13.ordinal(), this.mRateCtrlMap, this.mRateStrategyManager, this.mVipAppManager);
        return;
    L17:
        if (r8 != L4NetEvaluate.ForegroundAppStrategy.TICKET_GRABBING) goto L22;
        if (this.mBackgroundOthersRateNow <= 262144) goto L22;
        r13 = vipAppStrategy();
    L22:
        if (r8 == L4NetEvaluate.ForegroundAppStrategy.NETWORK_HANDOVER) goto L24;
    L26:
        this.mVipAppCnt = 0;
        this.mBackgroundRateOverCnt = 0;
        goto L36
    L24:
        if (this.mBackgroundOthersRateNow <= 262144) goto L26;
        r13 = normalTempStrategy(r10);
        goto L36
    L28:
        if (r12 < TEMPERATURE_LEVEL_1) goto L33;
        if (r12 >= TEMPERATURE_LEVEL_2) goto L33;
        this.mVipAppCnt = 0;
        this.mBackgroundRateOverCnt = 0;
        this.mTemperatureLevel2Cnt = 0;
        r13 = temperatureLevel1Strategy();
    L33:
        if (r12 < TEMPERATURE_LEVEL_2) goto L36;
        this.mVipAppCnt = 0;
        this.mBackgroundRateOverCnt = 0;
        this.mTemperatureLevel1Cnt = 0;
        r13 = temperatureLevel2Strategy();
        goto L36
    L5:
        if (this.isMaxBandWidthReady == true) goto L8;
        defpackage.a.j(new StringBuilder("mMaxBandWidthEstimatedVal not ready, mThroughputUpdateCnt is "), this.mThroughputUpdateCnt, TAG);
    }

    public static /* synthetic */ void access$000(RateControlManager r8, int r10) {
        r8.updateL2Throughput(r10);
    }

    public static /* synthetic */ void access$100(RateControlManager r8) {
        r8.unsetNetTrafficControl();
    }

    private void appRateLimitInfoPrint(StrategyType r13) {
        if ((this.mLogPeriodCnt % 10) != 0) goto L24;
        Iterator<UidRateControlInfo> r8 = this.mRateCtrlMap.values().iterator();
        String r10 = "null";
        String r11 = "null";
        String r12 = r11;
        String r14 = r12;
    L6:
        if (r8.hasNext() == false) goto L23;
        UidRateControlInfo r15 = r8.next();
        int r16 = AnonymousClass4.$SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[r15.appCtrlType.ordinal()];
        if (r16 == 1) goto L20;
        if (r16 != 2) goto L12;
        r11 = String.format(Locale.US, " UID %d Up %d Down %d Limit %dkbps ", new Object[]{Integer.valueOf(r15.uid), Integer.valueOf(r15.SendBytesInOneLogPeriod), Integer.valueOf(r15.RecvBytesInOneLogPeriod), Integer.valueOf(r15.rateLimit)});
    L22:
        r15.SendBytesInOneLogPeriod = 0;
        r15.RecvBytesInOneLogPeriod = 0;
        goto L6
    L12:
        if (r16 != 3) goto L14;
        r12 = String.format(Locale.US, " UID %d Up %d Down %d Limit %dkbps ", new Object[]{Integer.valueOf(r15.uid), Integer.valueOf(r15.SendBytesInOneLogPeriod), Integer.valueOf(r15.RecvBytesInOneLogPeriod), Integer.valueOf(r15.rateLimit)});
        goto L22
    L14:
        if (r16 != 4) goto L22;
        r14 = String.format(Locale.US, " UID %d Up %d Down %d Limit %dkbps ", new Object[]{Integer.valueOf(r15.uid), Integer.valueOf(r15.SendBytesInOneLogPeriod), Integer.valueOf(r15.RecvBytesInOneLogPeriod), Integer.valueOf(r15.rateLimit)});
        goto L22
    L20:
        if (r15.appPackageName == null) goto L22;
        r10 = String.format(Locale.US, " UID %d Up %d Down %d Limit %dkbps ", new Object[]{Integer.valueOf(r15.uid), Integer.valueOf(r15.SendBytesInOneLogPeriod), Integer.valueOf(r15.RecvBytesInOneLogPeriod), Integer.valueOf(r15.rateLimit)});
        goto L22
    L23:
        CaeLog.i(TAG, "Rate limit period print, strategyType " + r13 + ", temperature " + this.mReportCommonData.temperature + ", foregroundApp " + r10 + ", backgroundTotal " + this.mReportCommonData.backgroundAppRate + ", backgroundApp_1 " + r11 + ", backgroundApp_2 " + r12 + ", backgroundApp_3 " + r14 + ", backgroundApp_others " + this.mBackgroundOthersRateLimit + "kbps");
    L24:
        this.mLogPeriodCnt++;
    }

    private void cleanRateControlTempParam() {
        this.mVipAppCnt = 0;
        this.mBackgroundRateOverCnt = 0;
        this.mTemperatureLevel1Cnt = 0;
        this.mTemperatureLevel2Cnt = 0;
        this.mCleanNetTCCnt = 0;
        this.mForegroundRttOverCnt = 0;
        this.mBackgroundOthersRateLimit = 0;
        this.mIsForegroundRttOverThreshold = false;
        this.mBackgroundOthersRateNow = 0;
        this.mRateStrategyManager.reset();
        this.mLogPeriodCnt = 0;
        this.mVipStrategyReport.vipStrategyReportDataClean();
    }

    private void feedWatchDog() {
        this.mCleanNetTCCnt = 0;
    }

    public static RateControlManager getInstance(Context r8) {
        if (CaeUtil.isNetworkRateLimitSupported(r8) == true) goto L6;
        CaeLog.i(TAG, "network rate limit is not supported");
        return null;
    L6:
        CaeLog.i(TAG, "network rate limit is supported");
        if (mRateControlManager != null) goto L19;
        monitor-enter(RateControlManager.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (mRateControlManager != null) goto L13;
        mRateControlManager = new RateControlManager(r8);     // Catch: Throwable -> L15
    L13:
        monitor-exit(RateControlManager.class);     // Catch: Throwable -> L15
    L19:
        return mRateControlManager;
    }

    private String getNetif(ConcurrentHashMap<String, L4NetEvaluate.L4NetStats> r8) {
        Iterator<Map.Entry<String, L4NetEvaluate.L4NetStats>> r10 = r8.entrySet().iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L11;
        L4NetEvaluate.L4NetStats r12 = r10.next().getValue();
        if (r12.ifName.equals(WIFI0_IF_NAME) == true) goto L7;
        if (r12.ifName.equals(WIFI1_IF_NAME) == false) goto L4;
        r11 = true;
        goto L4
    L7:
        return WIFI0_IF_NAME;
    L11:
        if (r11 == false) goto L13;
        return WIFI1_IF_NAME;
    L13:
        return null;
    }

    private UidRateControlInfo getSocketInfo(int r8, ConcurrentHashMap<Long, L4NetTcpInfo> r10, L4NetEvaluate.L4NetForegroundApp r11) {
        String r12 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        UidRateControlInfo r13 = new UidRateControlInfo();
        r13.uid = r8;
        r13.ifName = this.mTargetNetif;
        if (r11 != null) goto L8;
    L10:
        r13.appPackageName = r12;
        r13.socketList = new ArrayList();
        r13.appCtrlType = AppCtrlType.BACKGROUND_OTHERS;
        r13.isUpdate = true;
        Iterator<Map.Entry<Long, L4NetTcpInfo>> r14 = r10.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L21;
        L4NetTcpInfo r15 = r14.next().getValue();
        if (r15.ifName.equals(this.mTargetNetif) == false) goto L12;
        int r16 = r13.SendBytesInOneLogPeriod;
        long r17 = r15.tcpSendBytes;
        r13.SendBytesInOneLogPeriod = r16 + ((int) r17);
        int r18 = r13.RecvBytesInOneLogPeriod;
        long r19 = r15.tcpRecvBytes;
        r13.RecvBytesInOneLogPeriod = r18 + ((int) r19);
        int r20 = (int) (r17 + r19);
        r13.rate += r20;
        if (r20 <= MIN_RATE_TO_MANAGE_THRESHOLD_IN_BYTE) goto L12;
        r13.socketList.add(new TrafficControlConfig.UidSocketInfo(r15.srcIP, r15.srcPort, r20));
        goto L12
    L21:
        if (r13.socketList.size() <= 10) goto L23;
        StringBuilder r21 = b.f("uid: ", r8, " socket count: ");
        r21.append(r13.socketList.size());
        r21.append(" exceed max count, will sort and drop.");
        CaeLog.d(TAG, r21.toString());
        r13.socketList.sort(new AnonymousClass2(this));
        r13.socketList = new ArrayList(r13.socketList.subList(0, 10));
    L23:
        return r13;
    L8:
        if (r8 != r11.uid) goto L10;
        r12 = r11.appPackageName;
        goto L10
    }

    private void mergeAppstoreSockets(ConcurrentSkipListSet<UidRateControlInfo> r8, UidRateControlInfo r10, UidRateControlInfo r11, L4NetEvaluate.L4NetForegroundApp r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 == null) goto L6;
        r10.socketList.addAll(r11.socketList);
        r8.remove(r11);
        return;
    L6:
        int r13 = this.mVipAppManager.getAppstoreUid();
        r11.uid = r13;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r13 != r12.uid) goto L14;
        r11.appCtrlType = AppCtrlType.FOREGROUND;
        r11.appPackageName = r12.appPackageName;
        return;
    }

    private void netifChangeResetProcess(String r8) {
        if (this.mTargetNetif != null) goto L6;
        CaeLog.i(TAG, "mTargetNetif set to " + r8);
        this.mTargetNetif = r8;
        this.mNetTCConfig.deInit();
        return;
    L6:
        this.mNetTCConfig.deInit();
        this.mAppRateLimitManager.clear();
        this.mTCState = TCState.DEINIT;
        cleanRateControlTempParam();
        CaeLog.i(TAG, "mTargetNetif change from " + this.mTargetNetif + " to " + r8);
        this.mTargetNetif = r8;
    }

    private StrategyType normalTempStrategy(int r8) {
        int r10 = this.mBackgroundRateOverCnt + 1;
        this.mBackgroundRateOverCnt = r10;
        if (r10 < 3) goto L20;
        TCState r11 = this.mTCState;
        TCState r12 = TCState.IN_NORMAL_TEMPERATURE_STRATEGY;
        if (r11 == r12) goto L7;
        CaeLog.i(TAG, "mTCState from " + this.mTCState + " to " + r12);
        this.mTCState = r12;
    L7:
        if (r8 == 0) goto L18;
        if (this.mBackgroundOthersRateNow < 524288) goto L18;
        if (r8 <= 150) goto L13;
        this.mForegroundRttOverCnt++;
    L15:
        if (this.mForegroundRttOverCnt <= 3) goto L18;
        this.mIsForegroundRttOverThreshold = true;
        goto L18
    L13:
        this.mForegroundRttOverCnt = 0;
        this.mIsForegroundRttOverThreshold = false;
    L18:
        return StrategyType.NORMAL_TEMPERATURE_STRATEGY;
    L20:
        return StrategyType.NONE_STRATEGY;
    }

    private void reportL4ToVipStrategy(ConcurrentHashMap<String, L4NetEvaluate.L4NetStats> r8, ConcurrentHashMap<Integer, L4NetEvaluate.L4NetStats> r10) {
        this.mVipStrategyReport.reportL4StatsToVipStrategy(r8, r10, this.mVipAppManager);
        boolean r11 = false;
        if (this.mContext != null) goto L5;
    L7:
        this.mVipStrategyReport.setVpnEnabled(r11);
        return;
    L5:
        if (this.mVipAppManager.isOAutoRunning() == false) goto L7;
        r11 = CaeUtil.isNetifUp(this.mContext, "tun0", 0);
        goto L7
    }

    private void setScreenOffPeriodicCb(Context r8) {
        L4NetTracker.ScreenOffPeriodicCallback r10 = new AnonymousClass3(this);
        L4NetTracker.getInstance(r8).setScreenOffPeriodicCallback(r10);
    }

    private StrategyType temperatureLevel1Strategy() {
        int r8 = this.mTemperatureLevel1Cnt + 1;
        this.mTemperatureLevel1Cnt = r8;
        if (r8 < 3) goto L10;
        TCState r10 = this.mTCState;
        TCState r11 = TCState.IN_TEMPERATURE_LEVEL1_STRATEGY;
        if (r10 == r11) goto L7;
        CaeLog.i(TAG, "mTCState from " + this.mTCState + " to " + r11 + " temperature is " + this.mReportCommonData.temperature);
        this.mTCState = r11;
    L7:
        this.mTemperatureLevel1Cnt = 3;
        return StrategyType.TEMPERATURE_LEVEL1_STRATEGY;
    L10:
        return StrategyType.NONE_STRATEGY;
    }

    private StrategyType temperatureLevel2Strategy() {
        int r8 = this.mTemperatureLevel2Cnt + 1;
        this.mTemperatureLevel2Cnt = r8;
        if (r8 < 3) goto L10;
        TCState r10 = this.mTCState;
        TCState r11 = TCState.IN_TEMPERATURE_LEVEL2_STRATEGY;
        if (r10 == r11) goto L7;
        CaeLog.i(TAG, "mTCState from " + this.mTCState + " to " + r11 + " temperature is " + this.mReportCommonData.temperature);
        this.mTCState = r11;
    L7:
        this.mTemperatureLevel2Cnt = 3;
        return StrategyType.TEMPERATURE_LEVEL2_STRATEGY;
    L10:
        return StrategyType.NONE_STRATEGY;
    }

    private void unsetNetTrafficControl() {
        StringBuilder r8 = new StringBuilder("unsetNetTrafficControl, mTCState from ");
        r8.append(this.mTCState);
        r8.append(" to ");
        TCState r10 = TCState.DEINIT;
        r8.append(r10);
        CaeLog.i(TAG, r8.toString());
        this.mNetworkRateLimitReport.reportRateLimitCancelEvent(this.mReportCommonData);
        this.mNetTCConfig.deInit();
        this.mAppRateLimitManager.clear();
        this.mTCState = r10;
        cleanRateControlTempParam();
    }

    private void updateL2Throughput(int r8) {
        int r10 = this.mThroughputUpdateCnt;
        if (r10 >= 8) goto L8;
        int r11 = r10 + 1;
        this.mThroughputUpdateCnt = r11;
        int r12 = this.mThroughputTempVal + r8;
        this.mThroughputTempVal = r12;
        if (r11 != 8) goto L10;
        this.isMaxBandWidthReady = true;
        this.mThroughputTempVal = r12 / 8;
        b.p(new StringBuilder("mThroughputTempVal is "), this.mThroughputTempVal, TAG);
        return;
    L10:
        return;
    L8:
        int r13 = ((this.mThroughputTempVal * 7) + r8) / 8;
        this.mThroughputTempVal = r13;
        this.mMaxBandWidthEstimatedVal = Math.max(r13 / 3, MIN_BANDWIDTH_ESTIMATED_VAL);
    }

    private void updateNetif() {
        Network r8 = this.mConnectivityManager.getActiveNetwork();
        LinkProperties r10 = this.mConnectivityManager.getLinkProperties(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        String r11 = r10.getInterfaceName();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.equals(this.mTargetNetif) == false) goto L11;
        return;
    L11:
        if (r11.startsWith(WLAN_IFNAME_MARK) == false) goto L13;
    L15:
        netifChangeResetProcess(r11);
        boolean r12 = this.mTargetNetif.startsWith(WLAN_IFNAME_MARK);
        this.isTragetNetifWlan = r12;
        if (r12 == false) goto L20;
        VipAppManager r13 = this.mVipAppManager;
        r13.addVipUid(r13.getDoubaoAppUid());
        return;
    L20:
        return;
    L13:
        if (r11.startsWith(CELL_IFNAME_MARK) == true) goto L15;
    }

    private void updateRateCtrlMap(ConcurrentHashMap<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> r10, L4NetEvaluate.L4NetForegroundApp r11) {
        ConcurrentSkipListSet<UidRateControlInfo> r8 = new ConcurrentSkipListSet(Comparator.comparingInt(new a()));
        Iterator<Map.Entry<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>>> r12 = r10.entrySet().iterator();
        UidRateControlInfo r13 = null;
        UidRateControlInfo r14 = null;
    L3:
        boolean r15 = false;
        if (r12.hasNext() == false) goto L27;
        Map.Entry<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> r16 = r12.next();
        UidRateControlInfo r17 = getSocketInfo(r16.getKey().intValue(), r16.getValue(), r11);
        if (r17 == null) goto L3;
        int r18 = r17.uid;
        if (r18 != r11.uid) goto L11;
        r15 = true;
    L11:
        boolean r19 = this.mVipAppManager.isVipUid(r18);
        if (r15 == true) goto L16;
        if (r17.socketList.isEmpty() == true) goto L3;
    L16:
        if (r15 == false) goto L18;
        r17.appCtrlType = AppCtrlType.FOREGROUND;
    L18:
        if (r19 == false) goto L21;
        r17.appCtrlType = AppCtrlType.FOREGROUND;
        r17.isVipApp = true;
    L21:
        if (r17.uid != this.mVipAppManager.getAppstoreUid()) goto L24;
        r13 = r17;
    L26:
        r8.add(r17);
        goto L3
    L24:
        if (r17.uid != this.mVipAppManager.getDownloadserverUid()) goto L26;
        r14 = r17;
        goto L26
    L27:
        mergeAppstoreSockets(r8, r13, r14, r11);
        Iterator<UidRateControlInfo> r110 = r8.iterator();
        int r20 = 0;
    L29:
        if (r110.hasNext() == false) goto L45;
        UidRateControlInfo r21 = r110.next();
        UidRateControlInfo r22 = this.mRateCtrlMap.get(Integer.valueOf(r21.uid));
        if (r22 == null) goto L36;
        r22.rate = r21.rate;
        r22.socketList = r21.socketList;
        r22.isUpdate = true;
        r22.appPackageName = null;
        String r23 = r21.appPackageName;
        if (r23 == null) goto L35;
        r22.appPackageName = r23;
    L35:
        r22.appCtrlType = r21.appCtrlType;
        r22.isVipApp = r21.isVipApp;
        r22.SendBytesInOneLogPeriod += r21.SendBytesInOneLogPeriod;
        r22.RecvBytesInOneLogPeriod += r21.RecvBytesInOneLogPeriod;
        r21 = r22;
    L38:
        if (r21.appCtrlType == AppCtrlType.FOREGROUND) goto L29;
        if (r21.isSpecificApp == true) goto L29;
        if (r20 >= 3) goto L29;
        r21.appCtrlType = AppCtrlType.values()[AppCtrlType.BACKGROUND_1.ordinal() + r20];
        r20 = r20 + 1;
        goto L29
    L36:
        this.mRateCtrlMap.put(Integer.valueOf(r21.uid), r21);
        goto L38
    L45:
        Iterator<UidRateControlInfo> r111 = this.mRateCtrlMap.values().iterator();
    L47:
        if (r111.hasNext() == false) goto L59;
        UidRateControlInfo r24 = r111.next();
        if (r24.isUpdate == true) goto L50;
        r24.rate = 0;
        r24.appPackageName = null;
        if (r24.isSpecificApp == true) goto L47;
        int r25 = r24.uid;
        if (r25 == r11.uid) goto L47;
        if (this.mVipAppManager.isVipUid(r25) == true) goto L47;
        this.mAppRateLimitManager.remove(r24.uid);
        r111.remove();
        goto L47
    L50:
        r24.isUpdate = false;
        goto L47
    }

    private StrategyType vipAppStrategy() {
        int r8 = this.mVipAppCnt + 1;
        this.mVipAppCnt = r8;
        if (r8 < 3) goto L10;
        TCState r10 = this.mTCState;
        TCState r11 = TCState.IN_VIP_APP_STRATEGY;
        if (r10 == r11) goto L8;
        CaeLog.i(TAG, "mTCState from " + this.mTCState + " to " + r11);
        this.mTCState = r11;
    L8:
        return StrategyType.VIP_APP_STRATEGY;
    L10:
        return StrategyType.NONE_STRATEGY;
    }

    private void watchDogCheck() {
        int r8 = this.mCleanNetTCCnt + 1;
        this.mCleanNetTCCnt = r8;
        if (r8 <= 60) goto L8;
        if (this.mTCState == TCState.DEINIT) goto L8;
        unsetNetTrafficControl();
    L8:
        if (this.mTCState == TCState.DEINIT) goto L11;
        appRateLimitInfoPrint(this.mLastStrategyType);
        return;
    }

    public String getTargetNetif() {
        return this.mTargetNetif;
    }

    public void netifDownProcess(String r8) {
        android.aimedia.a.r(b.h("netif ", r8, " is down, mTargetNetif is "), this.mTargetNetif, TAG);
        String r10 = this.mTargetNetif;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.equals(r8) == false) goto L9;
        this.mNetTCConfig.deInit();
        this.mTargetNetif = null;
        this.mTCState = TCState.DEINIT;
        cleanRateControlTempParam();
        return;
    }

    public void setNetworkQoEMonitor(NetworkQoEMonitor r8) {
        CaeLog.d(TAG, "call setNetworkQoEMonitor");
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "networkQoEMonitor is null");
        return;
    L6:
        r8.registerWiFiQoECallback(new AnonymousClass1(this));
    }

    public void updateL4NetStats(ConcurrentHashMap<String, L4NetEvaluate.L4NetStats> r8, ConcurrentHashMap<Integer, L4NetEvaluate.L4NetStats> r10, ConcurrentHashMap<Integer, ConcurrentHashMap<Long, L4NetTcpInfo>> r11, L4NetEvaluate.L4NetForegroundApp r12) {
        watchDogCheck();
        updateNetif();
        reportL4ToVipStrategy(r8, r10);
        String r13 = this.mTargetNetif;
        if (r13 != null) goto L5;
        return;
    L5:
        L4NetEvaluate.L4NetStats r14 = r8.get(r13);
        if (r14 != null) goto L8;
        return;
    L8:
        int r15 = r14.sendRate + r14.recvRate;
        if (r15 != 0) goto L11;
        return;
    L11:
        this.mNetTCConfig.setTargetIfName(this.mTargetNetif);
        this.mReportCommonData.ifName = this.mTargetNetif;
        L4NetEvaluate.L4NetStats r16 = r10.get(Integer.valueOf(r12.uid));
        NetworkRateLimitReport.ReportCommonData r17 = this.mReportCommonData;
        boolean r18 = false;
        if (r16 == null) goto L14;
        int r19 = r16.rttAve;
    L15:
        r17.foregroundAppRttAverage = r19;
        updateRateCtrlMap(r11, r12);
        UidRateControlInfo r20 = this.mRateCtrlMap.get(Integer.valueOf(r12.uid));
        NetworkRateLimitReport.ReportCommonData r21 = this.mReportCommonData;
        if (r20 == null) goto L18;
        int r22 = r20.rate;
    L19:
        r21.foregroundAppRate = r22;
        this.mBackgroundOthersRateNow = BackgroundOtherAndNotVipAppsRate(r15, r22);
        this.mReportCommonData.rateCtrlUidNumber = this.mRateCtrlMap.size();
        NetworkRateLimitReport.ReportCommonData r23 = this.mReportCommonData;
        r23.maxBandwidthEstimatedValue = this.mMaxBandWidthEstimatedVal;
        r23.foregroundAppPkgName = r12.appPackageName;
        L4NetEvaluate.ForegroundAppStrategy r24 = r12.strategy;
        if (r24 == L4NetEvaluate.ForegroundAppStrategy.NONE) goto L22;
        r18 = true;
    L22:
        r23.foregroundAppIsInWhitelist = r18;
        r23.backgroundAppRate = this.mBackgroundOthersRateNow;
        RateManager(r24, r23.foregroundAppRttAverage, r15);
        this.mAppRateLimitManager.updateUidSockInfoTimeoutCnt();
        return;
    L18:
        r22 = 0;
        goto L19
    L14:
        r19 = 0;
        goto L15
    }
}
