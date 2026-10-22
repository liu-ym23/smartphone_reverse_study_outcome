package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorVisibility {
    protected DescriptorVisibility() {
    }

    public final Integer compareTo(DescriptorVisibility r10) {
        Intrinsics.checkNotNullParameter(r10, "visibility");
        return getDelegate().compareTo(r10.getDelegate());
    }

    public abstract Visibility getDelegate();

    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(ReceiverValue r10, DeclarationDescriptorWithVisibility r11, DeclarationDescriptor r12, boolean r13);

    public abstract DescriptorVisibility normalize();

    public final String toString() {
        return getDelegate().toString();
    }
}
