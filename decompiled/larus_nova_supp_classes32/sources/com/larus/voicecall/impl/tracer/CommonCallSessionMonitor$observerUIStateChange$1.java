package com.larus.voicecall.impl.tracer;

import com.obric.aivoice.core.data.NameKeys;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.CommonCallSessionMonitor$observerUIStateChange$1", f = "CommonCallSessionMonitor.kt", i = {}, l = {337, 342}, m = "invokeSuspend", n = {}, s = {})
final class CommonCallSessionMonitor$observerUIStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonCallSessionMonitor<com.larus.audio.call.arch.c> this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CommonCallSessionMonitor<com.larus.audio.call.arch.c> a;
        public final /* synthetic */ Ref.IntRef b;

        public a(CommonCallSessionMonitor<com.larus.audio.call.arch.c> r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            CommonCallSessionMonitor<com.larus.audio.call.arch.c> r6 = this.a;
            Ref.IntRef r0 = this.b;
            r6.G = r0.element;
            r0.element = r5;
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ CommonCallSessionMonitor<com.larus.audio.call.arch.c> a;

        public b(CommonCallSessionMonitor<com.larus.audio.call.arch.c> r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            Pair r3 = (Pair) r1;
            int r4 = ((Number) r3.component1()).intValue();
            ((Number) r3.component2()).intValue();
            this.a.G = r4;
            return Unit.INSTANCE;
        }
    }

    public CommonCallSessionMonitor$observerUIStateChange$1(CommonCallSessionMonitor<com.larus.audio.call.arch.c> r1, Continuation<? super CommonCallSessionMonitor$observerUIStateChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonCallSessionMonitor$observerUIStateChange$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        ResultKt.throwOnFailure(r6);
    L21:
        throw new KotlinNothingValueException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r6);
        if (com.larus.audio.call.f.f() == false) goto L17;
        Ref.IntRef r7 = new Ref.IntRef();
        r7.element = -1;
        final i1 r2 = d3a.a.c(this.this$0.getContext()).y();
        Flow r3 = kotlinx.coroutines.flow.e.n(new CommonCallSessionMonitor$observerUIStateChange$1$invokeSuspend$$inlined$map$1(r2));
        a r4 = new a(this.this$0, r7);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L16;
        return r0;
    L17:
        MutableSharedFlow r8 = d3a.a.c(this.this$0.getContext()).i1();
        b r5 = new b(this.this$0);
        this.label = 2;
        if (r8.collect(r5, this) != r0) goto L21;
        return r0;
    }
}
