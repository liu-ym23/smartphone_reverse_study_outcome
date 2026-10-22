package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    public abstract void conflict(CallableMemberDescriptor r1, CallableMemberDescriptor r2);

    public NonReportingOverrideStrategy() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void inheritanceConflict(CallableMemberDescriptor r2, CallableMemberDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "first");
        Intrinsics.checkNotNullParameter(r3, "second");
        conflict(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void overrideConflict(CallableMemberDescriptor r2, CallableMemberDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "fromSuper");
        Intrinsics.checkNotNullParameter(r3, "fromCurrent");
        conflict(r2, r3);
    }
}
