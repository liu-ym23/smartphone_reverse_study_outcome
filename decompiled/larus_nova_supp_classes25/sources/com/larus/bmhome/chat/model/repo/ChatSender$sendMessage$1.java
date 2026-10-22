package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendMessage$1", f = "ChatSender.kt", i = {1}, l = {268, 270}, m = "invokeSuspend", n = {"cvs"}, s = {"L$3"})
final class ChatSender$sendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMCallback<Message> $callback;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ ic8.w $strategy;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$sendMessage$1(ic8.w r1, String r2, String r3, ChatSender r4, IIMCallback<Message> r5, String r6, Continuation<? super ChatSender$sendMessage$1> r7) {
        this.$strategy = r1;
        this.$scene = r2;
        this.$cvsId = r3;
        this.this$0 = r4;
        this.$callback = r5;
        this.$sendFuncChannel = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatSender$sendMessage$1(this.$strategy, this.$scene, this.$cvsId, this.this$0, this.$callback, this.$sendFuncChannel, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        wc9.e r3 = (wc9.e) this.L$3;
        String r4 = (String) this.L$2;
        IIMCallback<Message> r5 = (IIMCallback) this.L$1;
        ic8.w r6 = (ic8.w) this.L$0;
        ResultKt.throwOnFailure(r19);
        wc9.e r7 = r3;
        String r9 = r4;
        IIMCallback<Message> r8 = r5;
        ic8.w r10 = r6;
        Object r11 = r19;
    L24:
        com.larus.bmhome.chat.model.strategy.g0.a.d((com.larus.bmhome.chat.model.strategy.g0) r11, r7, r10, r8, false, r9, 8);
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
        Object r12 = r19;
    L16:
        wc9.e r13 = (wc9.e) r12;
        if (r13 == null) goto L28;
        ChatSender r14 = this.this$0;
        ic8.w r15 = this.$strategy;
        IIMCallback<Message> r16 = this.$callback;
        String r17 = this.$sendFuncChannel;
        if (r13.h() == true) goto L25;
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r17;
        this.L$3 = r13;
        this.label = 2;
        int r18 = ChatSender.j;
        r11 = r14.C(r13, this);
        if (r11 != r1) goto L23;
        return r1;
    L23:
        r9 = r17;
        r8 = r16;
        r10 = r15;
        r7 = r13;
        goto L24
    L25:
        if (r16 == null) goto L28;
        r16.onFailure(new IMError(-1, "cvs disabled", null, null, 12, null));
        goto L28
    L10:
        ResultKt.throwOnFailure(r19);
        String r20 = this.$strategy.b();
        if (r20 != null) goto L13;
        r20 = "";
    L13:
        String r21 = r20;
        ChatControlTrace.b.Ma(r21, this.$scene);
        com.larus.bmhome.chat.trace.appreciable.f.l(com.larus.bmhome.chat.trace.appreciable.f.a, r21, this.$cvsId, this.$scene, this.$strategy.contentType(), null, null, null, null, 240);
        this.this$0.a.d.d.i6("sendMessage", false);
        ChatSender r22 = this.this$0;
        String r23 = this.$cvsId;
        this.label = 1;
        r12 = ChatSender.y(r22, r23, this);
        if (r12 != r1) goto L16;
        return r1;
    }
}
