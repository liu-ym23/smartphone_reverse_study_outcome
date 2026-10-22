package com.google.protobuf;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
    private static final long EXTENSION_FIELD_OFFSET = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4290a = 0;

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionSchemaFull$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    static {
        EXTENSION_FIELD_OFFSET = getExtensionsFieldOffset();
    }

    ExtensionSchemaFull() {
    }

    private static <T> long getExtensionsFieldOffset() {
        return UnsafeUtil.objectFieldOffset(GeneratedMessage.ExtendableMessage.class.getDeclaredField("extensions"));
    L4:
        th = move-exception;
        throw new IllegalStateException("Unable to lookup extension field offset", th);
    }

    @Override // com.google.protobuf.ExtensionSchema
    int extensionNumber(Map.Entry<?, ?> r10) {
        return ((Descriptors.FieldDescriptor) r10.getKey()).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite r10, MessageLite r11, int r12) {
        return ((ExtensionRegistry) r10).findImmutableExtensionByNumber(((Message) r11).getDescriptorForType(), r12);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Descriptors.FieldDescriptor> getExtensions(Object r10) {
        return (FieldSet) UnsafeUtil.getObject(r10, EXTENSION_FIELD_OFFSET);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object r10) {
        FieldSet<Descriptors.FieldDescriptor> r11 = getExtensions(r10);
        if (r11.isImmutable() == false) goto L6;
        FieldSet r12 = r11.clone();
        setExtensions(r10, r12);
        return r12;
    L6:
        return r11;
    }

    @Override // com.google.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite r10) {
        return r10 instanceof GeneratedMessage.ExtendableMessage;
    }

    @Override // com.google.protobuf.ExtensionSchema
    void makeImmutable(Object r10) {
        getExtensions(r10).makeImmutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    <UT, UB> UB parseExtension(Object r10, Reader r11, Object r12, ExtensionRegistryLite r13, FieldSet<Descriptors.FieldDescriptor> r14, UB r15, UnknownFieldSchema<UT, UB> r16) {
        ExtensionRegistry.ExtensionInfo r17 = (ExtensionRegistry.ExtensionInfo) r12;
        int r18 = r17.descriptor.getNumber();
        if (r17.descriptor.isRepeated() == true) goto L5;
    L32:
        Object r19 = null;
        if (r17.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L39;
        int r20 = r11.readInt32();
        r19 = r17.descriptor.getEnumType().findValueByNumber(r20);
        if (r19 != null) goto L63;
        return (UB) SchemaUtil.storeUnknownEnum(r10, r18, r20, r15, r16);
    L63:
        if (r17.descriptor.isRepeated() == false) goto L65;
        r14.addRepeatedField(r17.descriptor, r19);
    L74:
        return r15;
    L65:
        int r21 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r17.descriptor.getLiteType().ordinal()];
        if (r21 != 17) goto L68;
    L70:
        Object r22 = r14.getField(r17.descriptor);
        if (r22 == null) goto L73;
        r19 = Internal.mergeMessage(r22, r19);
    L73:
        r14.setField(r17.descriptor, r19);
        goto L74
    L68:
        if (r21 == 18) goto L70;
    L39:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r17.descriptor.getLiteType().ordinal()]) {
            case 1: goto L61;
            case 2: goto L60;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L55;
            case 6: goto L54;
            case 7: goto L53;
            case 8: goto L52;
            case 9: goto L51;
            case 10: goto L50;
            case 11: goto L49;
            case 12: goto L48;
            case 13: goto L47;
            case 14: goto L46;
            case 15: goto L44;
            case 16: goto L43;
            case 17: goto L42;
            case 18: goto L41;
            default: goto L63;
        };
    L41:
        r19 = r11.readMessage(r17.defaultInstance.getClass(), r13);
        goto L63
    L42:
        r19 = r11.readGroup(r17.defaultInstance.getClass(), r13);
        goto L63
    L43:
        r19 = r11.readString();
        goto L63
    L44:
        r19 = r11.readBytes();
        goto L63
    L47:
        long r23 = r11.readSInt64();
    L59:
        r19 = Long.valueOf(r23);
        goto L63
    L48:
        int r24 = r11.readSInt32();
    L56:
        r19 = Integer.valueOf(r24);
        goto L63
    L49:
        r23 = r11.readSFixed64();
        goto L59
    L50:
        r24 = r11.readSFixed32();
        goto L56
    L51:
        r24 = r11.readUInt32();
        goto L56
    L52:
        r19 = Boolean.valueOf(r11.readBool());
        goto L63
    L53:
        r24 = r11.readFixed32();
        goto L56
    L54:
        r23 = r11.readFixed64();
        goto L59
    L55:
        r24 = r11.readInt32();
        goto L56
    L57:
        r23 = r11.readUInt64();
        goto L59
    L58:
        r23 = r11.readInt64();
        goto L59
    L60:
        r19 = Float.valueOf(r11.readFloat());
        goto L63
    L61:
        r19 = Double.valueOf(r11.readDouble());
        goto L63
    L46:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r17.descriptor.isPacked() == false) goto L32;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r17.descriptor.getLiteType().ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        ArrayList r25 = new ArrayList();
        r11.readEnumList(r25);
        ArrayList r26 = new ArrayList();
        Iterator<Integer> r27 = r25.iterator();
    L12:
        if (r27.hasNext() == false) goto L31;
        int r28 = r27.next().intValue();
        Descriptors.EnumValueDescriptor r29 = r17.descriptor.getEnumType().findValueByNumber(r28);
        if (r29 != null) goto L15;
        r15 = (UB) SchemaUtil.storeUnknownEnum(r10, r18, r28, r15, r16);
        goto L12
    L15:
        r26.add(r29);
    L31:
        r14.setField(r17.descriptor, r26);
        goto L74
    L17:
        ArrayList r30 = new ArrayList();
        r11.readSInt64List(r30);
    L30:
        r26 = r30;
        goto L31
    L18:
        r30 = new ArrayList();
        r11.readSInt32List(r30);
        goto L30
    L19:
        r30 = new ArrayList();
        r11.readSFixed64List(r30);
        goto L30
    L20:
        r30 = new ArrayList();
        r11.readSFixed32List(r30);
        goto L30
    L21:
        r30 = new ArrayList();
        r11.readUInt32List(r30);
        goto L30
    L22:
        r30 = new ArrayList();
        r11.readBoolList(r30);
        goto L30
    L23:
        r30 = new ArrayList();
        r11.readFixed32List(r30);
        goto L30
    L24:
        r30 = new ArrayList();
        r11.readFixed64List(r30);
        goto L30
    L25:
        r30 = new ArrayList();
        r11.readInt32List(r30);
        goto L30
    L26:
        r30 = new ArrayList();
        r11.readUInt64List(r30);
        goto L30
    L27:
        r30 = new ArrayList();
        r11.readInt64List(r30);
        goto L30
    L28:
        r30 = new ArrayList();
        r11.readFloatList(r30);
        goto L30
    L29:
        r30 = new ArrayList();
        r11.readDoubleList(r30);
        goto L30
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r17.descriptor.getLiteType());
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader r10, Object r11, ExtensionRegistryLite r12, FieldSet<Descriptors.FieldDescriptor> r13) {
        ExtensionRegistry.ExtensionInfo r14 = (ExtensionRegistry.ExtensionInfo) r11;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L5;
        Object r15 = r10.readMessage(r14.defaultInstance.getClass(), r12);
        r13.setField(r14.descriptor, r15);
        return;
    L5:
        r13.setField(r14.descriptor, new LazyField(r14.defaultInstance, r12, r10.readBytes()));
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString r10, Object r11, ExtensionRegistryLite r12, FieldSet<Descriptors.FieldDescriptor> r13) {
        ExtensionRegistry.ExtensionInfo r14 = (ExtensionRegistry.ExtensionInfo) r11;
        Message r15 = r14.defaultInstance.newBuilderForType().buildPartial();
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L9;
        BinaryReader r16 = BinaryReader.newInstance(ByteBuffer.wrap(r10.toByteArray()), true);
        Protobuf.getInstance().mergeFrom(r15, r16, r12);
        r13.setField(r14.descriptor, r15);
        if (r16.getFieldNumber() != Integer.MAX_VALUE) goto L8;
        return;
    L8:
        throw InvalidProtocolBufferException.invalidEndTag();
    L9:
        r13.setField(r14.descriptor, new LazyField(r14.defaultInstance, r12, r10));
    }

    @Override // com.google.protobuf.ExtensionSchema
    void serializeExtension(Writer r10, Map.Entry<?, ?> r11) {
        Descriptors.FieldDescriptor r12 = (Descriptors.FieldDescriptor) r11.getKey();
        if (r12.isRepeated() == false) goto L30;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r12.getLiteType().ordinal()]) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            default: goto L87;
        };
    L7:
        SchemaUtil.writeMessageList(r12.getNumber(), (List) r11.getValue(), r10);
        return;
    L8:
        SchemaUtil.writeGroupList(r12.getNumber(), (List) r11.getValue(), r10);
        return;
    L9:
        SchemaUtil.writeStringList(r12.getNumber(), (List) r11.getValue(), r10);
        return;
    L10:
        SchemaUtil.writeBytesList(r12.getNumber(), (List) r11.getValue(), r10);
        return;
    L11:
        List r13 = (List) r11.getValue();
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        r14.add(Integer.valueOf(((Descriptors.EnumValueDescriptor) r15.next()).getNumber()));
        goto L13
    L15:
        SchemaUtil.writeInt32List(r12.getNumber(), r14, r10, r12.isPacked());
        return;
    L16:
        SchemaUtil.writeSInt64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L17:
        SchemaUtil.writeSInt32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L18:
        SchemaUtil.writeSFixed64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L19:
        SchemaUtil.writeSFixed32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L20:
        SchemaUtil.writeUInt32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L21:
        SchemaUtil.writeBoolList(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L22:
        SchemaUtil.writeFixed32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L23:
        SchemaUtil.writeFixed64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L24:
        SchemaUtil.writeInt32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L25:
        SchemaUtil.writeUInt64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L26:
        SchemaUtil.writeInt64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L27:
        SchemaUtil.writeFloatList(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L28:
        SchemaUtil.writeDoubleList(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L87:
        return;
    L30:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r12.getLiteType().ordinal()]) {
            case 1: goto L50;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L44;
            case 7: goto L43;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L40;
            case 11: goto L39;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L33;
            case 18: goto L32;
            default: goto L88;
        };
    L32:
        r10.writeMessage(r12.getNumber(), r11.getValue());
        return;
    L33:
        r10.writeGroup(r12.getNumber(), r11.getValue());
        return;
    L34:
        r10.writeString(r12.getNumber(), (String) r11.getValue());
        return;
    L35:
        r10.writeBytes(r12.getNumber(), (ByteString) r11.getValue());
        return;
    L36:
        int r16 = r12.getNumber();
        int r17 = ((Descriptors.EnumValueDescriptor) r11.getValue()).getNumber();
    L46:
        r10.writeInt32(r16, r17);
        return;
    L37:
        r10.writeSInt64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L38:
        r10.writeSInt32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L39:
        r10.writeSFixed64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L40:
        r10.writeSFixed32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L41:
        r10.writeUInt32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L42:
        r10.writeBool(r12.getNumber(), ((Boolean) r11.getValue()).booleanValue());
        return;
    L43:
        r10.writeFixed32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L44:
        r10.writeFixed64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L45:
        r16 = r12.getNumber();
        r17 = ((Integer) r11.getValue()).intValue();
        goto L46
    L47:
        r10.writeUInt64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L48:
        r10.writeInt64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L49:
        r10.writeFloat(r12.getNumber(), ((Float) r11.getValue()).floatValue());
        return;
    L50:
        r10.writeDouble(r12.getNumber(), ((Double) r11.getValue()).doubleValue());
        return;
    }

    @Override // com.google.protobuf.ExtensionSchema
    void setExtensions(Object r10, FieldSet<Descriptors.FieldDescriptor> r11) {
        UnsafeUtil.putObject(r10, EXTENSION_FIELD_OFFSET, r11);
    }
}
