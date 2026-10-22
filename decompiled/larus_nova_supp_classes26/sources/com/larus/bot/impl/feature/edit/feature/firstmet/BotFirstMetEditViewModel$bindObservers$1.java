package com.larus.bot.impl.feature.edit.feature.firstmet;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.firstmet.BotFirstMetEditViewModel$bindObservers$1", f = "BotFirstMetEditViewModel.kt", i = {}, l = {424}, m = "invokeSuspend", n = {}, s = {})
final class BotFirstMetEditViewModel$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotFirstMetEditViewModel this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BotFirstMetEditViewModel a;

        public a(BotFirstMetEditViewModel r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            Unit r13 = (Unit) r11;
            boolean r14 = true;
            if (((n) this.a.d.getValue()).c != 1) goto L5;
            this.a.i(m.e.a);
        L23:
            return Unit.INSTANCE;
        L5:
            String r15 = this.a.a().getPrologue();
            if (r15 != null) goto L8;
        L11:
            if (r14 == false) goto L13;
        L21:
            BotFirstMetEditViewModel.h(this.a, false, 1, false, null, false, false, 251);
            goto L23
        L13:
            if (this.a.g() == false) goto L21;
            SpeakerVoice r16 = this.a.a().getVoice();
            if (r16 == null) goto L23;
            BotFirstMetEditViewModel r17 = this.a;
            String r1 = r17.a().getPrologue();
            if (r1 != null) goto L20;
            r1 = "";
        L20:
            r17.i(new m.a(r1, r16));
            goto L23
        L8:
            if (StringsKt.isBlank(r15) == true) goto L11;
            r14 = false;
            goto L11
        }
    }

    public BotFirstMetEditViewModel$bindObservers$1(BotFirstMetEditViewModel r1, Continuation<? super BotFirstMetEditViewModel$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotFirstMetEditViewModel$bindObservers$1(this.this$0, r3);
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
        MutableSharedFlow<Unit> r6 = this.this$0.g;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        FlowKt__EmittersKt$onStart$.inlined.unsafeFlow.1 r7 = new com.larus.bot.impl.common.util.f(r6).d;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
