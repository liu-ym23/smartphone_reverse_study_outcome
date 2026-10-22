package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class TransientReceiver extends AbstractReceiverValue {
    private static /* synthetic */ void $$$reportNull$$$0(int r5) {
        Object[] r10 = new Object[3];
        if (r5 == 2) goto L5;
        r10[0] = "type";
    L6:
        r10[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (r5 == 2) goto L9;
        r10[2] = "<init>";
    L11:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r10));
    L9:
        r10[2] = "replaceType";
        goto L11
    L5:
        r10[0] = "newType";
        goto L6
    }

    public TransientReceiver(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this(r5, null);
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    private TransientReceiver(KotlinType r5, ReceiverValue r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        super(r5, r10);
    }
}
