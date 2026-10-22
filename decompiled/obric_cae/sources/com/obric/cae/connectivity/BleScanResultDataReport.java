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
public final class BleScanResultDataReport extends GeneratedMessageV3 implements BleScanResultDataReportOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 5;
    public static final int ADDRESS_TYPE_FIELD_NUMBER = 4;
    public static final int ADVERTISE_FLAGS_FIELD_NUMBER = 14;
    public static final int ADVERTISING_SID_FIELD_NUMBER = 9;
    private static final BleScanResultDataReport DEFAULT_INSTANCE = null;
    public static final int DEVICE_NAME_FIELD_NUMBER = 13;
    public static final int EVENT_TYPE_FIELD_NUMBER = 3;
    public static final int MANUFACTURER_SPECIFIC_DATA_FIELD_NUMBER = 17;
    public static final int ORIGINAL_ADDRESS_FIELD_NUMBER = 6;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<BleScanResultDataReport> PARSER = null;
    public static final int PERIODIC_ADV_INT_FIELD_NUMBER = 12;
    public static final int PRIMARY_PHY_FIELD_NUMBER = 7;
    public static final int RSSI_FIELD_NUMBER = 11;
    public static final int SECONDARY_PHY_FIELD_NUMBER = 8;
    public static final int SERVICE_DATA_FIELD_NUMBER = 18;
    public static final int SERVICE_SOLICITATION_UUIDS_FIELD_NUMBER = 16;
    public static final int SERVICE_UUIDS_FIELD_NUMBER = 15;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int TRANSPORT_DISCOVERY_DATA_FIELD_NUMBER = 19;
    public static final int TX_POWER_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private int addressType_;
    private volatile Object address_;
    private int advertiseFlags_;
    private int advertisingSid_;
    private int bitField0_;
    private volatile Object deviceName_;
    private int eventType_;
    private volatile Object manufacturerSpecificData_;
    private byte memoizedIsInitialized;
    private volatile Object originalAddress_;
    private volatile Object packageName_;
    private int periodicAdvInt_;
    private int primaryPhy_;
    private int rssi_;
    private int secondaryPhy_;
    private volatile Object serviceData_;
    private volatile Object serviceSolicitationUuids_;
    private volatile Object serviceUuids_;
    private long timestamp_;
    private volatile Object transportDiscoveryData_;
    private int txPower_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BleScanResultDataReportOrBuilder {
        private int addressType_;
        private Object address_;
        private int advertiseFlags_;
        private int advertisingSid_;
        private int bitField0_;
        private Object deviceName_;
        private int eventType_;
        private Object manufacturerSpecificData_;
        private Object originalAddress_;
        private Object packageName_;
        private int periodicAdvInt_;
        private int primaryPhy_;
        private int rssi_;
        private int secondaryPhy_;
        private Object serviceData_;
        private Object serviceSolicitationUuids_;
        private Object serviceUuids_;
        private long timestamp_;
        private Object transportDiscoveryData_;
        private int txPower_;

        private Builder() {
            this.packageName_ = "";
            this.address_ = "";
            this.originalAddress_ = "";
            this.deviceName_ = "";
            this.serviceUuids_ = "";
            this.serviceSolicitationUuids_ = "";
            this.manufacturerSpecificData_ = "";
            this.serviceData_ = "";
            this.transportDiscoveryData_ = "";
        }

        private void buildPartial0(BleScanResultDataReport r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            BleScanResultDataReport.access$302(r8, this.packageName_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            BleScanResultDataReport.access$402(r8, this.timestamp_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            BleScanResultDataReport.access$502(r8, this.eventType_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            BleScanResultDataReport.access$602(r8, this.addressType_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            BleScanResultDataReport.access$702(r8, this.address_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            BleScanResultDataReport.access$802(r8, this.originalAddress_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            BleScanResultDataReport.access$902(r8, this.primaryPhy_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            BleScanResultDataReport.access$1002(r8, this.secondaryPhy_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            BleScanResultDataReport.access$1102(r8, this.advertisingSid_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            BleScanResultDataReport.access$1202(r8, this.txPower_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            BleScanResultDataReport.access$1302(r8, this.rssi_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            BleScanResultDataReport.access$1402(r8, this.periodicAdvInt_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            BleScanResultDataReport.access$1502(r8, this.deviceName_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            BleScanResultDataReport.access$1602(r8, this.advertiseFlags_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            BleScanResultDataReport.access$1702(r8, this.serviceUuids_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            BleScanResultDataReport.access$1802(r8, this.serviceSolicitationUuids_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            BleScanResultDataReport.access$1902(r8, this.manufacturerSpecificData_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            BleScanResultDataReport.access$2002(r8, this.serviceData_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L60;
            BleScanResultDataReport.access$2102(r8, this.transportDiscoveryData_);
            r11 = r11 | 262144;
        L60:
            BleScanResultDataReport.access$2276(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_BleScanResultDataReport_descriptor;
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

        public Builder clearAddress() {
            this.address_ = BleScanResultDataReport.getDefaultInstance().getAddress();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearAddressType() {
            this.bitField0_ &= -9;
            this.addressType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAdvertiseFlags() {
            this.bitField0_ &= -8193;
            this.advertiseFlags_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAdvertisingSid() {
            this.bitField0_ &= -257;
            this.advertisingSid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceName() {
            this.deviceName_ = BleScanResultDataReport.getDefaultInstance().getDeviceName();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.bitField0_ &= -5;
            this.eventType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearManufacturerSpecificData() {
            this.manufacturerSpecificData_ = BleScanResultDataReport.getDefaultInstance().getManufacturerSpecificData();
            this.bitField0_ &= -65537;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearOriginalAddress() {
            this.originalAddress_ = BleScanResultDataReport.getDefaultInstance().getOriginalAddress();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder clearPackageName() {
            this.packageName_ = BleScanResultDataReport.getDefaultInstance().getPackageName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearPeriodicAdvInt() {
            this.bitField0_ &= -2049;
            this.periodicAdvInt_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPrimaryPhy() {
            this.bitField0_ &= -65;
            this.primaryPhy_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRssi() {
            this.bitField0_ &= -1025;
            this.rssi_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSecondaryPhy() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.secondaryPhy_ = 0;
            onChanged();
            return this;
        }

        public Builder clearServiceData() {
            this.serviceData_ = BleScanResultDataReport.getDefaultInstance().getServiceData();
            this.bitField0_ &= -131073;
            onChanged();
            return this;
        }

        public Builder clearServiceSolicitationUuids() {
            this.serviceSolicitationUuids_ = BleScanResultDataReport.getDefaultInstance().getServiceSolicitationUuids();
            this.bitField0_ &= -32769;
            onChanged();
            return this;
        }

        public Builder clearServiceUuids() {
            this.serviceUuids_ = BleScanResultDataReport.getDefaultInstance().getServiceUuids();
            this.bitField0_ &= -16385;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -3;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTransportDiscoveryData() {
            this.transportDiscoveryData_ = BleScanResultDataReport.getDefaultInstance().getTransportDiscoveryData();
            this.bitField0_ &= -262145;
            onChanged();
            return this;
        }

        public Builder clearTxPower() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.txPower_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getAddress() {
            Object r8 = this.address_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.address_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getAddressBytes() {
            Object r8 = this.address_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.address_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getAddressType() {
            return this.addressType_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getAdvertiseFlags() {
            return this.advertiseFlags_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getAdvertisingSid() {
            return this.advertisingSid_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_BleScanResultDataReport_descriptor;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getDeviceName() {
            Object r8 = this.deviceName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.deviceName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getDeviceNameBytes() {
            Object r8 = this.deviceName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getEventType() {
            return this.eventType_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getManufacturerSpecificData() {
            Object r8 = this.manufacturerSpecificData_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.manufacturerSpecificData_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getManufacturerSpecificDataBytes() {
            Object r8 = this.manufacturerSpecificData_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.manufacturerSpecificData_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getOriginalAddress() {
            Object r8 = this.originalAddress_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.originalAddress_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getOriginalAddressBytes() {
            Object r8 = this.originalAddress_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.originalAddress_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
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

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getPackageNameBytes() {
            Object r8 = this.packageName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.packageName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getPeriodicAdvInt() {
            return this.periodicAdvInt_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getPrimaryPhy() {
            return this.primaryPhy_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getRssi() {
            return this.rssi_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getSecondaryPhy() {
            return this.secondaryPhy_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getServiceData() {
            Object r8 = this.serviceData_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.serviceData_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getServiceDataBytes() {
            Object r8 = this.serviceData_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.serviceData_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getServiceSolicitationUuids() {
            Object r8 = this.serviceSolicitationUuids_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.serviceSolicitationUuids_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getServiceSolicitationUuidsBytes() {
            Object r8 = this.serviceSolicitationUuids_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.serviceSolicitationUuids_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getServiceUuids() {
            Object r8 = this.serviceUuids_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.serviceUuids_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getServiceUuidsBytes() {
            Object r8 = this.serviceUuids_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.serviceUuids_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public String getTransportDiscoveryData() {
            Object r8 = this.transportDiscoveryData_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.transportDiscoveryData_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public ByteString getTransportDiscoveryDataBytes() {
            Object r8 = this.transportDiscoveryData_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.transportDiscoveryData_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public int getTxPower() {
            return this.txPower_;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasAddress() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasAddressType() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasAdvertiseFlags() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasAdvertisingSid() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasDeviceName() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasManufacturerSpecificData() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasOriginalAddress() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasPeriodicAdvInt() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasPrimaryPhy() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasRssi() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasSecondaryPhy() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasServiceData() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasServiceSolicitationUuids() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasServiceUuids() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasTransportDiscoveryData() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
        public boolean hasTxPower() {
            if ((this.bitField0_ & 512) == 0) goto L5;
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

        public Builder setAddress(String r8) {
            if (r8 == null) goto L6;
            this.address_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setAddressBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.address_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setAddressType(int r8) {
            this.addressType_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setAdvertiseFlags(int r8) {
            this.advertiseFlags_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setAdvertisingSid(int r8) {
            this.advertisingSid_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setDeviceName(String r8) {
            if (r8 == null) goto L6;
            this.deviceName_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceName_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEventType(int r8) {
            this.eventType_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setManufacturerSpecificData(String r8) {
            if (r8 == null) goto L6;
            this.manufacturerSpecificData_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setManufacturerSpecificDataBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.manufacturerSpecificData_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setOriginalAddress(String r8) {
            if (r8 == null) goto L6;
            this.originalAddress_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setOriginalAddressBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.originalAddress_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setPackageName(String r8) {
            if (r8 == null) goto L6;
            this.packageName_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setPackageNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.packageName_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setPeriodicAdvInt(int r8) {
            this.periodicAdvInt_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setPrimaryPhy(int r8) {
            this.primaryPhy_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRssi(int r8) {
            this.rssi_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setSecondaryPhy(int r8) {
            this.secondaryPhy_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setServiceData(String r8) {
            if (r8 == null) goto L6;
            this.serviceData_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setServiceDataBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.serviceData_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setServiceSolicitationUuids(String r8) {
            if (r8 == null) goto L6;
            this.serviceSolicitationUuids_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setServiceSolicitationUuidsBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.serviceSolicitationUuids_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setServiceUuids(String r8) {
            if (r8 == null) goto L6;
            this.serviceUuids_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setServiceUuidsBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.serviceUuids_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setTransportDiscoveryData(String r8) {
            if (r8 == null) goto L6;
            this.transportDiscoveryData_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTransportDiscoveryDataBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.transportDiscoveryData_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTxPower(int r8) {
            this.txPower_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.packageName_ = "";
            this.address_ = "";
            this.originalAddress_ = "";
            this.deviceName_ = "";
            this.serviceUuids_ = "";
            this.serviceSolicitationUuids_ = "";
            this.manufacturerSpecificData_ = "";
            this.serviceData_ = "";
            this.transportDiscoveryData_ = "";
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
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_BleScanResultDataReport_fieldAccessorTable.ensureFieldAccessorsInitialized(BleScanResultDataReport.class, Builder.class);
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
        public BleScanResultDataReport build() {
            BleScanResultDataReport r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BleScanResultDataReport buildPartial() {
            BleScanResultDataReport r8 = new BleScanResultDataReport(this, null);
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
        public BleScanResultDataReport getDefaultInstanceForType() {
            return BleScanResultDataReport.getDefaultInstance();
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
            this.packageName_ = "";
            this.timestamp_ = 0;
            this.eventType_ = 0;
            this.addressType_ = 0;
            this.address_ = "";
            this.originalAddress_ = "";
            this.primaryPhy_ = 0;
            this.secondaryPhy_ = 0;
            this.advertisingSid_ = 0;
            this.txPower_ = 0;
            this.rssi_ = 0;
            this.periodicAdvInt_ = 0;
            this.deviceName_ = "";
            this.advertiseFlags_ = 0;
            this.serviceUuids_ = "";
            this.serviceSolicitationUuids_ = "";
            this.manufacturerSpecificData_ = "";
            this.serviceData_ = "";
            this.transportDiscoveryData_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L41;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L38;
            int r12 = r8.readTag();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            switch(r12) {
                case 0: goto L28;
                case 10: goto L26;
                case 16: goto L25;
                case 24: goto L24;
                case 32: goto L23;
                case 42: goto L22;
                case 50: goto L21;
                case 56: goto L20;
                case 64: goto L19;
                case 72: goto L18;
                case 80: goto L17;
                case 88: goto L16;
                case 96: goto L15;
                case 106: goto L14;
                case 112: goto L13;
                case 122: goto L12;
                case 130: goto L11;
                case 138: goto L10;
                case 146: goto L9;
                case 154: goto L8;
                default: goto L29;
            };     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L8:
            this.transportDiscoveryData_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 262144;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L9:
            this.serviceData_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 131072;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L10:
            this.manufacturerSpecificData_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 65536;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L11:
            this.serviceSolicitationUuids_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 32768;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L12:
            this.serviceUuids_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 16384;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L13:
            this.advertiseFlags_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 8192;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L14:
            this.deviceName_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 4096;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L15:
            this.periodicAdvInt_ = r8.readUInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 2048;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L16:
            this.rssi_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 1024;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L17:
            this.txPower_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 512;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L18:
            this.advertisingSid_ = r8.readUInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 256;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L19:
            this.secondaryPhy_ = r8.readUInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 128;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L20:
            this.primaryPhy_ = r8.readUInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 64;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L21:
            this.originalAddress_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 32;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L22:
            this.address_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 16;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L23:
            this.addressType_ = r8.readUInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 8;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L24:
            this.eventType_ = r8.readUInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 4;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L25:
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 2;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L26:
            this.packageName_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 1;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L28:
            r11 = true;
            goto L4
        L29:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L33:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            onChanged();
            throw th;
        L38:
            onChanged();
            return this;
        L41:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof BleScanResultDataReport) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((BleScanResultDataReport) r8);
        }

        public Builder mergeFrom(BleScanResultDataReport r8) {
            if (r8 != BleScanResultDataReport.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasPackageName() == false) goto L9;
            this.packageName_ = BleScanResultDataReport.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasTimestamp() == false) goto L12;
            setTimestamp(r8.getTimestamp());
        L12:
            if (r8.hasEventType() == false) goto L15;
            setEventType(r8.getEventType());
        L15:
            if (r8.hasAddressType() == false) goto L18;
            setAddressType(r8.getAddressType());
        L18:
            if (r8.hasAddress() == false) goto L21;
            this.address_ = BleScanResultDataReport.access$700(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasOriginalAddress() == false) goto L24;
            this.originalAddress_ = BleScanResultDataReport.access$800(r8);
            this.bitField0_ |= 32;
            onChanged();
        L24:
            if (r8.hasPrimaryPhy() == false) goto L27;
            setPrimaryPhy(r8.getPrimaryPhy());
        L27:
            if (r8.hasSecondaryPhy() == false) goto L30;
            setSecondaryPhy(r8.getSecondaryPhy());
        L30:
            if (r8.hasAdvertisingSid() == false) goto L33;
            setAdvertisingSid(r8.getAdvertisingSid());
        L33:
            if (r8.hasTxPower() == false) goto L36;
            setTxPower(r8.getTxPower());
        L36:
            if (r8.hasRssi() == false) goto L39;
            setRssi(r8.getRssi());
        L39:
            if (r8.hasPeriodicAdvInt() == false) goto L42;
            setPeriodicAdvInt(r8.getPeriodicAdvInt());
        L42:
            if (r8.hasDeviceName() == false) goto L45;
            this.deviceName_ = BleScanResultDataReport.access$1500(r8);
            this.bitField0_ |= 4096;
            onChanged();
        L45:
            if (r8.hasAdvertiseFlags() == false) goto L48;
            setAdvertiseFlags(r8.getAdvertiseFlags());
        L48:
            if (r8.hasServiceUuids() == false) goto L51;
            this.serviceUuids_ = BleScanResultDataReport.access$1700(r8);
            this.bitField0_ |= 16384;
            onChanged();
        L51:
            if (r8.hasServiceSolicitationUuids() == false) goto L54;
            this.serviceSolicitationUuids_ = BleScanResultDataReport.access$1800(r8);
            this.bitField0_ |= 32768;
            onChanged();
        L54:
            if (r8.hasManufacturerSpecificData() == false) goto L57;
            this.manufacturerSpecificData_ = BleScanResultDataReport.access$1900(r8);
            this.bitField0_ |= 65536;
            onChanged();
        L57:
            if (r8.hasServiceData() == false) goto L60;
            this.serviceData_ = BleScanResultDataReport.access$2000(r8);
            this.bitField0_ |= 131072;
            onChanged();
        L60:
            if (r8.hasTransportDiscoveryData() == false) goto L62;
            this.transportDiscoveryData_ = BleScanResultDataReport.access$2100(r8);
            this.bitField0_ |= 262144;
            onChanged();
        L62:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new BleScanResultDataReport();
        PARSER = new AnonymousClass1();
    }

    private BleScanResultDataReport() {
        this.packageName_ = "";
        this.timestamp_ = 0;
        this.eventType_ = 0;
        this.addressType_ = 0;
        this.address_ = "";
        this.originalAddress_ = "";
        this.primaryPhy_ = 0;
        this.secondaryPhy_ = 0;
        this.advertisingSid_ = 0;
        this.txPower_ = 0;
        this.rssi_ = 0;
        this.periodicAdvInt_ = 0;
        this.deviceName_ = "";
        this.advertiseFlags_ = 0;
        this.serviceUuids_ = "";
        this.serviceSolicitationUuids_ = "";
        this.manufacturerSpecificData_ = "";
        this.serviceData_ = "";
        this.transportDiscoveryData_ = "";
        this.memoizedIsInitialized = -1;
        this.packageName_ = "";
        this.address_ = "";
        this.originalAddress_ = "";
        this.deviceName_ = "";
        this.serviceUuids_ = "";
        this.serviceSolicitationUuids_ = "";
        this.manufacturerSpecificData_ = "";
        this.serviceData_ = "";
        this.transportDiscoveryData_ = "";
    }

    public static /* synthetic */ int access$1002(BleScanResultDataReport r8, int r10) {
        r8.secondaryPhy_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(BleScanResultDataReport r8, int r10) {
        r8.advertisingSid_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(BleScanResultDataReport r8, int r10) {
        r8.txPower_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(BleScanResultDataReport r8, int r10) {
        r8.rssi_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(BleScanResultDataReport r8, int r10) {
        r8.periodicAdvInt_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1500(BleScanResultDataReport r8) {
        return r8.deviceName_;
    }

    public static /* synthetic */ Object access$1502(BleScanResultDataReport r8, Object r10) {
        r8.deviceName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(BleScanResultDataReport r8, int r10) {
        r8.advertiseFlags_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1700(BleScanResultDataReport r8) {
        return r8.serviceUuids_;
    }

    public static /* synthetic */ Object access$1702(BleScanResultDataReport r8, Object r10) {
        r8.serviceUuids_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1800(BleScanResultDataReport r8) {
        return r8.serviceSolicitationUuids_;
    }

    public static /* synthetic */ Object access$1802(BleScanResultDataReport r8, Object r10) {
        r8.serviceSolicitationUuids_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1900(BleScanResultDataReport r8) {
        return r8.manufacturerSpecificData_;
    }

    public static /* synthetic */ Object access$1902(BleScanResultDataReport r8, Object r10) {
        r8.manufacturerSpecificData_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2000(BleScanResultDataReport r8) {
        return r8.serviceData_;
    }

    public static /* synthetic */ Object access$2002(BleScanResultDataReport r8, Object r10) {
        r8.serviceData_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$2100(BleScanResultDataReport r8) {
        return r8.transportDiscoveryData_;
    }

    public static /* synthetic */ Object access$2102(BleScanResultDataReport r8, Object r10) {
        r8.transportDiscoveryData_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2276(BleScanResultDataReport r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$300(BleScanResultDataReport r8) {
        return r8.packageName_;
    }

    public static /* synthetic */ Object access$302(BleScanResultDataReport r8, Object r10) {
        r8.packageName_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$402(BleScanResultDataReport r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(BleScanResultDataReport r8, int r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(BleScanResultDataReport r8, int r10) {
        r8.addressType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(BleScanResultDataReport r8) {
        return r8.address_;
    }

    public static /* synthetic */ Object access$702(BleScanResultDataReport r8, Object r10) {
        r8.address_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$800(BleScanResultDataReport r8) {
        return r8.originalAddress_;
    }

    public static /* synthetic */ Object access$802(BleScanResultDataReport r8, Object r10) {
        r8.originalAddress_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(BleScanResultDataReport r8, int r10) {
        r8.primaryPhy_ = r10;
        return r10;
    }

    public static BleScanResultDataReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_BleScanResultDataReport_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BleScanResultDataReport parseDelimitedFrom(InputStream r8) {
        return (BleScanResultDataReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static BleScanResultDataReport parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<BleScanResultDataReport> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof BleScanResultDataReport) == false) goto L8;
        BleScanResultDataReport r10 = (BleScanResultDataReport) r8;
        if (hasPackageName() == r10.hasPackageName()) goto L13;
        return false;
    L13:
        if (hasPackageName() == false) goto L18;
        if (getPackageName().equals(r10.getPackageName()) == true) goto L18;
        return false;
    L18:
        if (hasTimestamp() == r10.hasTimestamp()) goto L21;
        return false;
    L21:
        if (hasTimestamp() == false) goto L26;
        if (getTimestamp() == r10.getTimestamp()) goto L26;
        return false;
    L26:
        if (hasEventType() == r10.hasEventType()) goto L29;
        return false;
    L29:
        if (hasEventType() == false) goto L34;
        if (getEventType() == r10.getEventType()) goto L34;
        return false;
    L34:
        if (hasAddressType() == r10.hasAddressType()) goto L37;
        return false;
    L37:
        if (hasAddressType() == false) goto L42;
        if (getAddressType() == r10.getAddressType()) goto L42;
        return false;
    L42:
        if (hasAddress() == r10.hasAddress()) goto L45;
        return false;
    L45:
        if (hasAddress() == false) goto L50;
        if (getAddress().equals(r10.getAddress()) == true) goto L50;
        return false;
    L50:
        if (hasOriginalAddress() == r10.hasOriginalAddress()) goto L53;
        return false;
    L53:
        if (hasOriginalAddress() == false) goto L58;
        if (getOriginalAddress().equals(r10.getOriginalAddress()) == true) goto L58;
        return false;
    L58:
        if (hasPrimaryPhy() == r10.hasPrimaryPhy()) goto L61;
        return false;
    L61:
        if (hasPrimaryPhy() == false) goto L66;
        if (getPrimaryPhy() == r10.getPrimaryPhy()) goto L66;
        return false;
    L66:
        if (hasSecondaryPhy() == r10.hasSecondaryPhy()) goto L69;
        return false;
    L69:
        if (hasSecondaryPhy() == false) goto L74;
        if (getSecondaryPhy() == r10.getSecondaryPhy()) goto L74;
        return false;
    L74:
        if (hasAdvertisingSid() == r10.hasAdvertisingSid()) goto L77;
        return false;
    L77:
        if (hasAdvertisingSid() == false) goto L82;
        if (getAdvertisingSid() == r10.getAdvertisingSid()) goto L82;
        return false;
    L82:
        if (hasTxPower() == r10.hasTxPower()) goto L85;
        return false;
    L85:
        if (hasTxPower() == false) goto L90;
        if (getTxPower() == r10.getTxPower()) goto L90;
        return false;
    L90:
        if (hasRssi() == r10.hasRssi()) goto L93;
        return false;
    L93:
        if (hasRssi() == false) goto L98;
        if (getRssi() == r10.getRssi()) goto L98;
        return false;
    L98:
        if (hasPeriodicAdvInt() == r10.hasPeriodicAdvInt()) goto L101;
        return false;
    L101:
        if (hasPeriodicAdvInt() == false) goto L106;
        if (getPeriodicAdvInt() == r10.getPeriodicAdvInt()) goto L106;
        return false;
    L106:
        if (hasDeviceName() == r10.hasDeviceName()) goto L109;
        return false;
    L109:
        if (hasDeviceName() == false) goto L114;
        if (getDeviceName().equals(r10.getDeviceName()) == true) goto L114;
        return false;
    L114:
        if (hasAdvertiseFlags() == r10.hasAdvertiseFlags()) goto L117;
        return false;
    L117:
        if (hasAdvertiseFlags() == false) goto L122;
        if (getAdvertiseFlags() == r10.getAdvertiseFlags()) goto L122;
        return false;
    L122:
        if (hasServiceUuids() == r10.hasServiceUuids()) goto L125;
        return false;
    L125:
        if (hasServiceUuids() == false) goto L130;
        if (getServiceUuids().equals(r10.getServiceUuids()) == true) goto L130;
        return false;
    L130:
        if (hasServiceSolicitationUuids() == r10.hasServiceSolicitationUuids()) goto L133;
        return false;
    L133:
        if (hasServiceSolicitationUuids() == false) goto L138;
        if (getServiceSolicitationUuids().equals(r10.getServiceSolicitationUuids()) == true) goto L138;
        return false;
    L138:
        if (hasManufacturerSpecificData() == r10.hasManufacturerSpecificData()) goto L141;
        return false;
    L141:
        if (hasManufacturerSpecificData() == false) goto L146;
        if (getManufacturerSpecificData().equals(r10.getManufacturerSpecificData()) == true) goto L146;
        return false;
    L146:
        if (hasServiceData() == r10.hasServiceData()) goto L149;
        return false;
    L149:
        if (hasServiceData() == false) goto L154;
        if (getServiceData().equals(r10.getServiceData()) == true) goto L154;
        return false;
    L154:
        if (hasTransportDiscoveryData() == r10.hasTransportDiscoveryData()) goto L157;
        return false;
    L157:
        if (hasTransportDiscoveryData() == false) goto L162;
        if (getTransportDiscoveryData().equals(r10.getTransportDiscoveryData()) == true) goto L162;
        return false;
    L162:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L164;
        return false;
    L164:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getAddress() {
        Object r8 = this.address_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.address_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getAddressBytes() {
        Object r8 = this.address_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.address_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getAddressType() {
        return this.addressType_;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getAdvertiseFlags() {
        return this.advertiseFlags_;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getAdvertisingSid() {
        return this.advertisingSid_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getDeviceName() {
        Object r8 = this.deviceName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.deviceName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getDeviceNameBytes() {
        Object r8 = this.deviceName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getEventType() {
        return this.eventType_;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getManufacturerSpecificData() {
        Object r8 = this.manufacturerSpecificData_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.manufacturerSpecificData_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getManufacturerSpecificDataBytes() {
        Object r8 = this.manufacturerSpecificData_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.manufacturerSpecificData_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getOriginalAddress() {
        Object r8 = this.originalAddress_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.originalAddress_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getOriginalAddressBytes() {
        Object r8 = this.originalAddress_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.originalAddress_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
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

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
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
    public Parser<BleScanResultDataReport> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getPeriodicAdvInt() {
        return this.periodicAdvInt_;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getPrimaryPhy() {
        return this.primaryPhy_;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getRssi() {
        return this.rssi_;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getSecondaryPhy() {
        return this.secondaryPhy_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + GeneratedMessage.computeStringSize(1, this.packageName_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt64Size(2, this.timestamp_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeUInt32Size(3, this.eventType_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeUInt32Size(4, this.addressType_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + GeneratedMessage.computeStringSize(5, this.address_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + GeneratedMessage.computeStringSize(6, this.originalAddress_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeUInt32Size(7, this.primaryPhy_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeUInt32Size(8, this.secondaryPhy_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeUInt32Size(9, this.advertisingSid_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt32Size(10, this.txPower_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.rssi_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeUInt32Size(12, this.periodicAdvInt_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + GeneratedMessage.computeStringSize(13, this.deviceName_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.advertiseFlags_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + GeneratedMessage.computeStringSize(15, this.serviceUuids_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + GeneratedMessage.computeStringSize(16, this.serviceSolicitationUuids_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + GeneratedMessage.computeStringSize(17, this.manufacturerSpecificData_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + GeneratedMessage.computeStringSize(18, this.serviceData_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L62;
        r10 = r10 + GeneratedMessage.computeStringSize(19, this.transportDiscoveryData_);
    L62:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getServiceData() {
        Object r8 = this.serviceData_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.serviceData_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getServiceDataBytes() {
        Object r8 = this.serviceData_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.serviceData_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getServiceSolicitationUuids() {
        Object r8 = this.serviceSolicitationUuids_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.serviceSolicitationUuids_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getServiceSolicitationUuidsBytes() {
        Object r8 = this.serviceSolicitationUuids_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.serviceSolicitationUuids_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getServiceUuids() {
        Object r8 = this.serviceUuids_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.serviceUuids_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getServiceUuidsBytes() {
        Object r8 = this.serviceUuids_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.serviceUuids_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public String getTransportDiscoveryData() {
        Object r8 = this.transportDiscoveryData_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.transportDiscoveryData_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public ByteString getTransportDiscoveryDataBytes() {
        Object r8 = this.transportDiscoveryData_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.transportDiscoveryData_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public int getTxPower() {
        return this.txPower_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasAddress() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasAddressType() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasAdvertiseFlags() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasAdvertisingSid() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasDeviceName() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasManufacturerSpecificData() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasOriginalAddress() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasPackageName() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasPeriodicAdvInt() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasPrimaryPhy() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasRssi() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasSecondaryPhy() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasServiceData() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasServiceSolicitationUuids() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasServiceUuids() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasTransportDiscoveryData() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.BleScanResultDataReportOrBuilder
    public boolean hasTxPower() {
        if ((this.bitField0_ & 512) == 0) goto L5;
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
        if (hasPackageName() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getPackageName().hashCode();
    L9:
        if (hasTimestamp() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + Internal.hashLong(getTimestamp());
    L12:
        if (hasEventType() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getEventType();
    L15:
        if (hasAddressType() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getAddressType();
    L18:
        if (hasAddress() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getAddress().hashCode();
    L21:
        if (hasOriginalAddress() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getOriginalAddress().hashCode();
    L24:
        if (hasPrimaryPhy() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getPrimaryPhy();
    L27:
        if (hasSecondaryPhy() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getSecondaryPhy();
    L30:
        if (hasAdvertisingSid() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getAdvertisingSid();
    L33:
        if (hasTxPower() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + getTxPower();
    L36:
        if (hasRssi() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + getRssi();
    L39:
        if (hasPeriodicAdvInt() == false) goto L42;
        r10 = b.a(r10, 37, 12, 53) + getPeriodicAdvInt();
    L42:
        if (hasDeviceName() == false) goto L45;
        r10 = b.a(r10, 37, 13, 53) + getDeviceName().hashCode();
    L45:
        if (hasAdvertiseFlags() == false) goto L48;
        r10 = b.a(r10, 37, 14, 53) + getAdvertiseFlags();
    L48:
        if (hasServiceUuids() == false) goto L51;
        r10 = b.a(r10, 37, 15, 53) + getServiceUuids().hashCode();
    L51:
        if (hasServiceSolicitationUuids() == false) goto L54;
        r10 = b.a(r10, 37, 16, 53) + getServiceSolicitationUuids().hashCode();
    L54:
        if (hasManufacturerSpecificData() == false) goto L57;
        r10 = b.a(r10, 37, 17, 53) + getManufacturerSpecificData().hashCode();
    L57:
        if (hasServiceData() == false) goto L60;
        r10 = b.a(r10, 37, 18, 53) + getServiceData().hashCode();
    L60:
        if (hasTransportDiscoveryData() == false) goto L62;
        r10 = b.a(r10, 37, 19, 53) + getTransportDiscoveryData().hashCode();
    L62:
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
        return new BleScanResultDataReport();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.packageName_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt64(2, this.timestamp_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeUInt32(3, this.eventType_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeUInt32(4, this.addressType_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.address_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        GeneratedMessage.writeString(r8, 6, this.originalAddress_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeUInt32(7, this.primaryPhy_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeUInt32(8, this.secondaryPhy_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeUInt32(9, this.advertisingSid_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt32(10, this.txPower_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.rssi_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeUInt32(12, this.periodicAdvInt_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        GeneratedMessage.writeString(r8, 13, this.deviceName_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeInt32(14, this.advertiseFlags_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        GeneratedMessage.writeString(r8, 15, this.serviceUuids_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        GeneratedMessage.writeString(r8, 16, this.serviceSolicitationUuids_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        GeneratedMessage.writeString(r8, 17, this.manufacturerSpecificData_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        GeneratedMessage.writeString(r8, 18, this.serviceData_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L59;
        GeneratedMessage.writeString(r8, 19, this.transportDiscoveryData_);
    L59:
        getUnknownFields().writeTo(r8);
    }

    private BleScanResultDataReport(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.packageName_ = "";
        this.timestamp_ = 0;
        this.eventType_ = 0;
        this.addressType_ = 0;
        this.address_ = "";
        this.originalAddress_ = "";
        this.primaryPhy_ = 0;
        this.secondaryPhy_ = 0;
        this.advertisingSid_ = 0;
        this.txPower_ = 0;
        this.rssi_ = 0;
        this.periodicAdvInt_ = 0;
        this.deviceName_ = "";
        this.advertiseFlags_ = 0;
        this.serviceUuids_ = "";
        this.serviceSolicitationUuids_ = "";
        this.manufacturerSpecificData_ = "";
        this.serviceData_ = "";
        this.transportDiscoveryData_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(BleScanResultDataReport r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static BleScanResultDataReport parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (BleScanResultDataReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static BleScanResultDataReport parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_BleScanResultDataReport_fieldAccessorTable.ensureFieldAccessorsInitialized(BleScanResultDataReport.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ BleScanResultDataReport(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static BleScanResultDataReport parseFrom(CodedInputStream r8) {
        return (BleScanResultDataReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public BleScanResultDataReport getDefaultInstanceForType() {
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

    public static BleScanResultDataReport parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (BleScanResultDataReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static BleScanResultDataReport parseFrom(InputStream r8) {
        return (BleScanResultDataReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static BleScanResultDataReport parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (BleScanResultDataReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static BleScanResultDataReport parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static BleScanResultDataReport parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static BleScanResultDataReport parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static BleScanResultDataReport parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
