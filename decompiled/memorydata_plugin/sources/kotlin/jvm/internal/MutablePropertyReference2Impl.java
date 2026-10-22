package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes6.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(Class r1, String r2, String r3, int r4) {
        super(r1, r2, r3, r4);
    }

    public MutablePropertyReference2Impl(KDeclarationContainer r3, String r4, String r5) {
        KDeclarationContainer r6 = (KDeclarationContainer) ZeusTransformUtils.wrapperContextForParams(r3, KDeclarationContainer.class, "com.obric.memorydata.plugin");
        super(((ClassBasedDeclarationContainer) ZeusTransformUtils.preCheckCast(r6, ClassBasedDeclarationContainer.class, "com.obric.memorydata.plugin")).getJClass(), r4, r5, !ZeusTransformUtils.instanceOf(r6, KClass.class) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty2
    public Object get(Object r3, Object r4) {
        return getGetter().call(new Object[]{r3, r4});
    }

    @Override // kotlin.reflect.KMutableProperty2
    public void set(Object r3, Object r4, Object r5) {
        getSetter().call(new Object[]{r3, r4, r5});
    }
}
