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

/* JADX INFO: loaded from: classes2.dex */
public final class LinkStats extends GeneratedMessageV3 implements LinkStatsOrBuilder {
    public static final int CCALEVEL_FIELD_NUMBER = 6;
    public static final int CENTER_FREQ_FIELD_NUMBER = 3;
    public static final int CONTENTION_ATIME_BE_FIELD_NUMBER = 13;
    public static final int CONTENTION_ATIME_BK_FIELD_NUMBER = 14;
    public static final int CONTENTION_ATIME_VI_FIELD_NUMBER = 15;
    public static final int CONTENTION_ATIME_VO_FIELD_NUMBER = 16;
    private static final LinkStats DEFAULT_INSTANCE = null;
    public static final int DELTACCABUSYTIME_FIELD_NUMBER = 4;
    public static final int DELTARADIOONTIME_FIELD_NUMBER = 5;
    public static final int DELTARXSUCCESS_FIELD_NUMBER = 12;
    public static final int DELTATXBAD_FIELD_NUMBER = 10;
    public static final int DELTATXRETRIES_FIELD_NUMBER = 8;
    public static final int DELTATXSUCCESS_FIELD_NUMBER = 7;
    public static final int LINK_ID_FIELD_NUMBER = 1;
    public static final int ON_TIME_SCAN_FIELD_NUMBER = 34;

    @Deprecated
    public static final Parser<LinkStats> PARSER = null;
    public static final int PER_FIELD_NUMBER = 33;
    public static final int POWER_PRED_MW_FIELD_NUMBER = 37;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int RL_CCA_BUSY_RATE_FIELD_NUMBER = 32;
    public static final int RL_RX_LINK_SPEED_FIELD_NUMBER = 31;
    public static final int RL_TX_LINK_SPEED_FIELD_NUMBER = 30;
    public static final int RSSI_ACK_FIELD_NUMBER = 29;
    public static final int RSSI_DATA_FIELD_NUMBER = 28;
    public static final int RSSI_MGMT_FIELD_NUMBER = 27;
    public static final int RX_SPEED_KBPS_FIELD_NUMBER = 36;
    public static final int TXBADLEVEL_FIELD_NUMBER = 11;
    public static final int TXMPDUBE_FIELD_NUMBER = 17;
    public static final int TXMPDUVI_FIELD_NUMBER = 20;
    public static final int TXMPDUVO_FIELD_NUMBER = 23;
    public static final int TXRETRANLEVELBE_FIELD_NUMBER = 19;
    public static final int TXRETRANLEVELVI_FIELD_NUMBER = 22;
    public static final int TXRETRANLEVELVO_FIELD_NUMBER = 25;
    public static final int TXRETRAYLEVEL_FIELD_NUMBER = 9;
    public static final int TXRETRIESBE_FIELD_NUMBER = 18;
    public static final int TXRETRIESVI_FIELD_NUMBER = 21;
    public static final int TXRETRIESVO_FIELD_NUMBER = 24;
    public static final int TX_SPEED_KBPS_FIELD_NUMBER = 35;
    public static final int WIDTH_FIELD_NUMBER = 26;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int bitField1_;
    private int ccaLevel_;
    private int centerFreq_;
    private int contentionAtimeBe_;
    private int contentionAtimeBk_;
    private int contentionAtimeVi_;
    private int contentionAtimeVo_;
    private int deltaCcaBusyTime_;
    private int deltaRadioOnTime_;
    private int deltaRxSuccess_;
    private long deltaTxBad_;
    private long deltaTxRetries_;
    private long deltaTxSuccess_;
    private int linkId_;
    private byte memoizedIsInitialized;
    private int onTimeScan_;
    private int per_;
    private float powerPredMw_;
    private int radioId_;
    private int rlCcaBusyRate_;
    private int rlRxLinkSpeed_;
    private int rlTxLinkSpeed_;
    private int rssiAck_;
    private int rssiData_;
    private int rssiMgmt_;
    private int rxSpeedKbps_;
    private int txBadLevel_;
    private long txMpduBe_;
    private long txMpduVi_;
    private long txMpduVo_;
    private int txRetranLevelBe_;
    private int txRetranLevelVi_;
    private int txRetranLevelVo_;
    private int txRetrayLevel_;
    private long txRetriesBe_;
    private long txRetriesVi_;
    private long txRetriesVo_;
    private int txSpeedKbps_;
    private int width_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkStatsOrBuilder {
        private int bitField0_;
        private int bitField1_;
        private int ccaLevel_;
        private int centerFreq_;
        private int contentionAtimeBe_;
        private int contentionAtimeBk_;
        private int contentionAtimeVi_;
        private int contentionAtimeVo_;
        private int deltaCcaBusyTime_;
        private int deltaRadioOnTime_;
        private int deltaRxSuccess_;
        private long deltaTxBad_;
        private long deltaTxRetries_;
        private long deltaTxSuccess_;
        private int linkId_;
        private int onTimeScan_;
        private int per_;
        private float powerPredMw_;
        private int radioId_;
        private int rlCcaBusyRate_;
        private int rlRxLinkSpeed_;
        private int rlTxLinkSpeed_;
        private int rssiAck_;
        private int rssiData_;
        private int rssiMgmt_;
        private int rxSpeedKbps_;
        private int txBadLevel_;
        private long txMpduBe_;
        private long txMpduVi_;
        private long txMpduVo_;
        private int txRetranLevelBe_;
        private int txRetranLevelVi_;
        private int txRetranLevelVo_;
        private int txRetrayLevel_;
        private long txRetriesBe_;
        private long txRetriesVi_;
        private long txRetriesVo_;
        private int txSpeedKbps_;
        private int width_;

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
        }

