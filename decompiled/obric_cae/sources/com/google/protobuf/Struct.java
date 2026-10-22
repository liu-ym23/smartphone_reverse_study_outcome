package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

        public static final class FieldsConverter implements MapFieldBuilder.Converter<String, ValueOrBuilder, Value> {
            private FieldsConverter() {
            }

            public /* synthetic */ FieldsConverter(AnonymousClass1 r8) {
                this();
            }

            @Override // com.google.protobuf.MapFieldBuilder.Converter
            public /* bridge */ /* synthetic */ MessageOrBuilder build(MessageOrBuilder r8) {
                return build((ValueOrBuilder) r8);
            }

            @Override // com.google.protobuf.MapFieldBuilder.Converter
            public MapEntry<String, Value> defaultEntry() {
                return FieldsDefaultEntryHolder.defaultEntry;
            }

            public Value build(ValueOrBuilder r8) {
                if ((r8 instanceof Value) == false) goto L7;
                return (Value) r8;
            L7:
                return ((Value.Builder) r8).build();
            }
        }

        static {
            fieldsConverter = new FieldsConverter(null);
        }

        private Builder() {
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
        }

        private void buildPartial0(Struct r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            Struct.access$302(r8, internalGetFields().build(FieldsDefaultEntryHolder.defaultEntry));
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> internalGetFields() {
            MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> r8 = this.fields_;
            if (r8 == null) goto L5;
            return r8;
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
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearFields() {
            this.bitField0_ &= -2;
            internalGetMutableFields().clear();
            return this;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public boolean containsFields(String r8) {
            if (r8 == null) goto L6;
            return internalGetFields().ensureBuilderMap().containsKey(r8);
        L6:
            throw new NullPointerException("map key");
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
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
        public Value getFieldsOrDefault(String r8, Value r10) {
            if (r8 == null) goto L8;
            Map<String, MessageOrBuilderT> r11 = internalGetMutableFields().ensureBuilderMap();
            if (r11.containsKey(r8) == true) goto L6;
            return r10;
        L6:
            return fieldsConverter.build((ValueOrBuilder) r11.get(r8));
        L8:
            throw new NullPointerException("map key");
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrThrow(String r8) {
            if (r8 == null) goto L10;
            Map<String, MessageOrBuilderT> r10 = internalGetMutableFields().ensureBuilderMap();
            if (r10.containsKey(r8) == false) goto L8;
            return fieldsConverter.build((ValueOrBuilder) r10.get(r8));
        L8:
            throw new IllegalArgumentException();
        L10:
            throw new NullPointerException("map key");
        }

        @Deprecated
        public Map<String, Value> getMutableFields() {
            this.bitField0_ |= 1;
            return internalGetMutableFields().ensureMessageMap();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public MapFieldReflectionAccessor internalGetMapFieldReflection(int r8) {
            if (r8 != 1) goto L7;
            return internalGetFields();
        L7:
            throw new RuntimeException(defpackage.a.d("Invalid map field number: ", r8));
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int r8) {
            if (r8 != 1) goto L7;
            return internalGetMutableFields();
        L7:
            throw new RuntimeException(defpackage.a.d("Invalid map field number: ", r8));
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder putAllFields(Map<String, Value> r8) {
            Iterator<Map.Entry<String, Value>> r10 = r8.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L12;
            Map.Entry<String, Value> r11 = r10.next();
            if (r11.getKey() == null) goto L11;
            if (r11.getValue() != null) goto L4;
        L11:
            throw null;
        L12:
            internalGetMutableFields().ensureBuilderMap().putAll(r8);
            this.bitField0_ |= 1;
            return this;
        }

        public Builder putFields(String r8, Value r10) {
            if (r8 == null) goto L9;
            if (r10 == null) goto L7;
            internalGetMutableFields().ensureBuilderMap().put(r8, r10);
            this.bitField0_ |= 1;
            return this;
        L7:
            throw new NullPointerException("map value");
        L9:
            throw new NullPointerException("map key");
        }

        public Value.Builder putFieldsBuilderIfAbsent(String r8) {
            Map<String, MessageOrBuilderT> r10 = internalGetMutableFields().ensureBuilderMap();
            Object r11 = (ValueOrBuilder) r10.get(r8);
            if (r11 != null) goto L6;
            r11 = Value.newBuilder();
            r10.put(r8, r11);
        L6:
            if ((r11 instanceof Value) == false) goto L9;
            r11 = ((Value) r11).toBuilder();
            r10.put(r8, r11);
        L9:
            return (Value.Builder) r11;
        }

        public Builder removeFields(String r8) {
            if (r8 == null) goto L6;
            internalGetMutableFields().ensureBuilderMap().remove(r8);
            return this;
        L6:
            throw new NullPointerException("map key");
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
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

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Struct build() {
            Struct r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Struct buildPartial() {
            Struct r8 = new Struct(this, null);
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
        public Struct getDefaultInstanceForType() {
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
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
            internalGetMutableFields().clear();
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
            if (r10 == null) goto L25;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L22;
            int r12 = r8.readTag();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
            if (r12 == 0) goto L14;
            if (r12 != 10) goto L10;
            MapEntry r13 = (MapEntry) r8.readMessage(FieldsDefaultEntryHolder.defaultEntry.getParserForType(), r10);     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
            internalGetMutableFields().ensureBuilderMap().put((String) r13.getKey(), (ValueOrBuilder) r13.getValue());     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
            this.bitField0_ |= 1;     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
            goto L4
        L10:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L14:
            r11 = true;
            goto L4
        L15:
            th = move-exception;
            onChanged();
            throw th;
        L17:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L15
        L22:
            onChanged();
            return this;
        L25:
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Struct) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Struct) r8);
        }

        public Builder mergeFrom(Struct r8) {
            if (r8 != Struct.getDefaultInstance()) goto L5;
            return this;
        L5:
            internalGetMutableFields().mergeFrom(Struct.access$400(r8));
            this.bitField0_ |= 1;
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    public static final class FieldsDefaultEntryHolder {
        static final MapEntry<String, Value> defaultEntry = null;

        static {
            defaultEntry = MapEntry.newDefaultInstance(StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());
        }

        private FieldsDefaultEntryHolder() {
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Struct");
        DEFAULT_INSTANCE = new Struct();
        PARSER = new AnonymousClass1();
    }

    private Struct() {
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ MapField access$302(Struct r8, MapField r10) {
        r8.fields_ = r10;
        return r10;
    }

    public static /* synthetic */ MapField access$400(Struct r8) {
        return r8.internalGetFields();
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    private MapField<String, Value> internalGetFields() {
        MapField<String, Value> r8 = this.fields_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Struct parseDelimitedFrom(InputStream r8) {
        return (Struct) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Struct parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Struct> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(String r8) {
        if (r8 == null) goto L6;
        return internalGetFields().getMap().containsKey(r8);
    L6:
        throw new NullPointerException("map key");
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Struct) == false) goto L8;
        Struct r10 = (Struct) r8;
        if (internalGetFields().equals(r10.internalGetFields()) == true) goto L13;
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
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
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
    public Value getFieldsOrDefault(String r8, Value r10) {
        if (r8 == null) goto L8;
        Map<String, Value> r11 = internalGetFields().getMap();
        if (r11.containsKey(r8) == true) goto L6;
        return r10;
    L6:
        return r11.get(r8);
    L8:
        throw new NullPointerException("map key");
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrThrow(String r8) {
        if (r8 == null) goto L10;
        Map<String, Value> r10 = internalGetFields().getMap();
        if (r10.containsKey(r8) == false) goto L8;
        return r10.get(r8);
    L8:
        throw new IllegalArgumentException();
    L10:
        throw new NullPointerException("map key");
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Struct> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        Iterator<Map.Entry<String, Value>> r10 = internalGetFields().getMap().entrySet().iterator();
        int r11 = 0;
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<String, Value> r12 = r10.next();
        r11 = r11 + CodedOutputStream.computeMessageSize(1, FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(r12.getKey()).setValue(r12.getValue()).build());
        goto L7
    L9:
        int r13 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r13;
        return r13;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (internalGetFields().getMap().isEmpty() == true) goto L8;
        r10 = defpackage.b.a(r10, 37, 1, 53) + internalGetFields().hashCode();
    L8:
        int r11 = getUnknownFields().hashCode();
        int r12 = r11 + (r10 * 29);
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage
    public MapFieldReflectionAccessor internalGetMapFieldReflection(int r8) {
        if (r8 != 1) goto L7;
        return internalGetFields();
    L7:
        throw new RuntimeException(defpackage.a.d("Invalid map field number: ", r8));
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
        GeneratedMessage.serializeStringMapTo(r8, internalGetFields(), FieldsDefaultEntryHolder.defaultEntry, 1);
        getUnknownFields().writeTo(r8);
    }

    private Struct(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Struct r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Struct parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Struct) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Struct parseFrom(ByteString r8, ExtensionRegistryLite r10) {
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

    public /* synthetic */ Struct(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Struct parseFrom(CodedInputStream r8) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Struct getDefaultInstanceForType() {
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

    public static Struct parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Struct parseFrom(InputStream r8) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static Struct parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Struct) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Struct parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Struct parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Struct parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Struct parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
