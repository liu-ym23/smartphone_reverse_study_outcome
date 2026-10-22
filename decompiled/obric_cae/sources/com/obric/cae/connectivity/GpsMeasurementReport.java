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
public final class GpsMeasurementReport extends GeneratedMessageV3 implements GpsMeasurementReportOrBuilder {
    public static final int ACCUMULATED_DELTA_RANGE_METERS_FIELD_NUMBER = 7;
    public static final int ACCUMULATED_DELTA_RANGE_STATE_FIELD_NUMBER = 9;
    public static final int ACCUMULATED_DELTA_RANGE_UNCERTAINTY_METERS_FIELD_NUMBER = 8;
    public static final int AZIMUTH_DEGREES_FIELD_NUMBER = 16;
    public static final int BASEBAND_CN0_DBHZ_FIELD_NUMBER = 5;
    public static final int CARRIER_FREQUENCY_HZ_FIELD_NUMBER = 3;
    public static final int CN0_DBHZ_FIELD_NUMBER = 4;
    public static final int CONSTELLATION_TYPE_FIELD_NUMBER = 2;
    private static final GpsMeasurementReport DEFAULT_INSTANCE = null;
    public static final int ELEVATION_DEGREES_FIELD_NUMBER = 15;
    public static final int MULTIPATH_INDICATOR_FIELD_NUMBER = 14;

    @Deprecated
    public static final Parser<GpsMeasurementReport> PARSER = null;
    public static final int PSEUDORANGE_FIELD_NUMBER = 6;
    public static final int RECEIVED_SV_TIME_NANOS_FIELD_NUMBER = 10;
    public static final int RECEIVED_SV_TIME_UNCERTAINTY_NANOS_FIELD_NUMBER = 11;
    public static final int STATE_FIELD_NUMBER = 13;
    public static final int SVID_FIELD_NUMBER = 1;
    public static final int TIME_OFFSET_NANOS_FIELD_NUMBER = 12;
    public static final int USED_IN_FIX_FIELD_NUMBER = 17;
    private static final long serialVersionUID = 0;
    private double accumulatedDeltaRangeMeters_;
    private int accumulatedDeltaRangeState_;
    private double accumulatedDeltaRangeUncertaintyMeters_;
    private float azimuthDegrees_;
    private double basebandCn0Dbhz_;
    private int bitField0_;
    private double carrierFrequencyHz_;
    private double cn0Dbhz_;
    private int constellationType_;
    private float elevationDegrees_;
    private byte memoizedIsInitialized;
    private int multipathIndicator_;
    private double pseudorange_;
    private long receivedSvTimeNanos_;
    private long receivedSvTimeUncertaintyNanos_;
    private int state_;
    private int svid_;
    private double timeOffsetNanos_;
    private boolean usedInFix_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GpsMeasurementReportOrBuilder {
        private double accumulatedDeltaRangeMeters_;
        private int accumulatedDeltaRangeState_;
        private double accumulatedDeltaRangeUncertaintyMeters_;
        private float azimuthDegrees_;
        private double basebandCn0Dbhz_;
        private int bitField0_;
        private double carrierFrequencyHz_;
        private double cn0Dbhz_;
        private int constellationType_;
        private float elevationDegrees_;
        private int multipathIndicator_;
        private double pseudorange_;
        private long receivedSvTimeNanos_;
        private long receivedSvTimeUncertaintyNanos_;
        private int state_;
        private int svid_;
        private double timeOffsetNanos_;
        private boolean usedInFix_;

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
        }

