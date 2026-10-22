package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractReceiverValue implements ReceiverValue {
    private final ReceiverValue original;
    protected final KotlinType receiverType;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L6;
        if (r10 == 2) goto L6;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L10;
        int r11 = 3;
    L11:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L15;
        r12[0] = "receiverType";
    L16:
        if (r10 == 1) goto L20;
        if (r10 == 2) goto L19;
        r12[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L21:
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L24;
        r12[2] = "<init>";
    L24:
        String r13 = String.format(r5, r12);
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L29;
        throw new IllegalArgumentException(r13);
    L29:
        throw new IllegalStateException(r13);
    L19:
        r12[1] = "getOriginal";
        goto L21
    L20:
        r12[1] = "getType";
    L15:
        r12[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L10:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public AbstractReceiverValue(KotlinType r5, ReceiverValue r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.receiverType = r5;
        if (r10 != null) goto L8;
        r10 = this;
    L8:
        this.original = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public KotlinType getType() {
        KotlinType r5 = this.receiverType;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r5;
    }
}
