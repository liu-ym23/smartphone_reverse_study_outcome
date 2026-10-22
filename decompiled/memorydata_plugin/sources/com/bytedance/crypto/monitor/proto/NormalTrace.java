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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
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

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.packageName_ = "";
            this.appId_ = "";
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        private void buildPartial0(NormalTrace r5) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L5;
            NormalTrace.access$302(r5, this.moduleId_);
            int r1 = 1;
        L7:
            if ((r0 & 2) == 0) goto L10;
            NormalTrace.access$402(r5, this.eventId_);
            r1 = r1 | 2;
        L10:
            if ((r0 & 4) == 0) goto L13;
            NormalTrace.access$502(r5, this.packageName_);
            r1 = r1 | 4;
        L13:
            if ((r0 & 8) == 0) goto L16;
            NormalTrace.access$602(r5, this.appId_);
            r1 = r1 | 8;
        L16:
            if ((r0 & 16) == 0) goto L19;
            NormalTrace.access$702(r5, this.userid_);
            r1 = r1 | 16;
        L19:
            if ((r0 & 32) == 0) goto L22;
            NormalTrace.access$802(r5, this.errCode_);
            r1 = r1 | 32;
        L22:
            if ((r0 & 64) == 0) goto L25;
            NormalTrace.access$902(r5, this.totalCalls_);
            r1 = r1 | 64;
        L25:
            if ((r0 & 128) == 0) goto L28;
            NormalTrace.access$1002(r5, this.timeConsumption_);
            r1 = r1 | 128;
        L28:
            if ((r0 & 256) == 0) goto L30;
            NormalTrace.access$1102(r5, this.totalDataSize_);
            r1 = r1 | 256;
        L30:
            NormalTrace.access$1276(r5, r1);
            return;
        L5:
            r1 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NormalTrace build() {
            NormalTrace r1 = buildPartial();
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
        public NormalTrace buildPartial() {
            NormalTrace r0 = new NormalTrace(this, null);
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
            Object r0 = this.appId_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L9;
            ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L7;
            this.appId_ = r2;
        L7:
            return r2;
        L9:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public ByteString getAppIdBytes() {
            Object r0 = this.appId_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.appId_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public ByteString getPackageNameBytes() {
            Object r0 = this.packageName_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.packageName_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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

        public Builder mergeFrom(NormalTrace r3) {
            if (r3 != NormalTrace.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r3.hasModuleId() == false) goto L9;
            setModuleId(r3.getModuleId());
        L9:
            if (r3.hasEventId() == false) goto L12;
            setEventId(r3.getEventId());
        L12:
            if (r3.hasPackageName() == false) goto L15;
            this.packageName_ = NormalTrace.access$500(r3);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r3.hasAppId() == false) goto L18;
            this.appId_ = NormalTrace.access$600(r3);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r3.hasUserid() == false) goto L21;
            setUserid(r3.getUserid());
        L21:
            if (r3.hasErrCode() == false) goto L24;
            setErrCode(r3.getErrCode());
        L24:
            if (r3.hasTotalCalls() == false) goto L27;
            setTotalCalls(r3.getTotalCalls());
        L27:
            if (r3.hasTimeConsumption() == false) goto L30;
            setTimeConsumption(r3.getTimeConsumption());
        L30:
            if (r3.hasTotalDataSize() == false) goto L32;
            setTotalDataSize(r3.getTotalDataSize());
        L32:
            mergeUnknownFields(r3.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r7, ExtensionRegistryLite r8) {
            r8.getClass();
            boolean r1 = false;
        L3:
            if (r1 == true) goto L46;
            int r2 = r7.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r2 == 0) goto L38;
            if (r2 == 8) goto L35;
            int r4 = 16;
            if (r2 == 16) goto L34;
            if (r2 == 26) goto L33;
            if (r2 == 34) goto L32;
            if (r2 == 40) goto L30;
            if (r2 == 48) goto L29;
            r4 = 64;
            if (r2 == 56) goto L28;
            if (r2 == 64) goto L27;
            if (r2 != 72) goto L24;
            this.totalDataSize_ = r7.readUInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            int r3 = this.bitField0_ | 256;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L36:
            this.bitField0_ = r3;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L24:
            if (parseUnknownField(r7, r8, r2) == true) goto L3;
        L27:
            this.timeConsumption_ = r7.readUInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r3 = this.bitField0_ | 128;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L28:
            this.totalCalls_ = r7.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L31:
            r3 = this.bitField0_ | r4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L29:
            this.errCode_ = r7.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r3 = this.bitField0_ | 32;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L30:
            this.userid_ = r7.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L31
        L32:
            this.appId_ = r7.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r3 = this.bitField0_ | 8;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L33:
            this.packageName_ = r7.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r3 = this.bitField0_ | 4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L34:
            this.eventId_ = r7.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r3 = this.bitField0_ | 2;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L35:
            this.moduleId_ = r7.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r3 = this.bitField0_ | 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L38:
            r1 = true;
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
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, NormalTrace.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((NormalTrace) ZeusTransformUtils.preCheckCast(r4, NormalTrace.class, "com.obric.memorydata.plugin"));
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

        public Builder setAppId(String r1) {
            r1.getClass();
            this.appId_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setAppIdBytes(ByteString r1) {
            r1.getClass();
            this.appId_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setErrCode(int r1) {
            this.errCode_ = r1;
            this.bitField0_ |= 32;
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

        public Builder setTimeConsumption(long r1) {
            this.timeConsumption_ = r1;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setTotalCalls(int r1) {
            this.totalCalls_ = r1;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTotalDataSize(long r1) {
            this.totalDataSize_ = r1;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setUserid(int r1) {
            this.userid_ = r1;
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

    private NormalTrace(GeneratedMessage.Builder<?> r3) {
        super(r3);
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

    public /* synthetic */ NormalTrace(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ long access$1002(NormalTrace r0, long r1) {
        r0.timeConsumption_ = r1;
        return r1;
    }

    public static /* synthetic */ long access$1102(NormalTrace r0, long r1) {
        r0.totalDataSize_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$1276(NormalTrace r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    public static /* synthetic */ int access$302(NormalTrace r0, int r1) {
        r0.moduleId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(NormalTrace r0, int r1) {
        r0.eventId_ = r1;
        return r1;
    }

    public static /* synthetic */ Object access$500(NormalTrace r0) {
        return r0.packageName_;
    }

    public static /* synthetic */ Object access$502(NormalTrace r0, Object r1) {
        r0.packageName_ = r1;
        return r1;
    }

    public static /* synthetic */ Object access$600(NormalTrace r0) {
        return r0.appId_;
    }

    public static /* synthetic */ Object access$602(NormalTrace r0, Object r1) {
        r0.appId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$702(NormalTrace r0, int r1) {
        r0.userid_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$802(NormalTrace r0, int r1) {
        r0.errCode_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$902(NormalTrace r0, int r1) {
        r0.totalCalls_ = r1;
        return r1;
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

    public static Builder newBuilder(NormalTrace r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static NormalTrace parseDelimitedFrom(InputStream r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(ByteString r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(CodedInputStream r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(InputStream r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(ByteBuffer r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(byte[] r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static NormalTrace parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (NormalTrace) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), NormalTrace.class, "com.obric.memorydata.plugin");
    }

    public static Parser<NormalTrace> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, NormalTrace.class) == false) goto L8;
        NormalTrace r10 = (NormalTrace) ZeusTransformUtils.preCheckCast(r9, NormalTrace.class, "com.obric.memorydata.plugin");
        if (hasModuleId() == r10.hasModuleId()) goto L13;
        return false;
    L13:
        if (hasModuleId() == false) goto L18;
        if (getModuleId() == r10.getModuleId()) goto L18;
        return false;
    L18:
        if (hasEventId() == r10.hasEventId()) goto L21;
        return false;
    L21:
        if (hasEventId() == false) goto L26;
        if (getEventId() == r10.getEventId()) goto L26;
        return false;
    L26:
        if (hasPackageName() == r10.hasPackageName()) goto L29;
        return false;
    L29:
        if (hasPackageName() == false) goto L34;
        if (getPackageName().equals(r10.getPackageName()) == true) goto L34;
        return false;
    L34:
        if (hasAppId() == r10.hasAppId()) goto L37;
        return false;
    L37:
        if (hasAppId() == false) goto L42;
        if (getAppId().equals(r10.getAppId()) == true) goto L42;
        return false;
    L42:
        if (hasUserid() == r10.hasUserid()) goto L45;
        return false;
    L45:
        if (hasUserid() == false) goto L50;
        if (getUserid() == r10.getUserid()) goto L50;
        return false;
    L50:
        if (hasErrCode() == r10.hasErrCode()) goto L53;
        return false;
    L53:
        if (hasErrCode() == false) goto L58;
        if (getErrCode() == r10.getErrCode()) goto L58;
        return false;
    L58:
        if (hasTotalCalls() == r10.hasTotalCalls()) goto L61;
        return false;
    L61:
        if (hasTotalCalls() == false) goto L66;
        if (getTotalCalls() == r10.getTotalCalls()) goto L66;
        return false;
    L66:
        if (hasTimeConsumption() == r10.hasTimeConsumption()) goto L69;
        return false;
    L69:
        if (hasTimeConsumption() == false) goto L74;
        if (getTimeConsumption() == r10.getTimeConsumption()) goto L74;
        return false;
    L74:
        if (hasTotalDataSize() == r10.hasTotalDataSize()) goto L77;
        return false;
    L77:
        if (hasTotalDataSize() == false) goto L82;
        if (getTotalDataSize() == r10.getTotalDataSize()) goto L82;
        return false;
    L82:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L84;
        return false;
    L84:
        return true;
    L8:
        return super.equals(r9);
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public String getAppId() {
        Object r0 = this.appId_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        String r2 = r1.toStringUtf8();
        if (r1.isValidUtf8() == false) goto L9;
        this.appId_ = r2;
    L9:
        return r2;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public ByteString getAppIdBytes() {
        Object r0 = this.appId_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.appId_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
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
    public Parser<NormalTrace> getParserForType() {
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
        r1 = r1 + GeneratedMessage.computeStringSize(4, this.appId_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r1 = r1 + CodedOutputStream.computeUInt32Size(5, this.userid_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r1 = r1 + CodedOutputStream.computeInt32Size(6, this.errCode_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r1 = r1 + CodedOutputStream.computeInt32Size(7, this.totalCalls_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r1 = r1 + CodedOutputStream.computeUInt64Size(8, this.timeConsumption_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L32;
        r1 = r1 + CodedOutputStream.computeUInt64Size(9, this.totalDataSize_);
    L32:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
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
        if (hasAppId() == false) goto L18;
        r1 = (((r1 * 37) + 4) * 53) + getAppId().hashCode();
    L18:
        if (hasUserid() == false) goto L21;
        r1 = (((r1 * 37) + 5) * 53) + getUserid();
    L21:
        if (hasErrCode() == false) goto L24;
        r1 = (((r1 * 37) + 6) * 53) + getErrCode();
    L24:
        if (hasTotalCalls() == false) goto L27;
        r1 = (((r1 * 37) + 7) * 53) + getTotalCalls();
    L27:
        if (hasTimeConsumption() == false) goto L30;
        r1 = (((r1 * 37) + 8) * 53) + Internal.hashLong(getTimeConsumption());
    L30:
        if (hasTotalDataSize() == false) goto L32;
        r1 = (((r1 * 37) + 9) * 53) + Internal.hashLong(getTotalDataSize());
    L32:
        int r2 = (r1 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r2;
        return r2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(NormalTrace.class, Builder.class);
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
        GeneratedMessage.writeString(r4, 4, this.appId_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r4.writeUInt32(5, this.userid_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r4.writeInt32(6, this.errCode_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r4.writeInt32(7, this.totalCalls_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r4.writeUInt64(8, this.timeConsumption_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L29;
        r4.writeUInt64(9, this.totalDataSize_);
    L29:
        getUnknownFields().writeTo(r4);
    }
}
