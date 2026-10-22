package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$prepareMessages$1", f = "ChatSender.kt", i = {}, l = {1336, 1337}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$prepareMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Function1<List<Message>, Unit> $prepareResult;
    final /* synthetic */ List<ic8.w> $strategies;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChatSender this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSender$prepareMessages$1(ChatSender r1, String r2, List<? extends ic8.w> r3, Function1<? super List<Message>, Unit> r4, Continuation<? super ChatSender$prepareMessages$1> r5) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$strategies = r3;
        this.$prepareResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatSender$prepareMessages$1(this.this$0, this.$cvsId, this.$strategies, this.$prepareResult, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Function1<List<Message>, Unit> r2 = (Function1) this.L$2;
        List<ic8.w> r3 = (List) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        ((com.larus.bmhome.chat.model.strategy.g0) r8).i(r4, 0, r3, r2);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        wc9.e r9 = (wc9.e) r8;
        if (r9 == null) goto L21;
        ChatSender r5 = this.this$0;
        String r6 = this.$cvsId;
        List<ic8.w> r7 = this.$strategies;
        Function1<List<Message>, Unit> r10 = this.$prepareResult;
        this.L$0 = r6;
        this.L$1 = r7;
        this.L$2 = r10;
        this.label = 2;
        int r11 = ChatSender.j;
        r8 = r5.C(r9, this);
        if (r8 != r0) goto L18;
        return r0;
    L18:
        r4 = r6;
        r3 = r7;
        r2 = r10;
        goto L19
    L10:
        ResultKt.throwOnFailure(r8);
        this.this$0.a.d.d.i6("prepareMessages", false);
        ChatSender r12 = this.this$0;
        String r13 = this.$cvsId;
        this.label = 1;
        r8 = ChatSender.y(r12, r13, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
