package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import androidx.constraintlayout.motion.widget.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r5 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r5;
            r5[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields;

        public Builder() {
            this.unknownFields = ByteString.EMPTY;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        public abstract BuilderType mergeFrom(MessageType r5);

        public boolean parseUnknownField(CodedInputStream r5, CodedOutputStream r10, ExtensionRegistryLite r11, int r12) throws IOException {
            return r5.skipField(r12, r10);
        }

        public final BuilderType setUnknownFields(ByteString r5) {
            this.unknownFields = r5;
            return this;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType clear() {
            this.unknownFields = ByteString.EMPTY;
            return this;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo76clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions;
        private boolean extensionsIsMutable;

        public ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        public static /* synthetic */ FieldSet access$000(ExtendableBuilder r5) {
            return r5.buildExtensions();
        }

        private FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensionsIsMutable == true) goto L6;
            this.extensions = this.extensions.clone();
            this.extensionsIsMutable = true;
            return;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r5) {
            if (r5.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> r5, Type r10) {
            verifyExtensionContainingType(r5);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(r5.descriptor, r5.singularToFieldSetType(r10));
            return this;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ Builder clear() {
            return clear();
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> r5) {
            verifyExtensionContainingType(r5);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r5.descriptor);
            return this;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r5) {
            verifyExtensionContainingType(r5);
            Object r10 = this.extensions.getField(r5.descriptor);
            if (r10 != null) goto L7;
            return r5.defaultValue;
        L7:
            return (Type) r5.fromFieldSetType(r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r5) {
            verifyExtensionContainingType(r5);
            return this.extensions.getRepeatedFieldCount(r5.descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r5) {
            verifyExtensionContainingType(r5);
            return this.extensions.hasField(r5.descriptor);
        }

        public void internalSetExtensionSet(FieldSet<ExtensionDescriptor> r5) {
            this.extensions = r5;
        }

        public final void mergeExtensionFields(MessageType r5) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$200(r5));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
        public boolean parseUnknownField(CodedInputStream r10, CodedOutputStream r11, ExtensionRegistryLite r12, int r13) throws IOException {
            ensureExtensionsIsMutable();
            return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> r5, Type r10) {
            verifyExtensionContainingType(r5);
            ensureExtensionsIsMutable();
            this.extensions.setField(r5.descriptor, r5.toFieldSetType(r10));
            return this;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType clear() {
            this.extensions.clear();
            this.extensionsIsMutable = false;
            return (BuilderType) super.clear();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo76clone() throws CloneNotSupportedException {
            return clone();
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> r5, int r10, Type r11) {
            verifyExtensionContainingType(r5);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(r5.descriptor, r10, r5.singularToFieldSetType(r11));
            return this;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r5, int r10) {
            verifyExtensionContainingType(r5);
            return (Type) r5.singularFromFieldSetType(this.extensions.getRepeatedField(r5.descriptor, r10));
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            public /* synthetic */ ExtensionWriter(ExtendableMessage r5, boolean r10, AnonymousClass1 r11) {
                this(r5, r10);
            }

            public void writeUntil(int r5, CodedOutputStream r10) throws IOException {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r11 = this.next;
                if (r11 == null) goto L18;
                if (r11.getKey().getNumber() >= r5) goto L26;
                ExtensionDescriptor r12 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r12, this.next.getValue(), r10);
            L15:
                if (this.iter.hasNext() == true) goto L16;
                this.next = null;
                goto L2
            L16:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r12.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r12.isRepeated() == true) goto L13;
                r10.writeMessageSetExtension(r12.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L26:
                return;
            }

            private ExtensionWriter(ExtendableMessage r5, boolean r10) {
                this.this$0 = r5;
                Iterator<Map.Entry<ExtensionDescriptor, Object>> r11 = ExtendableMessage.access$200(r5).iterator();
                this.iter = r11;
                if (r11.hasNext() == false) goto L5;
                this.next = r11.next();
            L5:
                this.messageSetWireFormat = r10;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        public static /* synthetic */ FieldSet access$200(ExtendableMessage r5) {
            return r5.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r5) {
            if (r5.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r5) {
            verifyExtensionContainingType(r5);
            Object r10 = this.extensions.getField(r5.descriptor);
            if (r10 != null) goto L7;
            return r5.defaultValue;
        L7:
            return (Type) r5.fromFieldSetType(r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r5) {
            verifyExtensionContainingType(r5);
            return this.extensions.getRepeatedFieldCount(r5.descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r5) {
            verifyExtensionContainingType(r5);
            return this.extensions.hasField(r5.descriptor);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream r10, CodedOutputStream r11, ExtensionRegistryLite r12, int r13) throws IOException {
            return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), r10, r11, r12, r13);
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> r5) {
            this.extensions = ExtendableBuilder.access$000(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r5, int r10) {
            verifyExtensionContainingType(r5);
            return (Type) r5.singularFromFieldSetType(this.extensions.getRepeatedField(r5.descriptor, r10));
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
        <Type> Type getExtension(GeneratedExtension<MessageType, Type> r5);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r5, int r10);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r5);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r5);
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        public ExtensionDescriptor(Internal.EnumLiteMap<?> r5, int r10, WireFormat.FieldType r11, boolean r12, boolean r13) {
            this.enumTypeMap = r5;
            this.number = r10;
            this.type = r11;
            this.isRepeated = r12;
            this.isPacked = r13;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r5) {
            return compareTo((ExtensionDescriptor) r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r5, MessageLite r10) {
            return ((Builder) r5).mergeFrom((GeneratedMessageLite) r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        public int compareTo(ExtensionDescriptor r5) {
            return this.number - r5.number;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        public GeneratedExtension(ContainingType r5, Type r10, MessageLite r11, ExtensionDescriptor r12, Class r13) {
            if (r5 == null) goto L16;
            if (r12.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r11 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r5;
            this.defaultValue = r10;
            this.messageDefaultInstance = r11;
            this.descriptor = r12;
            this.singularType = r13;
            if (Internal.EnumLite.class.isAssignableFrom(r13) == false) goto L13;
            this.enumValueOf = GeneratedMessageLite.getMethodOrDie(r13, "valueOf", new Class[]{Integer.TYPE});
            return;
        L13:
            this.enumValueOf = null;
            return;
        L16:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public Object fromFieldSetType(Object r5) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r10 = new ArrayList();
            Iterator r11 = ((List) r5).iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            r10.add(singularFromFieldSetType(r11.next()));
            goto L8
        L10:
            return r10;
        L11:
            return r5;
        L13:
            return singularFromFieldSetType(r5);
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

        public Object singularFromFieldSetType(Object r5) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r5;
        L5:
            return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, new Object[]{(Integer) r5});
        }

        public Object singularToFieldSetType(Object r5) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r5;
        L5:
            return Integer.valueOf(((Internal.EnumLite) r5).getNumber());
        }

        public Object toFieldSetType(Object r5) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r10 = new ArrayList();
            Iterator r11 = ((List) r5).iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            r10.add(singularToFieldSetType(r11.next()));
            goto L8
        L10:
            return r10;
        L11:
            return r5;
        L13:
            return singularToFieldSetType(r5);
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private byte[] asBytes;
        private String messageClassName;

        public SerializedForm(MessageLite r5) {
            this.messageClassName = r5.getClass().getName();
            this.asBytes = r5.toByteArray();
        }

        public Object readResolve() throws ObjectStreamException {
            MessageLite.Builder r5 = (MessageLite.Builder) Class.forName(this.messageClassName).getMethod("newBuilder", null).invoke(null, null);     // Catch: InvalidProtocolBufferException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
            r5.mergeFrom(this.asBytes);     // Catch: InvalidProtocolBufferException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
            return r5.buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L12:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class", e);
        L8:
            e = move-exception;
            throw new RuntimeException("Unable to call newBuilder method", e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to find newBuilder method", e);
        L6:
            e = move-exception;
            throw new RuntimeException("Error calling newBuilder", e.getCause());
        }
    }

    public GeneratedMessageLite() {
    }

    public static /* synthetic */ boolean access$100(FieldSet r5, MessageLite r10, CodedInputStream r11, CodedOutputStream r12, ExtensionRegistryLite r13, int r14) throws IOException {
        return parseUnknownField(r5, r10, r11, r12, r13, r14);
    }

    public static Method getMethodOrDie(Class r5, String r10, Class... r11) {
        return r5.getMethod(r10, r11);
    L4:
        e = move-exception;
        String r12 = r5.getName();
        String r13 = String.valueOf(r10);
        int r14 = r12.length() + 45;
        StringBuilder r15 = new StringBuilder(r13.length() + r14);
        a.C(r15, "Generated message class \"", r12, "\" missing method \"", r13);
        r15.append("\".");
        throw new RuntimeException(r15.toString(), e);
    }

    public static Object invokeOrDie(Method r5, Object r10, Object... r11) {
        return r5.invoke(r10, r11);
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

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r13, MessageLite r14, Internal.EnumLiteMap<?> r15, int r16, WireFormat.FieldType r17, boolean r18, Class r19) {
        return new GeneratedExtension(r13, Collections.emptyList(), r14, new ExtensionDescriptor(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r10, Type r11, MessageLite r12, Internal.EnumLiteMap<?> r13, int r14, WireFormat.FieldType r15, Class r16) {
        return new GeneratedExtension(r10, r11, r12, new ExtensionDescriptor(r13, r14, r15, false, false), r16);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public void makeExtensionsImmutable() {
    }

    public boolean parseUnknownField(CodedInputStream r5, CodedOutputStream r10, ExtensionRegistryLite r11, int r12) throws IOException {
        return r5.skipField(r12, r10);
    }

    public Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }

    public GeneratedMessageLite(Builder r5) {
    }

    private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> r5, MessageType r10, CodedInputStream r11, CodedOutputStream r12, ExtensionRegistryLite r13, int r14) throws IOException {
        int r15 = WireFormat.getTagWireType(r14);
        GeneratedExtension r16 = r13.findLiteExtensionByNumber(r10, WireFormat.getTagFieldNumber(r14));
        if (r16 != null) goto L6;
    L4:
        boolean r17 = true;
        boolean r18 = false;
    L15:
        if (r17 == true) goto L17;
        if (r18 == false) goto L31;
        int r19 = r11.pushLimit(r11.readRawVarint32());
        if (r16.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
    L22:
        if (r11.getBytesUntilLimit() <= 0) goto L30;
        Internal.EnumLite r20 = r16.descriptor.getEnumType().findValueByNumber(r11.readEnum());
        if (r20 == null) goto L25;
        r5.addRepeatedField(r16.descriptor, r16.singularToFieldSetType(r20));
        goto L22
    L25:
        return true;
    L30:
        r11.popLimit(r19);
    L58:
        return true;
    L28:
        if (r11.getBytesUntilLimit() <= 0) goto L30;
        r5.addRepeatedField(r16.descriptor, FieldSet.readPrimitiveField(r11, r16.descriptor.getLiteType(), false));
        goto L28
    L31:
        int r21 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r16.descriptor.getLiteJavaType().ordinal()];
        if (r21 == 1) goto L42;
        if (r21 == 2) goto L36;
        Object r22 = FieldSet.readPrimitiveField(r11, r16.descriptor.getLiteType(), false);
    L55:
        if (r16.descriptor.isRepeated() == false) goto L57;
        r5.addRepeatedField(r16.descriptor, r16.singularToFieldSetType(r22));
        goto L58
    L57:
        r5.setField(r16.descriptor, r16.singularToFieldSetType(r22));
        goto L58
    L36:
        int r23 = r11.readEnum();
        Internal.EnumLite r24 = r16.descriptor.getEnumType().findValueByNumber(r23);
        if (r24 != null) goto L40;
        r12.writeRawVarint32(r14);
        r12.writeUInt32NoTag(r23);
        return true;
    L40:
        r22 = r24;
        goto L55
    L42:
        if (r16.descriptor.isRepeated() == true) goto L46;
        MessageLite r25 = (MessageLite) r5.getField(r16.descriptor);
        if (r25 == null) goto L46;
        MessageLite.Builder r26 = r25.toBuilder();
    L47:
        if (r26 != null) goto L50;
        r26 = r16.getMessageDefaultInstance().newBuilderForType();
    L50:
        if (r16.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L52;
        r11.readGroup(r16.getNumber(), r26, r13);
    L53:
        r22 = r26.build();
        goto L55
    L52:
        r11.readMessage(r26, r13);
    L46:
        r26 = null;
        goto L47
    L17:
        return r11.skipField(r14, r12);
    L6:
        if (r15 != FieldSet.getWireFormatForFieldType(r16.descriptor.getLiteType(), false)) goto L8;
        r17 = false;
        r18 = false;
        goto L15
    L8:
        ExtensionDescriptor r27 = r16.descriptor;
        if (r27.isRepeated == false) goto L4;
        if (r27.type.isPackable() == false) goto L4;
        if (r15 != FieldSet.getWireFormatForFieldType(r16.descriptor.getLiteType(), true)) goto L4;
        r18 = true;
        r17 = false;
        goto L15
    }
}
