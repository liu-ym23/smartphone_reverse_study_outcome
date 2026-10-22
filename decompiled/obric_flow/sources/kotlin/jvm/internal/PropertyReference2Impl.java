package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(KDeclarationContainer r5, String r10, String r11) {
        super(((ClassBasedDeclarationContainer) r5).getJClass(), r10, r11, !(r5 instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty2
    public Object get(Object r5, Object r10) {
        return getGetter().call(new Object[]{r5, r10});
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference2Impl(Class r5, String r10, String r11, int r12) {
        super(r5, r10, r11, r12);
    }
}
