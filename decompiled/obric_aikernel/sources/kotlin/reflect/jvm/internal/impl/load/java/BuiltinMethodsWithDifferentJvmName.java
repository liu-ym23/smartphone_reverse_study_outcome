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

    public final Name getJvmName(SimpleFunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        Map<String, Name> r11 = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String r12 = MethodSignatureMappingKt.computeJvmSignature(r10);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r11.get(r12);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(final SimpleFunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        if (KotlinBuiltIns.isBuiltIn(r10) == false) goto L8;
        if (DescriptorUtilsKt.firstOverridden$default(r10, false, new AnonymousClass1(r10), 1, null) == null) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean isRemoveAtByIndex(SimpleFunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.getName().asString(), "removeAt") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature(r10), SpecialGenericSignatures.Companion.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature()) == false) goto L7;
        return true;
    }
}
