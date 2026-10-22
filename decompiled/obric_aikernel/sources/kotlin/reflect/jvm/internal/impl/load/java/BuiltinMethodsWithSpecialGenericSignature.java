package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = null;

    static {
        INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();
    }

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    public static final /* synthetic */ boolean access$getHasErasedValueParametersInJava(BuiltinMethodsWithSpecialGenericSignature r10, CallableMemberDescriptor r11) {
        return r10.getHasErasedValueParametersInJava(r11);
    }

    private final boolean getHasErasedValueParametersInJava(CallableMemberDescriptor r10) {
        return CollectionsKt.contains(SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), MethodSignatureMappingKt.computeJvmSignature(r10));
    }

    @JvmStatic
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature r11 = INSTANCE;
        Name r12 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "functionDescriptor.name");
        if (r11.getSameAsBuiltinMethodWithErasedValueParameters(r12) == true) goto L6;
        return null;
    L6:
        return (FunctionDescriptor) DescriptorUtilsKt.firstOverridden$default(r10, false, AnonymousClass1.INSTANCE, 1, null);
    }

    @JvmStatic
    public static final SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SpecialGenericSignatures.Companion r11 = SpecialGenericSignatures.Companion;
        if (r11.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(r10.getName()) == true) goto L5;
        return null;
    L5:
        CallableMemberDescriptor r12 = DescriptorUtilsKt.firstOverridden$default(r10, false, BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1.INSTANCE, 1, null);
        if (r12 == null) goto L12;
        String r13 = MethodSignatureMappingKt.computeJvmSignature(r12);
        if (r13 == null) goto L12;
        return r11.getSpecialSignatureInfo(r13);
    L12:
        return null;
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(Name r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(r10);
    }
}
