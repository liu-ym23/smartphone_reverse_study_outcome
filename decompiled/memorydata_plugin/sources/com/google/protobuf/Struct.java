package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
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

            /* synthetic */ FieldsConverter(AnonymousClass1 r1) {
                this();
            }

            @Override // com.google.protobuf.MapFieldBuilder.Converter
            public /* synthetic */ MessageOrBuilder build(MessageOrBuilder r3) {
                return build((ValueOrBuilder) ZeusTransformUtils.preCheckCast((MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.memorydata.plugin"), ValueOrBuilder.class, "com.obric.memorydata.plugin"));
            }

            public Value build(ValueOrBuilder r2) {
                ValueOrBuilder r1 = (ValueOrBuilder) ZeusTransformUtils.wrapperContextForParams(r2, ValueOrBuilder.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r1, Value.class) == false) goto L7;
                return (Value) ZeusTransformUtils.preCheckCast(r1, Value.class, "com.obric.memorydata.plugin");
            L7:
                return ((Value.Builder) ZeusTransformUtils.preCheckCast(r1, Value.Builder.class, "com.obric.memorydata.plugin")).build();
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

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(Struct r2) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            Struct.access$302(r2, internalGetFields().build(FieldsDefaultEntryHolder.defaultEntry));
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        private MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> internalGetFields() {
            MapFieldBuilder<String, ValueOrBuilder, Value, Value.Builder> r1 = this.fields_;
            if (r1 == null) goto L5;
            return r1;
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
            Struct r1 = buildPartial();
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
        public Struct buildPartial() {
            Struct r0 = new Struct(this, null);
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
            internalGetMutableFields().clear();
            return this;
        }

        public Builder clearFields() {
            this.bitField0_ &= -2;
            internalGetMutableFields().clear();
            return this;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public boolean containsFields(String r2) {
            Objects.requireNonNull(r2, "map key");
            return internalGetFields().ensureBuilderMap().containsKey(r2);
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
        public Value getFieldsOrDefault(String r2, Value r3) {
            Objects.requireNonNull(r2, "map key");
            Map<String, MessageOrBuilderT> r1 = internalGetMutableFields().ensureBuilderMap();
            if (r1.containsKey(r2) == true) goto L5;
            return r3;
        L5:
            return fieldsConverter.build((ValueOrBuilder) ZeusTransformUtils.preCheckCast(r1.get(r2), ValueOrBuilder.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrThrow(String r3) {
            Objects.requireNonNull(r3, "map key");
            Map<String, MessageOrBuilderT> r2 = internalGetMutableFields().ensureBuilderMap();
            if (r2.containsKey(r3) == false) goto L7;
            return fieldsConverter.build((ValueOrBuilder) ZeusTransformUtils.preCheckCast(r2.get(r3), ValueOrBuilder.class, "com.obric.memorydata.plugin"));
        L7:
            throw new IllegalArgumentException();
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
        public MapFieldReflectionAccessor internalGetMapFieldReflection(int r3) {
            if (r3 != 1) goto L7;
            return internalGetFields();
        L7:
            throw new RuntimeException("Invalid map field number: " + r3);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int r3) {
            if (r3 != 1) goto L7;
            return internalGetMutableFields();
        L7:
            throw new RuntimeException("Invalid map field number: " + r3);
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
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r9) {
            Objects.requireNonNull(r9);
            boolean r1 = false;
        L3:
            if (r1 == true) goto L21;
            int r2 = r8.readTag();     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            if (r2 == 0) goto L13;
            if (r2 != 10) goto L9;
            MapEntry r3 = (MapEntry) ZeusTransformUtils.preCheckCast(r8.readMessage(FieldsDefaultEntryHolder.defaultEntry.getParserForType(), r9), MapEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            internalGetMutableFields().ensureBuilderMap().put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), (ValueOrBuilder) ZeusTransformUtils.preCheckCast(r3.getValue(), ValueOrBuilder.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 InvalidProtocolBufferException -> L16
            goto L3
        L9:
            if (super.parseUnknownField(r8, r9, r2) == true) goto L3;
        L13:
            r1 = true;
            goto L3
        L14:
            th = move-exception;
            onChanged();
            throw th;
        L16:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L14
        L21:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Struct.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Struct) ZeusTransformUtils.preCheckCast(r4, Struct.class, "com.obric.memorydata.plugin"));
        }

        public Builder mergeFrom(Struct r3) {
            if (r3 != Struct.getDefaultInstance()) goto L5;
            return this;
        L5:
            internalGetMutableFields().mergeFrom(Struct.access$400(r3));
            this.bitField0_ |= 1;
            mergeUnknownFields(r3.getUnknownFields());
            onChanged();
            return this;
        }

        public Builder putAllFields(Map<String, Value> r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Iterator r0 = r6.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (r2.getKey() == null) goto L11;
            if (r2.getValue() != null) goto L4;
        L11:
            throw null;
        L12:
            internalGetMutableFields().ensureBuilderMap().putAll(r6);
            this.bitField0_ |= 1;
            return this;
        }

        public Builder putFields(String r2, Value r3) {
            Objects.requireNonNull(r2, "map key");
            Objects.requireNonNull(r3, "map value");
            internalGetMutableFields().ensureBuilderMap().put(r2, r3);
            this.bitField0_ |= 1;
            return this;
        }

        public Value.Builder putFieldsBuilderIfAbsent(String r4) {
            Map<String, MessageOrBuilderT> r3 = internalGetMutableFields().ensureBuilderMap();
            Object r0 = (ValueOrBuilder) ZeusTransformUtils.preCheckCast(r3.get(r4), ValueOrBuilder.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            r0 = Value.newBuilder();
            r3.put(r4, r0);
        L6:
            if (ZeusTransformUtils.instanceOf(r0, Value.class) == false) goto L9;
            r0 = ((Value) ZeusTransformUtils.preCheckCast(r0, Value.class, "com.obric.memorydata.plugin")).toBuilder();
            r3.put(r4, r0);
        L9:
            return (Value.Builder) ZeusTransformUtils.preCheckCast(r0, Value.Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder removeFields(String r2) {
            Objects.requireNonNull(r2, "map key");
            internalGetMutableFields().ensureBuilderMap().remove(r2);
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

    private Struct(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Struct(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ MapField access$302(Struct r0, MapField r1) {
        r0.fields_ = r1;
        return r1;
    }

    static /* synthetic */ MapField access$400(Struct r0) {
        return r0.internalGetFields();
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    private MapField<String, Value> internalGetFields() {
        MapField<String, Value> r0 = this.fields_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Struct r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static Struct parseDelimitedFrom(InputStream r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(ByteString r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(CodedInputStream r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(InputStream r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(ByteBuffer r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(byte[] r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Struct parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Struct) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Struct.class, "com.obric.memorydata.plugin");
    }

    public static Parser<Struct> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(String r2) {
        Objects.requireNonNull(r2, "map key");
        return internalGetFields().getMap().containsKey(r2);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, Struct.class) == false) goto L8;
        Struct r5 = (Struct) ZeusTransformUtils.preCheckCast(r4, Struct.class, "com.obric.memorydata.plugin");
        if (internalGetFields().equals(r5.internalGetFields()) == true) goto L13;
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
    public Value getFieldsOrDefault(String r2, Value r3) {
        Objects.requireNonNull(r2, "map key");
        Map<String, Value> r1 = internalGetFields().getMap();
        if (r1.containsKey(r2) == true) goto L5;
        return r3;
    L5:
        return (Value) ZeusTransformUtils.preCheckCast(r1.get(r2), Value.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrThrow(String r2) {
        Objects.requireNonNull(r2, "map key");
        Map<String, Value> r1 = internalGetFields().getMap();
        if (r1.containsKey(r2) == false) goto L7;
        return (Value) ZeusTransformUtils.preCheckCast(r1.get(r2), Value.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Struct> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        Iterator<Map.Entry<String, Value>> r2 = internalGetFields().getMap().entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1 = r1 + CodedOutputStream.computeMessageSize(1, FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin")).setValue((Value) ZeusTransformUtils.preCheckCast(r3.getValue(), Value.class, "com.obric.memorydata.plugin")).build());
        goto L7
    L9:
        int r4 = r1 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r4;
        return r4;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = 779 + getDescriptor().hashCode();
        if (internalGetFields().getMap().isEmpty() == true) goto L9;
        r0 = (((r0 * 37) + 1) * 53) + internalGetFields().hashCode();
    L9:
        int r1 = (r0 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r1;
        return r1;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage
    public MapFieldReflectionAccessor internalGetMapFieldReflection(int r3) {
        if (r3 != 1) goto L7;
        return internalGetFields();
    L7:
        throw new RuntimeException("Invalid map field number: " + r3);
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
    public void writeTo(CodedOutputStream r4) {
        GeneratedMessage.serializeStringMapTo(r4, internalGetFields(), FieldsDefaultEntryHolder.defaultEntry, 1);
        getUnknownFields().writeTo(r4);
    }
}
