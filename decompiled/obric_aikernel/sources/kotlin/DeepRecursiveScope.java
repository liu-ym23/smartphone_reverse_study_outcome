package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.7")
@RestrictsSuspension
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
public abstract class DeepRecursiveScope<T, R> {
    private DeepRecursiveScope() {
    }

    public /* synthetic */ DeepRecursiveScope(DefaultConstructorMarker r10) {
        this();
    }

    public abstract Object callRecursive(T r10, Continuation<? super R> r11);

    public abstract <U, S> Object callRecursive(DeepRecursiveFunction<U, S> r10, U r11, Continuation<? super S> r12);

    @Deprecated(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    public final Void invoke(DeepRecursiveFunction<?, ?> r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
