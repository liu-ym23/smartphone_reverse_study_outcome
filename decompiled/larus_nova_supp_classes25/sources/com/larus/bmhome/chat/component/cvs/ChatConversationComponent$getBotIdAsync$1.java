package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$getBotIdAsync$1", f = "ChatConversationComponent.kt", i = {}, l = {571}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$getBotIdAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onResultMayRunInIOThread;
    int label;
    final /* synthetic */ ChatConversationComponent this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatConversationComponent$getBotIdAsync$1(ChatConversationComponent r1, Function1<? super String, Unit> r2, Continuation<? super ChatConversationComponent$getBotIdAsync$1> r3) {
        this.this$0 = r1;
        this.$onResultMayRunInIOThread = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatConversationComponent$getBotIdAsync$1(this.this$0, this.$onResultMayRunInIOThread, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L13:
        List r5 = (List) r4;
        if (r5 == null) goto L19;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L19;
        this.$onResultMayRunInIOThread.invoke(r6);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ChatConversationComponent r7 = this.this$0;
        int r2 = ChatConversationComponent.r;
        e r8 = r7.F2().getState().getConversation();
        if (r8 == null) goto L19;
        this.label = 1;
        r4 = ic8.n.c(r8, this);
        if (r4 != r0) goto L13;
        return r0;
    }
}
