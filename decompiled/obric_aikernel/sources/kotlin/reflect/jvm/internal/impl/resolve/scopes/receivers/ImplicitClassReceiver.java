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

    public ImplicitClassReceiver(ClassDescriptor r10, ImplicitClassReceiver r11) {
        Intrinsics.checkNotNullParameter(r10, "classDescriptor");
        this.classDescriptor = r10;
        if (r11 != null) goto L5;
        r11 = this;
    L5:
        this.original = r11;
        this.declarationDescriptor = r10;
    }

    public boolean equals(Object r10) {
        ClassDescriptor r11 = this.classDescriptor;
        ClassDescriptor r12 = null;
        if ((r10 instanceof ImplicitClassReceiver) == false) goto L5;
        ImplicitClassReceiver r13 = (ImplicitClassReceiver) r10;
    L6:
        if (r13 == null) goto L9;
        r12 = r13.classDescriptor;
    L9:
        return Intrinsics.areEqual(r11, r12);
    L5:
        r13 = null;
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

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public SimpleType getType() {
        SimpleType r10 = this.classDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r10, "classDescriptor.defaultType");
        return r10;
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
