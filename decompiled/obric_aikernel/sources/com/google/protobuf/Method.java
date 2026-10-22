package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
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

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.responseTypeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Method r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L6;
            Method.access$402(r10, this.name_);
        L6:
            if ((r11 & 2) == 0) goto L9;
            Method.access$502(r10, this.requestTypeUrl_);
        L9:
            if ((r11 & 4) == 0) goto L12;
            Method.access$602(r10, this.requestStreaming_);
        L12:
            if ((r11 & 8) == 0) goto L15;
            Method.access$702(r10, this.responseTypeUrl_);
        L15:
            if ((r11 & 16) == 0) goto L18;
            Method.access$802(r10, this.responseStreaming_);
        L18:
            if ((r11 & 64) == 0) goto L21;
            Method.access$902(r10, this.syntax_);
            return;
        }

        private void buildPartialRepeatedFields(Method r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 == null) goto L5;
            List r12 = r11.build();
        L9:
            Method.access$302(r10, r12);
            return;
        L5:
            if ((this.bitField0_ & 32) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -33;
        L7:
            r12 = this.options_;
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
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.optionsBuilder_;
        }

        public Builder addAllOptions(Iterable<? extends Option> r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addOptions(int r10, Option r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureOptionsIsMutable();
            this.options_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addOptions(Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addOptions(Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureOptionsIsMutable();
            this.options_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public Option.Builder addOptionsBuilder(int r10) {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(r10, Option.getDefaultInstance());
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
            Method r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
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
            Method r10 = new Method(this, null);
            buildPartialRepeatedFields(r10);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r10);
        L5:
            onBuilt();
            return r10;
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
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            return this;
        L5:
            this.options_ = null;
            r10.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Method.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
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
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Option getOptions(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.options_.get(r10);
        L6:
            return (Option) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r10) {
            return (Option.Builder) internalGetOptionsFieldBuilder().getBuilder(r10);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.options_.get(r10);
        L6:
            return (OptionOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getRequestStreaming() {
            return this.requestStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getRequestTypeUrl() {
            Object r10 = this.requestTypeUrl_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.requestTypeUrl_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getRequestTypeUrlBytes() {
            Object r10 = this.requestTypeUrl_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.requestTypeUrl_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getResponseStreaming() {
            return this.responseStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getResponseTypeUrl() {
            Object r10 = this.responseTypeUrl_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.responseTypeUrl_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getResponseTypeUrlBytes() {
            Object r10 = this.responseTypeUrl_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.responseTypeUrl_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.forNumber(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
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

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            Objects.requireNonNull(r11);
            boolean r12 = false;
        L3:
            if (r12 == true) goto L42;
            int r13 = r10.readTag();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (r13 == 0) goto L34;
            if (r13 != 10) goto L9;
            this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 1;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L9:
            if (r13 != 18) goto L11;
            this.requestTypeUrl_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 2;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L11:
            if (r13 != 24) goto L13;
            this.requestStreaming_ = r10.readBool();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 4;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L13:
            if (r13 != 34) goto L15;
            this.responseTypeUrl_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 8;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L15:
            if (r13 != 40) goto L17;
            this.responseStreaming_ = r10.readBool();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 16;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L17:
            if (r13 != 50) goto L19;
            Option r14 = (Option) r10.readMessage(Option.parser(), r11);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r15 = this.optionsBuilder_;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            if (r15 == null) goto L26;
            r15.addMessage(r14);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L26:
            ensureOptionsIsMutable();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.options_.add(r14);     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L19:
            if (r13 != 56) goto L21;
            this.syntax_ = r10.readEnum();     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            this.bitField0_ |= 64;     // Catch: Throwable -> L35 InvalidProtocolBufferException -> L37
            goto L3
        L21:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L34:
            r12 = true;
            goto L3
        L37:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            onChanged();
            throw th;
        L42:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Method) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Method) r10);
        }

        public Builder mergeFrom(Method r10) {
            if (r10 != Method.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L9;
            this.name_ = Method.access$400(r10);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r10.getRequestTypeUrl().isEmpty() == true) goto L12;
            this.requestTypeUrl_ = Method.access$500(r10);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r10.getRequestStreaming() == false) goto L15;
            setRequestStreaming(r10.getRequestStreaming());
        L15:
            if (r10.getResponseTypeUrl().isEmpty() == true) goto L18;
            this.responseTypeUrl_ = Method.access$700(r10);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r10.getResponseStreaming() == false) goto L21;
            setResponseStreaming(r10.getResponseStreaming());
        L21:
            if (this.optionsBuilder_ != null) goto L30;
            if (Method.access$300(r10).isEmpty() == true) goto L39;
            if (this.options_.isEmpty() == false) goto L27;
            this.options_ = Method.access$300(r10);
            this.bitField0_ &= -33;
        L28:
            onChanged();
            goto L39
        L27:
            ensureOptionsIsMutable();
            this.options_.addAll(Method.access$300(r10));
        L39:
            if (Method.access$900(r10) == 0) goto L41;
            setSyntaxValue(r10.getSyntaxValue());
        L41:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L30:
            if (Method.access$300(r10).isEmpty() == true) goto L39;
            if (this.optionsBuilder_.isEmpty() == false) goto L37;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = null;
            this.optionsBuilder_ = null;
            this.options_ = Method.access$300(r10);
            this.bitField0_ &= -33;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L36;
            r11 = internalGetOptionsFieldBuilder();
        L36:
            this.optionsBuilder_ = r11;
            goto L39
        L37:
            this.optionsBuilder_.addAllMessages(Method.access$300(r10));
            goto L39
        }

        public Builder removeOptions(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder setName(String r10) {
            Objects.requireNonNull(r10);
            this.name_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.name_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setOptions(int r10, Option r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureOptionsIsMutable();
            this.options_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }

        public Builder setRequestStreaming(boolean r10) {
            this.requestStreaming_ = r10;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setRequestTypeUrl(String r10) {
            Objects.requireNonNull(r10);
            this.requestTypeUrl_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setRequestTypeUrlBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.requestTypeUrl_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setResponseStreaming(boolean r10) {
            this.responseStreaming_ = r10;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setResponseTypeUrl(String r10) {
            Objects.requireNonNull(r10);
            this.responseTypeUrl_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setResponseTypeUrlBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.responseTypeUrl_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setSyntax(Syntax r10) {
            Objects.requireNonNull(r10);
            this.bitField0_ |= 64;
            this.syntax_ = r10.getNumber();
            onChanged();
            return this;
        }

        public Builder setSyntaxValue(int r10) {
            this.syntax_ = r10;
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

    private Method(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.syntax_ = 0;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Method(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ List access$300(Method r10) {
        return r10.options_;
    }

    static /* synthetic */ List access$302(Method r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$400(Method r10) {
        return r10.name_;
    }

    static /* synthetic */ Object access$402(Method r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$500(Method r10) {
        return r10.requestTypeUrl_;
    }

    static /* synthetic */ Object access$502(Method r10, Object r11) {
        r10.requestTypeUrl_ = r11;
        return r11;
    }

    static /* synthetic */ boolean access$602(Method r10, boolean r11) {
        r10.requestStreaming_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$700(Method r10) {
        return r10.responseTypeUrl_;
    }

    static /* synthetic */ Object access$702(Method r10, Object r11) {
        r10.responseTypeUrl_ = r11;
        return r11;
    }

    static /* synthetic */ boolean access$802(Method r10, boolean r11) {
        r10.responseStreaming_ = r11;
        return r11;
    }

    static /* synthetic */ int access$900(Method r10) {
        return r10.syntax_;
    }

    static /* synthetic */ int access$902(Method r10, int r11) {
        r10.syntax_ = r11;
        return r11;
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

    public static Builder newBuilder(Method r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Method parseDelimitedFrom(InputStream r10) {
        return (Method) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Method parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Method) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Method parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Method parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Method parseFrom(CodedInputStream r10) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Method parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Method parseFrom(InputStream r10) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Method parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Method parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Method parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Method parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Method parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Method> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Method) == false) goto L8;
        Method r11 = (Method) r10;
        if (getName().equals(r11.getName()) == true) goto L13;
        return false;
    L13:
        if (getRequestTypeUrl().equals(r11.getRequestTypeUrl()) == true) goto L16;
        return false;
    L16:
        if (getRequestStreaming() == r11.getRequestStreaming()) goto L19;
        return false;
    L19:
        if (getResponseTypeUrl().equals(r11.getResponseTypeUrl()) == true) goto L22;
        return false;
    L22:
        if (getResponseStreaming() == r11.getResponseStreaming()) goto L25;
        return false;
    L25:
        if (getOptionsList().equals(r11.getOptionsList()) == true) goto L28;
        return false;
    L28:
        if (this.syntax_ == r11.syntax_) goto L31;
        return false;
    L31:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        return super.equals(r10);
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
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
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
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
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
        Object r10 = this.requestTypeUrl_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.requestTypeUrl_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getRequestTypeUrlBytes() {
        Object r10 = this.requestTypeUrl_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.requestTypeUrl_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        Object r10 = this.responseTypeUrl_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.responseTypeUrl_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getResponseTypeUrlBytes() {
        Object r10 = this.responseTypeUrl_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.responseTypeUrl_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r12 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L10:
        if (GeneratedMessage.isStringEmpty(this.requestTypeUrl_) == true) goto L12;
        r12 = r12 + GeneratedMessage.computeStringSize(2, this.requestTypeUrl_);
    L12:
        boolean r13 = this.requestStreaming_;
        if (r13 == false) goto L16;
        r12 = r12 + CodedOutputStream.computeBoolSize(3, r13);
    L16:
        if (GeneratedMessage.isStringEmpty(this.responseTypeUrl_) == true) goto L18;
        r12 = r12 + GeneratedMessage.computeStringSize(4, this.responseTypeUrl_);
    L18:
        boolean r14 = this.responseStreaming_;
        if (r14 == false) goto L22;
        r12 = r12 + CodedOutputStream.computeBoolSize(5, r14);
    L22:
        if (r11 >= this.options_.size()) goto L25;
        r12 = r12 + CodedOutputStream.computeMessageSize(6, this.options_.get(r11));
        r11 = r11 + 1;
        goto L22
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L27;
        r12 = r12 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L27:
        int r15 = r12 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r15;
        return r15;
    L8:
        r12 = 0;
        goto L10
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.forNumber(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRequestTypeUrl().hashCode()) * 37) + 3) * 53) + Internal.hashBoolean(getRequestStreaming())) * 37) + 4) * 53) + getResponseTypeUrl().hashCode()) * 37) + 5) * 53) + Internal.hashBoolean(getResponseStreaming());
        if (getOptionsCount() <= 0) goto L8;
        r11 = (((r11 * 37) + 6) * 53) + getOptionsList().hashCode();
    L8:
        int r12 = (((((r11 * 37) + 7) * 53) + this.syntax_) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Builder.class);
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
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    protected /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return newBuilderForType(r10);
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
    protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return new Builder(r10, null);
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
        AnonymousClass1 r10 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r10);
    L6:
        return new Builder(r10).mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L6;
        GeneratedMessage.writeString(r10, 1, this.name_);
    L6:
        if (GeneratedMessage.isStringEmpty(this.requestTypeUrl_) == true) goto L8;
        GeneratedMessage.writeString(r10, 2, this.requestTypeUrl_);
    L8:
        boolean r11 = this.requestStreaming_;
        if (r11 == false) goto L12;
        r10.writeBool(3, r11);
    L12:
        if (GeneratedMessage.isStringEmpty(this.responseTypeUrl_) == true) goto L14;
        GeneratedMessage.writeString(r10, 4, this.responseTypeUrl_);
    L14:
        boolean r12 = this.responseStreaming_;
        if (r12 == false) goto L17;
        r10.writeBool(5, r12);
    L17:
        int r13 = 0;
    L19:
        if (r13 >= this.options_.size()) goto L22;
        r10.writeMessage(6, this.options_.get(r13));
        r13 = r13 + 1;
        goto L19
    L22:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L24;
        r10.writeEnum(7, this.syntax_);
    L24:
        getUnknownFields().writeTo(r10);
    }
}
