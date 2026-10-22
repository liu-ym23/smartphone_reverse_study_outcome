package com.larus.voicecall.impl.continue_talk;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin$onStart$1", f = "ChatContinuousTalkComponentViewModel.kt", i = {}, l = {702, 704}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin a;

        public a(ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            int r3 = ((Number) r1).intValue();
            ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin.j3(this.a, r3);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin a;

        public b(ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            int r3 = ((Number) ((Pair) r1).component2()).intValue();
            ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin.j3(this.a, r3);
            return Unit.INSTANCE;
        }
    }

    public ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin$onStart$1(ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin r1, Continuation<? super ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin$onStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin$onStart$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        ResultKt.throwOnFailure(r5);
    L21:
        throw new KotlinNothingValueException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r5);
        if (com.larus.audio.call.f.f() == false) goto L17;
        final kotlinx.coroutines.flow.i1 r6 = d3a.a.c(this.this$0.getContext()).y();
        Flow r7 = kotlinx.coroutines.flow.e.n(new ChatContinuousTalkComponentViewModel$ContinuousTalkComponentBizPlugin$onStart$1$invokeSuspend$$inlined$map$1(r6));
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L17:
        MutableSharedFlow r8 = d3a.a.c(this.this$0.getContext()).i1();
        b r3 = new b(this.this$0);
        this.label = 2;
        if (r8.collect(r3, this) != r0) goto L21;
        return r0;
    }
}
