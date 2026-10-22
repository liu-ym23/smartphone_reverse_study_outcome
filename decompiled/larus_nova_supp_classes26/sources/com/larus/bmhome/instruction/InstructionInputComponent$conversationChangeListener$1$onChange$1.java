package com.larus.bmhome.instruction;

import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$conversationChangeListener$1$onChange$1", f = "InstructionInputComponent.kt", i = {}, l = {1084}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$conversationChangeListener$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$conversationChangeListener$1$onChange$1(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$conversationChangeListener$1$onChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$conversationChangeListener$1$onChange$1(this.this$0, r3);
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
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        InstructionInputComponent r6 = this.this$0;
        String r2 = InstructionInputComponent.Z2;
        com.larus.bmhome.chat.component.cvs.y r7 = r6.u0();
        if (r7 == null) goto L20;
        wc9.e r8 = r7.h();
        if (r8 == null) goto L20;
        InstructionInputComponent r3 = this.this$0;
        com.larus.bmhome.chat.component.cvs.y r4 = r3.u0();
        if (r4 == null) goto L15;
        BotModel r9 = r4.j0();
    L16:
        this.label = 1;
        if (InstructionInputComponent.h3(r3, r8, r9, this) != r0) goto L20;
        return r0;
    L15:
        r9 = null;
        goto L16
    }
}
