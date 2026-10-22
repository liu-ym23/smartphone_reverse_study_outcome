package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements FunctionBase<Object>, SuspendFunction {
    private final int arity;

    public RestrictedSuspendLambda(int r10) {
        this(r10, null);
    }

    public RestrictedSuspendLambda(int r10, Continuation<Object> r11) {
        super(r11);
        this.arity = r10;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) goto L6;
        String r10 = Reflection.renderLambdaToString(this);
        Intrinsics.checkNotNullExpressionValue(r10, "renderLambdaToString(this)");
        return r10;
    L6:
        return super.toString();
    }
}
