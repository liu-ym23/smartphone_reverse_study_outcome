package com.obric.cae.smartNetwork.NetworkAccelerate;

import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluateObserver;
import com.obric.cae.smartNetwork.netOpt.NetworkTruth;
import com.obric.cae.smartNetwork.networkRateLimit.RateControlManager;
import com.obric.cae.smartNetwork.networkRateLimit.RateStrategyManager;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import com.obric.cae.wifi.WiFiDBHelper;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class VipStrategyReport {
    public static final boolean DEFAULT_VIP_NETWORK_ENABLE = true;
    public static final int DEFAULT_WIFI_MSC_SET_VALUE = 7;
    private static final String EVENT_NAME = "cae_oauto_network_report";
    private static final int REPORT_INTERVAL_COUNT = 5;
    private static final String TAG = "VipStrategyReport";
    private static volatile VipStrategyReport sInstance;
    private final AtomicInteger mBackgroundRateLimit;
    private final AtomicInteger mBackgroundThroughput;
    private final AtomicInteger mCellularRtt;
    private final AtomicInteger mCellularThroughput;
    private final AtomicInteger mDoubaoAvgRttFiveSec;
    private int mDoubaoLossPacketsFiveSec;
    private final AtomicInteger mDoubaoMaxRttFiveSec;
    private final AtomicInteger mDoubaoMinRttFiveSec;
    private int mDoubaoPacketLossFiveSec;
    private final LinkedList<Integer> mDoubaoPacketLossHistory;
    private int mDoubaoReceivedBytesFiveSec;
    private final AtomicInteger mDoubaoRtt;
    private final LinkedList<Integer> mDoubaoRttHistory;
    private int mDoubaoSentBytesFiveSec;
    private int mDoubaoSentPacketsFiveSec;
    private int mDoubaoTotalRateFiveSec;
    private final AtomicReference<String> mForegroundAppPkg;
    private final AtomicInteger mForegroundRateLimit;
    private final AtomicInteger mForegroundThroughput;
    private final AtomicBoolean mIsSuperStableEnabled;
    private final AtomicBoolean mIsVipChannelEnabled;
    private final AtomicBoolean mIsVipNetworkFeatureEnabled;
    private final AtomicBoolean mIsVpnEnabled;
    private final AtomicBoolean mIsWifiAccelEnabled;
    private L4NetEvaluateObserver mL4NetEvaluateObserver;
    private NetworkTruth mNetworkTruth;
    private final AtomicInteger mRateStrategyType;
    private final AtomicInteger mReportCounter;
    private final AtomicInteger mVipChannelRateLimit;
    private final AtomicInteger mVipChannelThroughput;
    private final AtomicInteger mWifiCurrentThroughput;
    private final AtomicInteger mWifiRtt;

    private VipStrategyReport() {
        this.mDoubaoRttHistory = new LinkedList();
        this.mIsVipNetworkFeatureEnabled = new AtomicBoolean(false);
        this.mIsWifiAccelEnabled = new AtomicBoolean(false);
        this.mIsSuperStableEnabled = new AtomicBoolean(false);
        this.mIsVipChannelEnabled = new AtomicBoolean(false);
        this.mRateStrategyType = new AtomicInteger(RateControlManager.StrategyType.NONE_STRATEGY.ordinal());
        this.mForegroundAppPkg = new AtomicReference("");
        this.mForegroundRateLimit = new AtomicInteger(0);
        this.mVipChannelRateLimit = new AtomicInteger(0);
        this.mBackgroundRateLimit = new AtomicInteger(0);
        this.mForegroundThroughput = new AtomicInteger(0);
        this.mVipChannelThroughput = new AtomicInteger(0);
        this.mBackgroundThroughput = new AtomicInteger(0);
        this.mDoubaoRtt = new AtomicInteger(0);
        this.mDoubaoAvgRttFiveSec = new AtomicInteger(0);
        this.mDoubaoMaxRttFiveSec = new AtomicInteger(0);
        this.mDoubaoMinRttFiveSec = new AtomicInteger(0);
        this.mIsVpnEnabled = new AtomicBoolean(false);
        this.mWifiCurrentThroughput = new AtomicInteger(0);
        this.mWifiRtt = new AtomicInteger(0);
        this.mCellularThroughput = new AtomicInteger(0);
        this.mCellularRtt = new AtomicInteger(0);
        this.mReportCounter = new AtomicInteger(0);
        this.mDoubaoTotalRateFiveSec = 0;
        this.mDoubaoSentBytesFiveSec = 0;
        this.mDoubaoReceivedBytesFiveSec = 0;
        this.mDoubaoPacketLossFiveSec = 0;
        this.mDoubaoPacketLossHistory = new LinkedList();
        this.mDoubaoSentPacketsFiveSec = 0;
        this.mDoubaoLossPacketsFiveSec = 0;
    }

    private void appendDoubaoStatsInfo(JSONObject r8) {
        r8.put("doubaoTotalRateFiveSec", this.mDoubaoTotalRateFiveSec);     // Catch: JSONException -> L4
        r8.put("doubaoSentBytesFiveSec", this.mDoubaoSentBytesFiveSec);     // Catch: JSONException -> L4
        r8.put("doubaoReceivedBytesFiveSec", this.mDoubaoReceivedBytesFiveSec);     // Catch: JSONException -> L4
        r8.put("doubaoPacketLossFiveSec", this.mDoubaoPacketLossFiveSec);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Failed to append doubao stats info", e);
    }

    private void appendNetworkTruthCapabilityInfo(JSONObject r8) {
        NetworkTruth r10 = this.mNetworkTruth;
        if (r10 != null) goto L5;
        return;
    L5:
        NetworkTruth.NetworkInfo r11 = r10.getDefaultNetworkInfo();
        if (r11 != null) goto L29;
        return;
    L29:
        JSONObject r12 = this.mNetworkTruth.convertNetworkInfoToJson(r11);     // Catch: JSONException -> L26
        String r13 = "";
        if (r12.has("capabilityType") == false) goto L12;
        r13 = r12.getString("capabilityType");     // Catch: JSONException -> L26
        r8.put("capabilityType", r13);     // Catch: JSONException -> L26
    L12:
        if (r12.has(QesdkUtils.TAGS.JSON_TAG_CAPABILITY) == true) goto L14;
        return;
    L14:
        JSONObject r14 = r12.getJSONObject(QesdkUtils.TAGS.JSON_TAG_CAPABILITY);     // Catch: JSONException -> L26
        Iterator<String> r15 = r14.keys();     // Catch: JSONException -> L26
    L15:
        if (r15.hasNext() == false) goto L40;
        String r16 = r15.next();     // Catch: JSONException -> L26
        if ("wifi".equals(r13) == false) goto L24;
        if ("ssid".equals(r16) == true) goto L15;
        if (WiFiDBHelper.COL_BSSID.equals(r16) == true) goto L15;
    L24:
        r8.put(r16, r14.get(r16));     // Catch: JSONException -> L26
        goto L15
    L40:
        return;
    L26:
        e = move-exception;
        CaeLog.e(TAG, "Failed to append network capability info", e);
    }

    public static VipStrategyReport getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(VipStrategyReport.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new VipStrategyReport();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VipStrategyReport.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void reportToTea(VipAppManager r8) {
        if (r8.isOAutoRunning() == true) goto L6;
        return;
    L6:
        if (this.mReportCounter.incrementAndGet() < 5) goto L16;
        this.mReportCounter.set(0);
        JSONObject r10 = convertVipStrategyReportToJson();     // Catch: Exception -> L10
        appendDoubaoStatsInfo(r10);     // Catch: Exception -> L10
        appendNetworkTruthCapabilityInfo(r10);     // Catch: Exception -> L10
        ByteIOUtils.trackEvent(EVENT_NAME, r10);     // Catch: Exception -> L10
    L12:
        resetDoubaoStatsFiveSec();
        return;
    L10:
        e = move-exception;
        CaeLog.e(TAG, "Error reporting strategy to ByteIO", e);
        goto L12
    }

    private void resetDoubaoStatsFiveSec() {
        this.mDoubaoTotalRateFiveSec = 0;
        this.mDoubaoSentBytesFiveSec = 0;
        this.mDoubaoReceivedBytesFiveSec = 0;
        this.mDoubaoSentPacketsFiveSec = 0;
        this.mDoubaoLossPacketsFiveSec = 0;
    }

    public JSONObject convertVipStrategyReportToJson() {
        L4NetEvaluateObserver r8 = this.mL4NetEvaluateObserver;
        if (r8 == null) goto L7;
        boolean r10 = r8.getVipNetworkEnable();
        if (this.mIsVipNetworkFeatureEnabled.get() == r10) goto L7;
        this.mIsVipNetworkFeatureEnabled.set(r10);
    L7:
        JSONObject r11 = new JSONObject();
        r11.put("isVipNetworkFeatureEnabled", this.mIsVipNetworkFeatureEnabled.get());     // Catch: JSONException -> L10
        r11.put("isWifiAccelEnabled", this.mIsWifiAccelEnabled.get());     // Catch: JSONException -> L10
        r11.put("isSuperStableEnabled", this.mIsSuperStableEnabled.get());     // Catch: JSONException -> L10
        r11.put("isVipChannelEnabled", this.mIsVipChannelEnabled.get());     // Catch: JSONException -> L10
        r11.put("rateStrategyType", this.mRateStrategyType.get());     // Catch: JSONException -> L10
        r11.put("foregroundAppPkg", this.mForegroundAppPkg.get());     // Catch: JSONException -> L10
        r11.put("foregroundRateLimit", this.mForegroundRateLimit.get());     // Catch: JSONException -> L10
        r11.put("vipChannelRateLimit", this.mVipChannelRateLimit.get());     // Catch: JSONException -> L10
        r11.put("backgroundRateLimit", this.mBackgroundRateLimit.get());     // Catch: JSONException -> L10
        r11.put("foregroundThroughput", this.mForegroundThroughput.get());     // Catch: JSONException -> L10
        r11.put("vipChannelThroughput", this.mVipChannelThroughput.get());     // Catch: JSONException -> L10
        r11.put("backgroundThroughput", this.mBackgroundThroughput.get());     // Catch: JSONException -> L10
        r11.put("doubaoRtt", this.mDoubaoRtt.get());     // Catch: JSONException -> L10
        r11.put("doubaoAvgRttFiveSec", this.mDoubaoAvgRttFiveSec.get());     // Catch: JSONException -> L10
        r11.put("doubaoMaxRttFiveSec", this.mDoubaoMaxRttFiveSec.get());     // Catch: JSONException -> L10
        r11.put("doubaoMinRttFiveSec", this.mDoubaoMinRttFiveSec.get());     // Catch: JSONException -> L10
        r11.put("isVpnEnabled", this.mIsVpnEnabled.get());     // Catch: JSONException -> L10
        r11.put("wifiCurrentThroughput", this.mWifiCurrentThroughput.get());     // Catch: JSONException -> L10
        r11.put("wifiRtt", this.mWifiRtt.get());     // Catch: JSONException -> L10
        r11.put("cellularThroughput", this.mCellularThroughput.get());     // Catch: JSONException -> L10
        r11.put("cellularRtt", this.mCellularRtt.get());     // Catch: JSONException -> L10
    L12:
        return r11;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public void registerNetworkTruth(NetworkTruth r8) {
        this.mNetworkTruth = r8;
    }

    public void reportL4StatsToVipStrategy(ConcurrentHashMap<String, L4NetEvaluate.L4NetStats> r10, ConcurrentHashMap<Integer, L4NetEvaluate.L4NetStats> r11, VipAppManager r12) {
        Iterator<L4NetEvaluate.L4NetStats> r13 = r10.values().iterator();
        int r8 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r13.hasNext() == false) goto L14;
        L4NetEvaluate.L4NetStats r17 = r13.next();
        String r18 = r17.ifName;
        if (r18 == null) goto L4;
        if (r18.startsWith("wlan") == true) goto L10;
        if (r17.ifName.startsWith("rmnet") == false) goto L4;
        int r19 = (r17.sendRate + r17.recvRate) + r15;
        r16 = r17.rttAve;
        r15 = r19;
        goto L4
    L10:
        int r20 = (r17.sendRate + r17.recvRate) + r8;
        r14 = r17.rttAve;
        r8 = r20;
        goto L4
    L14:
        setDoubaoStatsInfo(r11.get(Integer.valueOf(r12.getDoubaoAppUid())));
        this.mWifiCurrentThroughput.set(r8);
        this.mWifiRtt.set(r14);
        this.mCellularThroughput.set(r15);
        this.mCellularRtt.set(r16);
    }

    public void reportRateLimitDataToVipStrategy(int r8, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r10, RateStrategyManager r11, VipAppManager r12) {
        Iterator<RateControlManager.UidRateControlInfo> r13 = r10.values().iterator();
        String r14 = "";
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r13.hasNext() == false) goto L16;
        RateControlManager.UidRateControlInfo r18 = r13.next();
        if (r18.appCtrlType == RateControlManager.AppCtrlType.FOREGROUND) goto L7;
        r17 = r17 + r18.rate;
        goto L4
    L7:
        String r19 = r18.appPackageName;
        if (r19 == null) goto L13;
        if (r19.isEmpty() == true) goto L13;
        r14 = r18.appPackageName;
        r15 = r15 + r18.rate;
    L13:
        if (r18.isVipApp == false) goto L4;
        r16 = r16 + r18.rate;
        goto L4
    L16:
        int r20 = r11.getBackgroundOthersRateLimit();
        int r110 = r11.getForegroundRateLimit();
        this.mRateStrategyType.set(r8);
        this.mForegroundAppPkg.set(r14);
        this.mForegroundThroughput.set(r15);
        this.mVipChannelThroughput.set(r16);
        this.mBackgroundThroughput.set(r17);
        this.mForegroundRateLimit.set(r110);
        this.mVipChannelRateLimit.set(TrafficControlConfig.DEFAULT_UNLIMITED_RATE);
        this.mBackgroundRateLimit.set(r20);
        reportToTea(r12);
    }

    public void setDoubaoRtt(int r8) {
        this.mDoubaoRtt.set(r8);
        LinkedList<Integer> r10 = this.mDoubaoRttHistory;
        monitor-enter(r10);
        this.mDoubaoRttHistory.addLast(Integer.valueOf(r8));     // Catch: Throwable -> L20
        if (this.mDoubaoRttHistory.size() <= 5) goto L8;
        this.mDoubaoRttHistory.removeFirst();     // Catch: Throwable -> L20
    L8:
        if (this.mDoubaoRttHistory.isEmpty() == true) goto L18;
        Iterator<Integer> r11 = this.mDoubaoRttHistory.iterator();     // Catch: Throwable -> L20
        int r12 = 0;
        int r13 = Integer.MIN_VALUE;
        int r14 = Integer.MAX_VALUE;
    L11:
        if (r11.hasNext() == false) goto L17;
        int r15 = r11.next().intValue();     // Catch: Throwable -> L20
        r12 = r12 + r15;     // Catch: Throwable -> L20
        if (r15 <= r13) goto L15;
        r13 = r15;
    L15:
        if (r15 >= r14) goto L11;
        r14 = r15;
        goto L11
    L17:
        this.mDoubaoAvgRttFiveSec.set(r12 / this.mDoubaoRttHistory.size());     // Catch: Throwable -> L20
        this.mDoubaoMaxRttFiveSec.set(r13);     // Catch: Throwable -> L20
        this.mDoubaoMinRttFiveSec.set(r14);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void setDoubaoStatsInfo(L4NetEvaluate.L4NetStats r8) {
        if (r8 != null) goto L6;
        setDoubaoRtt(0);
        return;
    L6:
        setDoubaoRtt(r8.rttAve);
        int r10 = this.mDoubaoTotalRateFiveSec;
        int r11 = r8.sendRate;
        int r12 = r8.recvRate;
        this.mDoubaoTotalRateFiveSec = (r11 + r12) + r10;
        this.mDoubaoSentBytesFiveSec += r11;
        this.mDoubaoReceivedBytesFiveSec += r12;
        int r13 = this.mDoubaoSentPacketsFiveSec;
        int r14 = r8.sendPackets;
        int r15 = r13 + r14;
        this.mDoubaoSentPacketsFiveSec = r15;
        int r16 = this.mDoubaoLossPacketsFiveSec + ((r14 * r8.sendRetrans) / 100);
        this.mDoubaoLossPacketsFiveSec = r16;
        if (r15 <= 0) goto L9;
        this.mDoubaoPacketLossFiveSec = (r16 * 100) / r15;
        return;
    L9:
        this.mDoubaoPacketLossFiveSec = 0;
    }

    public void setL4NetEvaluateObserver(L4NetEvaluateObserver r8) {
        this.mL4NetEvaluateObserver = r8;
        if (r8 == null) goto L6;
        this.mIsVipNetworkFeatureEnabled.set(r8.getVipNetworkEnable());
        return;
    }

    public void setSuperStableEnabled(boolean r8) {
        this.mIsSuperStableEnabled.set(r8);
    }

    public void setVipChannelEnabled(boolean r8) {
        this.mIsVipChannelEnabled.set(r8);
    }

    public void setVipNetworkFeatureEnabled(boolean r8) {
        this.mIsVipNetworkFeatureEnabled.set(r8);
    }

    public void setVpnEnabled(boolean r8) {
        this.mIsVpnEnabled.set(r8);
    }

    public void setWifiAccelEnabled(boolean r8) {
        this.mIsWifiAccelEnabled.set(r8);
    }

    public String toString() {
        return "VipStrategyReport{mIsVipNetworkFeatureEnabled=" + this.mIsVipNetworkFeatureEnabled.get() + ", mIsWifiAccelEnabled=" + this.mIsWifiAccelEnabled.get() + ", mIsSuperStableEnabled=" + this.mIsSuperStableEnabled.get() + ", mIsVipChannelEnabled=" + this.mIsVipChannelEnabled.get() + ", mRateStrategyType=" + this.mRateStrategyType.get() + ", mForegroundAppPkg='" + this.mForegroundAppPkg.get() + "', mForegroundRateLimit=" + this.mForegroundRateLimit.get() + ", mVipChannelRateLimit=" + this.mVipChannelRateLimit.get() + ", mBackgroundRateLimit=" + this.mBackgroundRateLimit.get() + ", mForegroundThroughput=" + this.mForegroundThroughput.get() + ", mVipChannelThroughput=" + this.mVipChannelThroughput.get() + ", mBackgroundThroughput=" + this.mBackgroundThroughput.get() + ", mDoubaoRtt=" + this.mDoubaoRtt.get() + ", mDoubaoAvgRttFiveSec=" + this.mDoubaoAvgRttFiveSec.get() + ", mDoubaoMaxRttFiveSec=" + this.mDoubaoMaxRttFiveSec.get() + ", mDoubaoMinRttFiveSec=" + this.mDoubaoMinRttFiveSec.get() + ", mIsVpnEnabled=" + this.mIsVpnEnabled.get() + ", mWifiCurrentThroughput=" + this.mWifiCurrentThroughput.get() + ", mWifiRtt=" + this.mWifiRtt.get() + ", mCellularThroughput=" + this.mCellularThroughput.get() + ", mCellularRtt=" + this.mCellularRtt.get() + '}';
    }

    public void vipStrategyReportDataClean() {
        this.mRateStrategyType.set(RateControlManager.StrategyType.NONE_STRATEGY.ordinal());
        this.mIsVipChannelEnabled.set(false);
        this.mForegroundAppPkg.set("");
        this.mForegroundThroughput.set(0);
        this.mVipChannelThroughput.set(0);
        this.mBackgroundThroughput.set(0);
        this.mForegroundRateLimit.set(0);
        this.mVipChannelRateLimit.set(0);
        this.mBackgroundRateLimit.set(0);
    }
}