        private void buildPartial0(GpsMeasurementReport r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            GpsMeasurementReport.access$302(r8, this.svid_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            GpsMeasurementReport.access$402(r8, this.constellationType_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            GpsMeasurementReport.access$502(r8, this.carrierFrequencyHz_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            GpsMeasurementReport.access$602(r8, this.cn0Dbhz_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            GpsMeasurementReport.access$702(r8, this.basebandCn0Dbhz_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            GpsMeasurementReport.access$802(r8, this.pseudorange_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            GpsMeasurementReport.access$902(r8, this.accumulatedDeltaRangeMeters_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            GpsMeasurementReport.access$1002(r8, this.accumulatedDeltaRangeUncertaintyMeters_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            GpsMeasurementReport.access$1102(r8, this.accumulatedDeltaRangeState_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            GpsMeasurementReport.access$1202(r8, this.receivedSvTimeNanos_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            GpsMeasurementReport.access$1302(r8, this.receivedSvTimeUncertaintyNanos_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            GpsMeasurementReport.access$1402(r8, this.timeOffsetNanos_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            GpsMeasurementReport.access$1502(r8, this.state_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            GpsMeasurementReport.access$1602(r8, this.multipathIndicator_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            GpsMeasurementReport.access$1702(r8, this.elevationDegrees_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L52;
            GpsMeasurementReport.access$1802(r8, this.azimuthDegrees_);
            r11 = r11 | 32768;
        L52:
            if ((r10 & 65536) == 0) goto L54;
            GpsMeasurementReport.access$1902(r8, this.usedInFix_);
            r11 = r11 | 65536;
        L54:
            GpsMeasurementReport.access$2076(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsMeasurementReport_descriptor;
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

        public Builder clearAccumulatedDeltaRangeMeters() {
            this.bitField0_ &= -65;
            this.accumulatedDeltaRangeMeters_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearAccumulatedDeltaRangeState() {
            this.bitField0_ &= -257;
            this.accumulatedDeltaRangeState_ = 0;
            onChanged();
            return this;
        }

        public Builder clearAccumulatedDeltaRangeUncertaintyMeters() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.accumulatedDeltaRangeUncertaintyMeters_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearAzimuthDegrees() {
            this.bitField0_ &= -32769;
            this.azimuthDegrees_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBasebandCn0Dbhz() {
            this.bitField0_ &= -17;
            this.basebandCn0Dbhz_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearCarrierFrequencyHz() {
            this.bitField0_ &= -5;
            this.carrierFrequencyHz_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearCn0Dbhz() {
            this.bitField0_ &= -9;
            this.cn0Dbhz_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearConstellationType() {
            this.bitField0_ &= -3;
            this.constellationType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearElevationDegrees() {
            this.bitField0_ &= -16385;
            this.elevationDegrees_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearMultipathIndicator() {
            this.bitField0_ &= -8193;
            this.multipathIndicator_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPseudorange() {
            this.bitField0_ &= -33;
            this.pseudorange_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearReceivedSvTimeNanos() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.receivedSvTimeNanos_ = 0;
            onChanged();
            return this;
        }

        public Builder clearReceivedSvTimeUncertaintyNanos() {
            this.bitField0_ &= -1025;
            this.receivedSvTimeUncertaintyNanos_ = 0;
            onChanged();
            return this;
        }

        public Builder clearState() {
            this.bitField0_ &= -4097;
            this.state_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSvid() {
            this.bitField0_ &= -2;
            this.svid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimeOffsetNanos() {
            this.bitField0_ &= -2049;
            this.timeOffsetNanos_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearUsedInFix() {
            this.bitField0_ &= -65537;
            this.usedInFix_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public double getAccumulatedDeltaRangeMeters() {
            return this.accumulatedDeltaRangeMeters_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public int getAccumulatedDeltaRangeState() {
            return this.accumulatedDeltaRangeState_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public double getAccumulatedDeltaRangeUncertaintyMeters() {
            return this.accumulatedDeltaRangeUncertaintyMeters_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public float getAzimuthDegrees() {
            return this.azimuthDegrees_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public double getBasebandCn0Dbhz() {
            return this.basebandCn0Dbhz_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public double getCarrierFrequencyHz() {
            return this.carrierFrequencyHz_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public double getCn0Dbhz() {
            return this.cn0Dbhz_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public int getConstellationType() {
            return this.constellationType_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsMeasurementReport_descriptor;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public float getElevationDegrees() {
            return this.elevationDegrees_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public int getMultipathIndicator() {
            return this.multipathIndicator_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public double getPseudorange() {
            return this.pseudorange_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public long getReceivedSvTimeNanos() {
            return this.receivedSvTimeNanos_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public long getReceivedSvTimeUncertaintyNanos() {
            return this.receivedSvTimeUncertaintyNanos_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public int getState() {
            return this.state_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public int getSvid() {
            return this.svid_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public double getTimeOffsetNanos() {
            return this.timeOffsetNanos_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean getUsedInFix() {
            return this.usedInFix_;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasAccumulatedDeltaRangeMeters() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasAccumulatedDeltaRangeState() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasAccumulatedDeltaRangeUncertaintyMeters() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasAzimuthDegrees() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasBasebandCn0Dbhz() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasCarrierFrequencyHz() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasCn0Dbhz() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasConstellationType() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasElevationDegrees() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasMultipathIndicator() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasPseudorange() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasReceivedSvTimeNanos() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasReceivedSvTimeUncertaintyNanos() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasState() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasSvid() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasTimeOffsetNanos() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
        public boolean hasUsedInFix() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
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

        public Builder setAccumulatedDeltaRangeMeters(double r8) {
            this.accumulatedDeltaRangeMeters_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setAccumulatedDeltaRangeState(int r8) {
            this.accumulatedDeltaRangeState_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setAccumulatedDeltaRangeUncertaintyMeters(double r8) {
            this.accumulatedDeltaRangeUncertaintyMeters_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setAzimuthDegrees(float r8) {
            this.azimuthDegrees_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setBasebandCn0Dbhz(double r8) {
            this.basebandCn0Dbhz_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setCarrierFrequencyHz(double r8) {
            this.carrierFrequencyHz_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setCn0Dbhz(double r8) {
            this.cn0Dbhz_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setConstellationType(int r8) {
            this.constellationType_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setElevationDegrees(float r8) {
            this.elevationDegrees_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setMultipathIndicator(int r8) {
            this.multipathIndicator_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setPseudorange(double r8) {
            this.pseudorange_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setReceivedSvTimeNanos(long r8) {
            this.receivedSvTimeNanos_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setReceivedSvTimeUncertaintyNanos(long r8) {
            this.receivedSvTimeUncertaintyNanos_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setState(int r8) {
            this.state_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setSvid(int r8) {
            this.svid_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTimeOffsetNanos(double r8) {
            this.timeOffsetNanos_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setUsedInFix(boolean r8) {
            this.usedInFix_ = r8;
            this.bitField0_ |= 65536;
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
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsMeasurementReport_fieldAccessorTable.ensureFieldAccessorsInitialized(GpsMeasurementReport.class, Builder.class);
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
        public GpsMeasurementReport build() {
            GpsMeasurementReport r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GpsMeasurementReport buildPartial() {
            GpsMeasurementReport r8 = new GpsMeasurementReport(this, null);
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
        public GpsMeasurementReport getDefaultInstanceForType() {
            return GpsMeasurementReport.getDefaultInstance();
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
            this.svid_ = 0;
            this.constellationType_ = 0;
            this.carrierFrequencyHz_ = 0.0d;
            this.cn0Dbhz_ = 0.0d;
            this.basebandCn0Dbhz_ = 0.0d;
            this.pseudorange_ = 0.0d;
            this.accumulatedDeltaRangeMeters_ = 0.0d;
            this.accumulatedDeltaRangeUncertaintyMeters_ = 0.0d;
            this.accumulatedDeltaRangeState_ = 0;
            this.receivedSvTimeNanos_ = 0;
            this.receivedSvTimeUncertaintyNanos_ = 0;
            this.timeOffsetNanos_ = 0.0d;
            this.state_ = 0;
            this.multipathIndicator_ = 0;
            this.elevationDegrees_ = 0.0f;
            this.azimuthDegrees_ = 0.0f;
            this.usedInFix_ = false;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L39;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L36;
            int r12 = r8.readTag();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            switch(r12) {
                case 0: goto L26;
                case 8: goto L24;
                case 16: goto L23;
                case 25: goto L22;
                case 33: goto L21;
                case 41: goto L20;
                case 49: goto L19;
                case 57: goto L18;
                case 65: goto L17;
                case 72: goto L16;
                case 80: goto L15;
                case 88: goto L14;
                case 97: goto L13;
                case 104: goto L12;
                case 112: goto L11;
                case 125: goto L10;
                case 133: goto L9;
                case 136: goto L8;
                default: goto L27;
            };     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
        L8:
            this.usedInFix_ = r8.readBool();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 65536;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L9:
            this.azimuthDegrees_ = r8.readFloat();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 32768;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L10:
            this.elevationDegrees_ = r8.readFloat();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 16384;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L11:
            this.multipathIndicator_ = r8.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 8192;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L12:
            this.state_ = r8.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 4096;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L13:
            this.timeOffsetNanos_ = r8.readDouble();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 2048;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L14:
            this.receivedSvTimeUncertaintyNanos_ = r8.readInt64();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 1024;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L15:
            this.receivedSvTimeNanos_ = r8.readInt64();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 512;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L16:
            this.accumulatedDeltaRangeState_ = r8.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 256;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L17:
            this.accumulatedDeltaRangeUncertaintyMeters_ = r8.readDouble();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 128;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L18:
            this.accumulatedDeltaRangeMeters_ = r8.readDouble();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 64;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L19:
            this.pseudorange_ = r8.readDouble();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 32;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L20:
            this.basebandCn0Dbhz_ = r8.readDouble();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 16;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L21:
            this.cn0Dbhz_ = r8.readDouble();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 8;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L22:
            this.carrierFrequencyHz_ = r8.readDouble();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 4;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L23:
            this.constellationType_ = r8.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 2;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            goto L4
        L24:
            this.svid_ = r8.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
            this.bitField0_ |= 1;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
        L26:
            r11 = true;
            goto L4
        L27:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L29:
            th = move-exception;
            onChanged();
            throw th;
        L31:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L29
        L36:
            onChanged();
            return this;
        L39:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof GpsMeasurementReport) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((GpsMeasurementReport) r8);
        }

        public Builder mergeFrom(GpsMeasurementReport r8) {
            if (r8 != GpsMeasurementReport.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSvid() == false) goto L9;
            setSvid(r8.getSvid());
        L9:
            if (r8.hasConstellationType() == false) goto L12;
            setConstellationType(r8.getConstellationType());
        L12:
            if (r8.hasCarrierFrequencyHz() == false) goto L15;
            setCarrierFrequencyHz(r8.getCarrierFrequencyHz());
        L15:
            if (r8.hasCn0Dbhz() == false) goto L18;
            setCn0Dbhz(r8.getCn0Dbhz());
        L18:
            if (r8.hasBasebandCn0Dbhz() == false) goto L21;
            setBasebandCn0Dbhz(r8.getBasebandCn0Dbhz());
        L21:
            if (r8.hasPseudorange() == false) goto L24;
            setPseudorange(r8.getPseudorange());
        L24:
            if (r8.hasAccumulatedDeltaRangeMeters() == false) goto L27;
            setAccumulatedDeltaRangeMeters(r8.getAccumulatedDeltaRangeMeters());
        L27:
            if (r8.hasAccumulatedDeltaRangeUncertaintyMeters() == false) goto L30;
            setAccumulatedDeltaRangeUncertaintyMeters(r8.getAccumulatedDeltaRangeUncertaintyMeters());
        L30:
            if (r8.hasAccumulatedDeltaRangeState() == false) goto L33;
            setAccumulatedDeltaRangeState(r8.getAccumulatedDeltaRangeState());
        L33:
            if (r8.hasReceivedSvTimeNanos() == false) goto L36;
            setReceivedSvTimeNanos(r8.getReceivedSvTimeNanos());
        L36:
            if (r8.hasReceivedSvTimeUncertaintyNanos() == false) goto L39;
            setReceivedSvTimeUncertaintyNanos(r8.getReceivedSvTimeUncertaintyNanos());
        L39:
            if (r8.hasTimeOffsetNanos() == false) goto L42;
            setTimeOffsetNanos(r8.getTimeOffsetNanos());
        L42:
            if (r8.hasState() == false) goto L45;
            setState(r8.getState());
        L45:
            if (r8.hasMultipathIndicator() == false) goto L48;
            setMultipathIndicator(r8.getMultipathIndicator());
        L48:
            if (r8.hasElevationDegrees() == false) goto L51;
            setElevationDegrees(r8.getElevationDegrees());
        L51:
            if (r8.hasAzimuthDegrees() == false) goto L54;
            setAzimuthDegrees(r8.getAzimuthDegrees());
        L54:
            if (r8.hasUsedInFix() == false) goto L56;
            setUsedInFix(r8.getUsedInFix());
        L56:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new GpsMeasurementReport();
        PARSER = new AnonymousClass1();
    }

    private GpsMeasurementReport() {
        this.svid_ = 0;
        this.constellationType_ = 0;
        this.carrierFrequencyHz_ = 0.0d;
        this.cn0Dbhz_ = 0.0d;
        this.basebandCn0Dbhz_ = 0.0d;
        this.pseudorange_ = 0.0d;
        this.accumulatedDeltaRangeMeters_ = 0.0d;
        this.accumulatedDeltaRangeUncertaintyMeters_ = 0.0d;
        this.accumulatedDeltaRangeState_ = 0;
        this.receivedSvTimeNanos_ = 0;
        this.receivedSvTimeUncertaintyNanos_ = 0;
        this.timeOffsetNanos_ = 0.0d;
        this.state_ = 0;
        this.multipathIndicator_ = 0;
        this.elevationDegrees_ = 0.0f;
        this.azimuthDegrees_ = 0.0f;
        this.usedInFix_ = false;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ double access$1002(GpsMeasurementReport r8, double r10) {
        r8.accumulatedDeltaRangeUncertaintyMeters_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(GpsMeasurementReport r8, int r10) {
        r8.accumulatedDeltaRangeState_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1202(GpsMeasurementReport r8, long r10) {
        r8.receivedSvTimeNanos_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1302(GpsMeasurementReport r8, long r10) {
        r8.receivedSvTimeUncertaintyNanos_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$1402(GpsMeasurementReport r8, double r10) {
        r8.timeOffsetNanos_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(GpsMeasurementReport r8, int r10) {
        r8.state_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(GpsMeasurementReport r8, int r10) {
        r8.multipathIndicator_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1702(GpsMeasurementReport r8, float r10) {
        r8.elevationDegrees_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1802(GpsMeasurementReport r8, float r10) {
        r8.azimuthDegrees_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1902(GpsMeasurementReport r8, boolean r10) {
        r8.usedInFix_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2076(GpsMeasurementReport r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$302(GpsMeasurementReport r8, int r10) {
        r8.svid_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(GpsMeasurementReport r8, int r10) {
        r8.constellationType_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$502(GpsMeasurementReport r8, double r10) {
        r8.carrierFrequencyHz_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$602(GpsMeasurementReport r8, double r10) {
        r8.cn0Dbhz_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$702(GpsMeasurementReport r8, double r10) {
        r8.basebandCn0Dbhz_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$802(GpsMeasurementReport r8, double r10) {
        r8.pseudorange_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$902(GpsMeasurementReport r8, double r10) {
        r8.accumulatedDeltaRangeMeters_ = r10;
        return r10;
    }

    public static GpsMeasurementReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsMeasurementReport_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static GpsMeasurementReport parseDelimitedFrom(InputStream r8) {
        return (GpsMeasurementReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static GpsMeasurementReport parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<GpsMeasurementReport> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof GpsMeasurementReport) == false) goto L8;
        GpsMeasurementReport r10 = (GpsMeasurementReport) r8;
        if (hasSvid() == r10.hasSvid()) goto L13;
        return false;
    L13:
        if (hasSvid() == false) goto L18;
        if (getSvid() == r10.getSvid()) goto L18;
        return false;
    L18:
        if (hasConstellationType() == r10.hasConstellationType()) goto L21;
        return false;
    L21:
        if (hasConstellationType() == false) goto L26;
        if (getConstellationType() == r10.getConstellationType()) goto L26;
        return false;
    L26:
        if (hasCarrierFrequencyHz() == r10.hasCarrierFrequencyHz()) goto L29;
        return false;
    L29:
        if (hasCarrierFrequencyHz() == false) goto L34;
        if (Double.doubleToLongBits(getCarrierFrequencyHz()) == Double.doubleToLongBits(r10.getCarrierFrequencyHz())) goto L34;
        return false;
    L34:
        if (hasCn0Dbhz() == r10.hasCn0Dbhz()) goto L37;
        return false;
    L37:
        if (hasCn0Dbhz() == false) goto L42;
        if (Double.doubleToLongBits(getCn0Dbhz()) == Double.doubleToLongBits(r10.getCn0Dbhz())) goto L42;
        return false;
    L42:
        if (hasBasebandCn0Dbhz() == r10.hasBasebandCn0Dbhz()) goto L45;
        return false;
    L45:
        if (hasBasebandCn0Dbhz() == false) goto L50;
        if (Double.doubleToLongBits(getBasebandCn0Dbhz()) == Double.doubleToLongBits(r10.getBasebandCn0Dbhz())) goto L50;
        return false;
    L50:
        if (hasPseudorange() == r10.hasPseudorange()) goto L53;
        return false;
    L53:
        if (hasPseudorange() == false) goto L58;
        if (Double.doubleToLongBits(getPseudorange()) == Double.doubleToLongBits(r10.getPseudorange())) goto L58;
        return false;
    L58:
        if (hasAccumulatedDeltaRangeMeters() == r10.hasAccumulatedDeltaRangeMeters()) goto L61;
        return false;
    L61:
        if (hasAccumulatedDeltaRangeMeters() == false) goto L66;
        if (Double.doubleToLongBits(getAccumulatedDeltaRangeMeters()) == Double.doubleToLongBits(r10.getAccumulatedDeltaRangeMeters())) goto L66;
        return false;
    L66:
        if (hasAccumulatedDeltaRangeUncertaintyMeters() == r10.hasAccumulatedDeltaRangeUncertaintyMeters()) goto L69;
        return false;
    L69:
        if (hasAccumulatedDeltaRangeUncertaintyMeters() == false) goto L74;
        if (Double.doubleToLongBits(getAccumulatedDeltaRangeUncertaintyMeters()) == Double.doubleToLongBits(r10.getAccumulatedDeltaRangeUncertaintyMeters())) goto L74;
        return false;
    L74:
        if (hasAccumulatedDeltaRangeState() == r10.hasAccumulatedDeltaRangeState()) goto L77;
        return false;
    L77:
        if (hasAccumulatedDeltaRangeState() == false) goto L82;
        if (getAccumulatedDeltaRangeState() == r10.getAccumulatedDeltaRangeState()) goto L82;
        return false;
    L82:
        if (hasReceivedSvTimeNanos() == r10.hasReceivedSvTimeNanos()) goto L85;
        return false;
    L85:
        if (hasReceivedSvTimeNanos() == false) goto L90;
        if (getReceivedSvTimeNanos() == r10.getReceivedSvTimeNanos()) goto L90;
        return false;
    L90:
        if (hasReceivedSvTimeUncertaintyNanos() == r10.hasReceivedSvTimeUncertaintyNanos()) goto L93;
        return false;
    L93:
        if (hasReceivedSvTimeUncertaintyNanos() == false) goto L98;
        if (getReceivedSvTimeUncertaintyNanos() == r10.getReceivedSvTimeUncertaintyNanos()) goto L98;
        return false;
    L98:
        if (hasTimeOffsetNanos() == r10.hasTimeOffsetNanos()) goto L101;
        return false;
    L101:
        if (hasTimeOffsetNanos() == false) goto L106;
        if (Double.doubleToLongBits(getTimeOffsetNanos()) == Double.doubleToLongBits(r10.getTimeOffsetNanos())) goto L106;
        return false;
    L106:
        if (hasState() == r10.hasState()) goto L109;
        return false;
    L109:
        if (hasState() == false) goto L114;
        if (getState() == r10.getState()) goto L114;
        return false;
    L114:
        if (hasMultipathIndicator() == r10.hasMultipathIndicator()) goto L117;
        return false;
    L117:
        if (hasMultipathIndicator() == false) goto L122;
        if (getMultipathIndicator() == r10.getMultipathIndicator()) goto L122;
        return false;
    L122:
        if (hasElevationDegrees() == r10.hasElevationDegrees()) goto L125;
        return false;
    L125:
        if (hasElevationDegrees() == false) goto L130;
        if (Float.floatToIntBits(getElevationDegrees()) == Float.floatToIntBits(r10.getElevationDegrees())) goto L130;
        return false;
    L130:
        if (hasAzimuthDegrees() == r10.hasAzimuthDegrees()) goto L133;
        return false;
    L133:
        if (hasAzimuthDegrees() == false) goto L138;
        if (Float.floatToIntBits(getAzimuthDegrees()) == Float.floatToIntBits(r10.getAzimuthDegrees())) goto L138;
        return false;
    L138:
        if (hasUsedInFix() == r10.hasUsedInFix()) goto L141;
        return false;
    L141:
        if (hasUsedInFix() == false) goto L146;
        if (getUsedInFix() == r10.getUsedInFix()) goto L146;
        return false;
    L146:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L148;
        return false;
    L148:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public double getAccumulatedDeltaRangeMeters() {
        return this.accumulatedDeltaRangeMeters_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public int getAccumulatedDeltaRangeState() {
        return this.accumulatedDeltaRangeState_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public double getAccumulatedDeltaRangeUncertaintyMeters() {
        return this.accumulatedDeltaRangeUncertaintyMeters_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public float getAzimuthDegrees() {
        return this.azimuthDegrees_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public double getBasebandCn0Dbhz() {
        return this.basebandCn0Dbhz_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public double getCarrierFrequencyHz() {
        return this.carrierFrequencyHz_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public double getCn0Dbhz() {
        return this.cn0Dbhz_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public int getConstellationType() {
        return this.constellationType_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public float getElevationDegrees() {
        return this.elevationDegrees_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public int getMultipathIndicator() {
        return this.multipathIndicator_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GpsMeasurementReport> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public double getPseudorange() {
        return this.pseudorange_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public long getReceivedSvTimeNanos() {
        return this.receivedSvTimeNanos_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public long getReceivedSvTimeUncertaintyNanos() {
        return this.receivedSvTimeUncertaintyNanos_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt32Size(1, this.svid_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.constellationType_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeDoubleSize(3, this.carrierFrequencyHz_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeDoubleSize(4, this.cn0Dbhz_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeDoubleSize(5, this.basebandCn0Dbhz_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeDoubleSize(6, this.pseudorange_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeDoubleSize(7, this.accumulatedDeltaRangeMeters_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeDoubleSize(8, this.accumulatedDeltaRangeUncertaintyMeters_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.accumulatedDeltaRangeState_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + CodedOutputStream.computeInt64Size(10, this.receivedSvTimeNanos_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt64Size(11, this.receivedSvTimeUncertaintyNanos_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeDoubleSize(12, this.timeOffsetNanos_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.state_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.multipathIndicator_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeFloatSize(15, this.elevationDegrees_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r10 = r10 + CodedOutputStream.computeFloatSize(16, this.azimuthDegrees_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L56;
        r10 = r10 + CodedOutputStream.computeBoolSize(17, this.usedInFix_);
    L56:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public int getState() {
        return this.state_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public int getSvid() {
        return this.svid_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public double getTimeOffsetNanos() {
        return this.timeOffsetNanos_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean getUsedInFix() {
        return this.usedInFix_;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasAccumulatedDeltaRangeMeters() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasAccumulatedDeltaRangeState() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasAccumulatedDeltaRangeUncertaintyMeters() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasAzimuthDegrees() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasBasebandCn0Dbhz() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasCarrierFrequencyHz() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasCn0Dbhz() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasConstellationType() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasElevationDegrees() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasMultipathIndicator() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasPseudorange() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasReceivedSvTimeNanos() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasReceivedSvTimeUncertaintyNanos() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasState() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasSvid() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasTimeOffsetNanos() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.GpsMeasurementReportOrBuilder
    public boolean hasUsedInFix() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
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
        if (hasSvid() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSvid();
    L9:
        if (hasConstellationType() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getConstellationType();
    L12:
        if (hasCarrierFrequencyHz() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Internal.hashLong(Double.doubleToLongBits(getCarrierFrequencyHz()));
    L15:
        if (hasCn0Dbhz() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Internal.hashLong(Double.doubleToLongBits(getCn0Dbhz()));
    L18:
        if (hasBasebandCn0Dbhz() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + Internal.hashLong(Double.doubleToLongBits(getBasebandCn0Dbhz()));
    L21:
        if (hasPseudorange() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + Internal.hashLong(Double.doubleToLongBits(getPseudorange()));
    L24:
        if (hasAccumulatedDeltaRangeMeters() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + Internal.hashLong(Double.doubleToLongBits(getAccumulatedDeltaRangeMeters()));
    L27:
        if (hasAccumulatedDeltaRangeUncertaintyMeters() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + Internal.hashLong(Double.doubleToLongBits(getAccumulatedDeltaRangeUncertaintyMeters()));
    L30:
        if (hasAccumulatedDeltaRangeState() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getAccumulatedDeltaRangeState();
    L33:
        if (hasReceivedSvTimeNanos() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + Internal.hashLong(getReceivedSvTimeNanos());
    L36:
        if (hasReceivedSvTimeUncertaintyNanos() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + Internal.hashLong(getReceivedSvTimeUncertaintyNanos());
    L39:
        if (hasTimeOffsetNanos() == false) goto L42;
        r10 = b.a(r10, 37, 12, 53) + Internal.hashLong(Double.doubleToLongBits(getTimeOffsetNanos()));
    L42:
        if (hasState() == false) goto L45;
        r10 = b.a(r10, 37, 13, 53) + getState();
    L45:
        if (hasMultipathIndicator() == false) goto L48;
        r10 = b.a(r10, 37, 14, 53) + getMultipathIndicator();
    L48:
        if (hasElevationDegrees() == false) goto L51;
        r10 = b.a(r10, 37, 15, 53) + Float.floatToIntBits(getElevationDegrees());
    L51:
        if (hasAzimuthDegrees() == false) goto L54;
        r10 = b.a(r10, 37, 16, 53) + Float.floatToIntBits(getAzimuthDegrees());
    L54:
        if (hasUsedInFix() == false) goto L56;
        r10 = b.a(r10, 37, 17, 53) + Internal.hashBoolean(getUsedInFix());
    L56:
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
        return new GpsMeasurementReport();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt32(1, this.svid_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.constellationType_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeDouble(3, this.carrierFrequencyHz_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeDouble(4, this.cn0Dbhz_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeDouble(5, this.basebandCn0Dbhz_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeDouble(6, this.pseudorange_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeDouble(7, this.accumulatedDeltaRangeMeters_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeDouble(8, this.accumulatedDeltaRangeUncertaintyMeters_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.accumulatedDeltaRangeState_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r8.writeInt64(10, this.receivedSvTimeNanos_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt64(11, this.receivedSvTimeUncertaintyNanos_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeDouble(12, this.timeOffsetNanos_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeInt32(13, this.state_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeInt32(14, this.multipathIndicator_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeFloat(15, this.elevationDegrees_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r8.writeFloat(16, this.azimuthDegrees_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L53;
        r8.writeBool(17, this.usedInFix_);
    L53:
        getUnknownFields().writeTo(r8);
    }

    private GpsMeasurementReport(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.svid_ = 0;
        this.constellationType_ = 0;
        this.carrierFrequencyHz_ = 0.0d;
        this.cn0Dbhz_ = 0.0d;
        this.basebandCn0Dbhz_ = 0.0d;
        this.pseudorange_ = 0.0d;
        this.accumulatedDeltaRangeMeters_ = 0.0d;
        this.accumulatedDeltaRangeUncertaintyMeters_ = 0.0d;
        this.accumulatedDeltaRangeState_ = 0;
        this.receivedSvTimeNanos_ = 0;
        this.receivedSvTimeUncertaintyNanos_ = 0;
        this.timeOffsetNanos_ = 0.0d;
        this.state_ = 0;
        this.multipathIndicator_ = 0;
        this.elevationDegrees_ = 0.0f;
        this.azimuthDegrees_ = 0.0f;
        this.usedInFix_ = false;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(GpsMeasurementReport r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static GpsMeasurementReport parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (GpsMeasurementReport) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static GpsMeasurementReport parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_GpsMeasurementReport_fieldAccessorTable.ensureFieldAccessorsInitialized(GpsMeasurementReport.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ GpsMeasurementReport(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static GpsMeasurementReport parseFrom(CodedInputStream r8) {
        return (GpsMeasurementReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public GpsMeasurementReport getDefaultInstanceForType() {
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

    public static GpsMeasurementReport parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (GpsMeasurementReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static GpsMeasurementReport parseFrom(InputStream r8) {
        return (GpsMeasurementReport) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static GpsMeasurementReport parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (GpsMeasurementReport) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static GpsMeasurementReport parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static GpsMeasurementReport parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static GpsMeasurementReport parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static GpsMeasurementReport parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
