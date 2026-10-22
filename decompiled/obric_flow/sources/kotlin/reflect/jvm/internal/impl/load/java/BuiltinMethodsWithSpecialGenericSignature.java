package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nspecialBuiltinMembers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 specialBuiltinMembers.kt\norg/jetbrains/kotlin/load/java/BuiltinMethodsWithSpecialGenericSignature\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = null;

    static {
        INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();
    }

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    public static final /* synthetic */ boolean access$getHasErasedValueParametersInJava(BuiltinMethodsWithSpecialGenericSignature r5, CallableMemberDescriptor r10) {
        return r5.getHasErasedValueParametersInJava(r10);
    }

    private final boolean getHasErasedValueParametersInJava(CallableMemberDescriptor r5) {
        return CollectionsKt.contains(SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), MethodSignatureMappingKt.computeJvmSignature(r5));
    }

    @JvmStatic
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        if (INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r5.getName()) == true) goto L6;
        return null;
    L6:
        return (FunctionDescriptor) DescriptorUtilsKt.firstOverridden$default(r5, false, AnonymousClass1.INSTANCE, 1, null);
    }

    @JvmStatic
    public static final SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SpecialGenericSignatures.Companion r10 = SpecialGenericSignatures.Companion;
        if (r10.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(r5.getName()) == true) goto L5;
        return null;
    L5:
        CallableMemberDescriptor r11 = DescriptorUtilsKt.firstOverridden$default(r5, false, BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1.INSTANCE, 1, null);
        if (r11 == null) goto L12;
        String r12 = MethodSignatureMappingKt.computeJvmSignature(r11);
        if (r12 == null) goto L12;
        return r10.getSpecialSignatureInfo(r12);
    L12:
        return null;
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(r5);
    }
}
