package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\ninlineClassManglingRules.kt\nKotlin\n*S Kotlin\n*F\n+ 1 inlineClassManglingRules.kt\norg/jetbrains/kotlin/resolve/jvm/InlineClassManglingRulesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n1747#2,3:58\n1747#2,3:61\n*S KotlinDebug\n*F\n+ 1 inlineClassManglingRules.kt\norg/jetbrains/kotlin/resolve/jvm/InlineClassManglingRulesKt\n*L\n25#1:58,3\n31#1:61,3\n*E\n"})
public final class InlineClassManglingRulesKt {
    private static final boolean isDontMangleClass(ClassDescriptor r5) {
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(r5), StandardNames.RESULT_FQ_NAME);
    }

    public static final boolean isInlineClassThatRequiresMangling(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (InlineClassesUtilsKt.isInlineClass(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDontMangleClass((ClassDescriptor) r5) == true) goto L7;
        return true;
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType r5) {
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof TypeParameterDescriptor) == false) goto L5;
        TypeParameterDescriptor r11 = (TypeParameterDescriptor) r10;
    L6:
        if (r11 != null) goto L10;
        return false;
    L10:
        return requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(r11));
    L5:
        r11 = null;
        goto L6
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType r5) {
        if (isInlineClassThatRequiresMangling(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (isTypeParameterWithUpperBoundThatRequiresMangling(r5) == true) goto L8;
        return false;
    }

    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if ((r5 instanceof ClassConstructorDescriptor) == false) goto L5;
        ClassConstructorDescriptor r10 = (ClassConstructorDescriptor) r5;
    L7:
        if (r10 != null) goto L10;
        return false;
    L10:
        if (DescriptorVisibilities.isPrivate(r10.getVisibility()) == false) goto L13;
        return false;
    L13:
        if (InlineClassesUtilsKt.isInlineClass(r10.getConstructedClass()) == false) goto L16;
        return false;
    L16:
        if (DescriptorUtils.isSealedClass(r10.getConstructedClass()) == false) goto L18;
        return false;
    L18:
        List<ValueParameterDescriptor> r11 = r10.getValueParameters();
        if (r11 != null) goto L21;
    L23:
        Iterator<T> r12 = r11.iterator();
    L25:
        if (r12.hasNext() == false) goto L34;
        if (requiresFunctionNameManglingInParameterTypes(((ValueParameterDescriptor) r12.next()).getType()) == false) goto L25;
        return true;
    L34:
        return false;
    L21:
        if (r11.isEmpty() == false) goto L23;
        return false;
    L5:
        r10 = null;
        goto L7
    }

    public static final boolean isInlineClassThatRequiresMangling(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (isInlineClassThatRequiresMangling(r10) == true) goto L7;
        return false;
    L7:
        return true;
    }
}
