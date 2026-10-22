package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
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

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.values_ = Collections.emptyList();
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(ListValue r1) {
        }

        private void buildPartialRepeatedFields(ListValue r2) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 == null) goto L5;
            List r1 = r0.build();
        L9:
            ListValue.access$302(r2, r1);
            return;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.values_ = Collections.unmodifiableList(this.values_);
            this.bitField0_ &= -2;
        L7:
            r1 = this.values_;
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
            List<Value> r1 = this.values_;
            boolean r3 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r3 = false;
        L8:
            this.valuesBuilder_ = new RepeatedFieldBuilder(r1, r3, getParentForChildren(), isClean());
            this.values_ = null;
        L10:
            return this.valuesBuilder_;
        }

        public Builder addAllValues(Iterable<? extends Value> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            ensureValuesIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.values_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addValues(int r2, Value.Builder r3) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addValues(int r2, Value r3) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureValuesIsMutable();
            this.values_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addValues(Value.Builder r2) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addValues(Value r2) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureValuesIsMutable();
            this.values_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Value.Builder addValuesBuilder() {
            return (Value.Builder) ZeusTransformUtils.preCheckCast(internalGetValuesFieldBuilder().addBuilder(Value.getDefaultInstance()), Value.Builder.class, "com.obric.memorydata.plugin");
        }

        public Value.Builder addValuesBuilder(int r2) {
            return (Value.Builder) ZeusTransformUtils.preCheckCast(internalGetValuesFieldBuilder().addBuilder(r2, Value.getDefaultInstance()), Value.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ListValue build() {
            ListValue r1 = buildPartial();
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
        public ListValue buildPartial() {
            ListValue r0 = new ListValue(this, null);
            buildPartialRepeatedFields(r0);
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
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            this.values_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            return this;
        L5:
            this.values_ = null;
            r0.clear();
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
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            this.values_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
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
        public Value getValues(int r3) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.values_.get(r3);
        L6:
            return (Value) ZeusTransformUtils.preCheckCast(r2, Value.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public Value.Builder getValuesBuilder(int r2) {
            return (Value.Builder) ZeusTransformUtils.preCheckCast(internalGetValuesFieldBuilder().getBuilder(r2), Value.Builder.class, "com.obric.memorydata.plugin");
        }

        public List<Value.Builder> getValuesBuilderList() {
            return internalGetValuesFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public int getValuesCount() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L7;
            return this.values_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<Value> getValuesList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.values_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public ValueOrBuilder getValuesOrBuilder(int r3) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.values_.get(r3);
        L6:
            return (ValueOrBuilder) ZeusTransformUtils.preCheckCast(r2, ValueOrBuilder.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
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
        public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r6) {
            Objects.requireNonNull(r6);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L24;
            int r1 = r5.readTag();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r1 == 0) goto L16;
            if (r1 != 10) goto L9;
            Value r2 = (Value) ZeusTransformUtils.preCheckCast(r5.readMessage(Value.parser(), r6), Value.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r3 = this.valuesBuilder_;     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            if (r3 == null) goto L13;
            r3.addMessage(r2);     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L13:
            ensureValuesIsMutable();     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            this.values_.add(r2);     // Catch: Throwable -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (super.parseUnknownField(r5, r6, r1) == true) goto L3;
        L16:
            r0 = true;
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

        public Builder mergeFrom(ListValue r3) {
            if (r3 != ListValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (this.valuesBuilder_ != null) goto L15;
            if (ListValue.access$300(r3).isEmpty() == false) goto L10;
        L23:
            mergeUnknownFields(r3.getUnknownFields());
            onChanged();
            return this;
        L10:
            if (this.values_.isEmpty() == false) goto L12;
            this.values_ = ListValue.access$300(r3);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L23
        L12:
            ensureValuesIsMutable();
            this.values_.addAll(ListValue.access$300(r3));
            goto L13
        L15:
            if (ListValue.access$300(r3).isEmpty() == true) goto L23;
            if (this.valuesBuilder_.isEmpty() == false) goto L22;
            this.valuesBuilder_.dispose();
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = null;
            this.valuesBuilder_ = null;
            this.values_ = ListValue.access$300(r3);
            this.bitField0_ &= -2;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L21;
            r0 = internalGetValuesFieldBuilder();
        L21:
            this.valuesBuilder_ = r0;
            goto L23
        L22:
            this.valuesBuilder_.addAllMessages(ListValue.access$300(r3));
            goto L23
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, ListValue.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((ListValue) ZeusTransformUtils.preCheckCast(r4, ListValue.class, "com.obric.memorydata.plugin"));
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

        public Builder removeValues(int r2) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder setValues(int r2, Value.Builder r3) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            ensureValuesIsMutable();
            this.values_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setValues(int r2, Value r3) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> r0 = this.valuesBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureValuesIsMutable();
            this.values_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
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

    private ListValue(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ ListValue(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ List access$300(ListValue r0) {
        return r0.values_;
    }

    static /* synthetic */ List access$302(ListValue r2, List r3) {
        List<Value> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.values_ = r4;
        return r4;
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

    public static Builder newBuilder(ListValue r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static ListValue parseDelimitedFrom(InputStream r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(ByteString r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(CodedInputStream r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(InputStream r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(ByteBuffer r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(byte[] r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static ListValue parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (ListValue) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), ListValue.class, "com.obric.memorydata.plugin");
    }

    public static Parser<ListValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ListValue.class) == false) goto L8;
        ListValue r5 = (ListValue) ZeusTransformUtils.preCheckCast(r4, ListValue.class, "com.obric.memorydata.plugin");
        if (getValuesList().equals(r5.getValuesList()) == true) goto L13;
        return false;
    L13:
        if (getUnknownFields().equals(r5.getUnknownFields()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        return super.equals(r4);
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
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.values_.size()) goto L9;
        r2 = r2 + CodedOutputStream.computeMessageSize(1, (MessageLite) ZeusTransformUtils.preCheckCast(this.values_.get(r1), MessageLite.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = r2 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r3;
        return r3;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public Value getValues(int r2) {
        return (Value) ZeusTransformUtils.preCheckCast(this.values_.get(r2), Value.class, "com.obric.memorydata.plugin");
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
    public ValueOrBuilder getValuesOrBuilder(int r2) {
        return (ValueOrBuilder) ZeusTransformUtils.preCheckCast(this.values_.get(r2), ValueOrBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = 779 + getDescriptor().hashCode();
        if (getValuesCount() <= 0) goto L9;
        r0 = (((r0 * 37) + 1) * 53) + getValuesList().hashCode();
    L9:
        int r1 = (r0 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, Builder.class);
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
        int r0 = 0;
    L4:
        if (r0 >= this.values_.size()) goto L6;
        r5.writeMessage(1, (MessageLite) ZeusTransformUtils.preCheckCast(this.values_.get(r0), MessageLite.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L4
    L6:
        getUnknownFields().writeTo(r5);
    }
}
