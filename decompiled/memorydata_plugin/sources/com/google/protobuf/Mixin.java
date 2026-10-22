package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
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

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.name_ = "";
            this.root_ = "";
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(Mixin r3) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L6;
            Mixin.access$302(r3, this.name_);
        L6:
            if ((r0 & 2) == 0) goto L9;
            Mixin.access$402(r3, this.root_);
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
            Mixin r1 = buildPartial();
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
        public Mixin buildPartial() {
            Mixin r0 = new Mixin(this, null);
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
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public ByteString getNameBytes() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.name_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public String getRoot() {
            Object r0 = this.root_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.root_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public ByteString getRootBytes() {
            Object r0 = this.root_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.root_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(Mixin.class, Builder.class);
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
            if (r0 == true) goto L24;
            int r1 = r5.readTag();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r1 == 0) goto L16;
            if (r1 != 10) goto L9;
            this.name_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (r1 != 18) goto L11;
            this.root_ = r5.readStringRequireUtf8();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
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
            if (ZeusTransformUtils.instanceOf(r4, Mixin.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Mixin) ZeusTransformUtils.preCheckCast(r4, Mixin.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(Mixin r2) {
            if (r2 != Mixin.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r2.getName().isEmpty() == true) goto L9;
            this.name_ = Mixin.access$300(r2);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r2.getRoot().isEmpty() == true) goto L11;
            this.root_ = Mixin.access$400(r2);
            this.bitField0_ |= 2;
            onChanged();
        L11:
            mergeUnknownFields(r2.getUnknownFields());
            onChanged();
            return this;
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

        public Builder setRoot(String r1) {
            Objects.requireNonNull(r1);
            this.root_ = r1;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setRootBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.root_ = r1;
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

    private Mixin(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.name_ = "";
        this.root_ = "";
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Mixin(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Object access$300(Mixin r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$302(Mixin r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$400(Mixin r0) {
        return r0.root_;
    }

    static /* synthetic */ Object access$402(Mixin r0, Object r1) {
        r0.root_ = r1;
        return r1;
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

    public static Builder newBuilder(Mixin r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static Mixin parseDelimitedFrom(InputStream r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(ByteString r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(CodedInputStream r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(InputStream r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(ByteBuffer r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(byte[] r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Mixin parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Mixin.class, "com.obric.memorydata.plugin");
    }

    public static Parser<Mixin> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Mixin.class) == false) goto L8;
        Mixin r6 = (Mixin) ZeusTransformUtils.preCheckCast(r5, Mixin.class, "com.obric.memorydata.plugin");
        if (getName().equals(r6.getName()) == true) goto L13;
        return false;
    L13:
        if (getRoot().equals(r6.getRoot()) == true) goto L16;
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
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Mixin> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public String getRoot() {
        Object r0 = this.root_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.root_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public ByteString getRootBytes() {
        Object r0 = this.root_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.root_ = r1;
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
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L9;
        r1 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
    L9:
        if (GeneratedMessage.isStringEmpty(this.root_) == true) goto L11;
        r1 = r1 + GeneratedMessage.computeStringSize(2, this.root_);
    L11:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRoot().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r0;
        return r0;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(Mixin.class, Builder.class);
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
    public void writeTo(CodedOutputStream r3) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L6;
        GeneratedMessage.writeString(r3, 1, this.name_);
    L6:
        if (GeneratedMessage.isStringEmpty(this.root_) == true) goto L8;
        GeneratedMessage.writeString(r3, 2, this.root_);
    L8:
        getUnknownFields().writeTo(r3);
    }
}
