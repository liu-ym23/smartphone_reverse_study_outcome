package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> r3, ExtensionSchema<?> r4, MessageLite r5) {
        MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r5, MessageLite.class, "com.obric.memorydata.plugin");
        this.unknownFieldSchema = r3;
        this.hasExtensions = r4.hasExtensions(r6);
        this.extensionSchema = r4;
        this.defaultInstance = r6;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> r1, T r2) {
        return r1.getSerializedSizeAsMessageSet(r1.getFromMessage(r2));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> r10, ExtensionSchema<ET> r11, T r12, Reader r13, ExtensionRegistryLite r14) {
        Reader r15 = (Reader) ZeusTransformUtils.wrapperContextForParams(r13, Reader.class, "com.obric.memorydata.plugin");
        UB r7 = r10.getBuilderFromMessage(r12);
        FieldSet<ET> r8 = r11.getMutableExtensions(r12);
    L17:
    L14:
        th = move-exception;
        r10.setBuilderToMessage(r12, r7);
        throw th;
    L5:
        if (r15.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (parseMessageSetItemOrUnknownField(r15, r14, r11, r8, r10, r7) == true) goto L17;
        r10.setBuilderToMessage(r12, r7);
        return;
    L6:
        r10.setBuilderToMessage(r12, r7);
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> r2, ExtensionSchema<?> r3, MessageLite r4) {
        return new MessageSetSchema(r2, r3, (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader r7, ExtensionRegistryLite r8, ExtensionSchema<ET> r9, FieldSet<ET> r10, UnknownFieldSchema<UT, UB> r11, UB r12) {
        Reader r13 = (Reader) ZeusTransformUtils.wrapperContextForParams(r7, Reader.class, "com.obric.memorydata.plugin");
        int r0 = r13.getTag();
        int r3 = 0;
        if (r0 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L5;
        Object r1 = null;
        ByteString r2 = null;
    L16:
        if (r13.getFieldNumber() == Integer.MAX_VALUE) goto L32;
        int r4 = r13.getTag();
        if (r4 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L20;
        if (r4 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L23;
        if (r4 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L32;
        if (r13.skipField() == true) goto L16;
    L23:
        if (r1 != null) goto L24;
        r2 = r13.readBytes();
        goto L16
    L24:
        r9.parseLengthPrefixedMessageSetItem(r13, r1, r8, r10);
        goto L16
    L20:
        r3 = r13.readUInt32();
        r1 = r9.findExtensionByNumber(r8, this.defaultInstance, r3);
    L32:
        if (r13.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L39;
        if (r2 == null) goto L37;
        if (r1 == null) goto L36;
        r9.parseMessageSetItem(r2, r1, r8, r10);
        goto L37
    L36:
        r11.addLengthDelimited(r12, r3, r2);
    L37:
        return true;
    L39:
        throw InvalidProtocolBufferException.invalidEndTag();
    L5:
        if (WireFormat.getTagWireType(r0) != 2) goto L13;
        Object r6 = r9.findExtensionByNumber(r8, this.defaultInstance, WireFormat.getTagFieldNumber(r0));
        if (r6 == null) goto L11;
        r9.parseLengthPrefixedMessageSetItem(r13, r6, r8, r10);
        return true;
    L11:
        return r11.mergeOneFieldFrom(r12, r13, 0);
    L13:
        return r13.skipField();
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> r2, T r3, Writer r4) {
        Writer r1 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        r2.writeAsMessageSetTo(r2.getFromMessage(r3), r1);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T r3, T r4) {
        if (this.unknownFieldSchema.getFromMessage(r3).equals(this.unknownFieldSchema.getFromMessage(r4)) == true) goto L7;
        return false;
    L7:
        if (this.hasExtensions == true) goto L9;
        return true;
    L9:
        return this.extensionSchema.getExtensions(r3).equals(this.extensionSchema.getExtensions(r4));
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T r3) {
        int r0 = getUnknownFieldsSerializedSize(this.unknownFieldSchema, r3) + 0;
        if (this.hasExtensions == true) goto L5;
        return r0;
    L5:
        return r0 + this.extensionSchema.getExtensions(r3).getMessageSetSerializedSize();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T r3) {
        int r0 = this.unknownFieldSchema.getFromMessage(r3).hashCode();
        if (this.hasExtensions == true) goto L5;
        return r0;
    L5:
        return (r0 * 53) + this.extensionSchema.getExtensions(r3).hashCode();
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T r1) {
        return this.extensionSchema.getExtensions(r1).isInitialized();
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T r2) {
        this.unknownFieldSchema.makeImmutable(r2);
        this.extensionSchema.makeImmutable(r2);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r7, Reader r8, ExtensionRegistryLite r9) {
        Reader r4 = (Reader) ZeusTransformUtils.wrapperContextForParams(r8, Reader.class, "com.obric.memorydata.plugin");
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, r7, r4, r9);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r2, T r3) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, r2, r3);
        if (this.hasExtensions == false) goto L6;
        SchemaUtil.mergeExtensions(this.extensionSchema, r2, r3);
        return;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r17, byte[] r18, int r19, int r20, ArrayDecoders.Registers r21) {
        UnknownFieldSetLite r2 = ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r17, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields;
        if (r2 != UnknownFieldSetLite.getDefaultInstance()) goto L5;
        r2 = UnknownFieldSetLite.newInstance();
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r17, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields = r2;
    L5:
        UnknownFieldSetLite r11 = r2;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r12 = ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r17, GeneratedMessageLite.ExtendableMessage.class, "com.obric.memorydata.plugin")).ensureExtensionsAreMutable();
        int r1 = r19;
        GeneratedMessageLite.GeneratedExtension r3 = null;
    L6:
        if (r1 >= r20) goto L37;
        int r4 = ArrayDecoders.decodeVarint32(r18, r1, r21);
        int r5 = r21.int1;
        if (r5 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L10;
        int r6 = 0;
        ByteString r7 = null;
    L18:
        if (r4 >= r20) goto L34;
        r4 = ArrayDecoders.decodeVarint32(r18, r4, r21);
        int r8 = r21.int1;
        int r14 = WireFormat.getTagFieldNumber(r8);
        int r15 = WireFormat.getTagWireType(r8);
        if (r14 != 2) goto L22;
        if (r15 != 0) goto L31;
        r4 = ArrayDecoders.decodeVarint32(r18, r4, r21);
        r6 = r21.int1;
        r3 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(this.extensionSchema.findExtensionByNumber(r21.extensionRegistry, this.defaultInstance, r6), GeneratedMessageLite.GeneratedExtension.class, "com.obric.memorydata.plugin");
    L31:
        if (r8 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L34;
        r4 = ArrayDecoders.skipField(r8, r18, r4, r20, r21);
        goto L18
    L22:
        if (r14 != 3) goto L31;
        if (r3 != null) goto L25;
        if (r15 != 2) goto L31;
        r4 = ArrayDecoders.decodeBytes(r18, r4, r21);
        r7 = (ByteString) ZeusTransformUtils.preCheckCast(r21.object1, ByteString.class, "com.obric.memorydata.plugin");
        goto L18
    L25:
        r4 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r3.getMessageDefaultInstance().getClass()), r18, r4, r20, r21);
        r12.setField(r3.descriptor, r21.object1);
    L34:
        if (r7 == null) goto L36;
        r11.storeField(WireFormat.makeTag(r6, 2), r7);
    L36:
        r1 = r4;
        goto L6
    L10:
        if (WireFormat.getTagWireType(r5) == 2) goto L11;
        r1 = ArrayDecoders.skipField(r5, r18, r4, r20, r21);
        goto L6
    L11:
        GeneratedMessageLite.GeneratedExtension r16 = (GeneratedMessageLite.GeneratedExtension) ZeusTransformUtils.preCheckCast(this.extensionSchema.findExtensionByNumber(r21.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(r5)), GeneratedMessageLite.GeneratedExtension.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L14;
        r1 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r16.getMessageDefaultInstance().getClass()), r18, r4, r20, r21);
        r12.setField(r16.descriptor, r21.object1);
    L15:
        r3 = r16;
        goto L6
    L14:
        r1 = ArrayDecoders.decodeUnknownField(r5, r18, r4, r20, r11, r21);
        goto L15
    L37:
        if (r1 != r20) goto L40;
        return;
    L40:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.defaultInstance, GeneratedMessageLite.class);
        MessageLite r2 = this.defaultInstance;
        if (r0 == false) goto L7;
        return (T) ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).newMutableInstance();
    L7:
        return (T) r2.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T r7, Writer r8) {
        Writer r9 = (Writer) ZeusTransformUtils.wrapperContextForParams(r8, Writer.class, "com.obric.memorydata.plugin");
        Iterator r0 = this.extensionSchema.getExtensions(r7).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        FieldSet.FieldDescriptorLite r3 = (FieldSet.FieldDescriptorLite) ZeusTransformUtils.preCheckCast(r2.getKey(), FieldSet.FieldDescriptorLite.class, "com.obric.memorydata.plugin");
        if (r3.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L17;
        if (r3.isRepeated() == true) goto L17;
        if (r3.isPacked() == true) goto L17;
        boolean r4 = ZeusTransformUtils.instanceOf(r2, LazyField.LazyEntry.class);
        int r5 = r3.getNumber();
        if (r4 == false) goto L14;
        Object r6 = ((LazyField.LazyEntry) ZeusTransformUtils.preCheckCast(r2, LazyField.LazyEntry.class, "com.obric.memorydata.plugin")).getField().toByteString();
    L15:
        r9.writeMessageSetItem(r5, r6);
        goto L4
    L14:
        r6 = r2.getValue();
    L17:
        throw new IllegalStateException("Found invalid MessageSet item.");
    L18:
        writeUnknownFieldsHelper(this.unknownFieldSchema, r7, r9);
    }
}
