package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes3.dex */
public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    private final ClassDescriptor descriptor;
    private final ImplicitClassReceiver receiverValue;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L6;
        if (r10 == 2) goto L6;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L11;
        int r11 = 3;
    L12:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L18;
        if (r10 == 3) goto L17;
        r12[0] = "descriptor";
    L19:
        if (r10 == 1) goto L23;
        if (r10 == 2) goto L22;
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L24:
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L29;
        if (r10 == 3) goto L28;
        r12[2] = "<init>";
        goto L29
    L28:
        r12[2] = "copy";
    L29:
        String r13 = String.format(r5, r12);
        if (r10 == 1) goto L34;
        if (r10 == 2) goto L34;
        throw new IllegalArgumentException(r13);
    L34:
        throw new IllegalStateException(r13);
    L22:
        r12[1] = "getContainingDeclaration";
        goto L24
    L23:
        r12[1] = "getValue";
        goto L24
    L17:
        r12[0] = "newOwner";
    L18:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L11:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public LazyClassReceiverParameterDescriptor(ClassDescriptor r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(Annotations.Companion.getEMPTY());
        this.descriptor = r5;
        this.receiverValue = new ImplicitClassReceiver(r5, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor r5 = this.descriptor;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ImplicitClassReceiver r5 = this.receiverValue;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "class " + this.descriptor.getName() + "::this";
    }
}
