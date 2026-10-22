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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.obric.cae.network.BlockedReason;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MloLinkLayerQualityReportData extends GeneratedMessageV3 implements MloLinkLayerQualityReportDataOrBuilder {
    public static final int ARPNEIGHBOURCOUNT_FIELD_NUMBER = 28;
    public static final int BAND1_FIELD_NUMBER = 7;
    public static final int BAND_FIELD_NUMBER = 6;
    public static final int CCASCORE_FIELD_NUMBER = 23;
    public static final int CONTENTION_ATIME_BK_FIELD_NUMBER = 42;
    public static final int CONTENTION_ATIME_VI_FIELD_NUMBER = 43;
    public static final int CURRENTCHANNELAPCOUNT_FIELD_NUMBER = 27;
    private static final MloLinkLayerQualityReportData DEFAULT_INSTANCE = null;
    public static final int DELAY_SIZE_MATRIX_FIELD_NUMBER = 48;
    public static final int DELTARXBYTES_FIELD_NUMBER = 15;
    public static final int DELTARXFCSERR_FIELD_NUMBER = 9;
    public static final int DELTATXBYTES_FIELD_NUMBER = 12;
    public static final int DELTA_CHANNEL_CCA_BUSY_TIME_FIELD_NUMBER = 41;
    public static final int DELTA_CHANNEL_ON_TIME_FIELD_NUMBER = 38;
    public static final int DELTA_CHANNEL_RX_TIME_FIELD_NUMBER = 40;
    public static final int DELTA_CHANNEL_TX_TIME_FIELD_NUMBER = 39;
    public static final int DEVICE_DATE_FIELD_NUMBER = 31;
    public static final int DEVICE_TIME_FIELD_NUMBER = 30;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int FREQ_FIELD_NUMBER = 3;
    public static final int IFNAME_FIELD_NUMBER = 2;
    public static final int IS_MLO_IFACE_FIELD_NUMBER = 29;
    public static final int LINK_STATS_FIELD_NUMBER = 32;

    @Deprecated
    public static final Parser<MloLinkLayerQualityReportData> PARSER = null;
    public static final int PERSCORE_FIELD_NUMBER = 24;
    public static final int RSSISCORE_FIELD_NUMBER = 25;
    public static final int RXBW_FIELD_NUMBER = 22;
    public static final int RXFCSERRLEVEL_FIELD_NUMBER = 10;
    public static final int RXLINK_SPEED_FIELD_NUMBER = 5;
    public static final int RXMCS_FIELD_NUMBER = 21;
    public static final int RXMODE_FIELD_NUMBER = 20;
    public static final int RXNSS_FIELD_NUMBER = 37;
    public static final int RXREALSPEED_FIELD_NUMBER = 16;
    public static final int RX_TPUT_PRED_FIELD_NUMBER = 33;
    public static final int SCENARIO_FIELD_NUMBER = 26;
    public static final int TOTALRXBYTES_FIELD_NUMBER = 14;
    public static final int TOTALTXBYTES_FIELD_NUMBER = 11;
    public static final int TXBW_FIELD_NUMBER = 19;
    public static final int TXLINK_SPEED_FIELD_NUMBER = 4;
    public static final int TXMCS_FIELD_NUMBER = 18;
    public static final int TXMODE_FIELD_NUMBER = 17;
    public static final int TXNSS_FIELD_NUMBER = 36;
    public static final int TXREALSPEED_FIELD_NUMBER = 13;
    public static final int TX_DELAY_AVG_FIELD_NUMBER = 44;
    public static final int TX_DELAY_P10_FIELD_NUMBER = 45;
    public static final int TX_DELAY_P90_FIELD_NUMBER = 46;
    public static final int TX_DELAY_PKTS_FIELD_NUMBER = 47;
    public static final int TX_TPUT_PRED_FIELD_NUMBER = 34;
    public static final int WIFIGENERATION_FIELD_NUMBER = 8;
    public static final int WIFI_STANDARD_FIELD_NUMBER = 35;
    private static final long serialVersionUID = 0;
    private int arpNeighbourCount_;
    private volatile Object band1_;
    private volatile Object band_;
    private int bitField0_;
    private int bitField1_;
    private int ccaScore_;
    private int contentionAtimeBk_;
    private int contentionAtimeVi_;
    private int currentChannelAPCount_;
    private Internal.IntList delaySizeMatrix_;
    private int deltaChannelCcaBusyTime_;
    private int deltaChannelOnTime_;
    private int deltaChannelRxTime_;
    private int deltaChannelTxTime_;
    private int deltaRxBytes_;
    private int deltaRxFcsErr_;
    private int deltaTxBytes_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private int freq_;
    private volatile Object ifName_;
    private boolean isMloIface_;
    private List<LinkStats> linkStats_;
    private byte memoizedIsInitialized;
    private int perScore_;
    private int rssiScore_;
    private int rxBw_;
    private int rxFcsErrLevel_;
    private int rxMcs_;
    private int rxMode_;
    private int rxNss_;
    private int rxRealSpeed_;
    private int rxTputPred_;
    private int rxlinkSpeed_;
    private int scenario_;
    private int totalRxBytes_;
    private int totalTxBytes_;
    private int txBw_;
    private float txDelayAvg_;
    private float txDelayP10_;
    private float txDelayP90_;
    private long txDelayPkts_;
    private int txMcs_;
    private int txMode_;
    private int txNss_;
    private int txRealSpeed_;
    private int txTputPred_;
    private int txlinkSpeed_;
    private volatile Object wifiGeneration_;
    private int wifiStandard_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MloLinkLayerQualityReportDataOrBuilder {
        private int arpNeighbourCount_;
        private Object band1_;
        private Object band_;
        private int bitField0_;
        private int bitField1_;
        private int ccaScore_;
        private int contentionAtimeBk_;
        private int contentionAtimeVi_;
        private int currentChannelAPCount_;
        private Internal.IntList delaySizeMatrix_;
        private int deltaChannelCcaBusyTime_;
        private int deltaChannelOnTime_;
        private int deltaChannelRxTime_;
        private int deltaChannelTxTime_;
        private int deltaRxBytes_;
        private int deltaRxFcsErr_;
        private int deltaTxBytes_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private int freq_;
        private Object ifName_;
        private boolean isMloIface_;
        private RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> linkStatsBuilder_;
        private List<LinkStats> linkStats_;
        private int perScore_;
        private int rssiScore_;
        private int rxBw_;
        private int rxFcsErrLevel_;
        private int rxMcs_;
        private int rxMode_;
        private int rxNss_;
        private int rxRealSpeed_;
        private int rxTputPred_;
        private int rxlinkSpeed_;
        private int scenario_;
        private int totalRxBytes_;
        private int totalTxBytes_;
        private int txBw_;
        private float txDelayAvg_;
        private float txDelayP10_;
        private float txDelayP90_;
        private long txDelayPkts_;
        private int txMcs_;
        private int txMode_;
        private int txNss_;
        private int txRealSpeed_;
        private int txTputPred_;
        private int txlinkSpeed_;
        private Object wifiGeneration_;
        private int wifiStandard_;

        private Builder() {
            this.eventType_ = "";
            this.ifName_ = "";
            this.band_ = "";
            this.band1_ = "";
            this.wifiGeneration_ = "";
            this.deviceDate_ = "";
            this.linkStats_ = Collections.emptyList();
            this.delaySizeMatrix_ = MloLinkLayerQualityReportData.access$5500();
        }

        private void buildPartial0(MloLinkLayerQualityReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            MloLinkLayerQualityReportData.access$602(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            MloLinkLayerQualityReportData.access$702(r8, this.ifName_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            MloLinkLayerQualityReportData.access$802(r8, this.freq_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            MloLinkLayerQualityReportData.access$902(r8, this.txlinkSpeed_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            MloLinkLayerQualityReportData.access$1002(r8, this.rxlinkSpeed_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            MloLinkLayerQualityReportData.access$1102(r8, this.band_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            MloLinkLayerQualityReportData.access$1202(r8, this.band1_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            MloLinkLayerQualityReportData.access$1302(r8, this.wifiGeneration_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            MloLinkLayerQualityReportData.access$1402(r8, this.deltaRxFcsErr_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            MloLinkLayerQualityReportData.access$1502(r8, this.rxFcsErrLevel_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            MloLinkLayerQualityReportData.access$1602(r8, this.totalTxBytes_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            MloLinkLayerQualityReportData.access$1702(r8, this.deltaTxBytes_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            MloLinkLayerQualityReportData.access$1802(r8, this.txRealSpeed_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            MloLinkLayerQualityReportData.access$1902(r8, this.totalRxBytes_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            MloLinkLayerQualityReportData.access$2002(r8, this.deltaRxBytes_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            MloLinkLayerQualityReportData.access$2102(r8, this.rxRealSpeed_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            MloLinkLayerQualityReportData.access$2202(r8, this.txMode_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            MloLinkLayerQualityReportData.access$2302(r8, this.txMcs_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            MloLinkLayerQualityReportData.access$2402(r8, this.txBw_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            MloLinkLayerQualityReportData.access$2502(r8, this.rxMode_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            MloLinkLayerQualityReportData.access$2602(r8, this.rxMcs_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            MloLinkLayerQualityReportData.access$2702(r8, this.rxBw_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            MloLinkLayerQualityReportData.access$2802(r8, this.ccaScore_);
            r11 = r11 | 4194304;
        L73:
            if ((8388608 & r10) == 0) goto L76;
            MloLinkLayerQualityReportData.access$2902(r8, this.perScore_);
            r11 = r11 | 8388608;
        L76:
            if ((16777216 & r10) == 0) goto L79;
            MloLinkLayerQualityReportData.access$3002(r8, this.rssiScore_);
            r11 = r11 | 16777216;
        L79:
            if ((33554432 & r10) == 0) goto L82;
            MloLinkLayerQualityReportData.access$3102(r8, this.scenario_);
            r11 = r11 | 33554432;
        L82:
            if ((67108864 & r10) == 0) goto L85;
            MloLinkLayerQualityReportData.access$3202(r8, this.currentChannelAPCount_);
            r11 = r11 | 67108864;
        L85:
            if ((134217728 & r10) == 0) goto L88;
            MloLinkLayerQualityReportData.access$3302(r8, this.arpNeighbourCount_);
            r11 = r11 | 134217728;
        L88:
            if ((268435456 & r10) == 0) goto L91;
            MloLinkLayerQualityReportData.access$3402(r8, this.isMloIface_);
            r11 = r11 | 268435456;
        L91:
            if ((536870912 & r10) == 0) goto L94;
            MloLinkLayerQualityReportData.access$3502(r8, this.deviceTime_);
            r11 = r11 | 536870912;
        L94:
            if ((r10 & 1073741824) == 0) goto L96;
            MloLinkLayerQualityReportData.access$3602(r8, this.deviceDate_);
            r11 = r11 | 1073741824;
        L96:
            MloLinkLayerQualityReportData.access$3776(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartial1(MloLinkLayerQualityReportData r8) {
            int r10 = this.bitField1_;
            int r11 = 0;
            if ((r10 & 1) == 0) goto L5;
            MloLinkLayerQualityReportData.access$3802(r8, this.rxTputPred_);
            int r12 = Integer.MIN_VALUE;
        L7:
            if ((r10 & 2) == 0) goto L10;
            MloLinkLayerQualityReportData.access$3902(r8, this.txTputPred_);
            r11 = 1;
        L10:
            if ((r10 & 4) == 0) goto L13;
            MloLinkLayerQualityReportData.access$4002(r8, this.wifiStandard_);
            r11 = r11 | 2;
        L13:
            if ((r10 & 8) == 0) goto L16;
            MloLinkLayerQualityReportData.access$4102(r8, this.txNss_);
            r11 = r11 | 4;
        L16:
            if ((r10 & 16) == 0) goto L19;
            MloLinkLayerQualityReportData.access$4202(r8, this.rxNss_);
            r11 = r11 | 8;
        L19:
            if ((r10 & 32) == 0) goto L22;
            MloLinkLayerQualityReportData.access$4302(r8, this.deltaChannelOnTime_);
            r11 = r11 | 16;
        L22:
            if ((r10 & 64) == 0) goto L25;
            MloLinkLayerQualityReportData.access$4402(r8, this.deltaChannelTxTime_);
            r11 = r11 | 32;
        L25:
            if ((r10 & 128) == 0) goto L28;
            MloLinkLayerQualityReportData.access$4502(r8, this.deltaChannelRxTime_);
            r11 = r11 | 64;
        L28:
            if ((r10 & 256) == 0) goto L31;
            MloLinkLayerQualityReportData.access$4602(r8, this.deltaChannelCcaBusyTime_);
            r11 = r11 | 128;
        L31:
            if ((r10 & 512) == 0) goto L34;
            MloLinkLayerQualityReportData.access$4702(r8, this.contentionAtimeBk_);
            r11 = r11 | 256;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            MloLinkLayerQualityReportData.access$4802(r8, this.contentionAtimeVi_);
            r11 = r11 | 512;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            MloLinkLayerQualityReportData.access$4902(r8, this.txDelayAvg_);
            r11 = r11 | 1024;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            MloLinkLayerQualityReportData.access$5002(r8, this.txDelayP10_);
            r11 = r11 | 2048;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            MloLinkLayerQualityReportData.access$5102(r8, this.txDelayP90_);
            r11 = r11 | 4096;
        L46:
            if ((r10 & 16384) == 0) goto L48;
            MloLinkLayerQualityReportData.access$5202(r8, this.txDelayPkts_);
            r11 = r11 | 8192;
        L48:
            MloLinkLayerQualityReportData.access$3776(r8, r12);
            MloLinkLayerQualityReportData.access$5376(r8, r11);
            return;
        L5:
            r12 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(MloLinkLayerQualityReportData r8) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = this.linkStatsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            MloLinkLayerQualityReportData.access$402(r8, r11);
            if ((this.bitField1_ & 32768) == 0) goto L12;
            this.delaySizeMatrix_.makeImmutable();
            this.bitField1_ &= -32769;
        L12:
            MloLinkLayerQualityReportData.access$502(r8, this.delaySizeMatrix_);
            return;
        L5:
            if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L7;
            this.linkStats_ = Collections.unmodifiableList(this.linkStats_);
            this.bitField0_ &= Integer.MAX_VALUE;
        L7:
            r11 = this.linkStats_;
            goto L9
        }

        private void ensureDelaySizeMatrixIsMutable() {
            if ((this.bitField1_ & 32768) != 0) goto L6;
            this.delaySizeMatrix_ = MloLinkLayerQualityReportData.access$5600(this.delaySizeMatrix_);
            this.bitField1_ |= 32768;
            return;
        }

        private void ensureLinkStatsIsMutable() {
            if ((this.bitField0_ & Integer.MIN_VALUE) != 0) goto L6;
            this.linkStats_ = new ArrayList(this.linkStats_);
            this.bitField0_ |= Integer.MIN_VALUE;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_MloLinkLayerQualityReportData_descriptor;
        }

        private RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> getLinkStatsFieldBuilder() {
            if (this.linkStatsBuilder_ != null) goto L10;
            List<LinkStats> r8 = this.linkStats_;
            if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.linkStatsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.linkStats_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.linkStatsBuilder_;
        }

        public Builder addAllDelaySizeMatrix(Iterable<? extends Integer> r8) {
            ensureDelaySizeMatrixIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.delaySizeMatrix_);
            onChanged();
            return this;
        }

        public Builder addAllLinkStats(Iterable<? extends LinkStats> r8) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = this.linkStatsBuilder_;
            if (r10 != null) goto L5;
            ensureLinkStatsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.linkStats_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addDelaySizeMatrix(int r8) {
            ensureDelaySizeMatrixIsMutable();
            this.delaySizeMatrix_.addInt(r8);
            onChanged();
            return this;
        }

        public Builder addLinkStats(int r8, LinkStats.Builder r10) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r11 = this.linkStatsBuilder_;
            if (r11 != null) goto L5;
            ensureLinkStatsIsMutable();
            this.linkStats_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public LinkStats.Builder addLinkStatsBuilder() {
            return (LinkStats.Builder) getLinkStatsFieldBuilder().addBuilder(LinkStats.getDefaultInstance());
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
            this.bitField0_ &= -134217729;
            this.arpNeighbourCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBand() {
            this.band_ = MloLinkLayerQualityReportData.getDefaultInstance().getBand();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder clearBand1() {
            this.band1_ = MloLinkLayerQualityReportData.getDefaultInstance().getBand1();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder clearCcaScore() {
            this.bitField0_ &= -4194305;
            this.ccaScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeBk() {
            this.bitField1_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.contentionAtimeBk_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeVi() {
            this.bitField1_ &= -1025;
            this.contentionAtimeVi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCurrentChannelAPCount() {
            this.bitField0_ &= -67108865;
            this.currentChannelAPCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDelaySizeMatrix() {
            this.delaySizeMatrix_ = MloLinkLayerQualityReportData.access$5700();
            this.bitField1_ &= -32769;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelCcaBusyTime() {
            this.bitField1_ &= -257;
            this.deltaChannelCcaBusyTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelOnTime() {
            this.bitField1_ &= -33;
            this.deltaChannelOnTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelRxTime() {
            this.bitField1_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.deltaChannelRxTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaChannelTxTime() {
            this.bitField1_ &= -65;
            this.deltaChannelTxTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaRxBytes() {
            this.bitField0_ &= -16385;
            this.deltaRxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaRxFcsErr() {
            this.bitField0_ &= -257;
            this.deltaRxFcsErr_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaTxBytes() {
            this.bitField0_ &= -2049;
            this.deltaTxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = MloLinkLayerQualityReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -1073741825;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -536870913;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = MloLinkLayerQualityReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearFreq() {
            this.bitField0_ &= -5;
            this.freq_ = 0;
            onChanged();
            return this;
        }

        public Builder clearIfName() {
            this.ifName_ = MloLinkLayerQualityReportData.getDefaultInstance().getIfName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearIsMloIface() {
            this.bitField0_ &= -268435457;
            this.isMloIface_ = false;
            onChanged();
            return this;
        }

        public Builder clearLinkStats() {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r8 = this.linkStatsBuilder_;
            if (r8 != null) goto L5;
            this.linkStats_ = Collections.emptyList();
            this.bitField0_ &= Integer.MAX_VALUE;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPerScore() {
            this.bitField0_ &= -8388609;
            this.perScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiScore() {
            this.bitField0_ &= -16777217;
            this.rssiScore_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxBw() {
            this.bitField0_ &= -2097153;
            this.rxBw_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxFcsErrLevel() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.rxFcsErrLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxMcs() {
            this.bitField0_ &= -1048577;
            this.rxMcs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxMode() {
            this.bitField0_ &= -524289;
            this.rxMode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxNss() {
            this.bitField1_ &= -17;
            this.rxNss_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxRealSpeed() {
            this.bitField0_ &= -32769;
            this.rxRealSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxTputPred() {
            this.bitField1_ &= -2;
            this.rxTputPred_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxlinkSpeed() {
            this.bitField0_ &= -17;
            this.rxlinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearScenario() {
            this.bitField0_ &= -33554433;
            this.scenario_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalRxBytes() {
            this.bitField0_ &= -8193;
            this.totalRxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalTxBytes() {
            this.bitField0_ &= -1025;
            this.totalTxBytes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxBw() {
            this.bitField0_ &= -262145;
            this.txBw_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxDelayAvg() {
            this.bitField1_ &= -2049;
            this.txDelayAvg_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTxDelayP10() {
            this.bitField1_ &= -4097;
            this.txDelayP10_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTxDelayP90() {
            this.bitField1_ &= -8193;
            this.txDelayP90_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTxDelayPkts() {
            this.bitField1_ &= -16385;
            this.txDelayPkts_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMcs() {
            this.bitField0_ &= -131073;
            this.txMcs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMode() {
            this.bitField0_ &= -65537;
            this.txMode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxNss() {
            this.bitField1_ &= -9;
            this.txNss_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRealSpeed() {
            this.bitField0_ &= -4097;
            this.txRealSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxTputPred() {
            this.bitField1_ &= -3;
            this.txTputPred_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxlinkSpeed() {
            this.bitField0_ &= -9;
            this.txlinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiGeneration() {
            this.wifiGeneration_ = MloLinkLayerQualityReportData.getDefaultInstance().getWifiGeneration();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearWifiStandard() {
            this.bitField1_ &= -5;
            this.wifiStandard_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getArpNeighbourCount() {
            return this.arpNeighbourCount_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public String getBand1() {
            Object r8 = this.band1_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.band1_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public ByteString getBand1Bytes() {
            Object r8 = this.band1_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.band1_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public ByteString getBandBytes() {
            Object r8 = this.band_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.band_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getCcaScore() {
            return this.ccaScore_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getContentionAtimeBk() {
            return this.contentionAtimeBk_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getContentionAtimeVi() {
            return this.contentionAtimeVi_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getCurrentChannelAPCount() {
            return this.currentChannelAPCount_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDelaySizeMatrix(int r8) {
            return this.delaySizeMatrix_.getInt(r8);
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDelaySizeMatrixCount() {
            return this.delaySizeMatrix_.size();
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public List<Integer> getDelaySizeMatrixList() {
            int r8 = this.bitField1_ & 32768;
            Internal.IntList r10 = this.delaySizeMatrix_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelCcaBusyTime() {
            return this.deltaChannelCcaBusyTime_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelOnTime() {
            return this.deltaChannelOnTime_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelRxTime() {
            return this.deltaChannelRxTime_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDeltaChannelTxTime() {
            return this.deltaChannelTxTime_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDeltaRxBytes() {
            return this.deltaRxBytes_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDeltaRxFcsErr() {
            return this.deltaRxFcsErr_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getDeltaTxBytes() {
            return this.deltaTxBytes_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_MloLinkLayerQualityReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getFreq() {
            return this.freq_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public String getIfName() {
            Object r8 = this.ifName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.ifName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public ByteString getIfNameBytes() {
            Object r8 = this.ifName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.ifName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean getIsMloIface() {
            return this.isMloIface_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public LinkStats getLinkStats(int r8) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = this.linkStatsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.linkStats_.get(r8);
        L6:
            return (LinkStats) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public LinkStats.Builder getLinkStatsBuilder(int r8) {
            return (LinkStats.Builder) getLinkStatsFieldBuilder().getBuilder(r8);
        }

        public List<LinkStats.Builder> getLinkStatsBuilderList() {
            return getLinkStatsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getLinkStatsCount() {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r8 = this.linkStatsBuilder_;
            if (r8 != null) goto L7;
            return this.linkStats_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public List<LinkStats> getLinkStatsList() {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r8 = this.linkStatsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.linkStats_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public LinkStatsOrBuilder getLinkStatsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = this.linkStatsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.linkStats_.get(r8);
        L6:
            return (LinkStatsOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public List<? extends LinkStatsOrBuilder> getLinkStatsOrBuilderList() {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r8 = this.linkStatsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.linkStats_);
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getPerScore() {
            return this.perScore_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRssiScore() {
            return this.rssiScore_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxBw() {
            return this.rxBw_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxFcsErrLevel() {
            return this.rxFcsErrLevel_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxMcs() {
            return this.rxMcs_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxMode() {
            return this.rxMode_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxNss() {
            return this.rxNss_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxRealSpeed() {
            return this.rxRealSpeed_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxTputPred() {
            return this.rxTputPred_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getRxlinkSpeed() {
            return this.rxlinkSpeed_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getScenario() {
            return this.scenario_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTotalRxBytes() {
            return this.totalRxBytes_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTotalTxBytes() {
            return this.totalTxBytes_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTxBw() {
            return this.txBw_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public float getTxDelayAvg() {
            return this.txDelayAvg_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public float getTxDelayP10() {
            return this.txDelayP10_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public float getTxDelayP90() {
            return this.txDelayP90_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public long getTxDelayPkts() {
            return this.txDelayPkts_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTxMcs() {
            return this.txMcs_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTxMode() {
            return this.txMode_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTxNss() {
            return this.txNss_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTxRealSpeed() {
            return this.txRealSpeed_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTxTputPred() {
            return this.txTputPred_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getTxlinkSpeed() {
            return this.txlinkSpeed_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public String getWifiGeneration() {
            Object r8 = this.wifiGeneration_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wifiGeneration_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public ByteString getWifiGenerationBytes() {
            Object r8 = this.wifiGeneration_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wifiGeneration_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public int getWifiStandard() {
            return this.wifiStandard_;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasArpNeighbourCount() {
            if ((this.bitField0_ & 134217728) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasBand() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasBand1() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasCcaScore() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasContentionAtimeBk() {
            if ((this.bitField1_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasContentionAtimeVi() {
            if ((this.bitField1_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasCurrentChannelAPCount() {
            if ((this.bitField0_ & 67108864) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelCcaBusyTime() {
            if ((this.bitField1_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelOnTime() {
            if ((this.bitField1_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelRxTime() {
            if ((this.bitField1_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaChannelTxTime() {
            if ((this.bitField1_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaRxBytes() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaRxFcsErr() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeltaTxBytes() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 1073741824) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 536870912) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasFreq() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasIfName() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasIsMloIface() {
            if ((this.bitField0_ & 268435456) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasPerScore() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRssiScore() {
            if ((this.bitField0_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxBw() {
            if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxFcsErrLevel() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxMcs() {
            if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxMode() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxNss() {
            if ((this.bitField1_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxRealSpeed() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxTputPred() {
            if ((this.bitField1_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasRxlinkSpeed() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasScenario() {
            if ((this.bitField0_ & 33554432) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTotalRxBytes() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTotalTxBytes() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxBw() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayAvg() {
            if ((this.bitField1_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayP10() {
            if ((this.bitField1_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayP90() {
            if ((this.bitField1_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxDelayPkts() {
            if ((this.bitField1_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxMcs() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxMode() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxNss() {
            if ((this.bitField1_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxRealSpeed() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxTputPred() {
            if ((this.bitField1_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasTxlinkSpeed() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasWifiGeneration() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
        public boolean hasWifiStandard() {
            if ((this.bitField1_ & 4) == 0) goto L5;
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

        public Builder removeLinkStats(int r8) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = this.linkStatsBuilder_;
            if (r10 != null) goto L5;
            ensureLinkStatsIsMutable();
            this.linkStats_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setArpNeighbourCount(int r8) {
            this.arpNeighbourCount_ = r8;
            this.bitField0_ |= 134217728;
            onChanged();
            return this;
        }

        public Builder setBand(String r8) {
            if (r8 == null) goto L6;
            this.band_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBand1(String r8) {
            if (r8 == null) goto L6;
            this.band1_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBand1Bytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.band1_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBandBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.band_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setCcaScore(int r8) {
            this.ccaScore_ = r8;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeBk(int r8) {
            this.contentionAtimeBk_ = r8;
            this.bitField1_ |= 512;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeVi(int r8) {
            this.contentionAtimeVi_ = r8;
            this.bitField1_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setCurrentChannelAPCount(int r8) {
            this.currentChannelAPCount_ = r8;
            this.bitField0_ |= 67108864;
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
            this.bitField1_ |= 256;
            onChanged();
            return this;
        }

        public Builder setDeltaChannelOnTime(int r8) {
            this.deltaChannelOnTime_ = r8;
            this.bitField1_ |= 32;
            onChanged();
            return this;
        }

        public Builder setDeltaChannelRxTime(int r8) {
            this.deltaChannelRxTime_ = r8;
            this.bitField1_ |= 128;
            onChanged();
            return this;
        }

        public Builder setDeltaChannelTxTime(int r8) {
            this.deltaChannelTxTime_ = r8;
            this.bitField1_ |= 64;
            onChanged();
            return this;
        }

        public Builder setDeltaRxBytes(int r8) {
            this.deltaRxBytes_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setDeltaRxFcsErr(int r8) {
            this.deltaRxFcsErr_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setDeltaTxBytes(int r8) {
            this.deltaTxBytes_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 1073741824;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 1073741824;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 536870912;
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

        public Builder setFreq(int r8) {
            this.freq_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setIfName(String r8) {
            if (r8 == null) goto L6;
            this.ifName_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setIfNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.ifName_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setIsMloIface(boolean r8) {
            this.isMloIface_ = r8;
            this.bitField0_ |= 268435456;
            onChanged();
            return this;
        }

        public Builder setLinkStats(int r8, LinkStats.Builder r10) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r11 = this.linkStatsBuilder_;
            if (r11 != null) goto L5;
            ensureLinkStatsIsMutable();
            this.linkStats_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setPerScore(int r8) {
            this.perScore_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRssiScore(int r8) {
            this.rssiScore_ = r8;
            this.bitField0_ |= 16777216;
            onChanged();
            return this;
        }

        public Builder setRxBw(int r8) {
            this.rxBw_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        }

        public Builder setRxFcsErrLevel(int r8) {
            this.rxFcsErrLevel_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setRxMcs(int r8) {
            this.rxMcs_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        }

        public Builder setRxMode(int r8) {
            this.rxMode_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setRxNss(int r8) {
            this.rxNss_ = r8;
            this.bitField1_ |= 16;
            onChanged();
            return this;
        }

        public Builder setRxRealSpeed(int r8) {
            this.rxRealSpeed_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setRxTputPred(int r8) {
            this.rxTputPred_ = r8;
            this.bitField1_ |= 1;
            onChanged();
            return this;
        }

        public Builder setRxlinkSpeed(int r8) {
            this.rxlinkSpeed_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setScenario(int r8) {
            this.scenario_ = r8;
            this.bitField0_ |= 33554432;
            onChanged();
            return this;
        }

        public Builder setTotalRxBytes(int r8) {
            this.totalRxBytes_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setTotalTxBytes(int r8) {
            this.totalTxBytes_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setTxBw(int r8) {
            this.txBw_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setTxDelayAvg(float r8) {
            this.txDelayAvg_ = r8;
            this.bitField1_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setTxDelayP10(float r8) {
            this.txDelayP10_ = r8;
            this.bitField1_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setTxDelayP90(float r8) {
            this.txDelayP90_ = r8;
            this.bitField1_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setTxDelayPkts(long r8) {
            this.txDelayPkts_ = r8;
            this.bitField1_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setTxMcs(int r8) {
            this.txMcs_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setTxMode(int r8) {
            this.txMode_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setTxNss(int r8) {
            this.txNss_ = r8;
            this.bitField1_ |= 8;
            onChanged();
            return this;
        }

        public Builder setTxRealSpeed(int r8) {
            this.txRealSpeed_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setTxTputPred(int r8) {
            this.txTputPred_ = r8;
            this.bitField1_ |= 2;
            onChanged();
            return this;
        }

        public Builder setTxlinkSpeed(int r8) {
            this.txlinkSpeed_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiGeneration(String r8) {
            if (r8 == null) goto L6;
            this.wifiGeneration_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWifiGenerationBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wifiGeneration_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWifiStandard(int r8) {
            this.wifiStandard_ = r8;
            this.bitField1_ |= 4;
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.ifName_ = "";
            this.band_ = "";
            this.band1_ = "";
            this.wifiGeneration_ = "";
            this.deviceDate_ = "";
            this.linkStats_ = Collections.emptyList();
            this.delaySizeMatrix_ = MloLinkLayerQualityReportData.access$5500();
        }

        public Builder addLinkStats(int r8, LinkStats r10) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r11 = this.linkStatsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureLinkStatsIsMutable();
            this.linkStats_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public LinkStats.Builder addLinkStatsBuilder(int r8) {
            return (LinkStats.Builder) getLinkStatsFieldBuilder().addBuilder(r8, LinkStats.getDefaultInstance());
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_MloLinkLayerQualityReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(MloLinkLayerQualityReportData.class, Builder.class);
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

        public Builder setLinkStats(int r8, LinkStats r10) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r11 = this.linkStatsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureLinkStatsIsMutable();
            this.linkStats_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
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

        public Builder addLinkStats(LinkStats.Builder r8) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = this.linkStatsBuilder_;
            if (r10 != null) goto L5;
            ensureLinkStatsIsMutable();
            this.linkStats_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MloLinkLayerQualityReportData build() {
            MloLinkLayerQualityReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MloLinkLayerQualityReportData buildPartial() {
            MloLinkLayerQualityReportData r8 = new MloLinkLayerQualityReportData(this, null);
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
        public MloLinkLayerQualityReportData getDefaultInstanceForType() {
            return MloLinkLayerQualityReportData.getDefaultInstance();
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

        public Builder addLinkStats(LinkStats r8) {
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = this.linkStatsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureLinkStatsIsMutable();
            this.linkStats_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
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
            this.ifName_ = "";
            this.freq_ = 0;
            this.txlinkSpeed_ = 0;
            this.rxlinkSpeed_ = 0;
            this.band_ = "";
            this.band1_ = "";
            this.wifiGeneration_ = "";
            this.deltaRxFcsErr_ = 0;
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
            this.ccaScore_ = 0;
            this.perScore_ = 0;
            this.rssiScore_ = 0;
            this.scenario_ = 0;
            this.currentChannelAPCount_ = 0;
            this.arpNeighbourCount_ = 0;
            this.isMloIface_ = false;
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r8 = this.linkStatsBuilder_;
            if (r8 != null) goto L5;
            this.linkStats_ = Collections.emptyList();
        L6:
            this.bitField0_ &= Integer.MAX_VALUE;
            this.rxTputPred_ = 0;
            this.txTputPred_ = 0;
            this.wifiStandard_ = 0;
            this.txNss_ = 0;
            this.rxNss_ = 0;
            this.deltaChannelOnTime_ = 0;
            this.deltaChannelTxTime_ = 0;
            this.deltaChannelRxTime_ = 0;
            this.deltaChannelCcaBusyTime_ = 0;
            this.contentionAtimeBk_ = 0;
            this.contentionAtimeVi_ = 0;
            this.txDelayAvg_ = 0.0f;
            this.txDelayP10_ = 0.0f;
            this.txDelayP90_ = 0.0f;
            this.txDelayPkts_ = 0;
            this.delaySizeMatrix_ = MloLinkLayerQualityReportData.access$200();
            return this;
        L5:
            this.linkStats_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L78;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L75;
            int r12 = r8.readTag();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            switch(r12) {
                case 0: goto L65;
                case 10: goto L63;
                case 18: goto L62;
                case 24: goto L61;
                case 32: goto L60;
                case 40: goto L59;
                case 50: goto L58;
                case 58: goto L57;
                case 66: goto L56;
                case 72: goto L55;
                case 80: goto L54;
                case 88: goto L53;
                case 96: goto L52;
                case 104: goto L51;
                case 112: goto L50;
                case 120: goto L49;
                case 128: goto L48;
                case 136: goto L47;
                case 144: goto L46;
                case 152: goto L45;
                case 160: goto L44;
                case 168: goto L43;
                case 176: goto L42;
                case 184: goto L41;
                case 192: goto L40;
                case 200: goto L39;
                case 208: goto L38;
                case 216: goto L37;
                case 224: goto L36;
                case 232: goto L35;
                case 240: goto L34;
                case 250: goto L33;
                case 258: goto L29;
                case 264: goto L28;
                case 272: goto L27;
                case 280: goto L26;
                case 288: goto L25;
                case 296: goto L24;
                case 304: goto L23;
                case 312: goto L22;
                case 320: goto L21;
                case 328: goto L20;
                case 336: goto L19;
                case 344: goto L18;
                case 357: goto L17;
                case 365: goto L16;
                case 373: goto L15;
                case 376: goto L14;
                case 384: goto L13;
                case 386: goto L8;
                default: goto L66;
            };     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
        L8:
            int r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            ensureDelaySizeMatrixIsMutable();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
        L10:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.delaySizeMatrix_.addInt(r8.readInt32());     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L10
        L12:
            r8.popLimit(r13);     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L13:
            int r14 = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            ensureDelaySizeMatrixIsMutable();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.delaySizeMatrix_.addInt(r14);     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L14:
            this.txDelayPkts_ = r8.readInt64();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 16384;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L15:
            this.txDelayP90_ = r8.readFloat();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 8192;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L16:
            this.txDelayP10_ = r8.readFloat();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 4096;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L17:
            this.txDelayAvg_ = r8.readFloat();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 2048;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L18:
            this.contentionAtimeVi_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 1024;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L19:
            this.contentionAtimeBk_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 512;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L20:
            this.deltaChannelCcaBusyTime_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 256;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L21:
            this.deltaChannelRxTime_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 128;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L22:
            this.deltaChannelTxTime_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 64;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L23:
            this.deltaChannelOnTime_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 32;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L24:
            this.rxNss_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 16;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L25:
            this.txNss_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 8;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L26:
            this.wifiStandard_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 4;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L27:
            this.txTputPred_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 2;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L28:
            this.rxTputPred_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField1_ |= 1;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L29:
            LinkStats r15 = (LinkStats) r8.readMessage(LinkStats.PARSER, r10);     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r16 = this.linkStatsBuilder_;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            if (r16 == null) goto L31;
            r16.addMessage(r15);     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L31:
            ensureLinkStatsIsMutable();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.linkStats_.add(r15);     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L33:
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 1073741824;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L34:
            this.deviceTime_ = r8.readInt64();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 536870912;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L35:
            this.isMloIface_ = r8.readBool();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 268435456;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L36:
            this.arpNeighbourCount_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 134217728;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L37:
            this.currentChannelAPCount_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 67108864;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L38:
            this.scenario_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 33554432;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L39:
            this.rssiScore_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 16777216;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L40:
            this.perScore_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 8388608;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L41:
            this.ccaScore_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 4194304;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L42:
            this.rxBw_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L43:
            this.rxMcs_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L44:
            this.rxMode_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 524288;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L45:
            this.txBw_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 262144;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L46:
            this.txMcs_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 131072;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L47:
            this.txMode_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 65536;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L48:
            this.rxRealSpeed_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 32768;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L49:
            this.deltaRxBytes_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 16384;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L50:
            this.totalRxBytes_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 8192;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L51:
            this.txRealSpeed_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 4096;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L52:
            this.deltaTxBytes_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 2048;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L53:
            this.totalTxBytes_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 1024;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L54:
            this.rxFcsErrLevel_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 512;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L55:
            this.deltaRxFcsErr_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 256;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L56:
            this.wifiGeneration_ = r8.readBytes();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 128;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L57:
            this.band1_ = r8.readBytes();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 64;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L58:
            this.band_ = r8.readBytes();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 32;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L59:
            this.rxlinkSpeed_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 16;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L60:
            this.txlinkSpeed_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 8;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L61:
            this.freq_ = r8.readInt32();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 4;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L62:
            this.ifName_ = r8.readBytes();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 2;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            goto L4
        L63:
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
            this.bitField0_ |= 1;     // Catch: Throwable -> L68 InvalidProtocolBufferException -> L70
        L65:
            r11 = true;
            goto L4
        L66:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L70:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L68
        L68:
            th = move-exception;
            onChanged();
            throw th;
        L75:
            onChanged();
            return this;
        L78:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof MloLinkLayerQualityReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((MloLinkLayerQualityReportData) r8);
        }

        public Builder mergeFrom(MloLinkLayerQualityReportData r8) {
            if (r8 != MloLinkLayerQualityReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = MloLinkLayerQualityReportData.access$600(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasIfName() == false) goto L12;
            this.ifName_ = MloLinkLayerQualityReportData.access$700(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasFreq() == false) goto L15;
            setFreq(r8.getFreq());
        L15:
            if (r8.hasTxlinkSpeed() == false) goto L18;
            setTxlinkSpeed(r8.getTxlinkSpeed());
        L18:
            if (r8.hasRxlinkSpeed() == false) goto L21;
            setRxlinkSpeed(r8.getRxlinkSpeed());
        L21:
            if (r8.hasBand() == false) goto L24;
            this.band_ = MloLinkLayerQualityReportData.access$1100(r8);
            this.bitField0_ |= 32;
            onChanged();
        L24:
            if (r8.hasBand1() == false) goto L27;
            this.band1_ = MloLinkLayerQualityReportData.access$1200(r8);
            this.bitField0_ |= 64;
            onChanged();
        L27:
            if (r8.hasWifiGeneration() == false) goto L30;
            this.wifiGeneration_ = MloLinkLayerQualityReportData.access$1300(r8);
            this.bitField0_ |= 128;
            onChanged();
        L30:
            if (r8.hasDeltaRxFcsErr() == false) goto L33;
            setDeltaRxFcsErr(r8.getDeltaRxFcsErr());
        L33:
            if (r8.hasRxFcsErrLevel() == false) goto L36;
            setRxFcsErrLevel(r8.getRxFcsErrLevel());
        L36:
            if (r8.hasTotalTxBytes() == false) goto L39;
            setTotalTxBytes(r8.getTotalTxBytes());
        L39:
            if (r8.hasDeltaTxBytes() == false) goto L42;
            setDeltaTxBytes(r8.getDeltaTxBytes());
        L42:
            if (r8.hasTxRealSpeed() == false) goto L45;
            setTxRealSpeed(r8.getTxRealSpeed());
        L45:
            if (r8.hasTotalRxBytes() == false) goto L48;
            setTotalRxBytes(r8.getTotalRxBytes());
        L48:
            if (r8.hasDeltaRxBytes() == false) goto L51;
            setDeltaRxBytes(r8.getDeltaRxBytes());
        L51:
            if (r8.hasRxRealSpeed() == false) goto L54;
            setRxRealSpeed(r8.getRxRealSpeed());
        L54:
            if (r8.hasTxMode() == false) goto L57;
            setTxMode(r8.getTxMode());
        L57:
            if (r8.hasTxMcs() == false) goto L60;
            setTxMcs(r8.getTxMcs());
        L60:
            if (r8.hasTxBw() == false) goto L63;
            setTxBw(r8.getTxBw());
        L63:
            if (r8.hasRxMode() == false) goto L66;
            setRxMode(r8.getRxMode());
        L66:
            if (r8.hasRxMcs() == false) goto L69;
            setRxMcs(r8.getRxMcs());
        L69:
            if (r8.hasRxBw() == false) goto L72;
            setRxBw(r8.getRxBw());
        L72:
            if (r8.hasCcaScore() == false) goto L75;
            setCcaScore(r8.getCcaScore());
        L75:
            if (r8.hasPerScore() == false) goto L78;
            setPerScore(r8.getPerScore());
        L78:
            if (r8.hasRssiScore() == false) goto L81;
            setRssiScore(r8.getRssiScore());
        L81:
            if (r8.hasScenario() == false) goto L84;
            setScenario(r8.getScenario());
        L84:
            if (r8.hasCurrentChannelAPCount() == false) goto L87;
            setCurrentChannelAPCount(r8.getCurrentChannelAPCount());
        L87:
            if (r8.hasArpNeighbourCount() == false) goto L90;
            setArpNeighbourCount(r8.getArpNeighbourCount());
        L90:
            if (r8.hasIsMloIface() == false) goto L93;
            setIsMloIface(r8.getIsMloIface());
        L93:
            if (r8.hasDeviceTime() == false) goto L96;
            setDeviceTime(r8.getDeviceTime());
        L96:
            if (r8.hasDeviceDate() == false) goto L99;
            this.deviceDate_ = MloLinkLayerQualityReportData.access$3600(r8);
            this.bitField0_ |= 1073741824;
            onChanged();
        L99:
            if (this.linkStatsBuilder_ != null) goto L108;
            if (MloLinkLayerQualityReportData.access$400(r8).isEmpty() == true) goto L117;
            if (this.linkStats_.isEmpty() == false) goto L105;
            this.linkStats_ = MloLinkLayerQualityReportData.access$400(r8);
            this.bitField0_ &= Integer.MAX_VALUE;
        L106:
            onChanged();
            goto L117
        L105:
            ensureLinkStatsIsMutable();
            this.linkStats_.addAll(MloLinkLayerQualityReportData.access$400(r8));
        L117:
            if (r8.hasRxTputPred() == false) goto L120;
            setRxTputPred(r8.getRxTputPred());
        L120:
            if (r8.hasTxTputPred() == false) goto L123;
            setTxTputPred(r8.getTxTputPred());
        L123:
            if (r8.hasWifiStandard() == false) goto L126;
            setWifiStandard(r8.getWifiStandard());
        L126:
            if (r8.hasTxNss() == false) goto L129;
            setTxNss(r8.getTxNss());
        L129:
            if (r8.hasRxNss() == false) goto L132;
            setRxNss(r8.getRxNss());
        L132:
            if (r8.hasDeltaChannelOnTime() == false) goto L135;
            setDeltaChannelOnTime(r8.getDeltaChannelOnTime());
        L135:
            if (r8.hasDeltaChannelTxTime() == false) goto L138;
            setDeltaChannelTxTime(r8.getDeltaChannelTxTime());
        L138:
            if (r8.hasDeltaChannelRxTime() == false) goto L141;
            setDeltaChannelRxTime(r8.getDeltaChannelRxTime());
        L141:
            if (r8.hasDeltaChannelCcaBusyTime() == false) goto L144;
            setDeltaChannelCcaBusyTime(r8.getDeltaChannelCcaBusyTime());
        L144:
            if (r8.hasContentionAtimeBk() == false) goto L147;
            setContentionAtimeBk(r8.getContentionAtimeBk());
        L147:
            if (r8.hasContentionAtimeVi() == false) goto L150;
            setContentionAtimeVi(r8.getContentionAtimeVi());
        L150:
            if (r8.hasTxDelayAvg() == false) goto L153;
            setTxDelayAvg(r8.getTxDelayAvg());
        L153:
            if (r8.hasTxDelayP10() == false) goto L156;
            setTxDelayP10(r8.getTxDelayP10());
        L156:
            if (r8.hasTxDelayP90() == false) goto L159;
            setTxDelayP90(r8.getTxDelayP90());
        L159:
            if (r8.hasTxDelayPkts() == false) goto L162;
            setTxDelayPkts(r8.getTxDelayPkts());
        L162:
            if (MloLinkLayerQualityReportData.access$500(r8).isEmpty() == false) goto L164;
        L168:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L164:
            if (this.delaySizeMatrix_.isEmpty() == false) goto L166;
            this.delaySizeMatrix_ = MloLinkLayerQualityReportData.access$500(r8);
            this.bitField1_ &= -32769;
        L167:
            onChanged();
            goto L168
        L166:
            ensureDelaySizeMatrixIsMutable();
            this.delaySizeMatrix_.addAll(MloLinkLayerQualityReportData.access$500(r8));
            goto L167
        L108:
            if (MloLinkLayerQualityReportData.access$400(r8).isEmpty() == true) goto L117;
            if (this.linkStatsBuilder_.isEmpty() == false) goto L115;
            this.linkStatsBuilder_.dispose();
            RepeatedFieldBuilderV3<LinkStats, LinkStats.Builder, LinkStatsOrBuilder> r10 = null;
            this.linkStatsBuilder_ = null;
            this.linkStats_ = MloLinkLayerQualityReportData.access$400(r8);
            this.bitField0_ = Integer.MAX_VALUE & this.bitField0_;
            if (MloLinkLayerQualityReportData.access$5400() == false) goto L114;
            r10 = getLinkStatsFieldBuilder();
        L114:
            this.linkStatsBuilder_ = r10;
            goto L117
        L115:
            this.linkStatsBuilder_.addAllMessages(MloLinkLayerQualityReportData.access$400(r8));
            goto L117
        }
    }

    static {
        DEFAULT_INSTANCE = new MloLinkLayerQualityReportData();
        PARSER = new AnonymousClass1();
    }

    private MloLinkLayerQualityReportData() {
        this.eventType_ = "";
        this.ifName_ = "";
        this.freq_ = 0;
        this.txlinkSpeed_ = 0;
        this.rxlinkSpeed_ = 0;
        this.band_ = "";
        this.band1_ = "";
        this.wifiGeneration_ = "";
        this.deltaRxFcsErr_ = 0;
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
        this.ccaScore_ = 0;
        this.perScore_ = 0;
        this.rssiScore_ = 0;
        this.scenario_ = 0;
        this.currentChannelAPCount_ = 0;
        this.arpNeighbourCount_ = 0;
        this.isMloIface_ = false;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.rxTputPred_ = 0;
        this.txTputPred_ = 0;
        this.wifiStandard_ = 0;
        this.txNss_ = 0;
        this.rxNss_ = 0;
        this.deltaChannelOnTime_ = 0;
        this.deltaChannelTxTime_ = 0;
        this.deltaChannelRxTime_ = 0;
        this.deltaChannelCcaBusyTime_ = 0;
        this.contentionAtimeBk_ = 0;
        this.contentionAtimeVi_ = 0;
        this.txDelayAvg_ = 0.0f;
        this.txDelayP10_ = 0.0f;
        this.txDelayP90_ = 0.0f;
        this.txDelayPkts_ = 0;
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.ifName_ = "";
        this.band_ = "";
        this.band1_ = "";
        this.wifiGeneration_ = "";
        this.deviceDate_ = "";
        this.linkStats_ = Collections.emptyList();
        this.delaySizeMatrix_ = GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ int access$1002(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxlinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1100(MloLinkLayerQualityReportData r8) {
        return r8.band_;
    }

    public static /* synthetic */ Object access$1102(MloLinkLayerQualityReportData r8, Object r10) {
        r8.band_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1200(MloLinkLayerQualityReportData r8) {
        return r8.band1_;
    }

    public static /* synthetic */ Object access$1202(MloLinkLayerQualityReportData r8, Object r10) {
        r8.band1_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1300(MloLinkLayerQualityReportData r8) {
        return r8.wifiGeneration_;
    }

    public static /* synthetic */ Object access$1302(MloLinkLayerQualityReportData r8, Object r10) {
        r8.wifiGeneration_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(MloLinkLayerQualityReportData r8, int r10) {
        r8.deltaRxFcsErr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxFcsErrLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(MloLinkLayerQualityReportData r8, int r10) {
        r8.totalTxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1702(MloLinkLayerQualityReportData r8, int r10) {
        r8.deltaTxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(MloLinkLayerQualityReportData r8, int r10) {
        r8.txRealSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1902(MloLinkLayerQualityReportData r8, int r10) {
        r8.totalRxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$200() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ int access$2002(MloLinkLayerQualityReportData r8, int r10) {
        r8.deltaRxBytes_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2102(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxRealSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2202(MloLinkLayerQualityReportData r8, int r10) {
        r8.txMode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2302(MloLinkLayerQualityReportData r8, int r10) {
        r8.txMcs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2402(MloLinkLayerQualityReportData r8, int r10) {
        r8.txBw_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2502(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxMode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2602(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxMcs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2702(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxBw_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2802(MloLinkLayerQualityReportData r8, int r10) {
        r8.ccaScore_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2902(MloLinkLayerQualityReportData r8, int r10) {
        r8.perScore_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3002(MloLinkLayerQualityReportData r8, int r10) {
        r8.rssiScore_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3102(MloLinkLayerQualityReportData r8, int r10) {
        r8.scenario_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3202(MloLinkLayerQualityReportData r8, int r10) {
        r8.currentChannelAPCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3302(MloLinkLayerQualityReportData r8, int r10) {
        r8.arpNeighbourCount_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$3402(MloLinkLayerQualityReportData r8, boolean r10) {
        r8.isMloIface_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$3502(MloLinkLayerQualityReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$3600(MloLinkLayerQualityReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$3602(MloLinkLayerQualityReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3776(MloLinkLayerQualityReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$3802(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxTputPred_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3902(MloLinkLayerQualityReportData r8, int r10) {
        r8.txTputPred_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(MloLinkLayerQualityReportData r8) {
        return r8.linkStats_;
    }

    public static /* synthetic */ int access$4002(MloLinkLayerQualityReportData r8, int r10) {
        r8.wifiStandard_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$402(MloLinkLayerQualityReportData r8, List r10) {
        r8.linkStats_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4102(MloLinkLayerQualityReportData r8, int r10) {
        r8.txNss_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4202(MloLinkLayerQualityReportData r8, int r10) {
        r8.rxNss_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4302(MloLinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelOnTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4402(MloLinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelTxTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4502(MloLinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelRxTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4602(MloLinkLayerQualityReportData r8, int r10) {
        r8.deltaChannelCcaBusyTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4702(MloLinkLayerQualityReportData r8, int r10) {
        r8.contentionAtimeBk_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4802(MloLinkLayerQualityReportData r8, int r10) {
        r8.contentionAtimeVi_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$4902(MloLinkLayerQualityReportData r8, float r10) {
        r8.txDelayAvg_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$500(MloLinkLayerQualityReportData r8) {
        return r8.delaySizeMatrix_;
    }

    public static /* synthetic */ float access$5002(MloLinkLayerQualityReportData r8, float r10) {
        r8.txDelayP10_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$502(MloLinkLayerQualityReportData r8, Internal.IntList r10) {
        r8.delaySizeMatrix_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$5102(MloLinkLayerQualityReportData r8, float r10) {
        r8.txDelayP90_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$5202(MloLinkLayerQualityReportData r8, long r10) {
        r8.txDelayPkts_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$5376(MloLinkLayerQualityReportData r8, int r10) {
        int r11 = r10 | r8.bitField1_;
        r8.bitField1_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$5400() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Internal.IntList access$5500() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Internal.IntList access$5600(Internal.IntList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.IntList access$5700() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Object access$600(MloLinkLayerQualityReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$602(MloLinkLayerQualityReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(MloLinkLayerQualityReportData r8) {
        return r8.ifName_;
    }

    public static /* synthetic */ Object access$702(MloLinkLayerQualityReportData r8, Object r10) {
        r8.ifName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(MloLinkLayerQualityReportData r8, int r10) {
        r8.freq_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(MloLinkLayerQualityReportData r8, int r10) {
        r8.txlinkSpeed_ = r10;
        return r10;
    }

    public static MloLinkLayerQualityReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_MloLinkLayerQualityReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static MloLinkLayerQualityReportData parseDelimitedFrom(InputStream r8) {
        return (MloLinkLayerQualityReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static MloLinkLayerQualityReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<MloLinkLayerQualityReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof MloLinkLayerQualityReportData) == false) goto L8;
        MloLinkLayerQualityReportData r10 = (MloLinkLayerQualityReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasIfName() == r10.hasIfName()) goto L21;
        return false;
    L21:
        if (hasIfName() == false) goto L26;
        if (getIfName().equals(r10.getIfName()) == true) goto L26;
        return false;
    L26:
        if (hasFreq() == r10.hasFreq()) goto L29;
        return false;
    L29:
        if (hasFreq() == false) goto L34;
        if (getFreq() == r10.getFreq()) goto L34;
        return false;
    L34:
        if (hasTxlinkSpeed() == r10.hasTxlinkSpeed()) goto L37;
        return false;
    L37:
        if (hasTxlinkSpeed() == false) goto L42;
        if (getTxlinkSpeed() == r10.getTxlinkSpeed()) goto L42;
        return false;
    L42:
        if (hasRxlinkSpeed() == r10.hasRxlinkSpeed()) goto L45;
        return false;
    L45:
        if (hasRxlinkSpeed() == false) goto L50;
        if (getRxlinkSpeed() == r10.getRxlinkSpeed()) goto L50;
        return false;
    L50:
        if (hasBand() == r10.hasBand()) goto L53;
        return false;
    L53:
        if (hasBand() == false) goto L58;
        if (getBand().equals(r10.getBand()) == true) goto L58;
        return false;
    L58:
        if (hasBand1() == r10.hasBand1()) goto L61;
        return false;
    L61:
        if (hasBand1() == false) goto L66;
        if (getBand1().equals(r10.getBand1()) == true) goto L66;
        return false;
    L66:
        if (hasWifiGeneration() == r10.hasWifiGeneration()) goto L69;
        return false;
    L69:
        if (hasWifiGeneration() == false) goto L74;
        if (getWifiGeneration().equals(r10.getWifiGeneration()) == true) goto L74;
        return false;
    L74:
        if (hasDeltaRxFcsErr() == r10.hasDeltaRxFcsErr()) goto L77;
        return false;
    L77:
        if (hasDeltaRxFcsErr() == false) goto L82;
        if (getDeltaRxFcsErr() == r10.getDeltaRxFcsErr()) goto L82;
        return false;
    L82:
        if (hasRxFcsErrLevel() == r10.hasRxFcsErrLevel()) goto L85;
        return false;
    L85:
        if (hasRxFcsErrLevel() == false) goto L90;
        if (getRxFcsErrLevel() == r10.getRxFcsErrLevel()) goto L90;
        return false;
    L90:
        if (hasTotalTxBytes() == r10.hasTotalTxBytes()) goto L93;
        return false;
    L93:
        if (hasTotalTxBytes() == false) goto L98;
        if (getTotalTxBytes() == r10.getTotalTxBytes()) goto L98;
        return false;
    L98:
        if (hasDeltaTxBytes() == r10.hasDeltaTxBytes()) goto L101;
        return false;
    L101:
        if (hasDeltaTxBytes() == false) goto L106;
        if (getDeltaTxBytes() == r10.getDeltaTxBytes()) goto L106;
        return false;
    L106:
        if (hasTxRealSpeed() == r10.hasTxRealSpeed()) goto L109;
        return false;
    L109:
        if (hasTxRealSpeed() == false) goto L114;
        if (getTxRealSpeed() == r10.getTxRealSpeed()) goto L114;
        return false;
    L114:
        if (hasTotalRxBytes() == r10.hasTotalRxBytes()) goto L117;
        return false;
    L117:
        if (hasTotalRxBytes() == false) goto L122;
        if (getTotalRxBytes() == r10.getTotalRxBytes()) goto L122;
        return false;
    L122:
        if (hasDeltaRxBytes() == r10.hasDeltaRxBytes()) goto L125;
        return false;
    L125:
        if (hasDeltaRxBytes() == false) goto L130;
        if (getDeltaRxBytes() == r10.getDeltaRxBytes()) goto L130;
        return false;
    L130:
        if (hasRxRealSpeed() == r10.hasRxRealSpeed()) goto L133;
        return false;
    L133:
        if (hasRxRealSpeed() == false) goto L138;
        if (getRxRealSpeed() == r10.getRxRealSpeed()) goto L138;
        return false;
    L138:
        if (hasTxMode() == r10.hasTxMode()) goto L141;
        return false;
    L141:
        if (hasTxMode() == false) goto L146;
        if (getTxMode() == r10.getTxMode()) goto L146;
        return false;
    L146:
        if (hasTxMcs() == r10.hasTxMcs()) goto L149;
        return false;
    L149:
        if (hasTxMcs() == false) goto L154;
        if (getTxMcs() == r10.getTxMcs()) goto L154;
        return false;
    L154:
        if (hasTxBw() == r10.hasTxBw()) goto L157;
        return false;
    L157:
        if (hasTxBw() == false) goto L162;
        if (getTxBw() == r10.getTxBw()) goto L162;
        return false;
    L162:
        if (hasRxMode() == r10.hasRxMode()) goto L165;
        return false;
    L165:
        if (hasRxMode() == false) goto L170;
        if (getRxMode() == r10.getRxMode()) goto L170;
        return false;
    L170:
        if (hasRxMcs() == r10.hasRxMcs()) goto L173;
        return false;
    L173:
        if (hasRxMcs() == false) goto L178;
        if (getRxMcs() == r10.getRxMcs()) goto L178;
        return false;
    L178:
        if (hasRxBw() == r10.hasRxBw()) goto L181;
        return false;
    L181:
        if (hasRxBw() == false) goto L186;
        if (getRxBw() == r10.getRxBw()) goto L186;
        return false;
    L186:
        if (hasCcaScore() == r10.hasCcaScore()) goto L189;
        return false;
    L189:
        if (hasCcaScore() == false) goto L194;
        if (getCcaScore() == r10.getCcaScore()) goto L194;
        return false;
    L194:
        if (hasPerScore() == r10.hasPerScore()) goto L197;
        return false;
    L197:
        if (hasPerScore() == false) goto L202;
        if (getPerScore() == r10.getPerScore()) goto L202;
        return false;
    L202:
        if (hasRssiScore() == r10.hasRssiScore()) goto L205;
        return false;
    L205:
        if (hasRssiScore() == false) goto L210;
        if (getRssiScore() == r10.getRssiScore()) goto L210;
        return false;
    L210:
        if (hasScenario() == r10.hasScenario()) goto L213;
        return false;
    L213:
        if (hasScenario() == false) goto L218;
        if (getScenario() == r10.getScenario()) goto L218;
        return false;
    L218:
        if (hasCurrentChannelAPCount() == r10.hasCurrentChannelAPCount()) goto L221;
        return false;
    L221:
        if (hasCurrentChannelAPCount() == false) goto L226;
        if (getCurrentChannelAPCount() == r10.getCurrentChannelAPCount()) goto L226;
        return false;
    L226:
        if (hasArpNeighbourCount() == r10.hasArpNeighbourCount()) goto L229;
        return false;
    L229:
        if (hasArpNeighbourCount() == false) goto L234;
        if (getArpNeighbourCount() == r10.getArpNeighbourCount()) goto L234;
        return false;
    L234:
        if (hasIsMloIface() == r10.hasIsMloIface()) goto L237;
        return false;
    L237:
        if (hasIsMloIface() == false) goto L242;
        if (getIsMloIface() == r10.getIsMloIface()) goto L242;
        return false;
    L242:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L245;
        return false;
    L245:
        if (hasDeviceTime() == false) goto L250;
        if (getDeviceTime() == r10.getDeviceTime()) goto L250;
        return false;
    L250:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L253;
        return false;
    L253:
        if (hasDeviceDate() == false) goto L258;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L258;
        return false;
    L258:
        if (getLinkStatsList().equals(r10.getLinkStatsList()) == true) goto L261;
        return false;
    L261:
        if (hasRxTputPred() == r10.hasRxTputPred()) goto L264;
        return false;
    L264:
        if (hasRxTputPred() == false) goto L269;
        if (getRxTputPred() == r10.getRxTputPred()) goto L269;
        return false;
    L269:
        if (hasTxTputPred() == r10.hasTxTputPred()) goto L272;
        return false;
    L272:
        if (hasTxTputPred() == false) goto L277;
        if (getTxTputPred() == r10.getTxTputPred()) goto L277;
        return false;
    L277:
        if (hasWifiStandard() == r10.hasWifiStandard()) goto L280;
        return false;
    L280:
        if (hasWifiStandard() == false) goto L285;
        if (getWifiStandard() == r10.getWifiStandard()) goto L285;
        return false;
    L285:
        if (hasTxNss() == r10.hasTxNss()) goto L288;
        return false;
    L288:
        if (hasTxNss() == false) goto L293;
        if (getTxNss() == r10.getTxNss()) goto L293;
        return false;
    L293:
        if (hasRxNss() == r10.hasRxNss()) goto L296;
        return false;
    L296:
        if (hasRxNss() == false) goto L301;
        if (getRxNss() == r10.getRxNss()) goto L301;
        return false;
    L301:
        if (hasDeltaChannelOnTime() == r10.hasDeltaChannelOnTime()) goto L304;
        return false;
    L304:
        if (hasDeltaChannelOnTime() == false) goto L309;
        if (getDeltaChannelOnTime() == r10.getDeltaChannelOnTime()) goto L309;
        return false;
    L309:
        if (hasDeltaChannelTxTime() == r10.hasDeltaChannelTxTime()) goto L312;
        return false;
    L312:
        if (hasDeltaChannelTxTime() == false) goto L317;
        if (getDeltaChannelTxTime() == r10.getDeltaChannelTxTime()) goto L317;
        return false;
    L317:
        if (hasDeltaChannelRxTime() == r10.hasDeltaChannelRxTime()) goto L320;
        return false;
    L320:
        if (hasDeltaChannelRxTime() == false) goto L325;
        if (getDeltaChannelRxTime() == r10.getDeltaChannelRxTime()) goto L325;
        return false;
    L325:
        if (hasDeltaChannelCcaBusyTime() == r10.hasDeltaChannelCcaBusyTime()) goto L328;
        return false;
    L328:
        if (hasDeltaChannelCcaBusyTime() == false) goto L333;
        if (getDeltaChannelCcaBusyTime() == r10.getDeltaChannelCcaBusyTime()) goto L333;
        return false;
    L333:
        if (hasContentionAtimeBk() == r10.hasContentionAtimeBk()) goto L336;
        return false;
    L336:
        if (hasContentionAtimeBk() == false) goto L341;
        if (getContentionAtimeBk() == r10.getContentionAtimeBk()) goto L341;
        return false;
    L341:
        if (hasContentionAtimeVi() == r10.hasContentionAtimeVi()) goto L344;
        return false;
    L344:
        if (hasContentionAtimeVi() == false) goto L349;
        if (getContentionAtimeVi() == r10.getContentionAtimeVi()) goto L349;
        return false;
    L349:
        if (hasTxDelayAvg() == r10.hasTxDelayAvg()) goto L352;
        return false;
    L352:
        if (hasTxDelayAvg() == false) goto L357;
        if (Float.floatToIntBits(getTxDelayAvg()) == Float.floatToIntBits(r10.getTxDelayAvg())) goto L357;
        return false;
    L357:
        if (hasTxDelayP10() == r10.hasTxDelayP10()) goto L360;
        return false;
    L360:
        if (hasTxDelayP10() == false) goto L365;
        if (Float.floatToIntBits(getTxDelayP10()) == Float.floatToIntBits(r10.getTxDelayP10())) goto L365;
        return false;
    L365:
        if (hasTxDelayP90() == r10.hasTxDelayP90()) goto L368;
        return false;
    L368:
        if (hasTxDelayP90() == false) goto L373;
        if (Float.floatToIntBits(getTxDelayP90()) == Float.floatToIntBits(r10.getTxDelayP90())) goto L373;
        return false;
    L373:
        if (hasTxDelayPkts() == r10.hasTxDelayPkts()) goto L376;
        return false;
    L376:
        if (hasTxDelayPkts() == false) goto L381;
        if (getTxDelayPkts() == r10.getTxDelayPkts()) goto L381;
        return false;
    L381:
        if (getDelaySizeMatrixList().equals(r10.getDelaySizeMatrixList()) == true) goto L384;
        return false;
    L384:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L386;
        return false;
    L386:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getArpNeighbourCount() {
        return this.arpNeighbourCount_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public String getBand1() {
        Object r8 = this.band1_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.band1_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public ByteString getBand1Bytes() {
        Object r8 = this.band1_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.band1_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public ByteString getBandBytes() {
        Object r8 = this.band_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.band_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getCcaScore() {
        return this.ccaScore_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getContentionAtimeBk() {
        return this.contentionAtimeBk_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getContentionAtimeVi() {
        return this.contentionAtimeVi_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getCurrentChannelAPCount() {
        return this.currentChannelAPCount_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDelaySizeMatrix(int r8) {
        return this.delaySizeMatrix_.getInt(r8);
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDelaySizeMatrixCount() {
        return this.delaySizeMatrix_.size();
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public List<Integer> getDelaySizeMatrixList() {
        return this.delaySizeMatrix_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelCcaBusyTime() {
        return this.deltaChannelCcaBusyTime_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelOnTime() {
        return this.deltaChannelOnTime_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelRxTime() {
        return this.deltaChannelRxTime_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDeltaChannelTxTime() {
        return this.deltaChannelTxTime_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDeltaRxBytes() {
        return this.deltaRxBytes_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDeltaRxFcsErr() {
        return this.deltaRxFcsErr_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getDeltaTxBytes() {
        return this.deltaTxBytes_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getFreq() {
        return this.freq_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public String getIfName() {
        Object r8 = this.ifName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.ifName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public ByteString getIfNameBytes() {
        Object r8 = this.ifName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.ifName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean getIsMloIface() {
        return this.isMloIface_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public LinkStats getLinkStats(int r8) {
        return this.linkStats_.get(r8);
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getLinkStatsCount() {
        return this.linkStats_.size();
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public List<LinkStats> getLinkStatsList() {
        return this.linkStats_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public LinkStatsOrBuilder getLinkStatsOrBuilder(int r8) {
        return this.linkStats_.get(r8);
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public List<? extends LinkStatsOrBuilder> getLinkStatsOrBuilderList() {
        return this.linkStats_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MloLinkLayerQualityReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getPerScore() {
        return this.perScore_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRssiScore() {
        return this.rssiScore_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxBw() {
        return this.rxBw_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxFcsErrLevel() {
        return this.rxFcsErrLevel_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxMcs() {
        return this.rxMcs_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxMode() {
        return this.rxMode_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxNss() {
        return this.rxNss_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxRealSpeed() {
        return this.rxRealSpeed_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxTputPred() {
        return this.rxTputPred_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getRxlinkSpeed() {
        return this.rxlinkSpeed_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getScenario() {
        return this.scenario_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.eventType_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + GeneratedMessage.computeStringSize(2, this.ifName_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeInt32Size(3, this.freq_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L19;
        r11 = r11 + CodedOutputStream.computeInt32Size(4, this.txlinkSpeed_);
    L19:
        if ((this.bitField0_ & 16) == 0) goto L22;
        r11 = r11 + CodedOutputStream.computeInt32Size(5, this.rxlinkSpeed_);
    L22:
        if ((this.bitField0_ & 32) == 0) goto L25;
        r11 = r11 + GeneratedMessage.computeStringSize(6, this.band_);
    L25:
        if ((this.bitField0_ & 64) == 0) goto L28;
        r11 = r11 + GeneratedMessage.computeStringSize(7, this.band1_);
    L28:
        if ((this.bitField0_ & 128) == 0) goto L31;
        r11 = r11 + GeneratedMessage.computeStringSize(8, this.wifiGeneration_);
    L31:
        if ((this.bitField0_ & 256) == 0) goto L34;
        r11 = r11 + CodedOutputStream.computeInt32Size(9, this.deltaRxFcsErr_);
    L34:
        if ((this.bitField0_ & 512) == 0) goto L37;
        r11 = r11 + CodedOutputStream.computeInt32Size(10, this.rxFcsErrLevel_);
    L37:
        if ((this.bitField0_ & 1024) == 0) goto L40;
        r11 = r11 + CodedOutputStream.computeInt32Size(11, this.totalTxBytes_);
    L40:
        if ((this.bitField0_ & 2048) == 0) goto L43;
        r11 = r11 + CodedOutputStream.computeInt32Size(12, this.deltaTxBytes_);
    L43:
        if ((this.bitField0_ & 4096) == 0) goto L46;
        r11 = r11 + CodedOutputStream.computeInt32Size(13, this.txRealSpeed_);
    L46:
        if ((this.bitField0_ & 8192) == 0) goto L49;
        r11 = r11 + CodedOutputStream.computeInt32Size(14, this.totalRxBytes_);
    L49:
        if ((this.bitField0_ & 16384) == 0) goto L52;
        r11 = r11 + CodedOutputStream.computeInt32Size(15, this.deltaRxBytes_);
    L52:
        if ((this.bitField0_ & 32768) == 0) goto L55;
        r11 = r11 + CodedOutputStream.computeInt32Size(16, this.rxRealSpeed_);
    L55:
        if ((this.bitField0_ & 65536) == 0) goto L58;
        r11 = r11 + CodedOutputStream.computeInt32Size(17, this.txMode_);
    L58:
        if ((this.bitField0_ & 131072) == 0) goto L61;
        r11 = r11 + CodedOutputStream.computeInt32Size(18, this.txMcs_);
    L61:
        if ((this.bitField0_ & 262144) == 0) goto L64;
        r11 = r11 + CodedOutputStream.computeInt32Size(19, this.txBw_);
    L64:
        if ((this.bitField0_ & 524288) == 0) goto L67;
        r11 = r11 + CodedOutputStream.computeInt32Size(20, this.rxMode_);
    L67:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L70;
        r11 = r11 + CodedOutputStream.computeInt32Size(21, this.rxMcs_);
    L70:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L73;
        r11 = r11 + CodedOutputStream.computeInt32Size(22, this.rxBw_);
    L73:
        if ((this.bitField0_ & 4194304) == 0) goto L76;
        r11 = r11 + CodedOutputStream.computeInt32Size(23, this.ccaScore_);
    L76:
        if ((this.bitField0_ & 8388608) == 0) goto L79;
        r11 = r11 + CodedOutputStream.computeInt32Size(24, this.perScore_);
    L79:
        if ((this.bitField0_ & 16777216) == 0) goto L82;
        r11 = r11 + CodedOutputStream.computeInt32Size(25, this.rssiScore_);
    L82:
        if ((this.bitField0_ & 33554432) == 0) goto L85;
        r11 = r11 + CodedOutputStream.computeInt32Size(26, this.scenario_);
    L85:
        if ((this.bitField0_ & 67108864) == 0) goto L88;
        r11 = r11 + CodedOutputStream.computeInt32Size(27, this.currentChannelAPCount_);
    L88:
        if ((this.bitField0_ & 134217728) == 0) goto L91;
        r11 = r11 + CodedOutputStream.computeInt32Size(28, this.arpNeighbourCount_);
    L91:
        if ((this.bitField0_ & 268435456) == 0) goto L94;
        r11 = r11 + CodedOutputStream.computeBoolSize(29, this.isMloIface_);
    L94:
        if ((this.bitField0_ & 536870912) == 0) goto L97;
        r11 = r11 + CodedOutputStream.computeInt64Size(30, this.deviceTime_);
    L97:
        if ((this.bitField0_ & 1073741824) == 0) goto L99;
        r11 = r11 + GeneratedMessage.computeStringSize(31, this.deviceDate_);
    L99:
        int r12 = 0;
    L101:
        if (r12 >= this.linkStats_.size()) goto L104;
        r11 = r11 + CodedOutputStream.computeMessageSize(32, this.linkStats_.get(r12));
        r12 = r12 + 1;
        goto L101
    L104:
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L107;
        r11 = r11 + CodedOutputStream.computeInt32Size(33, this.rxTputPred_);
    L107:
        if ((1 & this.bitField1_) == 0) goto L110;
        r11 = r11 + CodedOutputStream.computeInt32Size(34, this.txTputPred_);
    L110:
        if ((this.bitField1_ & 2) == 0) goto L113;
        r11 = r11 + CodedOutputStream.computeInt32Size(35, this.wifiStandard_);
    L113:
        if ((this.bitField1_ & 4) == 0) goto L116;
        r11 = r11 + CodedOutputStream.computeInt32Size(36, this.txNss_);
    L116:
        if ((this.bitField1_ & 8) == 0) goto L119;
        r11 = r11 + CodedOutputStream.computeInt32Size(37, this.rxNss_);
    L119:
        if ((this.bitField1_ & 16) == 0) goto L122;
        r11 = r11 + CodedOutputStream.computeInt32Size(38, this.deltaChannelOnTime_);
    L122:
        if ((this.bitField1_ & 32) == 0) goto L125;
        r11 = r11 + CodedOutputStream.computeInt32Size(39, this.deltaChannelTxTime_);
    L125:
        if ((this.bitField1_ & 64) == 0) goto L128;
        r11 = r11 + CodedOutputStream.computeInt32Size(40, this.deltaChannelRxTime_);
    L128:
        if ((this.bitField1_ & 128) == 0) goto L131;
        r11 = r11 + CodedOutputStream.computeInt32Size(41, this.deltaChannelCcaBusyTime_);
    L131:
        if ((this.bitField1_ & 256) == 0) goto L134;
        r11 = r11 + CodedOutputStream.computeInt32Size(42, this.contentionAtimeBk_);
    L134:
        if ((this.bitField1_ & 512) == 0) goto L137;
        r11 = r11 + CodedOutputStream.computeInt32Size(43, this.contentionAtimeVi_);
    L137:
        if ((this.bitField1_ & 1024) == 0) goto L140;
        r11 = r11 + CodedOutputStream.computeFloatSize(44, this.txDelayAvg_);
    L140:
        if ((this.bitField1_ & 2048) == 0) goto L143;
        r11 = r11 + CodedOutputStream.computeFloatSize(45, this.txDelayP10_);
    L143:
        if ((this.bitField1_ & 4096) == 0) goto L146;
        r11 = r11 + CodedOutputStream.computeFloatSize(46, this.txDelayP90_);
    L146:
        if ((this.bitField1_ & 8192) == 0) goto L148;
        r11 = r11 + CodedOutputStream.computeInt64Size(47, this.txDelayPkts_);
    L148:
        int r13 = 0;
    L150:
        if (r10 >= this.delaySizeMatrix_.size()) goto L152;
        r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(this.delaySizeMatrix_.getInt(r10));
        r10 = r10 + 1;
        goto L150
    L152:
        int r14 = getUnknownFields().getSerializedSize() + ((getDelaySizeMatrixList().size() * 2) + (r11 + r13));
        this.memoizedSize = r14;
        return r14;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTotalRxBytes() {
        return this.totalRxBytes_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTotalTxBytes() {
        return this.totalTxBytes_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTxBw() {
        return this.txBw_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public float getTxDelayAvg() {
        return this.txDelayAvg_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public float getTxDelayP10() {
        return this.txDelayP10_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public float getTxDelayP90() {
        return this.txDelayP90_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public long getTxDelayPkts() {
        return this.txDelayPkts_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTxMcs() {
        return this.txMcs_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTxMode() {
        return this.txMode_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTxNss() {
        return this.txNss_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTxRealSpeed() {
        return this.txRealSpeed_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTxTputPred() {
        return this.txTputPred_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getTxlinkSpeed() {
        return this.txlinkSpeed_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public String getWifiGeneration() {
        Object r8 = this.wifiGeneration_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wifiGeneration_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public ByteString getWifiGenerationBytes() {
        Object r8 = this.wifiGeneration_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wifiGeneration_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public int getWifiStandard() {
        return this.wifiStandard_;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasArpNeighbourCount() {
        if ((this.bitField0_ & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasBand() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasBand1() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasCcaScore() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasContentionAtimeBk() {
        if ((this.bitField1_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasContentionAtimeVi() {
        if ((this.bitField1_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasCurrentChannelAPCount() {
        if ((this.bitField0_ & 67108864) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelCcaBusyTime() {
        if ((this.bitField1_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelOnTime() {
        if ((this.bitField1_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelRxTime() {
        if ((this.bitField1_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaChannelTxTime() {
        if ((this.bitField1_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaRxBytes() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaRxFcsErr() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeltaTxBytes() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 1073741824) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasFreq() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasIfName() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasIsMloIface() {
        if ((this.bitField0_ & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasPerScore() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRssiScore() {
        if ((this.bitField0_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxBw() {
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxFcsErrLevel() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxMcs() {
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxMode() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxNss() {
        if ((this.bitField1_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxRealSpeed() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxTputPred() {
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasRxlinkSpeed() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasScenario() {
        if ((this.bitField0_ & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTotalRxBytes() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTotalTxBytes() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxBw() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayAvg() {
        if ((this.bitField1_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayP10() {
        if ((this.bitField1_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayP90() {
        if ((this.bitField1_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxDelayPkts() {
        if ((this.bitField1_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxMcs() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxMode() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxNss() {
        if ((this.bitField1_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxRealSpeed() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxTputPred() {
        if ((this.bitField1_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasTxlinkSpeed() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasWifiGeneration() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.MloLinkLayerQualityReportDataOrBuilder
    public boolean hasWifiStandard() {
        if ((this.bitField1_ & 2) == 0) goto L5;
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
        if (hasIfName() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getIfName().hashCode();
    L12:
        if (hasFreq() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getFreq();
    L15:
        if (hasTxlinkSpeed() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getTxlinkSpeed();
    L18:
        if (hasRxlinkSpeed() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getRxlinkSpeed();
    L21:
        if (hasBand() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getBand().hashCode();
    L24:
        if (hasBand1() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getBand1().hashCode();
    L27:
        if (hasWifiGeneration() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getWifiGeneration().hashCode();
    L30:
        if (hasDeltaRxFcsErr() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getDeltaRxFcsErr();
    L33:
        if (hasRxFcsErrLevel() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getRxFcsErrLevel();
    L36:
        if (hasTotalTxBytes() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getTotalTxBytes();
    L39:
        if (hasDeltaTxBytes() == false) goto L42;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getDeltaTxBytes();
    L42:
        if (hasTxRealSpeed() == false) goto L45;
        r10 = defpackage.b.a(r10, 37, 13, 53) + getTxRealSpeed();
    L45:
        if (hasTotalRxBytes() == false) goto L48;
        r10 = defpackage.b.a(r10, 37, 14, 53) + getTotalRxBytes();
    L48:
        if (hasDeltaRxBytes() == false) goto L51;
        r10 = defpackage.b.a(r10, 37, 15, 53) + getDeltaRxBytes();
    L51:
        if (hasRxRealSpeed() == false) goto L54;
        r10 = defpackage.b.a(r10, 37, 16, 53) + getRxRealSpeed();
    L54:
        if (hasTxMode() == false) goto L57;
        r10 = defpackage.b.a(r10, 37, 17, 53) + getTxMode();
    L57:
        if (hasTxMcs() == false) goto L60;
        r10 = defpackage.b.a(r10, 37, 18, 53) + getTxMcs();
    L60:
        if (hasTxBw() == false) goto L63;
        r10 = defpackage.b.a(r10, 37, 19, 53) + getTxBw();
    L63:
        if (hasRxMode() == false) goto L66;
        r10 = defpackage.b.a(r10, 37, 20, 53) + getRxMode();
    L66:
        if (hasRxMcs() == false) goto L69;
        r10 = defpackage.b.a(r10, 37, 21, 53) + getRxMcs();
    L69:
        if (hasRxBw() == false) goto L72;
        r10 = defpackage.b.a(r10, 37, 22, 53) + getRxBw();
    L72:
        if (hasCcaScore() == false) goto L75;
        r10 = defpackage.b.a(r10, 37, 23, 53) + getCcaScore();
    L75:
        if (hasPerScore() == false) goto L78;
        r10 = defpackage.b.a(r10, 37, 24, 53) + getPerScore();
    L78:
        if (hasRssiScore() == false) goto L81;
        r10 = defpackage.b.a(r10, 37, 25, 53) + getRssiScore();
    L81:
        if (hasScenario() == false) goto L84;
        r10 = defpackage.b.a(r10, 37, 26, 53) + getScenario();
    L84:
        if (hasCurrentChannelAPCount() == false) goto L87;
        r10 = defpackage.b.a(r10, 37, 27, 53) + getCurrentChannelAPCount();
    L87:
        if (hasArpNeighbourCount() == false) goto L90;
        r10 = defpackage.b.a(r10, 37, 28, 53) + getArpNeighbourCount();
    L90:
        if (hasIsMloIface() == false) goto L93;
        r10 = defpackage.b.a(r10, 37, 29, 53) + Internal.hashBoolean(getIsMloIface());
    L93:
        if (hasDeviceTime() == false) goto L96;
        r10 = defpackage.b.a(r10, 37, 30, 53) + Internal.hashLong(getDeviceTime());
    L96:
        if (hasDeviceDate() == false) goto L99;
        r10 = defpackage.b.a(r10, 37, 31, 53) + getDeviceDate().hashCode();
    L99:
        if (getLinkStatsCount() <= 0) goto L102;
        r10 = defpackage.b.a(r10, 37, 32, 53) + getLinkStatsList().hashCode();
    L102:
        if (hasRxTputPred() == false) goto L105;
        r10 = defpackage.b.a(r10, 37, 33, 53) + getRxTputPred();
    L105:
        if (hasTxTputPred() == false) goto L108;
        r10 = defpackage.b.a(r10, 37, 34, 53) + getTxTputPred();
    L108:
        if (hasWifiStandard() == false) goto L111;
        r10 = defpackage.b.a(r10, 37, 35, 53) + getWifiStandard();
    L111:
        if (hasTxNss() == false) goto L114;
        r10 = defpackage.b.a(r10, 37, 36, 53) + getTxNss();
    L114:
        if (hasRxNss() == false) goto L117;
        r10 = defpackage.b.a(r10, 37, 37, 53) + getRxNss();
    L117:
        if (hasDeltaChannelOnTime() == false) goto L120;
        r10 = defpackage.b.a(r10, 37, 38, 53) + getDeltaChannelOnTime();
    L120:
        if (hasDeltaChannelTxTime() == false) goto L123;
        r10 = defpackage.b.a(r10, 37, 39, 53) + getDeltaChannelTxTime();
    L123:
        if (hasDeltaChannelRxTime() == false) goto L126;
        r10 = defpackage.b.a(r10, 37, 40, 53) + getDeltaChannelRxTime();
    L126:
        if (hasDeltaChannelCcaBusyTime() == false) goto L129;
        r10 = defpackage.b.a(r10, 37, 41, 53) + getDeltaChannelCcaBusyTime();
    L129:
        if (hasContentionAtimeBk() == false) goto L132;
        r10 = defpackage.b.a(r10, 37, 42, 53) + getContentionAtimeBk();
    L132:
        if (hasContentionAtimeVi() == false) goto L135;
        r10 = defpackage.b.a(r10, 37, 43, 53) + getContentionAtimeVi();
    L135:
        if (hasTxDelayAvg() == false) goto L138;
        r10 = defpackage.b.a(r10, 37, 44, 53) + Float.floatToIntBits(getTxDelayAvg());
    L138:
        if (hasTxDelayP10() == false) goto L141;
        r10 = defpackage.b.a(r10, 37, 45, 53) + Float.floatToIntBits(getTxDelayP10());
    L141:
        if (hasTxDelayP90() == false) goto L144;
        r10 = defpackage.b.a(r10, 37, 46, 53) + Float.floatToIntBits(getTxDelayP90());
    L144:
        if (hasTxDelayPkts() == false) goto L147;
        r10 = defpackage.b.a(r10, 37, 47, 53) + Internal.hashLong(getTxDelayPkts());
    L147:
        if (getDelaySizeMatrixCount() <= 0) goto L149;
        r10 = defpackage.b.a(r10, 37, 48, 53) + getDelaySizeMatrixList().hashCode();
    L149:
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
        return new MloLinkLayerQualityReportData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r10, 1, this.eventType_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r10, 2, this.ifName_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r10.writeInt32(3, this.freq_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r10.writeInt32(4, this.txlinkSpeed_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r10.writeInt32(5, this.rxlinkSpeed_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        GeneratedMessage.writeString(r10, 6, this.band_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        GeneratedMessage.writeString(r10, 7, this.band1_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        GeneratedMessage.writeString(r10, 8, this.wifiGeneration_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r10.writeInt32(9, this.deltaRxFcsErr_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r10.writeInt32(10, this.rxFcsErrLevel_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r10.writeInt32(11, this.totalTxBytes_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r10.writeInt32(12, this.deltaTxBytes_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r10.writeInt32(13, this.txRealSpeed_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r10.writeInt32(14, this.totalRxBytes_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r10.writeInt32(15, this.deltaRxBytes_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r10.writeInt32(16, this.rxRealSpeed_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r10.writeInt32(17, this.txMode_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r10.writeInt32(18, this.txMcs_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        r10.writeInt32(19, this.txBw_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        r10.writeInt32(20, this.rxMode_);
    L63:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L66;
        r10.writeInt32(21, this.rxMcs_);
    L66:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L69;
        r10.writeInt32(22, this.rxBw_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r10.writeInt32(23, this.ccaScore_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L75;
        r10.writeInt32(24, this.perScore_);
    L75:
        if ((this.bitField0_ & 16777216) == 0) goto L78;
        r10.writeInt32(25, this.rssiScore_);
    L78:
        if ((this.bitField0_ & 33554432) == 0) goto L81;
        r10.writeInt32(26, this.scenario_);
    L81:
        if ((this.bitField0_ & 67108864) == 0) goto L84;
        r10.writeInt32(27, this.currentChannelAPCount_);
    L84:
        if ((this.bitField0_ & 134217728) == 0) goto L87;
        r10.writeInt32(28, this.arpNeighbourCount_);
    L87:
        if ((this.bitField0_ & 268435456) == 0) goto L90;
        r10.writeBool(29, this.isMloIface_);
    L90:
        if ((this.bitField0_ & 536870912) == 0) goto L93;
        r10.writeInt64(30, this.deviceTime_);
    L93:
        if ((this.bitField0_ & 1073741824) == 0) goto L95;
        GeneratedMessage.writeString(r10, 31, this.deviceDate_);
    L95:
        int r8 = 0;
        int r11 = 0;
    L97:
        if (r11 >= this.linkStats_.size()) goto L100;
        r10.writeMessage(32, this.linkStats_.get(r11));
        r11 = r11 + 1;
        goto L97
    L100:
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L103;
        r10.writeInt32(33, this.rxTputPred_);
    L103:
        if ((1 & this.bitField1_) == 0) goto L106;
        r10.writeInt32(34, this.txTputPred_);
    L106:
        if ((this.bitField1_ & 2) == 0) goto L109;
        r10.writeInt32(35, this.wifiStandard_);
    L109:
        if ((this.bitField1_ & 4) == 0) goto L112;
        r10.writeInt32(36, this.txNss_);
    L112:
        if ((this.bitField1_ & 8) == 0) goto L115;
        r10.writeInt32(37, this.rxNss_);
    L115:
        if ((this.bitField1_ & 16) == 0) goto L118;
        r10.writeInt32(38, this.deltaChannelOnTime_);
    L118:
        if ((this.bitField1_ & 32) == 0) goto L121;
        r10.writeInt32(39, this.deltaChannelTxTime_);
    L121:
        if ((this.bitField1_ & 64) == 0) goto L124;
        r10.writeInt32(40, this.deltaChannelRxTime_);
    L124:
        if ((this.bitField1_ & 128) == 0) goto L127;
        r10.writeInt32(41, this.deltaChannelCcaBusyTime_);
    L127:
        if ((this.bitField1_ & 256) == 0) goto L130;
        r10.writeInt32(42, this.contentionAtimeBk_);
    L130:
        if ((this.bitField1_ & 512) == 0) goto L133;
        r10.writeInt32(43, this.contentionAtimeVi_);
    L133:
        if ((this.bitField1_ & 1024) == 0) goto L136;
        r10.writeFloat(44, this.txDelayAvg_);
    L136:
        if ((this.bitField1_ & 2048) == 0) goto L139;
        r10.writeFloat(45, this.txDelayP10_);
    L139:
        if ((this.bitField1_ & 4096) == 0) goto L142;
        r10.writeFloat(46, this.txDelayP90_);
    L142:
        if ((this.bitField1_ & 8192) == 0) goto L145;
        r10.writeInt64(47, this.txDelayPkts_);
    L145:
        if (r8 >= this.delaySizeMatrix_.size()) goto L147;
        r10.writeInt32(48, this.delaySizeMatrix_.getInt(r8));
        r8 = r8 + 1;
        goto L145
    L147:
        getUnknownFields().writeTo(r10);
    }

    private MloLinkLayerQualityReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.ifName_ = "";
        this.freq_ = 0;
        this.txlinkSpeed_ = 0;
        this.rxlinkSpeed_ = 0;
        this.band_ = "";
        this.band1_ = "";
        this.wifiGeneration_ = "";
        this.deltaRxFcsErr_ = 0;
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
        this.ccaScore_ = 0;
        this.perScore_ = 0;
        this.rssiScore_ = 0;
        this.scenario_ = 0;
        this.currentChannelAPCount_ = 0;
        this.arpNeighbourCount_ = 0;
        this.isMloIface_ = false;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.rxTputPred_ = 0;
        this.txTputPred_ = 0;
        this.wifiStandard_ = 0;
        this.txNss_ = 0;
        this.rxNss_ = 0;
        this.deltaChannelOnTime_ = 0;
        this.deltaChannelTxTime_ = 0;
        this.deltaChannelRxTime_ = 0;
        this.deltaChannelCcaBusyTime_ = 0;
        this.contentionAtimeBk_ = 0;
        this.contentionAtimeVi_ = 0;
        this.txDelayAvg_ = 0.0f;
        this.txDelayP10_ = 0.0f;
        this.txDelayP90_ = 0.0f;
        this.txDelayPkts_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(MloLinkLayerQualityReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static MloLinkLayerQualityReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (MloLinkLayerQualityReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static MloLinkLayerQualityReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_MloLinkLayerQualityReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(MloLinkLayerQualityReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ MloLinkLayerQualityReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static MloLinkLayerQualityReportData parseFrom(CodedInputStream r8) {
        return (MloLinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public MloLinkLayerQualityReportData getDefaultInstanceForType() {
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

    public static MloLinkLayerQualityReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (MloLinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static MloLinkLayerQualityReportData parseFrom(InputStream r8) {
        return (MloLinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static MloLinkLayerQualityReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (MloLinkLayerQualityReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static MloLinkLayerQualityReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static MloLinkLayerQualityReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static MloLinkLayerQualityReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static MloLinkLayerQualityReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
