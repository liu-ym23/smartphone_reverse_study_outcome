package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes3.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(KDeclarationContainer r5, String r10, String r11) {
        super(((ClassBasedDeclarationContainer) r5).getJClass(), r10, r11, !(r5 instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty2
    public Object get(Object r5, Object r10) {
        return getGetter().call(new Object[]{r5, r10});
    }

    @Override // kotlin.reflect.KMutableProperty2
    public void set(Object r5, Object r10, Object r11) {
        getSetter().call(new Object[]{r5, r10, r11});
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference2Impl(Class r5, String r10, String r11, int r12) {
        super(r5, r10, r11, r12);
    }
}
