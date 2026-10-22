package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y1;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.coroutines.jvm.internal.CoroutineStackFrame] */
/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.d<T> {

    @JvmField
    public final CoroutineContext collectContext;

    @JvmField
    public final int collectContextSize;

    @JvmField
    public final kotlinx.coroutines.flow.d<T> collector;
    private Continuation<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(kotlinx.coroutines.flow.d<? super T> r10, CoroutineContext r11) {
        super(l.f10492c, EmptyCoroutineContext.INSTANCE);
        this.collector = r10;
        this.collectContext = r11;
        this.collectContextSize = ((Number) r11.fold(0, SafeCollector$collectContextSize$1.INSTANCE)).intValue();
    }

    private final void checkContext(CoroutineContext r10, CoroutineContext r11, T r12) {
        if ((r11 instanceof g) == false) goto L5;
        exceptionTransparencyViolated((g) r11, r12);
    L5:
        SafeCollector_commonKt.a(this, r10);
    }

    private final Object emit(Continuation<? super Unit> r10, T r11) {
        CoroutineContext r12 = r10.getContext();
        y1.g(r12);
        CoroutineContext r13 = this.lastEmissionContext;
        if (r13 == r12) goto L5;
        checkContext(r12, r13, r11);
        this.lastEmissionContext = r12;
    L5:
        this.completion = r10;
        Function3 r14 = SafeCollectorKt.a();
        kotlinx.coroutines.flow.d<T> r15 = this.collector;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object r16 = r14.invoke(r15, r11, this);
        if (Intrinsics.areEqual(r16, IntrinsicsKt.getCOROUTINE_SUSPENDED()) == true) goto L8;
        this.completion = null;
    L8:
        return r16;
    }

    private final void exceptionTransparencyViolated(g r10, Object r11) {
        throw new IllegalStateException(StringsKt.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + r10.f10490c + ", but then emission attempt of value '" + r11 + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T r10, Continuation<? super Unit> r11) {
        Object r12 = emit(r11, r10);     // Catch: Throwable -> L11
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L7:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r12;
    L10:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        this.lastEmissionContext = new g(th, r11.getContext());
        throw th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> r10 = this.completion;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext r10 = this.lastEmissionContext;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object r10) {
        Throwable r11 = Result.m35exceptionOrNullimpl(r10);
        if (r11 == null) goto L5;
        this.lastEmissionContext = new g(r11, getContext());
    L5:
        Continuation<? super Unit> r12 = this.completion;
        if (r12 == null) goto L9;
        r12.resumeWith(r10);
    L9:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
