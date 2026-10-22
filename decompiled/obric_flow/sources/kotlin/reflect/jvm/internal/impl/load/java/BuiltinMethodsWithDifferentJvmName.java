package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = null;

    static {
        INSTANCE = new BuiltinMethodsWithDifferentJvmName();
    }

    private BuiltinMethodsWithDifferentJvmName() {
    }

    public final Name getJvmName(SimpleFunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        Map<String, Name> r10 = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String r11 = MethodSignatureMappingKt.computeJvmSignature(r5);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r10.get(r11);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(final SimpleFunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        if (KotlinBuiltIns.isBuiltIn(r5) == true) goto L5;
        return false;
    L5:
        if (DescriptorUtilsKt.firstOverridden$default(r5, false, new AnonymousClass1(r5), 1, null) != null) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isRemoveAtByIndex(SimpleFunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getName().asString(), "removeAt") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature(r5), SpecialGenericSignatures.Companion.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature()) == false) goto L7;
        return true;
    }
}
