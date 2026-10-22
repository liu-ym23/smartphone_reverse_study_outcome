package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    public NonReportingOverrideStrategy() {
    }

    protected abstract void conflict(CallableMemberDescriptor r10, CallableMemberDescriptor r11);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void inheritanceConflict(CallableMemberDescriptor r10, CallableMemberDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "first");
        Intrinsics.checkNotNullParameter(r11, "second");
        conflict(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void overrideConflict(CallableMemberDescriptor r10, CallableMemberDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "fromSuper");
        Intrinsics.checkNotNullParameter(r11, "fromCurrent");
        conflict(r10, r11);
    }
}
