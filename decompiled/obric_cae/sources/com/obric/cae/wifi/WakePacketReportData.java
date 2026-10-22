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
public final class WakePacketReportData extends GeneratedMessageV3 implements WakePacketReportDataOrBuilder {
    private static final WakePacketReportData DEFAULT_INSTANCE = null;
    public static final int DELAYED_PKT_COUNT_FIELD_NUMBER = 10;
    public static final int DEVICE_DATE_FIELD_NUMBER = 14;
    public static final int DEVICE_TIME_FIELD_NUMBER = 13;
    public static final int DST_IP_FIELD_NUMBER = 19;
    public static final int DST_PORT_FIELD_NUMBER = 23;
    public static final int DST_TYPE_FIELD_NUMBER = 11;
    public static final int DST_TYPE_STR_FIELD_NUMBER = 12;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int IP_PROTOCOL_FIELD_NUMBER = 20;
    public static final int IP_PROTOCOL_STR_FIELD_NUMBER = 21;
    public static final int PACKET_LEN_FIELD_NUMBER = 9;
    public static final int PACKET_TYPE_FIELD_NUMBER = 5;
    public static final int PACKET_TYPE_STR_FIELD_NUMBER = 6;

    @Deprecated
    public static final Parser<WakePacketReportData> PARSER = null;
    public static final int PROTOCOL_NAME_FIELD_NUMBER = 8;
    public static final int PROTOCOL_TYPE_FIELD_NUMBER = 7;
    public static final int RAW_FRAME_FIELD_NUMBER = 17;
    public static final int RAW_FRAME_LEN_FIELD_NUMBER = 15;
    public static final int RAW_FRAME_TRUNCATED_FIELD_NUMBER = 16;
    public static final int SERVICE_NAME_FIELD_NUMBER = 24;
    public static final int SRC_IP_FIELD_NUMBER = 18;
    public static final int SRC_PORT_FIELD_NUMBER = 22;
    public static final int VDEV_ID_FIELD_NUMBER = 4;
    public static final int WAKE_REASON_FIELD_NUMBER = 2;
    public static final int WAKE_REASON_STR_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int delayedPktCount_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object dstIp_;
    private int dstPort_;
    private volatile Object dstTypeStr_;
    private int dstType_;
    private volatile Object eventType_;
    private volatile Object ipProtocolStr_;
    private int ipProtocol_;
    private byte memoizedIsInitialized;
    private int packetLen_;
    private volatile Object packetTypeStr_;
    private int packetType_;
    private volatile Object protocolName_;
    private int protocolType_;
    private int rawFrameLen_;
    private boolean rawFrameTruncated_;
    private ByteString rawFrame_;
    private volatile Object serviceName_;
    private volatile Object srcIp_;
    private int srcPort_;
    private int vdevId_;
    private volatile Object wakeReasonStr_;
    private int wakeReason_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WakePacketReportDataOrBuilder {
        private int bitField0_;
        private int delayedPktCount_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object dstIp_;
        private int dstPort_;
        private Object dstTypeStr_;
        private int dstType_;
        private Object eventType_;
        private Object ipProtocolStr_;
        private int ipProtocol_;
        private int packetLen_;
        private Object packetTypeStr_;
        private int packetType_;
        private Object protocolName_;
        private int protocolType_;
        private int rawFrameLen_;
        private boolean rawFrameTruncated_;
        private ByteString rawFrame_;
        private Object serviceName_;
        private Object srcIp_;
        private int srcPort_;
        private int vdevId_;
        private Object wakeReasonStr_;
        private int wakeReason_;

        private Builder() {
            this.eventType_ = "";
            this.wakeReasonStr_ = "";
            this.packetTypeStr_ = "";
            this.protocolName_ = "";
            this.dstTypeStr_ = "";
            this.deviceDate_ = "";
            this.rawFrame_ = ByteString.EMPTY;
            this.srcIp_ = "";
            this.dstIp_ = "";
            this.ipProtocolStr_ = "";
            this.serviceName_ = "";
        }

        private void buildPartial0(WakePacketReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            WakePacketReportData.access$302(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            WakePacketReportData.access$402(r8, this.wakeReason_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            WakePacketReportData.access$502(r8, this.wakeReasonStr_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            WakePacketReportData.access$602(r8, this.vdevId_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            WakePacketReportData.access$702(r8, this.packetType_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            WakePacketReportData.access$802(r8, this.packetTypeStr_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            WakePacketReportData.access$902(r8, this.protocolType_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            WakePacketReportData.access$1002(r8, this.protocolName_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            WakePacketReportData.access$1102(r8, this.packetLen_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            WakePacketReportData.access$1202(r8, this.delayedPktCount_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            WakePacketReportData.access$1302(r8, this.dstType_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            WakePacketReportData.access$1402(r8, this.dstTypeStr_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            WakePacketReportData.access$1502(r8, this.deviceTime_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            WakePacketReportData.access$1602(r8, this.deviceDate_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            WakePacketReportData.access$1702(r8, this.rawFrameLen_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            WakePacketReportData.access$1802(r8, this.rawFrameTruncated_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            WakePacketReportData.access$1902(r8, this.rawFrame_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            WakePacketReportData.access$2002(r8, this.srcIp_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            WakePacketReportData.access$2102(r8, this.dstIp_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L64;
            WakePacketReportData.access$2202(r8, this.ipProtocol_);
            r11 = r11 | 524288;
        L64:
            if ((r10 & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L67;
            WakePacketReportData.access$2302(r8, this.ipProtocolStr_);
            r11 = r11 | BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        L67:
            if ((r10 & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L70;
            WakePacketReportData.access$2402(r8, this.srcPort_);
            r11 = r11 | TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        L70:
            if ((4194304 & r10) == 0) goto L73;
            WakePacketReportData.access$2502(r8, this.dstPort_);
            r11 = r11 | 4194304;
        L73:
            if ((r10 & 8388608) == 0) goto L75;
            WakePacketReportData.access$2602(r8, this.serviceName_);
            r11 = r11 | 8388608;
        L75:
            WakePacketReportData.access$2776(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WakePacketReportData_descriptor;
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

        public Builder clearDelayedPktCount() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.delayedPktCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = WakePacketReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -8193;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -4097;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDstIp() {
            this.dstIp_ = WakePacketReportData.getDefaultInstance().getDstIp();
            this.bitField0_ &= -262145;
            onChanged();
            return this;
        }

        public Builder clearDstPort() {
            this.bitField0_ &= -4194305;
            this.dstPort_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDstType() {
            this.bitField0_ &= -1025;
            this.dstType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDstTypeStr() {
            this.dstTypeStr_ = WakePacketReportData.getDefaultInstance().getDstTypeStr();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = WakePacketReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearIpProtocol() {
            this.bitField0_ &= -524289;
            this.ipProtocol_ = 0;
            onChanged();
            return this;
        }

        public Builder clearIpProtocolStr() {
            this.ipProtocolStr_ = WakePacketReportData.getDefaultInstance().getIpProtocolStr();
            this.bitField0_ &= -1048577;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPacketLen() {
            this.bitField0_ &= -257;
            this.packetLen_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPacketType() {
            this.bitField0_ &= -17;
            this.packetType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPacketTypeStr() {
            this.packetTypeStr_ = WakePacketReportData.getDefaultInstance().getPacketTypeStr();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder clearProtocolName() {
            this.protocolName_ = WakePacketReportData.getDefaultInstance().getProtocolName();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearProtocolType() {
            this.bitField0_ &= -65;
            this.protocolType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRawFrame() {
            this.bitField0_ &= -65537;
            this.rawFrame_ = WakePacketReportData.getDefaultInstance().getRawFrame();
            onChanged();
            return this;
        }

        public Builder clearRawFrameLen() {
            this.bitField0_ &= -16385;
            this.rawFrameLen_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRawFrameTruncated() {
            this.bitField0_ &= -32769;
            this.rawFrameTruncated_ = false;
            onChanged();
            return this;
        }

        public Builder clearServiceName() {
            this.serviceName_ = WakePacketReportData.getDefaultInstance().getServiceName();
            this.bitField0_ &= -8388609;
            onChanged();
            return this;
        }

        public Builder clearSrcIp() {
            this.srcIp_ = WakePacketReportData.getDefaultInstance().getSrcIp();
            this.bitField0_ &= -131073;
            onChanged();
            return this;
        }

        public Builder clearSrcPort() {
            this.bitField0_ &= -2097153;
            this.srcPort_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVdevId() {
            this.bitField0_ &= -9;
            this.vdevId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWakeReason() {
            this.bitField0_ &= -3;
            this.wakeReason_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWakeReasonStr() {
            this.wakeReasonStr_ = WakePacketReportData.getDefaultInstance().getWakeReasonStr();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getDelayedPktCount() {
            return this.delayedPktCount_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WakePacketReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getDstIp() {
            Object r8 = this.dstIp_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.dstIp_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getDstIpBytes() {
            Object r8 = this.dstIp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.dstIp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getDstPort() {
            return this.dstPort_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getDstType() {
            return this.dstType_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getDstTypeStr() {
            Object r8 = this.dstTypeStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.dstTypeStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getDstTypeStrBytes() {
            Object r8 = this.dstTypeStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.dstTypeStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getIpProtocol() {
            return this.ipProtocol_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getIpProtocolStr() {
            Object r8 = this.ipProtocolStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.ipProtocolStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getIpProtocolStrBytes() {
            Object r8 = this.ipProtocolStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.ipProtocolStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getPacketLen() {
            return this.packetLen_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getPacketType() {
            return this.packetType_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getPacketTypeStr() {
            Object r8 = this.packetTypeStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.packetTypeStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getPacketTypeStrBytes() {
            Object r8 = this.packetTypeStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.packetTypeStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getProtocolName() {
            Object r8 = this.protocolName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.protocolName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getProtocolNameBytes() {
            Object r8 = this.protocolName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.protocolName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getProtocolType() {
            return this.protocolType_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getRawFrame() {
            return this.rawFrame_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getRawFrameLen() {
            return this.rawFrameLen_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean getRawFrameTruncated() {
            return this.rawFrameTruncated_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getServiceName() {
            Object r8 = this.serviceName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.serviceName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getServiceNameBytes() {
            Object r8 = this.serviceName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.serviceName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getSrcIp() {
            Object r8 = this.srcIp_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.srcIp_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getSrcIpBytes() {
            Object r8 = this.srcIp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.srcIp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getSrcPort() {
            return this.srcPort_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getVdevId() {
            return this.vdevId_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public int getWakeReason() {
            return this.wakeReason_;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public String getWakeReasonStr() {
            Object r8 = this.wakeReasonStr_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.wakeReasonStr_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public ByteString getWakeReasonStrBytes() {
            Object r8 = this.wakeReasonStr_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wakeReasonStr_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasDelayedPktCount() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasDstIp() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasDstPort() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasDstType() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasDstTypeStr() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasIpProtocol() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasIpProtocolStr() {
            if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasPacketLen() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasPacketType() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasPacketTypeStr() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasProtocolName() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasProtocolType() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasRawFrame() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasRawFrameLen() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasRawFrameTruncated() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasServiceName() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasSrcIp() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasSrcPort() {
            if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasVdevId() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasWakeReason() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
        public boolean hasWakeReasonStr() {
            if ((this.bitField0_ & 4) == 0) goto L5;
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

        public Builder setDelayedPktCount(int r8) {
            this.delayedPktCount_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setDstIp(String r8) {
            if (r8 == null) goto L6;
            this.dstIp_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDstIpBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.dstIp_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDstPort(int r8) {
            this.dstPort_ = r8;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setDstType(int r8) {
            this.dstType_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setDstTypeStr(String r8) {
            if (r8 == null) goto L6;
            this.dstTypeStr_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDstTypeStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.dstTypeStr_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
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

        public Builder setIpProtocol(int r8) {
            this.ipProtocol_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setIpProtocolStr(String r8) {
            if (r8 == null) goto L6;
            this.ipProtocolStr_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setIpProtocolStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.ipProtocolStr_ = r8;
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setPacketLen(int r8) {
            this.packetLen_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setPacketType(int r8) {
            this.packetType_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setPacketTypeStr(String r8) {
            if (r8 == null) goto L6;
            this.packetTypeStr_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setPacketTypeStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.packetTypeStr_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setProtocolName(String r8) {
            if (r8 == null) goto L6;
            this.protocolName_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setProtocolNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.protocolName_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setProtocolType(int r8) {
            this.protocolType_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setRawFrame(ByteString r8) {
            if (r8 == null) goto L6;
            this.rawFrame_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRawFrameLen(int r8) {
            this.rawFrameLen_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setRawFrameTruncated(boolean r8) {
            this.rawFrameTruncated_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setServiceName(String r8) {
            if (r8 == null) goto L6;
            this.serviceName_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setServiceNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.serviceName_ = r8;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSrcIp(String r8) {
            if (r8 == null) goto L6;
            this.srcIp_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSrcIpBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.srcIp_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSrcPort(int r8) {
            this.srcPort_ = r8;
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setVdevId(int r8) {
            this.vdevId_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setWakeReason(int r8) {
            this.wakeReason_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setWakeReasonStr(String r8) {
            if (r8 == null) goto L6;
            this.wakeReasonStr_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWakeReasonStrBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wakeReasonStr_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.wakeReasonStr_ = "";
            this.packetTypeStr_ = "";
            this.protocolName_ = "";
            this.dstTypeStr_ = "";
            this.deviceDate_ = "";
            this.rawFrame_ = ByteString.EMPTY;
            this.srcIp_ = "";
            this.dstIp_ = "";
            this.ipProtocolStr_ = "";
            this.serviceName_ = "";
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WakePacketReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WakePacketReportData.class, Builder.class);
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
        public WakePacketReportData build() {
            WakePacketReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WakePacketReportData buildPartial() {
            WakePacketReportData r8 = new WakePacketReportData(this, null);
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
        public WakePacketReportData getDefaultInstanceForType() {
            return WakePacketReportData.getDefaultInstance();
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
            this.eventType_ = "";
            this.wakeReason_ = 0;
            this.wakeReasonStr_ = "";
            this.vdevId_ = 0;
            this.packetType_ = 0;
            this.packetTypeStr_ = "";
            this.protocolType_ = 0;
            this.protocolName_ = "";
            this.packetLen_ = 0;
            this.delayedPktCount_ = 0;
            this.dstType_ = 0;
            this.dstTypeStr_ = "";
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            this.rawFrameLen_ = 0;
            this.rawFrameTruncated_ = false;
            this.rawFrame_ = ByteString.EMPTY;
            this.srcIp_ = "";
            this.dstIp_ = "";
            this.ipProtocol_ = 0;
            this.ipProtocolStr_ = "";
            this.srcPort_ = 0;
            this.dstPort_ = 0;
            this.serviceName_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L46;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L43;
            int r12 = r8.readTag();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            switch(r12) {
                case 0: goto L33;
                case 10: goto L31;
                case 16: goto L30;
                case 26: goto L29;
                case 32: goto L28;
                case 40: goto L27;
                case 50: goto L26;
                case 56: goto L25;
                case 66: goto L24;
                case 72: goto L23;
                case 80: goto L22;
                case 88: goto L21;
                case 98: goto L20;
                case 104: goto L19;
                case 114: goto L18;
                case 120: goto L17;
                case 128: goto L16;
                case 138: goto L15;
                case 146: goto L14;
                case 154: goto L13;
                case 160: goto L12;
                case 170: goto L11;
                case 176: goto L10;
                case 184: goto L9;
                case 194: goto L8;
                default: goto L34;
            };     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L8:
            this.serviceName_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8388608;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L9:
            this.dstPort_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 4194304;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L10:
            this.srcPort_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= TrafficControlConfig.DEFAULT_UNLIMITED_RATE;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L11:
            this.ipProtocolStr_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L12:
            this.ipProtocol_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 524288;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L13:
            this.dstIp_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 262144;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L14:
            this.srcIp_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 131072;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L15:
            this.rawFrame_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 65536;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L16:
            this.rawFrameTruncated_ = r8.readBool();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32768;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L17:
            this.rawFrameLen_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 16384;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L18:
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8192;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L19:
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 4096;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L20:
            this.dstTypeStr_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 2048;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L21:
            this.dstType_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1024;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L22:
            this.delayedPktCount_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 512;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L23:
            this.packetLen_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 256;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L24:
            this.protocolName_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 128;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L25:
            this.protocolType_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 64;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L26:
            this.packetTypeStr_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L27:
            this.packetType_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L28:
            this.vdevId_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L29:
            this.wakeReasonStr_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L30:
            this.wakeReason_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L31:
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L33:
            r11 = true;
            goto L4
        L34:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L36:
            th = move-exception;
            onChanged();
            throw th;
        L38:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L36
        L43:
            onChanged();
            return this;
        L46:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof WakePacketReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((WakePacketReportData) r8);
        }

        public Builder mergeFrom(WakePacketReportData r8) {
            if (r8 != WakePacketReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = WakePacketReportData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasWakeReason() == false) goto L12;
            setWakeReason(r8.getWakeReason());
        L12:
            if (r8.hasWakeReasonStr() == false) goto L15;
            this.wakeReasonStr_ = WakePacketReportData.access$500(r8);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r8.hasVdevId() == false) goto L18;
            setVdevId(r8.getVdevId());
        L18:
            if (r8.hasPacketType() == false) goto L21;
            setPacketType(r8.getPacketType());
        L21:
            if (r8.hasPacketTypeStr() == false) goto L24;
            this.packetTypeStr_ = WakePacketReportData.access$800(r8);
            this.bitField0_ |= 32;
            onChanged();
        L24:
            if (r8.hasProtocolType() == false) goto L27;
            setProtocolType(r8.getProtocolType());
        L27:
            if (r8.hasProtocolName() == false) goto L30;
            this.protocolName_ = WakePacketReportData.access$1000(r8);
            this.bitField0_ |= 128;
            onChanged();
        L30:
            if (r8.hasPacketLen() == false) goto L33;
            setPacketLen(r8.getPacketLen());
        L33:
            if (r8.hasDelayedPktCount() == false) goto L36;
            setDelayedPktCount(r8.getDelayedPktCount());
        L36:
            if (r8.hasDstType() == false) goto L39;
            setDstType(r8.getDstType());
        L39:
            if (r8.hasDstTypeStr() == false) goto L42;
            this.dstTypeStr_ = WakePacketReportData.access$1400(r8);
            this.bitField0_ |= 2048;
            onChanged();
        L42:
            if (r8.hasDeviceTime() == false) goto L45;
            setDeviceTime(r8.getDeviceTime());
        L45:
            if (r8.hasDeviceDate() == false) goto L48;
            this.deviceDate_ = WakePacketReportData.access$1600(r8);
            this.bitField0_ |= 8192;
            onChanged();
        L48:
            if (r8.hasRawFrameLen() == false) goto L51;
            setRawFrameLen(r8.getRawFrameLen());
        L51:
            if (r8.hasRawFrameTruncated() == false) goto L54;
            setRawFrameTruncated(r8.getRawFrameTruncated());
        L54:
            if (r8.hasRawFrame() == false) goto L57;
            setRawFrame(r8.getRawFrame());
        L57:
            if (r8.hasSrcIp() == false) goto L60;
            this.srcIp_ = WakePacketReportData.access$2000(r8);
            this.bitField0_ |= 131072;
            onChanged();
        L60:
            if (r8.hasDstIp() == false) goto L63;
            this.dstIp_ = WakePacketReportData.access$2100(r8);
            this.bitField0_ |= 262144;
            onChanged();
        L63:
            if (r8.hasIpProtocol() == false) goto L66;
            setIpProtocol(r8.getIpProtocol());
        L66:
            if (r8.hasIpProtocolStr() == false) goto L69;
            this.ipProtocolStr_ = WakePacketReportData.access$2300(r8);
            this.bitField0_ |= BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
            onChanged();
        L69:
            if (r8.hasSrcPort() == false) goto L72;
            setSrcPort(r8.getSrcPort());
        L72:
            if (r8.hasDstPort() == false) goto L75;
            setDstPort(r8.getDstPort());
        L75:
            if (r8.hasServiceName() == false) goto L77;
            this.serviceName_ = WakePacketReportData.access$2600(r8);
            this.bitField0_ |= 8388608;
            onChanged();
        L77:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new WakePacketReportData();
        PARSER = new AnonymousClass1();
    }

    private WakePacketReportData() {
        this.eventType_ = "";
        this.wakeReason_ = 0;
        this.wakeReasonStr_ = "";
        this.vdevId_ = 0;
        this.packetType_ = 0;
        this.packetTypeStr_ = "";
        this.protocolType_ = 0;
        this.protocolName_ = "";
        this.packetLen_ = 0;
        this.delayedPktCount_ = 0;
        this.dstType_ = 0;
        this.dstTypeStr_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.rawFrameLen_ = 0;
        this.rawFrameTruncated_ = false;
        ByteString r8 = ByteString.EMPTY;
        this.rawFrame_ = r8;
        this.srcIp_ = "";
        this.dstIp_ = "";
        this.ipProtocol_ = 0;
        this.ipProtocolStr_ = "";
        this.srcPort_ = 0;
        this.dstPort_ = 0;
        this.serviceName_ = "";
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.wakeReasonStr_ = "";
        this.packetTypeStr_ = "";
        this.protocolName_ = "";
        this.dstTypeStr_ = "";
        this.deviceDate_ = "";
        this.rawFrame_ = r8;
        this.srcIp_ = "";
        this.dstIp_ = "";
        this.ipProtocolStr_ = "";
        this.serviceName_ = "";
    }

    public static /* synthetic */ Object access$1000(WakePacketReportData r8) {
        return r8.protocolName_;
    }

    public static /* synthetic */ Object access$1002(WakePacketReportData r8, Object r10) {
        r8.protocolName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(WakePacketReportData r8, int r10) {
        r8.packetLen_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(WakePacketReportData r8, int r10) {
        r8.delayedPktCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(WakePacketReportData r8, int r10) {
        r8.dstType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1400(WakePacketReportData r8) {
        return r8.dstTypeStr_;
    }

    public static /* synthetic */ Object access$1402(WakePacketReportData r8, Object r10) {
        r8.dstTypeStr_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1502(WakePacketReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1600(WakePacketReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$1602(WakePacketReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1702(WakePacketReportData r8, int r10) {
        r8.rawFrameLen_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1802(WakePacketReportData r8, boolean r10) {
        r8.rawFrameTruncated_ = r10;
        return r10;
    }

    public static /* synthetic */ ByteString access$1902(WakePacketReportData r8, ByteString r10) {
        r8.rawFrame_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2000(WakePacketReportData r8) {
        return r8.srcIp_;
    }

    public static /* synthetic */ Object access$2002(WakePacketReportData r8, Object r10) {
        r8.srcIp_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2100(WakePacketReportData r8) {
        return r8.dstIp_;
    }

    public static /* synthetic */ Object access$2102(WakePacketReportData r8, Object r10) {
        r8.dstIp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2202(WakePacketReportData r8, int r10) {
        r8.ipProtocol_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2300(WakePacketReportData r8) {
        return r8.ipProtocolStr_;
    }

    public static /* synthetic */ Object access$2302(WakePacketReportData r8, Object r10) {
        r8.ipProtocolStr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2402(WakePacketReportData r8, int r10) {
        r8.srcPort_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2502(WakePacketReportData r8, int r10) {
        r8.dstPort_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2600(WakePacketReportData r8) {
        return r8.serviceName_;
    }

    public static /* synthetic */ Object access$2602(WakePacketReportData r8, Object r10) {
        r8.serviceName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2776(WakePacketReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(WakePacketReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$302(WakePacketReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(WakePacketReportData r8, int r10) {
        r8.wakeReason_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(WakePacketReportData r8) {
        return r8.wakeReasonStr_;
    }

    public static /* synthetic */ Object access$502(WakePacketReportData r8, Object r10) {
        r8.wakeReasonStr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(WakePacketReportData r8, int r10) {
        r8.vdevId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(WakePacketReportData r8, int r10) {
        r8.packetType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$800(WakePacketReportData r8) {
        return r8.packetTypeStr_;
    }

    public static /* synthetic */ Object access$802(WakePacketReportData r8, Object r10) {
        r8.packetTypeStr_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(WakePacketReportData r8, int r10) {
        r8.protocolType_ = r10;
        return r10;
    }

    public static WakePacketReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WakePacketReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static WakePacketReportData parseDelimitedFrom(InputStream r8) {
        return (WakePacketReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static WakePacketReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<WakePacketReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof WakePacketReportData) == false) goto L8;
        WakePacketReportData r10 = (WakePacketReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasWakeReason() == r10.hasWakeReason()) goto L21;
        return false;
    L21:
        if (hasWakeReason() == false) goto L26;
        if (getWakeReason() == r10.getWakeReason()) goto L26;
        return false;
    L26:
        if (hasWakeReasonStr() == r10.hasWakeReasonStr()) goto L29;
        return false;
    L29:
        if (hasWakeReasonStr() == false) goto L34;
        if (getWakeReasonStr().equals(r10.getWakeReasonStr()) == true) goto L34;
        return false;
    L34:
        if (hasVdevId() == r10.hasVdevId()) goto L37;
        return false;
    L37:
        if (hasVdevId() == false) goto L42;
        if (getVdevId() == r10.getVdevId()) goto L42;
        return false;
    L42:
        if (hasPacketType() == r10.hasPacketType()) goto L45;
        return false;
    L45:
        if (hasPacketType() == false) goto L50;
        if (getPacketType() == r10.getPacketType()) goto L50;
        return false;
    L50:
        if (hasPacketTypeStr() == r10.hasPacketTypeStr()) goto L53;
        return false;
    L53:
        if (hasPacketTypeStr() == false) goto L58;
        if (getPacketTypeStr().equals(r10.getPacketTypeStr()) == true) goto L58;
        return false;
    L58:
        if (hasProtocolType() == r10.hasProtocolType()) goto L61;
        return false;
    L61:
        if (hasProtocolType() == false) goto L66;
        if (getProtocolType() == r10.getProtocolType()) goto L66;
        return false;
    L66:
        if (hasProtocolName() == r10.hasProtocolName()) goto L69;
        return false;
    L69:
        if (hasProtocolName() == false) goto L74;
        if (getProtocolName().equals(r10.getProtocolName()) == true) goto L74;
        return false;
    L74:
        if (hasPacketLen() == r10.hasPacketLen()) goto L77;
        return false;
    L77:
        if (hasPacketLen() == false) goto L82;
        if (getPacketLen() == r10.getPacketLen()) goto L82;
        return false;
    L82:
        if (hasDelayedPktCount() == r10.hasDelayedPktCount()) goto L85;
        return false;
    L85:
        if (hasDelayedPktCount() == false) goto L90;
        if (getDelayedPktCount() == r10.getDelayedPktCount()) goto L90;
        return false;
    L90:
        if (hasDstType() == r10.hasDstType()) goto L93;
        return false;
    L93:
        if (hasDstType() == false) goto L98;
        if (getDstType() == r10.getDstType()) goto L98;
        return false;
    L98:
        if (hasDstTypeStr() == r10.hasDstTypeStr()) goto L101;
        return false;
    L101:
        if (hasDstTypeStr() == false) goto L106;
        if (getDstTypeStr().equals(r10.getDstTypeStr()) == true) goto L106;
        return false;
    L106:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L109;
        return false;
    L109:
        if (hasDeviceTime() == false) goto L114;
        if (getDeviceTime() == r10.getDeviceTime()) goto L114;
        return false;
    L114:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L117;
        return false;
    L117:
        if (hasDeviceDate() == false) goto L122;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L122;
        return false;
    L122:
        if (hasRawFrameLen() == r10.hasRawFrameLen()) goto L125;
        return false;
    L125:
        if (hasRawFrameLen() == false) goto L130;
        if (getRawFrameLen() == r10.getRawFrameLen()) goto L130;
        return false;
    L130:
        if (hasRawFrameTruncated() == r10.hasRawFrameTruncated()) goto L133;
        return false;
    L133:
        if (hasRawFrameTruncated() == false) goto L138;
        if (getRawFrameTruncated() == r10.getRawFrameTruncated()) goto L138;
        return false;
    L138:
        if (hasRawFrame() == r10.hasRawFrame()) goto L141;
        return false;
    L141:
        if (hasRawFrame() == false) goto L146;
        if (getRawFrame().equals(r10.getRawFrame()) == true) goto L146;
        return false;
    L146:
        if (hasSrcIp() == r10.hasSrcIp()) goto L149;
        return false;
    L149:
        if (hasSrcIp() == false) goto L154;
        if (getSrcIp().equals(r10.getSrcIp()) == true) goto L154;
        return false;
    L154:
        if (hasDstIp() == r10.hasDstIp()) goto L157;
        return false;
    L157:
        if (hasDstIp() == false) goto L162;
        if (getDstIp().equals(r10.getDstIp()) == true) goto L162;
        return false;
    L162:
        if (hasIpProtocol() == r10.hasIpProtocol()) goto L165;
        return false;
    L165:
        if (hasIpProtocol() == false) goto L170;
        if (getIpProtocol() == r10.getIpProtocol()) goto L170;
        return false;
    L170:
        if (hasIpProtocolStr() == r10.hasIpProtocolStr()) goto L173;
        return false;
    L173:
        if (hasIpProtocolStr() == false) goto L178;
        if (getIpProtocolStr().equals(r10.getIpProtocolStr()) == true) goto L178;
        return false;
    L178:
        if (hasSrcPort() == r10.hasSrcPort()) goto L181;
        return false;
    L181:
        if (hasSrcPort() == false) goto L186;
        if (getSrcPort() == r10.getSrcPort()) goto L186;
        return false;
    L186:
        if (hasDstPort() == r10.hasDstPort()) goto L189;
        return false;
    L189:
        if (hasDstPort() == false) goto L194;
        if (getDstPort() == r10.getDstPort()) goto L194;
        return false;
    L194:
        if (hasServiceName() == r10.hasServiceName()) goto L197;
        return false;
    L197:
        if (hasServiceName() == false) goto L202;
        if (getServiceName().equals(r10.getServiceName()) == true) goto L202;
        return false;
    L202:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L204;
        return false;
    L204:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getDelayedPktCount() {
        return this.delayedPktCount_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getDstIp() {
        Object r8 = this.dstIp_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.dstIp_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getDstIpBytes() {
        Object r8 = this.dstIp_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.dstIp_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getDstPort() {
        return this.dstPort_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getDstType() {
        return this.dstType_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getDstTypeStr() {
        Object r8 = this.dstTypeStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.dstTypeStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getDstTypeStrBytes() {
        Object r8 = this.dstTypeStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.dstTypeStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getIpProtocol() {
        return this.ipProtocol_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getIpProtocolStr() {
        Object r8 = this.ipProtocolStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.ipProtocolStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getIpProtocolStrBytes() {
        Object r8 = this.ipProtocolStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.ipProtocolStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getPacketLen() {
        return this.packetLen_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getPacketType() {
        return this.packetType_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getPacketTypeStr() {
        Object r8 = this.packetTypeStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.packetTypeStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getPacketTypeStrBytes() {
        Object r8 = this.packetTypeStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.packetTypeStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WakePacketReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getProtocolName() {
        Object r8 = this.protocolName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.protocolName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getProtocolNameBytes() {
        Object r8 = this.protocolName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.protocolName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getProtocolType() {
        return this.protocolType_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getRawFrame() {
        return this.rawFrame_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getRawFrameLen() {
        return this.rawFrameLen_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean getRawFrameTruncated() {
        return this.rawFrameTruncated_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + GeneratedMessage.computeStringSize(1, this.eventType_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.wakeReason_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.wakeReasonStr_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.vdevId_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.packetType_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + GeneratedMessage.computeStringSize(6, this.packetTypeStr_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.protocolType_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + GeneratedMessage.computeStringSize(8, this.protocolName_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.packetLen_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.delayedPktCount_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.dstType_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + GeneratedMessage.computeStringSize(12, this.dstTypeStr_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeUInt64Size(13, this.deviceTime_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + GeneratedMessage.computeStringSize(14, this.deviceDate_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeUInt32Size(15, this.rawFrameLen_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeBoolSize(16, this.rawFrameTruncated_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + CodedOutputStream.computeBytesSize(17, this.rawFrame_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + GeneratedMessage.computeStringSize(18, this.srcIp_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L63;
        r10 = r10 + GeneratedMessage.computeStringSize(19, this.dstIp_);
    L63:
        if ((this.bitField0_ & 524288) == 0) goto L66;
        r10 = r10 + CodedOutputStream.computeInt32Size(20, this.ipProtocol_);
    L66:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L69;
        r10 = r10 + GeneratedMessage.computeStringSize(21, this.ipProtocolStr_);
    L69:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L72;
        r10 = r10 + CodedOutputStream.computeInt32Size(22, this.srcPort_);
    L72:
        if ((this.bitField0_ & 4194304) == 0) goto L75;
        r10 = r10 + CodedOutputStream.computeInt32Size(23, this.dstPort_);
    L75:
        if ((this.bitField0_ & 8388608) == 0) goto L77;
        r10 = r10 + GeneratedMessage.computeStringSize(24, this.serviceName_);
    L77:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getServiceName() {
        Object r8 = this.serviceName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.serviceName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getServiceNameBytes() {
        Object r8 = this.serviceName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.serviceName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getSrcIp() {
        Object r8 = this.srcIp_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.srcIp_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getSrcIpBytes() {
        Object r8 = this.srcIp_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.srcIp_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getSrcPort() {
        return this.srcPort_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getVdevId() {
        return this.vdevId_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public int getWakeReason() {
        return this.wakeReason_;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public String getWakeReasonStr() {
        Object r8 = this.wakeReasonStr_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.wakeReasonStr_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public ByteString getWakeReasonStrBytes() {
        Object r8 = this.wakeReasonStr_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wakeReasonStr_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasDelayedPktCount() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasDstIp() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasDstPort() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasDstType() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasDstTypeStr() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasIpProtocol() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasIpProtocolStr() {
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasPacketLen() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasPacketType() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasPacketTypeStr() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasProtocolName() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasProtocolType() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasRawFrame() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasRawFrameLen() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasRawFrameTruncated() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasServiceName() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasSrcIp() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasSrcPort() {
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasVdevId() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasWakeReason() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.WakePacketReportDataOrBuilder
    public boolean hasWakeReasonStr() {
        if ((this.bitField0_ & 4) == 0) goto L5;
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
        if (hasWakeReason() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getWakeReason();
    L12:
        if (hasWakeReasonStr() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getWakeReasonStr().hashCode();
    L15:
        if (hasVdevId() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getVdevId();
    L18:
        if (hasPacketType() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getPacketType();
    L21:
        if (hasPacketTypeStr() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getPacketTypeStr().hashCode();
    L24:
        if (hasProtocolType() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getProtocolType();
    L27:
        if (hasProtocolName() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getProtocolName().hashCode();
    L30:
        if (hasPacketLen() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getPacketLen();
    L33:
        if (hasDelayedPktCount() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getDelayedPktCount();
    L36:
        if (hasDstType() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getDstType();
    L39:
        if (hasDstTypeStr() == false) goto L42;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getDstTypeStr().hashCode();
    L42:
        if (hasDeviceTime() == false) goto L45;
        r10 = defpackage.b.a(r10, 37, 13, 53) + Internal.hashLong(getDeviceTime());
    L45:
        if (hasDeviceDate() == false) goto L48;
        r10 = defpackage.b.a(r10, 37, 14, 53) + getDeviceDate().hashCode();
    L48:
        if (hasRawFrameLen() == false) goto L51;
        r10 = defpackage.b.a(r10, 37, 15, 53) + getRawFrameLen();
    L51:
        if (hasRawFrameTruncated() == false) goto L54;
        r10 = defpackage.b.a(r10, 37, 16, 53) + Internal.hashBoolean(getRawFrameTruncated());
    L54:
        if (hasRawFrame() == false) goto L57;
        r10 = defpackage.b.a(r10, 37, 17, 53) + getRawFrame().hashCode();
    L57:
        if (hasSrcIp() == false) goto L60;
        r10 = defpackage.b.a(r10, 37, 18, 53) + getSrcIp().hashCode();
    L60:
        if (hasDstIp() == false) goto L63;
        r10 = defpackage.b.a(r10, 37, 19, 53) + getDstIp().hashCode();
    L63:
        if (hasIpProtocol() == false) goto L66;
        r10 = defpackage.b.a(r10, 37, 20, 53) + getIpProtocol();
    L66:
        if (hasIpProtocolStr() == false) goto L69;
        r10 = defpackage.b.a(r10, 37, 21, 53) + getIpProtocolStr().hashCode();
    L69:
        if (hasSrcPort() == false) goto L72;
        r10 = defpackage.b.a(r10, 37, 22, 53) + getSrcPort();
    L72:
        if (hasDstPort() == false) goto L75;
        r10 = defpackage.b.a(r10, 37, 23, 53) + getDstPort();
    L75:
        if (hasServiceName() == false) goto L77;
        r10 = defpackage.b.a(r10, 37, 24, 53) + getServiceName().hashCode();
    L77:
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
        return new WakePacketReportData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.eventType_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.wakeReason_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r8, 3, this.wakeReasonStr_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.vdevId_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.packetType_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        GeneratedMessage.writeString(r8, 6, this.packetTypeStr_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.protocolType_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        GeneratedMessage.writeString(r8, 8, this.protocolName_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.packetLen_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.delayedPktCount_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.dstType_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        GeneratedMessage.writeString(r8, 12, this.dstTypeStr_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeUInt64(13, this.deviceTime_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        GeneratedMessage.writeString(r8, 14, this.deviceDate_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeUInt32(15, this.rawFrameLen_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r8.writeBool(16, this.rawFrameTruncated_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r8.writeBytes(17, this.rawFrame_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        GeneratedMessage.writeString(r8, 18, this.srcIp_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        GeneratedMessage.writeString(r8, 19, this.dstIp_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        r8.writeInt32(20, this.ipProtocol_);
    L63:
        if ((this.bitField0_ & BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE) == 0) goto L66;
        GeneratedMessage.writeString(r8, 21, this.ipProtocolStr_);
    L66:
        if ((this.bitField0_ & TrafficControlConfig.DEFAULT_UNLIMITED_RATE) == 0) goto L69;
        r8.writeInt32(22, this.srcPort_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r8.writeInt32(23, this.dstPort_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L74;
        GeneratedMessage.writeString(r8, 24, this.serviceName_);
    L74:
        getUnknownFields().writeTo(r8);
    }

    private WakePacketReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.wakeReason_ = 0;
        this.wakeReasonStr_ = "";
        this.vdevId_ = 0;
        this.packetType_ = 0;
        this.packetTypeStr_ = "";
        this.protocolType_ = 0;
        this.protocolName_ = "";
        this.packetLen_ = 0;
        this.delayedPktCount_ = 0;
        this.dstType_ = 0;
        this.dstTypeStr_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.rawFrameLen_ = 0;
        this.rawFrameTruncated_ = false;
        this.rawFrame_ = ByteString.EMPTY;
        this.srcIp_ = "";
        this.dstIp_ = "";
        this.ipProtocol_ = 0;
        this.ipProtocolStr_ = "";
        this.srcPort_ = 0;
        this.dstPort_ = 0;
        this.serviceName_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(WakePacketReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static WakePacketReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WakePacketReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static WakePacketReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_WakePacketReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(WakePacketReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ WakePacketReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static WakePacketReportData parseFrom(CodedInputStream r8) {
        return (WakePacketReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public WakePacketReportData getDefaultInstanceForType() {
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

    public static WakePacketReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (WakePacketReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static WakePacketReportData parseFrom(InputStream r8) {
        return (WakePacketReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static WakePacketReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WakePacketReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static WakePacketReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static WakePacketReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static WakePacketReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static WakePacketReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
