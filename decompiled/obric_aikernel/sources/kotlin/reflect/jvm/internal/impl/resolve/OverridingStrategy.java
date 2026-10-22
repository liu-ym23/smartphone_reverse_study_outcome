package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OverridingStrategy {
    public OverridingStrategy() {
    }

    public abstract void addFakeOverride(CallableMemberDescriptor r10);

    public abstract void inheritanceConflict(CallableMemberDescriptor r10, CallableMemberDescriptor r11);

    public abstract void overrideConflict(CallableMemberDescriptor r10, CallableMemberDescriptor r11);

    public void setOverriddenDescriptors(CallableMemberDescriptor r10, Collection<? extends CallableMemberDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "member");
        Intrinsics.checkNotNullParameter(r11, "overridden");
        r10.setOverriddenDescriptors(r11);
    }
}
