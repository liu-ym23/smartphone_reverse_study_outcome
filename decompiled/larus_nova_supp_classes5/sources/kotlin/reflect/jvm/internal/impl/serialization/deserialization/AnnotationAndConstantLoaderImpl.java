package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AnnotationAndConstantLoaderImpl extends AbstractAnnotationLoader<AnnotationDescriptor> implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer deserializer;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadAnnotationDefaultValue, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadAnnotationDefaultValue2(ProtoContainer r2, ProtoBuf$Property r3, KotlinType r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "expectedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public AnnotationDescriptor loadAnnotation(ProtoBuf$Annotation r2, NameResolver r3) {
        Intrinsics.checkNotNullParameter(r2, "proto");
        Intrinsics.checkNotNullParameter(r3, "nameResolver");
        return this.deserializer.deserializeAnnotation(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public /* bridge */ /* synthetic */ Object loadAnnotation(ProtoBuf$Annotation r1, NameResolver r2) {
        return loadAnnotation(r1, r2);
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor r2, NotFoundClasses r3, SerializerExtensionProtocol r4) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r4, "protocol");
        super(r4);
        this.deserializer = new AnnotationDeserializer(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadAnnotationDefaultValue(ProtoContainer r1, ProtoBuf$Property r2, KotlinType r3) {
        return loadAnnotationDefaultValue2(r1, r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadPropertyConstant, reason: avoid collision after fix types in other method */
    public ConstantValue<?> loadPropertyConstant2(ProtoContainer r2, ProtoBuf$Property r3, KotlinType r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "expectedType");
        ProtoBuf$Annotation.Argument.Value r5 = (ProtoBuf$Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(r3, getProtocol().getCompileTimeValue());
        if (r5 != null) goto L7;
        return null;
    L7:
        return this.deserializer.resolveValue(r4, r5, r2.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadPropertyConstant(ProtoContainer r1, ProtoBuf$Property r2, KotlinType r3) {
        return loadPropertyConstant2(r1, r2, r3);
    }
}
