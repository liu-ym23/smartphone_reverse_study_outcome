package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class NormalTrace extends GeneratedMessage implements NormalTraceOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 4;
    private static final NormalTrace DEFAULT_INSTANCE = null;
    public static final int ERR_CODE_FIELD_NUMBER = 6;
    public static final int EVENT_ID_FIELD_NUMBER = 2;
    public static final int MODULE_ID_FIELD_NUMBER = 1;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 3;
    private static final Parser<NormalTrace> PARSER = null;
    public static final int TIME_CONSUMPTION_FIELD_NUMBER = 8;
    public static final int TOTAL_CALLS_FIELD_NUMBER = 7;
    public static final int TOTAL_DATA_SIZE_FIELD_NUMBER = 9;
    public static final int USERID_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private volatile Object appId_;
    private int bitField0_;
    private int errCode_;
    private int eventId_;
    private byte memoizedIsInitialized;
    private int moduleId_;
    private volatile Object packageName_;
    private long timeConsumption_;
    private int totalCalls_;
    private long totalDataSize_;
    private int userid_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements NormalTraceOrBuilder {
        private Object appId_;
        private int bitField0_;
        private int errCode_;
        private int eventId_;
        private int moduleId_;
        private Object packageName_;
        private long timeConsumption_;
        private int totalCalls_;
        private long totalDataSize_;
        private int userid_;

        private Builder() {
            this.packageName_ = "";
            this.appId_ = "";
        }

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.packageName_ = "";
            this.appId_ = "";
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void buildPartial0(NormalTrace r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L5;
            NormalTrace.access$302(r10, this.moduleId_);
            int r12 = 1;
        L7:
            if ((r11 & 2) == 0) goto L10;
            NormalTrace.access$402(r10, this.eventId_);
            r12 = r12 | 2;
        L10:
            if ((r11 & 4) == 0) goto L13;
            NormalTrace.access$502(r10, this.packageName_);
            r12 = r12 | 4;
        L13:
            if ((r11 & 8) == 0) goto L16;
            NormalTrace.access$602(r10, this.appId_);
            r12 = r12 | 8;
        L16:
            if ((r11 & 16) == 0) goto L19;
            NormalTrace.access$702(r10, this.userid_);
            r12 = r12 | 16;
        L19:
            if ((r11 & 32) == 0) goto L22;
            NormalTrace.access$802(r10, this.errCode_);
            r12 = r12 | 32;
        L22:
            if ((r11 & 64) == 0) goto L25;
            NormalTrace.access$902(r10, this.totalCalls_);
            r12 = r12 | 64;
        L25:
            if ((r11 & 128) == 0) goto L28;
            NormalTrace.access$1002(r10, this.timeConsumption_);
            r12 = r12 | 128;
        L28:
            if ((r11 & 256) == 0) goto L30;
            NormalTrace.access$1102(r10, this.totalDataSize_);
            r12 = r12 | 256;
        L30:
            NormalTrace.access$1276(r10, r12);
            return;
        L5:
            r12 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NormalTrace build() {
            NormalTrace r10 = buildPartial();
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
        public NormalTrace buildPartial() {
            NormalTrace r10 = new NormalTrace(this, null);
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
            this.appId_ = "";
            this.userid_ = 0;
            this.errCode_ = 0;
            this.totalCalls_ = 0;
            this.timeConsumption_ = 0;
            this.totalDataSize_ = 0;
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

        public Builder clearAppId() {
            this.appId_ = NormalTrace.getDefaultInstance().getAppId();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearErrCode() {
            this.bitField0_ &= -33;
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
            this.packageName_ = NormalTrace.getDefaultInstance().getPackageName();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearTimeConsumption() {
            this.bitField0_ &= -129;
            this.timeConsumption_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalCalls() {
            this.bitField0_ &= -65;
            this.totalCalls_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalDataSize() {
            this.bitField0_ &= -257;
            this.totalDataSize_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUserid() {
            this.bitField0_ &= -17;
            this.userid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public String getAppId() {
            Object r10 = this.appId_;
            if ((r10 instanceof String) == true) goto L9;
            ByteString r11 = (ByteString) r10;
            String r12 = r11.toStringUtf8();
            if (r11.isValidUtf8() == false) goto L7;
            this.appId_ = r12;
        L7:
            return r12;
        L9:
            return (String) r10;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public ByteString getAppIdBytes() {
            Object r10 = this.appId_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.appId_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NormalTrace getDefaultInstanceForType() {
            return NormalTrace.getDefaultInstance();
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
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getEventId() {
            return this.eventId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getModuleId() {
            return this.moduleId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
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

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public ByteString getPackageNameBytes() {
            Object r10 = this.packageName_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.packageName_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public long getTimeConsumption() {
            return this.timeConsumption_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getTotalCalls() {
            return this.totalCalls_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public long getTotalDataSize() {
            return this.totalDataSize_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getUserid() {
            return this.userid_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasAppId() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasErrCode() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasEventId() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasModuleId() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasTimeConsumption() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasTotalCalls() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasTotalDataSize() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasUserid() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(NormalTrace.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(NormalTrace r10) {
            if (r10 != NormalTrace.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.hasModuleId() == false) goto L9;
            setModuleId(r10.getModuleId());
        L9:
            if (r10.hasEventId() == false) goto L12;
            setEventId(r10.getEventId());
        L12:
            if (r10.hasPackageName() == false) goto L15;
            this.packageName_ = NormalTrace.access$500(r10);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r10.hasAppId() == false) goto L18;
            this.appId_ = NormalTrace.access$600(r10);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r10.hasUserid() == false) goto L21;
            setUserid(r10.getUserid());
        L21:
            if (r10.hasErrCode() == false) goto L24;
            setErrCode(r10.getErrCode());
        L24:
            if (r10.hasTotalCalls() == false) goto L27;
            setTotalCalls(r10.getTotalCalls());
        L27:
            if (r10.hasTimeConsumption() == false) goto L30;
            setTimeConsumption(r10.getTimeConsumption());
        L30:
            if (r10.hasTotalDataSize() == false) goto L32;
            setTotalDataSize(r10.getTotalDataSize());
        L32:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            r11.getClass();
            boolean r12 = false;
        L3:
            if (r12 == true) goto L46;
            int r13 = r10.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r13 == 0) goto L38;
            if (r13 == 8) goto L35;
            int r14 = 16;
            if (r13 == 16) goto L34;
            if (r13 == 26) goto L33;
            if (r13 == 34) goto L32;
            if (r13 == 40) goto L30;
            if (r13 == 48) goto L29;
            r14 = 64;
            if (r13 == 56) goto L28;
            if (r13 == 64) goto L27;
            if (r13 != 72) goto L24;
            this.totalDataSize_ = r10.readUInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            int r15 = this.bitField0_ | 256;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L36:
            this.bitField0_ = r15;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L24:
            if (parseUnknownField(r10, r11, r13) == true) goto L3;
        L27:
            this.timeConsumption_ = r10.readUInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r15 = this.bitField0_ | 128;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L28:
            this.totalCalls_ = r10.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L31:
            r15 = this.bitField0_ | r14;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L29:
            this.errCode_ = r10.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r15 = this.bitField0_ | 32;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L30:
            this.userid_ = r10.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L31
        L32:
            this.appId_ = r10.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r15 = this.bitField0_ | 8;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L33:
            this.packageName_ = r10.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r15 = this.bitField0_ | 4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L34:
            this.eventId_ = r10.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r15 = this.bitField0_ | 2;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L35:
            this.moduleId_ = r10.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r15 = this.bitField0_ | 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L38:
            r12 = true;
            goto L3
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
        L46:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof NormalTrace) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((NormalTrace) r10);
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

        public Builder setAppId(String r10) {
            r10.getClass();
            this.appId_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setAppIdBytes(ByteString r10) {
            r10.getClass();
            this.appId_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setErrCode(int r10) {
            this.errCode_ = r10;
            this.bitField0_ |= 32;
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

        public Builder setTimeConsumption(long r10) {
            this.timeConsumption_ = r10;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setTotalCalls(int r10) {
            this.totalCalls_ = r10;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTotalDataSize(long r10) {
            this.totalDataSize_ = r10;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setUserid(int r10) {
            this.userid_ = r10;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", NormalTrace.class.getName());
        DEFAULT_INSTANCE = new NormalTrace();
        PARSER = new AnonymousClass1();
    }

    private NormalTrace() {
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.appId_ = "";
        this.userid_ = 0;
        this.errCode_ = 0;
        this.totalCalls_ = 0;
        this.timeConsumption_ = 0;
        this.totalDataSize_ = 0;
        this.memoizedIsInitialized = -1;
        this.packageName_ = "";
        this.appId_ = "";
    }

    private NormalTrace(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.appId_ = "";
        this.userid_ = 0;
        this.errCode_ = 0;
        this.totalCalls_ = 0;
        this.timeConsumption_ = 0;
        this.totalDataSize_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ NormalTrace(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ long access$1002(NormalTrace r10, long r11) {
        r10.timeConsumption_ = r11;
        return r11;
    }

    public static /* synthetic */ long access$1102(NormalTrace r10, long r11) {
        r10.totalDataSize_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$1276(NormalTrace r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    public static /* synthetic */ int access$302(NormalTrace r10, int r11) {
        r10.moduleId_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$402(NormalTrace r10, int r11) {
        r10.eventId_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$500(NormalTrace r10) {
        return r10.packageName_;
    }

    public static /* synthetic */ Object access$502(NormalTrace r10, Object r11) {
        r10.packageName_ = r11;
        return r11;
    }

    public static /* synthetic */ Object access$600(NormalTrace r10) {
        return r10.appId_;
    }

    public static /* synthetic */ Object access$602(NormalTrace r10, Object r11) {
        r10.appId_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$702(NormalTrace r10, int r11) {
        r10.userid_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$802(NormalTrace r10, int r11) {
        r10.errCode_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$902(NormalTrace r10, int r11) {
        r10.totalCalls_ = r11;
        return r11;
    }

    public static NormalTrace getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(NormalTrace r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static NormalTrace parseDelimitedFrom(InputStream r10) {
        return (NormalTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static NormalTrace parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (NormalTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static NormalTrace parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static NormalTrace parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static NormalTrace parseFrom(CodedInputStream r10) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static NormalTrace parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static NormalTrace parseFrom(InputStream r10) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static NormalTrace parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static NormalTrace parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static NormalTrace parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static NormalTrace parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static NormalTrace parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<NormalTrace> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof NormalTrace) == false) goto L8;
        NormalTrace r11 = (NormalTrace) r10;
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
        if (hasAppId() == r11.hasAppId()) goto L37;
        return false;
    L37:
        if (hasAppId() == false) goto L42;
        if (getAppId().equals(r11.getAppId()) == true) goto L42;
        return false;
    L42:
        if (hasUserid() == r11.hasUserid()) goto L45;
        return false;
    L45:
        if (hasUserid() == false) goto L50;
        if (getUserid() == r11.getUserid()) goto L50;
        return false;
    L50:
        if (hasErrCode() == r11.hasErrCode()) goto L53;
        return false;
    L53:
        if (hasErrCode() == false) goto L58;
        if (getErrCode() == r11.getErrCode()) goto L58;
        return false;
    L58:
        if (hasTotalCalls() == r11.hasTotalCalls()) goto L61;
        return false;
    L61:
        if (hasTotalCalls() == false) goto L66;
        if (getTotalCalls() == r11.getTotalCalls()) goto L66;
        return false;
    L66:
        if (hasTimeConsumption() == r11.hasTimeConsumption()) goto L69;
        return false;
    L69:
        if (hasTimeConsumption() == false) goto L74;
        if (getTimeConsumption() == r11.getTimeConsumption()) goto L74;
        return false;
    L74:
        if (hasTotalDataSize() == r11.hasTotalDataSize()) goto L77;
        return false;
    L77:
        if (hasTotalDataSize() == false) goto L82;
        if (getTotalDataSize() == r11.getTotalDataSize()) goto L82;
        return false;
    L82:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L84;
        return false;
    L84:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public String getAppId() {
        Object r10 = this.appId_;
        if ((r10 instanceof String) == true) goto L5;
        ByteString r11 = (ByteString) r10;
        String r12 = r11.toStringUtf8();
        if (r11.isValidUtf8() == false) goto L9;
        this.appId_ = r12;
    L9:
        return r12;
    L5:
        return (String) r10;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public ByteString getAppIdBytes() {
        Object r10 = this.appId_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.appId_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public NormalTrace getDefaultInstanceForType() {
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

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getErrCode() {
        return this.errCode_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getEventId() {
        return this.eventId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getModuleId() {
        return this.moduleId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
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

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
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
    public Parser<NormalTrace> getParserForType() {
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
        r11 = r11 + GeneratedMessage.computeStringSize(4, this.appId_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r11 = r11 + CodedOutputStream.computeUInt32Size(5, this.userid_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r11 = r11 + CodedOutputStream.computeInt32Size(6, this.errCode_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r11 = r11 + CodedOutputStream.computeInt32Size(7, this.totalCalls_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r11 = r11 + CodedOutputStream.computeUInt64Size(8, this.timeConsumption_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L32;
        r11 = r11 + CodedOutputStream.computeUInt64Size(9, this.totalDataSize_);
    L32:
        int r12 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public long getTimeConsumption() {
        return this.timeConsumption_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getTotalCalls() {
        return this.totalCalls_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public long getTotalDataSize() {
        return this.totalDataSize_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getUserid() {
        return this.userid_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasAppId() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasErrCode() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasEventId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasModuleId() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasPackageName() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasTimeConsumption() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasTotalCalls() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasTotalDataSize() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasUserid() {
        if ((this.bitField0_ & 16) == 0) goto L5;
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
        if (hasAppId() == false) goto L18;
        r11 = (((r11 * 37) + 4) * 53) + getAppId().hashCode();
    L18:
        if (hasUserid() == false) goto L21;
        r11 = (((r11 * 37) + 5) * 53) + getUserid();
    L21:
        if (hasErrCode() == false) goto L24;
        r11 = (((r11 * 37) + 6) * 53) + getErrCode();
    L24:
        if (hasTotalCalls() == false) goto L27;
        r11 = (((r11 * 37) + 7) * 53) + getTotalCalls();
    L27:
        if (hasTimeConsumption() == false) goto L30;
        r11 = (((r11 * 37) + 8) * 53) + Internal.hashLong(getTimeConsumption());
    L30:
        if (hasTotalDataSize() == false) goto L32;
        r11 = (((r11 * 37) + 9) * 53) + Internal.hashLong(getTotalDataSize());
    L32:
        int r12 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(NormalTrace.class, Builder.class);
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
        GeneratedMessage.writeString(r10, 4, this.appId_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r10.writeUInt32(5, this.userid_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r10.writeInt32(6, this.errCode_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r10.writeInt32(7, this.totalCalls_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r10.writeUInt64(8, this.timeConsumption_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L29;
        r10.writeUInt64(9, this.totalDataSize_);
    L29:
        getUnknownFields().writeTo(r10);
    }
}
