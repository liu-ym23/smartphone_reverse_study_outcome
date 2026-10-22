package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class StarProjectionImplKt {
    private static final KotlinType buildStarProjectionTypeByTypeParameters(final List<? extends TypeConstructor> r10, List<? extends KotlinType> r11, KotlinBuiltIns r12) {
        KotlinType r13 = TypeSubstitutor.create(new AnonymousClass1(r10)).substitute((KotlinType) CollectionsKt.first(r11), Variance.OUT_VARIANCE);
        if (r13 != null) goto L5;
        r13 = r12.getDefaultBound();
    L5:
        Intrinsics.checkNotNullExpressionValue(r13, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return r13;
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r11, "this.containingDeclaration");
        if ((r11 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L10;
        List<TypeParameterDescriptor> r12 = ((ClassifierDescriptorWithTypeParameters) r11).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.typeConstructor.parameters");
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        TypeConstructor r15 = ((TypeParameterDescriptor) r14.next()).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r15, "it.typeConstructor");
        r13.add(r15);
    L8:
        List<KotlinType> r16 = r10.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r16, "upperBounds");
        return buildStarProjectionTypeByTypeParameters(r13, r16, DescriptorUtilsKt.getBuiltIns(r10));
    L10:
        if ((r11 instanceof FunctionDescriptor) == false) goto L17;
        List<TypeParameterDescriptor> r17 = ((FunctionDescriptor) r11).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "descriptor.typeParameters");
        r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r18 = r17.iterator();
    L13:
        if (r18.hasNext() == false) goto L8;
        TypeConstructor r19 = ((TypeParameterDescriptor) r18.next()).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r19, "it.typeConstructor");
        r13.add(r19);
        goto L13
    L17:
        throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    }
}
