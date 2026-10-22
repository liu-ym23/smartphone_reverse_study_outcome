package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class DoubleValue extends GeneratedMessage implements DoubleValueOrBuilder {
    private static final DoubleValue DEFAULT_INSTANCE = null;
    private static final Parser<DoubleValue> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private double value_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements DoubleValueOrBuilder {
        private int bitField0_;
        private double value_;

        private Builder() {
        }

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(DoubleValue r3) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            DoubleValue.access$302(r3, this.value_);
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DoubleValue build() {
            DoubleValue r1 = buildPartial();
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
        public DoubleValue buildPartial() {
            DoubleValue r0 = new DoubleValue(this, null);
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
            this.value_ = 0.0d;
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
            this.value_ = 0.0d;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DoubleValue getDefaultInstanceForType() {
            return DoubleValue.getDefaultInstance();
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
            return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
        }

        @Override // com.google.protobuf.DoubleValueOrBuilder
        public double getValue() {
            return this.value_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, Builder.class);
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
        public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
            Objects.requireNonNull(r7);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L21;
            int r1 = r6.readTag();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            if (r1 == 0) goto L13;
            if (r1 != 9) goto L9;
            this.value_ = r6.readDouble();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            goto L3
        L9:
            if (super.parseUnknownField(r6, r7, r1) == true) goto L3;
        L13:
            r0 = true;
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

        public Builder mergeFrom(DoubleValue r5) {
            if (r5 != DoubleValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (Double.doubleToRawLongBits(r5.getValue()) == 0) goto L8;
            setValue(r5.getValue());
        L8:
            mergeUnknownFields(r5.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, DoubleValue.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((DoubleValue) ZeusTransformUtils.preCheckCast(r4, DoubleValue.class, "com.obric.memorydata.plugin"));
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

        public Builder setValue(double r1) {
            this.value_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", DoubleValue.class.getName());
        DEFAULT_INSTANCE = new DoubleValue();
        PARSER = new AnonymousClass1();
    }

    private DoubleValue() {
        this.value_ = 0.0d;
        this.memoizedIsInitialized = -1;
    }

    private DoubleValue(GeneratedMessage.Builder<?> r3) {
        super(r3);
        this.value_ = 0.0d;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ DoubleValue(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ double access$302(DoubleValue r0, double r1) {
        r0.value_ = r1;
        return r1;
    }

    public static DoubleValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DoubleValue r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static DoubleValue of(double r1) {
        return newBuilder().setValue(r1).build();
    }

    public static DoubleValue parseDelimitedFrom(InputStream r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(ByteString r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(CodedInputStream r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(InputStream r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(ByteBuffer r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(byte[] r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static DoubleValue parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (DoubleValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), DoubleValue.class, "com.obric.memorydata.plugin");
    }

    public static Parser<DoubleValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, DoubleValue.class) == false) goto L8;
        DoubleValue r8 = (DoubleValue) ZeusTransformUtils.preCheckCast(r7, DoubleValue.class, "com.obric.memorydata.plugin");
        if (Double.doubleToLongBits(getValue()) == Double.doubleToLongBits(r8.getValue())) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r8.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r7);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public DoubleValue getDefaultInstanceForType() {
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
    public Parser<DoubleValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (Double.doubleToRawLongBits(this.value_) == 0) goto L8;
        r1 = 0 + CodedOutputStream.computeDoubleSize(1, this.value_);
    L8:
        int r2 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r2;
        return r2;
    }

    @Override // com.google.protobuf.DoubleValueOrBuilder
    public double getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getValue()))) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r0;
        return r0;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, Builder.class);
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

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r5) {
        if (Double.doubleToRawLongBits(this.value_) == 0) goto L5;
        r5.writeDouble(1, this.value_);
    L5:
        getUnknownFields().writeTo(r5);
    }
}
