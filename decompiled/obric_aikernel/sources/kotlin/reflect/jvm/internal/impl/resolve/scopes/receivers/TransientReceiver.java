package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class TransientReceiver extends AbstractReceiverValue {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        if (r10 == 2) goto L5;
        r11[0] = WsConstants.KEY_CONNECTION_TYPE;
    L6:
        r11[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (r10 == 2) goto L9;
        r11[2] = "<init>";
    L11:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L9:
        r11[2] = "replaceType";
        goto L11
    L5:
        r11[0] = "newType";
        goto L6
    }

    public TransientReceiver(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this(r10, null);
    }

    private TransientReceiver(KotlinType r10, ReceiverValue r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        super(r10, r11);
    }

    public String toString() {
        return "{Transient} : " + getType();
    }
}
