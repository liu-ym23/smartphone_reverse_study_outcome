package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Struct extends GeneratedMessage implements StructOrBuilder {
    private static final Struct DEFAULT_INSTANCE = null;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static final Parser<Struct> PARSER = null;
    private static final long serialVersionUID = 0;
    private MapField<String, Value> fields_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements StructOrBuilder {
        private static final FieldsConverter fieldsConverter = null;
        private int bitField0_;
        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> fields_;

        private static final class FieldsConverter implements MapFieldBuilder.Converter<String, ValueOrBuilder, Value> {
            private FieldsConverter() {
            }

            /* synthetic */ FieldsConverter(AnonymousClass1 r10) {
                this();
            }

            @Override // com.google.protobuf.MapFieldBuilder.Converter
            public /* bridge */ /* synthetic */ MessageOrBuilder build(MessageOrBuilder r10) {
                return build((ValueOrBuilder) r10);
            }

            public Value build(ValueOrBuilder r10) {
                if ((r10 instanceof Value) == false) goto L7;
                return (Value) r10;
            L7:
                return ((Value.Builder) r10).build();
            }

            @Override // com.google.protobuf.MapFieldBuilder.Converter
            public MapEntry<String, Value> defaultEntry() {
                return FieldsDefaultEntryHolder.defaultEntry;
            }
        }

        static {
            fieldsConverter = new FieldsConverter(null);
        }

        private Builder() {
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Struct r10) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            Struct.access$302(r10, internalGetFields().build(FieldsDefaultEntryHolder.defaultEntry));
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> internalGetFields() {
            MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> r10 = this.fields_;
            if (r10 == null) goto L5;
            return r10;
        L5:
            return new MapFieldBuilder(fieldsConverter);
        }

        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> internalGetMutableFields() {
            if (this.fields_ != null) goto L5;
            this.fields_ = new MapFieldBuilder(fieldsConverter);
        L5:
            this.bitField0_ |= 1;
            onChanged();
            return this.fields_;
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
        public Struct build() {
            Struct r10 = buildPartial();
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
        public Struct buildPartial() {
            Struct r10 = new Struct(this, null);
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
            internalGetMutableFields().clear();
            return this;
        }

        public Builder clearFields() {
            this.bitField0_ &= -2;
            internalGetMutableFields().clear();
            return this;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public boolean containsFields(String r10) {
            Objects.requireNonNull(r10, "map key");
            return internalGetFields().ensureBuilderMap().containsKey(r10);
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
        public Struct getDefaultInstanceForType() {
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        @Override // com.google.protobuf.StructOrBuilder
        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public int getFieldsCount() {
            return internalGetFields().ensureBuilderMap().size();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Map<String, Value> getFieldsMap() {
            return internalGetFields().getImmutableMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrDefault(String r10, Value r11) {
            Objects.requireNonNull(r10, "map key");
            Map<String, MessageOrBuilderT> r12 = internalGetMutableFields().ensureBuilderMap();
            if (r12.containsKey(r10) == true) goto L5;
            return r11;
        L5:
            return fieldsConverter.build((ValueOrBuilder) r12.get(r10));
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrThrow(String r10) {
            Objects.requireNonNull(r10, "map key");
            Map<String, MessageOrBuilderT> r11 = internalGetMutableFields().ensureBuilderMap();
            if (r11.containsKey(r10) == false) goto L7;
            return fieldsConverter.build((ValueOrBuilder) r11.get(r10));
        L7:
            throw new IllegalArgumentException();
        }

        @Deprecated
        public Map<String, Value> getMutableFields() {
            this.bitField0_ |= 1;
            return internalGetMutableFields().ensureMessageMap();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected MapFieldReflectionAccessor internalGetMapFieldReflection(int r10) {
            if (r10 != 1) goto L7;
            return internalGetFields();
        L7:
            throw new RuntimeException("Invalid map field number: " + r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int r10) {
            if (r10 != 1) goto L7;
            return internalGetMutableFields();
        L7:
            throw new RuntimeException("Invalid map field number: " + r10);
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
            if (r12 == true) goto L21;
            int r13 = r10.readTag();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            if (r13 == 0) goto L13;
            if (r13 != 10) goto L9;
            MapEntry r14 = (MapEntry) r10.readMessage(FieldsDefaultEntryHolder.defaultEntry.getParserForType(), r11);     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            internalGetMutableFields().ensureBuilderMap().put((String) r14.getKey(), (ValueOrBuilder) r14.getValue());     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
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
            if ((r10 instanceof Struct) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Struct) r10);
        }

        public Builder mergeFrom(Struct r10) {
            if (r10 != Struct.getDefaultInstance()) goto L5;
            return this;
        L5:
            internalGetMutableFields().mergeFrom(Struct.access$400(r10));
            this.bitField0_ |= 1;
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        }

        public Builder putAllFields(Map<String, Value> r10) {
            Iterator<Map.Entry<String, Value>> r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            Map.Entry<String, Value> r12 = r11.next();
            if (r12.getKey() == null) goto L11;
            if (r12.getValue() != null) goto L4;
        L11:
            throw null;
        L12:
            internalGetMutableFields().ensureBuilderMap().putAll(r10);
            this.bitField0_ |= 1;
            return this;
        }

        public Builder putFields(String r10, Value r11) {
            Objects.requireNonNull(r10, "map key");
            Objects.requireNonNull(r11, "map value");
            internalGetMutableFields().ensureBuilderMap().put(r10, r11);
            this.bitField0_ |= 1;
            return this;
        }

        public Value.Builder putFieldsBuilderIfAbsent(String r10) {
            Map<String, MessageOrBuilderT> r11 = internalGetMutableFields().ensureBuilderMap();
            Object r12 = (ValueOrBuilder) r11.get(r10);
            if (r12 != null) goto L6;
            r12 = Value.newBuilder();
            r11.put(r10, r12);
        L6:
            if ((r12 instanceof Value) == false) goto L9;
            r12 = ((Value) r12).toBuilder();
            r11.put(r10, r12);
        L9:
            return (Value.Builder) r12;
        }

        public Builder removeFields(String r10) {
            Objects.requireNonNull(r10, "map key");
            internalGetMutableFields().ensureBuilderMap().remove(r10);
            return this;
        }
    }

    private static final class FieldsDefaultEntryHolder {
        static final MapEntry<String, Value> defaultEntry = null;

        static {
            defaultEntry = MapEntry.newDefaultInstance(StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());
        }

        private FieldsDefaultEntryHolder() {
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Struct.class.getName());
        DEFAULT_INSTANCE = new Struct();
        PARSER = new AnonymousClass1();
    }

    private Struct() {
        this.memoizedIsInitialized = -1;
    }

    private Struct(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Struct(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ MapField access$302(Struct r10, MapField r11) {
        r10.fields_ = r11;
        return r11;
    }

    static /* synthetic */ MapField access$400(Struct r10) {
        return r10.internalGetFields();
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    private MapField<String, Value> internalGetFields() {
        MapField<String, Value> r10 = this.fields_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Struct r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Struct parseDelimitedFrom(InputStream r10) {
        return (Struct) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Struct parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Struct) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Struct parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Struct parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Struct parseFrom(CodedInputStream r10) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Struct parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Struct parseFrom(InputStream r10) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Struct parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Struct parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Struct parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Struct parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Struct parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Struct> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(String r10) {
        Objects.requireNonNull(r10, "map key");
        return internalGetFields().getMap().containsKey(r10);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Struct) == false) goto L8;
        Struct r11 = (Struct) r10;
        if (internalGetFields().equals(r11.internalGetFields()) == true) goto L13;
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
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.StructOrBuilder
    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return internalGetFields().getMap().size();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Map<String, Value> getFieldsMap() {
        return internalGetFields().getMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrDefault(String r10, Value r11) {
        Objects.requireNonNull(r10, "map key");
        Map<String, Value> r12 = internalGetFields().getMap();
        if (r12.containsKey(r10) == true) goto L5;
        return r11;
    L5:
        return r12.get(r10);
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrThrow(String r10) {
        Objects.requireNonNull(r10, "map key");
        Map<String, Value> r11 = internalGetFields().getMap();
        if (r11.containsKey(r10) == false) goto L7;
        return r11.get(r10);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Struct> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        Iterator<Map.Entry<String, Value>> r12 = internalGetFields().getMap().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, Value> r13 = r12.next();
        r11 = r11 + CodedOutputStream.computeMessageSize(1, FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(r13.getKey()).setValue(r13.getValue()).build());
        goto L7
    L9:
        int r14 = r11 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r14;
        return r14;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = 779 + getDescriptor().hashCode();
        if (internalGetFields().getMap().isEmpty() == true) goto L8;
        r11 = (((r11 * 37) + 1) * 53) + internalGetFields().hashCode();
    L8:
        int r12 = (r11 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected MapFieldReflectionAccessor internalGetMapFieldReflection(int r10) {
        if (r10 != 1) goto L7;
        return internalGetFields();
    L7:
        throw new RuntimeException("Invalid map field number: " + r10);
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
        GeneratedMessage.serializeStringMapTo(r10, internalGetFields(), FieldsDefaultEntryHolder.defaultEntry, 1);
        getUnknownFields().writeTo(r10);
    }
}
