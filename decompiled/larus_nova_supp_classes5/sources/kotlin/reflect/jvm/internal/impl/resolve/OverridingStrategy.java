package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class OverridingStrategy {
    public OverridingStrategy() {
    }

    public abstract void addFakeOverride(CallableMemberDescriptor r1);

    public abstract void inheritanceConflict(CallableMemberDescriptor r1, CallableMemberDescriptor r2);

    public abstract void overrideConflict(CallableMemberDescriptor r1, CallableMemberDescriptor r2);

    public void setOverriddenDescriptors(CallableMemberDescriptor r2, Collection<? extends CallableMemberDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, "member");
        Intrinsics.checkNotNullParameter(r3, "overridden");
        r2.setOverriddenDescriptors(r3);
    }
}
