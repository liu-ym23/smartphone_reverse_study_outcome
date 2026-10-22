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
public final class PoorLinkDisconnectReportData extends GeneratedMessageV3 implements PoorLinkDisconnectReportDataOrBuilder {
    public static final int AVG_THROUGHPUT_KBPS_FIELD_NUMBER = 9;
    public static final int BSSID_FIELD_NUMBER = 5;
    public static final int BSSID_MD5_FIELD_NUMBER = 6;
    private static final PoorLinkDisconnectReportData DEFAULT_INSTANCE = null;
    public static final int DESTINATION_NETWORK_FIELD_NUMBER = 11;
    public static final int DEVICE_DATE_FIELD_NUMBER = 3;
    public static final int DEVICE_TIME_FIELD_NUMBER = 2;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int FOREGROUND_APP_FIELD_NUMBER = 12;
    public static final int IS_INTERNET_RECOVERED_FIELD_NUMBER = 10;

    @Deprecated
    public static final Parser<PoorLinkDisconnectReportData> PARSER = null;
    public static final int RSSI_FIELD_NUMBER = 8;
    public static final int TRIGGER_ID_FIELD_NUMBER = 4;
    public static final int WIFI_BAND_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int avgThroughputKbps_;
    private int bitField0_;
    private volatile Object bssidMd5_;
    private volatile Object bssid_;
    private int destinationNetwork_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private volatile Object foregroundApp_;
    private int isInternetRecovered_;
    private byte memoizedIsInitialized;
    private int rssi_;
    private int triggerId_;
    private int wifiBand_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PoorLinkDisconnectReportDataOrBuilder {
        private int avgThroughputKbps_;
        private int bitField0_;
        private Object bssidMd5_;
        private Object bssid_;
        private int destinationNetwork_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private Object foregroundApp_;
        private int isInternetRecovered_;
        private int rssi_;
        private int triggerId_;
        private int wifiBand_;

        private Builder() {
            this.eventType_ = "";
            this.deviceDate_ = "";
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.foregroundApp_ = "";
        }

        private void buildPartial0(PoorLinkDisconnectReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            PoorLinkDisconnectReportData.access$302(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            PoorLinkDisconnectReportData.access$402(r8, this.deviceTime_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            PoorLinkDisconnectReportData.access$502(r8, this.deviceDate_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            PoorLinkDisconnectReportData.access$602(r8, this.triggerId_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            PoorLinkDisconnectReportData.access$702(r8, this.bssid_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            PoorLinkDisconnectReportData.access$802(r8, this.bssidMd5_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            PoorLinkDisconnectReportData.access$902(r8, this.wifiBand_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            PoorLinkDisconnectReportData.access$1002(r8, this.rssi_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            PoorLinkDisconnectReportData.access$1102(r8, this.avgThroughputKbps_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            PoorLinkDisconnectReportData.access$1202(r8, this.isInternetRecovered_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            PoorLinkDisconnectReportData.access$1302(r8, this.destinationNetwork_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L39;
            PoorLinkDisconnectReportData.access$1402(r8, this.foregroundApp_);
            r11 = r11 | 2048;
        L39:
            PoorLinkDisconnectReportData.access$1576(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_PoorLinkDisconnectReportData_descriptor;
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

        public Builder clearAvgThroughputKbps() {
            this.bitField0_ &= -257;
            this.avgThroughputKbps_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBssid() {
            this.bssid_ = PoorLinkDisconnectReportData.getDefaultInstance().getBssid();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearBssidMd5() {
            this.bssidMd5_ = PoorLinkDisconnectReportData.getDefaultInstance().getBssidMd5();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder clearDestinationNetwork() {
            this.bitField0_ &= -1025;
            this.destinationNetwork_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = PoorLinkDisconnectReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -3;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = PoorLinkDisconnectReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearForegroundApp() {
            this.foregroundApp_ = PoorLinkDisconnectReportData.getDefaultInstance().getForegroundApp();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder clearIsInternetRecovered() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.isInternetRecovered_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearRssi() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.rssi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTriggerId() {
            this.bitField0_ &= -9;
            this.triggerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiBand() {
            this.bitField0_ &= -65;
            this.wifiBand_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public int getAvgThroughputKbps() {
            return this.avgThroughputKbps_;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public String getBssid() {
            Object r8 = this.bssid_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.bssid_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public ByteString getBssidBytes() {
            Object r8 = this.bssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public ByteString getBssidMd5Bytes() {
            Object r8 = this.bssidMd5_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssidMd5_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_PoorLinkDisconnectReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public int getDestinationNetwork() {
            return this.destinationNetwork_;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public ByteString getForegroundAppBytes() {
            Object r8 = this.foregroundApp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.foregroundApp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public int getIsInternetRecovered() {
            return this.isInternetRecovered_;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public int getRssi() {
            return this.rssi_;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public int getTriggerId() {
            return this.triggerId_;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public int getWifiBand() {
            return this.wifiBand_;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasAvgThroughputKbps() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasBssid() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasBssidMd5() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasDestinationNetwork() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasForegroundApp() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasIsInternetRecovered() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasRssi() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasTriggerId() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
        public boolean hasWifiBand() {
            if ((this.bitField0_ & 64) == 0) goto L5;
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

        public Builder setAvgThroughputKbps(int r8) {
            this.avgThroughputKbps_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setBssid(String r8) {
            if (r8 == null) goto L6;
            this.bssid_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.bssid_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5(String r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5Bytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDestinationNetwork(int r8) {
            this.destinationNetwork_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 2;
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

        public Builder setForegroundApp(String r8) {
            if (r8 == null) goto L6;
            this.foregroundApp_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setForegroundAppBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.foregroundApp_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setIsInternetRecovered(int r8) {
            this.isInternetRecovered_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRssi(int r8) {
            this.rssi_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setTriggerId(int r8) {
            this.triggerId_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiBand(int r8) {
            this.wifiBand_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.deviceDate_ = "";
            this.bssid_ = "";
            this.bssidMd5_ = "";
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_PoorLinkDisconnectReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(PoorLinkDisconnectReportData.class, Builder.class);
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
        public PoorLinkDisconnectReportData build() {
            PoorLinkDisconnectReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PoorLinkDisconnectReportData buildPartial() {
            PoorLinkDisconnectReportData r8 = new PoorLinkDisconnectReportData(this, null);
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
        public PoorLinkDisconnectReportData getDefaultInstanceForType() {
            return PoorLinkDisconnectReportData.getDefaultInstance();
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
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            this.triggerId_ = 0;
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.wifiBand_ = 0;
            this.rssi_ = 0;
            this.avgThroughputKbps_ = 0;
            this.isInternetRecovered_ = 0;
            this.destinationNetwork_ = 0;
            this.foregroundApp_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L34;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L31;
            int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            switch(r12) {
                case 0: goto L21;
                case 10: goto L19;
                case 16: goto L18;
                case 26: goto L17;
                case 32: goto L16;
                case 42: goto L15;
                case 50: goto L14;
                case 56: goto L13;
                case 64: goto L12;
                case 72: goto L11;
                case 80: goto L10;
                case 88: goto L9;
                case 98: goto L8;
                default: goto L22;
            };     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L8:
            this.foregroundApp_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2048;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L9:
            this.destinationNetwork_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1024;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            this.isInternetRecovered_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 512;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L11:
            this.avgThroughputKbps_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 256;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            this.rssi_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 128;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L13:
            this.wifiBand_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 64;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L14:
            this.bssidMd5_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 32;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L15:
            this.bssid_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 16;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L16:
            this.triggerId_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L17:
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L18:
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L19:
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L21:
            r11 = true;
            goto L4
        L22:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L24:
            th = move-exception;
            onChanged();
            throw th;
        L26:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L24
        L31:
            onChanged();
            return this;
        L34:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof PoorLinkDisconnectReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((PoorLinkDisconnectReportData) r8);
        }

        public Builder mergeFrom(PoorLinkDisconnectReportData r8) {
            if (r8 != PoorLinkDisconnectReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = PoorLinkDisconnectReportData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasDeviceTime() == false) goto L12;
            setDeviceTime(r8.getDeviceTime());
        L12:
            if (r8.hasDeviceDate() == false) goto L15;
            this.deviceDate_ = PoorLinkDisconnectReportData.access$500(r8);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r8.hasTriggerId() == false) goto L18;
            setTriggerId(r8.getTriggerId());
        L18:
            if (r8.hasBssid() == false) goto L21;
            this.bssid_ = PoorLinkDisconnectReportData.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasBssidMd5() == false) goto L24;
            this.bssidMd5_ = PoorLinkDisconnectReportData.access$800(r8);
            this.bitField0_ |= 32;
            onChanged();
        L24:
            if (r8.hasWifiBand() == false) goto L27;
            setWifiBand(r8.getWifiBand());
        L27:
            if (r8.hasRssi() == false) goto L30;
            setRssi(r8.getRssi());
        L30:
            if (r8.hasAvgThroughputKbps() == false) goto L33;
            setAvgThroughputKbps(r8.getAvgThroughputKbps());
        L33:
            if (r8.hasIsInternetRecovered() == false) goto L36;
            setIsInternetRecovered(r8.getIsInternetRecovered());
        L36:
            if (r8.hasDestinationNetwork() == false) goto L39;
            setDestinationNetwork(r8.getDestinationNetwork());
        L39:
            if (r8.hasForegroundApp() == false) goto L41;
            this.foregroundApp_ = PoorLinkDisconnectReportData.access$1400(r8);
            this.bitField0_ |= 2048;
            onChanged();
        L41:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new PoorLinkDisconnectReportData();
        PARSER = new AnonymousClass1();
    }

    private PoorLinkDisconnectReportData() {
        this.eventType_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.triggerId_ = 0;
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.wifiBand_ = 0;
        this.rssi_ = 0;
        this.avgThroughputKbps_ = 0;
        this.isInternetRecovered_ = 0;
        this.destinationNetwork_ = 0;
        this.foregroundApp_ = "";
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.deviceDate_ = "";
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.foregroundApp_ = "";
    }

    public static /* synthetic */ int access$1002(PoorLinkDisconnectReportData r8, int r10) {
        r8.rssi_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(PoorLinkDisconnectReportData r8, int r10) {
        r8.avgThroughputKbps_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(PoorLinkDisconnectReportData r8, int r10) {
        r8.isInternetRecovered_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(PoorLinkDisconnectReportData r8, int r10) {
        r8.destinationNetwork_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1400(PoorLinkDisconnectReportData r8) {
        return r8.foregroundApp_;
    }

    public static /* synthetic */ Object access$1402(PoorLinkDisconnectReportData r8, Object r10) {
        r8.foregroundApp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1576(PoorLinkDisconnectReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(PoorLinkDisconnectReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$302(PoorLinkDisconnectReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$402(PoorLinkDisconnectReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(PoorLinkDisconnectReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$502(PoorLinkDisconnectReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(PoorLinkDisconnectReportData r8, int r10) {
        r8.triggerId_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(PoorLinkDisconnectReportData r8) {
        return r8.bssid_;
    }

    public static /* synthetic */ Object access$702(PoorLinkDisconnectReportData r8, Object r10) {
        r8.bssid_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$800(PoorLinkDisconnectReportData r8) {
        return r8.bssidMd5_;
    }

    public static /* synthetic */ Object access$802(PoorLinkDisconnectReportData r8, Object r10) {
        r8.bssidMd5_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(PoorLinkDisconnectReportData r8, int r10) {
        r8.wifiBand_ = r10;
        return r10;
    }

    public static PoorLinkDisconnectReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_PoorLinkDisconnectReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PoorLinkDisconnectReportData parseDelimitedFrom(InputStream r8) {
        return (PoorLinkDisconnectReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static PoorLinkDisconnectReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<PoorLinkDisconnectReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof PoorLinkDisconnectReportData) == false) goto L8;
        PoorLinkDisconnectReportData r10 = (PoorLinkDisconnectReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L21;
        return false;
    L21:
        if (hasDeviceTime() == false) goto L26;
        if (getDeviceTime() == r10.getDeviceTime()) goto L26;
        return false;
    L26:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L29;
        return false;
    L29:
        if (hasDeviceDate() == false) goto L34;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L34;
        return false;
    L34:
        if (hasTriggerId() == r10.hasTriggerId()) goto L37;
        return false;
    L37:
        if (hasTriggerId() == false) goto L42;
        if (getTriggerId() == r10.getTriggerId()) goto L42;
        return false;
    L42:
        if (hasBssid() == r10.hasBssid()) goto L45;
        return false;
    L45:
        if (hasBssid() == false) goto L50;
        if (getBssid().equals(r10.getBssid()) == true) goto L50;
        return false;
    L50:
        if (hasBssidMd5() == r10.hasBssidMd5()) goto L53;
        return false;
    L53:
        if (hasBssidMd5() == false) goto L58;
        if (getBssidMd5().equals(r10.getBssidMd5()) == true) goto L58;
        return false;
    L58:
        if (hasWifiBand() == r10.hasWifiBand()) goto L61;
        return false;
    L61:
        if (hasWifiBand() == false) goto L66;
        if (getWifiBand() == r10.getWifiBand()) goto L66;
        return false;
    L66:
        if (hasRssi() == r10.hasRssi()) goto L69;
        return false;
    L69:
        if (hasRssi() == false) goto L74;
        if (getRssi() == r10.getRssi()) goto L74;
        return false;
    L74:
        if (hasAvgThroughputKbps() == r10.hasAvgThroughputKbps()) goto L77;
        return false;
    L77:
        if (hasAvgThroughputKbps() == false) goto L82;
        if (getAvgThroughputKbps() == r10.getAvgThroughputKbps()) goto L82;
        return false;
    L82:
        if (hasIsInternetRecovered() == r10.hasIsInternetRecovered()) goto L85;
        return false;
    L85:
        if (hasIsInternetRecovered() == false) goto L90;
        if (getIsInternetRecovered() == r10.getIsInternetRecovered()) goto L90;
        return false;
    L90:
        if (hasDestinationNetwork() == r10.hasDestinationNetwork()) goto L93;
        return false;
    L93:
        if (hasDestinationNetwork() == false) goto L98;
        if (getDestinationNetwork() == r10.getDestinationNetwork()) goto L98;
        return false;
    L98:
        if (hasForegroundApp() == r10.hasForegroundApp()) goto L101;
        return false;
    L101:
        if (hasForegroundApp() == false) goto L106;
        if (getForegroundApp().equals(r10.getForegroundApp()) == true) goto L106;
        return false;
    L106:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L108;
        return false;
    L108:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public int getAvgThroughputKbps() {
        return this.avgThroughputKbps_;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public String getBssid() {
        Object r8 = this.bssid_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.bssid_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public ByteString getBssidBytes() {
        Object r8 = this.bssid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public ByteString getBssidMd5Bytes() {
        Object r8 = this.bssidMd5_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssidMd5_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public int getDestinationNetwork() {
        return this.destinationNetwork_;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public ByteString getForegroundAppBytes() {
        Object r8 = this.foregroundApp_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.foregroundApp_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public int getIsInternetRecovered() {
        return this.isInternetRecovered_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PoorLinkDisconnectReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public int getRssi() {
        return this.rssi_;
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
        r10 = r10 + CodedOutputStream.computeUInt64Size(2, this.deviceTime_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.deviceDate_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.triggerId_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.bssid_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + GeneratedMessage.computeStringSize(6, this.bssidMd5_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.wifiBand_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt32Size(8, this.rssi_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.avgThroughputKbps_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.isInternetRecovered_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.destinationNetwork_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L41;
        r10 = r10 + GeneratedMessage.computeStringSize(12, this.foregroundApp_);
    L41:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public int getTriggerId() {
        return this.triggerId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public int getWifiBand() {
        return this.wifiBand_;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasAvgThroughputKbps() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasBssid() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasBssidMd5() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasDestinationNetwork() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasForegroundApp() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasIsInternetRecovered() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasRssi() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasTriggerId() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.PoorLinkDisconnectReportDataOrBuilder
    public boolean hasWifiBand() {
        if ((this.bitField0_ & 64) == 0) goto L5;
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
        if (hasDeviceTime() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashLong(getDeviceTime());
    L12:
        if (hasDeviceDate() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getDeviceDate().hashCode();
    L15:
        if (hasTriggerId() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getTriggerId();
    L18:
        if (hasBssid() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getBssid().hashCode();
    L21:
        if (hasBssidMd5() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getBssidMd5().hashCode();
    L24:
        if (hasWifiBand() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getWifiBand();
    L27:
        if (hasRssi() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getRssi();
    L30:
        if (hasAvgThroughputKbps() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getAvgThroughputKbps();
    L33:
        if (hasIsInternetRecovered() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getIsInternetRecovered();
    L36:
        if (hasDestinationNetwork() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getDestinationNetwork();
    L39:
        if (hasForegroundApp() == false) goto L41;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getForegroundApp().hashCode();
    L41:
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
        return new PoorLinkDisconnectReportData();
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
        r8.writeUInt64(2, this.deviceTime_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r8, 3, this.deviceDate_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.triggerId_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.bssid_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        GeneratedMessage.writeString(r8, 6, this.bssidMd5_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.wifiBand_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt32(8, this.rssi_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.avgThroughputKbps_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.isInternetRecovered_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.destinationNetwork_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L38;
        GeneratedMessage.writeString(r8, 12, this.foregroundApp_);
    L38:
        getUnknownFields().writeTo(r8);
    }

    private PoorLinkDisconnectReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.triggerId_ = 0;
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.wifiBand_ = 0;
        this.rssi_ = 0;
        this.avgThroughputKbps_ = 0;
        this.isInternetRecovered_ = 0;
        this.destinationNetwork_ = 0;
        this.foregroundApp_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(PoorLinkDisconnectReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static PoorLinkDisconnectReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (PoorLinkDisconnectReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static PoorLinkDisconnectReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_PoorLinkDisconnectReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(PoorLinkDisconnectReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ PoorLinkDisconnectReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static PoorLinkDisconnectReportData parseFrom(CodedInputStream r8) {
        return (PoorLinkDisconnectReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public PoorLinkDisconnectReportData getDefaultInstanceForType() {
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

    public static PoorLinkDisconnectReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (PoorLinkDisconnectReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PoorLinkDisconnectReportData parseFrom(InputStream r8) {
        return (PoorLinkDisconnectReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static PoorLinkDisconnectReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (PoorLinkDisconnectReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static PoorLinkDisconnectReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static PoorLinkDisconnectReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static PoorLinkDisconnectReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static PoorLinkDisconnectReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
