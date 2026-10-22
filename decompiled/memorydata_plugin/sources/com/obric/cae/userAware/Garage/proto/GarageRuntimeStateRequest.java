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
public final class GarageRuntimeStateRequest extends GeneratedMessageV3 implements GarageRuntimeStateRequestOrBuilder {
    public static final int CAPABILITY_MASK_FIELD_NUMBER = 3;
    private static final GarageRuntimeStateRequest DEFAULT_INSTANCE = null;
    public static final int ENABLED_FIELD_NUMBER = 2;

    @Deprecated
    public static final Parser<GarageRuntimeStateRequest> PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int capabilityMask_;
    private boolean enabled_;
    private byte memoizedIsInitialized;
    private int requestId_;
    private int version_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GarageRuntimeStateRequestOrBuilder {
        private int bitField0_;
        private int capabilityMask_;
        private boolean enabled_;
        private int requestId_;
        private int version_;

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent r3) {
            super((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r2, AnonymousClass1 r3) {
            this((GeneratedMessageV3.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, GeneratedMessageV3.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(GarageRuntimeStateRequest r4) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            GarageRuntimeStateRequest.access$302(r4, this.version_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L10;
            GarageRuntimeStateRequest.access$402(r4, this.enabled_);
            r1 = r1 | 2;
        L10:
            if ((r0 & 4) == 0) goto L13;
            GarageRuntimeStateRequest.access$502(r4, this.capabilityMask_);
            r1 = r1 | 4;
        L13:
            if ((r0 & 8) == 0) goto L15;
            GarageRuntimeStateRequest.access$602(r4, this.requestId_);
            r1 = r1 | 8;
        L15:
            GarageRuntimeStateRequest.access$776(r4, r1);
            return;
        L5:
            r1 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_descriptor;
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
        public GarageRuntimeStateRequest build() {
            GarageRuntimeStateRequest r1 = buildPartial();
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
        public GarageRuntimeStateRequest buildPartial() {
            GarageRuntimeStateRequest r0 = new GarageRuntimeStateRequest(this, null);
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
            this.enabled_ = false;
            this.capabilityMask_ = 0;
            this.requestId_ = 0;
            return this;
        }

        public Builder clearCapabilityMask() {
            this.bitField0_ &= -5;
            this.capabilityMask_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEnabled() {
            this.bitField0_ &= -3;
            this.enabled_ = false;
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

        public Builder clearRequestId() {
            this.bitField0_ &= -9;
            this.requestId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.bitField0_ &= -2;
            this.version_ = 0;
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

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public int getCapabilityMask() {
            return this.capabilityMask_;
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
        public GarageRuntimeStateRequest getDefaultInstanceForType() {
            return GarageRuntimeStateRequest.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_descriptor;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public boolean getEnabled() {
            return this.enabled_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public int getRequestId() {
            return this.requestId_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public boolean hasCapabilityMask() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public boolean hasEnabled() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public boolean hasRequestId() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
        public boolean hasVersion() {
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
            return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageRuntimeStateRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasVersion() == true) goto L6;
            return false;
        L6:
            if (hasEnabled() == true) goto L9;
            return false;
        L9:
            if (hasCapabilityMask() == true) goto L12;
            return false;
        L12:
            if (hasRequestId() == true) goto L14;
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
        public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
            Objects.requireNonNull(r7);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L31;
            int r2 = r6.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r2 == 0) goto L23;
            if (r2 == 8) goto L21;
            if (r2 == 16) goto L20;
            if (r2 == 24) goto L19;
            if (r2 != 32) goto L15;
            this.requestId_ = r6.readUInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            int r3 = this.bitField0_ | 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L18:
            this.bitField0_ = r3;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L3
        L15:
            if (parseUnknownField(r6, r7, r2) == true) goto L3;
        L19:
            this.capabilityMask_ = r6.readUInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            r3 = this.bitField0_ | 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L18
        L20:
            this.enabled_ = r6.readBool();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            r3 = this.bitField0_ | 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L18
        L21:
            this.version_ = r6.readUInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            r3 = this.bitField0_ | 1;
        L23:
            r0 = true;
            goto L3
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
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, GarageRuntimeStateRequest.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(r4, GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(GarageRuntimeStateRequest r2) {
            if (r2 != GarageRuntimeStateRequest.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.hasVersion() == false) goto L9;
            setVersion(r2.getVersion());
        L9:
            if (r2.hasEnabled() == false) goto L12;
            setEnabled(r2.getEnabled());
        L12:
            if (r2.hasCapabilityMask() == false) goto L15;
            setCapabilityMask(r2.getCapabilityMask());
        L15:
            if (r2.hasRequestId() == false) goto L17;
            setRequestId(r2.getRequestId());
        L17:
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

        public Builder setCapabilityMask(int r1) {
            this.capabilityMask_ = r1;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setEnabled(boolean r1) {
            this.enabled_ = r1;
            this.bitField0_ |= 2;
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

        public Builder setRequestId(int r1) {
            this.requestId_ = r1;
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

        public Builder setVersion(int r1) {
            this.version_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new GarageRuntimeStateRequest();
        PARSER = new AnonymousClass1();
    }

    private GarageRuntimeStateRequest() {
        this.version_ = 0;
        this.enabled_ = false;
        this.capabilityMask_ = 0;
        this.requestId_ = 0;
        this.memoizedIsInitialized = -1;
    }

    private GarageRuntimeStateRequest(GeneratedMessageV3.Builder<?> r1) {
        super(r1);
        this.version_ = 0;
        this.enabled_ = false;
        this.capabilityMask_ = 0;
        this.requestId_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ GarageRuntimeStateRequest(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ int access$302(GarageRuntimeStateRequest r0, int r1) {
        r0.version_ = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$402(GarageRuntimeStateRequest r0, boolean r1) {
        r0.enabled_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$502(GarageRuntimeStateRequest r0, int r1) {
        r0.capabilityMask_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$602(GarageRuntimeStateRequest r0, int r1) {
        r0.requestId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$776(GarageRuntimeStateRequest r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    public static GarageRuntimeStateRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GarageRuntimeStateRequest r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static GarageRuntimeStateRequest parseDelimitedFrom(InputStream r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(ByteString r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(CodedInputStream r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(InputStream r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(GeneratedMessageV3.parseWithIOException(PARSER, r1, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(ByteBuffer r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(byte[] r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static GarageRuntimeStateRequest parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
    }

    public static Parser<GarageRuntimeStateRequest> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GarageRuntimeStateRequest.class) == false) goto L8;
        GarageRuntimeStateRequest r6 = (GarageRuntimeStateRequest) ZeusTransformUtils.preCheckCast(r5, GarageRuntimeStateRequest.class, "com.obric.memorydata.plugin");
        if (hasVersion() == r6.hasVersion()) goto L13;
        return false;
    L13:
        if (hasVersion() == false) goto L18;
        if (getVersion() == r6.getVersion()) goto L18;
        return false;
    L18:
        if (hasEnabled() == r6.hasEnabled()) goto L21;
        return false;
    L21:
        if (hasEnabled() == false) goto L26;
        if (getEnabled() == r6.getEnabled()) goto L26;
        return false;
    L26:
        if (hasCapabilityMask() == r6.hasCapabilityMask()) goto L29;
        return false;
    L29:
        if (hasCapabilityMask() == false) goto L34;
        if (getCapabilityMask() == r6.getCapabilityMask()) goto L34;
        return false;
    L34:
        if (hasRequestId() == r6.hasRequestId()) goto L37;
        return false;
    L37:
        if (hasRequestId() == false) goto L42;
        if (getRequestId() == r6.getRequestId()) goto L42;
        return false;
    L42:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L44;
        return false;
    L44:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public int getCapabilityMask() {
        return this.capabilityMask_;
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
    public GarageRuntimeStateRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public boolean getEnabled() {
        return this.enabled_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GarageRuntimeStateRequest> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public int getRequestId() {
        return this.requestId_;
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
        r1 = r1 + CodedOutputStream.computeBoolSize(2, this.enabled_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r1 = r1 + CodedOutputStream.computeUInt32Size(3, this.capabilityMask_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L17;
        r1 = r1 + CodedOutputStream.computeUInt32Size(4, this.requestId_);
    L17:
        int r2 = getUnknownFields().getSerializedSize() + r1;
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public boolean hasCapabilityMask() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public boolean hasEnabled() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public boolean hasRequestId() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.userAware.Garage.proto.GarageRuntimeStateRequestOrBuilder
    public boolean hasVersion() {
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
        if (hasVersion() == false) goto L9;
        r1 = a.a(r1, 37, 1, 53) + getVersion();
    L9:
        if (hasEnabled() == false) goto L12;
        r1 = a.a(r1, 37, 2, 53) + Internal.hashBoolean(getEnabled());
    L12:
        if (hasCapabilityMask() == false) goto L15;
        r1 = a.a(r1, 37, 3, 53) + getCapabilityMask();
    L15:
        if (hasRequestId() == false) goto L17;
        r1 = a.a(r1, 37, 4, 53) + getRequestId();
    L17:
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
        return GarageDetectProto.internal_static_com_obric_cae_userAware_Garage_proto_GarageRuntimeStateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GarageRuntimeStateRequest.class, Builder.class);
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
        if (hasEnabled() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasCapabilityMask() == true) goto L21;
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasRequestId() == true) goto L24;
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
        return new GarageRuntimeStateRequest();
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
    public void writeTo(CodedOutputStream r4) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r4.writeUInt32(1, this.version_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r4.writeBool(2, this.enabled_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r4.writeUInt32(3, this.capabilityMask_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L14;
        r4.writeUInt32(4, this.requestId_);
    L14:
        getUnknownFields().writeTo(r4);
    }
}
