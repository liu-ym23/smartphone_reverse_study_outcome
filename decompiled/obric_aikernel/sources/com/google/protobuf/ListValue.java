package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ListValue extends GeneratedMessage implements ListValueOrBuilder {
    private static final ListValue DEFAULT_INSTANCE = null;
    private static final Parser<ListValue> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<Value> values_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ListValueOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> valuesBuilder_;
        private List<Value> values_;

        private Builder() {
            this.values_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.values_ = Collections.emptyList();
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(ListValue r10) {
        }

        private void buildPartialRepeatedFields(ListValue r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 == null) goto L5;
            List r12 = r11.build();
        L9:
            ListValue.access$302(r10, r12);
            return;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.values_ = Collections.unmodifiableList(this.values_);
            this.bitField0_ &= -2;
        L7:
            r12 = this.values_;
            goto L9
        }

        private void ensureValuesIsMutable() {
            if ((this.bitField0_ & 1) != 0) goto L6;
            this.values_ = new ArrayList(this.values_);
            this.bitField0_ |= 1;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_ListValue_descriptor;
        }

        private RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> internalGetValuesFieldBuilder() {
            if (this.valuesBuilder_ != null) goto L10;
            List<Value> r10 = this.values_;
            boolean r11 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r11 = false;
        L8:
            this.valuesBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.values_ = null;
        L10:
            return this.valuesBuilder_;
        }

        public Builder addAllValues(Iterable<? extends Value> r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L5;
            ensureValuesIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.values_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addValues(int r10, Value.Builder r11) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r12 = this.valuesBuilder_;
            if (r12 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addValues(int r10, Value r11) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r12 = this.valuesBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureValuesIsMutable();
            this.values_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addValues(Value.Builder r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addValues(Value r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureValuesIsMutable();
            this.values_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public Value.Builder addValuesBuilder() {
            return (Value.Builder) internalGetValuesFieldBuilder().addBuilder(Value.getDefaultInstance());
        }

        public Value.Builder addValuesBuilder(int r10) {
            return (Value.Builder) internalGetValuesFieldBuilder().addBuilder(r10, Value.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ListValue build() {
            ListValue r10 = buildPartial();
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
        public ListValue buildPartial() {
            ListValue r10 = new ListValue(this, null);
            buildPartialRepeatedFields(r10);
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
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L5;
            this.values_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            return this;
        L5:
            this.values_ = null;
            r10.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder clearValues() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L5;
            this.values_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ListValue getDefaultInstanceForType() {
            return ListValue.getDefaultInstance();
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
            return StructProto.internal_static_google_protobuf_ListValue_descriptor;
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public Value getValues(int r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.values_.get(r10);
        L6:
            return (Value) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public Value.Builder getValuesBuilder(int r10) {
            return (Value.Builder) internalGetValuesFieldBuilder().getBuilder(r10);
        }

        public List<Value.Builder> getValuesBuilderList() {
            return internalGetValuesFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public int getValuesCount() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L7;
            return this.values_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<Value> getValuesList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.values_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public ValueOrBuilder getValuesOrBuilder(int r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.values_.get(r10);
        L6:
            return (ValueOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.values_);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, Builder.class);
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
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            Objects.requireNonNull(r11);
            boolean r12 = false;
        L3:
            if (r12 == true) goto L24;
            int r13 = r10.readTag();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r13 == 0) goto L16;
            if (r13 != 10) goto L9;
            Value r14 = (Value) r10.readMessage(Value.parser(), r11);     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r15 = this.valuesBuilder_;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r15 == null) goto L13;
            r15.addMessage(r14);     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L13:
            ensureValuesIsMutable();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.values_.add(r14);     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
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

        public Builder mergeFrom(ListValue r10) {
            if (r10 != ListValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (this.valuesBuilder_ != null) goto L15;
            if (ListValue.access$300(r10).isEmpty() == false) goto L10;
        L23:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L10:
            if (this.values_.isEmpty() == false) goto L12;
            this.values_ = ListValue.access$300(r10);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L23
        L12:
            ensureValuesIsMutable();
            this.values_.addAll(ListValue.access$300(r10));
            goto L13
        L15:
            if (ListValue.access$300(r10).isEmpty() == true) goto L23;
            if (this.valuesBuilder_.isEmpty() == false) goto L22;
            this.valuesBuilder_.dispose();
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = null;
            this.valuesBuilder_ = null;
            this.values_ = ListValue.access$300(r10);
            this.bitField0_ &= -2;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L21;
            r11 = internalGetValuesFieldBuilder();
        L21:
            this.valuesBuilder_ = r11;
            goto L23
        L22:
            this.valuesBuilder_.addAllMessages(ListValue.access$300(r10));
            goto L23
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof ListValue) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((ListValue) r10);
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

        public Builder removeValues(int r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder setValues(int r10, Value.Builder r11) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r12 = this.valuesBuilder_;
            if (r12 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setValues(int r10, Value r11) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r12 = this.valuesBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureValuesIsMutable();
            this.values_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", ListValue.class.getName());
        DEFAULT_INSTANCE = new ListValue();
        PARSER = new AnonymousClass1();
    }

    private ListValue() {
        this.memoizedIsInitialized = -1;
        this.values_ = Collections.emptyList();
    }

    private ListValue(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ ListValue(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ List access$300(ListValue r10) {
        return r10.values_;
    }

    static /* synthetic */ List access$302(ListValue r10, List r11) {
        r10.values_ = r11;
        return r11;
    }

    public static ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListValue r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static ListValue parseDelimitedFrom(InputStream r10) {
        return (ListValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static ListValue parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (ListValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static ListValue parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static ListValue parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static ListValue parseFrom(CodedInputStream r10) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static ListValue parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static ListValue parseFrom(InputStream r10) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static ListValue parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static ListValue parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static ListValue parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static ListValue parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static ListValue parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<ListValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ListValue) == false) goto L8;
        ListValue r11 = (ListValue) r10;
        if (getValuesList().equals(r11.getValuesList()) == true) goto L13;
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
    public ListValue getDefaultInstanceForType() {
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
    public Parser<ListValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.values_.size()) goto L9;
        r12 = r12 + CodedOutputStream.computeMessageSize(1, this.values_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r13 = r12 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r13;
        return r13;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public Value getValues(int r10) {
        return this.values_.get(r10);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public int getValuesCount() {
        return this.values_.size();
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public List<Value> getValuesList() {
        return this.values_;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public ValueOrBuilder getValuesOrBuilder(int r10) {
        return this.values_.get(r10);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = 779 + getDescriptor().hashCode();
        if (getValuesCount() <= 0) goto L8;
        r11 = (((r11 * 37) + 1) * 53) + getValuesList().hashCode();
    L8:
        int r12 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, Builder.class);
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
        int r11 = 0;
    L4:
        if (r11 >= this.values_.size()) goto L6;
        r10.writeMessage(1, this.values_.get(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        getUnknownFields().writeTo(r10);
    }
}
