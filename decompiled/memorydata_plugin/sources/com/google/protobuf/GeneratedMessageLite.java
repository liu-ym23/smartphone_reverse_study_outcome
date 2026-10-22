package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
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
            int[] r0 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r0;
            r0[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        public Builder(MessageType r1) {
            this.defaultInstance = r1;
            if (r1.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void mergeFromInstance(MessageType r1, MessageType r2) {
            Protobuf.getInstance().schemaFor(r1).mergeFrom(r1, r2);
        }

        private MessageType newMutableInstance() {
            return (MessageType) this.defaultInstance.newMutableInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType build() {
            MessageType r1 = (MessageType) buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
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
            BuilderType r0 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r0.instance = (MessageType) buildPartial();
            return r0;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo141clone() {
            return clone();
        }

        public final void copyOnWrite() {
            if (this.instance.isMutable() == true) goto L6;
            copyOnWriteInternal();
            return;
        }

        public void copyOnWriteInternal() {
            MessageType r0 = (MessageType) newMutableInstance();
            mergeFromInstance(r0, this.instance);
            this.instance = r0;
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
        public /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r3) {
            return internalMergeFrom((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin"));
        }

        public BuilderType internalMergeFrom(MessageType r1) {
            return (BuilderType) mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.access$000(this.instance, false);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(r3), r4);     // Catch: RuntimeException -> L5
            return this;
        L5:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e.getCause(), IOException.class) == true) goto L9;
            throw e;
        L9:
            throw ((IOException) ZeusTransformUtils.preCheckCast(e.getCause(), IOException.class, "com.obric.memorydata.plugin"));
        }

        public BuilderType mergeFrom(MessageType r2) {
            if (getDefaultInstanceForType().equals(r2) == false) goto L5;
            return this;
        L5:
            copyOnWrite();
            mergeFromInstance(this.instance, r2);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r2, int r3, int r4) {
            return (BuilderType) mergeFrom(r2, r3, r4, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r9, int r10, int r11, ExtensionRegistryLite r12) {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, r9, r10, r10 + r11, new ArrayDecoders.Registers(r12));     // Catch: IOException -> L5 IndexOutOfBoundsException -> L8 InvalidProtocolBufferException -> L10
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
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T r1) {
            this.defaultInstance = r1;
        }

        @Override // com.google.protobuf.Parser
        public T parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, r1, r2);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public T parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return (T) GeneratedMessageLite.access$300(this.defaultInstance, r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ MessageLite parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return parsePartialFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return parsePartialFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return parsePartialFrom(r1, r2, r3, r4);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        public ExtendableBuilder(MessageType r1) {
            super(r1);
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> r0 = ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions;
            if (r0.isImmutable() == false) goto L6;
            FieldSet r1 = r0.clone();
            ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions = r1;
            return r1;
        L6:
            return r0;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r1) {
            if (r1.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> r3, Type r4) {
            GeneratedExtension<MessageType, ?> r5 = GeneratedMessageLite.access$100(r3);
            verifyExtensionContainingType(r5);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(r5.descriptor, r5.singularToFieldSetType(r4));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public final MessageType buildPartial() {
            if (((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).isMutable() == true) goto L7;
            Object r3 = this.instance;
        L6:
            return (MessageType) ZeusTransformUtils.preCheckCast(r3, ExtendableMessage.class, "com.obric.memorydata.plugin");
        L7:
            ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions.makeImmutable();
            r3 = super.buildPartial();
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

        public final BuilderType clearExtension(ExtensionLite<MessageType, ?> r2) {
            GeneratedExtension<MessageType, ?> r3 = GeneratedMessageLite.access$100(r2);
            verifyExtensionContainingType(r3);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(r3.descriptor);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            if (((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions == FieldSet.emptySet()) goto L6;
            ExtendableMessage r0 = (ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin");
            r0.extensions = ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions.clone();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r3) {
            return (Type) ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).getExtension(r3);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r3, int r4) {
            return (Type) ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).getExtension(r3, r4);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r3) {
            return ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).getExtensionCount(r3);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r3) {
            return ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).hasExtension(r3);
        }

        void internalSetExtensionSet(FieldSet<ExtensionDescriptor> r3) {
            copyOnWrite();
            ((ExtendableMessage) ZeusTransformUtils.preCheckCast(this.instance, ExtendableMessage.class, "com.obric.memorydata.plugin")).extensions = r3;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> r3, int r4, Type r5) {
            GeneratedExtension<MessageType, ?> r6 = GeneratedMessageLite.access$100(r3);
            verifyExtensionContainingType(r6);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(r6.descriptor, r4, r6.singularToFieldSetType(r5));
            return this;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> r3, Type r4) {
            GeneratedExtension<MessageType, ?> r5 = GeneratedMessageLite.access$100(r3);
            verifyExtensionContainingType(r5);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(r5.descriptor, r5.toFieldSetType(r4));
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

            private ExtensionWriter(ExtendableMessage r3, boolean r4) {
                this.this$0 = r3;
                Iterator r5 = r3.extensions.iterator();
                this.iter = r5;
                if (r5.hasNext() == false) goto L5;
                this.next = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            L5:
                this.messageSetWireFormat = r4;
            }

            /* synthetic */ ExtensionWriter(ExtendableMessage r1, boolean r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            public void writeUntil(int r5, CodedOutputStream r6) {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r0 = this.next;
                if (r0 == null) goto L19;
                if (((ExtensionDescriptor) ZeusTransformUtils.preCheckCast(r0.getKey(), ExtensionDescriptor.class, "com.obric.memorydata.plugin")).getNumber() >= r5) goto L24;
                ExtensionDescriptor r1 = (ExtensionDescriptor) ZeusTransformUtils.preCheckCast(this.next.getKey(), ExtensionDescriptor.class, "com.obric.memorydata.plugin");
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r1, this.next.getValue(), r6);
            L15:
                if (this.iter.hasNext() == false) goto L17;
                Map.Entry<ExtensionDescriptor, Object> r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.iter.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            L18:
                this.next = r2;
                goto L2
            L17:
                r2 = null;
                goto L18
            L9:
                if (r1.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r1.isRepeated() == true) goto L13;
                r6.writeMessageSetExtension(r1.getNumber(), (MessageLite) ZeusTransformUtils.preCheckCast(this.next.getValue(), MessageLite.class, "com.obric.memorydata.plugin"));
                goto L15
            L24:
                return;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.emptySet();
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream r8, GeneratedExtension<?, ?> r9, ExtensionRegistryLite r10, int r11) {
            parseExtension(r8, r10, r9, WireFormat.makeTag(r11, 2), r11);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString r4, ExtensionRegistryLite r5, GeneratedExtension<?, ?> r6) {
            MessageLite r0 = (MessageLite) ZeusTransformUtils.preCheckCast(this.extensions.getField(r6.descriptor), MessageLite.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            MessageLite.Builder r1 = r0.toBuilder();
        L6:
            if (r1 != null) goto L8;
            r1 = r6.getMessageDefaultInstance().newBuilderForType();
        L8:
            r1.mergeFrom(r4, r5);
            MessageLite r7 = r1.build();
            ensureExtensionsAreMutable().setField(r6.descriptor, r6.singularToFieldSetType(r7));
            return;
        L5:
            r1 = null;
            goto L6
        }

        private <MessageType2 extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType2 r7, CodedInputStream r8, ExtensionRegistryLite r9) {
            MessageLite r10 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r7, MessageLite.class, "com.obric.memorydata.plugin");
            int r1 = 0;
            ByteString r2 = null;
            GeneratedExtension<?, ?> r3 = null;
        L3:
            int r4 = r8.readTag();
            if (r4 == 0) goto L19;
            if (r4 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
            if (r4 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L13;
            if (r8.skipField(r4) == true) goto L3;
        L13:
            if (r1 == 0) goto L16;
            if (r3 == null) goto L16;
            eagerlyMergeMessageSetExtension(r8, r3, r9, r1);
            r2 = null;
        L16:
            r2 = r8.readBytes();
            goto L3
        L8:
            r1 = r8.readUInt32();
            if (r1 == 0) goto L3;
            r3 = r9.findLiteExtensionByNumber(r10, r1);
        L19:
            r8.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (r2 == null) goto L43;
            if (r1 == 0) goto L44;
            if (r3 == null) goto L24;
            mergeMessageSetExtensionFromBytes(r2, r9, r3);
            return;
        L24:
            if (r2 == null) goto L46;
            mergeLengthDelimitedField(r1, r2);
            return;
        L46:
            return;
        L44:
            return;
        }

        private boolean parseExtension(CodedInputStream r5, ExtensionRegistryLite r6, GeneratedExtension<?, ?> r7, int r8, int r9) {
            int r0 = WireFormat.getTagWireType(r8);
            if (r7 != null) goto L6;
        L4:
            boolean r3 = false;
            boolean r1 = true;
        L15:
            if (r1 == true) goto L17;
            ensureExtensionsAreMutable();
            if (r3 == false) goto L32;
            int r10 = r5.pushLimit(r5.readRawVarint32());
            if (r7.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L29;
        L23:
            if (r5.getBytesUntilLimit() <= 0) goto L31;
            Internal.EnumLite r11 = r7.descriptor.getEnumType().findValueByNumber(r5.readEnum());
            if (r11 == null) goto L26;
            this.extensions.addRepeatedField(r7.descriptor, r7.singularToFieldSetType(r11));
            goto L23
        L26:
            return true;
        L31:
            r5.popLimit(r10);
        L58:
            return true;
        L29:
            if (r5.getBytesUntilLimit() <= 0) goto L31;
            this.extensions.addRepeatedField(r7.descriptor, FieldSet.readPrimitiveField(r5, r7.descriptor.getLiteType(), false));
            goto L29
        L32:
            int r12 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r7.descriptor.getLiteJavaType().ordinal()];
            if (r12 != 1) goto L35;
            MessageLite.Builder r13 = null;
            if (r7.descriptor.isRepeated() == true) goto L47;
            MessageLite r14 = (MessageLite) ZeusTransformUtils.preCheckCast(this.extensions.getField(r7.descriptor), MessageLite.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L47;
            r13 = r14.toBuilder();
        L47:
            if (r13 != null) goto L50;
            r13 = r7.getMessageDefaultInstance().newBuilderForType();
        L50:
            if (r7.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L52;
            r5.readGroup(r7.getNumber(), r13, r6);
        L53:
            Object r15 = r13.build();
        L54:
            boolean r16 = r7.descriptor.isRepeated();
            FieldSet<ExtensionDescriptor> r4 = this.extensions;
            if (r16 == false) goto L57;
            r4.addRepeatedField(r7.descriptor, r7.singularToFieldSetType(r15));
            goto L58
        L57:
            r4.setField(r7.descriptor, r7.singularToFieldSetType(r15));
            goto L58
        L52:
            r5.readMessage(r13, r6);
            goto L53
        L35:
            if (r12 == 2) goto L37;
            r15 = FieldSet.readPrimitiveField(r5, r7.descriptor.getLiteType(), false);
            goto L54
        L37:
            int r17 = r5.readEnum();
            Internal.EnumLite r18 = r7.descriptor.getEnumType().findValueByNumber(r17);
            if (r18 != null) goto L41;
            mergeVarintField(r9, r17);
            return true;
        L41:
            r15 = r18;
            goto L54
        L17:
            return parseUnknownField(r8, r5);
        L6:
            if (r0 != FieldSet.getWireFormatForFieldType(r7.descriptor.getLiteType(), false)) goto L9;
            r1 = false;
            r3 = false;
            goto L15
        L9:
            if (r7.descriptor.isRepeated == false) goto L4;
            if (r7.descriptor.type.isPackable() == false) goto L4;
            if (r0 != FieldSet.getWireFormatForFieldType(r7.descriptor.getLiteType(), true)) goto L4;
            r1 = false;
            r3 = true;
            goto L15
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r1) {
            if (r1.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
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

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r2) {
            GeneratedExtension<MessageType, ?> r3 = GeneratedMessageLite.access$100(r2);
            verifyExtensionContainingType(r3);
            Object r1 = this.extensions.getField(r3.descriptor);
            if (r1 != null) goto L7;
            return r3.defaultValue;
        L7:
            return (Type) r3.fromFieldSetType(r1);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r2, int r3) {
            GeneratedExtension<MessageType, ?> r4 = GeneratedMessageLite.access$100(r2);
            verifyExtensionContainingType(r4);
            return (Type) r4.singularFromFieldSetType(this.extensions.getRepeatedField(r4.descriptor, r3));
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r1) {
            GeneratedExtension<MessageType, ?> r2 = GeneratedMessageLite.access$100(r1);
            verifyExtensionContainingType(r2);
            return this.extensions.getRepeatedFieldCount(r2.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r1) {
            GeneratedExtension<MessageType, ?> r2 = GeneratedMessageLite.access$100(r1);
            verifyExtensionContainingType(r2);
            return this.extensions.hasField(r2.descriptor);
        }

        public final void mergeExtensionFields(MessageType r2) {
            if (this.extensions.isImmutable() == false) goto L5;
            this.extensions = this.extensions.clone();
        L5:
            this.extensions.mergeFrom(r2.extensions);
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

        public <MessageType2 extends MessageLite> boolean parseUnknownField(MessageType2 r7, CodedInputStream r8, ExtensionRegistryLite r9, int r10) {
            MessageLite r11 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r7, MessageLite.class, "com.obric.memorydata.plugin");
            int r5 = WireFormat.getTagFieldNumber(r10);
            return parseExtension(r8, r9, r9.findLiteExtensionByNumber(r11, r5), r10, r5);
        }

        public <MessageType2 extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType2 r3, CodedInputStream r4, ExtensionRegistryLite r5, int r6) {
            MessageLite r7 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            if (r6 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L7;
            mergeMessageSetExtensionFromCodedStream(r7, r4, r5);
            return true;
        L7:
            if (WireFormat.getTagWireType(r6) != 2) goto L11;
            return parseUnknownField(r7, r4, r5, r6);
        L11:
            return r4.skipField(r6);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> r1);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r1, int r2);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r1);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r1);
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        ExtensionDescriptor(Internal.EnumLiteMap<?> r3, int r4, WireFormat.FieldType r5, boolean r6, boolean r7) {
            this.enumTypeMap = (Internal.EnumLiteMap) ZeusTransformUtils.wrapperContextForParams(r3, Internal.EnumLiteMap.class, "com.obric.memorydata.plugin");
            this.number = r4;
            this.type = r5;
            this.isRepeated = r6;
            this.isPacked = r7;
        }

        public int compareTo(ExtensionDescriptor r1) {
            return this.number - r1.number;
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return compareTo((ExtensionDescriptor) ZeusTransformUtils.preCheckCast(r3, ExtensionDescriptor.class, "com.obric.memorydata.plugin"));
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
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r2, MessageLite r3) {
            MessageLite.Builder r1 = (MessageLite.Builder) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.Builder.class, "com.obric.memorydata.plugin");
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            return ((Builder) ZeusTransformUtils.preCheckCast(r1, Builder.class, "com.obric.memorydata.plugin")).mergeFrom((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r4, GeneratedMessageLite.class, "com.obric.memorydata.plugin"));
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

        GeneratedExtension(ContainingType r2, Type r3, MessageLite r4, ExtensionDescriptor r5, Class r6) {
            ContainingType r7 = (ContainingType) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin");
            MessageLite r8 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L13;
            if (r5.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r8 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r7;
            this.defaultValue = r3;
            this.messageDefaultInstance = r8;
            this.descriptor = r5;
            return;
        L13:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object fromFieldSetType(Object r4) {
            if (this.descriptor.isRepeated() == false) goto L14;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L12;
            ProtobufArrayList r0 = new ProtobufArrayList();
            r0.ensureCapacity(((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).size());
            Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            r0.add(singularFromFieldSetType(r5.next()));
            goto L8
        L10:
            r0.makeImmutable();
            return r0;
        L12:
            return r4;
        L14:
            return singularFromFieldSetType(r4);
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

        Object singularFromFieldSetType(Object r3) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r3;
        L5:
            return this.descriptor.enumTypeMap.findValueByNumber(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        }

        Object singularToFieldSetType(Object r2) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r2;
        L5:
            return Integer.valueOf(((Internal.EnumLite) ZeusTransformUtils.preCheckCast(r2, Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber());
        }

        Object toFieldSetType(Object r4) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r0 = new ArrayList();
            Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            r0.add(singularToFieldSetType(r5.next()));
            goto L8
        L10:
            return r0;
        L11:
            return r4;
        L13:
            return singularToFieldSetType(r4);
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

        private MethodToInvoke(String r1, int r2) {
            super(r1, r2);
        }

        public static MethodToInvoke valueOf(String r2) {
            return (MethodToInvoke) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(MethodToInvoke.class, r2), MethodToInvoke.class, "com.obric.memorydata.plugin");
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MethodToInvoke[].class, "com.obric.memorydata.plugin");
        }
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        SerializedForm(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            this.messageClass = r4.getClass();
            this.messageClassName = r4.getClass().getName();
            this.asBytes = r4.toByteArray();
        }

        public static SerializedForm of(MessageLite r2) {
            return new SerializedForm((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin"));
        }

        private Class<?> resolveMessageClass() {
            Class<?> r0 = this.messageClass;
            if (r0 != null) goto L9;
            Class<?> r2 = Class.forName(this.messageClassName, false, getClass().getClassLoader());
            if (MessageLite.class.isAssignableFrom(r2) == false) goto L8;
            return r2;
        L8:
            throw new ClassNotFoundException();
        L9:
            return r0;
        }

        public Object readResolve() {
            java.lang.reflect.Field r0 = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r0.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            MessageLite.Builder r1 = ((MessageLite) ZeusTransformUtils.preCheckCast(r0.get(null), MessageLite.class, "com.obric.memorydata.plugin")).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r1.mergeFrom(this.asBytes);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            return r1.buildPartial();
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

    static /* synthetic */ boolean access$000(GeneratedMessageLite r0, boolean r1) {
        return isInitialized(r0, r1);
    }

    static /* synthetic */ GeneratedExtension access$100(ExtensionLite r0) {
        return checkIsLite(r0);
    }

    static /* synthetic */ GeneratedMessageLite access$300(GeneratedMessageLite r0, byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
        return parsePartialFrom(r0, r1, r2, r3, r4);
    }

    private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> r2) {
        if (r2.isLite() == false) goto L7;
        return (GeneratedExtension) ZeusTransformUtils.preCheckCast(r2, GeneratedExtension.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T r1) {
        if (r1 != null) goto L4;
    L8:
        return r1;
    L4:
        if (r1.isInitialized() == true) goto L8;
        throw r1.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(r1);
    }

    private int computeSerializedSize(Schema<?> r3) {
        Schema r4 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
    L7:
        return r4.getSerializedSize(this);
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

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> r5) {
        GeneratedMessageLite<?, ?> r1 = (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(defaultInstanceMap.get(r5), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
    L9:
        if (r1 != null) goto L15;
        r1 = (T) ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(UnsafeUtil.allocateInstance(r5), GeneratedMessageLite.class, "com.obric.memorydata.plugin")).getDefaultInstanceForType();
        if (r1 == null) goto L14;
        defaultInstanceMap.put((Class<?>) r5, r1);
        goto L15
    L14:
        throw new IllegalStateException();
    L15:
        return (T) r1;
    L16:
        Class.forName(r5.getName(), true, r5.getClassLoader());     // Catch: ClassNotFoundException -> L6
        r1 = (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(defaultInstanceMap.get(r5), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        throw new IllegalStateException("Class initialization cannot fail.", e);
    }

    static java.lang.reflect.Method getMethodOrDie(Class r3, String r4, Class... r5) {
        return r3.getMethod(r4, r5);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + r3.getName() + "\" missing method \"" + r4 + "\".", e);
    }

    static Object invokeOrDie(java.lang.reflect.Method r0, Object r1, Object... r2) {
        return r0.invoke(r1, r2);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r3 = e.getCause();
        if (ZeusTransformUtils.instanceOf(r3, RuntimeException.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, Error.class) == false) goto L12;
        throw ((Error) ZeusTransformUtils.preCheckCast(r3, Error.class, "com.obric.memorydata.plugin"));
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r3);
    L14:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r3, RuntimeException.class, "com.obric.memorydata.plugin"));
    }

    private static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T r4, boolean r5) {
        byte r0 = ((Byte) ZeusTransformUtils.preCheckCast(r4.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED, null, null), Byte.class, "com.obric.memorydata.plugin")).byteValue();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        boolean r1 = Protobuf.getInstance().schemaFor(r4).isInitialized(r4);
        if (r5 == false) goto L15;
        MethodToInvoke r6 = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
        if (r1 == false) goto L13;
        Object r2 = r4;
    L14:
        r4.dynamicMethod(r6, r2, null);
        goto L15
    L13:
        r2 = null;
    L15:
        return r1;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.protobuf.Internal$BooleanList] */
    public static Internal.BooleanList mutableCopy(Internal.BooleanList r2) {
        Internal.BooleanList r3 = (Internal.BooleanList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.BooleanList.class, "com.obric.memorydata.plugin");
        return r3.mutableCopyWithCapacity(r3.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.protobuf.Internal$DoubleList] */
    public static Internal.DoubleList mutableCopy(Internal.DoubleList r2) {
        Internal.DoubleList r3 = (Internal.DoubleList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.DoubleList.class, "com.obric.memorydata.plugin");
        return r3.mutableCopyWithCapacity(r3.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.protobuf.Internal$FloatList] */
    public static Internal.FloatList mutableCopy(Internal.FloatList r2) {
        Internal.FloatList r3 = (Internal.FloatList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.FloatList.class, "com.obric.memorydata.plugin");
        return r3.mutableCopyWithCapacity(r3.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.protobuf.Internal$IntList] */
    public static Internal.IntList mutableCopy(Internal.IntList r2) {
        Internal.IntList r3 = (Internal.IntList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.IntList.class, "com.obric.memorydata.plugin");
        return r3.mutableCopyWithCapacity(r3.size() * 2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.protobuf.Internal$LongList] */
    public static Internal.LongList mutableCopy(Internal.LongList r2) {
        Internal.LongList r3 = (Internal.LongList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.LongList.class, "com.obric.memorydata.plugin");
        return r3.mutableCopyWithCapacity(r3.size() * 2);
    }

    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> r2) {
        Internal.ProtobufList r3 = (Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r2, Internal.ProtobufList.class, "com.obric.memorydata.plugin");
        return r3.mutableCopyWithCapacity(r3.size() * 2);
    }

    public static Object newMessageInfo(MessageLite r2, String r3, Object[] r4) {
        return new RawMessageInfo((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r11, MessageLite r12, Internal.EnumLiteMap<?> r13, int r14, WireFormat.FieldType r15, boolean r16, Class r17) {
        MessageLite r0 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r11, MessageLite.class, "com.obric.memorydata.plugin");
        MessageLite r2 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r12, MessageLite.class, "com.obric.memorydata.plugin");
        Internal.EnumLiteMap r4 = (Internal.EnumLiteMap) ZeusTransformUtils.wrapperContextForParams(r13, Internal.EnumLiteMap.class, "com.obric.memorydata.plugin");
        return new GeneratedExtension(r0, ProtobufArrayList.emptyList(), r2, new ExtensionDescriptor(r4, r14, r15, true, r16), r17);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r12, Type r13, MessageLite r14, Internal.EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, Class r18) {
        return new GeneratedExtension((MessageLite) ZeusTransformUtils.wrapperContextForParams(r12, MessageLite.class, "com.obric.memorydata.plugin"), r13, (MessageLite) ZeusTransformUtils.wrapperContextForParams(r14, MessageLite.class, "com.obric.memorydata.plugin"), new ExtensionDescriptor((Internal.EnumLiteMap) ZeusTransformUtils.wrapperContextForParams(r15, Internal.EnumLiteMap.class, "com.obric.memorydata.plugin"), r16, r17, false, false), r18);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r1, InputStream r2) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r0, InputStream r1, ExtensionRegistryLite r2) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r0, r1, r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteString r2) {
        return (T) checkMessageInitialized(parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, ByteString r1, ExtensionRegistryLite r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r0, r1, r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, CodedInputStream r2) {
        return (T) parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, CodedInputStream r1, ExtensionRegistryLite r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r0, r1, r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, InputStream r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r1, CodedInputStream.newInstance(r2), ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, InputStream r1, ExtensionRegistryLite r2) {
        return (T) checkMessageInitialized(parsePartialFrom(r0, CodedInputStream.newInstance(r1), r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteBuffer r2) {
        return (T) parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, ByteBuffer r1, ExtensionRegistryLite r2) {
        return (T) checkMessageInitialized(parseFrom(r0, CodedInputStream.newInstance(r1), r2));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r3, byte[] r4) {
        return (T) checkMessageInitialized(parsePartialFrom(r3, r4, 0, r4.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r2, byte[] r3, ExtensionRegistryLite r4) {
        return (T) checkMessageInitialized(parsePartialFrom(r2, r3, 0, r3.length, r4));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r2, InputStream r3, ExtensionRegistryLite r4) {
        int r0 = r3.read();     // Catch: IOException -> L13 InvalidProtocolBufferException -> L16
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        CodedInputStream r5 = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)));
        T r6 = (T) parsePartialFrom(r2, r5, r4);
        r5.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L10
        return r6;
    L10:
        e = move-exception;
        throw e.setUnfinishedMessage(r6);
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

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r0, ByteString r1, ExtensionRegistryLite r2) {
        CodedInputStream r3 = r1.newCodedInput();
        T r4 = (T) parsePartialFrom(r0, r3, r2);
        r3.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r4;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r4);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r1, CodedInputStream r2) {
        return (T) parsePartialFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r2, CodedInputStream r3, ExtensionRegistryLite r4) {
        T r5 = (T) r2.newMutableInstance();
        Schema r1 = Protobuf.getInstance().schemaFor(r5);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r1.mergeFrom(r5, CodedInputStreamReader.forCodedInput(r3), r4);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r1.makeImmutable(r5);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        return r5;
    L21:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L26;
        e = new InvalidProtocolBufferException(e);
    L26:
        throw e.setUnfinishedMessage(r5);
    L18:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r5);
    L11:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), InvalidProtocolBufferException.class) == false) goto L17;
        throw ((InvalidProtocolBufferException) ZeusTransformUtils.preCheckCast(e.getCause(), InvalidProtocolBufferException.class, "com.obric.memorydata.plugin"));
    L17:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r5);
    L5:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), InvalidProtocolBufferException.class) == true) goto L9;
        throw e;
    L9:
        throw ((InvalidProtocolBufferException) ZeusTransformUtils.preCheckCast(e.getCause(), InvalidProtocolBufferException.class, "com.obric.memorydata.plugin"));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r7, byte[] r8, int r9, int r10, ExtensionRegistryLite r11) {
        if (r10 != 0) goto L4;
        return r7;
    L4:
        T r12 = (T) r7.newMutableInstance();
        Schema r6 = Protobuf.getInstance().schemaFor(r12);     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        r6.mergeFrom(r12, r8, r9, r9 + r10, new ArrayDecoders.Registers(r11));     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        r6.makeImmutable(r12);     // Catch: IndexOutOfBoundsException -> L7 IOException -> L9 UninitializedMessageException -> L16 InvalidProtocolBufferException -> L19
        return r12;
    L19:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L24;
        e = new InvalidProtocolBufferException(e);
    L24:
        throw e.setUnfinishedMessage(r12);
    L16:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r12);
    L9:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), InvalidProtocolBufferException.class) == false) goto L15;
        throw ((InvalidProtocolBufferException) ZeusTransformUtils.preCheckCast(e.getCause(), InvalidProtocolBufferException.class, "com.obric.memorydata.plugin"));
    L15:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r12);
    L8:
        throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(r12);
    }

    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> r1, T r2) {
        r2.markImmutable();
        defaultInstanceMap.put(r1, r2);
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

    public final <MessageType2 extends GeneratedMessageLite<MessageType2, BuilderType2>, BuilderType2 extends Builder<MessageType2, BuilderType2>> BuilderType2 createBuilder() {
        return (BuilderType2) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null), Builder.class, "com.obric.memorydata.plugin");
    }

    public final <MessageType2 extends GeneratedMessageLite<MessageType2, BuilderType2>, BuilderType2 extends Builder<MessageType2, BuilderType2>> BuilderType2 createBuilder(MessageType2 r1) {
        return (BuilderType2) createBuilder().mergeFrom(r1);
    }

    public abstract Object dynamicMethod(MethodToInvoke r1, Object r2, Object r3);

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (getClass() == r4.getClass()) goto L12;
        return false;
    L12:
        return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r4, GeneratedMessageLite.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE, null, null), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
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
        return (Parser) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.GET_PARSER, null, null), Parser.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    int getSerializedSize(Schema r3) {
        Schema<?> r4 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
        if (isMutable() == false) goto L10;
        int r2 = computeSerializedSize(r4);
        if (r2 < 0) goto L8;
        return r2;
    L8:
        throw new IllegalStateException("serialized size must be non-negative, was " + r2);
    L10:
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) goto L12;
        int r5 = computeSerializedSize(r4);
        setMemoizedSerializedSize(r5);
        return r5;
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

    public void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
        markImmutable();
    }

    void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public void mergeLengthDelimitedField(int r1, ByteString r2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(r1, r2);
    }

    public final void mergeUnknownFields(UnknownFieldSetLite r2) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, r2);
    }

    public void mergeVarintField(int r1, int r2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(r1, r2);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType newBuilderForType() {
        return (BuilderType) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null), Builder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    MessageType newMutableInstance() {
        return (MessageType) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE, null, null), GeneratedMessageLite.class, "com.obric.memorydata.plugin");
    }

    public boolean parseUnknownField(int r3, CodedInputStream r4) {
        if (WireFormat.getTagWireType(r3) != 4) goto L6;
        return false;
    L6:
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(r3, r4);
    }

    void setMemoizedHashCode(int r1) {
        this.memoizedHashCode = r1;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int r3) {
        if (r3 < 0) goto L6;
        this.memoizedSerializedSize = (r3 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        return;
    L6:
        throw new IllegalStateException("serialized size must be non-negative, was " + r3);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final BuilderType toBuilder() {
        return (BuilderType) ((Builder) ZeusTransformUtils.preCheckCast(dynamicMethod(MethodToInvoke.NEW_BUILDER, null, null), Builder.class, "com.obric.memorydata.plugin")).mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r2) {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(r2));
    }
}
