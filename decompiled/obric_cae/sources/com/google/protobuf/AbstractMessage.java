package com.google.protobuf;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    protected int memoizedSize;

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessageLite.Builder implements Message.Builder {
        public Builder() {
        }

        public static UninitializedMessageException newUninitializedMessageException(Message r8) {
            return new UninitializedMessageException(MessageReflection.findMissingFields(r8));
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r8 = getAllFields().entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            clearField(r8.next().getKey());
            goto L4
        L6:
            return this;
        }

        public BuilderType clearOneof(Descriptors.OneofDescriptor r8) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public List<String> findInitializationErrors() {
            return MessageReflection.findMissingFields(this);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r8) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public String getInitializationErrorString() {
            return MessageReflection.delimitWithCommas(findInitializationErrors());
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r8, int r10) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        public UnknownFieldSet.Builder getUnknownFieldSetBuilder() {
            return UnknownFieldSet.newBuilder(getUnknownFields());
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r8) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public BuilderType internalMergeFrom(AbstractMessageLite r8) {
            return (BuilderType) mergeFrom((Message) r8);
        }

        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r8) {
            return (BuilderType) super.mergeFrom(r8);
        }

        public BuilderType mergeUnknownFields(UnknownFieldSet r8) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(r8).build());
            return this;
        }

        public void setUnknownFieldSetBuilder(UnknownFieldSet.Builder r8) {
            setUnknownFields(r8.build());
        }

        public String toString() {
            return TextFormat.Printer.getOutputModePrinter().printToString(this, TextFormat.Printer.FieldReporterLevel.ABSTRACT_BUILDER_TO_STRING);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r8) {
            return internalMergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return (BuilderType) super.mergeFrom(r8, r10);
        }

        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r8) {
            return (BuilderType) mergeFrom(r8, ExtensionRegistry.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r8.shouldDiscardUnknownFields() == false) goto L5;
            UnknownFieldSet.Builder r11 = null;
        L6:
            MessageReflection.mergeMessageFrom(this, r11, r8, r10);
            if (r11 == null) goto L9;
            setUnknownFieldSetBuilder(r11);
        L9:
            return this;
        L5:
            r11 = getUnknownFieldSetBuilder();
            goto L6
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        public BuilderType mergeFrom(Message r8) {
            return (BuilderType) mergeFrom(r8, r8.getAllFields());
        }

        public BuilderType mergeFrom(Message r8, Map<Descriptors.FieldDescriptor, Object> r10) {
            if (r8.getDescriptorForType() != getDescriptorForType()) goto L23;
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L20;
            Map.Entry<Descriptors.FieldDescriptor, Object> r12 = r11.next();
            Descriptors.FieldDescriptor r13 = r12.getKey();
            if (r13.isRepeated() == true) goto L9;
            if (r13.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L17;
            Message r14 = (Message) getField(r13);
            if (r14 == r14.getDefaultInstanceForType()) goto L17;
            Object r15 = r14.newBuilderForType().mergeFrom(r14).mergeFrom((Message) r12.getValue()).build();
        L19:
            setField(r13, r15);
        L17:
            r15 = r12.getValue();
            goto L19
        L9:
            Iterator r16 = ((List) r12.getValue()).iterator();
        L11:
            if (r16.hasNext() == false) goto L6;
            addRepeatedField(r13, r16.next());
            goto L11
        L20:
            mergeUnknownFields(r8.getUnknownFields());
            return this;
        L23:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r8) {
            return (BuilderType) super.mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (BuilderType) super.mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8) {
            return (BuilderType) super.mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8, int r10, int r11) {
            return (BuilderType) super.mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return (BuilderType) super.mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return (BuilderType) super.mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }
    }

    public interface BuilderParent {
        void markDirty();
    }

    public AbstractMessage() {
        this.memoizedSize = -1;
    }

    private static boolean compareBytes(Object r8, Object r10) {
        if ((r8 instanceof byte[]) == false) goto L9;
        if ((r10 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) r8, (byte[]) r10);
    L9:
        return toByteString(r8).equals(toByteString(r10));
    }

    public static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> r8, Map<Descriptors.FieldDescriptor, Object> r10) {
        if (r8.size() == r10.size()) goto L5;
        return false;
    L5:
        Iterator<Descriptors.FieldDescriptor> r11 = r8.keySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L36;
        Descriptors.FieldDescriptor r12 = r11.next();
        if (r10.containsKey(r12) == false) goto L10;
        Object r13 = r8.get(r12);
        Object r14 = r10.get(r12);
        if (r12.getType() == Descriptors.FieldDescriptor.Type.BYTES) goto L14;
        if (r12.isMapField() == true) goto L31;
        if (r13.equals(r14) == true) goto L7;
        return false;
    L31:
        if (compareMapField(r13, r14) == true) goto L7;
        return false;
    L14:
        if (r12.isRepeated() == true) goto L15;
        if (compareBytes(r13, r14) == true) goto L7;
        return false;
    L15:
        List r15 = (List) r13;
        List r16 = (List) r14;
        if (r15.size() != r16.size()) goto L17;
        int r17 = 0;
    L20:
        if (r17 >= r15.size()) goto L7;
        if (compareBytes(r15.get(r17), r16.get(r17)) == false) goto L23;
        r17 = r17 + 1;
        goto L20
    L23:
        return false;
    L17:
        return false;
    L10:
        return false;
    L36:
        return true;
    }

    private static boolean compareMapField(Object r8, Object r10) {
        return MapFieldLite.equals(convertMapEntryListToMap((List) r8), convertMapEntryListToMap((List) r10));
    }

    private static Map convertMapEntryListToMap(List r8) {
        if (r8.isEmpty() == true) goto L5;
        HashMap r10 = new HashMap();
        Iterator r11 = r8.iterator();
        Message r12 = (Message) r11.next();
        Descriptors.Descriptor r13 = r12.getDescriptorForType();
        Descriptors.FieldDescriptor r14 = r13.findFieldByName("key");
        Descriptors.FieldDescriptor r15 = r13.findFieldByName("value");
        Object r16 = r12.getField(r15);
        if ((r16 instanceof Descriptors.EnumValueDescriptor) == false) goto L9;
        r16 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r16).getNumber());
    L9:
        r10.put(r12.getField(r14), r16);
        if (r11.hasNext() == false) goto L14;
        r12 = (Message) r11.next();
        r16 = r12.getField(r15);
        if ((r16 instanceof Descriptors.EnumValueDescriptor) == false) goto L9;
        r16 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r16).getNumber());
        goto L9
    L14:
        return r10;
    L5:
        return Collections.emptyMap();
    }

    public static int hashFields(int r8, Map<Descriptors.FieldDescriptor, Object> r10) {
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        Map.Entry<Descriptors.FieldDescriptor, Object> r12 = r11.next();
        Descriptors.FieldDescriptor r13 = r12.getKey();
        Object r14 = r12.getValue();
        int r15 = r13.getNumber();
        int r16 = r15 + (r8 * 37);
        if (r13.isMapField() == true) goto L7;
        if (r13.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L13;
        int r17 = r16 * 53;
        int r18 = r14.hashCode();
    L11:
        r8 = r18 + r17;
        goto L4
    L13:
        if (r13.isRepeated() == false) goto L15;
        r17 = r16 * 53;
        r18 = Internal.hashEnumList((List) r14);
        goto L11
    L15:
        r17 = r16 * 53;
        r18 = Internal.hashEnum((Internal.EnumLite) r14);
        goto L11
    L7:
        r8 = (r16 * 53) + hashMapField(r14);
        goto L4
    L16:
        return r8;
    }

    private static int hashMapField(Object r8) {
        return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List) r8));
    }

    private static ByteString toByteString(Object r8) {
        if ((r8 instanceof byte[]) == false) goto L7;
        return ByteString.copyFrom((byte[]) r8);
    L7:
        return (ByteString) r8;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Message) == true) goto L8;
        return false;
    L8:
        Message r10 = (Message) r8;
        if (getDescriptorForType() == r10.getDescriptorForType()) goto L12;
        return false;
    L12:
        if (compareFields(getAllFields(), r10.getAllFields()) == false) goto L17;
        if (getUnknownFields().equals(r10.getUnknownFields()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public List<String> findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(findInitializationErrors());
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r8) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = MessageReflection.getSerializedSize(this, getAllFields());
        this.memoizedSize = r10;
        return r10;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r8) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 != 0) goto L6;
        int r10 = (hashFields(getDescriptorForType().hashCode() + 779, getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r10;
        return r10;
    L6:
        return r8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }

    public Message.Builder newBuilderForType(BuilderParent r8) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public UninitializedMessageException newUninitializedMessageException() {
        return Builder.newUninitializedMessageException(this);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public void setMemoizedSerializedSize(int r8) {
        this.memoizedSize = r8;
    }

    @Override // com.google.protobuf.Message
    public final String toString() {
        return TextFormat.Printer.getOutputModePrinter().printToString(this, TextFormat.Printer.FieldReporterLevel.ABSTRACT_TO_STRING);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        MessageReflection.writeMessageTo(this, getAllFields(), r8, false);
    }
}
