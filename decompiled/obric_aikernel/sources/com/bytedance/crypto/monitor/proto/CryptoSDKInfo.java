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
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CryptoSDKInfo extends GeneratedMessage implements CryptoSDKInfoOrBuilder {
    private static final CryptoSDKInfo DEFAULT_INSTANCE = null;
    public static final int ERROR_TRACE_FIELD_NUMBER = 5;
    public static final int NORMAL_TRACE_FIELD_NUMBER = 4;
    private static final Parser<CryptoSDKInfo> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    public static final int TRAIN_NUM_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<ErrorTrace> errorTrace_;
    private byte memoizedIsInitialized;
    private List<NormalTrace> normalTrace_;
    private long timestamp_;
    private int trainNum_;
    private int version_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CryptoSDKInfoOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> errorTraceBuilder_;
        private List<ErrorTrace> errorTrace_;
        private RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> normalTraceBuilder_;
        private List<NormalTrace> normalTrace_;
        private long timestamp_;
        private int trainNum_;
        private int version_;

        private Builder() {
            this.normalTrace_ = Collections.emptyList();
            this.errorTrace_ = Collections.emptyList();
        }

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.normalTrace_ = Collections.emptyList();
            this.errorTrace_ = Collections.emptyList();
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void buildPartial0(CryptoSDKInfo r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L5;
            CryptoSDKInfo.access$502(r10, this.version_);
            int r12 = 1;
        L7:
            if ((r11 & 2) == 0) goto L10;
            CryptoSDKInfo.access$602(r10, this.trainNum_);
            r12 = r12 | 2;
        L10:
            if ((r11 & 4) == 0) goto L12;
            CryptoSDKInfo.access$702(r10, this.timestamp_);
            r12 = r12 | 4;
        L12:
            CryptoSDKInfo.access$876(r10, r12);
            return;
        L5:
            r12 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(CryptoSDKInfo r10) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r11 = this.normalTraceBuilder_;
            if (r11 == null) goto L5;
            List r12 = r11.build();
        L9:
            CryptoSDKInfo.access$302(r10, r12);
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r13 = this.errorTraceBuilder_;
            if (r13 == null) goto L12;
            List r14 = r13.build();
        L16:
            CryptoSDKInfo.access$402(r10, r14);
            return;
        L12:
            if ((this.bitField0_ & 16) == 0) goto L14;
            this.errorTrace_ = Collections.unmodifiableList(this.errorTrace_);
            this.bitField0_ &= -17;
        L14:
            r14 = this.errorTrace_;
            goto L16
        L5:
            if ((this.bitField0_ & 8) == 0) goto L7;
            this.normalTrace_ = Collections.unmodifiableList(this.normalTrace_);
            this.bitField0_ &= -9;
        L7:
            r12 = this.normalTrace_;
            goto L9
        }

        private void ensureErrorTraceIsMutable() {
            if ((this.bitField0_ & 16) != 0) goto L6;
            this.errorTrace_ = new ArrayList(this.errorTrace_);
            this.bitField0_ |= 16;
            return;
        }

        private void ensureNormalTraceIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.normalTrace_ = new ArrayList(this.normalTrace_);
            this.bitField0_ |= 8;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
        }

        private RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> internalGetErrorTraceFieldBuilder() {
            if (this.errorTraceBuilder_ != null) goto L10;
            List<ErrorTrace> r10 = this.errorTrace_;
            if ((this.bitField0_ & 16) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.errorTraceBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.errorTrace_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.errorTraceBuilder_;
        }

        private RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> internalGetNormalTraceFieldBuilder() {
            if (this.normalTraceBuilder_ != null) goto L10;
            List<NormalTrace> r10 = this.normalTrace_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.normalTraceBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.normalTrace_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.normalTraceBuilder_;
        }

        public Builder addAllErrorTrace(Iterable<? extends ErrorTrace> r10) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = this.errorTraceBuilder_;
            if (r11 != null) goto L5;
            ensureErrorTraceIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.errorTrace_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addAllNormalTrace(Iterable<? extends NormalTrace> r10) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r11 = this.normalTraceBuilder_;
            if (r11 != null) goto L5;
            ensureNormalTraceIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.normalTrace_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addErrorTrace(int r10, ErrorTrace.Builder r11) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r12 = this.errorTraceBuilder_;
            if (r12 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addErrorTrace(int r10, ErrorTrace r11) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r12 = this.errorTraceBuilder_;
            if (r12 != null) goto L5;
            r11.getClass();
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addErrorTrace(ErrorTrace.Builder r10) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = this.errorTraceBuilder_;
            if (r11 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addErrorTrace(ErrorTrace r10) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = this.errorTraceBuilder_;
            if (r11 != null) goto L5;
            r10.getClass();
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public ErrorTrace.Builder addErrorTraceBuilder() {
            return (ErrorTrace.Builder) internalGetErrorTraceFieldBuilder().addBuilder(ErrorTrace.getDefaultInstance());
        }

        public ErrorTrace.Builder addErrorTraceBuilder(int r10) {
            return (ErrorTrace.Builder) internalGetErrorTraceFieldBuilder().addBuilder(r10, ErrorTrace.getDefaultInstance());
        }

        public Builder addNormalTrace(int r10, NormalTrace.Builder r11) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r12 = this.normalTraceBuilder_;
            if (r12 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addNormalTrace(int r10, NormalTrace r11) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r12 = this.normalTraceBuilder_;
            if (r12 != null) goto L5;
            r11.getClass();
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addNormalTrace(NormalTrace.Builder r10) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r11 = this.normalTraceBuilder_;
            if (r11 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addNormalTrace(NormalTrace r10) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r11 = this.normalTraceBuilder_;
            if (r11 != null) goto L5;
            r10.getClass();
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public NormalTrace.Builder addNormalTraceBuilder() {
            return (NormalTrace.Builder) internalGetNormalTraceFieldBuilder().addBuilder(NormalTrace.getDefaultInstance());
        }

        public NormalTrace.Builder addNormalTraceBuilder(int r10) {
            return (NormalTrace.Builder) internalGetNormalTraceFieldBuilder().addBuilder(r10, NormalTrace.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CryptoSDKInfo build() {
            CryptoSDKInfo r10 = buildPartial();
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
        public CryptoSDKInfo buildPartial() {
            CryptoSDKInfo r10 = new CryptoSDKInfo(this, null);
            buildPartialRepeatedFields(r10);
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
            this.version_ = 0;
            this.trainNum_ = 0;
            this.timestamp_ = 0;
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r10 = this.normalTraceBuilder_;
            if (r10 != null) goto L5;
            this.normalTrace_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -9;
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = this.errorTraceBuilder_;
            if (r11 != null) goto L9;
            this.errorTrace_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -17;
            return this;
        L9:
            this.errorTrace_ = null;
            r11.clear();
            goto L10
        L5:
            this.normalTrace_ = null;
            r10.clear();
            goto L6
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

        public Builder clearErrorTrace() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r10 = this.errorTraceBuilder_;
            if (r10 != null) goto L5;
            this.errorTrace_ = Collections.emptyList();
            this.bitField0_ &= -17;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearNormalTrace() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r10 = this.normalTraceBuilder_;
            if (r10 != null) goto L5;
            this.normalTrace_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -5;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTrainNum() {
            this.bitField0_ &= -3;
            this.trainNum_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.bitField0_ &= -2;
            this.version_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CryptoSDKInfo getDefaultInstanceForType() {
            return CryptoSDKInfo.getDefaultInstance();
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
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public ErrorTrace getErrorTrace(int r10) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = this.errorTraceBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.errorTrace_.get(r10);
        L6:
            return (ErrorTrace) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public ErrorTrace.Builder getErrorTraceBuilder(int r10) {
            return (ErrorTrace.Builder) internalGetErrorTraceFieldBuilder().getBuilder(r10);
        }

        public List<ErrorTrace.Builder> getErrorTraceBuilderList() {
            return internalGetErrorTraceFieldBuilder().getBuilderList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getErrorTraceCount() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r10 = this.errorTraceBuilder_;
            if (r10 != null) goto L7;
            return this.errorTrace_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<ErrorTrace> getErrorTraceList() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r10 = this.errorTraceBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.errorTrace_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public ErrorTraceOrBuilder getErrorTraceOrBuilder(int r10) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = this.errorTraceBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.errorTrace_.get(r10);
        L6:
            return (ErrorTraceOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r10 = this.errorTraceBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.errorTrace_);
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public NormalTrace getNormalTrace(int r10) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r11 = this.normalTraceBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.normalTrace_.get(r10);
        L6:
            return (NormalTrace) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public NormalTrace.Builder getNormalTraceBuilder(int r10) {
            return (NormalTrace.Builder) internalGetNormalTraceFieldBuilder().getBuilder(r10);
        }

        public List<NormalTrace.Builder> getNormalTraceBuilderList() {
            return internalGetNormalTraceFieldBuilder().getBuilderList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getNormalTraceCount() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r10 = this.normalTraceBuilder_;
            if (r10 != null) goto L7;
            return this.normalTrace_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<NormalTrace> getNormalTraceList() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r10 = this.normalTraceBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.normalTrace_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public NormalTraceOrBuilder getNormalTraceOrBuilder(int r10) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r11 = this.normalTraceBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.normalTrace_.get(r10);
        L6:
            return (NormalTraceOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r10 = this.normalTraceBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.normalTrace_);
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getTrainNum() {
            return this.trainNum_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasTrainNum() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasVersion() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CryptoSDKInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CryptoSDKInfo r10) {
            if (r10 != CryptoSDKInfo.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.hasVersion() == false) goto L9;
            setVersion(r10.getVersion());
        L9:
            if (r10.hasTrainNum() == false) goto L12;
            setTrainNum(r10.getTrainNum());
        L12:
            if (r10.hasTimestamp() == false) goto L14;
            setTimestamp(r10.getTimestamp());
        L14:
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = null;
            if (this.normalTraceBuilder_ != null) goto L24;
            if (CryptoSDKInfo.access$300(r10).isEmpty() == true) goto L34;
            if (this.normalTrace_.isEmpty() == false) goto L21;
            this.normalTrace_ = CryptoSDKInfo.access$300(r10);
            this.bitField0_ &= -9;
        L22:
            onChanged();
            goto L34
        L21:
            ensureNormalTraceIsMutable();
            this.normalTrace_.addAll(CryptoSDKInfo.access$300(r10));
        L34:
            if (this.errorTraceBuilder_ != null) goto L43;
            if (CryptoSDKInfo.access$400(r10).isEmpty() == false) goto L38;
        L51:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L38:
            if (this.errorTrace_.isEmpty() == false) goto L40;
            this.errorTrace_ = CryptoSDKInfo.access$400(r10);
            this.bitField0_ &= -17;
        L41:
            onChanged();
            goto L51
        L40:
            ensureErrorTraceIsMutable();
            this.errorTrace_.addAll(CryptoSDKInfo.access$400(r10));
            goto L41
        L43:
            if (CryptoSDKInfo.access$400(r10).isEmpty() == true) goto L51;
            if (this.errorTraceBuilder_.isEmpty() == false) goto L50;
            this.errorTraceBuilder_.dispose();
            this.errorTraceBuilder_ = null;
            this.errorTrace_ = CryptoSDKInfo.access$400(r10);
            this.bitField0_ &= -17;
            if (CryptoSDKInfo.access$1000() == false) goto L49;
            r11 = internalGetErrorTraceFieldBuilder();
        L49:
            this.errorTraceBuilder_ = r11;
            goto L51
        L50:
            this.errorTraceBuilder_.addAllMessages(CryptoSDKInfo.access$400(r10));
            goto L51
        L24:
            if (CryptoSDKInfo.access$300(r10).isEmpty() == true) goto L34;
            if (this.normalTraceBuilder_.isEmpty() == false) goto L32;
            this.normalTraceBuilder_.dispose();
            this.normalTraceBuilder_ = null;
            this.normalTrace_ = CryptoSDKInfo.access$300(r10);
            this.bitField0_ &= -9;
            if (CryptoSDKInfo.access$900() == false) goto L30;
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r12 = internalGetNormalTraceFieldBuilder();
        L31:
            this.normalTraceBuilder_ = r12;
            goto L34
        L30:
            r12 = null;
            goto L31
        L32:
            this.normalTraceBuilder_.addAllMessages(CryptoSDKInfo.access$300(r10));
            goto L34
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            r11.getClass();
            boolean r12 = false;
        L3:
            if (r12 == true) goto L40;
            int r13 = r10.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r13 == 0) goto L32;
            if (r13 == 8) goto L29;
            if (r13 == 16) goto L28;
            if (r13 != 24) goto L13;
            this.timestamp_ = r10.readInt64();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            int r14 = this.bitField0_ | 4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L30:
            this.bitField0_ = r14;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L13:
            if (r13 == 34) goto L22;
            if (r13 != 42) goto L17;
            MessageLite r15 = (ErrorTrace) r10.readMessage(ErrorTrace.parser(), r11);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            RepeatedFieldBuilder r16 = this.errorTraceBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r16 == null) goto L21;
        L26:
            r16.addMessage(r15);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L21:
            ensureErrorTraceIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            List r17 = this.errorTrace_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L25:
            r17.add(r15);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L17:
            if (parseUnknownField(r10, r11, r13) == true) goto L3;
        L22:
            r15 = (NormalTrace) r10.readMessage(NormalTrace.parser(), r11);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r16 = this.normalTraceBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r16 != null) goto L26;
            ensureNormalTraceIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r17 = this.normalTrace_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L25
        L28:
            this.trainNum_ = r10.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r14 = this.bitField0_ | 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L30
        L29:
            this.version_ = r10.readInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r14 = this.bitField0_ | 1;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L32:
            r12 = true;
            goto L3
        L35:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            onChanged();
            throw th;
        L40:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof CryptoSDKInfo) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((CryptoSDKInfo) r10);
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

        public Builder removeErrorTrace(int r10) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r11 = this.errorTraceBuilder_;
            if (r11 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder removeNormalTrace(int r10) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r11 = this.normalTraceBuilder_;
            if (r11 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder setErrorTrace(int r10, ErrorTrace.Builder r11) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r12 = this.errorTraceBuilder_;
            if (r12 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setErrorTrace(int r10, ErrorTrace r11) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r12 = this.errorTraceBuilder_;
            if (r12 != null) goto L5;
            r11.getClass();
            ensureErrorTraceIsMutable();
            this.errorTrace_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }

        public Builder setNormalTrace(int r10, NormalTrace.Builder r11) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r12 = this.normalTraceBuilder_;
            if (r12 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setNormalTrace(int r10, NormalTrace r11) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r12 = this.normalTraceBuilder_;
            if (r12 != null) goto L5;
            r11.getClass();
            ensureNormalTraceIsMutable();
            this.normalTrace_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }

        public Builder setTimestamp(long r10) {
            this.timestamp_ = r10;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setTrainNum(int r10) {
            this.trainNum_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setVersion(int r10) {
            this.version_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CryptoSDKInfo.class.getName());
        DEFAULT_INSTANCE = new CryptoSDKInfo();
        PARSER = new AnonymousClass1();
    }

    private CryptoSDKInfo() {
        this.version_ = 0;
        this.trainNum_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
        this.normalTrace_ = Collections.emptyList();
        this.errorTrace_ = Collections.emptyList();
    }

    private CryptoSDKInfo(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.version_ = 0;
        this.trainNum_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ CryptoSDKInfo(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ boolean access$1000() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$300(CryptoSDKInfo r10) {
        return r10.normalTrace_;
    }

    public static /* synthetic */ List access$302(CryptoSDKInfo r10, List r11) {
        r10.normalTrace_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$400(CryptoSDKInfo r10) {
        return r10.errorTrace_;
    }

    public static /* synthetic */ List access$402(CryptoSDKInfo r10, List r11) {
        r10.errorTrace_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$502(CryptoSDKInfo r10, int r11) {
        r10.version_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$602(CryptoSDKInfo r10, int r11) {
        r10.trainNum_ = r11;
        return r11;
    }

    public static /* synthetic */ long access$702(CryptoSDKInfo r10, long r11) {
        r10.timestamp_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$876(CryptoSDKInfo r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    public static /* synthetic */ boolean access$900() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static CryptoSDKInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CryptoSDKInfo r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static CryptoSDKInfo parseDelimitedFrom(InputStream r10) {
        return (CryptoSDKInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static CryptoSDKInfo parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (CryptoSDKInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static CryptoSDKInfo parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static CryptoSDKInfo parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static CryptoSDKInfo parseFrom(CodedInputStream r10) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static CryptoSDKInfo parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static CryptoSDKInfo parseFrom(InputStream r10) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static CryptoSDKInfo parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static CryptoSDKInfo parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static CryptoSDKInfo parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static CryptoSDKInfo parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static CryptoSDKInfo parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<CryptoSDKInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof CryptoSDKInfo) == false) goto L8;
        CryptoSDKInfo r11 = (CryptoSDKInfo) r10;
        if (hasVersion() == r11.hasVersion()) goto L13;
        return false;
    L13:
        if (hasVersion() == false) goto L18;
        if (getVersion() == r11.getVersion()) goto L18;
        return false;
    L18:
        if (hasTrainNum() == r11.hasTrainNum()) goto L21;
        return false;
    L21:
        if (hasTrainNum() == false) goto L26;
        if (getTrainNum() == r11.getTrainNum()) goto L26;
        return false;
    L26:
        if (hasTimestamp() == r11.hasTimestamp()) goto L29;
        return false;
    L29:
        if (hasTimestamp() == false) goto L34;
        if (getTimestamp() == r11.getTimestamp()) goto L34;
        return false;
    L34:
        if (getNormalTraceList().equals(r11.getNormalTraceList()) == true) goto L37;
        return false;
    L37:
        if (getErrorTraceList().equals(r11.getErrorTraceList()) == true) goto L40;
        return false;
    L40:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CryptoSDKInfo getDefaultInstanceForType() {
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

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public ErrorTrace getErrorTrace(int r10) {
        return this.errorTrace_.get(r10);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getErrorTraceCount() {
        return this.errorTrace_.size();
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<ErrorTrace> getErrorTraceList() {
        return this.errorTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public ErrorTraceOrBuilder getErrorTraceOrBuilder(int r10) {
        return this.errorTrace_.get(r10);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList() {
        return this.errorTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public NormalTrace getNormalTrace(int r10) {
        return this.normalTrace_.get(r10);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getNormalTraceCount() {
        return this.normalTrace_.size();
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<NormalTrace> getNormalTraceList() {
        return this.normalTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public NormalTraceOrBuilder getNormalTraceOrBuilder(int r10) {
        return this.normalTrace_.get(r10);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList() {
        return this.normalTrace_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CryptoSDKInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r12 = CodedOutputStream.computeInt32Size(1, this.version_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r12 = r12 + CodedOutputStream.computeUInt32Size(2, this.trainNum_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r12 = r12 + CodedOutputStream.computeInt64Size(3, this.timestamp_);
    L15:
        int r13 = 0;
    L17:
        if (r13 >= this.normalTrace_.size()) goto L20;
        r12 = r12 + CodedOutputStream.computeMessageSize(4, this.normalTrace_.get(r13));
        r13 = r13 + 1;
    L20:
        if (r11 >= this.errorTrace_.size()) goto L22;
        r12 = r12 + CodedOutputStream.computeMessageSize(5, this.errorTrace_.get(r11));
        r11 = r11 + 1;
        goto L20
    L22:
        int r14 = r12 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r14;
        return r14;
    L8:
        r12 = 0;
        goto L10
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getTrainNum() {
        return this.trainNum_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasTrainNum() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasVersion() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = getDescriptor().hashCode() + 779;
        if (hasVersion() == false) goto L9;
        r11 = (((r11 * 37) + 1) * 53) + getVersion();
    L9:
        if (hasTrainNum() == false) goto L12;
        r11 = (((r11 * 37) + 2) * 53) + getTrainNum();
    L12:
        if (hasTimestamp() == false) goto L15;
        r11 = (((r11 * 37) + 3) * 53) + Internal.hashLong(getTimestamp());
    L15:
        if (getNormalTraceCount() <= 0) goto L18;
        r11 = (((r11 * 37) + 4) * 53) + getNormalTraceList().hashCode();
    L18:
        if (getErrorTraceCount() <= 0) goto L20;
        r11 = (((r11 * 37) + 5) * 53) + getErrorTraceList().hashCode();
    L20:
        int r12 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CryptoSDKInfo.class, Builder.class);
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
        r10.writeInt32(1, this.version_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r10.writeUInt32(2, this.trainNum_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L11;
        r10.writeInt64(3, this.timestamp_);
    L11:
        int r11 = 0;
        int r12 = 0;
    L13:
        if (r12 >= this.normalTrace_.size()) goto L16;
        r10.writeMessage(4, this.normalTrace_.get(r12));
        r12 = r12 + 1;
    L16:
        if (r11 >= this.errorTrace_.size()) goto L18;
        r10.writeMessage(5, this.errorTrace_.get(r11));
        r11 = r11 + 1;
        goto L16
    L18:
        getUnknownFields().writeTo(r10);
    }
}
