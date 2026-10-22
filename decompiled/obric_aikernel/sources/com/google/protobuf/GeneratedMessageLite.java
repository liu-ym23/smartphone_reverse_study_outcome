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

/* JADX INFO: loaded from: classes2.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Class<?>, GeneratedMessageLite<?, ?>> defaultInstanceMap;
    private int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r10 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r10;
            r10[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        protected Builder(MessageType r10) {
            this.defaultInstance = r10;
            if (r10.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void mergeFromInstance(MessageType r10, MessageType r11) {
            Protobuf.getInstance().schemaFor(r10).mergeFrom(r10, r11);
        }

        private MessageType newMutableInstance() {
            return (MessageType) this.defaultInstance.newMutableInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType build() {
            MessageType r10 = (MessageType) buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
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
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final BuilderType clear() {
            if (this.defaultInstance.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return this;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            BuilderType r10 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r10.instance = (MessageType) buildPartial();
            return r10;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo13clone() {
            return clone();
        }

        protected final void copyOnWrite() {
            if (this.instance.isMutable() == true) goto L6;
            copyOnWriteInternal();
            return;
        }

        protected void copyOnWriteInternal() {
            MessageType r10 = (MessageType) newMutableInstance();
            mergeFromInstance(r10, this.instance);
            this.instance = r10;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r10) {
            return internalMergeFrom((GeneratedMessageLite) r10);
        }

        protected BuilderType internalMergeFrom(MessageType r10) {
            return (BuilderType) mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.access$000(this.instance, false);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(r10), r11);     // Catch: RuntimeException -> L5
            return this;
        L5:
            e = move-exception;
            if ((e.getCause() instanceof IOException) == true) goto L9;
            throw e;
        L9:
            throw ((IOException) e.getCause());
        }

        public BuilderType mergeFrom(MessageType r10) {
            if (getDefaultInstanceForType().equals(r10) == false) goto L5;
            return this;
        L5:
            copyOnWrite();
            mergeFromInstance(this.instance, r10);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12) {
            return (BuilderType) mergeFrom(r10, r11, r12, ExtensionRegistryLite.getEmptyRegistry());
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
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return mergeFrom(r10, r11, r12, r13);
        }
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T r10) {
            this.defaultInstance = r10;
        }

        @Override // com.google.protobuf.Parser
        public T parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, r10, r11);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public T parsePartialFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return (T) GeneratedMessageLite.access$300(this.defaultInstance, r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ MessageLite parsePartialFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return parsePartialFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return parsePartialFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return parsePartialFrom(r10, r11, r12, r13);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected ExtendableBuilder(MessageType r10) {
            super(r10);
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> r10 = ((ExtendableMessage) this.instance).extensions;
            if (r10.isImmutable() == false) goto L6;
            FieldSet r11 = r10.clone();
            ((ExtendableMessage) this.instance).extensions = r11;
            return r11;
        L6:
            return r10;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r10) {
            if (r10.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> r10, Type r11) {
            GeneratedExtension<MessageType, ?> r12 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r12);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(r12.descriptor, r12.singularToFieldSetType(r11));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType buildPartial() {
            if (((ExtendableMessage) this.instance).isMutable() == true) goto L7;
            MessageType r10 = this.instance;
        L6:
            return r10;
        L7:
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            r10 = (MessageType) super.buildPartial();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r11);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(r11.descriptor);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        protected void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            if (((ExtendableMessage) this.instance).extensions == FieldSet.emptySet()) goto L6;
            MessageType r10 = this.instance;
            ExtendableMessage r11 = (ExtendableMessage) r10;
            r11.extensions = ((ExtendableMessage) r10).extensions.clone();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r10) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10) {
            return ((ExtendableMessage) this.instance).getExtensionCount(r10);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10) {
            return ((ExtendableMessage) this.instance).hasExtension(r10);
        }

        void internalSetExtensionSet(FieldSet<ExtensionDescriptor> r10) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = r10;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> r10, int r11, Type r12) {
            GeneratedExtension<MessageType, ?> r13 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r13);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(r13.descriptor, r11, r13.singularToFieldSetType(r12));
            return this;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> r10, Type r11) {
            GeneratedExtension<MessageType, ?> r12 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r12);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(r12.descriptor, r12.toFieldSetType(r11));
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            private ExtensionWriter(ExtendableMessage r10, boolean r11) {
                this.this$0 = r10;
                Iterator r12 = r10.extensions.iterator();
                this.iter = r12;
                if (r12.hasNext() == false) goto L5;
                this.next = (Map.Entry) r12.next();
            L5:
                this.messageSetWireFormat = r11;
            }

            /* synthetic */ ExtensionWriter(ExtendableMessage r10, boolean r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            public void writeUntil(int r10, CodedOutputStream r11) {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r12 = this.next;
                if (r12 == null) goto L19;
                if (r12.getKey().getNumber() >= r10) goto L24;
                ExtensionDescriptor r13 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r13, this.next.getValue(), r11);
            L15:
                if (this.iter.hasNext() == false) goto L17;
                Map.Entry<ExtensionDescriptor, Object> r14 = this.iter.next();
            L18:
                this.next = r14;
                goto L2
            L17:
                r14 = null;
                goto L18
            L9:
                if (r13.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r13.isRepeated() == true) goto L13;
                r11.writeMessageSetExtension(r13.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L24:
                return;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.emptySet();
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream r10, GeneratedExtension<?, ?> r11, ExtensionRegistryLite r12, int r13) {
            parseExtension(r10, r12, r11, WireFormat.makeTag(r13, 2), r13);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString r10, ExtensionRegistryLite r11, GeneratedExtension<?, ?> r12) {
            MessageLite r13 = (MessageLite) this.extensions.getField(r12.descriptor);
            if (r13 == null) goto L5;
            MessageLite.Builder r14 = r13.toBuilder();
        L6:
            if (r14 != null) goto L8;
            r14 = r12.getMessageDefaultInstance().newBuilderForType();
        L8:
            r14.mergeFrom(r10, r11);
            MessageLite r15 = r14.build();
            ensureExtensionsAreMutable().setField(r12.descriptor, r12.singularToFieldSetType(r15));
            return;
        L5:
            r14 = null;
            goto L6
        }

        private <MessageType2 extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType2 r10, CodedInputStream r11, ExtensionRegistryLite r12) {
            int r13 = 0;
            ByteString r14 = null;
            GeneratedExtension<?, ?> r15 = null;
        L3:
            int r16 = r11.readTag();
            if (r16 == 0) goto L19;
            if (r16 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
            if (r16 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L13;
            if (r11.skipField(r16) == true) goto L3;
        L13:
            if (r13 == 0) goto L16;
            if (r15 == null) goto L16;
            eagerlyMergeMessageSetExtension(r11, r15, r12, r13);
            r14 = null;
        L16:
            r14 = r11.readBytes();
            goto L3
        L8:
            r13 = r11.readUInt32();
            if (r13 == 0) goto L3;
            r15 = r12.findLiteExtensionByNumber(r10, r13);
        L19:
            r11.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (r14 == null) goto L42;
            if (r13 == 0) goto L43;
            if (r15 == null) goto L24;
            mergeMessageSetExtensionFromBytes(r14, r12, r15);
            return;
        L24:
            mergeLengthDelimitedField(r13, r14);
            return;
        L43:
            return;
        }

        private boolean parseExtension(CodedInputStream r10, ExtensionRegistryLite r11, GeneratedExtension<?, ?> r12, int r13, int r14) {
            int r15 = WireFormat.getTagWireType(r13);
            if (r12 != null) goto L6;
        L4:
            boolean r16 = false;
            boolean r17 = true;
        L15:
            if (r17 == true) goto L17;
            ensureExtensionsAreMutable();
            if (r16 == false) goto L32;
            int r18 = r10.pushLimit(r10.readRawVarint32());
            if (r12.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L29;
        L23:
            if (r10.getBytesUntilLimit() <= 0) goto L31;
            Internal.EnumLite r19 = r12.descriptor.getEnumType().findValueByNumber(r10.readEnum());
            if (r19 == null) goto L26;
            this.extensions.addRepeatedField(r12.descriptor, r12.singularToFieldSetType(r19));
            goto L23
        L26:
            return true;
        L31:
            r10.popLimit(r18);
        L58:
            return true;
        L29:
            if (r10.getBytesUntilLimit() <= 0) goto L31;
            this.extensions.addRepeatedField(r12.descriptor, FieldSet.readPrimitiveField(r10, r12.descriptor.getLiteType(), false));
            goto L29
        L32:
            int r20 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r12.descriptor.getLiteJavaType().ordinal()];
            if (r20 != 1) goto L35;
            MessageLite.Builder r21 = null;
            if (r12.descriptor.isRepeated() == true) goto L47;
            MessageLite r110 = (MessageLite) this.extensions.getField(r12.descriptor);
            if (r110 == null) goto L47;
            r21 = r110.toBuilder();
        L47:
            if (r21 != null) goto L50;
            r21 = r12.getMessageDefaultInstance().newBuilderForType();
        L50:
            if (r12.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L52;
            r10.readGroup(r12.getNumber(), r21, r11);
        L53:
            Object r22 = r21.build();
        L54:
            boolean r23 = r12.descriptor.isRepeated();
            FieldSet<ExtensionDescriptor> r24 = this.extensions;
            if (r23 == false) goto L57;
            r24.addRepeatedField(r12.descriptor, r12.singularToFieldSetType(r22));
            goto L58
        L57:
            r24.setField(r12.descriptor, r12.singularToFieldSetType(r22));
            goto L58
        L52:
            r10.readMessage(r21, r11);
            goto L53
        L35:
            if (r20 == 2) goto L37;
            r22 = FieldSet.readPrimitiveField(r10, r12.descriptor.getLiteType(), false);
            goto L54
        L37:
            int r25 = r10.readEnum();
            Internal.EnumLite r26 = r12.descriptor.getEnumType().findValueByNumber(r25);
            if (r26 != null) goto L41;
            mergeVarintField(r14, r25);
            return true;
        L41:
            r22 = r26;
            goto L54
        L17:
            return parseUnknownField(r13, r10);
        L6:
            if (r15 != FieldSet.getWireFormatForFieldType(r12.descriptor.getLiteType(), false)) goto L8;
            r17 = false;
            r16 = false;
            goto L15
        L8:
            ExtensionDescriptor r27 = r12.descriptor;
            if (r27.isRepeated == false) goto L4;
            if (r27.type.isPackable() == false) goto L4;
            if (r15 != FieldSet.getWireFormatForFieldType(r12.descriptor.getLiteType(), true)) goto L4;
            r17 = false;
            r16 = true;
            goto L15
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r10) {
            if (r10.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @CanIgnoreReturnValue
        FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable() == false) goto L6;
            this.extensions = this.extensions.clone();
        L6:
            return this.extensions;
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r11);
            Object r12 = this.extensions.getField(r11.descriptor);
            if (r12 != null) goto L7;
            return r11.defaultValue;
        L7:
            return (Type) r11.fromFieldSetType(r12);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11) {
            GeneratedExtension<MessageType, ?> r12 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r12);
            return (Type) r12.singularFromFieldSetType(this.extensions.getRepeatedField(r12.descriptor, r11));
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r11);
            return this.extensions.getRepeatedFieldCount(r11.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10) {
            GeneratedExtension<MessageType, ?> r11 = GeneratedMessageLite.access$100(r10);
            verifyExtensionContainingType(r11);
            return this.extensions.hasField(r11.descriptor);
        }

        protected final void mergeExtensionFields(MessageType r10) {
            if (this.extensions.isImmutable() == false) goto L5;
            this.extensions = this.extensions.clone();
        L5:
            this.extensions.mergeFrom(r10.extensions);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        protected <MessageType2 extends MessageLite> boolean parseUnknownField(MessageType2 r10, CodedInputStream r11, ExtensionRegistryLite r12, int r13) {
            int r14 = WireFormat.getTagFieldNumber(r13);
            return parseExtension(r11, r12, r12.findLiteExtensionByNumber(r10, r14), r13, r14);
        }

        protected <MessageType2 extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType2 r10, CodedInputStream r11, ExtensionRegistryLite r12, int r13) {
            if (r13 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L7;
            mergeMessageSetExtensionFromCodedStream(r10, r11, r12);
            return true;
        L7:
            if (WireFormat.getTagWireType(r13) != 2) goto L11;
            return parseUnknownField(r10, r11, r12, r13);
        L11:
            return r11.skipField(r13);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> r10);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r10, int r11);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r10);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r10);
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        ExtensionDescriptor(Internal.EnumLiteMap<?> r10, int r11, WireFormat.FieldType r12, boolean r13, boolean r14) {
            this.enumTypeMap = r10;
            this.number = r11;
            this.type = r12;
            this.isRepeated = r13;
            this.isPacked = r14;
        }

        public int compareTo(ExtensionDescriptor r10) {
            return this.number - r10.number;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return compareTo((ExtensionDescriptor) r10);
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
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r10, MessageLite r11) {
            return ((Builder) r10).mergeFrom((GeneratedMessageLite) r11);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        GeneratedExtension(ContainingType r10, Type r11, MessageLite r12, ExtensionDescriptor r13, Class r14) {
            if (r10 == null) goto L13;
            if (r13.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r12 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r10;
            this.defaultValue = r11;
            this.messageDefaultInstance = r12;
            this.descriptor = r13;
            return;
        L13:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object fromFieldSetType(Object r10) {
            if (this.descriptor.isRepeated() == false) goto L14;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L12;
            ProtobufArrayList r11 = new ProtobufArrayList();
            List r12 = (List) r10;
            r11.ensureCapacity(r12.size());
            Iterator r13 = r12.iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            r11.add(singularFromFieldSetType(r13.next()));
            goto L8
        L10:
            r11.makeImmutable();
            return r11;
        L12:
            return r10;
        L14:
            return singularFromFieldSetType(r10);
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

        Object singularFromFieldSetType(Object r10) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r10;
        L5:
            return this.descriptor.enumTypeMap.findValueByNumber(((Integer) r10).intValue());
        }

        Object singularToFieldSetType(Object r10) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r10;
        L5:
            return Integer.valueOf(((Internal.EnumLite) r10).getNumber());
        }

        Object toFieldSetType(Object r10) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r11 = new ArrayList();
            Iterator r12 = ((List) r10).iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r11.add(singularToFieldSetType(r12.next()));
            goto L8
        L10:
            return r11;
        L11:
            return r10;
        L13:
            return singularToFieldSetType(r10);
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

        private MethodToInvoke(String r10, int r11) {
            super(r10, r11);
        }

        public static MethodToInvoke valueOf(String r10) {
            return (MethodToInvoke) java.lang.Enum.valueOf(MethodToInvoke.class, r10);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) $VALUES.clone();
        }
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        SerializedForm(MessageLite r10) {
            this.messageClass = r10.getClass();
            this.messageClassName = r10.getClass().getName();
            this.asBytes = r10.toByteArray();
        }

        public static SerializedForm of(MessageLite r10) {
            return new SerializedForm(r10);
        }

        private Class<?> resolveMessageClass() {
            Class<?> r10 = this.messageClass;
            if (r10 != null) goto L9;
            Class<?> r11 = Class.forName(this.messageClassName, false, SerializedForm.class.getClassLoader());
            if (MessageLite.class.isAssignableFrom(r11) == false) goto L8;
            return r11;
        L8:
            throw new ClassNotFoundException();
        L9:
            return r10;
        }

        protected Object readResolve() {
            java.lang.reflect.Field r10 = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r10.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            MessageLite.Builder r11 = ((MessageLite) r10.get(null)).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r11.mergeFrom(this.asBytes);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            return r11.buildPartial();
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

    static /* synthetic */ boolean access$000(GeneratedMessageLite r10, boolean r11) {
        return isInitialized(r10, r11);
    }

    static /* synthetic */ GeneratedExtension access$100(ExtensionLite r10) {
        return checkIsLite(r10);
    }

    static /* synthetic */ GeneratedMessageLite access$300(GeneratedMessageLite r10, byte[] r11, int r12, int r13, ExtensionRegistryLite r14) {
        return parsePartialFrom(r10, r11, r12, r13, r14);
    }

    private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> r10) {
        if (r10.isLite() == false) goto L7;
        return (GeneratedExtension) r10;
    L7:
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T r10) {
        if (r10 != null) goto L4;
    L8:
        return r10;
    L4:
        if (r10.isInitialized() == true) goto L8;
        throw r10.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(r10);
    }

    private int computeSerializedSize(Schema<?> r10) {
        if (r10 != null) goto L6;
        return Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
    L6:
        return r10.getSerializedSize(this);
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        this.unknownFields = UnknownFieldSetLite.newInstance();
        return;
    }

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> r10) {
        GeneratedMessageLite<?, ?> r11 = defaultInstanceMap.get(r10);
        if (r11 == null) goto L16;
    L9:
        if (r11 != null) goto L15;
        r11 = (T) ((GeneratedMessageLite) UnsafeUtil.allocateInstance(r10)).getDefaultInstanceForType();
        if (r11 == null) goto L14;
        defaultInstanceMap.put((Class<?>) r10, r11);
        goto L15
    L14:
        throw new IllegalStateException();
    L15:
        return (T) r11;
    L16:
        Class.forName(r10.getName(), true, r10.getClassLoader());     // Catch: ClassNotFoundException -> L6
        r11 = defaultInstanceMap.get(r10);
    L6:
        e = move-exception;
        throw new IllegalStateException("Class initialization cannot fail.", e);
    }

    static java.lang.reflect.Method getMethodOrDie(Class r10, String r11, Class... r12) {
        return r10.getMethod(r11, r12);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + r10.getName() + "\" missing method \"" + r11 + "\".", e);
    }

    static Object invokeOrDie(java.lang.reflect.Method r10, Object r11, Object... r12) {
        return r10.invoke(r11, r12);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r13 = e.getCause();
        if ((r13 instanceof RuntimeException) == true) goto L14;
        if ((r13 instanceof Error) == false) goto L12;
        throw ((Error) r13);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r13);
    L14:
        throw ((RuntimeException) r13);
    }

    private static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T r10, boolean r11) {
        byte r12 = ((Byte) r10.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (r12 != 1) goto L5;
        return true;
    L5:
        if (r12 != 0) goto L8;
        return false;
    L8:
        boolean r13 = Protobuf.getInstance().schemaFor(r10).isInitialized(r10);
        if (r11 == false) goto L15;
        MethodToInvoke r14 = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
        if (r13 == false) goto L13;
        Object r15 = r10;
    L14:
        r10.dynamicMethod(r14, r15, null);
        goto L15
    L13:
        r15 = null;
    L15:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$BooleanList] */
    protected static Internal.BooleanList mutableCopy(Internal.BooleanList r10) {
        return r10.mutableCopyWithCapacity(r10.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$DoubleList] */
    protected static Internal.DoubleList mutableCopy(Internal.DoubleList r10) {
        return r10.mutableCopyWithCapacity(r10.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$FloatList] */
    protected static Internal.FloatList mutableCopy(Internal.FloatList r10) {
        return r10.mutableCopyWithCapacity(r10.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$IntList] */
    protected static Internal.IntList mutableCopy(Internal.IntList r10) {
        return r10.mutableCopyWithCapacity(r10.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.Internal$LongList] */
    protected static Internal.LongList mutableCopy(Internal.LongList r10) {
        return r10.mutableCopyWithCapacity(r10.size() * 2);
    }

    protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> r10) {
        return r10.mutableCopyWithCapacity(r10.size() * 2);
    }

    protected static Object newMessageInfo(MessageLite r10, String r11, Object[] r12) {
        return new RawMessageInfo(r10, r11, r12);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r13, MessageLite r14, Internal.EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, boolean r18, Class r19) {
        return new GeneratedExtension(r13, ProtobufArrayList.emptyList(), r14, new ExtensionDescriptor(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r10, Type r11, MessageLite r12, Internal.EnumLiteMap<?> r13, int r14, WireFormat.FieldType r15, Class r16) {
        return new GeneratedExtension(r10, r11, r12, new ExtensionDescriptor(r13, r14, r15, false, false), r16);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r10, InputStream r11) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r10, InputStream r11, ExtensionRegistryLite r12) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r10, r11, r12));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, ByteString r11) {
        return (T) checkMessageInitialized(parseFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, ByteString r11, ExtensionRegistryLite r12) {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, r12));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, CodedInputStream r11) {
        return (T) parseFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, CodedInputStream r11, ExtensionRegistryLite r12) {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, r12));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, InputStream r11) {
        return (T) checkMessageInitialized(parsePartialFrom(r10, CodedInputStream.newInstance(r11), ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, InputStream r11, ExtensionRegistryLite r12) {
        return (T) checkMessageInitialized(parsePartialFrom(r10, CodedInputStream.newInstance(r11), r12));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, ByteBuffer r11) {
        return (T) parseFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, ByteBuffer r11, ExtensionRegistryLite r12) {
        return (T) checkMessageInitialized(parseFrom(r10, CodedInputStream.newInstance(r11), r12));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, byte[] r11) {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, 0, r11.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r10, byte[] r11, ExtensionRegistryLite r12) {
        return (T) checkMessageInitialized(parsePartialFrom(r10, r11, 0, r11.length, r12));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r10, InputStream r11, ExtensionRegistryLite r12) {
        int r13 = r11.read();     // Catch: IOException -> L13 InvalidProtocolBufferException -> L16
        if (r13 != (-1)) goto L6;
        return null;
    L6:
        CodedInputStream r14 = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(r11, CodedInputStream.readRawVarint32(r13, r11)));
        T r15 = (T) parsePartialFrom(r10, r14, r12);
        r14.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L10
        return r15;
    L10:
        e = move-exception;
        throw e.setUnfinishedMessage(r15);
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

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, ByteString r11, ExtensionRegistryLite r12) {
        CodedInputStream r13 = r11.newCodedInput();
        T r14 = (T) parsePartialFrom(r10, r13, r12);
        r13.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r14;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r14);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, CodedInputStream r11) {
        return (T) parsePartialFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, CodedInputStream r11, ExtensionRegistryLite r12) {
        T r13 = (T) r10.newMutableInstance();
        Schema r14 = Protobuf.getInstance().schemaFor(r13);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r14.mergeFrom(r13, CodedInputStreamReader.forCodedInput(r11), r12);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r14.makeImmutable(r13);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        return r13;
    L21:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L26;
        e = new InvalidProtocolBufferException(e);
    L26:
        throw e.setUnfinishedMessage(r13);
    L18:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r13);
    L11:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == false) goto L17;
        throw ((InvalidProtocolBufferException) e.getCause());
    L17:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r13);
    L5:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == true) goto L9;
        throw e;
    L9:
        throw ((InvalidProtocolBufferException) e.getCause());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r10, byte[] r11, int r12, int r13, ExtensionRegistryLite r14) {
        if (r13 != 0) goto L4;
        return r10;
    L4:
        T r15 = (T) r10.newMutableInstance();
        Schema r16 = Protobuf.getInstance().schemaFor(r15);     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        r16.mergeFrom(r15, r11, r12, r12 + r13, new ArrayDecoders.Registers(r14));     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        r16.makeImmutable(r15);     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        return r15;
    L19:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L24;
        e = new InvalidProtocolBufferException(e);
    L24:
        throw e.setUnfinishedMessage(r15);
    L16:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r15);
    L9:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == false) goto L15;
        throw ((InvalidProtocolBufferException) e.getCause());
    L15:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r15);
    L8:
        throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(r15);
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> r10, T r11) {
        r11.markImmutable();
        defaultInstanceMap.put(r10, r11);
    }

    Object buildMessageInfo() {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO, null, null);
    }

    void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    int computeHashCode() {
        return Protobuf.getInstance().schemaFor(this).hashCode(this);
    }

    protected final <MessageType2 extends GeneratedMessageLite<MessageType2, BuilderType2>, BuilderType2 extends Builder<MessageType2, BuilderType2>> BuilderType2 createBuilder() {
        return (BuilderType2) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null);
    }

    protected final <MessageType2 extends GeneratedMessageLite<MessageType2, BuilderType2>, BuilderType2 extends Builder<MessageType2, BuilderType2>> BuilderType2 createBuilder(MessageType2 r10) {
        return (BuilderType2) createBuilder().mergeFrom(r10);
    }

    protected abstract Object dynamicMethod(MethodToInvoke r10, Object r11, Object r12);

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (getClass() == r10.getClass()) goto L12;
        return false;
    L12:
        return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE, null, null);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
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

    @Override // com.google.protobuf.AbstractMessageLite
    int getSerializedSize(Schema r10) {
        if (isMutable() == false) goto L10;
        int r11 = computeSerializedSize(r10);
        if (r11 < 0) goto L8;
        return r11;
    L8:
        throw new IllegalStateException("serialized size must be non-negative, was " + r11);
    L10:
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) goto L12;
        int r12 = computeSerializedSize(r10);
        setMemoizedSerializedSize(r12);
        return r12;
    L12:
        return getMemoizedSerializedSize();
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

    boolean hashCodeIsNotMemoized() {
        if (getMemoizedHashCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    boolean isMutable() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
        markImmutable();
    }

    void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    protected void mergeLengthDelimitedField(int r10, ByteString r11) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(r10, r11);
    }

    protected final void mergeUnknownFields(UnknownFieldSetLite r10) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, r10);
    }

    protected void mergeVarintField(int r10, int r11) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(r10, r11);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    MessageType newMutableInstance() {
        return (MessageType) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE, null, null);
    }

    protected boolean parseUnknownField(int r10, CodedInputStream r11) {
        if (WireFormat.getTagWireType(r10) != 4) goto L6;
        return false;
    L6:
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(r10, r11);
    }

    void setMemoizedHashCode(int r10) {
        this.memoizedHashCode = r10;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int r10) {
        if (r10 < 0) goto L6;
        this.memoizedSerializedSize = (r10 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        return;
    L6:
        throw new IllegalStateException("serialized size must be non-negative, was " + r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType toBuilder() {
        return (BuilderType) ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null)).mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(r10));
    }
}
