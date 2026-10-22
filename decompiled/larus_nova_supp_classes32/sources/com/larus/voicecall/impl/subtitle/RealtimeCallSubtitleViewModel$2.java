package com.larus.voicecall.impl.subtitle;

import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleViewModel$2", f = "RealtimeCallSubtitleViewModel.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallSubtitleViewModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Integer> $callStateFlow;
    int label;
    final /* synthetic */ q0 this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ q0 a;

        public a(q0 r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            int r4 = ((Number) r2).intValue();
            AtomicBoolean r5 = this.a.z;
            if (r4 != 7) goto L5;
            boolean r6 = true;
        L6:
            r5.set(r6);
            return Unit.INSTANCE;
        L5:
            r6 = false;
            goto L6
        }
    }

    public RealtimeCallSubtitleViewModel$2(Flow<Integer> r1, q0 r2, Continuation<? super RealtimeCallSubtitleViewModel$2> r3) {
        this.$callStateFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeCallSubtitleViewModel$2(this.$callStateFlow, this.this$0, r4);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Flow<Integer> r6 = this.$callStateFlow;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
