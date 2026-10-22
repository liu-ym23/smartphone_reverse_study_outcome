package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class BytesValue extends GeneratedMessage implements BytesValueOrBuilder {
    private static final BytesValue DEFAULT_INSTANCE = null;
    private static final Parser<BytesValue> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private ByteString value_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements BytesValueOrBuilder {
        private int bitField0_;
        private ByteString value_;

        private Builder() {
            this.value_ = ByteString.EMPTY;
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.value_ = ByteString.EMPTY;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(BytesValue r10) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            BytesValue.access$302(r10, this.value_);
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BytesValue build() {
            BytesValue r10 = buildPartial();
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
        public BytesValue buildPartial() {
            BytesValue r10 = new BytesValue(this, null);
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
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.value_ = ByteString.EMPTY;
            return this;
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

        public Builder clearValue() {
            this.bitField0_ &= -2;
            this.value_ = BytesValue.getDefaultInstance().getValue();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BytesValue getDefaultInstanceForType() {
            return BytesValue.getDefaultInstance();
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
            return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
        }

        @Override // com.google.protobuf.BytesValueOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, Builder.class);
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

        public Builder mergeFrom(BytesValue r10) {
            if (r10 != BytesValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getValue().isEmpty() == true) goto L8;
            setValue(r10.getValue());
        L8:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            Objects.requireNonNull(r11);
            boolean r12 = false;
        L3:
            if (r12 == true) goto L21;
            int r13 = r10.readTag();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            if (r13 == 0) goto L13;
            if (r13 != 10) goto L9;
            this.value_ = r10.readBytes();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            goto L3
        L9:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L13:
            r12 = true;
            goto L3
        L16:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            onChanged();
            throw th;
        L21:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof BytesValue) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((BytesValue) r10);
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

        public Builder setValue(ByteString r10) {
            Objects.requireNonNull(r10);
            this.value_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", BytesValue.class.getName());
        DEFAULT_INSTANCE = new BytesValue();
        PARSER = new AnonymousClass1();
    }

    private BytesValue() {
        ByteString r10 = ByteString.EMPTY;
        this.value_ = r10;
        this.memoizedIsInitialized = -1;
        this.value_ = r10;
    }

    private BytesValue(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.value_ = ByteString.EMPTY;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ BytesValue(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ ByteString access$302(BytesValue r10, ByteString r11) {
        r10.value_ = r11;
        return r11;
    }

    public static BytesValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BytesValue r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static BytesValue of(ByteString r10) {
        return newBuilder().setValue(r10).build();
    }

    public static BytesValue parseDelimitedFrom(InputStream r10) {
        return (BytesValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static BytesValue parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (BytesValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static BytesValue parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static BytesValue parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static BytesValue parseFrom(CodedInputStream r10) {
        return (BytesValue) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static BytesValue parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (BytesValue) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static BytesValue parseFrom(InputStream r10) {
        return (BytesValue) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static BytesValue parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (BytesValue) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static BytesValue parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static BytesValue parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static BytesValue parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static BytesValue parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<BytesValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof BytesValue) == false) goto L8;
        BytesValue r11 = (BytesValue) r10;
        if (getValue().equals(r11.getValue()) == true) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public BytesValue getDefaultInstanceForType() {
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

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<BytesValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (this.value_.isEmpty() == true) goto L8;
        r11 = 0 + CodedOutputStream.computeBytesSize(1, this.value_);
    L8:
        int r12 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.google.protobuf.BytesValueOrBuilder
    public ByteString getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getValue().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r11;
        return r11;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, Builder.class);
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
    protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return new Builder(r10, null);
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
        if (this.value_.isEmpty() == true) goto L5;
        r10.writeBytes(1, this.value_);
    L5:
        getUnknownFields().writeTo(r10);
    }
}
