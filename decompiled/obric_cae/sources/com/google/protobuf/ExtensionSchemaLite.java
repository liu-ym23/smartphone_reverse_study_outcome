package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
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

    public ExtensionSchemaLite() {
    }

    @Override // com.google.protobuf.ExtensionSchema
    public int extensionNumber(Map.Entry<?, ?> r8) {
        return ((GeneratedMessageLite.ExtensionDescriptor) r8.getKey()).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    public Object findExtensionByNumber(ExtensionRegistryLite r8, MessageLite r10, int r11) {
        return r8.findLiteExtensionByNumber(r10, r11);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object r8) {
        return ((GeneratedMessageLite.ExtendableMessage) r8).extensions;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object r8) {
        return ((GeneratedMessageLite.ExtendableMessage) r8).ensureExtensionsAreMutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    public boolean hasExtensions(MessageLite r8) {
        return r8 instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void makeImmutable(Object r8) {
        getExtensions(r8).makeImmutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    public <UT, UB> UB parseExtension(Object r8, Reader r10, Object r11, ExtensionRegistryLite r12, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r13, UB r14, UnknownFieldSchema<UT, UB> r15) {
        GeneratedMessageLite.GeneratedExtension r16 = (GeneratedMessageLite.GeneratedExtension) r11;
        int r17 = r16.getNumber();
        if (r16.descriptor.isRepeated() == false) goto L26;
        if (r16.descriptor.isPacked() == false) goto L26;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r16.getLiteType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        ArrayList r18 = new ArrayList();
        r10.readEnumList(r18);
        r14 = (UB) SchemaUtil.filterUnknownEnumList(r8, r17, r18, r16.descriptor.getEnumType(), r14, r15);
        Object r19 = r18;
    L24:
        r13.setField(r16.descriptor, r19);
    L84:
        return r14;
    L11:
        ArrayList r20 = new ArrayList();
        r10.readSInt64List(r20);
        r19 = r20;
        goto L24
    L12:
        ArrayList r21 = new ArrayList();
        r10.readSInt32List(r21);
        r19 = r21;
        goto L24
    L13:
        ArrayList r22 = new ArrayList();
        r10.readSFixed64List(r22);
        r19 = r22;
        goto L24
    L14:
        ArrayList r23 = new ArrayList();
        r10.readSFixed32List(r23);
        r19 = r23;
        goto L24
    L15:
        ArrayList r24 = new ArrayList();
        r10.readUInt32List(r24);
        r19 = r24;
        goto L24
    L16:
        ArrayList r25 = new ArrayList();
        r10.readBoolList(r25);
        r19 = r25;
        goto L24
    L17:
        ArrayList r26 = new ArrayList();
        r10.readFixed32List(r26);
        r19 = r26;
        goto L24
    L18:
        ArrayList r27 = new ArrayList();
        r10.readFixed64List(r27);
        r19 = r27;
        goto L24
    L19:
        ArrayList r28 = new ArrayList();
        r10.readInt32List(r28);
        r19 = r28;
        goto L24
    L20:
        ArrayList r29 = new ArrayList();
        r10.readUInt64List(r29);
        r19 = r29;
        goto L24
    L21:
        ArrayList r30 = new ArrayList();
        r10.readInt64List(r30);
        r19 = r30;
        goto L24
    L22:
        ArrayList r31 = new ArrayList();
        r10.readFloatList(r31);
        r19 = r31;
        goto L24
    L23:
        ArrayList r32 = new ArrayList();
        r10.readDoubleList(r32);
        r19 = r32;
        goto L24
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r16.descriptor.getLiteType());
    L26:
        if (r16.getLiteType() != WireFormat.FieldType.ENUM) goto L32;
        int r33 = r10.readInt32();
        if (r16.descriptor.getEnumType().findValueByNumber(r33) == null) goto L30;
    L67:
        Object r34 = Integer.valueOf(r33);
    L74:
        if (r16.isRepeated() == false) goto L76;
        r13.addRepeatedField(r16.descriptor, r34);
        goto L84
    L76:
        int r35 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r16.getLiteType().ordinal()];
        if (r35 == 17) goto L81;
        r19 = r34;
        if (r35 != 18) goto L24;
    L81:
        Object r36 = r13.getField(r16.descriptor);
        r19 = r34;
        if (r36 == null) goto L24;
        r19 = Internal.mergeMessage(r36, r34);
        goto L24
    L30:
        return (UB) SchemaUtil.storeUnknownEnum(r8, r17, r33, r14, r15);
    L32:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r16.getLiteType().ordinal()]) {
            case 1: goto L72;
            case 2: goto L71;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L66;
            case 6: goto L65;
            case 7: goto L64;
            case 8: goto L63;
            case 9: goto L62;
            case 10: goto L61;
            case 11: goto L60;
            case 12: goto L59;
            case 13: goto L58;
            case 14: goto L57;
            case 15: goto L55;
            case 16: goto L54;
            case 17: goto L45;
            case 18: goto L35;
            default: goto L33;
        };
    L33:
        r34 = null;
        goto L74
    L54:
        r34 = r10.readString();
        goto L74
    L55:
        r34 = r10.readBytes();
        goto L74
    L58:
        long r37 = r10.readSInt64();
    L70:
        r34 = Long.valueOf(r37);
        goto L74
    L59:
        r33 = r10.readSInt32();
        goto L67
    L60:
        r37 = r10.readSFixed64();
        goto L70
    L61:
        r33 = r10.readSFixed32();
        goto L67
    L62:
        r33 = r10.readUInt32();
        goto L67
    L63:
        r34 = Boolean.valueOf(r10.readBool());
        goto L74
    L64:
        r33 = r10.readFixed32();
        goto L67
    L65:
        r37 = r10.readFixed64();
        goto L70
    L66:
        r33 = r10.readInt32();
        goto L67
    L68:
        r37 = r10.readUInt64();
        goto L70
    L69:
        r37 = r10.readInt64();
        goto L70
    L71:
        r34 = Float.valueOf(r10.readFloat());
        goto L74
    L72:
        r34 = Double.valueOf(r10.readDouble());
        goto L74
    L35:
        if (r16.isRepeated() == true) goto L43;
        Object r38 = r13.getField(r16.descriptor);
        if ((r38 instanceof GeneratedMessageLite) == false) goto L43;
        Schema r39 = Protobuf.getInstance().schemaFor(r38);
        if (((GeneratedMessageLite) r38).isMutable() == true) goto L41;
        Object r110 = r39.newInstance();
        r39.mergeFrom(r110, r38);
        r13.setField(r16.descriptor, r110);
        r38 = r110;
    L41:
        r10.mergeMessageField(r38, r39, r12);
        return r14;
    L43:
        r34 = r10.readMessage(r16.getMessageDefaultInstance().getClass(), r12);
        goto L74
    L45:
        if (r16.isRepeated() == true) goto L53;
        Object r40 = r13.getField(r16.descriptor);
        if ((r40 instanceof GeneratedMessageLite) == false) goto L53;
        Schema r41 = Protobuf.getInstance().schemaFor(r40);
        if (((GeneratedMessageLite) r40).isMutable() == true) goto L51;
        Object r111 = r41.newInstance();
        r41.mergeFrom(r111, r40);
        r13.setField(r16.descriptor, r111);
        r40 = r111;
    L51:
        r10.mergeGroupField(r40, r41, r12);
        return r14;
    L53:
        r34 = r10.readGroup(r16.getMessageDefaultInstance().getClass(), r12);
        goto L74
    L57:
        throw new IllegalStateException("Shouldn't reach here.");
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void parseLengthPrefixedMessageSetItem(Reader r8, Object r10, ExtensionRegistryLite r11, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r12) {
        GeneratedMessageLite.GeneratedExtension r13 = (GeneratedMessageLite.GeneratedExtension) r10;
        Object r14 = r8.readMessage(r13.getMessageDefaultInstance().getClass(), r11);
        r12.setField(r13.descriptor, r14);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void parseMessageSetItem(ByteString r8, Object r10, ExtensionRegistryLite r11, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r12) {
        GeneratedMessageLite.GeneratedExtension r13 = (GeneratedMessageLite.GeneratedExtension) r10;
        MessageLite.Builder r14 = r13.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream r15 = r8.newCodedInput();
        r14.mergeFrom(r15, r11);
        r12.setField(r13.descriptor, r14.buildPartial());
        r15.checkLastTagWas(0);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void serializeExtension(Writer r8, Map.Entry<?, ?> r10) {
        GeneratedMessageLite.ExtensionDescriptor r11 = (GeneratedMessageLite.ExtensionDescriptor) r10.getKey();
        if (r11.isRepeated() == false) goto L33;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.getLiteType().ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L27;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L12;
            case 18: goto L7;
            default: goto L90;
        };
    L7:
        List r12 = (List) r10.getValue();
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.isEmpty() == true) goto L54;
        SchemaUtil.writeMessageList(r11.getNumber(), (List) r10.getValue(), r8, Protobuf.getInstance().schemaFor(r12.get(0).getClass()));
        return;
    L54:
        return;
    L12:
        List r13 = (List) r10.getValue();
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.isEmpty() == true) goto L57;
        SchemaUtil.writeGroupList(r11.getNumber(), (List) r10.getValue(), r8, Protobuf.getInstance().schemaFor(r13.get(0).getClass()));
        return;
    L57:
        return;
    L17:
        SchemaUtil.writeStringList(r11.getNumber(), (List) r10.getValue(), r8);
        return;
    L18:
        SchemaUtil.writeBytesList(r11.getNumber(), (List) r10.getValue(), r8);
        return;
    L19:
        SchemaUtil.writeSInt64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L20:
        SchemaUtil.writeSInt32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L21:
        SchemaUtil.writeSFixed64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L22:
        SchemaUtil.writeSFixed32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L23:
        SchemaUtil.writeUInt32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L24:
        SchemaUtil.writeBoolList(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L25:
        SchemaUtil.writeFixed32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L26:
        SchemaUtil.writeFixed64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L27:
        SchemaUtil.writeInt32List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L28:
        SchemaUtil.writeUInt64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L29:
        SchemaUtil.writeInt64List(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L30:
        SchemaUtil.writeFloatList(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L31:
        SchemaUtil.writeDoubleList(r11.getNumber(), (List) r10.getValue(), r8, r11.isPacked());
        return;
    L90:
        return;
    L33:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.getLiteType().ordinal()]) {
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L49;
            case 4: goto L48;
            case 5: goto L47;
            case 6: goto L46;
            case 7: goto L45;
            case 8: goto L44;
            case 9: goto L43;
            case 10: goto L42;
            case 11: goto L41;
            case 12: goto L40;
            case 13: goto L39;
            case 14: goto L47;
            case 15: goto L38;
            case 16: goto L37;
            case 17: goto L36;
            case 18: goto L35;
            default: goto L91;
        };
    L35:
        r8.writeMessage(r11.getNumber(), r10.getValue(), Protobuf.getInstance().schemaFor(r10.getValue().getClass()));
        return;
    L36:
        r8.writeGroup(r11.getNumber(), r10.getValue(), Protobuf.getInstance().schemaFor(r10.getValue().getClass()));
        return;
    L37:
        r8.writeString(r11.getNumber(), (String) r10.getValue());
        return;
    L38:
        r8.writeBytes(r11.getNumber(), (ByteString) r10.getValue());
        return;
    L39:
        r8.writeSInt64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L40:
        r8.writeSInt32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L41:
        r8.writeSFixed64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L42:
        r8.writeSFixed32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L43:
        r8.writeUInt32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L44:
        r8.writeBool(r11.getNumber(), ((Boolean) r10.getValue()).booleanValue());
        return;
    L45:
        r8.writeFixed32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L46:
        r8.writeFixed64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L47:
        r8.writeInt32(r11.getNumber(), ((Integer) r10.getValue()).intValue());
        return;
    L48:
        r8.writeUInt64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L49:
        r8.writeInt64(r11.getNumber(), ((Long) r10.getValue()).longValue());
        return;
    L50:
        r8.writeFloat(r11.getNumber(), ((Float) r10.getValue()).floatValue());
        return;
    L51:
        r8.writeDouble(r11.getNumber(), ((Double) r10.getValue()).doubleValue());
        return;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void setExtensions(Object r8, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r10) {
        ((GeneratedMessageLite.ExtendableMessage) r8).extensions = r10;
    }
}
