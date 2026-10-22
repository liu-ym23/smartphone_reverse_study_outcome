package com.larus.bmhome.clarification;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationComponent$installInputStatusObserver$1", f = "ClarificationComponent.kt", i = {}, l = {1892}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationComponent$installInputStatusObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.i1<Integer> $statusFlow;
    int label;
    final /* synthetic */ ClarificationComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ClarificationComponent a;

        public a(ClarificationComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            d2 r6 = this.a.n.a;
            if (r6 == null) goto L24;
            ze8.b r0 = r6.k;
            if (r0 != null) goto L9;
            return Unit.INSTANCE;
        L9:
            if (r0.c() == true) goto L23;
            if (r0.f() == true) goto L23;
            final boolean r1 = true;
            if (r5 != 1) goto L16;
        L20:
            r1 = false;
        L21:
            this.a.n.d(r6.j, new t1(r1));
            return Unit.INSTANCE;
        L16:
            if (r5 == 2) goto L21;
            if (r5 == 3) goto L20;
            return Unit.INSTANCE;
        L23:
            return Unit.INSTANCE;
        L24:
            return Unit.INSTANCE;
        }
    }

    public ClarificationComponent$installInputStatusObserver$1(kotlinx.coroutines.flow.i1<Integer> r1, ClarificationComponent r2, Continuation<? super ClarificationComponent$installInputStatusObserver$1> r3) {
        this.$statusFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ClarificationComponent$installInputStatusObserver$1(this.$statusFlow, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.i1<Integer> r6 = this.$statusFlow;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
