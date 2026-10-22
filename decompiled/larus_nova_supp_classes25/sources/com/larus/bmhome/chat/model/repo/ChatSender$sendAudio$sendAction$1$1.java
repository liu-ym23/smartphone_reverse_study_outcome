package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMError;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendAudio$sendAction$1$1", f = "ChatSender.kt", i = {1}, l = {954, 955}, m = "invokeSuspend", n = {"cvs"}, s = {"L$3"})
final class ChatSender$sendAudio$sendAction$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Message, IIMError, Unit> $callback;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ long $duration;
    final /* synthetic */ String $text;
    final /* synthetic */ String $vid;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$sendAudio$sendAction$1$1(ChatSender r1, String r2, String r3, String r4, long r5, Function2<? super Message, ? super IIMError, Unit> r7, Continuation<? super ChatSender$sendAudio$sendAction$1$1> r8) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$text = r3;
        this.$vid = r4;
        this.$duration = r5;
        this.$callback = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatSender$sendAudio$sendAction$1$1(this.this$0, this.$cvsId, this.$text, this.$vid, this.$duration, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        long r2 = this.J$0;
        wc9.e r3 = (wc9.e) this.L$3;
        Function2<? super Message, ? super IIMError, Unit> r4 = (Function2) this.L$2;
        String r5 = (String) this.L$1;
        String r6 = (String) this.L$0;
        ResultKt.throwOnFailure(r12);
        Function2<? super Message, ? super IIMError, Unit> r7 = r4;
        wc9.e r8 = r3;
        String r9 = r5;
        long r10 = r2;
        String r11 = r6;
    L19:
        ((com.larus.bmhome.chat.model.strategy.g0) r12).c(r11, r9, r10, r8, r7);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L13:
        wc9.e r13 = (wc9.e) r12;
        if (r13 == null) goto L21;
        ChatSender r14 = this.this$0;
        String r15 = this.$text;
        String r16 = this.$vid;
        long r17 = this.$duration;
        Function2<? super Message, ? super IIMError, Unit> r18 = this.$callback;
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r18;
        this.L$3 = r13;
        this.J$0 = r17;
        this.label = 2;
        int r19 = ChatSender.j;
        Object r20 = r14.C(r13, this);
        if (r20 != r0) goto L18;
        return r0;
    L18:
        r9 = r16;
        r8 = r13;
        r12 = r20;
        r11 = r15;
        r7 = r18;
        r10 = r17;
        goto L19
    L10:
        ResultKt.throwOnFailure(r12);
        this.this$0.a.d.d.i6("sendAudio", false);
        ChatSender r110 = this.this$0;
        String r21 = this.$cvsId;
        this.label = 1;
        r12 = ChatSender.y(r110, r21, this);
        if (r12 != r0) goto L13;
        return r0;
    }
}
