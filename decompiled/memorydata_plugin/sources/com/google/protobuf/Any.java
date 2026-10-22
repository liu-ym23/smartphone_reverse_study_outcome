package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class Any extends GeneratedMessage implements AnyOrBuilder {
    private static final Any DEFAULT_INSTANCE = null;
    private static final Parser<Any> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Message cachedUnpackValue;
    private byte memoizedIsInitialized;
    private volatile Object typeUrl_;
    private ByteString value_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AnyOrBuilder {
        private int bitField0_;
        private Object typeUrl_;
        private ByteString value_;

        private Builder() {
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(Any r3) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L6;
            Any.access$302(r3, this.typeUrl_);
        L6:
            if ((r0 & 2) == 0) goto L9;
            Any.access$402(r3, this.value_);
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any build() {
            Any r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
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
        public Any buildPartial() {
            Any r0 = new Any(this, null);
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
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.typeUrl_ = "";
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

        public Builder clearTypeUrl() {
            this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.bitField0_ &= -3;
            this.value_ = Any.getDefaultInstance().getValue();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Any getDefaultInstanceForType() {
            return Any.getDefaultInstance();
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
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public String getTypeUrl() {
            Object r0 = this.typeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.typeUrl_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getTypeUrlBytes() {
            Object r0 = this.typeUrl_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.typeUrl_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
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

        public Builder mergeFrom(Any r2) {
            if (r2 != Any.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.getTypeUrl().isEmpty() == true) goto L9;
            this.typeUrl_ = Any.access$300(r2);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r2.getValue().isEmpty() == true) goto L11;
            setValue(r2.getValue());
        L11:
            mergeUnknownFields(r2.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L24;
            int r1 = r5.readTag();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r1 == 0) goto L16;
            if (r1 != 10) goto L9;
            this.typeUrl_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (r1 != 18) goto L11;
            this.value_ = r5.readBytes();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L11:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L16:
            r0 = true;
            goto L3
        L17:
            th = move-exception;
            onChanged();
            throw th;
        L19:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L17
        L24:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Any.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Any) ZeusTransformUtils.preCheckCast(r4, Any.class, "com.obric.memorydata.plugin"));
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

        public Builder setTypeUrl(String r1) {
            Objects.requireNonNull(r1);
            this.typeUrl_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.typeUrl_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setValue(ByteString r1) {
            Objects.requireNonNull(r1);
            this.value_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Any.class.getName());
        DEFAULT_INSTANCE = new Any();
        PARSER = new AnonymousClass1();
    }

    private Any() {
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        this.memoizedIsInitialized = -1;
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    private Any(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Any(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Object access$300(Any r0) {
        return r0.typeUrl_;
    }

    static /* synthetic */ Object access$302(Any r0, Object r1) {
        r0.typeUrl_ = r1;
        return r1;
    }

    static /* synthetic */ ByteString access$402(Any r0, ByteString r1) {
        r0.value_ = r1;
        return r1;
    }

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    private static String getTypeNameFromTypeUrl(String r2) {
        int r0 = r2.lastIndexOf(47);
        if (r0 != (-1)) goto L6;
        return "";
    L6:
        return r2.substring(r0 + 1);
    }

    private static String getTypeUrl(String r2, Descriptors.Descriptor r3) {
        if (r2.endsWith("/") == false) goto L5;
        StringBuilder r4 = new StringBuilder().append(r2);
    L7:
        return r4.append(r3.getFullName()).toString();
    L5:
        r4 = new StringBuilder().append(r2).append("/");
        goto L7
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Any r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static <T extends Message> Any pack(T r3) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
        return newBuilder().setTypeUrl(getTypeUrl("type.googleapis.com", r4.getDescriptorForType())).setValue(r4.toByteString()).build();
    }

    public static <T extends Message> Any pack(T r2, String r3) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
        return newBuilder().setTypeUrl(getTypeUrl(r3, r4.getDescriptorForType())).setValue(r4.toByteString()).build();
    }

    public static Any parseDelimitedFrom(InputStream r2) {
        return (Any) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Any) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(ByteString r2) {
        return (Any) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Any) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(CodedInputStream r2) {
        return (Any) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Any) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(InputStream r2) {
        return (Any) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Any) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(ByteBuffer r2) {
        return (Any) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Any) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(byte[] r2) {
        return (Any) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Any parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Any) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Any.class, "com.obric.memorydata.plugin");
    }

    public static Parser<Any> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Any.class) == false) goto L8;
        Any r6 = (Any) ZeusTransformUtils.preCheckCast(r5, Any.class, "com.obric.memorydata.plugin");
        if (getTypeUrl().equals(r6.getTypeUrl()) == true) goto L13;
        return false;
    L13:
        if (getValue().equals(r6.getValue()) == true) goto L16;
        return false;
    L16:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        return super.equals(r5);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Any getDefaultInstanceForType() {
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
    public Parser<Any> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L9;
        r1 = 0 + GeneratedMessage.computeStringSize(1, this.typeUrl_);
    L9:
        if (this.value_.isEmpty() == true) goto L11;
        r1 = r1 + CodedOutputStream.computeBytesSize(2, this.value_);
    L11:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public String getTypeUrl() {
        Object r0 = this.typeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.typeUrl_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getTypeUrlBytes() {
        Object r0 = this.typeUrl_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.typeUrl_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTypeUrl().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r0;
        return r0;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
    }

    public <T extends Message> boolean is(Class<T> r3) {
        Message r4 = (Message) ZeusTransformUtils.preCheckCast(Internal.getDefaultInstance(r3), Message.class, "com.obric.memorydata.plugin");
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(r4.getDescriptorForType().getFullName());
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

    public boolean isSameTypeAs(Message r3) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(r4.getDescriptorForType().getFullName());
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

    public <T extends Message> T unpack(Class<T> r3) {
        if (this.cachedUnpackValue != null) goto L5;
        boolean r0 = false;
    L10:
        if (r0 == true) goto L16;
        if (is(r3) == false) goto L16;
        T r4 = (T) ZeusTransformUtils.preCheckCast(((Message) ZeusTransformUtils.preCheckCast(Internal.getDefaultInstance(r3), Message.class, "com.obric.memorydata.plugin")).getParserForType().parseFrom(getValue()), Message.class, "com.obric.memorydata.plugin");
        this.cachedUnpackValue = r4;
        return r4;
    L16:
        throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
    L5:
        if (this.cachedUnpackValue.getClass() == r3) goto L7;
        r0 = true;
        goto L10
    L7:
        return (T) this.cachedUnpackValue;
    }

    public <T extends Message> T unpackSameTypeAs(T r4) {
        Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
        if (this.cachedUnpackValue != null) goto L5;
        boolean r0 = false;
    L10:
        if (r0 == true) goto L16;
        if (isSameTypeAs(r5) == false) goto L16;
        T r6 = (T) ZeusTransformUtils.preCheckCast(r5.getParserForType().parseFrom(getValue()), Message.class, "com.obric.memorydata.plugin");
        this.cachedUnpackValue = r6;
        return r6;
    L16:
        throw new InvalidProtocolBufferException("Type of the Any message does not match the given exemplar.");
    L5:
        if (this.cachedUnpackValue.getClass() == r5.getClass()) goto L7;
        r0 = true;
        goto L10
    L7:
        return (T) this.cachedUnpackValue;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r3) {
        if (GeneratedMessage.isStringEmpty(this.typeUrl_) == true) goto L6;
        GeneratedMessage.writeString(r3, 1, this.typeUrl_);
    L6:
        if (this.value_.isEmpty() == true) goto L8;
        r3.writeBytes(2, this.value_);
    L8:
        getUnknownFields().writeTo(r3);
    }
}
