package com.obric.assistant.component.clicktalk;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.clicktalk.ChatClickTalkComponent$observeDoraGWearState$1", f = "ChatClickTalkComponent.kt", i = {}, l = {1730}, m = "invokeSuspend", n = {}, s = {})
final class ChatClickTalkComponent$observeDoraGWearState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatClickTalkComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatClickTalkComponent a;

        public a(ChatClickTalkComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            vha.a.a r7 = (vha.a) r5;
            if ((r7 instanceof vha.a.a) == false) goto L18;
            FLogger r8 = FLogger.a;
            r8.i("ChatClickTalkComponent", "coWakeupEvent: " + r7);
            ChatClickTalkComponent r0 = this.a;
            DoraWearState r9 = r7.c;
            DoraWearState r2 = r0.o;
            r0.o = r9;
            DoraWearState r3 = DoraWearState.ON;
            if (r9 != r3) goto L18;
            if (r2 == r3) goto L18;
            CoWakeupApi r10 = uha.a.a();
            if (r10 == null) goto L12;
            boolean r4 = true;
            if (r10.c() != true) goto L12;
        L13:
            if (r4 == false) goto L18;
            if (r0.gn() == false) goto L18;
            r8.i("ChatClickTalkComponent", "DoraG wear on, close click talk");
            maa.e.a.a(r0, ExitClickSpeakerType.INTERRUPT, null, false, 6);
        L12:
            r4 = false;
        L18:
            return Unit.INSTANCE;
        }
    }

    public ChatClickTalkComponent$observeDoraGWearState$1(ChatClickTalkComponent r1, Continuation<? super ChatClickTalkComponent$observeDoraGWearState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatClickTalkComponent$observeDoraGWearState$1(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoWakeupApi r6 = uha.a.a();
        if (r6 == null) goto L18;
        MutableSharedFlow r7 = r6.d();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
