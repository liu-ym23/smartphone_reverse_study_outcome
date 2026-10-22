package com.larus.bmhome.chat.model.repo;

import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$prepareAudioTextNew$1", f = "ChatSender.kt", i = {1, 1, 2, 2}, l = {655, 658, 660}, m = "invokeSuspend", n = {"cvs", "strategy", "cvs", "strategy"}, s = {"L$2", "L$3", "L$1", "L$2"})
public final class ChatSender$prepareAudioTextNew$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Function1<Message, Unit> $prepareResult;
    final /* synthetic */ long $startTime;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$prepareAudioTextNew$1(ChatSender r1, String r2, long r3, ChatPageContext r5, Function1<? super Message, Unit> r6, Continuation<? super ChatSender$prepareAudioTextNew$1> r7) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$startTime = r3;
        this.$chatPageContext = r5;
        this.$prepareResult = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatSender$prepareAudioTextNew$1(this.this$0, this.$cvsId, this.$startTime, this.$chatPageContext, this.$prepareResult, r10);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ai8.b r2 = (ai8.b) this.L$2;
        wc9.e r3 = (wc9.e) this.L$1;
        Function1<Message, Unit> r4 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r12);
        ai8.b r5 = r2;
        Function1<Message, Unit> r6 = r4;
    L30:
        com.larus.bmhome.chat.model.strategy.g0.a.b((com.larus.bmhome.chat.model.strategy.g0) r12, r3.a, 0, r5, false, r3.v, r6, 2);
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ChatSendUtils r7 = (ChatSendUtils) this.L$5;
        String r8 = (String) this.L$4;
        ai8.b r9 = (ai8.b) this.L$3;
        wc9.e r10 = (wc9.e) this.L$2;
        r6 = (Function1) this.L$1;
        ChatSender r11 = (ChatSender) this.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        String r13 = r9.b;
        r7.getClass();
        ChatSendUtils.q(r8, (String) r12, r13);
    L26:
        r3 = r10;
        this.L$0 = r6;
        this.L$1 = r3;
        this.L$2 = r9;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 3;
        int r14 = ChatSender.j;
        r12 = r11.C(r3, this);
        if (r12 != r0) goto L29;
        return r0;
    L29:
        r5 = r9;
        goto L30
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        r10 = (wc9.e) r12;
        if (r10 == null) goto L32;
        r11 = this.this$0;
        long r15 = this.$startTime;
        ChatPageContext r16 = this.$chatPageContext;
        r6 = this.$prepareResult;
        int r17 = ChatSender.j;
        r9 = r11.z(r15, r16, r10);
        if (com.larus.platform.exp.s.b == false) goto L26;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.RECORD_AUDIO") != 0) goto L26;
        r7 = ChatSendUtils.a;
        String r18 = r10.a;
        this.L$0 = r11;
        this.L$1 = r6;
        this.L$2 = r10;
        this.L$3 = r9;
        this.L$4 = r18;
        this.L$5 = r7;
        this.label = 2;
        Object r19 = r11.B(r10, this);
        if (r19 != r0) goto L24;
        return r0;
    L24:
        r8 = r18;
        r12 = r19;
        goto L25
    L12:
        ResultKt.throwOnFailure(r12);
        this.this$0.a.d.d.i6("prepareAudioTextNew", false);
        ChatSender r110 = this.this$0;
        String r20 = this.$cvsId;
        this.label = 1;
        r12 = ChatSender.y(r110, r20, this);
        if (r12 != r0) goto L15;
        return r0;
    }
}
