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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class GarageDetectEvent extends GeneratedMessageV3 implements GarageDetectEventOrBuilder {
    public static final int COMPLETED_SCAN_MASK_FIELD_NUMBER = 42;
    private static final GarageDetectEvent DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<GarageDetectEvent> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int REQUESTED_SCAN_MASK_FIELD_NUMBER = 41;
    public static final int RUNTIME_ENABLED_FIELD_NUMBER = 44;
    public static final int RUNTIME_REQUEST_ID_FIELD_NUMBER = 45;
    public static final int SCAN_ID_FIELD_NUMBER = 43;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int completedScanMask_;
    private byte memoizedIsInitialized;
    private int reason_;
    private int requestedScanMask_;
    private boolean runtimeEnabled_;
    private int runtimeRequestId_;
    private int scanId_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GarageDetectEventOrBuilder {
        private int bitField0_;
        private int completedScanMask_;
        private int reason_;
        private int requestedScanMask_;
        private boolean runtimeEnabled_;
        private int runtimeRequestId_;
        private int scanId_;

        private Builder() {
            this.reason_ = 0;
        }

        private Builder(GeneratedMessageV3.BuilderParent r3) {
            super((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.reason_ = 0;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r2, AnonymousClass1 r3) {
            this((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(GarageDetectEvent r4) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            GarageDetectEvent.access$302(r4, this.reason_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L10;
            GarageDetectEvent.access$402(r4, this.requestedScanMask_);
            r1 = r1 | 2;
        L10:
            if ((r0 & 4) == 0) goto L13;
            GarageDetectEvent.access$502(r4, this.completedScanMask_);
            r1 = r1 | 4;
        L13:
            if ((r0 & 8) == 0) goto L16;
            GarageDetectEvent.access$602(r4, this.scanId_);
            r1 = r1 | 8;
        L16:
            if ((r0 & 16) == 0) goto L19;
            GarageDetectEvent.access$702(r4, this.runtimeEnabled_);
            r1 = r1 | 16;
        L19:
            if ((r0 & 32) == 0) goto L21;
            GarageDetectEvent.access$802(r4, this.runtimeRequestId_);
            r1 = r1 | 32;
        L21:
            GarageDetectEvent.access$976(r4, r1);
            return;
        L5:
            r1 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_descriptor;
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
        public GarageDetectEvent build() {
            GarageDetectEvent r1 = buildPartial();
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
        public GarageDetectEvent buildPartial() {
            GarageDetectEvent r0 = new GarageDetectEvent(this, null);
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
            this.reason_ = 0;
            this.requestedScanMask_ = 0;
            this.completedScanMask_ = 0;
            this.scanId_ = 0;
            this.runtimeEnabled_ = false;
            this.runtimeRequestId_ = 0;
            return this;
        }

        public Builder clearCompletedScanMask() {
            this.bitField0_ &= -5;
            this.completedScanMask_ = 0;
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

        public Builder clearReason() {
            this.bitField0_ &= -2;
            this.reason_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRequestedScanMask() {
            this.bitField0_ &= -3;
            this.requestedScanMask_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRuntimeEnabled() {
            this.bitField0_ &= -17;
            this.runtimeEnabled_ = false;
            onChanged();
            return this;
        }

        public Builder clearRuntimeRequestId() {
            this.bitField0_ &= -33;
            this.runtimeRequestId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearScanId() {
            this.bitField0_ &= -9;
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

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public int getCompletedScanMask() {
            return this.completedScanMask_;
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
        public GarageDetectEvent getDefaultInstanceForType() {
            return GarageDetectEvent.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_descriptor;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public GarageReportReason getReason() {
            GarageReportReason r0 = GarageReportReason.forNumber(this.reason_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return GarageReportReason.GARAGE_REPORT_REASON_UNKNOWN;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public int getRequestedScanMask() {
            return this.requestedScanMask_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public boolean getRuntimeEnabled() {
            return this.runtimeEnabled_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public int getRuntimeRequestId() {
            return this.runtimeRequestId_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public int getScanId() {
            return this.scanId_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public boolean hasCompletedScanMask() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public boolean hasReason() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public boolean hasRequestedScanMask() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public boolean hasRuntimeEnabled() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public boolean hasRuntimeRequestId() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
        public boolean hasScanId() {
            if ((this.bitField0_ & 8) == 0) goto L5;
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
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageDetectEvent.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasReason() == true) goto L6;
            return false;
        L6:
            if (hasRequestedScanMask() == true) goto L9;
            return false;
        L9:
            if (hasCompletedScanMask() == true) goto L12;
            return false;
        L12:
            if (hasScanId() == true) goto L14;
            return false;
        L14:
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
        public Builder mergeFrom(CodedInputStream r7, ExtensionRegistryLite r8) {
            Objects.requireNonNull(r8);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L40;
            int r2 = r7.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r2 == 0) goto L32;
            if (r2 != 16) goto L9;
            int r3 = r7.readEnum();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (GarageReportReason.forNumber(r3) != null) goto L30;
            mergeUnknownVarintField(2, r3);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L30:
            this.reason_ = r3;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            int r4 = this.bitField0_ | 1;
        L22:
            this.bitField0_ = r4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L9:
            if (r2 == 328) goto L26;
            if (r2 == 336) goto L25;
            if (r2 == 344) goto L24;
            if (r2 == 352) goto L23;
            if (r2 != 360) goto L19;
            this.runtimeRequestId_ = r7.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r4 = this.bitField0_ | 32;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L22
        L19:
            if (parseUnknownField(r7, r8, r2) == true) goto L3;
        L23:
            this.runtimeEnabled_ = r7.readBool();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r4 = this.bitField0_ | 16;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L22
        L24:
            this.scanId_ = r7.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r4 = this.bitField0_ | 8;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L22
        L25:
            this.completedScanMask_ = r7.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r4 = this.bitField0_ | 4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L22
        L26:
            this.requestedScanMask_ = r7.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r4 = this.bitField0_ | 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L32:
            r0 = true;
            goto L3
        L33:
            th = move-exception;
            onChanged();
            throw th;
        L35:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L33
        L40:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, GarageDetectEvent.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((GarageDetectEvent) ZeusTransformUtils.preCheckCast(r4, GarageDetectEvent.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(GarageDetectEvent r2) {
            if (r2 != GarageDetectEvent.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.hasReason() == false) goto L9;
            setReason(r2.getReason());
        L9:
            if (r2.hasRequestedScanMask() == false) goto L12;
            setRequestedScanMask(r2.getRequestedScanMask());
        L12:
            if (r2.hasCompletedScanMask() == false) goto L15;
            setCompletedScanMask(r2.getCompletedScanMask());
        L15:
            if (r2.hasScanId() == false) goto L18;
            setScanId(r2.getScanId());
        L18:
            if (r2.hasRuntimeEnabled() == false) goto L21;
            setRuntimeEnabled(r2.getRuntimeEnabled());
        L21:
            if (r2.hasRuntimeRequestId() == false) goto L23;
            setRuntimeRequestId(r2.getRuntimeRequestId());
        L23:
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

        public Builder setCompletedScanMask(int r1) {
            this.completedScanMask_ = r1;
            this.bitField0_ |= 4;
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

        public Builder setReason(GarageReportReason r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 1;
            this.reason_ = r2.getNumber();
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

        public Builder setRequestedScanMask(int r1) {
            this.requestedScanMask_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setRuntimeEnabled(boolean r1) {
            this.runtimeEnabled_ = r1;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setRuntimeRequestId(int r1) {
            this.runtimeRequestId_ = r1;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setScanId(int r1) {
            this.scanId_ = r1;
            this.bitField0_ |= 8;
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
        DEFAULT_INSTANCE = new GarageDetectEvent();
        PARSER = new AnonymousClass1();
    }

    private GarageDetectEvent() {
        this.requestedScanMask_ = 0;
        this.completedScanMask_ = 0;
        this.scanId_ = 0;
        this.runtimeEnabled_ = false;
        this.runtimeRequestId_ = 0;
        this.memoizedIsInitialized = -1;
        this.reason_ = 0;
    }

    private GarageDetectEvent(GeneratedMessageV3.Builder<?> r1) {
        super(r1);
        this.reason_ = 0;
        this.requestedScanMask_ = 0;
        this.completedScanMask_ = 0;
        this.scanId_ = 0;
        this.runtimeEnabled_ = false;
        this.runtimeRequestId_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ GarageDetectEvent(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ int access$302(GarageDetectEvent r0, int r1) {
        r0.reason_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(GarageDetectEvent r0, int r1) {
        r0.requestedScanMask_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$502(GarageDetectEvent r0, int r1) {
        r0.completedScanMask_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(GarageDetectEvent r0, int r1) {
        r0.scanId_ = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$702(GarageDetectEvent r0, boolean r1) {
        r0.runtimeEnabled_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$802(GarageDetectEvent r0, int r1) {
        r0.runtimeRequestId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$976(GarageDetectEvent r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    public static GarageDetectEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GarageDetectEvent r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static GarageDetectEvent parseDelimitedFrom(InputStream r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(ByteString r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(CodedInputStream r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(InputStream r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(ByteBuffer r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(byte[] r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static GarageDetectEvent parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (GarageDetectEvent) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageDetectEvent.class, "com.obric.memorydata.plugin");
    }

    public static Parser<GarageDetectEvent> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GarageDetectEvent.class) == false) goto L8;
        GarageDetectEvent r6 = (GarageDetectEvent) ZeusTransformUtils.preCheckCast(r5, GarageDetectEvent.class, "com.obric.memorydata.plugin");
        if (hasReason() == r6.hasReason()) goto L13;
        return false;
    L13:
        if (hasReason() == false) goto L18;
        if (this.reason_ == r6.reason_) goto L18;
        return false;
    L18:
        if (hasRequestedScanMask() == r6.hasRequestedScanMask()) goto L21;
        return false;
    L21:
        if (hasRequestedScanMask() == false) goto L26;
        if (getRequestedScanMask() == r6.getRequestedScanMask()) goto L26;
        return false;
    L26:
        if (hasCompletedScanMask() == r6.hasCompletedScanMask()) goto L29;
        return false;
    L29:
        if (hasCompletedScanMask() == false) goto L34;
        if (getCompletedScanMask() == r6.getCompletedScanMask()) goto L34;
        return false;
    L34:
        if (hasScanId() == r6.hasScanId()) goto L37;
        return false;
    L37:
        if (hasScanId() == false) goto L42;
        if (getScanId() == r6.getScanId()) goto L42;
        return false;
    L42:
        if (hasRuntimeEnabled() == r6.hasRuntimeEnabled()) goto L45;
        return false;
    L45:
        if (hasRuntimeEnabled() == false) goto L50;
        if (getRuntimeEnabled() == r6.getRuntimeEnabled()) goto L50;
        return false;
    L50:
        if (hasRuntimeRequestId() == r6.hasRuntimeRequestId()) goto L53;
        return false;
    L53:
        if (hasRuntimeRequestId() == false) goto L58;
        if (getRuntimeRequestId() == r6.getRuntimeRequestId()) goto L58;
        return false;
    L58:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L60;
        return false;
    L60:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public int getCompletedScanMask() {
        return this.completedScanMask_;
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
    public GarageDetectEvent getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GarageDetectEvent> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public GarageReportReason getReason() {
        GarageReportReason r0 = GarageReportReason.forNumber(this.reason_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return GarageReportReason.GARAGE_REPORT_REASON_UNKNOWN;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public int getRequestedScanMask() {
        return this.requestedScanMask_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public boolean getRuntimeEnabled() {
        return this.runtimeEnabled_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public int getRuntimeRequestId() {
        return this.runtimeRequestId_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
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
        r1 = 0 + CodedOutputStream.computeEnumSize(2, this.reason_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r1 = r1 + CodedOutputStream.computeUInt32Size(41, this.requestedScanMask_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r1 = r1 + CodedOutputStream.computeUInt32Size(42, this.completedScanMask_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r1 = r1 + CodedOutputStream.computeUInt32Size(43, this.scanId_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r1 = r1 + CodedOutputStream.computeBoolSize(44, this.runtimeEnabled_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L23;
        r1 = r1 + CodedOutputStream.computeUInt32Size(45, this.runtimeRequestId_);
    L23:
        int r2 = getUnknownFields().getSerializedSize() + r1;
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public boolean hasCompletedScanMask() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public boolean hasReason() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public boolean hasRequestedScanMask() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public boolean hasRuntimeEnabled() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public boolean hasRuntimeRequestId() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageDetectEventOrBuilder
    public boolean hasScanId() {
        if ((this.bitField0_ & 8) == 0) goto L5;
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
        if (hasReason() == false) goto L9;
        r1 = a.a(r1, 37, 2, 53) + this.reason_;
    L9:
        if (hasRequestedScanMask() == false) goto L12;
        r1 = a.a(r1, 37, 41, 53) + getRequestedScanMask();
    L12:
        if (hasCompletedScanMask() == false) goto L15;
        r1 = a.a(r1, 37, 42, 53) + getCompletedScanMask();
    L15:
        if (hasScanId() == false) goto L18;
        r1 = a.a(r1, 37, 43, 53) + getScanId();
    L18:
        if (hasRuntimeEnabled() == false) goto L21;
        r1 = a.a(r1, 37, 44, 53) + Internal.hashBoolean(getRuntimeEnabled());
    L21:
        if (hasRuntimeRequestId() == false) goto L23;
        r1 = a.a(r1, 37, 45, 53) + getRuntimeRequestId();
    L23:
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
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageDetectEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageDetectEvent.class, Builder.class);
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
        if (hasReason() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasRequestedScanMask() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasCompletedScanMask() == true) goto L21;
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasScanId() == true) goto L24;
        this.memoizedIsInitialized = 0;
        return false;
    L24:
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
        return new GarageDetectEvent();
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
    public void writeTo(CodedOutputStream r3) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r3.writeEnum(2, this.reason_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r3.writeUInt32(41, this.requestedScanMask_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r3.writeUInt32(42, this.completedScanMask_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r3.writeUInt32(43, this.scanId_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r3.writeBool(44, this.runtimeEnabled_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L20;
        r3.writeUInt32(45, this.runtimeRequestId_);
    L20:
        getUnknownFields().writeTo(r3);
    }
}
