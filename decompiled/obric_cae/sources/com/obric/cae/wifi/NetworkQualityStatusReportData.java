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
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkQualityStatusReportData extends GeneratedMessageV3 implements NetworkQualityStatusReportDataOrBuilder {
    public static final int BAND1_FIELD_NUMBER = 9;
    public static final int BAND_FIELD_NUMBER = 8;
    public static final int BSSID_MD5_FIELD_NUMBER = 5;
    public static final int CCALEVEL_FIELD_NUMBER = 14;
    private static final NetworkQualityStatusReportData DEFAULT_INSTANCE = null;
    public static final int DEVICE_DATE_FIELD_NUMBER = 16;
    public static final int DEVICE_TIME_FIELD_NUMBER = 15;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int LOST_FIELD_NUMBER = 3;
    public static final int MLO_ENABLE_FIELD_NUMBER = 7;

    @Deprecated
    public static final Parser<NetworkQualityStatusReportData> PARSER = null;
    public static final int RTTMS_FIELD_NUMBER = 4;
    public static final int RX_LINKSPEED_FIELD_NUMBER = 13;
    public static final int RX_REALSPEED_FIELD_NUMBER = 11;
    public static final int SENT_FIELD_NUMBER = 2;
    public static final int TX_LINKSPEED_FIELD_NUMBER = 12;
    public static final int TX_REALSPEED_FIELD_NUMBER = 10;
    public static final int WIFIGENERATION_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private volatile Object band1_;
    private volatile Object band_;
    private int bitField0_;
    private volatile Object bssidMd5_;
    private int ccalevel_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private int lost_;
    private byte memoizedIsInitialized;
    private int mloEnable_;
    private int rttms_;
    private int rxLinkspeed_;
    private int rxRealspeed_;
    private int sent_;
    private int txLinkspeed_;
    private int txRealspeed_;
    private volatile Object wifigeneration_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NetworkQualityStatusReportDataOrBuilder {
        private Object band1_;
        private Object band_;
        private int bitField0_;
        private Object bssidMd5_;
        private int ccalevel_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private int lost_;
        private int mloEnable_;
        private int rttms_;
        private int rxLinkspeed_;
        private int rxRealspeed_;
        private int sent_;
        private int txLinkspeed_;
        private int txRealspeed_;
        private Object wifigeneration_;

        private Builder() {
            this.eventType_ = "";
            this.bssidMd5_ = "";
            this.wifigeneration_ = "";
            this.band_ = "";
            this.band1_ = "";
            this.deviceDate_ = "";
        }

        private void buildPartial0(NetworkQualityStatusReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            NetworkQualityStatusReportData.access$302(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            NetworkQualityStatusReportData.access$402(r8, this.sent_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            NetworkQualityStatusReportData.access$502(r8, this.lost_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            NetworkQualityStatusReportData.access$602(r8, this.rttms_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            NetworkQualityStatusReportData.access$702(r8, this.bssidMd5_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            NetworkQualityStatusReportData.access$802(r8, this.wifigeneration_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            NetworkQualityStatusReportData.access$902(r8, this.mloEnable_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            NetworkQualityStatusReportData.access$1002(r8, this.band_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            NetworkQualityStatusReportData.access$1102(r8, this.band1_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            NetworkQualityStatusReportData.access$1202(r8, this.txRealspeed_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            NetworkQualityStatusReportData.access$1302(r8, this.rxRealspeed_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            NetworkQualityStatusReportData.access$1402(r8, this.txLinkspeed_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            NetworkQualityStatusReportData.access$1502(r8, this.rxLinkspeed_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            NetworkQualityStatusReportData.access$1602(r8, this.ccalevel_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            NetworkQualityStatusReportData.access$1702(r8, this.deviceTime_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L51;
            NetworkQualityStatusReportData.access$1802(r8, this.deviceDate_);
            r11 = r11 | 32768;
        L51:
            NetworkQualityStatusReportData.access$1976(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_NetworkQualityStatusReportData_descriptor;
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

        public Builder clearBand() {
            this.band_ = NetworkQualityStatusReportData.getDefaultInstance().getBand();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearBand1() {
            this.band1_ = NetworkQualityStatusReportData.getDefaultInstance().getBand1();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder clearBssidMd5() {
            this.bssidMd5_ = NetworkQualityStatusReportData.getDefaultInstance().getBssidMd5();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearCcalevel() {
            this.bitField0_ &= -8193;
            this.ccalevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = NetworkQualityStatusReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -32769;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -16385;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = NetworkQualityStatusReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearLost() {
            this.bitField0_ &= -5;
            this.lost_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMloEnable() {
            this.bitField0_ &= -65;
            this.mloEnable_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearRttms() {
            this.bitField0_ &= -9;
            this.rttms_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxLinkspeed() {
            this.bitField0_ &= -4097;
            this.rxLinkspeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRxRealspeed() {
            this.bitField0_ &= -1025;
            this.rxRealspeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSent() {
            this.bitField0_ &= -3;
            this.sent_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxLinkspeed() {
            this.bitField0_ &= -2049;
            this.txLinkspeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTxRealspeed() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.txRealspeed_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifigeneration() {
            this.wifigeneration_ = NetworkQualityStatusReportData.getDefaultInstance().getWifigeneration();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public ByteString getBand1Bytes() {
            Object r8 = this.band1_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.band1_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public ByteString getBandBytes() {
            Object r8 = this.band_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.band_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public String getBssidMd5() {
            Object r8 = this.bssidMd5_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.bssidMd5_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public ByteString getBssidMd5Bytes() {
            Object r8 = this.bssidMd5_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssidMd5_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getCcalevel() {
            return this.ccalevel_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_NetworkQualityStatusReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getLost() {
            return this.lost_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getMloEnable() {
            return this.mloEnable_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getRttms() {
            return this.rttms_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getRxLinkspeed() {
            return this.rxLinkspeed_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getRxRealspeed() {
            return this.rxRealspeed_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getSent() {
            return this.sent_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getTxLinkspeed() {
            return this.txLinkspeed_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public int getTxRealspeed() {
            return this.txRealspeed_;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public ByteString getWifigenerationBytes() {
            Object r8 = this.wifigeneration_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wifigeneration_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasBand() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasBand1() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasBssidMd5() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasCcalevel() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasLost() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasMloEnable() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasRttms() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasRxLinkspeed() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasRxRealspeed() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasSent() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasTxLinkspeed() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasTxRealspeed() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
        public boolean hasWifigeneration() {
            if ((this.bitField0_ & 32) == 0) goto L5;
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

        public Builder setBand(String r8) {
            if (r8 == null) goto L6;
            this.band_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBand1(String r8) {
            if (r8 == null) goto L6;
            this.band1_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBand1Bytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.band1_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBandBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.band_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5(String r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5Bytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setCcalevel(int r8) {
            this.ccalevel_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 16384;
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

        public Builder setLost(int r8) {
            this.lost_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setMloEnable(int r8) {
            this.mloEnable_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRttms(int r8) {
            this.rttms_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setRxLinkspeed(int r8) {
            this.rxLinkspeed_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setRxRealspeed(int r8) {
            this.rxRealspeed_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setSent(int r8) {
            this.sent_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setTxLinkspeed(int r8) {
            this.txLinkspeed_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setTxRealspeed(int r8) {
            this.txRealspeed_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifigeneration(String r8) {
            if (r8 == null) goto L6;
            this.wifigeneration_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWifigenerationBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wifigeneration_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.bssidMd5_ = "";
            this.wifigeneration_ = "";
            this.band_ = "";
            this.band1_ = "";
            this.deviceDate_ = "";
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_NetworkQualityStatusReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkQualityStatusReportData.class, Builder.class);
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
        public NetworkQualityStatusReportData build() {
            NetworkQualityStatusReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkQualityStatusReportData buildPartial() {
            NetworkQualityStatusReportData r8 = new NetworkQualityStatusReportData(this, null);
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
        public NetworkQualityStatusReportData getDefaultInstanceForType() {
            return NetworkQualityStatusReportData.getDefaultInstance();
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
            this.sent_ = 0;
            this.lost_ = 0;
            this.rttms_ = 0;
            this.bssidMd5_ = "";
            this.wifigeneration_ = "";
            this.mloEnable_ = 0;
            this.band_ = "";
            this.band1_ = "";
            this.txRealspeed_ = 0;
            this.rxRealspeed_ = 0;
            this.txLinkspeed_ = 0;
            this.rxLinkspeed_ = 0;
            this.ccalevel_ = 0;
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L38;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L35;
            int r12 = r8.readTag();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            switch(r12) {
                case 0: goto L25;
                case 10: goto L23;
                case 16: goto L22;
                case 24: goto L21;
                case 32: goto L20;
                case 42: goto L19;
                case 50: goto L18;
                case 56: goto L17;
                case 66: goto L16;
                case 74: goto L15;
                case 80: goto L14;
                case 88: goto L13;
                case 96: goto L12;
                case 104: goto L11;
                case 112: goto L10;
                case 120: goto L9;
                case 130: goto L8;
                default: goto L26;
            };     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
        L8:
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 32768;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L9:
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 16384;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L10:
            this.ccalevel_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 8192;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L11:
            this.rxLinkspeed_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 4096;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L12:
            this.txLinkspeed_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 2048;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L13:
            this.rxRealspeed_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 1024;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L14:
            this.txRealspeed_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 512;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L15:
            this.band1_ = r8.readBytes();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 256;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L16:
            this.band_ = r8.readBytes();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 128;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L17:
            this.mloEnable_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 64;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L18:
            this.wifigeneration_ = r8.readBytes();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 32;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L19:
            this.bssidMd5_ = r8.readBytes();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 16;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L20:
            this.rttms_ = r8.readUInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 8;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L21:
            this.lost_ = r8.readUInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 4;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L22:
            this.sent_ = r8.readUInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 2;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L23:
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 1;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
        L25:
            r11 = true;
            goto L4
        L26:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L28:
            th = move-exception;
            onChanged();
            throw th;
        L30:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L28
        L35:
            onChanged();
            return this;
        L38:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof NetworkQualityStatusReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NetworkQualityStatusReportData) r8);
        }

        public Builder mergeFrom(NetworkQualityStatusReportData r8) {
            if (r8 != NetworkQualityStatusReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = NetworkQualityStatusReportData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasSent() == false) goto L12;
            setSent(r8.getSent());
        L12:
            if (r8.hasLost() == false) goto L15;
            setLost(r8.getLost());
        L15:
            if (r8.hasRttms() == false) goto L18;
            setRttms(r8.getRttms());
        L18:
            if (r8.hasBssidMd5() == false) goto L21;
            this.bssidMd5_ = NetworkQualityStatusReportData.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasWifigeneration() == false) goto L24;
            this.wifigeneration_ = NetworkQualityStatusReportData.access$800(r8);
            this.bitField0_ |= 32;
            onChanged();
        L24:
            if (r8.hasMloEnable() == false) goto L27;
            setMloEnable(r8.getMloEnable());
        L27:
            if (r8.hasBand() == false) goto L30;
            this.band_ = NetworkQualityStatusReportData.access$1000(r8);
            this.bitField0_ |= 128;
            onChanged();
        L30:
            if (r8.hasBand1() == false) goto L33;
            this.band1_ = NetworkQualityStatusReportData.access$1100(r8);
            this.bitField0_ |= 256;
            onChanged();
        L33:
            if (r8.hasTxRealspeed() == false) goto L36;
            setTxRealspeed(r8.getTxRealspeed());
        L36:
            if (r8.hasRxRealspeed() == false) goto L39;
            setRxRealspeed(r8.getRxRealspeed());
        L39:
            if (r8.hasTxLinkspeed() == false) goto L42;
            setTxLinkspeed(r8.getTxLinkspeed());
        L42:
            if (r8.hasRxLinkspeed() == false) goto L45;
            setRxLinkspeed(r8.getRxLinkspeed());
        L45:
            if (r8.hasCcalevel() == false) goto L48;
            setCcalevel(r8.getCcalevel());
        L48:
            if (r8.hasDeviceTime() == false) goto L51;
            setDeviceTime(r8.getDeviceTime());
        L51:
            if (r8.hasDeviceDate() == false) goto L53;
            this.deviceDate_ = NetworkQualityStatusReportData.access$1800(r8);
            this.bitField0_ |= 32768;
            onChanged();
        L53:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new NetworkQualityStatusReportData();
        PARSER = new AnonymousClass1();
    }

    private NetworkQualityStatusReportData() {
        this.eventType_ = "";
        this.sent_ = 0;
        this.lost_ = 0;
        this.rttms_ = 0;
        this.bssidMd5_ = "";
        this.wifigeneration_ = "";
        this.mloEnable_ = 0;
        this.band_ = "";
        this.band1_ = "";
        this.txRealspeed_ = 0;
        this.rxRealspeed_ = 0;
        this.txLinkspeed_ = 0;
        this.rxLinkspeed_ = 0;
        this.ccalevel_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.bssidMd5_ = "";
        this.wifigeneration_ = "";
        this.band_ = "";
        this.band1_ = "";
        this.deviceDate_ = "";
    }

    public static /* synthetic */ Object access$1000(NetworkQualityStatusReportData r8) {
        return r8.band_;
    }

    public static /* synthetic */ Object access$1002(NetworkQualityStatusReportData r8, Object r10) {
        r8.band_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1100(NetworkQualityStatusReportData r8) {
        return r8.band1_;
    }

    public static /* synthetic */ Object access$1102(NetworkQualityStatusReportData r8, Object r10) {
        r8.band1_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(NetworkQualityStatusReportData r8, int r10) {
        r8.txRealspeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(NetworkQualityStatusReportData r8, int r10) {
        r8.rxRealspeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(NetworkQualityStatusReportData r8, int r10) {
        r8.txLinkspeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(NetworkQualityStatusReportData r8, int r10) {
        r8.rxLinkspeed_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(NetworkQualityStatusReportData r8, int r10) {
        r8.ccalevel_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1702(NetworkQualityStatusReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1800(NetworkQualityStatusReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$1802(NetworkQualityStatusReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1976(NetworkQualityStatusReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(NetworkQualityStatusReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$302(NetworkQualityStatusReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(NetworkQualityStatusReportData r8, int r10) {
        r8.sent_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(NetworkQualityStatusReportData r8, int r10) {
        r8.lost_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(NetworkQualityStatusReportData r8, int r10) {
        r8.rttms_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(NetworkQualityStatusReportData r8) {
        return r8.bssidMd5_;
    }

    public static /* synthetic */ Object access$702(NetworkQualityStatusReportData r8, Object r10) {
        r8.bssidMd5_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$800(NetworkQualityStatusReportData r8) {
        return r8.wifigeneration_;
    }

    public static /* synthetic */ Object access$802(NetworkQualityStatusReportData r8, Object r10) {
        r8.wifigeneration_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(NetworkQualityStatusReportData r8, int r10) {
        r8.mloEnable_ = r10;
        return r10;
    }

    public static NetworkQualityStatusReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_NetworkQualityStatusReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static NetworkQualityStatusReportData parseDelimitedFrom(InputStream r8) {
        return (NetworkQualityStatusReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static NetworkQualityStatusReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<NetworkQualityStatusReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NetworkQualityStatusReportData) == false) goto L8;
        NetworkQualityStatusReportData r10 = (NetworkQualityStatusReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasSent() == r10.hasSent()) goto L21;
        return false;
    L21:
        if (hasSent() == false) goto L26;
        if (getSent() == r10.getSent()) goto L26;
        return false;
    L26:
        if (hasLost() == r10.hasLost()) goto L29;
        return false;
    L29:
        if (hasLost() == false) goto L34;
        if (getLost() == r10.getLost()) goto L34;
        return false;
    L34:
        if (hasRttms() == r10.hasRttms()) goto L37;
        return false;
    L37:
        if (hasRttms() == false) goto L42;
        if (getRttms() == r10.getRttms()) goto L42;
        return false;
    L42:
        if (hasBssidMd5() == r10.hasBssidMd5()) goto L45;
        return false;
    L45:
        if (hasBssidMd5() == false) goto L50;
        if (getBssidMd5().equals(r10.getBssidMd5()) == true) goto L50;
        return false;
    L50:
        if (hasWifigeneration() == r10.hasWifigeneration()) goto L53;
        return false;
    L53:
        if (hasWifigeneration() == false) goto L58;
        if (getWifigeneration().equals(r10.getWifigeneration()) == true) goto L58;
        return false;
    L58:
        if (hasMloEnable() == r10.hasMloEnable()) goto L61;
        return false;
    L61:
        if (hasMloEnable() == false) goto L66;
        if (getMloEnable() == r10.getMloEnable()) goto L66;
        return false;
    L66:
        if (hasBand() == r10.hasBand()) goto L69;
        return false;
    L69:
        if (hasBand() == false) goto L74;
        if (getBand().equals(r10.getBand()) == true) goto L74;
        return false;
    L74:
        if (hasBand1() == r10.hasBand1()) goto L77;
        return false;
    L77:
        if (hasBand1() == false) goto L82;
        if (getBand1().equals(r10.getBand1()) == true) goto L82;
        return false;
    L82:
        if (hasTxRealspeed() == r10.hasTxRealspeed()) goto L85;
        return false;
    L85:
        if (hasTxRealspeed() == false) goto L90;
        if (getTxRealspeed() == r10.getTxRealspeed()) goto L90;
        return false;
    L90:
        if (hasRxRealspeed() == r10.hasRxRealspeed()) goto L93;
        return false;
    L93:
        if (hasRxRealspeed() == false) goto L98;
        if (getRxRealspeed() == r10.getRxRealspeed()) goto L98;
        return false;
    L98:
        if (hasTxLinkspeed() == r10.hasTxLinkspeed()) goto L101;
        return false;
    L101:
        if (hasTxLinkspeed() == false) goto L106;
        if (getTxLinkspeed() == r10.getTxLinkspeed()) goto L106;
        return false;
    L106:
        if (hasRxLinkspeed() == r10.hasRxLinkspeed()) goto L109;
        return false;
    L109:
        if (hasRxLinkspeed() == false) goto L114;
        if (getRxLinkspeed() == r10.getRxLinkspeed()) goto L114;
        return false;
    L114:
        if (hasCcalevel() == r10.hasCcalevel()) goto L117;
        return false;
    L117:
        if (hasCcalevel() == false) goto L122;
        if (getCcalevel() == r10.getCcalevel()) goto L122;
        return false;
    L122:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L125;
        return false;
    L125:
        if (hasDeviceTime() == false) goto L130;
        if (getDeviceTime() == r10.getDeviceTime()) goto L130;
        return false;
    L130:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L133;
        return false;
    L133:
        if (hasDeviceDate() == false) goto L138;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L138;
        return false;
    L138:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L140;
        return false;
    L140:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public ByteString getBand1Bytes() {
        Object r8 = this.band1_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.band1_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public ByteString getBandBytes() {
        Object r8 = this.band_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.band_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public String getBssidMd5() {
        Object r8 = this.bssidMd5_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.bssidMd5_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public ByteString getBssidMd5Bytes() {
        Object r8 = this.bssidMd5_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssidMd5_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getCcalevel() {
        return this.ccalevel_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getLost() {
        return this.lost_;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getMloEnable() {
        return this.mloEnable_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NetworkQualityStatusReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getRttms() {
        return this.rttms_;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getRxLinkspeed() {
        return this.rxLinkspeed_;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getRxRealspeed() {
        return this.rxRealspeed_;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getSent() {
        return this.sent_;
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
        r10 = r10 + CodedOutputStream.computeUInt32Size(2, this.sent_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeUInt32Size(3, this.lost_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeUInt32Size(4, this.rttms_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.bssidMd5_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + GeneratedMessage.computeStringSize(6, this.wifigeneration_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.mloEnable_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + GeneratedMessage.computeStringSize(8, this.band_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + GeneratedMessage.computeStringSize(9, this.band1_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.txRealspeed_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.rxRealspeed_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.txLinkspeed_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.rxLinkspeed_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.ccalevel_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeUInt64Size(15, this.deviceTime_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L53;
        r10 = r10 + GeneratedMessage.computeStringSize(16, this.deviceDate_);
    L53:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getTxLinkspeed() {
        return this.txLinkspeed_;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public int getTxRealspeed() {
        return this.txRealspeed_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public ByteString getWifigenerationBytes() {
        Object r8 = this.wifigeneration_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wifigeneration_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasBand() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasBand1() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasBssidMd5() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasCcalevel() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasLost() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasMloEnable() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasRttms() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasRxLinkspeed() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasRxRealspeed() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasSent() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasTxLinkspeed() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasTxRealspeed() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.NetworkQualityStatusReportDataOrBuilder
    public boolean hasWifigeneration() {
        if ((this.bitField0_ & 32) == 0) goto L5;
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
        if (hasSent() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getSent();
    L12:
        if (hasLost() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getLost();
    L15:
        if (hasRttms() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getRttms();
    L18:
        if (hasBssidMd5() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getBssidMd5().hashCode();
    L21:
        if (hasWifigeneration() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getWifigeneration().hashCode();
    L24:
        if (hasMloEnable() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getMloEnable();
    L27:
        if (hasBand() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getBand().hashCode();
    L30:
        if (hasBand1() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getBand1().hashCode();
    L33:
        if (hasTxRealspeed() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getTxRealspeed();
    L36:
        if (hasRxRealspeed() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getRxRealspeed();
    L39:
        if (hasTxLinkspeed() == false) goto L42;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getTxLinkspeed();
    L42:
        if (hasRxLinkspeed() == false) goto L45;
        r10 = defpackage.b.a(r10, 37, 13, 53) + getRxLinkspeed();
    L45:
        if (hasCcalevel() == false) goto L48;
        r10 = defpackage.b.a(r10, 37, 14, 53) + getCcalevel();
    L48:
        if (hasDeviceTime() == false) goto L51;
        r10 = defpackage.b.a(r10, 37, 15, 53) + Internal.hashLong(getDeviceTime());
    L51:
        if (hasDeviceDate() == false) goto L53;
        r10 = defpackage.b.a(r10, 37, 16, 53) + getDeviceDate().hashCode();
    L53:
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
        return new NetworkQualityStatusReportData();
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
        r8.writeUInt32(2, this.sent_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeUInt32(3, this.lost_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeUInt32(4, this.rttms_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.bssidMd5_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        GeneratedMessage.writeString(r8, 6, this.wifigeneration_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.mloEnable_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        GeneratedMessage.writeString(r8, 8, this.band_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        GeneratedMessage.writeString(r8, 9, this.band1_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.txRealspeed_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.rxRealspeed_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeInt32(12, this.txLinkspeed_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeInt32(13, this.rxLinkspeed_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeInt32(14, this.ccalevel_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeUInt64(15, this.deviceTime_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L50;
        GeneratedMessage.writeString(r8, 16, this.deviceDate_);
    L50:
        getUnknownFields().writeTo(r8);
    }

    private NetworkQualityStatusReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.sent_ = 0;
        this.lost_ = 0;
        this.rttms_ = 0;
        this.bssidMd5_ = "";
        this.wifigeneration_ = "";
        this.mloEnable_ = 0;
        this.band_ = "";
        this.band1_ = "";
        this.txRealspeed_ = 0;
        this.rxRealspeed_ = 0;
        this.txLinkspeed_ = 0;
        this.rxLinkspeed_ = 0;
        this.ccalevel_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(NetworkQualityStatusReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static NetworkQualityStatusReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkQualityStatusReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static NetworkQualityStatusReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_NetworkQualityStatusReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkQualityStatusReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ NetworkQualityStatusReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static NetworkQualityStatusReportData parseFrom(CodedInputStream r8) {
        return (NetworkQualityStatusReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NetworkQualityStatusReportData getDefaultInstanceForType() {
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

    public static NetworkQualityStatusReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NetworkQualityStatusReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static NetworkQualityStatusReportData parseFrom(InputStream r8) {
        return (NetworkQualityStatusReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static NetworkQualityStatusReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkQualityStatusReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static NetworkQualityStatusReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkQualityStatusReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static NetworkQualityStatusReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkQualityStatusReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
