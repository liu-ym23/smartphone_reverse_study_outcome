package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.helper.a3;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$getBotInfo$1", f = "PromptCell.kt", i = {}, l = {1356}, m = "invokeSuspend", n = {}, s = {})
public final class PromptCell$getBotInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ boolean $preLoad;
    final /* synthetic */ String $requestId;
    int label;
    final /* synthetic */ PromptCell this$0;

    public PromptCell$getBotInfo$1(PromptCell r1, String r2, boolean r3, String r4, Continuation<? super PromptCell$getBotInfo$1> r5) {
        this.this$0 = r1;
        this.$botId = r2;
        this.$preLoad = r3;
        this.$requestId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PromptCell$getBotInfo$1(this.this$0, this.$botId, this.$preLoad, this.$requestId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        PromptCell r9 = this.this$0;
        a3 r2 = r9.Q;
        String r3 = this.$botId;
        t0 r6 = new t0(this.$preLoad, r3, r9, this.$requestId);
        this.label = 1;
        if (r2.a(r3, r6, this) != r0) goto L12;
        return r0;
    }
}
