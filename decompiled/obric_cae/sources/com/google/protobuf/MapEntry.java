package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class MapEntry<K, V> extends AbstractMessage {
    private volatile int cachedSerializedSize;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
        private boolean hasKey;
        private boolean hasValue;
        private K key;
        private final Metadata<K, V> metadata;
        private V value;

        private Builder(Metadata<K, V> r8) {
            this(r8, r8.defaultKey, r8.defaultValue, false, false);
        }

        private void checkFieldDescriptor(Descriptors.FieldDescriptor r8) {
            if (r8.getContainingType() != this.metadata.descriptor) goto L6;
            return;
        L6:
            throw new RuntimeException("Wrong FieldDescriptor \"" + r8.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> build() {
            MapEntry<K, V> r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> buildPartial() {
            return new MapEntry(this.metadata, this.key, this.value, null);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> clearField(Descriptors.FieldDescriptor r8) {
            checkFieldDescriptor(r8);
            if (r8.getNumber() != 1) goto L5;
            clearKey();
        L6:
            return this;
        L5:
            clearValue();
            goto L6
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap r8 = new TreeMap();
            Iterator<Descriptors.FieldDescriptor> r10 = this.metadata.descriptor.getFields().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            Descriptors.FieldDescriptor r11 = r10.next();
            if (hasField(r11) == false) goto L4;
            r8.put(r11, getField(r11));
            goto L4
        L9:
            return Collections.unmodifiableMap(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public MapEntry<K, V> getDefaultInstanceForType() {
            Metadata<K, V> r8 = this.metadata;
            return new MapEntry(r8, r8.defaultKey, r8.defaultValue, null);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.metadata.descriptor;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r8) {
            checkFieldDescriptor(r8);
            if (r8.getNumber() != 1) goto L5;
            Object r10 = getKey();
        L7:
            if (r8.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
            return r10;
        L9:
            return r8.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) r10).intValue());
        L5:
            r10 = getValue();
            goto L7
        }

        public K getKey() {
            return this.key;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
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
        public boolean hasField(Descriptors.FieldDescriptor r8) {
            checkFieldDescriptor(r8);
            if (r8.getNumber() != 1) goto L6;
            return this.hasKey;
        L6:
            return this.hasValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return MapEntry.access$600(this.metadata, this.value);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r8) {
            checkFieldDescriptor(r8);
            if (r8.getNumber() != 2) goto L9;
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L9;
            return ((Message) this.value).newBuilderForType();
        L9:
            throw new RuntimeException("\"" + r8.getFullName() + "\" is not a message value field.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setField(Descriptors.FieldDescriptor r8, Object r10) {
            checkFieldDescriptor(r8);
            if (r10 == null) goto L18;
            if (r8.getNumber() != 1) goto L8;
            setKey(r10);
        L16:
            return this;
        L8:
            if (r8.getType() != Descriptors.FieldDescriptor.Type.ENUM) goto L11;
            r10 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r10).getNumber());
        L15:
            setValue(r10);
            goto L16
        L11:
            if (r8.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L15;
            if (this.metadata.defaultValue.getClass().isInstance(r10) == true) goto L15;
            r10 = ((Message) this.metadata.defaultValue).toBuilder().mergeFrom((Message) r10).build();
            goto L15
        L18:
            throw new NullPointerException(r8.getFullName() + " is null");
        }

        public Builder<K, V> setKey(K r8) {
            this.key = r8;
            this.hasKey = true;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setUnknownFields(UnknownFieldSet r8) {
            return this;
        }

        public Builder<K, V> setValue(V r8) {
            this.value = r8;
            this.hasValue = true;
            return this;
        }

        public /* synthetic */ Builder(Metadata r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(Metadata<K, V> r8, K r10, V r11, boolean r12, boolean r13) {
            this.metadata = r8;
            this.key = r10;
            this.value = r11;
            this.hasKey = r12;
            this.hasValue = r13;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder<K, V> clone() {
            return new Builder(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public /* synthetic */ Builder(Metadata r8, Object r10, Object r11, boolean r12, boolean r13, AnonymousClass1 r14) {
            this(r8, r10, r11, r12, r13);
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
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }
    }

    public static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {
        public final Descriptors.Descriptor descriptor;
        public final Parser<MapEntry<K, V>> parser;

        public Metadata(Descriptors.Descriptor r8, MapEntry<K, V> r10, WireFormat.FieldType r11, WireFormat.FieldType r12) {
            super(r11, MapEntry.access$000(r10), r12, MapEntry.access$100(r10));
            this.descriptor = r8;
            this.parser = new AnonymousClass1(this);
        }
    }

    private MapEntry(Descriptors.Descriptor r8, WireFormat.FieldType r10, K r11, WireFormat.FieldType r12, V r13) {
        this.cachedSerializedSize = -1;
        this.key = r11;
        this.value = r13;
        this.metadata = new Metadata(r8, this, r10, r12);
    }

    public static /* synthetic */ Object access$000(MapEntry r8) {
        return r8.key;
    }

    public static /* synthetic */ Object access$100(MapEntry r8) {
        return r8.value;
    }

    public static /* synthetic */ boolean access$600(Metadata r8, Object r10) {
        return isInitialized(r8, r10);
    }

    private void checkFieldDescriptor(Descriptors.FieldDescriptor r8) {
        if (r8.getContainingType() != this.metadata.descriptor) goto L6;
        return;
    L6:
        throw new RuntimeException("Wrong FieldDescriptor \"" + r8.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
    }

    public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptors.Descriptor r8, WireFormat.FieldType r10, K r11, WireFormat.FieldType r12, V r13) {
        return new MapEntry(r8, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap r8 = new TreeMap();
        Iterator<Descriptors.FieldDescriptor> r10 = this.metadata.descriptor.getFields().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Descriptors.FieldDescriptor r11 = r10.next();
        if (hasField(r11) == false) goto L4;
        r8.put(r11, getField(r11));
        goto L4
    L9:
        return Collections.unmodifiableMap(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public MapEntry<K, V> getDefaultInstanceForType() {
        Metadata<K, V> r8 = this.metadata;
        return new MapEntry(r8, r8.defaultKey, r8.defaultValue);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r8) {
        checkFieldDescriptor(r8);
        if (r8.getNumber() != 1) goto L5;
        Object r10 = getKey();
    L7:
        if (r8.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
        return r10;
    L9:
        return r8.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) r10).intValue());
    L5:
        r10 = getValue();
        goto L7
    }

    public K getKey() {
        return this.key;
    }

    public final Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MapEntry<K, V>> getParserForType() {
        return this.metadata.parser;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r8, int r10) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r8) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.cachedSerializedSize != (-1)) goto L5;
        int r8 = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
        this.cachedSerializedSize = r8;
        return r8;
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
    public boolean hasField(Descriptors.FieldDescriptor r8) {
        checkFieldDescriptor(r8);
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
    public Builder<K, V> toBuilder() {
        return new Builder(this.metadata, this.key, this.value, true, true, null);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        MapEntryLite.writeTo(r8, this.metadata, this.key, this.value);
    }

    private MapEntry(Metadata<K, V> r8, CodedInputStream r10, ExtensionRegistryLite r11) {
        this.cachedSerializedSize = -1;
        this.metadata = r8;     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        Map.Entry r12 = MapEntryLite.parseEntry(r10, r8, r11);     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.key = (K) r12.getKey();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.value = (V) r12.getValue();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        return;
    L8:
        e = move-exception;
        throw e.setUnfinishedMessage(this);
    L5:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    }

    private static <V> boolean isInitialized(Metadata r8, V r10) {
        if (r8.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
        return true;
    L5:
        return ((MessageLite) r10).isInitialized();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ MapEntry(Metadata r8, CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
        this(r8, r10, r11);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    private MapEntry(Metadata r8, K r10, V r11) {
        this.cachedSerializedSize = -1;
        this.key = r10;
        this.value = r11;
        this.metadata = r8;
    }

    public /* synthetic */ MapEntry(Metadata r8, Object r10, Object r11, AnonymousClass1 r12) {
        this(r8, r10, r11);
    }
}
