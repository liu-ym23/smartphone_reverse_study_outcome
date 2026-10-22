package com.obric.cae.userAware.report;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.log.a;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.HARStateInfo;
import com.obric.cae.userAware.datacollection.UserFeedbackInfo;
import com.obric.cae.userAware.datacollection.WifiScanCount;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CaeUserAwareReportBase {
    protected static final int CAE_CONN_INFO_REPORT_INTERVAL = 10000;
    protected static final int CAE_NEAR_ELEVATOR_EVENT_FEATURE_ID = 112;
    protected static final int CAE_USER_AWARE_SERVICE_EVENT_FEATURE_ID = 94;
    public static final String EVENT_WIFI_SCAN_TUNE = "wifi_scan_tune";
    protected static final int MAX_HAR_STATE_RAW_DATA_SIZE = 30;
    protected static final int MAX_WIFI_CONN_REPORT_SIZE = 20;
    protected static final int MAX_WIFI_PNO_STATS_REPORT_SIZE = 5;
    protected static final int MAX_WIFI_SCAN_COUNT_REPORT_SIZE = 1;
    protected static final int MAX_WIFI_SCAN_REPORT_SIZE = 300;
    protected static final int MAX_WIFI_SCAN_REPORT_SIZE_PER_TIME = 30;
    protected static ConnectivityManager mConnectivityManager;
    private final int MSG_HANDLE_USER_AWARE_REPORT;
    protected final Object connListLock;
    protected final Object countListLock;
    protected final List<WifiStandardData> gAccumulatedWifiList;
    protected final List<HARStateInfo> gHarStateList;
    protected final List<WifiStandardData> gLatestWifiConnList;
    protected final List<PnoStats> gLatestWifiPnoStatsList;
    protected final List<WifiScanCount> gLatestWifiScanCountList;
    protected final Object harStateListLock;
    protected boolean isReadyToSendConnReport;
    protected final Context mContext;
    protected String mCurrentBssid;
    protected Handler mHandler;
    protected final Object pnoStatsListLock;
    protected final Object scanListLock;

    public static final class PnoStats {
        public static final int EVENT_START = 1;
        public static final int EVENT_STOP = 2;
        private long mDurationMs;
        private int mEstimatedRounds;
        private int mEstimatedRoundsToday;
        private int mEvent;
        private int mPeriodMs;
        private int mSessionCountToday;
        private long mStartWallClockMs;
        private long mStopWallClockMs;
        private long mTimeStamp;
        private long mTotalDurationTodayMs;

        public PnoStats() {
        }

        public PnoStats(PnoStats r3) {
            if (r3 != null) goto L5;
            return;
        L5:
            this.mTimeStamp = r3.mTimeStamp;
            this.mEvent = r3.mEvent;
            this.mStartWallClockMs = r3.mStartWallClockMs;
            this.mStopWallClockMs = r3.mStopWallClockMs;
            this.mDurationMs = r3.mDurationMs;
            this.mPeriodMs = r3.mPeriodMs;
            this.mEstimatedRounds = r3.mEstimatedRounds;
            this.mTotalDurationTodayMs = r3.mTotalDurationTodayMs;
            this.mSessionCountToday = r3.mSessionCountToday;
            this.mEstimatedRoundsToday = r3.mEstimatedRoundsToday;
        }

        public long getDurationMs() {
            return this.mDurationMs;
        }

        public int getEstimatedRounds() {
            return this.mEstimatedRounds;
        }

        public int getEstimatedRoundsToday() {
            return this.mEstimatedRoundsToday;
        }

        public int getEvent() {
            return this.mEvent;
        }

        public int getPeriodMs() {
            return this.mPeriodMs;
        }

        public int getSessionCountToday() {
            return this.mSessionCountToday;
        }

        public long getStartWallClockMs() {
            return this.mStartWallClockMs;
        }

        public long getStopWallClockMs() {
            return this.mStopWallClockMs;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }

        public long getTotalDurationTodayMs() {
            return this.mTotalDurationTodayMs;
        }

        public void setDurationMs(long r1) {
            this.mDurationMs = r1;
        }

        public void setEstimatedRounds(int r1) {
            this.mEstimatedRounds = r1;
        }

        public void setEstimatedRoundsToday(int r1) {
            this.mEstimatedRoundsToday = r1;
        }

        public void setEvent(int r1) {
            this.mEvent = r1;
        }

        public void setPeriodMs(int r1) {
            this.mPeriodMs = r1;
        }

        public void setSessionCountToday(int r1) {
            this.mSessionCountToday = r1;
        }

        public void setStartWallClockMs(long r1) {
            this.mStartWallClockMs = r1;
        }

        public void setStopWallClockMs(long r1) {
            this.mStopWallClockMs = r1;
        }

        public void setTimeStamp(long r1) {
            this.mTimeStamp = r1;
        }

        public void setTotalDurationTodayMs(long r1) {
            this.mTotalDurationTodayMs = r1;
        }
    }

    public static abstract class ReportItem {
        public ReportItem() {
        }

        public abstract void buildEvents();
    }

    public class ReportQueueProcessHandler extends Handler {
        final /* synthetic */ CaeUserAwareReportBase this$0;

        public ReportQueueProcessHandler(CaeUserAwareReportBase r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            if (r2.what != 0) goto L6;
            ((ReportItem) ZeusTransformUtils.preCheckCast(r2.obj, ReportItem.class, "com.obric.memorydata.plugin")).buildEvents();
            return;
        }
    }

    public CaeUserAwareReportBase(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.MSG_HANDLE_USER_AWARE_REPORT = 0;
        this.gAccumulatedWifiList = new ArrayList();
        this.gLatestWifiConnList = new ArrayList();
        this.gLatestWifiScanCountList = new ArrayList();
        this.gLatestWifiPnoStatsList = new ArrayList();
        this.gHarStateList = new ArrayList();
        this.scanListLock = new Object();
        this.connListLock = new Object();
        this.countListLock = new Object();
        this.pnoStatsListLock = new Object();
        this.harStateListLock = new Object();
        this.isReadyToSendConnReport = false;
        this.mCurrentBssid = "";
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        initHandler();
        mConnectivityManager = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
    }

    private void initHandler() {
        HandlerThread r0 = new HandlerThread("cae_user_aware_report");
        r0.start();
        this.mHandler = new ReportQueueProcessHandler(this, r0.getLooper());
    }

    public static boolean isWifiConnected() {
        ConnectivityManager r0 = mConnectivityManager;
        if (r0 == null) goto L12;
        NetworkCapabilities r1 = r0.getNetworkCapabilities(r0.getActiveNetwork());
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.hasTransport(1) == true) goto L9;
        return false;
    L9:
        if (r1.hasCapability(12) == true) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    static /* synthetic */ boolean lambda$reportWifiScanInfo$0(WifiStandardData r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (r1.getSsid() == null) goto L9;
        if (r1.getSsid().isEmpty() == true) goto L9;
        return false;
    }

    static /* synthetic */ int lambda$reportWifiScanInfo$1(WifiStandardData r0, WifiStandardData r1) {
        return Integer.compare(r1.getRssi(), r0.getRssi());
    }

    public void cleanup() {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
        this.mHandler.getLooper().quitSafely();
        this.mHandler = null;
    L5:
        clearAccumulatedWifiList();
        clearLatestWifiConnList();
        clearHarStateList();
        clearLatestWifiScanCountList();
        clearLatestWifiPnoStatsList();
    }

    public void clearAccumulatedWifiList() {
        Object r0 = this.scanListLock;
        monitor-enter(r0);
        this.gAccumulatedWifiList.clear();     // Catch: Throwable -> L7
        a.c(getTag(), "gAccumulatedWifiList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearHarStateList() {
        Object r0 = this.harStateListLock;
        monitor-enter(r0);
        this.gHarStateList.clear();     // Catch: Throwable -> L7
        a.c(getTag(), "gHarStateList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearLatestWifiConnList() {
        Object r0 = this.connListLock;
        monitor-enter(r0);
        this.gLatestWifiConnList.clear();     // Catch: Throwable -> L7
        this.isReadyToSendConnReport = false;     // Catch: Throwable -> L7
        a.c(getTag(), "latestWifiConnList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearLatestWifiPnoStatsList() {
        Object r0 = this.pnoStatsListLock;
        monitor-enter(r0);
        this.gLatestWifiPnoStatsList.clear();     // Catch: Throwable -> L7
        a.c(getTag(), "gLatestWifiPnoStatsList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearLatestWifiScanCountList() {
        Object r0 = this.countListLock;
        monitor-enter(r0);
        this.gLatestWifiScanCountList.clear();     // Catch: Throwable -> L7
        a.c(getTag(), "gLatestWifiScanCountList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract ReportItem createHARFeedbackReportItem(HARFeedbackInfo r1);

    public abstract ReportItem createHARStateReportItem();

    public abstract ReportItem createNearElevatorReportItem(NearElevator.InnerNearElevatorData r1);

    public abstract ReportItem createScanTuningReportItem(JSONObject r1);

    public abstract ReportItem createUserFeedbackReportItem(UserFeedbackInfo r1);

    public abstract ReportItem createWifiConnReportItem();

    public abstract ReportItem createWifiPnoStatsReportItem();

    public abstract ReportItem createWifiScanCountReportItem();

    public abstract ReportItem createWifiScanReportItem();

    public String getConnectedBssid() {
        if (isWifiConnected() == false) goto L19;
        WifiManager r0 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L20;
        WifiInfo r1 = r0.getConnectionInfo();     // Catch: Exception -> L13
        if (r1 != null) goto L9;
        return null;
    L9:
        if (r1.getBSSID() == null) goto L22;
        String r2 = r1.getBSSID();     // Catch: Exception -> L13
        if ("02:00:00:00:00:00".equals(r2) == true) goto L23;
        return r2;
    L23:
        return null;
    L22:
        return null;
    L13:
        e = move-exception;
        a.a(getTag(), "Failed to get connection info", e);
        return null;
    L20:
        return null;
    L19:
        return null;
    }

    public abstract String getTag();

    public void reportHARFeedbackInfo(HARFeedbackInfo r4) {
        a.c(getTag(), "reportHARFeedbackInfo, harFeedbackInfo: " + r4.toString());
        sendUserAwareReport(createHARFeedbackReportItem(r4));
    }

    public void reportHARStateInfo(HARStateInfo r5) {
        a.c(getTag(), "reportHARStateInfo, harStateInfo: " + r5.getValue() + "gHarStateList size=" + this.gHarStateList.size());
        Object r1 = this.harStateListLock;
        monitor-enter(r1);
        this.gHarStateList.add(r5);     // Catch: Throwable -> L9
        if (this.gHarStateList.size() < 30) goto L7;
        a.e(getTag(), "Trigger HAR state report, gHarStateList size=" + this.gHarStateList.size());     // Catch: Throwable -> L9
        sendUserAwareReport(createHARStateReportItem());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void reportNearElevatorData(NearElevator.InnerNearElevatorData r3) {
        a.c(getTag(), "reportNearElevatorData");
        sendUserAwareReport(createNearElevatorReportItem(r3));
    }

    public void reportScanCount(WifiScanCount r5) {
        if (r5 != null) goto L6;
        a.c(getTag(), "wifiScanList is empty or null, skip");
        return;
    L6:
        a.c(getTag(), "reportScanCount: " + r5.toString());
        Object r1 = this.countListLock;
        monitor-enter(r1);
        WifiScanCount r2 = new WifiScanCount(r5);     // Catch: Throwable -> L21
        this.gLatestWifiScanCountList.add(r2);     // Catch: Throwable -> L21
        a.c(getTag(), "scanCount buffered: size=" + this.gLatestWifiScanCountList.size() + " dateScanCount=" + r2.getDateScanCount() + " dateScanDropCount=" + r2.getDateScanDropCount());     // Catch: Throwable -> L21
        if (this.gLatestWifiScanCountList.size() < 1) goto L11;
        boolean r6 = true;
    L13:
        if (this.gLatestWifiScanCountList.size() <= 1) goto L15;
        this.gLatestWifiScanCountList.remove(0);     // Catch: Throwable -> L21
        goto L13
    L15:
        if (r6 == false) goto L18;
        a.c(getTag(), "Trigger wifi scan count report: size=" + this.gLatestWifiScanCountList.size() + " threshold=1");     // Catch: Throwable -> L21
        sendUserAwareReport(createWifiScanCountReportItem());     // Catch: Throwable -> L21
        String r7 = getTag();     // Catch: Throwable -> L21
        String r4 = "Trigger wifi scan count report, gLatestWifiScanCountList size=" + this.gLatestWifiScanCountList.size();     // Catch: Throwable -> L21
    L17:
        a.c(r7, r4);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L18:
        r7 = getTag();     // Catch: Throwable -> L21
        r4 = "Skip trigger wifi scan count report: size=" + this.gLatestWifiScanCountList.size() + " threshold=1";     // Catch: Throwable -> L21
        goto L17
    L11:
        r6 = false;
    L21:
        th = move-exception;
        throw th;
    }

    public void reportScanTuningResult(JSONObject r1) {
        if (r1 != null) goto L5;
        a.c(getTag(), "scan tuning payload is null, skip");
        return;
    L5:
        sendUserAwareReport(createScanTuningReportItem(r1));
    }

    public void reportUserFeedbackInfo(UserFeedbackInfo r3) {
        a.c(getTag(), "reportUserFeedbackInfo");
        sendUserAwareReport(createUserFeedbackReportItem(r3));
    }

    public void reportWifiConnInfo(WifiStandardData r5) {
        if (r5 != null) goto L5;
        a.c(getTag(), "wifiScanList is empty or null, skip");
        return;
    L5:
        Object r0 = this.connListLock;
        monitor-enter(r0);
        this.gLatestWifiConnList.add(r5);     // Catch: Throwable -> L20
        if (this.isReadyToSendConnReport == true) goto L10;
    L12:
        boolean r6 = false;
    L14:
        if (this.gLatestWifiConnList.size() <= 20) goto L16;
        this.gLatestWifiConnList.remove(0);     // Catch: Throwable -> L20
        goto L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r6 == false) goto L27;
        sendUserAwareReport(createWifiConnReportItem());
        a.c(getTag(), "Trigger wifi conn report, gLatestWifiConnList size=20");
        return;
    L27:
        return;
    L10:
        if (this.gLatestWifiConnList.size() < 20) goto L12;
        r6 = true;
    L20:
        th = move-exception;
        throw th;
    }

    public void reportWifiPnoStats(PnoStats r5) {
        if (r5 != null) goto L5;
        a.c(getTag(), "pno stats is null, skip");
        return;
    L5:
        Object r0 = this.pnoStatsListLock;
        monitor-enter(r0);
        this.gLatestWifiPnoStatsList.add(new PnoStats(r5));     // Catch: Throwable -> L18
        if (this.gLatestWifiPnoStatsList.size() < 5) goto L10;
        boolean r6 = true;
    L12:
        if (this.gLatestWifiPnoStatsList.size() <= 5) goto L14;
        this.gLatestWifiPnoStatsList.remove(0);     // Catch: Throwable -> L18
        goto L12
    L14:
        if (r6 == false) goto L16;
        sendUserAwareReport(createWifiPnoStatsReportItem());     // Catch: Throwable -> L18
        a.c(getTag(), "Trigger wifi pno stats report, size=" + this.gLatestWifiPnoStatsList.size());     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L10:
        r6 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public void reportWifiScanInfo(List<WifiStandardData> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L58:
        a.c(getTag(), "wifiScanList is empty, skip");
        return;
    L5:
        if (r7.isEmpty() == true) goto L58;
        WifiStandardData r0 = null;
        ArrayList r1 = new ArrayList(r7);
        r1.removeIf($$Lambda$CaeUserAwareReportBase$Mo5PGrrwaN4wxFCfAzQcC9qQTew.INSTANCE);
        if (getConnectedBssid() == null) goto L10;
        String r8 = getConnectedBssid();
    L11:
        this.mCurrentBssid = r8;
        if (TextUtils.isEmpty(r8) == true) goto L19;
        Iterator r9 = r1.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        WifiStandardData r2 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r9.next(), WifiStandardData.class, "com.obric.memorydata.plugin");
        if (this.mCurrentBssid.equals(r2.getBssid()) == false) goto L15;
        r0 = r2;
    L19:
        r1.sort($$Lambda$CaeUserAwareReportBase$2WQCck0FAyyy2dJe0mf_1cxsiTU.INSTANCE);
        int r10 = r1.size();
        boolean r3 = false;
        List r4 = r1;
        if (r10 <= 30) goto L23;
        r4 = r1.subList(0, 30);
    L23:
        if (isWifiConnected() == false) goto L28;
        if (r0 == null) goto L28;
        if (r4.contains(r0) == true) goto L28;
        a.c(getTag(), "add current ap into filteredList");
        r4.add(r0);
    L28:
        Object r11 = this.scanListLock;
        monitor-enter(r11);
        this.gAccumulatedWifiList.addAll(r4);     // Catch: Throwable -> L55
        if (this.gAccumulatedWifiList.size() < 300) goto L33;
        boolean r5 = true;
    L34:
        monitor-exit(r11);     // Catch: Throwable -> L55
        Handler r12 = this.mHandler;
        if (isWifiConnected() == false) goto L50;
        if (r12 == null) goto L50;
        if (r12.hasMessages(0) == true) goto L50;
        Object r13 = this.connListLock;
        monitor-enter(r13);
    L47:
        th = move-exception;
        throw th;
    L43:
        if (this.gLatestWifiConnList.size() < 30) goto L45;
        r3 = true;
    L45:
        monitor-exit(r13);     // Catch: Throwable -> L47
    L50:
        if (r3 == false) goto L52;
        sendUserAwareReportDelay(createWifiConnReportItem());
        a.c(getTag(), "Trigger wifi conn report, when scan result come");
    L52:
        if (r5 == false) goto L67;
        sendUserAwareReport(createWifiScanReportItem());
        a.c(getTag(), "Trigger wifi scan report");
        return;
    L67:
        return;
    L33:
        r5 = false;
    L55:
        th = move-exception;
        throw th;
    L10:
        r8 = "";
        goto L11
    }

    public void sendUserAwareReport(ReportItem r2) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L5;
        r0.obtainMessage(0, r2).sendToTarget();
        return;
    L5:
        a.i(getTag(), "mHandler is null, skip sending user aware report");
    }

    public void sendUserAwareReportDelay(ReportItem r3) {
        Handler r2 = this.mHandler;
        if (r2 == null) goto L6;
        r2.sendMessageDelayed(r2.obtainMessage(0, r3), 10000);
        return;
    }
}
