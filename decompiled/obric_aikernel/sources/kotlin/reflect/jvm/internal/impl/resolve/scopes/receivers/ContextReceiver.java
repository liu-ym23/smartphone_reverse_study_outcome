package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor declarationDescriptor;

    public ContextReceiver(CallableDescriptor r10, KotlinType r11, ReceiverValue r12) {
        Intrinsics.checkNotNullParameter(r10, "declarationDescriptor");
        Intrinsics.checkNotNullParameter(r11, "receiverType");
        super(r11, r12);
        this.declarationDescriptor = r10;
    }

    public CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    public String toString() {
        return "Cxt { " + getDeclarationDescriptor() + " }";
    }
}
