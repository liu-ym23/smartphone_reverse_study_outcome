package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractReceiverValue implements ReceiverValue {
    private final ReceiverValue original;
    protected final KotlinType receiverType;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L6;
        if (r10 == 2) goto L6;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L10;
        int r12 = 3;
    L11:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L15;
        r13[0] = "receiverType";
    L16:
        if (r10 == 1) goto L20;
        if (r10 == 2) goto L19;
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L21:
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L24;
        r13[2] = "<init>";
    L24:
        String r14 = String.format(r11, r13);
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L29;
        throw new IllegalArgumentException(r14);
    L29:
        throw new IllegalStateException(r14);
    L19:
        r13[1] = "getOriginal";
        goto L21
    L20:
        r13[1] = "getType";
    L15:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L10:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public AbstractReceiverValue(KotlinType r10, ReceiverValue r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.receiverType = r10;
        if (r11 != null) goto L8;
        r11 = this;
    L8:
        this.original = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public KotlinType getType() {
        KotlinType r10 = this.receiverType;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r10;
    }
}
