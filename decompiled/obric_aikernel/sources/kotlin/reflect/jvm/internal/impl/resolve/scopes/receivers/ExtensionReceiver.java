package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor descriptor;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 2) goto L5;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 2) goto L9;
        int r12 = 3;
    L10:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L17;
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L15;
        r13[0] = "callableDescriptor";
    L18:
        if (r10 == 2) goto L20;
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
    L21:
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        r13[2] = "<init>";
        goto L25
    L24:
        r13[2] = "replaceType";
    L25:
        String r14 = String.format(r11, r13);
        if (r10 == 2) goto L29;
        throw new IllegalArgumentException(r14);
    L29:
        throw new IllegalStateException(r14);
    L20:
        r13[1] = "getDeclarationDescriptor";
        goto L21
    L15:
        r13[0] = "newType";
        goto L18
    L16:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        goto L18
    L17:
        r13[0] = "receiverType";
        goto L18
    L9:
        r12 = 2;
        goto L10
    L5:
        r11 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public ExtensionReceiver(CallableDescriptor r10, KotlinType r11, ReceiverValue r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r11, r12);
        this.descriptor = r10;
    }

    public String toString() {
        return getType() + ": Ext {" + this.descriptor + "}";
    }
}
