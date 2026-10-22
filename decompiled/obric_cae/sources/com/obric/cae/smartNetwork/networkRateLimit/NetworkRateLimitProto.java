package com.obric.cae.smartNetwork.networkRateLimit;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkRateLimitProto extends GeneratedMessageV3 implements NetworkRateLimitProtoOrBuilder {
    private static final NetworkRateLimitProto DEFAULT_INSTANCE = null;
    public static final int NETWORK_RATE_LIMIT_CANCEL_DATA_FIELD_NUMBER = 2;
    public static final int NETWORK_RATE_LIMIT_DATA_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<NetworkRateLimitProto> PARSER = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private NetworkRateLimitCancelData networkRateLimitCancelData_;
    private NetworkRateLimitData networkRateLimitData_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NetworkRateLimitProtoOrBuilder {
        private int bitField0_;
        private SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> networkRateLimitCancelDataBuilder_;
        private NetworkRateLimitCancelData networkRateLimitCancelData_;
        private SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> networkRateLimitDataBuilder_;
        private NetworkRateLimitData networkRateLimitData_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(NetworkRateLimitProto r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L9;
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r11 = this.networkRateLimitDataBuilder_;
            if (r11 != null) goto L7;
            NetworkRateLimitData r12 = this.networkRateLimitData_;
        L8:
            NetworkRateLimitProto.access$402(r8, r12);
            int r13 = 1;
        L11:
            if ((r10 & 2) == 0) goto L17;
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r14 = this.networkRateLimitCancelDataBuilder_;
            if (r14 != null) goto L15;
            NetworkRateLimitCancelData r15 = this.networkRateLimitCancelData_;
        L16:
            NetworkRateLimitProto.access$502(r8, r15);
            r13 = r13 | 2;
            goto L17
        L15:
            r15 = (NetworkRateLimitCancelData) r14.build();
        L17:
            NetworkRateLimitProto.access$676(r8, r13);
            return;
        L7:
            r12 = (NetworkRateLimitData) r11.build();
            goto L8
        L9:
            r13 = 0;
            goto L11
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_descriptor;
        }

        private SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> getNetworkRateLimitCancelDataFieldBuilder() {
            if (this.networkRateLimitCancelDataBuilder_ != null) goto L6;
            this.networkRateLimitCancelDataBuilder_ = new SingleFieldBuilderV3(getNetworkRateLimitCancelData(), getParentForChildren(), isClean());
            this.networkRateLimitCancelData_ = null;
        L6:
            return this.networkRateLimitCancelDataBuilder_;
        }

        private SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> getNetworkRateLimitDataFieldBuilder() {
            if (this.networkRateLimitDataBuilder_ != null) goto L6;
            this.networkRateLimitDataBuilder_ = new SingleFieldBuilderV3(getNetworkRateLimitData(), getParentForChildren(), isClean());
            this.networkRateLimitData_ = null;
        L6:
            return this.networkRateLimitDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (NetworkRateLimitProto.access$200() == false) goto L6;
            getNetworkRateLimitDataFieldBuilder();
            getNetworkRateLimitCancelDataFieldBuilder();
            return;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearNetworkRateLimitCancelData() {
            this.bitField0_ &= -3;
            this.networkRateLimitCancelData_ = null;
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r8 = this.networkRateLimitCancelDataBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.networkRateLimitCancelDataBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearNetworkRateLimitData() {
            this.bitField0_ &= -2;
            this.networkRateLimitData_ = null;
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r8 = this.networkRateLimitDataBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.networkRateLimitDataBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_descriptor;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
        public NetworkRateLimitCancelData getNetworkRateLimitCancelData() {
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r8 = this.networkRateLimitCancelDataBuilder_;
            if (r8 != null) goto L9;
            NetworkRateLimitCancelData r10 = this.networkRateLimitCancelData_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NetworkRateLimitCancelData.getDefaultInstance();
        L9:
            return (NetworkRateLimitCancelData) r8.getMessage();
        }

        public NetworkRateLimitCancelData.Builder getNetworkRateLimitCancelDataBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (NetworkRateLimitCancelData.Builder) getNetworkRateLimitCancelDataFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
        public NetworkRateLimitCancelDataOrBuilder getNetworkRateLimitCancelDataOrBuilder() {
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r8 = this.networkRateLimitCancelDataBuilder_;
            if (r8 != null) goto L5;
            NetworkRateLimitCancelData r10 = this.networkRateLimitCancelData_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return NetworkRateLimitCancelData.getDefaultInstance();
        L5:
            return (NetworkRateLimitCancelDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
        public NetworkRateLimitData getNetworkRateLimitData() {
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r8 = this.networkRateLimitDataBuilder_;
            if (r8 != null) goto L9;
            NetworkRateLimitData r10 = this.networkRateLimitData_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return NetworkRateLimitData.getDefaultInstance();
        L9:
            return (NetworkRateLimitData) r8.getMessage();
        }

        public NetworkRateLimitData.Builder getNetworkRateLimitDataBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return (NetworkRateLimitData.Builder) getNetworkRateLimitDataFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
        public NetworkRateLimitDataOrBuilder getNetworkRateLimitDataOrBuilder() {
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r8 = this.networkRateLimitDataBuilder_;
            if (r8 != null) goto L5;
            NetworkRateLimitData r10 = this.networkRateLimitData_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return NetworkRateLimitData.getDefaultInstance();
        L5:
            return (NetworkRateLimitDataOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
        public boolean hasNetworkRateLimitCancelData() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
        public boolean hasNetworkRateLimitData() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
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

        public Builder mergeNetworkRateLimitCancelData(NetworkRateLimitCancelData r8) {
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r10 = this.networkRateLimitCancelDataBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            NetworkRateLimitCancelData r11 = this.networkRateLimitCancelData_;
            if (r11 == null) goto L11;
            if (r11 == NetworkRateLimitCancelData.getDefaultInstance()) goto L11;
            getNetworkRateLimitCancelDataBuilder().mergeFrom(r8);
        L11:
            this.networkRateLimitCancelData_ = r8;
            goto L13
        }

        public Builder mergeNetworkRateLimitData(NetworkRateLimitData r8) {
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r10 = this.networkRateLimitDataBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L11;
            NetworkRateLimitData r11 = this.networkRateLimitData_;
            if (r11 == null) goto L11;
            if (r11 == NetworkRateLimitData.getDefaultInstance()) goto L11;
            getNetworkRateLimitDataBuilder().mergeFrom(r8);
        L11:
            this.networkRateLimitData_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setNetworkRateLimitCancelData(NetworkRateLimitCancelData.Builder r8) {
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r10 = this.networkRateLimitCancelDataBuilder_;
            NetworkRateLimitCancelData r11 = r8.build();
            if (r10 != null) goto L5;
            this.networkRateLimitCancelData_ = r11;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setNetworkRateLimitData(NetworkRateLimitData.Builder r8) {
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r10 = this.networkRateLimitDataBuilder_;
            NetworkRateLimitData r11 = r8.build();
            if (r10 != null) goto L5;
            this.networkRateLimitData_ = r11;
        L6:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            maybeForceBuilderInitialization();
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
            return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkRateLimitProto.class, Builder.class);
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

        public Builder setNetworkRateLimitCancelData(NetworkRateLimitCancelData r8) {
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r10 = this.networkRateLimitCancelDataBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.networkRateLimitCancelData_ = r8;
        L9:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setNetworkRateLimitData(NetworkRateLimitData r8) {
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r10 = this.networkRateLimitDataBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.networkRateLimitData_ = r8;
        L9:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
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
        public NetworkRateLimitProto build() {
            NetworkRateLimitProto r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkRateLimitProto buildPartial() {
            NetworkRateLimitProto r8 = new NetworkRateLimitProto(this, null);
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
        public NetworkRateLimitProto getDefaultInstanceForType() {
            return NetworkRateLimitProto.getDefaultInstance();
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
            this.networkRateLimitData_ = null;
            SingleFieldBuilderV3<NetworkRateLimitData, NetworkRateLimitData.Builder, NetworkRateLimitDataOrBuilder> r8 = this.networkRateLimitDataBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.networkRateLimitDataBuilder_ = null;
        L5:
            this.networkRateLimitCancelData_ = null;
            SingleFieldBuilderV3<NetworkRateLimitCancelData, NetworkRateLimitCancelData.Builder, NetworkRateLimitCancelDataOrBuilder> r10 = this.networkRateLimitCancelDataBuilder_;
            if (r10 == null) goto L8;
            r10.dispose();
            this.networkRateLimitCancelDataBuilder_ = null;
        L8:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L28;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L25;
            int r12 = r8.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r12 == 0) goto L17;
            if (r12 != 10) goto L10;
            r8.readMessage(getNetworkRateLimitDataFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.bitField0_ |= 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L10:
            if (r12 != 18) goto L12;
            r8.readMessage(getNetworkRateLimitCancelDataFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.bitField0_ |= 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L12:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L17:
            r11 = true;
            goto L4
        L18:
            th = move-exception;
            onChanged();
            throw th;
        L20:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L18
        L25:
            onChanged();
            return this;
        L28:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof NetworkRateLimitProto) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NetworkRateLimitProto) r8);
        }

        public Builder mergeFrom(NetworkRateLimitProto r8) {
            if (r8 != NetworkRateLimitProto.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasNetworkRateLimitData() == false) goto L9;
            mergeNetworkRateLimitData(r8.getNetworkRateLimitData());
        L9:
            if (r8.hasNetworkRateLimitCancelData() == false) goto L11;
            mergeNetworkRateLimitCancelData(r8.getNetworkRateLimitCancelData());
        L11:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new NetworkRateLimitProto();
        PARSER = new AnonymousClass1();
    }

    private NetworkRateLimitProto() {
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ NetworkRateLimitData access$402(NetworkRateLimitProto r8, NetworkRateLimitData r10) {
        r8.networkRateLimitData_ = r10;
        return r10;
    }

    public static /* synthetic */ NetworkRateLimitCancelData access$502(NetworkRateLimitProto r8, NetworkRateLimitCancelData r10) {
        r8.networkRateLimitCancelData_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$676(NetworkRateLimitProto r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static NetworkRateLimitProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static NetworkRateLimitProto parseDelimitedFrom(InputStream r8) {
        return (NetworkRateLimitProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static NetworkRateLimitProto parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<NetworkRateLimitProto> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NetworkRateLimitProto) == false) goto L8;
        NetworkRateLimitProto r10 = (NetworkRateLimitProto) r8;
        if (hasNetworkRateLimitData() == r10.hasNetworkRateLimitData()) goto L13;
        return false;
    L13:
        if (hasNetworkRateLimitData() == false) goto L18;
        if (getNetworkRateLimitData().equals(r10.getNetworkRateLimitData()) == true) goto L18;
        return false;
    L18:
        if (hasNetworkRateLimitCancelData() == r10.hasNetworkRateLimitCancelData()) goto L21;
        return false;
    L21:
        if (hasNetworkRateLimitCancelData() == false) goto L26;
        if (getNetworkRateLimitCancelData().equals(r10.getNetworkRateLimitCancelData()) == true) goto L26;
        return false;
    L26:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L28;
        return false;
    L28:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
    public NetworkRateLimitCancelData getNetworkRateLimitCancelData() {
        NetworkRateLimitCancelData r8 = this.networkRateLimitCancelData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkRateLimitCancelData.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
    public NetworkRateLimitCancelDataOrBuilder getNetworkRateLimitCancelDataOrBuilder() {
        NetworkRateLimitCancelData r8 = this.networkRateLimitCancelData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkRateLimitCancelData.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
    public NetworkRateLimitData getNetworkRateLimitData() {
        NetworkRateLimitData r8 = this.networkRateLimitData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkRateLimitData.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
    public NetworkRateLimitDataOrBuilder getNetworkRateLimitDataOrBuilder() {
        NetworkRateLimitData r8 = this.networkRateLimitData_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return NetworkRateLimitData.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NetworkRateLimitProto> getParserForType() {
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
        r10 = 0 + CodedOutputStream.computeMessageSize(1, getNetworkRateLimitData());
    L9:
        if ((this.bitField0_ & 2) == 0) goto L11;
        r10 = r10 + CodedOutputStream.computeMessageSize(2, getNetworkRateLimitCancelData());
    L11:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
    public boolean hasNetworkRateLimitCancelData() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.networkRateLimit.NetworkRateLimitProtoOrBuilder
    public boolean hasNetworkRateLimitData() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (hasNetworkRateLimitData() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getNetworkRateLimitData().hashCode();
    L9:
        if (hasNetworkRateLimitCancelData() == false) goto L11;
        r10 = b.a(r10, 37, 2, 53) + getNetworkRateLimitCancelData().hashCode();
    L11:
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
        return new NetworkRateLimitProto();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeMessage(1, getNetworkRateLimitData());
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        r8.writeMessage(2, getNetworkRateLimitCancelData());
    L8:
        getUnknownFields().writeTo(r8);
    }

    private NetworkRateLimitProto(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(NetworkRateLimitProto r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static NetworkRateLimitProto parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkRateLimitProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static NetworkRateLimitProto parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return NetworkRateLimitEvent.internal_static_com_obric_cae_smartNetwork_networkRateLimit_NetworkRateLimitProto_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkRateLimitProto.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ NetworkRateLimitProto(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static NetworkRateLimitProto parseFrom(CodedInputStream r8) {
        return (NetworkRateLimitProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NetworkRateLimitProto getDefaultInstanceForType() {
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

    public static NetworkRateLimitProto parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NetworkRateLimitProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static NetworkRateLimitProto parseFrom(InputStream r8) {
        return (NetworkRateLimitProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static NetworkRateLimitProto parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetworkRateLimitProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static NetworkRateLimitProto parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkRateLimitProto parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static NetworkRateLimitProto parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetworkRateLimitProto parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
