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
public final class ConnectionTimeReportData extends GeneratedMessageV3 implements ConnectionTimeReportDataOrBuilder {
    public static final int BAND1_FIELD_NUMBER = 5;
    public static final int BAND_FIELD_NUMBER = 4;
    public static final int BSSID_FIELD_NUMBER = 2;
    public static final int BSSID_MD5_FIELD_NUMBER = 3;
    private static final ConnectionTimeReportData DEFAULT_INSTANCE = null;
    public static final int DEVICE_DATE_FIELD_NUMBER = 12;
    public static final int DEVICE_TIME_FIELD_NUMBER = 11;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    public static final int FREQUENCY1_FIELD_NUMBER = 7;
    public static final int FREQUENCY_FIELD_NUMBER = 6;
    public static final int MLO_ENABLE_FIELD_NUMBER = 10;

    @Deprecated
    public static final Parser<ConnectionTimeReportData> PARSER = null;
    public static final int TIME_SECONDS_FIELD_NUMBER = 8;
    public static final int WIFIGENERATION_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private volatile Object band1_;
    private volatile Object band_;
    private int bitField0_;
    private volatile Object bssidMd5_;
    private volatile Object bssid_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private int frequency1_;
    private int frequency_;
    private byte memoizedIsInitialized;
    private int mloEnable_;
    private long timeSeconds_;
    private volatile Object wifigeneration_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConnectionTimeReportDataOrBuilder {
        private Object band1_;
        private Object band_;
        private int bitField0_;
        private Object bssidMd5_;
        private Object bssid_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private int frequency1_;
        private int frequency_;
        private int mloEnable_;
        private long timeSeconds_;
        private Object wifigeneration_;

        private Builder() {
            this.eventType_ = "";
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.band_ = "";
            this.band1_ = "";
            this.wifigeneration_ = "";
            this.deviceDate_ = "";
        }

        private void buildPartial0(ConnectionTimeReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            ConnectionTimeReportData.access$302(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            ConnectionTimeReportData.access$402(r8, this.bssid_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            ConnectionTimeReportData.access$502(r8, this.bssidMd5_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            ConnectionTimeReportData.access$602(r8, this.band_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            ConnectionTimeReportData.access$702(r8, this.band1_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            ConnectionTimeReportData.access$802(r8, this.frequency_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            ConnectionTimeReportData.access$902(r8, this.frequency1_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            ConnectionTimeReportData.access$1002(r8, this.timeSeconds_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            ConnectionTimeReportData.access$1102(r8, this.wifigeneration_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            ConnectionTimeReportData.access$1202(r8, this.mloEnable_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            ConnectionTimeReportData.access$1302(r8, this.deviceTime_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L39;
            ConnectionTimeReportData.access$1402(r8, this.deviceDate_);
            r11 = r11 | 2048;
        L39:
            ConnectionTimeReportData.access$1576(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_ConnectionTimeReportData_descriptor;
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
            this.band_ = ConnectionTimeReportData.getDefaultInstance().getBand();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearBand1() {
            this.band1_ = ConnectionTimeReportData.getDefaultInstance().getBand1();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearBssid() {
            this.bssid_ = ConnectionTimeReportData.getDefaultInstance().getBssid();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearBssidMd5() {
            this.bssidMd5_ = ConnectionTimeReportData.getDefaultInstance().getBssidMd5();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearDeviceDate() {
            this.deviceDate_ = ConnectionTimeReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -1025;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = ConnectionTimeReportData.getDefaultInstance().getEventType();
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

        public Builder clearFrequency1() {
            this.bitField0_ &= -65;
            this.frequency1_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMloEnable() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.mloEnable_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearTimeSeconds() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.timeSeconds_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifigeneration() {
            this.wifigeneration_ = ConnectionTimeReportData.getDefaultInstance().getWifigeneration();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public ByteString getBand1Bytes() {
            Object r8 = this.band1_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.band1_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public ByteString getBandBytes() {
            Object r8 = this.band_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.band_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public ByteString getBssidBytes() {
            Object r8 = this.bssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_ConnectionTimeReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public int getFrequency() {
            return this.frequency_;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public int getFrequency1() {
            return this.frequency1_;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public int getMloEnable() {
            return this.mloEnable_;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public long getTimeSeconds() {
            return this.timeSeconds_;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public ByteString getWifigenerationBytes() {
            Object r8 = this.wifigeneration_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.wifigeneration_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasBand() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasBand1() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasBssid() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasBssidMd5() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasFrequency() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasFrequency1() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasMloEnable() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasTimeSeconds() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
        public boolean hasWifigeneration() {
            if ((this.bitField0_ & 256) == 0) goto L5;
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
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBand1(String r8) {
            if (r8 == null) goto L6;
            this.band1_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBand1Bytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.band1_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBandBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.band_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssid(String r8) {
            if (r8 == null) goto L6;
            this.bssid_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.bssid_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5(String r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setBssidMd5Bytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.bssidMd5_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 1024;
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

        public Builder setFrequency1(int r8) {
            this.frequency1_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setMloEnable(int r8) {
            this.mloEnable_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setTimeSeconds(long r8) {
            this.timeSeconds_ = r8;
            this.bitField0_ |= 128;
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
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setWifigenerationBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.wifigeneration_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.band_ = "";
            this.band1_ = "";
            this.wifigeneration_ = "";
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_ConnectionTimeReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectionTimeReportData.class, Builder.class);
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
        public ConnectionTimeReportData build() {
            ConnectionTimeReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ConnectionTimeReportData buildPartial() {
            ConnectionTimeReportData r8 = new ConnectionTimeReportData(this, null);
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
        public ConnectionTimeReportData getDefaultInstanceForType() {
            return ConnectionTimeReportData.getDefaultInstance();
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
            this.bssid_ = "";
            this.bssidMd5_ = "";
            this.band_ = "";
            this.band1_ = "";
            this.frequency_ = 0;
            this.frequency1_ = 0;
            this.timeSeconds_ = 0;
            this.wifigeneration_ = "";
            this.mloEnable_ = 0;
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
            if (r10 == null) goto L34;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L31;
            int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            switch(r12) {
                case 0: goto L21;
                case 10: goto L19;
                case 18: goto L18;
                case 26: goto L17;
                case 34: goto L16;
                case 42: goto L15;
                case 48: goto L14;
                case 56: goto L13;
                case 64: goto L12;
                case 74: goto L11;
                case 80: goto L10;
                case 88: goto L9;
                case 98: goto L8;
                default: goto L22;
            };     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L8:
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2048;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L9:
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1024;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            this.mloEnable_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 512;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L11:
            this.wifigeneration_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 256;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            this.timeSeconds_ = r8.readUInt64();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 128;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L13:
            this.frequency1_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 64;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L14:
            this.frequency_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 32;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L15:
            this.band1_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 16;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L16:
            this.band_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L17:
            this.bssidMd5_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L18:
            this.bssid_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
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
            if ((r8 instanceof ConnectionTimeReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((ConnectionTimeReportData) r8);
        }

        public Builder mergeFrom(ConnectionTimeReportData r8) {
            if (r8 != ConnectionTimeReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = ConnectionTimeReportData.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasBssid() == false) goto L12;
            this.bssid_ = ConnectionTimeReportData.access$400(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasBssidMd5() == false) goto L15;
            this.bssidMd5_ = ConnectionTimeReportData.access$500(r8);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r8.hasBand() == false) goto L18;
            this.band_ = ConnectionTimeReportData.access$600(r8);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r8.hasBand1() == false) goto L21;
            this.band1_ = ConnectionTimeReportData.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasFrequency() == false) goto L24;
            setFrequency(r8.getFrequency());
        L24:
            if (r8.hasFrequency1() == false) goto L27;
            setFrequency1(r8.getFrequency1());
        L27:
            if (r8.hasTimeSeconds() == false) goto L30;
            setTimeSeconds(r8.getTimeSeconds());
        L30:
            if (r8.hasWifigeneration() == false) goto L33;
            this.wifigeneration_ = ConnectionTimeReportData.access$1100(r8);
            this.bitField0_ |= 256;
            onChanged();
        L33:
            if (r8.hasMloEnable() == false) goto L36;
            setMloEnable(r8.getMloEnable());
        L36:
            if (r8.hasDeviceTime() == false) goto L39;
            setDeviceTime(r8.getDeviceTime());
        L39:
            if (r8.hasDeviceDate() == false) goto L41;
            this.deviceDate_ = ConnectionTimeReportData.access$1400(r8);
            this.bitField0_ |= 2048;
            onChanged();
        L41:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new ConnectionTimeReportData();
        PARSER = new AnonymousClass1();
    }

    private ConnectionTimeReportData() {
        this.eventType_ = "";
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.band_ = "";
        this.band1_ = "";
        this.frequency_ = 0;
        this.frequency1_ = 0;
        this.timeSeconds_ = 0;
        this.wifigeneration_ = "";
        this.mloEnable_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.band_ = "";
        this.band1_ = "";
        this.wifigeneration_ = "";
        this.deviceDate_ = "";
    }

    public static /* synthetic */ long access$1002(ConnectionTimeReportData r8, long r10) {
        r8.timeSeconds_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1100(ConnectionTimeReportData r8) {
        return r8.wifigeneration_;
    }

    public static /* synthetic */ Object access$1102(ConnectionTimeReportData r8, Object r10) {
        r8.wifigeneration_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(ConnectionTimeReportData r8, int r10) {
        r8.mloEnable_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1302(ConnectionTimeReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1400(ConnectionTimeReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$1402(ConnectionTimeReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1576(ConnectionTimeReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(ConnectionTimeReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$302(ConnectionTimeReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(ConnectionTimeReportData r8) {
        return r8.bssid_;
    }

    public static /* synthetic */ Object access$402(ConnectionTimeReportData r8, Object r10) {
        r8.bssid_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(ConnectionTimeReportData r8) {
        return r8.bssidMd5_;
    }

    public static /* synthetic */ Object access$502(ConnectionTimeReportData r8, Object r10) {
        r8.bssidMd5_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$600(ConnectionTimeReportData r8) {
        return r8.band_;
    }

    public static /* synthetic */ Object access$602(ConnectionTimeReportData r8, Object r10) {
        r8.band_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(ConnectionTimeReportData r8) {
        return r8.band1_;
    }

    public static /* synthetic */ Object access$702(ConnectionTimeReportData r8, Object r10) {
        r8.band1_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(ConnectionTimeReportData r8, int r10) {
        r8.frequency_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(ConnectionTimeReportData r8, int r10) {
        r8.frequency1_ = r10;
        return r10;
    }

    public static ConnectionTimeReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_ConnectionTimeReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ConnectionTimeReportData parseDelimitedFrom(InputStream r8) {
        return (ConnectionTimeReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static ConnectionTimeReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<ConnectionTimeReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof ConnectionTimeReportData) == false) goto L8;
        ConnectionTimeReportData r10 = (ConnectionTimeReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasBssid() == r10.hasBssid()) goto L21;
        return false;
    L21:
        if (hasBssid() == false) goto L26;
        if (getBssid().equals(r10.getBssid()) == true) goto L26;
        return false;
    L26:
        if (hasBssidMd5() == r10.hasBssidMd5()) goto L29;
        return false;
    L29:
        if (hasBssidMd5() == false) goto L34;
        if (getBssidMd5().equals(r10.getBssidMd5()) == true) goto L34;
        return false;
    L34:
        if (hasBand() == r10.hasBand()) goto L37;
        return false;
    L37:
        if (hasBand() == false) goto L42;
        if (getBand().equals(r10.getBand()) == true) goto L42;
        return false;
    L42:
        if (hasBand1() == r10.hasBand1()) goto L45;
        return false;
    L45:
        if (hasBand1() == false) goto L50;
        if (getBand1().equals(r10.getBand1()) == true) goto L50;
        return false;
    L50:
        if (hasFrequency() == r10.hasFrequency()) goto L53;
        return false;
    L53:
        if (hasFrequency() == false) goto L58;
        if (getFrequency() == r10.getFrequency()) goto L58;
        return false;
    L58:
        if (hasFrequency1() == r10.hasFrequency1()) goto L61;
        return false;
    L61:
        if (hasFrequency1() == false) goto L66;
        if (getFrequency1() == r10.getFrequency1()) goto L66;
        return false;
    L66:
        if (hasTimeSeconds() == r10.hasTimeSeconds()) goto L69;
        return false;
    L69:
        if (hasTimeSeconds() == false) goto L74;
        if (getTimeSeconds() == r10.getTimeSeconds()) goto L74;
        return false;
    L74:
        if (hasWifigeneration() == r10.hasWifigeneration()) goto L77;
        return false;
    L77:
        if (hasWifigeneration() == false) goto L82;
        if (getWifigeneration().equals(r10.getWifigeneration()) == true) goto L82;
        return false;
    L82:
        if (hasMloEnable() == r10.hasMloEnable()) goto L85;
        return false;
    L85:
        if (hasMloEnable() == false) goto L90;
        if (getMloEnable() == r10.getMloEnable()) goto L90;
        return false;
    L90:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L93;
        return false;
    L93:
        if (hasDeviceTime() == false) goto L98;
        if (getDeviceTime() == r10.getDeviceTime()) goto L98;
        return false;
    L98:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L101;
        return false;
    L101:
        if (hasDeviceDate() == false) goto L106;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L106;
        return false;
    L106:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L108;
        return false;
    L108:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public ByteString getBand1Bytes() {
        Object r8 = this.band1_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.band1_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public ByteString getBandBytes() {
        Object r8 = this.band_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.band_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public ByteString getBssidBytes() {
        Object r8 = this.bssid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public int getFrequency() {
        return this.frequency_;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public int getFrequency1() {
        return this.frequency1_;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public int getMloEnable() {
        return this.mloEnable_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ConnectionTimeReportData> getParserForType() {
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
        r10 = 0 + GeneratedMessage.computeStringSize(1, this.eventType_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + GeneratedMessage.computeStringSize(2, this.bssid_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.bssidMd5_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + GeneratedMessage.computeStringSize(4, this.band_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.band1_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.frequency_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.frequency1_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeUInt64Size(8, this.timeSeconds_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + GeneratedMessage.computeStringSize(9, this.wifigeneration_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.mloEnable_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeUInt64Size(11, this.deviceTime_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L41;
        r10 = r10 + GeneratedMessage.computeStringSize(12, this.deviceDate_);
    L41:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public long getTimeSeconds() {
        return this.timeSeconds_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
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

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public ByteString getWifigenerationBytes() {
        Object r8 = this.wifigeneration_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.wifigeneration_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasBand() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasBand1() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasBssid() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasBssidMd5() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasFrequency() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasFrequency1() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasMloEnable() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasTimeSeconds() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.ConnectionTimeReportDataOrBuilder
    public boolean hasWifigeneration() {
        if ((this.bitField0_ & 256) == 0) goto L5;
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
        if (hasBssid() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getBssid().hashCode();
    L12:
        if (hasBssidMd5() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getBssidMd5().hashCode();
    L15:
        if (hasBand() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getBand().hashCode();
    L18:
        if (hasBand1() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getBand1().hashCode();
    L21:
        if (hasFrequency() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getFrequency();
    L24:
        if (hasFrequency1() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getFrequency1();
    L27:
        if (hasTimeSeconds() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + Internal.hashLong(getTimeSeconds());
    L30:
        if (hasWifigeneration() == false) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getWifigeneration().hashCode();
    L33:
        if (hasMloEnable() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getMloEnable();
    L36:
        if (hasDeviceTime() == false) goto L39;
        r10 = defpackage.b.a(r10, 37, 11, 53) + Internal.hashLong(getDeviceTime());
    L39:
        if (hasDeviceDate() == false) goto L41;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getDeviceDate().hashCode();
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
        return new ConnectionTimeReportData();
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
        GeneratedMessage.writeString(r8, 2, this.bssid_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r8, 3, this.bssidMd5_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        GeneratedMessage.writeString(r8, 4, this.band_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.band1_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.frequency_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.frequency1_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeUInt64(8, this.timeSeconds_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        GeneratedMessage.writeString(r8, 9, this.wifigeneration_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.mloEnable_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeUInt64(11, this.deviceTime_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L38;
        GeneratedMessage.writeString(r8, 12, this.deviceDate_);
    L38:
        getUnknownFields().writeTo(r8);
    }

    private ConnectionTimeReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.bssid_ = "";
        this.bssidMd5_ = "";
        this.band_ = "";
        this.band1_ = "";
        this.frequency_ = 0;
        this.frequency1_ = 0;
        this.timeSeconds_ = 0;
        this.wifigeneration_ = "";
        this.mloEnable_ = 0;
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(ConnectionTimeReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static ConnectionTimeReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (ConnectionTimeReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static ConnectionTimeReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_ConnectionTimeReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(ConnectionTimeReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ ConnectionTimeReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static ConnectionTimeReportData parseFrom(CodedInputStream r8) {
        return (ConnectionTimeReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public ConnectionTimeReportData getDefaultInstanceForType() {
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

    public static ConnectionTimeReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (ConnectionTimeReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static ConnectionTimeReportData parseFrom(InputStream r8) {
        return (ConnectionTimeReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static ConnectionTimeReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (ConnectionTimeReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static ConnectionTimeReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static ConnectionTimeReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static ConnectionTimeReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static ConnectionTimeReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
