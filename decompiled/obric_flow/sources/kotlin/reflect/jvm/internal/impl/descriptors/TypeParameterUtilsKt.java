package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ntypeParameterUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeParameterUtils.kt\norg/jetbrains/kotlin/descriptors/TypeParameterUtilsKt\n+ 2 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n15#2,2:101\n1549#3:103\n1620#3,3:104\n*S KotlinDebug\n*F\n+ 1 typeParameterUtils.kt\norg/jetbrains/kotlin/descriptors/TypeParameterUtilsKt\n*L\n37#1:101,2\n42#1:103\n42#1:104,3\n*E\n"})
public final class TypeParameterUtilsKt {
    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L5;
        ClassifierDescriptorWithTypeParameters r11 = (ClassifierDescriptorWithTypeParameters) r10;
    L7:
        return buildPossiblyInnerType(r5, r11, 0);
    L5:
        r11 = null;
        goto L7
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor r5, DeclarationDescriptor r10, int r11) {
        return new CapturedTypeParameterDescriptor(r5, r10, r11);
    }

    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<TypeParameterDescriptor> r5 = r10.getDeclaredTypeParameters();
        if (r10.isInner() == false) goto L5;
    L7:
        List r11 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(r10), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE));
        Iterator<DeclarationDescriptor> r12 = DescriptorUtilsKt.getParents(r10).iterator();
    L8:
        List<TypeParameterDescriptor> r13 = null;
        if (r12.hasNext() == false) goto L13;
        DeclarationDescriptor r14 = r12.next();
        if ((r14 instanceof ClassDescriptor) == false) goto L8;
    L14:
        ClassDescriptor r15 = (ClassDescriptor) r14;
        if (r15 == null) goto L19;
        TypeConstructor r16 = r15.getTypeConstructor();
        if (r16 == null) goto L19;
        r13 = r16.getParameters();
    L19:
        if (r13 != null) goto L22;
        r13 = CollectionsKt.emptyList();
    L22:
        if (r11.isEmpty() == true) goto L24;
    L27:
        List r17 = CollectionsKt.plus(r11, r13);
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator r19 = r17.iterator();
    L29:
        if (r19.hasNext() == false) goto L32;
        r18.add(capturedCopyForInnerDeclaration((TypeParameterDescriptor) r19.next(), r10, r5.size()));
        goto L29
    L32:
        return CollectionsKt.plus(r5, r18);
    L24:
        if (r13.isEmpty() == false) goto L27;
        return r10.getDeclaredTypeParameters();
    L13:
        r14 = null;
        goto L14
    L5:
        if ((r10.getContainingDeclaration() instanceof CallableDescriptor) == true) goto L7;
        return r5;
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType r5, ClassifierDescriptorWithTypeParameters r10, int r11) {
        ClassifierDescriptorWithTypeParameters r12 = null;
        if (r10 != null) goto L5;
    L19:
        return null;
    L5:
        if (ErrorUtils.isError(r10) == true) goto L19;
        int r13 = r10.getDeclaredTypeParameters().size() + r11;
        if (r10.isInner() == false) goto L10;
        List<TypeProjection> r14 = r5.getArguments().subList(r11, r13);
        DeclarationDescriptor r15 = r10.getContainingDeclaration();
        if ((r15 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        r12 = (ClassifierDescriptorWithTypeParameters) r15;
    L18:
        return new PossiblyInnerType(r10, r14, buildPossiblyInnerType(r5, r12, r13));
    L10:
        if (r13 == r5.getArguments().size()) goto L13;
        DescriptorUtils.isLocal(r10);
    L13:
        return new PossiblyInnerType(r10, r5.getArguments().subList(r11, r5.getArguments().size()), null);
    }
}
