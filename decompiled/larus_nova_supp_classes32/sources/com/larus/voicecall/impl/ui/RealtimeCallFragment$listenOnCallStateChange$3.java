package com.larus.voicecall.impl.ui;

import com.larus.audio.call.mgr.MajorState;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallFragment$listenOnCallStateChange$3", f = "RealtimeCallFragment.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallFragment$listenOnCallStateChange$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallFragment a;

        public a(RealtimeCallFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            Pair r8 = (Pair) r6;
            MajorState r9 = (MajorState) r8.component1();
            int r10 = ((Number) r8.component2()).intValue();
            Pair<? extends MajorState, Integer> r0 = this.a.q;
            MajorState r1 = (MajorState) r0.component1();
            int r2 = ((Number) r0.component2()).intValue();
            FLogger.a.i("RealtimeCallFragment", "[CALL] Fragment state change: (" + r1 + ", " + r2 + ") -> (" + r9 + ", " + r10 + ')');
            this.a.q = TuplesKt.to(r9, Boxing.boxInt(r10));
            if (com.larus.audio.call.f.f() == true) goto L6;
            RealtimeCallFragment.S90(this.a, r9, r10);
        L6:
            return Unit.INSTANCE;
        }
    }

    public RealtimeCallFragment$listenOnCallStateChange$3(RealtimeCallFragment r1, Continuation<? super RealtimeCallFragment$listenOnCallStateChange$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallFragment$listenOnCallStateChange$3(this.this$0, r3);
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
        RealtimeCallFragment r6 = this.this$0;
        int r2 = RealtimeCallFragment.r;
        MutableSharedFlow r7 = ((com.larus.audio.call.a) r6.U90()).m;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
