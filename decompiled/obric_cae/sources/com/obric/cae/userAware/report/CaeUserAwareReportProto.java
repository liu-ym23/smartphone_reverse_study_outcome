package com.obric.cae.userAware.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.EventsUtils;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.libs.useraware.ICaeUserAware;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.log.CaeLog;
import com.obric.cae.p001useraware.CaeUserAwareServiceProto;
import com.obric.cae.p001useraware.CaeUserAwareServiceProtoData;
import com.obric.cae.p001useraware.HARStateRawData;
import com.obric.cae.p001useraware.HARUserAwareData;
import com.obric.cae.p001useraware.UserAwarePrecisionData;
import com.obric.cae.p001useraware.WifiConnReportData;
import com.obric.cae.p001useraware.WifiPnoStatsReportData;
import com.obric.cae.p001useraware.WifiScanCountReportData;
import com.obric.cae.p001useraware.WifiScanReportData;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.NearElevatorProto;
import com.obric.cae.userAware.WifiScanData;
import com.obric.cae.userAware.WifiScanDataPair;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.datacollection.HARStateInfo;
import com.obric.cae.userAware.datacollection.UserFeedbackInfo;
import com.obric.cae.userAware.datacollection.WifiScanCount;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CaeUserAwareReportProto extends CaeUserAwareReportBase {
    private static final String PACKAGE_NAME_CAE = "com.obric.cae";
    private static final String TAG = "CaeUserAwareReportProto";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile CaeUserAwareReportProto sInstance;

    public class HARFeedbackReportItem extends CaeUserAwareReportBase.ReportItem {
        private final HARFeedbackInfo harFeedbackInfo;
        final /* synthetic */ CaeUserAwareReportProto this$0;

        public HARFeedbackReportItem(CaeUserAwareReportProto r8, HARFeedbackInfo r10) {
            this.this$0 = r8;
            this.harFeedbackInfo = r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "HARFeedbackReportItem buildEvents");
            CaeUserAwareServiceProtoData.Builder r8 = CaeUserAwareServiceProtoData.newBuilder();
            HARUserAwareData.Builder r10 = HARUserAwareData.newBuilder();
            r10.setTimeStamp(this.harFeedbackInfo.getTimeStamp()).setStateCode(this.harFeedbackInfo.getStateCode()).setUserChoice(this.harFeedbackInfo.getUserChoice());
            r8.addHARUserAware(r10.build());
            CaeUserAwareServiceProto r11 = CaeUserAwareServiceProto.newBuilder().addCaeUserAwareServiceProtoData(r8.build()).build();
            EventsUtils.writePbEvent(System.currentTimeMillis(), 94, r11.toByteArray());
            CaeLog.i(CaeUserAwareReportProto.access$000(), "HARFeedbackReportItem report data complete and send to system");
        }
    }

    public class HARStateReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportProto this$0;

        public HARStateReportItem(CaeUserAwareReportProto r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "HARStateReportItem buildEvents");
            CaeUserAwareServiceProtoData.Builder r8 = CaeUserAwareServiceProtoData.newBuilder();
            Object r10 = this.this$0.countListLock;
            monitor-enter(r10);
            ArrayList r11 = new ArrayList(this.this$0.gHarStateList);     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            HARStateInfo r13 = (HARStateInfo) r12.next();
            HARStateRawData.Builder r14 = HARStateRawData.newBuilder();
            r14.setTimeStamp(r13.getTimeStamp()).setStateCode(r13.getValue()).setModelNumber(r13.getModelNumber());
            r8.addHARStateRaw(r14.build());
            goto L8
        L10:
            CaeUserAwareServiceProto r15 = CaeUserAwareServiceProto.newBuilder().addCaeUserAwareServiceProtoData(r8.build()).build();
            EventsUtils.writePbEvent(System.currentTimeMillis(), 94, r15.toByteArray());
            CaeLog.i(CaeUserAwareReportProto.access$000(), "HARStateReportItem report data complete and send to system");
            this.this$0.clearHarStateList();
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public class NearElevatorReportItem extends CaeUserAwareReportBase.ReportItem {
        private final NearElevator.InnerNearElevatorData data;
        final /* synthetic */ CaeUserAwareReportProto this$0;

        public NearElevatorReportItem(CaeUserAwareReportProto r8, NearElevator.InnerNearElevatorData r10) {
            this.this$0 = r8;
            this.data = r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "NearElevatorReportItem buildEvents");
            NearElevatorProto.Builder r8 = NearElevatorProto.newBuilder();     // Catch: Exception -> L15
            r8.setIsInElevator(this.data.isInElevator());     // Catch: Exception -> L15
            r8.setElevatorId(this.data.getElevatorId());     // Catch: Exception -> L15
            r8.setElevatorUpdateCnt(this.data.getElevatorUpdateCnt());     // Catch: Exception -> L15
            Iterator<NearElevator.WifiDataPair> r10 = this.data.getWifiDataPairs().iterator();     // Catch: Exception -> L15
        L5:
            if (r10.hasNext() == false) goto L13;
            NearElevator.WifiDataPair r11 = r10.next();     // Catch: Exception -> L15
            WifiScanDataPair.Builder r12 = WifiScanDataPair.newBuilder();     // Catch: Exception -> L15
            if (r11.getNewWifiData() == null) goto L10;
            WifiScanData.Builder r13 = WifiScanData.newBuilder();     // Catch: Exception -> L15
            r13.setRssi(r11.getNewWifiData().getRssi()).setFreq(r11.getNewWifiData().getFreq()).setChannelWidth(r11.getNewWifiData().getChannelWidth()).setTimestamp(r11.getNewWifiData().getTimestamp());     // Catch: Exception -> L15
            r12.setNewWifiScanData(r13.build());     // Catch: Exception -> L15
        L10:
            if (r11.getAnchorWifiData() == null) goto L12;
            WifiScanData.Builder r14 = WifiScanData.newBuilder();     // Catch: Exception -> L15
            r14.setRssi(r11.getAnchorWifiData().getRssi()).setFreq(r11.getAnchorWifiData().getFreq()).setChannelWidth(r11.getAnchorWifiData().getChannelWidth()).setTimestamp(r11.getAnchorWifiData().getTimestamp());     // Catch: Exception -> L15
            r12.setAnchorWifiData(r14.build());     // Catch: Exception -> L15
        L12:
            r8.addWifiDataPairs(r12.build());     // Catch: Exception -> L15
            goto L5
        L13:
            EventsUtils.writePbEvent(System.currentTimeMillis(), BWDLInnerConstant.LINK_RECOVERY, r8.build().toByteArray());     // Catch: Exception -> L15
            CaeLog.i(CaeUserAwareReportProto.access$000(), "NearElevator report sent successfully. isInElevator: " + this.data.isInElevator() + ", wifiDataPairsCount: " + this.data.getWifiDataPairs().size());     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            CaeLog.e(CaeUserAwareReportProto.access$000(), "Failed to build and send NearElevator event", e);
        }
    }

    public class UserFeedbackReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportProto this$0;
        private final UserFeedbackInfo userFeedbackInfo;

        public UserFeedbackReportItem(CaeUserAwareReportProto r8, UserFeedbackInfo r10) {
            this.this$0 = r8;
            this.userFeedbackInfo = r10;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "UserFeedbackReportItem buildEvents");
            CaeUserAwareServiceProtoData.Builder r8 = CaeUserAwareServiceProtoData.newBuilder();
            UserAwarePrecisionData.Builder r10 = UserAwarePrecisionData.newBuilder();
            r10.setTimeStamp(this.userFeedbackInfo.getTimeStamp()).setStateCode(this.userFeedbackInfo.getStateCode()).setStateChange(this.userFeedbackInfo.getStateChange()).setUserChoice(this.userFeedbackInfo.getUserChoice());
            r8.addUserAwarePrecision(r10.build());
            CaeUserAwareServiceProto r11 = CaeUserAwareServiceProto.newBuilder().addCaeUserAwareServiceProtoData(r8.build()).build();
            EventsUtils.writePbEvent(System.currentTimeMillis(), 94, r11.toByteArray());
            CaeLog.i(CaeUserAwareReportProto.access$000(), "UserFeedbackReportItem report data complete and send to system");
        }
    }

    public class WifiConnReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportProto this$0;

        public WifiConnReportItem(CaeUserAwareReportProto r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "WifiConnReportItem buildEvents");
            Object r8 = this.this$0.connListLock;
            monitor-enter(r8);
        L22:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiConnList.size() >= 20) goto L9;
            CaeLog.d(CaeUserAwareReportProto.access$000(), "WifiScanReportItem cannot buildEvents, gLatestWifiConnList size is too small, size is " + this.this$0.gLatestWifiConnList.size());     // Catch: Throwable -> L22
            monitor-exit(r8);     // Catch: Throwable -> L22
            return;
        L9:
            ArrayList r10 = new ArrayList(this.this$0.gLatestWifiConnList);     // Catch: Throwable -> L22
            monitor-exit(r8);     // Catch: Throwable -> L22
            CaeUserAwareServiceProtoData.Builder r11 = CaeUserAwareServiceProtoData.newBuilder();
            Iterator r12 = r10.iterator();
        L13:
            if (r12.hasNext() == false) goto L20;
            WifiStandardData r13 = (WifiStandardData) r12.next();
            if (r13 == null) goto L13;
            if (r13.getBssid() == null) goto L13;
            WifiConnReportData.Builder r14 = WifiConnReportData.newBuilder();
            r14.setBssid(r13.getBssid()).setSsid(r13.getSsid()).setRssi(r13.getRssi()).setFrequency(r13.getFrequency()).setTimestamp(r13.getTimestamp()).setAuthType(r13.getAuthType());
            r11.addWifiConnectionReport(r14.build());
            goto L13
        L20:
            EventsUtils.writePbEvent(System.currentTimeMillis(), 94, CaeUserAwareServiceProto.newBuilder().addCaeUserAwareServiceProtoData(r11.build()).build().toByteArray());
            this.this$0.clearLatestWifiConnList();
            CaeLog.i(CaeUserAwareReportProto.access$000(), "WifiConnReportItem report data complete and send to system");
        }
    }

    public class WifiPnoStatsReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportProto this$0;

        public WifiPnoStatsReportItem(CaeUserAwareReportProto r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "WifiPnoStatsReportItem buildEvents");
            Object r8 = this.this$0.pnoStatsListLock;
            monitor-enter(r8);
        L30:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiPnoStatsList.size() >= 5) goto L9;
            CaeLog.d(CaeUserAwareReportProto.access$000(), "WifiPnoStatsReportItem cannot buildEvents, size=" + this.this$0.gLatestWifiPnoStatsList.size());     // Catch: Throwable -> L30
            monitor-exit(r8);     // Catch: Throwable -> L30
            return;
        L9:
            ArrayList r10 = new ArrayList(this.this$0.gLatestWifiPnoStatsList);     // Catch: Throwable -> L30
            monitor-exit(r8);     // Catch: Throwable -> L30
            CaeUserAwareServiceProtoData.Builder r11 = CaeUserAwareServiceProtoData.newBuilder();
            JSONArray r12 = new JSONArray();
            Iterator r13 = r10.iterator();
        L13:
            if (r13.hasNext() == false) goto L20;
            CaeUserAwareReportBase.PnoStats r14 = (CaeUserAwareReportBase.PnoStats) r13.next();
            if (r14 == null) goto L13;
            WifiPnoStatsReportData.Builder r15 = WifiPnoStatsReportData.newBuilder();
            r15.setTimeStamp(r14.getTimeStamp()).setEvent(r14.getEvent()).setStartWallClockMs(r14.getStartWallClockMs()).setStopWallClockMs(r14.getStopWallClockMs()).setDurationMs(r14.getDurationMs()).setPeriodMs(r14.getPeriodMs()).setEstimatedRounds(r14.getEstimatedRounds()).setTotalDurationTodayMs(r14.getTotalDurationTodayMs()).setSessionCountToday(r14.getSessionCountToday()).setEstimatedRoundsToday(r14.getEstimatedRoundsToday());
            r11.addWifiPnoStatsReport(r15.build());
            JSONObject r16 = new JSONObject();     // Catch: Throwable -> L33
            r16.put("timeStamp", r14.getTimeStamp());     // Catch: Throwable -> L33
            r16.put("event", r14.getEvent());     // Catch: Throwable -> L33
            r16.put("startWallClockMs", r14.getStartWallClockMs());     // Catch: Throwable -> L33
            r16.put("stopWallClockMs", r14.getStopWallClockMs());     // Catch: Throwable -> L33
            r16.put("durationMs", r14.getDurationMs());     // Catch: Throwable -> L33
            r16.put("periodMs", r14.getPeriodMs());     // Catch: Throwable -> L33
            r16.put("estimatedRounds", r14.getEstimatedRounds());     // Catch: Throwable -> L33
            r16.put("totalDurationTodayMs", r14.getTotalDurationTodayMs());     // Catch: Throwable -> L33
            r16.put("sessionCountToday", r14.getSessionCountToday());     // Catch: Throwable -> L33
            r16.put("estimatedRoundsToday", r14.getEstimatedRoundsToday());     // Catch: Throwable -> L33
            r12.put(r16);     // Catch: Throwable -> L33
            goto L13
        L20:
            CaeUserAwareServiceProto r17 = CaeUserAwareServiceProto.newBuilder().addCaeUserAwareServiceProtoData(r11.build()).build();
            long r18 = System.currentTimeMillis();
            if (CaeUserAwareReportProto.access$100(this.this$0) == false) goto L23;
            EventsUtils.writePbEvent(r18, 94, r17.toByteArray());
        L28:
            this.this$0.clearLatestWifiPnoStatsList();
            CaeLog.i(CaeUserAwareReportProto.access$000(), "WifiPnoStatsReportItem report data complete and send");
            return;
        L23:
            JSONObject r19 = new JSONObject();
            r19.put("featureId", 94);     // Catch: Throwable -> L35
            r19.put("timestamp", r18);     // Catch: Throwable -> L35
            r19.put("wifiPnoStatsReport", r12);     // Catch: Throwable -> L35
        L39:
            ByteIOUtils.trackEvent(ICaeUserAware.USER_AWARE_REPORT_WIFI_PNO_STATS, r19);     // Catch: Throwable -> L27
        L27:
            ByteIOUtils.trackEvent(ICaeUserAware.USER_AWARE_REPORT_WIFI_PNO_STATS, r19.toString());     // Catch: Throwable -> L34
            goto L28
        }
    }

    public class WifiScanCountReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportProto this$0;

        public WifiScanCountReportItem(CaeUserAwareReportProto r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "WifiScanCountReportItem buildEvents");
            Object r8 = this.this$0.countListLock;
            monitor-enter(r8);
        L27:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.gLatestWifiScanCountList.size() >= 5) goto L9;
            CaeLog.d(CaeUserAwareReportProto.access$000(), "WifiScanCountReportItem cannot buildEvents, gLatestWifiScanCountList size is too small, size is " + this.this$0.gLatestWifiScanCountList.size());     // Catch: Throwable -> L27
            monitor-exit(r8);     // Catch: Throwable -> L27
            return;
        L9:
            ArrayList r10 = new ArrayList(this.this$0.gLatestWifiScanCountList);     // Catch: Throwable -> L27
            monitor-exit(r8);     // Catch: Throwable -> L27
            CaeUserAwareServiceProtoData.Builder r11 = CaeUserAwareServiceProtoData.newBuilder();
            JSONArray r12 = new JSONArray();
            Iterator r13 = r10.iterator();
        L13:
            if (r13.hasNext() == false) goto L17;
            WifiScanCount r14 = (WifiScanCount) r13.next();
            WifiScanCountReportData.Builder r15 = WifiScanCountReportData.newBuilder();
            r15.setTimeStamp(r14.getTimeStamp()).setScanType(r14.getScanType()).setSceneType(r14.getSceneType()).setDateScanCount(r14.getDateScanCount()).setDateScanDropCount(r14.getDateScanDropCount());
            r11.addWifiScanCountReport(r15.build());
            JSONObject r16 = new JSONObject();     // Catch: Throwable -> L30
            r16.put("timeStamp", r14.getTimeStamp());     // Catch: Throwable -> L30
            r16.put("scanType", r14.getScanType());     // Catch: Throwable -> L30
            r16.put("sceneType", r14.getSceneType());     // Catch: Throwable -> L30
            r16.put("dateScanCount", r14.getDateScanCount());     // Catch: Throwable -> L30
            r16.put("dateScanDropCount", r14.getDateScanDropCount());     // Catch: Throwable -> L30
            r12.put(r16);     // Catch: Throwable -> L30
            goto L13
        L17:
            CaeUserAwareServiceProto r17 = CaeUserAwareServiceProto.newBuilder().addCaeUserAwareServiceProtoData(r11.build()).build();
            long r18 = System.currentTimeMillis();
            if (CaeUserAwareReportProto.access$100(this.this$0) == false) goto L20;
            EventsUtils.writePbEvent(r18, 94, r17.toByteArray());
        L25:
            this.this$0.clearLatestWifiScanCountList();
            CaeLog.i(CaeUserAwareReportProto.access$000(), "WifiScanCountReportItem report data complete and send to system");
            return;
        L20:
            JSONObject r19 = new JSONObject();
            r19.put("featureId", 94);     // Catch: Throwable -> L32
            r19.put("timestamp", r18);     // Catch: Throwable -> L32
            r19.put("wifiScanCountReport", r12.toString());     // Catch: Throwable -> L32
        L35:
            ByteIOUtils.trackEvent(ICaeUserAware.USER_AWARE_REPORT_WIFI_SCAN_COUNT, r19);     // Catch: Throwable -> L24
        L24:
            ByteIOUtils.trackEvent(ICaeUserAware.USER_AWARE_REPORT_WIFI_SCAN_COUNT, r19.toString());     // Catch: Throwable -> L31
            goto L25
        }
    }

    public class WifiScanReportItem extends CaeUserAwareReportBase.ReportItem {
        final /* synthetic */ CaeUserAwareReportProto this$0;

        public WifiScanReportItem(CaeUserAwareReportProto r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase.ReportItem
        public void buildEvents() {
            CaeLog.d(CaeUserAwareReportProto.access$000(), "WifiScanReportItem buildEvents");
            CaeUserAwareServiceProtoData.Builder r8 = CaeUserAwareServiceProtoData.newBuilder();
            Object r10 = this.this$0.scanListLock;
            monitor-enter(r10);
            ArrayList r11 = new ArrayList(this.this$0.gAccumulatedWifiList);     // Catch: Throwable -> L17
            this.this$0.isReadyToSendConnReport = true;     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L15;
            WifiStandardData r13 = (WifiStandardData) r12.next();
            if (r13 == null) goto L8;
            if (r13.getBssid() == null) goto L8;
            WifiScanReportData.Builder r14 = WifiScanReportData.newBuilder();
            r14.setBssid(r13.getBssid()).setSsid(r13.getSsid()).setRssi(r13.getRssi()).setFrequency(r13.getFrequency()).setTimestamp(r13.getTimestamp()).setAuthType(r13.getAuthType());
            r8.addWifiScanReport(r14.build());
            goto L8
        L15:
            CaeUserAwareServiceProto r15 = CaeUserAwareServiceProto.newBuilder().addCaeUserAwareServiceProtoData(r8.build()).build();
            EventsUtils.writePbEvent(System.currentTimeMillis(), 94, r15.toByteArray());
            this.this$0.clearAccumulatedWifiList();
            CaeLog.i(CaeUserAwareReportProto.access$000(), "WifiScanReportItem report data complete and send to system");
            return;
        L17:
            th = move-exception;
            throw th;
        }
    }

    private CaeUserAwareReportProto(Context r8) {
        super(r8);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ boolean access$100(CaeUserAwareReportProto r8) {
        return r8.isCaePkg();
    }

    public static CaeUserAwareReportProto getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(CaeUserAwareReportProto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CaeUserAwareReportProto(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeUserAwareReportProto.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean isCaePkg() {
        Context r8 = this.mContext;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if ("com.obric.cae".equals(r8.getPackageName()) == false) goto L7;
        return true;
    }

    @Override // com.obric.cae.userAware.report.CaeUserAwareReportBase
    public void cleanup() {
        super.cleanup();
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
