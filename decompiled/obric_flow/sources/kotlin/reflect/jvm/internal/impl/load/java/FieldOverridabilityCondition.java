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
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r5, CallableDescriptor r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r5, "superDescriptor");
        Intrinsics.checkNotNullParameter(r10, "subDescriptor");
        if ((r10 instanceof PropertyDescriptor) == false) goto L27;
        if ((r5 instanceof PropertyDescriptor) == false) goto L27;
        PropertyDescriptor r12 = (PropertyDescriptor) r10;
        PropertyDescriptor r13 = (PropertyDescriptor) r5;
        if (Intrinsics.areEqual(r12.getName(), r13.getName()) == true) goto L12;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L12:
        if (JavaDescriptorUtilKt.isJavaField(r12) == false) goto L18;
        if (JavaDescriptorUtilKt.isJavaField(r13) == false) goto L18;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L18:
        if (JavaDescriptorUtilKt.isJavaField(r12) == true) goto L25;
        if (JavaDescriptorUtilKt.isJavaField(r13) == true) goto L25;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L25:
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L27:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
