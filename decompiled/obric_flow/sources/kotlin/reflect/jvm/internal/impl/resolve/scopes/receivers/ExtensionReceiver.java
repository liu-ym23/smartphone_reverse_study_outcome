package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor descriptor;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 2) goto L5;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 2) goto L9;
        int r11 = 3;
    L10:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L17;
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L15;
        r12[0] = "callableDescriptor";
    L18:
        if (r10 == 2) goto L20;
        r12[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
    L21:
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        r12[2] = "<init>";
        goto L25
    L24:
        r12[2] = "replaceType";
    L25:
        String r13 = String.format(r5, r12);
        if (r10 == 2) goto L29;
        throw new IllegalArgumentException(r13);
    L29:
        throw new IllegalStateException(r13);
    L20:
        r12[1] = "getDeclarationDescriptor";
        goto L21
    L15:
        r12[0] = "newType";
        goto L18
    L16:
        r12[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        goto L18
    L17:
        r12[0] = "receiverType";
        goto L18
    L9:
        r11 = 2;
        goto L10
    L5:
        r5 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public ExtensionReceiver(CallableDescriptor r5, KotlinType r10, ReceiverValue r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r10, r11);
        this.descriptor = r5;
    }

    public String toString() {
        return getType() + ": Ext {" + this.descriptor + "}";
    }
}
