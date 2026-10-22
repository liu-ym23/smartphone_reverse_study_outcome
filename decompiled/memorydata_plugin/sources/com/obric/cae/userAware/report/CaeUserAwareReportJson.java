package com.obric.cae.userAware.report;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.libs.useraware.d;
import com.obric.cae.log.a;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.UserAwareManager;
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
public class CaeUserAwareReportJson extends CaeUserAwareReportBase {
    private static final String TAG = "CaeUserAwareReportJson";
    private static volatile CaeUserAwareReportJson sInstance;
    private final Context mContext;
    private UserAwareManager mUserAwareManager;

    public class HARFeedbackReportItem extends CaeUserAwareReportBase.ReportItem {
        private final HARFeedbackInfo harFeedbackInfo;
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public HARFeedbackReportItem(CaeUserAwareReportJson r1, HARFeedbackInfo r2) {
            this.this$0 = r1;
            this.harFeedbackInfo = r2;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "HARFeedbackReportItem buildEvents");
            JsonObject r0 = new JsonObject();
            JsonObject r1 = new JsonObject();
            r1.addProperty("timeStamp", Long.valueOf(this.harFeedbackInfo.getTimeStamp()));
            r1.addProperty("stateCode", Integer.valueOf(this.harFeedbackInfo.getStateCode()));
            r1.addProperty("userChoice", Integer.valueOf(this.harFeedbackInfo.getUserChoice()));
            r0.addProperty("featureId", 94);
            r0.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r0.add("harUserAware", r1);
            String r2 = new Gson().toJson(r0);
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_HAR_feedback_info", r2);
            a.e(CaeUserAwareReportJson.access$000(), "HAR_feedback_info report data complete and send to callback");
        }
    }

    public class HARStateReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public HARStateReportItem(CaeUserAwareReportJson r1) {
            this.this$0 = r1;
        }

        private JsonArray getHarStateArray() {
            JsonArray r0 = new JsonArray();
            Object r1 = this.this$0.countListLock;
            monitor-enter(r1);
            ArrayList r2 = new ArrayList(this.this$0.gHarStateList);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            Iterator r5 = r2.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            HARStateInfo r3 = (HARStateInfo) ZeusTransformUtils.preCheckCast(r5.next(), HARStateInfo.class, "com.obric.memorydata.plugin");
            JsonObject r4 = new JsonObject();
            r4.addProperty("timeStamp", Long.valueOf(r3.getTimeStamp()));
            r4.addProperty("stateCode", Integer.valueOf(r3.getValue()));
            r4.addProperty("modelNumber", Integer.valueOf(r3.getModelNumber()));
            r0.add(r4);
            goto L8
        L10:
            return r0;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "HARStateReportItem buildEvents");
            JsonObject r0 = new JsonObject();
            JsonArray r1 = getHarStateArray();
            r0.addProperty("featureId", 94);
            r0.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r0.add("harStateRaw", r1);
            String r2 = new Gson().toJson(r0);
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_HAR_state_info", r2);
            a.e(CaeUserAwareReportJson.access$000(), "HAR_state_info report data complete and send to callback");
            this.this$0.clearHarStateList();
        }
    }

    public class NearElevatorReportItem extends CaeUserAwareReportBase.ReportItem {
        private final NearElevator.InnerNearElevatorData data;
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public NearElevatorReportItem(CaeUserAwareReportJson r1, NearElevator.InnerNearElevatorData r2) {
            this.this$0 = r1;
            this.data = r2;
        }

        private JsonObject getPairObj(NearElevator.WifiDataPair r8) {
            JsonObject r7 = new JsonObject();
            if (r8.getNewWifiData() == null) goto L6;
            JsonObject r0 = new JsonObject();
            r0.addProperty("rssi", Integer.valueOf(r8.getNewWifiData().getRssi()));
            r0.addProperty("freq", Integer.valueOf(r8.getNewWifiData().getFreq()));
            r0.addProperty("channelWidth", Integer.valueOf(r8.getNewWifiData().getChannelWidth()));
            r0.addProperty("timestamp", Long.valueOf(r8.getNewWifiData().getTimestamp()));
            r7.add("newWifiScanData", r0);
        L6:
            if (r8.getAnchorWifiData() == null) goto L8;
            JsonObject r1 = new JsonObject();
            r1.addProperty("rssi", Integer.valueOf(r8.getAnchorWifiData().getRssi()));
            r1.addProperty("freq", Integer.valueOf(r8.getAnchorWifiData().getFreq()));
            r1.addProperty("channelWidth", Integer.valueOf(r8.getAnchorWifiData().getChannelWidth()));
            r1.addProperty("timestamp", Long.valueOf(r8.getAnchorWifiData().getTimestamp()));
            r7.add("anchorWifiData", r1);
        L8:
            return r7;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "NearElevatorReportItem buildEvents");
            JsonObject r0 = new JsonObject();
            JsonObject r1 = new JsonObject();
            r1.addProperty("isInElevator", Boolean.valueOf(this.data.isInElevator()));
            r1.addProperty("elevatorId", Integer.valueOf(this.data.getElevatorId()));
            r1.addProperty("elevatorUpdateCnt", Integer.valueOf(this.data.getElevatorUpdateCnt()));
            JsonArray r2 = new JsonArray();
            Iterator<NearElevator.WifiDataPair> r3 = this.data.getWifiDataPairs().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r2.add(getPairObj((NearElevator.WifiDataPair) ZeusTransformUtils.preCheckCast(r3.next(), NearElevator.WifiDataPair.class, "com.obric.memorydata.plugin")));
            goto L4
        L6:
            r1.add("wifiDataPairs", r2);
            r0.addProperty("featureId", 112);
            r0.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r0.add("nearElevatorReport", r1);
            String r4 = new Gson().toJson(r0);
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_near_elevator_info", r4);
            a.e(CaeUserAwareReportJson.access$000(), "near_elevator_info report data complete and send to callback");
        }
    }

    public class ScanTuningReportItem extends CaeUserAwareReportBase.ReportItem {
        private final JSONObject mPayload;
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public ScanTuningReportItem(CaeUserAwareReportJson r1, JSONObject r2) {
            this.this$0 = r1;
            this.mPayload = r2;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "ScanTuningReportItem buildEvents");
            CaeUserAwareReportJson.access$100(this.this$0, CaeUserAwareReportBase.EVENT_WIFI_SCAN_TUNE, this.mPayload.toString());
            a.e(CaeUserAwareReportJson.access$000(), "scan tuning report data complete and send to callback");
        }
    }

    public class UserFeedbackReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;
        private final UserFeedbackInfo userFeedbackInfo;

        public UserFeedbackReportItem(CaeUserAwareReportJson r1, UserFeedbackInfo r2) {
            this.this$0 = r1;
            this.userFeedbackInfo = r2;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "UserFeedbackReportItem buildEvents");
            JsonObject r0 = new JsonObject();
            JsonObject r1 = new JsonObject();
            r1.addProperty("timeStamp", Long.valueOf(this.userFeedbackInfo.getTimeStamp()));
            r1.addProperty("stateCode", Integer.valueOf(this.userFeedbackInfo.getStateCode()));
            r1.addProperty("stateChange", Integer.valueOf(this.userFeedbackInfo.getStateChange()));
            r1.addProperty("userChoice", Integer.valueOf(this.userFeedbackInfo.getUserChoice()));
            r0.addProperty("featureId", 94);
            r0.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r0.add("userAwarePrecision", r1);
            String r2 = new Gson().toJson(r0);
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_user_feedback_info", r2);
            a.e(CaeUserAwareReportJson.access$000(), "user_feedback_info report data complete and send to callback");
        }
    }

    public class WifiConnReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiConnReportItem(CaeUserAwareReportJson r1) {
            this.this$0 = r1;
        }

        private JsonArray getWifiConnArray(List<WifiStandardData> r6) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            JsonArray r7 = new JsonArray();
            Iterator r8 = r5.iterator();
        L4:
            if (r8.hasNext() == false) goto L11;
            WifiStandardData r1 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r8.next(), WifiStandardData.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L4;
            if (r1.getBssid() == null) goto L4;
            JsonObject r2 = new JsonObject();
            r2.addProperty("bssid", r1.getBssid());
            r2.addProperty(Api.KEY_SSID, r1.getSsid());
            r2.addProperty("rssi", Integer.valueOf(r1.getRssi()));
            r2.addProperty("frequency", Integer.valueOf(r1.getFrequency()));
            r2.addProperty("timestamp", Long.valueOf(r1.getTimestamp()));
            r2.addProperty("authType", Integer.valueOf(r1.getAuthType()));
            r7.add(r2);
            goto L4
        L11:
            return r7;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "WifiConnReportItem buildEvents");
            Object r1 = this.this$0.connListLock;
            monitor-enter(r1);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiConnList.size() >= 20) goto L9;
            a.c(CaeUserAwareReportJson.access$000(), "WifiScanReportItem cannot buildEvents, gLatestWifiConnList size is too small, size is " + this.this$0.gLatestWifiConnList.size());     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L9:
            ArrayList r0 = new ArrayList(this.this$0.gLatestWifiConnList);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            JsonObject r2 = new JsonObject();
            JsonArray r3 = getWifiConnArray(r0);
            r2.addProperty("featureId", 94);
            r2.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r2.add("wifiConnectionReport", r3);
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_wifi_conn_info", new Gson().toJson(r2));
            this.this$0.clearLatestWifiConnList();
            a.e(CaeUserAwareReportJson.access$000(), "wifi_conn_info report data complete and send to callback");
        }
    }

    public class WifiPnoStatsReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiPnoStatsReportItem(CaeUserAwareReportJson r1) {
            this.this$0 = r1;
        }

        private JsonArray getWifiPnoStatsArray(List<CaeUserAwareReportBase.PnoStats> r6) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            JsonArray r7 = new JsonArray();
            Iterator r8 = r5.iterator();
        L4:
            if (r8.hasNext() == false) goto L9;
            CaeUserAwareReportBase.PnoStats r1 = (CaeUserAwareReportBase.PnoStats) ZeusTransformUtils.preCheckCast(r8.next(), CaeUserAwareReportBase.PnoStats.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L4;
            JsonObject r2 = new JsonObject();
            r2.addProperty("timeStamp", Long.valueOf(r1.getTimeStamp()));
            r2.addProperty("event", Integer.valueOf(r1.getEvent()));
            r2.addProperty("startWallClockMs", Long.valueOf(r1.getStartWallClockMs()));
            r2.addProperty("stopWallClockMs", Long.valueOf(r1.getStopWallClockMs()));
            r2.addProperty("durationMs", Long.valueOf(r1.getDurationMs()));
            r2.addProperty("periodMs", Integer.valueOf(r1.getPeriodMs()));
            r2.addProperty("estimatedRounds", Integer.valueOf(r1.getEstimatedRounds()));
            r2.addProperty("totalDurationTodayMs", Long.valueOf(r1.getTotalDurationTodayMs()));
            r2.addProperty("sessionCountToday", Integer.valueOf(r1.getSessionCountToday()));
            r2.addProperty("estimatedRoundsToday", Integer.valueOf(r1.getEstimatedRoundsToday()));
            r7.add(r2);
            goto L4
        L9:
            return r7;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "WifiPnoStatsReportItem buildEvents");
            Object r1 = this.this$0.pnoStatsListLock;
            monitor-enter(r1);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiPnoStatsList.size() >= 5) goto L9;
            a.c(CaeUserAwareReportJson.access$000(), "WifiPnoStatsReportItem cannot buildEvents, size=" + this.this$0.gLatestWifiPnoStatsList.size());     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L9:
            ArrayList r0 = new ArrayList(this.this$0.gLatestWifiPnoStatsList);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            JsonObject r2 = new JsonObject();
            JsonArray r3 = getWifiPnoStatsArray(r0);
            r2.addProperty("featureId", 94);
            r2.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r2.addProperty("wifiPnoStatsReport", r3.toString());
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_wifi_pno_stats", new Gson().toJson(r2));
            this.this$0.clearLatestWifiPnoStatsList();
            a.e(CaeUserAwareReportJson.access$000(), "wifi_pno_stats report data complete and send to callback");
        }
    }

    public class WifiScanCountReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiScanCountReportItem(CaeUserAwareReportJson r1) {
            this.this$0 = r1;
        }

        private JsonArray getWifiScanCountArray(List<WifiScanCount> r6) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            JsonArray r7 = new JsonArray();
            Iterator r8 = r5.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            WifiScanCount r1 = (WifiScanCount) ZeusTransformUtils.preCheckCast(r8.next(), WifiScanCount.class, "com.obric.memorydata.plugin");
            JsonObject r2 = new JsonObject();
            r2.addProperty("timeStamp", Long.valueOf(r1.getTimeStamp()));
            r2.addProperty("scanType", Integer.valueOf(r1.getScanType()));
            r2.addProperty("sceneType", Integer.valueOf(r1.getSceneType()));
            r2.addProperty("dateScanCount", Integer.valueOf(r1.getDateScanCount()));
            r2.addProperty("dateScanDropCount", Integer.valueOf(r1.getDateScanDropCount()));
            r7.add(r2);
            goto L4
        L6:
            return r7;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "WifiScanCountReportItem buildEvents");
            Object r1 = this.this$0.countListLock;
            monitor-enter(r1);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiScanCountList.size() >= 1) goto L9;
            a.c(CaeUserAwareReportJson.access$000(), "WifiScanCountReportItem cannot buildEvents, gLatestWifiScanCountList size is too small, size is " + this.this$0.gLatestWifiScanCountList.size());     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L9:
            ArrayList r0 = new ArrayList(this.this$0.gLatestWifiScanCountList);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            JsonObject r2 = new JsonObject();
            JsonArray r3 = getWifiScanCountArray(r0);
            r2.addProperty("featureId", 94);
            r2.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r2.addProperty("wifiScanCountReport", r3.toString());
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_wifi_scan_count", new Gson().toJson(r2));
            this.this$0.clearLatestWifiScanCountList();
            a.e(CaeUserAwareReportJson.access$000(), "wifi_scan_count report data complete and send to callback");
        }
    }

    public class WifiScanReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportJson this$0;

        public WifiScanReportItem(CaeUserAwareReportJson r1) {
            this.this$0 = r1;
        }

        private JsonArray getWifiScanArray(List<WifiStandardData> r6) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            JsonArray r7 = new JsonArray();
            Iterator r8 = r5.iterator();
        L4:
            if (r8.hasNext() == false) goto L11;
            WifiStandardData r1 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r8.next(), WifiStandardData.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L4;
            if (r1.getBssid() == null) goto L4;
            JsonObject r2 = new JsonObject();
            r2.addProperty("bssid", r1.getBssid());
            r2.addProperty(Api.KEY_SSID, r1.getSsid());
            r2.addProperty("rssi", Integer.valueOf(r1.getRssi()));
            r2.addProperty("frequency", Integer.valueOf(r1.getFrequency()));
            r2.addProperty("timestamp", Long.valueOf(r1.getTimestamp()));
            r2.addProperty("authType", Integer.valueOf(r1.getAuthType()));
            r7.add(r2);
            goto L4
        L11:
            return r7;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            a.c(CaeUserAwareReportJson.access$000(), "WifiScanReportItem buildEvents");
            Object r0 = this.this$0.scanListLock;
            monitor-enter(r0);
            ArrayList r1 = new ArrayList(this.this$0.gAccumulatedWifiList);     // Catch: Throwable -> L8
            this.this$0.isReadyToSendConnReport = true;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            JsonObject r2 = new JsonObject();
            JsonArray r3 = getWifiScanArray(r1);
            r2.addProperty("featureId", 94);
            r2.addProperty("timestamp", Long.valueOf(System.currentTimeMillis()));
            r2.add("wifiScanReport", r3);
            String r4 = new Gson().toJson(r2);
            CaeUserAwareReportJson.access$100(this.this$0, "useraware_wifi_scan_info", r4);
            this.this$0.clearAccumulatedWifiList();
            a.e(CaeUserAwareReportJson.access$000(), "wifi_scan_info report data complete and send to callback");
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private CaeUserAwareReportJson(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        a.c(TAG, "start report json");
        this.mUserAwareManager = UserAwareManager.getInstance();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(CaeUserAwareReportJson r0, String r1, String r2) {
        r0.notifyCallback(r1, r2);
    }

    public static CaeUserAwareReportJson getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(CaeUserAwareReportJson.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CaeUserAwareReportJson(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeUserAwareReportJson.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    static /* synthetic */ void lambda$notifyCallback$0(String r1, String r2, d r3, Object r4) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).a(r1, r2);
    }

    private void notifyCallback(final String r4, final String r5) {
        if (this.mUserAwareManager != null) goto L10;
        a.g(TAG, "UserAwareManager is not available, skipping notification");
        return;
    L10:
        a.c(TAG, "notifyCallback: eventName -- " + r4 + ", jsonData -- " + r5);     // Catch: Exception -> L6
        this.mUserAwareManager.notifyCallbacks(new $$Lambda$CaeUserAwareReportJson$XfyDdrDKCDaLpceu5oZEplo8t0(r4, r5), new Object());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        a.a(TAG, "Error calling user aware report callback", e);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public void cleanup() {
        super.cleanup();
        this.mUserAwareManager = null;
        sInstance = null;
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createHARFeedbackReportItem(HARFeedbackInfo r2) {
        return new HARFeedbackReportItem(this, r2);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createHARStateReportItem() {
        return new HARStateReportItem(this);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createNearElevatorReportItem(NearElevator.InnerNearElevatorData r2) {
        return new NearElevatorReportItem(this, r2);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createScanTuningReportItem(JSONObject r2) {
        return new ScanTuningReportItem(this, r2);
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public CaeUserAwareReportBase.ReportItem createUserFeedbackReportItem(UserFeedbackInfo r2) {
        return new UserFeedbackReportItem(this, r2);
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
