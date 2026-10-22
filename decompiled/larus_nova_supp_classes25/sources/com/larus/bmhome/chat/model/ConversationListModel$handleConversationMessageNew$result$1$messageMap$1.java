package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/larus/im/bean/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$handleConversationMessageNew$result$1$messageMap$1", f = "ConversationListModel.kt", i = {}, l = {1147}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationListModel$handleConversationMessageNew$result$1$messageMap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Message>>, Object> {
    final /* synthetic */ Set<String> $localMessageIds;
    final /* synthetic */ ConversationListModel $this_runCatching;
    int label;

    public ConversationListModel$handleConversationMessageNew$result$1$messageMap$1(ConversationListModel r1, Set<String> r2, Continuation<? super ConversationListModel$handleConversationMessageNew$result$1$messageMap$1> r3) {
        this.$this_runCatching = r1;
        this.$localMessageIds = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ConversationListModel$handleConversationMessageNew$result$1$messageMap$1(this.$this_runCatching, this.$localMessageIds, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, Message>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L13:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ConversationListModel r6 = this.$this_runCatching;
        Set<String> r2 = this.$localMessageIds;
        this.label = 1;
        ConversationListModel r3 = ConversationListModel.a;
        r6.getClass();
        kotlinx.coroutines.j r7 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r7.C();
        com.larus.im.d.e().d(r2, new v0(r7));
        r5 = r7.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r5 != r0) goto L13;
        return r0;
    }
}
