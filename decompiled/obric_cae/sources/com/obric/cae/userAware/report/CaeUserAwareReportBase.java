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
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.HARStateInfo;
import com.obric.cae.userAware.datacollection.UserFeedbackInfo;
import com.obric.cae.userAware.datacollection.WifiScanCount;
import g0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CaeUserAwareReportBase {
    protected static final int CAE_CONN_INFO_REPORT_INTERVAL = 10000;
    protected static final int CAE_NEAR_ELEVATOR_EVENT_FEATURE_ID = 112;
    protected static final int CAE_USER_AWARE_SERVICE_EVENT_FEATURE_ID = 94;
    protected static final int MAX_HAR_STATE_RAW_DATA_SIZE = 30;
    protected static final int MAX_WIFI_CONN_REPORT_SIZE = 20;
    protected static final int MAX_WIFI_PNO_STATS_REPORT_SIZE = 5;
    protected static final int MAX_WIFI_SCAN_COUNT_REPORT_SIZE = 5;
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

        public PnoStats(PnoStats r8) {
            if (r8 != null) goto L5;
            return;
        L5:
            this.mTimeStamp = r8.mTimeStamp;
            this.mEvent = r8.mEvent;
            this.mStartWallClockMs = r8.mStartWallClockMs;
            this.mStopWallClockMs = r8.mStopWallClockMs;
            this.mDurationMs = r8.mDurationMs;
            this.mPeriodMs = r8.mPeriodMs;
            this.mEstimatedRounds = r8.mEstimatedRounds;
            this.mTotalDurationTodayMs = r8.mTotalDurationTodayMs;
            this.mSessionCountToday = r8.mSessionCountToday;
            this.mEstimatedRoundsToday = r8.mEstimatedRoundsToday;
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

        public void setDurationMs(long r8) {
            this.mDurationMs = r8;
        }

        public void setEstimatedRounds(int r8) {
            this.mEstimatedRounds = r8;
        }

        public void setEstimatedRoundsToday(int r8) {
            this.mEstimatedRoundsToday = r8;
        }

        public void setEvent(int r8) {
            this.mEvent = r8;
        }

        public void setPeriodMs(int r8) {
            this.mPeriodMs = r8;
        }

        public void setSessionCountToday(int r8) {
            this.mSessionCountToday = r8;
        }

        public void setStartWallClockMs(long r8) {
            this.mStartWallClockMs = r8;
        }

        public void setStopWallClockMs(long r8) {
            this.mStopWallClockMs = r8;
        }

        public void setTimeStamp(long r8) {
            this.mTimeStamp = r8;
        }

        public void setTotalDurationTodayMs(long r8) {
            this.mTotalDurationTodayMs = r8;
        }
    }

    public static abstract class ReportItem {
        public ReportItem() {
        }

        public abstract void buildEvents();
    }

    public class ReportQueueProcessHandler extends Handler {
        final /* synthetic */ CaeUserAwareReportBase this$0;

        public ReportQueueProcessHandler(CaeUserAwareReportBase r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            if (r8.what != 0) goto L6;
            ((ReportItem) r8.obj).buildEvents();
            return;
        }
    }

    public CaeUserAwareReportBase(Context r8) {
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
        this.mContext = r8;
        initHandler();
        mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
    }

    public static /* synthetic */ int a(WifiStandardData r8, WifiStandardData r10) {
        return lambda$reportWifiScanInfo$1(r8, r10);
    }

    public static /* synthetic */ boolean b(WifiStandardData r8) {
        return lambda$reportWifiScanInfo$0(r8);
    }

    private void initHandler() {
        HandlerThread r8 = new HandlerThread("cae_user_aware_report");
        r8.start();
        this.mHandler = new ReportQueueProcessHandler(this, r8.getLooper());
    }

    public static boolean isWifiConnected() {
        ConnectivityManager r8 = mConnectivityManager;
        if (r8 == null) goto L12;
        NetworkCapabilities r10 = r8.getNetworkCapabilities(r8.getActiveNetwork());
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.hasTransport(1) == true) goto L9;
        return false;
    L9:
        if (r10.hasCapability(12) == true) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    private static /* synthetic */ boolean lambda$reportWifiScanInfo$0(WifiStandardData r8) {
        if (r8 != null) goto L4;
    L9:
        return true;
    L4:
        if (r8.getSsid() == null) goto L9;
        if (r8.getSsid().isEmpty() == true) goto L9;
        return false;
    }

    private static /* synthetic */ int lambda$reportWifiScanInfo$1(WifiStandardData r8, WifiStandardData r10) {
        return Integer.compare(r10.getRssi(), r8.getRssi());
    }

    public void cleanup() {
        Handler r8 = this.mHandler;
        if (r8 == null) goto L5;
        r8.removeCallbacksAndMessages(null);
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
        Object r8 = this.scanListLock;
        monitor-enter(r8);
        this.gAccumulatedWifiList.clear();     // Catch: Throwable -> L7
        CommSenseLog.d(getTag(), "gAccumulatedWifiList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearHarStateList() {
        Object r8 = this.harStateListLock;
        monitor-enter(r8);
        this.gHarStateList.clear();     // Catch: Throwable -> L7
        CommSenseLog.d(getTag(), "gHarStateList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearLatestWifiConnList() {
        Object r8 = this.connListLock;
        monitor-enter(r8);
        this.gLatestWifiConnList.clear();     // Catch: Throwable -> L7
        this.isReadyToSendConnReport = false;     // Catch: Throwable -> L7
        CommSenseLog.d(getTag(), "latestWifiConnList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearLatestWifiPnoStatsList() {
        Object r8 = this.pnoStatsListLock;
        monitor-enter(r8);
        this.gLatestWifiPnoStatsList.clear();     // Catch: Throwable -> L7
        CommSenseLog.d(getTag(), "gLatestWifiPnoStatsList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearLatestWifiScanCountList() {
        Object r8 = this.countListLock;
        monitor-enter(r8);
        this.gLatestWifiScanCountList.clear();     // Catch: Throwable -> L7
        CommSenseLog.d(getTag(), "gLatestWifiScanCountList cleared safely");     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract ReportItem createHARFeedbackReportItem(HARFeedbackInfo r8);

    public abstract ReportItem createHARStateReportItem();

    public abstract ReportItem createNearElevatorReportItem(NearElevator.InnerNearElevatorData r8);

    public abstract ReportItem createUserFeedbackReportItem(UserFeedbackInfo r8);

    public abstract ReportItem createWifiConnReportItem();

    public abstract ReportItem createWifiPnoStatsReportItem();

    public abstract ReportItem createWifiScanCountReportItem();

    public abstract ReportItem createWifiScanReportItem();

    public String getConnectedBssid() {
        if (isWifiConnected() == false) goto L19;
        WifiManager r8 = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
        if (r8 == null) goto L20;
        WifiInfo r10 = r8.getConnectionInfo();     // Catch: Exception -> L13
        if (r10 != null) goto L9;
        return null;
    L9:
        if (r10.getBSSID() == null) goto L22;
        String r11 = r10.getBSSID();     // Catch: Exception -> L13
        if ("02:00:00:00:00:00".equals(r11) == true) goto L23;
        return r11;
    L23:
        return null;
    L22:
        return null;
    L13:
        e = move-exception;
        CommSenseLog.e(getTag(), "Failed to get connection info", e);
        return null;
    L20:
        return null;
    L19:
        return null;
    }

    public abstract String getTag();

    public void reportHARFeedbackInfo(HARFeedbackInfo r8) {
        CommSenseLog.d(getTag(), "reportHARFeedbackInfo, harFeedbackInfo: " + r8.toString());
        sendUserAwareReport(createHARFeedbackReportItem(r8));
    }

    public void reportHARStateInfo(HARStateInfo r8) {
        CommSenseLog.d(getTag(), "reportHARStateInfo, harStateInfo: " + r8.getValue() + "gHarStateList size=" + this.gHarStateList.size());
        Object r10 = this.harStateListLock;
        monitor-enter(r10);
        this.gHarStateList.add(r8);     // Catch: Throwable -> L9
        if (this.gHarStateList.size() < 30) goto L7;
        CommSenseLog.i(getTag(), "Trigger HAR state report, gHarStateList size=" + this.gHarStateList.size());     // Catch: Throwable -> L9
        sendUserAwareReport(createHARStateReportItem());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void reportNearElevatorData(NearElevator.InnerNearElevatorData r8) {
        CommSenseLog.d(getTag(), "reportNearElevatorData");
        sendUserAwareReport(createNearElevatorReportItem(r8));
    }

    public void reportScanCount(WifiScanCount r8) {
        if (r8 != null) goto L6;
        CommSenseLog.d(getTag(), "wifiScanList is empty or null, skip");
        return;
    L6:
        CommSenseLog.d(getTag(), "reportScanCount: " + r8.toString());
        Object r10 = this.countListLock;
        monitor-enter(r10);
        WifiScanCount r11 = new WifiScanCount(r8);     // Catch: Throwable -> L21
        this.gLatestWifiScanCountList.add(r11);     // Catch: Throwable -> L21
        CommSenseLog.d(getTag(), "scanCount buffered: size=" + this.gLatestWifiScanCountList.size() + " dateScanCount=" + r11.getDateScanCount() + " dateScanDropCount=" + r11.getDateScanDropCount());     // Catch: Throwable -> L21
        if (this.gLatestWifiScanCountList.size() < 5) goto L11;
        boolean r12 = true;
    L13:
        if (this.gLatestWifiScanCountList.size() <= 5) goto L15;
        this.gLatestWifiScanCountList.remove(0);     // Catch: Throwable -> L21
        goto L13
    L15:
        if (r12 == false) goto L18;
        CommSenseLog.d(getTag(), "Trigger wifi scan count report: size=" + this.gLatestWifiScanCountList.size() + " threshold=5");     // Catch: Throwable -> L21
        sendUserAwareReport(createWifiScanCountReportItem());     // Catch: Throwable -> L21
        String r13 = getTag();     // Catch: Throwable -> L21
        String r14 = "Trigger wifi scan count report, gLatestWifiScanCountList size=" + this.gLatestWifiScanCountList.size();     // Catch: Throwable -> L21
    L17:
        CommSenseLog.d(r13, r14);     // Catch: Throwable -> L21
        monitor-exit(r10);     // Catch: Throwable -> L21
        return;
    L18:
        r13 = getTag();     // Catch: Throwable -> L21
        r14 = "Skip trigger wifi scan count report: size=" + this.gLatestWifiScanCountList.size() + " threshold=5";     // Catch: Throwable -> L21
        goto L17
    L11:
        r12 = false;
    L21:
        th = move-exception;
        throw th;
    }

    public void reportUserFeedbackInfo(UserFeedbackInfo r8) {
        CommSenseLog.d(getTag(), "reportUserFeedbackInfo");
        sendUserAwareReport(createUserFeedbackReportItem(r8));
    }

    public void reportWifiConnInfo(WifiStandardData r8) {
        if (r8 != null) goto L5;
        CommSenseLog.d(getTag(), "wifiScanList is empty or null, skip");
        return;
    L5:
        Object r10 = this.connListLock;
        monitor-enter(r10);
        this.gLatestWifiConnList.add(r8);     // Catch: Throwable -> L20
        if (this.isReadyToSendConnReport == true) goto L10;
    L12:
        boolean r11 = false;
    L14:
        if (this.gLatestWifiConnList.size() <= 20) goto L16;
        this.gLatestWifiConnList.remove(0);     // Catch: Throwable -> L20
        goto L14
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L20
        if (r11 == false) goto L27;
        sendUserAwareReport(createWifiConnReportItem());
        CommSenseLog.d(getTag(), "Trigger wifi conn report, gLatestWifiConnList size=20");
        return;
    L27:
        return;
    L10:
        if (this.gLatestWifiConnList.size() < 20) goto L12;
        r11 = true;
    L20:
        th = move-exception;
        throw th;
    }

    public void reportWifiPnoStats(PnoStats r8) {
        if (r8 != null) goto L5;
        CommSenseLog.d(getTag(), "pno stats is null, skip");
        return;
    L5:
        Object r10 = this.pnoStatsListLock;
        monitor-enter(r10);
        this.gLatestWifiPnoStatsList.add(new PnoStats(r8));     // Catch: Throwable -> L18
        if (this.gLatestWifiPnoStatsList.size() < 5) goto L10;
        boolean r11 = true;
    L12:
        if (this.gLatestWifiPnoStatsList.size() <= 5) goto L14;
        this.gLatestWifiPnoStatsList.remove(0);     // Catch: Throwable -> L18
        goto L12
    L14:
        if (r11 == false) goto L16;
        sendUserAwareReport(createWifiPnoStatsReportItem());     // Catch: Throwable -> L18
        CommSenseLog.d(getTag(), "Trigger wifi pno stats report, size=" + this.gLatestWifiPnoStatsList.size());     // Catch: Throwable -> L18
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L10:
        r11 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public void reportWifiScanInfo(List<WifiStandardData> r8) {
        if (r8 != null) goto L4;
    L58:
        CommSenseLog.d(getTag(), "wifiScanList is empty, skip");
        return;
    L4:
        if (r8.isEmpty() == true) goto L58;
        ArrayList r10 = new ArrayList(r8);
        r10.removeIf(new a());
        if (getConnectedBssid() == null) goto L9;
        String r11 = getConnectedBssid();
    L10:
        this.mCurrentBssid = r11;
        if (TextUtils.isEmpty(r11) == true) goto L18;
        Iterator r12 = r10.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        WifiStandardData r13 = (WifiStandardData) r12.next();
        if (this.mCurrentBssid.equals(r13.getBssid()) == false) goto L14;
    L19:
        r10.sort(new d(3));
        int r14 = r10.size();
        boolean r15 = false;
        List r16 = r10;
        if (r14 <= 30) goto L23;
        r16 = r10.subList(0, 30);
    L23:
        if (isWifiConnected() == false) goto L28;
        if (r13 == null) goto L28;
        if (r16.contains(r13) == true) goto L28;
        CommSenseLog.d(getTag(), "add current ap into filteredList");
        r16.add(r13);
    L28:
        Object r17 = this.scanListLock;
        monitor-enter(r17);
        this.gAccumulatedWifiList.addAll(r16);     // Catch: Throwable -> L55
        if (this.gAccumulatedWifiList.size() < 300) goto L33;
        boolean r18 = true;
    L34:
        monitor-exit(r17);     // Catch: Throwable -> L55
        Handler r19 = this.mHandler;
        if (isWifiConnected() == false) goto L50;
        if (r19 == null) goto L50;
        if (r19.hasMessages(0) == true) goto L50;
        Object r20 = this.connListLock;
        monitor-enter(r20);
    L47:
        th = move-exception;
        throw th;
    L43:
        if (this.gLatestWifiConnList.size() < 30) goto L45;
        r15 = true;
    L45:
        monitor-exit(r20);     // Catch: Throwable -> L47
    L50:
        if (r15 == false) goto L52;
        sendUserAwareReportDelay(createWifiConnReportItem());
        CommSenseLog.d(getTag(), "Trigger wifi conn report, when scan result come");
    L52:
        if (r18 == false) goto L67;
        sendUserAwareReport(createWifiScanReportItem());
        CommSenseLog.d(getTag(), "Trigger wifi scan report");
        return;
    L67:
        return;
    L33:
        r18 = false;
    L55:
        th = move-exception;
        throw th;
    L18:
        r13 = null;
        goto L19
    L9:
        r11 = "";
        goto L10
    }

    public void sendUserAwareReport(ReportItem r8) {
        Handler r10 = this.mHandler;
        if (r10 == null) goto L5;
        r10.obtainMessage(0, r8).sendToTarget();
        return;
    L5:
        CommSenseLog.e(getTag(), "mHandler is null, skip sending user aware report");
    }

    public void sendUserAwareReportDelay(ReportItem r8) {
        Handler r10 = this.mHandler;
        if (r10 == null) goto L6;
        r10.sendMessageDelayed(r10.obtainMessage(0, r8), 10000);
        return;
    }
}
