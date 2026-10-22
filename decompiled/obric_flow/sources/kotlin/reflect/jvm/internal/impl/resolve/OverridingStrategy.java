package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OverridingStrategy {
    public OverridingStrategy() {
    }

    public abstract void addFakeOverride(CallableMemberDescriptor r5);

    public abstract void inheritanceConflict(CallableMemberDescriptor r5, CallableMemberDescriptor r10);

    public abstract void overrideConflict(CallableMemberDescriptor r5, CallableMemberDescriptor r10);

    public void setOverriddenDescriptors(CallableMemberDescriptor r5, Collection<? extends CallableMemberDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "member");
        Intrinsics.checkNotNullParameter(r10, "overridden");
        r5.setOverriddenDescriptors(r10);
    }
}
