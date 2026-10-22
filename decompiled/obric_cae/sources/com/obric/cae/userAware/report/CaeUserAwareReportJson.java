package com.obric.cae.userAware.report;

import android.annotation.SuppressLint;
import android.content.Context;
import com.obric.cae.libs.softap.c;
import com.obric.cae.libs.useraware.ICaeUserAware;
import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.HARStateInfo;
import com.obric.cae.userAware.datacollection.UserFeedbackInfo;
import com.obric.cae.userAware.datacollection.WifiScanCount;
import com.obric.cae.wifi.WiFiDBHelper;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import ha.j;
import ha.m;
import ha.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CaeUserAwareReportJson extends CaeUserAwareReportBase {
    private static final String TAG = "CaeUserAwareReportJson";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile CaeUserAwareReportJson sInstance;
    private final Context mContext;
    private UserAwareManager mUserAwareManager;

    public class HARFeedbackReportItem extends CaeUserAwareReportBase.ReportItem {
        private final HARFeedbackInfo harFeedbackInfo;
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public HARFeedbackReportItem(CaeUserAwareReportJson r8, HARFeedbackInfo r10) {
            this.this$0 = r8;
            this.harFeedbackInfo = r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "HARFeedbackReportItem buildEvents");
            s r8 = new s();
            s r10 = new s();
            r10.m("timeStamp", Long.valueOf(this.harFeedbackInfo.getTimeStamp()));
            r10.m("stateCode", Integer.valueOf(this.harFeedbackInfo.getStateCode()));
            r10.m("userChoice", Integer.valueOf(this.harFeedbackInfo.getUserChoice()));
            r8.m("featureId", 94);
            r8.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r8.k("harUserAware", r10);
            String r11 = new j().i(r8);
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_HAR_FEEDBACK_INFO, r11);
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "HAR_feedback_info report data complete and send to callback");
        }
    }

    public class HARStateReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public HARStateReportItem(CaeUserAwareReportJson r8) {
            this.this$0 = r8;
        }

        private m getHarStateArray() {
            m r8 = new m();
            Object r10 = this.this$0.countListLock;
            monitor-enter(r10);
            ArrayList r11 = new ArrayList(this.this$0.gHarStateList);     // Catch: Throwable -> L11
            monitor-exit(r10);     // Catch: Throwable -> L11
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            HARStateInfo r13 = (HARStateInfo) r12.next();
            s r14 = new s();
            r14.m("timeStamp", Long.valueOf(r13.getTimeStamp()));
            r14.m("stateCode", Integer.valueOf(r13.getValue()));
            r14.m("modelNumber", Integer.valueOf(r13.getModelNumber()));
            r8.k(r14);
            goto L8
        L10:
            return r8;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "HARStateReportItem buildEvents");
            s r8 = new s();
            m r10 = getHarStateArray();
            r8.m("featureId", 94);
            r8.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r8.k("harStateRaw", r10);
            String r11 = new j().i(r8);
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_HAR_STATE_INFO, r11);
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "HAR_state_info report data complete and send to callback");
            this.this$0.clearHarStateList();
        }
    }

    public class NearElevatorReportItem extends CaeUserAwareReportBase.ReportItem {
        private final NearElevator.InnerNearElevatorData data;
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public NearElevatorReportItem(CaeUserAwareReportJson r8, NearElevator.InnerNearElevatorData r10) {
            this.this$0 = r8;
            this.data = r10;
        }

        private s getPairObj(NearElevator.WifiDataPair r8) {
            s r10 = new s();
            if (r8.getNewWifiData() == null) goto L6;
            s r11 = new s();
            r11.m(WiFiDBHelper.COL_RSSI, Integer.valueOf(r8.getNewWifiData().getRssi()));
            r11.m("freq", Integer.valueOf(r8.getNewWifiData().getFreq()));
            r11.m("channelWidth", Integer.valueOf(r8.getNewWifiData().getChannelWidth()));
            r11.m("timestamp", Long.valueOf(r8.getNewWifiData().getTimestamp()));
            r10.k("newWifiScanData", r11);
        L6:
            if (r8.getAnchorWifiData() == null) goto L8;
            s r12 = new s();
            r12.m(WiFiDBHelper.COL_RSSI, Integer.valueOf(r8.getAnchorWifiData().getRssi()));
            r12.m("freq", Integer.valueOf(r8.getAnchorWifiData().getFreq()));
            r12.m("channelWidth", Integer.valueOf(r8.getAnchorWifiData().getChannelWidth()));
            r12.m("timestamp", Long.valueOf(r8.getAnchorWifiData().getTimestamp()));
            r10.k("anchorWifiData", r12);
        L8:
            return r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "NearElevatorReportItem buildEvents");
            s r8 = new s();
            s r10 = new s();
            r10.l("isInElevator", Boolean.valueOf(this.data.isInElevator()));
            r10.m("elevatorId", Integer.valueOf(this.data.getElevatorId()));
            r10.m("elevatorUpdateCnt", Integer.valueOf(this.data.getElevatorUpdateCnt()));
            m r11 = new m();
            Iterator<NearElevator.WifiDataPair> r12 = this.data.getWifiDataPairs().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.k(getPairObj(r12.next()));
            goto L4
        L6:
            r10.k("wifiDataPairs", r11);
            r8.m("featureId", Integer.valueOf(BWDLInnerConstant.LINK_RECOVERY));
            r8.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r8.k("nearElevatorReport", r10);
            String r13 = new j().i(r8);
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_NEAR_ELEVATOR_INFO, r13);
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "near_elevator_info report data complete and send to callback");
        }
    }

    public class UserFeedbackReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;
        private final UserFeedbackInfo userFeedbackInfo;

        public UserFeedbackReportItem(CaeUserAwareReportJson r8, UserFeedbackInfo r10) {
            this.this$0 = r8;
            this.userFeedbackInfo = r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "UserFeedbackReportItem buildEvents");
            s r8 = new s();
            s r10 = new s();
            r10.m("timeStamp", Long.valueOf(this.userFeedbackInfo.getTimeStamp()));
            r10.m("stateCode", Integer.valueOf(this.userFeedbackInfo.getStateCode()));
            r10.m("stateChange", Integer.valueOf(this.userFeedbackInfo.getStateChange()));
            r10.m("userChoice", Integer.valueOf(this.userFeedbackInfo.getUserChoice()));
            r8.m("featureId", 94);
            r8.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r8.k("userAwarePrecision", r10);
            String r11 = new j().i(r8);
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_USER_FEEDBACK_INFO, r11);
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "user_feedback_info report data complete and send to callback");
        }
    }

    public class WifiConnReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiConnReportItem(CaeUserAwareReportJson r8) {
            this.this$0 = r8;
        }

        private m getWifiConnArray(List<WifiStandardData> r8) {
            m r10 = new m();
            Iterator<WifiStandardData> r11 = r8.iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            WifiStandardData r12 = r11.next();
            if (r12 == null) goto L4;
            if (r12.getBssid() == null) goto L4;
            s r13 = new s();
            r13.n(WiFiDBHelper.COL_BSSID, r12.getBssid());
            r13.n("ssid", r12.getSsid());
            r13.m(WiFiDBHelper.COL_RSSI, Integer.valueOf(r12.getRssi()));
            r13.m("frequency", Integer.valueOf(r12.getFrequency()));
            r13.m("timestamp", Long.valueOf(r12.getTimestamp()));
            r13.m("authType", Integer.valueOf(r12.getAuthType()));
            r10.k(r13);
            goto L4
        L11:
            return r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "WifiConnReportItem buildEvents");
            Object r8 = this.this$0.connListLock;
            monitor-enter(r8);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiConnList.size() >= 20) goto L9;
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "WifiScanReportItem cannot buildEvents, gLatestWifiConnList size is too small, size is " + this.this$0.gLatestWifiConnList.size());     // Catch: Throwable -> L13
            monitor-exit(r8);     // Catch: Throwable -> L13
            return;
        L9:
            ArrayList r10 = new ArrayList(this.this$0.gLatestWifiConnList);     // Catch: Throwable -> L13
            monitor-exit(r8);     // Catch: Throwable -> L13
            s r11 = new s();
            m r12 = getWifiConnArray(r10);
            r11.m("featureId", 94);
            r11.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r11.k("wifiConnectionReport", r12);
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_WIFI_CONNECT_INFO, new j().i(r11));
            this.this$0.clearLatestWifiConnList();
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "wifi_conn_info report data complete and send to callback");
        }
    }

    public class WifiPnoStatsReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiPnoStatsReportItem(CaeUserAwareReportJson r8) {
            this.this$0 = r8;
        }

        private m getWifiPnoStatsArray(List<CaeUserAwareReportBase.PnoStats> r8) {
            m r10 = new m();
            Iterator<CaeUserAwareReportBase.PnoStats> r11 = r8.iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            CaeUserAwareReportBase.PnoStats r12 = r11.next();
            if (r12 == null) goto L4;
            s r13 = new s();
            r13.m("timeStamp", Long.valueOf(r12.getTimeStamp()));
            r13.m("event", Integer.valueOf(r12.getEvent()));
            r13.m("startWallClockMs", Long.valueOf(r12.getStartWallClockMs()));
            r13.m("stopWallClockMs", Long.valueOf(r12.getStopWallClockMs()));
            r13.m("durationMs", Long.valueOf(r12.getDurationMs()));
            r13.m("periodMs", Integer.valueOf(r12.getPeriodMs()));
            r13.m("estimatedRounds", Integer.valueOf(r12.getEstimatedRounds()));
            r13.m("totalDurationTodayMs", Long.valueOf(r12.getTotalDurationTodayMs()));
            r13.m("sessionCountToday", Integer.valueOf(r12.getSessionCountToday()));
            r13.m("estimatedRoundsToday", Integer.valueOf(r12.getEstimatedRoundsToday()));
            r10.k(r13);
            goto L4
        L9:
            return r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "WifiPnoStatsReportItem buildEvents");
            Object r8 = this.this$0.pnoStatsListLock;
            monitor-enter(r8);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiPnoStatsList.size() >= 5) goto L9;
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "WifiPnoStatsReportItem cannot buildEvents, size=" + this.this$0.gLatestWifiPnoStatsList.size());     // Catch: Throwable -> L13
            monitor-exit(r8);     // Catch: Throwable -> L13
            return;
        L9:
            ArrayList r10 = new ArrayList(this.this$0.gLatestWifiPnoStatsList);     // Catch: Throwable -> L13
            monitor-exit(r8);     // Catch: Throwable -> L13
            s r11 = new s();
            m r12 = getWifiPnoStatsArray(r10);
            r11.m("featureId", 94);
            r11.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r11.n("wifiPnoStatsReport", r12.toString());
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_WIFI_PNO_STATS, new j().i(r11));
            this.this$0.clearLatestWifiPnoStatsList();
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "wifi_pno_stats report data complete and send to callback");
        }
    }

    public class WifiScanCountReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiScanCountReportItem(CaeUserAwareReportJson r8) {
            this.this$0 = r8;
        }

        private m getWifiScanCountArray(List<WifiScanCount> r8) {
            m r10 = new m();
            Iterator<WifiScanCount> r11 = r8.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            WifiScanCount r12 = r11.next();
            s r13 = new s();
            r13.m("timeStamp", Long.valueOf(r12.getTimeStamp()));
            r13.m("scanType", Integer.valueOf(r12.getScanType()));
            r13.m("sceneType", Integer.valueOf(r12.getSceneType()));
            r13.m("dateScanCount", Integer.valueOf(r12.getDateScanCount()));
            r13.m("dateScanDropCount", Integer.valueOf(r12.getDateScanDropCount()));
            r10.k(r13);
            goto L4
        L6:
            return r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "WifiScanCountReportItem buildEvents");
            Object r8 = this.this$0.countListLock;
            monitor-enter(r8);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiScanCountList.size() >= 5) goto L9;
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "WifiScanCountReportItem cannot buildEvents, gLatestWifiScanCountList size is too small, size is " + this.this$0.gLatestWifiScanCountList.size());     // Catch: Throwable -> L13
            monitor-exit(r8);     // Catch: Throwable -> L13
            return;
        L9:
            ArrayList r10 = new ArrayList(this.this$0.gLatestWifiScanCountList);     // Catch: Throwable -> L13
            monitor-exit(r8);     // Catch: Throwable -> L13
            s r11 = new s();
            m r12 = getWifiScanCountArray(r10);
            r11.m("featureId", 94);
            r11.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r11.n("wifiScanCountReport", r12.toString());
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_WIFI_SCAN_COUNT, new j().i(r11));
            this.this$0.clearLatestWifiScanCountList();
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "wifi_scan_count report data complete and send to callback");
        }
    }

    public class WifiScanReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiScanReportItem(CaeUserAwareReportJson r8) {
            this.this$0 = r8;
        }

        private m getWifiScanArray(List<WifiStandardData> r8) {
            m r10 = new m();
            Iterator<WifiStandardData> r11 = r8.iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            WifiStandardData r12 = r11.next();
            if (r12 == null) goto L4;
            if (r12.getBssid() == null) goto L4;
            s r13 = new s();
            r13.n(WiFiDBHelper.COL_BSSID, r12.getBssid());
            r13.n("ssid", r12.getSsid());
            r13.m(WiFiDBHelper.COL_RSSI, Integer.valueOf(r12.getRssi()));
            r13.m("frequency", Integer.valueOf(r12.getFrequency()));
            r13.m("timestamp", Long.valueOf(r12.getTimestamp()));
            r13.m("authType", Integer.valueOf(r12.getAuthType()));
            r10.k(r13);
            goto L4
        L11:
            return r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CommSenseLog.d(CaeUserAwareReportJson.access$000(), "WifiScanReportItem buildEvents");
            Object r8 = this.this$0.scanListLock;
            monitor-enter(r8);
            ArrayList r10 = new ArrayList(this.this$0.gAccumulatedWifiList);     // Catch: Throwable -> L8
            this.this$0.isReadyToSendConnReport = true;     // Catch: Throwable -> L8
            monitor-exit(r8);     // Catch: Throwable -> L8
            s r11 = new s();
            m r12 = getWifiScanArray(r10);
            r11.m("featureId", 94);
            r11.m("timestamp", Long.valueOf(System.currentTimeMillis()));
            r11.k("wifiScanReport", r12);
            String r13 = new j().i(r11);
            CaeUserAwareReportJson.access$100(this.this$0, ICaeUserAware.USER_AWARE_REPORT_WIFI_SCAN_INFO, r13);
            this.this$0.clearAccumulatedWifiList();
            CommSenseLog.i(CaeUserAwareReportJson.access$000(), "wifi_scan_info report data complete and send to callback");
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private CaeUserAwareReportJson(Context r8) {
        super(r8);
        this.mContext = r8;
        CommSenseLog.d(TAG, "start report json");
        this.mUserAwareManager = UserAwareManager.getInstance();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(CaeUserAwareReportJson r8, String r10, String r11) {
        r8.notifyCallback(r10, r11);
    }

    public static /* synthetic */ void c(String r8, String r10, ICaeUserAwareCallback r11, Object r12) {
        lambda$notifyCallback$0(r8, r10, r11, r12);
    }

    public static CaeUserAwareReportJson getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(CaeUserAwareReportJson.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CaeUserAwareReportJson(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeUserAwareReportJson.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static /* synthetic */ void lambda$notifyCallback$0(String r8, String r10, ICaeUserAwareCallback r11, Object r12) {
        r11.onUserAwareReportData(r8, r10);
    }

    private void notifyCallback(String r8, String r10) {
        if (this.mUserAwareManager != null) goto L10;
        CommSenseLog.w(TAG, "UserAwareManager is not available, skipping notification");
        return;
    L10:
        CommSenseLog.d(TAG, "notifyCallback: eventName -- " + r8 + ", jsonData -- " + r10);     // Catch: Exception -> L6
        this.mUserAwareManager.notifyCallbacks(new c(2, r8, r10), new Object());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        CommSenseLog.e(TAG, "Error calling user aware report callback", e);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public void cleanup() {
        super.cleanup();
        this.mUserAwareManager = null;
        sInstance = null;
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createHARFeedbackReportItem(HARFeedbackInfo r8) {
        return new HARFeedbackReportItem(this, r8);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createHARStateReportItem() {
        return new HARStateReportItem(this);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createNearElevatorReportItem(NearElevator.InnerNearElevatorData r8) {
        return new NearElevatorReportItem(this, r8);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createUserFeedbackReportItem(UserFeedbackInfo r8) {
        return new UserFeedbackReportItem(this, r8);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createWifiConnReportItem() {
        return new WifiConnReportItem(this);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createWifiPnoStatsReportItem() {
        return new WifiPnoStatsReportItem(this);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createWifiScanCountReportItem() {
        return new WifiScanCountReportItem(this);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createWifiScanReportItem() {
        return new WifiScanReportItem(this);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public String getTag() {
        return TAG;
    }
}
