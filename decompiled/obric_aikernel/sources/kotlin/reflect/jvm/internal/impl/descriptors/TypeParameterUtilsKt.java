package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeParameterUtilsKt {
    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r11 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L5;
        ClassifierDescriptorWithTypeParameters r12 = (ClassifierDescriptorWithTypeParameters) r11;
    L7:
        return buildPossiblyInnerType(r10, r12, 0);
    L5:
        r12 = null;
        goto L7
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType r10, ClassifierDescriptorWithTypeParameters r11, int r12) {
        ClassifierDescriptorWithTypeParameters r13 = null;
        if (r11 != null) goto L5;
    L19:
        return null;
    L5:
        if (ErrorUtils.isError(r11) == true) goto L19;
        int r14 = r11.getDeclaredTypeParameters().size() + r12;
        if (r11.isInner() == false) goto L10;
        List<TypeProjection> r15 = r10.getArguments().subList(r12, r14);
        DeclarationDescriptor r16 = r11.getContainingDeclaration();
        if ((r16 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        r13 = (ClassifierDescriptorWithTypeParameters) r16;
    L18:
        return new PossiblyInnerType(r11, r15, buildPossiblyInnerType(r10, r13, r14));
    L10:
        if (r14 == r10.getArguments().size()) goto L13;
        DescriptorUtils.isLocal(r11);
    L13:
        return new PossiblyInnerType(r11, r10.getArguments().subList(r12, r10.getArguments().size()), null);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor r10, DeclarationDescriptor r11, int r12) {
        return new CapturedTypeParameterDescriptor(r10, r11, r12);
    }

    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<TypeParameterDescriptor> r11 = r10.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "declaredTypeParameters");
        if (r10.isInner() == false) goto L5;
    L7:
        List r12 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(r10), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE));
        Iterator<DeclarationDescriptor> r13 = DescriptorUtilsKt.getParents(r10).iterator();
    L8:
        List<TypeParameterDescriptor> r14 = null;
        if (r13.hasNext() == false) goto L13;
        DeclarationDescriptor r15 = r13.next();
        if ((r15 instanceof ClassDescriptor) == false) goto L8;
    L14:
        ClassDescriptor r16 = (ClassDescriptor) r15;
        if (r16 == null) goto L19;
        TypeConstructor r17 = r16.getTypeConstructor();
        if (r17 == null) goto L19;
        r14 = r17.getParameters();
    L19:
        if (r14 != null) goto L22;
        r14 = CollectionsKt.emptyList();
    L22:
        if (r12.isEmpty() == true) goto L24;
    L27:
        List r18 = CollectionsKt.plus(r12, r14);
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L29:
        if (r20.hasNext() == false) goto L32;
        TypeParameterDescriptor r21 = (TypeParameterDescriptor) r20.next();
        Intrinsics.checkNotNullExpressionValue(r21, "it");
        r19.add(capturedCopyForInnerDeclaration(r21, r10, r11.size()));
        goto L29
    L32:
        return CollectionsKt.plus(r11, r19);
    L24:
        if (r14.isEmpty() == false) goto L27;
        List<TypeParameterDescriptor> r22 = r10.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r22, "declaredTypeParameters");
        return r22;
    L13:
        r15 = null;
        goto L14
    L5:
        if ((r10.getContainingDeclaration() instanceof CallableDescriptor) == true) goto L7;
        return r11;
    }
}
