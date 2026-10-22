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
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TypeParameterUtilsKt {
    public static /* synthetic */ boolean accessor$TypeParameterUtilsKt$lambda0(DeclarationDescriptor r0) {
        return computeConstructorTypeParameters$lambda$0(r0);
    }

    public static /* synthetic */ boolean accessor$TypeParameterUtilsKt$lambda1(DeclarationDescriptor r0) {
        return computeConstructorTypeParameters$lambda$1(r0);
    }

    public static /* synthetic */ Sequence accessor$TypeParameterUtilsKt$lambda2(DeclarationDescriptor r0) {
        return computeConstructorTypeParameters$lambda$2(r0);
    }

    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ClassifierDescriptor r0 = r2.getConstructor().getDeclarationDescriptor();
        if ((r0 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L5;
        ClassifierDescriptorWithTypeParameters r1 = (ClassifierDescriptorWithTypeParameters) r0;
    L7:
        return buildPossiblyInnerType(r2, r1, 0);
    L5:
        r1 = null;
        goto L7
    }

    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List<TypeParameterDescriptor> r0 = r6.getDeclaredTypeParameters();
        if (r6.isInner() == false) goto L5;
    L7:
        List r1 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(r6), TypeParameterUtilsKt$.Lambda.0.INSTANCE), TypeParameterUtilsKt$.Lambda.1.INSTANCE), TypeParameterUtilsKt$.Lambda.2.INSTANCE));
        Iterator r2 = DescriptorUtilsKt.getParents(r6).iterator();
    L8:
        List<TypeParameterDescriptor> r4 = null;
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if ((r3 instanceof ClassDescriptor) == false) goto L8;
    L14:
        ClassDescriptor r5 = (ClassDescriptor) r3;
        if (r5 == null) goto L19;
        TypeConstructor r7 = r5.getTypeConstructor();
        if (r7 == null) goto L19;
        r4 = r7.getParameters();
    L19:
        if (r4 != null) goto L22;
        r4 = CollectionsKt.emptyList();
    L22:
        if (r1.isEmpty() == true) goto L24;
    L27:
        List r8 = CollectionsKt.plus(r1, r4);
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L29:
        if (r10.hasNext() == false) goto L32;
        TypeParameterDescriptor r11 = (TypeParameterDescriptor) r10.next();
        Intrinsics.checkNotNull(r11);
        r9.add(capturedCopyForInnerDeclaration(r11, r6, r0.size()));
        goto L29
    L32:
        return CollectionsKt.plus(r0, r9);
    L24:
        if (r4.isEmpty() == false) goto L27;
        return r6.getDeclaredTypeParameters();
    L13:
        r3 = null;
        goto L14
    L5:
        if ((r6.getContainingDeclaration() instanceof CallableDescriptor) == true) goto L7;
        return r0;
    }

    private static final boolean computeConstructorTypeParameters$lambda$0(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1 instanceof CallableDescriptor;
    }

    private static final boolean computeConstructorTypeParameters$lambda$1(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return !(r1 instanceof ConstructorDescriptor);
    }

    private static final Sequence computeConstructorTypeParameters$lambda$2(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return CollectionsKt.asSequence(((CallableDescriptor) r1).getTypeParameters());
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType r5, ClassifierDescriptorWithTypeParameters r6, int r7) {
        ClassifierDescriptorWithTypeParameters r0 = null;
        if (r6 != null) goto L5;
    L19:
        return null;
    L5:
        if (ErrorUtils.isError(r6) == true) goto L19;
        int r1 = r6.getDeclaredTypeParameters().size() + r7;
        if (r6.isInner() == false) goto L10;
        List<TypeProjection> r8 = r5.getArguments().subList(r7, r1);
        DeclarationDescriptor r3 = r6.getContainingDeclaration();
        if ((r3 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        r0 = (ClassifierDescriptorWithTypeParameters) r3;
    L18:
        return new PossiblyInnerType(r6, r8, buildPossiblyInnerType(r5, r0, r1));
    L10:
        if (r1 == r5.getArguments().size()) goto L13;
        DescriptorUtils.isLocal(r6);
    L13:
        return new PossiblyInnerType(r6, r5.getArguments().subList(r7, r5.getArguments().size()), null);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor r1, DeclarationDescriptor r2, int r3) {
        return new CapturedTypeParameterDescriptor(r1, r2, r3);
    }
}
