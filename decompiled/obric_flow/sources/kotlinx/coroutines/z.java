package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public static final y Key = null;

    static {
        Key = new y(ContinuationInterceptor.Key, new com.bytedance.ai.model.m(16));
    }

    public z() {
        super(ContinuationInterceptor.Key);
    }

    public static /* synthetic */ z limitedParallelism$default(z r5, int r10, String r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = null;
    L7:
        return r5.limitedParallelism(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
    }

    public abstract void dispatch(CoroutineContext r5, Runnable r10);

    public void dispatchYield(CoroutineContext r5, Runnable r10) {
        dispatch(r5, r10);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r5) {
        return (E) ContinuationInterceptor.DefaultImpls.get(this, r5);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> r5) {
        return new kotlinx.coroutines.internal.e(this, r5);
    }

    public boolean isDispatchNeeded(CoroutineContext r5) {
        return true;
    }

    public z limitedParallelism(int r5, String r10) {
        kotlinx.coroutines.internal.f.c(r5);
        return new kotlinx.coroutines.internal.g(this, r5, r10);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r5) {
        return ContinuationInterceptor.DefaultImpls.minusKey(this, r5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    public final z plus(z r5) {
        return r5;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void releaseInterceptedContinuation(Continuation<?> r5) {
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        kotlinx.coroutines.internal.e r10 = (kotlinx.coroutines.internal.e) r5;
        r10.getClass();
    L3:
        AtomicReferenceFieldUpdater r11 = kotlinx.coroutines.internal.e.f18931h;
        if (r11.get(r10) == kotlinx.coroutines.internal.f.f18933b) goto L3;
        Object r12 = r11.get(r10);
        if ((r12 instanceof l) == false) goto L8;
        l r13 = (l) r12;
    L9:
        if (r13 == null) goto L14;
        r13.r();
        return;
    L14:
        return;
    L8:
        r13 = null;
        goto L9
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + j0.f(this);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated for good. Override 'limitedParallelism(parallelism: Int, name: String?)' instead", replaceWith = @ReplaceWith(expression = "limitedParallelism(parallelism, null)", imports = {}))
    public /* synthetic */ z limitedParallelism(int r5) {
        return limitedParallelism(r5, null);
    }
}
