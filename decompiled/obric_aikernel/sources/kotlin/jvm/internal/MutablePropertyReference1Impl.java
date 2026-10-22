package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes2.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(Class r10, String r11, String r12, int r13) {
        super(CallableReference.NO_RECEIVER, r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(Object r10, Class r11, String r12, String r13, int r14) {
        super(r10, r11, r12, r13, r14);
    }

    public MutablePropertyReference1Impl(KDeclarationContainer r10, String r11, String r12) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r10).getJClass(), r11, r12, !(r10 instanceof KClass) ? 1 : 0);
    }

    public Object get(Object r10) {
        return getGetter().call(new Object[]{r10});
    }

    public void set(Object r10, Object r11) {
        getSetter().call(new Object[]{r10, r11});
    }
}
