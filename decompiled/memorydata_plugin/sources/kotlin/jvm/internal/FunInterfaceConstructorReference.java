package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes6.dex */
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    public FunInterfaceConstructorReference(Class r2) {
        super(1);
        this.funInterface = r2;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, FunInterfaceConstructorReference.class) == true) goto L10;
        return false;
    L10:
        FunInterfaceConstructorReference r4 = (FunInterfaceConstructorReference) ZeusTransformUtils.preCheckCast(r3, FunInterfaceConstructorReference.class, "com.obric.memorydata.plugin");
        return this.funInterface.equals(r4.funInterface);
    }

    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }
}
