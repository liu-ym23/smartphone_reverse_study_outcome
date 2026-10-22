package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "SpecialBuiltinMembers")
@SourceDebugExtension({"SMAP\nspecialBuiltinMembers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 specialBuiltinMembers.kt\norg/jetbrains/kotlin/load/java/SpecialBuiltinMembers\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
public final class SpecialBuiltinMembers {
    public static final boolean doesOverrideBuiltinWithDifferentJvmName(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (getOverriddenBuiltinWithDifferentJvmName(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "callableMemberDescriptor");
        CallableMemberDescriptor r10 = getOverriddenBuiltinThatAffectsJvmName(r5);
        if (r10 == null) goto L16;
        CallableMemberDescriptor r11 = DescriptorUtilsKt.getPropertyIfAccessor(r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        if ((r11 instanceof PropertyDescriptor) == false) goto L11;
        return ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(r11);
    L11:
        if ((r11 instanceof SimpleFunctionDescriptor) == false) goto L18;
        Name r12 = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor) r11);
        if (r12 != null) goto L15;
        return null;
    L15:
        return r12.asString();
    L18:
        return null;
    L16:
        return null;
    }

    private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor r5) {
        if (KotlinBuiltIns.isBuiltIn(r5) == true) goto L7;
        return null;
    L7:
        return getOverriddenBuiltinWithDifferentJvmName(r5);
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(r5.getName()) == true) goto L8;
        if (BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(DescriptorUtilsKt.getPropertyIfAccessor(r5).getName()) == true) goto L8;
        return null;
    L8:
        if ((r5 instanceof PropertyDescriptor) == false) goto L10;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L15;
        return (T) DescriptorUtilsKt.firstOverridden$default(r5, false, AnonymousClass1.INSTANCE, 1, null);
    L15:
        if ((r5 instanceof SimpleFunctionDescriptor) == true) goto L17;
        return null;
    L17:
        return (T) DescriptorUtilsKt.firstOverridden$default(r5, false, AnonymousClass2.INSTANCE, 1, null);
    L10:
        r10 = r5 instanceof PropertyAccessorDescriptor;
        goto L12
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        T r10 = (T) getOverriddenBuiltinWithDifferentJvmName(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r5.getName()) == true) goto L9;
        return null;
    L9:
        return (T) DescriptorUtilsKt.firstOverridden$default(r5, false, C02262.INSTANCE, 1, null);
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor r5, CallableDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "specialCallableDescriptor");
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        SimpleType r12 = ((ClassDescriptor) r11).getDefaultType();
        ClassDescriptor r13 = DescriptorUtils.getSuperClassDescriptor(r5);
    L3:
        if (r13 == null) goto L11;
        if ((r13 instanceof JavaClassDescriptor) == true) goto L10;
        if (TypeCheckingProcedure.findCorrespondingSupertype(r13.getDefaultType(), r12) == null) goto L10;
        return !KotlinBuiltIns.isBuiltIn(r13);
    L10:
        r13 = DescriptorUtils.getSuperClassDescriptor(r13);
        goto L3
    L11:
        return false;
    }

    public static final boolean isFromJava(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return DescriptorUtilsKt.getPropertyIfAccessor(r5).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (isFromJava(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (KotlinBuiltIns.isBuiltIn(r5) == true) goto L8;
        return false;
    }
}
