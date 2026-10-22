package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Mixin extends GeneratedMessage implements MixinOrBuilder {
    private static final Mixin DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final Parser<Mixin> PARSER = null;
    public static final int ROOT_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object root_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements MixinOrBuilder {
        private int bitField0_;
        private Object name_;
        private Object root_;

        private Builder() {
            this.name_ = "";
            this.root_ = "";
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.root_ = "";
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Mixin r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L6;
            Mixin.access$302(r10, this.name_);
        L6:
            if ((r11 & 2) == 0) goto L9;
            Mixin.access$402(r10, this.root_);
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApiProto.internal_static_google_protobuf_Mixin_descriptor;
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
        public Mixin build() {
            Mixin r10 = buildPartial();
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
        public Mixin buildPartial() {
            Mixin r10 = new Mixin(this, null);
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
            this.root_ = "";
            return this;
        }

        public Builder clearName() {
            this.name_ = Mixin.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearRoot() {
            this.root_ = Mixin.getDefaultInstance().getRoot();
            this.bitField0_ &= -3;
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
        public Mixin getDefaultInstanceForType() {
            return Mixin.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Mixin_descriptor;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public String getRoot() {
            Object r10 = this.root_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.root_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public ByteString getRootBytes() {
            Object r10 = this.root_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.root_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(Mixin.class, Builder.class);
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
            this.root_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L11:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L16:
            r12 = true;
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
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Mixin) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Mixin) r10);
        }

        public Builder mergeFrom(Mixin r10) {
            if (r10 != Mixin.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L9;
            this.name_ = Mixin.access$300(r10);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r10.getRoot().isEmpty() == true) goto L11;
            this.root_ = Mixin.access$400(r10);
            this.bitField0_ |= 2;
            onChanged();
        L11:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
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

        public Builder setRoot(String r10) {
            Objects.requireNonNull(r10);
            this.root_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setRootBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.root_ = r10;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Mixin.class.getName());
        DEFAULT_INSTANCE = new Mixin();
        PARSER = new AnonymousClass1();
    }

    private Mixin() {
        this.name_ = "";
        this.root_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.root_ = "";
    }

    private Mixin(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.name_ = "";
        this.root_ = "";
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Mixin(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ Object access$300(Mixin r10) {
        return r10.name_;
    }

    static /* synthetic */ Object access$302(Mixin r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$400(Mixin r10) {
        return r10.root_;
    }

    static /* synthetic */ Object access$402(Mixin r10, Object r11) {
        r10.root_ = r11;
        return r11;
    }

    public static Mixin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Mixin_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Mixin r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Mixin parseDelimitedFrom(InputStream r10) {
        return (Mixin) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Mixin parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Mixin) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Mixin parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Mixin parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Mixin parseFrom(CodedInputStream r10) {
        return (Mixin) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Mixin parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Mixin) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Mixin parseFrom(InputStream r10) {
        return (Mixin) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Mixin parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Mixin) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Mixin parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Mixin parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Mixin parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Mixin parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Mixin> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Mixin) == false) goto L8;
        Mixin r11 = (Mixin) r10;
        if (getName().equals(r11.getName()) == true) goto L13;
        return false;
    L13:
        if (getRoot().equals(r11.getRoot()) == true) goto L16;
        return false;
    L16:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L18;
        return false;
    L18:
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
    public Mixin getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MixinOrBuilder
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
    public Parser<Mixin> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public String getRoot() {
        Object r10 = this.root_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.root_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public ByteString getRootBytes() {
        Object r10 = this.root_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.root_ = r11;
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
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L9;
        r11 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
    L9:
        if (GeneratedMessage.isStringEmpty(this.root_) == true) goto L11;
        r11 = r11 + GeneratedMessage.computeStringSize(2, this.root_);
    L11:
        int r12 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRoot().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r11;
        return r11;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(Mixin.class, Builder.class);
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
        if (GeneratedMessage.isStringEmpty(this.root_) == true) goto L8;
        GeneratedMessage.writeString(r10, 2, this.root_);
    L8:
        getUnknownFields().writeTo(r10);
    }
}
