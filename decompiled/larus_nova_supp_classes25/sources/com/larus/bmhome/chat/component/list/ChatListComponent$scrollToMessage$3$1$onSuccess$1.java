package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$scrollToMessage$3$1$onSuccess$1", f = "ChatListComponent.kt", i = {}, l = {2962}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponent$scrollToMessage$3$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $alignTop;
    final /* synthetic */ String $targetMsgId;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$scrollToMessage$3$1$onSuccess$1(ChatListComponent r1, String r2, boolean r3, Continuation<? super ChatListComponent$scrollToMessage$3$1$onSuccess$1> r4) {
        this.this$0 = r1;
        this.$targetMsgId = r2;
        this.$alignTop = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatListComponent$scrollToMessage$3$1$onSuccess$1(this.this$0, this.$targetMsgId, this.$alignTop, r5);
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
    L11:
        MessageAdapter r5 = this.this$0.O;
        if (r5 == null) goto L27;
        List<b> r6 = r5.z2();
        if (r6 == null) goto L27;
        String r2 = this.$targetMsgId;
        Iterator<b> r7 = r6.iterator();
        int r3 = 0;
    L17:
        if (r7.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(r7.next().getMessage().getMessageId(), r2) == true) goto L23;
        r3 = r3 + 1;
    L23:
        ChatListComponent r8 = this.this$0;
        boolean r9 = this.$alignTop;
        if (r3 < 0) goto L27;
        r8.E7(r3, r9);
        goto L27
    L22:
        r3 = -1;
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(50, this) != r0) goto L11;
        return r0;
    }
}
