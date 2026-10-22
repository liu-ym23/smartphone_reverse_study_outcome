package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.ActionCreator$buildSearchAction$1$3$question$1", f = "ActionCreator.kt", i = {}, l = {472}, m = "invokeSuspend", n = {}, s = {})
public final class ActionCreator$buildSearchAction$1$3$question$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Message>, Object> {
    final /* synthetic */ Message $msg;
    int label;

    public ActionCreator$buildSearchAction$1$3$question$1(Message r1, Continuation<? super ActionCreator$buildSearchAction$1$3$question$1> r2) {
        this.$msg = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ActionCreator$buildSearchAction$1$3$question$1(this.$msg, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Message> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IChatRepoService r5 = zh8.a.a;
        IChatRepoService r6 = zh8.a.a;
        Message r2 = this.$msg;
        this.label = 1;
        r4 = r6.y1(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
