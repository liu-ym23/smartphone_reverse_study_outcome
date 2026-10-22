package com.larus.bmhome.chat.component.title;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import ic8.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$setupTitle$1$5$2", f = "ChatTitleComponent.kt", i = {}, l = {1837}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleComponent$setupTitle$1$5$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $conversation;
    Object L$0;
    int label;

    public ChatTitleComponent$setupTitle$1$5$2(e r1, Continuation<? super ChatTitleComponent$setupTitle$1$5$2> r2) {
        this.$conversation = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatTitleComponent$setupTitle$1$5$2(this.$conversation, r3);
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
        BotStatusCacheDelegate r2 = (BotStatusCacheDelegate) this.L$0;
        ResultKt.throwOnFailure(r4);
    L12:
        List r5 = (List) r4;
        if (r5 == null) goto L15;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r2.a(r6, true);
        return Unit.INSTANCE;
    L15:
        r6 = null;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        BotStatusCacheDelegate r7 = BotStatusCacheDelegate.b;
        e r3 = this.$conversation;
        this.L$0 = r7;
        this.label = 1;
        Object r8 = n.c(r3, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r7;
        r4 = r8;
        goto L12
    }
}
