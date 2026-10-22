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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
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

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        private void buildPartial0(CloudSyncData r3) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            CloudSyncData.access$302(r3, this.cryptoMode_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L9;
            CloudSyncData.access$402(r3, this.dataSize_);
            r1 = r1 | 2;
        L9:
            CloudSyncData.access$576(r3, r1);
            return;
        L5:
            r1 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CloudSyncData build() {
            CloudSyncData r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw GeneratedMessage.Builder.newUninitializedMessageException(r1);
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
            CloudSyncData r0 = new CloudSyncData(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
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

        public Builder mergeFrom(CloudSyncData r2) {
            if (r2 != CloudSyncData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.hasCryptoMode() == false) goto L9;
            setCryptoMode(r2.getCryptoMode());
        L9:
            if (r2.hasDataSize() == false) goto L11;
            setDataSize(r2.getDataSize());
        L11:
            mergeUnknownFields(r2.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            r6.getClass();
            boolean r1 = false;
        L3:
            if (r1 == true) goto L25;
            int r2 = r5.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r2 == 0) goto L17;
            if (r2 == 8) goto L14;
            if (r2 != 16) goto L11;
            this.dataSize_ = r5.readUInt32();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            int r3 = this.bitField0_ | 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
        L15:
            this.bitField0_ = r3;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L3
        L11:
            if (parseUnknownField(r5, r6, r2) == true) goto L3;
        L14:
            this.cryptoMode_ = r5.readUInt32();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            r3 = this.bitField0_ | 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
        L17:
            r1 = true;
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
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, CloudSyncData.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((CloudSyncData) ZeusTransformUtils.preCheckCast(r4, CloudSyncData.class, "com.obric.memorydata.plugin"));
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

        public Builder setCryptoMode(int r1) {
            this.cryptoMode_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setDataSize(int r1) {
            this.dataSize_ = r1;
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

    private CloudSyncData(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.cryptoMode_ = 0;
        this.dataSize_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ CloudSyncData(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ int access$302(CloudSyncData r0, int r1) {
        r0.cryptoMode_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(CloudSyncData r0, int r1) {
        r0.dataSize_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$576(CloudSyncData r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
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

    public static Builder newBuilder(CloudSyncData r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static CloudSyncData parseDelimitedFrom(InputStream r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(ByteString r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(CodedInputStream r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(InputStream r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(ByteBuffer r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(byte[] r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static CloudSyncData parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (CloudSyncData) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), CloudSyncData.class, "com.obric.memorydata.plugin");
    }

    public static Parser<CloudSyncData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CloudSyncData.class) == false) goto L8;
        CloudSyncData r6 = (CloudSyncData) ZeusTransformUtils.preCheckCast(r5, CloudSyncData.class, "com.obric.memorydata.plugin");
        if (hasCryptoMode() == r6.hasCryptoMode()) goto L13;
        return false;
    L13:
        if (hasCryptoMode() == false) goto L18;
        if (getCryptoMode() == r6.getCryptoMode()) goto L18;
        return false;
    L18:
        if (hasDataSize() == r6.hasDataSize()) goto L21;
        return false;
    L21:
        if (hasDataSize() == false) goto L26;
        if (getDataSize() == r6.getDataSize()) goto L26;
        return false;
    L26:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L28;
        return false;
    L28:
        return true;
    L8:
        return super.equals(r5);
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
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r1 = 0 + CodedOutputStream.computeUInt32Size(1, this.cryptoMode_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L11;
        r1 = r1 + CodedOutputStream.computeUInt32Size(2, this.dataSize_);
    L11:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
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
        int r0 = this.memoizedHashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = getDescriptor().hashCode() + 779;
        if (hasCryptoMode() == false) goto L9;
        r1 = (((r1 * 37) + 1) * 53) + getCryptoMode();
    L9:
        if (hasDataSize() == false) goto L11;
        r1 = (((r1 * 37) + 2) * 53) + getDataSize();
    L11:
        int r2 = (r1 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r2;
        return r2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_fieldAccessorTable.ensureFieldAccessorsInitialized(CloudSyncData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
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
    public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
        return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
        return newBuilderForType((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r1 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r1);
    L6:
        return new Builder(r1).mergeFrom(this);
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
    public void writeTo(CodedOutputStream r3) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r3.writeUInt32(1, this.cryptoMode_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        r3.writeUInt32(2, this.dataSize_);
    L8:
        getUnknownFields().writeTo(r3);
    }
}
