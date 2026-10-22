package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.ActionCreator$buildSearchAction$1$4", f = "ActionCreator.kt", i = {}, l = {492}, m = "invokeSuspend", n = {}, s = {})
final class ActionCreator$buildSearchAction$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ z this$0;

    public ActionCreator$buildSearchAction$1$4(Message r1, z r2, Continuation<? super ActionCreator$buildSearchAction$1$4> r3) {
        this.$msg = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ActionCreator$buildSearchAction$1$4(this.$msg, this.this$0, r4);
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
        String r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        Message r9 = (Message) r8;
        if (r9 == null) goto L27;
        String r10 = r9.getContent();
        if (r10 == null) goto L27;
        z r3 = this.this$0;
        gd8.g r4 = r3.e.h2();
        if (r4 == null) goto L21;
        com.larus.bmhome.chat.component.cvs.y r5 = r3.e.u0();
        if (r5 == null) goto L20;
        r2 = r5.Y1();
    L20:
        r4.ou(r2, r10);
    L21:
        com.larus.bmhome.chat.api.q0 r11 = r3.a;
        if (r11 == null) goto L27;
        ChatMessageList r6 = r11.B7();
        if (r6 == null) goto L27;
        b0$a.a(r6, false, 0, null, null, 0, 30);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r12 = Dispatchers.getIO();
        ActionCreator$buildSearchAction$1$4$question$1 r7 = new ActionCreator$buildSearchAction$1$4$question$1(this.$msg, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r12, r7, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
