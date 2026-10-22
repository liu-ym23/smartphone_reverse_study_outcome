package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes6.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int r8, Class r9, String r10, String r11, int r12) {
        super(r8, NO_RECEIVER, r9, r10, r11, r12);
    }

    public FunctionReferenceImpl(int r1, Object r2, Class r3, String r4, String r5, int r6) {
        super(r1, r2, r3, r4, r5, r6);
    }

    public FunctionReferenceImpl(int r10, KDeclarationContainer r11, String r12, String r13) {
        KDeclarationContainer r14 = (KDeclarationContainer) ZeusTransformUtils.wrapperContextForParams(r11, KDeclarationContainer.class, "com.obric.memorydata.plugin");
        super(r10, NO_RECEIVER, ((ClassBasedDeclarationContainer) ZeusTransformUtils.preCheckCast(r14, ClassBasedDeclarationContainer.class, "com.obric.memorydata.plugin")).getJClass(), r12, r13, !ZeusTransformUtils.instanceOf(r14, KClass.class) ? 1 : 0);
    }
}
