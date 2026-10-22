package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class GarageApScanResultRequest extends GeneratedMessageV3 implements GarageApScanResultRequestOrBuilder {
    public static final int BLE_STATUS_FIELD_NUMBER = 2;
    public static final int BLE_VALID_UNIQUE_COUNT_FIELD_NUMBER = 18;
    public static final int BT_DENSITY_BUCKET_FIELD_NUMBER = 3;
    public static final int BT_DEVCLASS_MAJOR_0_FRACTION_FIELD_NUMBER = 10;
    public static final int BT_DEVCLASS_MAJOR_5_FRACTION_FIELD_NUMBER = 11;
    public static final int BT_DEVICETYPE_2_FRACTION_FIELD_NUMBER = 8;
    public static final int BT_DEVICETYPE_3_FRACTION_FIELD_NUMBER = 9;
    public static final int BT_HAS_UUID_FRACTION_FIELD_NUMBER = 7;
    public static final int BT_RSSI_MEAN_FIELD_NUMBER = 4;
    public static final int BT_RSSI_STD_FIELD_NUMBER = 5;
    public static final int BT_STRONG_M80_FRACTION_FIELD_NUMBER = 6;
    private static final GarageApScanResultRequest DEFAULT_INSTANCE = null;
    public static final int GNSS_MEAN_CN0_FIELD_NUMBER = 14;
    public static final int GNSS_STATUS_FIELD_NUMBER = 12;
    public static final int GNSS_SV_COUNT_FIELD_NUMBER = 13;
    public static final int GNSS_TOP4_CN0_FIELD_NUMBER = 15;
    public static final int GNSS_USED_FRACTION_FIELD_NUMBER = 17;
    public static final int GNSS_USED_SV_COUNT_FIELD_NUMBER = 16;

    @Deprecated
    public static final Parser<GarageApScanResultRequest> PARSER = null;
    public static final int SCAN_ID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int bleStatus_;
    private int bleValidUniqueCount_;
    private float btDensityBucket_;
    private float btDevclassMajor0Fraction_;
    private float btDevclassMajor5Fraction_;
    private float btDevicetype2Fraction_;
    private float btDevicetype3Fraction_;
    private float btHasUuidFraction_;
    private float btRssiMean_;
    private float btRssiStd_;
    private float btStrongM80Fraction_;
    private float gnssMeanCn0_;
    private int gnssStatus_;
    private float gnssSvCount_;
    private float gnssTop4Cn0_;
    private float gnssUsedFraction_;
    private float gnssUsedSvCount_;
    private byte memoizedIsInitialized;
    private int scanId_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GarageApScanResultRequestOrBuilder {
        private int bitField0_;
        private int bleStatus_;
        private int bleValidUniqueCount_;
        private float btDensityBucket_;
        private float btDevclassMajor0Fraction_;
        private float btDevclassMajor5Fraction_;
        private float btDevicetype2Fraction_;
        private float btDevicetype3Fraction_;
        private float btHasUuidFraction_;
        private float btRssiMean_;
        private float btRssiStd_;
        private float btStrongM80Fraction_;
        private float gnssMeanCn0_;
        private int gnssStatus_;
        private float gnssSvCount_;
        private float gnssTop4Cn0_;
        private float gnssUsedFraction_;
        private float gnssUsedSvCount_;
        private int scanId_;

        private Builder() {
            this.bleStatus_ = 0;
            this.gnssStatus_ = 0;
        }

        private Builder(GeneratedMessageV3.BuilderParent r3) {
            super((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.bleStatus_ = 0;
            this.gnssStatus_ = 0;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r2, AnonymousClass1 r3) {
            this((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(GarageApScanResultRequest r5) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            GarageApScanResultRequest.access$302(r5, this.scanId_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L10;
            GarageApScanResultRequest.access$402(r5, this.bleStatus_);
            r1 = r1 | 2;
        L10:
            if ((r0 & 4) == 0) goto L13;
            GarageApScanResultRequest.access$502(r5, this.btDensityBucket_);
            r1 = r1 | 4;
        L13:
            if ((r0 & 8) == 0) goto L16;
            GarageApScanResultRequest.access$602(r5, this.btRssiMean_);
            r1 = r1 | 8;
        L16:
            if ((r0 & 16) == 0) goto L19;
            GarageApScanResultRequest.access$702(r5, this.btRssiStd_);
            r1 = r1 | 16;
        L19:
            if ((r0 & 32) == 0) goto L22;
            GarageApScanResultRequest.access$802(r5, this.btStrongM80Fraction_);
            r1 = r1 | 32;
        L22:
            if ((r0 & 64) == 0) goto L25;
            GarageApScanResultRequest.access$902(r5, this.btHasUuidFraction_);
            r1 = r1 | 64;
        L25:
            if ((r0 & 128) == 0) goto L28;
            GarageApScanResultRequest.access$1002(r5, this.btDevicetype2Fraction_);
            r1 = r1 | 128;
        L28:
            if ((r0 & 256) == 0) goto L31;
            GarageApScanResultRequest.access$1102(r5, this.btDevicetype3Fraction_);
            r1 = r1 | 256;
        L31:
            if ((r0 & 512) == 0) goto L34;
            GarageApScanResultRequest.access$1202(r5, this.btDevclassMajor0Fraction_);
            r1 = r1 | 512;
        L34:
            if ((r0 & 1024) == 0) goto L37;
            GarageApScanResultRequest.access$1302(r5, this.btDevclassMajor5Fraction_);
            r1 = r1 | 1024;
        L37:
            if ((r0 & 2048) == 0) goto L40;
            GarageApScanResultRequest.access$1402(r5, this.gnssStatus_);
            r1 = r1 | 2048;
        L40:
            if ((r0 & 4096) == 0) goto L43;
            GarageApScanResultRequest.access$1502(r5, this.gnssSvCount_);
            r1 = r1 | 4096;
        L43:
            if ((r0 & 8192) == 0) goto L46;
            GarageApScanResultRequest.access$1602(r5, this.gnssMeanCn0_);
            r1 = r1 | 8192;
        L46:
            if ((r0 & 16384) == 0) goto L49;
            GarageApScanResultRequest.access$1702(r5, this.gnssTop4Cn0_);
            r1 = r1 | 16384;
        L49:
            if ((r0 & 32768) == 0) goto L52;
            GarageApScanResultRequest.access$1802(r5, this.gnssUsedSvCount_);
            r1 = r1 | 32768;
        L52:
            if ((r0 & 65536) == 0) goto L55;
            GarageApScanResultRequest.access$1902(r5, this.gnssUsedFraction_);
            r1 = r1 | 65536;
        L55:
            if ((r0 & 131072) == 0) goto L57;
            GarageApScanResultRequest.access$2002(r5, this.bleValidUniqueCount_);
            r1 = r1 | 131072;
        L57:
            GarageApScanResultRequest.access$2176(r5, r1);
            return;
        L5:
            r1 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return (Builder) ZeusTransformUtils.preCheckCast(super.addRepeatedField(r1, r2), Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GarageApScanResultRequest build() {
            GarageApScanResultRequest r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw GeneratedMessageV3.Builder.newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GarageApScanResultRequest buildPartial() {
            GarageApScanResultRequest r0 = new GarageApScanResultRequest(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.scanId_ = 0;
            this.bleStatus_ = 0;
            this.btDensityBucket_ = 0.0f;
            this.btRssiMean_ = 0.0f;
            this.btRssiStd_ = 0.0f;
            this.btStrongM80Fraction_ = 0.0f;
            this.btHasUuidFraction_ = 0.0f;
            this.btDevicetype2Fraction_ = 0.0f;
            this.btDevicetype3Fraction_ = 0.0f;
            this.btDevclassMajor0Fraction_ = 0.0f;
            this.btDevclassMajor5Fraction_ = 0.0f;
            this.gnssStatus_ = 0;
            this.gnssSvCount_ = 0.0f;
            this.gnssMeanCn0_ = 0.0f;
            this.gnssTop4Cn0_ = 0.0f;
            this.gnssUsedSvCount_ = 0.0f;
            this.gnssUsedFraction_ = 0.0f;
            this.bleValidUniqueCount_ = 0;
            return this;
        }

        public Builder clearBleStatus() {
            this.bitField0_ &= -3;
            this.bleStatus_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBleValidUniqueCount() {
            this.bitField0_ &= -131073;
            this.bleValidUniqueCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBtDensityBucket() {
            this.bitField0_ &= -5;
            this.btDensityBucket_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtDevclassMajor0Fraction() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.btDevclassMajor0Fraction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtDevclassMajor5Fraction() {
            this.bitField0_ &= -1025;
            this.btDevclassMajor5Fraction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtDevicetype2Fraction() {
            this.bitField0_ &= -129;
            this.btDevicetype2Fraction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtDevicetype3Fraction() {
            this.bitField0_ &= -257;
            this.btDevicetype3Fraction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtHasUuidFraction() {
            this.bitField0_ &= -65;
            this.btHasUuidFraction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtRssiMean() {
            this.bitField0_ &= -9;
            this.btRssiMean_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtRssiStd() {
            this.bitField0_ &= -17;
            this.btRssiStd_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBtStrongM80Fraction() {
            this.bitField0_ &= -33;
            this.btStrongM80Fraction_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r2) {
            return (Builder) ZeusTransformUtils.preCheckCast(super.clearField(r2), Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder clearGnssMeanCn0() {
            this.bitField0_ &= -8193;
            this.gnssMeanCn0_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearGnssStatus() {
            this.bitField0_ &= -2049;
            this.gnssStatus_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGnssSvCount() {
            this.bitField0_ &= -4097;
            this.gnssSvCount_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearGnssTop4Cn0() {
            this.bitField0_ &= -16385;
            this.gnssTop4Cn0_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearGnssUsedFraction() {
            this.bitField0_ &= -65537;
            this.gnssUsedFraction_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearGnssUsedSvCount() {
            this.bitField0_ &= -32769;
            this.gnssUsedSvCount_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r1) {
            return clearOneof(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r2) {
            return (Builder) ZeusTransformUtils.preCheckCast(super.clearOneof(r2), Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder clearScanId() {
            this.bitField0_ &= -2;
            this.scanId_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) ZeusTransformUtils.preCheckCast(super.clone(), Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo141clone() {
            return clone();
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public GarageApScanStatus getBleStatus() {
            GarageApScanStatus r0 = GarageApScanStatus.forNumber(this.bleStatus_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public int getBleValidUniqueCount() {
            return this.bleValidUniqueCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtDensityBucket() {
            return this.btDensityBucket_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtDevclassMajor0Fraction() {
            return this.btDevclassMajor0Fraction_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtDevclassMajor5Fraction() {
            return this.btDevclassMajor5Fraction_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtDevicetype2Fraction() {
            return this.btDevicetype2Fraction_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtDevicetype3Fraction() {
            return this.btDevicetype3Fraction_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtHasUuidFraction() {
            return this.btHasUuidFraction_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtRssiMean() {
            return this.btRssiMean_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtRssiStd() {
            return this.btRssiStd_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getBtStrongM80Fraction() {
            return this.btStrongM80Fraction_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GarageApScanResultRequest getDefaultInstanceForType() {
            return GarageApScanResultRequest.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_descriptor;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getGnssMeanCn0() {
            return this.gnssMeanCn0_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public GarageApScanStatus getGnssStatus() {
            GarageApScanStatus r0 = GarageApScanStatus.forNumber(this.gnssStatus_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getGnssSvCount() {
            return this.gnssSvCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getGnssTop4Cn0() {
            return this.gnssTop4Cn0_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getGnssUsedFraction() {
            return this.gnssUsedFraction_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public float getGnssUsedSvCount() {
            return this.gnssUsedSvCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public int getScanId() {
            return this.scanId_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBleStatus() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBleValidUniqueCount() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtDensityBucket() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtDevclassMajor0Fraction() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtDevclassMajor5Fraction() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtDevicetype2Fraction() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtDevicetype3Fraction() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtHasUuidFraction() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtRssiMean() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtRssiStd() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasBtStrongM80Fraction() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasGnssMeanCn0() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasGnssStatus() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasGnssSvCount() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasGnssTop4Cn0() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasGnssUsedFraction() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasGnssUsedSvCount() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
        public boolean hasScanId() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageApScanResultRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasScanId() == true) goto L6;
            return false;
        L6:
            if (hasBleStatus() == true) goto L9;
            return false;
        L9:
            if (hasBtDensityBucket() == true) goto L12;
            return false;
        L12:
            if (hasBtRssiMean() == true) goto L15;
            return false;
        L15:
            if (hasBtRssiStd() == true) goto L18;
            return false;
        L18:
            if (hasBtStrongM80Fraction() == true) goto L21;
            return false;
        L21:
            if (hasBtHasUuidFraction() == true) goto L24;
            return false;
        L24:
            if (hasBtDevicetype2Fraction() == true) goto L27;
            return false;
        L27:
            if (hasBtDevicetype3Fraction() == true) goto L30;
            return false;
        L30:
            if (hasBtDevclassMajor0Fraction() == true) goto L33;
            return false;
        L33:
            if (hasBtDevclassMajor5Fraction() == true) goto L36;
            return false;
        L36:
            if (hasGnssStatus() == true) goto L39;
            return false;
        L39:
            if (hasGnssSvCount() == true) goto L42;
            return false;
        L42:
            if (hasGnssMeanCn0() == true) goto L45;
            return false;
        L45:
            if (hasGnssTop4Cn0() == true) goto L48;
            return false;
        L48:
            if (hasGnssUsedSvCount() == true) goto L51;
            return false;
        L51:
            if (hasGnssUsedFraction() == true) goto L54;
            return false;
        L54:
            if (hasBleValidUniqueCount() == true) goto L56;
            return false;
        L56:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ Message.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
            Objects.requireNonNull(r7);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L42;
            int r2 = r6.readTag();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            switch(r2) {
                case 0: goto L34;
                case 8: goto L31;
                case 16: goto L27;
                case 29: goto L26;
                case 37: goto L25;
                case 45: goto L24;
                case 53: goto L23;
                case 61: goto L22;
                case 69: goto L21;
                case 77: goto L20;
                case 85: goto L19;
                case 93: goto L18;
                case 96: goto L14;
                case 109: goto L13;
                case 117: goto L12;
                case 125: goto L11;
                case 133: goto L10;
                case 141: goto L9;
                case 144: goto L7;
                default: goto L33;
            };     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
        L7:
            this.bleValidUniqueCount_ = r6.readUInt32();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            int r3 = this.bitField0_ | 131072;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
        L8:
            this.bitField0_ = r3;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L9:
            this.gnssUsedFraction_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 65536;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L10:
            this.gnssUsedSvCount_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 32768;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L11:
            this.gnssTop4Cn0_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 16384;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L12:
            this.gnssMeanCn0_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 8192;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L13:
            this.gnssSvCount_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 4096;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L14:
            int r4 = r6.readEnum();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (GarageApScanStatus.forNumber(r4) != null) goto L17;
            mergeUnknownVarintField(12, r4);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L17:
            this.gnssStatus_ = r4;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 2048;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L18:
            this.btDevclassMajor5Fraction_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 1024;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L19:
            this.btDevclassMajor0Fraction_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 512;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L20:
            this.btDevicetype3Fraction_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 256;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L21:
            this.btDevicetype2Fraction_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 128;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L22:
            this.btHasUuidFraction_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 64;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L23:
            this.btStrongM80Fraction_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 32;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L24:
            this.btRssiStd_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 16;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L25:
            this.btRssiMean_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 8;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L26:
            this.btDensityBucket_ = r6.readFloat();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 4;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L27:
            int r5 = r6.readEnum();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (GarageApScanStatus.forNumber(r5) != null) goto L30;
            mergeUnknownVarintField(2, r5);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L30:
            this.bleStatus_ = r5;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 2;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L8
        L31:
            this.scanId_ = r6.readUInt32();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            r3 = this.bitField0_ | 1;
        L34:
            r0 = true;
            goto L3
        L33:
            if (parseUnknownField(r6, r7, r2) == true) goto L3;
        L35:
            th = move-exception;
            onChanged();
            throw th;
        L37:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L35
        L42:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, GarageApScanResultRequest.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(r4, GarageApScanResultRequest.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(GarageApScanResultRequest r2) {
            if (r2 != GarageApScanResultRequest.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.hasScanId() == false) goto L9;
            setScanId(r2.getScanId());
        L9:
            if (r2.hasBleStatus() == false) goto L12;
            setBleStatus(r2.getBleStatus());
        L12:
            if (r2.hasBtDensityBucket() == false) goto L15;
            setBtDensityBucket(r2.getBtDensityBucket());
        L15:
            if (r2.hasBtRssiMean() == false) goto L18;
            setBtRssiMean(r2.getBtRssiMean());
        L18:
            if (r2.hasBtRssiStd() == false) goto L21;
            setBtRssiStd(r2.getBtRssiStd());
        L21:
            if (r2.hasBtStrongM80Fraction() == false) goto L24;
            setBtStrongM80Fraction(r2.getBtStrongM80Fraction());
        L24:
            if (r2.hasBtHasUuidFraction() == false) goto L27;
            setBtHasUuidFraction(r2.getBtHasUuidFraction());
        L27:
            if (r2.hasBtDevicetype2Fraction() == false) goto L30;
            setBtDevicetype2Fraction(r2.getBtDevicetype2Fraction());
        L30:
            if (r2.hasBtDevicetype3Fraction() == false) goto L33;
            setBtDevicetype3Fraction(r2.getBtDevicetype3Fraction());
        L33:
            if (r2.hasBtDevclassMajor0Fraction() == false) goto L36;
            setBtDevclassMajor0Fraction(r2.getBtDevclassMajor0Fraction());
        L36:
            if (r2.hasBtDevclassMajor5Fraction() == false) goto L39;
            setBtDevclassMajor5Fraction(r2.getBtDevclassMajor5Fraction());
        L39:
            if (r2.hasGnssStatus() == false) goto L42;
            setGnssStatus(r2.getGnssStatus());
        L42:
            if (r2.hasGnssSvCount() == false) goto L45;
            setGnssSvCount(r2.getGnssSvCount());
        L45:
            if (r2.hasGnssMeanCn0() == false) goto L48;
            setGnssMeanCn0(r2.getGnssMeanCn0());
        L48:
            if (r2.hasGnssTop4Cn0() == false) goto L51;
            setGnssTop4Cn0(r2.getGnssTop4Cn0());
        L51:
            if (r2.hasGnssUsedSvCount() == false) goto L54;
            setGnssUsedSvCount(r2.getGnssUsedSvCount());
        L54:
            if (r2.hasGnssUsedFraction() == false) goto L57;
            setGnssUsedFraction(r2.getGnssUsedFraction());
        L57:
            if (r2.hasBleValidUniqueCount() == false) goto L59;
            setBleValidUniqueCount(r2.getBleValidUniqueCount());
        L59:
            mergeUnknownFields(r2.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r1) {
            return mergeUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r2) {
            return (Builder) ZeusTransformUtils.preCheckCast(super.mergeUnknownFields(r2), Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder setBleStatus(GarageApScanStatus r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 2;
            this.bleStatus_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder setBleValidUniqueCount(int r2) {
            this.bleValidUniqueCount_ = r2;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setBtDensityBucket(float r1) {
            this.btDensityBucket_ = r1;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setBtDevclassMajor0Fraction(float r1) {
            this.btDevclassMajor0Fraction_ = r1;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setBtDevclassMajor5Fraction(float r1) {
            this.btDevclassMajor5Fraction_ = r1;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setBtDevicetype2Fraction(float r1) {
            this.btDevicetype2Fraction_ = r1;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setBtDevicetype3Fraction(float r1) {
            this.btDevicetype3Fraction_ = r1;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setBtHasUuidFraction(float r1) {
            this.btHasUuidFraction_ = r1;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setBtRssiMean(float r1) {
            this.btRssiMean_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setBtRssiStd(float r1) {
            this.btRssiStd_ = r1;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setBtStrongM80Fraction(float r1) {
            this.btStrongM80Fraction_ = r1;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return (Builder) ZeusTransformUtils.preCheckCast(super.setField(r1, r2), Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder setGnssMeanCn0(float r1) {
            this.gnssMeanCn0_ = r1;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setGnssStatus(GarageApScanStatus r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 2048;
            this.gnssStatus_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder setGnssSvCount(float r1) {
            this.gnssSvCount_ = r1;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setGnssTop4Cn0(float r1) {
            this.gnssTop4Cn0_ = r1;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setGnssUsedFraction(float r2) {
            this.gnssUsedFraction_ = r2;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setGnssUsedSvCount(float r2) {
            this.gnssUsedSvCount_ = r2;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return (Builder) ZeusTransformUtils.preCheckCast(super.setRepeatedField(r1, r2, r3), Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder setScanId(int r1) {
            this.scanId_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r2) {
            return (Builder) ZeusTransformUtils.preCheckCast(super.setUnknownFields(r2), Builder.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        DEFAULT_INSTANCE = new GarageApScanResultRequest();
        PARSER = new AnonymousClass1();
    }

    private GarageApScanResultRequest() {
        this.scanId_ = 0;
        this.btDensityBucket_ = 0.0f;
        this.btRssiMean_ = 0.0f;
        this.btRssiStd_ = 0.0f;
        this.btStrongM80Fraction_ = 0.0f;
        this.btHasUuidFraction_ = 0.0f;
        this.btDevicetype2Fraction_ = 0.0f;
        this.btDevicetype3Fraction_ = 0.0f;
        this.btDevclassMajor0Fraction_ = 0.0f;
        this.btDevclassMajor5Fraction_ = 0.0f;
        this.gnssSvCount_ = 0.0f;
        this.gnssMeanCn0_ = 0.0f;
        this.gnssTop4Cn0_ = 0.0f;
        this.gnssUsedSvCount_ = 0.0f;
        this.gnssUsedFraction_ = 0.0f;
        this.bleValidUniqueCount_ = 0;
        this.memoizedIsInitialized = -1;
        this.bleStatus_ = 0;
        this.gnssStatus_ = 0;
    }

    private GarageApScanResultRequest(GeneratedMessageV3.Builder<?> r2) {
        super(r2);
        this.scanId_ = 0;
        this.bleStatus_ = 0;
        this.btDensityBucket_ = 0.0f;
        this.btRssiMean_ = 0.0f;
        this.btRssiStd_ = 0.0f;
        this.btStrongM80Fraction_ = 0.0f;
        this.btHasUuidFraction_ = 0.0f;
        this.btDevicetype2Fraction_ = 0.0f;
        this.btDevicetype3Fraction_ = 0.0f;
        this.btDevclassMajor0Fraction_ = 0.0f;
        this.btDevclassMajor5Fraction_ = 0.0f;
        this.gnssStatus_ = 0;
        this.gnssSvCount_ = 0.0f;
        this.gnssMeanCn0_ = 0.0f;
        this.gnssTop4Cn0_ = 0.0f;
        this.gnssUsedSvCount_ = 0.0f;
        this.gnssUsedFraction_ = 0.0f;
        this.bleValidUniqueCount_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ GarageApScanResultRequest(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ float access$1002(GarageApScanResultRequest r0, float r1) {
        r0.btDevicetype2Fraction_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1102(GarageApScanResultRequest r0, float r1) {
        r0.btDevicetype3Fraction_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1202(GarageApScanResultRequest r0, float r1) {
        r0.btDevclassMajor0Fraction_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1302(GarageApScanResultRequest r0, float r1) {
        r0.btDevclassMajor5Fraction_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1402(GarageApScanResultRequest r0, int r1) {
        r0.gnssStatus_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1502(GarageApScanResultRequest r0, float r1) {
        r0.gnssSvCount_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1602(GarageApScanResultRequest r0, float r1) {
        r0.gnssMeanCn0_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1702(GarageApScanResultRequest r0, float r1) {
        r0.gnssTop4Cn0_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1802(GarageApScanResultRequest r0, float r1) {
        r0.gnssUsedSvCount_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$1902(GarageApScanResultRequest r0, float r1) {
        r0.gnssUsedFraction_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$2002(GarageApScanResultRequest r0, int r1) {
        r0.bleValidUniqueCount_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$2176(GarageApScanResultRequest r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    public static /* synthetic */ int access$302(GarageApScanResultRequest r0, int r1) {
        r0.scanId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(GarageApScanResultRequest r0, int r1) {
        r0.bleStatus_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$502(GarageApScanResultRequest r0, float r1) {
        r0.btDensityBucket_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$602(GarageApScanResultRequest r0, float r1) {
        r0.btRssiMean_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$702(GarageApScanResultRequest r0, float r1) {
        r0.btRssiStd_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$802(GarageApScanResultRequest r0, float r1) {
        r0.btStrongM80Fraction_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$902(GarageApScanResultRequest r0, float r1) {
        r0.btHasUuidFraction_ = r1;
        return r1;
    }

    public static GarageApScanResultRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GarageApScanResultRequest r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static GarageApScanResultRequest parseDelimitedFrom(InputStream r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(ByteString r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(CodedInputStream r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(InputStream r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(ByteBuffer r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(byte[] r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageApScanResultRequest parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
    }

    public static Parser<GarageApScanResultRequest> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GarageApScanResultRequest.class) == false) goto L8;
        GarageApScanResultRequest r6 = (GarageApScanResultRequest) ZeusTransformUtils.preCheckCast(r5, GarageApScanResultRequest.class, "com.obric.memorydata.plugin");
        if (hasScanId() == r6.hasScanId()) goto L13;
        return false;
    L13:
        if (hasScanId() == false) goto L18;
        if (getScanId() == r6.getScanId()) goto L18;
        return false;
    L18:
        if (hasBleStatus() == r6.hasBleStatus()) goto L21;
        return false;
    L21:
        if (hasBleStatus() == false) goto L26;
        if (this.bleStatus_ == r6.bleStatus_) goto L26;
        return false;
    L26:
        if (hasBtDensityBucket() == r6.hasBtDensityBucket()) goto L29;
        return false;
    L29:
        if (hasBtDensityBucket() == false) goto L34;
        if (Float.floatToIntBits(getBtDensityBucket()) == Float.floatToIntBits(r6.getBtDensityBucket())) goto L34;
        return false;
    L34:
        if (hasBtRssiMean() == r6.hasBtRssiMean()) goto L37;
        return false;
    L37:
        if (hasBtRssiMean() == false) goto L42;
        if (Float.floatToIntBits(getBtRssiMean()) == Float.floatToIntBits(r6.getBtRssiMean())) goto L42;
        return false;
    L42:
        if (hasBtRssiStd() == r6.hasBtRssiStd()) goto L45;
        return false;
    L45:
        if (hasBtRssiStd() == false) goto L50;
        if (Float.floatToIntBits(getBtRssiStd()) == Float.floatToIntBits(r6.getBtRssiStd())) goto L50;
        return false;
    L50:
        if (hasBtStrongM80Fraction() == r6.hasBtStrongM80Fraction()) goto L53;
        return false;
    L53:
        if (hasBtStrongM80Fraction() == false) goto L58;
        if (Float.floatToIntBits(getBtStrongM80Fraction()) == Float.floatToIntBits(r6.getBtStrongM80Fraction())) goto L58;
        return false;
    L58:
        if (hasBtHasUuidFraction() == r6.hasBtHasUuidFraction()) goto L61;
        return false;
    L61:
        if (hasBtHasUuidFraction() == false) goto L66;
        if (Float.floatToIntBits(getBtHasUuidFraction()) == Float.floatToIntBits(r6.getBtHasUuidFraction())) goto L66;
        return false;
    L66:
        if (hasBtDevicetype2Fraction() == r6.hasBtDevicetype2Fraction()) goto L69;
        return false;
    L69:
        if (hasBtDevicetype2Fraction() == false) goto L74;
        if (Float.floatToIntBits(getBtDevicetype2Fraction()) == Float.floatToIntBits(r6.getBtDevicetype2Fraction())) goto L74;
        return false;
    L74:
        if (hasBtDevicetype3Fraction() == r6.hasBtDevicetype3Fraction()) goto L77;
        return false;
    L77:
        if (hasBtDevicetype3Fraction() == false) goto L82;
        if (Float.floatToIntBits(getBtDevicetype3Fraction()) == Float.floatToIntBits(r6.getBtDevicetype3Fraction())) goto L82;
        return false;
    L82:
        if (hasBtDevclassMajor0Fraction() == r6.hasBtDevclassMajor0Fraction()) goto L85;
        return false;
    L85:
        if (hasBtDevclassMajor0Fraction() == false) goto L90;
        if (Float.floatToIntBits(getBtDevclassMajor0Fraction()) == Float.floatToIntBits(r6.getBtDevclassMajor0Fraction())) goto L90;
        return false;
    L90:
        if (hasBtDevclassMajor5Fraction() == r6.hasBtDevclassMajor5Fraction()) goto L93;
        return false;
    L93:
        if (hasBtDevclassMajor5Fraction() == false) goto L98;
        if (Float.floatToIntBits(getBtDevclassMajor5Fraction()) == Float.floatToIntBits(r6.getBtDevclassMajor5Fraction())) goto L98;
        return false;
    L98:
        if (hasGnssStatus() == r6.hasGnssStatus()) goto L101;
        return false;
    L101:
        if (hasGnssStatus() == false) goto L106;
        if (this.gnssStatus_ == r6.gnssStatus_) goto L106;
        return false;
    L106:
        if (hasGnssSvCount() == r6.hasGnssSvCount()) goto L109;
        return false;
    L109:
        if (hasGnssSvCount() == false) goto L114;
        if (Float.floatToIntBits(getGnssSvCount()) == Float.floatToIntBits(r6.getGnssSvCount())) goto L114;
        return false;
    L114:
        if (hasGnssMeanCn0() == r6.hasGnssMeanCn0()) goto L117;
        return false;
    L117:
        if (hasGnssMeanCn0() == false) goto L122;
        if (Float.floatToIntBits(getGnssMeanCn0()) == Float.floatToIntBits(r6.getGnssMeanCn0())) goto L122;
        return false;
    L122:
        if (hasGnssTop4Cn0() == r6.hasGnssTop4Cn0()) goto L125;
        return false;
    L125:
        if (hasGnssTop4Cn0() == false) goto L130;
        if (Float.floatToIntBits(getGnssTop4Cn0()) == Float.floatToIntBits(r6.getGnssTop4Cn0())) goto L130;
        return false;
    L130:
        if (hasGnssUsedSvCount() == r6.hasGnssUsedSvCount()) goto L133;
        return false;
    L133:
        if (hasGnssUsedSvCount() == false) goto L138;
        if (Float.floatToIntBits(getGnssUsedSvCount()) == Float.floatToIntBits(r6.getGnssUsedSvCount())) goto L138;
        return false;
    L138:
        if (hasGnssUsedFraction() == r6.hasGnssUsedFraction()) goto L141;
        return false;
    L141:
        if (hasGnssUsedFraction() == false) goto L146;
        if (Float.floatToIntBits(getGnssUsedFraction()) == Float.floatToIntBits(r6.getGnssUsedFraction())) goto L146;
        return false;
    L146:
        if (hasBleValidUniqueCount() == r6.hasBleValidUniqueCount()) goto L149;
        return false;
    L149:
        if (hasBleValidUniqueCount() == false) goto L154;
        if (getBleValidUniqueCount() == r6.getBleValidUniqueCount()) goto L154;
        return false;
    L154:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L156;
        return false;
    L156:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public GarageApScanStatus getBleStatus() {
        GarageApScanStatus r0 = GarageApScanStatus.forNumber(this.bleStatus_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public int getBleValidUniqueCount() {
        return this.bleValidUniqueCount_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtDensityBucket() {
        return this.btDensityBucket_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtDevclassMajor0Fraction() {
        return this.btDevclassMajor0Fraction_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtDevclassMajor5Fraction() {
        return this.btDevclassMajor5Fraction_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtDevicetype2Fraction() {
        return this.btDevicetype2Fraction_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtDevicetype3Fraction() {
        return this.btDevicetype3Fraction_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtHasUuidFraction() {
        return this.btHasUuidFraction_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtRssiMean() {
        return this.btRssiMean_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtRssiStd() {
        return this.btRssiStd_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getBtStrongM80Fraction() {
        return this.btStrongM80Fraction_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GarageApScanResultRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getGnssMeanCn0() {
        return this.gnssMeanCn0_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public GarageApScanStatus getGnssStatus() {
        GarageApScanStatus r0 = GarageApScanStatus.forNumber(this.gnssStatus_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getGnssSvCount() {
        return this.gnssSvCount_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getGnssTop4Cn0() {
        return this.gnssTop4Cn0_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getGnssUsedFraction() {
        return this.gnssUsedFraction_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public float getGnssUsedSvCount() {
        return this.gnssUsedSvCount_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GarageApScanResultRequest> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public int getScanId() {
        return this.scanId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r1 = 0 + CodedOutputStream.computeUInt32Size(1, this.scanId_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r1 = r1 + CodedOutputStream.computeEnumSize(2, this.bleStatus_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r1 = r1 + CodedOutputStream.computeFloatSize(3, this.btDensityBucket_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r1 = r1 + CodedOutputStream.computeFloatSize(4, this.btRssiMean_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r1 = r1 + CodedOutputStream.computeFloatSize(5, this.btRssiStd_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r1 = r1 + CodedOutputStream.computeFloatSize(6, this.btStrongM80Fraction_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r1 = r1 + CodedOutputStream.computeFloatSize(7, this.btHasUuidFraction_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r1 = r1 + CodedOutputStream.computeFloatSize(8, this.btDevicetype2Fraction_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r1 = r1 + CodedOutputStream.computeFloatSize(9, this.btDevicetype3Fraction_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r1 = r1 + CodedOutputStream.computeFloatSize(10, this.btDevclassMajor0Fraction_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r1 = r1 + CodedOutputStream.computeFloatSize(11, this.btDevclassMajor5Fraction_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r1 = r1 + CodedOutputStream.computeEnumSize(12, this.gnssStatus_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r1 = r1 + CodedOutputStream.computeFloatSize(13, this.gnssSvCount_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r1 = r1 + CodedOutputStream.computeFloatSize(14, this.gnssMeanCn0_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r1 = r1 + CodedOutputStream.computeFloatSize(15, this.gnssTop4Cn0_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r1 = r1 + CodedOutputStream.computeFloatSize(16, this.gnssUsedSvCount_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r1 = r1 + CodedOutputStream.computeFloatSize(17, this.gnssUsedFraction_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L59;
        r1 = r1 + CodedOutputStream.computeUInt32Size(18, this.bleValidUniqueCount_);
    L59:
        int r2 = getUnknownFields().getSerializedSize() + r1;
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBleStatus() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBleValidUniqueCount() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtDensityBucket() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtDevclassMajor0Fraction() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtDevclassMajor5Fraction() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtDevicetype2Fraction() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtDevicetype3Fraction() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtHasUuidFraction() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtRssiMean() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtRssiStd() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasBtStrongM80Fraction() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasGnssMeanCn0() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasGnssStatus() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasGnssSvCount() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasGnssTop4Cn0() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasGnssUsedFraction() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasGnssUsedSvCount() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageApScanResultRequestOrBuilder
    public boolean hasScanId() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r0 = this.memoizedHashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = getDescriptor().hashCode() + 779;
        if (hasScanId() == false) goto L9;
        r1 = a.a(r1, 37, 1, 53) + getScanId();
    L9:
        if (hasBleStatus() == false) goto L12;
        r1 = a.a(r1, 37, 2, 53) + this.bleStatus_;
    L12:
        if (hasBtDensityBucket() == false) goto L15;
        r1 = a.a(r1, 37, 3, 53) + Float.floatToIntBits(getBtDensityBucket());
    L15:
        if (hasBtRssiMean() == false) goto L18;
        r1 = a.a(r1, 37, 4, 53) + Float.floatToIntBits(getBtRssiMean());
    L18:
        if (hasBtRssiStd() == false) goto L21;
        r1 = a.a(r1, 37, 5, 53) + Float.floatToIntBits(getBtRssiStd());
    L21:
        if (hasBtStrongM80Fraction() == false) goto L24;
        r1 = a.a(r1, 37, 6, 53) + Float.floatToIntBits(getBtStrongM80Fraction());
    L24:
        if (hasBtHasUuidFraction() == false) goto L27;
        r1 = a.a(r1, 37, 7, 53) + Float.floatToIntBits(getBtHasUuidFraction());
    L27:
        if (hasBtDevicetype2Fraction() == false) goto L30;
        r1 = a.a(r1, 37, 8, 53) + Float.floatToIntBits(getBtDevicetype2Fraction());
    L30:
        if (hasBtDevicetype3Fraction() == false) goto L33;
        r1 = a.a(r1, 37, 9, 53) + Float.floatToIntBits(getBtDevicetype3Fraction());
    L33:
        if (hasBtDevclassMajor0Fraction() == false) goto L36;
        r1 = a.a(r1, 37, 10, 53) + Float.floatToIntBits(getBtDevclassMajor0Fraction());
    L36:
        if (hasBtDevclassMajor5Fraction() == false) goto L39;
        r1 = a.a(r1, 37, 11, 53) + Float.floatToIntBits(getBtDevclassMajor5Fraction());
    L39:
        if (hasGnssStatus() == false) goto L42;
        r1 = a.a(r1, 37, 12, 53) + this.gnssStatus_;
    L42:
        if (hasGnssSvCount() == false) goto L45;
        r1 = a.a(r1, 37, 13, 53) + Float.floatToIntBits(getGnssSvCount());
    L45:
        if (hasGnssMeanCn0() == false) goto L48;
        r1 = a.a(r1, 37, 14, 53) + Float.floatToIntBits(getGnssMeanCn0());
    L48:
        if (hasGnssTop4Cn0() == false) goto L51;
        r1 = a.a(r1, 37, 15, 53) + Float.floatToIntBits(getGnssTop4Cn0());
    L51:
        if (hasGnssUsedSvCount() == false) goto L54;
        r1 = a.a(r1, 37, 16, 53) + Float.floatToIntBits(getGnssUsedSvCount());
    L54:
        if (hasGnssUsedFraction() == false) goto L57;
        r1 = a.a(r1, 37, 17, 53) + Float.floatToIntBits(getGnssUsedFraction());
    L57:
        if (hasBleValidUniqueCount() == false) goto L59;
        r1 = a.a(r1, 37, 18, 53) + getBleValidUniqueCount();
    L59:
        int r2 = getUnknownFields().hashCode();
        int r3 = r2 + (r1 * 29);
        this.memoizedHashCode = r3;
        return r3;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageApScanResultRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageApScanResultRequest.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (hasScanId() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasBleStatus() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasBtDensityBucket() == true) goto L21;
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasBtRssiMean() == true) goto L25;
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (hasBtRssiStd() == true) goto L29;
        this.memoizedIsInitialized = 0;
        return false;
    L29:
        if (hasBtStrongM80Fraction() == true) goto L33;
        this.memoizedIsInitialized = 0;
        return false;
    L33:
        if (hasBtHasUuidFraction() == true) goto L37;
        this.memoizedIsInitialized = 0;
        return false;
    L37:
        if (hasBtDevicetype2Fraction() == true) goto L41;
        this.memoizedIsInitialized = 0;
        return false;
    L41:
        if (hasBtDevicetype3Fraction() == true) goto L45;
        this.memoizedIsInitialized = 0;
        return false;
    L45:
        if (hasBtDevclassMajor0Fraction() == true) goto L49;
        this.memoizedIsInitialized = 0;
        return false;
    L49:
        if (hasBtDevclassMajor5Fraction() == true) goto L53;
        this.memoizedIsInitialized = 0;
        return false;
    L53:
        if (hasGnssStatus() == true) goto L57;
        this.memoizedIsInitialized = 0;
        return false;
    L57:
        if (hasGnssSvCount() == true) goto L61;
        this.memoizedIsInitialized = 0;
        return false;
    L61:
        if (hasGnssMeanCn0() == true) goto L65;
        this.memoizedIsInitialized = 0;
        return false;
    L65:
        if (hasGnssTop4Cn0() == true) goto L69;
        this.memoizedIsInitialized = 0;
        return false;
    L69:
        if (hasGnssUsedSvCount() == true) goto L73;
        this.memoizedIsInitialized = 0;
        return false;
    L73:
        if (hasGnssUsedFraction() == true) goto L77;
        this.memoizedIsInitialized = 0;
        return false;
    L77:
        if (hasBleValidUniqueCount() == true) goto L80;
        this.memoizedIsInitialized = 0;
        return false;
    L80:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
        return newBuilderForType((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r2) {
        return new Builder((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r1) {
        return new GarageApScanResultRequest();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r1 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r1);
    L6:
        return new Builder(r1).mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r5) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r5.writeUInt32(1, this.scanId_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r5.writeEnum(2, this.bleStatus_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r5.writeFloat(3, this.btDensityBucket_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r5.writeFloat(4, this.btRssiMean_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r5.writeFloat(5, this.btRssiStd_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r5.writeFloat(6, this.btStrongM80Fraction_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r5.writeFloat(7, this.btHasUuidFraction_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r5.writeFloat(8, this.btDevicetype2Fraction_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r5.writeFloat(9, this.btDevicetype3Fraction_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r5.writeFloat(10, this.btDevclassMajor0Fraction_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r5.writeFloat(11, this.btDevclassMajor5Fraction_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r5.writeEnum(12, this.gnssStatus_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r5.writeFloat(13, this.gnssSvCount_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r5.writeFloat(14, this.gnssMeanCn0_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r5.writeFloat(15, this.gnssTop4Cn0_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r5.writeFloat(16, this.gnssUsedSvCount_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r5.writeFloat(17, this.gnssUsedFraction_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L56;
        r5.writeUInt32(18, this.bleValidUniqueCount_);
    L56:
        getUnknownFields().writeTo(r5);
    }
}
