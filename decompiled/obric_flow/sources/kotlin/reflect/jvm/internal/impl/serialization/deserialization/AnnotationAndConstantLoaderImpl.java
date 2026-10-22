package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nAnnotationAndConstantLoaderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationAndConstantLoaderImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationAndConstantLoaderImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1549#2:140\n1620#2,3:141\n1549#2:144\n1620#2,3:145\n1549#2:149\n1620#2,3:150\n1549#2:153\n1620#2,3:154\n1549#2:157\n1620#2,3:158\n1549#2:161\n1620#2,3:162\n1549#2:165\n1620#2,3:166\n1549#2:169\n1620#2,3:170\n1549#2:173\n1620#2,3:174\n1#3:148\n*S KotlinDebug\n*F\n+ 1 AnnotationAndConstantLoaderImpl.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationAndConstantLoaderImpl\n*L\n39#1:140\n39#1:141,3\n58#1:144\n58#1:145,3\n65#1:149\n65#1:150,3\n72#1:153\n72#1:154,3\n79#1:157\n79#1:158,3\n92#1:161\n92#1:162,3\n112#1:165\n112#1:166,3\n118#1:169\n118#1:170,3\n122#1:173\n122#1:174,3\n*E\n"})
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer deserializer;
    private final SerializerExtensionProtocol protocol;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[AnnotatedCallableKind.values().length];
            r5[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor r5, NotFoundClasses r10, SerializerExtensionProtocol r11) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r10, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r11, "protocol");
        this.protocol = r11;
        this.deserializer = new AnnotationDeserializer(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadAnnotationDefaultValue, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadAnnotationDefaultValue2(ProtoContainer r5, ProtoBuf.Property r10, KotlinType r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "expectedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer r5, MessageLite r10, AnnotatedCallableKind r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "kind");
        if ((r10 instanceof ProtoBuf.Constructor) == false) goto L6;
        List r12 = (List) ((ProtoBuf.Constructor) r10).getExtension(this.protocol.getConstructorAnnotation());
    L21:
        if (r12 != null) goto L23;
        r12 = CollectionsKt.emptyList();
    L23:
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        r13.add(this.deserializer.deserializeAnnotation((ProtoBuf.Annotation) r14.next(), r5.getNameResolver()));
        goto L25
    L27:
        return r13;
    L6:
        if ((r10 instanceof ProtoBuf.Function) == false) goto L9;
        r12 = (List) ((ProtoBuf.Function) r10).getExtension(this.protocol.getFunctionAnnotation());
        goto L21
    L9:
        if ((r10 instanceof ProtoBuf.Property) == false) goto L29;
        int r15 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r15 != 1) goto L13;
        r12 = (List) ((ProtoBuf.Property) r10).getExtension(this.protocol.getPropertyAnnotation());
        goto L21
    L13:
        if (r15 != 2) goto L15;
        r12 = (List) ((ProtoBuf.Property) r10).getExtension(this.protocol.getPropertyGetterAnnotation());
        goto L21
    L15:
        if (r15 != 3) goto L18;
        r12 = (List) ((ProtoBuf.Property) r10).getExtension(this.protocol.getPropertySetterAnnotation());
        goto L21
    L18:
        throw new IllegalStateException("Unsupported callable kind with property proto");
    L29:
        throw new IllegalStateException(("Unknown message: " + r10).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.Class r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        List r5 = (List) r10.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator r12 = r5.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        ProtoBuf.Annotation r13 = (ProtoBuf.Annotation) r12.next();
        r11.add(this.deserializer.deserializeAnnotation(r13, r10.getNameResolver()));
        goto L7
    L9:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer r5, ProtoBuf.EnumEntry r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        List r11 = (List) r10.getExtension(this.protocol.getEnumEntryAnnotation());
        if (r11 != null) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        ProtoBuf.Annotation r14 = (ProtoBuf.Annotation) r13.next();
        r12.add(this.deserializer.deserializeAnnotation(r14, r5.getNameResolver()));
        goto L7
    L9:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer r5, MessageLite r10, AnnotatedCallableKind r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "kind");
        List r12 = null;
        if ((r10 instanceof ProtoBuf.Function) == false) goto L8;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> r13 = this.protocol.getFunctionExtensionReceiverAnnotation();
        if (r13 == null) goto L21;
        r12 = (List) ((ProtoBuf.Function) r10).getExtension(r13);
    L21:
        if (r12 != null) goto L23;
        r12 = CollectionsKt.emptyList();
    L23:
        ArrayList r14 = new ArrayList(CollectionsKt.h(r12));
        Iterator r15 = r12.iterator();
    L25:
        if (r15.hasNext() == false) goto L27;
        r14.add(this.deserializer.deserializeAnnotation((ProtoBuf.Annotation) r15.next(), r5.getNameResolver()));
        goto L25
    L27:
        return r14;
    L8:
        if ((r10 instanceof ProtoBuf.Property) == false) goto L29;
        int r16 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r16 != 1) goto L12;
    L18:
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> r17 = this.protocol.getPropertyExtensionReceiverAnnotation();
        if (r17 == null) goto L21;
        r12 = (List) ((ProtoBuf.Property) r10).getExtension(r17);
        goto L21
    L12:
        if (r16 == 2) goto L18;
        if (r16 == 3) goto L18;
        throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + r11).toString());
    L29:
        throw new IllegalStateException(("Unknown message: " + r10).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer r5, ProtoBuf.Property r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> r11 = this.protocol.getPropertyBackingFieldAnnotation();
        if (r11 == null) goto L5;
        List r12 = (List) r10.getExtension(r11);
    L6:
        if (r12 != null) goto L8;
        r12 = CollectionsKt.emptyList();
    L8:
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        ProtoBuf.Annotation r15 = (ProtoBuf.Annotation) r14.next();
        r13.add(this.deserializer.deserializeAnnotation(r15, r5.getNameResolver()));
        goto L10
    L12:
        return r13;
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadPropertyConstant(ProtoContainer r5, ProtoBuf.Property r10, KotlinType r11) {
        return loadPropertyConstant2(r5, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer r5, ProtoBuf.Property r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> r11 = this.protocol.getPropertyDelegatedFieldAnnotation();
        if (r11 == null) goto L5;
        List r12 = (List) r10.getExtension(r11);
    L6:
        if (r12 != null) goto L8;
        r12 = CollectionsKt.emptyList();
    L8:
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        ProtoBuf.Annotation r15 = (ProtoBuf.Annotation) r14.next();
        r13.add(this.deserializer.deserializeAnnotation(r15, r5.getNameResolver()));
        goto L10
    L12:
        return r13;
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf.Type r5, NameResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        List r11 = (List) r5.getExtension(this.protocol.getTypeAnnotation());
        if (r11 != null) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        ProtoBuf.Annotation r14 = (ProtoBuf.Annotation) r13.next();
        r12.add(this.deserializer.deserializeAnnotation(r14, r10));
        goto L7
    L9:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r5, NameResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        List r11 = (List) r5.getExtension(this.protocol.getTypeParameterAnnotation());
        if (r11 != null) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        ProtoBuf.Annotation r14 = (ProtoBuf.Annotation) r13.next();
        r12.add(this.deserializer.deserializeAnnotation(r14, r10));
        goto L7
    L9:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer r5, MessageLite r10, AnnotatedCallableKind r11, int r12, ProtoBuf.ValueParameter r13) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "callableProto");
        Intrinsics.checkNotNullParameter(r11, "kind");
        Intrinsics.checkNotNullParameter(r13, "proto");
        List r14 = (List) r13.getExtension(this.protocol.getParameterAnnotation());
        if (r14 != null) goto L5;
        r14 = CollectionsKt.emptyList();
    L5:
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        ProtoBuf.Annotation r17 = (ProtoBuf.Annotation) r16.next();
        r15.add(this.deserializer.deserializeAnnotation(r17, r5.getNameResolver()));
        goto L7
    L9:
        return r15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadAnnotationDefaultValue(ProtoContainer r5, ProtoBuf.Property r10, KotlinType r11) {
        return loadAnnotationDefaultValue2(r5, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadPropertyConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadPropertyConstant2(ProtoContainer r5, ProtoBuf.Property r10, KotlinType r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "expectedType");
        ProtoBuf.Annotation.Argument.Value r12 = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(r10, this.protocol.getCompileTimeValue());
        if (r12 != null) goto L7;
        return null;
    L7:
        return this.deserializer.resolveValue(r11, r12, r5.getNameResolver());
    }
}
