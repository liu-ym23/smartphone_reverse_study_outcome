package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes3.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int r10, KDeclarationContainer r11, String r12, String r13) {
        super(r10, CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) r11).getJClass(), r12, r13, !(r11 instanceof KClass) ? 1 : 0);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int r10, Class r11, String r12, String r13, int r14) {
        super(r10, CallableReference.NO_RECEIVER, r11, r12, r13, r14);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int r5, Object r10, Class r11, String r12, String r13, int r14) {
        super(r5, r10, r11, r12, r13, r14);
    }
}
