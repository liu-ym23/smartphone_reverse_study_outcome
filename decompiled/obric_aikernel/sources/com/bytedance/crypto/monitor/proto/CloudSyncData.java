package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class CloudSyncData extends GeneratedMessage implements CloudSyncDataOrBuilder {
    public static final int CRYPTO_MODE_FIELD_NUMBER = 1;
    public static final int DATA_SIZE_FIELD_NUMBER = 2;
    private static final CloudSyncData DEFAULT_INSTANCE = null;
    private static final Parser<CloudSyncData> PARSER = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cryptoMode_;
    private int dataSize_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CloudSyncDataOrBuilder {
        private int bitField0_;
        private int cryptoMode_;
        private int dataSize_;

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void buildPartial0(CloudSyncData r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L5;
            CloudSyncData.access$302(r10, this.cryptoMode_);
            int r12 = 1;
        L7:
            if ((r11 & 2) == 0) goto L9;
            CloudSyncData.access$402(r10, this.dataSize_);
            r12 = r12 | 2;
        L9:
            CloudSyncData.access$576(r10, r12);
            return;
        L5:
            r12 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CloudSyncData build() {
            CloudSyncData r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
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
        public CloudSyncData buildPartial() {
            CloudSyncData r10 = new CloudSyncData(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r10);
        L5:
            onBuilt();
            return r10;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.cryptoMode_ = 0;
            this.dataSize_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder clearCryptoMode() {
            this.bitField0_ &= -2;
            this.cryptoMode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDataSize() {
            this.bitField0_ &= -3;
            this.dataSize_ = 0;
            onChanged();
            return this;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public int getCryptoMode() {
            return this.cryptoMode_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public int getDataSize() {
            return this.dataSize_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CloudSyncData getDefaultInstanceForType() {
            return CloudSyncData.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public boolean hasCryptoMode() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public boolean hasDataSize() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_fieldAccessorTable.ensureFieldAccessorsInitialized(CloudSyncData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CloudSyncData r10) {
            if (r10 != CloudSyncData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.hasCryptoMode() == false) goto L9;
            setCryptoMode(r10.getCryptoMode());
        L9:
            if (r10.hasDataSize() == false) goto L11;
            setDataSize(r10.getDataSize());
        L11:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            r11.getClass();
            boolean r12 = false;
        L3:
            if (r12 == true) goto L25;
            int r13 = r10.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r13 == 0) goto L17;
            if (r13 == 8) goto L14;
            if (r13 != 16) goto L11;
            this.dataSize_ = r10.readUInt32();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            int r14 = this.bitField0_ | 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
        L15:
            this.bitField0_ = r14;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L3
        L11:
            if (parseUnknownField(r10, r11, r13) == true) goto L3;
        L14:
            this.cryptoMode_ = r10.readUInt32();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            r14 = this.bitField0_ | 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
        L17:
            r12 = true;
            goto L3
        L20:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            onChanged();
            throw th;
        L25:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof CloudSyncData) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((CloudSyncData) r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        public Builder setCryptoMode(int r10) {
            this.cryptoMode_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setDataSize(int r10) {
            this.dataSize_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CloudSyncData.class.getName());
        DEFAULT_INSTANCE = new CloudSyncData();
        PARSER = new AnonymousClass1();
    }

    private CloudSyncData() {
        this.cryptoMode_ = 0;
        this.dataSize_ = 0;
        this.memoizedIsInitialized = -1;
    }

    private CloudSyncData(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.cryptoMode_ = 0;
        this.dataSize_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ CloudSyncData(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ int access$302(CloudSyncData r10, int r11) {
        r10.cryptoMode_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$402(CloudSyncData r10, int r11) {
        r10.dataSize_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$576(CloudSyncData r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    public static CloudSyncData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CloudSyncData r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static CloudSyncData parseDelimitedFrom(InputStream r10) {
        return (CloudSyncData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static CloudSyncData parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (CloudSyncData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static CloudSyncData parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static CloudSyncData parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static CloudSyncData parseFrom(CodedInputStream r10) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static CloudSyncData parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static CloudSyncData parseFrom(InputStream r10) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static CloudSyncData parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static CloudSyncData parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static CloudSyncData parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static CloudSyncData parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static CloudSyncData parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<CloudSyncData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof CloudSyncData) == false) goto L8;
        CloudSyncData r11 = (CloudSyncData) r10;
        if (hasCryptoMode() == r11.hasCryptoMode()) goto L13;
        return false;
    L13:
        if (hasCryptoMode() == false) goto L18;
        if (getCryptoMode() == r11.getCryptoMode()) goto L18;
        return false;
    L18:
        if (hasDataSize() == r11.hasDataSize()) goto L21;
        return false;
    L21:
        if (hasDataSize() == false) goto L26;
        if (getDataSize() == r11.getDataSize()) goto L26;
        return false;
    L26:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L28;
        return false;
    L28:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public int getCryptoMode() {
        return this.cryptoMode_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public int getDataSize() {
        return this.dataSize_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CloudSyncData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CloudSyncData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r11 = 0 + CodedOutputStream.computeUInt32Size(1, this.cryptoMode_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L11;
        r11 = r11 + CodedOutputStream.computeUInt32Size(2, this.dataSize_);
    L11:
        int r12 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public boolean hasCryptoMode() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public boolean hasDataSize() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = getDescriptor().hashCode() + 779;
        if (hasCryptoMode() == false) goto L9;
        r11 = (((r11 * 37) + 1) * 53) + getCryptoMode();
    L9:
        if (hasDataSize() == false) goto L11;
        r11 = (((r11 * 37) + 2) * 53) + getDataSize();
    L11:
        int r12 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_fieldAccessorTable.ensureFieldAccessorsInitialized(CloudSyncData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r10 = this.memoizedIsInitialized;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return new Builder(r10, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return newBuilderForType(r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r10 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r10);
    L6:
        return new Builder(r10).mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r10.writeUInt32(1, this.cryptoMode_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        r10.writeUInt32(2, this.dataSize_);
    L8:
        getUnknownFields().writeTo(r10);
    }
}
