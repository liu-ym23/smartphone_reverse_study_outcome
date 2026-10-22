package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorVisibility {
    public DescriptorVisibility() {
    }

    public final Integer compareTo(DescriptorVisibility r5) {
        Intrinsics.checkNotNullParameter(r5, "visibility");
        return getDelegate().compareTo(r5.getDelegate());
    }

    public abstract Visibility getDelegate();

    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(ReceiverValue r5, DeclarationDescriptorWithVisibility r10, DeclarationDescriptor r11, boolean r12);

    public abstract DescriptorVisibility normalize();

    public final String toString() {
        return getDelegate().toString();
    }
}
