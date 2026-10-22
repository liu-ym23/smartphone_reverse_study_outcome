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
public final class NetworkQoE extends GeneratedMessageV3 implements NetworkQoEOrBuilder {
    public static final int CCA_BUSY_RATE_FIELD_NUMBER = 11;
    public static final int CHANNEL_BUSY_RATE_FIELD_NUMBER = 10;
    private static final NetworkQoE DEFAULT_INSTANCE = null;
    public static final int DEFAULT_NETWORK_FIELD_NUMBER = 4;
    public static final int FOREGROUND_APP_FIELD_NUMBER = 2;
    public static final int L2_QOE_STATE_GOOD_FIELD_NUMBER = 6;
    public static final int L4_QOE_STATE_GOOD_FIELD_NUMBER = 20;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 3;
    public static final int ON_TIME_RATE_FIELD_NUMBER = 9;

    @Deprecated
    public static final Parser<NetworkQoE> PARSER = null;
    public static final int PER_FIELD_NUMBER = 15;
    public static final int RECVOOOPERCENT_FIELD_NUMBER = 24;
    public static final int RECVPACKETS_FIELD_NUMBER = 23;
    public static final int RECVRATE_FIELD_NUMBER = 28;
    public static final int RETRANRATE_FIELD_NUMBER = 26;
    public static final int RTT_FIELD_NUMBER = 21;
    public static final int RX_LINK_SPEED_FIELD_NUMBER = 19;
    public static final int RX_MPDU_FIELD_NUMBER = 13;
    public static final int RX_SPEED_KBPS_FIELD_NUMBER = 17;
    public static final int RX_TPUT_FIELD_NUMBER = 8;
    public static final int SENDPACKETS_FIELD_NUMBER = 22;
    public static final int SENDRATE_FIELD_NUMBER = 27;
    public static final int STREAMNUM_FIELD_NUMBER = 29;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    public static final int TX_LINK_SPEED_FIELD_NUMBER = 18;
    public static final int TX_MPDU_FIELD_NUMBER = 12;
    public static final int TX_RETRIES_FIELD_NUMBER = 14;
    public static final int TX_SPEED_KBPS_FIELD_NUMBER = 16;
    public static final int TX_TPUT_FIELD_NUMBER = 7;
    public static final int UNACKED_FIELD_NUMBER = 25;
    public static final int VALID_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int ccaBusyRate_;
    private int channelBusyRate_;
    private boolean defaultNetwork_;
    private volatile Object foregroundApp_;
    private boolean l2QoeStateGood_;
    private boolean l4QoeStateGood_;
    private byte memoizedIsInitialized;
    private int networkType_;
    private int onTimeRate_;
    private int per_;
    private int recvOooPercent_;
    private int recvPackets_;
    private int recvRate_;
    private int retranRate_;
    private int rtt_;
    private int rxLinkSpeed_;
    private int rxMpdu_;
    private int rxSpeedKbps_;
    private int rxTput_;
    private int sendPackets_;
    private int sendRate_;
    private int streamNum_;
    private long timestamp_;
    private int txLinkSpeed_;
    private int txMpdu_;
    private int txRetries_;
    private int txSpeedKbps_;
    private int txTput_;
    private int unacked_;
    private boolean valid_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NetworkQoEOrBuilder {
        private int bitField0_;
        private int ccaBusyRate_;
        private int channelBusyRate_;
        private boolean defaultNetwork_;
        private Object foregroundApp_;
        private boolean l2QoeStateGood_;
        private boolean l4QoeStateGood_;
        private int networkType_;
        private int onTimeRate_;
        private int per_;
        private int recvOooPercent_;
        private int recvPackets_;
        private int recvRate_;
        private int retranRate_;
        private int rtt_;
        private int rxLinkSpeed_;
        private int rxMpdu_;
        private int rxSpeedKbps_;
        private int rxTput_;
        private int sendPackets_;
        private int sendRate_;
        private int streamNum_;
        private long timestamp_;
        private int txLinkSpeed_;
        private int txMpdu_;
        private int txRetries_;
        private int txSpeedKbps_;
        private int txTput_;
        private int unacked_;
        private boolean valid_;

        private Builder() {
            this.foregroundApp_ = "";
        }

        private void buildPartial0(NetworkQoE r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            NetworkQoE.access$302(r8, this.timestamp_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            NetworkQoE.access$402(r8, this.foregroundApp_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            NetworkQoE.access$502(r8, this.networkType_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            NetworkQoE.access$602(r8, this.defaultNetwork_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            NetworkQoE.access$702(r8, this.valid_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            NetworkQoE.access$802(r8, this.l2QoeStateGood_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            NetworkQoE.access$902(r8, this.txTput_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            NetworkQoE.access$1002(r8, this.rxTput_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            NetworkQoE.access$1102(r8, this.onTimeRate_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            NetworkQoE.access$1202(r8, this.channelBusyRate_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            NetworkQoE.access$1302(r8, this.ccaBusyRate_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            NetworkQoE.access$1402(r8, this.txMpdu_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            NetworkQoE.access$1502(r8, this.rxMpdu_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            NetworkQoE.access$1602(r8, this.txRetries_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            NetworkQoE.access$1702(r8, this.per_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            NetworkQoE.access$1802(r8, this.txSpeedKbps_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            NetworkQoE.access$1902(r8, this.rxSpeedKbps_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            NetworkQoE.access$2002(r8, this.txLinkSpeed_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            NetworkQoE.access$2102(r8, this.rxLinkSpeed_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            NetworkQoE.access$2202(r8, this.l4QoeStateGood_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            NetworkQoE.access$2302(r8, this.rtt_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            NetworkQoE.access$2402(r8, this.sendPackets_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            NetworkQoE.access$2502(r8, this.recvPackets_);
            r11 = r11 | 4194304;
        L73:
            if ((8388608 & r10) == 0) goto L76;
            NetworkQoE.access$2602(r8, this.recvOooPercent_);
            r11 = r11 | 8388608;
        L76:
            if ((16777216 & r10) == 0) goto L79;
            NetworkQoE.access$2702(r8, this.unacked_);
            r11 = r11 | 16777216;
        L79:
            if ((33554432 & r10) == 0) goto L82;
            NetworkQoE.access$2802(r8, this.retranRate_);
            r11 = r11 | 33554432;
        L82:
            if ((67108864 & r10) == 0) goto L85;
            NetworkQoE.access$2902(r8, this.sendRate_);
            r11 = r11 | 67108864;
        L85:
            if ((134217728 & r10) == 0) goto L88;
            NetworkQoE.access$3002(r8, this.recvRate_);
            r11 = r11 | 134217728;
        L88:
            if ((r10 & 268435456) == 0) goto L90;
            NetworkQoE.access$3102(r8, this.streamNum_);
            r11 = r11 | 268435456;
        L90:
            NetworkQoE.access$3276(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkQoE_descriptor;
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

        public Builder clearCcaBusyRate() {
            this.bitField0_ &= -1025;
            this.ccaBusyRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChannelBusyRate() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.channelBusyRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDefaultNetwork() {
            this.bitField0_ &= -9;
            this.defaultNetwork_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearForegroundApp() {
            this.foregroundApp_ = NetworkQoE.getDefaultInstance().getForegroundApp();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearL2QoeStateGood() {
            this.bitField0_ &= -33;
            this.l2QoeStateGood_ = false;
            onChanged();
            return this;
        }

        public Builder clearL4QoeStateGood() {
            this.bitField0_ &= -524289;
            this.l4QoeStateGood_ = false;
            onChanged();
            return this;
        }

        public Builder clearNetworkType() {
            this.bitField0_ &= -5;
            this.networkType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOnTimeRate() {
            this.bitField0_ &= -257;
            this.onTimeRate_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPer() {
            this.bitField0_ &= -16385;
            this.per_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRecvOooPercent() {
            this.bitField0_ &= -8388609;
            this.recvOooPercent_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRecvPackets() {
            this.bitField0_ &= -4194305;
            this.recvPackets_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRecvRate() {
            this.bitField0_ &= -134217729;
            this.recvRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRetranRate() {
            this.bitField0_ &= -33554433;
            this.retranRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRtt() {
            this.bitField0_ &= -1048577;
            this.rtt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxLinkSpeed() {
            this.bitField0_ &= -262145;
            this.rxLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxMpdu() {
            this.bitField0_ &= -4097;
            this.rxMpdu_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxSpeedKbps() {
            this.bitField0_ &= -65537;
            this.rxSpeedKbps_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxTput() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.rxTput_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSendPackets() {
            this.bitField0_ &= -2097153;
            this.sendPackets_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSendRate() {
            this.bitField0_ &= -67108865;
            this.sendRate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStreamNum() {
            this.bitField0_ &= -268435457;
            this.streamNum_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -2;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxLinkSpeed() {
            this.bitField0_ &= -131073;
            this.txLinkSpeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxMpdu() {
            this.bitField0_ &= -2049;
            this.txMpdu_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRetries() {
            this.bitField0_ &= -8193;
            this.txRetries_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxSpeedKbps() {
            this.bitField0_ &= -32769;
            this.txSpeedKbps_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxTput() {
            this.bitField0_ &= -65;
            this.txTput_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUnacked() {
            this.bitField0_ &= -16777217;
            this.unacked_ = 0;
            onChanged();
            return this;
        }

        public Builder clearValid() {
            this.bitField0_ &= -17;
            this.valid_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getCcaBusyRate() {
            return this.ccaBusyRate_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getChannelBusyRate() {
            return this.channelBusyRate_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean getDefaultNetwork() {
            return this.defaultNetwork_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkQoE_descriptor;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public String getForegroundApp() {
            Object r8 = this.foregroundApp_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.foregroundApp_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public ByteString getForegroundAppBytes() {
            Object r8 = this.foregroundApp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.foregroundApp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean getL2QoeStateGood() {
            return this.l2QoeStateGood_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean getL4QoeStateGood() {
            return this.l4QoeStateGood_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getNetworkType() {
            return this.networkType_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getOnTimeRate() {
            return this.onTimeRate_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getPer() {
            return this.per_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRecvOooPercent() {
            return this.recvOooPercent_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRecvPackets() {
            return this.recvPackets_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRecvRate() {
            return this.recvRate_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRetranRate() {
            return this.retranRate_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRtt() {
            return this.rtt_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRxLinkSpeed() {
            return this.rxLinkSpeed_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRxMpdu() {
            return this.rxMpdu_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRxSpeedKbps() {
            return this.rxSpeedKbps_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getRxTput() {
            return this.rxTput_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getSendPackets() {
            return this.sendPackets_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getSendRate() {
            return this.sendRate_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getStreamNum() {
            return this.streamNum_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getTxLinkSpeed() {
            return this.txLinkSpeed_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getTxMpdu() {
            return this.txMpdu_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getTxRetries() {
            return this.txRetries_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getTxSpeedKbps() {
            return this.txSpeedKbps_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getTxTput() {
            return this.txTput_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public int getUnacked() {
            return this.unacked_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean getValid() {
            return this.valid_;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasCcaBusyRate() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasChannelBusyRate() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasDefaultNetwork() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasForegroundApp() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasL2QoeStateGood() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasL4QoeStateGood() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasNetworkType() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasOnTimeRate() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasPer() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRecvOooPercent() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRecvPackets() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRecvRate() {
            if ((this.bitField0_ & 134217728) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRetranRate() {
            if ((this.bitField0_ & 33554432) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRtt() {
            if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRxLinkSpeed() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRxMpdu() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRxSpeedKbps() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasRxTput() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasSendPackets() {
            if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasSendRate() {
            if ((this.bitField0_ & 67108864) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasStreamNum() {
            if ((this.bitField0_ & 268435456) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasTxLinkSpeed() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasTxMpdu() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasTxRetries() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasTxSpeedKbps() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasTxTput() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasUnacked() {
            if ((this.bitField0_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.NetworkQoEOrBuilder
        public boolean hasValid() {
            if ((this.bitField0_ & 16) == 0) goto L5;
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

        public Builder setCcaBusyRate(int r8) {
            this.ccaBusyRate_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setChannelBusyRate(int r8) {
            this.channelBusyRate_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setDefaultNetwork(boolean r8) {
            this.defaultNetwork_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setForegroundApp(String r8) {
            if (r8 == null) goto L6;
            this.foregroundApp_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setForegroundAppBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.foregroundApp_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setL2QoeStateGood(boolean r8) {
            this.l2QoeStateGood_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setL4QoeStateGood(boolean r8) {
            this.l4QoeStateGood_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setNetworkType(int r8) {
            this.networkType_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setOnTimeRate(int r8) {
            this.onTimeRate_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setPer(int r8) {
            this.per_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setRecvOooPercent(int r8) {
            this.recvOooPercent_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        }

        public Builder setRecvPackets(int r8) {
            this.recvPackets_ = r8;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setRecvRate(int r8) {
            this.recvRate_ = r8;
            this.bitField0_ |= 134217728;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRetranRate(int r8) {
            this.retranRate_ = r8;
            this.bitField0_ |= 33554432;
            onChanged();
            return this;
        }

        public Builder setRtt(int r8) {
            this.rtt_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        }

        public Builder setRxLinkSpeed(int r8) {
            this.rxLinkSpeed_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setRxMpdu(int r8) {
            this.rxMpdu_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setRxSpeedKbps(int r8) {
            this.rxSpeedKbps_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setRxTput(int r8) {
            this.rxTput_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setSendPackets(int r8) {
            this.sendPackets_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        }

        public Builder setSendRate(int r8) {
            this.sendRate_ = r8;
            this.bitField0_ |= 67108864;
            onChanged();
            return this;
        }

        public Builder setStreamNum(int r8) {
            this.streamNum_ = r8;
            this.bitField0_ |= 268435456;
            onChanged();
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTxLinkSpeed(int r8) {
            this.txLinkSpeed_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setTxMpdu(int r8) {
            this.txMpdu_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setTxRetries(int r8) {
            this.txRetries_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setTxSpeedKbps(int r8) {
            this.txSpeedKbps_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setTxTput(int r8) {
            this.txTput_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setUnacked(int r8) {
            this.unacked_ = r8;
            this.bitField0_ |= 16777216;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setValid(boolean r8) {
            this.valid_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.foregroundApp_ = "";
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkQoE_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkQoE.class, Builder.class);
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
        public NetworkQoE build() {
            NetworkQoE r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkQoE buildPartial() {
            NetworkQoE r8 = new NetworkQoE(this, null);
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
        public NetworkQoE getDefaultInstanceForType() {
            return NetworkQoE.getDefaultInstance();
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
            this.timestamp_ = 0;
            this.foregroundApp_ = "";
            this.networkType_ = 0;
            this.defaultNetwork_ = false;
            this.valid_ = false;
            this.l2QoeStateGood_ = false;
            this.txTput_ = 0;
            this.rxTput_ = 0;
            this.onTimeRate_ = 0;
            this.channelBusyRate_ = 0;
            this.ccaBusyRate_ = 0;
            this.txMpdu_ = 0;
            this.rxMpdu_ = 0;
            this.txRetries_ = 0;
            this.per_ = 0;
            this.txSpeedKbps_ = 0;
            this.rxSpeedKbps_ = 0;
            this.txLinkSpeed_ = 0;
            this.rxLinkSpeed_ = 0;
            this.l4QoeStateGood_ = false;
            this.rtt_ = 0;
            this.sendPackets_ = 0;
            this.recvPackets_ = 0;
            this.recvOooPercent_ = 0;
            this.unacked_ = 0;
            this.retranRate_ = 0;
            this.sendRate_ = 0;
            this.recvRate_ = 0;
            this.streamNum_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L51;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L48;
            int r12 = r8.readTag();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            switch(r12) {
                case 0: goto L38;
                case 8: goto L36;
                case 18: goto L35;
                case 24: goto L34;
                case 32: goto L33;
                case 40: goto L32;
                case 48: goto L31;
                case 56: goto L30;
                case 64: goto L29;
                case 72: goto L28;
                case 80: goto L27;
                case 88: goto L26;
                case 96: goto L25;
                case 104: goto L24;
                case 112: goto L23;
                case 120: goto L22;
                case 128: goto L21;
                case 136: goto L20;
                case 144: goto L19;
                case 152: goto L18;
                case 160: goto L17;
                case 168: goto L16;
                case 176: goto L15;
                case 184: goto L14;
                case 192: goto L13;
                case 200: goto L12;
                case 208: goto L11;
                case 216: goto L10;
                case 224: goto L9;
                case 232: goto L8;
                default: goto L39;
            };     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
        L8:
            this.streamNum_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 268435456;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L9:
            this.recvRate_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 134217728;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L10:
            this.sendRate_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 67108864;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L11:
            this.retranRate_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 33554432;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L12:
            this.unacked_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 16777216;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L13:
            this.recvOooPercent_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 8388608;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L14:
            this.recvPackets_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 4194304;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L15:
            this.sendPackets_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L16:
            this.rtt_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L17:
            this.l4QoeStateGood_ = r8.readBool();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 524288;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L18:
            this.rxLinkSpeed_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 262144;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L19:
            this.txLinkSpeed_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 131072;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L20:
            this.rxSpeedKbps_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 65536;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L21:
            this.txSpeedKbps_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 32768;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L22:
            this.per_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 16384;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L23:
            this.txRetries_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 8192;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L24:
            this.rxMpdu_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 4096;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L25:
            this.txMpdu_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 2048;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L26:
            this.ccaBusyRate_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 1024;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L27:
            this.channelBusyRate_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 512;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L28:
            this.onTimeRate_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 256;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L29:
            this.rxTput_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 128;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L30:
            this.txTput_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 64;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L31:
            this.l2QoeStateGood_ = r8.readBool();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 32;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L32:
            this.valid_ = r8.readBool();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 16;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L33:
            this.defaultNetwork_ = r8.readBool();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 8;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L34:
            this.networkType_ = r8.readInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 4;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L35:
            this.foregroundApp_ = r8.readBytes();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 2;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L4
        L36:
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 1;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
        L38:
            r11 = true;
            goto L4
        L39:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L43:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            onChanged();
            throw th;
        L48:
            onChanged();
            return this;
        L51:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof NetworkQoE) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NetworkQoE) r8);
        }

        public Builder mergeFrom(NetworkQoE r8) {
            if (r8 != NetworkQoE.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasTimestamp() == false) goto L9;
            setTimestamp(r8.getTimestamp());
        L9:
            if (r8.hasForegroundApp() == false) goto L12;
            this.foregroundApp_ = NetworkQoE.access$400(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasNetworkType() == false) goto L15;
            setNetworkType(r8.getNetworkType());
        L15:
            if (r8.hasDefaultNetwork() == false) goto L18;
            setDefaultNetwork(r8.getDefaultNetwork());
        L18:
            if (r8.hasValid() == false) goto L21;
            setValid(r8.getValid());
        L21:
            if (r8.hasL2QoeStateGood() == false) goto L24;
            setL2QoeStateGood(r8.getL2QoeStateGood());
        L24:
            if (r8.hasTxTput() == false) goto L27;
            setTxTput(r8.getTxTput());
        L27:
            if (r8.hasRxTput() == false) goto L30;
            setRxTput(r8.getRxTput());
        L30:
            if (r8.hasOnTimeRate() == false) goto L33;
            setOnTimeRate(r8.getOnTimeRate());
        L33:
            if (r8.hasChannelBusyRate() == false) goto L36;
            setChannelBusyRate(r8.getChannelBusyRate());
        L36:
            if (r8.hasCcaBusyRate() == false) goto L39;
            setCcaBusyRate(r8.getCcaBusyRate());
        L39:
            if (r8.hasTxMpdu() == false) goto L42;
            setTxMpdu(r8.getTxMpdu());
        L42:
            if (r8.hasRxMpdu() == false) goto L45;
            setRxMpdu(r8.getRxMpdu());
        L45:
            if (r8.hasTxRetries() == false) goto L48;
            setTxRetries(r8.getTxRetries());
        L48:
            if (r8.hasPer() == false) goto L51;
            setPer(r8.getPer());
        L51:
            if (r8.hasTxSpeedKbps() == false) goto L54;
            setTxSpeedKbps(r8.getTxSpeedKbps());
        L54:
            if (r8.hasRxSpeedKbps() == false) goto L57;
            setRxSpeedKbps(r8.getRxSpeedKbps());
        L57:
            if (r8.hasTxLinkSpeed() == false) goto L60;
            setTxLinkSpeed(r8.getTxLinkSpeed());
        L60:
            if (r8.hasRxLinkSpeed() == false) goto L63;
            setRxLinkSpeed(r8.getRxLinkSpeed());
        L63:
            if (r8.hasL4QoeStateGood() == false) goto L66;
            setL4QoeStateGood(r8.getL4QoeStateGood());
        L66:
            if (r8.hasRtt() == false) goto L69;
            setRtt(r8.getRtt());
        L69:
            if (r8.hasSendPackets() == false) goto L72;
            setSendPackets(r8.getSendPackets());
        L72:
            if (r8.hasRecvPackets() == false) goto L75;
            setRecvPackets(r8.getRecvPackets());
        L75:
            if (r8.hasRecvOooPercent() == false) goto L78;
            setRecvOooPercent(r8.getRecvOooPercent());
        L78:
            if (r8.hasUnacked() == false) goto L81;
            setUnacked(r8.getUnacked());
        L81:
            if (r8.hasRetranRate() == false) goto L84;
            setRetranRate(r8.getRetranRate());
        L84:
            if (r8.hasSendRate() == false) goto L87;
            setSendRate(r8.getSendRate());
        L87:
            if (r8.hasRecvRate() == false) goto L90;
            setRecvRate(r8.getRecvRate());
        L90:
            if (r8.hasStreamNum() == false) goto L92;
            setStreamNum(r8.getStreamNum());
        L92:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new NetworkQoE();
        PARSER = new AnonymousClass1();
    }

    private NetworkQoE() {
        this.timestamp_ = 0;
        this.foregroundApp_ = "";
        this.networkType_ = 0;
        this.defaultNetwork_ = false;
        this.valid_ = false;
        this.l2QoeStateGood_ = false;
        this.txTput_ = 0;
        this.rxTput_ = 0;
        this.onTimeRate_ = 0;
        this.channelBusyRate_ = 0;
        this.ccaBusyRate_ = 0;
        this.txMpdu_ = 0;
        this.rxMpdu_ = 0;
        this.txRetries_ = 0;
        this.per_ = 0;
        this.txSpeedKbps_ = 0;
        this.rxSpeedKbps_ = 0;
        this.txLinkSpeed_ = 0;
        this.rxLinkSpeed_ = 0;
        this.l4QoeStateGood_ = false;
        this.rtt_ = 0;
        this.sendPackets_ = 0;
        this.recvPackets_ = 0;
        this.recvOooPercent_ = 0;
        this.unacked_ = 0;
        this.retranRate_ = 0;
        this.sendRate_ = 0;
        this.recvRate_ = 0;
        this.streamNum_ = 0;
        this.memoizedIsInitialized = -1;
        this.foregroundApp_ = "";
    }

    public static /* synthetic */ int access$1002(NetworkQoE r8, int r10) {
        r8.rxTput_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(NetworkQoE r8, int r10) {
        r8.onTimeRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(NetworkQoE r8, int r10) {
        r8.channelBusyRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(NetworkQoE r8, int r10) {
        r8.ccaBusyRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(NetworkQoE r8, int r10) {
        r8.txMpdu_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(NetworkQoE r8, int r10) {
        r8.rxMpdu_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(NetworkQoE r8, int r10) {
        r8.txRetries_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1702(NetworkQoE r8, int r10) {
        r8.per_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(NetworkQoE r8, int r10) {
        r8.txSpeedKbps_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1902(NetworkQoE r8, int r10) {
        r8.rxSpeedKbps_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2002(NetworkQoE r8, int r10) {
        r8.txLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2102(NetworkQoE r8, int r10) {
        r8.rxLinkSpeed_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$2202(NetworkQoE r8, boolean r10) {
        r8.l4QoeStateGood_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2302(NetworkQoE r8, int r10) {
        r8.rtt_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2402(NetworkQoE r8, int r10) {
        r8.sendPackets_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2502(NetworkQoE r8, int r10) {
        r8.recvPackets_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2602(NetworkQoE r8, int r10) {
        r8.recvOooPercent_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2702(NetworkQoE r8, int r10) {
        r8.unacked_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2802(NetworkQoE r8, int r10) {
        r8.retranRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2902(NetworkQoE r8, int r10) {
        r8.sendRate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3002(NetworkQoE r8, int r10) {
        r8.recvRate_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$302(NetworkQoE r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3102(NetworkQoE r8, int r10) {
        r8.streamNum_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3276(NetworkQoE r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$400(NetworkQoE r8) {
        return r8.foregroundApp_;
    }

    public static /* synthetic */ Object access$402(NetworkQoE r8, Object r10) {
        r8.foregroundApp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(NetworkQoE r8, int r10) {
        r8.networkType_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$602(NetworkQoE r8, boolean r10) {
        r8.defaultNetwork_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$702(NetworkQoE r8, boolean r10) {
        r8.valid_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$802(NetworkQoE r8, boolean r10) {
        r8.l2QoeStateGood_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(NetworkQoE r8, int r10) {
        r8.txTput_ = r10;
        return r10;
    }

    public static NetworkQoE getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkQoE_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static NetworkQoE parseDelimitedFrom(InputStream r8) {
        return (NetworkQoE) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static NetworkQoE parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<NetworkQoE> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NetworkQoE) == false) goto L8;
        NetworkQoE r10 = (NetworkQoE) r8;
        if (hasTimestamp() == r10.hasTimestamp()) goto L13;
        return false;
    L13:
        if (hasTimestamp() == false) goto L18;
        if (getTimestamp() == r10.getTimestamp()) goto L18;
        return false;
    L18:
        if (hasForegroundApp() == r10.hasForegroundApp()) goto L21;
        return false;
    L21:
        if (hasForegroundApp() == false) goto L26;
        if (getForegroundApp().equals(r10.getForegroundApp()) == true) goto L26;
        return false;
    L26:
        if (hasNetworkType() == r10.hasNetworkType()) goto L29;
        return false;
    L29:
        if (hasNetworkType() == false) goto L34;
        if (getNetworkType() == r10.getNetworkType()) goto L34;
        return false;
    L34:
        if (hasDefaultNetwork() == r10.hasDefaultNetwork()) goto L37;
        return false;
    L37:
        if (hasDefaultNetwork() == false) goto L42;
        if (getDefaultNetwork() == r10.getDefaultNetwork()) goto L42;
        return false;
    L42:
        if (hasValid() == r10.hasValid()) goto L45;
        return false;
    L45:
        if (hasValid() == false) goto L50;
        if (getValid() == r10.getValid()) goto L50;
        return false;
    L50:
        if (hasL2QoeStateGood() == r10.hasL2QoeStateGood()) goto L53;
        return false;
    L53:
        if (hasL2QoeStateGood() == false) goto L58;
        if (getL2QoeStateGood() == r10.getL2QoeStateGood()) goto L58;
        return false;
    L58:
        if (hasTxTput() == r10.hasTxTput()) goto L61;
        return false;
    L61:
        if (hasTxTput() == false) goto L66;
        if (getTxTput() == r10.getTxTput()) goto L66;
        return false;
    L66:
        if (hasRxTput() == r10.hasRxTput()) goto L69;
        return false;
    L69:
        if (hasRxTput() == false) goto L74;
        if (getRxTput() == r10.getRxTput()) goto L74;
        return false;
    L74:
        if (hasOnTimeRate() == r10.hasOnTimeRate()) goto L77;
        return false;
    L77:
        if (hasOnTimeRate() == false) goto L82;
        if (getOnTimeRate() == r10.getOnTimeRate()) goto L82;
        return false;
    L82:
        if (hasChannelBusyRate() == r10.hasChannelBusyRate()) goto L85;
        return false;
    L85:
        if (hasChannelBusyRate() == false) goto L90;
        if (getChannelBusyRate() == r10.getChannelBusyRate()) goto L90;
        return false;
    L90:
        if (hasCcaBusyRate() == r10.hasCcaBusyRate()) goto L93;
        return false;
    L93:
        if (hasCcaBusyRate() == false) goto L98;
        if (getCcaBusyRate() == r10.getCcaBusyRate()) goto L98;
        return false;
    L98:
        if (hasTxMpdu() == r10.hasTxMpdu()) goto L101;
        return false;
    L101:
        if (hasTxMpdu() == false) goto L106;
        if (getTxMpdu() == r10.getTxMpdu()) goto L106;
        return false;
    L106:
        if (hasRxMpdu() == r10.hasRxMpdu()) goto L109;
        return false;
    L109:
        if (hasRxMpdu() == false) goto L114;
        if (getRxMpdu() == r10.getRxMpdu()) goto L114;
        return false;
    L114:
        if (hasTxRetries() == r10.hasTxRetries()) goto L117;
        return false;
    L117:
        if (hasTxRetries() == false) goto L122;
        if (getTxRetries() == r10.getTxRetries()) goto L122;
        return false;
    L122:
        if (hasPer() == r10.hasPer()) goto L125;
        return false;
    L125:
        if (hasPer() == false) goto L130;
        if (getPer() == r10.getPer()) goto L130;
        return false;
    L130:
        if (hasTxSpeedKbps() == r10.hasTxSpeedKbps()) goto L133;
        return false;
    L133:
        if (hasTxSpeedKbps() == false) goto L138;
        if (getTxSpeedKbps() == r10.getTxSpeedKbps()) goto L138;
        return false;
    L138:
        if (hasRxSpeedKbps() == r10.hasRxSpeedKbps()) goto L141;
        return false;
    L141:
        if (hasRxSpeedKbps() == false) goto L146;
        if (getRxSpeedKbps() == r10.getRxSpeedKbps()) goto L146;
        return false;
    L146:
        if (hasTxLinkSpeed() == r10.hasTxLinkSpeed()) goto L149;
        return false;
    L149:
        if (hasTxLinkSpeed() == false) goto L154;
        if (getTxLinkSpeed() == r10.getTxLinkSpeed()) goto L154;
        return false;
    L154:
        if (hasRxLinkSpeed() == r10.hasRxLinkSpeed()) goto L157;
        return false;
    L157:
        if (hasRxLinkSpeed() == false) goto L162;
        if (getRxLinkSpeed() == r10.getRxLinkSpeed()) goto L162;
        return false;
    L162:
        if (hasL4QoeStateGood() == r10.hasL4QoeStateGood()) goto L165;
        return false;
    L165:
        if (hasL4QoeStateGood() == false) goto L170;
        if (getL4QoeStateGood() == r10.getL4QoeStateGood()) goto L170;
        return false;
    L170:
        if (hasRtt() == r10.hasRtt()) goto L173;
        return false;
    L173:
        if (hasRtt() == false) goto L178;
        if (getRtt() == r10.getRtt()) goto L178;
        return false;
    L178:
        if (hasSendPackets() == r10.hasSendPackets()) goto L181;
        return false;
    L181:
        if (hasSendPackets() == false) goto L186;
        if (getSendPackets() == r10.getSendPackets()) goto L186;
        return false;
    L186:
        if (hasRecvPackets() == r10.hasRecvPackets()) goto L189;
        return false;
    L189:
        if (hasRecvPackets() == false) goto L194;
        if (getRecvPackets() == r10.getRecvPackets()) goto L194;
        return false;
    L194:
        if (hasRecvOooPercent() == r10.hasRecvOooPercent()) goto L197;
        return false;
    L197:
        if (hasRecvOooPercent() == false) goto L202;
        if (getRecvOooPercent() == r10.getRecvOooPercent()) goto L202;
        return false;
    L202:
        if (hasUnacked() == r10.hasUnacked()) goto L205;
        return false;
    L205:
        if (hasUnacked() == false) goto L210;
        if (getUnacked() == r10.getUnacked()) goto L210;
        return false;
    L210:
        if (hasRetranRate() == r10.hasRetranRate()) goto L213;
        return false;
    L213:
        if (hasRetranRate() == false) goto L218;
        if (getRetranRate() == r10.getRetranRate()) goto L218;
        return false;
    L218:
        if (hasSendRate() == r10.hasSendRate()) goto L221;
        return false;
    L221:
        if (hasSendRate() == false) goto L226;
        if (getSendRate() == r10.getSendRate()) goto L226;
        return false;
    L226:
        if (hasRecvRate() == r10.hasRecvRate()) goto L229;
        return false;
    L229:
        if (hasRecvRate() == false) goto L234;
        if (getRecvRate() == r10.getRecvRate()) goto L234;
        return false;
    L234:
        if (hasStreamNum() == r10.hasStreamNum()) goto L237;
        return false;
    L237:
        if (hasStreamNum() == false) goto L242;
        if (getStreamNum() == r10.getStreamNum()) goto L242;
        return false;
    L242:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L244;
        return false;
    L244:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getCcaBusyRate() {
        return this.ccaBusyRate_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getChannelBusyRate() {
        return this.channelBusyRate_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean getDefaultNetwork() {
        return this.defaultNetwork_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public String getForegroundApp() {
        Object r8 = this.foregroundApp_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.foregroundApp_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public ByteString getForegroundAppBytes() {
        Object r8 = this.foregroundApp_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.foregroundApp_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean getL2QoeStateGood() {
        return this.l2QoeStateGood_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean getL4QoeStateGood() {
        return this.l4QoeStateGood_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getNetworkType() {
        return this.networkType_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getOnTimeRate() {
        return this.onTimeRate_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NetworkQoE> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getPer() {
        return this.per_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRecvOooPercent() {
        return this.recvOooPercent_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRecvPackets() {
        return this.recvPackets_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRecvRate() {
        return this.recvRate_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRetranRate() {
        return this.retranRate_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRtt() {
        return this.rtt_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRxLinkSpeed() {
        return this.rxLinkSpeed_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRxMpdu() {
        return this.rxMpdu_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRxSpeedKbps() {
        return this.rxSpeedKbps_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getRxTput() {
        return this.rxTput_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getSendPackets() {
        return this.sendPackets_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getSendRate() {
        return this.sendRate_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt64Size(1, this.timestamp_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + GeneratedMessage.computeStringSize(2, this.foregroundApp_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.networkType_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeBoolSize(4, this.defaultNetwork_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeBoolSize(5, this.valid_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeBoolSize(6, this.l2QoeStateGood_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.txTput_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt32Size(8, this.rxTput_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.onTimeRate_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.channelBusyRate_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.ccaBusyRate_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.txMpdu_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.rxMpdu_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.txRetries_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeInt32Size(15, this.per_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeInt32Size(16, this.txSpeedKbps_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + CodedOutputStream.computeInt32Size(17, this.rxSpeedKbps_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + CodedOutputStream.computeInt32Size(18, this.txLinkSpeed_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L63;
        r10 = r10 + CodedOutputStream.computeInt32Size(19, this.rxLinkSpeed_);
    L63:
        if ((this.bitField0_ & 524288) == 0) goto L66;
        r10 = r10 + CodedOutputStream.computeBoolSize(20, this.l4QoeStateGood_);
    L66:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L69;
        r10 = r10 + CodedOutputStream.computeInt32Size(21, this.rtt_);
    L69:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L72;
        r10 = r10 + CodedOutputStream.computeInt32Size(22, this.sendPackets_);
    L72:
        if ((this.bitField0_ & 4194304) == 0) goto L75;
        r10 = r10 + CodedOutputStream.computeInt32Size(23, this.recvPackets_);
    L75:
        if ((this.bitField0_ & 8388608) == 0) goto L78;
        r10 = r10 + CodedOutputStream.computeInt32Size(24, this.recvOooPercent_);
    L78:
        if ((this.bitField0_ & 16777216) == 0) goto L81;
        r10 = r10 + CodedOutputStream.computeInt32Size(25, this.unacked_);
    L81:
        if ((this.bitField0_ & 33554432) == 0) goto L84;
        r10 = r10 + CodedOutputStream.computeInt32Size(26, this.retranRate_);
    L84:
        if ((this.bitField0_ & 67108864) == 0) goto L87;
        r10 = r10 + CodedOutputStream.computeInt32Size(27, this.sendRate_);
    L87:
        if ((this.bitField0_ & 134217728) == 0) goto L90;
        r10 = r10 + CodedOutputStream.computeInt32Size(28, this.recvRate_);
    L90:
        if ((this.bitField0_ & 268435456) == 0) goto L92;
        r10 = r10 + CodedOutputStream.computeInt32Size(29, this.streamNum_);
    L92:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getStreamNum() {
        return this.streamNum_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getTxLinkSpeed() {
        return this.txLinkSpeed_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getTxMpdu() {
        return this.txMpdu_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getTxRetries() {
        return this.txRetries_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getTxSpeedKbps() {
        return this.txSpeedKbps_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getTxTput() {
        return this.txTput_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public int getUnacked() {
        return this.unacked_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean getValid() {
        return this.valid_;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasCcaBusyRate() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasChannelBusyRate() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasDefaultNetwork() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasForegroundApp() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasL2QoeStateGood() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasL4QoeStateGood() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasNetworkType() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasOnTimeRate() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasPer() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRecvOooPercent() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRecvPackets() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRecvRate() {
        if ((this.bitField0_ & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRetranRate() {
        if ((this.bitField0_ & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRtt() {
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRxLinkSpeed() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRxMpdu() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRxSpeedKbps() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasRxTput() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasSendPackets() {
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasSendRate() {
        if ((this.bitField0_ & 67108864) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasStreamNum() {
        if ((this.bitField0_ & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasTxLinkSpeed() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasTxMpdu() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasTxRetries() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasTxSpeedKbps() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasTxTput() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasUnacked() {
        if ((this.bitField0_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.NetworkQoEOrBuilder
    public boolean hasValid() {
        if ((this.bitField0_ & 16) == 0) goto L5;
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
        if (hasTimestamp() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(getTimestamp());
    L9:
        if (hasForegroundApp() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getForegroundApp().hashCode();
    L12:
        if (hasNetworkType() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getNetworkType();
    L15:
        if (hasDefaultNetwork() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Internal.hashBoolean(getDefaultNetwork());
    L18:
        if (hasValid() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + Internal.hashBoolean(getValid());
    L21:
        if (hasL2QoeStateGood() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + Internal.hashBoolean(getL2QoeStateGood());
    L24:
        if (hasTxTput() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getTxTput();
    L27:
        if (hasRxTput() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getRxTput();
    L30:
        if (hasOnTimeRate() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getOnTimeRate();
    L33:
        if (hasChannelBusyRate() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + getChannelBusyRate();
    L36:
        if (hasCcaBusyRate() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + getCcaBusyRate();
    L39:
        if (hasTxMpdu() == false) goto L42;
        r10 = b.a(r10, 37, 12, 53) + getTxMpdu();
    L42:
        if (hasRxMpdu() == false) goto L45;
        r10 = b.a(r10, 37, 13, 53) + getRxMpdu();
    L45:
        if (hasTxRetries() == false) goto L48;
        r10 = b.a(r10, 37, 14, 53) + getTxRetries();
    L48:
        if (hasPer() == false) goto L51;
        r10 = b.a(r10, 37, 15, 53) + getPer();
    L51:
        if (hasTxSpeedKbps() == false) goto L54;
        r10 = b.a(r10, 37, 16, 53) + getTxSpeedKbps();
    L54:
        if (hasRxSpeedKbps() == false) goto L57;
        r10 = b.a(r10, 37, 17, 53) + getRxSpeedKbps();
    L57:
        if (hasTxLinkSpeed() == false) goto L60;
        r10 = b.a(r10, 37, 18, 53) + getTxLinkSpeed();
    L60:
        if (hasRxLinkSpeed() == false) goto L63;
        r10 = b.a(r10, 37, 19, 53) + getRxLinkSpeed();
    L63:
        if (hasL4QoeStateGood() == false) goto L66;
        r10 = b.a(r10, 37, 20, 53) + Internal.hashBoolean(getL4QoeStateGood());
    L66:
        if (hasRtt() == false) goto L69;
        r10 = b.a(r10, 37, 21, 53) + getRtt();
    L69:
        if (hasSendPackets() == false) goto L72;
        r10 = b.a(r10, 37, 22, 53) + getSendPackets();
    L72:
        if (hasRecvPackets() == false) goto L75;
        r10 = b.a(r10, 37, 23, 53) + getRecvPackets();
    L75:
        if (hasRecvOooPercent() == false) goto L78;
        r10 = b.a(r10, 37, 24, 53) + getRecvOooPercent();
    L78:
        if (hasUnacked() == false) goto L81;
        r10 = b.a(r10, 37, 25, 53) + getUnacked();
    L81:
        if (hasRetranRate() == false) goto L84;
        r10 = b.a(r10, 37, 26, 53) + getRetranRate();
    L84:
        if (hasSendRate() == false) goto L87;
        r10 = b.a(r10, 37, 27, 53) + getSendRate();
    L87:
        if (hasRecvRate() == false) goto L90;
        r10 = b.a(r10, 37, 28, 53) + getRecvRate();
    L90:
        if (hasStreamNum() == false) goto L92;
        r10 = b.a(r10, 37, 29, 53) + getStreamNum();
    L92:
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
        return new NetworkQoE();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt64(1, this.timestamp_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.foregroundApp_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.networkType_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeBool(4, this.defaultNetwork_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeBool(5, this.valid_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeBool(6, this.l2QoeStateGood_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.txTput_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt32(8, this.rxTput_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.onTimeRate_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.channelBusyRate_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.ccaBusyRate_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeInt32(12, this.txMpdu_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeInt32(13, this.rxMpdu_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeInt32(14, this.txRetries_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeInt32(15, this.per_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r8.writeInt32(16, this.txSpeedKbps_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r8.writeInt32(17, this.rxSpeedKbps_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r8.writeInt32(18, this.txLinkSpeed_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        r8.writeInt32(19, this.rxLinkSpeed_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        r8.writeBool(20, this.l4QoeStateGood_);
    L63:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L66;
        r8.writeInt32(21, this.rtt_);
    L66:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L69;
        r8.writeInt32(22, this.sendPackets_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r8.writeInt32(23, this.recvPackets_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L75;
        r8.writeInt32(24, this.recvOooPercent_);
    L75:
        if ((this.bitField0_ & 16777216) == 0) goto L78;
        r8.writeInt32(25, this.unacked_);
    L78:
        if ((this.bitField0_ & 33554432) == 0) goto L81;
        r8.writeInt32(26, this.retranRate_);
    L81:
        if ((this.bitField0_ & 67108864) == 0) goto L84;
        r8.writeInt32(27, this.sendRate_);
    L84:
        if ((this.bitField0_ & 134217728) == 0) goto L87;
        r8.writeInt32(28, this.recvRate_);
    L87:
        if ((this.bitField0_ & 268435456) == 0) goto L89;
        r8.writeInt32(29, this.streamNum_);
    L89:
        getUnknownFields().writeTo(r8);
    }

    private NetworkQoE(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.timestamp_ = 0;
        this.foregroundApp_ = "";
        this.networkType_ = 0;
        this.defaultNetwork_ = false;
        this.valid_ = false;
        this.l2QoeStateGood_ = false;
        this.txTput_ = 0;
        this.rxTput_ = 0;
        this.onTimeRate_ = 0;
        this.channelBusyRate_ = 0;
        this.ccaBusyRate_ = 0;
        this.txMpdu_ = 0;
        this.rxMpdu_ = 0;
        this.txRetries_ = 0;
        this.per_ = 0;
        this.txSpeedKbps_ = 0;
        this.rxSpeedKbps_ = 0;
        this.txLinkSpeed_ = 0;
        this.rxLinkSpeed_ = 0;
        this.l4QoeStateGood_ = false;
        this.rtt_ = 0;
        this.sendPackets_ = 0;
        this.recvPackets_ = 0;
        this.recvOooPercent_ = 0;
        this.unacked_ = 0;
        this.retranRate_ = 0;
        this.sendRate_ = 0;
        this.recvRate_ = 0;
        this.streamNum_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(NetworkQoE r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static NetworkQoE parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkQoE) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static NetworkQoE parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_NetworkQoE_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkQoE.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ NetworkQoE(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static NetworkQoE parseFrom(CodedInputStream r8) {
        return (NetworkQoE) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NetworkQoE getDefaultInstanceForType() {
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

    public static NetworkQoE parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NetworkQoE) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static NetworkQoE parseFrom(InputStream r8) {
        return (NetworkQoE) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static NetworkQoE parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkQoE) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static NetworkQoE parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkQoE parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static NetworkQoE parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkQoE parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
