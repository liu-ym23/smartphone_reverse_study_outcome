package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> r8, ExtensionSchema<?> r10, MessageLite r11) {
        this.unknownFieldSchema = r8;
        this.hasExtensions = r10.hasExtensions(r11);
        this.extensionSchema = r10;
        this.defaultInstance = r11;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> r8, T r10) {
        return r8.getSerializedSizeAsMessageSet(r8.getFromMessage(r10));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> r10, ExtensionSchema<ET> r11, T r12, Reader r13, ExtensionRegistryLite r14) {
        UB r8 = r10.getBuilderFromMessage(r12);
        FieldSet<ET> r15 = r11.getMutableExtensions(r12);
    L17:
    L14:
        th = move-exception;
        r10.setBuilderToMessage(r12, r8);
        throw th;
    L5:
        if (r13.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (parseMessageSetItemOrUnknownField(r13, r14, r11, r15, r10, r8) == true) goto L17;
        r10.setBuilderToMessage(r12, r8);
        return;
    L6:
        r10.setBuilderToMessage(r12, r8);
    }

    public static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> r8, ExtensionSchema<?> r10, MessageLite r11) {
        return new MessageSetSchema(r8, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader r8, ExtensionRegistryLite r10, ExtensionSchema<ET> r11, FieldSet<ET> r12, UnknownFieldSchema<UT, UB> r13, UB r14) {
        int r15 = r8.getTag();
        int r16 = 0;
        if (r15 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L5;
        Object r17 = null;
        ByteString r18 = null;
    L16:
        if (r8.getFieldNumber() == Integer.MAX_VALUE) goto L32;
        int r19 = r8.getTag();
        if (r19 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L20;
        if (r19 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L23;
        if (r19 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L32;
        if (r8.skipField() == true) goto L16;
    L23:
        if (r17 != null) goto L24;
        r18 = r8.readBytes();
        goto L16
    L24:
        r11.parseLengthPrefixedMessageSetItem(r8, r17, r10, r12);
        goto L16
    L20:
        r16 = r8.readUInt32();
        r17 = r11.findExtensionByNumber(r10, this.defaultInstance, r16);
    L32:
        if (r8.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L39;
        if (r18 == null) goto L37;
        if (r17 == null) goto L36;
        r11.parseMessageSetItem(r18, r17, r10, r12);
        goto L37
    L36:
        r13.addLengthDelimited(r14, r16, r18);
    L37:
        return true;
    L39:
        throw InvalidProtocolBufferException.invalidEndTag();
    L5:
        if (WireFormat.getTagWireType(r15) != 2) goto L13;
        Object r20 = r11.findExtensionByNumber(r10, this.defaultInstance, WireFormat.getTagFieldNumber(r15));
        if (r20 == null) goto L11;
        r11.parseLengthPrefixedMessageSetItem(r8, r20, r10, r12);
        return true;
    L11:
        return r13.mergeOneFieldFrom(r14, r8, 0);
    L13:
        return r8.skipField();
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> r8, T r10, Writer r11) {
        r8.writeAsMessageSetTo(r8.getFromMessage(r10), r11);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T r8, T r10) {
        if (this.unknownFieldSchema.getFromMessage(r8).equals(this.unknownFieldSchema.getFromMessage(r10)) == true) goto L7;
        return false;
    L7:
        if (this.hasExtensions == true) goto L9;
        return true;
    L9:
        return this.extensionSchema.getExtensions(r8).equals(this.extensionSchema.getExtensions(r10));
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T r8) {
        int r10 = getUnknownFieldsSerializedSize(this.unknownFieldSchema, r8) + 0;
        if (this.hasExtensions == true) goto L5;
        return r10;
    L5:
        return r10 + this.extensionSchema.getExtensions(r8).getMessageSetSerializedSize();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T r8) {
        int r10 = this.unknownFieldSchema.getFromMessage(r8).hashCode();
        if (this.hasExtensions == true) goto L5;
        return r10;
    L5:
        return (r10 * 53) + this.extensionSchema.getExtensions(r8).hashCode();
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T r8) {
        return this.extensionSchema.getExtensions(r8).isInitialized();
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T r8) {
        this.unknownFieldSchema.makeImmutable(r8);
        this.extensionSchema.makeImmutable(r8);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r8, Reader r10, ExtensionRegistryLite r11) {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, r8, r10, r11);
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        MessageLite r8 = this.defaultInstance;
        if ((r8 instanceof GeneratedMessageLite) == false) goto L7;
        return (T) ((GeneratedMessageLite) r8).newMutableInstance();
    L7:
        return (T) r8.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T r8, Writer r10) {
        Iterator r11 = this.extensionSchema.getExtensions(r8).iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        Map.Entry r12 = (Map.Entry) r11.next();
        FieldSet.FieldDescriptorLite r13 = (FieldSet.FieldDescriptorLite) r12.getKey();
        if (r13.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L17;
        if (r13.isRepeated() == true) goto L17;
        if (r13.isPacked() == true) goto L17;
        boolean r14 = r12 instanceof LazyField.LazyEntry;
        int r15 = r13.getNumber();
        if (r14 == false) goto L14;
        Object r16 = ((LazyField.LazyEntry) r12).getField().toByteString();
    L15:
        r10.writeMessageSetItem(r15, r16);
        goto L4
    L14:
        r16 = r12.getValue();
    L17:
        throw new IllegalStateException("Found invalid MessageSet item.");
    L18:
        writeUnknownFieldsHelper(this.unknownFieldSchema, r8, r10);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r8, T r10) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, r8, r10);
        if (this.hasExtensions == false) goto L6;
        SchemaUtil.mergeExtensions(this.extensionSchema, r8, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r11, byte[] r12, int r13, int r14, ArrayDecoders.Registers r15) {
        GeneratedMessageLite r8 = (GeneratedMessageLite) r11;
        UnknownFieldSetLite r10 = r8.unknownFields;
        if (r10 != UnknownFieldSetLite.getDefaultInstance()) goto L5;
        r10 = UnknownFieldSetLite.newInstance();
        r8.unknownFields = r10;
    L5:
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r16 = ((GeneratedMessageLite.ExtendableMessage) r11).ensureExtensionsAreMutable();
        GeneratedMessageLite.GeneratedExtension r17 = null;
    L6:
        if (r13 >= r14) goto L37;
        int r18 = ArrayDecoders.decodeVarint32(r12, r13, r15);
        int r19 = r15.int1;
        if (r19 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L10;
        int r110 = 0;
        ByteString r20 = null;
    L18:
        if (r18 >= r14) goto L34;
        r18 = ArrayDecoders.decodeVarint32(r12, r18, r15);
        int r21 = r15.int1;
        int r22 = WireFormat.getTagFieldNumber(r21);
        int r23 = WireFormat.getTagWireType(r21);
        if (r22 != 2) goto L22;
        if (r23 != 0) goto L31;
        r18 = ArrayDecoders.decodeVarint32(r12, r18, r15);
        r110 = r15.int1;
        r17 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(r15.extensionRegistry, this.defaultInstance, r110);
    L31:
        if (r21 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L34;
        r18 = ArrayDecoders.skipField(r21, r12, r18, r14, r15);
        goto L18
    L22:
        if (r22 != 3) goto L31;
        if (r17 != null) goto L25;
        if (r23 != 2) goto L31;
        r18 = ArrayDecoders.decodeBytes(r12, r18, r15);
        r20 = (ByteString) r15.object1;
        goto L18
    L25:
        r18 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r17.getMessageDefaultInstance().getClass()), r12, r18, r14, r15);
        r16.setField(r17.descriptor, r15.object1);
    L34:
        if (r20 == null) goto L36;
        r10.storeField(WireFormat.makeTag(r110, 2), r20);
    L36:
        r13 = r18;
        goto L6
    L10:
        if (WireFormat.getTagWireType(r19) == 2) goto L11;
        r13 = ArrayDecoders.skipField(r19, r12, r18, r14, r15);
        goto L6
    L11:
        GeneratedMessageLite.GeneratedExtension r24 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(r15.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(r19));
        if (r24 == null) goto L14;
        r13 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r24.getMessageDefaultInstance().getClass()), r12, r18, r14, r15);
        r16.setField(r24.descriptor, r15.object1);
    L15:
        r17 = r24;
        goto L6
    L14:
        r13 = ArrayDecoders.decodeUnknownField(r19, r12, r18, r14, r10, r15);
        goto L15
    L37:
        if (r13 != r14) goto L40;
        return;
    L40:
        throw InvalidProtocolBufferException.parseFailure();
    }
}
