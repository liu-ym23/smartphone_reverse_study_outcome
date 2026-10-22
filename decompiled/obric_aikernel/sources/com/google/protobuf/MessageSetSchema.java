package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> r10, ExtensionSchema<?> r11, MessageLite r12) {
        this.unknownFieldSchema = r10;
        this.hasExtensions = r11.hasExtensions(r12);
        this.extensionSchema = r11;
        this.defaultInstance = r12;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> r10, T r11) {
        return r10.getSerializedSizeAsMessageSet(r10.getFromMessage(r11));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> r10, ExtensionSchema<ET> r11, T r12, Reader r13, ExtensionRegistryLite r14) {
        UB r15 = r10.getBuilderFromMessage(r12);
        FieldSet<ET> r16 = r11.getMutableExtensions(r12);
    L17:
    L14:
        th = move-exception;
        r10.setBuilderToMessage(r12, r15);
        throw th;
    L5:
        if (r13.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (parseMessageSetItemOrUnknownField(r13, r14, r11, r16, r10, r15) == true) goto L17;
        r10.setBuilderToMessage(r12, r15);
        return;
    L6:
        r10.setBuilderToMessage(r12, r15);
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> r10, ExtensionSchema<?> r11, MessageLite r12) {
        return new MessageSetSchema(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader r10, ExtensionRegistryLite r11, ExtensionSchema<ET> r12, FieldSet<ET> r13, UnknownFieldSchema<UT, UB> r14, UB r15) {
        int r16 = r10.getTag();
        int r17 = 0;
        if (r16 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L5;
        Object r18 = null;
        ByteString r19 = null;
    L16:
        if (r10.getFieldNumber() == Integer.MAX_VALUE) goto L32;
        int r20 = r10.getTag();
        if (r20 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L20;
        if (r20 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L23;
        if (r20 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L32;
        if (r10.skipField() == true) goto L16;
    L23:
        if (r18 != null) goto L24;
        r19 = r10.readBytes();
        goto L16
    L24:
        r12.parseLengthPrefixedMessageSetItem(r10, r18, r11, r13);
        goto L16
    L20:
        r17 = r10.readUInt32();
        r18 = r12.findExtensionByNumber(r11, this.defaultInstance, r17);
    L32:
        if (r10.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L39;
        if (r19 == null) goto L37;
        if (r18 == null) goto L36;
        r12.parseMessageSetItem(r19, r18, r11, r13);
        goto L37
    L36:
        r14.addLengthDelimited(r15, r17, r19);
    L37:
        return true;
    L39:
        throw InvalidProtocolBufferException.invalidEndTag();
    L5:
        if (WireFormat.getTagWireType(r16) != 2) goto L13;
        Object r21 = r12.findExtensionByNumber(r11, this.defaultInstance, WireFormat.getTagFieldNumber(r16));
        if (r21 == null) goto L11;
        r12.parseLengthPrefixedMessageSetItem(r10, r21, r11, r13);
        return true;
    L11:
        return r14.mergeOneFieldFrom(r15, r10, 0);
    L13:
        return r10.skipField();
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> r10, T r11, Writer r12) {
        r10.writeAsMessageSetTo(r10.getFromMessage(r11), r12);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T r10, T r11) {
        if (this.unknownFieldSchema.getFromMessage(r10).equals(this.unknownFieldSchema.getFromMessage(r11)) == true) goto L7;
        return false;
    L7:
        if (this.hasExtensions == true) goto L9;
        return true;
    L9:
        return this.extensionSchema.getExtensions(r10).equals(this.extensionSchema.getExtensions(r11));
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T r10) {
        int r11 = getUnknownFieldsSerializedSize(this.unknownFieldSchema, r10) + 0;
        if (this.hasExtensions == true) goto L5;
        return r11;
    L5:
        return r11 + this.extensionSchema.getExtensions(r10).getMessageSetSerializedSize();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T r10) {
        int r11 = this.unknownFieldSchema.getFromMessage(r10).hashCode();
        if (this.hasExtensions == true) goto L5;
        return r11;
    L5:
        return (r11 * 53) + this.extensionSchema.getExtensions(r10).hashCode();
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T r10) {
        return this.extensionSchema.getExtensions(r10).isInitialized();
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T r10) {
        this.unknownFieldSchema.makeImmutable(r10);
        this.extensionSchema.makeImmutable(r10);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r10, Reader r11, ExtensionRegistryLite r12) {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, r10, r11, r12);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r10, T r11) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, r10, r11);
        if (this.hasExtensions == false) goto L6;
        SchemaUtil.mergeExtensions(this.extensionSchema, r10, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r11, byte[] r12, int r13, int r14, ArrayDecoders.Registers r15) {
        GeneratedMessageLite r10 = (GeneratedMessageLite) r11;
        UnknownFieldSetLite r16 = r10.unknownFields;
        if (r16 != UnknownFieldSetLite.getDefaultInstance()) goto L5;
        r16 = UnknownFieldSetLite.newInstance();
        r10.unknownFields = r16;
    L5:
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r17 = ((GeneratedMessageLite.ExtendableMessage) r11).ensureExtensionsAreMutable();
        GeneratedMessageLite.GeneratedExtension r18 = null;
    L6:
        if (r13 >= r14) goto L37;
        int r19 = ArrayDecoders.decodeVarint32(r12, r13, r15);
        int r110 = r15.int1;
        if (r110 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L10;
        int r111 = 0;
        ByteString r20 = null;
    L18:
        if (r19 >= r14) goto L34;
        r19 = ArrayDecoders.decodeVarint32(r12, r19, r15);
        int r21 = r15.int1;
        int r22 = WireFormat.getTagFieldNumber(r21);
        int r23 = WireFormat.getTagWireType(r21);
        if (r22 != 2) goto L22;
        if (r23 != 0) goto L31;
        r19 = ArrayDecoders.decodeVarint32(r12, r19, r15);
        r111 = r15.int1;
        r18 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(r15.extensionRegistry, this.defaultInstance, r111);
    L31:
        if (r21 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L34;
        r19 = ArrayDecoders.skipField(r21, r12, r19, r14, r15);
        goto L18
    L22:
        if (r22 != 3) goto L31;
        if (r18 != null) goto L25;
        if (r23 != 2) goto L31;
        r19 = ArrayDecoders.decodeBytes(r12, r19, r15);
        r20 = (ByteString) r15.object1;
        goto L18
    L25:
        r19 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r18.getMessageDefaultInstance().getClass()), r12, r19, r14, r15);
        r17.setField(r18.descriptor, r15.object1);
    L34:
        if (r20 == null) goto L36;
        r16.storeField(WireFormat.makeTag(r111, 2), r20);
    L36:
        r13 = r19;
        goto L6
    L10:
        if (WireFormat.getTagWireType(r110) == 2) goto L11;
        r13 = ArrayDecoders.skipField(r110, r12, r19, r14, r15);
        goto L6
    L11:
        GeneratedMessageLite.GeneratedExtension r24 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(r15.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(r110));
        if (r24 == null) goto L14;
        r13 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r24.getMessageDefaultInstance().getClass()), r12, r19, r14, r15);
        r17.setField(r24.descriptor, r15.object1);
    L15:
        r18 = r24;
        goto L6
    L14:
        r13 = ArrayDecoders.decodeUnknownField(r110, r12, r19, r14, r16, r15);
        goto L15
    L37:
        if (r13 != r14) goto L40;
        return;
    L40:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        MessageLite r10 = this.defaultInstance;
        if ((r10 instanceof GeneratedMessageLite) == false) goto L7;
        return (T) ((GeneratedMessageLite) r10).newMutableInstance();
    L7:
        return (T) r10.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T r10, Writer r11) {
        Iterator r12 = this.extensionSchema.getExtensions(r10).iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();
        FieldSet.FieldDescriptorLite r14 = (FieldSet.FieldDescriptorLite) r13.getKey();
        if (r14.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L17;
        if (r14.isRepeated() == true) goto L17;
        if (r14.isPacked() == true) goto L17;
        boolean r15 = r13 instanceof LazyField.LazyEntry;
        int r16 = r14.getNumber();
        if (r15 == false) goto L14;
        Object r17 = ((LazyField.LazyEntry) r13).getField().toByteString();
    L15:
        r11.writeMessageSetItem(r16, r17);
        goto L4
    L14:
        r17 = r13.getValue();
    L17:
        throw new IllegalStateException("Found invalid MessageSet item.");
    L18:
        writeUnknownFieldsHelper(this.unknownFieldSchema, r10, r11);
    }
}
