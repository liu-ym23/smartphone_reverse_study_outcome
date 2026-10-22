package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes3.dex */
public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;

    @SinceKotlin(version = "1.4")
    private final int flags;

    public FunctionReference(int r10) {
        this(r10, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    public KCallable computeReflected() {
        return Reflection.function(this);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof FunctionReference) == false) goto L23;
        FunctionReference r10 = (FunctionReference) r5;
        if (getName().equals(r10.getName()) == false) goto L21;
        if (getSignature().equals(r10.getSignature()) == false) goto L21;
        if (this.flags != r10.flags) goto L21;
        if (this.arity != r10.arity) goto L21;
        if (Intrinsics.areEqual(getBoundReceiver(), r10.getBoundReceiver()) == false) goto L21;
        if (Intrinsics.areEqual(getOwner(), r10.getOwner()) == false) goto L21;
        return true;
    L21:
        return false;
    L23:
        if ((r5 instanceof KFunction) == true) goto L25;
        return false;
    L25:
        return r5.equals(compute());
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public int hashCode() {
        if (getOwner() != null) goto L5;
        int r5 = 0;
    L6:
        int r10 = (getName().hashCode() + r5) * 31;
        return getSignature().hashCode() + r10;
    L5:
        r5 = getOwner().hashCode() * 31;
        goto L6
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    @SinceKotlin(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable r5 = compute();
        if (r5 == this) goto L7;
        return r5.toString();
    L7:
        if ("<init>".equals(getName()) == false) goto L10;
        return "constructor (Kotlin reflection is not available)";
    L10:
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @SinceKotlin(version = "1.1")
    public FunctionReference(int r10, Object r11) {
        this(r10, r11, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    @SinceKotlin(version = "1.4")
    public FunctionReference(int r10, Object r11, Class r12, String r13, String r14, int r15) {
        if ((r15 & 1) != 1) goto L5;
        boolean r16 = true;
    L6:
        super(r11, r12, r13, r14, r16);
        this.arity = r10;
        this.flags = r15 >> 1;
        return;
    L5:
        r16 = false;
        goto L6
    }
}
