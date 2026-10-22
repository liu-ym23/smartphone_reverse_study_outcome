package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {
    private Continuation<Object> cont;
    private Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function;
    private Object result;
    private Object value;

    /* JADX WARN: Multi-variable type inference failed */
    public DeepRecursiveScopeImpl(Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "block");
        super(null);
        this.function = r10;
        this.value = r11;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = this;
        this.result = DeepRecursiveKt.access$getUNDEFINED_RESULT$p();
    }

    public static final /* synthetic */ void access$setCont$p(DeepRecursiveScopeImpl r10, Continuation r11) {
        r10.cont = r11;
    }

    public static final /* synthetic */ void access$setFunction$p(DeepRecursiveScopeImpl r10, Function3 r11) {
        r10.function = r11;
    }

    public static final /* synthetic */ void access$setResult$p(DeepRecursiveScopeImpl r10, Object r11) {
        r10.result = r11;
    }

    private final Continuation<Object> crossFunctionCompletion(final Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> r10, final Continuation<Object> r11) {
        final EmptyCoroutineContext r12 = EmptyCoroutineContext.INSTANCE;
        return new DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1(r12, this, r10, r11);
    }

    @Override // kotlin.DeepRecursiveScope
    public Object callRecursive(T r10, Continuation<? super R> r11) {
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = r11;
        this.value = r10;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r12;
    }

    @Override // kotlin.DeepRecursiveScope
    public <U, S> Object callRecursive(DeepRecursiveFunction<U, S> r10, U r11, Continuation<? super S> r12) {
        Function3<DeepRecursiveScope<U, S>, U, Continuation<? super S>, Object> r13 = r10.getBlock$kotlin_stdlib();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> r14 = this.function;
        if (r13 == r14) goto L5;
        this.function = r13;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = crossFunctionCompletion(r14, r12);
    L6:
        this.value = r11;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L9:
        return r15;
    L5:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = r12;
        goto L6
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        this.cont = null;
        this.result = r10;
    }

    public final R runCallLoop() {
    L2:
        R r10 = (R) this.result;
        Continuation<Object> r11 = this.cont;
        if (r11 == null) goto L4;
        if (Result.m34equalsimpl0(DeepRecursiveKt.access$getUNDEFINED_RESULT$p(), r10) == false) goto L18;
        Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> r12 = this.function;     // Catch: Throwable -> L15
        Object r13 = this.value;     // Catch: Throwable -> L15
        if ((r12 instanceof BaseContinuationImpl) == true) goto L11;
        Object r14 = IntrinsicsKt.wrapWithContinuationImpl(r12, this, r13, r11);     // Catch: Throwable -> L15
    L13:
        if (r14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L2;
        Result.Companion r15 = Result.Companion;
    L17:
        r10 = (R) Result.m32constructorimpl(r14);
    L19:
        r11.resumeWith(r10);
        goto L2
    L11:
        r14 = ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 3)).invoke(this, r13, r11);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = ResultKt.createFailure(th);
        goto L17
    L18:
        this.result = DeepRecursiveKt.access$getUNDEFINED_RESULT$p();
        goto L19
    L4:
        ResultKt.throwOnFailure(r10);
        return r10;
    }
}
