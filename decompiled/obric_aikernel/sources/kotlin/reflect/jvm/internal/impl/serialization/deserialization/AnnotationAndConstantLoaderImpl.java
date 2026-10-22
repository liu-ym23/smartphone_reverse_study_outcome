package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer deserializer;
    private final SerializerExtensionProtocol protocol;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[AnnotatedCallableKind.values().length];
            r10[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor r10, NotFoundClasses r11, SerializerExtensionProtocol r12) {
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r11, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r12, "protocol");
        this.protocol = r12;
        this.deserializer = new AnnotationDeserializer(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadAnnotationDefaultValue(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        return loadAnnotationDefaultValue2(r10, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadAnnotationDefaultValue, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadAnnotationDefaultValue2(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "expectedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "kind");
        if ((r11 instanceof ProtoBuf.Constructor) == false) goto L7;
        GeneratedMessageLite.ExtendableMessage r13 = (ProtoBuf.Constructor) r11;
        Object r14 = this.protocol.getConstructorAnnotation();
    L5:
        List r15 = (List) r13.getExtension(r14);
        if (r15 != null) goto L24;
        r15 = CollectionsKt.emptyList();
    L24:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L26:
        if (r17.hasNext() == false) goto L28;
        r16.add(this.deserializer.deserializeAnnotation((ProtoBuf.Annotation) r17.next(), r10.getNameResolver()));
        goto L26
    L28:
        return r16;
    L7:
        if ((r11 instanceof ProtoBuf.Function) == false) goto L10;
        r13 = (ProtoBuf.Function) r11;
        r14 = this.protocol.getFunctionAnnotation();
        goto L5
    L10:
        if ((r11 instanceof ProtoBuf.Property) == false) goto L30;
        int r18 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r18 != 1) goto L14;
        r13 = (ProtoBuf.Property) r11;
        r14 = this.protocol.getPropertyAnnotation();
        goto L5
    L14:
        if (r18 != 2) goto L16;
        r13 = (ProtoBuf.Property) r11;
        r14 = this.protocol.getPropertyGetterAnnotation();
        goto L5
    L16:
        if (r18 != 3) goto L19;
        r13 = (ProtoBuf.Property) r11;
        r14 = this.protocol.getPropertySetterAnnotation();
        goto L5
    L19:
        throw new IllegalStateException("Unsupported callable kind with property proto".toString());
    L30:
        throw new IllegalStateException(("Unknown message: " + r11).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.Class r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        List r11 = (List) r10.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (r11 != null) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        ProtoBuf.Annotation r14 = (ProtoBuf.Annotation) r13.next();
        r12.add(this.deserializer.deserializeAnnotation(r14, r10.getNameResolver()));
        goto L7
    L9:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer r10, ProtoBuf.EnumEntry r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        List r12 = (List) r11.getExtension(this.protocol.getEnumEntryAnnotation());
        if (r12 != null) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        ProtoBuf.Annotation r15 = (ProtoBuf.Annotation) r14.next();
        r13.add(this.deserializer.deserializeAnnotation(r15, r10.getNameResolver()));
        goto L7
    L9:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "kind");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer r10, ProtoBuf.Property r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadPropertyConstant(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        return loadPropertyConstant2(r10, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadPropertyConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadPropertyConstant2(ProtoContainer r10, ProtoBuf.Property r11, KotlinType r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "expectedType");
        ProtoBuf.Annotation.Argument.Value r13 = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(r11, this.protocol.getCompileTimeValue());
        if (r13 != null) goto L7;
        return null;
    L7:
        return this.deserializer.resolveValue(r12, r13, r10.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer r10, ProtoBuf.Property r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "proto");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf.Type r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        List r12 = (List) r10.getExtension(this.protocol.getTypeAnnotation());
        if (r12 != null) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        ProtoBuf.Annotation r15 = (ProtoBuf.Annotation) r14.next();
        r13.add(this.deserializer.deserializeAnnotation(r15, r11));
        goto L7
    L9:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        List r12 = (List) r10.getExtension(this.protocol.getTypeParameterAnnotation());
        if (r12 != null) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        ProtoBuf.Annotation r15 = (ProtoBuf.Annotation) r14.next();
        r13.add(this.deserializer.deserializeAnnotation(r15, r11));
        goto L7
    L9:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12, int r13, ProtoBuf.ValueParameter r14) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "callableProto");
        Intrinsics.checkNotNullParameter(r12, "kind");
        Intrinsics.checkNotNullParameter(r14, "proto");
        List r15 = (List) r14.getExtension(this.protocol.getParameterAnnotation());
        if (r15 != null) goto L5;
        r15 = CollectionsKt.emptyList();
    L5:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L7:
        if (r17.hasNext() == false) goto L9;
        ProtoBuf.Annotation r18 = (ProtoBuf.Annotation) r17.next();
        r16.add(this.deserializer.deserializeAnnotation(r18, r10.getNameResolver()));
        goto L7
    L9:
        return r16;
    }
}
