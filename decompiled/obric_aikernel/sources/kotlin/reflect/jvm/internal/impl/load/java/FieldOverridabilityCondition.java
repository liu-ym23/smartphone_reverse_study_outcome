package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* JADX INFO: loaded from: classes3.dex */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    public FieldOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12) {
        Intrinsics.checkNotNullParameter(r10, "superDescriptor");
        Intrinsics.checkNotNullParameter(r11, "subDescriptor");
        if ((r11 instanceof PropertyDescriptor) == false) goto L27;
        if ((r10 instanceof PropertyDescriptor) == false) goto L27;
        PropertyDescriptor r13 = (PropertyDescriptor) r11;
        PropertyDescriptor r14 = (PropertyDescriptor) r10;
        if (Intrinsics.areEqual(r13.getName(), r14.getName()) == true) goto L12;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L12:
        if (JavaDescriptorUtilKt.isJavaField(r13) == false) goto L18;
        if (JavaDescriptorUtilKt.isJavaField(r14) == false) goto L18;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L18:
        if (JavaDescriptorUtilKt.isJavaField(r13) == true) goto L25;
        if (JavaDescriptorUtilKt.isJavaField(r14) == true) goto L25;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L25:
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L27:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
