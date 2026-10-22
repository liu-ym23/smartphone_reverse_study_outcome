package kotlin.reflect.jvm.internal.impl.load.java;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
public final class SpecialBuiltinMembers {
    public static final boolean doesOverrideBuiltinWithDifferentJvmName(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (getOverriddenBuiltinWithDifferentJvmName(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "callableMemberDescriptor");
        CallableMemberDescriptor r11 = getOverriddenBuiltinThatAffectsJvmName(r10);
        if (r11 == null) goto L16;
        CallableMemberDescriptor r12 = DescriptorUtilsKt.getPropertyIfAccessor(r11);
        if (r12 != null) goto L8;
        return null;
    L8:
        if ((r12 instanceof PropertyDescriptor) == false) goto L11;
        return ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(r12);
    L11:
        if ((r12 instanceof SimpleFunctionDescriptor) == false) goto L18;
        Name r13 = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor) r12);
        if (r13 != null) goto L15;
        return null;
    L15:
        return r13.asString();
    L18:
        return null;
    L16:
        return null;
    }

    private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor r10) {
        if (KotlinBuiltIns.isBuiltIn(r10) == true) goto L7;
        return null;
    L7:
        return getOverriddenBuiltinWithDifferentJvmName(r10);
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(r10.getName()) == true) goto L8;
        if (BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(DescriptorUtilsKt.getPropertyIfAccessor(r10).getName()) == true) goto L8;
        return null;
    L8:
        if ((r10 instanceof PropertyDescriptor) == false) goto L10;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L16;
        Function1 r12 = AnonymousClass1.INSTANCE;
    L18:
        return (T) DescriptorUtilsKt.firstOverridden$default(r10, false, r12, 1, null);
    L16:
        if ((r10 instanceof SimpleFunctionDescriptor) == false) goto L19;
        r12 = AnonymousClass2.INSTANCE;
        goto L18
    L19:
        return null;
    L10:
        r11 = r10 instanceof PropertyAccessorDescriptor;
        goto L12
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        T r11 = (T) getOverriddenBuiltinWithDifferentJvmName(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        BuiltinMethodsWithSpecialGenericSignature r12 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name r13 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r13, ActivityLifecycle.NAME);
        if (r12.getSameAsBuiltinMethodWithErasedValueParameters(r13) == true) goto L9;
        return null;
    L9:
        return (T) DescriptorUtilsKt.firstOverridden$default(r10, false, C04152.INSTANCE, 1, null);
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor r10, CallableDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "specialCallableDescriptor");
        DeclarationDescriptor r12 = r11.getContainingDeclaration();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        SimpleType r13 = ((ClassDescriptor) r12).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r13, "specialCallableDescripto…ssDescriptor).defaultType");
    L3:
        r10 = DescriptorUtils.getSuperClassDescriptor(r10);
        boolean r14 = false;
        if (r10 == null) goto L13;
        if ((r10 instanceof JavaClassDescriptor) == true) goto L3;
        if (TypeCheckingProcedure.findCorrespondingSupertype(r10.getDefaultType(), r13) == null) goto L10;
        r14 = true;
    L10:
        if (r14 == false) goto L3;
        return !KotlinBuiltIns.isBuiltIn(r10);
    L13:
        return false;
    }

    public static final boolean isFromJava(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return DescriptorUtilsKt.getPropertyIfAccessor(r10).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (isFromJava(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (KotlinBuiltIns.isBuiltIn(r10) == true) goto L8;
        return false;
    }
}
