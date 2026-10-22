package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return mo358getGetter().call(new Object[0]);
    }

    public PropertyReference0Impl(KDeclarationContainer r7, String r8, String r9) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r7).getJClass(), r8, r9, !(r7 instanceof KClass) ? 1 : 0);
    }

    public PropertyReference0Impl(Class r7, String r8, String r9, int r10) {
        super(CallableReference.NO_RECEIVER, r7, r8, r9, r10);
    }

    public PropertyReference0Impl(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }
}
