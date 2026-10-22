package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
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

    ExtensionSchemaLite() {
    }

    @Override // com.google.protobuf.ExtensionSchema
    int extensionNumber(Map.Entry<?, ?> r10) {
        return ((GeneratedMessageLite.ExtensionDescriptor) r10.getKey()).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite r10, MessageLite r11, int r12) {
        return r10.findLiteExtensionByNumber(r11, r12);
    }

    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object r10) {
        return ((GeneratedMessageLite.ExtendableMessage) r10).extensions;
    }

    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object r10) {
        return ((GeneratedMessageLite.ExtendableMessage) r10).ensureExtensionsAreMutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite r10) {
        return r10 instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.google.protobuf.ExtensionSchema
    void makeImmutable(Object r10) {
        getExtensions(r10).makeImmutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    <UT, UB> UB parseExtension(Object r10, Reader r11, Object r12, ExtensionRegistryLite r13, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r14, UB r15, UnknownFieldSchema<UT, UB> r16) {
        GeneratedMessageLite.GeneratedExtension r17 = (GeneratedMessageLite.GeneratedExtension) r12;
        int r18 = r17.getNumber();
        if (r17.descriptor.isRepeated() == true) goto L5;
    L25:
        Object r19 = null;
        if (r17.getLiteType() != WireFormat.FieldType.ENUM) goto L32;
        int r20 = r11.readInt32();
        if (r17.descriptor.getEnumType().findValueByNumber(r20) == null) goto L30;
    L67:
        r19 = Integer.valueOf(r20);
    L74:
        if (r17.isRepeated() == false) goto L76;
        r14.addRepeatedField(r17.descriptor, r19);
    L84:
        return r15;
    L76:
        int r21 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r17.getLiteType().ordinal()];
        if (r21 == 17) goto L81;
        Object r22 = r19;
        if (r21 == 18) goto L81;
    L24:
        r14.setField(r17.descriptor, r22);
    L81:
        Object r23 = r14.getField(r17.descriptor);
        r22 = r19;
        if (r23 == null) goto L24;
        r22 = Internal.mergeMessage(r23, r19);
        goto L24
    L30:
        return (UB) SchemaUtil.storeUnknownEnum(r10, r18, r20, r15, r16);
    L32:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r17.getLiteType().ordinal()]) {
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
            default: goto L74;
        };
    L54:
        r19 = r11.readString();
        goto L74
    L55:
        r19 = r11.readBytes();
        goto L74
    L58:
        long r24 = r11.readSInt64();
    L70:
        r19 = Long.valueOf(r24);
        goto L74
    L59:
        r20 = r11.readSInt32();
        goto L67
    L60:
        r24 = r11.readSFixed64();
        goto L70
    L61:
        r20 = r11.readSFixed32();
        goto L67
    L62:
        r20 = r11.readUInt32();
        goto L67
    L63:
        r19 = Boolean.valueOf(r11.readBool());
        goto L74
    L64:
        r20 = r11.readFixed32();
        goto L67
    L65:
        r24 = r11.readFixed64();
        goto L70
    L66:
        r20 = r11.readInt32();
        goto L67
    L68:
        r24 = r11.readUInt64();
        goto L70
    L69:
        r24 = r11.readInt64();
        goto L70
    L71:
        r19 = Float.valueOf(r11.readFloat());
        goto L74
    L72:
        r19 = Double.valueOf(r11.readDouble());
        goto L74
    L35:
        if (r17.isRepeated() == true) goto L43;
        Object r25 = r14.getField(r17.descriptor);
        if ((r25 instanceof GeneratedMessageLite) == false) goto L43;
        Schema r26 = Protobuf.getInstance().schemaFor(r25);
        if (((GeneratedMessageLite) r25).isMutable() == true) goto L41;
        Object r110 = r26.newInstance();
        r26.mergeFrom(r110, r25);
        r14.setField(r17.descriptor, r110);
        r25 = r110;
    L41:
        r11.mergeMessageField(r25, r26, r13);
        return r15;
    L43:
        r19 = r11.readMessage(r17.getMessageDefaultInstance().getClass(), r13);
        goto L74
    L45:
        if (r17.isRepeated() == true) goto L53;
        Object r27 = r14.getField(r17.descriptor);
        if ((r27 instanceof GeneratedMessageLite) == false) goto L53;
        Schema r28 = Protobuf.getInstance().schemaFor(r27);
        if (((GeneratedMessageLite) r27).isMutable() == true) goto L51;
        Object r111 = r28.newInstance();
        r28.mergeFrom(r111, r27);
        r14.setField(r17.descriptor, r111);
        r27 = r111;
    L51:
        r11.mergeGroupField(r27, r28, r13);
        return r15;
    L53:
        r19 = r11.readGroup(r17.getMessageDefaultInstance().getClass(), r13);
        goto L74
    L57:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r17.descriptor.isPacked() == false) goto L25;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r17.getLiteType().ordinal()]) {
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
        ArrayList r29 = new ArrayList();
        r11.readEnumList(r29);
        r15 = (UB) SchemaUtil.filterUnknownEnumList(r10, r18, r29, r17.descriptor.getEnumType(), r15, r16);
        r22 = r29;
        goto L24
    L11:
        ArrayList r30 = new ArrayList();
        r11.readSInt64List(r30);
        r22 = r30;
        goto L24
    L12:
        ArrayList r31 = new ArrayList();
        r11.readSInt32List(r31);
        r22 = r31;
        goto L24
    L13:
        ArrayList r32 = new ArrayList();
        r11.readSFixed64List(r32);
        r22 = r32;
        goto L24
    L14:
        ArrayList r33 = new ArrayList();
        r11.readSFixed32List(r33);
        r22 = r33;
        goto L24
    L15:
        ArrayList r34 = new ArrayList();
        r11.readUInt32List(r34);
        r22 = r34;
        goto L24
    L16:
        ArrayList r35 = new ArrayList();
        r11.readBoolList(r35);
        r22 = r35;
        goto L24
    L17:
        ArrayList r36 = new ArrayList();
        r11.readFixed32List(r36);
        r22 = r36;
        goto L24
    L18:
        ArrayList r37 = new ArrayList();
        r11.readFixed64List(r37);
        r22 = r37;
        goto L24
    L19:
        ArrayList r38 = new ArrayList();
        r11.readInt32List(r38);
        r22 = r38;
        goto L24
    L20:
        ArrayList r39 = new ArrayList();
        r11.readUInt64List(r39);
        r22 = r39;
        goto L24
    L21:
        ArrayList r40 = new ArrayList();
        r11.readInt64List(r40);
        r22 = r40;
        goto L24
    L22:
        ArrayList r41 = new ArrayList();
        r11.readFloatList(r41);
        r22 = r41;
        goto L24
    L23:
        ArrayList r42 = new ArrayList();
        r11.readDoubleList(r42);
        r22 = r42;
        goto L24
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r17.descriptor.getLiteType());
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader r10, Object r11, ExtensionRegistryLite r12, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r13) {
        GeneratedMessageLite.GeneratedExtension r14 = (GeneratedMessageLite.GeneratedExtension) r11;
        Object r15 = r10.readMessage(r14.getMessageDefaultInstance().getClass(), r12);
        r13.setField(r14.descriptor, r15);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString r10, Object r11, ExtensionRegistryLite r12, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r13) {
        GeneratedMessageLite.GeneratedExtension r14 = (GeneratedMessageLite.GeneratedExtension) r11;
        MessageLite.Builder r15 = r14.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream r16 = r10.newCodedInput();
        r15.mergeFrom(r16, r12);
        r13.setField(r14.descriptor, r15.buildPartial());
        r16.checkLastTagWas(0);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void serializeExtension(Writer r10, Map.Entry<?, ?> r11) {
        GeneratedMessageLite.ExtensionDescriptor r12 = (GeneratedMessageLite.ExtensionDescriptor) r11.getKey();
        if (r12.isRepeated() == false) goto L33;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r12.getLiteType().ordinal()]) {
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
        List r13 = (List) r11.getValue();
        if (r13 != null) goto L10;
        return;
    L10:
        if (r13.isEmpty() == true) goto L54;
        SchemaUtil.writeMessageList(r12.getNumber(), (List) r11.getValue(), r10, Protobuf.getInstance().schemaFor(r13.get(0).getClass()));
        return;
    L54:
        return;
    L12:
        List r14 = (List) r11.getValue();
        if (r14 != null) goto L15;
        return;
    L15:
        if (r14.isEmpty() == true) goto L57;
        SchemaUtil.writeGroupList(r12.getNumber(), (List) r11.getValue(), r10, Protobuf.getInstance().schemaFor(r14.get(0).getClass()));
        return;
    L57:
        return;
    L17:
        SchemaUtil.writeStringList(r12.getNumber(), (List) r11.getValue(), r10);
        return;
    L18:
        SchemaUtil.writeBytesList(r12.getNumber(), (List) r11.getValue(), r10);
        return;
    L19:
        SchemaUtil.writeSInt64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L20:
        SchemaUtil.writeSInt32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L21:
        SchemaUtil.writeSFixed64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L22:
        SchemaUtil.writeSFixed32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L23:
        SchemaUtil.writeUInt32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L24:
        SchemaUtil.writeBoolList(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L25:
        SchemaUtil.writeFixed32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L26:
        SchemaUtil.writeFixed64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L27:
        SchemaUtil.writeInt32List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L28:
        SchemaUtil.writeUInt64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L29:
        SchemaUtil.writeInt64List(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L30:
        SchemaUtil.writeFloatList(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L31:
        SchemaUtil.writeDoubleList(r12.getNumber(), (List) r11.getValue(), r10, r12.isPacked());
        return;
    L90:
        return;
    L33:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r12.getLiteType().ordinal()]) {
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
        r10.writeMessage(r12.getNumber(), r11.getValue(), Protobuf.getInstance().schemaFor(r11.getValue().getClass()));
        return;
    L36:
        r10.writeGroup(r12.getNumber(), r11.getValue(), Protobuf.getInstance().schemaFor(r11.getValue().getClass()));
        return;
    L37:
        r10.writeString(r12.getNumber(), (String) r11.getValue());
        return;
    L38:
        r10.writeBytes(r12.getNumber(), (ByteString) r11.getValue());
        return;
    L39:
        r10.writeSInt64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L40:
        r10.writeSInt32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L41:
        r10.writeSFixed64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L42:
        r10.writeSFixed32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L43:
        r10.writeUInt32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L44:
        r10.writeBool(r12.getNumber(), ((Boolean) r11.getValue()).booleanValue());
        return;
    L45:
        r10.writeFixed32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L46:
        r10.writeFixed64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L47:
        r10.writeInt32(r12.getNumber(), ((Integer) r11.getValue()).intValue());
        return;
    L48:
        r10.writeUInt64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L49:
        r10.writeInt64(r12.getNumber(), ((Long) r11.getValue()).longValue());
        return;
    L50:
        r10.writeFloat(r12.getNumber(), ((Float) r11.getValue()).floatValue());
        return;
    L51:
        r10.writeDouble(r12.getNumber(), ((Double) r11.getValue()).doubleValue());
        return;
    }

    @Override // com.google.protobuf.ExtensionSchema
    void setExtensions(Object r10, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r11) {
        ((GeneratedMessageLite.ExtendableMessage) r10).extensions = r11;
    }
}
