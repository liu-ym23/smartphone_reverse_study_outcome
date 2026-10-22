package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,426:1\n329#2:427\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n*L\n417#1:427\n*E\n"})
public final class SubscribedFlowCollector<T> implements d<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d<T> f10458c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function2<d<? super T>, Continuation<? super Unit>, Object> f10459g;

    public final Object a(Continuation<? super Unit> r10) {
        if ((r10 instanceof SubscribedFlowCollector$onSubscription$1) == false) goto L7;
        SubscribedFlowCollector$onSubscription$1 r11 = (SubscribedFlowCollector$onSubscription$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L20;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SafeCollector r16 = (SafeCollector) r11.L$1;
        SubscribedFlowCollector<T> r17 = (SubscribedFlowCollector) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L18
    L25:
        r16.releaseIntercepted();
        d<T> r18 = r17.f10458c;
        if ((r18 instanceof SubscribedFlowCollector) == false) goto L33;
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 2;
        if (((SubscribedFlowCollector) r18).a(r11) != r14) goto L31;
        return r14;
    L33:
        return Unit.INSTANCE;
    L18:
        Throwable th = th;
    L36:
        r16.releaseIntercepted();
        throw th;
    L20:
        ResultKt.throwOnFailure(r13);
        SafeCollector r19 = new SafeCollector(this.f10458c, r11.getContext());
        Function2<d<? super T>, Continuation<? super Unit>, Object> r20 = this.f10459g;     // Catch: Throwable -> L34
        r11.L$0 = this;     // Catch: Throwable -> L34
        r11.L$1 = r19;     // Catch: Throwable -> L34
        r11.label = 1;     // Catch: Throwable -> L34
        if (r20.invoke(r19, r11) != r14) goto L24;
        return r14;
    L24:
        r17 = this;
        r16 = r19;
    L34:
        th = move-exception;
        th = th;
        r16 = r19;
    L7:
        r11 = new SubscribedFlowCollector$onSubscription$1(this, r10);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T r10, Continuation<? super Unit> r11) {
        return this.f10458c.emit(r10, r11);
    }
}
