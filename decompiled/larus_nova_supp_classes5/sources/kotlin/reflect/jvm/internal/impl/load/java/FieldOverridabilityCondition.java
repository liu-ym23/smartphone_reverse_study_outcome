package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    public FieldOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r2, CallableDescriptor r3, ClassDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "superDescriptor");
        Intrinsics.checkNotNullParameter(r3, "subDescriptor");
        if ((r3 instanceof PropertyDescriptor) == false) goto L27;
        if ((r2 instanceof PropertyDescriptor) == false) goto L27;
        PropertyDescriptor r5 = (PropertyDescriptor) r3;
        PropertyDescriptor r6 = (PropertyDescriptor) r2;
        if (Intrinsics.areEqual(r5.getName(), r6.getName()) == true) goto L12;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L12:
        if (JavaDescriptorUtilKt.isJavaField(r5) == false) goto L18;
        if (JavaDescriptorUtilKt.isJavaField(r6) == false) goto L18;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L18:
        if (JavaDescriptorUtilKt.isJavaField(r5) == true) goto L25;
        if (JavaDescriptorUtilKt.isJavaField(r6) == true) goto L25;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L25:
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L27:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
