package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ndescriptorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 descriptorUtil.kt\norg/jetbrains/kotlin/descriptors/DescriptorUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n*L\n1#1,108:1\n1#2:109\n19#3:110\n*S KotlinDebug\n*F\n+ 1 descriptorUtil.kt\norg/jetbrains/kotlin/descriptors/DescriptorUtilKt\n*L\n38#1:110\n*E\n"})
public final class DescriptorUtilKt {
    public static final ClassifierDescriptor getTopLevelContainingClassifier(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        if (r10 != null) goto L5;
        return null;
    L5:
        if ((r5 instanceof PackageFragmentDescriptor) == false) goto L8;
        return null;
    L8:
        if (isTopLevelInPackage(r10) == true) goto L11;
        return getTopLevelContainingClassifier(r10);
    L11:
        if ((r10 instanceof ClassifierDescriptor) == true) goto L13;
        return null;
    L13:
        return (ClassifierDescriptor) r10;
    }

    public static final boolean isTopLevelInPackage(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    public static final boolean isTypedEqualsInValueClass(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        ClassDescriptor r11 = null;
        if ((r10 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r12 = (ClassDescriptor) r10;
    L7:
        if (r12 != null) goto L9;
        return false;
    L9:
        if (InlineClassesUtilsKt.isValueClass(r12) == false) goto L11;
        r11 = r12;
    L11:
        if (r11 == null) goto L37;
        SimpleType r13 = r11.getDefaultType();
        if (r13 == null) goto L38;
        KotlinType r14 = TypeUtilsKt.replaceArgumentsWithStarProjections(r13);
        if (r14 == null) goto L45;
        KotlinType r15 = r5.getReturnType();
        if (r15 != null) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r5.getName(), OperatorNameConventions.EQUALS) == true) goto L23;
        return false;
    L23:
        if (TypeUtilsKt.isBoolean(r15) == true) goto L27;
        if (TypeUtilsKt.isNothing(r15) == true) goto L27;
        return false;
    L27:
        if (r5.getValueParameters().size() == 1) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(TypeUtilsKt.replaceArgumentsWithStarProjections(r5.getValueParameters().get(0).getType()), r14) == true) goto L31;
        return false;
    L31:
        if (r5.getContextReceiverParameters().isEmpty() == true) goto L33;
        return false;
    L33:
        if (r5.getExtensionReceiverParameter() == null) goto L35;
        return false;
    L35:
        return true;
    L45:
        return false;
    L38:
        return false;
    L37:
        return false;
    L5:
        r12 = null;
        goto L7
    }

    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor r5, FqName r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "lookupLocation");
        if (r10.isRoot() == false) goto L5;
        return null;
    L5:
        ClassifierDescriptor r12 = r5.getPackage(r10.parent()).getMemberScope().mo1404getContributedClassifier(r10.shortName(), r11);
        if ((r12 instanceof ClassDescriptor) == false) goto L8;
        ClassDescriptor r13 = (ClassDescriptor) r12;
    L9:
        if (r13 == null) goto L11;
        return r13;
    L11:
        ClassDescriptor r14 = resolveClassByFqName(r5, r10.parent(), r11);
        if (r14 == null) goto L16;
        MemberScope r15 = r14.getUnsubstitutedInnerClassesScope();
        if (r15 == null) goto L16;
        ClassifierDescriptor r16 = r15.mo1404getContributedClassifier(r10.shortName(), r11);
    L18:
        if ((r16 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r16;
    L16:
        r16 = null;
        goto L18
    L8:
        r13 = null;
        goto L9
    }
}
