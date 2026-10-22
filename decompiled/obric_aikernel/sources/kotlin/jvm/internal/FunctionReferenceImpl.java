package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes2.dex */
public class FunctionReferenceImpl extends FunctionReference {
    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int r10, Class r11, String r12, String r13, int r14) {
        super(r10, CallableReference.NO_RECEIVER, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int r10, Object r11, Class r12, String r13, String r14, int r15) {
        super(r10, r11, r12, r13, r14, r15);
    }

    public FunctionReferenceImpl(int r10, KDeclarationContainer r11, String r12, String r13) {
        super(r10, CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r11).getJClass(), r12, r13, !(r11 instanceof KClass) ? 1 : 0);
    }
}
