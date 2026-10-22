package com.larus.voicecall.impl.continue_talk;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.obric.aivoice.core.data.NameKeys;
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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponentViewModel$listenOnCallStateChange$1", f = "ChatContinuousTalkComponentViewModel.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponentViewModel$listenOnCallStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ChatContinuousTalkComponentViewModel this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatContinuousTalkComponentViewModel a;
        public final /* synthetic */ Context b;

        public a(ChatContinuousTalkComponentViewModel r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            final int r5 = ((Number) r3).intValue();
            FLogger.a.d("ChatContinuousTalkComponentViewModel", "new state: " + r5 + " current:" + this.a.getState());
            if (r5 != 14) goto L5;
            ChatContinuousTalkComponentViewModel.access$setMute$p(this.a, true);
        L9:
            ChatContinuousTalkComponentViewModel.access$setState(this.a, new h1(r5));
            ChatContinuousTalkComponentViewModel.access$updateNotification(this.a, r5, this.b);
            return Unit.INSTANCE;
        L5:
            if (r5 == 15) goto L7;
            ChatContinuousTalkComponentViewModel.access$setCurrentState$p(this.a, r5);
            goto L9
        L7:
            ChatContinuousTalkComponentViewModel.access$setMute$p(this.a, false);
            goto L9
        }
    }

    public ChatContinuousTalkComponentViewModel$listenOnCallStateChange$1(ChatContinuousTalkComponentViewModel r1, Context r2, Continuation<? super ChatContinuousTalkComponentViewModel$listenOnCallStateChange$1> r3) {
        this.this$0 = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatContinuousTalkComponentViewModel$listenOnCallStateChange$1(this.this$0, this.$context, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        RealtimeCallService r7 = ChatContinuousTalkComponentViewModel.access$getRealtimeCallService$p(this.this$0);
        if (r7 == null) goto L18;
        MutableSharedFlow r8 = ((com.larus.audio.call.a) r7).k;
        if (r8 == null) goto L18;
        a r2 = new a(this.this$0, this.$context);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
