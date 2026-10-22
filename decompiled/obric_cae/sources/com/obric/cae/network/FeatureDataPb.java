package com.obric.cae.network;

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
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import com.ttnet.org.chromium.net.NetError;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureDataPb extends GeneratedMessageV3 implements FeatureDataPbOrBuilder {
    public static final int APP_CATEGORY_FIELD_NUMBER = 6;
    public static final int APP_SPEED_RATE_FIELD_NUMBER = 10;
    public static final int CELL_L2_STATE_FIELD_NUMBER = 25;
    public static final int CELL_REMAINING_TRAFFIC_FIELD_NUMBER = 4;
    public static final int CELL_USED_TRAFFIC_FIELD_NUMBER = 3;
    public static final int CUR_LOCATION_FIELD_NUMBER = 12;
    public static final int D7_CELL_APP_USED_FIELD_NUMBER = 7;
    public static final int D7_CELL_TOTAL_USED_FIELD_NUMBER = 8;
    public static final int D7_TRAFFIC_APP_USED_FIELD_NUMBER = 9;
    private static final FeatureDataPb DEFAULT_INSTANCE = null;
    public static final int INDEX_FIELD_NUMBER = 1;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 5;

    @Deprecated
    public static final Parser<FeatureDataPb> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int TOTAL_SPEED_RATE_FIELD_NUMBER = 11;
    public static final int WIFI_BAND_FIELD_NUMBER = 15;
    public static final int WIFI_L2_RX_TPUT_FIELD_NUMBER = 14;
    public static final int WIFI_L2_TX_TPUT_FIELD_NUMBER = 13;
    public static final int WIFI_L4_RECV_OOO_RATE_FIELD_NUMBER = 20;
    public static final int WIFI_L4_RECV_PKTS_FIELD_NUMBER = 19;
    public static final int WIFI_L4_RECV_SPEED_FIELD_NUMBER = 24;
    public static final int WIFI_L4_RETRY_RATE_FIELD_NUMBER = 22;
    public static final int WIFI_L4_RTT_FIELD_NUMBER = 17;
    public static final int WIFI_L4_SEND_PKTS_FIELD_NUMBER = 18;
    public static final int WIFI_L4_SEND_SPEED_FIELD_NUMBER = 23;
    public static final int WIFI_L4_UNACK_PKTS_FIELD_NUMBER = 21;
    public static final int WIFI_RSSI_FIELD_NUMBER = 16;
    private static final long serialVersionUID = 0;
    private int appCategory_;
    private int appSpeedRate_;
    private int bitField0_;
    private int cellL2State_;
    private int cellRemainingTraffic_;
    private int cellUsedTraffic_;
    private int curLocation_;
    private int d7CellAppUsed_;
    private int d7CellTotalUsed_;
    private int d7TrafficAppUsed_;
    private long index_;
    private byte memoizedIsInitialized;
    private volatile Object packageName_;
    private long timestamp_;
    private int totalSpeedRate_;
    private int wifiBand_;
    private int wifiL2RxTput_;
    private int wifiL2TxTput_;
    private int wifiL4RecvOooRate_;
    private int wifiL4RecvPkts_;
    private int wifiL4RecvSpeed_;
    private int wifiL4RetryRate_;
    private int wifiL4Rtt_;
    private int wifiL4SendPkts_;
    private int wifiL4SendSpeed_;
    private int wifiL4UnackPkts_;
    private int wifiRssi_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FeatureDataPbOrBuilder {
        private int appCategory_;
        private int appSpeedRate_;
        private int bitField0_;
        private int cellL2State_;
        private int cellRemainingTraffic_;
        private int cellUsedTraffic_;
        private int curLocation_;
        private int d7CellAppUsed_;
        private int d7CellTotalUsed_;
        private int d7TrafficAppUsed_;
        private long index_;
        private Object packageName_;
        private long timestamp_;
        private int totalSpeedRate_;
        private int wifiBand_;
        private int wifiL2RxTput_;
        private int wifiL2TxTput_;
        private int wifiL4RecvOooRate_;
        private int wifiL4RecvPkts_;
        private int wifiL4RecvSpeed_;
        private int wifiL4RetryRate_;
        private int wifiL4Rtt_;
        private int wifiL4SendPkts_;
        private int wifiL4SendSpeed_;
        private int wifiL4UnackPkts_;
        private int wifiRssi_;

        private Builder() {
            this.packageName_ = "";
        }

        private void buildPartial0(FeatureDataPb r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            FeatureDataPb.access$302(r8, this.index_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            FeatureDataPb.access$402(r8, this.timestamp_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            FeatureDataPb.access$502(r8, this.cellUsedTraffic_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            FeatureDataPb.access$602(r8, this.cellRemainingTraffic_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            FeatureDataPb.access$702(r8, this.packageName_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            FeatureDataPb.access$802(r8, this.appCategory_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            FeatureDataPb.access$902(r8, this.d7CellAppUsed_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            FeatureDataPb.access$1002(r8, this.d7CellTotalUsed_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            FeatureDataPb.access$1102(r8, this.d7TrafficAppUsed_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            FeatureDataPb.access$1202(r8, this.appSpeedRate_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            FeatureDataPb.access$1302(r8, this.totalSpeedRate_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            FeatureDataPb.access$1402(r8, this.curLocation_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            FeatureDataPb.access$1502(r8, this.wifiL2TxTput_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            FeatureDataPb.access$1602(r8, this.wifiL2RxTput_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            FeatureDataPb.access$1702(r8, this.wifiBand_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            FeatureDataPb.access$1802(r8, this.wifiRssi_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            FeatureDataPb.access$1902(r8, this.wifiL4Rtt_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            FeatureDataPb.access$2002(r8, this.wifiL4SendPkts_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            FeatureDataPb.access$2102(r8, this.wifiL4RecvPkts_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            FeatureDataPb.access$2202(r8, this.wifiL4RecvOooRate_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            FeatureDataPb.access$2302(r8, this.wifiL4UnackPkts_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            FeatureDataPb.access$2402(r8, this.wifiL4RetryRate_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            FeatureDataPb.access$2502(r8, this.wifiL4SendSpeed_);
            r11 = r11 | 4194304;
        L73:
            if ((8388608 & r10) == 0) goto L76;
            FeatureDataPb.access$2602(r8, this.wifiL4RecvSpeed_);
            r11 = r11 | 8388608;
        L76:
            if ((r10 & 16777216) == 0) goto L78;
            FeatureDataPb.access$2702(r8, this.cellL2State_);
            r11 = r11 | 16777216;
        L78:
            FeatureDataPb.access$2876(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_FeatureDataPb_descriptor;
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

        public Builder clearAppCategory() {
            this.bitField0_ &= -33;
            this.appCategory_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAppSpeedRate() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.appSpeedRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCellL2State() {
            this.bitField0_ &= -16777217;
            this.cellL2State_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCellRemainingTraffic() {
            this.bitField0_ &= -9;
            this.cellRemainingTraffic_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCellUsedTraffic() {
            this.bitField0_ &= -5;
            this.cellUsedTraffic_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCurLocation() {
            this.bitField0_ &= -2049;
            this.curLocation_ = 0;
            onChanged();
            return this;
        }

        public Builder clearD7CellAppUsed() {
            this.bitField0_ &= -65;
            this.d7CellAppUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearD7CellTotalUsed() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.d7CellTotalUsed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearD7TrafficAppUsed() {
            this.bitField0_ &= -257;
            this.d7TrafficAppUsed_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearIndex() {
            this.bitField0_ &= -2;
            this.index_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPackageName() {
            this.packageName_ = FeatureDataPb.getDefaultInstance().getPackageName();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -3;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalSpeedRate() {
            this.bitField0_ &= -1025;
            this.totalSpeedRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiBand() {
            this.bitField0_ &= -16385;
            this.wifiBand_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL2RxTput() {
            this.bitField0_ &= -8193;
            this.wifiL2RxTput_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL2TxTput() {
            this.bitField0_ &= -4097;
            this.wifiL2TxTput_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4RecvOooRate() {
            this.bitField0_ &= -524289;
            this.wifiL4RecvOooRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4RecvPkts() {
            this.bitField0_ &= -262145;
            this.wifiL4RecvPkts_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4RecvSpeed() {
            this.bitField0_ &= -8388609;
            this.wifiL4RecvSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4RetryRate() {
            this.bitField0_ &= -2097153;
            this.wifiL4RetryRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4Rtt() {
            this.bitField0_ &= -65537;
            this.wifiL4Rtt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4SendPkts() {
            this.bitField0_ &= -131073;
            this.wifiL4SendPkts_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4SendSpeed() {
            this.bitField0_ &= -4194305;
            this.wifiL4SendSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiL4UnackPkts() {
            this.bitField0_ &= -1048577;
            this.wifiL4UnackPkts_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiRssi() {
            this.bitField0_ &= -32769;
            this.wifiRssi_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getAppCategory() {
            return this.appCategory_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getAppSpeedRate() {
            return this.appSpeedRate_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getCellL2State() {
            return this.cellL2State_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getCellRemainingTraffic() {
            return this.cellRemainingTraffic_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getCellUsedTraffic() {
            return this.cellUsedTraffic_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getCurLocation() {
            return this.curLocation_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getD7CellAppUsed() {
            return this.d7CellAppUsed_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getD7CellTotalUsed() {
            return this.d7CellTotalUsed_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getD7TrafficAppUsed() {
            return this.d7TrafficAppUsed_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_FeatureDataPb_descriptor;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public long getIndex() {
            return this.index_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public String getPackageName() {
            Object r8 = this.packageName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.packageName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public ByteString getPackageNameBytes() {
            Object r8 = this.packageName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.packageName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getTotalSpeedRate() {
            return this.totalSpeedRate_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiBand() {
            return this.wifiBand_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL2RxTput() {
            return this.wifiL2RxTput_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL2TxTput() {
            return this.wifiL2TxTput_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4RecvOooRate() {
            return this.wifiL4RecvOooRate_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4RecvPkts() {
            return this.wifiL4RecvPkts_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4RecvSpeed() {
            return this.wifiL4RecvSpeed_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4RetryRate() {
            return this.wifiL4RetryRate_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4Rtt() {
            return this.wifiL4Rtt_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4SendPkts() {
            return this.wifiL4SendPkts_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4SendSpeed() {
            return this.wifiL4SendSpeed_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiL4UnackPkts() {
            return this.wifiL4UnackPkts_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public int getWifiRssi() {
            return this.wifiRssi_;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasAppCategory() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasAppSpeedRate() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasCellL2State() {
            if ((this.bitField0_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasCellRemainingTraffic() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasCellUsedTraffic() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasCurLocation() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasD7CellAppUsed() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasD7CellTotalUsed() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasD7TrafficAppUsed() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasIndex() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasTotalSpeedRate() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiBand() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL2RxTput() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL2TxTput() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4RecvOooRate() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4RecvPkts() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4RecvSpeed() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4RetryRate() {
            if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4Rtt() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4SendPkts() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4SendSpeed() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiL4UnackPkts() {
            if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.FeatureDataPbOrBuilder
        public boolean hasWifiRssi() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
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

        public Builder setAppCategory(int r8) {
            this.appCategory_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setAppSpeedRate(int r8) {
            this.appSpeedRate_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setCellL2State(int r8) {
            this.cellL2State_ = r8;
            this.bitField0_ |= 16777216;
            onChanged();
            return this;
        }

        public Builder setCellRemainingTraffic(int r8) {
            this.cellRemainingTraffic_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setCellUsedTraffic(int r8) {
            this.cellUsedTraffic_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setCurLocation(int r8) {
            this.curLocation_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setD7CellAppUsed(int r8) {
            this.d7CellAppUsed_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setD7CellTotalUsed(int r8) {
            this.d7CellTotalUsed_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setD7TrafficAppUsed(int r8) {
            this.d7TrafficAppUsed_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setIndex(long r8) {
            this.index_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setPackageName(String r8) {
            if (r8 == null) goto L6;
            this.packageName_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setPackageNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.packageName_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setTotalSpeedRate(int r8) {
            this.totalSpeedRate_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiBand(int r8) {
            this.wifiBand_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setWifiL2RxTput(int r8) {
            this.wifiL2RxTput_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setWifiL2TxTput(int r8) {
            this.wifiL2TxTput_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setWifiL4RecvOooRate(int r8) {
            this.wifiL4RecvOooRate_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setWifiL4RecvPkts(int r8) {
            this.wifiL4RecvPkts_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setWifiL4RecvSpeed(int r8) {
            this.wifiL4RecvSpeed_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        }

        public Builder setWifiL4RetryRate(int r8) {
            this.wifiL4RetryRate_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        }

        public Builder setWifiL4Rtt(int r8) {
            this.wifiL4Rtt_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setWifiL4SendPkts(int r8) {
            this.wifiL4SendPkts_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setWifiL4SendSpeed(int r8) {
            this.wifiL4SendSpeed_ = r8;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setWifiL4UnackPkts(int r8) {
            this.wifiL4UnackPkts_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        }

        public Builder setWifiRssi(int r8) {
            this.wifiRssi_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.packageName_ = "";
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_FeatureDataPb_fieldAccessorTable.ensureFieldAccessorsInitialized(FeatureDataPb.class, Builder.class);
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
        public FeatureDataPb build() {
            FeatureDataPb r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FeatureDataPb buildPartial() {
            FeatureDataPb r8 = new FeatureDataPb(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
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
        public FeatureDataPb getDefaultInstanceForType() {
            return FeatureDataPb.getDefaultInstance();
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
            this.index_ = 0;
            this.timestamp_ = 0;
            this.cellUsedTraffic_ = 0;
            this.cellRemainingTraffic_ = 0;
            this.packageName_ = "";
            this.appCategory_ = 0;
            this.d7CellAppUsed_ = 0;
            this.d7CellTotalUsed_ = 0;
            this.d7TrafficAppUsed_ = 0;
            this.appSpeedRate_ = 0;
            this.totalSpeedRate_ = 0;
            this.curLocation_ = 0;
            this.wifiL2TxTput_ = 0;
            this.wifiL2RxTput_ = 0;
            this.wifiBand_ = 0;
            this.wifiRssi_ = 0;
            this.wifiL4Rtt_ = 0;
            this.wifiL4SendPkts_ = 0;
            this.wifiL4RecvPkts_ = 0;
            this.wifiL4RecvOooRate_ = 0;
            this.wifiL4UnackPkts_ = 0;
            this.wifiL4RetryRate_ = 0;
            this.wifiL4SendSpeed_ = 0;
            this.wifiL4RecvSpeed_ = 0;
            this.cellL2State_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L47;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L44;
            int r12 = r8.readTag();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            switch(r12) {
                case 0: goto L34;
                case 8: goto L32;
                case 16: goto L31;
                case 24: goto L30;
                case 32: goto L29;
                case 42: goto L28;
                case 48: goto L27;
                case 56: goto L26;
                case 64: goto L25;
                case 72: goto L24;
                case 80: goto L23;
                case 88: goto L22;
                case 96: goto L21;
                case 104: goto L20;
                case 112: goto L19;
                case 120: goto L18;
                case 128: goto L17;
                case 136: goto L16;
                case 144: goto L15;
                case 152: goto L14;
                case 160: goto L13;
                case 168: goto L12;
                case 176: goto L11;
                case 184: goto L10;
                case 192: goto L9;
                case 200: goto L8;
                default: goto L35;
            };     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
        L8:
            this.cellL2State_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 16777216;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L9:
            this.wifiL4RecvSpeed_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 8388608;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L10:
            this.wifiL4SendSpeed_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 4194304;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L11:
            this.wifiL4RetryRate_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L12:
            this.wifiL4UnackPkts_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L13:
            this.wifiL4RecvOooRate_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 524288;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L14:
            this.wifiL4RecvPkts_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 262144;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L15:
            this.wifiL4SendPkts_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 131072;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L16:
            this.wifiL4Rtt_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 65536;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L17:
            this.wifiRssi_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 32768;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L18:
            this.wifiBand_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 16384;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L19:
            this.wifiL2RxTput_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 8192;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L20:
            this.wifiL2TxTput_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 4096;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L21:
            this.curLocation_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 2048;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L22:
            this.totalSpeedRate_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 1024;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L23:
            this.appSpeedRate_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 512;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L24:
            this.d7TrafficAppUsed_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 256;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L25:
            this.d7CellTotalUsed_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 128;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L26:
            this.d7CellAppUsed_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 64;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L27:
            this.appCategory_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 32;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L28:
            this.packageName_ = r8.readBytes();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 16;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L29:
            this.cellRemainingTraffic_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 8;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L30:
            this.cellUsedTraffic_ = r8.readInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 4;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L31:
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 2;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L32:
            this.index_ = r8.readInt64();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 1;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
        L34:
            r11 = true;
            goto L4
        L35:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L37:
            th = move-exception;
            onChanged();
            throw th;
        L39:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L37
        L44:
            onChanged();
            return this;
        L47:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof FeatureDataPb) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((FeatureDataPb) r8);
        }

        public Builder mergeFrom(FeatureDataPb r8) {
            if (r8 != FeatureDataPb.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasIndex() == false) goto L9;
            setIndex(r8.getIndex());
        L9:
            if (r8.hasTimestamp() == false) goto L12;
            setTimestamp(r8.getTimestamp());
        L12:
            if (r8.hasCellUsedTraffic() == false) goto L15;
            setCellUsedTraffic(r8.getCellUsedTraffic());
        L15:
            if (r8.hasCellRemainingTraffic() == false) goto L18;
            setCellRemainingTraffic(r8.getCellRemainingTraffic());
        L18:
            if (r8.hasPackageName() == false) goto L21;
            this.packageName_ = FeatureDataPb.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasAppCategory() == false) goto L24;
            setAppCategory(r8.getAppCategory());
        L24:
            if (r8.hasD7CellAppUsed() == false) goto L27;
            setD7CellAppUsed(r8.getD7CellAppUsed());
        L27:
            if (r8.hasD7CellTotalUsed() == false) goto L30;
            setD7CellTotalUsed(r8.getD7CellTotalUsed());
        L30:
            if (r8.hasD7TrafficAppUsed() == false) goto L33;
            setD7TrafficAppUsed(r8.getD7TrafficAppUsed());
        L33:
            if (r8.hasAppSpeedRate() == false) goto L36;
            setAppSpeedRate(r8.getAppSpeedRate());
        L36:
            if (r8.hasTotalSpeedRate() == false) goto L39;
            setTotalSpeedRate(r8.getTotalSpeedRate());
        L39:
            if (r8.hasCurLocation() == false) goto L42;
            setCurLocation(r8.getCurLocation());
        L42:
            if (r8.hasWifiL2TxTput() == false) goto L45;
            setWifiL2TxTput(r8.getWifiL2TxTput());
        L45:
            if (r8.hasWifiL2RxTput() == false) goto L48;
            setWifiL2RxTput(r8.getWifiL2RxTput());
        L48:
            if (r8.hasWifiBand() == false) goto L51;
            setWifiBand(r8.getWifiBand());
        L51:
            if (r8.hasWifiRssi() == false) goto L54;
            setWifiRssi(r8.getWifiRssi());
        L54:
            if (r8.hasWifiL4Rtt() == false) goto L57;
            setWifiL4Rtt(r8.getWifiL4Rtt());
        L57:
            if (r8.hasWifiL4SendPkts() == false) goto L60;
            setWifiL4SendPkts(r8.getWifiL4SendPkts());
        L60:
            if (r8.hasWifiL4RecvPkts() == false) goto L63;
            setWifiL4RecvPkts(r8.getWifiL4RecvPkts());
        L63:
            if (r8.hasWifiL4RecvOooRate() == false) goto L66;
            setWifiL4RecvOooRate(r8.getWifiL4RecvOooRate());
        L66:
            if (r8.hasWifiL4UnackPkts() == false) goto L69;
            setWifiL4UnackPkts(r8.getWifiL4UnackPkts());
        L69:
            if (r8.hasWifiL4RetryRate() == false) goto L72;
            setWifiL4RetryRate(r8.getWifiL4RetryRate());
        L72:
            if (r8.hasWifiL4SendSpeed() == false) goto L75;
            setWifiL4SendSpeed(r8.getWifiL4SendSpeed());
        L75:
            if (r8.hasWifiL4RecvSpeed() == false) goto L78;
            setWifiL4RecvSpeed(r8.getWifiL4RecvSpeed());
        L78:
            if (r8.hasCellL2State() == false) goto L80;
            setCellL2State(r8.getCellL2State());
        L80:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new FeatureDataPb();
        PARSER = new AnonymousClass1();
    }

    private FeatureDataPb() {
        this.index_ = 0;
        this.timestamp_ = 0;
        this.cellUsedTraffic_ = 0;
        this.cellRemainingTraffic_ = 0;
        this.packageName_ = "";
        this.appCategory_ = 0;
        this.d7CellAppUsed_ = 0;
        this.d7CellTotalUsed_ = 0;
        this.d7TrafficAppUsed_ = 0;
        this.appSpeedRate_ = 0;
        this.totalSpeedRate_ = 0;
        this.curLocation_ = 0;
        this.wifiL2TxTput_ = 0;
        this.wifiL2RxTput_ = 0;
        this.wifiBand_ = 0;
        this.wifiRssi_ = 0;
        this.wifiL4Rtt_ = 0;
        this.wifiL4SendPkts_ = 0;
        this.wifiL4RecvPkts_ = 0;
        this.wifiL4RecvOooRate_ = 0;
        this.wifiL4UnackPkts_ = 0;
        this.wifiL4RetryRate_ = 0;
        this.wifiL4SendSpeed_ = 0;
        this.wifiL4RecvSpeed_ = 0;
        this.cellL2State_ = 0;
        this.memoizedIsInitialized = -1;
        this.packageName_ = "";
    }

    public static /* synthetic */ int access$1002(FeatureDataPb r8, int r10) {
        r8.d7CellTotalUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(FeatureDataPb r8, int r10) {
        r8.d7TrafficAppUsed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(FeatureDataPb r8, int r10) {
        r8.appSpeedRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(FeatureDataPb r8, int r10) {
        r8.totalSpeedRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(FeatureDataPb r8, int r10) {
        r8.curLocation_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(FeatureDataPb r8, int r10) {
        r8.wifiL2TxTput_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(FeatureDataPb r8, int r10) {
        r8.wifiL2RxTput_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1702(FeatureDataPb r8, int r10) {
        r8.wifiBand_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(FeatureDataPb r8, int r10) {
        r8.wifiRssi_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1902(FeatureDataPb r8, int r10) {
        r8.wifiL4Rtt_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2002(FeatureDataPb r8, int r10) {
        r8.wifiL4SendPkts_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2102(FeatureDataPb r8, int r10) {
        r8.wifiL4RecvPkts_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2202(FeatureDataPb r8, int r10) {
        r8.wifiL4RecvOooRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2302(FeatureDataPb r8, int r10) {
        r8.wifiL4UnackPkts_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2402(FeatureDataPb r8, int r10) {
        r8.wifiL4RetryRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2502(FeatureDataPb r8, int r10) {
        r8.wifiL4SendSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2602(FeatureDataPb r8, int r10) {
        r8.wifiL4RecvSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2702(FeatureDataPb r8, int r10) {
        r8.cellL2State_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2876(FeatureDataPb r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ long access$302(FeatureDataPb r8, long r10) {
        r8.index_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$402(FeatureDataPb r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(FeatureDataPb r8, int r10) {
        r8.cellUsedTraffic_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(FeatureDataPb r8, int r10) {
        r8.cellRemainingTraffic_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(FeatureDataPb r8) {
        return r8.packageName_;
    }

    public static /* synthetic */ Object access$702(FeatureDataPb r8, Object r10) {
        r8.packageName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(FeatureDataPb r8, int r10) {
        r8.appCategory_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(FeatureDataPb r8, int r10) {
        r8.d7CellAppUsed_ = r10;
        return r10;
    }

    public static FeatureDataPb getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_FeatureDataPb_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static FeatureDataPb parseDelimitedFrom(InputStream r8) {
        return (FeatureDataPb) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static FeatureDataPb parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<FeatureDataPb> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof FeatureDataPb) == false) goto L8;
        FeatureDataPb r10 = (FeatureDataPb) r8;
        if (hasIndex() == r10.hasIndex()) goto L13;
        return false;
    L13:
        if (hasIndex() == false) goto L18;
        if (getIndex() == r10.getIndex()) goto L18;
        return false;
    L18:
        if (hasTimestamp() == r10.hasTimestamp()) goto L21;
        return false;
    L21:
        if (hasTimestamp() == false) goto L26;
        if (getTimestamp() == r10.getTimestamp()) goto L26;
        return false;
    L26:
        if (hasCellUsedTraffic() == r10.hasCellUsedTraffic()) goto L29;
        return false;
    L29:
        if (hasCellUsedTraffic() == false) goto L34;
        if (getCellUsedTraffic() == r10.getCellUsedTraffic()) goto L34;
        return false;
    L34:
        if (hasCellRemainingTraffic() == r10.hasCellRemainingTraffic()) goto L37;
        return false;
    L37:
        if (hasCellRemainingTraffic() == false) goto L42;
        if (getCellRemainingTraffic() == r10.getCellRemainingTraffic()) goto L42;
        return false;
    L42:
        if (hasPackageName() == r10.hasPackageName()) goto L45;
        return false;
    L45:
        if (hasPackageName() == false) goto L50;
        if (getPackageName().equals(r10.getPackageName()) == true) goto L50;
        return false;
    L50:
        if (hasAppCategory() == r10.hasAppCategory()) goto L53;
        return false;
    L53:
        if (hasAppCategory() == false) goto L58;
        if (getAppCategory() == r10.getAppCategory()) goto L58;
        return false;
    L58:
        if (hasD7CellAppUsed() == r10.hasD7CellAppUsed()) goto L61;
        return false;
    L61:
        if (hasD7CellAppUsed() == false) goto L66;
        if (getD7CellAppUsed() == r10.getD7CellAppUsed()) goto L66;
        return false;
    L66:
        if (hasD7CellTotalUsed() == r10.hasD7CellTotalUsed()) goto L69;
        return false;
    L69:
        if (hasD7CellTotalUsed() == false) goto L74;
        if (getD7CellTotalUsed() == r10.getD7CellTotalUsed()) goto L74;
        return false;
    L74:
        if (hasD7TrafficAppUsed() == r10.hasD7TrafficAppUsed()) goto L77;
        return false;
    L77:
        if (hasD7TrafficAppUsed() == false) goto L82;
        if (getD7TrafficAppUsed() == r10.getD7TrafficAppUsed()) goto L82;
        return false;
    L82:
        if (hasAppSpeedRate() == r10.hasAppSpeedRate()) goto L85;
        return false;
    L85:
        if (hasAppSpeedRate() == false) goto L90;
        if (getAppSpeedRate() == r10.getAppSpeedRate()) goto L90;
        return false;
    L90:
        if (hasTotalSpeedRate() == r10.hasTotalSpeedRate()) goto L93;
        return false;
    L93:
        if (hasTotalSpeedRate() == false) goto L98;
        if (getTotalSpeedRate() == r10.getTotalSpeedRate()) goto L98;
        return false;
    L98:
        if (hasCurLocation() == r10.hasCurLocation()) goto L101;
        return false;
    L101:
        if (hasCurLocation() == false) goto L106;
        if (getCurLocation() == r10.getCurLocation()) goto L106;
        return false;
    L106:
        if (hasWifiL2TxTput() == r10.hasWifiL2TxTput()) goto L109;
        return false;
    L109:
        if (hasWifiL2TxTput() == false) goto L114;
        if (getWifiL2TxTput() == r10.getWifiL2TxTput()) goto L114;
        return false;
    L114:
        if (hasWifiL2RxTput() == r10.hasWifiL2RxTput()) goto L117;
        return false;
    L117:
        if (hasWifiL2RxTput() == false) goto L122;
        if (getWifiL2RxTput() == r10.getWifiL2RxTput()) goto L122;
        return false;
    L122:
        if (hasWifiBand() == r10.hasWifiBand()) goto L125;
        return false;
    L125:
        if (hasWifiBand() == false) goto L130;
        if (getWifiBand() == r10.getWifiBand()) goto L130;
        return false;
    L130:
        if (hasWifiRssi() == r10.hasWifiRssi()) goto L133;
        return false;
    L133:
        if (hasWifiRssi() == false) goto L138;
        if (getWifiRssi() == r10.getWifiRssi()) goto L138;
        return false;
    L138:
        if (hasWifiL4Rtt() == r10.hasWifiL4Rtt()) goto L141;
        return false;
    L141:
        if (hasWifiL4Rtt() == false) goto L146;
        if (getWifiL4Rtt() == r10.getWifiL4Rtt()) goto L146;
        return false;
    L146:
        if (hasWifiL4SendPkts() == r10.hasWifiL4SendPkts()) goto L149;
        return false;
    L149:
        if (hasWifiL4SendPkts() == false) goto L154;
        if (getWifiL4SendPkts() == r10.getWifiL4SendPkts()) goto L154;
        return false;
    L154:
        if (hasWifiL4RecvPkts() == r10.hasWifiL4RecvPkts()) goto L157;
        return false;
    L157:
        if (hasWifiL4RecvPkts() == false) goto L162;
        if (getWifiL4RecvPkts() == r10.getWifiL4RecvPkts()) goto L162;
        return false;
    L162:
        if (hasWifiL4RecvOooRate() == r10.hasWifiL4RecvOooRate()) goto L165;
        return false;
    L165:
        if (hasWifiL4RecvOooRate() == false) goto L170;
        if (getWifiL4RecvOooRate() == r10.getWifiL4RecvOooRate()) goto L170;
        return false;
    L170:
        if (hasWifiL4UnackPkts() == r10.hasWifiL4UnackPkts()) goto L173;
        return false;
    L173:
        if (hasWifiL4UnackPkts() == false) goto L178;
        if (getWifiL4UnackPkts() == r10.getWifiL4UnackPkts()) goto L178;
        return false;
    L178:
        if (hasWifiL4RetryRate() == r10.hasWifiL4RetryRate()) goto L181;
        return false;
    L181:
        if (hasWifiL4RetryRate() == false) goto L186;
        if (getWifiL4RetryRate() == r10.getWifiL4RetryRate()) goto L186;
        return false;
    L186:
        if (hasWifiL4SendSpeed() == r10.hasWifiL4SendSpeed()) goto L189;
        return false;
    L189:
        if (hasWifiL4SendSpeed() == false) goto L194;
        if (getWifiL4SendSpeed() == r10.getWifiL4SendSpeed()) goto L194;
        return false;
    L194:
        if (hasWifiL4RecvSpeed() == r10.hasWifiL4RecvSpeed()) goto L197;
        return false;
    L197:
        if (hasWifiL4RecvSpeed() == false) goto L202;
        if (getWifiL4RecvSpeed() == r10.getWifiL4RecvSpeed()) goto L202;
        return false;
    L202:
        if (hasCellL2State() == r10.hasCellL2State()) goto L205;
        return false;
    L205:
        if (hasCellL2State() == false) goto L210;
        if (getCellL2State() == r10.getCellL2State()) goto L210;
        return false;
    L210:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L212;
        return false;
    L212:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getAppCategory() {
        return this.appCategory_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getAppSpeedRate() {
        return this.appSpeedRate_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getCellL2State() {
        return this.cellL2State_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getCellRemainingTraffic() {
        return this.cellRemainingTraffic_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getCellUsedTraffic() {
        return this.cellUsedTraffic_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getCurLocation() {
        return this.curLocation_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getD7CellAppUsed() {
        return this.d7CellAppUsed_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getD7CellTotalUsed() {
        return this.d7CellTotalUsed_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getD7TrafficAppUsed() {
        return this.d7TrafficAppUsed_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public long getIndex() {
        return this.index_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public String getPackageName() {
        Object r8 = this.packageName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.packageName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public ByteString getPackageNameBytes() {
        Object r8 = this.packageName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.packageName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<FeatureDataPb> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt64Size(1, this.index_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt64Size(2, this.timestamp_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.cellUsedTraffic_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.cellRemainingTraffic_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.packageName_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.appCategory_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.d7CellAppUsed_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt32Size(8, this.d7CellTotalUsed_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.d7TrafficAppUsed_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.appSpeedRate_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.totalSpeedRate_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.curLocation_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.wifiL2TxTput_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.wifiL2RxTput_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeInt32Size(15, this.wifiBand_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeInt32Size(16, this.wifiRssi_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + CodedOutputStream.computeInt32Size(17, this.wifiL4Rtt_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + CodedOutputStream.computeInt32Size(18, this.wifiL4SendPkts_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L63;
        r10 = r10 + CodedOutputStream.computeInt32Size(19, this.wifiL4RecvPkts_);
    L63:
        if ((this.bitField0_ & 524288) == 0) goto L66;
        r10 = r10 + CodedOutputStream.computeInt32Size(20, this.wifiL4RecvOooRate_);
    L66:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L69;
        r10 = r10 + CodedOutputStream.computeInt32Size(21, this.wifiL4UnackPkts_);
    L69:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L72;
        r10 = r10 + CodedOutputStream.computeInt32Size(22, this.wifiL4RetryRate_);
    L72:
        if ((this.bitField0_ & 4194304) == 0) goto L75;
        r10 = r10 + CodedOutputStream.computeInt32Size(23, this.wifiL4SendSpeed_);
    L75:
        if ((this.bitField0_ & 8388608) == 0) goto L78;
        r10 = r10 + CodedOutputStream.computeInt32Size(24, this.wifiL4RecvSpeed_);
    L78:
        if ((this.bitField0_ & 16777216) == 0) goto L80;
        r10 = r10 + CodedOutputStream.computeInt32Size(25, this.cellL2State_);
    L80:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getTotalSpeedRate() {
        return this.totalSpeedRate_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiBand() {
        return this.wifiBand_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL2RxTput() {
        return this.wifiL2RxTput_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL2TxTput() {
        return this.wifiL2TxTput_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4RecvOooRate() {
        return this.wifiL4RecvOooRate_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4RecvPkts() {
        return this.wifiL4RecvPkts_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4RecvSpeed() {
        return this.wifiL4RecvSpeed_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4RetryRate() {
        return this.wifiL4RetryRate_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4Rtt() {
        return this.wifiL4Rtt_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4SendPkts() {
        return this.wifiL4SendPkts_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4SendSpeed() {
        return this.wifiL4SendSpeed_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiL4UnackPkts() {
        return this.wifiL4UnackPkts_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public int getWifiRssi() {
        return this.wifiRssi_;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasAppCategory() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasAppSpeedRate() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasCellL2State() {
        if ((this.bitField0_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasCellRemainingTraffic() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasCellUsedTraffic() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasCurLocation() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasD7CellAppUsed() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasD7CellTotalUsed() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasD7TrafficAppUsed() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasIndex() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasPackageName() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasTotalSpeedRate() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiBand() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL2RxTput() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL2TxTput() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4RecvOooRate() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4RecvPkts() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4RecvSpeed() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4RetryRate() {
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4Rtt() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4SendPkts() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4SendSpeed() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiL4UnackPkts() {
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.FeatureDataPbOrBuilder
    public boolean hasWifiRssi() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
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
        if (hasIndex() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(getIndex());
    L9:
        if (hasTimestamp() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + Internal.hashLong(getTimestamp());
    L12:
        if (hasCellUsedTraffic() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getCellUsedTraffic();
    L15:
        if (hasCellRemainingTraffic() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getCellRemainingTraffic();
    L18:
        if (hasPackageName() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getPackageName().hashCode();
    L21:
        if (hasAppCategory() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getAppCategory();
    L24:
        if (hasD7CellAppUsed() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getD7CellAppUsed();
    L27:
        if (hasD7CellTotalUsed() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getD7CellTotalUsed();
    L30:
        if (hasD7TrafficAppUsed() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getD7TrafficAppUsed();
    L33:
        if (hasAppSpeedRate() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + getAppSpeedRate();
    L36:
        if (hasTotalSpeedRate() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + getTotalSpeedRate();
    L39:
        if (hasCurLocation() == false) goto L42;
        r10 = b.a(r10, 37, 12, 53) + getCurLocation();
    L42:
        if (hasWifiL2TxTput() == false) goto L45;
        r10 = b.a(r10, 37, 13, 53) + getWifiL2TxTput();
    L45:
        if (hasWifiL2RxTput() == false) goto L48;
        r10 = b.a(r10, 37, 14, 53) + getWifiL2RxTput();
    L48:
        if (hasWifiBand() == false) goto L51;
        r10 = b.a(r10, 37, 15, 53) + getWifiBand();
    L51:
        if (hasWifiRssi() == false) goto L54;
        r10 = b.a(r10, 37, 16, 53) + getWifiRssi();
    L54:
        if (hasWifiL4Rtt() == false) goto L57;
        r10 = b.a(r10, 37, 17, 53) + getWifiL4Rtt();
    L57:
        if (hasWifiL4SendPkts() == false) goto L60;
        r10 = b.a(r10, 37, 18, 53) + getWifiL4SendPkts();
    L60:
        if (hasWifiL4RecvPkts() == false) goto L63;
        r10 = b.a(r10, 37, 19, 53) + getWifiL4RecvPkts();
    L63:
        if (hasWifiL4RecvOooRate() == false) goto L66;
        r10 = b.a(r10, 37, 20, 53) + getWifiL4RecvOooRate();
    L66:
        if (hasWifiL4UnackPkts() == false) goto L69;
        r10 = b.a(r10, 37, 21, 53) + getWifiL4UnackPkts();
    L69:
        if (hasWifiL4RetryRate() == false) goto L72;
        r10 = b.a(r10, 37, 22, 53) + getWifiL4RetryRate();
    L72:
        if (hasWifiL4SendSpeed() == false) goto L75;
        r10 = b.a(r10, 37, 23, 53) + getWifiL4SendSpeed();
    L75:
        if (hasWifiL4RecvSpeed() == false) goto L78;
        r10 = b.a(r10, 37, 24, 53) + getWifiL4RecvSpeed();
    L78:
        if (hasCellL2State() == false) goto L80;
        r10 = b.a(r10, 37, 25, 53) + getCellL2State();
    L80:
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
        return new FeatureDataPb();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt64(1, this.index_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt64(2, this.timestamp_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.cellUsedTraffic_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.cellRemainingTraffic_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.packageName_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.appCategory_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.d7CellAppUsed_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt32(8, this.d7CellTotalUsed_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.d7TrafficAppUsed_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.appSpeedRate_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.totalSpeedRate_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeInt32(12, this.curLocation_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeInt32(13, this.wifiL2TxTput_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeInt32(14, this.wifiL2RxTput_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeInt32(15, this.wifiBand_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r8.writeInt32(16, this.wifiRssi_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r8.writeInt32(17, this.wifiL4Rtt_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r8.writeInt32(18, this.wifiL4SendPkts_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        r8.writeInt32(19, this.wifiL4RecvPkts_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        r8.writeInt32(20, this.wifiL4RecvOooRate_);
    L63:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L66;
        r8.writeInt32(21, this.wifiL4UnackPkts_);
    L66:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L69;
        r8.writeInt32(22, this.wifiL4RetryRate_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r8.writeInt32(23, this.wifiL4SendSpeed_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L75;
        r8.writeInt32(24, this.wifiL4RecvSpeed_);
    L75:
        if ((this.bitField0_ & 16777216) == 0) goto L77;
        r8.writeInt32(25, this.cellL2State_);
    L77:
        getUnknownFields().writeTo(r8);
    }

    private FeatureDataPb(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.index_ = 0;
        this.timestamp_ = 0;
        this.cellUsedTraffic_ = 0;
        this.cellRemainingTraffic_ = 0;
        this.packageName_ = "";
        this.appCategory_ = 0;
        this.d7CellAppUsed_ = 0;
        this.d7CellTotalUsed_ = 0;
        this.d7TrafficAppUsed_ = 0;
        this.appSpeedRate_ = 0;
        this.totalSpeedRate_ = 0;
        this.curLocation_ = 0;
        this.wifiL2TxTput_ = 0;
        this.wifiL2RxTput_ = 0;
        this.wifiBand_ = 0;
        this.wifiRssi_ = 0;
        this.wifiL4Rtt_ = 0;
        this.wifiL4SendPkts_ = 0;
        this.wifiL4RecvPkts_ = 0;
        this.wifiL4RecvOooRate_ = 0;
        this.wifiL4UnackPkts_ = 0;
        this.wifiL4RetryRate_ = 0;
        this.wifiL4SendSpeed_ = 0;
        this.wifiL4RecvSpeed_ = 0;
        this.cellL2State_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(FeatureDataPb r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static FeatureDataPb parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (FeatureDataPb) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static FeatureDataPb parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_FeatureDataPb_fieldAccessorTable.ensureFieldAccessorsInitialized(FeatureDataPb.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ FeatureDataPb(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static FeatureDataPb parseFrom(CodedInputStream r8) {
        return (FeatureDataPb) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public FeatureDataPb getDefaultInstanceForType() {
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

    public static FeatureDataPb parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (FeatureDataPb) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static FeatureDataPb parseFrom(InputStream r8) {
        return (FeatureDataPb) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static FeatureDataPb parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (FeatureDataPb) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static FeatureDataPb parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static FeatureDataPb parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static FeatureDataPb parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static FeatureDataPb parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