        private void buildPartial0(LinkStats r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            LinkStats.access$302(r8, this.linkId_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            LinkStats.access$402(r8, this.radioId_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            LinkStats.access$502(r8, this.centerFreq_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            LinkStats.access$602(r8, this.deltaCcaBusyTime_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            LinkStats.access$702(r8, this.deltaRadioOnTime_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            LinkStats.access$802(r8, this.ccaLevel_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            LinkStats.access$902(r8, this.deltaTxSuccess_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            LinkStats.access$1002(r8, this.deltaTxRetries_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            LinkStats.access$1102(r8, this.txRetrayLevel_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            LinkStats.access$1202(r8, this.deltaTxBad_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            LinkStats.access$1302(r8, this.txBadLevel_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            LinkStats.access$1402(r8, this.deltaRxSuccess_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            LinkStats.access$1502(r8, this.contentionAtimeBe_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            LinkStats.access$1602(r8, this.contentionAtimeBk_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            LinkStats.access$1702(r8, this.contentionAtimeVi_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            LinkStats.access$1802(r8, this.contentionAtimeVo_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            LinkStats.access$1902(r8, this.txMpduBe_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            LinkStats.access$2002(r8, this.txRetriesBe_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            LinkStats.access$2102(r8, this.txRetranLevelBe_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            LinkStats.access$2202(r8, this.txMpduVi_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            LinkStats.access$2302(r8, this.txRetriesVi_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            LinkStats.access$2402(r8, this.txRetranLevelVi_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            LinkStats.access$2502(r8, this.txMpduVo_);
            r11 = r11 | 4194304;
        L73:
            if ((8388608 & r10) == 0) goto L76;
            LinkStats.access$2602(r8, this.txRetriesVo_);
            r11 = r11 | 8388608;
        L76:
            if ((16777216 & r10) == 0) goto L79;
            LinkStats.access$2702(r8, this.txRetranLevelVo_);
            r11 = r11 | 16777216;
        L79:
            if ((33554432 & r10) == 0) goto L82;
            LinkStats.access$2802(r8, this.width_);
            r11 = r11 | 33554432;
        L82:
            if ((67108864 & r10) == 0) goto L85;
            LinkStats.access$2902(r8, this.rssiMgmt_);
            r11 = r11 | 67108864;
        L85:
            if ((134217728 & r10) == 0) goto L88;
            LinkStats.access$3002(r8, this.rssiData_);
            r11 = r11 | 134217728;
        L88:
            if ((268435456 & r10) == 0) goto L91;
            LinkStats.access$3102(r8, this.rssiAck_);
            r11 = r11 | 268435456;
        L91:
            if ((536870912 & r10) == 0) goto L94;
            LinkStats.access$3202(r8, this.rlTxLinkSpeed_);
            r11 = r11 | 536870912;
        L94:
            if ((1073741824 & r10) == 0) goto L97;
            LinkStats.access$3302(r8, this.rlRxLinkSpeed_);
            r11 = r11 | 1073741824;
        L97:
            if ((r10 & Integer.MIN_VALUE) == 0) goto L99;
            LinkStats.access$3402(r8, this.rlCcaBusyRate_);
            r11 = r11 | Integer.MIN_VALUE;
        L99:
            LinkStats.access$3576(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartial1(LinkStats r8) {
            int r10 = this.bitField1_;
            if ((r10 & 1) == 0) goto L5;
            LinkStats.access$3602(r8, this.per_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            LinkStats.access$3702(r8, this.onTimeScan_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            LinkStats.access$3802(r8, this.txSpeedKbps_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            LinkStats.access$3902(r8, this.rxSpeedKbps_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L18;
            LinkStats.access$4002(r8, this.powerPredMw_);
            r11 = r11 | 16;
        L18:
            LinkStats.access$4176(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkStats_descriptor;
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

        public Builder clearCcaLevel() {
            this.bitField0_ &= -33;
            this.ccaLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCenterFreq() {
            this.bitField0_ &= -5;
            this.centerFreq_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeBe() {
            this.bitField0_ &= -4097;
            this.contentionAtimeBe_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeBk() {
            this.bitField0_ &= -8193;
            this.contentionAtimeBk_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeVi() {
            this.bitField0_ &= -16385;
            this.contentionAtimeVi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearContentionAtimeVo() {
            this.bitField0_ &= -32769;
            this.contentionAtimeVo_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaCcaBusyTime() {
            this.bitField0_ &= -9;
            this.deltaCcaBusyTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaRadioOnTime() {
            this.bitField0_ &= -17;
            this.deltaRadioOnTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaRxSuccess() {
            this.bitField0_ &= -2049;
            this.deltaRxSuccess_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaTxBad() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.deltaTxBad_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaTxRetries() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.deltaTxRetries_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeltaTxSuccess() {
            this.bitField0_ &= -65;
            this.deltaTxSuccess_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearLinkId() {
            this.bitField0_ &= -2;
            this.linkId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOnTimeScan() {
            this.bitField1_ &= -3;
            this.onTimeScan_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPer() {
            this.bitField1_ &= -2;
            this.per_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPowerPredMw() {
            this.bitField1_ &= -17;
            this.powerPredMw_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearRadioId() {
            this.bitField0_ &= -3;
            this.radioId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRlCcaBusyRate() {
            this.bitField0_ &= Integer.MAX_VALUE;
            this.rlCcaBusyRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRlRxLinkSpeed() {
            this.bitField0_ &= -1073741825;
            this.rlRxLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRlTxLinkSpeed() {
            this.bitField0_ &= -536870913;
            this.rlTxLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiAck() {
            this.bitField0_ &= -268435457;
            this.rssiAck_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiData() {
            this.bitField0_ &= -134217729;
            this.rssiData_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssiMgmt() {
            this.bitField0_ &= -67108865;
            this.rssiMgmt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxSpeedKbps() {
            this.bitField1_ &= -9;
            this.rxSpeedKbps_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxBadLevel() {
            this.bitField0_ &= -1025;
            this.txBadLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMpduBe() {
            this.bitField0_ &= -65537;
            this.txMpduBe_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMpduVi() {
            this.bitField0_ &= -524289;
            this.txMpduVi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMpduVo() {
            this.bitField0_ &= -4194305;
            this.txMpduVo_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetranLevelBe() {
            this.bitField0_ &= -262145;
            this.txRetranLevelBe_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetranLevelVi() {
            this.bitField0_ &= -2097153;
            this.txRetranLevelVi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetranLevelVo() {
            this.bitField0_ &= -16777217;
            this.txRetranLevelVo_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetrayLevel() {
            this.bitField0_ &= -257;
            this.txRetrayLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetriesBe() {
            this.bitField0_ &= -131073;
            this.txRetriesBe_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetriesVi() {
            this.bitField0_ &= -1048577;
            this.txRetriesVi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetriesVo() {
            this.bitField0_ &= -8388609;
            this.txRetriesVo_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxSpeedKbps() {
            this.bitField1_ &= -5;
            this.txSpeedKbps_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWidth() {
            this.bitField0_ &= -33554433;
            this.width_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getCcaLevel() {
            return this.ccaLevel_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getCenterFreq() {
            return this.centerFreq_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getContentionAtimeBe() {
            return this.contentionAtimeBe_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getContentionAtimeBk() {
            return this.contentionAtimeBk_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getContentionAtimeVi() {
            return this.contentionAtimeVi_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getContentionAtimeVo() {
            return this.contentionAtimeVo_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getDeltaCcaBusyTime() {
            return this.deltaCcaBusyTime_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getDeltaRadioOnTime() {
            return this.deltaRadioOnTime_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getDeltaRxSuccess() {
            return this.deltaRxSuccess_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getDeltaTxBad() {
            return this.deltaTxBad_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getDeltaTxRetries() {
            return this.deltaTxRetries_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getDeltaTxSuccess() {
            return this.deltaTxSuccess_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkStats_descriptor;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getLinkId() {
            return this.linkId_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getOnTimeScan() {
            return this.onTimeScan_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getPer() {
            return this.per_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public float getPowerPredMw() {
            return this.powerPredMw_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRadioId() {
            return this.radioId_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRlCcaBusyRate() {
            return this.rlCcaBusyRate_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRlRxLinkSpeed() {
            return this.rlRxLinkSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRlTxLinkSpeed() {
            return this.rlTxLinkSpeed_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRssiAck() {
            return this.rssiAck_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRssiData() {
            return this.rssiData_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRssiMgmt() {
            return this.rssiMgmt_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getRxSpeedKbps() {
            return this.rxSpeedKbps_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getTxBadLevel() {
            return this.txBadLevel_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getTxMpduBe() {
            return this.txMpduBe_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getTxMpduVi() {
            return this.txMpduVi_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getTxMpduVo() {
            return this.txMpduVo_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getTxRetranLevelBe() {
            return this.txRetranLevelBe_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getTxRetranLevelVi() {
            return this.txRetranLevelVi_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getTxRetranLevelVo() {
            return this.txRetranLevelVo_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getTxRetrayLevel() {
            return this.txRetrayLevel_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getTxRetriesBe() {
            return this.txRetriesBe_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getTxRetriesVi() {
            return this.txRetriesVi_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public long getTxRetriesVo() {
            return this.txRetriesVo_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getTxSpeedKbps() {
            return this.txSpeedKbps_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasCcaLevel() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasCenterFreq() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasContentionAtimeBe() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasContentionAtimeBk() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasContentionAtimeVi() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasContentionAtimeVo() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasDeltaCcaBusyTime() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasDeltaRadioOnTime() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasDeltaRxSuccess() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasDeltaTxBad() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasDeltaTxRetries() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasDeltaTxSuccess() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasLinkId() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasOnTimeScan() {
            if ((this.bitField1_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasPer() {
            if ((this.bitField1_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasPowerPredMw() {
            if ((this.bitField1_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRadioId() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRlCcaBusyRate() {
            if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRlRxLinkSpeed() {
            if ((this.bitField0_ & 1073741824) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRlTxLinkSpeed() {
            if ((this.bitField0_ & 536870912) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRssiAck() {
            if ((this.bitField0_ & 268435456) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRssiData() {
            if ((this.bitField0_ & 134217728) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRssiMgmt() {
            if ((this.bitField0_ & 67108864) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasRxSpeedKbps() {
            if ((this.bitField1_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxBadLevel() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxMpduBe() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxMpduVi() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxMpduVo() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxRetranLevelBe() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxRetranLevelVi() {
            if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxRetranLevelVo() {
            if ((this.bitField0_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxRetrayLevel() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxRetriesBe() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxRetriesVi() {
            if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxRetriesVo() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasTxSpeedKbps() {
            if ((this.bitField1_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.LinkStatsOrBuilder
        public boolean hasWidth() {
            if ((this.bitField0_ & 33554432) == 0) goto L5;
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

        public Builder setCcaLevel(int r8) {
            this.ccaLevel_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setCenterFreq(int r8) {
            this.centerFreq_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeBe(int r8) {
            this.contentionAtimeBe_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeBk(int r8) {
            this.contentionAtimeBk_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeVi(int r8) {
            this.contentionAtimeVi_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setContentionAtimeVo(int r8) {
            this.contentionAtimeVo_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setDeltaCcaBusyTime(int r8) {
            this.deltaCcaBusyTime_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setDeltaRadioOnTime(int r8) {
            this.deltaRadioOnTime_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setDeltaRxSuccess(int r8) {
            this.deltaRxSuccess_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setDeltaTxBad(long r8) {
            this.deltaTxBad_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setDeltaTxRetries(long r8) {
            this.deltaTxRetries_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setDeltaTxSuccess(long r8) {
            this.deltaTxSuccess_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setLinkId(int r8) {
            this.linkId_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setOnTimeScan(int r8) {
            this.onTimeScan_ = r8;
            this.bitField1_ |= 2;
            onChanged();
            return this;
        }

        public Builder setPer(int r8) {
            this.per_ = r8;
            this.bitField1_ |= 1;
            onChanged();
            return this;
        }

        public Builder setPowerPredMw(float r8) {
            this.powerPredMw_ = r8;
            this.bitField1_ |= 16;
            onChanged();
            return this;
        }

        public Builder setRadioId(int r8) {
            this.radioId_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRlCcaBusyRate(int r8) {
            this.rlCcaBusyRate_ = r8;
            this.bitField0_ |= Integer.MIN_VALUE;
            onChanged();
            return this;
        }

        public Builder setRlRxLinkSpeed(int r8) {
            this.rlRxLinkSpeed_ = r8;
            this.bitField0_ |= 1073741824;
            onChanged();
            return this;
        }

        public Builder setRlTxLinkSpeed(int r8) {
            this.rlTxLinkSpeed_ = r8;
            this.bitField0_ |= 536870912;
            onChanged();
            return this;
        }

        public Builder setRssiAck(int r8) {
            this.rssiAck_ = r8;
            this.bitField0_ |= 268435456;
            onChanged();
            return this;
        }

        public Builder setRssiData(int r8) {
            this.rssiData_ = r8;
            this.bitField0_ |= 134217728;
            onChanged();
            return this;
        }

        public Builder setRssiMgmt(int r8) {
            this.rssiMgmt_ = r8;
            this.bitField0_ |= 67108864;
            onChanged();
            return this;
        }

        public Builder setRxSpeedKbps(int r8) {
            this.rxSpeedKbps_ = r8;
            this.bitField1_ |= 8;
            onChanged();
            return this;
        }

        public Builder setTxBadLevel(int r8) {
            this.txBadLevel_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setTxMpduBe(long r8) {
            this.txMpduBe_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setTxMpduVi(long r8) {
            this.txMpduVi_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setTxMpduVo(long r8) {
            this.txMpduVo_ = r8;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setTxRetranLevelBe(int r8) {
            this.txRetranLevelBe_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setTxRetranLevelVi(int r8) {
            this.txRetranLevelVi_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        }

        public Builder setTxRetranLevelVo(int r8) {
            this.txRetranLevelVo_ = r8;
            this.bitField0_ |= 16777216;
            onChanged();
            return this;
        }

        public Builder setTxRetrayLevel(int r8) {
            this.txRetrayLevel_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setTxRetriesBe(long r8) {
            this.txRetriesBe_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setTxRetriesVi(long r8) {
            this.txRetriesVi_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        }

        public Builder setTxRetriesVo(long r8) {
            this.txRetriesVo_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        }

        public Builder setTxSpeedKbps(int r8) {
            this.txSpeedKbps_ = r8;
            this.bitField1_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWidth(int r8) {
            this.width_ = r8;
            this.bitField0_ |= 33554432;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkStats_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkStats.class, Builder.class);
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

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LinkStats build() {
            LinkStats r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LinkStats buildPartial() {
            LinkStats r8 = new LinkStats(this, null);
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
        public LinkStats getDefaultInstanceForType() {
            return LinkStats.getDefaultInstance();
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
            this.linkId_ = 0;
            this.radioId_ = 0;
            this.centerFreq_ = 0;
            this.deltaCcaBusyTime_ = 0;
            this.deltaRadioOnTime_ = 0;
            this.ccaLevel_ = 0;
            this.deltaTxSuccess_ = 0;
            this.deltaTxRetries_ = 0;
            this.txRetrayLevel_ = 0;
            this.deltaTxBad_ = 0;
            this.txBadLevel_ = 0;
            this.deltaRxSuccess_ = 0;
            this.contentionAtimeBe_ = 0;
            this.contentionAtimeBk_ = 0;
            this.contentionAtimeVi_ = 0;
            this.contentionAtimeVo_ = 0;
            this.txMpduBe_ = 0;
            this.txRetriesBe_ = 0;
            this.txRetranLevelBe_ = 0;
            this.txMpduVi_ = 0;
            this.txRetriesVi_ = 0;
            this.txRetranLevelVi_ = 0;
            this.txMpduVo_ = 0;
            this.txRetriesVo_ = 0;
            this.txRetranLevelVo_ = 0;
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
            this.powerPredMw_ = 0.0f;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L59;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L56;
            int r12 = r8.readTag();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            switch(r12) {
                case 0: goto L46;
                case 8: goto L44;
                case 16: goto L43;
                case 24: goto L42;
                case 32: goto L41;
                case 40: goto L40;
                case 48: goto L39;
                case 56: goto L38;
                case 64: goto L37;
                case 72: goto L36;
                case 80: goto L35;
                case 88: goto L34;
                case 96: goto L33;
                case 104: goto L32;
                case 112: goto L31;
                case 120: goto L30;
                case 128: goto L29;
                case 136: goto L28;
                case 144: goto L27;
                case 152: goto L26;
                case 160: goto L25;
                case 168: goto L24;
                case 176: goto L23;
                case 184: goto L22;
                case 192: goto L21;
                case 200: goto L20;
                case 208: goto L19;
                case 216: goto L18;
                case 224: goto L17;
                case 232: goto L16;
                case 240: goto L15;
                case 248: goto L14;
                case 256: goto L13;
                case 264: goto L12;
                case 272: goto L11;
                case 280: goto L10;
                case 288: goto L9;
                case 301: goto L8;
                default: goto L47;
            };     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
        L8:
            this.powerPredMw_ = r8.readFloat();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField1_ |= 16;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L9:
            this.rxSpeedKbps_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField1_ |= 8;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L10:
            this.txSpeedKbps_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField1_ |= 4;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L11:
            this.onTimeScan_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField1_ |= 2;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L12:
            this.per_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField1_ |= 1;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L13:
            this.rlCcaBusyRate_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= Integer.MIN_VALUE;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L14:
            this.rlRxLinkSpeed_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 1073741824;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L15:
            this.rlTxLinkSpeed_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 536870912;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L16:
            this.rssiAck_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 268435456;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L17:
            this.rssiData_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 134217728;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L18:
            this.rssiMgmt_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 67108864;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L19:
            this.width_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 33554432;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L20:
            this.txRetranLevelVo_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 16777216;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L21:
            this.txRetriesVo_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 8388608;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L22:
            this.txMpduVo_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 4194304;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L23:
            this.txRetranLevelVi_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L24:
            this.txRetriesVi_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L25:
            this.txMpduVi_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 524288;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L26:
            this.txRetranLevelBe_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 262144;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L27:
            this.txRetriesBe_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 131072;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L28:
            this.txMpduBe_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 65536;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L29:
            this.contentionAtimeVo_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 32768;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L30:
            this.contentionAtimeVi_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 16384;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L31:
            this.contentionAtimeBk_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 8192;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L32:
            this.contentionAtimeBe_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 4096;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L33:
            this.deltaRxSuccess_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 2048;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L34:
            this.txBadLevel_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 1024;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L35:
            this.deltaTxBad_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 512;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L36:
            this.txRetrayLevel_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 256;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L37:
            this.deltaTxRetries_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 128;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L38:
            this.deltaTxSuccess_ = r8.readInt64();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 64;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L39:
            this.ccaLevel_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 32;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L40:
            this.deltaRadioOnTime_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 16;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L41:
            this.deltaCcaBusyTime_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 8;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L42:
            this.centerFreq_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 4;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L43:
            this.radioId_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 2;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L44:
            this.linkId_ = r8.readInt32();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            this.bitField0_ |= 1;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
        L46:
            r11 = true;
            goto L4
        L47:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L49:
            th = move-exception;
            onChanged();
            throw th;
        L51:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L49
        L56:
            onChanged();
            return this;
        L59:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof LinkStats) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((LinkStats) r8);
        }

        public Builder mergeFrom(LinkStats r8) {
            if (r8 != LinkStats.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasLinkId() == false) goto L9;
            setLinkId(r8.getLinkId());
        L9:
            if (r8.hasRadioId() == false) goto L12;
            setRadioId(r8.getRadioId());
        L12:
            if (r8.hasCenterFreq() == false) goto L15;
            setCenterFreq(r8.getCenterFreq());
        L15:
            if (r8.hasDeltaCcaBusyTime() == false) goto L18;
            setDeltaCcaBusyTime(r8.getDeltaCcaBusyTime());
        L18:
            if (r8.hasDeltaRadioOnTime() == false) goto L21;
            setDeltaRadioOnTime(r8.getDeltaRadioOnTime());
        L21:
            if (r8.hasCcaLevel() == false) goto L24;
            setCcaLevel(r8.getCcaLevel());
        L24:
            if (r8.hasDeltaTxSuccess() == false) goto L27;
            setDeltaTxSuccess(r8.getDeltaTxSuccess());
        L27:
            if (r8.hasDeltaTxRetries() == false) goto L30;
            setDeltaTxRetries(r8.getDeltaTxRetries());
        L30:
            if (r8.hasTxRetrayLevel() == false) goto L33;
            setTxRetrayLevel(r8.getTxRetrayLevel());
        L33:
            if (r8.hasDeltaTxBad() == false) goto L36;
            setDeltaTxBad(r8.getDeltaTxBad());
        L36:
            if (r8.hasTxBadLevel() == false) goto L39;
            setTxBadLevel(r8.getTxBadLevel());
        L39:
            if (r8.hasDeltaRxSuccess() == false) goto L42;
            setDeltaRxSuccess(r8.getDeltaRxSuccess());
        L42:
            if (r8.hasContentionAtimeBe() == false) goto L45;
            setContentionAtimeBe(r8.getContentionAtimeBe());
        L45:
            if (r8.hasContentionAtimeBk() == false) goto L48;
            setContentionAtimeBk(r8.getContentionAtimeBk());
        L48:
            if (r8.hasContentionAtimeVi() == false) goto L51;
            setContentionAtimeVi(r8.getContentionAtimeVi());
        L51:
            if (r8.hasContentionAtimeVo() == false) goto L54;
            setContentionAtimeVo(r8.getContentionAtimeVo());
        L54:
            if (r8.hasTxMpduBe() == false) goto L57;
            setTxMpduBe(r8.getTxMpduBe());
        L57:
            if (r8.hasTxRetriesBe() == false) goto L60;
            setTxRetriesBe(r8.getTxRetriesBe());
        L60:
            if (r8.hasTxRetranLevelBe() == false) goto L63;
            setTxRetranLevelBe(r8.getTxRetranLevelBe());
        L63:
            if (r8.hasTxMpduVi() == false) goto L66;
            setTxMpduVi(r8.getTxMpduVi());
        L66:
            if (r8.hasTxRetriesVi() == false) goto L69;
            setTxRetriesVi(r8.getTxRetriesVi());
        L69:
            if (r8.hasTxRetranLevelVi() == false) goto L72;
            setTxRetranLevelVi(r8.getTxRetranLevelVi());
        L72:
            if (r8.hasTxMpduVo() == false) goto L75;
            setTxMpduVo(r8.getTxMpduVo());
        L75:
            if (r8.hasTxRetriesVo() == false) goto L78;
            setTxRetriesVo(r8.getTxRetriesVo());
        L78:
            if (r8.hasTxRetranLevelVo() == false) goto L81;
            setTxRetranLevelVo(r8.getTxRetranLevelVo());
        L81:
            if (r8.hasWidth() == false) goto L84;
            setWidth(r8.getWidth());
        L84:
            if (r8.hasRssiMgmt() == false) goto L87;
            setRssiMgmt(r8.getRssiMgmt());
        L87:
            if (r8.hasRssiData() == false) goto L90;
            setRssiData(r8.getRssiData());
        L90:
            if (r8.hasRssiAck() == false) goto L93;
            setRssiAck(r8.getRssiAck());
        L93:
            if (r8.hasRlTxLinkSpeed() == false) goto L96;
            setRlTxLinkSpeed(r8.getRlTxLinkSpeed());
        L96:
            if (r8.hasRlRxLinkSpeed() == false) goto L99;
            setRlRxLinkSpeed(r8.getRlRxLinkSpeed());
        L99:
            if (r8.hasRlCcaBusyRate() == false) goto L102;
            setRlCcaBusyRate(r8.getRlCcaBusyRate());
        L102:
            if (r8.hasPer() == false) goto L105;
            setPer(r8.getPer());
        L105:
            if (r8.hasOnTimeScan() == false) goto L108;
            setOnTimeScan(r8.getOnTimeScan());
        L108:
            if (r8.hasTxSpeedKbps() == false) goto L111;
            setTxSpeedKbps(r8.getTxSpeedKbps());
        L111:
            if (r8.hasRxSpeedKbps() == false) goto L114;
            setRxSpeedKbps(r8.getRxSpeedKbps());
        L114:
            if (r8.hasPowerPredMw() == false) goto L116;
            setPowerPredMw(r8.getPowerPredMw());
        L116:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new LinkStats();
        PARSER = new AnonymousClass1();
    }

    private LinkStats() {
        this.linkId_ = 0;
        this.radioId_ = 0;
        this.centerFreq_ = 0;
        this.deltaCcaBusyTime_ = 0;
        this.deltaRadioOnTime_ = 0;
        this.ccaLevel_ = 0;
        this.deltaTxSuccess_ = 0;
        this.deltaTxRetries_ = 0;
        this.txRetrayLevel_ = 0;
        this.deltaTxBad_ = 0;
        this.txBadLevel_ = 0;
        this.deltaRxSuccess_ = 0;
        this.contentionAtimeBe_ = 0;
        this.contentionAtimeBk_ = 0;
        this.contentionAtimeVi_ = 0;
        this.contentionAtimeVo_ = 0;
        this.txMpduBe_ = 0;
        this.txRetriesBe_ = 0;
        this.txRetranLevelBe_ = 0;
        this.txMpduVi_ = 0;
        this.txRetriesVi_ = 0;
        this.txRetranLevelVi_ = 0;
        this.txMpduVo_ = 0;
        this.txRetriesVo_ = 0;
        this.txRetranLevelVo_ = 0;
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
        this.powerPredMw_ = 0.0f;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ long access$1002(LinkStats r8, long r10) {
        r8.deltaTxRetries_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(LinkStats r8, int r10) {
        r8.txRetrayLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1202(LinkStats r8, long r10) {
        r8.deltaTxBad_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(LinkStats r8, int r10) {
        r8.txBadLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(LinkStats r8, int r10) {
        r8.deltaRxSuccess_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(LinkStats r8, int r10) {
        r8.contentionAtimeBe_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(LinkStats r8, int r10) {
        r8.contentionAtimeBk_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1702(LinkStats r8, int r10) {
        r8.contentionAtimeVi_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(LinkStats r8, int r10) {
        r8.contentionAtimeVo_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1902(LinkStats r8, long r10) {
        r8.txMpduBe_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$2002(LinkStats r8, long r10) {
        r8.txRetriesBe_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2102(LinkStats r8, int r10) {
        r8.txRetranLevelBe_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$2202(LinkStats r8, long r10) {
        r8.txMpduVi_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$2302(LinkStats r8, long r10) {
        r8.txRetriesVi_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2402(LinkStats r8, int r10) {
        r8.txRetranLevelVi_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$2502(LinkStats r8, long r10) {
        r8.txMpduVo_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$2602(LinkStats r8, long r10) {
        r8.txRetriesVo_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2702(LinkStats r8, int r10) {
        r8.txRetranLevelVo_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2802(LinkStats r8, int r10) {
        r8.width_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2902(LinkStats r8, int r10) {
        r8.rssiMgmt_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3002(LinkStats r8, int r10) {
        r8.rssiData_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$302(LinkStats r8, int r10) {
        r8.linkId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3102(LinkStats r8, int r10) {
        r8.rssiAck_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3202(LinkStats r8, int r10) {
        r8.rlTxLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3302(LinkStats r8, int r10) {
        r8.rlRxLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3402(LinkStats r8, int r10) {
        r8.rlCcaBusyRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3576(LinkStats r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$3602(LinkStats r8, int r10) {
        r8.per_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3702(LinkStats r8, int r10) {
        r8.onTimeScan_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3802(LinkStats r8, int r10) {
        r8.txSpeedKbps_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3902(LinkStats r8, int r10) {
        r8.rxSpeedKbps_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$4002(LinkStats r8, float r10) {
        r8.powerPredMw_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(LinkStats r8, int r10) {
        r8.radioId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4176(LinkStats r8, int r10) {
        int r11 = r10 | r8.bitField1_;
        r8.bitField1_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$502(LinkStats r8, int r10) {
        r8.centerFreq_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(LinkStats r8, int r10) {
        r8.deltaCcaBusyTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(LinkStats r8, int r10) {
        r8.deltaRadioOnTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(LinkStats r8, int r10) {
        r8.ccaLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$902(LinkStats r8, long r10) {
        r8.deltaTxSuccess_ = r10;
        return r10;
    }

    public static LinkStats getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkStats_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static LinkStats parseDelimitedFrom(InputStream r8) {
        return (LinkStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static LinkStats parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<LinkStats> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof LinkStats) == false) goto L8;
        LinkStats r10 = (LinkStats) r8;
        if (hasLinkId() == r10.hasLinkId()) goto L13;
        return false;
    L13:
        if (hasLinkId() == false) goto L18;
        if (getLinkId() == r10.getLinkId()) goto L18;
        return false;
    L18:
        if (hasRadioId() == r10.hasRadioId()) goto L21;
        return false;
    L21:
        if (hasRadioId() == false) goto L26;
        if (getRadioId() == r10.getRadioId()) goto L26;
        return false;
    L26:
        if (hasCenterFreq() == r10.hasCenterFreq()) goto L29;
        return false;
    L29:
        if (hasCenterFreq() == false) goto L34;
        if (getCenterFreq() == r10.getCenterFreq()) goto L34;
        return false;
    L34:
        if (hasDeltaCcaBusyTime() == r10.hasDeltaCcaBusyTime()) goto L37;
        return false;
    L37:
        if (hasDeltaCcaBusyTime() == false) goto L42;
        if (getDeltaCcaBusyTime() == r10.getDeltaCcaBusyTime()) goto L42;
        return false;
    L42:
        if (hasDeltaRadioOnTime() == r10.hasDeltaRadioOnTime()) goto L45;
        return false;
    L45:
        if (hasDeltaRadioOnTime() == false) goto L50;
        if (getDeltaRadioOnTime() == r10.getDeltaRadioOnTime()) goto L50;
        return false;
    L50:
        if (hasCcaLevel() == r10.hasCcaLevel()) goto L53;
        return false;
    L53:
        if (hasCcaLevel() == false) goto L58;
        if (getCcaLevel() == r10.getCcaLevel()) goto L58;
        return false;
    L58:
        if (hasDeltaTxSuccess() == r10.hasDeltaTxSuccess()) goto L61;
        return false;
    L61:
        if (hasDeltaTxSuccess() == false) goto L66;
        if (getDeltaTxSuccess() == r10.getDeltaTxSuccess()) goto L66;
        return false;
    L66:
        if (hasDeltaTxRetries() == r10.hasDeltaTxRetries()) goto L69;
        return false;
    L69:
        if (hasDeltaTxRetries() == false) goto L74;
        if (getDeltaTxRetries() == r10.getDeltaTxRetries()) goto L74;
        return false;
    L74:
        if (hasTxRetrayLevel() == r10.hasTxRetrayLevel()) goto L77;
        return false;
    L77:
        if (hasTxRetrayLevel() == false) goto L82;
        if (getTxRetrayLevel() == r10.getTxRetrayLevel()) goto L82;
        return false;
    L82:
        if (hasDeltaTxBad() == r10.hasDeltaTxBad()) goto L85;
        return false;
    L85:
        if (hasDeltaTxBad() == false) goto L90;
        if (getDeltaTxBad() == r10.getDeltaTxBad()) goto L90;
        return false;
    L90:
        if (hasTxBadLevel() == r10.hasTxBadLevel()) goto L93;
        return false;
    L93:
        if (hasTxBadLevel() == false) goto L98;
        if (getTxBadLevel() == r10.getTxBadLevel()) goto L98;
        return false;
    L98:
        if (hasDeltaRxSuccess() == r10.hasDeltaRxSuccess()) goto L101;
        return false;
    L101:
        if (hasDeltaRxSuccess() == false) goto L106;
        if (getDeltaRxSuccess() == r10.getDeltaRxSuccess()) goto L106;
        return false;
    L106:
        if (hasContentionAtimeBe() == r10.hasContentionAtimeBe()) goto L109;
        return false;
    L109:
        if (hasContentionAtimeBe() == false) goto L114;
        if (getContentionAtimeBe() == r10.getContentionAtimeBe()) goto L114;
        return false;
    L114:
        if (hasContentionAtimeBk() == r10.hasContentionAtimeBk()) goto L117;
        return false;
    L117:
        if (hasContentionAtimeBk() == false) goto L122;
        if (getContentionAtimeBk() == r10.getContentionAtimeBk()) goto L122;
        return false;
    L122:
        if (hasContentionAtimeVi() == r10.hasContentionAtimeVi()) goto L125;
        return false;
    L125:
        if (hasContentionAtimeVi() == false) goto L130;
        if (getContentionAtimeVi() == r10.getContentionAtimeVi()) goto L130;
        return false;
    L130:
        if (hasContentionAtimeVo() == r10.hasContentionAtimeVo()) goto L133;
        return false;
    L133:
        if (hasContentionAtimeVo() == false) goto L138;
        if (getContentionAtimeVo() == r10.getContentionAtimeVo()) goto L138;
        return false;
    L138:
        if (hasTxMpduBe() == r10.hasTxMpduBe()) goto L141;
        return false;
    L141:
        if (hasTxMpduBe() == false) goto L146;
        if (getTxMpduBe() == r10.getTxMpduBe()) goto L146;
        return false;
    L146:
        if (hasTxRetriesBe() == r10.hasTxRetriesBe()) goto L149;
        return false;
    L149:
        if (hasTxRetriesBe() == false) goto L154;
        if (getTxRetriesBe() == r10.getTxRetriesBe()) goto L154;
        return false;
    L154:
        if (hasTxRetranLevelBe() == r10.hasTxRetranLevelBe()) goto L157;
        return false;
    L157:
        if (hasTxRetranLevelBe() == false) goto L162;
        if (getTxRetranLevelBe() == r10.getTxRetranLevelBe()) goto L162;
        return false;
    L162:
        if (hasTxMpduVi() == r10.hasTxMpduVi()) goto L165;
        return false;
    L165:
        if (hasTxMpduVi() == false) goto L170;
        if (getTxMpduVi() == r10.getTxMpduVi()) goto L170;
        return false;
    L170:
        if (hasTxRetriesVi() == r10.hasTxRetriesVi()) goto L173;
        return false;
    L173:
        if (hasTxRetriesVi() == false) goto L178;
        if (getTxRetriesVi() == r10.getTxRetriesVi()) goto L178;
        return false;
    L178:
        if (hasTxRetranLevelVi() == r10.hasTxRetranLevelVi()) goto L181;
        return false;
    L181:
        if (hasTxRetranLevelVi() == false) goto L186;
        if (getTxRetranLevelVi() == r10.getTxRetranLevelVi()) goto L186;
        return false;
    L186:
        if (hasTxMpduVo() == r10.hasTxMpduVo()) goto L189;
        return false;
    L189:
        if (hasTxMpduVo() == false) goto L194;
        if (getTxMpduVo() == r10.getTxMpduVo()) goto L194;
        return false;
    L194:
        if (hasTxRetriesVo() == r10.hasTxRetriesVo()) goto L197;
        return false;
    L197:
        if (hasTxRetriesVo() == false) goto L202;
        if (getTxRetriesVo() == r10.getTxRetriesVo()) goto L202;
        return false;
    L202:
        if (hasTxRetranLevelVo() == r10.hasTxRetranLevelVo()) goto L205;
        return false;
    L205:
        if (hasTxRetranLevelVo() == false) goto L210;
        if (getTxRetranLevelVo() == r10.getTxRetranLevelVo()) goto L210;
        return false;
    L210:
        if (hasWidth() == r10.hasWidth()) goto L213;
        return false;
    L213:
        if (hasWidth() == false) goto L218;
        if (getWidth() == r10.getWidth()) goto L218;
        return false;
    L218:
        if (hasRssiMgmt() == r10.hasRssiMgmt()) goto L221;
        return false;
    L221:
        if (hasRssiMgmt() == false) goto L226;
        if (getRssiMgmt() == r10.getRssiMgmt()) goto L226;
        return false;
    L226:
        if (hasRssiData() == r10.hasRssiData()) goto L229;
        return false;
    L229:
        if (hasRssiData() == false) goto L234;
        if (getRssiData() == r10.getRssiData()) goto L234;
        return false;
    L234:
        if (hasRssiAck() == r10.hasRssiAck()) goto L237;
        return false;
    L237:
        if (hasRssiAck() == false) goto L242;
        if (getRssiAck() == r10.getRssiAck()) goto L242;
        return false;
    L242:
        if (hasRlTxLinkSpeed() == r10.hasRlTxLinkSpeed()) goto L245;
        return false;
    L245:
        if (hasRlTxLinkSpeed() == false) goto L250;
        if (getRlTxLinkSpeed() == r10.getRlTxLinkSpeed()) goto L250;
        return false;
    L250:
        if (hasRlRxLinkSpeed() == r10.hasRlRxLinkSpeed()) goto L253;
        return false;
    L253:
        if (hasRlRxLinkSpeed() == false) goto L258;
        if (getRlRxLinkSpeed() == r10.getRlRxLinkSpeed()) goto L258;
        return false;
    L258:
        if (hasRlCcaBusyRate() == r10.hasRlCcaBusyRate()) goto L261;
        return false;
    L261:
        if (hasRlCcaBusyRate() == false) goto L266;
        if (getRlCcaBusyRate() == r10.getRlCcaBusyRate()) goto L266;
        return false;
    L266:
        if (hasPer() == r10.hasPer()) goto L269;
        return false;
    L269:
        if (hasPer() == false) goto L274;
        if (getPer() == r10.getPer()) goto L274;
        return false;
    L274:
        if (hasOnTimeScan() == r10.hasOnTimeScan()) goto L277;
        return false;
    L277:
        if (hasOnTimeScan() == false) goto L282;
        if (getOnTimeScan() == r10.getOnTimeScan()) goto L282;
        return false;
    L282:
        if (hasTxSpeedKbps() == r10.hasTxSpeedKbps()) goto L285;
        return false;
    L285:
        if (hasTxSpeedKbps() == false) goto L290;
        if (getTxSpeedKbps() == r10.getTxSpeedKbps()) goto L290;
        return false;
    L290:
        if (hasRxSpeedKbps() == r10.hasRxSpeedKbps()) goto L293;
        return false;
    L293:
        if (hasRxSpeedKbps() == false) goto L298;
        if (getRxSpeedKbps() == r10.getRxSpeedKbps()) goto L298;
        return false;
    L298:
        if (hasPowerPredMw() == r10.hasPowerPredMw()) goto L301;
        return false;
    L301:
        if (hasPowerPredMw() == false) goto L306;
        if (Float.floatToIntBits(getPowerPredMw()) == Float.floatToIntBits(r10.getPowerPredMw())) goto L306;
        return false;
    L306:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L308;
        return false;
    L308:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getCcaLevel() {
        return this.ccaLevel_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getCenterFreq() {
        return this.centerFreq_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getContentionAtimeBe() {
        return this.contentionAtimeBe_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getContentionAtimeBk() {
        return this.contentionAtimeBk_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getContentionAtimeVi() {
        return this.contentionAtimeVi_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getContentionAtimeVo() {
        return this.contentionAtimeVo_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getDeltaCcaBusyTime() {
        return this.deltaCcaBusyTime_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getDeltaRadioOnTime() {
        return this.deltaRadioOnTime_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getDeltaRxSuccess() {
        return this.deltaRxSuccess_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getDeltaTxBad() {
        return this.deltaTxBad_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getDeltaTxRetries() {
        return this.deltaTxRetries_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getDeltaTxSuccess() {
        return this.deltaTxSuccess_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getLinkId() {
        return this.linkId_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getOnTimeScan() {
        return this.onTimeScan_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LinkStats> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getPer() {
        return this.per_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public float getPowerPredMw() {
        return this.powerPredMw_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRlCcaBusyRate() {
        return this.rlCcaBusyRate_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRlRxLinkSpeed() {
        return this.rlRxLinkSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRlTxLinkSpeed() {
        return this.rlTxLinkSpeed_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRssiAck() {
        return this.rssiAck_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRssiData() {
        return this.rssiData_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRssiMgmt() {
        return this.rssiMgmt_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getRxSpeedKbps() {
        return this.rxSpeedKbps_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt32Size(1, this.linkId_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.radioId_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.centerFreq_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.deltaCcaBusyTime_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.deltaRadioOnTime_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.ccaLevel_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt64Size(7, this.deltaTxSuccess_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt64Size(8, this.deltaTxRetries_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.txRetrayLevel_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt64Size(10, this.deltaTxBad_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.txBadLevel_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.deltaRxSuccess_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.contentionAtimeBe_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.contentionAtimeBk_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeInt32Size(15, this.contentionAtimeVi_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeInt32Size(16, this.contentionAtimeVo_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + CodedOutputStream.computeInt64Size(17, this.txMpduBe_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + CodedOutputStream.computeInt64Size(18, this.txRetriesBe_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L63;
        r10 = r10 + CodedOutputStream.computeInt32Size(19, this.txRetranLevelBe_);
    L63:
        if ((this.bitField0_ & 524288) == 0) goto L66;
        r10 = r10 + CodedOutputStream.computeInt64Size(20, this.txMpduVi_);
    L66:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L69;
        r10 = r10 + CodedOutputStream.computeInt64Size(21, this.txRetriesVi_);
    L69:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L72;
        r10 = r10 + CodedOutputStream.computeInt32Size(22, this.txRetranLevelVi_);
    L72:
        if ((this.bitField0_ & 4194304) == 0) goto L75;
        r10 = r10 + CodedOutputStream.computeInt64Size(23, this.txMpduVo_);
    L75:
        if ((this.bitField0_ & 8388608) == 0) goto L78;
        r10 = r10 + CodedOutputStream.computeInt64Size(24, this.txRetriesVo_);
    L78:
        if ((this.bitField0_ & 16777216) == 0) goto L81;
        r10 = r10 + CodedOutputStream.computeInt32Size(25, this.txRetranLevelVo_);
    L81:
        if ((this.bitField0_ & 33554432) == 0) goto L84;
        r10 = r10 + CodedOutputStream.computeInt32Size(26, this.width_);
    L84:
        if ((this.bitField0_ & 67108864) == 0) goto L87;
        r10 = r10 + CodedOutputStream.computeInt32Size(27, this.rssiMgmt_);
    L87:
        if ((this.bitField0_ & 134217728) == 0) goto L90;
        r10 = r10 + CodedOutputStream.computeInt32Size(28, this.rssiData_);
    L90:
        if ((this.bitField0_ & 268435456) == 0) goto L93;
        r10 = r10 + CodedOutputStream.computeInt32Size(29, this.rssiAck_);
    L93:
        if ((this.bitField0_ & 536870912) == 0) goto L96;
        r10 = r10 + CodedOutputStream.computeInt32Size(30, this.rlTxLinkSpeed_);
    L96:
        if ((this.bitField0_ & 1073741824) == 0) goto L99;
        r10 = r10 + CodedOutputStream.computeInt32Size(31, this.rlRxLinkSpeed_);
    L99:
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L102;
        r10 = r10 + CodedOutputStream.computeInt32Size(32, this.rlCcaBusyRate_);
    L102:
        if ((this.bitField1_ & 1) == 0) goto L105;
        r10 = r10 + CodedOutputStream.computeInt32Size(33, this.per_);
    L105:
        if ((this.bitField1_ & 2) == 0) goto L108;
        r10 = r10 + CodedOutputStream.computeInt32Size(34, this.onTimeScan_);
    L108:
        if ((this.bitField1_ & 4) == 0) goto L111;
        r10 = r10 + CodedOutputStream.computeInt32Size(35, this.txSpeedKbps_);
    L111:
        if ((this.bitField1_ & 8) == 0) goto L114;
        r10 = r10 + CodedOutputStream.computeInt32Size(36, this.rxSpeedKbps_);
    L114:
        if ((this.bitField1_ & 16) == 0) goto L116;
        r10 = r10 + CodedOutputStream.computeFloatSize(37, this.powerPredMw_);
    L116:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getTxBadLevel() {
        return this.txBadLevel_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getTxMpduBe() {
        return this.txMpduBe_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getTxMpduVi() {
        return this.txMpduVi_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getTxMpduVo() {
        return this.txMpduVo_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getTxRetranLevelBe() {
        return this.txRetranLevelBe_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getTxRetranLevelVi() {
        return this.txRetranLevelVi_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getTxRetranLevelVo() {
        return this.txRetranLevelVo_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getTxRetrayLevel() {
        return this.txRetrayLevel_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getTxRetriesBe() {
        return this.txRetriesBe_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getTxRetriesVi() {
        return this.txRetriesVi_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public long getTxRetriesVo() {
        return this.txRetriesVo_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getTxSpeedKbps() {
        return this.txSpeedKbps_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public int getWidth() {
        return this.width_;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasCcaLevel() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasCenterFreq() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasContentionAtimeBe() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasContentionAtimeBk() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasContentionAtimeVi() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasContentionAtimeVo() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasDeltaCcaBusyTime() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasDeltaRadioOnTime() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasDeltaRxSuccess() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasDeltaTxBad() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasDeltaTxRetries() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasDeltaTxSuccess() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasLinkId() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasOnTimeScan() {
        if ((this.bitField1_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasPer() {
        if ((this.bitField1_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasPowerPredMw() {
        if ((this.bitField1_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRadioId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRlCcaBusyRate() {
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRlRxLinkSpeed() {
        if ((this.bitField0_ & 1073741824) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRlTxLinkSpeed() {
        if ((this.bitField0_ & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRssiAck() {
        if ((this.bitField0_ & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRssiData() {
        if ((this.bitField0_ & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRssiMgmt() {
        if ((this.bitField0_ & 67108864) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasRxSpeedKbps() {
        if ((this.bitField1_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxBadLevel() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxMpduBe() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxMpduVi() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxMpduVo() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxRetranLevelBe() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxRetranLevelVi() {
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxRetranLevelVo() {
        if ((this.bitField0_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxRetrayLevel() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxRetriesBe() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxRetriesVi() {
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxRetriesVo() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasTxSpeedKbps() {
        if ((this.bitField1_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.LinkStatsOrBuilder
    public boolean hasWidth() {
        if ((this.bitField0_ & 33554432) == 0) goto L5;
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
        if (hasLinkId() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getLinkId();
    L9:
        if (hasRadioId() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getRadioId();
    L12:
        if (hasCenterFreq() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getCenterFreq();
    L15:
        if (hasDeltaCcaBusyTime() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getDeltaCcaBusyTime();
    L18:
        if (hasDeltaRadioOnTime() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getDeltaRadioOnTime();
    L21:
        if (hasCcaLevel() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getCcaLevel();
    L24:
        if (hasDeltaTxSuccess() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + Internal.hashLong(getDeltaTxSuccess());
    L27:
        if (hasDeltaTxRetries() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + Internal.hashLong(getDeltaTxRetries());
    L30:
        if (hasTxRetrayLevel() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getTxRetrayLevel();
    L33:
        if (hasDeltaTxBad() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + Internal.hashLong(getDeltaTxBad());
    L36:
        if (hasTxBadLevel() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getTxBadLevel();
    L39:
        if (hasDeltaRxSuccess() == false) goto L42;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getDeltaRxSuccess();
    L42:
        if (hasContentionAtimeBe() == false) goto L45;
        r10 = defpackage.b.a(r10, 37, 13, 53) + getContentionAtimeBe();
    L45:
        if (hasContentionAtimeBk() == false) goto L48;
        r10 = defpackage.b.a(r10, 37, 14, 53) + getContentionAtimeBk();
    L48:
        if (hasContentionAtimeVi() == false) goto L51;
        r10 = defpackage.b.a(r10, 37, 15, 53) + getContentionAtimeVi();
    L51:
        if (hasContentionAtimeVo() == false) goto L54;
        r10 = defpackage.b.a(r10, 37, 16, 53) + getContentionAtimeVo();
    L54:
        if (hasTxMpduBe() == false) goto L57;
        r10 = defpackage.b.a(r10, 37, 17, 53) + Internal.hashLong(getTxMpduBe());
    L57:
        if (hasTxRetriesBe() == false) goto L60;
        r10 = defpackage.b.a(r10, 37, 18, 53) + Internal.hashLong(getTxRetriesBe());
    L60:
        if (hasTxRetranLevelBe() == false) goto L63;
        r10 = defpackage.b.a(r10, 37, 19, 53) + getTxRetranLevelBe();
    L63:
        if (hasTxMpduVi() == false) goto L66;
        r10 = defpackage.b.a(r10, 37, 20, 53) + Internal.hashLong(getTxMpduVi());
    L66:
        if (hasTxRetriesVi() == false) goto L69;
        r10 = defpackage.b.a(r10, 37, 21, 53) + Internal.hashLong(getTxRetriesVi());
    L69:
        if (hasTxRetranLevelVi() == false) goto L72;
        r10 = defpackage.b.a(r10, 37, 22, 53) + getTxRetranLevelVi();
    L72:
        if (hasTxMpduVo() == false) goto L75;
        r10 = defpackage.b.a(r10, 37, 23, 53) + Internal.hashLong(getTxMpduVo());
    L75:
        if (hasTxRetriesVo() == false) goto L78;
        r10 = defpackage.b.a(r10, 37, 24, 53) + Internal.hashLong(getTxRetriesVo());
    L78:
        if (hasTxRetranLevelVo() == false) goto L81;
        r10 = defpackage.b.a(r10, 37, 25, 53) + getTxRetranLevelVo();
    L81:
        if (hasWidth() == false) goto L84;
        r10 = defpackage.b.a(r10, 37, 26, 53) + getWidth();
    L84:
        if (hasRssiMgmt() == false) goto L87;
        r10 = defpackage.b.a(r10, 37, 27, 53) + getRssiMgmt();
    L87:
        if (hasRssiData() == false) goto L90;
        r10 = defpackage.b.a(r10, 37, 28, 53) + getRssiData();
    L90:
        if (hasRssiAck() == false) goto L93;
        r10 = defpackage.b.a(r10, 37, 29, 53) + getRssiAck();
    L93:
        if (hasRlTxLinkSpeed() == false) goto L96;
        r10 = defpackage.b.a(r10, 37, 30, 53) + getRlTxLinkSpeed();
    L96:
        if (hasRlRxLinkSpeed() == false) goto L99;
        r10 = defpackage.b.a(r10, 37, 31, 53) + getRlRxLinkSpeed();
    L99:
        if (hasRlCcaBusyRate() == false) goto L102;
        r10 = defpackage.b.a(r10, 37, 32, 53) + getRlCcaBusyRate();
    L102:
        if (hasPer() == false) goto L105;
        r10 = defpackage.b.a(r10, 37, 33, 53) + getPer();
    L105:
        if (hasOnTimeScan() == false) goto L108;
        r10 = defpackage.b.a(r10, 37, 34, 53) + getOnTimeScan();
    L108:
        if (hasTxSpeedKbps() == false) goto L111;
        r10 = defpackage.b.a(r10, 37, 35, 53) + getTxSpeedKbps();
    L111:
        if (hasRxSpeedKbps() == false) goto L114;
        r10 = defpackage.b.a(r10, 37, 36, 53) + getRxSpeedKbps();
    L114:
        if (hasPowerPredMw() == false) goto L116;
        r10 = defpackage.b.a(r10, 37, 37, 53) + Float.floatToIntBits(getPowerPredMw());
    L116:
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
        return new LinkStats();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r10.writeInt32(1, this.linkId_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r10.writeInt32(2, this.radioId_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r10.writeInt32(3, this.centerFreq_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r10.writeInt32(4, this.deltaCcaBusyTime_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r10.writeInt32(5, this.deltaRadioOnTime_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r10.writeInt32(6, this.ccaLevel_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r10.writeInt64(7, this.deltaTxSuccess_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r10.writeInt64(8, this.deltaTxRetries_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r10.writeInt32(9, this.txRetrayLevel_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r10.writeInt64(10, this.deltaTxBad_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r10.writeInt32(11, this.txBadLevel_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r10.writeInt32(12, this.deltaRxSuccess_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r10.writeInt32(13, this.contentionAtimeBe_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r10.writeInt32(14, this.contentionAtimeBk_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r10.writeInt32(15, this.contentionAtimeVi_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r10.writeInt32(16, this.contentionAtimeVo_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r10.writeInt64(17, this.txMpduBe_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r10.writeInt64(18, this.txRetriesBe_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        r10.writeInt32(19, this.txRetranLevelBe_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        r10.writeInt64(20, this.txMpduVi_);
    L63:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L66;
        r10.writeInt64(21, this.txRetriesVi_);
    L66:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L69;
        r10.writeInt32(22, this.txRetranLevelVi_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r10.writeInt64(23, this.txMpduVo_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L75;
        r10.writeInt64(24, this.txRetriesVo_);
    L75:
        if ((this.bitField0_ & 16777216) == 0) goto L78;
        r10.writeInt32(25, this.txRetranLevelVo_);
    L78:
        if ((this.bitField0_ & 33554432) == 0) goto L81;
        r10.writeInt32(26, this.width_);
    L81:
        if ((this.bitField0_ & 67108864) == 0) goto L84;
        r10.writeInt32(27, this.rssiMgmt_);
    L84:
        if ((this.bitField0_ & 134217728) == 0) goto L87;
        r10.writeInt32(28, this.rssiData_);
    L87:
        if ((this.bitField0_ & 268435456) == 0) goto L90;
        r10.writeInt32(29, this.rssiAck_);
    L90:
        if ((this.bitField0_ & 536870912) == 0) goto L93;
        r10.writeInt32(30, this.rlTxLinkSpeed_);
    L93:
        if ((this.bitField0_ & 1073741824) == 0) goto L96;
        r10.writeInt32(31, this.rlRxLinkSpeed_);
    L96:
        if ((this.bitField0_ & Integer.MIN_VALUE) == 0) goto L99;
        r10.writeInt32(32, this.rlCcaBusyRate_);
    L99:
        if ((this.bitField1_ & 1) == 0) goto L102;
        r10.writeInt32(33, this.per_);
    L102:
        if ((this.bitField1_ & 2) == 0) goto L105;
        r10.writeInt32(34, this.onTimeScan_);
    L105:
        if ((this.bitField1_ & 4) == 0) goto L108;
        r10.writeInt32(35, this.txSpeedKbps_);
    L108:
        if ((this.bitField1_ & 8) == 0) goto L111;
        r10.writeInt32(36, this.rxSpeedKbps_);
    L111:
        if ((this.bitField1_ & 16) == 0) goto L113;
        r10.writeFloat(37, this.powerPredMw_);
    L113:
        getUnknownFields().writeTo(r10);
    }

    private LinkStats(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.linkId_ = 0;
        this.radioId_ = 0;
        this.centerFreq_ = 0;
        this.deltaCcaBusyTime_ = 0;
        this.deltaRadioOnTime_ = 0;
        this.ccaLevel_ = 0;
        this.deltaTxSuccess_ = 0;
        this.deltaTxRetries_ = 0;
        this.txRetrayLevel_ = 0;
        this.deltaTxBad_ = 0;
        this.txBadLevel_ = 0;
        this.deltaRxSuccess_ = 0;
        this.contentionAtimeBe_ = 0;
        this.contentionAtimeBk_ = 0;
        this.contentionAtimeVi_ = 0;
        this.contentionAtimeVo_ = 0;
        this.txMpduBe_ = 0;
        this.txRetriesBe_ = 0;
        this.txRetranLevelBe_ = 0;
        this.txMpduVi_ = 0;
        this.txRetriesVi_ = 0;
        this.txRetranLevelVi_ = 0;
        this.txMpduVo_ = 0;
        this.txRetriesVo_ = 0;
        this.txRetranLevelVo_ = 0;
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
        this.powerPredMw_ = 0.0f;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(LinkStats r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static LinkStats parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (LinkStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static LinkStats parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_LinkStats_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkStats.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ LinkStats(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static LinkStats parseFrom(CodedInputStream r8) {
        return (LinkStats) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public LinkStats getDefaultInstanceForType() {
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

    public static LinkStats parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (LinkStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static LinkStats parseFrom(InputStream r8) {
        return (LinkStats) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static LinkStats parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (LinkStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static LinkStats parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static LinkStats parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static LinkStats parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static LinkStats parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
