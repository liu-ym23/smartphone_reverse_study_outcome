package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class MapEntry<K, V> extends AbstractMessage {
    private volatile int cachedSerializedSize;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
        private boolean hasKey;
        private boolean hasValue;
        private K key;
        private final Metadata<K, V> metadata;
        private V value;

        private Builder(Metadata<K, V> r10) {
            this(r10, r10.defaultKey, r10.defaultValue, false, false);
        }

        /* synthetic */ Builder(Metadata r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Builder(Metadata<K, V> r10, K r11, V r12, boolean r13, boolean r14) {
            this.metadata = r10;
            this.key = r11;
            this.value = r12;
            this.hasKey = r13;
            this.hasValue = r14;
        }

        /* synthetic */ Builder(Metadata r10, Object r11, Object r12, boolean r13, boolean r14, AnonymousClass1 r15) {
            this(r10, r11, r12, r13, r14);
        }

        private void checkFieldDescriptor(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != this.metadata.descriptor) goto L6;
            return;
        L6:
            throw new RuntimeException("Wrong FieldDescriptor \"" + r10.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> build() {
            MapEntry<K, V> r10 = buildPartial();
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
        public MapEntry<K, V> buildPartial() {
            return new MapEntry(this.metadata, this.key, this.value, null);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> clearField(Descriptors.FieldDescriptor r10) {
            checkFieldDescriptor(r10);
            if (r10.getNumber() != 1) goto L5;
            clearKey();
        L6:
            return this;
        L5:
            clearValue();
            goto L6
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        public Builder<K, V> clearKey() {
            this.key = this.metadata.defaultKey;
            this.hasKey = false;
            return this;
        }

        public Builder<K, V> clearValue() {
            this.value = this.metadata.defaultValue;
            this.hasValue = false;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder<K, V> clone() {
            return new Builder(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo13clone() {
            return clone();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap r10 = new TreeMap();
            Iterator<Descriptors.FieldDescriptor> r11 = this.metadata.descriptor.getFields().iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            Descriptors.FieldDescriptor r12 = r11.next();
            if (hasField(r12) == false) goto L4;
            r10.put(r12, getField(r12));
            goto L4
        L9:
            return Collections.unmodifiableMap(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MapEntry<K, V> getDefaultInstanceForType() {
            Metadata<K, V> r10 = this.metadata;
            return new MapEntry(r10, r10.defaultKey, r10.defaultValue, null);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.metadata.descriptor;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            checkFieldDescriptor(r10);
            if (r10.getNumber() != 1) goto L5;
            Object r11 = getKey();
        L7:
            if (r10.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
            return r11;
        L9:
            return r10.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) r11).intValue());
        L5:
            r11 = getValue();
            goto L7
        }

        public K getKey() {
            return this.key;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        public V getValue() {
            return this.value;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            checkFieldDescriptor(r10);
            if (r10.getNumber() != 1) goto L6;
            return this.hasKey;
        L6:
            return this.hasValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return MapEntry.access$600(this.metadata, this.value);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            checkFieldDescriptor(r10);
            if (r10.getNumber() != 2) goto L9;
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L9;
            return ((Message) this.value).newBuilderForType();
        L9:
            throw new RuntimeException("\"" + r10.getFullName() + "\" is not a message value field.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setField(Descriptors.FieldDescriptor r10, Object r11) {
            checkFieldDescriptor(r10);
            if (r11 == null) goto L18;
            if (r10.getNumber() != 1) goto L8;
            setKey(r11);
        L16:
            return this;
        L8:
            if (r10.getType() != Descriptors.FieldDescriptor.Type.ENUM) goto L11;
            r11 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r11).getNumber());
        L15:
            setValue(r11);
            goto L16
        L11:
            if (r10.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L15;
            if (this.metadata.defaultValue.getClass().isInstance(r11) == true) goto L15;
            r11 = ((Message) this.metadata.defaultValue).toBuilder().mergeFrom((Message) r11).build();
            goto L15
        L18:
            throw new NullPointerException(r10.getFullName() + " is null");
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        public Builder<K, V> setKey(K r10) {
            this.key = r10;
            this.hasKey = true;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setUnknownFields(UnknownFieldSet r10) {
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
            return setUnknownFields(r10);
        }

        public Builder<K, V> setValue(V r10) {
            this.value = r10;
            this.hasValue = true;
            return this;
        }
    }

    private static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {
        public final Descriptors.Descriptor descriptor;
        public final Parser<MapEntry<K, V>> parser;

        public Metadata(Descriptors.Descriptor r10, MapEntry<K, V> r11, WireFormat.FieldType r12, WireFormat.FieldType r13) {
            super(r12, MapEntry.access$000(r11), r13, MapEntry.access$100(r11));
            this.descriptor = r10;
            this.parser = new AnonymousClass1(this);
        }
    }

    private MapEntry(Descriptors.Descriptor r10, WireFormat.FieldType r11, K r12, WireFormat.FieldType r13, V r14) {
        this.cachedSerializedSize = -1;
        this.key = r12;
        this.value = r14;
        this.metadata = new Metadata(r10, this, r11, r13);
    }

    private MapEntry(Metadata<K, V> r10, CodedInputStream r11, ExtensionRegistryLite r12) {
        this.cachedSerializedSize = -1;
        this.metadata = r10;     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        Map.Entry r13 = MapEntryLite.parseEntry(r11, r10, r12);     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.key = (K) r13.getKey();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.value = (V) r13.getValue();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        return;
    L8:
        e = move-exception;
        throw e.setUnfinishedMessage(this);
    L5:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    }

    /* synthetic */ MapEntry(Metadata r10, CodedInputStream r11, ExtensionRegistryLite r12, AnonymousClass1 r13) {
        this(r10, r11, r12);
    }

    private MapEntry(Metadata r10, K r11, V r12) {
        this.cachedSerializedSize = -1;
        this.key = r11;
        this.value = r12;
        this.metadata = r10;
    }

    /* synthetic */ MapEntry(Metadata r10, Object r11, Object r12, AnonymousClass1 r13) {
        this(r10, r11, r12);
    }

    static /* synthetic */ Object access$000(MapEntry r10) {
        return r10.key;
    }

    static /* synthetic */ Object access$100(MapEntry r10) {
        return r10.value;
    }

    static /* synthetic */ boolean access$600(Metadata r10, Object r11) {
        return isInitialized(r10, r11);
    }

    private void checkFieldDescriptor(Descriptors.FieldDescriptor r10) {
        if (r10.getContainingType() != this.metadata.descriptor) goto L6;
        return;
    L6:
        throw new RuntimeException("Wrong FieldDescriptor \"" + r10.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
    }

    private static <V> boolean isInitialized(Metadata r10, V r11) {
        if (r10.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
        return true;
    L5:
        return ((MessageLite) r11).isInitialized();
    }

    public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptors.Descriptor r10, WireFormat.FieldType r11, K r12, WireFormat.FieldType r13, V r14) {
        return new MapEntry(r10, r11, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap r10 = new TreeMap();
        Iterator<Descriptors.FieldDescriptor> r11 = this.metadata.descriptor.getFields().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Descriptors.FieldDescriptor r12 = r11.next();
        if (hasField(r12) == false) goto L4;
        r10.put(r12, getField(r12));
        goto L4
    L9:
        return Collections.unmodifiableMap(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MapEntry<K, V> getDefaultInstanceForType() {
        Metadata<K, V> r10 = this.metadata;
        return new MapEntry(r10, r10.defaultKey, r10.defaultValue);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r10) {
        checkFieldDescriptor(r10);
        if (r10.getNumber() != 1) goto L5;
        Object r11 = getKey();
    L7:
        if (r10.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
        return r11;
    L9:
        return r10.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) r11).intValue());
    L5:
        r11 = getValue();
        goto L7
    }

    public K getKey() {
        return this.key;
    }

    final Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MapEntry<K, V>> getParserForType() {
        return this.metadata.parser;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.cachedSerializedSize != (-1)) goto L5;
        int r10 = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
        this.cachedSerializedSize = r10;
        return r10;
    L5:
        return this.cachedSerializedSize;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    public V getValue() {
        return this.value;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r10) {
        checkFieldDescriptor(r10);
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.metadata, this.value);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> newBuilderForType() {
        return new Builder(this.metadata, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> toBuilder() {
        return new Builder(this.metadata, this.key, this.value, true, true, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        MapEntryLite.writeTo(r10, this.metadata, this.key, this.value);
    }
}
