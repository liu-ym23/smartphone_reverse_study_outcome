package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
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
    int extensionNumber(Map.Entry<?, ?> r2) {
        return ((GeneratedMessageLite.ExtensionDescriptor) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), GeneratedMessageLite.ExtensionDescriptor.class, "com.obric.memorydata.plugin")).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite r2, MessageLite r3, int r4) {
        return r2.findLiteExtensionByNumber((MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object r2) {
        return ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions;
    }

    @Override // com.google.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object r2) {
        return ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.ExtendableMessage.class, "com.obric.memorydata.plugin")).ensureExtensionsAreMutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite r2) {
        return ZeusTransformUtils.instanceOf((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin"), GeneratedMessageLite.ExtendableMessage.class);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void makeImmutable(Object r1) {
        getExtensions(r1).makeImmutable();
    }

    @Override // com.google.protobuf.ExtensionSchema
    <UT, UB> UB parseExtension(Object r8, Reader r9, Object r10, ExtensionRegistryLite r11, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r12, UB r13, UnknownFieldSchema<UT, UB> r14) {
        Reader r7 = (Reader) ZeusTransformUtils.wrapperContextForParams(r9, Reader.class, "com.obric.memorydata.plugin");
        GeneratedMessageLite.GeneratedExtension r15 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(r10, GeneratedMessageLite.GeneratedExtension.class, "com.obric.memorydata.plugin");
        int r2 = r15.getNumber();
        if (r15.descriptor.isRepeated() == true) goto L5;
    L25:
        Object r16 = null;
        if (r15.getLiteType() != WireFormat.FieldType.ENUM) goto L32;
        int r17 = r7.readInt32();
        if (r15.descriptor.getEnumType().findValueByNumber(r17) == null) goto L30;
    L67:
        r16 = Integer.valueOf(r17);
    L74:
        if (r15.isRepeated() == false) goto L76;
        r12.addRepeatedField(r15.descriptor, r16);
    L84:
        return r13;
    L76:
        int r18 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()];
        if (r18 == 17) goto L81;
        Object r19 = r16;
        if (r18 == 18) goto L81;
    L24:
        r12.setField(r15.descriptor, r19);
    L81:
        Object r20 = r12.getField(r15.descriptor);
        r19 = r16;
        if (r20 == null) goto L24;
        r19 = Internal.mergeMessage(r20, r16);
        goto L24
    L30:
        return (UB) SchemaUtil.storeUnknownEnum(r8, r2, r17, r13, r14);
    L32:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()]) {
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
        r16 = r7.readString();
        goto L74
    L55:
        r16 = r7.readBytes();
        goto L74
    L58:
        long r21 = r7.readSInt64();
    L70:
        r16 = Long.valueOf(r21);
        goto L74
    L59:
        r17 = r7.readSInt32();
        goto L67
    L60:
        r21 = r7.readSFixed64();
        goto L70
    L61:
        r17 = r7.readSFixed32();
        goto L67
    L62:
        r17 = r7.readUInt32();
        goto L67
    L63:
        r16 = Boolean.valueOf(r7.readBool());
        goto L74
    L64:
        r17 = r7.readFixed32();
        goto L67
    L65:
        r21 = r7.readFixed64();
        goto L70
    L66:
        r17 = r7.readInt32();
        goto L67
    L68:
        r21 = r7.readUInt64();
        goto L70
    L69:
        r21 = r7.readInt64();
        goto L70
    L71:
        r16 = Float.valueOf(r7.readFloat());
        goto L74
    L72:
        r16 = Double.valueOf(r7.readDouble());
        goto L74
    L35:
        if (r15.isRepeated() == true) goto L43;
        Object r22 = r12.getField(r15.descriptor);
        if (ZeusTransformUtils.instanceOf(r22, GeneratedMessageLite.class) == false) goto L43;
        Schema r110 = Protobuf.getInstance().schemaFor(r22);
        if (((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r22, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).isMutable() == true) goto L41;
        Object r111 = r110.newInstance();
        r110.mergeFrom(r111, r22);
        r12.setField(r15.descriptor, r111);
        r22 = r111;
    L41:
        r7.mergeMessageField(r22, r110, r11);
        return r13;
    L43:
        r16 = r7.readMessage(r15.getMessageDefaultInstance().getClass(), r11);
        goto L74
    L45:
        if (r15.isRepeated() == true) goto L53;
        Object r23 = r12.getField(r15.descriptor);
        if (ZeusTransformUtils.instanceOf(r23, GeneratedMessageLite.class) == false) goto L53;
        Schema r112 = Protobuf.getInstance().schemaFor(r23);
        if (((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r23, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).isMutable() == true) goto L51;
        Object r113 = r112.newInstance();
        r112.mergeFrom(r113, r23);
        r12.setField(r15.descriptor, r113);
        r23 = r113;
    L51:
        r7.mergeGroupField(r23, r112, r11);
        return r13;
    L53:
        r16 = r7.readGroup(r15.getMessageDefaultInstance().getClass(), r11);
        goto L74
    L57:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r15.descriptor.isPacked() == false) goto L25;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()]) {
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
        ArrayList r114 = new ArrayList();
        r7.readEnumList(r114);
        r13 = (UB) SchemaUtil.filterUnknownEnumList(r8, r2, r114, r15.descriptor.getEnumType(), r13, r14);
        r19 = r114;
        goto L24
    L11:
        ArrayList r115 = new ArrayList();
        r7.readSInt64List(r115);
        r19 = r115;
        goto L24
    L12:
        ArrayList r116 = new ArrayList();
        r7.readSInt32List(r116);
        r19 = r116;
        goto L24
    L13:
        ArrayList r117 = new ArrayList();
        r7.readSFixed64List(r117);
        r19 = r117;
        goto L24
    L14:
        ArrayList r118 = new ArrayList();
        r7.readSFixed32List(r118);
        r19 = r118;
        goto L24
    L15:
        ArrayList r119 = new ArrayList();
        r7.readUInt32List(r119);
        r19 = r119;
        goto L24
    L16:
        ArrayList r120 = new ArrayList();
        r7.readBoolList(r120);
        r19 = r120;
        goto L24
    L17:
        ArrayList r121 = new ArrayList();
        r7.readFixed32List(r121);
        r19 = r121;
        goto L24
    L18:
        ArrayList r122 = new ArrayList();
        r7.readFixed64List(r122);
        r19 = r122;
        goto L24
    L19:
        ArrayList r123 = new ArrayList();
        r7.readInt32List(r123);
        r19 = r123;
        goto L24
    L20:
        ArrayList r124 = new ArrayList();
        r7.readUInt64List(r124);
        r19 = r124;
        goto L24
    L21:
        ArrayList r125 = new ArrayList();
        r7.readInt64List(r125);
        r19 = r125;
        goto L24
    L22:
        ArrayList r126 = new ArrayList();
        r7.readFloatList(r126);
        r19 = r126;
        goto L24
    L23:
        ArrayList r127 = new ArrayList();
        r7.readDoubleList(r127);
        r19 = r127;
        goto L24
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r15.descriptor.getLiteType());
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader r2, Object r3, ExtensionRegistryLite r4, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r5) {
        Reader r1 = (Reader) ZeusTransformUtils.wrapperContextForParams(r2, Reader.class, "com.obric.memorydata.plugin");
        GeneratedMessageLite.GeneratedExtension r6 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.GeneratedExtension.class, "com.obric.memorydata.plugin");
        Object r7 = r1.readMessage(r6.getMessageDefaultInstance().getClass(), r4);
        r5.setField(r6.descriptor, r7);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString r2, Object r3, ExtensionRegistryLite r4, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r5) {
        GeneratedMessageLite.GeneratedExtension r1 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.GeneratedExtension.class, "com.obric.memorydata.plugin");
        MessageLite.Builder r6 = r1.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream r7 = r2.newCodedInput();
        r6.mergeFrom(r7, r4);
        r5.setField(r1.descriptor, r6.buildPartial());
        r7.checkLastTagWas(0);
    }

    @Override // com.google.protobuf.ExtensionSchema
    void serializeExtension(Writer r5, Map.Entry<?, ?> r6) {
        Writer r4 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r6, Map.Entry.class, "com.obric.memorydata.plugin");
        GeneratedMessageLite.ExtensionDescriptor r8 = (GeneratedMessageLite.ExtensionDescriptor) ZeusTransformUtils.preCheckCast(r7.getKey(), GeneratedMessageLite.ExtensionDescriptor.class, "com.obric.memorydata.plugin");
        if (r8.isRepeated() == false) goto L33;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.getLiteType().ordinal()]) {
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
        List r1 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isEmpty() == true) goto L54;
        SchemaUtil.writeMessageList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, Protobuf.getInstance().schemaFor(r1.get(0).getClass()));
        return;
    L54:
        return;
    L12:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.isEmpty() == true) goto L57;
        SchemaUtil.writeGroupList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, Protobuf.getInstance().schemaFor(r2.get(0).getClass()));
        return;
    L57:
        return;
    L17:
        SchemaUtil.writeStringList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4);
        return;
    L18:
        SchemaUtil.writeBytesList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4);
        return;
    L19:
        SchemaUtil.writeSInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L20:
        SchemaUtil.writeSInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L21:
        SchemaUtil.writeSFixed64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L22:
        SchemaUtil.writeSFixed32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L23:
        SchemaUtil.writeUInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L24:
        SchemaUtil.writeBoolList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L25:
        SchemaUtil.writeFixed32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L26:
        SchemaUtil.writeFixed64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L27:
        SchemaUtil.writeInt32List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L28:
        SchemaUtil.writeUInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L29:
        SchemaUtil.writeInt64List(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L30:
        SchemaUtil.writeFloatList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L31:
        SchemaUtil.writeDoubleList(r8.getNumber(), (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin"), r4, r8.isPacked());
        return;
    L90:
        return;
    L33:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.getLiteType().ordinal()]) {
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
        r4.writeMessage(r8.getNumber(), r7.getValue(), Protobuf.getInstance().schemaFor(r7.getValue().getClass()));
        return;
    L36:
        r4.writeGroup(r8.getNumber(), r7.getValue(), Protobuf.getInstance().schemaFor(r7.getValue().getClass()));
        return;
    L37:
        r4.writeString(r8.getNumber(), (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin"));
        return;
    L38:
        r4.writeBytes(r8.getNumber(), (ByteString) ZeusTransformUtils.preCheckCast(r7.getValue(), ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L39:
        r4.writeSInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L40:
        r4.writeSInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L41:
        r4.writeSFixed64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L42:
        r4.writeSFixed32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L43:
        r4.writeUInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L44:
        r4.writeBool(r8.getNumber(), ((Boolean) ZeusTransformUtils.preCheckCast(r7.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L45:
        r4.writeFixed32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L46:
        r4.writeFixed64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L47:
        r4.writeInt32(r8.getNumber(), ((Integer) ZeusTransformUtils.preCheckCast(r7.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L48:
        r4.writeUInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L49:
        r4.writeInt64(r8.getNumber(), ((Long) ZeusTransformUtils.preCheckCast(r7.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L50:
        r4.writeFloat(r8.getNumber(), ((Float) ZeusTransformUtils.preCheckCast(r7.getValue(), Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L51:
        r4.writeDouble(r8.getNumber(), ((Double) ZeusTransformUtils.preCheckCast(r7.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    }

    @Override // com.google.protobuf.ExtensionSchema
    void setExtensions(Object r2, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r3) {
        ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions = r3;
    }
}
