package com.obric.cae.statusReport.wifi;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.cae.caed.events.CaeRoamParcel;
import com.cae.caed.events.WakePacketParcel;
import com.cae.caed.events.WlanCrashParcel;
import com.google.protobuf.ByteString;
import com.obric.cae.libs.statusreport.LinkLayerQuality;
import com.obric.cae.libs.statusreport.LinkStatsParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.utils.CaeUtil;
import com.obric.cae.utils.CaeWifiUtil;
import com.obric.cae.wifi.CaeWifiServiceProto;
import com.obric.cae.wifi.CaeWifiServiceProtoData;
import com.obric.cae.wifi.ConnectionTimeReportData;
import com.obric.cae.wifi.LinkLayerQualityReportData;
import com.obric.cae.wifi.LinkStats;
import com.obric.cae.wifi.MloLinkLayerQualityReportData;
import com.obric.cae.wifi.PoorLinkDisconnectReportData;
import com.obric.cae.wifi.PowerStatsReportData;
import com.obric.cae.wifi.RoamCandidateAp;
import com.obric.cae.wifi.RoamSuccessReportData;
import com.obric.cae.wifi.RouterModelReportData;
import com.obric.cae.wifi.WakePacketReportData;
import com.obric.cae.wifi.WlanCrashReportData;
import defpackage.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CaeWifiStatusCollect {
    private static final int CAEWIFI_SERVICE_EVENT_FEATURE_ID = 52;
    private static final int CONNECTION_TIME_THRESHOLD_SECONDS = 30;
    private static final boolean DEBUG = false;
    private static final int LINKLAYER_QUALITY_REPORT_INTERVAL = 12000;
    private static final String POWER_STATS_PATH = "/sys/kernel/peach_v2/power_stats";
    private static final int POWER_STATS_SCREEN_OFF_MINTIME = 60000;
    private static final int ROAM_SUCCESS_MAX_AP = 10;
    private static String TAG = "CaeWifiStatusCollect";
    private static boolean sInited = false;
    private static CaeWifiStatusCollect sInstance;
    private int MSG_HANDLE_WIFI_REPORT;
    private long mConnectedTimeStamp;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private PowerStatsInfo mLastPowerStatsInfo;
    private long mScreenOffTstamp;
    private HashMap<String, UPnPDevice> mUPnPDevs;

    /* JADX INFO: renamed from: com.obric.cae.statusReport.wifi.CaeWifiStatusCollect$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType = null;

        static {
            int[] r8 = new int[ReportItemType.values().length];
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType = r8;
            r8[ReportItemType.REPORT_TYPE_ROUTER_MODEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[ReportItemType.REPORT_TYPE_CONNECTION_TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[ReportItemType.REPORT_TYPE_POWER_STATS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[ReportItemType.REPORT_TYPE_LINKLAYER_QUALITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[ReportItemType.REPORT_TYPE_ROAM_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[ReportItemType.REPORT_TYPE_WLAN_CRASH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[ReportItemType.REPORT_TYPE_WAKE_PACKET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[ReportItemType.REPORT_TYPE_POOR_LINK_DISCONNECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public class ConnectionTimeReportItem extends ReportItem {
        String mBand;
        String mBand1;
        String mBssid;
        int mFrequency;
        int mFrequency1;
        boolean mMloEnable;
        long mTimeSeconds;
        String mWifigeneration;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public ConnectionTimeReportItem(CaeWifiStatusCollect r8, long r10, String r11, String r12, String r13, int r14, int r15, String r16, boolean r17) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_CONNECTION_TIME);
            this.mWifigeneration = "";
            this.mTimeSeconds = r10;
            this.mBssid = r11;
            this.mBand = r12;
            this.mBand1 = r13;
            this.mFrequency = r14;
            this.mFrequency1 = r15;
            if (r16 != null) goto L5;
            r16 = "";
        L5:
            this.mWifigeneration = r16;
            this.mMloEnable = r17;
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            ConnectionTimeReportData.Builder r8 = ConnectionTimeReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setTimeSeconds(this.mTimeSeconds);
            r8.setBssid(CaeWifiUtil.maskMACAddress(this.mBssid));
            r8.setBssidMd5(CaeUtil.stringToMD5(this.mBssid));
            r8.setBand(this.mBand);
            r8.setBand1(this.mBand1);
            r8.setFrequency(this.mFrequency);
            r8.setFrequency1(this.mFrequency1);
            r8.setWifigeneration(this.mWifigeneration);
            r8.setMloEnable(this.mMloEnable ? 1 : 0);
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            CaeWifiServiceProto.Builder r10 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r11 = CaeWifiServiceProtoData.newBuilder();
            r11.setConnectionTimeReport(r8);
            r10.addCaeWifiServiceProto(r11);
            CaeUtil.writePbEventSafely(getTimestamp(), 52, r10.build().toByteArray());
            CaeLog.i(CaeWifiStatusCollect.access$200(), getType().getEventName() + ": time_seconds=" + this.mTimeSeconds + " bssid=" + CaeWifiUtil.maskMACAddress(this.mBssid) + " band=" + this.mBand + " band1=" + this.mBand1 + " freq=" + this.mFrequency + " freq1=" + this.mFrequency1 + " generation=" + this.mWifigeneration + " mloenable=" + this.mMloEnable);
        }
    }

    public class LinkLayerQualityReportItem extends ReportItem {
        String mBand;
        String mBand1;
        int mFrequency;
        LinkLayerQuality mLinkLayerQuality;
        int mRxLinkspeed;
        int mTxLinkSpeed;
        String mWifigeneration;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public LinkLayerQualityReportItem(CaeWifiStatusCollect r8, LinkLayerQuality r10, int r11, int r12, int r13, String r14, String r15, String r16) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_LINKLAYER_QUALITY);
            this.mWifigeneration = "";
            this.mLinkLayerQuality = r10;
            this.mFrequency = r11;
            this.mTxLinkSpeed = r12;
            this.mRxLinkspeed = r13;
            this.mBand = r14;
            this.mBand1 = r15;
            if (r16 != null) goto L5;
            r16 = "";
        L5:
            this.mWifigeneration = r16;
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            if (this.mLinkLayerQuality.isMloIface() == true) goto L18;
            LinkLayerQualityReportData.Builder r8 = LinkLayerQualityReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setFrequency(this.mFrequency);
            r8.setTxLinkSpeed(this.mTxLinkSpeed);
            r8.setRxLinkSpeed(this.mRxLinkspeed);
            r8.setCcaScore(this.mLinkLayerQuality.getCcaScore());
            r8.setPerScore(this.mLinkLayerQuality.getPerScore());
            r8.setRssiScore(this.mLinkLayerQuality.getRssiScore());
            r8.setScenario(this.mLinkLayerQuality.getScenario());
            if (this.mLinkLayerQuality.getLinkStats().isEmpty() == true) goto L7;
            LinkStatsParcel r10 = this.mLinkLayerQuality.getLinkStats().get(0);
            r8.setDeltaRadioOnTime(r10.getDeltaRadioOnTime());
            r8.setCcaLevel(r10.getCcaLevel());
            r8.setDeltaTxSuccess(r10.getDeltaTxSuccess());
            r8.setTxRetranLevel(r10.getTxRetranLevel());
            r8.setDeltaRxSuccess(r10.getDeltaRxSuccess());
            r8.setContentionAtimeBe(r10.getContention_atime_be());
            r8.setContentionAtimeVo(r10.getContention_atime_vo());
            r8.setTotalTxRetranLevelBe(r10.getTxRetranLevelBe());
            r8.setTotalTxRetranLevelVo(r10.getTxRetranLevelVo());
            r8.setWidth(r10.getWidth());
            r8.setRssiMgmt(r10.getRssi_mgmt());
            r8.setRssiData(r10.getRssi_data());
            r8.setRssiAck(r10.getRssi_ack());
            r8.setRlTxLinkSpeed(r10.getRl_tx_link_speed());
            r8.setRlRxLinkSpeed(r10.getRl_rx_link_speed());
            r8.setRlCcaBusyRate(r10.getRl_cca_busy_rate());
            r8.setPer(r10.getPer());
            r8.setOnTimeScan(r10.getOn_time_scan());
            r8.setTxSpeedKbps(r10.getTx_speed_kbps());
            r8.setRxSpeedKbps(r10.getRx_speed_kbps());
            r8.setPowerPredMw(r10.getPower_pred_mw());
        L7:
            r8.setRxFcsErrLevel(this.mLinkLayerQuality.getRxFcsErrLevel());
            r8.setDeltaTxBytes(this.mLinkLayerQuality.getDeltaTxBytes());
            r8.setTxRealSpeed(this.mLinkLayerQuality.getTxRealSpeed());
            r8.setDeltaRxBytes(this.mLinkLayerQuality.getDeltaRxBytes());
            r8.setRxRealSpeed(this.mLinkLayerQuality.getRxRealSpeed());
            r8.setTxMode(this.mLinkLayerQuality.getTxMode());
            r8.setTxMcs(this.mLinkLayerQuality.getTxMcs());
            r8.setTxBw(this.mLinkLayerQuality.getTxBw());
            r8.setTxNss(this.mLinkLayerQuality.getTxNss());
            r8.setRxMode(this.mLinkLayerQuality.getRxMode());
            r8.setRxMcs(this.mLinkLayerQuality.getRxMcs());
            r8.setRxBw(this.mLinkLayerQuality.getRxBw());
            r8.setRxNss(this.mLinkLayerQuality.getRxNss());
            r8.setDeltaChannelOnTime(this.mLinkLayerQuality.getDelta_channel_on_time());
            r8.setDeltaChannelTxTime(this.mLinkLayerQuality.getDelta_channel_tx_time());
            r8.setDeltaChannelRxTime(this.mLinkLayerQuality.getDelta_channel_rx_time());
            r8.setDeltaChannelCcaBusyTime(this.mLinkLayerQuality.getDelta_channel_cca_busy_time());
            r8.setArpNeighbourCount(this.mLinkLayerQuality.getArpNeighbourCount());
            r8.setCurrentChannelAPCount(this.mLinkLayerQuality.getCurrentChannelAPCount());
            r8.setWifigeneration(this.mWifigeneration);
            r8.setBand(this.mBand);
            r8.setRxTputPred(this.mLinkLayerQuality.getRxTputPred());
            r8.setTxTputPred(this.mLinkLayerQuality.getTxTputPred());
            r8.setWifiStandard(this.mLinkLayerQuality.getWifiStandard());
            r8.setContentionAtimeBk(this.mLinkLayerQuality.getContentionAtimeBk());
            r8.setContentionAtimeVi(this.mLinkLayerQuality.getContentionAtimeVi());
            r8.setTxDelayAvg(this.mLinkLayerQuality.getTxDelayAvg());
            r8.setTxDelayP10(this.mLinkLayerQuality.getTxDelayP10());
            r8.setTxDelayP90(this.mLinkLayerQuality.getTxDelayP90());
            r8.setTxDelayPkts(this.mLinkLayerQuality.getTxDelayPkts());
            List<Integer> r11 = this.mLinkLayerQuality.getDelaySizeMatrix();
            if (r11 == null) goto L17;
            Iterator<Integer> r12 = r11.iterator();
        L11:
            if (r12.hasNext() == false) goto L17;
            Integer r13 = r12.next();
            if (r13 == null) goto L15;
            int r14 = r13.intValue();
        L16:
            r8.addDelaySizeMatrix(r14);
            goto L11
        L15:
            r14 = 0;
        L17:
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            CaeWifiServiceProto.Builder r15 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r16 = CaeWifiServiceProtoData.newBuilder();
            r16.setLinkLayerQualityReport(r8);
            r15.addCaeWifiServiceProto(r16);
            CaeUtil.writePbEventSafely(getTimestamp(), 52, r15.build().toByteArray());
            return;
        L18:
            MloLinkLayerQualityReportData.Builder r17 = MloLinkLayerQualityReportData.newBuilder();
            r17.setEventType(getType().getEventName());
            r17.setIfName(this.mLinkLayerQuality.getIfName());
            r17.setFreq(this.mLinkLayerQuality.getFreq());
            r17.setTxlinkSpeed(this.mLinkLayerQuality.getTxlinkSpeed());
            r17.setRxlinkSpeed(this.mLinkLayerQuality.getRxlinkSpeed());
            r17.setBand(this.mLinkLayerQuality.getBand());
            r17.setBand1(this.mLinkLayerQuality.getBand1());
            r17.setWifiGeneration(this.mLinkLayerQuality.getWifiGeneration());
            r17.setDeltaRxFcsErr(this.mLinkLayerQuality.getDeltaRxFcsErr());
            r17.setRxFcsErrLevel(this.mLinkLayerQuality.getRxFcsErrLevel());
            r17.setTotalTxBytes(this.mLinkLayerQuality.getTotalTxBytes());
            r17.setDeltaTxBytes(this.mLinkLayerQuality.getDeltaTxBytes());
            r17.setTxRealSpeed(this.mLinkLayerQuality.getTxRealSpeed());
            r17.setTotalRxBytes(this.mLinkLayerQuality.getTotalRxBytes());
            r17.setDeltaRxBytes(this.mLinkLayerQuality.getDeltaRxBytes());
            r17.setRxRealSpeed(this.mLinkLayerQuality.getRxRealSpeed());
            r17.setTxMode(this.mLinkLayerQuality.getTxMode());
            r17.setTxMcs(this.mLinkLayerQuality.getTxMcs());
            r17.setTxBw(this.mLinkLayerQuality.getTxBw());
            r17.setTxNss(this.mLinkLayerQuality.getTxNss());
            r17.setRxMode(this.mLinkLayerQuality.getRxMode());
            r17.setRxMcs(this.mLinkLayerQuality.getRxMcs());
            r17.setRxBw(this.mLinkLayerQuality.getRxBw());
            r17.setRxNss(this.mLinkLayerQuality.getRxNss());
            r17.setDeltaChannelOnTime(this.mLinkLayerQuality.getDelta_channel_on_time());
            r17.setDeltaChannelTxTime(this.mLinkLayerQuality.getDelta_channel_tx_time());
            r17.setDeltaChannelRxTime(this.mLinkLayerQuality.getDelta_channel_rx_time());
            r17.setDeltaChannelCcaBusyTime(this.mLinkLayerQuality.getDelta_channel_cca_busy_time());
            r17.setCcaScore(this.mLinkLayerQuality.getCcaScore());
            r17.setPerScore(this.mLinkLayerQuality.getPerScore());
            r17.setRssiScore(this.mLinkLayerQuality.getRssiScore());
            r17.setScenario(this.mLinkLayerQuality.getScenario());
            r17.setCurrentChannelAPCount(this.mLinkLayerQuality.getCurrentChannelAPCount());
            r17.setArpNeighbourCount(this.mLinkLayerQuality.getArpNeighbourCount());
            r17.setIsMloIface(this.mLinkLayerQuality.isMloIface());
            r17.setDeviceTime(getTimestamp());
            r17.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            r17.setRxTputPred(this.mLinkLayerQuality.getRxTputPred());
            r17.setTxTputPred(this.mLinkLayerQuality.getTxTputPred());
            r17.setWifiStandard(this.mLinkLayerQuality.getWifiStandard());
            r17.setContentionAtimeBk(this.mLinkLayerQuality.getContentionAtimeBk());
            r17.setContentionAtimeVi(this.mLinkLayerQuality.getContentionAtimeVi());
            r17.setTxDelayAvg(this.mLinkLayerQuality.getTxDelayAvg());
            r17.setTxDelayP10(this.mLinkLayerQuality.getTxDelayP10());
            r17.setTxDelayP90(this.mLinkLayerQuality.getTxDelayP90());
            r17.setTxDelayPkts(this.mLinkLayerQuality.getTxDelayPkts());
            List<Integer> r18 = this.mLinkLayerQuality.getDelaySizeMatrix();
            if (r18 == null) goto L28;
            Iterator<Integer> r19 = r18.iterator();
        L22:
            if (r19.hasNext() == false) goto L28;
            Integer r20 = r19.next();
            if (r20 == null) goto L26;
            int r21 = r20.intValue();
        L27:
            r17.addDelaySizeMatrix(r21);
            goto L22
        L26:
            r21 = 0;
        L28:
            Iterator<LinkStatsParcel> r22 = this.mLinkLayerQuality.getLinkStats().iterator();
        L30:
            if (r22.hasNext() == false) goto L32;
            LinkStatsParcel r23 = r22.next();
            LinkStats.Builder r24 = LinkStats.newBuilder();
            r24.setLinkId(r23.getLink_id());
            r24.setRadioId(r23.getRadio_id());
            r24.setCenterFreq(r23.getCenter_freq());
            r24.setDeltaCcaBusyTime(r23.getDeltaCcaBusyTime());
            r24.setDeltaRadioOnTime(r23.getDeltaRadioOnTime());
            r24.setCcaLevel(r23.getCcaLevel());
            r24.setDeltaTxSuccess(r23.getDeltaTxSuccess());
            r24.setDeltaTxRetries(r23.getDeltaTxRetries());
            r24.setTxRetrayLevel(r23.getTxRetranLevel());
            r24.setDeltaTxBad(r23.getDeltaTxBad());
            r24.setTxBadLevel(r23.getTxBadLevel());
            r24.setDeltaRxSuccess(r23.getDeltaRxSuccess());
            r24.setContentionAtimeBe(r23.getContention_atime_be());
            r24.setContentionAtimeBk(r23.getContention_atime_bk());
            r24.setContentionAtimeVi(r23.getContention_atime_vi());
            r24.setContentionAtimeVo(r23.getContention_atime_vo());
            r24.setTxMpduBe(r23.getTxMpduBe());
            r24.setTxRetriesBe(r23.getTxRetriesBe());
            r24.setTxRetranLevelBe(r23.getTxRetranLevelBe());
            r24.setTxMpduVi(r23.getTxMpduVi());
            r24.setTxRetriesVi(r23.getTxRetriesVi());
            r24.setTxRetranLevelVi(r23.getTxRetranLevelVi());
            r24.setTxMpduVo(r23.getTxMpduVo());
            r24.setTxRetriesVo(r23.getTxRetriesVo());
            r24.setTxRetranLevelVo(r23.getTxRetranLevelVo());
            r24.setWidth(r23.getWidth());
            r24.setRssiMgmt(r23.getRssi_mgmt());
            r24.setRssiData(r23.getRssi_data());
            r24.setRssiAck(r23.getRssi_ack());
            r24.setRlTxLinkSpeed(r23.getRl_tx_link_speed());
            r24.setRlRxLinkSpeed(r23.getRl_rx_link_speed());
            r24.setRlCcaBusyRate(r23.getRl_cca_busy_rate());
            r24.setPer(r23.getPer());
            r24.setOnTimeScan(r23.getOn_time_scan());
            r24.setTxSpeedKbps(r23.getTx_speed_kbps());
            r24.setRxSpeedKbps(r23.getRx_speed_kbps());
            r24.setPowerPredMw(r23.getPower_pred_mw());
            r17.addLinkStats(r24);
            goto L30
        L32:
            CaeWifiServiceProto.Builder r25 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r26 = CaeWifiServiceProtoData.newBuilder();
            r26.setMloLinkLayerQualityReport(r17);
            r25.addCaeWifiServiceProto(r26);
            CaeUtil.writePbEventSafely(getTimestamp(), 52, r25.build().toByteArray());
        }
    }

    public class PoorLinkDisconnectReportItem extends ReportItem {
        int mAverageThroughputKbps;
        String mBssid;
        int mDestinationNetwork;
        String mForegroundApp;
        int mRecovered;
        int mRssi;
        int mTriggerId;
        int mWifiBand;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public PoorLinkDisconnectReportItem(CaeWifiStatusCollect r8, int r10, String r11, int r12, int r13, int r14, int r15, int r16, String r17) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_POOR_LINK_DISCONNECT);
            this.mTriggerId = r10;
            if (r11 != null) goto L5;
            r11 = "";
        L5:
            this.mBssid = r11;
            this.mWifiBand = r12;
            this.mRssi = r13;
            this.mAverageThroughputKbps = r14;
            this.mRecovered = r15;
            this.mDestinationNetwork = r16;
            if (r17 != null) goto L8;
            r17 = "";
        L8:
            this.mForegroundApp = r17;
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            PoorLinkDisconnectReportData.Builder r8 = PoorLinkDisconnectReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            r8.setTriggerId(this.mTriggerId);
            r8.setBssid(CaeWifiUtil.maskMACAddress(this.mBssid));
            r8.setBssidMd5(CaeUtil.stringToMD5(this.mBssid));
            r8.setWifiBand(this.mWifiBand);
            r8.setRssi(this.mRssi);
            r8.setAvgThroughputKbps(this.mAverageThroughputKbps);
            r8.setIsInternetRecovered(this.mRecovered);
            r8.setDestinationNetwork(this.mDestinationNetwork);
            r8.setForegroundApp(this.mForegroundApp);
            CaeWifiServiceProto.Builder r10 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r11 = CaeWifiServiceProtoData.newBuilder();
            r11.setPoorLinkDisconnectReport(r8);
            r10.addCaeWifiServiceProto(r11);
            CaeUtil.writePbEventSafely(getTimestamp(), 52, r10.build().toByteArray());
            String r12 = CaeWifiStatusCollect.access$200();
            StringBuilder r13 = new StringBuilder();
            r13.append(getType().getEventName());
            r13.append(" triggerId=");
            r13.append(this.mTriggerId);
            r13.append(" bssid=");
            r13.append(CaeWifiUtil.maskMACAddress(this.mBssid));
            r13.append(" wifiBand=");
            r13.append(this.mWifiBand);
            r13.append(" rssi=");
            r13.append(this.mRssi);
            r13.append(" avgThroughput=");
            r13.append(this.mAverageThroughputKbps);
            r13.append(" recovered=");
            r13.append(this.mRecovered);
            r13.append(" destination=");
            r13.append(this.mDestinationNetwork);
            r13.append(" foregroundApp=");
            android.aimedia.a.r(r13, this.mForegroundApp, r12);
        }
    }

    public class PowerStatsInfo {
        public long mLastSleepTstamp;
        public long mSleepEnterCounter;
        public long mSleepTime;
        public long mTotalOnTime;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        private PowerStatsInfo(CaeWifiStatusCollect r8) {
            this.this$0 = r8;
        }

        public /* synthetic */ PowerStatsInfo(CaeWifiStatusCollect r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class PowerStatsReportItem extends ReportItem {
        long mLastSleepTstamp;
        long mSleepEnterCounter;
        int mSleepTime;
        int mTotalOnTime;
        int mWakeLevel;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public PowerStatsReportItem(CaeWifiStatusCollect r8, int r10, int r11, long r12, long r13, int r14) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_POWER_STATS);
            this.mSleepTime = r10;
            this.mTotalOnTime = r11;
            this.mSleepEnterCounter = r12;
            this.mLastSleepTstamp = r13;
            this.mWakeLevel = r14;
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            PowerStatsReportData.Builder r8 = PowerStatsReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setSleepTime(this.mSleepTime);
            r8.setTotalOnTime(this.mTotalOnTime);
            r8.setSleepEnterCounter(this.mSleepEnterCounter);
            r8.setLastSleepTstamp(this.mLastSleepTstamp);
            r8.setWakeLevel(this.mWakeLevel);
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            CaeWifiServiceProto.Builder r10 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r11 = CaeWifiServiceProtoData.newBuilder();
            r11.setPowerStatsReport(r8);
            r10.addCaeWifiServiceProto(r11);
            CaeUtil.writePbEventSafely(getTimestamp(), 52, r10.build().toByteArray());
            String r12 = CaeWifiStatusCollect.access$200();
            StringBuilder r13 = new StringBuilder();
            r13.append(getType().getEventName());
            r13.append(": sleeptime=");
            r13.append(this.mSleepTime);
            r13.append(" totaltime=");
            r13.append(this.mTotalOnTime);
            r13.append(" sleepenter=");
            r13.append(this.mSleepEnterCounter);
            r13.append(" lastsleepstamp=");
            r13.append(this.mLastSleepTstamp);
            r13.append(" wakelevel=");
            b.p(r13, this.mWakeLevel, r12);
        }
    }

    public abstract class ReportItem {
        private long mTimestamp;
        private ReportItemType mType;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public ReportItem(CaeWifiStatusCollect r8, ReportItemType r10) {
            this.this$0 = r8;
            this.mType = r10;
            this.mTimestamp = System.currentTimeMillis();
        }

        public abstract void buildEvents();

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public ReportItemType getType() {
            return this.mType;
        }
    }

    public static final enum ReportItemType extends Enum<ReportItemType> {
        private static final /* synthetic */ ReportItemType[] $VALUES = null;
        public static final ReportItemType REPORT_TYPE_CONNECTION_TIME = null;
        public static final ReportItemType REPORT_TYPE_LINKLAYER_QUALITY = null;
        public static final ReportItemType REPORT_TYPE_POOR_LINK_DISCONNECT = null;
        public static final ReportItemType REPORT_TYPE_POWER_STATS = null;
        public static final ReportItemType REPORT_TYPE_ROAM_SUCCESS = null;
        public static final ReportItemType REPORT_TYPE_ROUTER_MODEL = null;
        public static final ReportItemType REPORT_TYPE_WAKE_PACKET = null;
        public static final ReportItemType REPORT_TYPE_WLAN_CRASH = null;
        private final String mEventName;

        private static /* synthetic */ ReportItemType[] $values() {
            return new ReportItemType[]{REPORT_TYPE_ROUTER_MODEL, REPORT_TYPE_CONNECTION_TIME, REPORT_TYPE_POWER_STATS, REPORT_TYPE_LINKLAYER_QUALITY, REPORT_TYPE_ROAM_SUCCESS, REPORT_TYPE_WLAN_CRASH, REPORT_TYPE_WAKE_PACKET, REPORT_TYPE_POOR_LINK_DISCONNECT};
        }

        static {
            REPORT_TYPE_ROUTER_MODEL = new ReportItemType("REPORT_TYPE_ROUTER_MODEL", 0, "wifi_router_model");
            REPORT_TYPE_CONNECTION_TIME = new ReportItemType("REPORT_TYPE_CONNECTION_TIME", 1, "wifi_connection_time");
            REPORT_TYPE_POWER_STATS = new ReportItemType("REPORT_TYPE_POWER_STATS", 2, "wifi_power_stats");
            REPORT_TYPE_LINKLAYER_QUALITY = new ReportItemType("REPORT_TYPE_LINKLAYER_QUALITY", 3, "wifi_linklayer_quality");
            REPORT_TYPE_ROAM_SUCCESS = new ReportItemType("REPORT_TYPE_ROAM_SUCCESS", 4, "wifi_roam_success");
            REPORT_TYPE_WLAN_CRASH = new ReportItemType("REPORT_TYPE_WLAN_CRASH", 5, "wifi_wlan_crash");
            REPORT_TYPE_WAKE_PACKET = new ReportItemType("REPORT_TYPE_WAKE_PACKET", 6, "wifi_wake_packet");
            REPORT_TYPE_POOR_LINK_DISCONNECT = new ReportItemType("REPORT_TYPE_POOR_LINK_DISCONNECT", 7, "wifi_poor_link_disconnect");
            $VALUES = $values();
        }

        private ReportItemType(String r8, int r10, String r11) {
            super(r8, r10);
            this.mEventName = r11;
        }

        public static ReportItemType valueOf(String r8) {
            return (ReportItemType) Enum.valueOf(ReportItemType.class, r8);
        }

        public static ReportItemType[] values() {
            return (ReportItemType[]) $VALUES.clone();
        }

        public String getEventName() {
            return this.mEventName;
        }
    }

    public class ReportQueueProcessHandler extends Handler {
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public ReportQueueProcessHandler(CaeWifiStatusCollect r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            if (r8.what != CaeWifiStatusCollect.access$100(this.this$0)) goto L14;
            ReportItem r10 = (ReportItem) r8.obj;
            switch(AnonymousClass1.$SwitchMap$com$obric$cae$statusReport$wifi$CaeWifiStatusCollect$ReportItemType[r10.getType().ordinal()]) {
                case 1: goto L12;
                case 2: goto L12;
                case 3: goto L12;
                case 4: goto L12;
                case 5: goto L12;
                case 6: goto L12;
                case 7: goto L12;
                case 8: goto L12;
                default: goto L6;
            };
        L6:
            CaeLog.e(CaeWifiStatusCollect.access$200(), "unknown report type");
            return;
        L12:
            r10.buildEvents();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            CaeLog.e(CaeWifiStatusCollect.access$200(), "buildEvents failed, type=" + r10.getType(), th);
            return;
        }
    }

    public class RoamSuccessReportItem extends ReportItem {
        String[] mApBssid;
        int[] mApChan;
        int[] mApRssi;
        int[] mApTotalScore;
        int[] mApType;
        String mResultStatus;
        int[] mScanChanFreq;
        int mScanNumAp;
        int mScanNumChan;
        String mScanType;
        String mTriggerReason;
        int mTriggerRssi;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public RoamSuccessReportItem(CaeWifiStatusCollect r8, String r10, int r11, String r12, int r13, int r14, int[] r15, String r16, String[] r17, int[] r18, int[] r19, int[] r110, int[] r111) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_ROAM_SUCCESS);
            this.mTriggerReason = "";
            this.mScanType = "";
            this.mResultStatus = "";
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            this.mTriggerReason = r10;
            this.mTriggerRssi = r11;
            if (r12 != null) goto L8;
            r12 = "";
        L8:
            this.mScanType = r12;
            this.mScanNumAp = r13;
            this.mScanNumChan = r14;
            this.mScanChanFreq = r15;
            if (r16 != null) goto L11;
            r16 = "";
        L11:
            this.mResultStatus = r16;
            this.mApBssid = r17;
            this.mApChan = r18;
            this.mApRssi = r19;
            this.mApTotalScore = r110;
            this.mApType = r111;
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            RoamSuccessReportData.Builder r8 = RoamSuccessReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setRoamTriggerReason(this.mTriggerReason);
            r8.setRoamTriggerRssi(this.mTriggerRssi);
            r8.setRoamScanType(this.mScanType);
            r8.setRoamScanNumAp(this.mScanNumAp);
            r8.setRoamScanNumChan(this.mScanNumChan);
            int[] r10 = this.mScanChanFreq;
            int r11 = 0;
            if (r10 == null) goto L7;
            int r12 = r10.length;
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L7;
            r8.addRoamScanChanFreq(r10[r13]);
            r13 = r13 + 1;
        L7:
            r8.setRoamResultStatus(this.mResultStatus);
            int r14 = Math.min(CaeWifiStatusCollect.access$300(this.this$0, this.mApBssid, this.mApChan, this.mApRssi, this.mApTotalScore, this.mApType), 10);
        L8:
            if (r11 >= r14) goto L13;
            RoamCandidateAp.Builder r15 = RoamCandidateAp.newBuilder();
            String r16 = this.mApBssid[r11];
            if (r16 != null) goto L12;
            r16 = "";
        L12:
            r15.setApBssid(r16);
            r15.setApChan(this.mApChan[r11]);
            r15.setApRssi(this.mApRssi[r11]);
            r15.setApTotalScore(this.mApTotalScore[r11]);
            r15.setApType(this.mApType[r11]);
            r8.addRoamApList(r15);
            r11 = r11 + 1;
            goto L8
        L13:
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            CaeWifiServiceProto.Builder r17 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r18 = CaeWifiServiceProtoData.newBuilder();
            r18.setRoamSuccessReport(r8);
            r17.addCaeWifiServiceProto(r18);
            CaeUtil.writePbEventSafely(getTimestamp(), 52, r17.build().toByteArray());
        }
    }

    public class RouterModelReportItem extends ReportItem {
        String mBssid;
        boolean mMloEnable;
        String mRouterModel;
        String mRouterType;
        String mWifigeneration;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public RouterModelReportItem(CaeWifiStatusCollect r8, String r10, String r11, String r12, String r13, boolean r14) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_ROUTER_MODEL);
            this.mRouterType = "";
            this.mRouterModel = "";
            this.mBssid = "";
            this.mWifigeneration = "";
            if (r11 != null) goto L5;
            r11 = "";
        L5:
            this.mRouterType = r11;
            if (r12 != null) goto L8;
            r12 = "";
        L8:
            this.mRouterModel = r12;
            if (r10 != null) goto L11;
            r10 = "";
        L11:
            this.mBssid = r10;
            if (r13 != null) goto L14;
            r13 = "";
        L14:
            this.mWifigeneration = r13;
            this.mMloEnable = r14;
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            RouterModelReportData.Builder r8 = RouterModelReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setRouterType(this.mRouterType);
            r8.setRouterModel(this.mRouterModel);
            r8.setBssid(CaeWifiUtil.maskMACAddress(this.mBssid));
            r8.setBssidMd5(CaeUtil.stringToMD5(this.mBssid));
            r8.setWifigeneration(this.mWifigeneration);
            r8.setMloEnable(this.mMloEnable ? 1 : 0);
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            CaeWifiServiceProto.Builder r10 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r11 = CaeWifiServiceProtoData.newBuilder();
            r11.setRouterModelReport(r8);
            r10.addCaeWifiServiceProto(r11);
            CaeUtil.writePbEventSafely(getTimestamp(), 52, r10.build().toByteArray());
            CaeLog.i(CaeWifiStatusCollect.access$200(), getType().getEventName() + " routerType=" + this.mRouterType + " router model=" + this.mRouterModel + " wifigeneration=" + this.mWifigeneration + " mloenable=" + this.mMloEnable);
        }
    }

    public class WakePacketReportItem extends ReportItem {
        int mDelayedPktCount;
        String mDstIp;
        int mDstPort;
        int mDstType;
        String mDstTypeStr;
        int mIpProtocol;
        String mIpProtocolStr;
        int mPacketLen;
        int mPacketType;
        String mPacketTypeStr;
        String mProtocolName;
        int mProtocolType;
        byte[] mRawFrame;
        int mRawFrameLen;
        boolean mRawFrameTruncated;
        String mServiceName;
        String mSrcIp;
        int mSrcPort;
        int mVdevId;
        int mWakeReason;
        String mWakeReasonStr;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public WakePacketReportItem(CaeWifiStatusCollect r8, WakePacketParcel r10) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_WAKE_PACKET);
            this.mWakeReasonStr = "";
            this.mPacketTypeStr = "";
            this.mProtocolName = "";
            this.mDstTypeStr = "";
            this.mRawFrame = new byte[0];
            this.mSrcIp = "";
            this.mDstIp = "";
            this.mIpProtocolStr = "";
            this.mServiceName = "";
            if (r10 != null) goto L5;
            return;
        L5:
            this.mWakeReason = r10.f4244a;
            this.mWakeReasonStr = CaeWifiStatusCollect.access$400(r8, r10.f4245b);
            this.mVdevId = r10.f4246m;
            this.mPacketType = r10.f4247n;
            this.mPacketTypeStr = CaeWifiStatusCollect.access$400(r8, r10.f4248o);
            this.mProtocolType = r10.f4249p;
            this.mProtocolName = CaeWifiStatusCollect.access$400(r8, r10.f4250q);
            this.mPacketLen = r10.f4251r;
            this.mDelayedPktCount = r10.f4252s;
            int r11 = r10.f4253t;
            this.mDstType = r11;
            this.mDstTypeStr = CaeWifiStatusCollect.access$500(r8, r11);
            this.mRawFrameLen = r10.f4254u;
            this.mRawFrameTruncated = r10.f4255v;
            byte[] r12 = r10.f4256w;
            if (r12 != null) goto L8;
            r12 = new byte[0];
        L8:
            this.mRawFrame = r12;
            this.mSrcIp = CaeWifiStatusCollect.access$400(r8, r10.f4257x);
            this.mDstIp = CaeWifiStatusCollect.access$400(r8, r10.f4258y);
            this.mIpProtocol = r10.f4259z;
            this.mIpProtocolStr = CaeWifiStatusCollect.access$400(r8, r10.A);
            this.mSrcPort = r10.B;
            this.mDstPort = r10.C;
            this.mServiceName = CaeWifiStatusCollect.access$400(r8, r10.D);
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            WakePacketReportData.Builder r8 = WakePacketReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setWakeReason(this.mWakeReason);
            r8.setWakeReasonStr(this.mWakeReasonStr);
            r8.setVdevId(this.mVdevId);
            r8.setPacketType(this.mPacketType);
            r8.setPacketTypeStr(this.mPacketTypeStr);
            r8.setProtocolType(this.mProtocolType);
            r8.setProtocolName(this.mProtocolName);
            r8.setPacketLen(this.mPacketLen);
            r8.setDelayedPktCount(this.mDelayedPktCount);
            r8.setDstType(this.mDstType);
            r8.setDstTypeStr(this.mDstTypeStr);
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            r8.setRawFrameLen(this.mRawFrameLen);
            r8.setRawFrameTruncated(this.mRawFrameTruncated);
            byte[] r10 = this.mRawFrame;
            if (r10.length <= 0) goto L5;
            r8.setRawFrame(ByteString.copyFrom(r10));
        L5:
            r8.setSrcIp(this.mSrcIp);
            r8.setDstIp(this.mDstIp);
            r8.setIpProtocol(this.mIpProtocol);
            r8.setIpProtocolStr(this.mIpProtocolStr);
            r8.setSrcPort(this.mSrcPort);
            r8.setDstPort(this.mDstPort);
            r8.setServiceName(this.mServiceName);
            CaeWifiServiceProto.Builder r11 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r12 = CaeWifiServiceProtoData.newBuilder();
            r12.setWakePacketReport(r8);
            r11.addCaeWifiServiceProto(r12);
            boolean r13 = CaeUtil.writePbEventSafely(getTimestamp(), 52, r11.build().toByteArray());
            String r14 = CaeWifiStatusCollect.access$200();
            StringBuilder r15 = new StringBuilder("wifi_wake_packet pb write ");
            if (r13 == false) goto L8;
            String r16 = "success";
        L9:
            r15.append(r16);
            r15.append(", wakeReason=");
            r15.append(this.mWakeReasonStr);
            r15.append(", packetType=");
            r15.append(this.mPacketTypeStr);
            r15.append(", protocol=");
            r15.append(this.mProtocolName);
            r15.append(", srcIp=");
            r15.append(this.mSrcIp);
            r15.append(", dstIp=");
            r15.append(this.mDstIp);
            r15.append(", ipProtocol=");
            r15.append(this.mIpProtocolStr);
            r15.append(", srcPort=");
            r15.append(this.mSrcPort);
            r15.append(", dstPort=");
            r15.append(this.mDstPort);
            r15.append(", service=");
            r15.append(this.mServiceName);
            r15.append(", rawFrameLen=");
            r15.append(this.mRawFrameLen);
            r15.append(", rawFrameTruncated=");
            r15.append(this.mRawFrameTruncated);
            CaeLog.i(r14, r15.toString());
            return;
        L8:
            r16 = "failed";
            goto L9
        }
    }

    public class WlanCrashReportItem extends ReportItem {
        int mCnssPlatQuirks;
        int mConnectedLast;
        String mDeviceDevStateStr;
        String mDeviceExecStr;
        int mDeviceId;
        int mDriverState;
        String mHostDevStateStr;
        String mHostExecStr;
        String mHostHangFunc;
        int mHostHangLine;
        String mHostPmStateStr;
        int mMhiState;
        int mPciLinkDownInd;
        int mPciLinkState;
        String mRddmSfrInfo;
        int mReason;
        String mReasonStr;
        int mRecoveryCount;
        String mSubReason;
        String mTriggerSource;
        String mWlanDriverVersion;
        String mWlanFwBuildTimestamp;
        int mWlanFwVersion;
        String mWlanFwVersionStr;
        final /* synthetic */ CaeWifiStatusCollect this$0;

        public WlanCrashReportItem(CaeWifiStatusCollect r8, WlanCrashParcel r10) {
            this.this$0 = r8;
            super(r8, ReportItemType.REPORT_TYPE_WLAN_CRASH);
            this.mSubReason = "";
            this.mRddmSfrInfo = "";
            this.mHostPmStateStr = "";
            this.mHostDevStateStr = "";
            this.mHostExecStr = "";
            this.mDeviceExecStr = "";
            this.mDeviceDevStateStr = "";
            this.mHostHangFunc = "";
            this.mReasonStr = "";
            this.mTriggerSource = "";
            this.mWlanDriverVersion = "";
            this.mWlanFwVersionStr = "";
            this.mWlanFwBuildTimestamp = "";
            if (r10 != null) goto L5;
            return;
        L5:
            this.mReason = r10.f4260a;
            this.mSubReason = CaeWifiStatusCollect.access$400(r8, r10.f4273x);
            this.mPciLinkState = r10.f4261b;
            this.mPciLinkDownInd = r10.f4262m;
            this.mMhiState = r10.f4263n;
            this.mDriverState = r10.f4264o;
            this.mCnssPlatQuirks = r10.f4265p;
            this.mConnectedLast = r10.f4266q;
            this.mRddmSfrInfo = CaeWifiStatusCollect.access$400(r8, r10.f4267r);
            this.mHostPmStateStr = CaeWifiStatusCollect.access$400(r8, r10.f4268s);
            this.mHostDevStateStr = CaeWifiStatusCollect.access$400(r8, r10.f4269t);
            this.mHostExecStr = CaeWifiStatusCollect.access$400(r8, r10.f4270u);
            this.mDeviceExecStr = CaeWifiStatusCollect.access$400(r8, r10.f4271v);
            this.mDeviceDevStateStr = CaeWifiStatusCollect.access$400(r8, r10.f4272w);
            this.mHostHangLine = r10.f4274y;
            this.mHostHangFunc = CaeWifiStatusCollect.access$400(r8, r10.f4275z);
            this.mReasonStr = CaeWifiStatusCollect.access$400(r8, r10.A);
            this.mRecoveryCount = r10.B;
            this.mTriggerSource = CaeWifiStatusCollect.access$400(r8, r10.C);
            this.mDeviceId = r10.D;
            this.mWlanDriverVersion = CaeWifiStatusCollect.access$400(r8, r10.E);
            this.mWlanFwVersion = r10.F;
            this.mWlanFwVersionStr = CaeWifiStatusCollect.access$400(r8, r10.G);
            this.mWlanFwBuildTimestamp = CaeWifiStatusCollect.access$400(r8, r10.H);
        }

        @Override // com.obric.cae.statusReport.wifi.CaeWifiStatusCollect.ReportItem
        public void buildEvents() {
            WlanCrashReportData.Builder r8 = WlanCrashReportData.newBuilder();
            r8.setEventType(getType().getEventName());
            r8.setReason(this.mReason);
            r8.setSubReason(this.mSubReason);
            r8.setPciLinkState(this.mPciLinkState);
            r8.setPciLinkDownInd(this.mPciLinkDownInd);
            r8.setMhiState(this.mMhiState);
            r8.setDriverState(this.mDriverState);
            r8.setCnssPlatQuirks(this.mCnssPlatQuirks);
            r8.setConnectedLast(this.mConnectedLast);
            r8.setRddmSfrInfo(this.mRddmSfrInfo);
            r8.setHostPmStateStr(this.mHostPmStateStr);
            r8.setHostDevStateStr(this.mHostDevStateStr);
            r8.setHostExecStr(this.mHostExecStr);
            r8.setDeviceExecStr(this.mDeviceExecStr);
            r8.setDeviceDevStateStr(this.mDeviceDevStateStr);
            r8.setHostHangLine(this.mHostHangLine);
            r8.setHostHangFunc(this.mHostHangFunc);
            r8.setDeviceTime(getTimestamp());
            r8.setDeviceDate(CaeUtil.timeMillisToDateString(getTimestamp()));
            r8.setReasonStr(this.mReasonStr);
            r8.setRecoveryCount(this.mRecoveryCount);
            r8.setTriggerSource(this.mTriggerSource);
            r8.setDeviceId(this.mDeviceId);
            r8.setWlanDriverVersion(this.mWlanDriverVersion);
            r8.setWlanFwVersion(this.mWlanFwVersion);
            r8.setWlanFwBuildTimestamp(this.mWlanFwBuildTimestamp);
            r8.setWlanFwVersionStr(this.mWlanFwVersionStr);
            CaeWifiServiceProto.Builder r10 = CaeWifiServiceProto.newBuilder();
            CaeWifiServiceProtoData.Builder r11 = CaeWifiServiceProtoData.newBuilder();
            r11.setWlanCrashReport(r8);
            r10.addCaeWifiServiceProto(r11);
            boolean r12 = CaeUtil.writePbEventSafely(getTimestamp(), 52, r10.build().toByteArray());
            String r13 = CaeWifiStatusCollect.access$200();
            StringBuilder r14 = new StringBuilder("wifi_wlan_crash pb write ");
            if (r12 == false) goto L5;
            String r15 = "success";
        L6:
            r14.append(r15);
            r14.append(", reason=");
            r14.append(this.mReason);
            r14.append(", reasonStr=");
            r14.append(this.mReasonStr);
            r14.append(", subReason=");
            r14.append(this.mSubReason);
            r14.append(", recoveryCount=");
            r14.append(this.mRecoveryCount);
            r14.append(", triggerSource=");
            r14.append(this.mTriggerSource);
            r14.append(", deviceId=");
            r14.append(this.mDeviceId);
            r14.append(", driverVersion=");
            r14.append(this.mWlanDriverVersion);
            r14.append(", fwVersion=");
            r14.append(this.mWlanFwVersion);
            r14.append(", fwVersionStr=");
            r14.append(this.mWlanFwVersionStr);
            r14.append(", fwBuildTimestamp=");
            android.aimedia.a.r(r14, this.mWlanFwBuildTimestamp, r13);
            return;
        L5:
            r15 = "failed";
            goto L6
        }
    }

    public CaeWifiStatusCollect() {
        this.mConnectedTimeStamp = 0;
        this.MSG_HANDLE_WIFI_REPORT = 0;
        this.mUPnPDevs = new HashMap();
    }

    public static /* synthetic */ void a(CaeWifiStatusCollect r8, String r10, String r11, CaeWifiInfo r12) {
        r8.lambda$reportUPnPDeviceInfo$0(r10, r11, r12);
    }

    public static /* synthetic */ int access$100(CaeWifiStatusCollect r8) {
        return r8.MSG_HANDLE_WIFI_REPORT;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ int access$300(CaeWifiStatusCollect r8, Object r10, Object r11, Object r12, Object r13, Object r14) {
        return r8.minLen(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ String access$400(CaeWifiStatusCollect r8, String r10) {
        return r8.safeString(r10);
    }

    public static /* synthetic */ String access$500(CaeWifiStatusCollect r8, int r10) {
        return r8.wakeDstTypeToString(r10);
    }

    public static CaeWifiStatusCollect getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new CaeWifiStatusCollect();
    L6:
        return sInstance;
    }

    private /* synthetic */ void lambda$reportUPnPDeviceInfo$0(String r11, String r12, CaeWifiInfo r13) {
        Iterator<UPnPDevice> r8 = new UPnPDiscovery().discoveryUPnPDevices().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        UPnPDevice r10 = r8.next();
        if (r10.getHostAddress().equals(r11) == false) goto L4;
        this.mUPnPDevs.put(r12, r10);
        r13.setFriendlyName(r10.getFriendlyName());
        r13.setManufacaturer(r10.getManufacturer());
        sendWifiReport(new RouterModelReportItem(this, r13.getBssid(), r10.getManufacturer(), r10.getFriendlyName(), r13.getWifigenertaion(), r13.getMloEnable()));
        goto L4
    }

    private int minLen(Object r8, Object r10, Object r11, Object r12, Object r13) {
        Object[] r14 = {r8, r10, r11, r12, r13};
        int r15 = Integer.MAX_VALUE;
        int r16 = 0;
    L4:
        if (r16 >= 5) goto L16;
        Object r17 = r14[r16];
        if (r17 == null) goto L7;
        if ((r17 instanceof Object[]) == false) goto L12;
        int r18 = ((Object[]) r17).length;
    L14:
        r15 = Math.min(r15, r18);
        r16 = r16 + 1;
        goto L4
    L12:
        if ((r17 instanceof int[]) == false) goto L15;
        r18 = ((int[]) r17).length;
        goto L14
    L15:
        return 0;
    L7:
        return 0;
    L16:
        if (r15 != Integer.MAX_VALUE) goto L19;
        return 0;
    L19:
        return r15;
    }

    private int parseIntSafe(String r8) {
        if (r8 != null) goto L8;
        return 0;
    L8:
        return Integer.parseInt(r8);
    L10:
        return 0;
    }

    private String safeString(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }

    private void sendWifiReport(ReportItem r8) {
        this.mHandler.obtainMessage(this.MSG_HANDLE_WIFI_REPORT, r8).sendToTarget();
    }

    private String wakeDstTypeToString(int r8) {
        if (r8 != 1) goto L5;
        return "UNICAST";
    L5:
        if (r8 != 2) goto L7;
        return "MULTICAST";
    L7:
        if (r8 == 3) goto L10;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L10:
        return "BROADCAST";
    }

    public void cleanup() {
        Handler r8 = this.mHandler;
        if (r8 == null) goto L6;
        r8.removeCallbacksAndMessages(null);
        this.mHandler.getLooper().quitSafely();
        this.mHandler = null;
        return;
    }

    public void init(Context r8, WifiManager r10) {
        if (sInited == false) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        return;
    L7:
        sInited = true;
        this.mContext = r8.getApplicationContext();
        this.mLastPowerStatsInfo = new PowerStatsInfo(this, null);
        HandlerThread r11 = new HandlerThread("caewifistatus");
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new ReportQueueProcessHandler(this, this.mHandlerThread.getLooper());
    }

    public void reportConnectionTime(SupplicantState r18, CaeWifiInfo r19) {
        long r12 = SystemClock.uptimeMillis();
        if (r18 != SupplicantState.COMPLETED) goto L11;
        long r8 = this.mConnectedTimeStamp;
        if (r8 == 0) goto L9;
        long r10 = (r12 - r8) / 1000;
        if (r10 <= 30) goto L9;
        sendWifiReport(new ConnectionTimeReportItem(this, r10, r19.getBssid(), r19.getBand(), r19.getBand1(), r19.getFrequency(), r19.getFrequency1(), r19.getWifigenertaion(), r19.getMloEnable()));
    L9:
        this.mConnectedTimeStamp = r12;
        return;
    L11:
        if (r18 != SupplicantState.DISCONNECTED) goto L17;
        long r11 = this.mConnectedTimeStamp;
        if (r11 == 0) goto L17;
        long r13 = (r12 - r11) / 1000;
        if (r13 <= 30) goto L17;
        sendWifiReport(new ConnectionTimeReportItem(this, r13, r19.getBssid(), r19.getBand(), r19.getBand1(), r19.getFrequency(), r19.getFrequency1(), r19.getWifigenertaion(), r19.getMloEnable()));
    L17:
        this.mConnectedTimeStamp = 0;
    }

    public void reportLinkLayerQuality(LinkLayerQuality r11) {
        sendWifiReport(new LinkLayerQualityReportItem(this, r11, r11.getFreq(), r11.getTxlinkSpeed(), r11.getRxlinkSpeed(), r11.getBand(), r11.getBand1(), r11.getWifiGeneration()));
    }

    public void reportPoorLinkDisconnect(int r12, String r13, int r14, int r15, int r16, int r17, int r18, String r19) {
        sendWifiReport(new PoorLinkDisconnectReportItem(this, r12, r13, r14, r15, r16, r17, r18, r19));
    }

    public void reportPowerStats(int r17) {
        String r8 = CaeUtil.readFileByFullPath(POWER_STATS_PATH);
        long r10 = CaeUtil.extractValue(r8, "cumulative_sleep_time_ms");
        long r11 = CaeUtil.extractValue(r8, "cumulative_total_on_time_ms");
        long r12 = CaeUtil.extractValue(r8, "deep_sleep_enter_counter");
        long r13 = CaeUtil.extractValue(r8, "last_deep_sleep_enter_tstamp_ms");
        long r14 = SystemClock.elapsedRealtime();
        if (r17 != 0) goto L6;
        PowerStatsInfo r15 = this.mLastPowerStatsInfo;
        r15.mSleepTime = r10;
        r15.mTotalOnTime = r11;
        r15.mSleepEnterCounter = r12;
        r15.mLastSleepTstamp = r13;
        this.mScreenOffTstamp = r14;
    L6:
        if (r17 != 1) goto L14;
        PowerStatsInfo r16 = this.mLastPowerStatsInfo;
        int r18 = (int) (r10 - r16.mSleepTime);
        int r19 = (int) (r11 - r16.mTotalOnTime);
        int r20 = (int) (r12 - r16.mSleepEnterCounter);
        int r21 = (int) (r13 - r16.mLastSleepTstamp);
        int r22 = (int) (r14 - this.mScreenOffTstamp);
        if (r19 > 0) goto L10;
        return;
    L10:
        if (r22 <= POWER_STATS_SCREEN_OFF_MINTIME) goto L16;
        sendWifiReport(new PowerStatsReportItem(this, r18, r19, r20, r21, (r19 * 100) / r22));
        return;
    L16:
        return;
    }

    public void reportRoamSuccess(CaeRoamParcel r17) {
        if (r17 != null) goto L5;
        return;
    L5:
        sendWifiReport(new RoamSuccessReportItem(this, String.valueOf(r17.f4228a), parseIntSafe(String.valueOf(r17.f4230m)), String.valueOf(r17.f4231n), r17.f4232o, r17.f4233p, r17.f4235r, String.valueOf(r17.f4236s), r17.f4240w, r17.f4241x, r17.f4242y, r17.f4243z, r17.A));
    }

    public void reportUPnPDeviceInfo(String r10, String r11, CaeWifiInfo r12) {
        if (r10 != null) goto L4;
    L16:
        CaeLog.d(TAG, "skip UPnP info report, invalid connection info");
        return;
    L4:
        if (r10.isEmpty() == true) goto L16;
        if (r11 == null) goto L16;
        if (r11.isEmpty() == true) goto L16;
        if (r12 == null) goto L16;
        if (this.mUPnPDevs.containsKey(r11) == false) goto L14;
        CaeLog.d(TAG, "already reported UPnP info, bssid=" + CaeWifiUtil.maskMACAddress(r11));
        return;
    L14:
        new Thread(new a(this, r10, r11, r12, 0), "ReportUPnPDeviceInfoThread").start();
    }

    public void reportWakePacket(WakePacketParcel r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        sendWifiReport(new WakePacketReportItem(this, r8));
    }

    public void reportWlanCrash(WlanCrashParcel r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        sendWifiReport(new WlanCrashReportItem(this, r8));
    }
}
