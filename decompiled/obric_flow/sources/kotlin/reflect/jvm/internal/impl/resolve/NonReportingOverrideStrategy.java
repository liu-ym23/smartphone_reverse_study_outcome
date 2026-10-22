package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    public NonReportingOverrideStrategy() {
    }

    public abstract void conflict(CallableMemberDescriptor r5, CallableMemberDescriptor r10);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void inheritanceConflict(CallableMemberDescriptor r5, CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "first");
        Intrinsics.checkNotNullParameter(r10, "second");
        conflict(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void overrideConflict(CallableMemberDescriptor r5, CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "fromSuper");
        Intrinsics.checkNotNullParameter(r10, "fromCurrent");
        conflict(r5, r10);
    }
}
