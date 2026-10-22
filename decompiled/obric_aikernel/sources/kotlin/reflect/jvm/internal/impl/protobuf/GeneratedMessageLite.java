package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$1, reason: invalid class name */
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

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields;

        protected Builder() {
            this.unknownFields = ByteString.EMPTY;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public abstract MessageType getDefaultInstanceForType();

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        public abstract BuilderType mergeFrom(MessageType r10);

        public final BuilderType setUnknownFields(ByteString r10) {
            this.unknownFields = r10;
            return this;
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions;
        private boolean extensionsIsMutable;

        protected ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        static /* synthetic */ FieldSet access$000(ExtendableBuilder r10) {
            return r10.buildExtensions();
        }

        private FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensionsIsMutable == true) goto L6;
            this.extensions = this.extensions.m1322clone();
            this.extensionsIsMutable = true;
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected final void mergeExtensionFields(MessageType r10) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$200(r10));
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<ExtensionDescriptor> extensions;

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            private ExtensionWriter(ExtendableMessage r10, boolean r11) {
                this.this$0 = r10;
                Iterator<Map.Entry<ExtensionDescriptor, Object>> r12 = ExtendableMessage.access$200(r10).iterator();
                this.iter = r12;
                if (r12.hasNext() == false) goto L5;
                this.next = r12.next();
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

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> r10) {
            this.extensions = ExtendableBuilder.access$000(r10);
        }

        static /* synthetic */ FieldSet access$200(ExtendableMessage r10) {
            return r10.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r10) {
            if (r10.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r10) {
            verifyExtensionContainingType(r10);
            Object r11 = this.extensions.getField(r10.descriptor);
            if (r11 != null) goto L7;
            return r10.defaultValue;
        L7:
            return (Type) r10.fromFieldSetType(r11);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r10, int r11) {
            verifyExtensionContainingType(r10);
            return (Type) r10.singularFromFieldSetType(this.extensions.getRepeatedField(r10.descriptor, r11));
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r10) {
            verifyExtensionContainingType(r10);
            return this.extensions.getRepeatedFieldCount(r10.descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r10) {
            verifyExtensionContainingType(r10);
            return this.extensions.hasField(r10.descriptor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        protected void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        protected boolean parseUnknownField(CodedInputStream r10, CodedOutputStream r11, ExtensionRegistryLite r12, int r13) {
            return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), r10, r11, r12, r13);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
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

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return compareTo((ExtensionDescriptor) r10);
        }

        public int compareTo(ExtensionDescriptor r10) {
            return this.number - r10.number;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r10, MessageLite r11) {
            return ((Builder) r10).mergeFrom((GeneratedMessageLite) r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        GeneratedExtension(ContainingType r10, Type r11, MessageLite r12, ExtensionDescriptor r13, Class r14) {
            if (r10 == null) goto L17;
            if (r13.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r12 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r10;
            this.defaultValue = r11;
            this.messageDefaultInstance = r12;
            this.descriptor = r13;
            this.singularType = r14;
            if (Internal.EnumLite.class.isAssignableFrom(r14) == false) goto L13;
            Method r15 = GeneratedMessageLite.getMethodOrDie(r14, "valueOf", new Class[]{Integer.TYPE});
        L14:
            this.enumValueOf = r15;
            return;
        L13:
            r15 = null;
            goto L14
        L17:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object fromFieldSetType(Object r10) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r11 = new ArrayList();
            Iterator r12 = ((List) r10).iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r11.add(singularFromFieldSetType(r12.next()));
            goto L8
        L10:
            return r11;
        L11:
            return r10;
        L13:
            return singularFromFieldSetType(r10);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        Object singularFromFieldSetType(Object r10) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r10;
        L5:
            return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, new Object[]{(Integer) r10});
        }

        Object singularToFieldSetType(Object r10) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r10;
        L5:
            return Integer.valueOf(((Internal.EnumLite) r10).getNumber());
        }
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(Builder r10) {
    }

    static /* synthetic */ boolean access$100(FieldSet r10, MessageLite r11, CodedInputStream r12, CodedOutputStream r13, ExtensionRegistryLite r14, int r15) {
        return parseUnknownField(r10, r11, r12, r13, r14, r15);
    }

    static Method getMethodOrDie(Class r10, String r11, Class... r12) {
        return r10.getMethod(r11, r12);
    L4:
        e = move-exception;
        String r13 = r10.getName();
        String r14 = String.valueOf(r11);
        StringBuilder r15 = new StringBuilder((r13.length() + 45) + r14.length());
        r15.append("Generated message class \"");
        r15.append(r13);
        r15.append("\" missing method \"");
        r15.append(r14);
        r15.append("\".");
        throw new RuntimeException(r15.toString(), e);
    }

    static Object invokeOrDie(Method r10, Object r11, Object... r12) {
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

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r13, MessageLite r14, Internal.EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, boolean r18, Class r19) {
        return new GeneratedExtension(r13, Collections.emptyList(), r14, new ExtensionDescriptor(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r10, Type r11, MessageLite r12, Internal.EnumLiteMap<?> r13, int r14, WireFormat.FieldType r15, Class r16) {
        return new GeneratedExtension(r10, r11, r12, new ExtensionDescriptor(r13, r14, r15, false, false), r16);
    }

    private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> r10, MessageType r11, CodedInputStream r12, CodedOutputStream r13, ExtensionRegistryLite r14, int r15) {
        int r16 = WireFormat.getTagWireType(r15);
        GeneratedExtension r17 = r14.findLiteExtensionByNumber(r11, WireFormat.getTagFieldNumber(r15));
        if (r17 != null) goto L6;
    L4:
        boolean r18 = false;
        boolean r19 = true;
    L15:
        if (r19 == true) goto L17;
        if (r18 == false) goto L31;
        int r20 = r12.pushLimit(r12.readRawVarint32());
        if (r17.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
    L22:
        if (r12.getBytesUntilLimit() <= 0) goto L30;
        Internal.EnumLite r21 = r17.descriptor.getEnumType().findValueByNumber(r12.readEnum());
        if (r21 == null) goto L25;
        r10.addRepeatedField(r17.descriptor, r17.singularToFieldSetType(r21));
        goto L22
    L25:
        return true;
    L30:
        r12.popLimit(r20);
    L57:
        return true;
    L28:
        if (r12.getBytesUntilLimit() <= 0) goto L30;
        r10.addRepeatedField(r17.descriptor, FieldSet.readPrimitiveField(r12, r17.descriptor.getLiteType(), false));
        goto L28
    L31:
        int r22 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r17.descriptor.getLiteJavaType().ordinal()];
        if (r22 != 1) goto L34;
        MessageLite.Builder r23 = null;
        if (r17.descriptor.isRepeated() == true) goto L46;
        MessageLite r110 = (MessageLite) r10.getField(r17.descriptor);
        if (r110 == null) goto L46;
        r23 = r110.toBuilder();
    L46:
        if (r23 != null) goto L49;
        r23 = r17.getMessageDefaultInstance().newBuilderForType();
    L49:
        if (r17.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L51;
        r12.readGroup(r17.getNumber(), r23, r14);
    L52:
        Object r24 = r23.build();
    L54:
        if (r17.descriptor.isRepeated() == false) goto L56;
        r10.addRepeatedField(r17.descriptor, r17.singularToFieldSetType(r24));
        goto L57
    L56:
        r10.setField(r17.descriptor, r17.singularToFieldSetType(r24));
        goto L57
    L51:
        r12.readMessage(r23, r14);
        goto L52
    L34:
        if (r22 == 2) goto L36;
        r24 = FieldSet.readPrimitiveField(r12, r17.descriptor.getLiteType(), false);
        goto L54
    L36:
        int r25 = r12.readEnum();
        Internal.EnumLite r26 = r17.descriptor.getEnumType().findValueByNumber(r25);
        if (r26 != null) goto L40;
        r13.writeRawVarint32(r15);
        r13.writeUInt32NoTag(r25);
        return true;
    L40:
        r24 = r26;
        goto L54
    L17:
        return r12.skipField(r15, r13);
    L6:
        if (r16 != FieldSet.getWireFormatForFieldType(r17.descriptor.getLiteType(), false)) goto L8;
        r19 = false;
        r18 = false;
        goto L15
    L8:
        ExtensionDescriptor r27 = r17.descriptor;
        if (r27.isRepeated == false) goto L4;
        if (r27.type.isPackable() == false) goto L4;
        if (r16 != FieldSet.getWireFormatForFieldType(r17.descriptor.getLiteType(), true)) goto L4;
        r19 = false;
        r18 = true;
        goto L15
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected void makeExtensionsImmutable() {
    }

    protected boolean parseUnknownField(CodedInputStream r10, CodedOutputStream r11, ExtensionRegistryLite r12, int r13) {
        return r10.skipField(r13, r11);
    }
}
