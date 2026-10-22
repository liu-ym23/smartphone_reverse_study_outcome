package com.google.protobuf;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntryLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType r8, K r10, WireFormat.FieldType r11, V r12) {
            this.keyType = r8;
            this.defaultKey = r10;
            this.valueType = r11;
            this.defaultValue = r12;
        }
    }

    private MapEntryLite(Metadata<K, V> r8, K r10, V r11) {
        this.metadata = r8;
        this.key = r10;
        this.value = r11;
    }

    public static <K, V> int computeSerializedSize(Metadata<K, V> r8, K r10, V r11) {
        return FieldSet.computeElementSize(r8.keyType, 1, r10) + FieldSet.computeElementSize(r8.valueType, 2, r11);
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType r8, K r10, WireFormat.FieldType r11, V r12) {
        return new MapEntryLite(r8, r10, r11, r12);
    }

    public static <T> T parseField(CodedInputStream r8, ExtensionRegistryLite r10, WireFormat.FieldType r11, T r12) {
        int r13 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.ordinal()];
        if (r13 != 1) goto L5;
        MessageLite.Builder r14 = ((MessageLite) r12).toBuilder();
        r8.readMessage(r14, r10);
        return (T) r14.buildPartial();
    L5:
        if (r13 == 2) goto L13;
        if (r13 == 3) goto L11;
        return (T) FieldSet.readPrimitiveField(r8, r11, true);
    L11:
        throw new RuntimeException("Groups are not allowed in maps.");
    L13:
        return (T) Integer.valueOf(r8.readEnum());
    }

    public static <K, V> void writeTo(CodedOutputStream r8, Metadata<K, V> r10, K r11, V r12) {
        FieldSet.writeElement(r8, r10.keyType, 1, r11);
        FieldSet.writeElement(r8, r10.valueType, 2, r12);
    }

    public int computeMessageSize(int r8, K r10, V r11) {
        int r12 = CodedOutputStream.computeTagSize(r8);
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, r10, r11)) + r12;
    }

    public K getKey() {
        return this.key;
    }

    public Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    public V getValue() {
        return this.value;
    }

    public Map.Entry<K, V> parseEntry(ByteString r8, ExtensionRegistryLite r10) {
        return parseEntry(r8.newCodedInput(), this.metadata, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> r8, CodedInputStream r10, ExtensionRegistryLite r11) {
        int r12 = r10.pushLimit(r10.readRawVarint32());
        Metadata<K, V> r13 = this.metadata;
        Object r14 = r13.defaultKey;
        Object r15 = r13.defaultValue;
    L3:
        int r16 = r10.readTag();
        if (r16 == 0) goto L14;
        if (r16 == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) goto L8;
        if (r16 == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) goto L11;
        if (r10.skipField(r16) == true) goto L3;
    L11:
        r15 = parseField(r10, r11, this.metadata.valueType, r15);
        goto L3
    L8:
        r14 = parseField(r10, r11, this.metadata.keyType, r14);
    L14:
        r10.checkLastTagWas(0);
        r10.popLimit(r12);
        r8.put(r14, r15);
    }

    public void serializeTo(CodedOutputStream r8, int r10, K r11, V r12) {
        r8.writeTag(r10, 2);
        r8.writeUInt32NoTag(computeSerializedSize(this.metadata, r11, r12));
        writeTo(r8, this.metadata, r11, r12);
    }

    private MapEntryLite(WireFormat.FieldType r8, K r10, WireFormat.FieldType r11, V r12) {
        this.metadata = new Metadata(r8, r10, r11, r12);
        this.key = r10;
        this.value = r12;
    }

    public static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream r8, Metadata<K, V> r10, ExtensionRegistryLite r11) {
        Object r12 = r10.defaultKey;
        Object r13 = r10.defaultValue;
    L3:
        int r14 = r8.readTag();
        if (r14 == 0) goto L15;
        if (r14 == WireFormat.makeTag(1, r10.keyType.getWireType())) goto L8;
        if (r14 == WireFormat.makeTag(2, r10.valueType.getWireType())) goto L11;
        if (r8.skipField(r14) == true) goto L3;
    L11:
        r13 = parseField(r8, r11, r10.valueType, r13);
        goto L3
    L8:
        r12 = parseField(r8, r11, r10.keyType, r12);
    L15:
        return new AbstractMap.SimpleImmutableEntry(r12, r13);
    }
}
