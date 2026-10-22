package com.larus.bmhome.chat.component.trace;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.d;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatTraceComponent$sendUpCmd$1", f = "ChatTraceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTraceComponent$sendUpCmd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $conversation;
    final /* synthetic */ boolean $enter;
    int label;

    public ChatTraceComponent$sendUpCmd$1(boolean r1, e r2, Continuation<? super ChatTraceComponent$sendUpCmd$1> r3) {
        this.$enter = r1;
        this.$conversation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTraceComponent$sendUpCmd$1(this.$enter, this.$conversation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        if (this.$enter == false) goto L7;
        NativeConversationServiceImpl r5 = d.d();
        e r1 = this.$conversation;
        r5.enterConversation(r1.a, r1.j, null);
    L9:
        return Unit.INSTANCE;
    L7:
        NativeConversationServiceImpl r6 = d.d();
        e r2 = this.$conversation;
        r6.exitConversation(r2.a, r2.j, null);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
