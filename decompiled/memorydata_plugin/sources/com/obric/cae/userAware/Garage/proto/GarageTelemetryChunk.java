package com.obric.cae.userAware.Garage.proto;

import androidx.core.view.accessibility.AccessibilityEventCompat;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class GarageTelemetryChunk extends GeneratedMessageV3 implements GarageTelemetryChunkOrBuilder {
    public static final int ACCEL_SAMPLE_COUNT_FIELD_NUMBER = 12;
    public static final int CHUNK_COUNT_FIELD_NUMBER = 5;
    public static final int CHUNK_INDEX_FIELD_NUMBER = 4;
    public static final int COMPLETED_SCAN_MASK_FIELD_NUMBER = 22;
    public static final int CRC32_FIELD_NUMBER = 7;
    private static final GarageTelemetryChunk DEFAULT_INSTANCE = null;
    public static final int EVENT_CONFIDENCE_FIELD_NUMBER = 18;
    public static final int EVENT_DIRECTION_FIELD_NUMBER = 17;
    public static final int FEATURE_COUNT_FIELD_NUMBER = 15;
    public static final int GYRO_SAMPLE_COUNT_FIELD_NUMBER = 14;
    public static final int LINACC_SAMPLE_COUNT_FIELD_NUMBER = 13;

    @Deprecated
    public static final Parser<GarageTelemetryChunk> PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 26;
    public static final int PRESSURE_SAMPLE_COUNT_FIELD_NUMBER = 11;
    public static final int QUALITY_FLAGS_FIELD_NUMBER = 10;
    public static final int RECORD_SIZE_FIELD_NUMBER = 16;
    public static final int REQUESTED_SCAN_MASK_FIELD_NUMBER = 21;
    public static final int SCAN_ID_FIELD_NUMBER = 27;
    public static final int SCAN_PURPOSE_FIELD_NUMBER = 19;
    public static final int SCAN_RESULT_FIELD_NUMBER = 20;
    public static final int SCENE_CONFIDENCE_FIELD_NUMBER = 25;
    public static final int SCENE_IS_UG_FIELD_NUMBER = 24;
    public static final int SCENE_VALID_FIELD_NUMBER = 23;
    public static final int SNAPSHOT_ID_FIELD_NUMBER = 3;
    public static final int TOTAL_SIZE_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int WINDOW_END_MS_FIELD_NUMBER = 9;
    public static final int WINDOW_START_MS_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private int accelSampleCount_;
    private int bitField0_;
    private int chunkCount_;
    private int chunkIndex_;
    private int completedScanMask_;
    private int crc32_;
    private float eventConfidence_;
    private int eventDirection_;
    private int featureCount_;
    private int gyroSampleCount_;
    private int linaccSampleCount_;
    private byte memoizedIsInitialized;
    private ByteString payload_;
    private int pressureSampleCount_;
    private int qualityFlags_;
    private int recordSize_;
    private int requestedScanMask_;
    private int scanId_;
    private int scanPurpose_;
    private int scanResult_;
    private float sceneConfidence_;
    private boolean sceneIsUg_;
    private boolean sceneValid_;
    private int snapshotId_;
    private int totalSize_;
    private int type_;
    private int version_;
    private long windowEndMs_;
    private long windowStartMs_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GarageTelemetryChunkOrBuilder {
        private int accelSampleCount_;
        private int bitField0_;
        private int chunkCount_;
        private int chunkIndex_;
        private int completedScanMask_;
        private int crc32_;
        private float eventConfidence_;
        private int eventDirection_;
        private int featureCount_;
        private int gyroSampleCount_;
        private int linaccSampleCount_;
        private ByteString payload_;
        private int pressureSampleCount_;
        private int qualityFlags_;
        private int recordSize_;
        private int requestedScanMask_;
        private int scanId_;
        private int scanPurpose_;
        private int scanResult_;
        private float sceneConfidence_;
        private boolean sceneIsUg_;
        private boolean sceneValid_;
        private int snapshotId_;
        private int totalSize_;
        private int type_;
        private int version_;
        private long windowEndMs_;
        private long windowStartMs_;

        private Builder() {
            this.type_ = 0;
            this.payload_ = ByteString.EMPTY;
        }

        private Builder(GeneratedMessageV3.BuilderParent r3) {
            super((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.type_ = 0;
            this.payload_ = ByteString.EMPTY;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r2, AnonymousClass1 r3) {
            this((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(GarageTelemetryChunk r5) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            GarageTelemetryChunk.access$302(r5, this.version_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L10;
            GarageTelemetryChunk.access$402(r5, this.type_);
            r1 = r1 | 2;
        L10:
            if ((r0 & 4) == 0) goto L13;
            GarageTelemetryChunk.access$502(r5, this.snapshotId_);
            r1 = r1 | 4;
        L13:
            if ((r0 & 8) == 0) goto L16;
            GarageTelemetryChunk.access$602(r5, this.chunkIndex_);
            r1 = r1 | 8;
        L16:
            if ((r0 & 16) == 0) goto L19;
            GarageTelemetryChunk.access$702(r5, this.chunkCount_);
            r1 = r1 | 16;
        L19:
            if ((r0 & 32) == 0) goto L22;
            GarageTelemetryChunk.access$802(r5, this.totalSize_);
            r1 = r1 | 32;
        L22:
            if ((r0 & 64) == 0) goto L25;
            GarageTelemetryChunk.access$902(r5, this.crc32_);
            r1 = r1 | 64;
        L25:
            if ((r0 & 128) == 0) goto L28;
            GarageTelemetryChunk.access$1002(r5, this.windowStartMs_);
            r1 = r1 | 128;
        L28:
            if ((r0 & 256) == 0) goto L31;
            GarageTelemetryChunk.access$1102(r5, this.windowEndMs_);
            r1 = r1 | 256;
        L31:
            if ((r0 & 512) == 0) goto L34;
            GarageTelemetryChunk.access$1202(r5, this.qualityFlags_);
            r1 = r1 | 512;
        L34:
            if ((r0 & 1024) == 0) goto L37;
            GarageTelemetryChunk.access$1302(r5, this.pressureSampleCount_);
            r1 = r1 | 1024;
        L37:
            if ((r0 & 2048) == 0) goto L40;
            GarageTelemetryChunk.access$1402(r5, this.accelSampleCount_);
            r1 = r1 | 2048;
        L40:
            if ((r0 & 4096) == 0) goto L43;
            GarageTelemetryChunk.access$1502(r5, this.linaccSampleCount_);
            r1 = r1 | 4096;
        L43:
            if ((r0 & 8192) == 0) goto L46;
            GarageTelemetryChunk.access$1602(r5, this.gyroSampleCount_);
            r1 = r1 | 8192;
        L46:
            if ((r0 & 16384) == 0) goto L49;
            GarageTelemetryChunk.access$1702(r5, this.featureCount_);
            r1 = r1 | 16384;
        L49:
            if ((r0 & 32768) == 0) goto L52;
            GarageTelemetryChunk.access$1802(r5, this.recordSize_);
            r1 = r1 | 32768;
        L52:
            if ((r0 & 65536) == 0) goto L55;
            GarageTelemetryChunk.access$1902(r5, this.eventDirection_);
            r1 = r1 | 65536;
        L55:
            if ((r0 & 131072) == 0) goto L58;
            GarageTelemetryChunk.access$2002(r5, this.eventConfidence_);
            r1 = r1 | 131072;
        L58:
            if ((r0 & 262144) == 0) goto L61;
            GarageTelemetryChunk.access$2102(r5, this.scanPurpose_);
            r1 = r1 | 262144;
        L61:
            if ((r0 & 524288) == 0) goto L64;
            GarageTelemetryChunk.access$2202(r5, this.scanResult_);
            r1 = r1 | 524288;
        L64:
            if ((r0 & 1048576) == 0) goto L67;
            GarageTelemetryChunk.access$2302(r5, this.requestedScanMask_);
            r1 = r1 | 1048576;
        L67:
            if ((r0 & 2097152) == 0) goto L70;
            GarageTelemetryChunk.access$2402(r5, this.completedScanMask_);
            r1 = r1 | 2097152;
        L70:
            if ((4194304 & r0) == 0) goto L73;
            GarageTelemetryChunk.access$2502(r5, this.sceneValid_);
            r1 = r1 | 4194304;
        L73:
            if ((8388608 & r0) == 0) goto L76;
            GarageTelemetryChunk.access$2602(r5, this.sceneIsUg_);
            r1 = r1 | 8388608;
        L76:
            if ((16777216 & r0) == 0) goto L79;
            GarageTelemetryChunk.access$2702(r5, this.sceneConfidence_);
            r1 = r1 | 16777216;
        L79:
            if ((33554432 & r0) == 0) goto L82;
            GarageTelemetryChunk.access$2802(r5, this.payload_);
            r1 = r1 | 33554432;
        L82:
            if ((r0 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L84;
            GarageTelemetryChunk.access$2902(r5, this.scanId_);
            r1 = r1 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        L84:
            GarageTelemetryChunk.access$3076(r5, r1);
            return;
        L5:
            r1 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_descriptor;
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
        public GarageTelemetryChunk build() {
            GarageTelemetryChunk r1 = buildPartial();
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
        public GarageTelemetryChunk buildPartial() {
            GarageTelemetryChunk r0 = new GarageTelemetryChunk(this, null);
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
            this.version_ = 0;
            this.type_ = 0;
            this.snapshotId_ = 0;
            this.chunkIndex_ = 0;
            this.chunkCount_ = 0;
            this.totalSize_ = 0;
            this.crc32_ = 0;
            this.windowStartMs_ = 0;
            this.windowEndMs_ = 0;
            this.qualityFlags_ = 0;
            this.pressureSampleCount_ = 0;
            this.accelSampleCount_ = 0;
            this.linaccSampleCount_ = 0;
            this.gyroSampleCount_ = 0;
            this.featureCount_ = 0;
            this.recordSize_ = 0;
            this.eventDirection_ = 0;
            this.eventConfidence_ = 0.0f;
            this.scanPurpose_ = 0;
            this.scanResult_ = 0;
            this.requestedScanMask_ = 0;
            this.completedScanMask_ = 0;
            this.sceneValid_ = false;
            this.sceneIsUg_ = false;
            this.sceneConfidence_ = 0.0f;
            this.payload_ = ByteString.EMPTY;
            this.scanId_ = 0;
            return this;
        }

        public Builder clearAccelSampleCount() {
            this.bitField0_ &= -2049;
            this.accelSampleCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChunkCount() {
            this.bitField0_ &= -17;
            this.chunkCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChunkIndex() {
            this.bitField0_ &= -9;
            this.chunkIndex_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCompletedScanMask() {
            this.bitField0_ &= -2097153;
            this.completedScanMask_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCrc32() {
            this.bitField0_ &= -65;
            this.crc32_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventConfidence() {
            this.bitField0_ &= -131073;
            this.eventConfidence_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearEventDirection() {
            this.bitField0_ &= -65537;
            this.eventDirection_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFeatureCount() {
            this.bitField0_ &= -16385;
            this.featureCount_ = 0;
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

        public Builder clearGyroSampleCount() {
            this.bitField0_ &= -8193;
            this.gyroSampleCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLinaccSampleCount() {
            this.bitField0_ &= -4097;
            this.linaccSampleCount_ = 0;
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

        public Builder clearPayload() {
            this.bitField0_ &= -33554433;
            this.payload_ = GarageTelemetryChunk.getDefaultInstance().getPayload();
            onChanged();
            return this;
        }

        public Builder clearPressureSampleCount() {
            this.bitField0_ &= -1025;
            this.pressureSampleCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearQualityFlags() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.qualityFlags_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRecordSize() {
            this.bitField0_ &= -32769;
            this.recordSize_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRequestedScanMask() {
            this.bitField0_ &= -1048577;
            this.requestedScanMask_ = 0;
            onChanged();
            return this;
        }

        public Builder clearScanId() {
            this.bitField0_ &= -67108865;
            this.scanId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearScanPurpose() {
            this.bitField0_ &= -262145;
            this.scanPurpose_ = 0;
            onChanged();
            return this;
        }

        public Builder clearScanResult() {
            this.bitField0_ &= -524289;
            this.scanResult_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSceneConfidence() {
            this.bitField0_ &= -16777217;
            this.sceneConfidence_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearSceneIsUg() {
            this.bitField0_ &= -8388609;
            this.sceneIsUg_ = false;
            onChanged();
            return this;
        }

        public Builder clearSceneValid() {
            this.bitField0_ &= -4194305;
            this.sceneValid_ = false;
            onChanged();
            return this;
        }

        public Builder clearSnapshotId() {
            this.bitField0_ &= -5;
            this.snapshotId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalSize() {
            this.bitField0_ &= -33;
            this.totalSize_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.bitField0_ &= -3;
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.bitField0_ &= -2;
            this.version_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWindowEndMs() {
            this.bitField0_ &= -257;
            this.windowEndMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWindowStartMs() {
            this.bitField0_ &= -129;
            this.windowStartMs_ = 0;
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

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getAccelSampleCount() {
            return this.accelSampleCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getChunkCount() {
            return this.chunkCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getChunkIndex() {
            return this.chunkIndex_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getCompletedScanMask() {
            return this.completedScanMask_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getCrc32() {
            return this.crc32_;
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
        public GarageTelemetryChunk getDefaultInstanceForType() {
            return GarageTelemetryChunk.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_descriptor;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public float getEventConfidence() {
            return this.eventConfidence_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getEventDirection() {
            return this.eventDirection_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getFeatureCount() {
            return this.featureCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getGyroSampleCount() {
            return this.gyroSampleCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getLinaccSampleCount() {
            return this.linaccSampleCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public ByteString getPayload() {
            return this.payload_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getPressureSampleCount() {
            return this.pressureSampleCount_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getQualityFlags() {
            return this.qualityFlags_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getRecordSize() {
            return this.recordSize_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getRequestedScanMask() {
            return this.requestedScanMask_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getScanId() {
            return this.scanId_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getScanPurpose() {
            return this.scanPurpose_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getScanResult() {
            return this.scanResult_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public float getSceneConfidence() {
            return this.sceneConfidence_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean getSceneIsUg() {
            return this.sceneIsUg_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean getSceneValid() {
            return this.sceneValid_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getSnapshotId() {
            return this.snapshotId_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getTotalSize() {
            return this.totalSize_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public GarageTelemetryType getType() {
            GarageTelemetryType r0 = GarageTelemetryType.forNumber(this.type_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return GarageTelemetryType.GARAGE_TELEMETRY_TYPE_UNKNOWN;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public long getWindowEndMs() {
            return this.windowEndMs_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public long getWindowStartMs() {
            return this.windowStartMs_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasAccelSampleCount() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasChunkCount() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasChunkIndex() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasCompletedScanMask() {
            if ((this.bitField0_ & 2097152) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasCrc32() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasEventConfidence() {
            if ((this.bitField0_ & 131072) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasEventDirection() {
            if ((this.bitField0_ & 65536) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasFeatureCount() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasGyroSampleCount() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasLinaccSampleCount() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasPayload() {
            if ((this.bitField0_ & 33554432) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasPressureSampleCount() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasQualityFlags() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasRecordSize() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasRequestedScanMask() {
            if ((this.bitField0_ & 1048576) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasScanId() {
            if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasScanPurpose() {
            if ((this.bitField0_ & 262144) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasScanResult() {
            if ((this.bitField0_ & 524288) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasSceneConfidence() {
            if ((this.bitField0_ & 16777216) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasSceneIsUg() {
            if ((this.bitField0_ & 8388608) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasSceneValid() {
            if ((this.bitField0_ & 4194304) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasSnapshotId() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasTotalSize() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasVersion() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasWindowEndMs() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
        public boolean hasWindowStartMs() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageTelemetryChunk.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasVersion() == true) goto L6;
            return false;
        L6:
            if (hasType() == true) goto L9;
            return false;
        L9:
            if (hasSnapshotId() == true) goto L12;
            return false;
        L12:
            if (hasChunkIndex() == true) goto L15;
            return false;
        L15:
            if (hasChunkCount() == true) goto L18;
            return false;
        L18:
            if (hasTotalSize() == true) goto L21;
            return false;
        L21:
            if (hasCrc32() == true) goto L24;
            return false;
        L24:
            if (hasWindowStartMs() == true) goto L27;
            return false;
        L27:
            if (hasWindowEndMs() == true) goto L30;
            return false;
        L30:
            if (hasQualityFlags() == true) goto L33;
            return false;
        L33:
            if (hasPressureSampleCount() == true) goto L36;
            return false;
        L36:
            if (hasAccelSampleCount() == true) goto L39;
            return false;
        L39:
            if (hasLinaccSampleCount() == true) goto L42;
            return false;
        L42:
            if (hasGyroSampleCount() == true) goto L45;
            return false;
        L45:
            if (hasFeatureCount() == true) goto L48;
            return false;
        L48:
            if (hasRecordSize() == true) goto L51;
            return false;
        L51:
            if (hasPayload() == true) goto L53;
            return false;
        L53:
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
            if (r0 == true) goto L48;
            int r2 = r6.readTag();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            switch(r2) {
                case 0: goto L40;
                case 8: goto L37;
                case 16: goto L33;
                case 24: goto L32;
                case 32: goto L31;
                case 40: goto L30;
                case 48: goto L29;
                case 61: goto L28;
                case 64: goto L27;
                case 72: goto L26;
                case 80: goto L25;
                case 88: goto L24;
                case 96: goto L23;
                case 104: goto L22;
                case 112: goto L21;
                case 120: goto L20;
                case 128: goto L19;
                case 136: goto L18;
                case 149: goto L17;
                case 152: goto L16;
                case 160: goto L15;
                case 168: goto L14;
                case 176: goto L13;
                case 184: goto L12;
                case 192: goto L11;
                case 205: goto L10;
                case 210: goto L9;
                case 216: goto L7;
                default: goto L39;
            };     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
        L7:
            this.scanId_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            int r3 = this.bitField0_ | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
        L8:
            this.bitField0_ = r3;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L9:
            this.payload_ = r6.readBytes();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 33554432;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L10:
            this.sceneConfidence_ = r6.readFloat();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 16777216;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L11:
            this.sceneIsUg_ = r6.readBool();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 8388608;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L12:
            this.sceneValid_ = r6.readBool();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 4194304;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L13:
            this.completedScanMask_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 2097152;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L14:
            this.requestedScanMask_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 1048576;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L15:
            this.scanResult_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 524288;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L16:
            this.scanPurpose_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 262144;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L17:
            this.eventConfidence_ = r6.readFloat();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 131072;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L18:
            this.eventDirection_ = r6.readSInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 65536;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L19:
            this.recordSize_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 32768;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L20:
            this.featureCount_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 16384;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L21:
            this.gyroSampleCount_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 8192;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L22:
            this.linaccSampleCount_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 4096;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L23:
            this.accelSampleCount_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 2048;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L24:
            this.pressureSampleCount_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 1024;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L25:
            this.qualityFlags_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 512;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L26:
            this.windowEndMs_ = r6.readUInt64();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 256;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L27:
            this.windowStartMs_ = r6.readUInt64();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 128;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L28:
            this.crc32_ = r6.readFixed32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 64;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L29:
            this.totalSize_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 32;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L30:
            this.chunkCount_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 16;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L31:
            this.chunkIndex_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 8;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L32:
            this.snapshotId_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 4;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L33:
            int r4 = r6.readEnum();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            if (GarageTelemetryType.forNumber(r4) != null) goto L36;
            mergeUnknownVarintField(2, r4);     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L36:
            this.type_ = r4;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 2;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L8
        L37:
            this.version_ = r6.readUInt32();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.bitField0_ | 1;
        L40:
            r0 = true;
            goto L3
        L39:
            if (parseUnknownField(r6, r7, r2) == true) goto L3;
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
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, GarageTelemetryChunk.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(r4, GarageTelemetryChunk.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(GarageTelemetryChunk r3) {
            if (r3 != GarageTelemetryChunk.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r3.hasVersion() == false) goto L9;
            setVersion(r3.getVersion());
        L9:
            if (r3.hasType() == false) goto L12;
            setType(r3.getType());
        L12:
            if (r3.hasSnapshotId() == false) goto L15;
            setSnapshotId(r3.getSnapshotId());
        L15:
            if (r3.hasChunkIndex() == false) goto L18;
            setChunkIndex(r3.getChunkIndex());
        L18:
            if (r3.hasChunkCount() == false) goto L21;
            setChunkCount(r3.getChunkCount());
        L21:
            if (r3.hasTotalSize() == false) goto L24;
            setTotalSize(r3.getTotalSize());
        L24:
            if (r3.hasCrc32() == false) goto L27;
            setCrc32(r3.getCrc32());
        L27:
            if (r3.hasWindowStartMs() == false) goto L30;
            setWindowStartMs(r3.getWindowStartMs());
        L30:
            if (r3.hasWindowEndMs() == false) goto L33;
            setWindowEndMs(r3.getWindowEndMs());
        L33:
            if (r3.hasQualityFlags() == false) goto L36;
            setQualityFlags(r3.getQualityFlags());
        L36:
            if (r3.hasPressureSampleCount() == false) goto L39;
            setPressureSampleCount(r3.getPressureSampleCount());
        L39:
            if (r3.hasAccelSampleCount() == false) goto L42;
            setAccelSampleCount(r3.getAccelSampleCount());
        L42:
            if (r3.hasLinaccSampleCount() == false) goto L45;
            setLinaccSampleCount(r3.getLinaccSampleCount());
        L45:
            if (r3.hasGyroSampleCount() == false) goto L48;
            setGyroSampleCount(r3.getGyroSampleCount());
        L48:
            if (r3.hasFeatureCount() == false) goto L51;
            setFeatureCount(r3.getFeatureCount());
        L51:
            if (r3.hasRecordSize() == false) goto L54;
            setRecordSize(r3.getRecordSize());
        L54:
            if (r3.hasEventDirection() == false) goto L57;
            setEventDirection(r3.getEventDirection());
        L57:
            if (r3.hasEventConfidence() == false) goto L60;
            setEventConfidence(r3.getEventConfidence());
        L60:
            if (r3.hasScanPurpose() == false) goto L63;
            setScanPurpose(r3.getScanPurpose());
        L63:
            if (r3.hasScanResult() == false) goto L66;
            setScanResult(r3.getScanResult());
        L66:
            if (r3.hasRequestedScanMask() == false) goto L69;
            setRequestedScanMask(r3.getRequestedScanMask());
        L69:
            if (r3.hasCompletedScanMask() == false) goto L72;
            setCompletedScanMask(r3.getCompletedScanMask());
        L72:
            if (r3.hasSceneValid() == false) goto L75;
            setSceneValid(r3.getSceneValid());
        L75:
            if (r3.hasSceneIsUg() == false) goto L78;
            setSceneIsUg(r3.getSceneIsUg());
        L78:
            if (r3.hasSceneConfidence() == false) goto L81;
            setSceneConfidence(r3.getSceneConfidence());
        L81:
            if (r3.hasPayload() == false) goto L84;
            setPayload(r3.getPayload());
        L84:
            if (r3.hasScanId() == false) goto L86;
            setScanId(r3.getScanId());
        L86:
            mergeUnknownFields(r3.getUnknownFields());
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

        public Builder setAccelSampleCount(int r1) {
            this.accelSampleCount_ = r1;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setChunkCount(int r1) {
            this.chunkCount_ = r1;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setChunkIndex(int r1) {
            this.chunkIndex_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setCompletedScanMask(int r2) {
            this.completedScanMask_ = r2;
            this.bitField0_ |= 2097152;
            onChanged();
            return this;
        }

        public Builder setCrc32(int r1) {
            this.crc32_ = r1;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setEventConfidence(float r2) {
            this.eventConfidence_ = r2;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder setEventDirection(int r2) {
            this.eventDirection_ = r2;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setFeatureCount(int r1) {
            this.featureCount_ = r1;
            this.bitField0_ |= 16384;
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

        public Builder setGyroSampleCount(int r1) {
            this.gyroSampleCount_ = r1;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setLinaccSampleCount(int r1) {
            this.linaccSampleCount_ = r1;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setPayload(ByteString r2) {
            Objects.requireNonNull(r2);
            this.payload_ = r2;
            this.bitField0_ |= 33554432;
            onChanged();
            return this;
        }

        public Builder setPressureSampleCount(int r1) {
            this.pressureSampleCount_ = r1;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setQualityFlags(int r1) {
            this.qualityFlags_ = r1;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setRecordSize(int r2) {
            this.recordSize_ = r2;
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

        public Builder setRequestedScanMask(int r2) {
            this.requestedScanMask_ = r2;
            this.bitField0_ |= 1048576;
            onChanged();
            return this;
        }

        public Builder setScanId(int r2) {
            this.scanId_ = r2;
            this.bitField0_ |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            onChanged();
            return this;
        }

        public Builder setScanPurpose(int r2) {
            this.scanPurpose_ = r2;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder setScanResult(int r2) {
            this.scanResult_ = r2;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder setSceneConfidence(float r2) {
            this.sceneConfidence_ = r2;
            this.bitField0_ |= 16777216;
            onChanged();
            return this;
        }

        public Builder setSceneIsUg(boolean r2) {
            this.sceneIsUg_ = r2;
            this.bitField0_ |= 8388608;
            onChanged();
            return this;
        }

        public Builder setSceneValid(boolean r2) {
            this.sceneValid_ = r2;
            this.bitField0_ |= 4194304;
            onChanged();
            return this;
        }

        public Builder setSnapshotId(int r1) {
            this.snapshotId_ = r1;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setTotalSize(int r1) {
            this.totalSize_ = r1;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setType(GarageTelemetryType r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 2;
            this.type_ = r2.getNumber();
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

        public Builder setVersion(int r1) {
            this.version_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setWindowEndMs(long r1) {
            this.windowEndMs_ = r1;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setWindowStartMs(long r1) {
            this.windowStartMs_ = r1;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new GarageTelemetryChunk();
        PARSER = new AnonymousClass1();
    }

    private GarageTelemetryChunk() {
        this.version_ = 0;
        this.type_ = 0;
        this.snapshotId_ = 0;
        this.chunkIndex_ = 0;
        this.chunkCount_ = 0;
        this.totalSize_ = 0;
        this.crc32_ = 0;
        this.windowStartMs_ = 0;
        this.windowEndMs_ = 0;
        this.qualityFlags_ = 0;
        this.pressureSampleCount_ = 0;
        this.accelSampleCount_ = 0;
        this.linaccSampleCount_ = 0;
        this.gyroSampleCount_ = 0;
        this.featureCount_ = 0;
        this.recordSize_ = 0;
        this.eventDirection_ = 0;
        this.eventConfidence_ = 0.0f;
        this.scanPurpose_ = 0;
        this.scanResult_ = 0;
        this.requestedScanMask_ = 0;
        this.completedScanMask_ = 0;
        this.sceneValid_ = false;
        this.sceneIsUg_ = false;
        this.sceneConfidence_ = 0.0f;
        ByteString r1 = ByteString.EMPTY;
        this.scanId_ = 0;
        this.memoizedIsInitialized = -1;
        this.type_ = 0;
        this.payload_ = r1;
    }

    private GarageTelemetryChunk(GeneratedMessageV3.Builder<?> r3) {
        super(r3);
        this.version_ = 0;
        this.type_ = 0;
        this.snapshotId_ = 0;
        this.chunkIndex_ = 0;
        this.chunkCount_ = 0;
        this.totalSize_ = 0;
        this.crc32_ = 0;
        this.windowStartMs_ = 0;
        this.windowEndMs_ = 0;
        this.qualityFlags_ = 0;
        this.pressureSampleCount_ = 0;
        this.accelSampleCount_ = 0;
        this.linaccSampleCount_ = 0;
        this.gyroSampleCount_ = 0;
        this.featureCount_ = 0;
        this.recordSize_ = 0;
        this.eventDirection_ = 0;
        this.eventConfidence_ = 0.0f;
        this.scanPurpose_ = 0;
        this.scanResult_ = 0;
        this.requestedScanMask_ = 0;
        this.completedScanMask_ = 0;
        this.sceneValid_ = false;
        this.sceneIsUg_ = false;
        this.sceneConfidence_ = 0.0f;
        this.payload_ = ByteString.EMPTY;
        this.scanId_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ GarageTelemetryChunk(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ long access$1002(GarageTelemetryChunk r0, long r1) {
        r0.windowStartMs_ = r1;
        return r1;
    }

    public static /* synthetic */ long access$1102(GarageTelemetryChunk r0, long r1) {
        r0.windowEndMs_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1202(GarageTelemetryChunk r0, int r1) {
        r0.qualityFlags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1302(GarageTelemetryChunk r0, int r1) {
        r0.pressureSampleCount_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1402(GarageTelemetryChunk r0, int r1) {
        r0.accelSampleCount_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1502(GarageTelemetryChunk r0, int r1) {
        r0.linaccSampleCount_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1602(GarageTelemetryChunk r0, int r1) {
        r0.gyroSampleCount_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1702(GarageTelemetryChunk r0, int r1) {
        r0.featureCount_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1802(GarageTelemetryChunk r0, int r1) {
        r0.recordSize_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1902(GarageTelemetryChunk r0, int r1) {
        r0.eventDirection_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$2002(GarageTelemetryChunk r0, float r1) {
        r0.eventConfidence_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$2102(GarageTelemetryChunk r0, int r1) {
        r0.scanPurpose_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$2202(GarageTelemetryChunk r0, int r1) {
        r0.scanResult_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$2302(GarageTelemetryChunk r0, int r1) {
        r0.requestedScanMask_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$2402(GarageTelemetryChunk r0, int r1) {
        r0.completedScanMask_ = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2502(GarageTelemetryChunk r0, boolean r1) {
        r0.sceneValid_ = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2602(GarageTelemetryChunk r0, boolean r1) {
        r0.sceneIsUg_ = r1;
        return r1;
    }

    public static /* synthetic */ float access$2702(GarageTelemetryChunk r0, float r1) {
        r0.sceneConfidence_ = r1;
        return r1;
    }

    public static /* synthetic */ ByteString access$2802(GarageTelemetryChunk r0, ByteString r1) {
        r0.payload_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$2902(GarageTelemetryChunk r0, int r1) {
        r0.scanId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$302(GarageTelemetryChunk r0, int r1) {
        r0.version_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$3076(GarageTelemetryChunk r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    public static /* synthetic */ int access$402(GarageTelemetryChunk r0, int r1) {
        r0.type_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$502(GarageTelemetryChunk r0, int r1) {
        r0.snapshotId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(GarageTelemetryChunk r0, int r1) {
        r0.chunkIndex_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$702(GarageTelemetryChunk r0, int r1) {
        r0.chunkCount_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$802(GarageTelemetryChunk r0, int r1) {
        r0.totalSize_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$902(GarageTelemetryChunk r0, int r1) {
        r0.crc32_ = r1;
        return r1;
    }

    public static GarageTelemetryChunk getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GarageTelemetryChunk r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static GarageTelemetryChunk parseDelimitedFrom(InputStream r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(ByteString r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(CodedInputStream r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(InputStream r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(ByteBuffer r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(byte[] r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static GarageTelemetryChunk parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
    }

    public static Parser<GarageTelemetryChunk> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, GarageTelemetryChunk.class) == false) goto L8;
        GarageTelemetryChunk r10 = (GarageTelemetryChunk) ZeusTransformUtils.preCheckCast(r9, GarageTelemetryChunk.class, "com.obric.memorydata.plugin");
        if (hasVersion() == r10.hasVersion()) goto L13;
        return false;
    L13:
        if (hasVersion() == false) goto L18;
        if (getVersion() == r10.getVersion()) goto L18;
        return false;
    L18:
        if (hasType() == r10.hasType()) goto L21;
        return false;
    L21:
        if (hasType() == false) goto L26;
        if (this.type_ == r10.type_) goto L26;
        return false;
    L26:
        if (hasSnapshotId() == r10.hasSnapshotId()) goto L29;
        return false;
    L29:
        if (hasSnapshotId() == false) goto L34;
        if (getSnapshotId() == r10.getSnapshotId()) goto L34;
        return false;
    L34:
        if (hasChunkIndex() == r10.hasChunkIndex()) goto L37;
        return false;
    L37:
        if (hasChunkIndex() == false) goto L42;
        if (getChunkIndex() == r10.getChunkIndex()) goto L42;
        return false;
    L42:
        if (hasChunkCount() == r10.hasChunkCount()) goto L45;
        return false;
    L45:
        if (hasChunkCount() == false) goto L50;
        if (getChunkCount() == r10.getChunkCount()) goto L50;
        return false;
    L50:
        if (hasTotalSize() == r10.hasTotalSize()) goto L53;
        return false;
    L53:
        if (hasTotalSize() == false) goto L58;
        if (getTotalSize() == r10.getTotalSize()) goto L58;
        return false;
    L58:
        if (hasCrc32() == r10.hasCrc32()) goto L61;
        return false;
    L61:
        if (hasCrc32() == false) goto L66;
        if (getCrc32() == r10.getCrc32()) goto L66;
        return false;
    L66:
        if (hasWindowStartMs() == r10.hasWindowStartMs()) goto L69;
        return false;
    L69:
        if (hasWindowStartMs() == false) goto L74;
        if (getWindowStartMs() == r10.getWindowStartMs()) goto L74;
        return false;
    L74:
        if (hasWindowEndMs() == r10.hasWindowEndMs()) goto L77;
        return false;
    L77:
        if (hasWindowEndMs() == false) goto L82;
        if (getWindowEndMs() == r10.getWindowEndMs()) goto L82;
        return false;
    L82:
        if (hasQualityFlags() == r10.hasQualityFlags()) goto L85;
        return false;
    L85:
        if (hasQualityFlags() == false) goto L90;
        if (getQualityFlags() == r10.getQualityFlags()) goto L90;
        return false;
    L90:
        if (hasPressureSampleCount() == r10.hasPressureSampleCount()) goto L93;
        return false;
    L93:
        if (hasPressureSampleCount() == false) goto L98;
        if (getPressureSampleCount() == r10.getPressureSampleCount()) goto L98;
        return false;
    L98:
        if (hasAccelSampleCount() == r10.hasAccelSampleCount()) goto L101;
        return false;
    L101:
        if (hasAccelSampleCount() == false) goto L106;
        if (getAccelSampleCount() == r10.getAccelSampleCount()) goto L106;
        return false;
    L106:
        if (hasLinaccSampleCount() == r10.hasLinaccSampleCount()) goto L109;
        return false;
    L109:
        if (hasLinaccSampleCount() == false) goto L114;
        if (getLinaccSampleCount() == r10.getLinaccSampleCount()) goto L114;
        return false;
    L114:
        if (hasGyroSampleCount() == r10.hasGyroSampleCount()) goto L117;
        return false;
    L117:
        if (hasGyroSampleCount() == false) goto L122;
        if (getGyroSampleCount() == r10.getGyroSampleCount()) goto L122;
        return false;
    L122:
        if (hasFeatureCount() == r10.hasFeatureCount()) goto L125;
        return false;
    L125:
        if (hasFeatureCount() == false) goto L130;
        if (getFeatureCount() == r10.getFeatureCount()) goto L130;
        return false;
    L130:
        if (hasRecordSize() == r10.hasRecordSize()) goto L133;
        return false;
    L133:
        if (hasRecordSize() == false) goto L138;
        if (getRecordSize() == r10.getRecordSize()) goto L138;
        return false;
    L138:
        if (hasEventDirection() == r10.hasEventDirection()) goto L141;
        return false;
    L141:
        if (hasEventDirection() == false) goto L146;
        if (getEventDirection() == r10.getEventDirection()) goto L146;
        return false;
    L146:
        if (hasEventConfidence() == r10.hasEventConfidence()) goto L149;
        return false;
    L149:
        if (hasEventConfidence() == false) goto L154;
        if (Float.floatToIntBits(getEventConfidence()) == Float.floatToIntBits(r10.getEventConfidence())) goto L154;
        return false;
    L154:
        if (hasScanPurpose() == r10.hasScanPurpose()) goto L157;
        return false;
    L157:
        if (hasScanPurpose() == false) goto L162;
        if (getScanPurpose() == r10.getScanPurpose()) goto L162;
        return false;
    L162:
        if (hasScanResult() == r10.hasScanResult()) goto L165;
        return false;
    L165:
        if (hasScanResult() == false) goto L170;
        if (getScanResult() == r10.getScanResult()) goto L170;
        return false;
    L170:
        if (hasRequestedScanMask() == r10.hasRequestedScanMask()) goto L173;
        return false;
    L173:
        if (hasRequestedScanMask() == false) goto L178;
        if (getRequestedScanMask() == r10.getRequestedScanMask()) goto L178;
        return false;
    L178:
        if (hasCompletedScanMask() == r10.hasCompletedScanMask()) goto L181;
        return false;
    L181:
        if (hasCompletedScanMask() == false) goto L186;
        if (getCompletedScanMask() == r10.getCompletedScanMask()) goto L186;
        return false;
    L186:
        if (hasSceneValid() == r10.hasSceneValid()) goto L189;
        return false;
    L189:
        if (hasSceneValid() == false) goto L194;
        if (getSceneValid() == r10.getSceneValid()) goto L194;
        return false;
    L194:
        if (hasSceneIsUg() == r10.hasSceneIsUg()) goto L197;
        return false;
    L197:
        if (hasSceneIsUg() == false) goto L202;
        if (getSceneIsUg() == r10.getSceneIsUg()) goto L202;
        return false;
    L202:
        if (hasSceneConfidence() == r10.hasSceneConfidence()) goto L205;
        return false;
    L205:
        if (hasSceneConfidence() == false) goto L210;
        if (Float.floatToIntBits(getSceneConfidence()) == Float.floatToIntBits(r10.getSceneConfidence())) goto L210;
        return false;
    L210:
        if (hasPayload() == r10.hasPayload()) goto L213;
        return false;
    L213:
        if (hasPayload() == false) goto L218;
        if (getPayload().equals(r10.getPayload()) == true) goto L218;
        return false;
    L218:
        if (hasScanId() == r10.hasScanId()) goto L221;
        return false;
    L221:
        if (hasScanId() == false) goto L226;
        if (getScanId() == r10.getScanId()) goto L226;
        return false;
    L226:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L228;
        return false;
    L228:
        return true;
    L8:
        return super.equals(r9);
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getAccelSampleCount() {
        return this.accelSampleCount_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getChunkCount() {
        return this.chunkCount_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getChunkIndex() {
        return this.chunkIndex_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getCompletedScanMask() {
        return this.completedScanMask_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getCrc32() {
        return this.crc32_;
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
    public GarageTelemetryChunk getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public float getEventConfidence() {
        return this.eventConfidence_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getEventDirection() {
        return this.eventDirection_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getFeatureCount() {
        return this.featureCount_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getGyroSampleCount() {
        return this.gyroSampleCount_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getLinaccSampleCount() {
        return this.linaccSampleCount_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GarageTelemetryChunk> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public ByteString getPayload() {
        return this.payload_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getPressureSampleCount() {
        return this.pressureSampleCount_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getQualityFlags() {
        return this.qualityFlags_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getRecordSize() {
        return this.recordSize_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getRequestedScanMask() {
        return this.requestedScanMask_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getScanId() {
        return this.scanId_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getScanPurpose() {
        return this.scanPurpose_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getScanResult() {
        return this.scanResult_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public float getSceneConfidence() {
        return this.sceneConfidence_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean getSceneIsUg() {
        return this.sceneIsUg_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean getSceneValid() {
        return this.sceneValid_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r1 = 0 + CodedOutputStream.computeUInt32Size(1, this.version_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r1 = r1 + CodedOutputStream.computeEnumSize(2, this.type_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r1 = r1 + CodedOutputStream.computeUInt32Size(3, this.snapshotId_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r1 = r1 + CodedOutputStream.computeUInt32Size(4, this.chunkIndex_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r1 = r1 + CodedOutputStream.computeUInt32Size(5, this.chunkCount_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r1 = r1 + CodedOutputStream.computeUInt32Size(6, this.totalSize_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r1 = r1 + CodedOutputStream.computeFixed32Size(7, this.crc32_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r1 = r1 + CodedOutputStream.computeUInt64Size(8, this.windowStartMs_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r1 = r1 + CodedOutputStream.computeUInt64Size(9, this.windowEndMs_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r1 = r1 + CodedOutputStream.computeUInt32Size(10, this.qualityFlags_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r1 = r1 + CodedOutputStream.computeUInt32Size(11, this.pressureSampleCount_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r1 = r1 + CodedOutputStream.computeUInt32Size(12, this.accelSampleCount_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r1 = r1 + CodedOutputStream.computeUInt32Size(13, this.linaccSampleCount_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r1 = r1 + CodedOutputStream.computeUInt32Size(14, this.gyroSampleCount_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r1 = r1 + CodedOutputStream.computeUInt32Size(15, this.featureCount_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L54;
        r1 = r1 + CodedOutputStream.computeUInt32Size(16, this.recordSize_);
    L54:
        if ((this.bitField0_ & 65536) == 0) goto L57;
        r1 = r1 + CodedOutputStream.computeSInt32Size(17, this.eventDirection_);
    L57:
        if ((this.bitField0_ & 131072) == 0) goto L60;
        r1 = r1 + CodedOutputStream.computeFloatSize(18, this.eventConfidence_);
    L60:
        if ((this.bitField0_ & 262144) == 0) goto L63;
        r1 = r1 + CodedOutputStream.computeUInt32Size(19, this.scanPurpose_);
    L63:
        if ((this.bitField0_ & 524288) == 0) goto L66;
        r1 = r1 + CodedOutputStream.computeUInt32Size(20, this.scanResult_);
    L66:
        if ((this.bitField0_ & 1048576) == 0) goto L69;
        r1 = r1 + CodedOutputStream.computeUInt32Size(21, this.requestedScanMask_);
    L69:
        if ((this.bitField0_ & 2097152) == 0) goto L72;
        r1 = r1 + CodedOutputStream.computeUInt32Size(22, this.completedScanMask_);
    L72:
        if ((this.bitField0_ & 4194304) == 0) goto L75;
        r1 = r1 + CodedOutputStream.computeBoolSize(23, this.sceneValid_);
    L75:
        if ((this.bitField0_ & 8388608) == 0) goto L78;
        r1 = r1 + CodedOutputStream.computeBoolSize(24, this.sceneIsUg_);
    L78:
        if ((this.bitField0_ & 16777216) == 0) goto L81;
        r1 = r1 + CodedOutputStream.computeFloatSize(25, this.sceneConfidence_);
    L81:
        if ((this.bitField0_ & 33554432) == 0) goto L84;
        r1 = r1 + CodedOutputStream.computeBytesSize(26, this.payload_);
    L84:
        if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L86;
        r1 = r1 + CodedOutputStream.computeUInt32Size(27, this.scanId_);
    L86:
        int r2 = getUnknownFields().getSerializedSize() + r1;
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getSnapshotId() {
        return this.snapshotId_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getTotalSize() {
        return this.totalSize_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public GarageTelemetryType getType() {
        GarageTelemetryType r0 = GarageTelemetryType.forNumber(this.type_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return GarageTelemetryType.GARAGE_TELEMETRY_TYPE_UNKNOWN;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public long getWindowEndMs() {
        return this.windowEndMs_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public long getWindowStartMs() {
        return this.windowStartMs_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasAccelSampleCount() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasChunkCount() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasChunkIndex() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasCompletedScanMask() {
        if ((this.bitField0_ & 2097152) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasCrc32() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasEventConfidence() {
        if ((this.bitField0_ & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasEventDirection() {
        if ((this.bitField0_ & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasFeatureCount() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasGyroSampleCount() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasLinaccSampleCount() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasPayload() {
        if ((this.bitField0_ & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasPressureSampleCount() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasQualityFlags() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasRecordSize() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasRequestedScanMask() {
        if ((this.bitField0_ & 1048576) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasScanId() {
        if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasScanPurpose() {
        if ((this.bitField0_ & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasScanResult() {
        if ((this.bitField0_ & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasSceneConfidence() {
        if ((this.bitField0_ & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasSceneIsUg() {
        if ((this.bitField0_ & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasSceneValid() {
        if ((this.bitField0_ & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasSnapshotId() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasTotalSize() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasType() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasVersion() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasWindowEndMs() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageTelemetryChunkOrBuilder
    public boolean hasWindowStartMs() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r0 = this.memoizedHashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = getDescriptor().hashCode() + 779;
        if (hasVersion() == false) goto L9;
        r1 = a.a(r1, 37, 1, 53) + getVersion();
    L9:
        if (hasType() == false) goto L12;
        r1 = a.a(r1, 37, 2, 53) + this.type_;
    L12:
        if (hasSnapshotId() == false) goto L15;
        r1 = a.a(r1, 37, 3, 53) + getSnapshotId();
    L15:
        if (hasChunkIndex() == false) goto L18;
        r1 = a.a(r1, 37, 4, 53) + getChunkIndex();
    L18:
        if (hasChunkCount() == false) goto L21;
        r1 = a.a(r1, 37, 5, 53) + getChunkCount();
    L21:
        if (hasTotalSize() == false) goto L24;
        r1 = a.a(r1, 37, 6, 53) + getTotalSize();
    L24:
        if (hasCrc32() == false) goto L27;
        r1 = a.a(r1, 37, 7, 53) + getCrc32();
    L27:
        if (hasWindowStartMs() == false) goto L30;
        r1 = a.a(r1, 37, 8, 53) + Internal.hashLong(getWindowStartMs());
    L30:
        if (hasWindowEndMs() == false) goto L33;
        r1 = a.a(r1, 37, 9, 53) + Internal.hashLong(getWindowEndMs());
    L33:
        if (hasQualityFlags() == false) goto L36;
        r1 = a.a(r1, 37, 10, 53) + getQualityFlags();
    L36:
        if (hasPressureSampleCount() == false) goto L39;
        r1 = a.a(r1, 37, 11, 53) + getPressureSampleCount();
    L39:
        if (hasAccelSampleCount() == false) goto L42;
        r1 = a.a(r1, 37, 12, 53) + getAccelSampleCount();
    L42:
        if (hasLinaccSampleCount() == false) goto L45;
        r1 = a.a(r1, 37, 13, 53) + getLinaccSampleCount();
    L45:
        if (hasGyroSampleCount() == false) goto L48;
        r1 = a.a(r1, 37, 14, 53) + getGyroSampleCount();
    L48:
        if (hasFeatureCount() == false) goto L51;
        r1 = a.a(r1, 37, 15, 53) + getFeatureCount();
    L51:
        if (hasRecordSize() == false) goto L54;
        r1 = a.a(r1, 37, 16, 53) + getRecordSize();
    L54:
        if (hasEventDirection() == false) goto L57;
        r1 = a.a(r1, 37, 17, 53) + getEventDirection();
    L57:
        if (hasEventConfidence() == false) goto L60;
        r1 = a.a(r1, 37, 18, 53) + Float.floatToIntBits(getEventConfidence());
    L60:
        if (hasScanPurpose() == false) goto L63;
        r1 = a.a(r1, 37, 19, 53) + getScanPurpose();
    L63:
        if (hasScanResult() == false) goto L66;
        r1 = a.a(r1, 37, 20, 53) + getScanResult();
    L66:
        if (hasRequestedScanMask() == false) goto L69;
        r1 = a.a(r1, 37, 21, 53) + getRequestedScanMask();
    L69:
        if (hasCompletedScanMask() == false) goto L72;
        r1 = a.a(r1, 37, 22, 53) + getCompletedScanMask();
    L72:
        if (hasSceneValid() == false) goto L75;
        r1 = a.a(r1, 37, 23, 53) + Internal.hashBoolean(getSceneValid());
    L75:
        if (hasSceneIsUg() == false) goto L78;
        r1 = a.a(r1, 37, 24, 53) + Internal.hashBoolean(getSceneIsUg());
    L78:
        if (hasSceneConfidence() == false) goto L81;
        r1 = a.a(r1, 37, 25, 53) + Float.floatToIntBits(getSceneConfidence());
    L81:
        if (hasPayload() == false) goto L84;
        r1 = a.a(r1, 37, 26, 53) + getPayload().hashCode();
    L84:
        if (hasScanId() == false) goto L86;
        r1 = a.a(r1, 37, 27, 53) + getScanId();
    L86:
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
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageTelemetryChunk_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageTelemetryChunk.class, Builder.class);
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
        if (hasVersion() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasType() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasSnapshotId() == true) goto L21;
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasChunkIndex() == true) goto L25;
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (hasChunkCount() == true) goto L29;
        this.memoizedIsInitialized = 0;
        return false;
    L29:
        if (hasTotalSize() == true) goto L33;
        this.memoizedIsInitialized = 0;
        return false;
    L33:
        if (hasCrc32() == true) goto L37;
        this.memoizedIsInitialized = 0;
        return false;
    L37:
        if (hasWindowStartMs() == true) goto L41;
        this.memoizedIsInitialized = 0;
        return false;
    L41:
        if (hasWindowEndMs() == true) goto L45;
        this.memoizedIsInitialized = 0;
        return false;
    L45:
        if (hasQualityFlags() == true) goto L49;
        this.memoizedIsInitialized = 0;
        return false;
    L49:
        if (hasPressureSampleCount() == true) goto L53;
        this.memoizedIsInitialized = 0;
        return false;
    L53:
        if (hasAccelSampleCount() == true) goto L57;
        this.memoizedIsInitialized = 0;
        return false;
    L57:
        if (hasLinaccSampleCount() == true) goto L61;
        this.memoizedIsInitialized = 0;
        return false;
    L61:
        if (hasGyroSampleCount() == true) goto L65;
        this.memoizedIsInitialized = 0;
        return false;
    L65:
        if (hasFeatureCount() == true) goto L69;
        this.memoizedIsInitialized = 0;
        return false;
    L69:
        if (hasRecordSize() == true) goto L73;
        this.memoizedIsInitialized = 0;
        return false;
    L73:
        if (hasPayload() == true) goto L76;
        this.memoizedIsInitialized = 0;
        return false;
    L76:
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
        return new GarageTelemetryChunk();
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
    public void writeTo(CodedOutputStream r6) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r6.writeUInt32(1, this.version_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r6.writeEnum(2, this.type_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r6.writeUInt32(3, this.snapshotId_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r6.writeUInt32(4, this.chunkIndex_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r6.writeUInt32(5, this.chunkCount_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r6.writeUInt32(6, this.totalSize_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r6.writeFixed32(7, this.crc32_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r6.writeUInt64(8, this.windowStartMs_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r6.writeUInt64(9, this.windowEndMs_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        r6.writeUInt32(10, this.qualityFlags_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r6.writeUInt32(11, this.pressureSampleCount_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r6.writeUInt32(12, this.accelSampleCount_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r6.writeUInt32(13, this.linaccSampleCount_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r6.writeUInt32(14, this.gyroSampleCount_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r6.writeUInt32(15, this.featureCount_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L51;
        r6.writeUInt32(16, this.recordSize_);
    L51:
        if ((this.bitField0_ & 65536) == 0) goto L54;
        r6.writeSInt32(17, this.eventDirection_);
    L54:
        if ((this.bitField0_ & 131072) == 0) goto L57;
        r6.writeFloat(18, this.eventConfidence_);
    L57:
        if ((this.bitField0_ & 262144) == 0) goto L60;
        r6.writeUInt32(19, this.scanPurpose_);
    L60:
        if ((this.bitField0_ & 524288) == 0) goto L63;
        r6.writeUInt32(20, this.scanResult_);
    L63:
        if ((this.bitField0_ & 1048576) == 0) goto L66;
        r6.writeUInt32(21, this.requestedScanMask_);
    L66:
        if ((this.bitField0_ & 2097152) == 0) goto L69;
        r6.writeUInt32(22, this.completedScanMask_);
    L69:
        if ((this.bitField0_ & 4194304) == 0) goto L72;
        r6.writeBool(23, this.sceneValid_);
    L72:
        if ((this.bitField0_ & 8388608) == 0) goto L75;
        r6.writeBool(24, this.sceneIsUg_);
    L75:
        if ((this.bitField0_ & 16777216) == 0) goto L78;
        r6.writeFloat(25, this.sceneConfidence_);
    L78:
        if ((this.bitField0_ & 33554432) == 0) goto L81;
        r6.writeBytes(26, this.payload_);
    L81:
        if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L83;
        r6.writeUInt32(27, this.scanId_);
    L83:
        getUnknownFields().writeTo(r6);
    }
}
