package com.larus.avlink.plugins;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraFirstPartyAuthPlugin$tryRequestLocationAuthMessage$1", f = "DoraFirstPartyAuthPlugin.kt", i = {}, l = {659}, m = "invokeSuspend", n = {}, s = {})
final class DoraFirstPartyAuthPlugin$tryRequestLocationAuthMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $questionId;
    int label;
    final /* synthetic */ DoraFirstPartyAuthPlugin this$0;

    public DoraFirstPartyAuthPlugin$tryRequestLocationAuthMessage$1(String r1, DoraFirstPartyAuthPlugin r2, Continuation<? super DoraFirstPartyAuthPlugin$tryRequestLocationAuthMessage$1> r3) {
        this.$questionId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraFirstPartyAuthPlugin$tryRequestLocationAuthMessage$1(this.$questionId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Message r8 = (Message) r7;
        if (r8 == null) goto L14;
        com.larus.platform.service.l1 r2 = com.larus.platform.service.l1.a;
        String r3 = this.$questionId;
        String r4 = r8.getLocalMessageId();
        String r9 = r8.getConversationId();
        DoraFirstPartyAuthPlugin r5 = this.this$0;
        int r6 = DoraFirstPartyAuthPlugin.q;
        r2.b(new hq9.y2(r3, r4, r9, r5.p3()));
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        IChatRepoService r10 = zh8.a.a;
        IChatRepoService r11 = zh8.a.a;
        String r12 = this.$questionId;
        this.label = 1;
        r7 = r11.E1(r12, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
