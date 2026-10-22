package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class Method extends GeneratedMessage implements MethodOrBuilder {
    private static final Method DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static final Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private boolean requestStreaming_;
    private volatile Object requestTypeUrl_;
    private boolean responseStreaming_;
    private volatile Object responseTypeUrl_;
    private int syntax_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements MethodOrBuilder {
        private int bitField0_;
        private Object name_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private boolean requestStreaming_;
        private Object requestTypeUrl_;
        private boolean responseStreaming_;
        private Object responseTypeUrl_;
        private int syntax_;

        private Builder() {
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.responseTypeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.responseTypeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(Method r3) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L6;
            Method.access$402(r3, this.name_);
        L6:
            if ((r0 & 2) == 0) goto L9;
            Method.access$502(r3, this.requestTypeUrl_);
        L9:
            if ((r0 & 4) == 0) goto L12;
            Method.access$602(r3, this.requestStreaming_);
        L12:
            if ((r0 & 8) == 0) goto L15;
            Method.access$702(r3, this.responseTypeUrl_);
        L15:
            if ((r0 & 16) == 0) goto L18;
            Method.access$802(r3, this.responseStreaming_);
        L18:
            if ((r0 & 64) == 0) goto L21;
            Method.access$902(r3, this.syntax_);
            return;
        }

        private void buildPartialRepeatedFields(Method r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L5;
            List r1 = r0.build();
        L9:
            Method.access$302(r2, r1);
            return;
        L5:
            if ((this.bitField0_ & 32) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -33;
        L7:
            r1 = this.options_;
            goto L9
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 32) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 32;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApiProto.internal_static_google_protobuf_Method_descriptor;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r1 = this.options_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.optionsBuilder_;
        }

        public Builder addAllOptions(Iterable<? extends Option> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addOptions(Option.Builder r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addOptions(Option r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureOptionsIsMutable();
            this.options_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance()), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        public Option.Builder addOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(r2, Option.getDefaultInstance()), Option.Builder.class, "com.obric.memorydata.plugin");
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
        public Method build() {
            Method r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
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
        public Method buildPartial() {
            Method r0 = new Method(this, null);
            buildPartialRepeatedFields(r0);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
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

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.requestStreaming_ = false;
            this.responseTypeUrl_ = "";
            this.responseStreaming_ = false;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r1 = this.optionsBuilder_;
            if (r1 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            return this;
        L5:
            this.options_ = null;
            r1.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Method.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder clearRequestStreaming() {
            this.bitField0_ &= -5;
            this.requestStreaming_ = false;
            onChanged();
            return this;
        }

        public Builder clearRequestTypeUrl() {
            this.requestTypeUrl_ = Method.getDefaultInstance().getRequestTypeUrl();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearResponseStreaming() {
            this.bitField0_ &= -17;
            this.responseStreaming_ = false;
            onChanged();
            return this;
        }

        public Builder clearResponseTypeUrl() {
            this.responseTypeUrl_ = Method.getDefaultInstance().getResponseTypeUrl();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -65;
            this.syntax_ = 0;
            onChanged();
            return this;
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
        public Method getDefaultInstanceForType() {
            return Method.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Method_descriptor;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getName() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getNameBytes() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.name_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Option getOptions(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.options_.get(r3);
        L6:
            return (Option) ZeusTransformUtils.preCheckCast(r2, Option.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().getBuilder(r2), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return this.options_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.options_.get(r3);
        L6:
            return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(r2, OptionOrBuilder.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getRequestStreaming() {
            return this.requestStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getRequestTypeUrl() {
            Object r0 = this.requestTypeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.requestTypeUrl_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getRequestTypeUrlBytes() {
            Object r0 = this.requestTypeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.requestTypeUrl_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getResponseStreaming() {
            return this.responseStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getResponseTypeUrl() {
            Object r0 = this.responseTypeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.responseTypeUrl_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getResponseTypeUrlBytes() {
            Object r0 = this.responseTypeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.responseTypeUrl_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Syntax getSyntax() {
            Syntax r0 = Syntax.forNumber(this.syntax_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
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
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L42;
            int r1 = r5.readTag();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (r1 == 0) goto L34;
            if (r1 != 10) goto L9;
            this.name_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 1;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L9:
            if (r1 != 18) goto L11;
            this.requestTypeUrl_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 2;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L11:
            if (r1 != 24) goto L13;
            this.requestStreaming_ = r5.readBool();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 4;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L13:
            if (r1 != 34) goto L15;
            this.responseTypeUrl_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 8;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L15:
            if (r1 != 40) goto L17;
            this.responseStreaming_ = r5.readBool();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 16;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L17:
            if (r1 != 50) goto L19;
            Option r2 = (Option) ZeusTransformUtils.preCheckCast(r5.readMessage(Option.parser(), r6), Option.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r3 = this.optionsBuilder_;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (r3 == null) goto L26;
            r3.addMessage(r2);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L26:
            ensureOptionsIsMutable();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.options_.add(r2);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L19:
            if (r1 != 56) goto L21;
            this.syntax_ = r5.readEnum();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 64;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L21:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L34:
            r0 = true;
            goto L3
        L35:
            th = move-exception;
            onChanged();
            throw th;
        L37:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L35
        L42:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Method.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(Method r3) {
            if (r3 != Method.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r3.getName().isEmpty() == true) goto L9;
            this.name_ = Method.access$400(r3);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r3.getRequestTypeUrl().isEmpty() == true) goto L12;
            this.requestTypeUrl_ = Method.access$500(r3);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r3.getRequestStreaming() == false) goto L15;
            setRequestStreaming(r3.getRequestStreaming());
        L15:
            if (r3.getResponseTypeUrl().isEmpty() == true) goto L18;
            this.responseTypeUrl_ = Method.access$700(r3);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r3.getResponseStreaming() == false) goto L21;
            setResponseStreaming(r3.getResponseStreaming());
        L21:
            if (this.optionsBuilder_ != null) goto L30;
            if (Method.access$300(r3).isEmpty() == true) goto L39;
            if (this.options_.isEmpty() == false) goto L27;
            this.options_ = Method.access$300(r3);
            this.bitField0_ &= -33;
        L28:
            onChanged();
            goto L39
        L27:
            ensureOptionsIsMutable();
            this.options_.addAll(Method.access$300(r3));
        L39:
            if (Method.access$900(r3) == 0) goto L41;
            setSyntaxValue(r3.getSyntaxValue());
        L41:
            mergeUnknownFields(r3.getUnknownFields());
            onChanged();
            return this;
        L30:
            if (Method.access$300(r3).isEmpty() == true) goto L39;
            if (this.optionsBuilder_.isEmpty() == false) goto L37;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = null;
            this.optionsBuilder_ = null;
            this.options_ = Method.access$300(r3);
            this.bitField0_ &= -33;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L36;
            r0 = internalGetOptionsFieldBuilder();
        L36:
            this.optionsBuilder_ = r0;
            goto L39
        L37:
            this.optionsBuilder_.addAllMessages(Method.access$300(r3));
            goto L39
        }

        public Builder removeOptions(int r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder setName(String r1) {
            Objects.requireNonNull(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setRequestStreaming(boolean r1) {
            this.requestStreaming_ = r1;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setRequestTypeUrl(String r1) {
            Objects.requireNonNull(r1);
            this.requestTypeUrl_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setRequestTypeUrlBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.requestTypeUrl_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setResponseStreaming(boolean r1) {
            this.responseStreaming_ = r1;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setResponseTypeUrl(String r1) {
            Objects.requireNonNull(r1);
            this.responseTypeUrl_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setResponseTypeUrlBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.responseTypeUrl_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setSyntax(Syntax r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 64;
            this.syntax_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder setSyntaxValue(int r1) {
            this.syntax_ = r1;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Method.class.getName());
        DEFAULT_INSTANCE = new Method();
        PARSER = new AnonymousClass1();
    }

    private Method() {
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.syntax_ = 0;
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.responseTypeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    private Method(GeneratedMessage.Builder<?> r2) {
        super(r2);
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.syntax_ = 0;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Method(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ List access$300(Method r0) {
        return r0.options_;
    }

    static /* synthetic */ List access$302(Method r2, List r3) {
        List<Option> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.options_ = r4;
        return r4;
    }

    static /* synthetic */ Object access$400(Method r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$402(Method r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$500(Method r0) {
        return r0.requestTypeUrl_;
    }

    static /* synthetic */ Object access$502(Method r0, Object r1) {
        r0.requestTypeUrl_ = r1;
        return r1;
    }

    static /* synthetic */ boolean access$602(Method r0, boolean r1) {
        r0.requestStreaming_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$700(Method r0) {
        return r0.responseTypeUrl_;
    }

    static /* synthetic */ Object access$702(Method r0, Object r1) {
        r0.responseTypeUrl_ = r1;
        return r1;
    }

    static /* synthetic */ boolean access$802(Method r0, boolean r1) {
        r0.responseStreaming_ = r1;
        return r1;
    }

    static /* synthetic */ int access$900(Method r0) {
        return r0.syntax_;
    }

    static /* synthetic */ int access$902(Method r0, int r1) {
        r0.syntax_ = r1;
        return r1;
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Method r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static Method parseDelimitedFrom(InputStream r2) {
        return (Method) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Method) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(ByteString r2) {
        return (Method) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Method) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(CodedInputStream r2) {
        return (Method) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Method) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(InputStream r2) {
        return (Method) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Method) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(ByteBuffer r2) {
        return (Method) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Method) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(byte[] r2) {
        return (Method) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Method parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Method) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Method.class, "com.obric.memorydata.plugin");
    }

    public static Parser<Method> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Method.class) == false) goto L8;
        Method r6 = (Method) ZeusTransformUtils.preCheckCast(r5, Method.class, "com.obric.memorydata.plugin");
        if (getName().equals(r6.getName()) == true) goto L13;
        return false;
    L13:
        if (getRequestTypeUrl().equals(r6.getRequestTypeUrl()) == true) goto L16;
        return false;
    L16:
        if (getRequestStreaming() == r6.getRequestStreaming()) goto L19;
        return false;
    L19:
        if (getResponseTypeUrl().equals(r6.getResponseTypeUrl()) == true) goto L22;
        return false;
    L22:
        if (getResponseStreaming() == r6.getResponseStreaming()) goto L25;
        return false;
    L25:
        if (getOptionsList().equals(r6.getOptionsList()) == true) goto L28;
        return false;
    L28:
        if (this.syntax_ == r6.syntax_) goto L31;
        return false;
    L31:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        return super.equals(r5);
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
    public Method getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getName() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Option getOptions(int r2) {
        return (Option) ZeusTransformUtils.preCheckCast(this.options_.get(r2), Option.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r2) {
        return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r2), OptionOrBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Method> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getRequestTypeUrl() {
        Object r0 = this.requestTypeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.requestTypeUrl_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getRequestTypeUrlBytes() {
        Object r0 = this.requestTypeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.requestTypeUrl_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        Object r0 = this.responseTypeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.responseTypeUrl_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getResponseTypeUrlBytes() {
        Object r0 = this.responseTypeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.responseTypeUrl_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r2 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L10:
        if (GeneratedMessage.isStringEmpty(this.requestTypeUrl_) == true) goto L12;
        r2 = r2 + GeneratedMessage.computeStringSize(2, this.requestTypeUrl_);
    L12:
        boolean r3 = this.requestStreaming_;
        if (r3 == false) goto L16;
        r2 = r2 + CodedOutputStream.computeBoolSize(3, r3);
    L16:
        if (GeneratedMessage.isStringEmpty(this.responseTypeUrl_) == true) goto L18;
        r2 = r2 + GeneratedMessage.computeStringSize(4, this.responseTypeUrl_);
    L18:
        boolean r4 = this.responseStreaming_;
        if (r4 == false) goto L22;
        r2 = r2 + CodedOutputStream.computeBoolSize(5, r4);
    L22:
        if (r1 >= this.options_.size()) goto L25;
        r2 = r2 + CodedOutputStream.computeMessageSize(6, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r1), MessageLite.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L22
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L27;
        r2 = r2 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L27:
        int r5 = r2 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r5;
        return r5;
    L8:
        r2 = 0;
        goto L10
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Syntax getSyntax() {
        Syntax r0 = Syntax.forNumber(this.syntax_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRequestTypeUrl().hashCode()) * 37) + 3) * 53) + Internal.hashBoolean(getRequestStreaming())) * 37) + 4) * 53) + getResponseTypeUrl().hashCode()) * 37) + 5) * 53) + Internal.hashBoolean(getResponseStreaming());
        if (getOptionsCount() <= 0) goto L9;
        r0 = (((r0 * 37) + 6) * 53) + getOptionsList().hashCode();
    L9:
        int r1 = (((((r0 * 37) + 7) * 53) + this.syntax_) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Builder.class);
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
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
        return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"), null);
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
    public void writeTo(CodedOutputStream r6) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L6;
        GeneratedMessage.writeString(r6, 1, this.name_);
    L6:
        if (GeneratedMessage.isStringEmpty(this.requestTypeUrl_) == true) goto L8;
        GeneratedMessage.writeString(r6, 2, this.requestTypeUrl_);
    L8:
        boolean r0 = this.requestStreaming_;
        if (r0 == false) goto L12;
        r6.writeBool(3, r0);
    L12:
        if (GeneratedMessage.isStringEmpty(this.responseTypeUrl_) == true) goto L14;
        GeneratedMessage.writeString(r6, 4, this.responseTypeUrl_);
    L14:
        boolean r1 = this.responseStreaming_;
        if (r1 == false) goto L17;
        r6.writeBool(5, r1);
    L17:
        int r2 = 0;
    L19:
        if (r2 >= this.options_.size()) goto L22;
        r6.writeMessage(6, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r2), MessageLite.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L19
    L22:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L24;
        r6.writeEnum(7, this.syntax_);
    L24:
        getUnknownFields().writeTo(r6);
    }
}
