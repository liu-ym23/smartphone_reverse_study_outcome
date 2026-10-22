package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final ClassDescriptor classDescriptor;

    public ContextClassReceiver(ClassDescriptor r10, KotlinType r11, ReceiverValue r12) {
        Intrinsics.checkNotNullParameter(r10, "classDescriptor");
        Intrinsics.checkNotNullParameter(r11, "receiverType");
        super(r11, r12);
        this.classDescriptor = r10;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}
