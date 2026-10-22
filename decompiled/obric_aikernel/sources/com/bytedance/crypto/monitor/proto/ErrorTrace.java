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
import com.google.protobuf.SingleFieldBuilder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ErrorTrace extends GeneratedMessage implements ErrorTraceOrBuilder {
    public static final int CLOUD_SYNC_DATA_FIELD_NUMBER = 100;
    private static final ErrorTrace DEFAULT_INSTANCE = null;
    public static final int ERR_CODE_FIELD_NUMBER = 4;
    public static final int EVENT_ID_FIELD_NUMBER = 2;
    public static final int MODULE_ID_FIELD_NUMBER = 1;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 3;
    private static final Parser<ErrorTrace> PARSER = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private CloudSyncData cloudSyncData_;
    private int errCode_;
    private int eventId_;
    private byte memoizedIsInitialized;
    private int moduleId_;
    private volatile Object packageName_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ErrorTraceOrBuilder {
        private int bitField0_;
        private SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> cloudSyncDataBuilder_;
        private CloudSyncData cloudSyncData_;
        private int errCode_;
        private int eventId_;
        private int moduleId_;
        private Object packageName_;

        private Builder() {
            this.packageName_ = "";
            maybeForceBuilderInitialization();
        }

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.packageName_ = "";
            maybeForceBuilderInitialization();
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void buildPartial0(ErrorTrace r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L5;
            ErrorTrace.access$402(r10, this.moduleId_);
            int r12 = 1;
        L7:
            if ((r11 & 2) == 0) goto L10;
            ErrorTrace.access$502(r10, this.eventId_);
            r12 = r12 | 2;
        L10:
            if ((r11 & 4) == 0) goto L13;
            ErrorTrace.access$602(r10, this.packageName_);
            r12 = r12 | 4;
        L13:
            if ((r11 & 8) == 0) goto L16;
            ErrorTrace.access$702(r10, this.errCode_);
            r12 = r12 | 8;
        L16:
            if ((r11 & 16) == 0) goto L22;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r13 = this.cloudSyncDataBuilder_;
            if (r13 != null) goto L20;
            CloudSyncData r14 = this.cloudSyncData_;
        L21:
            ErrorTrace.access$802(r10, r14);
            r12 = r12 | 16;
            goto L22
        L20:
            r14 = (CloudSyncData) r13.build();
        L22:
            ErrorTrace.access$976(r10, r12);
            return;
        L5:
            r12 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor;
        }

        private SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> internalGetCloudSyncDataFieldBuilder() {
            if (this.cloudSyncDataBuilder_ != null) goto L6;
            this.cloudSyncDataBuilder_ = new SingleFieldBuilder(getCloudSyncData(), getParentForChildren(), isClean());
            this.cloudSyncData_ = null;
        L6:
            return this.cloudSyncDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (ErrorTrace.access$200() == false) goto L6;
            internalGetCloudSyncDataFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ErrorTrace build() {
            ErrorTrace r10 = buildPartial();
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
        public ErrorTrace buildPartial() {
            ErrorTrace r10 = new ErrorTrace(this, null);
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
            this.moduleId_ = 0;
            this.eventId_ = 0;
            this.packageName_ = "";
            this.errCode_ = 0;
            this.cloudSyncData_ = null;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r10 = this.cloudSyncDataBuilder_;
            if (r10 == null) goto L5;
            r10.dispose();
            this.cloudSyncDataBuilder_ = null;
        L5:
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

        public Builder clearCloudSyncData() {
            this.bitField0_ &= -17;
            this.cloudSyncData_ = null;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r10 = this.cloudSyncDataBuilder_;
            if (r10 == null) goto L5;
            r10.dispose();
            this.cloudSyncDataBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearErrCode() {
            this.bitField0_ &= -9;
            this.errCode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventId() {
            this.bitField0_ &= -3;
            this.eventId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearModuleId() {
            this.bitField0_ &= -2;
            this.moduleId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPackageName() {
            this.packageName_ = ErrorTrace.getDefaultInstance().getPackageName();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public CloudSyncData getCloudSyncData() {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r10 = this.cloudSyncDataBuilder_;
            if (r10 != null) goto L9;
            CloudSyncData r11 = this.cloudSyncData_;
            if (r11 == null) goto L7;
            return r11;
        L7:
            return CloudSyncData.getDefaultInstance();
        L9:
            return (CloudSyncData) r10.getMessage();
        }

        public CloudSyncData.Builder getCloudSyncDataBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (CloudSyncData.Builder) internalGetCloudSyncDataFieldBuilder().getBuilder();
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public CloudSyncDataOrBuilder getCloudSyncDataOrBuilder() {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r10 = this.cloudSyncDataBuilder_;
            if (r10 != null) goto L5;
            CloudSyncData r11 = this.cloudSyncData_;
            if (r11 == null) goto L9;
            return r11;
        L9:
            return CloudSyncData.getDefaultInstance();
        L5:
            return (CloudSyncDataOrBuilder) r10.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ErrorTrace getDefaultInstanceForType() {
            return ErrorTrace.getDefaultInstance();
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
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public int getEventId() {
            return this.eventId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public int getModuleId() {
            return this.moduleId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public String getPackageName() {
            Object r10 = this.packageName_;
            if ((r10 instanceof String) == true) goto L9;
            ByteString r11 = (ByteString) r10;
            String r12 = r11.toStringUtf8();
            if (r11.isValidUtf8() == false) goto L7;
            this.packageName_ = r12;
        L7:
            return r12;
        L9:
            return (String) r10;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public ByteString getPackageNameBytes() {
            Object r10 = this.packageName_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.packageName_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasCloudSyncData() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasErrCode() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasEventId() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasModuleId() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(ErrorTrace.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeCloudSyncData(CloudSyncData r10) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r11 = this.cloudSyncDataBuilder_;
            if (r11 == null) goto L5;
            r11.mergeFrom(r10);
        L14:
            if (this.cloudSyncData_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            CloudSyncData r12 = this.cloudSyncData_;
            if (r12 == null) goto L11;
            if (r12 == CloudSyncData.getDefaultInstance()) goto L11;
            getCloudSyncDataBuilder().mergeFrom(r10);
        L11:
            this.cloudSyncData_ = r10;
            goto L14
        }

        public Builder mergeFrom(ErrorTrace r10) {
            if (r10 != ErrorTrace.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.hasModuleId() == false) goto L9;
            setModuleId(r10.getModuleId());
        L9:
            if (r10.hasEventId() == false) goto L12;
            setEventId(r10.getEventId());
        L12:
            if (r10.hasPackageName() == false) goto L15;
            this.packageName_ = ErrorTrace.access$600(r10);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r10.hasErrCode() == false) goto L18;
            setErrCode(r10.getErrCode());
        L18:
            if (r10.hasCloudSyncData() == false) goto L20;
            mergeCloudSyncData(r10.getCloudSyncData());
        L20:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            r11.getClass();
            boolean r12 = false;
        L3:
            if (r12 == true) goto L34;
            int r13 = r10.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (r13 == 0) goto L26;
            if (r13 == 8) goto L23;
            if (r13 == 16) goto L22;
            if (r13 == 26) goto L21;
            if (r13 == 32) goto L20;
            if (r13 != 802) goto L17;
            r10.readMessage(internalGetCloudSyncDataFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            int r14 = this.bitField0_ | 16;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L24:
            this.bitField0_ = r14;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L3
        L17:
            if (parseUnknownField(r10, r11, r13) == true) goto L3;
        L20:
            this.errCode_ = r10.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r14 = this.bitField0_ | 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L21:
            this.packageName_ = r10.readBytes();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r14 = this.bitField0_ | 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L22:
            this.eventId_ = r10.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r14 = this.bitField0_ | 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L23:
            this.moduleId_ = r10.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r14 = this.bitField0_ | 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L26:
            r12 = true;
            goto L3
        L29:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            onChanged();
            throw th;
        L34:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof ErrorTrace) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((ErrorTrace) r10);
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

        public Builder setCloudSyncData(CloudSyncData.Builder r10) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r11 = this.cloudSyncDataBuilder_;
            CloudSyncData r12 = r10.build();
            if (r11 != null) goto L5;
            this.cloudSyncData_ = r12;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r11.setMessage(r12);
            goto L6
        }

        public Builder setCloudSyncData(CloudSyncData r10) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r11 = this.cloudSyncDataBuilder_;
            if (r11 != null) goto L5;
            r10.getClass();
            this.cloudSyncData_ = r10;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r11.setMessage(r10);
            goto L6
        }

        public Builder setErrCode(int r10) {
            this.errCode_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setEventId(int r10) {
            this.eventId_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setModuleId(int r10) {
            this.moduleId_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setPackageName(String r10) {
            r10.getClass();
            this.packageName_ = r10;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPackageNameBytes(ByteString r10) {
            r10.getClass();
            this.packageName_ = r10;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", ErrorTrace.class.getName());
        DEFAULT_INSTANCE = new ErrorTrace();
        PARSER = new AnonymousClass1();
    }

    private ErrorTrace() {
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.errCode_ = 0;
        this.memoizedIsInitialized = -1;
        this.packageName_ = "";
    }

    private ErrorTrace(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.errCode_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ ErrorTrace(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$402(ErrorTrace r10, int r11) {
        r10.moduleId_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$502(ErrorTrace r10, int r11) {
        r10.eventId_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$600(ErrorTrace r10) {
        return r10.packageName_;
    }

    public static /* synthetic */ Object access$602(ErrorTrace r10, Object r11) {
        r10.packageName_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$702(ErrorTrace r10, int r11) {
        r10.errCode_ = r11;
        return r11;
    }

    public static /* synthetic */ CloudSyncData access$802(ErrorTrace r10, CloudSyncData r11) {
        r10.cloudSyncData_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$976(ErrorTrace r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    public static ErrorTrace getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ErrorTrace r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static ErrorTrace parseDelimitedFrom(InputStream r10) {
        return (ErrorTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static ErrorTrace parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (ErrorTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static ErrorTrace parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static ErrorTrace parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static ErrorTrace parseFrom(CodedInputStream r10) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static ErrorTrace parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static ErrorTrace parseFrom(InputStream r10) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static ErrorTrace parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static ErrorTrace parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static ErrorTrace parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static ErrorTrace parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static ErrorTrace parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<ErrorTrace> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ErrorTrace) == false) goto L8;
        ErrorTrace r11 = (ErrorTrace) r10;
        if (hasModuleId() == r11.hasModuleId()) goto L13;
        return false;
    L13:
        if (hasModuleId() == false) goto L18;
        if (getModuleId() == r11.getModuleId()) goto L18;
        return false;
    L18:
        if (hasEventId() == r11.hasEventId()) goto L21;
        return false;
    L21:
        if (hasEventId() == false) goto L26;
        if (getEventId() == r11.getEventId()) goto L26;
        return false;
    L26:
        if (hasPackageName() == r11.hasPackageName()) goto L29;
        return false;
    L29:
        if (hasPackageName() == false) goto L34;
        if (getPackageName().equals(r11.getPackageName()) == true) goto L34;
        return false;
    L34:
        if (hasErrCode() == r11.hasErrCode()) goto L37;
        return false;
    L37:
        if (hasErrCode() == false) goto L42;
        if (getErrCode() == r11.getErrCode()) goto L42;
        return false;
    L42:
        if (hasCloudSyncData() == r11.hasCloudSyncData()) goto L45;
        return false;
    L45:
        if (hasCloudSyncData() == false) goto L50;
        if (getCloudSyncData().equals(r11.getCloudSyncData()) == true) goto L50;
        return false;
    L50:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L52;
        return false;
    L52:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public CloudSyncData getCloudSyncData() {
        CloudSyncData r10 = this.cloudSyncData_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return CloudSyncData.getDefaultInstance();
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public CloudSyncDataOrBuilder getCloudSyncDataOrBuilder() {
        CloudSyncData r10 = this.cloudSyncData_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return CloudSyncData.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ErrorTrace getDefaultInstanceForType() {
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

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public int getErrCode() {
        return this.errCode_;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public int getEventId() {
        return this.eventId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public int getModuleId() {
        return this.moduleId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public String getPackageName() {
        Object r10 = this.packageName_;
        if ((r10 instanceof String) == true) goto L5;
        ByteString r11 = (ByteString) r10;
        String r12 = r11.toStringUtf8();
        if (r11.isValidUtf8() == false) goto L9;
        this.packageName_ = r12;
    L9:
        return r12;
    L5:
        return (String) r10;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public ByteString getPackageNameBytes() {
        Object r10 = this.packageName_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.packageName_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ErrorTrace> getParserForType() {
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
        r11 = 0 + CodedOutputStream.computeUInt32Size(1, this.moduleId_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r11 = r11 + CodedOutputStream.computeUInt32Size(2, this.eventId_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r11 = r11 + GeneratedMessage.computeStringSize(3, this.packageName_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r11 = r11 + CodedOutputStream.computeInt32Size(4, this.errCode_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L20;
        r11 = r11 + CodedOutputStream.computeMessageSize(100, getCloudSyncData());
    L20:
        int r12 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasCloudSyncData() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasErrCode() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasEventId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasModuleId() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasPackageName() {
        if ((this.bitField0_ & 4) == 0) goto L5;
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
        if (hasModuleId() == false) goto L9;
        r11 = (((r11 * 37) + 1) * 53) + getModuleId();
    L9:
        if (hasEventId() == false) goto L12;
        r11 = (((r11 * 37) + 2) * 53) + getEventId();
    L12:
        if (hasPackageName() == false) goto L15;
        r11 = (((r11 * 37) + 3) * 53) + getPackageName().hashCode();
    L15:
        if (hasErrCode() == false) goto L18;
        r11 = (((r11 * 37) + 4) * 53) + getErrCode();
    L18:
        if (hasCloudSyncData() == false) goto L20;
        r11 = (((r11 * 37) + 100) * 53) + getCloudSyncData().hashCode();
    L20:
        int r12 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(ErrorTrace.class, Builder.class);
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
        r10.writeUInt32(1, this.moduleId_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r10.writeUInt32(2, this.eventId_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r10, 3, this.packageName_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r10.writeInt32(4, this.errCode_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L17;
        r10.writeMessage(100, getCloudSyncData());
    L17:
        getUnknownFields().writeTo(r10);
    }
}
