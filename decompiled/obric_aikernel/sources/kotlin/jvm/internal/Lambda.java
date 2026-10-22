package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int r10) {
        this.arity = r10;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String r10 = Reflection.renderLambdaToString(this);
        Intrinsics.checkNotNullExpressionValue(r10, "renderLambdaToString(this)");
        return r10;
    }
}
