package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields;

        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType r1);

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public Builder() {
            this.unknownFields = ByteString.EMPTY;
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo381clone() {
            return clone();
        }

        public final BuilderType setUnknownFields(ByteString r1) {
            this.unknownFields = r1;
            return this;
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions;
        private boolean extensionsIsMutable;

        private FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensionsIsMutable == true) goto L6;
            this.extensions = this.extensions.m382clone();
            this.extensionsIsMutable = true;
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo381clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        public static /* synthetic */ FieldSet access$000(ExtendableBuilder r0) {
            return r0.buildExtensions();
        }

        public final void mergeExtensionFields(MessageType r2) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$200(r2));
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            private ExtensionWriter(ExtendableMessage r2, boolean r3) {
                this.this$0 = r2;
                Iterator<Map.Entry<ExtensionDescriptor, Object>> r4 = ExtendableMessage.access$200(r2).iterator();
                this.iter = r4;
                if (r4.hasNext() == false) goto L5;
                this.next = r4.next();
            L5:
                this.messageSetWireFormat = r3;
            }

            public void writeUntil(int r4, CodedOutputStream r5) throws IOException {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r0 = this.next;
                if (r0 == null) goto L18;
                if (r0.getKey().getNumber() >= r4) goto L26;
                ExtensionDescriptor r1 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r1, this.next.getValue(), r5);
            L15:
                if (this.iter.hasNext() == true) goto L16;
                this.next = null;
                goto L2
            L16:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r1.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r1.isRepeated() == true) goto L13;
                r5.writeMessageSetExtension(r1.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L26:
                return;
            }

            public /* synthetic */ ExtensionWriter(ExtendableMessage r1, boolean r2, AnonymousClass1 r3) {
                this(r1, r2);
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> r1) {
            this.extensions = ExtendableBuilder.access$000(r1);
        }

        public static /* synthetic */ FieldSet access$200(ExtendableMessage r0) {
            return r0.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r2) {
            if (r2.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r3) {
            verifyExtensionContainingType(r3);
            Object r0 = this.extensions.getField(r3.descriptor);
            if (r0 != null) goto L7;
            return r3.defaultValue;
        L7:
            return (Type) r3.fromFieldSetType(r0);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r2) {
            verifyExtensionContainingType(r2);
            return this.extensions.getRepeatedFieldCount(r2.descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r2) {
            verifyExtensionContainingType(r2);
            return this.extensions.hasField(r2.descriptor);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r3, int r4) {
            verifyExtensionContainingType(r3);
            return (Type) r3.singularFromFieldSetType(this.extensions.getRepeatedField(r3.descriptor, r4));
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream r7, CodedOutputStream r8, ExtensionRegistryLite r9, int r10) throws IOException {
            return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), r7, r8, r9, r10);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal$EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public Internal$EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
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
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r1) {
            return compareTo((ExtensionDescriptor) r1);
        }

        public int compareTo(ExtensionDescriptor r2) {
            return this.number - r2.number;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r1, MessageLite r2) {
            return ((Builder) r1).mergeFrom((GeneratedMessageLite) r2);
        }

        public ExtensionDescriptor(Internal$EnumLiteMap<?> r1, int r2, WireFormat.FieldType r3, boolean r4, boolean r5) {
            this.enumTypeMap = r1;
            this.number = r2;
            this.type = r3;
            this.isRepeated = r4;
            this.isPacked = r5;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public Object fromFieldSetType(Object r3) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r0 = new ArrayList();
            Iterator r4 = ((List) r3).iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            r0.add(singularFromFieldSetType(r4.next()));
            goto L8
        L10:
            return r0;
        L11:
            return r3;
        L13:
            return singularFromFieldSetType(r3);
        }

        public Object singularFromFieldSetType(Object r4) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r4;
        L5:
            return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, new Object[]{(Integer) r4});
        }

        public Object singularToFieldSetType(Object r3) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r3;
        L5:
            return Integer.valueOf(((Internal$EnumLite) r3).getNumber());
        }

        public GeneratedExtension(ContainingType r3, Type r4, MessageLite r5, ExtensionDescriptor r6, Class r7) {
            if (r3 == null) goto L16;
            if (r6.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r5 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r3;
            this.defaultValue = r4;
            this.messageDefaultInstance = r5;
            this.descriptor = r6;
            this.singularType = r7;
            if (Internal$EnumLite.class.isAssignableFrom(r7) == false) goto L13;
            this.enumValueOf = GeneratedMessageLite.getMethodOrDie(r7, "valueOf", new Class[]{Integer.TYPE});
            return;
        L13:
            this.enumValueOf = null;
            return;
        L16:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    public void makeExtensionsImmutable() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public GeneratedMessageLite() {
    }

    public GeneratedMessageLite(Builder r1) {
    }

    static Method getMethodOrDie(Class r4, String r5, Class... r6) {
        return r4.getMethod(r5, r6);
    L4:
        e = move-exception;
        String r7 = r4.getName();
        String r8 = String.valueOf(r5);
        StringBuilder r1 = new StringBuilder((r7.length() + 45) + r8.length());
        r1.append("Generated message class \"");
        r1.append(r7);
        r1.append("\" missing method \"");
        r1.append(r8);
        r1.append("\".");
        throw new RuntimeException(r1.toString(), e);
    }

    static Object invokeOrDie(Method r0, Object r1, Object... r2) {
        return r0.invoke(r1, r2);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r3 = e.getCause();
        if ((r3 instanceof RuntimeException) == true) goto L14;
        if ((r3 instanceof Error) == false) goto L12;
        throw ((Error) r3);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r3);
    L14:
        throw ((RuntimeException) r3);
    }

    public boolean parseUnknownField(CodedInputStream r1, CodedOutputStream r2, ExtensionRegistryLite r3, int r4) throws IOException {
        return r1.skipField(r4, r2);
    }

    public static /* synthetic */ boolean access$100(FieldSet r0, MessageLite r1, CodedInputStream r2, CodedOutputStream r3, ExtensionRegistryLite r4, int r5) throws IOException {
        return parseUnknownField(r0, r1, r2, r3, r4, r5);
    }

    private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> r5, MessageType r6, CodedInputStream r7, CodedOutputStream r8, ExtensionRegistryLite r9, int r10) throws IOException {
        int r0 = WireFormat.getTagWireType(r10);
        GeneratedExtension r11 = r9.findLiteExtensionByNumber(r6, WireFormat.getTagFieldNumber(r10));
        if (r11 != null) goto L7;
    L4:
        boolean r1 = true;
    L5:
        boolean r3 = false;
    L16:
        if (r1 == true) goto L18;
        if (r3 == false) goto L32;
        int r12 = r7.pushLimit(r7.readRawVarint32());
        if (r11.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L29;
    L23:
        if (r7.getBytesUntilLimit() <= 0) goto L31;
        int r13 = r7.readEnum();
        Internal$EnumLite r14 = r11.descriptor.getEnumType().findValueByNumber(r13);
        if (r14 == null) goto L26;
        r5.addRepeatedField(r11.descriptor, r11.singularToFieldSetType(r14));
        goto L23
    L26:
        return true;
    L31:
        r7.popLimit(r12);
    L59:
        return true;
    L29:
        if (r7.getBytesUntilLimit() <= 0) goto L31;
        Object r15 = FieldSet.readPrimitiveField(r7, r11.descriptor.getLiteType(), false);
        r5.addRepeatedField(r11.descriptor, r15);
        goto L29
    L32:
        int r2 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r11.descriptor.getLiteJavaType().ordinal()];
        if (r2 == 1) goto L43;
        if (r2 == 2) goto L37;
        Object r16 = FieldSet.readPrimitiveField(r7, r11.descriptor.getLiteType(), false);
    L56:
        if (r11.descriptor.isRepeated() == false) goto L58;
        r5.addRepeatedField(r11.descriptor, r11.singularToFieldSetType(r16));
        goto L59
    L58:
        r5.setField(r11.descriptor, r11.singularToFieldSetType(r16));
        goto L59
    L37:
        int r17 = r7.readEnum();
        Internal$EnumLite r18 = r11.descriptor.getEnumType().findValueByNumber(r17);
        if (r18 != null) goto L41;
        r8.writeRawVarint32(r10);
        r8.writeUInt32NoTag(r17);
        return true;
    L41:
        r16 = r18;
        goto L56
    L43:
        if (r11.descriptor.isRepeated() == true) goto L47;
        MessageLite r19 = (MessageLite) r5.getField(r11.descriptor);
        if (r19 == null) goto L47;
        MessageLite.Builder r20 = r19.mo380toBuilder();
    L48:
        if (r20 != null) goto L51;
        r20 = r11.getMessageDefaultInstance().mo379newBuilderForType();
    L51:
        if (r11.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L53;
        r7.readGroup(r11.getNumber(), r20, r9);
    L54:
        r16 = r20.build();
        goto L56
    L53:
        r7.readMessage(r20, r9);
    L47:
        r20 = null;
        goto L48
    L18:
        return r7.skipField(r10, r8);
    L7:
        if (r0 != FieldSet.getWireFormatForFieldType(r11.descriptor.getLiteType(), false)) goto L9;
        r1 = false;
        goto L5
    L9:
        ExtensionDescriptor r4 = r11.descriptor;
        if (r4.isRepeated == false) goto L4;
        if (r4.type.isPackable() == false) goto L4;
        if (r0 != FieldSet.getWireFormatForFieldType(r11.descriptor.getLiteType(), true)) goto L4;
        r1 = false;
        r3 = true;
        goto L16
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r13, MessageLite r14, Internal$EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, boolean r18, Class r19) {
        return new GeneratedExtension(r13, Collections.emptyList(), r14, new ExtensionDescriptor(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r8, Type r9, MessageLite r10, Internal$EnumLiteMap<?> r11, int r12, WireFormat.FieldType r13, Class r14) {
        return new GeneratedExtension(r8, r9, r10, new ExtensionDescriptor(r11, r12, r13, false, false), r14);
    }
}
