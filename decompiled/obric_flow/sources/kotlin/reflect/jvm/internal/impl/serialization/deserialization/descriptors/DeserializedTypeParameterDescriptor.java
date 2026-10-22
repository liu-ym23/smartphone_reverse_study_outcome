package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDeserializedTypeParameterDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedTypeParameterDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedTypeParameterDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1549#2:59\n1620#2,3:60\n*S KotlinDebug\n*F\n+ 1 DeserializedTypeParameterDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedTypeParameterDescriptor\n*L\n51#1:59\n51#1:60,3\n*E\n"})
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final DeserializedAnnotations annotations;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationContext f18759c;
    private final ProtoBuf.TypeParameter proto;

    public DeserializedTypeParameterDescriptor(DeserializationContext r12, ProtoBuf.TypeParameter r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "proto");
        super(r12.getStorageManager(), r12.getContainingDeclaration(), Annotations.Companion.getEMPTY(), NameResolverUtilKt.getName(r12.getNameResolver(), r13.getName()), ProtoEnumFlags.INSTANCE.variance(r13.getVariance()), r13.getReified(), r14, SourceElement.NO_SOURCE, SupertypeLoopChecker.EMPTY.INSTANCE);
        this.f18759c = r12;
        this.proto = r13;
        this.annotations = new DeserializedAnnotations(r12.getStorageManager(), new DeserializedTypeParameterDescriptor$annotations$1(this));
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(DeserializedTypeParameterDescriptor r5) {
        return r5.f18759c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public /* bridge */ /* synthetic */ Annotations getAnnotations() {
        return getAnnotations();
    }

    public final ProtoBuf.TypeParameter getProto() {
        return this.proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo1405reportSupertypeLoopError(KotlinType r5) {
        reportSupertypeLoopError(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public List<KotlinType> resolveUpperBounds() {
        List<ProtoBuf.Type> r5 = ProtoTypeTableUtilKt.upperBounds(this.proto, this.f18759c.getTypeTable());
        if (r5.isEmpty() == true) goto L5;
        TypeDeserializer r10 = this.f18759c.getTypeDeserializer();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.add(r10.type((ProtoBuf.Type) r12.next()));
        goto L8
    L10:
        return r11;
    L5:
        return CollectionsKt.listOf(DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    public Void reportSupertypeLoopError(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
