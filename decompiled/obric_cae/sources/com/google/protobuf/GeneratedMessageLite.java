package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Class<?>, GeneratedMessageLite<?, ?>> defaultInstanceMap;
    private int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r8 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r8;
            r8[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        public Builder(MessageType r8) {
            this.defaultInstance = r8;
            if (r8.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void mergeFromInstance(MessageType r8, MessageType r10) {
            Protobuf.getInstance().schemaFor(r8).mergeFrom(r8, r10);
        }

        private MessageType newMutableInstance() {
            return (MessageType) this.defaultInstance.newMutableInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType build() {
            MessageType r8 = (MessageType) buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessageLite.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MessageType buildPartial() {
            if (this.instance.isMutable() == false) goto L5;
            this.instance.makeImmutable();
            return this.instance;
        L5:
            return this.instance;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final BuilderType clear() {
            if (this.defaultInstance.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return this;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        public final void copyOnWrite() {
            if (this.instance.isMutable() == true) goto L6;
            copyOnWriteInternal();
            return;
        }

        public void copyOnWriteInternal() {
            MessageType r8 = (MessageType) newMutableInstance();
            mergeFromInstance(r8, this.instance);
            this.instance = r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r8) {
            return internalMergeFrom((GeneratedMessageLite) r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.access$000(this.instance, false);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            BuilderType r8 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r8.instance = (MessageType) buildPartial();
            return r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public BuilderType internalMergeFrom(MessageType r8) {
            return (BuilderType) mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(r8), r10);     // Catch: RuntimeException -> L5
            return this;
        L5:
            e = move-exception;
            if ((e.getCause() instanceof IOException) == true) goto L9;
            throw e;
        L9:
            throw ((IOException) e.getCause());
        }

        public BuilderType mergeFrom(MessageType r8) {
            if (getDefaultInstanceForType().equals(r8) == false) goto L5;
            return this;
        L5:
            copyOnWrite();
            mergeFromInstance(this.instance, r8);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r8, int r10, int r11) {
            return (BuilderType) mergeFrom(r8, r10, r11, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, r10, r11, r11 + r12, new ArrayDecoders.Registers(r13));     // Catch: IOException -> L5 IndexOutOfBoundsException -> L8 InvalidProtocolBufferException -> L10
            return this;
        L10:
            e = move-exception;
            throw e;
        L5:
            e = move-exception;
            throw new RuntimeException("Reading from byte array should not throw IOException.", e);
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T r8) {
            this.defaultInstance = r8;
        }

        @Override // com.google.protobuf.Parser
        public T parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, r8, r10);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public T parsePartialFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return (T) GeneratedMessageLite.access$300(this.defaultInstance, r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ MessageLite parsePartialFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return parsePartialFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return parsePartialFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return parsePartialFrom(r8, r10, r11, r12);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        public ExtendableBuilder(MessageType r8) {
            super(r8);
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> r8 = ((ExtendableMessage) this.instance).extensions;
            if (r8.isImmutable() == false) goto L6;
            FieldSet r10 = r8.clone();
            ((ExtendableMessage) this.instance).extensions = r10;
            return r10;
        L6:
            return r8;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r8) {
            if (r8.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> r8, Type r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r11);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(r11.descriptor, r11.singularToFieldSetType(r10));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType buildPartial() {
            if (((ExtendableMessage) this.instance).isMutable() == true) goto L7;
            MessageType r8 = this.instance;
        L6:
            return r8;
        L7:
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            r8 = (MessageType) super.buildPartial();
            goto L6
        }

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> r8) {
            GeneratedExtension<MessageType, ?> r10 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r10);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(r10.descriptor);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            if (((ExtendableMessage) this.instance).extensions == FieldSet.emptySet()) goto L6;
            MessageType r8 = this.instance;
            ExtendableMessage r10 = (ExtendableMessage) r8;
            r10.extensions = ((ExtendableMessage) r8).extensions.clone();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r8) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r8) {
            return ((ExtendableMessage) this.instance).getExtensionCount(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r8) {
            return ((ExtendableMessage) this.instance).hasExtension(r8);
        }

        public void internalSetExtensionSet(FieldSet<ExtensionDescriptor> r8) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = r8;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> r8, int r10, Type r11) {
            GeneratedExtension<MessageType, ?> r12 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r12);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(r12.descriptor, r10, r12.singularToFieldSetType(r11));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r8, int r10) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r8, r10);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> r8, Type r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r11);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(r11.descriptor, r11.toFieldSetType(r10));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            private ExtensionWriter(ExtendableMessage r8, boolean r10) {
                this.this$0 = r8;
                Iterator r11 = r8.extensions.iterator();
                this.iter = r11;
                if (r11.hasNext() == false) goto L5;
                this.next = (Map.Entry) r11.next();
            L5:
                this.messageSetWireFormat = r10;
            }

            public void writeUntil(int r8, CodedOutputStream r10) {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r11 = this.next;
                if (r11 == null) goto L19;
                if (r11.getKey().getNumber() >= r8) goto L24;
                ExtensionDescriptor r12 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r12, this.next.getValue(), r10);
            L15:
                if (this.iter.hasNext() == false) goto L17;
                Map.Entry<ExtensionDescriptor, Object> r13 = this.iter.next();
            L18:
                this.next = r13;
                goto L2
            L17:
                r13 = null;
                goto L18
            L9:
                if (r12.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r12.isRepeated() == true) goto L13;
                r10.writeMessageSetExtension(r12.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L24:
                return;
            }

            public /* synthetic */ ExtensionWriter(ExtendableMessage r8, boolean r10, AnonymousClass1 r11) {
                this(r8, r10);
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.emptySet();
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream r8, GeneratedExtension<?, ?> r10, ExtensionRegistryLite r11, int r12) {
            parseExtension(r8, r11, r10, WireFormat.makeTag(r12, 2), r12);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString r8, ExtensionRegistryLite r10, GeneratedExtension<?, ?> r11) {
            MessageLite r12 = (MessageLite) this.extensions.getField(r11.descriptor);
            if (r12 == null) goto L5;
            MessageLite.Builder r13 = r12.toBuilder();
        L6:
            if (r13 != null) goto L8;
            r13 = r11.getMessageDefaultInstance().newBuilderForType();
        L8:
            r13.mergeFrom(r8, r10);
            MessageLite r14 = r13.build();
            ensureExtensionsAreMutable().setField(r11.descriptor, r11.singularToFieldSetType(r14));
            return;
        L5:
            r13 = null;
            goto L6
        }

        private <MessageType2 extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType2 r8, CodedInputStream r10, ExtensionRegistryLite r11) {
            int r12 = 0;
            ByteString r13 = null;
            GeneratedExtension<?, ?> r14 = null;
        L3:
            int r15 = r10.readTag();
            if (r15 == 0) goto L19;
            if (r15 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
            if (r15 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L13;
            if (r10.skipField(r15) == true) goto L3;
        L13:
            if (r12 == 0) goto L16;
            if (r14 == null) goto L16;
            eagerlyMergeMessageSetExtension(r10, r14, r11, r12);
            r13 = null;
        L16:
            r13 = r10.readBytes();
            goto L3
        L8:
            r12 = r10.readUInt32();
            if (r12 == 0) goto L3;
            r14 = r11.findLiteExtensionByNumber(r8, r12);
        L19:
            r10.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (r13 == null) goto L42;
            if (r12 == 0) goto L43;
            if (r14 == null) goto L24;
            mergeMessageSetExtensionFromBytes(r13, r11, r14);
            return;
        L24:
            mergeLengthDelimitedField(r12, r13);
            return;
        L43:
            return;
        }

        private boolean parseExtension(CodedInputStream r8, ExtensionRegistryLite r10, GeneratedExtension<?, ?> r11, int r12, int r13) {
            int r14 = WireFormat.getTagWireType(r12);
            if (r11 != null) goto L6;
        L4:
            boolean r15 = true;
            boolean r16 = false;
        L15:
            if (r15 == true) goto L17;
            ensureExtensionsAreMutable();
            if (r16 == false) goto L32;
            int r17 = r8.pushLimit(r8.readRawVarint32());
            if (r11.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L29;
        L23:
            if (r8.getBytesUntilLimit() <= 0) goto L31;
            Internal.EnumLite r18 = r11.descriptor.getEnumType().findValueByNumber(r8.readEnum());
            if (r18 == null) goto L26;
            this.extensions.addRepeatedField(r11.descriptor, r11.singularToFieldSetType(r18));
            goto L23
        L26:
            return true;
        L31:
            r8.popLimit(r17);
        L59:
            return true;
        L29:
            if (r8.getBytesUntilLimit() <= 0) goto L31;
            this.extensions.addRepeatedField(r11.descriptor, FieldSet.readPrimitiveField(r8, r11.descriptor.getLiteType(), false));
            goto L29
        L32:
            int r19 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r11.descriptor.getLiteJavaType().ordinal()];
            if (r19 == 1) goto L43;
            if (r19 == 2) goto L37;
            Object r20 = FieldSet.readPrimitiveField(r8, r11.descriptor.getLiteType(), false);
        L55:
            boolean r21 = r11.descriptor.isRepeated();
            FieldSet<ExtensionDescriptor> r22 = this.extensions;
            if (r21 == false) goto L58;
            r22.addRepeatedField(r11.descriptor, r11.singularToFieldSetType(r20));
            goto L59
        L58:
            r22.setField(r11.descriptor, r11.singularToFieldSetType(r20));
            goto L59
        L37:
            int r23 = r8.readEnum();
            Internal.EnumLite r24 = r11.descriptor.getEnumType().findValueByNumber(r23);
            if (r24 != null) goto L41;
            mergeVarintField(r13, r23);
            return true;
        L41:
            r20 = r24;
            goto L55
        L43:
            if (r11.descriptor.isRepeated() == true) goto L47;
            MessageLite r25 = (MessageLite) this.extensions.getField(r11.descriptor);
            if (r25 == null) goto L47;
            MessageLite.Builder r26 = r25.toBuilder();
        L48:
            if (r26 != null) goto L51;
            r26 = r11.getMessageDefaultInstance().newBuilderForType();
        L51:
            if (r11.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L53;
            r8.readGroup(r11.getNumber(), r26, r10);
        L54:
            r20 = r26.build();
            goto L55
        L53:
            r8.readMessage(r26, r10);
        L47:
            r26 = null;
            goto L48
        L17:
            return parseUnknownField(r12, r8);
        L6:
            if (r14 != FieldSet.getWireFormatForFieldType(r11.descriptor.getLiteType(), false)) goto L8;
            r15 = false;
            r16 = false;
            goto L15
        L8:
            ExtensionDescriptor r27 = r11.descriptor;
            if (r27.isRepeated == false) goto L4;
            if (r27.type.isPackable() == false) goto L4;
            if (r14 != FieldSet.getWireFormatForFieldType(r11.descriptor.getLiteType(), true)) goto L4;
            r16 = true;
            r15 = false;
            goto L15
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r8) {
            if (r8.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @CanIgnoreReturnValue
        public FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable() == false) goto L6;
            this.extensions = this.extensions.clone();
        L6:
            return this.extensions;
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r8) {
            GeneratedExtension<MessageType, ?> r10 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r10);
            Object r11 = this.extensions.getField(r10.descriptor);
            if (r11 != null) goto L7;
            return r10.defaultValue;
        L7:
            return (Type) r10.fromFieldSetType(r11);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r8) {
            GeneratedExtension<MessageType, ?> r10 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r10);
            return this.extensions.getRepeatedFieldCount(r10.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r8) {
            GeneratedExtension<MessageType, ?> r10 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r10);
            return this.extensions.hasField(r10.descriptor);
        }

        public final void mergeExtensionFields(MessageType r8) {
            if (this.extensions.isImmutable() == false) goto L5;
            this.extensions = this.extensions.clone();
        L5:
            this.extensions.mergeFrom(r8.extensions);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        public <MessageType2 extends MessageLite> boolean parseUnknownField(MessageType2 r8, CodedInputStream r10, ExtensionRegistryLite r11, int r12) {
            int r13 = WireFormat.getTagFieldNumber(r12);
            return parseExtension(r10, r11, r11.findLiteExtensionByNumber(r8, r13), r12, r13);
        }

        public <MessageType2 extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType2 r8, CodedInputStream r10, ExtensionRegistryLite r11, int r12) {
            if (r12 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L7;
            mergeMessageSetExtensionFromCodedStream(r8, r10, r11);
            return true;
        L7:
            if (WireFormat.getTagWireType(r12) != 2) goto L11;
            return parseUnknownField(r8, r10, r11, r12);
        L11:
            return r10.skipField(r12);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r8, int r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$100(r8);
            verifyExtensionContainingType(r11);
            return (Type) r11.singularFromFieldSetType(this.extensions.getRepeatedField(r11.descriptor, r10));
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> r8);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r8, int r10);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r8);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r8);
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        public ExtensionDescriptor(Internal.EnumLiteMap<?> r8, int r10, WireFormat.FieldType r11, boolean r12, boolean r13) {
            this.enumTypeMap = r8;
            this.number = r10;
            this.type = r11;
            this.isRepeated = r12;
            this.isPacked = r13;
        }

        public int compareTo(ExtensionDescriptor r8) {
            return this.number - r8.number;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public void internalMergeFrom(Object r8, Object r10) {
            ((Builder) r8).mergeFrom((GeneratedMessageLite) r10);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean internalMessageIsImmutable(Object r8) {
            return r8 instanceof MessageLite;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r8) {
            return compareTo((ExtensionDescriptor) r8);
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        public GeneratedExtension(ContainingType r8, Type r10, MessageLite r11, ExtensionDescriptor r12, Class r13) {
            if (r8 == null) goto L13;
            if (r12.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r11 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r8;
            this.defaultValue = r10;
            this.messageDefaultInstance = r11;
            this.descriptor = r12;
            return;
        L13:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public Object fromFieldSetType(Object r8) {
            if (this.descriptor.isRepeated() == false) goto L14;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L12;
            ProtobufArrayList r10 = new ProtobufArrayList();
            List r11 = (List) r8;
            r10.ensureCapacity(r11.size());
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r10.add(singularFromFieldSetType(r12.next()));
            goto L8
        L10:
            r10.makeImmutable();
            return r10;
        L12:
            return r8;
        L14:
            return singularFromFieldSetType(r8);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        @Override // com.google.protobuf.ExtensionLite
        public Type getDefaultValue() {
            return this.defaultValue;
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        @Override // com.google.protobuf.ExtensionLite
        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return this.descriptor.getNumber();
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        public Object singularFromFieldSetType(Object r8) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r8;
        L5:
            return this.descriptor.enumTypeMap.findValueByNumber(((Integer) r8).intValue());
        }

        public Object singularToFieldSetType(Object r8) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r8;
        L5:
            return Integer.valueOf(((Internal.EnumLite) r8).getNumber());
        }

        public Object toFieldSetType(Object r8) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r10 = new ArrayList();
            Iterator r11 = ((List) r8).iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            r10.add(singularToFieldSetType(r11.next()));
            goto L8
        L10:
            return r10;
        L11:
            return r8;
        L13:
            return singularToFieldSetType(r8);
        }
    }

    public static final enum MethodToInvoke extends java.lang.Enum<MethodToInvoke> {
        private static final /* synthetic */ MethodToInvoke[] $VALUES = null;
        public static final MethodToInvoke BUILD_MESSAGE_INFO = null;
        public static final MethodToInvoke GET_DEFAULT_INSTANCE = null;
        public static final MethodToInvoke GET_MEMOIZED_IS_INITIALIZED = null;
        public static final MethodToInvoke GET_PARSER = null;
        public static final MethodToInvoke NEW_BUILDER = null;
        public static final MethodToInvoke NEW_MUTABLE_INSTANCE = null;
        public static final MethodToInvoke SET_MEMOIZED_IS_INITIALIZED = null;

        private static /* synthetic */ MethodToInvoke[] $values() {
            return new MethodToInvoke[]{GET_MEMOIZED_IS_INITIALIZED, SET_MEMOIZED_IS_INITIALIZED, BUILD_MESSAGE_INFO, NEW_MUTABLE_INSTANCE, NEW_BUILDER, GET_DEFAULT_INSTANCE, GET_PARSER};
        }

        static {
            GET_MEMOIZED_IS_INITIALIZED = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            SET_MEMOIZED_IS_INITIALIZED = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            BUILD_MESSAGE_INFO = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            NEW_MUTABLE_INSTANCE = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            NEW_BUILDER = new MethodToInvoke("NEW_BUILDER", 4);
            GET_DEFAULT_INSTANCE = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            GET_PARSER = new MethodToInvoke("GET_PARSER", 6);
            $VALUES = $values();
        }

        private MethodToInvoke(String r8, int r10) {
            super(r8, r10);
        }

        public static MethodToInvoke valueOf(String r8) {
            return (MethodToInvoke) java.lang.Enum.valueOf(MethodToInvoke.class, r8);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) $VALUES.clone();
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public SerializedForm(MessageLite r8) {
            this.messageClass = r8.getClass();
            this.messageClassName = r8.getClass().getName();
            this.asBytes = r8.toByteArray();
        }

        public static SerializedForm of(MessageLite r8) {
            return new SerializedForm(r8);
        }

        private Class<?> resolveMessageClass() {
            Class<?> r8 = this.messageClass;
            if (r8 != null) goto L9;
            Class<?> r10 = Class.forName(this.messageClassName, false, SerializedForm.class.getClassLoader());
            if (MessageLite.class.isAssignableFrom(r10) == false) goto L8;
            return r10;
        L8:
            throw new ClassNotFoundException();
        L9:
            return r8;
        }

        public Object readResolve() {
            java.lang.reflect.Field r8 = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r8.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            MessageLite.Builder r10 = ((MessageLite) r8.get(null)).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r10.mergeFrom(this.asBytes);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            return r10.buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L16:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L13:
            e = move-exception;
            throw new RuntimeException("Unable to find DEFAULT_INSTANCE in " + this.messageClassName, e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e);
        }
    }

    static {
        defaultInstanceMap = new ConcurrentHashMap();
    }

    public GeneratedMessageLite() {
        this.memoizedSerializedSize = -1;
        this.unknownFields = UnknownFieldSetLite.getDefaultInstance();
    }

    public static /* synthetic */ boolean access$000(GeneratedMessageLite r8, boolean r10) {
        return isInitialized(r8, r10);
    }

    public static /* synthetic */ GeneratedExtension access$100(ExtensionLite r8) {
        return checkIsLite(r8);
    }

    public static /* synthetic */ GeneratedMessageLite access$300(GeneratedMessageLite r8, byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
        return parsePartialFrom(r8, r10, r11, r12, r13);
    }

    private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> r8) {
        if (r8.isLite() == false) goto L7;
        return (GeneratedExtension) r8;
    L7:
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T r8) {
        if (r8 != null) goto L4;
    L8:
        return r8;
    L4:
        if (r8.isInitialized() == true) goto L8;
        throw r8.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(r8);
    }

    private int computeSerializedSize(Schema<?> r8) {
        if (r8 != null) goto L6;
        return Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
    L6:
        return r8.getSerializedSize(this);
    }

    public static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    public static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    public static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        this.unknownFields = UnknownFieldSetLite.newInstance();
        return;
    }

    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> r8) {
        GeneratedMessageLite<?, ?> r10 = defaultInstanceMap.get(r8);
        if (r10 == null) goto L16;
    L9:
        if (r10 != null) goto L15;
        r10 = (T) ((GeneratedMessageLite) UnsafeUtil.allocateInstance(r8)).getDefaultInstanceForType();
        if (r10 == null) goto L14;
        defaultInstanceMap.put((Class<?>) r8, r10);
        goto L15
    L14:
        throw new IllegalStateException();
    L15:
        return (T) r10;
    L16:
        Class.forName(r8.getName(), true, r8.getClassLoader());     // Catch: ClassNotFoundException -> L6
        r10 = defaultInstanceMap.get(r8);
    L6:
        e = move-exception;
        throw new IllegalStateException("Class initialization cannot fail.", e);
    }

    public static java.lang.reflect.Method getMethodOrDie(Class r8, String r10, Class... r11) {
        return r8.getMethod(r10, r11);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + r8.getName() + "\" missing method \"" + r10 + "\".", e);
    }

    public static Object invokeOrDie(java.lang.reflect.Method r8, Object r10, Object... r11) {
        return r8.invoke(r10, r11);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r12 = e.getCause();
        if ((r12 instanceof RuntimeException) == true) goto L14;
        if ((r12 instanceof Error) == false) goto L12;
        throw ((Error) r12);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r12);
    L14:
        throw ((RuntimeException) r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$BooleanList] */
    public static Internal.BooleanList mutableCopy(Internal.BooleanList r8) {
        return r8.mutableCopyWithCapacity(r8.size() * 2);
    }

    public static Object newMessageInfo(MessageLite r8, String r10, Object[] r11) {
        return new RawMessageInfo(r8, r10, r11);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r13, MessageLite r14, Internal.EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, boolean r18, Class r19) {
        return new GeneratedExtension(r13, ProtobufArrayList.emptyList(), r14, new ExtensionDescriptor(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r8, Type r10, MessageLite r11, Internal.EnumLiteMap<?> r12, int r13, WireFormat.FieldType r14, Class r15) {
        return new GeneratedExtension(r8, r10, r11, new ExtensionDescriptor(r12, r13, r14, false, false), r15);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r8, InputStream r10) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r8, r10, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, ByteString r10) {
        return (T) checkMessageInitialized(parseFrom(r8, r10, ExtensionRegistryLite.getEmptyRegistry()));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r8, InputStream r10, ExtensionRegistryLite r11) {
        int r12 = r10.read();     // Catch: IOException -> L13 InvalidProtocolBufferException -> L16
        if (r12 != (-1)) goto L6;
        return null;
    L6:
        CodedInputStream r13 = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(r10, CodedInputStream.readRawVarint32(r12, r10)));
        T r14 = (T) parsePartialFrom(r8, r13, r11);
        r13.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L10
        return r14;
    L10:
        e = move-exception;
        throw e.setUnfinishedMessage(r14);
    L16:
        e = move-exception;
        if (e.getThrownFromInputStream() == true) goto L20;
        throw e;
    L20:
        throw new InvalidProtocolBufferException(e);
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r8, ByteString r10, ExtensionRegistryLite r11) {
        CodedInputStream r12 = r10.newCodedInput();
        T r13 = (T) parsePartialFrom(r8, r12, r11);
        r12.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r13;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r13);
    }

    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> r8, T r10) {
        r10.markImmutable();
        defaultInstanceMap.put(r8, r10);
    }

    public Object buildMessageInfo() {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO, null, null);
    }

    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    public int computeHashCode() {
        return Protobuf.getInstance().schemaFor(this).hashCode(this);
    }

    public final <MessageType2 extends GeneratedMessageLite<MessageType2, BuilderType2>, BuilderType2 extends Builder<MessageType2, BuilderType2>> BuilderType2 createBuilder() {
        return (BuilderType2) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null);
    }

    public abstract Object dynamicMethod(MethodToInvoke r8, Object r10, Object r11);

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L9;
        return false;
    L9:
        if (getClass() == r8.getClass()) goto L12;
        return false;
    L12:
        return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE, null, null);
    }

    public int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER, null, null);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    public int hashCode() {
        if (isMutable() == false) goto L7;
        return computeHashCode();
    L7:
        if (hashCodeIsNotMemoized() == false) goto L10;
        setMemoizedHashCode(computeHashCode());
    L10:
        return getMemoizedHashCode();
    }

    public boolean hashCodeIsNotMemoized() {
        if (getMemoizedHashCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public boolean isMutable() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
        markImmutable();
    }

    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public void mergeLengthDelimitedField(int r8, ByteString r10) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(r8, r10);
    }

    public final void mergeUnknownFields(UnknownFieldSetLite r8) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, r8);
    }

    public void mergeVarintField(int r8, int r10) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null);
    }

    public MessageType newMutableInstance() {
        return (MessageType) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE, null, null);
    }

    public boolean parseUnknownField(int r8, CodedInputStream r10) {
        if (WireFormat.getTagWireType(r8) != 4) goto L6;
        return false;
    L6:
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(r8, r10);
    }

    public void setMemoizedHashCode(int r8) {
        this.memoizedHashCode = r8;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public void setMemoizedSerializedSize(int r8) {
        if (r8 < 0) goto L6;
        int r10 = r8 & Integer.MAX_VALUE;
        this.memoizedSerializedSize = r10 | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        return;
    L6:
        throw new IllegalStateException(defpackage.a.d("serialized size must be non-negative, was ", r8));
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType toBuilder() {
        return (BuilderType) ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null)).mergeFrom(this);
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(r8));
    }

    private static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T r8, boolean r10) {
        byte r11 = ((Byte) r8.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (r11 != 1) goto L5;
        return true;
    L5:
        if (r11 != 0) goto L8;
        return false;
    L8:
        boolean r12 = Protobuf.getInstance().schemaFor(r8).isInitialized(r8);
        if (r10 == false) goto L15;
        MethodToInvoke r13 = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
        if (r12 == false) goto L13;
        Object r14 = r8;
    L14:
        r8.dynamicMethod(r13, r14, null);
        goto L15
    L13:
        r14 = null;
    L15:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$DoubleList] */
    public static Internal.DoubleList mutableCopy(Internal.DoubleList r8) {
        return r8.mutableCopyWithCapacity(r8.size() * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r8, InputStream r10, ExtensionRegistryLite r11) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r8, r10, r11));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, ByteString r10, ExtensionRegistryLite r11) {
        return (T) checkMessageInitialized(parsePartialFrom(r8, r10, r11));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r8, CodedInputStream r10) {
        return (T) parsePartialFrom(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
    }

    public final <MessageType2 extends GeneratedMessageLite<MessageType2, BuilderType2>, BuilderType2 extends Builder<MessageType2, BuilderType2>> BuilderType2 createBuilder(MessageType2 r8) {
        return (BuilderType2) createBuilder().mergeFrom(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public int getSerializedSize(Schema r8) {
        if (isMutable() == false) goto L10;
        int r10 = computeSerializedSize(r8);
        if (r10 < 0) goto L8;
        return r10;
    L8:
        throw new IllegalStateException(defpackage.a.d("serialized size must be non-negative, was ", r10));
    L10:
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) goto L12;
        int r11 = computeSerializedSize(r8);
        setMemoizedSerializedSize(r11);
        return r11;
    L12:
        return getMemoizedSerializedSize();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$FloatList] */
    public static Internal.FloatList mutableCopy(Internal.FloatList r8) {
        return r8.mutableCopyWithCapacity(r8.size() * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, CodedInputStream r10) {
        return (T) parseFrom(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r8, CodedInputStream r10, ExtensionRegistryLite r11) {
        T r12 = (T) r8.newMutableInstance();
        Schema r13 = Protobuf.getInstance().schemaFor(r12);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r13.mergeFrom(r12, CodedInputStreamReader.forCodedInput(r10), r11);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r13.makeImmutable(r12);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        return r12;
    L21:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L26;
        e = new InvalidProtocolBufferException(e);
    L26:
        throw e.setUnfinishedMessage(r12);
    L18:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r12);
    L11:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == false) goto L17;
        throw ((InvalidProtocolBufferException) e.getCause());
    L17:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r12);
    L5:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == true) goto L9;
        throw e;
    L9:
        throw ((InvalidProtocolBufferException) e.getCause());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$IntList] */
    public static Internal.IntList mutableCopy(Internal.IntList r8) {
        return r8.mutableCopyWithCapacity(r8.size() * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, CodedInputStream r10, ExtensionRegistryLite r11) {
        return (T) checkMessageInitialized(parsePartialFrom(r8, r10, r11));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r8, byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
        if (r12 != 0) goto L4;
        return r8;
    L4:
        T r14 = (T) r8.newMutableInstance();
        Schema r15 = Protobuf.getInstance().schemaFor(r14);     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        r15.mergeFrom(r14, r10, r11, r11 + r12, new ArrayDecoders.Registers(r13));     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        r15.makeImmutable(r14);     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        return r14;
    L19:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L24;
        e = new InvalidProtocolBufferException(e);
    L24:
        throw e.setUnfinishedMessage(r14);
    L16:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r14);
    L9:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == false) goto L15;
        throw ((InvalidProtocolBufferException) e.getCause());
    L15:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r14);
    L8:
        throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(r14);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$LongList] */
    public static Internal.LongList mutableCopy(Internal.LongList r8) {
        return r8.mutableCopyWithCapacity(r8.size() * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, InputStream r10) {
        return (T) checkMessageInitialized(parsePartialFrom(r8, CodedInputStream.newInstance(r10), ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> r8) {
        return r8.mutableCopyWithCapacity(r8.size() * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, InputStream r10, ExtensionRegistryLite r11) {
        return (T) checkMessageInitialized(parsePartialFrom(r8, CodedInputStream.newInstance(r10), r11));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, ByteBuffer r10) {
        return (T) parseFrom(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, ByteBuffer r10, ExtensionRegistryLite r11) {
        return (T) checkMessageInitialized(parseFrom(r8, CodedInputStream.newInstance(r10), r11));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, byte[] r10) {
        return (T) checkMessageInitialized(parsePartialFrom(r8, r10, 0, r10.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r8, byte[] r10, ExtensionRegistryLite r11) {
        return (T) checkMessageInitialized(parsePartialFrom(r8, r10, 0, r10.length, r11));
    }
}
