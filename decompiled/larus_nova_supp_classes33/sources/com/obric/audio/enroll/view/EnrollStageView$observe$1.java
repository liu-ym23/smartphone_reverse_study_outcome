package com.obric.audio.enroll.view;

import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollStageView$observe$1", f = "EnrollStageView.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollStageView$observe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollStageView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ EnrollStageView a;

        public a(EnrollStageView r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            qia.e r5 = (qia.e) r3;
            FLogger.a.i("EnrollStageView", "observe eventBus " + r5);
            if ((r5 instanceof qia.h) == false) goto L6;
            EnrollStageView r6 = this.a;
            Pair<Integer, Integer> r7 = EnrollStageView.e;
            r6.V5(true);
        L9:
            return Unit.INSTANCE;
        L6:
            if ((r5 instanceof qia.j) == false) goto L9;
            EnrollStageView r8 = this.a;
            Pair<Integer, Integer> r9 = EnrollStageView.e;
            r8.V5(false);
            goto L9
        }
    }

    public EnrollStageView$observe$1(EnrollStageView r1, Continuation<? super EnrollStageView$observe$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollStageView$observe$1(this.this$0, r3);
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
        MutableSharedFlow<qia.e> r6 = this.this$0.getViewModel().getEventBus();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
