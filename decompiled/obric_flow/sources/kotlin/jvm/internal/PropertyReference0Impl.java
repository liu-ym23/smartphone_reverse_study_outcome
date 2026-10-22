package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(KDeclarationContainer r10, String r11, String r12) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r10).getJClass(), r11, r12, !(r10 instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0Impl(Class r10, String r11, String r12, int r13) {
        super(CallableReference.NO_RECEIVER, r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference0Impl(Object r5, Class r10, String r11, String r12, int r13) {
        super(r5, r10, r11, r12, r13);
    }
}
