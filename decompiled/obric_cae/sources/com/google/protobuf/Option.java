package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
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

        private void buildPartial0(Option r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L6;
            Option.access$302(r8, this.name_);
        L6:
            if ((r10 & 2) == 0) goto L12;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r11 = this.valueBuilder_;
            if (r11 != null) goto L10;
            Any r12 = this.value_;
        L11:
            Option.access$402(r8, r12);
            int r13 = 1;
        L13:
            Option.access$576(r8, r13);
            return;
        L10:
            r12 = (Any) r11.build();
            goto L11
        L12:
            r13 = 0;
            goto L13
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
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
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
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r8 = this.valueBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.valueBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.name_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public Any getValue() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r8 = this.valueBuilder_;
            if (r8 != null) goto L9;
            Any r10 = this.value_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return Any.getDefaultInstance();
        L9:
            return (Any) r8.getMessage();
        }

        public Any.Builder getValueBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Any.Builder) internalGetValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public AnyOrBuilder getValueOrBuilder() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r8 = this.valueBuilder_;
            if (r8 != null) goto L5;
            Any r10 = this.value_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return Any.getDefaultInstance();
        L5:
            return (AnyOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public boolean hasValue() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeValue(Any r8) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r10 = this.valueBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L14:
            if (this.value_ == null) goto L16;
            this.bitField0_ |= 2;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            Any r11 = this.value_;
            if (r11 == null) goto L11;
            if (r11 == Any.getDefaultInstance()) goto L11;
            getValueBuilder().mergeFrom(r8);
        L11:
            this.value_ = r8;
            goto L14
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

        public Builder setValue(Any.Builder r8) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r10 = this.valueBuilder_;
            Any r11 = r8.build();
            if (r10 != null) goto L5;
            this.value_ = r11;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.name_ = "";
            maybeForceBuilderInitialization();
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

        public Builder setValue(Any r8) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r10 = this.valueBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.value_ = r8;
        L9:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Option build() {
            Option r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Option buildPartial() {
            Option r8 = new Option(this, null);
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
        public Option getDefaultInstanceForType() {
            return Option.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
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
            this.value_ = null;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> r8 = this.valueBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.valueBuilder_ = null;
        L5:
            return this;
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
            if (r10 == null) goto L28;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L25;
            int r12 = r8.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r12 == 0) goto L17;
            if (r12 != 10) goto L10;
            this.name_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.bitField0_ |= 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L10:
            if (r12 != 18) goto L12;
            r8.readMessage(internalGetValueFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.bitField0_ |= 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L12:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L17:
            r11 = true;
            goto L4
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
        L28:
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Option) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Option) r8);
        }

        public Builder mergeFrom(Option r8) {
            if (r8 != Option.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.getName().isEmpty() == true) goto L9;
            this.name_ = Option.access$300(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasValue() == false) goto L11;
            mergeValue(r8.getValue());
        L11:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Option");
        DEFAULT_INSTANCE = new Option();
        PARSER = new AnonymousClass1();
    }

    private Option() {
        this.name_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
    }

    public static /* synthetic */ Object access$300(Option r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$302(Option r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static /* synthetic */ Any access$402(Option r8, Any r10) {
        r8.value_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$576(Option r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
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

    public static Option parseDelimitedFrom(InputStream r8) {
        return (Option) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Option parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Option> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Option) == false) goto L8;
        Option r10 = (Option) r8;
        if (getName().equals(r10.getName()) == true) goto L13;
        return false;
    L13:
        if (hasValue() == r10.hasValue()) goto L16;
        return false;
    L16:
        if (hasValue() == false) goto L21;
        if (getValue().equals(r10.getValue()) == true) goto L21;
        return false;
    L21:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L23;
        return false;
    L23:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.name_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Option> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L9;
        r10 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
    L9:
        if ((this.bitField0_ & 1) == 0) goto L11;
        r10 = r10 + CodedOutputStream.computeMessageSize(2, getValue());
    L11:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public Any getValue() {
        Any r8 = this.value_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Any.getDefaultInstance();
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public AnyOrBuilder getValueOrBuilder() {
        Any r8 = this.value_;
        if (r8 == null) goto L5;
        return r8;
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
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = (((getDescriptor().hashCode() + 779) * 37) + 1) * 53;
        int r11 = getName().hashCode() + r10;
        if (hasValue() == false) goto L8;
        int r12 = defpackage.b.a(r11, 37, 2, 53);
        r11 = getValue().hashCode() + r12;
    L8:
        int r13 = getUnknownFields().hashCode();
        int r14 = r13 + (r11 * 29);
        this.memoizedHashCode = r14;
        return r14;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
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
        if ((this.bitField0_ & 1) == 0) goto L8;
        r8.writeMessage(2, getValue());
    L8:
        getUnknownFields().writeTo(r8);
    }

    private Option(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.name_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Option r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Option parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Option) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Option parseFrom(ByteString r8, ExtensionRegistryLite r10) {
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

    public /* synthetic */ Option(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Option parseFrom(CodedInputStream r8) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Option getDefaultInstanceForType() {
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

    public static Option parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Option parseFrom(InputStream r8) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static Option parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Option parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Option parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Option parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Option parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
