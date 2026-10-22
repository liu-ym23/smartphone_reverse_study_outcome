package com.google.protobuf;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
    private static final long EXTENSION_FIELD_OFFSET = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5186a = 0;

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionSchemaFull$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
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

    public ExtensionSchemaFull() {
    }

    private static <T> long getExtensionsFieldOffset() {
        return UnsafeUtil.objectFieldOffset(GeneratedMessage.ExtendableMessage.class.getDeclaredField("extensions"));
    L4:
        th = move-exception;
        throw new IllegalStateException("Unable to lookup extension field offset", th);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public int extensionNumber(Map.Entry<?, ?> r8) {
        return ((Descriptors.FieldDescriptor) r8.getKey()).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    public Object findExtensionByNumber(ExtensionRegistryLite r8, MessageLite r10, int r11) {
        return ((ExtensionRegistry) r8).findImmutableExtensionByNumber(((Message) r10).getDescriptorForType(), r11);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Descriptors.FieldDescriptor> getExtensions(Object r8) {
        return (FieldSet) UnsafeUtil.getObject(r8, EXTENSION_FIELD_OFFSET);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object r8) {
        FieldSet<Descriptors.FieldDescriptor> r10 = getExtensions(r8);
        if (r10.isImmutable() == false) goto L6;
        FieldSet r11 = r10.clone();
        setExtensions(r8, r11);
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public boolean hasExtensions(MessageLite r8) {
        return r8 instanceof GeneratedMessage.ExtendableMessage;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void makeImmutable(Object r8) {
        getExtensions(r8).makeImmutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    public <UT, UB> UB parseExtension(Object r8, Reader r10, Object r11, ExtensionRegistryLite r12, FieldSet<Descriptors.FieldDescriptor> r13, UB r14, UnknownFieldSchema<UT, UB> r15) {
        ExtensionRegistry.ExtensionInfo r16 = (ExtensionRegistry.ExtensionInfo) r11;
        int r17 = r16.descriptor.getNumber();
        if (r16.descriptor.isRepeated() == false) goto L33;
        if (r16.descriptor.isPacked() == false) goto L33;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r16.descriptor.getLiteType().ordinal()]) {
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
        ArrayList r18 = new ArrayList();
        r10.readEnumList(r18);
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L12:
        if (r20.hasNext() == false) goto L31;
        int r21 = ((Integer) r20.next()).intValue();
        Descriptors.EnumValueDescriptor r22 = r16.descriptor.getEnumType().findValueByNumber(r21);
        if (r22 != null) goto L15;
        r14 = (UB) SchemaUtil.storeUnknownEnum(r8, r17, r21, r14, r15);
        goto L12
    L15:
        r19.add(r22);
    L31:
        r13.setField(r16.descriptor, r19);
    L74:
        return r14;
    L17:
        ArrayList r23 = new ArrayList();
        r10.readSInt64List(r23);
    L30:
        r19 = r23;
        goto L31
    L18:
        r23 = new ArrayList();
        r10.readSInt32List(r23);
        goto L30
    L19:
        r23 = new ArrayList();
        r10.readSFixed64List(r23);
        goto L30
    L20:
        r23 = new ArrayList();
        r10.readSFixed32List(r23);
        goto L30
    L21:
        r23 = new ArrayList();
        r10.readUInt32List(r23);
        goto L30
    L22:
        r23 = new ArrayList();
        r10.readBoolList(r23);
        goto L30
    L23:
        r23 = new ArrayList();
        r10.readFixed32List(r23);
        goto L30
    L24:
        r23 = new ArrayList();
        r10.readFixed64List(r23);
        goto L30
    L25:
        r23 = new ArrayList();
        r10.readInt32List(r23);
        goto L30
    L26:
        r23 = new ArrayList();
        r10.readUInt64List(r23);
        goto L30
    L27:
        r23 = new ArrayList();
        r10.readInt64List(r23);
        goto L30
    L28:
        r23 = new ArrayList();
        r10.readFloatList(r23);
        goto L30
    L29:
        r23 = new ArrayList();
        r10.readDoubleList(r23);
        goto L30
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r16.descriptor.getLiteType());
    L33:
        if (r16.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L39;
        int r24 = r10.readInt32();
        Object r25 = r16.descriptor.getEnumType().findValueByNumber(r24);
        if (r25 != null) goto L63;
        return (UB) SchemaUtil.storeUnknownEnum(r8, r17, r24, r14, r15);
    L63:
        if (r16.descriptor.isRepeated() == false) goto L65;
        r13.addRepeatedField(r16.descriptor, r25);
        goto L74
    L65:
        int r26 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r16.descriptor.getLiteType().ordinal()];
        if (r26 != 17) goto L68;
    L70:
        Object r27 = r13.getField(r16.descriptor);
        if (r27 == null) goto L73;
        r25 = Internal.mergeMessage(r27, r25);
    L73:
        r13.setField(r16.descriptor, r25);
        goto L74
    L68:
        if (r26 == 18) goto L70;
    L39:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r16.descriptor.getLiteType().ordinal()]) {
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
            default: goto L40;
        };
    L40:
        r25 = null;
        goto L63
    L41:
        r25 = r10.readMessage(r16.defaultInstance.getClass(), r12);
        goto L63
    L42:
        r25 = r10.readGroup(r16.defaultInstance.getClass(), r12);
        goto L63
    L43:
        r25 = r10.readString();
        goto L63
    L44:
        r25 = r10.readBytes();
        goto L63
    L47:
        long r28 = r10.readSInt64();
    L59:
        r25 = Long.valueOf(r28);
        goto L63
    L48:
        int r29 = r10.readSInt32();
    L56:
        r25 = Integer.valueOf(r29);
        goto L63
    L49:
        r28 = r10.readSFixed64();
        goto L59
    L50:
        r29 = r10.readSFixed32();
        goto L56
    L51:
        r29 = r10.readUInt32();
        goto L56
    L52:
        r25 = Boolean.valueOf(r10.readBool());
        goto L63
    L53:
        r29 = r10.readFixed32();
        goto L56
    L54:
        r28 = r10.readFixed64();
        goto L59
    L55:
        r29 = r10.readInt32();
        goto L56
    L57:
        r28 = r10.readUInt64();
        goto L59
    L58:
        r28 = r10.readInt64();
        goto L59
    L60:
        r25 = Float.valueOf(r10.readFloat());
        goto L63
    L61:
        r25 = Double.valueOf(r10.readDouble());
        goto L63
    L46:
        throw new IllegalStateException("Shouldn't reach here.");
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void parseLengthPrefixedMessageSetItem(Reader r8, Object r10, ExtensionRegistryLite r11, FieldSet<Descriptors.FieldDescriptor> r12) {
        ExtensionRegistry.ExtensionInfo r13 = (ExtensionRegistry.ExtensionInfo) r10;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L5;
        Object r14 = r8.readMessage(r13.defaultInstance.getClass(), r11);
        r12.setField(r13.descriptor, r14);
        return;
    L5:
        r12.setField(r13.descriptor, new LazyField(r13.defaultInstance, r11, r8.readBytes()));
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void parseMessageSetItem(ByteString r8, Object r10, ExtensionRegistryLite r11, FieldSet<Descriptors.FieldDescriptor> r12) {
        ExtensionRegistry.ExtensionInfo r13 = (ExtensionRegistry.ExtensionInfo) r10;
        Message r14 = r13.defaultInstance.newBuilderForType().buildPartial();
        if (ExtensionRegistryLite.isEagerlyParseMessageSets() == false) goto L9;
        BinaryReader r15 = BinaryReader.newInstance(ByteBuffer.wrap(r8.toByteArray()), true);
        Protobuf.getInstance().mergeFrom(r14, r15, r11);
        r12.setField(r13.descriptor, r14);
        if (r15.getFieldNumber() != Integer.MAX_VALUE) goto L8;
        return;
    L8:
        throw InvalidProtocolBufferException.invalidEndTag();
    L9:
        r12.setField(r13.descriptor, new LazyField(r13.defaultInstance, r11, r8));
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void serializeExtension(Writer r8, Map.Entry<?, ?> r10) {
        Descriptors.FieldDescriptor r11 = (Descriptors.FieldDescriptor) r10.getKey();
        if (r11.isRepeated() == false) goto L30;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.getLiteType().ordinal()]) {
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
        SchemaUtil.writeMessageList(r11.getNumber(), (List) r10.getValue(), r8);
        return;
    L8:
        SchemaUtil.writeGroupList(r11.getNumber(), (List) r10.getValue(), r8);
        return;
    L9:
        SchemaUtil.writeStringList(r11.getNumber(), (List) r10.getValue(), r8);
        return;
    L10:
        SchemaUtil.writeBytesList(r11.getNumber(), (List) r10.getValue(), r8);
        return;
    L11:
        List r12 = (List) r10.getValue();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        r13.add(Integer.valueOf(((Descriptors.EnumValueDescriptor) r14.next()).getNumber()));
        goto L13
    L15:
        SchemaUtil.writeInt32List(r11.getNumber(), r13, r8, r11.isPacked());
        return;
    L16:
        SchemaUtil.writeSInt64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L17:
        SchemaUtil.writeSInt32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L18:
        SchemaUtil.writeSFixed64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L19:
        SchemaUtil.writeSFixed32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L20:
        SchemaUtil.writeUInt32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L21:
        SchemaUtil.writeBoolList(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L22:
        SchemaUtil.writeFixed32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L23:
        SchemaUtil.writeFixed64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L24:
        SchemaUtil.writeInt32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L25:
        SchemaUtil.writeUInt64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L26:
        SchemaUtil.writeInt64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L27:
        SchemaUtil.writeFloatList(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L28:
        SchemaUtil.writeDoubleList(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L87:
        return;
    L30:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.getLiteType().ordinal()]) {
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
        r8.writeMessage(r11.getNumber(), r10.getValue());
        return;
    L33:
        r8.writeGroup(r11.getNumber(), r10.getValue());
        return;
    L34:
        r8.writeString(r11.getNumber(), (String) r10.getValue());
        return;
    L35:
        r8.writeBytes(r11.getNumber(), (ByteString) r10.getValue());
        return;
    L36:
        int r15 = r11.getNumber();
        int r16 = ((Descriptors.EnumValueDescriptor) r10.getValue()).getNumber();
    L46:
        r8.writeInt32(r15, r16);
        return;
    L37:
        r8.writeSInt64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L38:
        r8.writeSInt32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L39:
        r8.writeSFixed64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L40:
        r8.writeSFixed32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L41:
        r8.writeUInt32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L42:
        r8.writeBool(r11.getNumber(), ((Boolean) r10.getValue()).booleanValue());
        return;
    L43:
        r8.writeFixed32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L44:
        r8.writeFixed64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L45:
        r15 = r11.getNumber();
        r16 = ((Integer) r10.getValue()).intValue();
        goto L46
    L47:
        r8.writeUInt64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L48:
        r8.writeInt64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L49:
        r8.writeFloat(r11.getNumber(), ((Float) r10.getValue()).floatValue());
        return;
    L50:
        r8.writeDouble(r11.getNumber(), ((Double) r10.getValue()).doubleValue());
        return;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void setExtensions(Object r8, FieldSet<Descriptors.FieldDescriptor> r10) {
        UnsafeUtil.putObject(r8, EXTENSION_FIELD_OFFSET, r10);
    }
}
