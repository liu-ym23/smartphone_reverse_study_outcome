package com.obric.cae.wifi;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.obric.cae.network.BlockedReason;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class LinkLayerQualityReportData extends GeneratedMessageV3 implements LinkLayerQualityReportDataOrBuilder {
    public static final int ARPNEIGHBOURCOUNT_FIELD_NUMBER = 34;
    public static final int BAND_FIELD_NUMBER = 35;
    public static final int CCALEVEL_FIELD_NUMBER = 10;
    public static final int CCASCORE_FIELD_NUMBER = 2;
    public static final int CONTENTION_ATIME_BE_FIELD_NUMBER = 27;
    public static final int CONTENTION_ATIME_BK_FIELD_NUMBER = 58;
    public static final int CONTENTION_ATIME_VI_FIELD_NUMBER = 59;
    public static final int CONTENTION_ATIME_VO_FIELD_NUMBER = 28;
    public static final int CURRENTCHANNELAPCOUNT_FIELD_NUMBER = 33;
    private static final LinkLayerQualityReportData DEFAULT_INSTANCE = null;
    public static final int DELAY_SIZE_MATRIX_FIELD_NUMBER = 64;
    public static final int DELTARADIOONTIME_FIELD_NUMBER = 9;
    public static final int DELTARXBYTES_FIELD_NUMBER = 19;
    public static final int DELTARXSUCCESS_FIELD_NUMBER = 13;
    public static final int DELTATXBYTES_FIELD_NUMBER = 16;
    public static final int DELTATXSUCCESS_FIELD_NUMBER = 11;
    public static final int DELTA_CHANNEL_CCA_BUSY_TIME_FIELD_NUMBER = 56;
    public static final int DELTA_CHANNEL_ON_TIME_FIELD_NUMBER = 53;
    public static final int DELTA_CHANNEL_RX_TIME_FIELD_NUMBER = 55;
    public static final int DELTA_CHANNEL_TX_TIME_FIELD_NUMBER = 54;
    public static final int DEVICE_DATE_FIELD_NUMBER = 32;
    public static final int DEVICE_TIME_FIELD_NUMBER = 31;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int FREQUENCY_FIELD_NUMBER = 6;
    public static final int ON_TIME_SCAN_FIELD_NUMBER = 48;

    @Deprecated
    public static final Parser<LinkLayerQualityReportData> PARSER = null;
    public static final int PERSCORE_FIELD_NUMBER = 3;
    public static final int PER_FIELD_NUMBER = 47;
    public static final int POWER_PRED_MW_FIELD_NUMBER = 57;
    public static final int RL_CCA_BUSY_RATE_FIELD_NUMBER = 46;
    public static final int RL_RX_LINK_SPEED_FIELD_NUMBER = 45;
    public static final int RL_TX_LINK_SPEED_FIELD_NUMBER = 44;
    public static final int RSSISCORE_FIELD_NUMBER = 4;
    public static final int RSSI_ACK_FIELD_NUMBER = 43;
    public static final int RSSI_DATA_FIELD_NUMBER = 42;
    public static final int RSSI_MGMT_FIELD_NUMBER = 41;
    public static final int RXBW_FIELD_NUMBER = 26;
    public static final int RXFCSERRLEVEL_FIELD_NUMBER = 14;
    public static final int RXLINKSPEED_FIELD_NUMBER = 8;
    public static final int RXMCS_FIELD_NUMBER = 25;
    public static final int RXMODE_FIELD_NUMBER = 24;
    public static final int RXNSS_FIELD_NUMBER = 52;
    public static final int RXREALSPEED_FIELD_NUMBER = 20;
    public static final int RX_SPEED_KBPS_FIELD_NUMBER = 50;
    public static final int RX_TPUT_PRED_FIELD_NUMBER = 37;
    public static final int SCENARIO_FIELD_NUMBER = 5;
    public static final int TOTALRXBYTES_FIELD_NUMBER = 18;
    public static final int TOTALTXBYTES_FIELD_NUMBER = 15;
    public static final int TOTALTXRETRANLEVELBE_FIELD_NUMBER = 29;
    public static final int TOTALTXRETRANLEVELVO_FIELD_NUMBER = 30;
    public static final int TXBW_FIELD_NUMBER = 23;
    public static final int TXLINKSPEED_FIELD_NUMBER = 7;
    public static final int TXMCS_FIELD_NUMBER = 22;
    public static final int TXMODE_FIELD_NUMBER = 21;
    public static final int TXNSS_FIELD_NUMBER = 51;
    public static final int TXREALSPEED_FIELD_NUMBER = 17;
    public static final int TXRETRANLEVEL_FIELD_NUMBER = 12;
    public static final int TX_DELAY_AVG_FIELD_NUMBER = 60;
    public static final int TX_DELAY_P10_FIELD_NUMBER = 61;
    public static final int TX_DELAY_P90_FIELD_NUMBER = 62;
    public static final int TX_DELAY_PKTS_FIELD_NUMBER = 63;
    public static final int TX_SPEED_KBPS_FIELD_NUMBER = 49;
    public static final int TX_TPUT_PRED_FIELD_NUMBER = 38;
    public static final int WIDTH_FIELD_NUMBER = 40;
    public static final int WIFIGENERATION_FIELD_NUMBER = 36;
    public static final int WIFI_STANDARD_FIELD_NUMBER = 39;
    private static final long serialVersionUID = 0;
    private int arpNeighbourCount_;
    private volatile Object band_;
    private int bitField0_;
    private int bitField1_;
    private int ccaLevel_;
    private int ccaScore_;
    private int contentionAtimeBe_;
    private int contentionAtimeBk_;
    private int contentionAtimeVi_;
    private int contentionAtimeVo_;
    private int currentChannelAPCount_;
    private Internal.IntList delaySizeMatrix_;
    private int deltaChannelCcaBusyTime_;
    private int deltaChannelOnTime_;
    private int deltaChannelRxTime_;
    private int deltaChannelTxTime_;
    private int deltaRadioOnTime_;
    private int deltaRxBytes_;
    private long deltaRxSuccess_;
    private int deltaTxBytes_;
    private long deltaTxSuccess_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private int frequency_;
    private byte memoizedIsInitialized;
    private int onTimeScan_;
    private int perScore_;
    private int per_;
    private float powerPredMw_;
    private int rlCcaBusyRate_;
    private int rlRxLinkSpeed_;
    private int rlTxLinkSpeed_;
    private int rssiAck_;
    private int rssiData_;
    private int rssiMgmt_;
    private int rssiScore_;
    private int rxBw_;
    private int rxFcsErrLevel_;
    private int rxLinkSpeed_;
    private int rxMcs_;
    private int rxMode_;
    private int rxNss_;
    private int rxRealSpeed_;
    private int rxSpeedKbps_;
    private int rxTputPred_;
    private int scenario_;
    private int totalRxBytes_;
    private int totalTxBytes_;
    private long totalTxRetranLevelBe_;
    private long totalTxRetranLevelVo_;
    private int txBw_;
    private float txDelayAvg_;
    private float txDelayP10_;
    private float txDelayP90_;
    private long txDelayPkts_;
    private int txLinkSpeed_;
    private int txMcs_;
    private int txMode_;
    private int txNss_;
    private int txRealSpeed_;
    private int txRetranLevel_;
    private int txSpeedKbps_;
    private int txTputPred_;
    private int width_;
    private int wifiStandard_;
    private volatile Object wifigeneration_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkLayerQualityReportDataOrBuilder {
        private int arpNeighbourCount_;
        private Object band_;
        private int bitField0_;
        private int bitField1_;
        private int ccaLevel_;
        private int ccaScore_;
        private int contentionAtimeBe_;
        private int contentionAtimeBk_;
        private int contentionAtimeVi_;
        private int contentionAtimeVo_;
        private int currentChannelAPCount_;
        private Internal.IntList delaySizeMatrix_;
        private int deltaChannelCcaBusyTime_;
        private int deltaChannelOnTime_;
        private int deltaChannelRxTime_;
        private int deltaChannelTxTime_;
        private int deltaRadioOnTime_;
        private int deltaRxBytes_;
        private long deltaRxSuccess_;
        private int deltaTxBytes_;
        private long deltaTxSuccess_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private int frequency_;
        private int onTimeScan_;
        private int perScore_;
        private int per_;
        private float powerPredMw_;
        private int rlCcaBusyRate_;
        private int rlRxLinkSpeed_;
        private int rlTxLinkSpeed_;
        private int rssiAck_;
        private int rssiData_;
        private int rssiMgmt_;
        private int rssiScore_;
        private int rxBw_;
        private int rxFcsErrLevel_;
        private int rxLinkSpeed_;
        private int rxMcs_;
        private int rxMode_;
        private int rxNss_;
        private int rxRealSpeed_;
        private int rxSpeedKbps_;
        private int rxTputPred_;
        private int scenario_;
        private int totalRxBytes_;
        private int totalTxBytes_;
        private long totalTxRetranLevelBe_;
        private long totalTxRetranLevelVo_;
        private int txBw_;
        private float txDelayAvg_;
        private float txDelayP10_;
        private float txDelayP90_;
        private long txDelayPkts_;
        private int txLinkSpeed_;
        private int txMcs_;
        private int txMode_;
        private int txNss_;
        private int txRealSpeed_;
        private int txRetranLevel_;
        private int txSpeedKbps_;
        private int txTputPred_;
        private int width_;
        private int wifiStandard_;
        private Object wifigeneration_;

        private Builder() {
            this.eventType_ = "";
            this.deviceDate_ = "";
            this.band_ = "";
            this.wifigeneration_ = "";
            this.delaySizeMatrix_ = LinkLayerQualityReportData.access$7000();
        }

        private void buildPartial0(LinkLayerQualityReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            LinkLayerQualityReportData.access$502(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            LinkLayerQualityReportData.access$602(r8, this.ccaScore_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            LinkLayerQualityReportData.access$702(r8, this.perScore_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            LinkLayerQualityReportData.access$802(r8, this.rssiScore_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            LinkLayerQualityReportData.access$902(r8, this.scenario_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            LinkLayerQualityReportData.access$1002(r8, this.frequency_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            LinkLayerQualityReportData.access$1102(r8, this.txLinkSpeed_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            LinkLayerQualityReportData.access$1202(r8, this.rxLinkSpeed_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            LinkLayerQualityReportData.access$1302(r8, this.deltaRadioOnTime_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            LinkLayerQualityReportData.access$1402(r8, this.ccaLevel_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            LinkLayerQualityReportData.access$1502(r8, this.deltaTxSuccess_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            LinkLayerQualityReportData.access$1602(r8, this.txRetranLevel_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            LinkLayerQualityReportData.access$1702(r8, this.deltaRxSuccess_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            LinkLayerQualityReportData.access$1802(r8, this.rxFcsErrLevel_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            LinkLayerQualityReportData.access$1902(r8, this.totalTxBytes_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            LinkLayerQualityReportData.access$2002(r8, this.deltaTxBytes_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            LinkLayerQualityReportData.access$2102(r8, this.txRealSpeed_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            LinkLayerQualityReportData.access$2202(r8, this.totalRxBytes_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            LinkLayerQualityReportData.access$2302(r8, this.deltaRxBytes_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            LinkLayerQualityReportData.access$2402(r8, this.rxRealSpeed_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            LinkLayerQualityReportData.access$2502(r8, this.txMode_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            LinkLayerQualityReportData.access$2602(r8, this.txMcs_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            LinkLayerQualityReportData.access$2702(r8, this.txBw_);
            r11 = r11 | 4194304;
        L73:
            if ((8388608 & r10) == 0) goto L76;
            LinkLayerQualityReportData.access$2802(r8, this.rxMode_);
            r11 = r11 | 8388608;
        L76:
            if ((16777216 & r10) == 0) goto L79;
            LinkLayerQualityReportData.access$2902(r8, this.rxMcs_);
            r11 = r11 | 16777216;
        L79:
            if ((33554432 & r10) == 0) goto L82;
            LinkLayerQualityReportData.access$3002(r8, this.rxBw_);
            r11 = r11 | 33554432;
        L82:
            if ((67108864 & r10) == 0) goto L85;
            LinkLayerQualityReportData.access$3102(r8, this.contentionAtimeBe_);
            r11 = r11 | 67108864;
        L85:
            if ((134217728 & r10) == 0) goto L88;
            LinkLayerQualityReportData.access$3202(r8, this.contentionAtimeVo_);
            r11 = r11 | 134217728;
        L88:
            if ((268435456 & r10) == 0) goto L91;
            LinkLayerQualityReportData.access$3302(r8, this.totalTxRetranLevelBe_);
            r11 = r11 | 268435456;
        L91:
            if ((536870912 & r10) == 0) goto L94;
            LinkLayerQualityReportData.access$3402(r8, this.totalTxRetranLevelVo_);
            r11 = r11 | 536870912;
        L94:
            if ((1073741824 & r10) == 0) goto L97;
            LinkLayerQualityReportData.access$3502(r8, this.deviceTime_);
            r11 = r11 | 1073741824;
        L97:
            if ((r10 & Integer.MIN_VALUE) == 0) goto L99;
            LinkLayerQualityReportData.access$3602(r8, this.deviceDate_);
            r11 = r11 | Integer.MIN_VALUE;
        L99:
            LinkLayerQualityReportData.access$3776(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartial1(LinkLayerQualityReportData r8) {
            int r10 = this.bitField1_;
            if ((r10 & 1) == 0) goto L5;
            LinkLayerQualityReportData.access$3802(r8, this.currentChannelAPCount_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            LinkLayerQualityReportData.access$3902(r8, this.arpNeighbourCount_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            LinkLayerQualityReportData.access$4002(r8, this.band_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            LinkLayerQualityReportData.access$4102(r8, this.wifigeneration_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            LinkLayerQualityReportData.access$4202(r8, this.rxTputPred_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            LinkLayerQualityReportData.access$4302(r8, this.txTputPred_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            LinkLayerQualityReportData.access$4402(r8, this.wifiStandard_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            LinkLayerQualityReportData.access$4502(r8, this.width_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            LinkLayerQualityReportData.access$4602(r8, this.rssiMgmt_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            LinkLayerQualityReportData.access$4702(r8, this.rssiData_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            LinkLayerQualityReportData.access$4802(r8, this.rssiAck_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            LinkLayerQualityReportData.access$4902(r8, this.rlTxLinkSpeed_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            LinkLayerQualityReportData.access$5002(r8, this.rlRxLinkSpeed_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            LinkLayerQualityReportData.access$5102(r8, this.rlCcaBusyRate_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            LinkLayerQualityReportData.access$5202(r8, this.per_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            LinkLayerQualityReportData.access$5302(r8, this.onTimeScan_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            LinkLayerQualityReportData.access$5402(r8, this.txSpeedKbps_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            LinkLayerQualityReportData.access$5502(r8, this.rxSpeedKbps_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            LinkLayerQualityReportData.access$5602(r8, this.txNss_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            LinkLayerQualityReportData.access$5702(r8, this.rxNss_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            LinkLayerQualityReportData.access$5802(r8, this.deltaChannelOnTime_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            LinkLayerQualityReportData.access$5902(r8, this.deltaChannelTxTime_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            LinkLayerQualityReportData.access$6002(r8, this.deltaChannelRxTime_);
            r11 = r11 | 4194304;
        L73:
            if ((8388608 & r10) == 0) goto L76;
            LinkLayerQualityReportData.access$6102(r8, this.deltaChannelCcaBusyTime_);
            r11 = r11 | 8388608;
        L76:
            if ((16777216 & r10) == 0) goto L79;
            LinkLayerQualityReportData.access$6202(r8, this.powerPredMw_);
            r11 = r11 | 16777216;
        L79:
            if ((33554432 & r10) == 0) goto L82;
            LinkLayerQualityReportData.access$6302(r8, this.contentionAtimeBk_);
            r11 = r11 | 33554432;
        L82:
            if ((67108864 & r10) == 0) goto L85;
            LinkLayerQualityReportData.access$6402(r8, this.contentionAtimeVi_);
            r11 = r11 | 67108864;
        L85:
            if ((134217728 & r10) == 0) goto L88;
            LinkLayerQualityReportData.access$6502(r8, this.txDelayAvg_);
            r11 = r11 | 134217728;
        L88:
            if ((268435456 & r10) == 0) goto L91;
            LinkLayerQualityReportData.access$6602(r8, this.txDelayP10_);
            r11 = r11 | 268435456;
        L91:
            if ((536870912 & r10) == 0) goto L94;
            LinkLayerQualityReportData.access$6702(r8, this.txDelayP90_);
            r11 = r11 | 536870912;
        L94:
            if ((r10 & 1073741824) == 0) goto L96;
            LinkLayerQualityReportData.access$6802(r8, this.txDelayPkts_);
            r11 = r11 | 1073741824;
        L96:
            LinkLayerQualityReportData.access$6976(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(LinkLayerQualityReportData r8) {
            if ((this.bitField1_ & Integer.MIN_VALUE) == 0) goto L5;
            this.delaySizeMatrix_.makeImmutable();
            this.bitField1_ &= Integer.MAX_VALUE;
        L5:
            LinkLayerQualityReportData.access$402(r8, this.delaySizeMatrix_);
        }

        private void ensureDelaySizeMatrixIsMutable() {
            if ((this.bitField1_ & Integer.MIN_VALUE) != 0) goto L6;
            this.delaySizeMatrix_ = LinkLayerQualityReportData.access$7100(this.delaySizeMatrix_);
            this.bitField1_ |= Integer.MIN_VALUE;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkLayerQualityReportData_descriptor;
        }

        public Builder addAllDelaySizeMatrix(Iterable<? extends Integer> r8) {
            ensureDelaySizeMatrixIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.delaySizeMatrix_);
            onChanged();
            return this;
        }

        public Builder addDelaySizeMatrix(int r8) {
            ensureDelaySizeMatrixIsMutable();
            this.delaySizeMatrix_.addInt(r8);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearArpNeighbourCount() {
            this.bitField1_ &= -3;
            this.arpNeighbourCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBand() {
            this.band_ = LinkLayerQualityReportData.getDefaultInstance().getBand();
            this.bitField1_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearCcaLevel() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.ccaLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCcaScore() {
            this.bitField0_ &= -3;
            this.ccaScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeBe() {
            this.bitField0_ &= -67108865;
            this.contentionAtimeBe_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeBk() {
            this.bitField1_ &= -33554433;
            this.contentionAtimeBk_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeVi() {
            this.bitField1_ &= -67108865;
            this.contentionAtimeVi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeVo() {
            this.bitField0_ &= -134217729;
            this.contentionAtimeVo_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCurrentChannelAPCount() {
            this.bitField1_ &= -2;
            this.currentChannelAPCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDelaySizeMatrix() {
            this.delaySizeMatrix_ = LinkLayerQualityReportData.access$7200();
            this.bitField1_ &= Integer.MAX_VALUE;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelCcaBusyTime() {
            this.bitField1_ &= -8388609;
            this.deltaChannelCcaBusyTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelOnTime() {
            this.bitField1_ &= -1048577;
            this.deltaChannelOnTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelRxTime() {
            this.bitField1_ &= -4194305;
            this.deltaChannelRxTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelTxTime() {
            this.bitField1_ &= -2097153;
            this.deltaChannelTxTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaRadioOnTime() {
            this.bitField0_ &= -257;
            this.deltaRadioOnTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaRxBytes() {
            this.bitField0_ &= -262145;
            this.deltaRxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaRxSuccess() {
            this.bitField0_ &= -4097;
            this.deltaRxSuccess_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaTxBytes() {
            this.bitField0_ &= -32769;
            this.deltaTxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaTxSuccess() {
            this.bitField0_ &= -1025;
            this.deltaTxSuccess_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = LinkLayerQualityReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= Integer.MAX_VALUE;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -1073741825;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = LinkLayerQualityReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearFrequency() {
            this.bitField0_ &= -33;
            this.frequency_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOnTimeScan() {
            this.bitField1_ &= -32769;
            this.onTimeScan_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPer() {
            this.bitField1_ &= -16385;
            this.per_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPerScore() {
            this.bitField0_ &= -5;
            this.perScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPowerPredMw() {
            this.bitField1_ &= -16777217;
            this.powerPredMw_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearRlCcaBusyRate() {
            this.bitField1_ &= -8193;
            this.rlCcaBusyRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRlRxLinkSpeed() {
            this.bitField1_ &= -4097;
            this.rlRxLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRlTxLinkSpeed() {
            this.bitField1_ &= -2049;
            this.rlTxLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiAck() {
            this.bitField1_ &= -1025;
            this.rssiAck_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiData() {
            this.bitField1_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.rssiData_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiMgmt() {
            this.bitField1_ &= -257;
            this.rssiMgmt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiScore() {
            this.bitField0_ &= -9;
            this.rssiScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxBw() {
            this.bitField0_ &= -33554433;
            this.rxBw_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxFcsErrLevel() {
            this.bitField0_ &= -8193;
            this.rxFcsErrLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxLinkSpeed() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.rxLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxMcs() {
            this.bitField0_ &= -16777217;
            this.rxMcs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxMode() {
            this.bitField0_ &= -8388609;
            this.rxMode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxNss() {
            this.bitField1_ &= -524289;
            this.rxNss_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxRealSpeed() {
            this.bitField0_ &= -524289;
            this.rxRealSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxSpeedKbps() {
            this.bitField1_ &= -131073;
            this.rxSpeedKbps_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxTputPred() {
            this.bitField1_ &= -17;
            this.rxTputPred_ = 0;
            onChanged();
            return this;
        }

        public Builder clearScenario() {
            this.bitField0_ &= -17;
            this.scenario_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalRxBytes() {
            this.bitField0_ &= -131073;
            this.totalRxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalTxBytes() {
            this.bitField0_ &= -16385;
            this.totalTxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalTxRetranLevelBe() {
            this.bitField0_ &= -268435457;
            this.totalTxRetranLevelBe_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalTxRetranLevelVo() {
            this.bitField0_ &= -536870913;
            this.totalTxRetranLevelVo_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxBw() {
            this.bitField0_ &= -4194305;
            this.txBw_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxDelayAvg() {
            this.bitField1_ &= -134217729;
            this.txDelayAvg_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTxDelayP10() {
            this.bitField1_ &= -268435457;
            this.txDelayP10_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTxDelayP90() {
            this.bitField1_ &= -536870913;
            this.txDelayP90_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTxDelayPkts() {
            this.bitField1_ &= -1073741825;
            this.txDelayPkts_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxLinkSpeed() {
            this.bitField0_ &= -65;
            this.txLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMcs() {
            this.bitField0_ &= -2097153;
            this.txMcs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMode() {
            this.bitField0_ &= -1048577;
            this.txMode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxNss() {
            this.bitField1_ &= -262145;
            this.txNss_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRealSpeed() {
            this.bitField0_ &= -65537;
            this.txRealSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetranLevel() {
            this.bitField0_ &= -2049;
            this.txRetranLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxSpeedKbps() {
            this.bitField1_ &= -65537;
            this.txSpeedKbps_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxTputPred() {
            this.bitField1_ &= -33;
            this.txTputPred_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWidth() {
            this.bitField1_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.width_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiStandard() {
            this.bitField1_ &= -65;
            this.wifiStandard_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifigeneration() {
            this.wifigeneration_ = LinkLayerQualityReportData.getDefaultInstance().getWifigeneration();
            this.bitField1_ &= -9;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getArpNeighbourCount() {
            return this.arpNeighbourCount_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public String getBand() {
            Object r8 = this.band_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.band_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public ByteString getBandBytes() {
            Object r8 = this.band_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.band_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getCcaLevel() {
            return this.ccaLevel_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getCcaScore() {
            return this.ccaScore_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getContentionAtimeBe() {
            return this.contentionAtimeBe_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getContentionAtimeBk() {
            return this.contentionAtimeBk_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getContentionAtimeVi() {
            return this.contentionAtimeVi_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getContentionAtimeVo() {
            return this.contentionAtimeVo_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getCurrentChannelAPCount() {
            return this.currentChannelAPCount_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDelaySizeMatrix(int r8) {
            return this.delaySizeMatrix_.getInt(r8);
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDelaySizeMatrixCount() {
            return this.delaySizeMatrix_.size();
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public List<Integer> getDelaySizeMatrixList() {
            int r8 = this.bitField1_ & Integer.MIN_VALUE;
            Internal.IntList r10 = this.delaySizeMatrix_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelCcaBusyTime() {
            return this.deltaChannelCcaBusyTime_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelOnTime() {
            return this.deltaChannelOnTime_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelRxTime() {
            return this.deltaChannelRxTime_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelTxTime() {
            return this.deltaChannelTxTime_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDeltaRadioOnTime() {
            return this.deltaRadioOnTime_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDeltaRxBytes() {
            return this.deltaRxBytes_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public long getDeltaRxSuccess() {
            return this.deltaRxSuccess_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getDeltaTxBytes() {
            return this.deltaTxBytes_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public long getDeltaTxSuccess() {
            return this.deltaTxSuccess_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkLayerQualityReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public String getDeviceDate() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.deviceDate_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public String getEventType() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.eventType_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getFrequency() {
            return this.frequency_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getOnTimeScan() {
            return this.onTimeScan_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getPer() {
            return this.per_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getPerScore() {
            return this.perScore_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public float getPowerPredMw() {
            return this.powerPredMw_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRlCcaBusyRate() {
            return this.rlCcaBusyRate_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRlRxLinkSpeed() {
            return this.rlRxLinkSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRlTxLinkSpeed() {
            return this.rlTxLinkSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRssiAck() {
            return this.rssiAck_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRssiData() {
            return this.rssiData_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRssiMgmt() {
            return this.rssiMgmt_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRssiScore() {
            return this.rssiScore_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxBw() {
            return this.rxBw_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxFcsErrLevel() {
            return this.rxFcsErrLevel_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxLinkSpeed() {
            return this.rxLinkSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxMcs() {
            return this.rxMcs_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxMode() {
            return this.rxMode_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxNss() {
            return this.rxNss_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxRealSpeed() {
            return this.rxRealSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxSpeedKbps() {
            return this.rxSpeedKbps_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getRxTputPred() {
            return this.rxTputPred_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getScenario() {
            return this.scenario_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTotalRxBytes() {
            return this.totalRxBytes_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTotalTxBytes() {
            return this.totalTxBytes_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public long getTotalTxRetranLevelBe() {
            return this.totalTxRetranLevelBe_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public long getTotalTxRetranLevelVo() {
            return this.totalTxRetranLevelVo_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxBw() {
            return this.txBw_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public float getTxDelayAvg() {
            return this.txDelayAvg_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public float getTxDelayP10() {
            return this.txDelayP10_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public float getTxDelayP90() {
            return this.txDelayP90_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public long getTxDelayPkts() {
            return this.txDelayPkts_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxLinkSpeed() {
            return this.txLinkSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxMcs() {
            return this.txMcs_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxMode() {
            return this.txMode_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxNss() {
            return this.txNss_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxRealSpeed() {
            return this.txRealSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxRetranLevel() {
            return this.txRetranLevel_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxSpeedKbps() {
            return this.txSpeedKbps_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getTxTputPred() {
            return this.txTputPred_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public int getWifiStandard() {
            return this.wifiStandard_;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public String getWifigeneration() {
            Object r8 = this.wifigeneration_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wifigeneration_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public ByteString getWifigenerationBytes() {
            Object r8 = this.wifigeneration_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wifigeneration_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasArpNeighbourCount() {
            if ((this.bitField1_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasBand() {
            if ((this.bitField1_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasCcaLevel() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasCcaScore() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasContentionAtimeBe() {
            if ((this.bitField0_ & 67108864) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasContentionAtimeBk() {
            if ((this.bitField1_ & 33554432) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasContentionAtimeVi() {
            if ((this.bitField1_ & 67108864) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasContentionAtimeVo() {
            if ((this.bitField0_ & 134217728) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasCurrentChannelAPCount() {
            if ((this.bitField1_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelCcaBusyTime() {
            if ((this.bitField1_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelOnTime() {
            if ((this.bitField1_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelRxTime() {
            if ((this.bitField1_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelTxTime() {
            if ((this.bitField1_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaRadioOnTime() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaRxBytes() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaRxSuccess() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaTxBytes() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaTxSuccess() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 1073741824) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasFrequency() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasOnTimeScan() {
            if ((this.bitField1_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasPer() {
            if ((this.bitField1_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasPerScore() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasPowerPredMw() {
            if ((this.bitField1_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRlCcaBusyRate() {
            if ((this.bitField1_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRlRxLinkSpeed() {
            if ((this.bitField1_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRlTxLinkSpeed() {
            if ((this.bitField1_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRssiAck() {
            if ((this.bitField1_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRssiData() {
            if ((this.bitField1_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRssiMgmt() {
            if ((this.bitField1_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRssiScore() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxBw() {
            if ((this.bitField0_ & 33554432) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxFcsErrLevel() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxLinkSpeed() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxMcs() {
            if ((this.bitField0_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxMode() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxNss() {
            if ((this.bitField1_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxRealSpeed() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxSpeedKbps() {
            if ((this.bitField1_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasRxTputPred() {
            if ((this.bitField1_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasScenario() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTotalRxBytes() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTotalTxBytes() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTotalTxRetranLevelBe() {
            if ((this.bitField0_ & 268435456) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTotalTxRetranLevelVo() {
            if ((this.bitField0_ & 536870912) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxBw() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayAvg() {
            if ((this.bitField1_ & 134217728) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayP10() {
            if ((this.bitField1_ & 268435456) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayP90() {
            if ((this.bitField1_ & 536870912) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayPkts() {
            if ((this.bitField1_ & 1073741824) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxLinkSpeed() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxMcs() {
            if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxMode() {
            if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxNss() {
            if ((this.bitField1_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxRealSpeed() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxRetranLevel() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxSpeedKbps() {
            if ((this.bitField1_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasTxTputPred() {
            if ((this.bitField1_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasWidth() {
            if ((this.bitField1_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasWifiStandard() {
            if ((this.bitField1_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
        public boolean hasWifigeneration() {
            if ((this.bitField1_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setArpNeighbourCount(int r8) {
            this.arpNeighbourCount_ = r8;
            this.bitField1_ |= 2;
            onChanged();
            return this;
        }

        public Builder setBand(String r8) {
            if (r8 == null) goto L6;
            this.band_ = r8;
            this.bitField1_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBandBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.band_ = r8;
            this.bitField1_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setCcaLevel(int r8) {
            this.ccaLevel_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setCcaScore(int r8) {
            this.ccaScore_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeBe(int r8) {
            this.contentionAtimeBe_ = r8;
            this.bitField0_ |= 67108864;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeBk(int r8) {
            this.contentionAtimeBk_ = r8;
            this.bitField1_ |= 33554432;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeVi(int r8) {
            this.contentionAtimeVi_ = r8;
            this.bitField1_ |= 67108864;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeVo(int r8) {
            this.contentionAtimeVo_ = r8;
            this.bitField0_ |= 134217728;
            onChanged();
            return this;
        }

        public Builder setCurrentChannelAPCount(int r8) {
            this.currentChannelAPCount_ = r8;
            this.bitField1_ |= 1;
            onChanged();
            return this;
        }

        public Builder setDelaySizeMatrix(int r8, int r10) {
            ensureDelaySizeMatrixIsMutable();
            this.delaySizeMatrix_.setInt(r8, r10);
            onChanged();
            return this;
        }

        public Builder setDeltaChannelCcaBusyTime(int r8) {
            this.deltaChannelCcaBusyTime_ = r8;
            this.bitField1_ |= 8388608;
            onChanged();
            return this;
        }

        public Builder setDeltaChannelOnTime(int r8) {
            this.deltaChannelOnTime_ = r8;
            this.bitField1_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        }

        public Builder setDeltaChannelRxTime(int r8) {
            this.deltaChannelRxTime_ = r8;
            this.bitField1_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setDeltaChannelTxTime(int r8) {
            this.deltaChannelTxTime_ = r8;
            this.bitField1_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        }

        public Builder setDeltaRadioOnTime(int r8) {
            this.deltaRadioOnTime_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setDeltaRxBytes(int r8) {
            this.deltaRxBytes_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setDeltaRxSuccess(long r8) {
            this.deltaRxSuccess_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setDeltaTxBytes(int r8) {
            this.deltaTxBytes_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setDeltaTxSuccess(long r8) {
            this.deltaTxSuccess_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= Integer.MIN_VALUE;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= Integer.MIN_VALUE;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 1073741824;
            onChanged();
            return this;
        }

        public Builder setEventType(String r8) {
            if (r8 == null) goto L6;
            this.eventType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEventTypeBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.eventType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setFrequency(int r8) {
            this.frequency_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setOnTimeScan(int r8) {
            this.onTimeScan_ = r8;
            this.bitField1_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setPer(int r8) {
            this.per_ = r8;
            this.bitField1_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setPerScore(int r8) {
            this.perScore_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPowerPredMw(float r8) {
            this.powerPredMw_ = r8;
            this.bitField1_ |= 16777216;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRlCcaBusyRate(int r8) {
            this.rlCcaBusyRate_ = r8;
            this.bitField1_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setRlRxLinkSpeed(int r8) {
            this.rlRxLinkSpeed_ = r8;
            this.bitField1_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setRlTxLinkSpeed(int r8) {
            this.rlTxLinkSpeed_ = r8;
            this.bitField1_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setRssiAck(int r8) {
            this.rssiAck_ = r8;
            this.bitField1_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setRssiData(int r8) {
            this.rssiData_ = r8;
            this.bitField1_ |= 512;
            onChanged();
            return this;
        }

        public Builder setRssiMgmt(int r8) {
            this.rssiMgmt_ = r8;
            this.bitField1_ |= 256;
            onChanged();
            return this;
        }

        public Builder setRssiScore(int r8) {
            this.rssiScore_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setRxBw(int r8) {
            this.rxBw_ = r8;
            this.bitField0_ |= 33554432;
            onChanged();
            return this;
        }

        public Builder setRxFcsErrLevel(int r8) {
            this.rxFcsErrLevel_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setRxLinkSpeed(int r8) {
            this.rxLinkSpeed_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setRxMcs(int r8) {
            this.rxMcs_ = r8;
            this.bitField0_ |= 16777216;
            onChanged();
            return this;
        }

        public Builder setRxMode(int r8) {
            this.rxMode_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        }

        public Builder setRxNss(int r8) {
            this.rxNss_ = r8;
            this.bitField1_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setRxRealSpeed(int r8) {
            this.rxRealSpeed_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setRxSpeedKbps(int r8) {
            this.rxSpeedKbps_ = r8;
            this.bitField1_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setRxTputPred(int r8) {
            this.rxTputPred_ = r8;
            this.bitField1_ |= 16;
            onChanged();
            return this;
        }

        public Builder setScenario(int r8) {
            this.scenario_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setTotalRxBytes(int r8) {
            this.totalRxBytes_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setTotalTxBytes(int r8) {
            this.totalTxBytes_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setTotalTxRetranLevelBe(long r8) {
            this.totalTxRetranLevelBe_ = r8;
            this.bitField0_ |= 268435456;
            onChanged();
            return this;
        }

        public Builder setTotalTxRetranLevelVo(long r8) {
            this.totalTxRetranLevelVo_ = r8;
            this.bitField0_ |= 536870912;
            onChanged();
            return this;
        }

        public Builder setTxBw(int r8) {
            this.txBw_ = r8;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setTxDelayAvg(float r8) {
            this.txDelayAvg_ = r8;
            this.bitField1_ |= 134217728;
            onChanged();
            return this;
        }

        public Builder setTxDelayP10(float r8) {
            this.txDelayP10_ = r8;
            this.bitField1_ |= 268435456;
            onChanged();
            return this;
        }

        public Builder setTxDelayP90(float r8) {
            this.txDelayP90_ = r8;
            this.bitField1_ |= 536870912;
            onChanged();
            return this;
        }

        public Builder setTxDelayPkts(long r8) {
            this.txDelayPkts_ = r8;
            this.bitField1_ |= 1073741824;
            onChanged();
            return this;
        }

        public Builder setTxLinkSpeed(int r8) {
            this.txLinkSpeed_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTxMcs(int r8) {
            this.txMcs_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        }

        public Builder setTxMode(int r8) {
            this.txMode_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        }

        public Builder setTxNss(int r8) {
            this.txNss_ = r8;
            this.bitField1_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setTxRealSpeed(int r8) {
            this.txRealSpeed_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setTxRetranLevel(int r8) {
            this.txRetranLevel_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setTxSpeedKbps(int r8) {
            this.txSpeedKbps_ = r8;
            this.bitField1_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setTxTputPred(int r8) {
            this.txTputPred_ = r8;
            this.bitField1_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWidth(int r8) {
            this.width_ = r8;
            this.bitField1_ |= 128;
            onChanged();
            return this;
        }

        public Builder setWifiStandard(int r8) {
            this.wifiStandard_ = r8;
            this.bitField1_ |= 64;
            onChanged();
            return this;
        }

        public Builder setWifigeneration(String r8) {
            if (r8 == null) goto L6;
            this.wifigeneration_ = r8;
            this.bitField1_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWifigenerationBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wifigeneration_ = r8;
            this.bitField1_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.deviceDate_ = "";
            this.band_ = "";
            this.wifigeneration_ = "";
            this.delaySizeMatrix_ = LinkLayerQualityReportData.access$7000();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkLayerQualityReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkLayerQualityReportData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LinkLayerQualityReportData build() {
            LinkLayerQualityReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LinkLayerQualityReportData buildPartial() {
            LinkLayerQualityReportData r8 = new LinkLayerQualityReportData(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L6;
            buildPartial0(r8);
        L6:
            if (this.bitField1_ == 0) goto L8;
            buildPartial1(r8);
        L8:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public LinkLayerQualityReportData getDefaultInstanceForType() {
            return LinkLayerQualityReportData.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r8) {
            return (Builder) super.clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return (Builder) super.clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (Builder) super.setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.bitField1_ = 0;
            this.eventType_ = "";
            this.ccaScore_ = 0;
            this.perScore_ = 0;
            this.rssiScore_ = 0;
            this.scenario_ = 0;
            this.frequency_ = 0;
            this.txLinkSpeed_ = 0;
            this.rxLinkSpeed_ = 0;
            this.deltaRadioOnTime_ = 0;
            this.ccaLevel_ = 0;
            this.deltaTxSuccess_ = 0;
            this.txRetranLevel_ = 0;
            this.deltaRxSuccess_ = 0;
            this.rxFcsErrLevel_ = 0;
            this.totalTxBytes_ = 0;
            this.deltaTxBytes_ = 0;
            this.txRealSpeed_ = 0;
            this.totalRxBytes_ = 0;
            this.deltaRxBytes_ = 0;
            this.rxRealSpeed_ = 0;
            this.txMode_ = 0;
            this.txMcs_ = 0;
            this.txBw_ = 0;
            this.rxMode_ = 0;
            this.rxMcs_ = 0;
            this.rxBw_ = 0;
            this.contentionAtimeBe_ = 0;
            this.contentionAtimeVo_ = 0;
            this.totalTxRetranLevelBe_ = 0;
            this.totalTxRetranLevelVo_ = 0;
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            this.currentChannelAPCount_ = 0;
            this.arpNeighbourCount_ = 0;
            this.band_ = "";
            this.wifigeneration_ = "";
            this.rxTputPred_ = 0;
            this.txTputPred_ = 0;
            this.wifiStandard_ = 0;
            this.width_ = 0;
            this.rssiMgmt_ = 0;
            this.rssiData_ = 0;
            this.rssiAck_ = 0;
            this.rlTxLinkSpeed_ = 0;
            this.rlRxLinkSpeed_ = 0;
            this.rlCcaBusyRate_ = 0;
            this.per_ = 0;
            this.onTimeScan_ = 0;
            this.txSpeedKbps_ = 0;
            this.rxSpeedKbps_ = 0;
            this.txNss_ = 0;
            this.rxNss_ = 0;
            this.deltaChannelOnTime_ = 0;
            this.deltaChannelTxTime_ = 0;
            this.deltaChannelRxTime_ = 0;
            this.deltaChannelCcaBusyTime_ = 0;
            this.powerPredMw_ = 0.0f;
            this.contentionAtimeBk_ = 0;
            this.contentionAtimeVi_ = 0;
            this.txDelayAvg_ = 0.0f;
            this.txDelayP10_ = 0.0f;
            this.txDelayP90_ = 0.0f;
            this.txDelayPkts_ = 0;
            this.delaySizeMatrix_ = LinkLayerQualityReportData.access$200();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r11, ExtensionRegistryLite r12) {
            if (r12 == null) goto L91;
            boolean r8 = false;
        L4:
            if (r8 == true) goto L88;
            int r10 = r11.readTag();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            switch(r10) {
                case 0: goto L78;
                case 10: goto L76;
                case 16: goto L75;
                case 24: goto L74;
                case 32: goto L73;
                case 40: goto L72;
                case 48: goto L71;
                case 56: goto L70;
                case 64: goto L69;
                case 72: goto L68;
                case 80: goto L67;
                case 88: goto L66;
                case 96: goto L65;
                case 104: goto L64;
                case 112: goto L63;
                case 120: goto L62;
                case 128: goto L61;
                case 136: goto L60;
                case 144: goto L59;
                case 152: goto L58;
                case 160: goto L57;
                case 168: goto L56;
                case 176: goto L55;
                case 184: goto L54;
                case 192: goto L53;
                case 200: goto L52;
                case 208: goto L51;
                case 216: goto L50;
                case 224: goto L49;
                case 232: goto L48;
                case 240: goto L47;
                case 248: goto L46;
                case 258: goto L45;
                case 264: goto L44;
                case 272: goto L43;
                case 282: goto L42;
                case 290: goto L41;
                case 296: goto L40;
                case 304: goto L39;
                case 312: goto L38;
                case 320: goto L37;
                case 328: goto L36;
                case 336: goto L35;
                case 344: goto L34;
                case 352: goto L33;
                case 360: goto L32;
                case 368: goto L31;
                case 376: goto L30;
                case 384: goto L29;
                case 392: goto L28;
                case 400: goto L27;
                case 408: goto L26;
                case 416: goto L25;
                case 424: goto L24;
                case 432: goto L23;
                case 440: goto L22;
                case 448: goto L21;
                case 461: goto L20;
                case 464: goto L19;
                case 472: goto L18;
                case 485: goto L17;
                case 493: goto L16;
                case 501: goto L15;
                case 504: goto L14;
                case 512: goto L13;
                case 514: goto L8;
                default: goto L79;
            };     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
        L8:
            int r13 = r11.pushLimit(r11.readRawVarint32());     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            ensureDelaySizeMatrixIsMutable();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
        L10:
            if (r11.getBytesUntilLimit() <= 0) goto L12;
            this.delaySizeMatrix_.addInt(r11.readInt32());     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L10
        L12:
            r11.popLimit(r13);     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L13:
            int r14 = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            ensureDelaySizeMatrixIsMutable();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.delaySizeMatrix_.addInt(r14);     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L14:
            this.txDelayPkts_ = r11.readInt64();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 1073741824;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L15:
            this.txDelayP90_ = r11.readFloat();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 536870912;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L16:
            this.txDelayP10_ = r11.readFloat();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 268435456;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L17:
            this.txDelayAvg_ = r11.readFloat();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 134217728;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L18:
            this.contentionAtimeVi_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 67108864;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L19:
            this.contentionAtimeBk_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 33554432;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L20:
            this.powerPredMw_ = r11.readFloat();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 16777216;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L21:
            this.deltaChannelCcaBusyTime_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 8388608;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L22:
            this.deltaChannelRxTime_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 4194304;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L23:
            this.deltaChannelTxTime_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L24:
            this.deltaChannelOnTime_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L25:
            this.rxNss_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 524288;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L26:
            this.txNss_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 262144;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L27:
            this.rxSpeedKbps_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 131072;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L28:
            this.txSpeedKbps_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 65536;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L29:
            this.onTimeScan_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 32768;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L30:
            this.per_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 16384;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L31:
            this.rlCcaBusyRate_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 8192;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L32:
            this.rlRxLinkSpeed_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 4096;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L33:
            this.rlTxLinkSpeed_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 2048;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L34:
            this.rssiAck_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 1024;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L35:
            this.rssiData_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 512;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L36:
            this.rssiMgmt_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 256;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L37:
            this.width_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 128;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L38:
            this.wifiStandard_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 64;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L39:
            this.txTputPred_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 32;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L40:
            this.rxTputPred_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 16;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L41:
            this.wifigeneration_ = r11.readBytes();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 8;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L42:
            this.band_ = r11.readBytes();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 4;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L43:
            this.arpNeighbourCount_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 2;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L44:
            this.currentChannelAPCount_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField1_ |= 1;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L45:
            this.deviceDate_ = r11.readBytes();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= Integer.MIN_VALUE;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L46:
            this.deviceTime_ = r11.readUInt64();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 1073741824;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L47:
            this.totalTxRetranLevelVo_ = r11.readInt64();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 536870912;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L48:
            this.totalTxRetranLevelBe_ = r11.readInt64();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 268435456;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L49:
            this.contentionAtimeVo_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 134217728;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L50:
            this.contentionAtimeBe_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 67108864;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L51:
            this.rxBw_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 33554432;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L52:
            this.rxMcs_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 16777216;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L53:
            this.rxMode_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 8388608;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L54:
            this.txBw_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 4194304;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L55:
            this.txMcs_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L56:
            this.txMode_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L57:
            this.rxRealSpeed_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 524288;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L58:
            this.deltaRxBytes_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 262144;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L59:
            this.totalRxBytes_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 131072;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L60:
            this.txRealSpeed_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 65536;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L61:
            this.deltaTxBytes_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 32768;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L62:
            this.totalTxBytes_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 16384;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L63:
            this.rxFcsErrLevel_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 8192;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L64:
            this.deltaRxSuccess_ = r11.readInt64();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 4096;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L65:
            this.txRetranLevel_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 2048;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L66:
            this.deltaTxSuccess_ = r11.readInt64();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 1024;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L67:
            this.ccaLevel_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 512;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L68:
            this.deltaRadioOnTime_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 256;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L69:
            this.rxLinkSpeed_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 128;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L70:
            this.txLinkSpeed_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 64;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L71:
            this.frequency_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 32;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L72:
            this.scenario_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 16;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L73:
            this.rssiScore_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 8;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L74:
            this.perScore_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 4;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L75:
            this.ccaScore_ = r11.readInt32();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 2;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            goto L4
        L76:
            this.eventType_ = r11.readBytes();     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
            this.bitField0_ |= 1;     // Catch: Throwable -> L81 InvalidProtocolBufferException -> L83
        L78:
            r8 = true;
            goto L4
        L79:
            if (super.parseUnknownField(r11, r12, r10) == true) goto L4;
        L83:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L81
        L81:
            th = move-exception;
            onChanged();
            throw th;
        L88:
            onChanged();
            return this;
        L91:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof LinkLayerQualityReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((LinkLayerQualityReportData) r8);
        }

        public Builder mergeFrom(LinkLayerQualityReportData r8) {
            if (r8 != LinkLayerQualityReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = LinkLayerQualityReportData.access$500(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasCcaScore() == false) goto L12;
            setCcaScore(r8.getCcaScore());
        L12:
            if (r8.hasPerScore() == false) goto L15;
            setPerScore(r8.getPerScore());
        L15:
            if (r8.hasRssiScore() == false) goto L18;
            setRssiScore(r8.getRssiScore());
        L18:
            if (r8.hasScenario() == false) goto L21;
            setScenario(r8.getScenario());
        L21:
            if (r8.hasFrequency() == false) goto L24;
            setFrequency(r8.getFrequency());
        L24:
            if (r8.hasTxLinkSpeed() == false) goto L27;
            setTxLinkSpeed(r8.getTxLinkSpeed());
        L27:
            if (r8.hasRxLinkSpeed() == false) goto L30;
            setRxLinkSpeed(r8.getRxLinkSpeed());
        L30:
            if (r8.hasDeltaRadioOnTime() == false) goto L33;
            setDeltaRadioOnTime(r8.getDeltaRadioOnTime());
        L33:
            if (r8.hasCcaLevel() == false) goto L36;
            setCcaLevel(r8.getCcaLevel());
        L36:
            if (r8.hasDeltaTxSuccess() == false) goto L39;
            setDeltaTxSuccess(r8.getDeltaTxSuccess());
        L39:
            if (r8.hasTxRetranLevel() == false) goto L42;
            setTxRetranLevel(r8.getTxRetranLevel());
        L42:
            if (r8.hasDeltaRxSuccess() == false) goto L45;
            setDeltaRxSuccess(r8.getDeltaRxSuccess());
        L45:
            if (r8.hasRxFcsErrLevel() == false) goto L48;
            setRxFcsErrLevel(r8.getRxFcsErrLevel());
        L48:
            if (r8.hasTotalTxBytes() == false) goto L51;
            setTotalTxBytes(r8.getTotalTxBytes());
        L51:
            if (r8.hasDeltaTxBytes() == false) goto L54;
            setDeltaTxBytes(r8.getDeltaTxBytes());
        L54:
            if (r8.hasTxRealSpeed() == false) goto L57;
            setTxRealSpeed(r8.getTxRealSpeed());
        L57:
            if (r8.hasTotalRxBytes() == false) goto L60;
            setTotalRxBytes(r8.getTotalRxBytes());
        L60:
            if (r8.hasDeltaRxBytes() == false) goto L63;
            setDeltaRxBytes(r8.getDeltaRxBytes());
        L63:
            if (r8.hasRxRealSpeed() == false) goto L66;
            setRxRealSpeed(r8.getRxRealSpeed());
        L66:
            if (r8.hasTxMode() == false) goto L69;
            setTxMode(r8.getTxMode());
        L69:
            if (r8.hasTxMcs() == false) goto L72;
            setTxMcs(r8.getTxMcs());
        L72:
            if (r8.hasTxBw() == false) goto L75;
            setTxBw(r8.getTxBw());
        L75:
            if (r8.hasRxMode() == false) goto L78;
            setRxMode(r8.getRxMode());
        L78:
            if (r8.hasRxMcs() == false) goto L81;
            setRxMcs(r8.getRxMcs());
        L81:
            if (r8.hasRxBw() == false) goto L84;
            setRxBw(r8.getRxBw());
        L84:
            if (r8.hasContentionAtimeBe() == false) goto L87;
            setContentionAtimeBe(r8.getContentionAtimeBe());
        L87:
            if (r8.hasContentionAtimeVo() == false) goto L90;
            setContentionAtimeVo(r8.getContentionAtimeVo());
        L90:
            if (r8.hasTotalTxRetranLevelBe() == false) goto L93;
            setTotalTxRetranLevelBe(r8.getTotalTxRetranLevelBe());
        L93:
            if (r8.hasTotalTxRetranLevelVo() == false) goto L96;
            setTotalTxRetranLevelVo(r8.getTotalTxRetranLevelVo());
        L96:
            if (r8.hasDeviceTime() == false) goto L99;
            setDeviceTime(r8.getDeviceTime());
        L99:
            if (r8.hasDeviceDate() == false) goto L102;
            this.deviceDate_ = LinkLayerQualityReportData.access$3600(r8);
            this.bitField0_ |= Integer.MIN_VALUE;
            onChanged();
        L102:
            if (r8.hasCurrentChannelAPCount() == false) goto L105;
            setCurrentChannelAPCount(r8.getCurrentChannelAPCount());
        L105:
            if (r8.hasArpNeighbourCount() == false) goto L108;
            setArpNeighbourCount(r8.getArpNeighbourCount());
        L108:
            if (r8.hasBand() == false) goto L111;
            this.band_ = LinkLayerQualityReportData.access$4000(r8);
            this.bitField1_ |= 4;
            onChanged();
        L111:
            if (r8.hasWifigeneration() == false) goto L114;
            this.wifigeneration_ = LinkLayerQualityReportData.access$4100(r8);
            this.bitField1_ |= 8;
            onChanged();
        L114:
            if (r8.hasRxTputPred() == false) goto L117;
            setRxTputPred(r8.getRxTputPred());
        L117:
            if (r8.hasTxTputPred() == false) goto L120;
            setTxTputPred(r8.getTxTputPred());
        L120:
            if (r8.hasWifiStandard() == false) goto L123;
            setWifiStandard(r8.getWifiStandard());
        L123:
            if (r8.hasWidth() == false) goto L126;
            setWidth(r8.getWidth());
        L126:
            if (r8.hasRssiMgmt() == false) goto L129;
            setRssiMgmt(r8.getRssiMgmt());
        L129:
            if (r8.hasRssiData() == false) goto L132;
            setRssiData(r8.getRssiData());
        L132:
            if (r8.hasRssiAck() == false) goto L135;
            setRssiAck(r8.getRssiAck());
        L135:
            if (r8.hasRlTxLinkSpeed() == false) goto L138;
            setRlTxLinkSpeed(r8.getRlTxLinkSpeed());
        L138:
            if (r8.hasRlRxLinkSpeed() == false) goto L141;
            setRlRxLinkSpeed(r8.getRlRxLinkSpeed());
        L141:
            if (r8.hasRlCcaBusyRate() == false) goto L144;
            setRlCcaBusyRate(r8.getRlCcaBusyRate());
        L144:
            if (r8.hasPer() == false) goto L147;
            setPer(r8.getPer());
        L147:
            if (r8.hasOnTimeScan() == false) goto L150;
            setOnTimeScan(r8.getOnTimeScan());
        L150:
            if (r8.hasTxSpeedKbps() == false) goto L153;
            setTxSpeedKbps(r8.getTxSpeedKbps());
        L153:
            if (r8.hasRxSpeedKbps() == false) goto L156;
            setRxSpeedKbps(r8.getRxSpeedKbps());
        L156:
            if (r8.hasTxNss() == false) goto L159;
            setTxNss(r8.getTxNss());
        L159:
            if (r8.hasRxNss() == false) goto L162;
            setRxNss(r8.getRxNss());
        L162:
            if (r8.hasDeltaChannelOnTime() == false) goto L165;
            setDeltaChannelOnTime(r8.getDeltaChannelOnTime());
        L165:
            if (r8.hasDeltaChannelTxTime() == false) goto L168;
            setDeltaChannelTxTime(r8.getDeltaChannelTxTime());
        L168:
            if (r8.hasDeltaChannelRxTime() == false) goto L171;
            setDeltaChannelRxTime(r8.getDeltaChannelRxTime());
        L171:
            if (r8.hasDeltaChannelCcaBusyTime() == false) goto L174;
            setDeltaChannelCcaBusyTime(r8.getDeltaChannelCcaBusyTime());
        L174:
            if (r8.hasPowerPredMw() == false) goto L177;
            setPowerPredMw(r8.getPowerPredMw());
        L177:
            if (r8.hasContentionAtimeBk() == false) goto L180;
            setContentionAtimeBk(r8.getContentionAtimeBk());
        L180:
            if (r8.hasContentionAtimeVi() == false) goto L183;
            setContentionAtimeVi(r8.getContentionAtimeVi());
        L183:
            if (r8.hasTxDelayAvg() == false) goto L186;
            setTxDelayAvg(r8.getTxDelayAvg());
        L186:
            if (r8.hasTxDelayP10() == false) goto L189;
            setTxDelayP10(r8.getTxDelayP10());
        L189:
            if (r8.hasTxDelayP90() == false) goto L192;
            setTxDelayP90(r8.getTxDelayP90());
        L192:
            if (r8.hasTxDelayPkts() == false) goto L195;
            setTxDelayPkts(r8.getTxDelayPkts());
        L195:
            if (LinkLayerQualityReportData.access$400(r8).isEmpty() == false) goto L197;
        L201:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L197:
            if (this.delaySizeMatrix_.isEmpty() == false) goto L199;
            this.delaySizeMatrix_ = LinkLayerQualityReportData.access$400(r8);
            this.bitField1_ &= Integer.MAX_VALUE;
        L200:
            onChanged();
            goto L201
        L199:
            ensureDelaySizeMatrixIsMutable();
            this.delaySizeMatrix_.addAll(LinkLayerQualityReportData.access$400(r8));
            goto L200
        }
    }

    static {
        DEFAULT_INSTANCE = new LinkLayerQualityReportData();
        PARSER = new AnonymousClass1();
    }

    private LinkLayerQualityReportData() {
        this.eventType_ = "";
        this.ccaScore_ = 0;
        this.perScore_ = 0;
        this.rssiScore_ = 0;
        this.scenario_ = 0;
        this.frequency_ = 0;
        this.txLinkSpeed_ = 0;
        this.rxLinkSpeed_ = 0;
        this.deltaRadioOnTime_ = 0;
        this.ccaLevel_ = 0;
        this.deltaTxSuccess_ = 0;
        this.txRetranLevel_ = 0;
        this.deltaRxSuccess_ = 0;
        this.rxFcsErrLevel_ = 0;
        this.totalTxBytes_ = 0;
        this.deltaTxBytes_ = 0;
        this.txRealSpeed_ = 0;
        this.totalRxBytes_ = 0;
        this.deltaRxBytes_ = 0;
        this.rxRealSpeed_ = 0;
        this.txMode_ = 0;
        this.txMcs_ = 0;
        this.txBw_ = 0;
        this.rxMode_ = 0;
        this.rxMcs_ = 0;
        this.rxBw_ = 0;
        this.contentionAtimeBe_ = 0;
        this.contentionAtimeVo_ = 0;
        this.totalTxRetranLevelBe_ = 0;
        this.totalTxRetranLevelVo_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.currentChannelAPCount_ = 0;
        this.arpNeighbourCount_ = 0;
        this.band_ = "";
        this.wifigeneration_ = "";
        this.rxTputPred_ = 0;
        this.txTputPred_ = 0;
        this.wifiStandard_ = 0;
        this.width_ = 0;
        this.rssiMgmt_ = 0;
        this.rssiData_ = 0;
        this.rssiAck_ = 0;
        this.rlTxLinkSpeed_ = 0;
        this.rlRxLinkSpeed_ = 0;
        this.rlCcaBusyRate_ = 0;
        this.per_ = 0;
        this.onTimeScan_ = 0;
        this.txSpeedKbps_ = 0;
        this.rxSpeedKbps_ = 0;
        this.txNss_ = 0;
        this.rxNss_ = 0;
        this.deltaChannelOnTime_ = 0;
        this.deltaChannelTxTime_ = 0;
        this.deltaChannelRxTime_ = 0;
        this.deltaChannelCcaBusyTime_ = 0;
        this.powerPredMw_ = 0.0f;
        this.contentionAtimeBk_ = 0;
        this.contentionAtimeVi_ = 0;
        this.txDelayAvg_ = 0.0f;
        this.txDelayP10_ = 0.0f;
        this.txDelayP90_ = 0.0f;
        this.txDelayPkts_ = 0;
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.deviceDate_ = "";
        this.band_ = "";
        this.wifigeneration_ = "";
        this.delaySizeMatrix_ = GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ int access$1002(LinkLayerQualityReportData r8, int r10) {
        r8.frequency_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(LinkLayerQualityReportData r8, int r10) {
        r8.txLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(LinkLayerQualityReportData r8, int r10) {
        r8.rxLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(LinkLayerQualityReportData r8, int r10) {
        r8.deltaRadioOnTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(LinkLayerQualityReportData r8, int r10) {
        r8.ccaLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1502(LinkLayerQualityReportData r8, long r10) {
        r8.deltaTxSuccess_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(LinkLayerQualityReportData r8, int r10) {
        r8.txRetranLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1702(LinkLayerQualityReportData r8, long r10) {
        r8.deltaRxSuccess_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(LinkLayerQualityReportData r8, int r10) {
        r8.rxFcsErrLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1902(LinkLayerQualityReportData r8, int r10) {
        r8.totalTxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$200() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ int access$2002(LinkLayerQualityReportData r8, int r10) {
        r8.deltaTxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2102(LinkLayerQualityReportData r8, int r10) {
        r8.txRealSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2202(LinkLayerQualityReportData r8, int r10) {
        r8.totalRxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2302(LinkLayerQualityReportData r8, int r10) {
        r8.deltaRxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2402(LinkLayerQualityReportData r8, int r10) {
        r8.rxRealSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2502(LinkLayerQualityReportData r8, int r10) {
        r8.txMode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2602(LinkLayerQualityReportData r8, int r10) {
        r8.txMcs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2702(LinkLayerQualityReportData r8, int r10) {
        r8.txBw_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2802(LinkLayerQualityReportData r8, int r10) {
        r8.rxMode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2902(LinkLayerQualityReportData r8, int r10) {
        r8.rxMcs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3002(LinkLayerQualityReportData r8, int r10) {
        r8.rxBw_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3102(LinkLayerQualityReportData r8, int r10) {
        r8.contentionAtimeBe_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3202(LinkLayerQualityReportData r8, int r10) {
        r8.contentionAtimeVo_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$3302(LinkLayerQualityReportData r8, long r10) {
        r8.totalTxRetranLevelBe_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$3402(LinkLayerQualityReportData r8, long r10) {
        r8.totalTxRetranLevelVo_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$3502(LinkLayerQualityReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$3600(LinkLayerQualityReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$3602(LinkLayerQualityReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3776(LinkLayerQualityReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$3802(LinkLayerQualityReportData r8, int r10) {
        r8.currentChannelAPCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3902(LinkLayerQualityReportData r8, int r10) {
        r8.arpNeighbourCount_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$400(LinkLayerQualityReportData r8) {
        return r8.delaySizeMatrix_;
    }

    public static /* synthetic */ Object access$4000(LinkLayerQualityReportData r8) {
        return r8.band_;
    }

    public static /* synthetic */ Object access$4002(LinkLayerQualityReportData r8, Object r10) {
        r8.band_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$402(LinkLayerQualityReportData r8, Internal.IntList r10) {
        r8.delaySizeMatrix_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$4100(LinkLayerQualityReportData r8) {
        return r8.wifigeneration_;
    }

    public static /* synthetic */ Object access$4102(LinkLayerQualityReportData r8, Object r10) {
        r8.wifigeneration_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4202(LinkLayerQualityReportData r8, int r10) {
        r8.rxTputPred_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4302(LinkLayerQualityReportData r8, int r10) {
        r8.txTputPred_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4402(LinkLayerQualityReportData r8, int r10) {
        r8.wifiStandard_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4502(LinkLayerQualityReportData r8, int r10) {
        r8.width_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4602(LinkLayerQualityReportData r8, int r10) {
        r8.rssiMgmt_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4702(LinkLayerQualityReportData r8, int r10) {
        r8.rssiData_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4802(LinkLayerQualityReportData r8, int r10) {
        r8.rssiAck_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4902(LinkLayerQualityReportData r8, int r10) {
        r8.rlTxLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(LinkLayerQualityReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ int access$5002(LinkLayerQualityReportData r8, int r10) {
        r8.rlRxLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$502(LinkLayerQualityReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5102(LinkLayerQualityReportData r8, int r10) {
        r8.rlCcaBusyRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5202(LinkLayerQualityReportData r8, int r10) {
        r8.per_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5302(LinkLayerQualityReportData r8, int r10) {
        r8.onTimeScan_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5402(LinkLayerQualityReportData r8, int r10) {
        r8.txSpeedKbps_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5502(LinkLayerQualityReportData r8, int r10) {
        r8.rxSpeedKbps_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5602(LinkLayerQualityReportData r8, int r10) {
        r8.txNss_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5702(LinkLayerQualityReportData r8, int r10) {
        r8.rxNss_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5802(LinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelOnTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5902(LinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelTxTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6002(LinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelRxTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(LinkLayerQualityReportData r8, int r10) {
        r8.ccaScore_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6102(LinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelCcaBusyTime_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$6202(LinkLayerQualityReportData r8, float r10) {
        r8.powerPredMw_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6302(LinkLayerQualityReportData r8, int r10) {
        r8.contentionAtimeBk_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6402(LinkLayerQualityReportData r8, int r10) {
        r8.contentionAtimeVi_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$6502(LinkLayerQualityReportData r8, float r10) {
        r8.txDelayAvg_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$6602(LinkLayerQualityReportData r8, float r10) {
        r8.txDelayP10_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$6702(LinkLayerQualityReportData r8, float r10) {
        r8.txDelayP90_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$6802(LinkLayerQualityReportData r8, long r10) {
        r8.txDelayPkts_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6976(LinkLayerQualityReportData r8, int r10) {
        int r11 = r10 | r8.bitField1_;
        r8.bitField1_ = r11;
        return r11;
    }

    public static /* synthetic */ Internal.IntList access$7000() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ int access$702(LinkLayerQualityReportData r8, int r10) {
        r8.perScore_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$7100(Internal.IntList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.IntList access$7200() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ int access$802(LinkLayerQualityReportData r8, int r10) {
        r8.rssiScore_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(LinkLayerQualityReportData r8, int r10) {
        r8.scenario_ = r10;
        return r10;
    }

    public static LinkLayerQualityReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkLayerQualityReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static LinkLayerQualityReportData parseDelimitedFrom(InputStream r8) {
        return (LinkLayerQualityReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static LinkLayerQualityReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<LinkLayerQualityReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof LinkLayerQualityReportData) == false) goto L8;
        LinkLayerQualityReportData r10 = (LinkLayerQualityReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasCcaScore() == r10.hasCcaScore()) goto L21;
        return false;
    L21:
        if (hasCcaScore() == false) goto L26;
        if (getCcaScore() == r10.getCcaScore()) goto L26;
        return false;
    L26:
        if (hasPerScore() == r10.hasPerScore()) goto L29;
        return false;
    L29:
        if (hasPerScore() == false) goto L34;
        if (getPerScore() == r10.getPerScore()) goto L34;
        return false;
    L34:
        if (hasRssiScore() == r10.hasRssiScore()) goto L37;
        return false;
    L37:
        if (hasRssiScore() == false) goto L42;
        if (getRssiScore() == r10.getRssiScore()) goto L42;
        return false;
    L42:
        if (hasScenario() == r10.hasScenario()) goto L45;
        return false;
    L45:
        if (hasScenario() == false) goto L50;
        if (getScenario() == r10.getScenario()) goto L50;
        return false;
    L50:
        if (hasFrequency() == r10.hasFrequency()) goto L53;
        return false;
    L53:
        if (hasFrequency() == false) goto L58;
        if (getFrequency() == r10.getFrequency()) goto L58;
        return false;
    L58:
        if (hasTxLinkSpeed() == r10.hasTxLinkSpeed()) goto L61;
        return false;
    L61:
        if (hasTxLinkSpeed() == false) goto L66;
        if (getTxLinkSpeed() == r10.getTxLinkSpeed()) goto L66;
        return false;
    L66:
        if (hasRxLinkSpeed() == r10.hasRxLinkSpeed()) goto L69;
        return false;
    L69:
        if (hasRxLinkSpeed() == false) goto L74;
        if (getRxLinkSpeed() == r10.getRxLinkSpeed()) goto L74;
        return false;
    L74:
        if (hasDeltaRadioOnTime() == r10.hasDeltaRadioOnTime()) goto L77;
        return false;
    L77:
        if (hasDeltaRadioOnTime() == false) goto L82;
        if (getDeltaRadioOnTime() == r10.getDeltaRadioOnTime()) goto L82;
        return false;
    L82:
        if (hasCcaLevel() == r10.hasCcaLevel()) goto L85;
        return false;
    L85:
        if (hasCcaLevel() == false) goto L90;
        if (getCcaLevel() == r10.getCcaLevel()) goto L90;
        return false;
    L90:
        if (hasDeltaTxSuccess() == r10.hasDeltaTxSuccess()) goto L93;
        return false;
    L93:
        if (hasDeltaTxSuccess() == false) goto L98;
        if (getDeltaTxSuccess() == r10.getDeltaTxSuccess()) goto L98;
        return false;
    L98:
        if (hasTxRetranLevel() == r10.hasTxRetranLevel()) goto L101;
        return false;
    L101:
        if (hasTxRetranLevel() == false) goto L106;
        if (getTxRetranLevel() == r10.getTxRetranLevel()) goto L106;
        return false;
    L106:
        if (hasDeltaRxSuccess() == r10.hasDeltaRxSuccess()) goto L109;
        return false;
    L109:
        if (hasDeltaRxSuccess() == false) goto L114;
        if (getDeltaRxSuccess() == r10.getDeltaRxSuccess()) goto L114;
        return false;
    L114:
        if (hasRxFcsErrLevel() == r10.hasRxFcsErrLevel()) goto L117;
        return false;
    L117:
        if (hasRxFcsErrLevel() == false) goto L122;
        if (getRxFcsErrLevel() == r10.getRxFcsErrLevel()) goto L122;
        return false;
    L122:
        if (hasTotalTxBytes() == r10.hasTotalTxBytes()) goto L125;
        return false;
    L125:
        if (hasTotalTxBytes() == false) goto L130;
        if (getTotalTxBytes() == r10.getTotalTxBytes()) goto L130;
        return false;
    L130:
        if (hasDeltaTxBytes() == r10.hasDeltaTxBytes()) goto L133;
        return false;
    L133:
        if (hasDeltaTxBytes() == false) goto L138;
        if (getDeltaTxBytes() == r10.getDeltaTxBytes()) goto L138;
        return false;
    L138:
        if (hasTxRealSpeed() == r10.hasTxRealSpeed()) goto L141;
        return false;
    L141:
        if (hasTxRealSpeed() == false) goto L146;
        if (getTxRealSpeed() == r10.getTxRealSpeed()) goto L146;
        return false;
    L146:
        if (hasTotalRxBytes() == r10.hasTotalRxBytes()) goto L149;
        return false;
    L149:
        if (hasTotalRxBytes() == false) goto L154;
        if (getTotalRxBytes() == r10.getTotalRxBytes()) goto L154;
        return false;
    L154:
        if (hasDeltaRxBytes() == r10.hasDeltaRxBytes()) goto L157;
        return false;
    L157:
        if (hasDeltaRxBytes() == false) goto L162;
        if (getDeltaRxBytes() == r10.getDeltaRxBytes()) goto L162;
        return false;
    L162:
        if (hasRxRealSpeed() == r10.hasRxRealSpeed()) goto L165;
        return false;
    L165:
        if (hasRxRealSpeed() == false) goto L170;
        if (getRxRealSpeed() == r10.getRxRealSpeed()) goto L170;
        return false;
    L170:
        if (hasTxMode() == r10.hasTxMode()) goto L173;
        return false;
    L173:
        if (hasTxMode() == false) goto L178;
        if (getTxMode() == r10.getTxMode()) goto L178;
        return false;
    L178:
        if (hasTxMcs() == r10.hasTxMcs()) goto L181;
        return false;
    L181:
        if (hasTxMcs() == false) goto L186;
        if (getTxMcs() == r10.getTxMcs()) goto L186;
        return false;
    L186:
        if (hasTxBw() == r10.hasTxBw()) goto L189;
        return false;
    L189:
        if (hasTxBw() == false) goto L194;
        if (getTxBw() == r10.getTxBw()) goto L194;
        return false;
    L194:
        if (hasRxMode() == r10.hasRxMode()) goto L197;
        return false;
    L197:
        if (hasRxMode() == false) goto L202;
        if (getRxMode() == r10.getRxMode()) goto L202;
        return false;
    L202:
        if (hasRxMcs() == r10.hasRxMcs()) goto L205;
        return false;
    L205:
        if (hasRxMcs() == false) goto L210;
        if (getRxMcs() == r10.getRxMcs()) goto L210;
        return false;
    L210:
        if (hasRxBw() == r10.hasRxBw()) goto L213;
        return false;
    L213:
        if (hasRxBw() == false) goto L218;
        if (getRxBw() == r10.getRxBw()) goto L218;
        return false;
    L218:
        if (hasContentionAtimeBe() == r10.hasContentionAtimeBe()) goto L221;
        return false;
    L221:
        if (hasContentionAtimeBe() == false) goto L226;
        if (getContentionAtimeBe() == r10.getContentionAtimeBe()) goto L226;
        return false;
    L226:
        if (hasContentionAtimeVo() == r10.hasContentionAtimeVo()) goto L229;
        return false;
    L229:
        if (hasContentionAtimeVo() == false) goto L234;
        if (getContentionAtimeVo() == r10.getContentionAtimeVo()) goto L234;
        return false;
    L234:
        if (hasTotalTxRetranLevelBe() == r10.hasTotalTxRetranLevelBe()) goto L237;
        return false;
    L237:
        if (hasTotalTxRetranLevelBe() == false) goto L242;
        if (getTotalTxRetranLevelBe() == r10.getTotalTxRetranLevelBe()) goto L242;
        return false;
    L242:
        if (hasTotalTxRetranLevelVo() == r10.hasTotalTxRetranLevelVo()) goto L245;
        return false;
    L245:
        if (hasTotalTxRetranLevelVo() == false) goto L250;
        if (getTotalTxRetranLevelVo() == r10.getTotalTxRetranLevelVo()) goto L250;
        return false;
    L250:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L253;
        return false;
    L253:
        if (hasDeviceTime() == false) goto L258;
        if (getDeviceTime() == r10.getDeviceTime()) goto L258;
        return false;
    L258:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L261;
        return false;
    L261:
        if (hasDeviceDate() == false) goto L266;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L266;
        return false;
    L266:
        if (hasCurrentChannelAPCount() == r10.hasCurrentChannelAPCount()) goto L269;
        return false;
    L269:
        if (hasCurrentChannelAPCount() == false) goto L274;
        if (getCurrentChannelAPCount() == r10.getCurrentChannelAPCount()) goto L274;
        return false;
    L274:
        if (hasArpNeighbourCount() == r10.hasArpNeighbourCount()) goto L277;
        return false;
    L277:
        if (hasArpNeighbourCount() == false) goto L282;
        if (getArpNeighbourCount() == r10.getArpNeighbourCount()) goto L282;
        return false;
    L282:
        if (hasBand() == r10.hasBand()) goto L285;
        return false;
    L285:
        if (hasBand() == false) goto L290;
        if (getBand().equals(r10.getBand()) == true) goto L290;
        return false;
    L290:
        if (hasWifigeneration() == r10.hasWifigeneration()) goto L293;
        return false;
    L293:
        if (hasWifigeneration() == false) goto L298;
        if (getWifigeneration().equals(r10.getWifigeneration()) == true) goto L298;
        return false;
    L298:
        if (hasRxTputPred() == r10.hasRxTputPred()) goto L301;
        return false;
    L301:
        if (hasRxTputPred() == false) goto L306;
        if (getRxTputPred() == r10.getRxTputPred()) goto L306;
        return false;
    L306:
        if (hasTxTputPred() == r10.hasTxTputPred()) goto L309;
        return false;
    L309:
        if (hasTxTputPred() == false) goto L314;
        if (getTxTputPred() == r10.getTxTputPred()) goto L314;
        return false;
    L314:
        if (hasWifiStandard() == r10.hasWifiStandard()) goto L317;
        return false;
    L317:
        if (hasWifiStandard() == false) goto L322;
        if (getWifiStandard() == r10.getWifiStandard()) goto L322;
        return false;
    L322:
        if (hasWidth() == r10.hasWidth()) goto L325;
        return false;
    L325:
        if (hasWidth() == false) goto L330;
        if (getWidth() == r10.getWidth()) goto L330;
        return false;
    L330:
        if (hasRssiMgmt() == r10.hasRssiMgmt()) goto L333;
        return false;
    L333:
        if (hasRssiMgmt() == false) goto L338;
        if (getRssiMgmt() == r10.getRssiMgmt()) goto L338;
        return false;
    L338:
        if (hasRssiData() == r10.hasRssiData()) goto L341;
        return false;
    L341:
        if (hasRssiData() == false) goto L346;
        if (getRssiData() == r10.getRssiData()) goto L346;
        return false;
    L346:
        if (hasRssiAck() == r10.hasRssiAck()) goto L349;
        return false;
    L349:
        if (hasRssiAck() == false) goto L354;
        if (getRssiAck() == r10.getRssiAck()) goto L354;
        return false;
    L354:
        if (hasRlTxLinkSpeed() == r10.hasRlTxLinkSpeed()) goto L357;
        return false;
    L357:
        if (hasRlTxLinkSpeed() == false) goto L362;
        if (getRlTxLinkSpeed() == r10.getRlTxLinkSpeed()) goto L362;
        return false;
    L362:
        if (hasRlRxLinkSpeed() == r10.hasRlRxLinkSpeed()) goto L365;
        return false;
    L365:
        if (hasRlRxLinkSpeed() == false) goto L370;
        if (getRlRxLinkSpeed() == r10.getRlRxLinkSpeed()) goto L370;
        return false;
    L370:
        if (hasRlCcaBusyRate() == r10.hasRlCcaBusyRate()) goto L373;
        return false;
    L373:
        if (hasRlCcaBusyRate() == false) goto L378;
        if (getRlCcaBusyRate() == r10.getRlCcaBusyRate()) goto L378;
        return false;
    L378:
        if (hasPer() == r10.hasPer()) goto L381;
        return false;
    L381:
        if (hasPer() == false) goto L386;
        if (getPer() == r10.getPer()) goto L386;
        return false;
    L386:
        if (hasOnTimeScan() == r10.hasOnTimeScan()) goto L389;
        return false;
    L389:
        if (hasOnTimeScan() == false) goto L394;
        if (getOnTimeScan() == r10.getOnTimeScan()) goto L394;
        return false;
    L394:
        if (hasTxSpeedKbps() == r10.hasTxSpeedKbps()) goto L397;
        return false;
    L397:
        if (hasTxSpeedKbps() == false) goto L402;
        if (getTxSpeedKbps() == r10.getTxSpeedKbps()) goto L402;
        return false;
    L402:
        if (hasRxSpeedKbps() == r10.hasRxSpeedKbps()) goto L405;
        return false;
    L405:
        if (hasRxSpeedKbps() == false) goto L410;
        if (getRxSpeedKbps() == r10.getRxSpeedKbps()) goto L410;
        return false;
    L410:
        if (hasTxNss() == r10.hasTxNss()) goto L413;
        return false;
    L413:
        if (hasTxNss() == false) goto L418;
        if (getTxNss() == r10.getTxNss()) goto L418;
        return false;
    L418:
        if (hasRxNss() == r10.hasRxNss()) goto L421;
        return false;
    L421:
        if (hasRxNss() == false) goto L426;
        if (getRxNss() == r10.getRxNss()) goto L426;
        return false;
    L426:
        if (hasDeltaChannelOnTime() == r10.hasDeltaChannelOnTime()) goto L429;
        return false;
    L429:
        if (hasDeltaChannelOnTime() == false) goto L434;
        if (getDeltaChannelOnTime() == r10.getDeltaChannelOnTime()) goto L434;
        return false;
    L434:
        if (hasDeltaChannelTxTime() == r10.hasDeltaChannelTxTime()) goto L437;
        return false;
    L437:
        if (hasDeltaChannelTxTime() == false) goto L442;
        if (getDeltaChannelTxTime() == r10.getDeltaChannelTxTime()) goto L442;
        return false;
    L442:
        if (hasDeltaChannelRxTime() == r10.hasDeltaChannelRxTime()) goto L445;
        return false;
    L445:
        if (hasDeltaChannelRxTime() == false) goto L450;
        if (getDeltaChannelRxTime() == r10.getDeltaChannelRxTime()) goto L450;
        return false;
    L450:
        if (hasDeltaChannelCcaBusyTime() == r10.hasDeltaChannelCcaBusyTime()) goto L453;
        return false;
    L453:
        if (hasDeltaChannelCcaBusyTime() == false) goto L458;
        if (getDeltaChannelCcaBusyTime() == r10.getDeltaChannelCcaBusyTime()) goto L458;
        return false;
    L458:
        if (hasPowerPredMw() == r10.hasPowerPredMw()) goto L461;
        return false;
    L461:
        if (hasPowerPredMw() == false) goto L466;
        if (Float.floatToIntBits(getPowerPredMw()) == Float.floatToIntBits(r10.getPowerPredMw())) goto L466;
        return false;
    L466:
        if (hasContentionAtimeBk() == r10.hasContentionAtimeBk()) goto L469;
        return false;
    L469:
        if (hasContentionAtimeBk() == false) goto L474;
        if (getContentionAtimeBk() == r10.getContentionAtimeBk()) goto L474;
        return false;
    L474:
        if (hasContentionAtimeVi() == r10.hasContentionAtimeVi()) goto L477;
        return false;
    L477:
        if (hasContentionAtimeVi() == false) goto L482;
        if (getContentionAtimeVi() == r10.getContentionAtimeVi()) goto L482;
        return false;
    L482:
        if (hasTxDelayAvg() == r10.hasTxDelayAvg()) goto L485;
        return false;
    L485:
        if (hasTxDelayAvg() == false) goto L490;
        if (Float.floatToIntBits(getTxDelayAvg()) == Float.floatToIntBits(r10.getTxDelayAvg())) goto L490;
        return false;
    L490:
        if (hasTxDelayP10() == r10.hasTxDelayP10()) goto L493;
        return false;
    L493:
        if (hasTxDelayP10() == false) goto L498;
        if (Float.floatToIntBits(getTxDelayP10()) == Float.floatToIntBits(r10.getTxDelayP10())) goto L498;
        return false;
    L498:
        if (hasTxDelayP90() == r10.hasTxDelayP90()) goto L501;
        return false;
    L501:
        if (hasTxDelayP90() == false) goto L506;
        if (Float.floatToIntBits(getTxDelayP90()) == Float.floatToIntBits(r10.getTxDelayP90())) goto L506;
        return false;
    L506:
        if (hasTxDelayPkts() == r10.hasTxDelayPkts()) goto L509;
        return false;
    L509:
        if (hasTxDelayPkts() == false) goto L514;
        if (getTxDelayPkts() == r10.getTxDelayPkts()) goto L514;
        return false;
    L514:
        if (getDelaySizeMatrixList().equals(r10.getDelaySizeMatrixList()) == true) goto L517;
        return false;
    L517:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L519;
        return false;
    L519:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getArpNeighbourCount() {
        return this.arpNeighbourCount_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public String getBand() {
        Object r8 = this.band_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.band_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public ByteString getBandBytes() {
        Object r8 = this.band_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.band_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getCcaLevel() {
        return this.ccaLevel_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getCcaScore() {
        return this.ccaScore_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getContentionAtimeBe() {
        return this.contentionAtimeBe_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getContentionAtimeBk() {
        return this.contentionAtimeBk_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getContentionAtimeVi() {
        return this.contentionAtimeVi_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getContentionAtimeVo() {
        return this.contentionAtimeVo_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getCurrentChannelAPCount() {
        return this.currentChannelAPCount_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDelaySizeMatrix(int r8) {
        return this.delaySizeMatrix_.getInt(r8);
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDelaySizeMatrixCount() {
        return this.delaySizeMatrix_.size();
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public List<Integer> getDelaySizeMatrixList() {
        return this.delaySizeMatrix_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelCcaBusyTime() {
        return this.deltaChannelCcaBusyTime_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelOnTime() {
        return this.deltaChannelOnTime_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelRxTime() {
        return this.deltaChannelRxTime_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelTxTime() {
        return this.deltaChannelTxTime_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDeltaRadioOnTime() {
        return this.deltaRadioOnTime_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDeltaRxBytes() {
        return this.deltaRxBytes_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public long getDeltaRxSuccess() {
        return this.deltaRxSuccess_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getDeltaTxBytes() {
        return this.deltaTxBytes_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public long getDeltaTxSuccess() {
        return this.deltaTxSuccess_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public String getDeviceDate() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.deviceDate_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public String getEventType() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.eventType_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getFrequency() {
        return this.frequency_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getOnTimeScan() {
        return this.onTimeScan_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LinkLayerQualityReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getPer() {
        return this.per_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getPerScore() {
        return this.perScore_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public float getPowerPredMw() {
        return this.powerPredMw_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRlCcaBusyRate() {
        return this.rlCcaBusyRate_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRlRxLinkSpeed() {
        return this.rlRxLinkSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRlTxLinkSpeed() {
        return this.rlTxLinkSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRssiAck() {
        return this.rssiAck_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRssiData() {
        return this.rssiData_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRssiMgmt() {
        return this.rssiMgmt_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRssiScore() {
        return this.rssiScore_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxBw() {
        return this.rxBw_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxFcsErrLevel() {
        return this.rxFcsErrLevel_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxLinkSpeed() {
        return this.rxLinkSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxMcs() {
        return this.rxMcs_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxMode() {
        return this.rxMode_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxNss() {
        return this.rxNss_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxRealSpeed() {
        return this.rxRealSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxSpeedKbps() {
        return this.rxSpeedKbps_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getRxTputPred() {
        return this.rxTputPred_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getScenario() {
        return this.scenario_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L6;
        return r8;
    L6:
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r10 = GeneratedMessage.computeStringSize(1, this.eventType_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.ccaScore_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.perScore_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L19;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.rssiScore_);
    L19:
        if ((this.bitField0_ & 16) == 0) goto L22;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.scenario_);
    L22:
        if ((this.bitField0_ & 32) == 0) goto L25;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.frequency_);
    L25:
        if ((this.bitField0_ & 64) == 0) goto L28;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.txLinkSpeed_);
    L28:
        if ((this.bitField0_ & 128) == 0) goto L31;
        r10 = r10 + CodedOutputStream.computeInt32Size(8, this.rxLinkSpeed_);
    L31:
        if ((this.bitField0_ & 256) == 0) goto L34;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.deltaRadioOnTime_);
    L34:
        if ((this.bitField0_ & 512) == 0) goto L37;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.ccaLevel_);
    L37:
        if ((this.bitField0_ & 1024) == 0) goto L40;
        r10 = r10 + CodedOutputStream.computeInt64Size(11, this.deltaTxSuccess_);
    L40:
        if ((this.bitField0_ & 2048) == 0) goto L43;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.txRetranLevel_);
    L43:
        if ((this.bitField0_ & 4096) == 0) goto L46;
        r10 = r10 + CodedOutputStream.computeInt64Size(13, this.deltaRxSuccess_);
    L46:
        if ((this.bitField0_ & 8192) == 0) goto L49;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.rxFcsErrLevel_);
    L49:
        if ((this.bitField0_ & 16384) == 0) goto L52;
        r10 = r10 + CodedOutputStream.computeInt32Size(15, this.totalTxBytes_);
    L52:
        if ((this.bitField0_ & 32768) == 0) goto L55;
        r10 = r10 + CodedOutputStream.computeInt32Size(16, this.deltaTxBytes_);
    L55:
        if ((this.bitField0_ & 65536) == 0) goto L58;
        r10 = r10 + CodedOutputStream.computeInt32Size(17, this.txRealSpeed_);
    L58:
        if ((this.bitField0_ & 131072) == 0) goto L61;
        r10 = r10 + CodedOutputStream.computeInt32Size(18, this.totalRxBytes_);
    L61:
        if ((this.bitField0_ & 262144) == 0) goto L64;
        r10 = r10 + CodedOutputStream.computeInt32Size(19, this.deltaRxBytes_);
    L64:
        if ((this.bitField0_ & 524288) == 0) goto L67;
        r10 = r10 + CodedOutputStream.computeInt32Size(20, this.rxRealSpeed_);
    L67:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L70;
        r10 = r10 + CodedOutputStream.computeInt32Size(21, this.txMode_);
    L70:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L73;
        r10 = r10 + CodedOutputStream.computeInt32Size(22, this.txMcs_);
    L73:
        if ((this.bitField0_ & 4194304) == 0) goto L76;
        r10 = r10 + CodedOutputStream.computeInt32Size(23, this.txBw_);
    L76:
        if ((this.bitField0_ & 8388608) == 0) goto L79;
        r10 = r10 + CodedOutputStream.computeInt32Size(24, this.rxMode_);
    L79:
        if ((this.bitField0_ & 16777216) == 0) goto L82;
        r10 = r10 + CodedOutputStream.computeInt32Size(25, this.rxMcs_);
    L82:
        if ((this.bitField0_ & 33554432) == 0) goto L85;
        r10 = r10 + CodedOutputStream.computeInt32Size(26, this.rxBw_);
    L85:
        if ((this.bitField0_ & 67108864) == 0) goto L88;
        r10 = r10 + CodedOutputStream.computeInt32Size(27, this.contentionAtimeBe_);
    L88:
        if ((this.bitField0_ & 134217728) == 0) goto L91;
        r10 = r10 + CodedOutputStream.computeInt32Size(28, this.contentionAtimeVo_);
    L91:
        if ((this.bitField0_ & 268435456) == 0) goto L94;
        r10 = r10 + CodedOutputStream.computeInt64Size(29, this.totalTxRetranLevelBe_);
    L94:
        if ((this.bitField0_ & 536870912) == 0) goto L97;
        r10 = r10 + CodedOutputStream.computeInt64Size(30, this.totalTxRetranLevelVo_);
    L97:
        if ((this.bitField0_ & 1073741824) == 0) goto L100;
        r10 = r10 + CodedOutputStream.computeUInt64Size(31, this.deviceTime_);
    L100:
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L103;
        r10 = r10 + GeneratedMessage.computeStringSize(32, this.deviceDate_);
    L103:
        if ((1 & this.bitField1_) == 0) goto L106;
        r10 = r10 + CodedOutputStream.computeInt32Size(33, this.currentChannelAPCount_);
    L106:
        if ((this.bitField1_ & 2) == 0) goto L109;
        r10 = r10 + CodedOutputStream.computeInt32Size(34, this.arpNeighbourCount_);
    L109:
        if ((this.bitField1_ & 4) == 0) goto L112;
        r10 = r10 + GeneratedMessage.computeStringSize(35, this.band_);
    L112:
        if ((this.bitField1_ & 8) == 0) goto L115;
        r10 = r10 + GeneratedMessage.computeStringSize(36, this.wifigeneration_);
    L115:
        if ((this.bitField1_ & 16) == 0) goto L118;
        r10 = r10 + CodedOutputStream.computeInt32Size(37, this.rxTputPred_);
    L118:
        if ((this.bitField1_ & 32) == 0) goto L121;
        r10 = r10 + CodedOutputStream.computeInt32Size(38, this.txTputPred_);
    L121:
        if ((this.bitField1_ & 64) == 0) goto L124;
        r10 = r10 + CodedOutputStream.computeInt32Size(39, this.wifiStandard_);
    L124:
        if ((this.bitField1_ & 128) == 0) goto L127;
        r10 = r10 + CodedOutputStream.computeInt32Size(40, this.width_);
    L127:
        if ((this.bitField1_ & 256) == 0) goto L130;
        r10 = r10 + CodedOutputStream.computeInt32Size(41, this.rssiMgmt_);
    L130:
        if ((this.bitField1_ & 512) == 0) goto L133;
        r10 = r10 + CodedOutputStream.computeInt32Size(42, this.rssiData_);
    L133:
        if ((this.bitField1_ & 1024) == 0) goto L136;
        r10 = r10 + CodedOutputStream.computeInt32Size(43, this.rssiAck_);
    L136:
        if ((this.bitField1_ & 2048) == 0) goto L139;
        r10 = r10 + CodedOutputStream.computeInt32Size(44, this.rlTxLinkSpeed_);
    L139:
        if ((this.bitField1_ & 4096) == 0) goto L142;
        r10 = r10 + CodedOutputStream.computeInt32Size(45, this.rlRxLinkSpeed_);
    L142:
        if ((this.bitField1_ & 8192) == 0) goto L145;
        r10 = r10 + CodedOutputStream.computeInt32Size(46, this.rlCcaBusyRate_);
    L145:
        if ((this.bitField1_ & 16384) == 0) goto L148;
        r10 = r10 + CodedOutputStream.computeInt32Size(47, this.per_);
    L148:
        if ((this.bitField1_ & 32768) == 0) goto L151;
        r10 = r10 + CodedOutputStream.computeInt32Size(48, this.onTimeScan_);
    L151:
        if ((this.bitField1_ & 65536) == 0) goto L154;
        r10 = r10 + CodedOutputStream.computeInt32Size(49, this.txSpeedKbps_);
    L154:
        if ((this.bitField1_ & 131072) == 0) goto L157;
        r10 = r10 + CodedOutputStream.computeInt32Size(50, this.rxSpeedKbps_);
    L157:
        if ((this.bitField1_ & 262144) == 0) goto L160;
        r10 = r10 + CodedOutputStream.computeInt32Size(51, this.txNss_);
    L160:
        if ((this.bitField1_ & 524288) == 0) goto L163;
        r10 = r10 + CodedOutputStream.computeInt32Size(52, this.rxNss_);
    L163:
        if ((this.bitField1_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L166;
        r10 = r10 + CodedOutputStream.computeInt32Size(53, this.deltaChannelOnTime_);
    L166:
        if ((this.bitField1_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L169;
        r10 = r10 + CodedOutputStream.computeInt32Size(54, this.deltaChannelTxTime_);
    L169:
        if ((this.bitField1_ & 4194304) == 0) goto L172;
        r10 = r10 + CodedOutputStream.computeInt32Size(55, this.deltaChannelRxTime_);
    L172:
        if ((this.bitField1_ & 8388608) == 0) goto L175;
        r10 = r10 + CodedOutputStream.computeInt32Size(56, this.deltaChannelCcaBusyTime_);
    L175:
        if ((this.bitField1_ & 16777216) == 0) goto L178;
        r10 = r10 + CodedOutputStream.computeFloatSize(57, this.powerPredMw_);
    L178:
        if ((this.bitField1_ & 33554432) == 0) goto L181;
        r10 = r10 + CodedOutputStream.computeInt32Size(58, this.contentionAtimeBk_);
    L181:
        if ((this.bitField1_ & 67108864) == 0) goto L184;
        r10 = r10 + CodedOutputStream.computeInt32Size(59, this.contentionAtimeVi_);
    L184:
        if ((this.bitField1_ & 134217728) == 0) goto L187;
        r10 = r10 + CodedOutputStream.computeFloatSize(60, this.txDelayAvg_);
    L187:
        if ((this.bitField1_ & 268435456) == 0) goto L190;
        r10 = r10 + CodedOutputStream.computeFloatSize(61, this.txDelayP10_);
    L190:
        if ((this.bitField1_ & 536870912) == 0) goto L193;
        r10 = r10 + CodedOutputStream.computeFloatSize(62, this.txDelayP90_);
    L193:
        if ((this.bitField1_ & 1073741824) == 0) goto L195;
        r10 = r10 + CodedOutputStream.computeInt64Size(63, this.txDelayPkts_);
    L195:
        int r11 = 0;
        int r16 = 0;
    L197:
        if (r11 >= this.delaySizeMatrix_.size()) goto L199;
        r16 = CodedOutputStream.computeInt32SizeNoTag(this.delaySizeMatrix_.getInt(r11)) + r16;
        r11 = r11 + 1;
        goto L197
    L199:
        int r12 = getUnknownFields().getSerializedSize() + ((getDelaySizeMatrixList().size() * 2) + (r10 + r16));
        this.memoizedSize = r12;
        return r12;
    L8:
        r10 = 0;
        goto L10
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTotalRxBytes() {
        return this.totalRxBytes_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTotalTxBytes() {
        return this.totalTxBytes_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public long getTotalTxRetranLevelBe() {
        return this.totalTxRetranLevelBe_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public long getTotalTxRetranLevelVo() {
        return this.totalTxRetranLevelVo_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxBw() {
        return this.txBw_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public float getTxDelayAvg() {
        return this.txDelayAvg_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public float getTxDelayP10() {
        return this.txDelayP10_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public float getTxDelayP90() {
        return this.txDelayP90_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public long getTxDelayPkts() {
        return this.txDelayPkts_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxLinkSpeed() {
        return this.txLinkSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxMcs() {
        return this.txMcs_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxMode() {
        return this.txMode_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxNss() {
        return this.txNss_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxRealSpeed() {
        return this.txRealSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxRetranLevel() {
        return this.txRetranLevel_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxSpeedKbps() {
        return this.txSpeedKbps_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getTxTputPred() {
        return this.txTputPred_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getWidth() {
        return this.width_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public int getWifiStandard() {
        return this.wifiStandard_;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public String getWifigeneration() {
        Object r8 = this.wifigeneration_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wifigeneration_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public ByteString getWifigenerationBytes() {
        Object r8 = this.wifigeneration_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wifigeneration_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasArpNeighbourCount() {
        if ((this.bitField1_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasBand() {
        if ((this.bitField1_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasCcaLevel() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasCcaScore() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasContentionAtimeBe() {
        if ((this.bitField0_ & 67108864) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasContentionAtimeBk() {
        if ((this.bitField1_ & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasContentionAtimeVi() {
        if ((this.bitField1_ & 67108864) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasContentionAtimeVo() {
        if ((this.bitField0_ & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasCurrentChannelAPCount() {
        if ((this.bitField1_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelCcaBusyTime() {
        if ((this.bitField1_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelOnTime() {
        if ((this.bitField1_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelRxTime() {
        if ((this.bitField1_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelTxTime() {
        if ((this.bitField1_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaRadioOnTime() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaRxBytes() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaRxSuccess() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaTxBytes() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaTxSuccess() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 1073741824) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasFrequency() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasOnTimeScan() {
        if ((this.bitField1_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasPer() {
        if ((this.bitField1_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasPerScore() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasPowerPredMw() {
        if ((this.bitField1_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRlCcaBusyRate() {
        if ((this.bitField1_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRlRxLinkSpeed() {
        if ((this.bitField1_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRlTxLinkSpeed() {
        if ((this.bitField1_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRssiAck() {
        if ((this.bitField1_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRssiData() {
        if ((this.bitField1_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRssiMgmt() {
        if ((this.bitField1_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRssiScore() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxBw() {
        if ((this.bitField0_ & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxFcsErrLevel() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxLinkSpeed() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxMcs() {
        if ((this.bitField0_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxMode() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxNss() {
        if ((this.bitField1_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxRealSpeed() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxSpeedKbps() {
        if ((this.bitField1_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasRxTputPred() {
        if ((this.bitField1_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasScenario() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTotalRxBytes() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTotalTxBytes() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTotalTxRetranLevelBe() {
        if ((this.bitField0_ & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTotalTxRetranLevelVo() {
        if ((this.bitField0_ & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxBw() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayAvg() {
        if ((this.bitField1_ & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayP10() {
        if ((this.bitField1_ & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayP90() {
        if ((this.bitField1_ & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayPkts() {
        if ((this.bitField1_ & 1073741824) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxLinkSpeed() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxMcs() {
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxMode() {
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxNss() {
        if ((this.bitField1_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxRealSpeed() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxRetranLevel() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxSpeedKbps() {
        if ((this.bitField1_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasTxTputPred() {
        if ((this.bitField1_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasWidth() {
        if ((this.bitField1_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasWifiStandard() {
        if ((this.bitField1_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkLayerQualityReportDataOrBuilder
    public boolean hasWifigeneration() {
        if ((this.bitField1_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (hasEventType() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getEventType().hashCode();
    L9:
        if (hasCcaScore() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getCcaScore();
    L12:
        if (hasPerScore() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getPerScore();
    L15:
        if (hasRssiScore() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getRssiScore();
    L18:
        if (hasScenario() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getScenario();
    L21:
        if (hasFrequency() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getFrequency();
    L24:
        if (hasTxLinkSpeed() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getTxLinkSpeed();
    L27:
        if (hasRxLinkSpeed() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getRxLinkSpeed();
    L30:
        if (hasDeltaRadioOnTime() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getDeltaRadioOnTime();
    L33:
        if (hasCcaLevel() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getCcaLevel();
    L36:
        if (hasDeltaTxSuccess() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + Internal.hashLong(getDeltaTxSuccess());
    L39:
        if (hasTxRetranLevel() == false) goto L42;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getTxRetranLevel();
    L42:
        if (hasDeltaRxSuccess() == false) goto L45;
        r10 = defpackage.b.a(r10, 37, 13, 53) + Internal.hashLong(getDeltaRxSuccess());
    L45:
        if (hasRxFcsErrLevel() == false) goto L48;
        r10 = defpackage.b.a(r10, 37, 14, 53) + getRxFcsErrLevel();
    L48:
        if (hasTotalTxBytes() == false) goto L51;
        r10 = defpackage.b.a(r10, 37, 15, 53) + getTotalTxBytes();
    L51:
        if (hasDeltaTxBytes() == false) goto L54;
        r10 = defpackage.b.a(r10, 37, 16, 53) + getDeltaTxBytes();
    L54:
        if (hasTxRealSpeed() == false) goto L57;
        r10 = defpackage.b.a(r10, 37, 17, 53) + getTxRealSpeed();
    L57:
        if (hasTotalRxBytes() == false) goto L60;
        r10 = defpackage.b.a(r10, 37, 18, 53) + getTotalRxBytes();
    L60:
        if (hasDeltaRxBytes() == false) goto L63;
        r10 = defpackage.b.a(r10, 37, 19, 53) + getDeltaRxBytes();
    L63:
        if (hasRxRealSpeed() == false) goto L66;
        r10 = defpackage.b.a(r10, 37, 20, 53) + getRxRealSpeed();
    L66:
        if (hasTxMode() == false) goto L69;
        r10 = defpackage.b.a(r10, 37, 21, 53) + getTxMode();
    L69:
        if (hasTxMcs() == false) goto L72;
        r10 = defpackage.b.a(r10, 37, 22, 53) + getTxMcs();
    L72:
        if (hasTxBw() == false) goto L75;
        r10 = defpackage.b.a(r10, 37, 23, 53) + getTxBw();
    L75:
        if (hasRxMode() == false) goto L78;
        r10 = defpackage.b.a(r10, 37, 24, 53) + getRxMode();
    L78:
        if (hasRxMcs() == false) goto L81;
        r10 = defpackage.b.a(r10, 37, 25, 53) + getRxMcs();
    L81:
        if (hasRxBw() == false) goto L84;
        r10 = defpackage.b.a(r10, 37, 26, 53) + getRxBw();
    L84:
        if (hasContentionAtimeBe() == false) goto L87;
        r10 = defpackage.b.a(r10, 37, 27, 53) + getContentionAtimeBe();
    L87:
        if (hasContentionAtimeVo() == false) goto L90;
        r10 = defpackage.b.a(r10, 37, 28, 53) + getContentionAtimeVo();
    L90:
        if (hasTotalTxRetranLevelBe() == false) goto L93;
        r10 = defpackage.b.a(r10, 37, 29, 53) + Internal.hashLong(getTotalTxRetranLevelBe());
    L93:
        if (hasTotalTxRetranLevelVo() == false) goto L96;
        r10 = defpackage.b.a(r10, 37, 30, 53) + Internal.hashLong(getTotalTxRetranLevelVo());
    L96:
        if (hasDeviceTime() == false) goto L99;
        r10 = defpackage.b.a(r10, 37, 31, 53) + Internal.hashLong(getDeviceTime());
    L99:
        if (hasDeviceDate() == false) goto L102;
        r10 = defpackage.b.a(r10, 37, 32, 53) + getDeviceDate().hashCode();
    L102:
        if (hasCurrentChannelAPCount() == false) goto L105;
        r10 = defpackage.b.a(r10, 37, 33, 53) + getCurrentChannelAPCount();
    L105:
        if (hasArpNeighbourCount() == false) goto L108;
        r10 = defpackage.b.a(r10, 37, 34, 53) + getArpNeighbourCount();
    L108:
        if (hasBand() == false) goto L111;
        r10 = defpackage.b.a(r10, 37, 35, 53) + getBand().hashCode();
    L111:
        if (hasWifigeneration() == false) goto L114;
        r10 = defpackage.b.a(r10, 37, 36, 53) + getWifigeneration().hashCode();
    L114:
        if (hasRxTputPred() == false) goto L117;
        r10 = defpackage.b.a(r10, 37, 37, 53) + getRxTputPred();
    L117:
        if (hasTxTputPred() == false) goto L120;
        r10 = defpackage.b.a(r10, 37, 38, 53) + getTxTputPred();
    L120:
        if (hasWifiStandard() == false) goto L123;
        r10 = defpackage.b.a(r10, 37, 39, 53) + getWifiStandard();
    L123:
        if (hasWidth() == false) goto L126;
        r10 = defpackage.b.a(r10, 37, 40, 53) + getWidth();
    L126:
        if (hasRssiMgmt() == false) goto L129;
        r10 = defpackage.b.a(r10, 37, 41, 53) + getRssiMgmt();
    L129:
        if (hasRssiData() == false) goto L132;
        r10 = defpackage.b.a(r10, 37, 42, 53) + getRssiData();
    L132:
        if (hasRssiAck() == false) goto L135;
        r10 = defpackage.b.a(r10, 37, 43, 53) + getRssiAck();
    L135:
        if (hasRlTxLinkSpeed() == false) goto L138;
        r10 = defpackage.b.a(r10, 37, 44, 53) + getRlTxLinkSpeed();
    L138:
        if (hasRlRxLinkSpeed() == false) goto L141;
        r10 = defpackage.b.a(r10, 37, 45, 53) + getRlRxLinkSpeed();
    L141:
        if (hasRlCcaBusyRate() == false) goto L144;
        r10 = defpackage.b.a(r10, 37, 46, 53) + getRlCcaBusyRate();
    L144:
        if (hasPer() == false) goto L147;
        r10 = defpackage.b.a(r10, 37, 47, 53) + getPer();
    L147:
        if (hasOnTimeScan() == false) goto L150;
        r10 = defpackage.b.a(r10, 37, 48, 53) + getOnTimeScan();
    L150:
        if (hasTxSpeedKbps() == false) goto L153;
        r10 = defpackage.b.a(r10, 37, 49, 53) + getTxSpeedKbps();
    L153:
        if (hasRxSpeedKbps() == false) goto L156;
        r10 = defpackage.b.a(r10, 37, 50, 53) + getRxSpeedKbps();
    L156:
        if (hasTxNss() == false) goto L159;
        r10 = defpackage.b.a(r10, 37, 51, 53) + getTxNss();
    L159:
        if (hasRxNss() == false) goto L162;
        r10 = defpackage.b.a(r10, 37, 52, 53) + getRxNss();
    L162:
        if (hasDeltaChannelOnTime() == false) goto L165;
        r10 = defpackage.b.a(r10, 37, 53, 53) + getDeltaChannelOnTime();
    L165:
        if (hasDeltaChannelTxTime() == false) goto L168;
        r10 = defpackage.b.a(r10, 37, 54, 53) + getDeltaChannelTxTime();
    L168:
        if (hasDeltaChannelRxTime() == false) goto L171;
        r10 = defpackage.b.a(r10, 37, 55, 53) + getDeltaChannelRxTime();
    L171:
        if (hasDeltaChannelCcaBusyTime() == false) goto L174;
        r10 = defpackage.b.a(r10, 37, 56, 53) + getDeltaChannelCcaBusyTime();
    L174:
        if (hasPowerPredMw() == false) goto L177;
        r10 = defpackage.b.a(r10, 37, 57, 53) + Float.floatToIntBits(getPowerPredMw());
    L177:
        if (hasContentionAtimeBk() == false) goto L180;
        r10 = defpackage.b.a(r10, 37, 58, 53) + getContentionAtimeBk();
    L180:
        if (hasContentionAtimeVi() == false) goto L183;
        r10 = defpackage.b.a(r10, 37, 59, 53) + getContentionAtimeVi();
    L183:
        if (hasTxDelayAvg() == false) goto L186;
        r10 = defpackage.b.a(r10, 37, 60, 53) + Float.floatToIntBits(getTxDelayAvg());
    L186:
        if (hasTxDelayP10() == false) goto L189;
        r10 = defpackage.b.a(r10, 37, 61, 53) + Float.floatToIntBits(getTxDelayP10());
    L189:
        if (hasTxDelayP90() == false) goto L192;
        r10 = defpackage.b.a(r10, 37, 62, 53) + Float.floatToIntBits(getTxDelayP90());
    L192:
        if (hasTxDelayPkts() == false) goto L195;
        r10 = defpackage.b.a(r10, 37, 63, 53) + Internal.hashLong(getTxDelayPkts());
    L195:
        if (getDelaySizeMatrixCount() <= 0) goto L197;
        r10 = defpackage.b.a(r10, 37, 64, 53) + getDelaySizeMatrixList().hashCode();
    L197:
        int r11 = getUnknownFields().hashCode();
        int r12 = r11 + (r10 * 29);
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r8 = this.memoizedIsInitialized;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new LinkLayerQualityReportData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r17) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r17, 1, this.eventType_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r17.writeInt32(2, this.ccaScore_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r17.writeInt32(3, this.perScore_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r17.writeInt32(4, this.rssiScore_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r17.writeInt32(5, this.scenario_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r17.writeInt32(6, this.frequency_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r17.writeInt32(7, this.txLinkSpeed_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r17.writeInt32(8, this.rxLinkSpeed_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r17.writeInt32(9, this.deltaRadioOnTime_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r17.writeInt32(10, this.ccaLevel_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r17.writeInt64(11, this.deltaTxSuccess_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r17.writeInt32(12, this.txRetranLevel_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r17.writeInt64(13, this.deltaRxSuccess_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r17.writeInt32(14, this.rxFcsErrLevel_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r17.writeInt32(15, this.totalTxBytes_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r17.writeInt32(16, this.deltaTxBytes_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r17.writeInt32(17, this.txRealSpeed_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r17.writeInt32(18, this.totalRxBytes_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        r17.writeInt32(19, this.deltaRxBytes_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        r17.writeInt32(20, this.rxRealSpeed_);
    L63:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L66;
        r17.writeInt32(21, this.txMode_);
    L66:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L69;
        r17.writeInt32(22, this.txMcs_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r17.writeInt32(23, this.txBw_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L75;
        r17.writeInt32(24, this.rxMode_);
    L75:
        if ((this.bitField0_ & 16777216) == 0) goto L78;
        r17.writeInt32(25, this.rxMcs_);
    L78:
        if ((this.bitField0_ & 33554432) == 0) goto L81;
        r17.writeInt32(26, this.rxBw_);
    L81:
        if ((this.bitField0_ & 67108864) == 0) goto L84;
        r17.writeInt32(27, this.contentionAtimeBe_);
    L84:
        if ((this.bitField0_ & 134217728) == 0) goto L87;
        r17.writeInt32(28, this.contentionAtimeVo_);
    L87:
        if ((this.bitField0_ & 268435456) == 0) goto L90;
        r17.writeInt64(29, this.totalTxRetranLevelBe_);
    L90:
        if ((this.bitField0_ & 536870912) == 0) goto L93;
        r17.writeInt64(30, this.totalTxRetranLevelVo_);
    L93:
        if ((this.bitField0_ & 1073741824) == 0) goto L96;
        r17.writeUInt64(31, this.deviceTime_);
    L96:
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L99;
        GeneratedMessage.writeString(r17, 32, this.deviceDate_);
    L99:
        if ((this.bitField1_ & 1) == 0) goto L102;
        r17.writeInt32(33, this.currentChannelAPCount_);
    L102:
        if ((this.bitField1_ & 2) == 0) goto L105;
        r17.writeInt32(34, this.arpNeighbourCount_);
    L105:
        if ((this.bitField1_ & 4) == 0) goto L108;
        GeneratedMessage.writeString(r17, 35, this.band_);
    L108:
        if ((this.bitField1_ & 8) == 0) goto L111;
        GeneratedMessage.writeString(r17, 36, this.wifigeneration_);
    L111:
        if ((this.bitField1_ & 16) == 0) goto L114;
        r17.writeInt32(37, this.rxTputPred_);
    L114:
        if ((this.bitField1_ & 32) == 0) goto L117;
        r17.writeInt32(38, this.txTputPred_);
    L117:
        if ((this.bitField1_ & 64) == 0) goto L120;
        r17.writeInt32(39, this.wifiStandard_);
    L120:
        if ((this.bitField1_ & 128) == 0) goto L123;
        r17.writeInt32(40, this.width_);
    L123:
        if ((this.bitField1_ & 256) == 0) goto L126;
        r17.writeInt32(41, this.rssiMgmt_);
    L126:
        if ((this.bitField1_ & 512) == 0) goto L129;
        r17.writeInt32(42, this.rssiData_);
    L129:
        if ((this.bitField1_ & 1024) == 0) goto L132;
        r17.writeInt32(43, this.rssiAck_);
    L132:
        if ((this.bitField1_ & 2048) == 0) goto L135;
        r17.writeInt32(44, this.rlTxLinkSpeed_);
    L135:
        if ((this.bitField1_ & 4096) == 0) goto L138;
        r17.writeInt32(45, this.rlRxLinkSpeed_);
    L138:
        if ((this.bitField1_ & 8192) == 0) goto L141;
        r17.writeInt32(46, this.rlCcaBusyRate_);
    L141:
        if ((this.bitField1_ & 16384) == 0) goto L144;
        r17.writeInt32(47, this.per_);
    L144:
        if ((this.bitField1_ & 32768) == 0) goto L147;
        r17.writeInt32(48, this.onTimeScan_);
    L147:
        if ((this.bitField1_ & 65536) == 0) goto L150;
        r17.writeInt32(49, this.txSpeedKbps_);
    L150:
        if ((this.bitField1_ & 131072) == 0) goto L153;
        r17.writeInt32(50, this.rxSpeedKbps_);
    L153:
        if ((this.bitField1_ & 262144) == 0) goto L156;
        r17.writeInt32(51, this.txNss_);
    L156:
        if ((this.bitField1_ & 524288) == 0) goto L159;
        r17.writeInt32(52, this.rxNss_);
    L159:
        if ((this.bitField1_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L162;
        r17.writeInt32(53, this.deltaChannelOnTime_);
    L162:
        if ((this.bitField1_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L165;
        r17.writeInt32(54, this.deltaChannelTxTime_);
    L165:
        if ((this.bitField1_ & 4194304) == 0) goto L168;
        r17.writeInt32(55, this.deltaChannelRxTime_);
    L168:
        if ((this.bitField1_ & 8388608) == 0) goto L171;
        r17.writeInt32(56, this.deltaChannelCcaBusyTime_);
    L171:
        if ((this.bitField1_ & 16777216) == 0) goto L174;
        r17.writeFloat(57, this.powerPredMw_);
    L174:
        if ((this.bitField1_ & 33554432) == 0) goto L177;
        r17.writeInt32(58, this.contentionAtimeBk_);
    L177:
        if ((this.bitField1_ & 67108864) == 0) goto L180;
        r17.writeInt32(59, this.contentionAtimeVi_);
    L180:
        if ((this.bitField1_ & 134217728) == 0) goto L183;
        r17.writeFloat(60, this.txDelayAvg_);
    L183:
        if ((this.bitField1_ & 268435456) == 0) goto L186;
        r17.writeFloat(61, this.txDelayP10_);
    L186:
        if ((this.bitField1_ & 536870912) == 0) goto L189;
        r17.writeFloat(62, this.txDelayP90_);
    L189:
        if ((this.bitField1_ & 1073741824) == 0) goto L191;
        r17.writeInt64(63, this.txDelayPkts_);
    L191:
        int r8 = 0;
    L193:
        if (r8 >= this.delaySizeMatrix_.size()) goto L195;
        r17.writeInt32(64, this.delaySizeMatrix_.getInt(r8));
        r8 = r8 + 1;
        goto L193
    L195:
        getUnknownFields().writeTo(r17);
    }

    private LinkLayerQualityReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.ccaScore_ = 0;
        this.perScore_ = 0;
        this.rssiScore_ = 0;
        this.scenario_ = 0;
        this.frequency_ = 0;
        this.txLinkSpeed_ = 0;
        this.rxLinkSpeed_ = 0;
        this.deltaRadioOnTime_ = 0;
        this.ccaLevel_ = 0;
        this.deltaTxSuccess_ = 0;
        this.txRetranLevel_ = 0;
        this.deltaRxSuccess_ = 0;
        this.rxFcsErrLevel_ = 0;
        this.totalTxBytes_ = 0;
        this.deltaTxBytes_ = 0;
        this.txRealSpeed_ = 0;
        this.totalRxBytes_ = 0;
        this.deltaRxBytes_ = 0;
        this.rxRealSpeed_ = 0;
        this.txMode_ = 0;
        this.txMcs_ = 0;
        this.txBw_ = 0;
        this.rxMode_ = 0;
        this.rxMcs_ = 0;
        this.rxBw_ = 0;
        this.contentionAtimeBe_ = 0;
        this.contentionAtimeVo_ = 0;
        this.totalTxRetranLevelBe_ = 0;
        this.totalTxRetranLevelVo_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.currentChannelAPCount_ = 0;
        this.arpNeighbourCount_ = 0;
        this.band_ = "";
        this.wifigeneration_ = "";
        this.rxTputPred_ = 0;
        this.txTputPred_ = 0;
        this.wifiStandard_ = 0;
        this.width_ = 0;
        this.rssiMgmt_ = 0;
        this.rssiData_ = 0;
        this.rssiAck_ = 0;
        this.rlTxLinkSpeed_ = 0;
        this.rlRxLinkSpeed_ = 0;
        this.rlCcaBusyRate_ = 0;
        this.per_ = 0;
        this.onTimeScan_ = 0;
        this.txSpeedKbps_ = 0;
        this.rxSpeedKbps_ = 0;
        this.txNss_ = 0;
        this.rxNss_ = 0;
        this.deltaChannelOnTime_ = 0;
        this.deltaChannelTxTime_ = 0;
        this.deltaChannelRxTime_ = 0;
        this.deltaChannelCcaBusyTime_ = 0;
        this.powerPredMw_ = 0.0f;
        this.contentionAtimeBk_ = 0;
        this.contentionAtimeVi_ = 0;
        this.txDelayAvg_ = 0.0f;
        this.txDelayP10_ = 0.0f;
        this.txDelayP90_ = 0.0f;
        this.txDelayPkts_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(LinkLayerQualityReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static LinkLayerQualityReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (LinkLayerQualityReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static LinkLayerQualityReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkLayerQualityReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkLayerQualityReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ LinkLayerQualityReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static LinkLayerQualityReportData parseFrom(CodedInputStream r8) {
        return (LinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public LinkLayerQualityReportData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    public static LinkLayerQualityReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (LinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static LinkLayerQualityReportData parseFrom(InputStream r8) {
        return (LinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static LinkLayerQualityReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (LinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static LinkLayerQualityReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static LinkLayerQualityReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static LinkLayerQualityReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static LinkLayerQualityReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
