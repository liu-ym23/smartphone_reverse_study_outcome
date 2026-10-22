package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {
    private final ClassDescriptor classDescriptor;
    private final ClassDescriptor declarationDescriptor;
    private final ImplicitClassReceiver original;

    public ImplicitClassReceiver(ClassDescriptor r5, ImplicitClassReceiver r10) {
        Intrinsics.checkNotNullParameter(r5, "classDescriptor");
        this.classDescriptor = r5;
        if (r10 != null) goto L5;
        r10 = this;
    L5:
        this.original = r10;
        this.declarationDescriptor = r5;
    }

    public boolean equals(Object r5) {
        ClassDescriptor r10 = this.classDescriptor;
        ClassDescriptor r11 = null;
        if ((r5 instanceof ImplicitClassReceiver) == false) goto L5;
        ImplicitClassReceiver r12 = (ImplicitClassReceiver) r5;
    L6:
        if (r12 == null) goto L9;
        r11 = r12.classDescriptor;
    L9:
        return Intrinsics.areEqual(r10, r11);
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public SimpleType getType() {
        return this.classDescriptor.getDefaultType();
    }
}
