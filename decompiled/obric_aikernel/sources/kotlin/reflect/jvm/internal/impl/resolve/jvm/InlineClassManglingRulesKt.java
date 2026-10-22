package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassManglingRulesKt {
    private static final boolean isDontMangleClass(ClassDescriptor r10) {
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(r10), StandardNames.RESULT_FQ_NAME);
    }

    public static final boolean isInlineClassThatRequiresMangling(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (InlineClassesUtilsKt.isInlineClass(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDontMangleClass((ClassDescriptor) r10) == true) goto L7;
        return true;
    }

    public static final boolean isInlineClassThatRequiresMangling(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 == null) goto L8;
        if (isInlineClassThatRequiresMangling(r11) != true) goto L8;
        return true;
    L8:
        return false;
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType r10) {
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r11 instanceof TypeParameterDescriptor) == false) goto L5;
        TypeParameterDescriptor r12 = (TypeParameterDescriptor) r11;
    L6:
        if (r12 != null) goto L10;
        return false;
    L10:
        return requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(r12));
    L5:
        r12 = null;
        goto L6
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType r10) {
        if (isInlineClassThatRequiresMangling(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (isTypeParameterWithUpperBoundThatRequiresMangling(r10) == true) goto L8;
        return false;
    }

    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        if ((r10 instanceof ClassConstructorDescriptor) == false) goto L5;
        ClassConstructorDescriptor r11 = (ClassConstructorDescriptor) r10;
    L7:
        if (r11 != null) goto L10;
        return false;
    L10:
        if (DescriptorVisibilities.isPrivate(r11.getVisibility()) == false) goto L12;
        return false;
    L12:
        ClassDescriptor r12 = r11.getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(r12, "constructorDescriptor.constructedClass");
        if (InlineClassesUtilsKt.isInlineClass(r12) == false) goto L16;
        return false;
    L16:
        if (DescriptorUtils.isSealedClass(r11.getConstructedClass()) == false) goto L18;
        return false;
    L18:
        List<ValueParameterDescriptor> r13 = r11.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "constructorDescriptor.valueParameters");
        if ((r13 instanceof Collection) == true) goto L21;
    L23:
        Iterator<T> r14 = r13.iterator();
    L25:
        if (r14.hasNext() == false) goto L34;
        KotlinType r15 = ((ValueParameterDescriptor) r14.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r15, "it.type");
        if (requiresFunctionNameManglingInParameterTypes(r15) == false) goto L25;
        return true;
    L34:
        return false;
    L21:
        if (r13.isEmpty() == false) goto L23;
        return false;
    L5:
        r11 = null;
        goto L7
    }
}
