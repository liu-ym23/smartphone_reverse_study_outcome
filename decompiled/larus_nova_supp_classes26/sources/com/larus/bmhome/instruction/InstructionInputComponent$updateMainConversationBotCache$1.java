package com.larus.bmhome.instruction;

import com.bytedance.keva.Keva;
import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$updateMainConversationBotCache$1", f = "InstructionInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$updateMainConversationBotCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$updateMainConversationBotCache$1(InstructionInputComponent r1, BotModel r2, Continuation<? super InstructionInputComponent$updateMainConversationBotCache$1> r3) {
        this.this$0 = r1;
        this.$botModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        InstructionInputComponent$updateMainConversationBotCache$1 r0 = new InstructionInputComponent$updateMainConversationBotCache$1(this.this$0, this.$botModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r3);
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        InstructionInputComponent r5 = this.this$0;
        BotModel r0 = this.$botModel;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(r5.y.toJson(r0));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r6) == false) goto L12;
        r6 = null;
    L12:
        String r7 = (String) r6;
        if (r7 == null) goto L16;
        InstructionInputComponent r2 = this.this$0;
        String r8 = InstructionInputComponent.Z2;
        ((Keva) r2.z.getValue()).storeString("cached_main_bot_model", r7);
    L16:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
