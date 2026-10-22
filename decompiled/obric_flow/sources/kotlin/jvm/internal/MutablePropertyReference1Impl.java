package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes3.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(KDeclarationContainer r10, String r11, String r12) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r10).getJClass(), r11, r12, !(r10 instanceof KClass) ? 1 : 0);
    }

    public Object get(Object r5) {
        return getGetter().call(new Object[]{r5});
    }

    public void set(Object r5, Object r10) {
        getSetter().call(new Object[]{r5, r10});
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(Class r10, String r11, String r12, int r13) {
        super(CallableReference.NO_RECEIVER, r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(Object r5, Class r10, String r11, String r12, int r13) {
        super(r5, r10, r11, r12, r13);
    }
}
