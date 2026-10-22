package com.google.protobuf;

import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Method extends GeneratedMessage implements MethodOrBuilder {
    private static final Method DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static final Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private volatile Object edition_;
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
        private Object edition_;
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
            this.edition_ = "";
        }

        private void buildPartial0(Method r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L6;
            Method.access$402(r8, this.name_);
        L6:
            if ((r10 & 2) == 0) goto L9;
            Method.access$502(r8, this.requestTypeUrl_);
        L9:
            if ((r10 & 4) == 0) goto L12;
            Method.access$602(r8, this.requestStreaming_);
        L12:
            if ((r10 & 8) == 0) goto L15;
            Method.access$702(r8, this.responseTypeUrl_);
        L15:
            if ((r10 & 16) == 0) goto L18;
            Method.access$802(r8, this.responseStreaming_);
        L18:
            if ((r10 & 64) == 0) goto L21;
            Method.access$902(r8, this.syntax_);
        L21:
            if ((r10 & 128) == 0) goto L24;
            Method.access$1002(r8, this.edition_);
            return;
        }

        private void buildPartialRepeatedFields(Method r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            Method.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 32) == 0) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -33;
        L7:
            r11 = this.options_;
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
            List<Option> r8 = this.options_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.optionsBuilder_;
        }

        public Builder addAllOptions(Iterable<? extends Option> r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addOptions(int r8, Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Deprecated
        public Builder clearEdition() {
            this.edition_ = Method.getDefaultInstance().getEdition();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Method.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
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

        @Deprecated
        public Builder clearSyntax() {
            this.bitField0_ &= -65;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Method_descriptor;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        @Deprecated
        public String getEdition() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.edition_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        @Deprecated
        public ByteString getEditionBytes() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.edition_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.name_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Option getOptions(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.options_.get(r8);
        L6:
            return (Option) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r8) {
            return (Option.Builder) internalGetOptionsFieldBuilder().getBuilder(r8);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return this.options_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.options_.get(r8);
        L6:
            return (OptionOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getRequestStreaming() {
            return this.requestStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getRequestTypeUrl() {
            Object r8 = this.requestTypeUrl_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.requestTypeUrl_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getRequestTypeUrlBytes() {
            Object r8 = this.requestTypeUrl_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.requestTypeUrl_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getResponseStreaming() {
            return this.responseStreaming_;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getResponseTypeUrl() {
            Object r8 = this.responseTypeUrl_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.responseTypeUrl_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getResponseTypeUrlBytes() {
            Object r8 = this.responseTypeUrl_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.responseTypeUrl_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        @Deprecated
        public Syntax getSyntax() {
            Syntax r8 = Syntax.forNumber(this.syntax_);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        @Deprecated
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
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder removeOptions(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        @Deprecated
        public Builder setEdition(String r8) {
            if (r8 == null) goto L6;
            this.edition_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Deprecated
        public Builder setEditionBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.edition_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setName(String r8) {
            if (r8 == null) goto L6;
            this.name_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.name_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setOptions(int r8, Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setRequestStreaming(boolean r8) {
            this.requestStreaming_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setRequestTypeUrl(String r8) {
            if (r8 == null) goto L6;
            this.requestTypeUrl_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRequestTypeUrlBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.requestTypeUrl_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setResponseStreaming(boolean r8) {
            this.responseStreaming_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setResponseTypeUrl(String r8) {
            if (r8 == null) goto L6;
            this.responseTypeUrl_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setResponseTypeUrlBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.responseTypeUrl_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Deprecated
        public Builder setSyntax(Syntax r8) {
            if (r8 == null) goto L6;
            this.bitField0_ |= 64;
            this.syntax_ = r8.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Deprecated
        public Builder setSyntaxValue(int r8) {
            this.syntax_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.name_ = "";
            this.requestTypeUrl_ = "";
            this.responseTypeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
        }

        public Builder addOptions(int r8, Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public Option.Builder addOptionsBuilder(int r8) {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(r8, Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        public Builder setOptions(int r8, Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addOptions(Option.Builder r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Method build() {
            Method r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Method buildPartial() {
            Method r8 = new Method(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public Method getDefaultInstanceForType() {
            return Method.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addOptions(Option r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
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
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            this.edition_ = "";
            return this;
        L5:
            this.options_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L49;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L46;
            int r12 = r8.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r12 == 0) goto L38;
            if (r12 != 10) goto L10;
            this.name_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L10:
            if (r12 != 18) goto L12;
            this.requestTypeUrl_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 2;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.requestStreaming_ = r8.readBool();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L14:
            if (r12 != 34) goto L16;
            this.responseTypeUrl_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 8;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.responseStreaming_ = r8.readBool();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 16;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L18:
            if (r12 != 50) goto L20;
            Option r13 = (Option) r8.readMessage(Option.parser(), r10);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r14 = this.optionsBuilder_;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r14 == null) goto L30;
            r14.addMessage(r13);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L30:
            ensureOptionsIsMutable();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.options_.add(r13);     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L20:
            if (r12 != 56) goto L22;
            this.syntax_ = r8.readEnum();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 64;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L22:
            if (r12 != 66) goto L24;
            this.edition_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            this.bitField0_ |= 128;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L4
        L24:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L38:
            r11 = true;
            goto L4
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L46:
            onChanged();
            return this;
        L49:
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Method) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Method) r8);
        }

        public Builder mergeFrom(Method r8) {
            if (r8 != Method.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.getName().isEmpty() == true) goto L9;
            this.name_ = Method.access$400(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.getRequestTypeUrl().isEmpty() == true) goto L12;
            this.requestTypeUrl_ = Method.access$500(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.getRequestStreaming() == false) goto L15;
            setRequestStreaming(r8.getRequestStreaming());
        L15:
            if (r8.getResponseTypeUrl().isEmpty() == true) goto L18;
            this.responseTypeUrl_ = Method.access$700(r8);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r8.getResponseStreaming() == false) goto L21;
            setResponseStreaming(r8.getResponseStreaming());
        L21:
            if (this.optionsBuilder_ != null) goto L30;
            if (Method.access$300(r8).isEmpty() == true) goto L39;
            if (this.options_.isEmpty() == false) goto L27;
            this.options_ = Method.access$300(r8);
            this.bitField0_ &= -33;
        L28:
            onChanged();
            goto L39
        L27:
            ensureOptionsIsMutable();
            this.options_.addAll(Method.access$300(r8));
        L39:
            if (Method.access$900(r8) == 0) goto L42;
            setSyntaxValue(r8.getSyntaxValue());
        L42:
            if (r8.getEdition().isEmpty() == true) goto L44;
            this.edition_ = Method.access$1000(r8);
            this.bitField0_ |= 128;
            onChanged();
        L44:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L30:
            if (Method.access$300(r8).isEmpty() == true) goto L39;
            if (this.optionsBuilder_.isEmpty() == false) goto L37;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = null;
            this.optionsBuilder_ = null;
            this.options_ = Method.access$300(r8);
            this.bitField0_ &= -33;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L36;
            r10 = internalGetOptionsFieldBuilder();
        L36:
            this.optionsBuilder_ = r10;
            goto L39
        L37:
            this.optionsBuilder_.addAllMessages(Method.access$300(r8));
            goto L39
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Method");
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
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.responseTypeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
    }

    public static /* synthetic */ Object access$1000(Method r8) {
        return r8.edition_;
    }

    public static /* synthetic */ Object access$1002(Method r8, Object r10) {
        r8.edition_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$300(Method r8) {
        return r8.options_;
    }

    public static /* synthetic */ List access$302(Method r8, List r10) {
        r8.options_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(Method r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$402(Method r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$500(Method r8) {
        return r8.requestTypeUrl_;
    }

    public static /* synthetic */ Object access$502(Method r8, Object r10) {
        r8.requestTypeUrl_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$602(Method r8, boolean r10) {
        r8.requestStreaming_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(Method r8) {
        return r8.responseTypeUrl_;
    }

    public static /* synthetic */ Object access$702(Method r8, Object r10) {
        r8.responseTypeUrl_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$802(Method r8, boolean r10) {
        r8.responseStreaming_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$900(Method r8) {
        return r8.syntax_;
    }

    public static /* synthetic */ int access$902(Method r8, int r10) {
        r8.syntax_ = r10;
        return r10;
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

    public static Method parseDelimitedFrom(InputStream r8) {
        return (Method) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Method parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Method> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Method) == false) goto L8;
        Method r10 = (Method) r8;
        if (getName().equals(r10.getName()) == true) goto L13;
        return false;
    L13:
        if (getRequestTypeUrl().equals(r10.getRequestTypeUrl()) == true) goto L16;
        return false;
    L16:
        if (getRequestStreaming() == r10.getRequestStreaming()) goto L19;
        return false;
    L19:
        if (getResponseTypeUrl().equals(r10.getResponseTypeUrl()) == true) goto L22;
        return false;
    L22:
        if (getResponseStreaming() == r10.getResponseStreaming()) goto L25;
        return false;
    L25:
        if (getOptionsList().equals(r10.getOptionsList()) == true) goto L28;
        return false;
    L28:
        if (this.syntax_ == r10.syntax_) goto L31;
        return false;
    L31:
        if (getEdition().equals(r10.getEdition()) == true) goto L34;
        return false;
    L34:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    @Deprecated
    public String getEdition() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.edition_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    @Deprecated
    public ByteString getEditionBytes() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.edition_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.name_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Option getOptions(int r8) {
        return this.options_.get(r8);
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
    public OptionOrBuilder getOptionsOrBuilder(int r8) {
        return this.options_.get(r8);
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
        Object r8 = this.requestTypeUrl_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.requestTypeUrl_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getRequestTypeUrlBytes() {
        Object r8 = this.requestTypeUrl_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.requestTypeUrl_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        Object r8 = this.responseTypeUrl_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.responseTypeUrl_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getResponseTypeUrlBytes() {
        Object r8 = this.responseTypeUrl_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.responseTypeUrl_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L10:
        if (GeneratedMessage.isStringEmpty(this.requestTypeUrl_) == true) goto L12;
        r11 = r11 + GeneratedMessage.computeStringSize(2, this.requestTypeUrl_);
    L12:
        boolean r12 = this.requestStreaming_;
        if (r12 == false) goto L16;
        r11 = r11 + CodedOutputStream.computeBoolSize(3, r12);
    L16:
        if (GeneratedMessage.isStringEmpty(this.responseTypeUrl_) == true) goto L18;
        r11 = r11 + GeneratedMessage.computeStringSize(4, this.responseTypeUrl_);
    L18:
        boolean r13 = this.responseStreaming_;
        if (r13 == false) goto L22;
        r11 = r11 + CodedOutputStream.computeBoolSize(5, r13);
    L22:
        if (r10 >= this.options_.size()) goto L25;
        r11 = r11 + CodedOutputStream.computeMessageSize(6, this.options_.get(r10));
        r10 = r10 + 1;
        goto L22
    L25:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L28;
        r11 = r11 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L28:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L30;
        r11 = r11 + GeneratedMessage.computeStringSize(8, this.edition_);
    L30:
        int r14 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r14;
        return r14;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.google.protobuf.MethodOrBuilder
    @Deprecated
    public Syntax getSyntax() {
        Syntax r8 = Syntax.forNumber(this.syntax_);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    @Deprecated
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = (((getDescriptor().hashCode() + 779) * 37) + 1) * 53;
        int r11 = (((getName().hashCode() + r10) * 37) + 2) * 53;
        int r12 = (((getRequestTypeUrl().hashCode() + r11) * 37) + 3) * 53;
        int r13 = (((Internal.hashBoolean(getRequestStreaming()) + r12) * 37) + 4) * 53;
        int r14 = (((getResponseTypeUrl().hashCode() + r13) * 37) + 5) * 53;
        int r15 = Internal.hashBoolean(getResponseStreaming()) + r14;
        if (getOptionsCount() <= 0) goto L8;
        int r16 = defpackage.b.a(r15, 37, 6, 53);
        r15 = getOptionsList().hashCode() + r16;
    L8:
        int r17 = (((defpackage.b.a(r15, 37, 7, 53) + this.syntax_) * 37) + 8) * 53;
        int r18 = (getEdition().hashCode() + r17) * 29;
        int r19 = getUnknownFields().hashCode() + r18;
        this.memoizedHashCode = r19;
        return r19;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L6;
        GeneratedMessage.writeString(r8, 1, this.name_);
    L6:
        if (GeneratedMessage.isStringEmpty(this.requestTypeUrl_) == true) goto L8;
        GeneratedMessage.writeString(r8, 2, this.requestTypeUrl_);
    L8:
        boolean r10 = this.requestStreaming_;
        if (r10 == false) goto L12;
        r8.writeBool(3, r10);
    L12:
        if (GeneratedMessage.isStringEmpty(this.responseTypeUrl_) == true) goto L14;
        GeneratedMessage.writeString(r8, 4, this.responseTypeUrl_);
    L14:
        boolean r11 = this.responseStreaming_;
        if (r11 == false) goto L17;
        r8.writeBool(5, r11);
    L17:
        int r12 = 0;
    L19:
        if (r12 >= this.options_.size()) goto L22;
        r8.writeMessage(6, this.options_.get(r12));
        r12 = r12 + 1;
        goto L19
    L22:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L25;
        r8.writeEnum(7, this.syntax_);
    L25:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L27;
        GeneratedMessage.writeString(r8, 8, this.edition_);
    L27:
        getUnknownFields().writeTo(r8);
    }

    private Method(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Method r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Method parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Method) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Method parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ Method(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Method parseFrom(CodedInputStream r8) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Method getDefaultInstanceForType() {
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

    public static Method parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Method parseFrom(InputStream r8) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static Method parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Method) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Method parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Method parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Method parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Method parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
