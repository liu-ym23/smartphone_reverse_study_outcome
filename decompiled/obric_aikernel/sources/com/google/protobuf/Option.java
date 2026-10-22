package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Option extends GeneratedMessage implements OptionOrBuilder {
    private static final Option DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final Parser<Option> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private Any value_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements OptionOrBuilder {
        private int bitField0_;
        private Object name_;
        private SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> valueBuilder_;
        private Any value_;

        private Builder() {
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Option r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L5;
            Option.access$302(r10, this.name_);
        L5:
            int r12 = 0;
            if ((r11 & 2) == 0) goto L12;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r13 = this.valueBuilder_;
            if (r13 != null) goto L10;
            Any r14 = this.value_;
        L11:
            Option.access$402(r10, r14);
            r12 = 1;
            goto L12
        L10:
            r14 = (Any) r13.build();
        L12:
            Option.access$576(r10, r12);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        private SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> internalGetValueFieldBuilder() {
            if (this.valueBuilder_ != null) goto L6;
            this.valueBuilder_ = new SingleFieldBuilder(getValue(), getParentForChildren(), isClean());
            this.value_ = null;
        L6:
            return this.valueBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L6;
            internalGetValueFieldBuilder();
            return;
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
        public Option build() {
            Option r10 = buildPartial();
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
        public Option buildPartial() {
            Option r10 = new Option(this, null);
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
            this.value_ = null;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r10 = this.valueBuilder_;
            if (r10 == null) goto L5;
            r10.dispose();
            this.valueBuilder_ = null;
        L5:
            return this;
        }

        public Builder clearName() {
            this.name_ = Option.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.bitField0_ &= -3;
            this.value_ = null;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r10 = this.valueBuilder_;
            if (r10 == null) goto L5;
            r10.dispose();
            this.valueBuilder_ = null;
        L5:
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
        public Option getDefaultInstanceForType() {
            return Option.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public Any getValue() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r10 = this.valueBuilder_;
            if (r10 != null) goto L9;
            Any r11 = this.value_;
            if (r11 == null) goto L7;
            return r11;
        L7:
            return Any.getDefaultInstance();
        L9:
            return (Any) r10.getMessage();
        }

        public Any.Builder getValueBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Any.Builder) internalGetValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public AnyOrBuilder getValueOrBuilder() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r10 = this.valueBuilder_;
            if (r10 != null) goto L5;
            Any r11 = this.value_;
            if (r11 == null) goto L9;
            return r11;
        L9:
            return Any.getDefaultInstance();
        L5:
            return (AnyOrBuilder) r10.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public boolean hasValue() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
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
            if (r12 == true) goto L24;
            int r13 = r10.readTag();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r13 == 0) goto L16;
            if (r13 != 10) goto L9;
            this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (r13 != 18) goto L11;
            r10.readMessage(internalGetValueFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L11:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L16:
            r12 = true;
            goto L3
        L19:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            onChanged();
            throw th;
        L24:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Option) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Option) r10);
        }

        public Builder mergeFrom(Option r10) {
            if (r10 != Option.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L9;
            this.name_ = Option.access$300(r10);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r10.hasValue() == false) goto L11;
            mergeValue(r10.getValue());
        L11:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        }

        public Builder mergeValue(Any r10) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r11 = this.valueBuilder_;
            if (r11 == null) goto L5;
            r11.mergeFrom(r10);
        L14:
            if (this.value_ == null) goto L16;
            this.bitField0_ |= 2;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            Any r12 = this.value_;
            if (r12 == null) goto L11;
            if (r12 == Any.getDefaultInstance()) goto L11;
            getValueBuilder().mergeFrom(r10);
        L11:
            this.value_ = r10;
            goto L14
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

        public Builder setValue(Any.Builder r10) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r11 = this.valueBuilder_;
            Any r12 = r10.build();
            if (r11 != null) goto L5;
            this.value_ = r12;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r11.setMessage(r12);
            goto L6
        }

        public Builder setValue(Any r10) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r11 = this.valueBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            this.value_ = r10;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r11.setMessage(r10);
            goto L6
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Option.class.getName());
        DEFAULT_INSTANCE = new Option();
        PARSER = new AnonymousClass1();
    }

    private Option() {
        this.name_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
    }

    private Option(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.name_ = "";
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Option(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ Object access$300(Option r10) {
        return r10.name_;
    }

    static /* synthetic */ Object access$302(Option r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    static /* synthetic */ Any access$402(Option r10, Any r11) {
        r10.value_ = r11;
        return r11;
    }

    static /* synthetic */ int access$576(Option r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Option r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Option parseDelimitedFrom(InputStream r10) {
        return (Option) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Option parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Option) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Option parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Option parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Option parseFrom(CodedInputStream r10) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Option parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Option parseFrom(InputStream r10) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Option parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Option parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Option parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Option parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Option parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Option> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Option) == false) goto L8;
        Option r11 = (Option) r10;
        if (getName().equals(r11.getName()) == true) goto L13;
        return false;
    L13:
        if (hasValue() == r11.hasValue()) goto L16;
        return false;
    L16:
        if (hasValue() == false) goto L21;
        if (getValue().equals(r11.getValue()) == true) goto L21;
        return false;
    L21:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L23;
        return false;
    L23:
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
    public Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Option> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L9;
        r11 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
    L9:
        if ((this.bitField0_ & 1) == 0) goto L11;
        r11 = r11 + CodedOutputStream.computeMessageSize(2, getValue());
    L11:
        int r12 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public Any getValue() {
        Any r10 = this.value_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Any.getDefaultInstance();
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public AnyOrBuilder getValueOrBuilder() {
        Any r10 = this.value_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Any.getDefaultInstance();
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public boolean hasValue() {
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
        int r11 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasValue() == false) goto L8;
        r11 = (((r11 * 37) + 2) * 53) + getValue().hashCode();
    L8:
        int r12 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
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
        if ((this.bitField0_ & 1) == 0) goto L8;
        r10.writeMessage(2, getValue());
    L8:
        getUnknownFields().writeTo(r10);
    }
}
