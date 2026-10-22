package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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

        private void buildPartial0(ListValue r8) {
        }

        private void buildPartialRepeatedFields(ListValue r8) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            ListValue.access$302(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.values_ = Collections.unmodifiableList(this.values_);
            this.bitField0_ &= -2;
        L7:
            r11 = this.values_;
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
            List<Value> r8 = this.values_;
            boolean r10 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r10 = false;
        L8:
            this.valuesBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.values_ = null;
        L10:
            return this.valuesBuilder_;
        }

        public Builder addAllValues(Iterable<? extends Value> r8) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L5;
            ensureValuesIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.values_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addValues(int r8, Value.Builder r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public Value.Builder addValuesBuilder() {
            return (Value.Builder) internalGetValuesFieldBuilder().addBuilder(Value.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ListValue build() {
            ListValue r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ListValue buildPartial() {
            ListValue r8 = new ListValue(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearValues() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r8 = this.valuesBuilder_;
            if (r8 != null) goto L5;
            this.values_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public ListValue getDefaultInstanceForType() {
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_ListValue_descriptor;
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public Value getValues(int r8) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.values_.get(r8);
        L6:
            return (Value) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public Value.Builder getValuesBuilder(int r8) {
            return (Value.Builder) internalGetValuesFieldBuilder().getBuilder(r8);
        }

        public List<Value.Builder> getValuesBuilderList() {
            return internalGetValuesFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public int getValuesCount() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r8 = this.valuesBuilder_;
            if (r8 != null) goto L7;
            return this.values_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<Value> getValuesList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r8 = this.valuesBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.values_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public ValueOrBuilder getValuesOrBuilder(int r8) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.values_.get(r8);
        L6:
            return (ValueOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r8 = this.valuesBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.values_);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder removeValues(int r8) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setValues(int r8, Value.Builder r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.values_ = Collections.emptyList();
        }

        public Builder addValues(int r8, Value r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureValuesIsMutable();
            this.values_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public Value.Builder addValuesBuilder(int r8) {
            return (Value.Builder) internalGetValuesFieldBuilder().addBuilder(r8, Value.getDefaultInstance());
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
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        public Builder setValues(int r8, Value r10) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r11 = this.valuesBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureValuesIsMutable();
            this.values_.set(r8, r10);
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

        public Builder addValues(Value.Builder r8) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
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
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r8 = this.valuesBuilder_;
            if (r8 != null) goto L5;
            this.values_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            return this;
        L5:
            this.values_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addValues(Value r8) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = this.valuesBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureValuesIsMutable();
            this.values_.add(r8);
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
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
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
            Value r13 = (Value) r8.readMessage(Value.parser(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r14 = this.valuesBuilder_;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r14 == null) goto L14;
            r14.addMessage(r13);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L14:
            ensureValuesIsMutable();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            this.values_.add(r13);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L10:
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

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder mergeFrom(ListValue r8) {
            if (r8 != ListValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (this.valuesBuilder_ != null) goto L15;
            if (ListValue.access$300(r8).isEmpty() == false) goto L10;
        L23:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L10:
            if (this.values_.isEmpty() == false) goto L12;
            this.values_ = ListValue.access$300(r8);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L23
        L12:
            ensureValuesIsMutable();
            this.values_.addAll(ListValue.access$300(r8));
            goto L13
        L15:
            if (ListValue.access$300(r8).isEmpty() == true) goto L23;
            if (this.valuesBuilder_.isEmpty() == false) goto L22;
            this.valuesBuilder_.dispose();
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r10 = null;
            this.valuesBuilder_ = null;
            this.values_ = ListValue.access$300(r8);
            this.bitField0_ &= -2;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L21;
            r10 = internalGetValuesFieldBuilder();
        L21:
            this.valuesBuilder_ = r10;
            goto L23
        L22:
            this.valuesBuilder_.addAllMessages(ListValue.access$300(r8));
            goto L23
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof ListValue) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((ListValue) r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "ListValue");
        DEFAULT_INSTANCE = new ListValue();
        PARSER = new AnonymousClass1();
    }

    private ListValue() {
        this.memoizedIsInitialized = -1;
        this.values_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$300(ListValue r8) {
        return r8.values_;
    }

    public static /* synthetic */ List access$302(ListValue r8, List r10) {
        r8.values_ = r10;
        return r10;
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

    public static ListValue parseDelimitedFrom(InputStream r8) {
        return (ListValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static ListValue parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<ListValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof ListValue) == false) goto L8;
        ListValue r10 = (ListValue) r8;
        if (getValuesList().equals(r10.getValuesList()) == true) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public ListValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ListValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= this.values_.size()) goto L9;
        r11 = r11 + CodedOutputStream.computeMessageSize(1, this.values_.get(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        int r12 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r12;
        return r12;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public Value getValues(int r8) {
        return this.values_.get(r8);
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
    public ValueOrBuilder getValuesOrBuilder(int r8) {
        return this.values_.get(r8);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (getValuesCount() <= 0) goto L8;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getValuesList().hashCode();
    L8:
        int r11 = getUnknownFields().hashCode();
        int r12 = r11 + (r10 * 29);
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, Builder.class);
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
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.values_.size()) goto L6;
        r8.writeMessage(1, this.values_.get(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        getUnknownFields().writeTo(r8);
    }

    private ListValue(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(ListValue r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static ListValue parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (ListValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static ListValue parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ ListValue(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static ListValue parseFrom(CodedInputStream r8) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public static ListValue parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    public static ListValue parseFrom(InputStream r8) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static ListValue parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static ListValue parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static ListValue parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static ListValue parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static ListValue parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
