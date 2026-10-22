package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$handleColdLaunchMessageEventFlow$5", f = "ChatListComponent.kt", i = {}, l = {4488}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$handleColdLaunchMessageEventFlow$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.social.page.datasource.event.c<b> $toppingList;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$handleColdLaunchMessageEventFlow$5(ChatListComponent r1, com.larus.bmhome.social.page.datasource.event.c<b> r2, Continuation<? super ChatListComponent$handleColdLaunchMessageEventFlow$5> r3) {
        this.this$0 = r1;
        this.$toppingList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponent$handleColdLaunchMessageEventFlow$5(this.this$0, this.$toppingList, r4);
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
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        MessageAdapter r5 = this.this$0.O;
        if (r5 == null) goto L14;
        com.larus.bmhome.social.page.datasource.event.c<b> r2 = this.$toppingList;
        this.label = 1;
        if (MessageAdapter.L2(r5, r2, this) != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
