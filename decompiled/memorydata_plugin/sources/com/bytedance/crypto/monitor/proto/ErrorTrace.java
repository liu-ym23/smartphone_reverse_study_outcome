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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
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

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.packageName_ = "";
            maybeForceBuilderInitialization();
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        private void buildPartial0(ErrorTrace r4) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            ErrorTrace.access$402(r4, this.moduleId_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L10;
            ErrorTrace.access$502(r4, this.eventId_);
            r1 = r1 | 2;
        L10:
            if ((r0 & 4) == 0) goto L13;
            ErrorTrace.access$602(r4, this.packageName_);
            r1 = r1 | 4;
        L13:
            if ((r0 & 8) == 0) goto L16;
            ErrorTrace.access$702(r4, this.errCode_);
            r1 = r1 | 8;
        L16:
            if ((r0 & 16) == 0) goto L22;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r2 = this.cloudSyncDataBuilder_;
            if (r2 != null) goto L20;
            CloudSyncData r3 = this.cloudSyncData_;
        L21:
            ErrorTrace.access$802(r4, r3);
            r1 = r1 | 16;
            goto L22
        L20:
            r3 = (CloudSyncData) ZeusTransformUtils.preCheckCast(r2.build(), CloudSyncData.class, "com.obric.memorydata.plugin");
        L22:
            ErrorTrace.access$976(r4, r1);
            return;
        L5:
            r1 = 0;
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
            ErrorTrace r1 = buildPartial();
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
        public ErrorTrace buildPartial() {
            ErrorTrace r0 = new ErrorTrace(this, null);
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
            this.moduleId_ = 0;
            this.eventId_ = 0;
            this.packageName_ = "";
            this.errCode_ = 0;
            this.cloudSyncData_ = null;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r1 = this.cloudSyncDataBuilder_;
            if (r1 == null) goto L5;
            r1.dispose();
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
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r1 = this.cloudSyncDataBuilder_;
            if (r1 == null) goto L5;
            r1.dispose();
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
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r0 = this.cloudSyncDataBuilder_;
            if (r0 != null) goto L9;
            CloudSyncData r2 = this.cloudSyncData_;
            if (r2 == null) goto L7;
            return r2;
        L7:
            return CloudSyncData.getDefaultInstance();
        L9:
            return (CloudSyncData) ZeusTransformUtils.preCheckCast(r0.getMessage(), CloudSyncData.class, "com.obric.memorydata.plugin");
        }

        public CloudSyncData.Builder getCloudSyncDataBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (CloudSyncData.Builder) ZeusTransformUtils.preCheckCast(internalGetCloudSyncDataFieldBuilder().getBuilder(), CloudSyncData.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public CloudSyncDataOrBuilder getCloudSyncDataOrBuilder() {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r0 = this.cloudSyncDataBuilder_;
            if (r0 != null) goto L5;
            CloudSyncData r2 = this.cloudSyncData_;
            if (r2 == null) goto L9;
            return r2;
        L9:
            return CloudSyncData.getDefaultInstance();
        L5:
            return (CloudSyncDataOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(), CloudSyncDataOrBuilder.class, "com.obric.memorydata.plugin");
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
            Object r0 = this.packageName_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
            ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L7;
            this.packageName_ = r2;
        L7:
            return r2;
        L9:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public ByteString getPackageNameBytes() {
            Object r0 = this.packageName_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.packageName_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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

        public Builder mergeCloudSyncData(CloudSyncData r3) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r0 = this.cloudSyncDataBuilder_;
            if (r0 == null) goto L5;
            r0.mergeFrom(r3);
        L14:
            if (this.cloudSyncData_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            CloudSyncData r1 = this.cloudSyncData_;
            if (r1 == null) goto L11;
            if (r1 == CloudSyncData.getDefaultInstance()) goto L11;
            getCloudSyncDataBuilder().mergeFrom(r3);
        L11:
            this.cloudSyncData_ = r3;
            goto L14
        }

        public Builder mergeFrom(ErrorTrace r2) {
            if (r2 != ErrorTrace.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.hasModuleId() == false) goto L9;
            setModuleId(r2.getModuleId());
        L9:
            if (r2.hasEventId() == false) goto L12;
            setEventId(r2.getEventId());
        L12:
            if (r2.hasPackageName() == false) goto L15;
            this.packageName_ = ErrorTrace.access$600(r2);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r2.hasErrCode() == false) goto L18;
            setErrCode(r2.getErrCode());
        L18:
            if (r2.hasCloudSyncData() == false) goto L20;
            mergeCloudSyncData(r2.getCloudSyncData());
        L20:
            mergeUnknownFields(r2.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r7, ExtensionRegistryLite r8) {
            r8.getClass();
            boolean r1 = false;
        L3:
            if (r1 == true) goto L34;
            int r2 = r7.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (r2 == 0) goto L26;
            if (r2 == 8) goto L23;
            if (r2 == 16) goto L22;
            if (r2 == 26) goto L21;
            if (r2 == 32) goto L20;
            if (r2 != 802) goto L17;
            r7.readMessage(internalGetCloudSyncDataFieldBuilder().getBuilder(), r8);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            int r3 = this.bitField0_ | 16;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L24:
            this.bitField0_ = r3;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L3
        L17:
            if (parseUnknownField(r7, r8, r2) == true) goto L3;
        L20:
            this.errCode_ = r7.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r3 = this.bitField0_ | 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L21:
            this.packageName_ = r7.readBytes();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r3 = this.bitField0_ | 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L22:
            this.eventId_ = r7.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r3 = this.bitField0_ | 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L23:
            this.moduleId_ = r7.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r3 = this.bitField0_ | 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L26:
            r1 = true;
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
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, ErrorTrace.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((ErrorTrace) ZeusTransformUtils.preCheckCast(r4, ErrorTrace.class, "com.obric.memorydata.plugin"));
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

        public Builder setCloudSyncData(CloudSyncData.Builder r2) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r0 = this.cloudSyncDataBuilder_;
            CloudSyncData r3 = r2.build();
            if (r0 != null) goto L5;
            this.cloudSyncData_ = r3;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r0.setMessage(r3);
            goto L6
        }

        public Builder setCloudSyncData(CloudSyncData r2) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r0 = this.cloudSyncDataBuilder_;
            if (r0 != null) goto L5;
            r2.getClass();
            this.cloudSyncData_ = r2;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r0.setMessage(r2);
            goto L6
        }

        public Builder setErrCode(int r1) {
            this.errCode_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setEventId(int r1) {
            this.eventId_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setModuleId(int r1) {
            this.moduleId_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setPackageName(String r1) {
            r1.getClass();
            this.packageName_ = r1;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPackageNameBytes(ByteString r1) {
            r1.getClass();
            this.packageName_ = r1;
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

    private ErrorTrace(GeneratedMessage.Builder<?> r2) {
        super(r2);
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.errCode_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ ErrorTrace(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$402(ErrorTrace r0, int r1) {
        r0.moduleId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$502(ErrorTrace r0, int r1) {
        r0.eventId_ = r1;
        return r1;
    }

    public static /* synthetic */ Object access$600(ErrorTrace r0) {
        return r0.packageName_;
    }

    public static /* synthetic */ Object access$602(ErrorTrace r0, Object r1) {
        r0.packageName_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$702(ErrorTrace r0, int r1) {
        r0.errCode_ = r1;
        return r1;
    }

    public static /* synthetic */ CloudSyncData access$802(ErrorTrace r0, CloudSyncData r1) {
        r0.cloudSyncData_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$976(ErrorTrace r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
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

    public static Builder newBuilder(ErrorTrace r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static ErrorTrace parseDelimitedFrom(InputStream r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(ByteString r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(CodedInputStream r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(InputStream r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(ByteBuffer r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(byte[] r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static ErrorTrace parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (ErrorTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), ErrorTrace.class, "com.obric.memorydata.plugin");
    }

    public static Parser<ErrorTrace> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ErrorTrace.class) == false) goto L8;
        ErrorTrace r6 = (ErrorTrace) ZeusTransformUtils.preCheckCast(r5, ErrorTrace.class, "com.obric.memorydata.plugin");
        if (hasModuleId() == r6.hasModuleId()) goto L13;
        return false;
    L13:
        if (hasModuleId() == false) goto L18;
        if (getModuleId() == r6.getModuleId()) goto L18;
        return false;
    L18:
        if (hasEventId() == r6.hasEventId()) goto L21;
        return false;
    L21:
        if (hasEventId() == false) goto L26;
        if (getEventId() == r6.getEventId()) goto L26;
        return false;
    L26:
        if (hasPackageName() == r6.hasPackageName()) goto L29;
        return false;
    L29:
        if (hasPackageName() == false) goto L34;
        if (getPackageName().equals(r6.getPackageName()) == true) goto L34;
        return false;
    L34:
        if (hasErrCode() == r6.hasErrCode()) goto L37;
        return false;
    L37:
        if (hasErrCode() == false) goto L42;
        if (getErrCode() == r6.getErrCode()) goto L42;
        return false;
    L42:
        if (hasCloudSyncData() == r6.hasCloudSyncData()) goto L45;
        return false;
    L45:
        if (hasCloudSyncData() == false) goto L50;
        if (getCloudSyncData().equals(r6.getCloudSyncData()) == true) goto L50;
        return false;
    L50:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L52;
        return false;
    L52:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public CloudSyncData getCloudSyncData() {
        CloudSyncData r0 = this.cloudSyncData_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CloudSyncData.getDefaultInstance();
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public CloudSyncDataOrBuilder getCloudSyncDataOrBuilder() {
        CloudSyncData r0 = this.cloudSyncData_;
        if (r0 == null) goto L5;
        return r0;
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
        Object r0 = this.packageName_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        String r2 = r1.toStringUtf8();
        if (r1.isValidUtf8() == false) goto L9;
        this.packageName_ = r2;
    L9:
        return r2;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public ByteString getPackageNameBytes() {
        Object r0 = this.packageName_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.packageName_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ErrorTrace> getParserForType() {
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
        r1 = 0 + CodedOutputStream.computeUInt32Size(1, this.moduleId_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r1 = r1 + CodedOutputStream.computeUInt32Size(2, this.eventId_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r1 = r1 + GeneratedMessage.computeStringSize(3, this.packageName_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r1 = r1 + CodedOutputStream.computeInt32Size(4, this.errCode_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L20;
        r1 = r1 + CodedOutputStream.computeMessageSize(100, getCloudSyncData());
    L20:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
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
        int r0 = this.memoizedHashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = getDescriptor().hashCode() + 779;
        if (hasModuleId() == false) goto L9;
        r1 = (((r1 * 37) + 1) * 53) + getModuleId();
    L9:
        if (hasEventId() == false) goto L12;
        r1 = (((r1 * 37) + 2) * 53) + getEventId();
    L12:
        if (hasPackageName() == false) goto L15;
        r1 = (((r1 * 37) + 3) * 53) + getPackageName().hashCode();
    L15:
        if (hasErrCode() == false) goto L18;
        r1 = (((r1 * 37) + 4) * 53) + getErrCode();
    L18:
        if (hasCloudSyncData() == false) goto L20;
        r1 = (((r1 * 37) + 100) * 53) + getCloudSyncData().hashCode();
    L20:
        int r2 = (r1 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r2;
        return r2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(ErrorTrace.class, Builder.class);
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
    public void writeTo(CodedOutputStream r4) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r4.writeUInt32(1, this.moduleId_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r4.writeUInt32(2, this.eventId_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r4, 3, this.packageName_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r4.writeInt32(4, this.errCode_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L17;
        r4.writeMessage(100, getCloudSyncData());
    L17:
        getUnknownFields().writeTo(r4);
    }
}
