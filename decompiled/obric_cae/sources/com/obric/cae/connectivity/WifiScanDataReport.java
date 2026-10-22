package com.obric.cae.connectivity;

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
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class WifiScanDataReport extends GeneratedMessageV3 implements WifiScanDataReportOrBuilder {
    public static final int BSSID_FIELD_NUMBER = 2;
    public static final int CAPABILITIES_FIELD_NUMBER = 7;
    public static final int CHANNEL_WIDTH_FIELD_NUMBER = 5;
    private static final WifiScanDataReport DEFAULT_INSTANCE = null;
    public static final int FREQUENCY_FIELD_NUMBER = 4;
    public static final int IS_PASSPOINT_NETWORK_FIELD_NUMBER = 8;
    public static final int IS_SUPPORT_80211MC_FIELD_NUMBER = 9;
    public static final int LEVEL_FIELD_NUMBER = 3;

    @Deprecated
    public static final Parser<WifiScanDataReport> PARSER = null;
    public static final int SCAN_TIMESTAMP_MS_FIELD_NUMBER = 10;
    public static final int SSID_FIELD_NUMBER = 1;
    public static final int WIFI_STANDARD_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object bssid_;
    private volatile Object capabilities_;
    private int channelWidth_;
    private int frequency_;
    private boolean isPasspointNetwork_;
    private boolean isSupport80211Mc_;
    private int level_;
    private byte memoizedIsInitialized;
    private long scanTimestampMs_;
    private volatile Object ssid_;
    private int wifiStandard_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiScanDataReportOrBuilder {
        private int bitField0_;
        private Object bssid_;
        private Object capabilities_;
        private int channelWidth_;
        private int frequency_;
        private boolean isPasspointNetwork_;
        private boolean isSupport80211Mc_;
        private int level_;
        private long scanTimestampMs_;
        private Object ssid_;
        private int wifiStandard_;

        private Builder() {
            this.ssid_ = "";
            this.bssid_ = "";
            this.capabilities_ = "";
        }

        private void buildPartial0(WifiScanDataReport r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            WifiScanDataReport.access$302(r8, this.ssid_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            WifiScanDataReport.access$402(r8, this.bssid_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            WifiScanDataReport.access$502(r8, this.level_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            WifiScanDataReport.access$602(r8, this.frequency_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            WifiScanDataReport.access$702(r8, this.channelWidth_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            WifiScanDataReport.access$802(r8, this.wifiStandard_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            WifiScanDataReport.access$902(r8, this.capabilities_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            WifiScanDataReport.access$1002(r8, this.isPasspointNetwork_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            WifiScanDataReport.access$1102(r8, this.isSupport80211Mc_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L33;
            WifiScanDataReport.access$1202(r8, this.scanTimestampMs_);
            r11 = r11 | 512;
        L33:
            WifiScanDataReport.access$1376(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_WifiScanDataReport_descriptor;
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

        public Builder clearBssid() {
            this.bssid_ = WifiScanDataReport.getDefaultInstance().getBssid();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearCapabilities() {
            this.capabilities_ = WifiScanDataReport.getDefaultInstance().getCapabilities();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder clearChannelWidth() {
            this.bitField0_ &= -17;
            this.channelWidth_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearFrequency() {
            this.bitField0_ &= -9;
            this.frequency_ = 0;
            onChanged();
            return this;
        }

        public Builder clearIsPasspointNetwork() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.isPasspointNetwork_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsSupport80211Mc() {
            this.bitField0_ &= -257;
            this.isSupport80211Mc_ = false;
            onChanged();
            return this;
        }

        public Builder clearLevel() {
            this.bitField0_ &= -5;
            this.level_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearScanTimestampMs() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.scanTimestampMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSsid() {
            this.ssid_ = WifiScanDataReport.getDefaultInstance().getSsid();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearWifiStandard() {
            this.bitField0_ &= -33;
            this.wifiStandard_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
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

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public ByteString getBssidBytes() {
            Object r8 = this.bssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.bssid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public String getCapabilities() {
            Object r8 = this.capabilities_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.capabilities_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public ByteString getCapabilitiesBytes() {
            Object r8 = this.capabilities_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.capabilities_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public int getChannelWidth() {
            return this.channelWidth_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_WifiScanDataReport_descriptor;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public int getFrequency() {
            return this.frequency_;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean getIsPasspointNetwork() {
            return this.isPasspointNetwork_;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean getIsSupport80211Mc() {
            return this.isSupport80211Mc_;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public long getScanTimestampMs() {
            return this.scanTimestampMs_;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public String getSsid() {
            Object r8 = this.ssid_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.ssid_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public ByteString getSsidBytes() {
            Object r8 = this.ssid_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.ssid_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public int getWifiStandard() {
            return this.wifiStandard_;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasBssid() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasCapabilities() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasChannelWidth() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasFrequency() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasIsPasspointNetwork() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasIsSupport80211Mc() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasLevel() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasScanTimestampMs() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasSsid() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
        public boolean hasWifiStandard() {
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

        public Builder setCapabilities(String r8) {
            if (r8 == null) goto L6;
            this.capabilities_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setCapabilitiesBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.capabilities_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setChannelWidth(int r8) {
            this.channelWidth_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setFrequency(int r8) {
            this.frequency_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setIsPasspointNetwork(boolean r8) {
            this.isPasspointNetwork_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setIsSupport80211Mc(boolean r8) {
            this.isSupport80211Mc_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setLevel(int r8) {
            this.level_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setScanTimestampMs(long r8) {
            this.scanTimestampMs_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setSsid(String r8) {
            if (r8 == null) goto L6;
            this.ssid_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSsidBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.ssid_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiStandard(int r8) {
            this.wifiStandard_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.ssid_ = "";
            this.bssid_ = "";
            this.capabilities_ = "";
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
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_WifiScanDataReport_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiScanDataReport.class, Builder.class);
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
        public WifiScanDataReport build() {
            WifiScanDataReport r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WifiScanDataReport buildPartial() {
            WifiScanDataReport r8 = new WifiScanDataReport(this, null);
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
        public WifiScanDataReport getDefaultInstanceForType() {
            return WifiScanDataReport.getDefaultInstance();
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
            this.ssid_ = "";
            this.bssid_ = "";
            this.level_ = 0;
            this.frequency_ = 0;
            this.channelWidth_ = 0;
            this.wifiStandard_ = 0;
            this.capabilities_ = "";
            this.isPasspointNetwork_ = false;
            this.isSupport80211Mc_ = false;
            this.scanTimestampMs_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L32;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L29;
            int r12 = r8.readTag();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            switch(r12) {
                case 0: goto L19;
                case 10: goto L17;
                case 18: goto L16;
                case 24: goto L15;
                case 32: goto L14;
                case 40: goto L13;
                case 48: goto L12;
                case 58: goto L11;
                case 64: goto L10;
                case 72: goto L9;
                case 80: goto L8;
                default: goto L20;
            };     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
        L8:
            this.scanTimestampMs_ = r8.readUInt64();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 512;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L9:
            this.isSupport80211Mc_ = r8.readBool();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 256;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L10:
            this.isPasspointNetwork_ = r8.readBool();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 128;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L11:
            this.capabilities_ = r8.readBytes();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 64;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L12:
            this.wifiStandard_ = r8.readInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 32;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L13:
            this.channelWidth_ = r8.readInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 16;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L14:
            this.frequency_ = r8.readInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 8;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L15:
            this.level_ = r8.readInt32();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 4;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L16:
            this.bssid_ = r8.readBytes();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 2;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L17:
            this.ssid_ = r8.readBytes();     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
            this.bitField0_ |= 1;     // Catch: Throwable -> L22 InvalidProtocolBufferException -> L24
        L19:
            r11 = true;
            goto L4
        L20:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L24:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            onChanged();
            throw th;
        L29:
            onChanged();
            return this;
        L32:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof WifiScanDataReport) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((WifiScanDataReport) r8);
        }

        public Builder mergeFrom(WifiScanDataReport r8) {
            if (r8 != WifiScanDataReport.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSsid() == false) goto L9;
            this.ssid_ = WifiScanDataReport.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasBssid() == false) goto L12;
            this.bssid_ = WifiScanDataReport.access$400(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasLevel() == false) goto L15;
            setLevel(r8.getLevel());
        L15:
            if (r8.hasFrequency() == false) goto L18;
            setFrequency(r8.getFrequency());
        L18:
            if (r8.hasChannelWidth() == false) goto L21;
            setChannelWidth(r8.getChannelWidth());
        L21:
            if (r8.hasWifiStandard() == false) goto L24;
            setWifiStandard(r8.getWifiStandard());
        L24:
            if (r8.hasCapabilities() == false) goto L27;
            this.capabilities_ = WifiScanDataReport.access$900(r8);
            this.bitField0_ |= 64;
            onChanged();
        L27:
            if (r8.hasIsPasspointNetwork() == false) goto L30;
            setIsPasspointNetwork(r8.getIsPasspointNetwork());
        L30:
            if (r8.hasIsSupport80211Mc() == false) goto L33;
            setIsSupport80211Mc(r8.getIsSupport80211Mc());
        L33:
            if (r8.hasScanTimestampMs() == false) goto L35;
            setScanTimestampMs(r8.getScanTimestampMs());
        L35:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new WifiScanDataReport();
        PARSER = new AnonymousClass1();
    }

    private WifiScanDataReport() {
        this.ssid_ = "";
        this.bssid_ = "";
        this.level_ = 0;
        this.frequency_ = 0;
        this.channelWidth_ = 0;
        this.wifiStandard_ = 0;
        this.capabilities_ = "";
        this.isPasspointNetwork_ = false;
        this.isSupport80211Mc_ = false;
        this.scanTimestampMs_ = 0;
        this.memoizedIsInitialized = -1;
        this.ssid_ = "";
        this.bssid_ = "";
        this.capabilities_ = "";
    }

    public static /* synthetic */ boolean access$1002(WifiScanDataReport r8, boolean r10) {
        r8.isPasspointNetwork_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1102(WifiScanDataReport r8, boolean r10) {
        r8.isSupport80211Mc_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1202(WifiScanDataReport r8, long r10) {
        r8.scanTimestampMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1376(WifiScanDataReport r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(WifiScanDataReport r8) {
        return r8.ssid_;
    }

    public static /* synthetic */ Object access$302(WifiScanDataReport r8, Object r10) {
        r8.ssid_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(WifiScanDataReport r8) {
        return r8.bssid_;
    }

    public static /* synthetic */ Object access$402(WifiScanDataReport r8, Object r10) {
        r8.bssid_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(WifiScanDataReport r8, int r10) {
        r8.level_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(WifiScanDataReport r8, int r10) {
        r8.frequency_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(WifiScanDataReport r8, int r10) {
        r8.channelWidth_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(WifiScanDataReport r8, int r10) {
        r8.wifiStandard_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$900(WifiScanDataReport r8) {
        return r8.capabilities_;
    }

    public static /* synthetic */ Object access$902(WifiScanDataReport r8, Object r10) {
        r8.capabilities_ = r10;
        return r10;
    }

    public static WifiScanDataReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_WifiScanDataReport_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static WifiScanDataReport parseDelimitedFrom(InputStream r8) {
        return (WifiScanDataReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static WifiScanDataReport parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<WifiScanDataReport> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof WifiScanDataReport) == false) goto L8;
        WifiScanDataReport r10 = (WifiScanDataReport) r8;
        if (hasSsid() == r10.hasSsid()) goto L13;
        return false;
    L13:
        if (hasSsid() == false) goto L18;
        if (getSsid().equals(r10.getSsid()) == true) goto L18;
        return false;
    L18:
        if (hasBssid() == r10.hasBssid()) goto L21;
        return false;
    L21:
        if (hasBssid() == false) goto L26;
        if (getBssid().equals(r10.getBssid()) == true) goto L26;
        return false;
    L26:
        if (hasLevel() == r10.hasLevel()) goto L29;
        return false;
    L29:
        if (hasLevel() == false) goto L34;
        if (getLevel() == r10.getLevel()) goto L34;
        return false;
    L34:
        if (hasFrequency() == r10.hasFrequency()) goto L37;
        return false;
    L37:
        if (hasFrequency() == false) goto L42;
        if (getFrequency() == r10.getFrequency()) goto L42;
        return false;
    L42:
        if (hasChannelWidth() == r10.hasChannelWidth()) goto L45;
        return false;
    L45:
        if (hasChannelWidth() == false) goto L50;
        if (getChannelWidth() == r10.getChannelWidth()) goto L50;
        return false;
    L50:
        if (hasWifiStandard() == r10.hasWifiStandard()) goto L53;
        return false;
    L53:
        if (hasWifiStandard() == false) goto L58;
        if (getWifiStandard() == r10.getWifiStandard()) goto L58;
        return false;
    L58:
        if (hasCapabilities() == r10.hasCapabilities()) goto L61;
        return false;
    L61:
        if (hasCapabilities() == false) goto L66;
        if (getCapabilities().equals(r10.getCapabilities()) == true) goto L66;
        return false;
    L66:
        if (hasIsPasspointNetwork() == r10.hasIsPasspointNetwork()) goto L69;
        return false;
    L69:
        if (hasIsPasspointNetwork() == false) goto L74;
        if (getIsPasspointNetwork() == r10.getIsPasspointNetwork()) goto L74;
        return false;
    L74:
        if (hasIsSupport80211Mc() == r10.hasIsSupport80211Mc()) goto L77;
        return false;
    L77:
        if (hasIsSupport80211Mc() == false) goto L82;
        if (getIsSupport80211Mc() == r10.getIsSupport80211Mc()) goto L82;
        return false;
    L82:
        if (hasScanTimestampMs() == r10.hasScanTimestampMs()) goto L85;
        return false;
    L85:
        if (hasScanTimestampMs() == false) goto L90;
        if (getScanTimestampMs() == r10.getScanTimestampMs()) goto L90;
        return false;
    L90:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L92;
        return false;
    L92:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
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

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public ByteString getBssidBytes() {
        Object r8 = this.bssid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.bssid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public String getCapabilities() {
        Object r8 = this.capabilities_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.capabilities_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public ByteString getCapabilitiesBytes() {
        Object r8 = this.capabilities_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.capabilities_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public int getChannelWidth() {
        return this.channelWidth_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public int getFrequency() {
        return this.frequency_;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean getIsPasspointNetwork() {
        return this.isPasspointNetwork_;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean getIsSupport80211Mc() {
        return this.isSupport80211Mc_;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public int getLevel() {
        return this.level_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WifiScanDataReport> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public long getScanTimestampMs() {
        return this.scanTimestampMs_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + GeneratedMessage.computeStringSize(1, this.ssid_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + GeneratedMessage.computeStringSize(2, this.bssid_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.level_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.frequency_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.channelWidth_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.wifiStandard_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + GeneratedMessage.computeStringSize(7, this.capabilities_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeBoolSize(8, this.isPasspointNetwork_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeBoolSize(9, this.isSupport80211Mc_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L35;
        r10 = r10 + CodedOutputStream.computeUInt64Size(10, this.scanTimestampMs_);
    L35:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public String getSsid() {
        Object r8 = this.ssid_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.ssid_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public ByteString getSsidBytes() {
        Object r8 = this.ssid_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.ssid_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public int getWifiStandard() {
        return this.wifiStandard_;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasBssid() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasCapabilities() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasChannelWidth() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasFrequency() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasIsPasspointNetwork() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasIsSupport80211Mc() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasLevel() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasScanTimestampMs() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasSsid() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.connectivity.WifiScanDataReportOrBuilder
    public boolean hasWifiStandard() {
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
        if (hasSsid() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSsid().hashCode();
    L9:
        if (hasBssid() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getBssid().hashCode();
    L12:
        if (hasLevel() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getLevel();
    L15:
        if (hasFrequency() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getFrequency();
    L18:
        if (hasChannelWidth() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getChannelWidth();
    L21:
        if (hasWifiStandard() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getWifiStandard();
    L24:
        if (hasCapabilities() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getCapabilities().hashCode();
    L27:
        if (hasIsPasspointNetwork() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + Internal.hashBoolean(getIsPasspointNetwork());
    L30:
        if (hasIsSupport80211Mc() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + Internal.hashBoolean(getIsSupport80211Mc());
    L33:
        if (hasScanTimestampMs() == false) goto L35;
        r10 = b.a(r10, 37, 10, 53) + Internal.hashLong(getScanTimestampMs());
    L35:
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
        return new WifiScanDataReport();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.ssid_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.bssid_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.level_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.frequency_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.channelWidth_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.wifiStandard_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        GeneratedMessage.writeString(r8, 7, this.capabilities_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeBool(8, this.isPasspointNetwork_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeBool(9, this.isSupport80211Mc_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L32;
        r8.writeUInt64(10, this.scanTimestampMs_);
    L32:
        getUnknownFields().writeTo(r8);
    }

    private WifiScanDataReport(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.ssid_ = "";
        this.bssid_ = "";
        this.level_ = 0;
        this.frequency_ = 0;
        this.channelWidth_ = 0;
        this.wifiStandard_ = 0;
        this.capabilities_ = "";
        this.isPasspointNetwork_ = false;
        this.isSupport80211Mc_ = false;
        this.scanTimestampMs_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(WifiScanDataReport r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static WifiScanDataReport parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanDataReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static WifiScanDataReport parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_WifiScanDataReport_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiScanDataReport.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ WifiScanDataReport(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static WifiScanDataReport parseFrom(CodedInputStream r8) {
        return (WifiScanDataReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public WifiScanDataReport getDefaultInstanceForType() {
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

    public static WifiScanDataReport parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanDataReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static WifiScanDataReport parseFrom(InputStream r8) {
        return (WifiScanDataReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static WifiScanDataReport parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (WifiScanDataReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static WifiScanDataReport parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiScanDataReport parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static WifiScanDataReport parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static WifiScanDataReport parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
