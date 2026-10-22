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
public final class GpsLocationSummaryReport extends GeneratedMessageV3 implements GpsLocationSummaryReportOrBuilder {
    public static final int ACCURACY_FIELD_NUMBER = 4;
    public static final int ALTITUDE_FIELD_NUMBER = 3;
    public static final int AVG_CN0_DBHZ_FIELD_NUMBER = 14;
    public static final int BEARING_ACCURACY_FIELD_NUMBER = 11;
    public static final int BEARING_FIELD_NUMBER = 6;
    private static final GpsLocationSummaryReport DEFAULT_INSTANCE = null;
    public static final int HAS_ALMANAC_FIELD_NUMBER = 20;
    public static final int HAS_EPHEMERIS_FIELD_NUMBER = 19;
    public static final int HDOP_FIELD_NUMBER = 16;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LOCATION_TIME_FIELD_NUMBER = 7;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    public static final int MAX_CN0_DBHZ_FIELD_NUMBER = 15;

    @Deprecated
    public static final Parser<GpsLocationSummaryReport> PARSER = null;
    public static final int PDOP_FIELD_NUMBER = 18;
    public static final int PROVIDER_FIELD_NUMBER = 8;
    public static final int SATELLITE_COUNT_FIELD_NUMBER = 12;
    public static final int SPEED_ACCURACY_FIELD_NUMBER = 10;
    public static final int SPEED_FIELD_NUMBER = 5;
    public static final int USED_IN_FIX_COUNT_FIELD_NUMBER = 13;
    public static final int VDOP_FIELD_NUMBER = 17;
    public static final int VERTICAL_ACCURACY_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private float accuracy_;
    private double altitude_;
    private float avgCn0Dbhz_;
    private float bearingAccuracy_;
    private float bearing_;
    private int bitField0_;
    private boolean hasAlmanac_;
    private boolean hasEphemeris_;
    private float hdop_;
    private double latitude_;
    private long locationTime_;
    private double longitude_;
    private float maxCn0Dbhz_;
    private byte memoizedIsInitialized;
    private float pdop_;
    private volatile Object provider_;
    private int satelliteCount_;
    private float speedAccuracy_;
    private float speed_;
    private int usedInFixCount_;
    private float vdop_;
    private float verticalAccuracy_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GpsLocationSummaryReportOrBuilder {
        private float accuracy_;
        private double altitude_;
        private float avgCn0Dbhz_;
        private float bearingAccuracy_;
        private float bearing_;
        private int bitField0_;
        private boolean hasAlmanac_;
        private boolean hasEphemeris_;
        private float hdop_;
        private double latitude_;
        private long locationTime_;
        private double longitude_;
        private float maxCn0Dbhz_;
        private float pdop_;
        private Object provider_;
        private int satelliteCount_;
        private float speedAccuracy_;
        private float speed_;
        private int usedInFixCount_;
        private float vdop_;
        private float verticalAccuracy_;

        private Builder() {
            this.provider_ = "";
        }

        private void buildPartial0(GpsLocationSummaryReport r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            GpsLocationSummaryReport.access$302(r8, this.latitude_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            GpsLocationSummaryReport.access$402(r8, this.longitude_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            GpsLocationSummaryReport.access$502(r8, this.altitude_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            GpsLocationSummaryReport.access$602(r8, this.accuracy_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            GpsLocationSummaryReport.access$702(r8, this.speed_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            GpsLocationSummaryReport.access$802(r8, this.bearing_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            GpsLocationSummaryReport.access$902(r8, this.locationTime_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            GpsLocationSummaryReport.access$1002(r8, this.provider_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            GpsLocationSummaryReport.access$1102(r8, this.verticalAccuracy_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            GpsLocationSummaryReport.access$1202(r8, this.speedAccuracy_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            GpsLocationSummaryReport.access$1302(r8, this.bearingAccuracy_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            GpsLocationSummaryReport.access$1402(r8, this.satelliteCount_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            GpsLocationSummaryReport.access$1502(r8, this.usedInFixCount_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            GpsLocationSummaryReport.access$1602(r8, this.avgCn0Dbhz_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            GpsLocationSummaryReport.access$1702(r8, this.maxCn0Dbhz_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            GpsLocationSummaryReport.access$1802(r8, this.hdop_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L55;
            GpsLocationSummaryReport.access$1902(r8, this.vdop_);
            r11 = r11 | 65536;
        L55:
            if ((r10 & 131072) == 0) goto L58;
            GpsLocationSummaryReport.access$2002(r8, this.pdop_);
            r11 = r11 | 131072;
        L58:
            if ((r10 & 262144) == 0) goto L61;
            GpsLocationSummaryReport.access$2102(r8, this.hasEphemeris_);
            r11 = r11 | 262144;
        L61:
            if ((r10 & 524288) == 0) goto L63;
            GpsLocationSummaryReport.access$2202(r8, this.hasAlmanac_);
            r11 = r11 | 524288;
        L63:
            GpsLocationSummaryReport.access$2376(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_descriptor;
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

        public Builder clearAccuracy() {
            this.bitField0_ &= -9;
            this.accuracy_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearAltitude() {
            this.bitField0_ &= -5;
            this.altitude_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearAvgCn0Dbhz() {
            this.bitField0_ &= -8193;
            this.avgCn0Dbhz_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBearing() {
            this.bitField0_ &= -33;
            this.bearing_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBearingAccuracy() {
            this.bitField0_ &= -1025;
            this.bearingAccuracy_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearHasAlmanac() {
            this.bitField0_ &= -524289;
            this.hasAlmanac_ = false;
            onChanged();
            return this;
        }

        public Builder clearHasEphemeris() {
            this.bitField0_ &= -262145;
            this.hasEphemeris_ = false;
            onChanged();
            return this;
        }

        public Builder clearHdop() {
            this.bitField0_ &= -32769;
            this.hdop_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearLatitude() {
            this.bitField0_ &= -2;
            this.latitude_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearLocationTime() {
            this.bitField0_ &= -65;
            this.locationTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLongitude() {
            this.bitField0_ &= -3;
            this.longitude_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearMaxCn0Dbhz() {
            this.bitField0_ &= -16385;
            this.maxCn0Dbhz_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPdop() {
            this.bitField0_ &= -131073;
            this.pdop_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearProvider() {
            this.provider_ = GpsLocationSummaryReport.getDefaultInstance().getProvider();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearSatelliteCount() {
            this.bitField0_ &= -2049;
            this.satelliteCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSpeed() {
            this.bitField0_ &= -17;
            this.speed_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearSpeedAccuracy() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.speedAccuracy_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearUsedInFixCount() {
            this.bitField0_ &= -4097;
            this.usedInFixCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVdop() {
            this.bitField0_ &= -65537;
            this.vdop_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearVerticalAccuracy() {
            this.bitField0_ &= -257;
            this.verticalAccuracy_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getAccuracy() {
            return this.accuracy_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public double getAltitude() {
            return this.altitude_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getAvgCn0Dbhz() {
            return this.avgCn0Dbhz_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getBearing() {
            return this.bearing_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getBearingAccuracy() {
            return this.bearingAccuracy_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_descriptor;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean getHasAlmanac() {
            return this.hasAlmanac_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean getHasEphemeris() {
            return this.hasEphemeris_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getHdop() {
            return this.hdop_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public double getLatitude() {
            return this.latitude_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public long getLocationTime() {
            return this.locationTime_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public double getLongitude() {
            return this.longitude_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getMaxCn0Dbhz() {
            return this.maxCn0Dbhz_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getPdop() {
            return this.pdop_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public String getProvider() {
            Object r8 = this.provider_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.provider_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public ByteString getProviderBytes() {
            Object r8 = this.provider_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.provider_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public int getSatelliteCount() {
            return this.satelliteCount_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getSpeed() {
            return this.speed_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getSpeedAccuracy() {
            return this.speedAccuracy_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public int getUsedInFixCount() {
            return this.usedInFixCount_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getVdop() {
            return this.vdop_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public float getVerticalAccuracy() {
            return this.verticalAccuracy_;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasAccuracy() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasAltitude() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasAvgCn0Dbhz() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasBearing() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasBearingAccuracy() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasHasAlmanac() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasHasEphemeris() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasHdop() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasLatitude() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasLocationTime() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasLongitude() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasMaxCn0Dbhz() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasPdop() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasProvider() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasSatelliteCount() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasSpeed() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasSpeedAccuracy() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasUsedInFixCount() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasVdop() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
        public boolean hasVerticalAccuracy() {
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

        public Builder setAccuracy(float r8) {
            this.accuracy_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setAltitude(double r8) {
            this.altitude_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setAvgCn0Dbhz(float r8) {
            this.avgCn0Dbhz_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setBearing(float r8) {
            this.bearing_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setBearingAccuracy(float r8) {
            this.bearingAccuracy_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setHasAlmanac(boolean r8) {
            this.hasAlmanac_ = r8;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setHasEphemeris(boolean r8) {
            this.hasEphemeris_ = r8;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setHdop(float r8) {
            this.hdop_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setLatitude(double r8) {
            this.latitude_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setLocationTime(long r8) {
            this.locationTime_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setLongitude(double r8) {
            this.longitude_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setMaxCn0Dbhz(float r8) {
            this.maxCn0Dbhz_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setPdop(float r8) {
            this.pdop_ = r8;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setProvider(String r8) {
            if (r8 == null) goto L6;
            this.provider_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setProviderBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.provider_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSatelliteCount(int r8) {
            this.satelliteCount_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setSpeed(float r8) {
            this.speed_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setSpeedAccuracy(float r8) {
            this.speedAccuracy_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setUsedInFixCount(int r8) {
            this.usedInFixCount_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setVdop(float r8) {
            this.vdop_ = r8;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setVerticalAccuracy(float r8) {
            this.verticalAccuracy_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.provider_ = "";
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
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_fieldAccessorTable.ensureFieldAccessorsInitialized(GpsLocationSummaryReport.class, Builder.class);
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
        public GpsLocationSummaryReport build() {
            GpsLocationSummaryReport r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GpsLocationSummaryReport buildPartial() {
            GpsLocationSummaryReport r8 = new GpsLocationSummaryReport(this, null);
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
        public GpsLocationSummaryReport getDefaultInstanceForType() {
            return GpsLocationSummaryReport.getDefaultInstance();
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
            this.latitude_ = 0.0d;
            this.longitude_ = 0.0d;
            this.altitude_ = 0.0d;
            this.accuracy_ = 0.0f;
            this.speed_ = 0.0f;
            this.bearing_ = 0.0f;
            this.locationTime_ = 0;
            this.provider_ = "";
            this.verticalAccuracy_ = 0.0f;
            this.speedAccuracy_ = 0.0f;
            this.bearingAccuracy_ = 0.0f;
            this.satelliteCount_ = 0;
            this.usedInFixCount_ = 0;
            this.avgCn0Dbhz_ = 0.0f;
            this.maxCn0Dbhz_ = 0.0f;
            this.hdop_ = 0.0f;
            this.vdop_ = 0.0f;
            this.pdop_ = 0.0f;
            this.hasEphemeris_ = false;
            this.hasAlmanac_ = false;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L42;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L39;
            int r12 = r8.readTag();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            switch(r12) {
                case 0: goto L29;
                case 9: goto L27;
                case 17: goto L26;
                case 25: goto L25;
                case 37: goto L24;
                case 45: goto L23;
                case 53: goto L22;
                case 56: goto L21;
                case 66: goto L20;
                case 77: goto L19;
                case 85: goto L18;
                case 93: goto L17;
                case 96: goto L16;
                case 104: goto L15;
                case 117: goto L14;
                case 125: goto L13;
                case 133: goto L12;
                case 141: goto L11;
                case 149: goto L10;
                case 152: goto L9;
                case 160: goto L8;
                default: goto L30;
            };     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
        L8:
            this.hasAlmanac_ = r8.readBool();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 524288;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L9:
            this.hasEphemeris_ = r8.readBool();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 262144;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L10:
            this.pdop_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 131072;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L11:
            this.vdop_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 65536;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L12:
            this.hdop_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 32768;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L13:
            this.maxCn0Dbhz_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 16384;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L14:
            this.avgCn0Dbhz_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 8192;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L15:
            this.usedInFixCount_ = r8.readInt32();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 4096;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L16:
            this.satelliteCount_ = r8.readInt32();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 2048;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L17:
            this.bearingAccuracy_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 1024;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L18:
            this.speedAccuracy_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 512;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L19:
            this.verticalAccuracy_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 256;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L20:
            this.provider_ = r8.readBytes();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 128;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L21:
            this.locationTime_ = r8.readUInt64();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 64;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L22:
            this.bearing_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 32;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L23:
            this.speed_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 16;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L24:
            this.accuracy_ = r8.readFloat();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 8;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L25:
            this.altitude_ = r8.readDouble();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 4;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L26:
            this.longitude_ = r8.readDouble();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 2;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            goto L4
        L27:
            this.latitude_ = r8.readDouble();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            this.bitField0_ |= 1;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
        L29:
            r11 = true;
            goto L4
        L30:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L34:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            onChanged();
            throw th;
        L39:
            onChanged();
            return this;
        L42:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof GpsLocationSummaryReport) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((GpsLocationSummaryReport) r8);
        }

        public Builder mergeFrom(GpsLocationSummaryReport r8) {
            if (r8 != GpsLocationSummaryReport.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasLatitude() == false) goto L9;
            setLatitude(r8.getLatitude());
        L9:
            if (r8.hasLongitude() == false) goto L12;
            setLongitude(r8.getLongitude());
        L12:
            if (r8.hasAltitude() == false) goto L15;
            setAltitude(r8.getAltitude());
        L15:
            if (r8.hasAccuracy() == false) goto L18;
            setAccuracy(r8.getAccuracy());
        L18:
            if (r8.hasSpeed() == false) goto L21;
            setSpeed(r8.getSpeed());
        L21:
            if (r8.hasBearing() == false) goto L24;
            setBearing(r8.getBearing());
        L24:
            if (r8.hasLocationTime() == false) goto L27;
            setLocationTime(r8.getLocationTime());
        L27:
            if (r8.hasProvider() == false) goto L30;
            this.provider_ = GpsLocationSummaryReport.access$1000(r8);
            this.bitField0_ |= 128;
            onChanged();
        L30:
            if (r8.hasVerticalAccuracy() == false) goto L33;
            setVerticalAccuracy(r8.getVerticalAccuracy());
        L33:
            if (r8.hasSpeedAccuracy() == false) goto L36;
            setSpeedAccuracy(r8.getSpeedAccuracy());
        L36:
            if (r8.hasBearingAccuracy() == false) goto L39;
            setBearingAccuracy(r8.getBearingAccuracy());
        L39:
            if (r8.hasSatelliteCount() == false) goto L42;
            setSatelliteCount(r8.getSatelliteCount());
        L42:
            if (r8.hasUsedInFixCount() == false) goto L45;
            setUsedInFixCount(r8.getUsedInFixCount());
        L45:
            if (r8.hasAvgCn0Dbhz() == false) goto L48;
            setAvgCn0Dbhz(r8.getAvgCn0Dbhz());
        L48:
            if (r8.hasMaxCn0Dbhz() == false) goto L51;
            setMaxCn0Dbhz(r8.getMaxCn0Dbhz());
        L51:
            if (r8.hasHdop() == false) goto L54;
            setHdop(r8.getHdop());
        L54:
            if (r8.hasVdop() == false) goto L57;
            setVdop(r8.getVdop());
        L57:
            if (r8.hasPdop() == false) goto L60;
            setPdop(r8.getPdop());
        L60:
            if (r8.hasHasEphemeris() == false) goto L63;
            setHasEphemeris(r8.getHasEphemeris());
        L63:
            if (r8.hasHasAlmanac() == false) goto L65;
            setHasAlmanac(r8.getHasAlmanac());
        L65:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new GpsLocationSummaryReport();
        PARSER = new AnonymousClass1();
    }

    private GpsLocationSummaryReport() {
        this.latitude_ = 0.0d;
        this.longitude_ = 0.0d;
        this.altitude_ = 0.0d;
        this.accuracy_ = 0.0f;
        this.speed_ = 0.0f;
        this.bearing_ = 0.0f;
        this.locationTime_ = 0;
        this.provider_ = "";
        this.verticalAccuracy_ = 0.0f;
        this.speedAccuracy_ = 0.0f;
        this.bearingAccuracy_ = 0.0f;
        this.satelliteCount_ = 0;
        this.usedInFixCount_ = 0;
        this.avgCn0Dbhz_ = 0.0f;
        this.maxCn0Dbhz_ = 0.0f;
        this.hdop_ = 0.0f;
        this.vdop_ = 0.0f;
        this.pdop_ = 0.0f;
        this.hasEphemeris_ = false;
        this.hasAlmanac_ = false;
        this.memoizedIsInitialized = -1;
        this.provider_ = "";
    }

    public static /* synthetic */ Object access$1000(GpsLocationSummaryReport r8) {
        return r8.provider_;
    }

    public static /* synthetic */ Object access$1002(GpsLocationSummaryReport r8, Object r10) {
        r8.provider_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1102(GpsLocationSummaryReport r8, float r10) {
        r8.verticalAccuracy_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1202(GpsLocationSummaryReport r8, float r10) {
        r8.speedAccuracy_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1302(GpsLocationSummaryReport r8, float r10) {
        r8.bearingAccuracy_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1402(GpsLocationSummaryReport r8, int r10) {
        r8.satelliteCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(GpsLocationSummaryReport r8, int r10) {
        r8.usedInFixCount_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1602(GpsLocationSummaryReport r8, float r10) {
        r8.avgCn0Dbhz_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1702(GpsLocationSummaryReport r8, float r10) {
        r8.maxCn0Dbhz_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1802(GpsLocationSummaryReport r8, float r10) {
        r8.hdop_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1902(GpsLocationSummaryReport r8, float r10) {
        r8.vdop_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$2002(GpsLocationSummaryReport r8, float r10) {
        r8.pdop_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$2102(GpsLocationSummaryReport r8, boolean r10) {
        r8.hasEphemeris_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$2202(GpsLocationSummaryReport r8, boolean r10) {
        r8.hasAlmanac_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2376(GpsLocationSummaryReport r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ double access$302(GpsLocationSummaryReport r8, double r10) {
        r8.latitude_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$402(GpsLocationSummaryReport r8, double r10) {
        r8.longitude_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$502(GpsLocationSummaryReport r8, double r10) {
        r8.altitude_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$602(GpsLocationSummaryReport r8, float r10) {
        r8.accuracy_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$702(GpsLocationSummaryReport r8, float r10) {
        r8.speed_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$802(GpsLocationSummaryReport r8, float r10) {
        r8.bearing_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$902(GpsLocationSummaryReport r8, long r10) {
        r8.locationTime_ = r10;
        return r10;
    }

    public static GpsLocationSummaryReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static GpsLocationSummaryReport parseDelimitedFrom(InputStream r8) {
        return (GpsLocationSummaryReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static GpsLocationSummaryReport parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<GpsLocationSummaryReport> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof GpsLocationSummaryReport) == false) goto L8;
        GpsLocationSummaryReport r10 = (GpsLocationSummaryReport) r8;
        if (hasLatitude() == r10.hasLatitude()) goto L13;
        return false;
    L13:
        if (hasLatitude() == false) goto L18;
        if (Double.doubleToLongBits(getLatitude()) == Double.doubleToLongBits(r10.getLatitude())) goto L18;
        return false;
    L18:
        if (hasLongitude() == r10.hasLongitude()) goto L21;
        return false;
    L21:
        if (hasLongitude() == false) goto L26;
        if (Double.doubleToLongBits(getLongitude()) == Double.doubleToLongBits(r10.getLongitude())) goto L26;
        return false;
    L26:
        if (hasAltitude() == r10.hasAltitude()) goto L29;
        return false;
    L29:
        if (hasAltitude() == false) goto L34;
        if (Double.doubleToLongBits(getAltitude()) == Double.doubleToLongBits(r10.getAltitude())) goto L34;
        return false;
    L34:
        if (hasAccuracy() == r10.hasAccuracy()) goto L37;
        return false;
    L37:
        if (hasAccuracy() == false) goto L42;
        if (Float.floatToIntBits(getAccuracy()) == Float.floatToIntBits(r10.getAccuracy())) goto L42;
        return false;
    L42:
        if (hasSpeed() == r10.hasSpeed()) goto L45;
        return false;
    L45:
        if (hasSpeed() == false) goto L50;
        if (Float.floatToIntBits(getSpeed()) == Float.floatToIntBits(r10.getSpeed())) goto L50;
        return false;
    L50:
        if (hasBearing() == r10.hasBearing()) goto L53;
        return false;
    L53:
        if (hasBearing() == false) goto L58;
        if (Float.floatToIntBits(getBearing()) == Float.floatToIntBits(r10.getBearing())) goto L58;
        return false;
    L58:
        if (hasLocationTime() == r10.hasLocationTime()) goto L61;
        return false;
    L61:
        if (hasLocationTime() == false) goto L66;
        if (getLocationTime() == r10.getLocationTime()) goto L66;
        return false;
    L66:
        if (hasProvider() == r10.hasProvider()) goto L69;
        return false;
    L69:
        if (hasProvider() == false) goto L74;
        if (getProvider().equals(r10.getProvider()) == true) goto L74;
        return false;
    L74:
        if (hasVerticalAccuracy() == r10.hasVerticalAccuracy()) goto L77;
        return false;
    L77:
        if (hasVerticalAccuracy() == false) goto L82;
        if (Float.floatToIntBits(getVerticalAccuracy()) == Float.floatToIntBits(r10.getVerticalAccuracy())) goto L82;
        return false;
    L82:
        if (hasSpeedAccuracy() == r10.hasSpeedAccuracy()) goto L85;
        return false;
    L85:
        if (hasSpeedAccuracy() == false) goto L90;
        if (Float.floatToIntBits(getSpeedAccuracy()) == Float.floatToIntBits(r10.getSpeedAccuracy())) goto L90;
        return false;
    L90:
        if (hasBearingAccuracy() == r10.hasBearingAccuracy()) goto L93;
        return false;
    L93:
        if (hasBearingAccuracy() == false) goto L98;
        if (Float.floatToIntBits(getBearingAccuracy()) == Float.floatToIntBits(r10.getBearingAccuracy())) goto L98;
        return false;
    L98:
        if (hasSatelliteCount() == r10.hasSatelliteCount()) goto L101;
        return false;
    L101:
        if (hasSatelliteCount() == false) goto L106;
        if (getSatelliteCount() == r10.getSatelliteCount()) goto L106;
        return false;
    L106:
        if (hasUsedInFixCount() == r10.hasUsedInFixCount()) goto L109;
        return false;
    L109:
        if (hasUsedInFixCount() == false) goto L114;
        if (getUsedInFixCount() == r10.getUsedInFixCount()) goto L114;
        return false;
    L114:
        if (hasAvgCn0Dbhz() == r10.hasAvgCn0Dbhz()) goto L117;
        return false;
    L117:
        if (hasAvgCn0Dbhz() == false) goto L122;
        if (Float.floatToIntBits(getAvgCn0Dbhz()) == Float.floatToIntBits(r10.getAvgCn0Dbhz())) goto L122;
        return false;
    L122:
        if (hasMaxCn0Dbhz() == r10.hasMaxCn0Dbhz()) goto L125;
        return false;
    L125:
        if (hasMaxCn0Dbhz() == false) goto L130;
        if (Float.floatToIntBits(getMaxCn0Dbhz()) == Float.floatToIntBits(r10.getMaxCn0Dbhz())) goto L130;
        return false;
    L130:
        if (hasHdop() == r10.hasHdop()) goto L133;
        return false;
    L133:
        if (hasHdop() == false) goto L138;
        if (Float.floatToIntBits(getHdop()) == Float.floatToIntBits(r10.getHdop())) goto L138;
        return false;
    L138:
        if (hasVdop() == r10.hasVdop()) goto L141;
        return false;
    L141:
        if (hasVdop() == false) goto L146;
        if (Float.floatToIntBits(getVdop()) == Float.floatToIntBits(r10.getVdop())) goto L146;
        return false;
    L146:
        if (hasPdop() == r10.hasPdop()) goto L149;
        return false;
    L149:
        if (hasPdop() == false) goto L154;
        if (Float.floatToIntBits(getPdop()) == Float.floatToIntBits(r10.getPdop())) goto L154;
        return false;
    L154:
        if (hasHasEphemeris() == r10.hasHasEphemeris()) goto L157;
        return false;
    L157:
        if (hasHasEphemeris() == false) goto L162;
        if (getHasEphemeris() == r10.getHasEphemeris()) goto L162;
        return false;
    L162:
        if (hasHasAlmanac() == r10.hasHasAlmanac()) goto L165;
        return false;
    L165:
        if (hasHasAlmanac() == false) goto L170;
        if (getHasAlmanac() == r10.getHasAlmanac()) goto L170;
        return false;
    L170:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L172;
        return false;
    L172:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getAccuracy() {
        return this.accuracy_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public double getAltitude() {
        return this.altitude_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getAvgCn0Dbhz() {
        return this.avgCn0Dbhz_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getBearing() {
        return this.bearing_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getBearingAccuracy() {
        return this.bearingAccuracy_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean getHasAlmanac() {
        return this.hasAlmanac_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean getHasEphemeris() {
        return this.hasEphemeris_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getHdop() {
        return this.hdop_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public double getLatitude() {
        return this.latitude_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public long getLocationTime() {
        return this.locationTime_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public double getLongitude() {
        return this.longitude_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getMaxCn0Dbhz() {
        return this.maxCn0Dbhz_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GpsLocationSummaryReport> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getPdop() {
        return this.pdop_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public String getProvider() {
        Object r8 = this.provider_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.provider_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public ByteString getProviderBytes() {
        Object r8 = this.provider_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.provider_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public int getSatelliteCount() {
        return this.satelliteCount_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeDoubleSize(1, this.latitude_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeDoubleSize(2, this.longitude_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeDoubleSize(3, this.altitude_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeFloatSize(4, this.accuracy_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeFloatSize(5, this.speed_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeFloatSize(6, this.bearing_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeUInt64Size(7, this.locationTime_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + GeneratedMessage.computeStringSize(8, this.provider_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeFloatSize(9, this.verticalAccuracy_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeFloatSize(10, this.speedAccuracy_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeFloatSize(11, this.bearingAccuracy_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.satelliteCount_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.usedInFixCount_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeFloatSize(14, this.avgCn0Dbhz_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeFloatSize(15, this.maxCn0Dbhz_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeFloatSize(16, this.hdop_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r10 = r10 + CodedOutputStream.computeFloatSize(17, this.vdop_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r10 = r10 + CodedOutputStream.computeFloatSize(18, this.pdop_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L63;
        r10 = r10 + CodedOutputStream.computeBoolSize(19, this.hasEphemeris_);
    L63:
        if ((this.bitField0_ & 524288) == 0) goto L65;
        r10 = r10 + CodedOutputStream.computeBoolSize(20, this.hasAlmanac_);
    L65:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getSpeed() {
        return this.speed_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getSpeedAccuracy() {
        return this.speedAccuracy_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public int getUsedInFixCount() {
        return this.usedInFixCount_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getVdop() {
        return this.vdop_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public float getVerticalAccuracy() {
        return this.verticalAccuracy_;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasAccuracy() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasAltitude() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasAvgCn0Dbhz() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasBearing() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasBearingAccuracy() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasHasAlmanac() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasHasEphemeris() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasHdop() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasLatitude() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasLocationTime() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasLongitude() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasMaxCn0Dbhz() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasPdop() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasProvider() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasSatelliteCount() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasSpeed() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasSpeedAccuracy() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasUsedInFixCount() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasVdop() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsLocationSummaryReportOrBuilder
    public boolean hasVerticalAccuracy() {
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
        if (hasLatitude() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(Double.doubleToLongBits(getLatitude()));
    L9:
        if (hasLongitude() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + Internal.hashLong(Double.doubleToLongBits(getLongitude()));
    L12:
        if (hasAltitude() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Internal.hashLong(Double.doubleToLongBits(getAltitude()));
    L15:
        if (hasAccuracy() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Float.floatToIntBits(getAccuracy());
    L18:
        if (hasSpeed() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + Float.floatToIntBits(getSpeed());
    L21:
        if (hasBearing() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + Float.floatToIntBits(getBearing());
    L24:
        if (hasLocationTime() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + Internal.hashLong(getLocationTime());
    L27:
        if (hasProvider() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getProvider().hashCode();
    L30:
        if (hasVerticalAccuracy() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + Float.floatToIntBits(getVerticalAccuracy());
    L33:
        if (hasSpeedAccuracy() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + Float.floatToIntBits(getSpeedAccuracy());
    L36:
        if (hasBearingAccuracy() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + Float.floatToIntBits(getBearingAccuracy());
    L39:
        if (hasSatelliteCount() == false) goto L42;
        r10 = b.a(r10, 37, 12, 53) + getSatelliteCount();
    L42:
        if (hasUsedInFixCount() == false) goto L45;
        r10 = b.a(r10, 37, 13, 53) + getUsedInFixCount();
    L45:
        if (hasAvgCn0Dbhz() == false) goto L48;
        r10 = b.a(r10, 37, 14, 53) + Float.floatToIntBits(getAvgCn0Dbhz());
    L48:
        if (hasMaxCn0Dbhz() == false) goto L51;
        r10 = b.a(r10, 37, 15, 53) + Float.floatToIntBits(getMaxCn0Dbhz());
    L51:
        if (hasHdop() == false) goto L54;
        r10 = b.a(r10, 37, 16, 53) + Float.floatToIntBits(getHdop());
    L54:
        if (hasVdop() == false) goto L57;
        r10 = b.a(r10, 37, 17, 53) + Float.floatToIntBits(getVdop());
    L57:
        if (hasPdop() == false) goto L60;
        r10 = b.a(r10, 37, 18, 53) + Float.floatToIntBits(getPdop());
    L60:
        if (hasHasEphemeris() == false) goto L63;
        r10 = b.a(r10, 37, 19, 53) + Internal.hashBoolean(getHasEphemeris());
    L63:
        if (hasHasAlmanac() == false) goto L65;
        r10 = b.a(r10, 37, 20, 53) + Internal.hashBoolean(getHasAlmanac());
    L65:
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
        return new GpsLocationSummaryReport();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeDouble(1, this.latitude_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeDouble(2, this.longitude_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeDouble(3, this.altitude_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeFloat(4, this.accuracy_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeFloat(5, this.speed_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeFloat(6, this.bearing_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeUInt64(7, this.locationTime_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        GeneratedMessage.writeString(r8, 8, this.provider_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeFloat(9, this.verticalAccuracy_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeFloat(10, this.speedAccuracy_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeFloat(11, this.bearingAccuracy_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeInt32(12, this.satelliteCount_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeInt32(13, this.usedInFixCount_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeFloat(14, this.avgCn0Dbhz_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeFloat(15, this.maxCn0Dbhz_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r8.writeFloat(16, this.hdop_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r8.writeFloat(17, this.vdop_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r8.writeFloat(18, this.pdop_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        r8.writeBool(19, this.hasEphemeris_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L62;
        r8.writeBool(20, this.hasAlmanac_);
    L62:
        getUnknownFields().writeTo(r8);
    }

    private GpsLocationSummaryReport(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.latitude_ = 0.0d;
        this.longitude_ = 0.0d;
        this.altitude_ = 0.0d;
        this.accuracy_ = 0.0f;
        this.speed_ = 0.0f;
        this.bearing_ = 0.0f;
        this.locationTime_ = 0;
        this.provider_ = "";
        this.verticalAccuracy_ = 0.0f;
        this.speedAccuracy_ = 0.0f;
        this.bearingAccuracy_ = 0.0f;
        this.satelliteCount_ = 0;
        this.usedInFixCount_ = 0;
        this.avgCn0Dbhz_ = 0.0f;
        this.maxCn0Dbhz_ = 0.0f;
        this.hdop_ = 0.0f;
        this.vdop_ = 0.0f;
        this.pdop_ = 0.0f;
        this.hasEphemeris_ = false;
        this.hasAlmanac_ = false;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(GpsLocationSummaryReport r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static GpsLocationSummaryReport parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (GpsLocationSummaryReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static GpsLocationSummaryReport parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsLocationSummaryReport_fieldAccessorTable.ensureFieldAccessorsInitialized(GpsLocationSummaryReport.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ GpsLocationSummaryReport(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static GpsLocationSummaryReport parseFrom(CodedInputStream r8) {
        return (GpsLocationSummaryReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public GpsLocationSummaryReport getDefaultInstanceForType() {
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

    public static GpsLocationSummaryReport parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (GpsLocationSummaryReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static GpsLocationSummaryReport parseFrom(InputStream r8) {
        return (GpsLocationSummaryReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static GpsLocationSummaryReport parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (GpsLocationSummaryReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static GpsLocationSummaryReport parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static GpsLocationSummaryReport parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static GpsLocationSummaryReport parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static GpsLocationSummaryReport parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
