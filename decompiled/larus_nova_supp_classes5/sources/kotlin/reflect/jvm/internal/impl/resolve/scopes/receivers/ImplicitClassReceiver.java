package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {
    private final ClassDescriptor classDescriptor;
    private final ClassDescriptor declarationDescriptor;
    private final ImplicitClassReceiver original;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public SimpleType getType() {
        return this.classDescriptor.getDefaultType();
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    public boolean equals(Object r4) {
        ClassDescriptor r0 = this.classDescriptor;
        ClassDescriptor r2 = null;
        if ((r4 instanceof ImplicitClassReceiver) == false) goto L5;
        ImplicitClassReceiver r5 = (ImplicitClassReceiver) r4;
    L6:
        if (r5 == null) goto L9;
        r2 = r5.classDescriptor;
    L9:
        return Intrinsics.areEqual(r0, r2);
    L5:
        r5 = null;
        goto L6
    }

    public ImplicitClassReceiver(ClassDescriptor r2, ImplicitClassReceiver r3) {
        Intrinsics.checkNotNullParameter(r2, "classDescriptor");
        this.classDescriptor = r2;
        if (r3 != null) goto L5;
        r3 = this;
    L5:
        this.original = r3;
        this.declarationDescriptor = r2;
    }
}
