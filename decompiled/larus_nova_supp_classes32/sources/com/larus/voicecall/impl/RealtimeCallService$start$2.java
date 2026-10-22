package com.larus.voicecall.impl;

import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.f;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.plugins.c1;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.RealtimeCallService$start$2", f = "RealtimeCallService.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallService$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallService this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallService a;

        public a(RealtimeCallService r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            Pair r5 = (Pair) r3;
            AVKitDuplexState r6 = (AVKitDuplexState) r5.component1();
            int r7 = ((Number) r5.component2()).intValue();
            RealtimeCallService r0 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "duplex");
            if (Intrinsics.areEqual(r6, ((Pair) ((com.larus.audio.call.a) r0).n.getValue()).getFirst()) == true) goto L5;
        L6:
            ((com.larus.audio.call.a) r0).n.setValue(TuplesKt.to(r6, Integer.valueOf(r7)));
        L8:
            if (f.f() == false) goto L11;
            RealtimeCallService r8 = this.a;
            r8.f(r8.o().s1(), r7);
        L11:
            return Unit.INSTANCE;
        L5:
            if (r7 == ((Number) ((Pair) ((com.larus.audio.call.a) r0).n.getValue()).getSecond()).intValue()) goto L8;
            goto L6
        }
    }

    public RealtimeCallService$start$2(RealtimeCallService r1, Continuation<? super RealtimeCallService$start$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallService$start$2(this.this$0, r3);
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
        i1 r6 = LLMCallController.w(this.this$0.u, Reflection.getOrCreateKotlinClass(c1.class)).y();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
