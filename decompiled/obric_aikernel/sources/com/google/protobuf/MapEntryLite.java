package com.google.protobuf;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntryLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType r10, K r11, WireFormat.FieldType r12, V r13) {
            this.keyType = r10;
            this.defaultKey = r11;
            this.valueType = r12;
            this.defaultValue = r13;
        }
    }

    private MapEntryLite(Metadata<K, V> r10, K r11, V r12) {
        this.metadata = r10;
        this.key = r11;
        this.value = r12;
    }

    private MapEntryLite(WireFormat.FieldType r10, K r11, WireFormat.FieldType r12, V r13) {
        this.metadata = new Metadata(r10, r11, r12, r13);
        this.key = r11;
        this.value = r13;
    }

    static <K, V> int computeSerializedSize(Metadata<K, V> r10, K r11, V r12) {
        return FieldSet.computeElementSize(r10.keyType, 1, r11) + FieldSet.computeElementSize(r10.valueType, 2, r12);
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType r10, K r11, WireFormat.FieldType r12, V r13) {
        return new MapEntryLite(r10, r11, r12, r13);
    }

    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream r10, Metadata<K, V> r11, ExtensionRegistryLite r12) {
        Object r13 = r11.defaultKey;
        Object r14 = r11.defaultValue;
    L3:
        int r15 = r10.readTag();
        if (r15 == 0) goto L15;
        if (r15 == WireFormat.makeTag(1, r11.keyType.getWireType())) goto L8;
        if (r15 == WireFormat.makeTag(2, r11.valueType.getWireType())) goto L11;
        if (r10.skipField(r15) == true) goto L3;
    L11:
        r14 = parseField(r10, r12, r11.valueType, r14);
        goto L3
    L8:
        r13 = parseField(r10, r12, r11.keyType, r13);
    L15:
        return new AbstractMap.SimpleImmutableEntry(r13, r14);
    }

    static <T> T parseField(CodedInputStream r10, ExtensionRegistryLite r11, WireFormat.FieldType r12, T r13) {
        int r14 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r12.ordinal()];
        if (r14 != 1) goto L5;
        MessageLite.Builder r15 = ((MessageLite) r13).toBuilder();
        r10.readMessage(r15, r11);
        return (T) r15.buildPartial();
    L5:
        if (r14 == 2) goto L13;
        if (r14 == 3) goto L11;
        return (T) FieldSet.readPrimitiveField(r10, r12, true);
    L11:
        throw new RuntimeException("Groups are not allowed in maps.");
    L13:
        return (T) Integer.valueOf(r10.readEnum());
    }

    static <K, V> void writeTo(CodedOutputStream r10, Metadata<K, V> r11, K r12, V r13) {
        FieldSet.writeElement(r10, r11.keyType, 1, r12);
        FieldSet.writeElement(r10, r11.valueType, 2, r13);
    }

    public int computeMessageSize(int r10, K r11, V r12) {
        return CodedOutputStream.computeTagSize(r10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, r11, r12));
    }

    public K getKey() {
        return this.key;
    }

    Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    public V getValue() {
        return this.value;
    }

    public Map.Entry<K, V> parseEntry(ByteString r10, ExtensionRegistryLite r11) {
        return parseEntry(r10.newCodedInput(), this.metadata, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> r10, CodedInputStream r11, ExtensionRegistryLite r12) {
        int r13 = r11.pushLimit(r11.readRawVarint32());
        Metadata<K, V> r14 = this.metadata;
        Object r15 = r14.defaultKey;
        Object r16 = r14.defaultValue;
    L3:
        int r17 = r11.readTag();
        if (r17 == 0) goto L14;
        if (r17 == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) goto L8;
        if (r17 == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) goto L11;
        if (r11.skipField(r17) == true) goto L3;
    L11:
        r16 = parseField(r11, r12, this.metadata.valueType, r16);
        goto L3
    L8:
        r15 = parseField(r11, r12, this.metadata.keyType, r15);
    L14:
        r11.checkLastTagWas(0);
        r11.popLimit(r13);
        r10.put(r15, r16);
    }

    public void serializeTo(CodedOutputStream r10, int r11, K r12, V r13) {
        r10.writeTag(r11, 2);
        r10.writeUInt32NoTag(computeSerializedSize(this.metadata, r12, r13));
        writeTo(r10, this.metadata, r12, r13);
    }
}
