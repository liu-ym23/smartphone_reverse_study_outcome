package com.larus.bmhome.chat.component.title;

import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/model/EditPos;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$getEditPosFromBotModel$2", f = "ChatTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleComponent$getEditPosFromBotModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EditPos>, Object> {
    final /* synthetic */ BotModel $new;
    int label;

    public ChatTitleComponent$getEditPosFromBotModel$2(BotModel r1, Continuation<? super ChatTitleComponent$getEditPosFromBotModel$2> r2) {
        this.$new = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatTitleComponent$getEditPosFromBotModel$2(this.$new, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super EditPos> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        Gson r4 = new Gson();
        BotModel r0 = this.$new;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl((EditPos) r4.fromJson(r0.getEditPos(), EditPos.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L12;
        r5 = null;
    L12:
        EditPos r6 = (EditPos) r5;
        if (r6 == null) goto L15;
        return r6;
    L15:
        return new EditPos(0);
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
