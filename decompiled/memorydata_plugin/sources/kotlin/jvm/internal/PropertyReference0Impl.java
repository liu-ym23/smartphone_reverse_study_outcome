package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes6.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(Class r7, String r8, String r9, int r10) {
        super(NO_RECEIVER, r7, r8, r9, r10);
    }

    public PropertyReference0Impl(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }

    public PropertyReference0Impl(KDeclarationContainer r9, String r10, String r11) {
        KDeclarationContainer r12 = (KDeclarationContainer) ZeusTransformUtils.wrapperContextForParams(r9, KDeclarationContainer.class, "com.obric.memorydata.plugin");
        super(NO_RECEIVER, ((ClassBasedDeclarationContainer) ZeusTransformUtils.preCheckCast(r12, ClassBasedDeclarationContainer.class, "com.obric.memorydata.plugin")).getJClass(), r10, r11, !ZeusTransformUtils.instanceOf(r12, KClass.class) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return getGetter().call(new Object[0]);
    }
}
